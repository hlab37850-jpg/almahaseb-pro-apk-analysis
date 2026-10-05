package com.google.common.collect;

import androidx.core.location.LocationRequestCompat;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import defpackage.AbstractC1163Zb;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class DiscreteDomain<C extends Comparable> {
    final boolean supportsFastOffset;

    public static final class b extends DiscreteDomain implements Serializable {
        public static final b a = new b();
        public static final BigInteger b = BigInteger.valueOf(Long.MIN_VALUE);
        public static final BigInteger c = BigInteger.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);

        public b() {
            super(true);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public long distance(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(b).min(c).longValue();
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public BigInteger next(BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigInteger offset(BigInteger bigInteger, long j) {
            AbstractC1163Zb.c(j, "distance");
            return bigInteger.add(BigInteger.valueOf(j));
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public BigInteger previous(BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }

    public static final class c extends DiscreteDomain implements Serializable {
        public static final c a = new c();

        public c() {
            super(true);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public long distance(Integer num, Integer num2) {
            return ((long) num2.intValue()) - ((long) num.intValue());
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer minValue() {
            return Integer.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Integer next(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue + 1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Integer offset(Integer num, long j) {
            AbstractC1163Zb.c(j, "distance");
            return Integer.valueOf(Ints.checkedCast(num.longValue() + j));
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Integer previous(Integer num) {
            int iIntValue = num.intValue();
            if (iIntValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(iIntValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    public static final class d extends DiscreteDomain implements Serializable {
        public static final d a = new d();

        public d() {
            super(true);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public long distance(Long l, Long l2) {
            long jLongValue = l2.longValue() - l.longValue();
            if (l2.longValue() > l.longValue() && jLongValue < 0) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
            if (l2.longValue() >= l.longValue() || jLongValue <= 0) {
                return jLongValue;
            }
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Long maxValue() {
            return Long.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Long minValue() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Long next(Long l) {
            long jLongValue = l.longValue();
            if (jLongValue == LocationRequestCompat.PASSIVE_INTERVAL) {
                return null;
            }
            return Long.valueOf(jLongValue + 1);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Long offset(Long l, long j) {
            AbstractC1163Zb.c(j, "distance");
            long jLongValue = l.longValue() + j;
            if (jLongValue < 0) {
                Preconditions.checkArgument(l.longValue() < 0, "overflow");
            }
            return Long.valueOf(jLongValue);
        }

        @Override // com.google.common.collect.DiscreteDomain
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Long previous(Long l) {
            long jLongValue = l.longValue();
            if (jLongValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(jLongValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return b.a;
    }

    public static DiscreteDomain<Integer> integers() {
        return c.a;
    }

    public static DiscreteDomain<Long> longs() {
        return d.a;
    }

    public abstract long distance(C c2, C c3);

    @CanIgnoreReturnValue
    public C maxValue() {
        throw new NoSuchElementException();
    }

    @CanIgnoreReturnValue
    public C minValue() {
        throw new NoSuchElementException();
    }

    public abstract C next(C c2);

    public C offset(C c2, long j) {
        AbstractC1163Zb.c(j, "distance");
        C c3 = c2;
        for (long j2 = 0; j2 < j; j2++) {
            c3 = (C) next(c3);
            if (c3 == null) {
                String strValueOf = String.valueOf(c2);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 51);
                sb.append("overflowed computing offset(");
                sb.append(strValueOf);
                sb.append(", ");
                sb.append(j);
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return c3;
    }

    public abstract C previous(C c2);

    public DiscreteDomain() {
        this(false);
    }

    private DiscreteDomain(boolean z) {
        this.supportsFastOffset = z;
    }
}
