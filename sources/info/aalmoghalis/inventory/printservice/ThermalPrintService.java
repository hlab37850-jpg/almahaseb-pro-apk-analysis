package info.aalmoghalis.inventory.printservice;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.print.PrintJobInfo;
import android.print.PrinterInfo;
import android.printservice.PrintJob;
import android.printservice.PrintService;
import android.printservice.PrinterDiscoverySession;
import android.util.Log;
import androidx.annotation.RequiresApi;
import defpackage.C4206wU;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 19)
public class ThermalPrintService extends PrintService {
    public PrinterInfo a;
    public Handler b;

    public final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 3) {
                return;
            }
            ThermalPrintService.this.b((PrintJob) message.obj);
        }
    }

    public final void b(PrintJob printJob) {
        if (printJob.isQueued()) {
            printJob.start();
        }
        PrintJobInfo info2 = printJob.getInfo();
        File file = new File(getFilesDir(), info2.getLabel() + ".pdf");
        try {
            FileInputStream fileInputStream = new FileInputStream(printJob.getDocument().getData().getFileDescriptor());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Intent intent = new Intent(this, (Class<?>) MainActivity.class);
                    intent.setFlags(268435456);
                    intent.putExtra("FILE", file.getPath());
                    startActivity(intent);
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException unused) {
        }
    }

    @Override // android.printservice.PrintService
    public void onConnected() {
        Log.i("ThermalPrintService", "#onConnected()");
        this.b = new a(getMainLooper());
    }

    @Override // android.app.Service
    public void onCreate() {
        this.a = new PrinterInfo.Builder(generatePrinterId("Printer 1"), "MiNiPrinter", 1).build();
    }

    @Override // android.printservice.PrintService
    public PrinterDiscoverySession onCreatePrinterDiscoverySession() {
        return new C4206wU(this.a);
    }

    @Override // android.printservice.PrintService
    public void onPrintJobQueued(PrintJob printJob) {
        this.b.sendMessageDelayed(this.b.obtainMessage(3, printJob), 0L);
    }

    @Override // android.printservice.PrintService
    public void onRequestCancelPrintJob(PrintJob printJob) {
        Log.i("ThermalPrintService", "#onRequestCancelPrintJob() printJobId: " + printJob.getId());
        if (!this.b.hasMessages(3)) {
            if (printJob.isQueued() || printJob.isStarted()) {
                printJob.cancel();
                return;
            }
            return;
        }
        this.b.removeMessages(3);
        if (printJob.isQueued() || printJob.isStarted()) {
            printJob.cancel();
        }
    }
}
