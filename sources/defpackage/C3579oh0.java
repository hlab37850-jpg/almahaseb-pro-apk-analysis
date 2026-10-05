package defpackage;

import android.location.Location;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzz;

/* JADX INFO: renamed from: oh0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3579oh0 extends zi0 {
    public final /* synthetic */ Location a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3579oh0(zzz zzzVar, GoogleApiClient googleApiClient, Location location) {
        super(googleApiClient);
        this.a = location;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzJ(this.a);
        setResult(Status.RESULT_SUCCESS);
    }
}
