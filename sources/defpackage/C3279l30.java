package defpackage;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.auth.api.signin.internal.zbe;
import com.google.android.gms.auth.api.signin.internal.zbs;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: l30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3279l30 extends AbstractC4011u30 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ GoogleSignInOptions b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3279l30(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        super(googleApiClient);
        this.a = context;
        this.b = googleSignInOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new GoogleSignInResult(null, status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zbs) ((zbe) anyClient).getService()).zbe(new BinderC3115j30(this), this.b);
    }
}
