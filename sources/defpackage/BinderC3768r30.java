package defpackage;

import com.google.android.gms.auth.api.signin.internal.zba;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: r30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC3768r30 extends zba {
    public final /* synthetic */ C3930t30 a;

    public BinderC3768r30(C3930t30 c3930t30) {
        this.a = c3930t30;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void zbb(Status status) {
        this.a.setResult(status);
    }
}
