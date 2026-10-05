package defpackage;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000authapi.zbl;
import com.google.android.gms.internal.p000authapi.zbt;

/* JADX INFO: renamed from: q30, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3688q30 extends AbstractC4092v30 {
    public C3688q30(zbl zblVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // defpackage.AbstractC4092v30
    public final void a(Context context, zbt zbtVar) {
        zbtVar.zbf(new BinderC3849s30(this));
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
