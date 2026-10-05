package defpackage;

import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.signin.internal.zak;

/* JADX INFO: renamed from: e20, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC2080e20 implements Runnable {
    public final /* synthetic */ zak a;
    public final /* synthetic */ zact b;

    public RunnableC2080e20(zact zactVar, zak zakVar) {
        this.b = zactVar;
        this.a = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zact.zad(this.b, this.a);
    }
}
