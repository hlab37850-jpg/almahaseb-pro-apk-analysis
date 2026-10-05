package defpackage;

import com.google.android.gms.common.api.internal.a;

/* JADX INFO: loaded from: classes2.dex */
public final class R20 implements Runnable {
    public final /* synthetic */ a a;

    public R20(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.m.lock();
        try {
            a.p(this.a);
        } finally {
            this.a.m.unlock();
        }
    }
}
