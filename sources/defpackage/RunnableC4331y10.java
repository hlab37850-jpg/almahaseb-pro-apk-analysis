package defpackage;

import com.google.android.gms.common.api.internal.zaaw;

/* JADX INFO: renamed from: y10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC4331y10 implements Runnable {
    public final /* synthetic */ zaaw a;

    public RunnableC4331y10(zaaw zaawVar) {
        this.a = zaawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zaaw zaawVar = this.a;
        zaawVar.zad.cancelAvailabilityErrorNotifications(zaawVar.zac);
    }
}
