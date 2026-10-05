package defpackage;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000authapi.zbl;
import com.google.android.gms.internal.p000authapi.zbt;
import com.google.android.gms.internal.p000authapi.zbu;

/* JADX INFO: renamed from: m30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3361m30 extends AbstractC4092v30 {
    public final /* synthetic */ Credential a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3361m30(zbl zblVar, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.a = credential;
    }

    @Override // defpackage.AbstractC4092v30
    public final void a(Context context, zbt zbtVar) {
        zbtVar.zbe(new BinderC3849s30(this), new zbu(this.a));
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
