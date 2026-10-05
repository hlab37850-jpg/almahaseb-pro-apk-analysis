package defpackage;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: fr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2229fr extends AN {
    public final Handler a;
    public final boolean b;

    /* JADX INFO: renamed from: fr$a */
    public static final class a extends AN.c {
        public final Handler a;
        public final boolean b;
        public volatile boolean c;

        public a(Handler handler, boolean z) {
            this.a = handler;
            this.b = z;
        }

        @Override // AN.c
        public InterfaceC0624Jj c(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.c) {
                return AbstractC0598Ij.a();
            }
            b bVar = new b(this.a, FM.o(runnable));
            Message messageObtain = Message.obtain(this.a, bVar);
            messageObtain.obj = this;
            if (this.b) {
                messageObtain.setAsynchronous(true);
            }
            this.a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.c) {
                return bVar;
            }
            this.a.removeCallbacks(bVar);
            return AbstractC0598Ij.a();
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            this.c = true;
            this.a.removeCallbacksAndMessages(this);
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.c;
        }
    }

    /* JADX INFO: renamed from: fr$b */
    public static final class b implements Runnable, InterfaceC0624Jj {
        public final Handler a;
        public final Runnable b;
        public volatile boolean c;

        public b(Handler handler, Runnable runnable) {
            this.a = handler;
            this.b = runnable;
        }

        @Override // defpackage.InterfaceC0624Jj
        public void dispose() {
            this.a.removeCallbacks(this);
            this.c = true;
        }

        @Override // defpackage.InterfaceC0624Jj
        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Throwable th) {
                FM.m(th);
            }
        }
    }

    public C2229fr(Handler handler, boolean z) {
        this.a = handler;
        this.b = z;
    }

    @Override // defpackage.AN
    public AN.c createWorker() {
        return new a(this.a, this.b);
    }

    @Override // defpackage.AN
    public InterfaceC0624Jj scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        b bVar = new b(this.a, FM.o(runnable));
        Message messageObtain = Message.obtain(this.a, bVar);
        if (this.b) {
            messageObtain.setAsynchronous(true);
        }
        this.a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
        return bVar;
    }
}
