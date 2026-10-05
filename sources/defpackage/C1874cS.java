package defpackage;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: renamed from: cS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1874cS {
    public final HandlerThread a;
    public final InterfaceC2421i9 b;
    public final Handler c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public int l;
    public int m;
    public int n;

    /* JADX INFO: renamed from: cS$a */
    public static class a extends Handler {
        public final C1874cS a;

        /* JADX INFO: renamed from: cS$a$a, reason: collision with other inner class name */
        public class RunnableC0166a implements Runnable {
            public final /* synthetic */ Message a;

            public RunnableC0166a(Message message) {
                this.a = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new AssertionError("Unhandled stats message." + this.a.what);
            }
        }

        public a(Looper looper, C1874cS c1874cS) {
            super(looper);
            this.a = c1874cS;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.a.j();
                return;
            }
            if (i == 1) {
                this.a.k();
                return;
            }
            if (i == 2) {
                this.a.h(message.arg1);
                return;
            }
            if (i == 3) {
                this.a.i(message.arg1);
            } else if (i != 4) {
                C4192wG.o.post(new RunnableC0166a(message));
            } else {
                this.a.l((Long) message.obj);
            }
        }
    }

    public C1874cS(InterfaceC2421i9 interfaceC2421i9) {
        this.b = interfaceC2421i9;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.a = handlerThread;
        handlerThread.start();
        AbstractC4047uX.j(handlerThread.getLooper());
        this.c = new a(handlerThread.getLooper(), this);
    }

    public static long g(int i, long j) {
        return j / ((long) i);
    }

    public C2032dS a() {
        return new C2032dS(this.b.a(), this.b.size(), this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }

    public void b(Bitmap bitmap) {
        m(bitmap, 2);
    }

    public void c(Bitmap bitmap) {
        m(bitmap, 3);
    }

    public void d() {
        this.c.sendEmptyMessage(0);
    }

    public void e() {
        this.c.sendEmptyMessage(1);
    }

    public void f(long j) {
        Handler handler = this.c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j)));
    }

    public void h(long j) {
        int i = this.m + 1;
        this.m = i;
        long j2 = this.g + j;
        this.g = j2;
        this.j = g(i, j2);
    }

    public void i(long j) {
        this.n++;
        long j2 = this.h + j;
        this.h = j2;
        this.k = g(this.m, j2);
    }

    public void j() {
        this.d++;
    }

    public void k() {
        this.e++;
    }

    public void l(Long l) {
        this.l++;
        long jLongValue = this.f + l.longValue();
        this.f = jLongValue;
        this.i = g(this.l, jLongValue);
    }

    public final void m(Bitmap bitmap, int i) {
        int iK = AbstractC4047uX.k(bitmap);
        Handler handler = this.c;
        handler.sendMessage(handler.obtainMessage(i, iK, 0));
    }
}
