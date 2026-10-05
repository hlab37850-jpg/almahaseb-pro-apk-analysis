package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzz;
import com.google.android.gms.location.LocationCallback;

/* JADX INFO: renamed from: bh0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1816bh0 extends zi0 {
    public final /* synthetic */ LocationCallback a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1816bh0(zzz zzzVar, GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        super(googleApiClient);
        this.a = locationCallback;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzaz) anyClient).zzH(ListenerHolders.createListenerKey(this.a, LocationCallback.class.getSimpleName()), new Ei0(this));
    }
}
