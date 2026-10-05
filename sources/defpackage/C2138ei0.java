package defpackage;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzz;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: renamed from: ei0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2138ei0 extends zi0 {
    public final /* synthetic */ LocationRequest a;
    public final /* synthetic */ PendingIntent b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2138ei0(zzz zzzVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.a = locationRequest;
        this.b = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzE(this.a, this.b, new Ei0(this));
    }
}
