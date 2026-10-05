package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class D20 {
    public final int a;
    public final ConnectionResult b;

    public D20(ConnectionResult connectionResult, int i) {
        Preconditions.checkNotNull(connectionResult);
        this.b = connectionResult;
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public final ConnectionResult b() {
        return this.b;
    }
}
