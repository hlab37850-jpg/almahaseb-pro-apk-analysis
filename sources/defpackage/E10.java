package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zaas;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zae;

/* JADX INFO: loaded from: classes2.dex */
public final class E10 implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ zaaw a;

    public /* synthetic */ E10(zaaw zaawVar, zaas zaasVar) {
        this.a = zaawVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        ((zae) Preconditions.checkNotNull(this.a.zak)).zad(new D10(this.a));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.a.zab.lock();
        try {
            if (this.a.zaI(connectionResult)) {
                this.a.zaA();
                this.a.zaF();
            } else {
                this.a.zaD(connectionResult);
            }
        } finally {
            this.a.zab.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
