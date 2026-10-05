package info.aalmoghalis.inventory.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import defpackage.AbstractC0637Jw;
import defpackage.AbstractC0707Kw;
import defpackage.AbstractC0897Rw;
import defpackage.AbstractC0923Sw;
import defpackage.AbstractC0949Tw;
import defpackage.AbstractC4158vt;
import defpackage.C0345Am;
import defpackage.C2160f10;
import defpackage.C2243g2;
import defpackage.Z00;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.lang.BaseActivity;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes3.dex */
public class LoginActivity extends BaseActivity implements C2160f10.g {
    public SQLiteDatabase c;
    public Z00 d;
    public KeyStore e;
    public Cipher f;
    public C2243g2 g;
    public Handler h = new c();
    public Dialog i = null;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginActivity.this.x();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginActivity.this.D();
        }
    }

    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.d("mProgress=f=", message.obj + "");
            message.obj.toString().equals("20");
            LoginActivity.this.E(false);
        }
    }

    private void C() {
        startActivity(new Intent(this, (Class<?>) FragmentStatePagerSupport_Main.class));
        finish();
    }

    public void A() {
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
        int i = Build.VERSION.SDK_INT;
        FingerprintManager fingerprintManagerA = i >= 23 ? AbstractC0637Jw.a(getSystemService("fingerprint")) : null;
        if (i >= 23) {
            if (!fingerprintManagerA.isHardwareDetected()) {
                this.g.f.setText("Your Device does not have a Fingerprint Sensor");
                return;
            }
            if (ContextCompat.checkSelfPermission(this, "android.permission.USE_FINGERPRINT") != 0) {
                this.g.f.setText("Fingerprint authentication permission not enabled");
                return;
            }
            if (!fingerprintManagerA.hasEnrolledFingerprints()) {
                this.g.f.setText("Register at least one fingerprint in Settings");
                return;
            }
            if (!keyguardManager.isKeyguardSecure()) {
                this.g.f.setText("Lock screen security not enabled in Settings");
                return;
            }
            B();
            if (z()) {
                AbstractC0707Kw.a();
                new C0345Am(this).b(fingerprintManagerA, AbstractC0949Tw.a(this.f));
            }
        }
    }

    public void B() {
        try {
            this.e = KeyStore.getInstance("AndroidKeyStore");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            try {
                this.e.load(null);
                AbstractC0923Sw.a();
                keyGenerator.init(AbstractC0897Rw.a("inv_key", 3).setBlockModes("CBC").setUserAuthenticationRequired(true).setEncryptionPaddings("PKCS7Padding").build());
                keyGenerator.generateKey();
            } catch (IOException | InvalidAlgorithmParameterException | NoSuchAlgorithmException | CertificateException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchProviderException e3) {
            throw new RuntimeException("Failed to get KeyGenerator instance", e3);
        }
    }

    public void D() {
        C2160f10 c2160f10 = new C2160f10(this.d, this, this);
        if (!AbstractC4158vt.a(this)) {
            Toast.makeText(this, getString(R.string.no_internet), 0).show();
            return;
        }
        this.d.Sb();
        Z00.T = this.d.ia("PREF_ACCOUNT_NAME", "0");
        if (this.d.ia("PREF_ACCOUNT_NAME", "0").equals("0")) {
            Toast.makeText(this, getString(R.string.no_email), 0).show();
        } else {
            E(true);
            c2160f10.o("-1", "0", this.h);
        }
    }

    public void E(boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setView(((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.progress, (ViewGroup) null));
            if (z) {
                AlertDialog alertDialogCreate = builder.create();
                this.i = alertDialogCreate;
                alertDialogCreate.setCancelable(false);
                this.i.show();
            } else {
                Dialog dialog = this.i;
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.C2160f10.g
    public void d(int i, int i2, String str) {
        Log.d("reset=", i + ":" + i2 + ":" + str);
        if (i2 != 3 || this.d.ia("reset_user_id", "").equals("")) {
            this.g.e.setText(str);
            return;
        }
        new C2160f10(this.d).a0();
        new C2160f10(this.d, this).o(String.valueOf(i), "2", null);
        new C2160f10(this.d, this).g(i, this.g.j);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Process.killProcess(Process.myPid());
    }

    @Override // info.aalmoghalis.inventory.lang.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2243g2 c2243g2C = C2243g2.c(getLayoutInflater());
        this.g = c2243g2C;
        setContentView(c2243g2C.getRoot());
        try {
            this.g.d.setOnClickListener(new a());
            TextView textView = this.g.g;
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            this.g.e.setTextColor(SupportMenu.CATEGORY_MASK);
            this.g.g.setOnClickListener(new b());
        } catch (Exception unused) {
        }
        Z00 z00 = new Z00(this.c, this);
        this.d = z00;
        if (!z00.ia("reset_user_id", "").equals("")) {
            y();
        }
        try {
            A();
        } catch (Exception e) {
            Log.d("login_err=", e.getMessage() + "");
            e.printStackTrace();
        }
        getWindow().setSoftInputMode(4);
        this.g.j.requestFocus();
    }

    public final void x() {
        this.g.j.setError(null);
        if (this.g.j.getText().toString().equals(Z00.W)) {
            Z00.V = "1";
            C();
        } else {
            this.g.j.setError(getString(R.string.error_invalid_password));
            this.g.j.requestFocus();
            ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.g.j, 0);
        }
    }

    public void y() {
        C2160f10 c2160f10 = new C2160f10(this.d, this, this);
        Log.d("check_confirm=", "c1");
        if (AbstractC4158vt.a(this)) {
            this.d.Sb();
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            long j = Long.parseLong(this.d.ia("reset_expire", "0"));
            Log.d("check_confirm=", "c2:" + timeInMillis + ":" + j);
            if (timeInMillis >= j) {
                c2160f10.a0();
                return;
            }
            int i = Integer.parseInt(this.d.ia("reset_check", "0"));
            long j2 = ((long) (60000 * i)) + timeInMillis;
            long j3 = Long.parseLong(this.d.ia("reset_next", "0"));
            Log.d("check_confirm=", "c3:" + j3 + ":" + j2 + ":" + i);
            if (j3 <= 0 || timeInMillis >= j3) {
                this.d.Lc("reset_next", j2 + "");
                E(true);
                c2160f10.o("-1", "0", this.h);
            }
        }
    }

    public boolean z() {
        try {
            this.f = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                this.e.load(null);
                this.f.init(1, (SecretKey) this.e.getKey("inv_key", null));
                return true;
            } catch (KeyPermanentlyInvalidatedException unused) {
                return false;
            } catch (IOException e) {
                e = e;
                throw new RuntimeException("Failed to init Cipher", e);
            } catch (InvalidKeyException e2) {
                e = e2;
                throw new RuntimeException("Failed to init Cipher", e);
            } catch (KeyStoreException e3) {
                e = e3;
                throw new RuntimeException("Failed to init Cipher", e);
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                throw new RuntimeException("Failed to init Cipher", e);
            } catch (UnrecoverableKeyException e5) {
                e = e5;
                throw new RuntimeException("Failed to init Cipher", e);
            } catch (CertificateException e6) {
                e = e6;
                throw new RuntimeException("Failed to init Cipher", e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e7) {
            throw new RuntimeException("Failed to get Cipher", e7);
        }
    }
}
