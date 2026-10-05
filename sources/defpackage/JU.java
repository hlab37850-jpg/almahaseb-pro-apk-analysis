package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class JU {
    public static final b d = new b(null);
    public static final JU e = new a();
    public boolean a;
    public long b;
    public long c;

    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public b() {
        }
    }

    public JU a() {
        this.a = false;
        return this;
    }

    public JU b() {
        this.c = 0L;
        return this;
    }

    public long c() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public JU d(long j) {
        this.a = true;
        this.b = j;
        return this;
    }

    public boolean e() {
        return this.a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public JU g(long j, TimeUnit timeUnit) {
        AbstractC4492zt.h(timeUnit, "unit");
        if (j >= 0) {
            this.c = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j).toString());
    }

    public long h() {
        return this.c;
    }

    public static final class a extends JU {
        @Override // defpackage.JU
        public JU g(long j, TimeUnit timeUnit) {
            AbstractC4492zt.h(timeUnit, "unit");
            return this;
        }

        @Override // defpackage.JU
        public JU d(long j) {
            return this;
        }

        @Override // defpackage.JU
        public void f() {
        }
    }
}
