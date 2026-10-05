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
import android.os.Message;
import android.text.BidiFormatter;
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
import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.xml.xmp.XmpWriter;
import com.itextpdf.tool.xml.html.HTML;
import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.internal.BluetoothUuids;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.util.internal.StringUtilities;
import defpackage.AbstractC3521o10;
import defpackage.C2151ev;
import defpackage.C4150vl;
import defpackage.DW;
import defpackage.EH;
import defpackage.FS;
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
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.apache.poi.hssf.record.formula.RefErrorPtg;

/* JADX INFO: loaded from: classes3.dex */
public class MainActivity3 extends BaseActivity implements Runnable {
    public static final byte[] R = {10};
    public static final byte[] S = {Ascii.ESC, RefErrorPtg.sid, 33};
    public static final byte[] T = {Ascii.ESC, 50};
    public static final byte[] U = {Ascii.ESC, 51, 1};
    public static final byte[] V = {Ascii.ESC, 51, Ascii.CAN};
    public static final byte[] W = {Ascii.ESC, 51, 30};
    public static final byte[] X = {Ascii.ESC, 51, 8};
    public static byte[] Y = {29, 118, ByteBuffer.ZERO, ByteBuffer.ZERO, 32, 0, 0, 1};
    public static final byte[] Z = {Ascii.ESC, RefErrorPtg.sid, 33};
    public Button c;
    public Button d;
    public Button e;
    public TextView f;
    public TextView g;
    public BluetoothAdapter h;
    public ProgressDialog j;
    public BluetoothSocket k;
    public BluetoothDevice l;
    public SQLiteDatabase n;
    public Z00 p;
    public UUID i = UUID.fromString(BluetoothUuids.PRINTING_CHANNEL_ID);
    public ImageView q = null;
    public String t = null;
    public String u = "0";
    public Dialog v = null;
    public Handler w = new d();
    public String x = null;
    public String y = "";
    public String z = "";
    public int A = 38;
    public int B = 20;
    public int C = 1;
    public int D = 1;
    public int E = 5;
    public String F = "";
    public String G = "";
    public Bitmap H = null;
    public byte[] I = {29, RefErrorPtg.sid, 0, 0, 0};
    public byte[] J = {29, DocWriter.FORWARD, 0};
    public final byte[] K = {Ascii.ESC, 64};
    public final byte[] L = {Ascii.ESC, 64};
    public final byte[] M = {Ascii.ESC, 51, Ascii.CAN};
    public final byte[] N = {Ascii.ESC, 55, 11, Ascii.DEL, 50};
    public final byte[] O = {Ascii.ESC, 100};
    public final byte P = 10;
    public Handler Q = new f();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity3.this.J();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MainActivity3.this.p.ia("DeviceAddress", "").equals("")) {
                MainActivity3.this.J();
            } else {
                MainActivity3.this.B();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity3.this, (Class<?>) SettingsActivity.class);
            intent.putExtra("show_fragment", SettingsActivity.BarcodePreferenceFragment.class.getName());
            MainActivity3.this.startActivity(intent);
        }
    }

    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("msg=", message.obj + "");
            if (message.obj.toString().equals("1")) {
                MainActivity3 mainActivity3 = MainActivity3.this;
                mainActivity3.f.setText(mainActivity3.G);
                try {
                    MainActivity3 mainActivity4 = MainActivity3.this;
                    mainActivity4.p.id(mainActivity4.q, Z00.L + "/print2.jpg");
                } catch (Exception e) {
                    Log.d("set_img_err=", e.getMessage() + "");
                }
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < Z00.j0.size(); i++) {
                MainActivity3.this.x = ((String[]) Z00.j0.get(i))[0];
                MainActivity3.this.y = ((String[]) Z00.j0.get(i))[1];
                if (i == 0) {
                    MainActivity3.this.D();
                }
                new WH();
                MainActivity3 mainActivity3 = MainActivity3.this;
                String str = mainActivity3.F;
                mainActivity3.G = str;
                mainActivity3.p.ae(str, mainActivity3.z, mainActivity3.f, "print2");
                MainActivity3 mainActivity4 = MainActivity3.this;
                mainActivity4.p.ae(mainActivity4.G, mainActivity4.z, mainActivity4.f, "print");
                try {
                    MainActivity3.this.F();
                } catch (Exception e) {
                    Log.d("print_err2=", e.getMessage() + "");
                }
                try {
                    Message message = new Message();
                    message.obj = "1";
                    MainActivity3.this.w.sendMessage(message);
                } catch (Exception unused) {
                }
            }
        }
    }

    public class f extends Handler {
        public f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MainActivity3.this.j.dismiss();
            Toast.makeText(MainActivity3.this, "DeviceConnected", 0).show();
            MainActivity3.this.G();
        }
    }

    private int[][] C(Bitmap bitmap) {
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

    private byte[] I(int i, int i2, int[][] iArr) {
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
                    b2 = (byte) (b2 | ((byte) ((L(iArr[i6][i2]) ? 1 : 0) << (7 - i5))));
                }
            }
            bArr[i4] = b2;
            i3 += 8;
        }
        return bArr;
    }

    private static boolean L(int i) {
        if (((i >> 24) & 255) != 255) {
            return false;
        }
        return ((int) (((((double) ((i >> 16) & 255)) * 0.299d) + (((double) ((i >> 8) & 255)) * 0.587d)) + (((double) (i & 255)) * 0.114d))) < 127;
    }

    public final void A(BluetoothSocket bluetoothSocket) {
        try {
            bluetoothSocket.close();
            Log.d("TAG", "SocketClosed");
        } catch (IOException unused) {
            Log.d("TAG", "CouldNotCloseSocket");
        }
    }

    public void B() {
        String strIa = this.p.ia("DeviceAddress", "");
        EH.c("bonded_device", strIa);
        Log.d("TAG", "DeviceAddress=" + strIa);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.h = defaultAdapter;
        if (defaultAdapter == null) {
            Toast.makeText(this, "Message1", 0).show();
        } else if (defaultAdapter.isEnabled()) {
            if (!z()) {
                return;
            } else {
                w();
            }
        } else if (!z()) {
            return;
        } else {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2);
        }
        this.l = this.h.getRemoteDevice(strIa);
        this.j = ProgressDialog.show(this, "Connecting...", this.l.getName() + " : " + this.l.getAddress(), true, true);
        new Thread(this).start();
    }

    public void D() {
        if (getIntent().getStringExtra("item_barcode") != null) {
            this.z = getIntent().getStringExtra("item_barcode");
        }
        if (getIntent().getStringExtra("img_w") != null) {
            this.A = Integer.parseInt(getIntent().getStringExtra("img_w"));
            this.B = Integer.parseInt(getIntent().getStringExtra("img_h"));
            this.C = Integer.parseInt(getIntent().getStringExtra("img_cnt"));
            this.D = Integer.parseInt(getIntent().getStringExtra("col_cnt"));
        }
        if (getIntent().getStringExtra("img_m2") != null) {
            this.E = Integer.parseInt(getIntent().getStringExtra("img_m2"));
        }
        this.F = this.p.h0(this.x, this.z);
        Log.d("BILL=", this.z + ":" + this.F + "");
    }

    public void E(OutputStream outputStream, String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            if (BitmapFactory.decodeFile(Z00.L + "/" + str, options) != null) {
                outputStream.close();
                BluetoothConnection bluetoothConnection = new BluetoothConnection(this.l.getAddress());
                bluetoothConnection.open();
                ZebraPrinter zebraPrinterFactory = ZebraPrinterFactory.getInstance(bluetoothConnection);
                zebraPrinterFactory.sendCommand("! UTILITIES\r\nIN-MILLIMETERS\r\nCENTER\r\nSETFF 10 2\r\nPRINT\r\n");
                zebraPrinterFactory.printImage(Z00.L + "/print.jpg", 0, 0, -1, -1, false);
                bluetoothConnection.close();
            } else {
                Log.e("Print Photo error", "the file isn't exists");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("photo_error", "" + e2.getMessage());
        }
    }

    public void F() {
        String str = "5";
        if (this.x == null || this.F.equals("")) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("#ابتثجحخدذرزسشصضطظعغفقكلمنهوي@");
            sb.append(StringUtilities.LF);
            String str2 = "";
            try {
                String str3 = "28";
                sb.append(this.p.Ja(new String("#ابتثجحخدذرزسشصضطظعغفقكلمنهوي@".getBytes(XmpWriter.UTF8), "ISO-8859-1").getBytes()));
                sb.append(StringUtilities.LF);
                sb.append(this.p.Ja(new String("#ابتثجحخدذرزسشصضطظعغفقكلمنهوي@".getBytes("ISO-8859-1"), XmpWriter.UTF8).getBytes()));
                sb.append("\n\n");
                sb.append(this.p.Ja("#ابتثجحخدذرزسشصضطظعغفقكلمنهوي@".getBytes("windows-1256")));
                Log.d("bill_print=", sb.toString());
                OutputStream outputStream = this.k.getOutputStream();
                String strIa = this.p.ia("prefThermalType", "1");
                try {
                    if (strIa.equals("1") || strIa.equals("4")) {
                        str = str2;
                        outputStream.write(new byte[]{Ascii.ESC, 33, 0});
                        outputStream.write(WH.a);
                        H("print.jpg", outputStream, true, true);
                    } else {
                        if (strIa.equals("5")) {
                            outputStream.write(WH.a);
                            H("print.jpg", outputStream, true, true);
                        } else if (strIa.equals("2")) {
                            E(outputStream, "print.jpg");
                        } else if (strIa.equals("3")) {
                            outputStream.write(WH.a);
                            outputStream.write(new byte[]{Ascii.FS, 46});
                            Log.d("BILL=", this.F);
                            String strReplaceAll = this.F.replaceAll("إ", "ا");
                            this.F = strReplaceAll;
                            String strReplaceAll2 = strReplaceAll.replaceAll("لا", "إ");
                            this.F = strReplaceAll2;
                            String strReplaceAll3 = strReplaceAll2.replaceAll("٠", "0");
                            this.F = strReplaceAll3;
                            String strReplaceAll4 = strReplaceAll3.replaceAll("١", "1");
                            this.F = strReplaceAll4;
                            String strReplaceAll5 = strReplaceAll4.replaceAll("٢", "2");
                            this.F = strReplaceAll5;
                            String strReplaceAll6 = strReplaceAll5.replaceAll("٣", "3");
                            this.F = strReplaceAll6;
                            String strReplaceAll7 = strReplaceAll6.replaceAll("٤", "4");
                            this.F = strReplaceAll7;
                            String strReplaceAll8 = strReplaceAll7.replaceAll("٥", "5");
                            this.F = strReplaceAll8;
                            String strReplaceAll9 = strReplaceAll8.replaceAll("٦", "6");
                            this.F = strReplaceAll9;
                            String strReplaceAll10 = strReplaceAll9.replaceAll("٧", "7");
                            this.F = strReplaceAll10;
                            String strReplaceAll11 = strReplaceAll10.replaceAll("٨", "8");
                            this.F = strReplaceAll11;
                            String strReplaceAll12 = strReplaceAll11.replaceAll("٩", "9");
                            this.F = strReplaceAll12;
                            String[] strArrSplit = strReplaceAll12.split(StringUtilities.LF);
                            C4150vl c4150vl = new C4150vl(outputStream);
                            int i = 0;
                            while (i < strArrSplit.length) {
                                Log.d("BILL=", strArrSplit[i]);
                                String strB = new DW().b(strArrSplit[i]);
                                strArrSplit[i] = strB;
                                String strGc = this.p.Gc(strB);
                                Log.d("BILL=", strGc + StringUtilities.LF);
                                c4150vl.i("Cp864");
                                String str4 = str3;
                                String strIa2 = this.p.ia("pref_codetable", str4);
                                String str5 = str2;
                                if (strIa2.equals(str5)) {
                                    strIa2 = str4;
                                }
                                c4150vl.r(Integer.parseInt(strIa2));
                                FS fs = new FS();
                                FS.c cVar = FS.c._1;
                                FS fsD = fs.e(cVar, cVar).f(0).d(true);
                                BidiFormatter.getInstance();
                                c4150vl.u(fsD, strGc + StringUtilities.LF);
                                i++;
                                str2 = str5;
                                str3 = str4;
                            }
                        } else {
                            str = str2;
                            if (strIa.equals("10")) {
                                C2151ev c2151evB = C2151ev.b(this.k.getInputStream(), outputStream);
                                if (c2151evB != null) {
                                    Log.d(HTML.Tag.LABEL, "Detected: " + c2151evB + ":" + c2151evB.c);
                                } else {
                                    Log.w(HTML.Tag.LABEL, "Printer did not report label length. Falling back to manual SIZE.");
                                }
                                Log.d("label=", "START_LABELE");
                                outputStream.write(AbstractC3521o10.a());
                                outputStream.write(AbstractC3521o10.f(this.A, this.B + this.E, 1, 8, 0, 0, 0, "864"));
                                Bitmap bitmapD = AbstractC3521o10.d("print.jpg");
                                if (this.E / 2 > this.B / 4) {
                                    this.E = 0;
                                }
                                int i2 = this.C;
                                int i3 = this.D;
                                int i4 = i2 / i3;
                                if (i4 > 0) {
                                    i3 = i4;
                                }
                                outputStream.write("REFERENCE 0,0\r\n".getBytes());
                                outputStream.write("BACKFEED 0\r\n".getBytes());
                                for (int i5 = 0; i5 < i3; i5++) {
                                    outputStream.write(AbstractC3521o10.c());
                                    outputStream.write(AbstractC3521o10.b(0, 0, (int) Math.ceil(bitmapD.getWidth() / 8), bitmapD.getHeight(), 0));
                                    H("print.jpg", outputStream, false, true);
                                    outputStream.write(AbstractC3521o10.e(1, 1));
                                }
                                Log.d("label=", "End_LABELE");
                            }
                        }
                        str = str2;
                    }
                    outputStream.flush();
                } catch (Exception e2) {
                    e = e2;
                    Log.d("print_err1=", e.getMessage() + str);
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                str = str2;
            }
        } catch (Exception e4) {
            e = e4;
            str = "";
        }
    }

    public final void G() {
        Log.d("Bills_cnt=", Z00.j0.size() + "");
        if (Z00.j0.size() > 1) {
            Toast.makeText(this, getString(R.string.bills_count) + " : " + Z00.j0.size(), 1).show();
        }
        new Thread(new e()).start();
    }

    public final void H(String str, OutputStream outputStream, boolean z, boolean z2) throws IOException {
        int i;
        File file = new File(Z00.L, str);
        String strIa = this.p.ia("prefThermalType", "1");
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
        int[][] iArrC = C(bitmapDecodeFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (strIa.equals("4")) {
            byteArrayOutputStream.write(U);
        } else if (!strIa.equals("10")) {
            byteArrayOutputStream.write(V);
        }
        if (strIa.equals("10")) {
            int iCeil = (int) Math.ceil(bitmapDecodeFile.getWidth() / 8);
            for (int i5 = 0; i5 < bitmapDecodeFile.getHeight(); i5++) {
                int i6 = 0;
                while (i6 < iCeil) {
                    int i7 = i6 * 8;
                    byte b2 = 0;
                    int i8 = 0;
                    while (true) {
                        i = i6 + 1;
                        if (i7 < i * 8) {
                            b2 = (byte) (((byte) ((!L(bitmapDecodeFile.getPixel(i7, i5)) ? 1 : 0) << (7 - i8))) | b2);
                            i8++;
                            i7++;
                        }
                    }
                    byteArrayOutputStream.write(b2);
                    i6 = i;
                }
            }
            byteArrayOutputStream.write(StringUtilities.CRLF.getBytes());
        } else {
            for (int i9 = 0; i9 < iArrC.length; i9 += 24) {
                byteArrayOutputStream.write(S);
                int[] iArr = iArrC[i9];
                byteArrayOutputStream.write(new byte[]{(byte) (iArr.length & 255), (byte) ((iArr.length & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)});
                for (int i10 = 0; i10 < iArrC[i9].length; i10++) {
                    byteArrayOutputStream.write(I(i9, i10, iArrC));
                }
                byteArrayOutputStream.write(WH.b);
            }
        }
        if (z2) {
            List list = Z00.j0;
            if (((String[]) list.get(list.size() - 1)).equals(this.x) && !strIa.equals("10")) {
                byteArrayOutputStream.write(W);
            }
            if (strIa.equals("1") || strIa.equals("4") || strIa.equals("10")) {
                outputStream.write(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.toByteArray().length);
            } else if (strIa.equals("3") || strIa.equals("5")) {
                K(byteArrayOutputStream, outputStream);
            }
        }
    }

    public void J() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.h = defaultAdapter;
        if (defaultAdapter == null) {
            Toast.makeText(this, "Message1", 0).show();
            return;
        }
        if (defaultAdapter.isEnabled()) {
            w();
            startActivityForResult(new Intent(this, (Class<?>) DeviceListActivity.class), 1);
        } else if (z()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2);
        }
    }

    public void K(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream) {
        try {
            int length = byteArrayOutputStream.toByteArray().length;
            int i = 0;
            while (i < length) {
                int iMin = Math.min(length - i, 200);
                outputStream.write(byteArrayOutputStream.toByteArray(), i, iMin);
                outputStream.flush();
                i += iMin;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void M(int i) {
        if (!this.p.ia("prefThermalType", "1").equals("10")) {
            this.g.setVisibility(8);
            return;
        }
        String str = String.format("\n\n" + getString(R.string.print_height) + ": %s\n" + getString(R.string.barcode_margin_h) + ": %s\n" + getString(R.string.printer_height) + ": %s\n", Integer.valueOf(this.B), Integer.valueOf(this.E), Integer.valueOf(i));
        this.g.setVisibility(0);
        this.g.setText(str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (i2 != -1) {
                Toast.makeText(this, "Message", 0).show();
                return;
            } else {
                w();
                startActivityForResult(new Intent(this, (Class<?>) DeviceListActivity.class), 1);
                return;
            }
        }
        if (i2 == -1) {
            String string = intent.getExtras().getString("DeviceAddress");
            this.p.Lc("DeviceAddress", string);
            EH.c("bonded_device", string);
            Log.v("TAG", "Coming incoming address " + string);
            this.l = this.h.getRemoteDevice(string);
            this.j = ProgressDialog.show(this, "Connecting...", this.l.getName() + " : " + this.l.getAddress(), true, true);
            new Thread(this).start();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            BluetoothSocket bluetoothSocket = this.k;
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
        this.p = new Z00(this.n, this);
        this.f = (TextView) findViewById(R.id.bill_tv);
        this.g = (TextView) findViewById(R.id.label_info);
        this.q = (ImageView) findViewById(R.id.btn_attach);
        if (Z00.j0.size() > 0) {
            this.x = ((String[]) Z00.j0.get(0))[0];
            this.y = ((String[]) Z00.j0.get(0))[1];
            SettingsActivity.ThermalPreferenceFragment.i = false;
            D();
            new WH();
            new info.aalmoghalis.inventory.printBT.a(Z00.G0, info.aalmoghalis.inventory.printBT.a.EnumC0321a.RIGHT);
            String str = this.F;
            this.G = str;
            this.f.setText(str);
            try {
                int iAe = this.p.ae(this.G, this.z, this.f, "print2");
                this.p.id(this.q, Z00.L + "/print2.jpg");
                M(iAe);
            } catch (Exception e2) {
                Log.d("set_img_err=", e2.getMessage() + "");
            }
        }
        if (this.p.ia("DeviceAddress", "").equals("")) {
            J();
        } else {
            B();
        }
        Button button = (Button) findViewById(R.id.Scan);
        this.c = button;
        button.setOnClickListener(new a());
        Button button2 = (Button) findViewById(R.id.mPrint);
        this.d = button2;
        button2.setOnClickListener(new b());
        Button button3 = (Button) findViewById(R.id.dis);
        this.e = button3;
        button3.setOnClickListener(new c());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            BluetoothSocket bluetoothSocket = this.k;
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
        if (SettingsActivity.BarcodePreferenceFragment.i) {
            SettingsActivity.BarcodePreferenceFragment.i = false;
            D();
            new WH();
            new info.aalmoghalis.inventory.printBT.a(Z00.G0, info.aalmoghalis.inventory.printBT.a.EnumC0321a.RIGHT);
            String str = this.F;
            this.G = str;
            this.f.setText(str);
            try {
                int iAe = this.p.ae(this.G, this.z, this.f, "print2");
                this.p.id(this.q, Z00.L + "/print2.jpg");
                M(iAe);
            } catch (Exception unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                this.k = this.l.createRfcommSocketToServiceRecord(this.i);
                this.h.cancelDiscovery();
                try {
                    this.k.connect();
                } catch (IOException unused) {
                    this.k = this.l.createRfcommSocketToServiceRecord(this.i);
                    Thread.sleep(500L);
                    this.k.connect();
                }
                this.Q.sendEmptyMessage(0);
            } catch (InterruptedException e2) {
                e = e2;
                Log.d("TAG", "CouldNotConnectToSocket", e);
                A(this.k);
            }
        } catch (IOException e3) {
            e = e3;
            Log.d("TAG", "CouldNotConnectToSocket", e);
            A(this.k);
        }
    }

    public final void w() {
        Set<BluetoothDevice> bondedDevices = this.h.getBondedDevices();
        if (bondedDevices.size() > 0) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                Log.v("TAG", "PairedDevices: " + bluetoothDevice.getName() + "  " + bluetoothDevice.getAddress());
            }
        }
    }

    public boolean z() {
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
}
