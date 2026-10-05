package defpackage;

import androidx.work.WorkRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class K6 {
    public long a = 100;
    public long b = WorkRequest.MIN_BACKOFF_MILLIS;
    public int c = 2;
    public double d;
    public int e;

    public long a() {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(this.a);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(this.c);
        int i = this.e;
        this.e = i + 1;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf2.pow(i));
        if (this.d != 0.0d) {
            double dRandom = Math.random();
            BigInteger bigInteger = BigDecimal.valueOf(dRandom).multiply(BigDecimal.valueOf(this.d)).multiply(new BigDecimal(bigIntegerMultiply)).toBigInteger();
            bigIntegerMultiply = (((int) Math.floor(dRandom * 10.0d)) & 1) == 0 ? bigIntegerMultiply.subtract(bigInteger) : bigIntegerMultiply.add(bigInteger);
        }
        return bigIntegerMultiply.min(BigInteger.valueOf(this.b)).max(BigInteger.valueOf(this.a)).longValue();
    }

    public int b() {
        return this.e;
    }

    public void c() {
        this.e = 0;
    }

    public K6 d(double d) {
        if (d < 0.0d || d >= 1.0d) {
            throw new IllegalArgumentException("jitter must be between 0 and 1");
        }
        this.d = d;
        return this;
    }

    public K6 e(long j) {
        this.b = j;
        return this;
    }

    public K6 f(long j) {
        this.a = j;
        return this;
    }
}
