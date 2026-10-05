package defpackage;

import com.google.android.gms.auth.api.signin.internal.zba;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: n30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC3443n30 extends zba {
    public final /* synthetic */ C3607p30 a;

    public BinderC3443n30(C3607p30 c3607p30) {
        this.a = c3607p30;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void zbc(Status status) {
        this.a.setResult(status);
    }
}
