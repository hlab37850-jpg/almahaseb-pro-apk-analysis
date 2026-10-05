package defpackage;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000authapi.zbd;
import com.google.android.gms.internal.p000authapi.zbe;

/* JADX INFO: renamed from: i30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC2410i30 extends zbd {
    public final /* synthetic */ C3197k30 a;

    public BinderC2410i30(C3197k30 c3197k30) {
        this.a = c3197k30;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbd, com.google.android.gms.internal.p000authapi.zbs
    public final void zbb(Status status, Credential credential) {
        this.a.setResult(new zbe(status, credential));
    }

    @Override // com.google.android.gms.internal.p000authapi.zbd, com.google.android.gms.internal.p000authapi.zbs
    public final void zbc(Status status) {
        this.a.setResult(new zbe(status, null));
    }
}
