package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class H10 implements GoogleApiClient.ConnectionCallbacks {
    public final /* synthetic */ AtomicReference a;
    public final /* synthetic */ StatusPendingResult b;
    public final /* synthetic */ zabe c;

    public H10(zabe zabeVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.c = zabeVar;
        this.a = atomicReference;
        this.b = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.c.zam((GoogleApiClient) Preconditions.checkNotNull((GoogleApiClient) this.a.get()), this.b, true);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }
}
