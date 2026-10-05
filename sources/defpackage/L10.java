package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zabe;

/* JADX INFO: loaded from: classes2.dex */
public final class L10 implements GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ StatusPendingResult a;

    public L10(zabe zabeVar, StatusPendingResult statusPendingResult) {
        this.a = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.a.setResult(new Status(8));
    }
}
