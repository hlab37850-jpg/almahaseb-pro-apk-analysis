package defpackage;

import android.print.PrintAttributes;
import android.print.PrinterCapabilitiesInfo;
import android.print.PrinterId;
import android.print.PrinterInfo;
import android.printservice.PrinterDiscoverySession;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: wU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4206wU extends PrinterDiscoverySession {
    public PrinterInfo a;

    public C4206wU(PrinterInfo printerInfo) {
        this.a = new PrinterInfo.Builder(printerInfo).setCapabilities(new PrinterCapabilitiesInfo.Builder(printerInfo.getId()).addMediaSize(PrintAttributes.MediaSize.ISO_A5, true).addResolution(new PrintAttributes.Resolution("1234", "Default", 200, 200), true).setColorModes(1, 1).build()).build();
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onStartPrinterDiscovery(List list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.a);
        addPrinters(arrayList);
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onDestroy() {
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onStartPrinterStateTracking(PrinterId printerId) {
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onStopPrinterDiscovery() {
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onStopPrinterStateTracking(PrinterId printerId) {
    }

    @Override // android.printservice.PrinterDiscoverySession
    public void onValidatePrinters(List list) {
    }
}
