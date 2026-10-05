package defpackage;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.location.GeofencingRequest;

/* JADX INFO: renamed from: e40, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2084e40 extends AbstractC3609p40 {
    public final /* synthetic */ GeofencingRequest a;
    public final /* synthetic */ PendingIntent b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2084e40(zzaf zzafVar, GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.a = geofencingRequest;
        this.b = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzv(this.a, this.b, this);
    }
}
