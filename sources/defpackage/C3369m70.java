package defpackage;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.auth.zzbh;
import com.google.android.gms.internal.auth.zzbt;

/* JADX INFO: renamed from: m70, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3369m70 extends N60 {
    public final /* synthetic */ ProxyRequest a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3369m70(zzbt zzbtVar, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        super(googleApiClient);
        this.a = proxyRequest;
    }

    @Override // defpackage.N60
    public final void a(Context context, zzbh zzbhVar) {
        zzbhVar.zze(new BinderC2336h70(this), this.a);
    }
}
