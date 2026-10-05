package defpackage;

import com.google.android.gms.tasks.zzac;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: m40, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3363m40 implements InterfaceC3770r40 {
    public final CountDownLatch a = new CountDownLatch(1);

    public /* synthetic */ C3363m40(zzac zzacVar) {
    }

    public final void a() throws InterruptedException {
        this.a.await();
    }

    public final boolean b(long j, TimeUnit timeUnit) {
        return this.a.await(j, timeUnit);
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.a.countDown();
    }
}
