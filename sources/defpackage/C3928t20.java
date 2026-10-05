package defpackage;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: renamed from: t20, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3928t20 extends BasePendingResult {
    public final Result a;

    public C3928t20(Result result) {
        super(Looper.getMainLooper());
        this.a = result;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        if (status.getStatusCode() == this.a.getStatus().getStatusCode()) {
            return this.a;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
