package info.aalmoghalis.inventory.printBT;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.tool.xml.css.CSS;
import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.internal.BluetoothUuids;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.C1205a8;
import defpackage.C2337h8;
import defpackage.C2419i8;
import defpackage.C4150vl;
import defpackage.C4312xl;
import defpackage.DW;
import defpackage.EH;
import defpackage.EnumC4231wl;
import defpackage.FS;
import defpackage.InterfaceC0954Ub;
import defpackage.VH;
import defpackage.WH;
import defpackage.XH;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.SettingsActivity;
import info.aalmoghalis.inventory.lang.BaseActivity;
import info.aalmoghalis.inventory.printBT.MainActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.apache.poi.hssf.record.formula.RefErrorPtg;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity extends BaseActivity implements Runnable {
    public static final byte[] Q = {10};
    public static final byte[] R = {Ascii.ESC, RefErrorPtg.sid, 33};
    public static final byte[] S = {Ascii.ESC, RefErrorPtg.sid, 1};
    public static final byte[] T = {Ascii.ESC, 50};
    public static final byte[] U = {Ascii.ESC, ByteBuffer.ZERO};
    public static final byte[] V = {Ascii.ESC, 51, 1};
    public static final byte[] W = {Ascii.ESC, 51, 2};
    public static final byte[] X = {Ascii.ESC, 74, 1};
    public static final byte[] Y = {Ascii.ESC, 100, 0};
    public static final byte[] Z = {Ascii.ESC, 51, Ascii.CAN};
    public static final byte[] a0 = {Ascii.ESC, 51, 30};
    public static final byte[] b0 = {Ascii.ESC, 51, 8};
    public static final byte[] c0 = {Ascii.ESC, 51, 10};
    public static final byte[] d0 = {Ascii.ESC, 51, 0};
    public static final byte[] e0 = {Ascii.ESC, 51, 33};
    public static byte[] f0 = {29, 118, ByteBuffer.ZERO, ByteBuffer.ZERO, 32, 0, 0, 1};
    public static final byte[] g0 = {Ascii.ESC, RefErrorPtg.sid, 33};
    public Button c;
    public Button d;
    public Button e;
    public TextView f;
    public BluetoothAdapter g;
    public ProgressDialog i;
    public BluetoothSocket j;
    public BluetoothDevice k;
    public SQLiteDatabase l;
    public Z00 n;
    public UUID h = UUID.fromString(BluetoothUuids.PRINTING_CHANNEL_ID);
    public ImageView p = null;
    public String q = null;
    public String t = "0";
    public String u = "";
    public String v = CSS.Value.PERCENTAGE;
    public String w = CSS.Value.PERCENTAGE;
    public String x = "";
    public Dialog y = null;
    public Handler z = new f();
    public String A = null;
    public String B = "";
    public String C = "";
    public String D = "";
    public String E = "";
    public String F = "";
    public Bitmap G = null;
    public byte[] H = {29, RefErrorPtg.sid, 0, 0, 0};
    public byte[] I = {29, DocWriter.FORWARD, 0};
    public final byte[] J = {Ascii.ESC, 64};
    public final byte[] K = {Ascii.ESC, 64};
    public final byte[] L = {Ascii.ESC, 51, Ascii.CAN};
    public final byte[] M = {Ascii.ESC, 55, 11, Ascii.DEL, 50};
    public final byte[] N = {Ascii.ESC, 100};
    public final byte O = 10;
    public Handler P = new h();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Z00.j0.size() > 0) {
                MainActivity.this.T();
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.P();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity.this.n.ia("DeviceAddress", "").equals("")) {
                MainActivity.this.P();
            } else {
                MainActivity.this.D();
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, (Class<?>) SettingsActivity.class);
            intent.putExtra("show_fragment", SettingsActivity.ThermalPreferenceFragment.class.getName());
            intent.putExtra(":android:no_headers", true);
            MainActivity.this.startActivity(intent);
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ int a;

        public e(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MainActivity.this.A = ((String[]) Z00.j0.get(this.a))[0];
                MainActivity.this.B = ((String[]) Z00.j0.get(this.a))[1];
                MainActivity.this.C = ((String[]) Z00.j0.get(this.a)).length > 2 ? ((String[]) Z00.j0.get(this.a))[2] : "0";
                MainActivity.this.H();
                MainActivity mainActivity = MainActivity.this;
                String str = mainActivity.D;
                mainActivity.F = str;
                mainActivity.n.Zd(str, mainActivity.f, "print2", mainActivity.E);
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.n.Zd(mainActivity2.F, mainActivity2.f, "print", mainActivity2.E);
                MainActivity mainActivity3 = MainActivity.this;
                mainActivity3.n.id(mainActivity3.p, Z00.L + "/" + MainActivity.this.n.ec("print2", ".jpg"));
                MainActivity.this.S();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("print_err2=", e.getMessage() + "");
            }
        }
    }

    public class f extends Handler {
        public f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("1")) {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.f.setText(mainActivity.F);
                try {
                    MainActivity mainActivity2 = MainActivity.this;
                    mainActivity2.n.id(mainActivity2.p, Z00.L + "/" + MainActivity.this.n.ec("print2", ".jpg"));
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("set_img_err=", e.getMessage() + "");
                    return;
                }
            }
            if (message.obj.toString().equals("2")) {
                MainActivity mainActivity3 = MainActivity.this;
                mainActivity3.f.setText(mainActivity3.F);
                try {
                    MainActivity mainActivity4 = MainActivity.this;
                    mainActivity4.n.id(mainActivity4.p, Z00.L + "/" + MainActivity.this.n.ec("print2", ".jpg"));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Log.d("set_img_err=", e2.getMessage() + "");
                }
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!MainActivity.this.u.equals("")) {
                MainActivity.this.H();
                new WH();
                MainActivity mainActivity = MainActivity.this;
                String str = mainActivity.D;
                mainActivity.F = str;
                mainActivity.n.Zd(str, mainActivity.f, "print2", mainActivity.E);
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.n.Zd(mainActivity2.F, mainActivity2.f, "print", mainActivity2.E);
                try {
                    MainActivity.this.K();
                } catch (Exception e) {
                    Log.d("print_err2=", e.getMessage() + "");
                    e.printStackTrace();
                }
                try {
                    Message message = new Message();
                    message.obj = "1";
                    MainActivity.this.z.sendMessage(message);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            for (int i = 0; i < Z00.j0.size(); i++) {
                MainActivity.this.A = ((String[]) Z00.j0.get(i))[0];
                MainActivity.this.B = ((String[]) Z00.j0.get(i))[1];
                MainActivity.this.C = ((String[]) Z00.j0.get(i)).length > 2 ? ((String[]) Z00.j0.get(i))[2] : "0";
                MainActivity.this.H();
                new WH();
                MainActivity mainActivity3 = MainActivity.this;
                String str2 = mainActivity3.D;
                mainActivity3.F = str2;
                mainActivity3.n.Zd(str2, mainActivity3.f, "print2", mainActivity3.E);
                MainActivity mainActivity4 = MainActivity.this;
                mainActivity4.n.Zd(mainActivity4.F, mainActivity4.f, "print", mainActivity4.E);
                try {
                    MainActivity.this.K();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    Log.d("print_err2=", e3.getMessage() + "");
                }
                try {
                    Message message2 = new Message();
                    message2.obj = "1";
                    MainActivity.this.z.sendMessage(message2);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public class h extends Handler {
        public h() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MainActivity.this.i.dismiss();
            Toast.makeText(MainActivity.this, "DeviceConnected", 0).show();
            MainActivity.this.L();
        }
    }

    public static final class i implements InterfaceC0954Ub {
        public Bitmap a;

        public i(Bitmap bitmap) {
            this.a = bitmap;
        }
    }

    private void C(BluetoothSocket bluetoothSocket) {
        try {
            bluetoothSocket.close();
            Log.d("thermal_printer=", "SocketClosed");
        } catch (IOException unused) {
            Log.d("thermal_printer=", "CouldNotCloseSocket");
        }
    }

    private int[][] E(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, height, width);
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                iArr[i2][i3] = bitmap.getPixel(i3, i2);
            }
        }
        return iArr;
    }

    public static /* synthetic */ void G(Bitmap bitmap, VH vh) {
        vh.j(bitmap, -1);
        vh.k();
        vh.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Log.d("Bills_cnt=", Z00.j0.size() + "");
        if (Z00.j0.size() > 1 && this.u.equals("")) {
            Toast.makeText(this, getString(R.string.bills_count) + " : " + Z00.j0.size(), 1).show();
        }
        new Thread(new g()).start();
    }

    private byte[] O(int i2, int i3, int[][] iArr) {
        byte[] bArr = new byte[3];
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        int i4 = i2;
        for (int i5 = 0; i4 < i2 + 24 && i5 < 3; i5++) {
            byte b2 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                int i7 = i4 + i6;
                if (i7 < iArr.length) {
                    b2 = (byte) (b2 | ((byte) ((U(iArr[i7][i3]) ? 1 : 0) << (7 - i6))));
                }
            }
            bArr[i5] = b2;
            i4 += 8;
        }
        return bArr;
    }

    private static boolean U(int i2) {
        if (((i2 >> 24) & 255) != 255) {
            return false;
        }
        return ((int) (((((double) ((i2 >> 16) & 255)) * 0.299d) + (((double) ((i2 >> 8) & 255)) * 0.587d)) + (((double) (i2 & 255)) * 0.114d))) < 127;
    }

    private void y() {
        Set<BluetoothDevice> bondedDevices = this.g.getBondedDevices();
        if (bondedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
            }
        }
    }

    public boolean B() {
        boolean z;
        boolean z2 = false;
        if (ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") != -1 || Build.VERSION.SDK_INT < 31) {
            z = true;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.BLUETOOTH_CONNECT"}, 2);
            z = false;
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_SCAN") != -1 || Build.VERSION.SDK_INT < 31) {
            z2 = z;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.BLUETOOTH_SCAN"}, 2);
        }
        Log.d("check_bluetooth_perm=", z2 + "");
        return z2;
    }

    public void D() {
        String strIa = this.n.ia("DeviceAddress", "");
        EH.c("bonded_device", strIa);
        Log.d("thermal_printer=", "DeviceAddress=" + strIa);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.g = defaultAdapter;
        if (defaultAdapter == null) {
            Toast.makeText(this, "Message1", 0).show();
        } else if (defaultAdapter.isEnabled()) {
            if (!B()) {
                return;
            } else {
                y();
            }
        } else if (!B()) {
            return;
        } else {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2);
        }
        this.k = this.g.getRemoteDevice(strIa);
        this.i = ProgressDialog.show(this, "Connecting...", this.k.getName() + " : " + this.k.getAddress(), true, true);
        new Thread(this).start();
    }

    public final void F() {
        BluetoothDevice bluetoothDeviceE = VH.l(this).e();
        if (bluetoothDeviceE != null) {
            bluetoothDeviceE.getName();
        }
    }

    public void H() {
        String str = this.t;
        if (str == "0") {
            String str2 = this.u;
            if (str2 != "") {
                this.D = this.n.Ga(str2, this.v, this.w, this.x);
                return;
            }
            String str3 = this.q;
            if (str3 != null) {
                this.D = this.n.Ia(this.A, str3, this.B, this.C);
                return;
            }
            String[] strArrHa = this.n.Ha(this.A, this.B, "");
            this.D = strArrHa[0];
            this.E = strArrHa[1];
            return;
        }
        if (!str.equals("8")) {
            if (this.t.equals("9")) {
                this.D = this.n.Wa(this.A);
                return;
            }
            return;
        }
        Log.d("print_offer=", ":" + this.t + ":" + this.A);
        this.D = this.n.Va(this.A);
    }

    public void I(OutputStream outputStream, String str, boolean z) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            options.inPreferredConfig = config;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(Z00.L + "/" + str, options);
            if (z) {
                int width = bitmapDecodeFile.getWidth();
                int height = bitmapDecodeFile.getHeight();
                if (width % 8 != 0 || height % 24 != 0) {
                    int i2 = 0;
                    int i3 = ((width / 8) * 8) - (width % 8 == 0 ? 0 : 8);
                    int i4 = (height / 24) * 24;
                    if (height % 24 != 0) {
                        i2 = 24;
                    }
                    int i5 = i4 + i2;
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i5, config);
                    float f2 = i3 / width;
                    float f3 = i5 / height;
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
            if (bitmapDecodeFile != null) {
                outputStream.close();
            } else {
                Log.e("Print Photo error", "the file isn't exists");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("photo_error", "" + e2.getMessage());
        }
    }

    public void J(OutputStream outputStream, String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            if (BitmapFactory.decodeFile(Z00.L + "/" + str, options) != null) {
                outputStream.close();
                BluetoothConnection bluetoothConnection = new BluetoothConnection(this.k.getAddress());
                bluetoothConnection.open();
                ZebraPrinter zebraPrinterFactory = ZebraPrinterFactory.getInstance(bluetoothConnection);
                zebraPrinterFactory.sendCommand("! UTILITIES\r\nIN-MILLIMETERS\r\nCENTER\r\nSETFF 10 2\r\nPRINT\r\n");
                zebraPrinterFactory.printImage(Z00.L + "/" + this.n.fc("print", ".jpg"), 0, 0, -1, -1, false);
                bluetoothConnection.close();
            } else {
                Log.e("Print Photo error", "the file isn't exists");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("photo_error", "" + e2.getMessage());
        }
    }

    public void K() {
        OutputStream outputStream;
        String str;
        String str2 = StringUtilities.LF;
        String str3 = "إ";
        String str4 = "8";
        String str5 = "7";
        String str6 = "6";
        String str7 = "4";
        String str8 = "1";
        String str9 = "";
        if ((this.A == null && this.u.equals("")) || this.D.equals("")) {
            return;
        }
        try {
            OutputStream outputStream2 = this.j.getOutputStream();
            String str10 = "";
            try {
                String strIa = this.n.ia("prefThermalType", "1");
                String str11 = "28";
                int i2 = Integer.parseInt(this.n.ia("prefNoPrinted", "1"));
                int i3 = 0;
                while (i3 < i2) {
                    String str12 = str8;
                    int i4 = i2;
                    int i5 = i3;
                    String str13 = str2;
                    String str14 = str3;
                    if (strIa.equals(str8) || strIa.equals(str7) || strIa.equals(str6)) {
                        String str15 = str11;
                        OutputStream outputStream3 = outputStream2;
                        Log.d("print_thermal=", "start_print");
                        outputStream3.write(new byte[]{Ascii.ESC, 33, 0});
                        Log.d("print_thermal=", "select_font_A");
                        outputStream3.write(WH.a);
                        Log.d("print_thermal=", "reset_modes");
                        outputStream = outputStream3;
                        str = str15;
                        M(this.n.fc("print", ".jpg"), outputStream3, false, true, new int[0]);
                    } else {
                        if (strIa.equals(str5)) {
                            Log.d("print_thermal=", "start_print");
                            N(this.n.fc("print", ".jpg"), outputStream2, true, true);
                            str = str11;
                            outputStream = outputStream2;
                        } else if (strIa.equals(str4)) {
                            Log.d("print_thermal=", "start_print");
                            outputStream2.write(new byte[]{Ascii.ESC, 33, 0});
                            Log.d("print_thermal=", "select_font_A");
                            outputStream2.write(WH.a);
                            I(outputStream2, this.n.fc("print", ".jpg"), false);
                            str5 = str5;
                            str4 = str4;
                            str10 = str10;
                            str = str11;
                            str12 = str12;
                            str14 = str14;
                            outputStream = outputStream2;
                            str6 = str6;
                            strIa = strIa;
                            str13 = str13;
                            str7 = str7;
                        } else {
                            String str16 = str7;
                            if (strIa.equals("5")) {
                                outputStream2.write(WH.a);
                                OutputStream outputStream4 = outputStream2;
                                M(this.n.fc("print", ".jpg"), outputStream4, true, true, new int[0]);
                                strIa = strIa;
                                str4 = str4;
                                str10 = str10;
                                str13 = str13;
                                str14 = str14;
                                str7 = str16;
                                str12 = str12;
                                str5 = str5;
                                outputStream = outputStream4;
                                str = str11;
                                str6 = str6;
                            } else {
                                OutputStream outputStream5 = outputStream2;
                                String str17 = str6;
                                if (strIa.equals("2")) {
                                    J(outputStream5, this.n.fc("print", ".jpg"));
                                } else if (strIa.equals("3")) {
                                    outputStream5.write(new byte[]{Ascii.ESC, 33, 0});
                                    outputStream5.write(WH.a);
                                    outputStream5.write(new byte[]{Ascii.FS, 46});
                                    Log.d("BILL=", this.D);
                                    String str18 = str14;
                                    String strReplaceAll = this.D.replaceAll(str18, "ا");
                                    this.D = strReplaceAll;
                                    String strReplaceAll2 = strReplaceAll.replaceAll("لا", str18);
                                    this.D = strReplaceAll2;
                                    String strReplaceAll3 = strReplaceAll2.replaceAll("٠", "0");
                                    this.D = strReplaceAll3;
                                    String strReplaceAll4 = strReplaceAll3.replaceAll("١", str12);
                                    this.D = strReplaceAll4;
                                    String strReplaceAll5 = strReplaceAll4.replaceAll("٢", "2");
                                    this.D = strReplaceAll5;
                                    String strReplaceAll6 = strReplaceAll5.replaceAll("٣", "3");
                                    this.D = strReplaceAll6;
                                    String strReplaceAll7 = strReplaceAll6.replaceAll("٤", str16);
                                    this.D = strReplaceAll7;
                                    String strReplaceAll8 = strReplaceAll7.replaceAll("٥", "5");
                                    this.D = strReplaceAll8;
                                    String strReplaceAll9 = strReplaceAll8.replaceAll("٦", str17);
                                    this.D = strReplaceAll9;
                                    String strReplaceAll10 = strReplaceAll9.replaceAll("٧", str5);
                                    this.D = strReplaceAll10;
                                    String strReplaceAll11 = strReplaceAll10.replaceAll("٨", str4);
                                    this.D = strReplaceAll11;
                                    String strReplaceAll12 = strReplaceAll11.replaceAll("٩", "9");
                                    this.D = strReplaceAll12;
                                    String[] strArrSplit = strReplaceAll12.split(str13);
                                    C4150vl c4150vl = new C4150vl(outputStream5);
                                    strIa = strIa;
                                    int i6 = 0;
                                    while (i6 < strArrSplit.length) {
                                        String str19 = str18;
                                        String strB = new DW().b(strArrSplit[i6]);
                                        strArrSplit[i6] = strB;
                                        String strGc = this.n.Gc(strB);
                                        c4150vl.i("Cp864");
                                        String[] strArr = strArrSplit;
                                        String str20 = str5;
                                        String str21 = str11;
                                        String strIa2 = this.n.ia("pref_codetable", str21);
                                        String str22 = str10;
                                        try {
                                            if (strIa2.equals(str22)) {
                                                strIa2 = str21;
                                            }
                                            c4150vl.r(Integer.parseInt(strIa2));
                                            FS fs = new FS();
                                            str10 = str22;
                                            FS.c cVar = FS.c._1;
                                            c4150vl.u(fs.e(cVar, cVar).f(0).d(true), strGc + str13);
                                            i6++;
                                            str11 = str21;
                                            strArrSplit = strArr;
                                            str18 = str19;
                                            str5 = str20;
                                        } catch (Exception e2) {
                                            e = e2;
                                            str10 = str22;
                                            str9 = str10;
                                            Log.d("print_err1=", e.getMessage() + str9);
                                            e.printStackTrace();
                                            return;
                                        }
                                    }
                                    String str23 = str18;
                                    str5 = str5;
                                    String str24 = str11;
                                    String str25 = this.A;
                                    List list = Z00.j0;
                                    if (str25 == ((String[]) list.get(list.size() - 1))[0]) {
                                        c4150vl.d(4);
                                        c4150vl.c(C4150vl.b.PART);
                                    }
                                    new C2337h8();
                                    C2419i8 c2419i8 = new C2419i8();
                                    new C1205a8().a(EnumC4231wl.Center);
                                    if (new File(Z00.L, "print.jpg").exists()) {
                                        Log.d("BILL=", "imgFile.exists");
                                        new C4312xl(new i(BitmapFactory.decodeFile(Z00.L + "/print.jpg")), c2419i8);
                                    }
                                    str13 = str13;
                                    str4 = str4;
                                    str7 = str16;
                                    str6 = str17;
                                    str10 = str10;
                                    str12 = str12;
                                    str14 = str23;
                                    outputStream = outputStream5;
                                    str = str24;
                                }
                                strIa = strIa;
                                str4 = str4;
                                str10 = str10;
                                str13 = str13;
                                str14 = str14;
                                str7 = str16;
                                str12 = str12;
                                str5 = str5;
                                outputStream = outputStream5;
                                str = str11;
                                str6 = str17;
                            }
                        }
                        str2 = str13;
                        i3 = i5 + 1;
                        str4 = str4;
                        str6 = str6;
                        str8 = str12;
                        strIa = strIa;
                        str7 = str7;
                        outputStream2 = outputStream;
                        str5 = str5;
                        str11 = str;
                        str3 = str14;
                        str10 = str10;
                        i2 = i4;
                    }
                    str2 = str13;
                    i3 = i5 + 1;
                    str4 = str4;
                    str6 = str6;
                    str8 = str12;
                    strIa = strIa;
                    str7 = str7;
                    outputStream2 = outputStream;
                    str5 = str5;
                    str11 = str;
                    str3 = str14;
                    str10 = str10;
                    i2 = i4;
                }
                str9 = str10;
                outputStream2.flush();
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x017f A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:3:0x0010, B:6:0x002e, B:8:0x0053, B:10:0x005f, B:15:0x0067, B:19:0x0074, B:23:0x0083, B:24:0x00da, B:26:0x00e9, B:29:0x00fa, B:32:0x00ff, B:33:0x0114, B:34:0x0131, B:36:0x0136, B:37:0x013f, B:39:0x014a, B:42:0x0150, B:44:0x0167, B:48:0x0195, B:50:0x019b, B:53:0x01a2, B:55:0x01aa, B:56:0x01c7, B:58:0x01cf, B:59:0x01ec, B:45:0x017f, B:47:0x0187, B:60:0x0211, B:27:0x00f4, B:61:0x0217), top: B:65:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0187 A[Catch: Exception -> 0x0064, TryCatch #0 {Exception -> 0x0064, blocks: (B:3:0x0010, B:6:0x002e, B:8:0x0053, B:10:0x005f, B:15:0x0067, B:19:0x0074, B:23:0x0083, B:24:0x00da, B:26:0x00e9, B:29:0x00fa, B:32:0x00ff, B:33:0x0114, B:34:0x0131, B:36:0x0136, B:37:0x013f, B:39:0x014a, B:42:0x0150, B:44:0x0167, B:48:0x0195, B:50:0x019b, B:53:0x01a2, B:55:0x01aa, B:56:0x01c7, B:58:0x01cf, B:59:0x01ec, B:45:0x017f, B:47:0x0187, B:60:0x0211, B:27:0x00f4, B:61:0x0217), top: B:65:0x0010 }] */
    public final void M(String str, OutputStream outputStream, boolean z, boolean z2, int... iArr) {
        try {
            Log.d("print_image=", "start print");
            File file = new File(Z00.L, str);
            String strIa = this.n.ia("prefThermalType", "1");
            if (!file.exists()) {
                Log.d("print_thermal=", "file doesn't exists");
                return;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            options.inPreferredConfig = config;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(Z00.L + "/" + str, options);
            if (z) {
                int width = bitmapDecodeFile.getWidth();
                int height = bitmapDecodeFile.getHeight();
                if (width % 8 != 0 || height % 24 != 0) {
                    int i2 = ((width / 8) * 8) - (width % 8 == 0 ? 0 : 8);
                    int i3 = ((height / 24) * 24) + (height % 24 == 0 ? 0 : 24);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
                    Matrix matrix = new Matrix();
                    matrix.setScale(i2 / width, i3 / height, 0.0f, 0.0f);
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
            if (strIa.equals("4")) {
                byteArrayOutputStream.write(V);
                Log.d("print_thermal=", "set_line_space");
            } else {
                byteArrayOutputStream.write(Z);
            }
            for (int i4 = 0; i4 < iArrE.length; i4 += 24) {
                if (i4 == 0) {
                    Log.d("print_thermal=", "SELECT_BIT_IMAGE_MODE:" + iArrE.length);
                }
                byteArrayOutputStream.write(R);
                int[] iArr2 = iArrE[i4];
                byteArrayOutputStream.write(new byte[]{(byte) (iArr2.length & 255), (byte) ((iArr2.length & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)});
                for (int i5 = 0; i5 < iArrE[i4].length; i5++) {
                    byteArrayOutputStream.write(O(i4, i5, iArrE));
                }
                byteArrayOutputStream.write(WH.b);
            }
            if (z2) {
                if (this.u == "") {
                    List list = Z00.j0;
                    if (((String[]) list.get(list.size() - 1))[0].equals(this.A)) {
                        byteArrayOutputStream.write("\n\n\n\n".getBytes());
                        byteArrayOutputStream.write(new byte[]{29, 86, 66});
                        byteArrayOutputStream.write(a0);
                    } else if (!this.u.equals("")) {
                        byteArrayOutputStream.write(new byte[]{29, 86, 66});
                        byteArrayOutputStream.write(a0);
                    }
                } else if (!this.u.equals("")) {
                    byteArrayOutputStream.write(new byte[]{29, 86, 66});
                    byteArrayOutputStream.write(a0);
                }
                if (strIa.equals("1") || strIa.equals("4")) {
                    Log.d("print_thermal=", "push_data:" + byteArrayOutputStream.toByteArray().length);
                    outputStream.write(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.toByteArray().length);
                } else if (strIa.equals("5")) {
                    Log.d("print_thermal=", "push_data_batch:" + byteArrayOutputStream.toByteArray().length);
                    Q(byteArrayOutputStream, outputStream);
                } else if (strIa.equals("6")) {
                    Log.d("print_thermal=", "push_data_per_byte:" + byteArrayOutputStream.toByteArray().length);
                    R(byteArrayOutputStream, outputStream);
                }
            }
            Log.d("print_thermal=", "finish");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void N(String str, OutputStream outputStream, boolean z, boolean z2) throws IOException {
        File file = new File(Z00.L, str);
        file.length();
        new ByteArrayOutputStream();
        Log.d("thermal_printer=", "print_image2=" + str + ":" + file.lastModified() + ":" + file.getAbsolutePath());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        final Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        outputStream.close();
        F();
        Z00 z00 = this.n;
        int i2 = Integer.parseInt(z00.C(z00.ia("prefPaperSize", getString(R.string.default_paper_size))));
        XH.f = i2;
        int i3 = i2 * 8;
        XH.e = i3;
        XH.d = i3;
        VH.l(this).d(new VH.a() { // from class: fx
            @Override // VH.a
            public final void a(VH vh) {
                MainActivity.G(bitmapDecodeFile, vh);
            }
        }, new VH.b() { // from class: gx
            @Override // VH.b
            public final void a(String str2) {
                this.a.V(str2);
            }
        });
    }

    public void P() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.g = defaultAdapter;
        if (defaultAdapter == null) {
            Toast.makeText(this, "Message1", 0).show();
            return;
        }
        if (!defaultAdapter.isEnabled()) {
            if (B()) {
                startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2);
            }
        } else if (B()) {
            y();
            startActivityForResult(new Intent(this, (Class<?>) DeviceListActivity.class), 1);
        }
    }

    public void Q(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream) {
        try {
            int length = byteArrayOutputStream.toByteArray().length;
            int i2 = 0;
            while (i2 < length) {
                int iMin = Math.min(length - i2, 200);
                outputStream.write(byteArrayOutputStream.toByteArray(), i2, iMin);
                outputStream.flush();
                i2 += iMin;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void R(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream) {
        try {
            int length = byteArrayOutputStream.toByteArray().length;
            for (int i2 = 0; i2 < length - 1; i2++) {
                outputStream.write(byteArrayOutputStream.toByteArray()[i2]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void S() {
        String strX4;
        Z00 z00 = new Z00(this.l, this);
        this.n = z00;
        if (this.t != "0") {
            strX4 = z00.X4("select ifnull(b.gsm,'') as _id from bills2 a,customers b where a.cus_id=b.id and a.id=" + this.A);
        } else if (this.u != "") {
            strX4 = z00.X4("select ifnull(b.gsm,'') as _id from customers b where   b.id=" + this.u);
        } else if (this.q == null) {
            strX4 = z00.X4("select ifnull(b.gsm,'') as _id from bills a,customers b where a.cus_id=b.id and a.id=" + this.A + " and a.date_='" + this.B + "'");
        } else {
            strX4 = z00.X4("select ifnull(b.gsm,'') as _id from transactions a,customers b  where a.cus_id=b.id and a.p_id=" + this.A + " and a.bill_id=-3  and a.p_date='" + this.B + "' and  ifnull(substr( a.online_ref2, instr(a.online_ref2, ':')),'0') ='" + this.C + "' and a.cus_id<> " + this.q);
        }
        Z00 z01 = this.n;
        z01.Fd(strX4, z01.ec("print2", ".jpg"));
    }

    public void T() {
        if (Z00.j0.size() > 1 && this.u.equals("")) {
            Toast.makeText(this, getString(R.string.bills_count) + " : " + Z00.j0.size(), 0).show();
        }
        if (this.u.equals("")) {
            int i2 = 0;
            for (int i3 = 0; i3 < Z00.j0.size(); i3++) {
                new Handler(Looper.getMainLooper()).postDelayed(new e(i3), i2 == 0 ? 0L : i2 * AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                i2++;
            }
            return;
        }
        H();
        new WH();
        String str = this.D;
        this.F = str;
        this.n.Zd(str, this.f, "print2", this.E);
        this.n.Zd(this.F, this.f, "print", this.E);
        this.n.id(this.p, Z00.L + "/" + this.n.ec("print2", ".jpg"));
        try {
            S();
        } catch (Exception e2) {
            Log.d("print_err2=", e2.getMessage() + "");
            e2.printStackTrace();
        }
    }

    public final void V(String str) {
        Toast.makeText(this, str, 0).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1) {
            if (i2 == 2 && i3 == -1) {
                y();
                startActivityForResult(new Intent(this, (Class<?>) DeviceListActivity.class), 1);
                return;
            }
            return;
        }
        if (i3 == -1) {
            String string = intent.getExtras().getString("DeviceAddress");
            this.n.Lc("DeviceAddress", string);
            EH.c("bonded_device", string);
            Log.v("thermal_printer=", "Coming incoming address " + string);
            this.k = this.g.getRemoteDevice(string);
            this.i = ProgressDialog.show(this, "Connecting...", this.k.getName() + " : " + this.k.getAddress(), true, true);
            new Thread(this).start();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            BluetoothSocket bluetoothSocket = this.j;
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }
        } catch (Exception e2) {
            Log.e("Tag", "Exe ", e2);
        }
        setResult(0);
        finish();
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main_print);
        this.n = new Z00(this.l, this);
        this.f = (TextView) findViewById(R.id.bill_tv);
        ImageView imageView = (ImageView) findViewById(R.id.btn_attach);
        this.p = imageView;
        imageView.setOnClickListener(new a());
        if (getIntent().getStringExtra("cash_id") != null) {
            this.q = getIntent().getStringExtra("cash_id");
        }
        if (getIntent().getStringExtra("TR_TYPE") != null) {
            this.t = getIntent().getStringExtra("TR_TYPE");
        }
        if (getIntent().getStringExtra("cus_id") != null) {
            this.u = getIntent().getStringExtra("cus_id");
            this.v = getIntent().getStringExtra("f_date");
            this.w = getIntent().getStringExtra("t_date");
            this.x = getIntent().getStringExtra("curr_name");
        }
        if (Z00.j0.size() > 0 && this.u.equals("")) {
            this.A = ((String[]) Z00.j0.get(0))[0];
            this.B = ((String[]) Z00.j0.get(0))[1];
            this.C = ((String[]) Z00.j0.get(0)).length > 2 ? ((String[]) Z00.j0.get(0))[2] : "0";
            SettingsActivity.ThermalPreferenceFragment.i = false;
            H();
            new WH();
            new info.aalmoghalis.inventory.printBT.a(Z00.G0, info.aalmoghalis.inventory.printBT.a.EnumC0321a.RIGHT);
            String str = this.D;
            this.F = str;
            this.f.setText(str);
            try {
                this.n.Zd(this.F, this.f, "print2", this.E);
                this.n.Zd(this.F, this.f, "print", this.E);
                this.n.id(this.p, Z00.L + "/" + this.n.ec("print2", ".jpg"));
            } catch (Exception e2) {
                Log.d("set_img_err=", e2.getMessage() + "");
            }
        } else if (!this.u.equals("")) {
            SettingsActivity.ThermalPreferenceFragment.i = false;
            H();
            new WH();
            new info.aalmoghalis.inventory.printBT.a(Z00.G0, info.aalmoghalis.inventory.printBT.a.EnumC0321a.RIGHT);
            String str2 = this.D;
            this.F = str2;
            this.f.setText(str2);
            try {
                this.n.Zd(this.F, this.f, "print2", this.E);
                this.n.Zd(this.F, this.f, "print", this.E);
                this.n.id(this.p, Z00.L + "/" + this.n.ec("print2", ".jpg"));
            } catch (Exception e3) {
                Log.d("set_img_err=", e3.getMessage() + "");
            }
        }
        if (this.n.ia("DeviceAddress", "").equals("")) {
            P();
        } else {
            D();
        }
        Button button = (Button) findViewById(R.id.Scan);
        this.c = button;
        button.setOnClickListener(new b());
        Button button2 = (Button) findViewById(R.id.mPrint);
        this.d = button2;
        button2.setOnClickListener(new c());
        Button button3 = (Button) findViewById(R.id.dis);
        this.e = button3;
        button3.setOnClickListener(new d());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            BluetoothSocket bluetoothSocket = this.j;
            if (bluetoothSocket != null) {
                bluetoothSocket.close();
            }
        } catch (Exception e2) {
            Log.e("Tag", "Exe ", e2);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (SettingsActivity.ThermalPreferenceFragment.i) {
            SettingsActivity.ThermalPreferenceFragment.i = false;
            H();
            new WH();
            new info.aalmoghalis.inventory.printBT.a(Z00.G0, info.aalmoghalis.inventory.printBT.a.EnumC0321a.RIGHT);
            String str = this.D;
            this.F = str;
            this.f.setText(str);
            try {
                this.n.Zd(this.F, this.f, "print2", this.E);
                this.n.Zd(this.F, this.f, "print", this.E);
                this.n.id(this.p, Z00.L + "/" + this.n.ec("print2", ".jpg"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003e  */
    @Override // java.lang.Runnable
    public void run() {
        BluetoothSocket bluetoothSocket;
        try {
            try {
                this.j = this.k.createRfcommSocketToServiceRecord(this.h);
                this.g.cancelDiscovery();
                try {
                    this.j.connect();
                } catch (IOException unused) {
                    this.j = this.k.createRfcommSocketToServiceRecord(this.h);
                    Thread.sleep(500L);
                    this.j.connect();
                }
                this.P.sendEmptyMessage(0);
            } catch (InterruptedException e2) {
                e = e2;
                Log.d("thermal_printer=", "CouldNotConnectToSocket", e);
                bluetoothSocket = this.j;
                if (bluetoothSocket != null) {
                    C(bluetoothSocket);
                }
                e.printStackTrace();
            }
        } catch (IOException e3) {
            e = e3;
            Log.d("thermal_printer=", "CouldNotConnectToSocket", e);
            bluetoothSocket = this.j;
            if (bluetoothSocket != null) {
                C(bluetoothSocket);
            }
            e.printStackTrace();
        }
    }
}
