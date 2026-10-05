package defpackage;

import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzba;
import com.google.android.gms.internal.location.zzbj;
import com.google.android.gms.internal.location.zzz;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: loaded from: classes2.dex */
public final class Xh0 extends zi0 {
    public final /* synthetic */ LocationRequest a;
    public final /* synthetic */ LocationCallback b;
    public final /* synthetic */ Looper c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xh0(zzz zzzVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        super(googleApiClient);
        this.a = locationRequest;
        this.b = locationCallback;
        this.c = looper;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzB(zzba.zza(null, this.a), ListenerHolders.createListenerHolder(this.b, zzbj.zza(this.c), LocationCallback.class.getSimpleName()), new Ei0(this));
    }
}
