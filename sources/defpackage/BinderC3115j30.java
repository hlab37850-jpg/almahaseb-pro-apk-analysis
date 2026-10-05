package defpackage;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.internal.zba;
import com.google.android.gms.auth.api.signin.internal.zbn;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: j30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC3115j30 extends zba {
    public final /* synthetic */ C3279l30 a;

    public BinderC3115j30(C3279l30 c3279l30) {
        this.a = c3279l30;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void zbd(GoogleSignInAccount googleSignInAccount, Status status) {
        if (googleSignInAccount != null) {
            zbn.zbc(this.a.a).zbe(this.a.b, googleSignInAccount);
        }
        this.a.setResult(new GoogleSignInResult(googleSignInAccount, status));
    }
}
