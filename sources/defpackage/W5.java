package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public class W5 extends JU {
    public static final a i = new a(null);
    public static final ReentrantLock j;
    public static final Condition k;
    public static final long l;
    public static final long m;
    public static W5 n;
    public boolean f;
    public W5 g;
    public long h;

    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final W5 c() throws InterruptedException {
            W5 w5 = W5.n;
            AbstractC4492zt.e(w5);
            W5 w6 = w5.g;
            if (w6 == null) {
                long jNanoTime = System.nanoTime();
                e().await(W5.l, TimeUnit.MILLISECONDS);
                W5 w7 = W5.n;
                AbstractC4492zt.e(w7);
                if (w7.g != null || System.nanoTime() - jNanoTime < W5.m) {
                    return null;
                }
                return W5.n;
            }
            long jY = w6.y(System.nanoTime());
            if (jY > 0) {
                e().await(jY, TimeUnit.NANOSECONDS);
                return null;
            }
            W5 w8 = W5.n;
            AbstractC4492zt.e(w8);
            w8.g = w6.g;
            w6.g = null;
            return w6;
        }

        public final boolean d(W5 w5) {
            ReentrantLock reentrantLockF = W5.i.f();
            reentrantLockF.lock();
            try {
                if (!w5.f) {
                    return false;
                }
                w5.f = false;
                for (W5 w6 = W5.n; w6 != null; w6 = w6.g) {
                    if (w6.g == w5) {
                        w6.g = w5.g;
                        w5.g = null;
                        return false;
                    }
                }
                return true;
            } finally {
                reentrantLockF.unlock();
            }
        }

        public final Condition e() {
            return W5.k;
        }

        public final ReentrantLock f() {
            return W5.j;
        }

        public final void g(W5 w5, long j, boolean z) {
            ReentrantLock reentrantLockF = W5.i.f();
            reentrantLockF.lock();
            try {
                if (w5.f) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                w5.f = true;
                if (W5.n == null) {
                    W5.n = new W5();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j != 0 && z) {
                    w5.h = Math.min(j, w5.c() - jNanoTime) + jNanoTime;
                } else if (j != 0) {
                    w5.h = j + jNanoTime;
                } else {
                    if (!z) {
                        throw new AssertionError();
                    }
                    w5.h = w5.c();
                }
                long jY = w5.y(jNanoTime);
                W5 w6 = W5.n;
                AbstractC4492zt.e(w6);
                while (w6.g != null) {
                    W5 w7 = w6.g;
                    AbstractC4492zt.e(w7);
                    if (jY < w7.y(jNanoTime)) {
                        break;
                    }
                    w6 = w6.g;
                    AbstractC4492zt.e(w6);
                }
                w5.g = w6.g;
                w6.g = w5;
                if (w6 == W5.n) {
                    W5.i.e().signal();
                }
                FW fw = FW.a;
                reentrantLockF.unlock();
            } catch (Throwable th) {
                reentrantLockF.unlock();
                throw th;
            }
        }

        public a() {
        }
    }

    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    a aVar = W5.i;
                    ReentrantLock reentrantLockF = aVar.f();
                    reentrantLockF.lock();
                    try {
                        W5 w5C = aVar.c();
                        if (w5C == W5.n) {
                            W5.n = null;
                            reentrantLockF.unlock();
                            return;
                        } else {
                            FW fw = FW.a;
                            reentrantLockF.unlock();
                            if (w5C != null) {
                                w5C.B();
                            }
                        }
                    } catch (Throwable th) {
                        reentrantLockF.unlock();
                        throw th;
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public static final class c implements LQ {
        public final /* synthetic */ LQ b;

        public c(LQ lq) {
            this.b = lq;
        }

        @Override // defpackage.LQ
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public W5 b() {
            return W5.this;
        }

        @Override // defpackage.LQ, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            W5 w5 = W5.this;
            LQ lq = this.b;
            w5.v();
            try {
                try {
                    lq.close();
                    FW fw = FW.a;
                    if (w5.w()) {
                        throw w5.p(null);
                    }
                } catch (IOException e) {
                    if (!w5.w()) {
                        throw e;
                    }
                    throw w5.p(e);
                }
            } catch (Throwable th) {
                w5.w();
                throw th;
            }
        }

        @Override // defpackage.LQ, java.io.Flushable
        public void flush() throws IOException {
            W5 w5 = W5.this;
            LQ lq = this.b;
            w5.v();
            try {
                try {
                    lq.flush();
                    FW fw = FW.a;
                    if (w5.w()) {
                        throw w5.p(null);
                    }
                } catch (IOException e) {
                    if (!w5.w()) {
                        throw e;
                    }
                    throw w5.p(e);
                }
            } catch (Throwable th) {
                w5.w();
                throw th;
            }
        }

        @Override // defpackage.LQ
        public void p(H8 h8, long j) throws IOException {
            AbstractC4492zt.h(h8, DublinCoreProperties.SOURCE);
            AbstractC2074e.b(h8.R(), 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                C3306lO c3306lO = h8.a;
                AbstractC4492zt.e(c3306lO);
                while (j2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    j2 += (long) (c3306lO.c - c3306lO.b);
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    } else {
                        c3306lO = c3306lO.f;
                        AbstractC4492zt.e(c3306lO);
                    }
                }
                W5 w5 = W5.this;
                LQ lq = this.b;
                w5.v();
                try {
                    try {
                        lq.p(h8, j2);
                        FW fw = FW.a;
                        if (w5.w()) {
                            throw w5.p(null);
                        }
                        j -= j2;
                    } catch (IOException e) {
                        if (!w5.w()) {
                            throw e;
                        }
                        throw w5.p(e);
                    }
                } catch (Throwable th) {
                    w5.w();
                    throw th;
                }
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.b + ')';
        }
    }

    public static final class d implements InterfaceC3309lR {
        public final /* synthetic */ InterfaceC3309lR b;

        public d(InterfaceC3309lR interfaceC3309lR) {
            this.b = interfaceC3309lR;
        }

        @Override // defpackage.InterfaceC3309lR
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public W5 b() {
            return W5.this;
        }

        @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            W5 w5 = W5.this;
            InterfaceC3309lR interfaceC3309lR = this.b;
            w5.v();
            try {
                try {
                    interfaceC3309lR.close();
                    FW fw = FW.a;
                    if (w5.w()) {
                        throw w5.p(null);
                    }
                } catch (IOException e) {
                    if (!w5.w()) {
                        throw e;
                    }
                    throw w5.p(e);
                }
            } catch (Throwable th) {
                w5.w();
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.b + ')';
        }

        @Override // defpackage.InterfaceC3309lR
        public long y(H8 h8, long j) throws IOException {
            AbstractC4492zt.h(h8, "sink");
            W5 w5 = W5.this;
            InterfaceC3309lR interfaceC3309lR = this.b;
            w5.v();
            try {
                try {
                    long jY = interfaceC3309lR.y(h8, j);
                    if (w5.w()) {
                        throw w5.p(null);
                    }
                    return jY;
                } catch (IOException e) {
                    if (w5.w()) {
                        throw w5.p(e);
                    }
                    throw e;
                }
            } catch (Throwable th) {
                w5.w();
                throw th;
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        AbstractC4492zt.g(conditionNewCondition, "newCondition(...)");
        k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        l = millis;
        m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final InterfaceC3309lR A(InterfaceC3309lR interfaceC3309lR) {
        AbstractC4492zt.h(interfaceC3309lR, DublinCoreProperties.SOURCE);
        return new d(interfaceC3309lR);
    }

    public final IOException p(IOException iOException) {
        return x(iOException);
    }

    public final void v() {
        long jH = h();
        boolean zE = e();
        if (jH != 0 || zE) {
            i.g(this, jH, zE);
        }
    }

    public final boolean w() {
        return i.d(this);
    }

    public IOException x(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long y(long j2) {
        return this.h - j2;
    }

    public final LQ z(LQ lq) {
        AbstractC4492zt.h(lq, "sink");
        return new c(lq);
    }

    public void B() {
    }
}
