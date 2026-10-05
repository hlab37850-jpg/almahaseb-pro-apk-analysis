package defpackage;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zabe;

/* JADX INFO: loaded from: classes2.dex */
public final class M10 implements ResultCallback {
    public final /* synthetic */ StatusPendingResult a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ GoogleApiClient c;
    public final /* synthetic */ zabe d;

    public M10(zabe zabeVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.d = zabeVar;
        this.a = statusPendingResult;
        this.b = z;
        this.c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void onResult(Result result) {
        Status status = (Status) result;
        Storage.getInstance(this.d.zan).zac();
        if (status.isSuccess() && this.d.isConnected()) {
            zabe zabeVar = this.d;
            zabeVar.disconnect();
            zabeVar.connect();
        }
        this.a.setResult(status);
        if (this.b) {
            this.c.disconnect();
        }
    }
}
