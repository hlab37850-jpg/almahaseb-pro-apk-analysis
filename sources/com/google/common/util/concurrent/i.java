package com.google.common.util.concurrent;

import com.google.common.math.LongMath;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends RateLimiter {
    public double a;
    public double b;
    public double c;
    public long d;

    public static final class b extends i {
        public final double e;

        public b(RateLimiter.a aVar, double d) {
            super(aVar);
            this.e = d;
        }

        @Override // com.google.common.util.concurrent.i
        public double a() {
            return this.c;
        }

        @Override // com.google.common.util.concurrent.i
        public void b(double d, double d2) {
            double d3 = this.b;
            double d4 = this.e * d;
            this.b = d4;
            if (d3 == Double.POSITIVE_INFINITY) {
                this.a = d4;
            } else {
                this.a = d3 != 0.0d ? (this.a * d4) / d3 : 0.0d;
            }
        }

        @Override // com.google.common.util.concurrent.i
        public long d(double d, double d2) {
            return 0L;
        }
    }

    public static final class c extends i {
        public final long e;
        public double f;
        public double g;
        public double h;

        public c(RateLimiter.a aVar, long j, TimeUnit timeUnit, double d) {
            super(aVar);
            this.e = timeUnit.toMicros(j);
            this.h = d;
        }

        @Override // com.google.common.util.concurrent.i
        public double a() {
            return this.e / this.b;
        }

        @Override // com.google.common.util.concurrent.i
        public void b(double d, double d2) {
            double d3 = this.b;
            double d4 = this.h * d2;
            long j = this.e;
            double d5 = (j * 0.5d) / d2;
            this.g = d5;
            double d6 = ((j * 2.0d) / (d2 + d4)) + d5;
            this.b = d6;
            this.f = (d4 - d2) / (d6 - d5);
            if (d3 == Double.POSITIVE_INFINITY) {
                this.a = 0.0d;
                return;
            }
            if (d3 != 0.0d) {
                d6 = (this.a * d6) / d3;
            }
            this.a = d6;
        }

        @Override // com.google.common.util.concurrent.i
        public long d(double d, double d2) {
            long jE;
            double d3 = d - this.g;
            if (d3 > 0.0d) {
                double dMin = Math.min(d3, d2);
                jE = (long) (((e(d3) + e(d3 - dMin)) * dMin) / 2.0d);
                d2 -= dMin;
            } else {
                jE = 0;
            }
            return jE + ((long) (this.c * d2));
        }

        public final double e(double d) {
            return this.c + (d * this.f);
        }
    }

    public abstract double a();

    public abstract void b(double d, double d2);

    public void c(long j) {
        long j2 = this.d;
        if (j > j2) {
            this.a = Math.min(this.b, this.a + ((j - j2) / a()));
            this.d = j;
        }
    }

    public abstract long d(double d, double d2);

    @Override // com.google.common.util.concurrent.RateLimiter
    public final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1L) / this.c;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final void doSetRate(double d, long j) {
        c(j);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d;
        this.c = micros;
        b(d, micros);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long queryEarliestAvailable(long j) {
        return this.d;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long reserveEarliestAvailable(int i, long j) {
        c(j);
        long j2 = this.d;
        double d = i;
        double dMin = Math.min(d, this.a);
        this.d = LongMath.saturatedAdd(this.d, d(this.a, dMin) + ((long) ((d - dMin) * this.c)));
        this.a -= dMin;
        return j2;
    }

    public i(RateLimiter.a aVar) {
        super(aVar);
        this.d = 0L;
    }
}
