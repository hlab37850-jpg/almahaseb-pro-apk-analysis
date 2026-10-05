package defpackage;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zabq;

/* JADX INFO: loaded from: classes2.dex */
public final class V10 implements Runnable {
    public final /* synthetic */ ConnectionResult a;
    public final /* synthetic */ W10 b;

    public V10(W10 w10, ConnectionResult connectionResult) {
        this.b = w10;
        this.a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        W10 w10 = this.b;
        zabq zabqVar = (zabq) w10.f.zan.get(w10.b);
        if (zabqVar == null) {
            return;
        }
        if (!this.a.isSuccess()) {
            zabqVar.zar(this.a, null);
            return;
        }
        this.b.e = true;
        if (this.b.a.requiresSignIn()) {
            this.b.e();
            return;
        }
        try {
            W10 w11 = this.b;
            w11.a.getRemoteService(null, w11.a.getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            this.b.a.disconnect("Failed to get service from broker.");
            zabqVar.zar(new ConnectionResult(10), null);
        }
    }
}
