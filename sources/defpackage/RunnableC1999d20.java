package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zact;

/* JADX INFO: renamed from: d20, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC1999d20 implements Runnable {
    public final /* synthetic */ zact a;

    public RunnableC1999d20(zact zactVar) {
        this.a = zactVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.zah.zae(new ConnectionResult(4));
    }
}
