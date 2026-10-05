package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import info.aalmoghalis.inventory.R;
import info.aalmoghalis.inventory.activity.FragmentStatePagerSupport_Main;
import info.aalmoghalis.inventory.activity.LoginActivity;

/* JADX INFO: renamed from: Am, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0345Am extends FingerprintManager.AuthenticationCallback {
    public Context a;

    public C0345Am(Context context) {
        this.a = context;
    }

    public final void a() {
        this.a.startActivity(new Intent(this.a, (Class<?>) FragmentStatePagerSupport_Main.class));
        Context context = this.a;
        if (context instanceof LoginActivity) {
            ((LoginActivity) context).finish();
        }
    }

    public void b(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject) {
        CancellationSignal cancellationSignal = new CancellationSignal();
        if (ContextCompat.checkSelfPermission(this.a, "android.permission.USE_FINGERPRINT") != 0) {
            return;
        }
        fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
    }

    public void c(String str, Boolean bool) {
        TextView textView = (TextView) ((Activity) this.a).findViewById(R.id.errorText);
        textView.setText(str);
        if (bool.booleanValue()) {
            textView.setTextColor(ContextCompat.getColor(this.a, R.color.green));
            Z00.V = "1";
            a();
        }
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence charSequence) {
        c("Fingerprint Authentication error\n" + ((Object) charSequence), Boolean.FALSE);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationFailed() {
        c(this.a.getString(R.string.finger_login_err), Boolean.FALSE);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationHelp(int i, CharSequence charSequence) {
        c("Fingerprint Authentication help\n" + ((Object) charSequence), Boolean.FALSE);
    }

    @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
        c(this.a.getString(R.string.finger_login_succ), Boolean.TRUE);
    }
}
