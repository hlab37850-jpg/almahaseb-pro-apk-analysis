package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.location.zzbq;

/* JADX INFO: renamed from: k40, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3199k40 extends AbstractC3609p40 {
    public final /* synthetic */ zzbq a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3199k40(zzaf zzafVar, GoogleApiClient googleApiClient, zzbq zzbqVar) {
        super(googleApiClient);
        this.a = zzbqVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzw(this.a, this);
    }
}
