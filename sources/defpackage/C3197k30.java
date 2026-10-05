package defpackage;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000authapi.zbe;
import com.google.android.gms.internal.p000authapi.zbl;
import com.google.android.gms.internal.p000authapi.zbt;

/* JADX INFO: renamed from: k30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3197k30 extends AbstractC4092v30 {
    public final /* synthetic */ CredentialRequest a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3197k30(zbl zblVar, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        super(googleApiClient);
        this.a = credentialRequest;
    }

    @Override // defpackage.AbstractC4092v30
    public final void a(Context context, zbt zbtVar) {
        zbtVar.zbd(new BinderC2410i30(this), this.a);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zbe(status, null);
    }
}
