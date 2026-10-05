package defpackage;

import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.internal.auth.zzbd;

/* JADX INFO: renamed from: h70, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class BinderC2336h70 extends zzbd {
    public final /* synthetic */ C3369m70 a;

    public BinderC2336h70(C3369m70 c3369m70) {
        this.a = c3369m70;
    }

    @Override // com.google.android.gms.internal.auth.zzbd, com.google.android.gms.internal.auth.zzbg
    public final void zzb(ProxyResponse proxyResponse) {
        this.a.setResult(new A70(proxyResponse));
    }
}
