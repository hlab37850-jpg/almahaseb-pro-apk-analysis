package info.aalmoghalis.inventory.printBT;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.MotionEventCompat;
import com.google.common.base.Ascii;
import com.zebra.sdk.comm.UsbConnection;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC3521o10;
import defpackage.WH;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.SettingsActivity;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.record.formula.RefErrorPtg;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity4 extends BaseActivity {
    public static Boolean I = Boolean.TRUE;
    public static final byte[] J = {10};
    public static final byte[] K = {Ascii.ESC, RefErrorPtg.sid, 33};
    public static final byte[] L = {Ascii.ESC, 51, Ascii.CAN};
    public static final byte[] M = {Ascii.ESC, 51, 30};
    public UsbManager c;
    public UsbDevice d;
    public UsbDeviceConnection e;
    public UsbInterface f;
    public UsbEndpoint g;
    public PendingIntent h;
    public HashMap i;
    public Iterator j;
    public SQLiteDatabase k;
    public Z00 l;
    public TextView w;
    public String n = null;
    public String p = "";
    public String q = "";
    public String t = "";
    public String u = null;
    public String v = "0";
    public String x = "";
    public ImageView y = null;
    public int z = 38;
    public int A = 20;
    public int B = 1;
    public int C = 1;
    public int D = 5;
    public String E = "";
    public final BroadcastReceiver F = new d();
    public Handler G = new f();
    public StringBuffer H = new StringBuffer();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity4.this.N();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity4 mainActivity4 = MainActivity4.this;
            mainActivity4.I(mainActivity4.e, MainActivity4.this.f);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity4.this, (Class<?>) SettingsActivity.class);
            intent.putExtra("show_fragment", SettingsActivity.BarcodePreferenceFragment.class.getName());
            intent.putExtra(":android:no_headers", true);
            MainActivity4.this.startActivity(intent);
        }
    }

    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.android.example.USB_PERMISSION".equals(intent.getAction())) {
                synchronized (this) {
                    try {
                        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                        if (!intent.getBooleanExtra("permission", false)) {
                            Toast.makeText(context, "PERMISSION DENIED FOR THIS DEVICE", 0).show();
                        } else if (usbDevice != null) {
                            MainActivity4.this.f = usbDevice.getInterface(0);
                            MainActivity4 mainActivity4 = MainActivity4.this;
                            mainActivity4.g = mainActivity4.f.getEndpoint(1);
                            MainActivity4 mainActivity5 = MainActivity4.this;
                            mainActivity5.e = mainActivity5.c.openDevice(usbDevice);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ UsbDeviceConnection a;
        public final /* synthetic */ ByteArrayOutputStream b;

        public e(UsbDeviceConnection usbDeviceConnection, ByteArrayOutputStream byteArrayOutputStream) {
            this.a = usbDeviceConnection;
            this.b = byteArrayOutputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity4.this.H.append("baos\n");
            MainActivity4.this.L();
            this.a.bulkTransfer(MainActivity4.this.g, this.b.toByteArray(), this.b.toByteArray().length, 0);
        }
    }

    public class f extends Handler {
        public f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (!message.obj.toString().equals("1")) {
                if (message.obj.toString().equals("2")) {
                    MainActivity4 mainActivity4 = MainActivity4.this;
                    mainActivity4.w.setText(mainActivity4.H.toString());
                    return;
                }
                return;
            }
            try {
                MainActivity4 mainActivity5 = MainActivity4.this;
                mainActivity5.l.id(mainActivity5.y, Z00.L + "/print2.jpg");
            } catch (Exception e) {
                Log.d("set_img_err=", e.getMessage() + "");
            }
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ UsbDeviceConnection a;
        public final /* synthetic */ UsbInterface b;

        public g(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
            this.a = usbDeviceConnection;
            this.b = usbInterface;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < Z00.j0.size(); i++) {
                MainActivity4.this.n = ((String[]) Z00.j0.get(i))[0];
                MainActivity4.this.p = ((String[]) Z00.j0.get(i))[1];
                MainActivity4.this.F();
                new WH();
                MainActivity4 mainActivity4 = MainActivity4.this;
                String str = mainActivity4.q;
                mainActivity4.x = str;
                mainActivity4.l.Zd(str, mainActivity4.w, "print2", mainActivity4.u);
                MainActivity4 mainActivity5 = MainActivity4.this;
                mainActivity5.l.Zd(mainActivity5.x, mainActivity5.w, "print", mainActivity5.u);
                try {
                    MainActivity4.this.H(this.a, this.b);
                } catch (Exception e) {
                    Log.d("print_err2=", e.getMessage() + "");
                }
                try {
                    Message message = new Message();
                    message.obj = "1";
                    MainActivity4.this.G.sendMessage(message);
                } catch (Exception unused) {
                }
            }
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ UsbDeviceConnection a;
        public final /* synthetic */ byte[] b;

        public h(UsbDeviceConnection usbDeviceConnection, byte[] bArr) {
            this.a = usbDeviceConnection;
            this.b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity4.this.H.append("printformat\n");
            UsbDeviceConnection usbDeviceConnection = this.a;
            UsbEndpoint usbEndpoint = MainActivity4.this.g;
            byte[] bArr = this.b;
            usbDeviceConnection.bulkTransfer(usbEndpoint, bArr, bArr.length, 0);
            MainActivity4.this.H.append("PrinterCommands\n");
            UsbDeviceConnection usbDeviceConnection2 = this.a;
            UsbEndpoint usbEndpoint2 = MainActivity4.this.g;
            byte[] bArr2 = WH.a;
            usbDeviceConnection2.bulkTransfer(usbEndpoint2, bArr2, bArr2.length, 0);
        }
    }

    private int[][] E(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, height, width);
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                iArr[i][i2] = bitmap.getPixel(i2, i);
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
        Log.d("Bills_cnt=", Z00.j0.size() + "");
        if (Z00.j0.size() > 1) {
            Toast.makeText(this, getString(R.string.bills_count) + " : " + Z00.j0.size(), 1).show();
        }
        new Thread(new g(usbDeviceConnection, usbInterface)).start();
    }

    private void J(String str, UsbDeviceConnection usbDeviceConnection, boolean z, boolean z2) throws IOException {
        if (!new File(Z00.L, str).exists()) {
            Toast.makeText(this, "file doesn't exists", 0).show();
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        options.inPreferredConfig = config;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(Z00.L + "/" + str, options);
        if (z) {
            int width = bitmapDecodeFile.getWidth();
            int height = bitmapDecodeFile.getHeight();
            int i = width % 8;
            if (i != 0 || height % 24 != 0) {
                int i2 = ((width / 8) * 8) - (i == 0 ? 0 : 8);
                int i3 = ((height / 24) * 24) + (height % 24 == 0 ? 0 : 24);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
                float f2 = i2 / width;
                float f3 = i3 / height;
                Matrix matrix = new Matrix();
                matrix.setScale(f2, f3, 0.0f, 0.0f);
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0.0f);
                Paint paint = new Paint();
                paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.setMatrix(matrix);
                canvas.drawBitmap(bitmapDecodeFile, 0.0f, 0.0f, paint);
                Log.d("image=w", bitmapCreateBitmap.getWidth() + ":" + bitmapCreateBitmap.getHeight());
                bitmapDecodeFile = bitmapCreateBitmap;
            }
        }
        int[][] iArrE = E(bitmapDecodeFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(L);
        for (int i4 = 0; i4 < iArrE.length; i4 += 24) {
            byteArrayOutputStream.write(K);
            int[] iArr = iArrE[i4];
            byteArrayOutputStream.write(new byte[]{(byte) (iArr.length & 255), (byte) ((iArr.length & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)});
            for (int i5 = 0; i5 < iArrE[i4].length; i5++) {
                byteArrayOutputStream.write(M(i4, i5, iArrE));
            }
            byteArrayOutputStream.write(WH.b);
        }
        if (z2) {
            List list = Z00.j0;
            if (((String[]) list.get(list.size() - 1)).equals(this.n)) {
                byteArrayOutputStream.write("\n\n\n\n".getBytes());
                byteArrayOutputStream.write(WH.k);
                byteArrayOutputStream.write(M);
            }
            String strIa = this.l.ia("prefThermalType", "1");
            if (strIa.equals("1")) {
                new Thread(new e(usbDeviceConnection, byteArrayOutputStream)).run();
            } else if (strIa.equals("3")) {
                O(byteArrayOutputStream, usbDeviceConnection);
            }
        }
    }

    private byte[] M(int i, int i2, int[][] iArr) {
        byte[] bArr = new byte[3];
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        int i3 = i;
        for (int i4 = 0; i3 < i + 24 && i4 < 3; i4++) {
            byte b2 = 0;
            for (int i5 = 0; i5 < 8; i5++) {
                int i6 = i3 + i5;
                if (i6 < iArr.length) {
                    b2 = (byte) (b2 | ((byte) ((P(iArr[i6][i2]) ? 1 : 0) << (7 - i5))));
                }
            }
            bArr[i4] = b2;
            i3 += 8;
        }
        return bArr;
    }

    private static boolean P(int i) {
        if (((i >> 24) & 255) != 255) {
            return false;
        }
        return ((int) (((((double) ((i >> 16) & 255)) * 0.299d) + (((double) ((i >> 8) & 255)) * 0.587d)) + (((double) (i & 255)) * 0.114d))) < 127;
    }

    private String Q(int i) {
        if (i == 0) {
            return "USB class indicating that the class is determined on a per-interface basis";
        }
        if (i == 1) {
            return "USB class for audio devices";
        }
        if (i == 2) {
            return "USB class for communication devices";
        }
        if (i == 3) {
            return "USB class for human interface devices (for example, mice and keyboards)";
        }
        if (i == 13) {
            return "USB class for content security devices";
        }
        if (i == 14) {
            return "USB class for video devices";
        }
        if (i == 224) {
            return "USB class for wireless controller devices";
        }
        if (i == 239) {
            return "USB class for wireless miscellaneous devices";
        }
        if (i == 254) {
            return "Application specific USB class";
        }
        if (i == 255) {
            return "Vendor specific USB class";
        }
        switch (i) {
            case 5:
                return "USB class for physical devices";
            case 6:
                return "USB class for still image devices (digital cameras)";
            case 7:
                return "USB class for printers";
            case 8:
                return "USB class for mass storage devices";
            case 9:
                return "USB class for USB hubs";
            case 10:
                return "USB class for CDC devices (communications device class)";
            case 11:
                return "USB class for content smart card devices";
            default:
                return "Unknown USB class!";
        }
    }

    public void F() {
        if (getIntent().getStringExtra("item_barcode") != null) {
            this.E = getIntent().getStringExtra("item_barcode");
        }
        if (getIntent().getStringExtra("img_w") != null) {
            this.z = Integer.parseInt(getIntent().getStringExtra("img_w"));
            this.A = Integer.parseInt(getIntent().getStringExtra("img_h"));
            this.B = Integer.parseInt(getIntent().getStringExtra("img_cnt"));
        }
        if (getIntent().getStringExtra("img_m2") != null) {
            this.D = Integer.parseInt(getIntent().getStringExtra("img_m2"));
        }
        this.q = this.l.h0(this.n, this.E);
        Log.d("BILL=", this.E + ":" + this.q + "");
    }

    public void G(UsbDeviceConnection usbDeviceConnection, String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            if (BitmapFactory.decodeFile(Z00.L + "/" + str, options) != null) {
                usbDeviceConnection.close();
                UsbConnection usbConnection = new UsbConnection(this.c, this.d);
                usbConnection.open();
                ZebraPrinter zebraPrinterFactory = ZebraPrinterFactory.getInstance(usbConnection);
                zebraPrinterFactory.sendCommand("! UTILITIES\r\nIN-MILLIMETERS\r\nCENTER\r\nSETFF 10 2\r\nPRINT\r\n");
                zebraPrinterFactory.printImage(Z00.L + "/print.jpg", 0, 0, -1, -1, false);
                usbConnection.close();
            } else {
                Log.e("Print Photo error", "the file isn't exists");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("photo_error", "" + e2.getMessage());
        }
    }

    public void H(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
        this.H.append("");
        this.H.append("Start\n");
        if (this.n == null) {
            Log.d("print=", "TR ID IS NULL");
            this.H.append("TR ID IS NULL\n");
            L();
            return;
        }
        if (usbInterface == null) {
            Log.d("print=", "INTERFACE IS NULL");
            this.H.append("INTERFACE IS NULL\n");
            L();
            return;
        }
        if (usbDeviceConnection == null) {
            Log.d("print=", "CONNECTION IS NULL");
            this.H.append("CONNECTION IS NULL\n");
            L();
            return;
        }
        Boolean bool = I;
        if (bool == null) {
            Log.d("print=", "FORCE CLAIM IS NULL");
            this.H.append("FORCE CLAIM IS NULL\n");
            L();
            return;
        }
        usbDeviceConnection.claimInterface(usbInterface, bool.booleanValue());
        this.H.append("Start Send Data\n");
        if (this.q.equals("")) {
            Log.d("print=", "BILL IS NULL");
            this.H.append("BILL IS NULL\n");
            L();
            return;
        }
        try {
            Log.d("print=", "BILL START PRINT");
            this.H.append("BILL START PRINT\n");
            String strIa = this.l.ia("prefThermalType", "1");
            if (strIa.equals("1")) {
                new Thread(new h(usbDeviceConnection, new byte[]{Ascii.ESC, 33, 0})).run();
                J("print.jpg", this.e, true, true);
            } else if (strIa.equals("2")) {
                G(this.e, "print.jpg");
            } else if (strIa.equals("3")) {
                usbDeviceConnection.bulkTransfer(this.g, new byte[]{Ascii.ESC, 33, 0}, 3, 0);
                UsbEndpoint usbEndpoint = this.g;
                byte[] bArr = WH.a;
                usbDeviceConnection.bulkTransfer(usbEndpoint, bArr, bArr.length, 0);
                J("print.jpg", this.e, true, true);
            } else if (strIa.equals("10")) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Log.d("label=", "START_LABELE");
                    byteArrayOutputStream.write(AbstractC3521o10.a());
                    byteArrayOutputStream.write(AbstractC3521o10.f(this.z, this.A + this.D, 1, 8, 0, 0, 0, "864"));
                    Bitmap bitmapD = AbstractC3521o10.d("print.jpg");
                    if (this.D / 2 > this.A / 4) {
                        this.D = 0;
                    }
                    int i = this.B;
                    int i2 = this.C;
                    int i3 = i / i2;
                    if (i3 > 0) {
                        i2 = i3;
                    }
                    byteArrayOutputStream.write("REFERENCE 0,0\r\n".getBytes());
                    byteArrayOutputStream.write("BACKFEED 0\r\n".getBytes());
                    for (int i4 = 0; i4 < i2; i4++) {
                        byteArrayOutputStream.write(AbstractC3521o10.c());
                        byteArrayOutputStream.write(AbstractC3521o10.b(0, 0, (int) Math.ceil(bitmapD.getWidth() / 8), bitmapD.getHeight(), 0));
                        K("print.jpg", byteArrayOutputStream, false, true);
                        byteArrayOutputStream.write(AbstractC3521o10.e(1, 1));
                    }
                    Log.d("label=", "End_LABELE");
                    O(byteArrayOutputStream, usbDeviceConnection);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            L();
        } catch (Exception e3) {
            Log.d("print_err=", e3.getMessage() + "");
            Toast.makeText(this, "err=" + e3.getMessage(), 1).show();
            e3.printStackTrace();
        }
    }

    public final void K(String str, OutputStream outputStream, boolean z, boolean z2) throws IOException {
        int i;
        File file = new File(Z00.L, str);
        String strIa = this.l.ia("prefThermalType", "1");
        if (!file.exists()) {
            Toast.makeText(this, "file doesn't exists", 0).show();
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        options.inPreferredConfig = config;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(Z00.L + "/" + str, options);
        if (z) {
            int width = bitmapDecodeFile.getWidth();
            int height = bitmapDecodeFile.getHeight();
            int i2 = width % 8;
            if (i2 != 0 || height % 24 != 0) {
                int i3 = ((width / 8) * 8) - (i2 == 0 ? 0 : 8);
                int i4 = ((height / 24) * 24) + (height % 24 == 0 ? 0 : 24);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, config);
                float f2 = i3 / width;
                float f3 = i4 / height;
                Matrix matrix = new Matrix();
                matrix.setScale(f2, f3, 0.0f, 0.0f);
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0.0f);
                Paint paint = new Paint();
                paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.setMatrix(matrix);
                canvas.drawBitmap(bitmapDecodeFile, 0.0f, 0.0f, paint);
                Log.d("image=w", bitmapCreateBitmap.getWidth() + ":" + bitmapCreateBitmap.getHeight());
                bitmapDecodeFile = bitmapCreateBitmap;
            }
        }
        E(bitmapDecodeFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCeil = (int) Math.ceil(bitmapDecodeFile.getWidth() / 8);
        for (int i5 = 0; i5 < bitmapDecodeFile.getHeight(); i5++) {
            int i6 = 0;
            while (i6 < iCeil) {
                int i7 = i6 * 8;
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    i = i6 + 1;
                    if (i7 < i * 8) {
                        i8 = (byte) (i8 | ((byte) ((!P(bitmapDecodeFile.getPixel(i7, i5)) ? 1 : 0) << (7 - i9))));
                        i9++;
                        i7++;
                    }
                }
                byteArrayOutputStream.write(i8);
                i6 = i;
            }
        }
        byteArrayOutputStream.write(StringUtilities.CRLF.getBytes());
        if (z2) {
            if (strIa.equals("1") || strIa.equals("4") || strIa.equals("10")) {
                outputStream.write(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.toByteArray().length);
            }
        }
    }

    public void L() {
        Message message = new Message();
        message.obj = "2";
        this.G.sendMessage(message);
    }

    public void N() {
        UsbManager usbManager = (UsbManager) getSystemService("usb");
        this.c = usbManager;
        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        this.i = deviceList;
        if (deviceList.size() <= 0) {
            Toast.makeText(this, "Please attach printer via USB", 0).show();
            return;
        }
        this.j = this.i.values().iterator();
        Toast.makeText(this, "Device List Size: " + String.valueOf(this.i.size()), 0).show();
        String str = "";
        while (this.j.hasNext()) {
            UsbDevice usbDevice = (UsbDevice) this.j.next();
            str = str + "\nDeviceID: " + usbDevice.getDeviceId() + "\nDeviceName: " + usbDevice.getDeviceName() + "\nProtocol: " + usbDevice.getDeviceProtocol() + "\nDeviceClass: " + usbDevice.getDeviceClass() + " - " + Q(usbDevice.getDeviceClass()) + "\nDeviceSubClass: " + usbDevice.getDeviceSubclass() + "\nVendorID: " + usbDevice.getVendorId() + "\nProductID: " + usbDevice.getDeviceProtocol() + StringUtilities.LF;
            Toast.makeText(this, "INTERFACE COUNT: " + String.valueOf(usbDevice.getInterfaceCount()) + ":" + usbDevice.getManufacturerName() + ":", 0).show();
            this.d = usbDevice;
            Toast.makeText(this, "Device is attached", 1).show();
        }
        this.h = PendingIntent.getBroadcast(this, 0, new Intent("com.android.example.USB_PERMISSION"), 134217728);
        registerReceiver(this.F, new IntentFilter("com.android.example.USB_PERMISSION"));
        this.c.requestPermission(this.d, this.h);
    }

    public void O(ByteArrayOutputStream byteArrayOutputStream, UsbDeviceConnection usbDeviceConnection) {
        try {
            int length = byteArrayOutputStream.toByteArray().length;
            int i = 0;
            while (i < length) {
                int iMin = Math.min(length - i, 200);
                this.H.append("baos_parts\n");
                L();
                usbDeviceConnection.bulkTransfer(this.g, byteArrayOutputStream.toByteArray(), i, iMin, 0);
                usbDeviceConnection.close();
                i += iMin;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main_print);
        this.l = new Z00(this.k, this);
        TextView textView = (TextView) findViewById(R.id.bill_tv);
        this.w = textView;
        textView.setDrawingCacheEnabled(true);
        this.y = (ImageView) findViewById(R.id.btn_attach);
        if (getIntent().getStringExtra("cash_id") != null) {
            this.u = getIntent().getStringExtra("cash_id");
        }
        if (getIntent().getStringExtra("TR_TYPE") != null) {
            this.v = getIntent().getStringExtra("TR_TYPE");
        }
        if (Z00.j0.size() > 0) {
            this.n = ((String[]) Z00.j0.get(0))[0];
            this.p = ((String[]) Z00.j0.get(0))[1];
            SettingsActivity.ThermalPreferenceFragment.i = false;
            F();
            new WH();
            new info.aalmoghalis.inventory.printBT.a(Z00.G0, info.aalmoghalis.inventory.printBT.a.EnumC0321a.RIGHT);
            String str = this.q;
            this.x = str;
            this.w.setText(str);
            try {
                this.l.Zd(this.x, this.w, "print2", this.u);
                this.l.id(this.y, Z00.L + "/print2.jpg");
            } catch (Exception e2) {
                Log.d("set_img_err=", e2.getMessage() + "");
            }
        }
        Button button = (Button) findViewById(R.id.mPrint);
        try {
            N();
        } catch (Exception e3) {
            e3.printStackTrace();
            Log.d("print_err1=", e3.getMessage() + "");
        }
        ((Button) findViewById(R.id.Scan)).setOnClickListener(new a());
        button.setOnClickListener(new b());
        ((Button) findViewById(R.id.dis)).setOnClickListener(new c());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (SettingsActivity.BarcodePreferenceFragment.i) {
            SettingsActivity.BarcodePreferenceFragment.i = false;
            F();
            new WH();
            new info.aalmoghalis.inventory.printBT.a(Z00.G0, info.aalmoghalis.inventory.printBT.a.EnumC0321a.RIGHT);
            String str = this.q;
            this.x = str;
            this.w.setText(str);
            try {
                this.l.Zd(this.x, this.w, "print2", this.u);
                this.l.id(this.y, Z00.L + "/print2.jpg");
            } catch (Exception unused) {
            }
        }
    }
}
