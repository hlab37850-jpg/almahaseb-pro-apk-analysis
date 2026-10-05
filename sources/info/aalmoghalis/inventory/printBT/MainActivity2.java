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
import com.itextpdf.tool.xml.css.CSS;
import com.zebra.sdk.comm.UsbConnection;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.DW;
import defpackage.WH;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.SettingsActivity;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.record.formula.RefErrorPtg;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity2 extends BaseActivity {
    public static Boolean I = Boolean.TRUE;
    public static final byte[] J = {10};
    public static final byte[] K = {Ascii.ESC, RefErrorPtg.sid, 33};
    public static final byte[] L = {Ascii.ESC, 51, Ascii.CAN};
    public static final byte[] M = {Ascii.ESC, 51, 1};
    public static final byte[] N = {Ascii.ESC, 51, 30};
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
    public TextView x;
    public String n = null;
    public String p = "";
    public String q = "";
    public String t = "";
    public String u = "";
    public String v = null;
    public String w = "0";
    public String y = "";
    public ImageView z = null;
    public String A = "";
    public String B = CSS.Value.PERCENTAGE;
    public String C = CSS.Value.PERCENTAGE;
    public String D = "";
    public boolean E = false;
    public final BroadcastReceiver F = new d();
    public Handler G = new f();
    public StringBuffer H = new StringBuffer();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity2 mainActivity2 = MainActivity2.this;
            mainActivity2.E = false;
            mainActivity2.M();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity2 mainActivity2 = MainActivity2.this;
            mainActivity2.I(mainActivity2.e, MainActivity2.this.f);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity2.this, (Class<?>) SettingsActivity.class);
            intent.putExtra("show_fragment", SettingsActivity.ThermalPreferenceFragment.class.getName());
            intent.putExtra(":android:no_headers", true);
            MainActivity2.this.startActivity(intent);
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
                            MainActivity2.this.f = usbDevice.getInterface(0);
                            MainActivity2 mainActivity2 = MainActivity2.this;
                            mainActivity2.g = mainActivity2.f.getEndpoint(1);
                            MainActivity2 mainActivity3 = MainActivity2.this;
                            mainActivity3.e = mainActivity3.c.openDevice(usbDevice);
                            MainActivity2 mainActivity4 = MainActivity2.this;
                            if (mainActivity4.E) {
                                mainActivity4.E = false;
                            }
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
            MainActivity2.this.H.append("baos\n");
            MainActivity2.this.K();
            this.a.bulkTransfer(MainActivity2.this.g, this.b.toByteArray(), this.b.toByteArray().length, 0);
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
                    MainActivity2 mainActivity2 = MainActivity2.this;
                    mainActivity2.x.setText(mainActivity2.H.toString());
                    return;
                }
                return;
            }
            try {
                MainActivity2 mainActivity3 = MainActivity2.this;
                mainActivity3.l.id(mainActivity3.z, Z00.L + "/print2.jpg");
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
            if (!MainActivity2.this.A.equals("")) {
                MainActivity2.this.F();
                new WH();
                MainActivity2 mainActivity2 = MainActivity2.this;
                String str = mainActivity2.t;
                mainActivity2.y = str;
                mainActivity2.l.Zd(str, mainActivity2.x, "print2", mainActivity2.u);
                MainActivity2 mainActivity3 = MainActivity2.this;
                mainActivity3.l.Zd(mainActivity3.y, mainActivity3.x, "print", mainActivity3.u);
                try {
                    MainActivity2.this.H(this.a, this.b);
                } catch (Exception e) {
                    Log.d("print_err2=", e.getMessage() + "");
                }
                try {
                    Message message = new Message();
                    message.obj = "1";
                    MainActivity2.this.G.sendMessage(message);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            for (int i = 0; i < Z00.j0.size(); i++) {
                MainActivity2.this.n = ((String[]) Z00.j0.get(i))[0];
                MainActivity2.this.p = ((String[]) Z00.j0.get(i))[1];
                MainActivity2.this.q = ((String[]) Z00.j0.get(i)).length > 2 ? ((String[]) Z00.j0.get(i))[2] : "0";
                MainActivity2.this.F();
                new WH();
                MainActivity2 mainActivity4 = MainActivity2.this;
                String str2 = mainActivity4.t;
                mainActivity4.y = str2;
                mainActivity4.l.Zd(str2, mainActivity4.x, "print2", mainActivity4.u);
                MainActivity2 mainActivity5 = MainActivity2.this;
                mainActivity5.l.Zd(mainActivity5.y, mainActivity5.x, "print", mainActivity5.u);
                try {
                    MainActivity2.this.H(this.a, this.b);
                } catch (Exception e2) {
                    Log.d("print_err2=", e2.getMessage() + "");
                }
                try {
                    Message message2 = new Message();
                    message2.obj = "1";
                    MainActivity2.this.G.sendMessage(message2);
                } catch (Exception unused2) {
                }
            }
        }
    }

    public static boolean O(int i) {
        if (((i >> 24) & 255) != 255) {
            return false;
        }
        return ((int) (((((double) ((i >> 16) & 255)) * 0.299d) + (((double) ((i >> 8) & 255)) * 0.587d)) + (((double) (i & 255)) * 0.114d))) < 127;
    }

    public final int[][] E(Bitmap bitmap) {
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

    public void F() {
        if (this.w != "0") {
            Log.d("start=", "print_offer:" + this.w);
            if (this.w.equals("8")) {
                this.t = this.l.Va(this.n);
                return;
            } else {
                if (this.w.equals("9")) {
                    this.t = this.l.Wa(this.n);
                    return;
                }
                return;
            }
        }
        String str = this.A;
        if (str != "") {
            this.t = this.l.Ga(str, this.B, this.C, this.D);
            return;
        }
        String str2 = this.v;
        if (str2 != null) {
            this.t = this.l.Ia(this.n, str2, this.p, this.q);
            return;
        }
        String[] strArrHa = this.l.Ha(this.n, this.p, "");
        this.t = strArrHa[0];
        this.u = strArrHa[1];
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
        String str;
        int i;
        String str2;
        int i2;
        int i3 = 3;
        String str3 = StringUtilities.LF;
        String str4 = "";
        this.H.append("");
        this.H.append("Start\n");
        if (this.n == null && this.A == "") {
            Log.d("print=", "TR ID IS NULL");
            this.H.append("TR ID IS NULL\n");
            K();
            return;
        }
        if (usbInterface == null) {
            Log.d("print=", "INTERFACE IS NULL");
            this.H.append("INTERFACE IS NULL\n");
            K();
            return;
        }
        if (usbDeviceConnection == null) {
            Log.d("print=", "CONNECTION IS NULL");
            this.H.append("CONNECTION IS NULL\n");
            K();
            return;
        }
        Boolean bool = I;
        if (bool == null) {
            Log.d("print=", "FORCE CLAIM IS NULL");
            this.H.append("FORCE CLAIM IS NULL\n");
            K();
            return;
        }
        usbDeviceConnection.claimInterface(usbInterface, bool.booleanValue());
        this.H.append("Start Send Data\n");
        if (this.t.equals("")) {
            Log.d("print=", "BILL IS NULL");
            this.H.append("BILL IS NULL\n");
            K();
            return;
        }
        try {
            Log.d("print=", "BILL START PRINT");
            this.H.append("BILL START PRINT\n");
            String strIa = this.l.ia("prefThermalType", "1");
            int i4 = Integer.parseInt(this.l.ia("prefNoPrinted", "1"));
            int i5 = 0;
            while (i5 < i4) {
                if (strIa.equals("1") || strIa.equals("4")) {
                    i = i4;
                    str2 = str3;
                    str = str4;
                    usbDeviceConnection.bulkTransfer(this.g, new byte[]{Ascii.ESC, 33, 0}, 3, 0);
                    UsbEndpoint usbEndpoint = this.g;
                    byte[] bArr = WH.a;
                    usbDeviceConnection.bulkTransfer(usbEndpoint, bArr, bArr.length, 0);
                    i2 = 1;
                    J("print.jpg", this.e, false, true);
                } else {
                    if (strIa.equals("5")) {
                        byte[] bArr2 = new byte[i3];
                        // fill-array-data instruction
                        bArr2[0] = 27;
                        bArr2[1] = 33;
                        bArr2[2] = 0;
                        i = i4;
                        str = str4;
                        try {
                            usbDeviceConnection.bulkTransfer(this.g, bArr2, i3, 0);
                            UsbEndpoint usbEndpoint2 = this.g;
                            byte[] bArr3 = WH.a;
                            usbDeviceConnection.bulkTransfer(usbEndpoint2, bArr3, bArr3.length, 0);
                            J("print.jpg", this.e, false, true);
                        } catch (Exception e2) {
                            e = e2;
                            Log.d("print_err=", e.getMessage() + str);
                            Toast.makeText(this, "err=" + e.getMessage(), 1).show();
                            e.printStackTrace();
                            return;
                        }
                    } else {
                        i = i4;
                        str = str4;
                        if (strIa.equals("3")) {
                            byte[] bArr4 = {Ascii.ESC, 33, 0};
                            this.H.append("printformat\n");
                            usbDeviceConnection.bulkTransfer(this.g, bArr4, 3, 0);
                            this.H.append("PrinterCommands\n");
                            UsbEndpoint usbEndpoint3 = this.g;
                            byte[] bArr5 = WH.a;
                            usbDeviceConnection.bulkTransfer(usbEndpoint3, bArr5, bArr5.length, 0);
                            usbDeviceConnection.bulkTransfer(this.g, new byte[]{Ascii.FS, 46}, 2, 0);
                            int i6 = Integer.parseInt(this.l.ia("pref_codetable", "28"));
                            String strReplaceAll = this.t.replaceAll("إ", "ا");
                            this.t = strReplaceAll;
                            String strReplaceAll2 = strReplaceAll.replaceAll("لا", "إ");
                            this.t = strReplaceAll2;
                            String strReplaceAll3 = strReplaceAll2.replaceAll("٠", "0");
                            this.t = strReplaceAll3;
                            String strReplaceAll4 = strReplaceAll3.replaceAll("١", "1");
                            this.t = strReplaceAll4;
                            String strReplaceAll5 = strReplaceAll4.replaceAll("٢", "2");
                            this.t = strReplaceAll5;
                            String strReplaceAll6 = strReplaceAll5.replaceAll("٣", "3");
                            this.t = strReplaceAll6;
                            String strReplaceAll7 = strReplaceAll6.replaceAll("٤", "4");
                            this.t = strReplaceAll7;
                            String strReplaceAll8 = strReplaceAll7.replaceAll("٥", "5");
                            this.t = strReplaceAll8;
                            String strReplaceAll9 = strReplaceAll8.replaceAll("٦", "6");
                            this.t = strReplaceAll9;
                            String strReplaceAll10 = strReplaceAll9.replaceAll("٧", "7");
                            this.t = strReplaceAll10;
                            String strReplaceAll11 = strReplaceAll10.replaceAll("٨", "8");
                            this.t = strReplaceAll11;
                            String strReplaceAll12 = strReplaceAll11.replaceAll("٩", "9");
                            this.t = strReplaceAll12;
                            String[] strArrSplit = strReplaceAll12.split(str3);
                            byte[] bArr6 = {Ascii.ESC, 116, (byte) i6};
                            int i7 = 0;
                            while (i7 < strArrSplit.length) {
                                Log.d("BILL=", strArrSplit[i7]);
                                String strB = new DW().b(strArrSplit[i7]);
                                strArrSplit[i7] = strB;
                                String str5 = this.l.Gc(strB) + str3;
                                usbDeviceConnection.bulkTransfer(this.g, bArr6, 3, 0);
                                usbDeviceConnection.bulkTransfer(this.g, new byte[]{Ascii.ESC, 33, 8}, 3, 0);
                                usbDeviceConnection.bulkTransfer(this.g, str5.getBytes("Cp864"), str5.getBytes("Cp864").length, 0);
                                i7++;
                                strArrSplit = strArrSplit;
                                str3 = str3;
                                bArr6 = bArr6;
                            }
                        } else {
                            str2 = str3;
                            if (strIa.equals("2")) {
                                G(this.e, "print.jpg");
                            }
                        }
                        i2 = 1;
                    }
                    str2 = str3;
                    i2 = 1;
                }
                i5 += i2;
                i4 = i;
                str4 = str;
                str3 = str2;
                i3 = 3;
            }
            str = str4;
            K();
        } catch (Exception e3) {
            e = e3;
            str = str4;
        }
    }

    public final void I(UsbDeviceConnection usbDeviceConnection, UsbInterface usbInterface) {
        Log.d("Bills_cnt=", Z00.j0.size() + "");
        if (Z00.j0.size() > 1 && this.A == "") {
            Toast.makeText(this, getString(R.string.bills_count) + " : " + Z00.j0.size(), 1).show();
        }
        new Thread(new g(usbDeviceConnection, usbInterface)).start();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0140  */
    /* JADX WARN: Code duplicated, block: B:39:0x0148  */
    public final void J(String str, UsbDeviceConnection usbDeviceConnection, boolean z, boolean z2) throws IOException {
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
        if (Z00.M0.equals("4")) {
            byteArrayOutputStream.write(M);
        } else {
            byteArrayOutputStream.write(L);
        }
        for (int i4 = 0; i4 < iArrE.length; i4 += 24) {
            byteArrayOutputStream.write(K);
            int[] iArr = iArrE[i4];
            byteArrayOutputStream.write(new byte[]{(byte) (iArr.length & 255), (byte) ((iArr.length & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)});
            for (int i5 = 0; i5 < iArrE[i4].length; i5++) {
                byteArrayOutputStream.write(L(i4, i5, iArrE));
            }
            byteArrayOutputStream.write(WH.b);
        }
        if (z2) {
            if (this.A == "") {
                List list = Z00.j0;
                if (((String[]) list.get(list.size() - 1))[0].equals(this.n)) {
                    byteArrayOutputStream.write("\n\n\n\n".getBytes());
                    byteArrayOutputStream.write(new byte[]{29, 86, 66});
                    byteArrayOutputStream.write(N);
                } else if (!this.A.equals("")) {
                    byteArrayOutputStream.write(new byte[]{29, 86, 66});
                    byteArrayOutputStream.write(N);
                }
            } else if (!this.A.equals("")) {
                byteArrayOutputStream.write(new byte[]{29, 86, 66});
                byteArrayOutputStream.write(N);
            }
            String strIa = this.l.ia("prefThermalType", "1");
            if (strIa.equals("1") || strIa.equals("4")) {
                new Thread(new e(usbDeviceConnection, byteArrayOutputStream)).run();
            } else if (strIa.equals("3") || strIa.equals("5")) {
                N(byteArrayOutputStream, usbDeviceConnection);
            }
        }
    }

    public void K() {
        Message message = new Message();
        message.obj = "2";
        this.G.sendMessage(message);
    }

    public final byte[] L(int i, int i2, int[][] iArr) {
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
                    b2 = (byte) (b2 | ((byte) ((O(iArr[i6][i2]) ? 1 : 0) << (7 - i5))));
                }
            }
            bArr[i4] = b2;
            i3 += 8;
        }
        return bArr;
    }

    public void M() {
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
            str = str + "\nDeviceID: " + usbDevice.getDeviceId() + "\nDeviceName: " + usbDevice.getDeviceName() + "\nProtocol: " + usbDevice.getDeviceProtocol() + "\nDeviceClass: " + usbDevice.getDeviceClass() + " - " + P(usbDevice.getDeviceClass()) + "\nDeviceSubClass: " + usbDevice.getDeviceSubclass() + "\nVendorID: " + usbDevice.getVendorId() + "\nProductID: " + usbDevice.getDeviceProtocol() + StringUtilities.LF;
            Toast.makeText(this, "INTERFACE COUNT: " + String.valueOf(usbDevice.getInterfaceCount()) + ":" + usbDevice.getManufacturerName() + ":", 0).show();
            this.d = usbDevice;
            Toast.makeText(this, "Device is attached", 1).show();
        }
        this.h = PendingIntent.getBroadcast(this, 0, new Intent("com.android.example.USB_PERMISSION"), 134217728);
        registerReceiver(this.F, new IntentFilter("com.android.example.USB_PERMISSION"));
        this.c.requestPermission(this.d, this.h);
    }

    public void N(ByteArrayOutputStream byteArrayOutputStream, UsbDeviceConnection usbDeviceConnection) {
        try {
            int length = byteArrayOutputStream.toByteArray().length;
            int i = 0;
            while (i < length) {
                int iMin = Math.min(length - i, 200);
                this.H.append("baos_parts\n");
                K();
                usbDeviceConnection.bulkTransfer(this.g, byteArrayOutputStream.toByteArray(), i, iMin, 0);
                usbDeviceConnection.close();
                i += iMin;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String P(int i) {
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

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main_print);
        this.l = new Z00(this.k, this);
        TextView textView = (TextView) findViewById(R.id.bill_tv);
        this.x = textView;
        textView.setDrawingCacheEnabled(true);
        this.z = (ImageView) findViewById(R.id.btn_attach);
        if (getIntent().getStringExtra("cash_id") != null) {
            this.v = getIntent().getStringExtra("cash_id");
        }
        if (getIntent().getStringExtra("TR_TYPE") != null) {
            this.w = getIntent().getStringExtra("TR_TYPE");
        }
        if (getIntent().getStringExtra("cus_id") != null) {
            this.A = getIntent().getStringExtra("cus_id");
            this.B = getIntent().getStringExtra("f_date");
            this.C = getIntent().getStringExtra("t_date");
            this.D = getIntent().getStringExtra("curr_name");
        }
        if (Z00.j0.size() > 0 && this.A == "") {
            this.n = ((String[]) Z00.j0.get(0))[0];
            this.p = ((String[]) Z00.j0.get(0))[1];
            this.q = ((String[]) Z00.j0.get(0)).length > 2 ? ((String[]) Z00.j0.get(0))[2] : "0";
            SettingsActivity.ThermalPreferenceFragment.i = false;
            F();
            new WH();
            new info.aalmoghalis.inventory.printBT.a(Z00.G0, info.aalmoghalis.inventory.printBT.a.EnumC0321a.RIGHT);
            String str = this.t;
            this.y = str;
            this.x.setText(str);
            try {
                this.l.Zd(this.y, this.x, "print2", this.u);
                this.l.id(this.z, Z00.L + "/print2.jpg");
            } catch (Exception e2) {
                Log.d("set_img_err=", e2.getMessage() + "");
            }
        }
        if (!this.A.equals("")) {
            SettingsActivity.ThermalPreferenceFragment.i = false;
            F();
            new WH();
            new info.aalmoghalis.inventory.printBT.a(Z00.G0, info.aalmoghalis.inventory.printBT.a.EnumC0321a.RIGHT);
            String str2 = this.t;
            this.y = str2;
            this.x.setText(str2);
            try {
                this.l.Zd(this.y, this.x, "print2", this.u);
                this.l.Zd(this.y, this.x, "print", this.u);
                this.l.id(this.z, Z00.L + "/print2.jpg");
            } catch (Exception e3) {
                Log.d("set_img_err=", e3.getMessage() + "");
            }
        }
        Button button = (Button) findViewById(R.id.mPrint);
        try {
            this.E = true;
            M();
        } catch (Exception e4) {
            e4.printStackTrace();
            Log.d("print_err1=", e4.getMessage() + "");
        }
        ((Button) findViewById(R.id.Scan)).setOnClickListener(new a());
        button.setOnClickListener(new b());
        ((Button) findViewById(R.id.dis)).setOnClickListener(new c());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (SettingsActivity.ThermalPreferenceFragment.i) {
            SettingsActivity.ThermalPreferenceFragment.i = false;
            F();
            new WH();
            new info.aalmoghalis.inventory.printBT.a(Z00.G0, info.aalmoghalis.inventory.printBT.a.EnumC0321a.RIGHT);
            String str = this.t;
            this.y = str;
            this.x.setText(str);
            try {
                this.l.Zd(this.y, this.x, "print2", this.u);
                this.l.id(this.z, Z00.L + "/print2.jpg");
            } catch (Exception unused) {
            }
        }
    }
}
