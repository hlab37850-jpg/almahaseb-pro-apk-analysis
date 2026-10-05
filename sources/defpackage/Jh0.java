package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzbj;
import com.google.android.gms.internal.location.zzz;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

/* JADX INFO: loaded from: classes2.dex */
public final class Jh0 extends zi0 {
    public final /* synthetic */ LocationRequest a;
    public final /* synthetic */ LocationListener b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Jh0(zzz zzzVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        super(googleApiClient);
        this.a = locationRequest;
        this.b = locationListener;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzC(this.a, ListenerHolders.createListenerHolder(this.b, zzbj.zzb(), LocationListener.class.getSimpleName()), new Ei0(this));
    }
}
