package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.client.android.BeepManager;
import com.google.zxing.client.android.InactivityTimer;
import com.google.zxing.client.android.Intents;
import com.google.zxing.client.android.R;
import defpackage.V6;
import defpackage.Y6;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final String m = "a";
    public static int n = 250;
    public Activity a;
    public DecoratedBarcodeView b;
    public InactivityTimer f;
    public BeepManager g;
    public Handler h;
    public final CameraPreview.f k;
    public boolean l;
    public int c = -1;
    public boolean d = false;
    public boolean e = false;
    public boolean i = false;
    public V6 j = new C0276a();

    /* JADX INFO: renamed from: com.journeyapps.barcodescanner.a$a, reason: collision with other inner class name */
    public class C0276a implements V6 {

        /* JADX INFO: renamed from: com.journeyapps.barcodescanner.a$a$a, reason: collision with other inner class name */
        public class RunnableC0277a implements Runnable {
            public final /* synthetic */ Y6 a;

            public RunnableC0277a(Y6 y6) {
                this.a = y6;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.u(this.a);
            }
        }

        public C0276a() {
        }

        @Override // defpackage.V6
        public void a(List list) {
        }

        @Override // defpackage.V6
        public void b(Y6 y6) {
            a.this.b.f();
            a.this.g.playBeepSoundAndVibrate();
            a.this.h.post(new RunnableC0277a(y6));
        }
    }

    public class b implements CameraPreview.f {
        public b() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void a() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void b(Exception exc) {
            a.this.i();
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void c() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void d() {
            if (a.this.i) {
                Log.d(a.m, "Camera closed; finishing activity");
                a.this.j();
            }
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.f
        public void e() {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d(a.m, "Finishing due to inactivity");
            a.this.j();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.v();
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            a.this.j();
        }
    }

    public class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a.this.j();
        }
    }

    public a(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        b bVar = new b();
        this.k = bVar;
        this.l = false;
        this.a = activity;
        this.b = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().i(bVar);
        this.h = new Handler();
        this.f = new InactivityTimer(activity, new c());
        this.g = new BeepManager(activity);
    }

    public static Intent t(Y6 y6, String str) {
        Intent intent = new Intent(Intents.Scan.ACTION);
        intent.addFlags(524288);
        intent.putExtra(Intents.Scan.RESULT, y6.toString());
        intent.putExtra(Intents.Scan.RESULT_FORMAT, y6.a().toString());
        byte[] bArrC = y6.c();
        if (bArrC != null && bArrC.length > 0) {
            intent.putExtra(Intents.Scan.RESULT_BYTES, bArrC);
        }
        Map mapD = y6.d();
        if (mapD != null) {
            ResultMetadataType resultMetadataType = ResultMetadataType.UPC_EAN_EXTENSION;
            if (mapD.containsKey(resultMetadataType)) {
                intent.putExtra(Intents.Scan.RESULT_UPC_EAN_EXTENSION, mapD.get(resultMetadataType).toString());
            }
            Number number = (Number) mapD.get(ResultMetadataType.ORIENTATION);
            if (number != null) {
                intent.putExtra(Intents.Scan.RESULT_ORIENTATION, number.intValue());
            }
            String str2 = (String) mapD.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
            if (str2 != null) {
                intent.putExtra(Intents.Scan.RESULT_ERROR_CORRECTION_LEVEL, str2);
            }
            Iterable iterable = (Iterable) mapD.get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                Iterator it = iterable.iterator();
                int i = 0;
                while (it.hasNext()) {
                    intent.putExtra(Intents.Scan.RESULT_BYTE_SEGMENTS_PREFIX + i, (byte[]) it.next());
                    i++;
                }
            }
        }
        if (str != null) {
            intent.putExtra(Intents.Scan.RESULT_BARCODE_IMAGE_PATH, str);
        }
        return intent;
    }

    public void g() {
        if (this.b.getBarcodeView().s()) {
            j();
        } else {
            this.i = true;
        }
        this.b.f();
        this.f.cancel();
    }

    public void h() {
        this.b.b(this.j);
    }

    public void i() {
        if (this.a.isFinishing() || this.e || this.i) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getString(R.string.zxing_app_name));
        builder.setMessage(this.a.getString(R.string.zxing_msg_camera_framework_bug));
        builder.setPositiveButton(R.string.zxing_button_ok, new e());
        builder.setOnCancelListener(new f());
        builder.show();
    }

    public final void j() {
        this.a.finish();
    }

    public final String k(Y6 y6) {
        if (this.d) {
            Bitmap bitmapB = y6.b();
            try {
                File fileCreateTempFile = File.createTempFile("barcodeimage", ".jpg", this.a.getCacheDir());
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                bitmapB.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                return fileCreateTempFile.getAbsolutePath();
            } catch (IOException e2) {
                Log.w(m, "Unable to create temporary file and store bitmap! " + e2);
            }
        }
        return null;
    }

    public void l(Intent intent, Bundle bundle) {
        this.a.getWindow().addFlags(128);
        if (bundle != null) {
            this.c = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra(Intents.Scan.ORIENTATION_LOCKED, true)) {
                m();
            }
            if (Intents.Scan.ACTION.equals(intent.getAction())) {
                this.b.e(intent);
            }
            if (!intent.getBooleanExtra(Intents.Scan.BEEP_ENABLED, true)) {
                this.g.setBeepEnabled(false);
            }
            if (intent.hasExtra(Intents.Scan.TIMEOUT)) {
                this.h.postDelayed(new d(), intent.getLongExtra(Intents.Scan.TIMEOUT, 0L));
            }
            if (intent.getBooleanExtra(Intents.Scan.BARCODE_IMAGE_ENABLED, false)) {
                this.d = true;
            }
        }
    }

    public void m() {
        if (this.c == -1) {
            int rotation = this.a.getWindowManager().getDefaultDisplay().getRotation();
            int i = this.a.getResources().getConfiguration().orientation;
            int i2 = 0;
            if (i == 2) {
                if (rotation != 0 && rotation != 1) {
                    i2 = 8;
                }
            } else if (i == 1) {
                i2 = (rotation == 0 || rotation == 3) ? 1 : 9;
            }
            this.c = i2;
        }
        this.a.setRequestedOrientation(this.c);
    }

    public void n() {
        this.e = true;
        this.f.cancel();
        this.h.removeCallbacksAndMessages(null);
    }

    public void o() {
        this.f.cancel();
        this.b.g();
    }

    public void p(int i, String[] strArr, int[] iArr) {
        if (i == n) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                i();
            } else {
                this.b.h();
            }
        }
    }

    public void q() {
        if (Build.VERSION.SDK_INT >= 23) {
            s();
        } else {
            this.b.h();
        }
        this.f.start();
    }

    public void r(Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.c);
    }

    public final void s() {
        if (ContextCompat.checkSelfPermission(this.a, "android.permission.CAMERA") == 0) {
            this.b.h();
        } else {
            if (this.l) {
                return;
            }
            ActivityCompat.requestPermissions(this.a, new String[]{"android.permission.CAMERA"}, n);
            this.l = true;
        }
    }

    public void u(Y6 y6) {
        this.a.setResult(-1, t(y6, k(y6)));
        g();
    }

    public void v() {
        Intent intent = new Intent(Intents.Scan.ACTION);
        intent.putExtra(Intents.Scan.TIMEOUT, true);
        this.a.setResult(0, intent);
        g();
    }
}
