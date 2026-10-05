package defpackage;

import com.google.android.gms.common.api.internal.zaaw;

/* JADX INFO: loaded from: classes2.dex */
public abstract class F10 implements Runnable {
    public final /* synthetic */ zaaw a;

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        this.a.zab.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    a();
                }
            } catch (RuntimeException e) {
                this.a.zaa.zam(e);
            }
        } finally {
            this.a.zab.unlock();
        }
    }
}
