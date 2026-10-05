package defpackage;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: renamed from: w20, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4171w20 extends BasePendingResult {
    public final Result a;

    public C4171w20(GoogleApiClient googleApiClient, Result result) {
        super(googleApiClient);
        this.a = result;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        return this.a;
    }
}
