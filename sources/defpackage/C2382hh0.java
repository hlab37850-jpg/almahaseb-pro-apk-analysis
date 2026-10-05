package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzz;

/* JADX INFO: renamed from: hh0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2382hh0 extends zi0 {
    public final /* synthetic */ boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2382hh0(zzz zzzVar, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient);
        this.a = z;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzI(this.a);
        setResult(Status.RESULT_SUCCESS);
    }
}
