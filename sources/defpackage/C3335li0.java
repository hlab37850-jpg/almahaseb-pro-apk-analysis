package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzz;
import com.google.android.gms.location.LocationListener;

/* JADX INFO: renamed from: li0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3335li0 extends zi0 {
    public final /* synthetic */ LocationListener a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3335li0(zzz zzzVar, GoogleApiClient googleApiClient, LocationListener locationListener) {
        super(googleApiClient);
        this.a = locationListener;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzF(ListenerHolders.createListenerKey(this.a, LocationListener.class.getSimpleName()), new Ei0(this));
    }
}
