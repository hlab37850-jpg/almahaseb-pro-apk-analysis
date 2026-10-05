package defpackage;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class W10 implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {
    public final Api.Client a;
    public final ApiKey b;
    public IAccountAccessor c = null;
    public Set d = null;
    public boolean e = false;
    public final /* synthetic */ GoogleApiManager f;

    public W10(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.f = googleApiManager;
        this.a = client;
        this.b = apiKey;
    }

    public final void e() {
        IAccountAccessor iAccountAccessor;
        if (!this.e || (iAccountAccessor = this.c) == null) {
            return;
        }
        this.a.getRemoteService(iAccountAccessor, this.d);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        this.f.zar.post(new V10(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zae(ConnectionResult connectionResult) {
        zabq zabqVar = (zabq) this.f.zan.get(this.b);
        if (zabqVar != null) {
            zabqVar.zas(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zaf(IAccountAccessor iAccountAccessor, Set set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zae(new ConnectionResult(4));
        } else {
            this.c = iAccountAccessor;
            this.d = set;
            e();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    public final void zag(int i) {
        zabq zabqVar = (zabq) this.f.zan.get(this.b);
        if (zabqVar != null) {
            if (zabqVar.zaj) {
                zabqVar.zas(new ConnectionResult(17));
            } else {
                zabqVar.onConnectionSuspended(i);
            }
        }
    }
}
