package com.google.common.math;

import androidx.compose.animation.core.AnimationKt;
import androidx.compose.runtime.ComposerKt;
import androidx.core.location.LocationRequestCompat;
import androidx.work.WorkRequest;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import defpackage.AbstractC0992Vj;
import defpackage.AbstractC1776bB;
import java.math.RoundingMode;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class LongMath {

    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;

    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;

    @VisibleForTesting
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;

    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    @VisibleForTesting
    @GwtIncompatible
    static final long[] powersOf10 = {1, 10, 100, 1000, WorkRequest.MIN_BACKOFF_MILLIS, 100000, AnimationKt.MillisToNanos, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    @VisibleForTesting
    @GwtIncompatible
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, TIFFConstants.TIFFTAG_CELLLENGTH, ComposerKt.referenceKey, ShapeTypes.ACTION_BUTTON_RETURN, ShapeTypes.FLOW_CHART_CONNECTOR, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    @VisibleForTesting
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, MetaDo.META_TEXTOUT, 684, 419, TIFFConstants.TIFFTAG_YPOSITION, 214, ShapeTypes.ACTION_BUTTON_RETURN, ShapeTypes.FLOW_CHART_TERMINATOR, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{LocationRequestCompat.PASSIVE_INTERVAL, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class b {
        public static final b a = new a("SMALL", 0);
        public static final b b = new C0254b("LARGE", 1);
        public static final /* synthetic */ b[] c = a();

        public final enum a extends b {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.math.LongMath.b
            public long b(long j, long j2, long j3) {
                return (j * j2) % j3;
            }

            @Override // com.google.common.math.LongMath.b
            public long e(long j, long j2) {
                return (j * j) % j2;
            }
        }

        /* JADX INFO: renamed from: com.google.common.math.LongMath$b$b, reason: collision with other inner class name */
        public final enum C0254b extends b {
            public C0254b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.math.LongMath.b
            public long b(long j, long j2, long j3) {
                long j4 = j >>> 32;
                long j5 = j2 >>> 32;
                long j6 = j & 4294967295L;
                long j7 = j2 & 4294967295L;
                long j8 = j(j4 * j5, j3) + (j4 * j7);
                if (j8 < 0) {
                    j8 = UnsignedLongs.remainder(j8, j3);
                }
                Long.signum(j6);
                return i(j(j8 + (j5 * j6), j3), UnsignedLongs.remainder(j6 * j7, j3), j3);
            }

            @Override // com.google.common.math.LongMath.b
            public long e(long j, long j2) {
                long j3 = j >>> 32;
                long j4 = j & 4294967295L;
                long j5 = j(j3 * j3, j2);
                long jRemainder = j3 * j4 * 2;
                if (jRemainder < 0) {
                    jRemainder = UnsignedLongs.remainder(jRemainder, j2);
                }
                return i(j(j5 + jRemainder, j2), UnsignedLongs.remainder(j4 * j4, j2), j2);
            }

            public final long i(long j, long j2, long j3) {
                long j4 = j + j2;
                return j >= j3 - j2 ? j4 - j3 : j4;
            }

            public final long j(long j, long j2) {
                int i = 32;
                do {
                    int iMin = Math.min(i, Long.numberOfLeadingZeros(j));
                    j = UnsignedLongs.remainder(j << iMin, j2);
                    i -= iMin;
                } while (i > 0);
                return j;
            }
        }

        public b(String str, int i) {
            super(str, i);
        }

        public static /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static boolean f(long j, long j2) {
            return (j2 <= LongMath.FLOOR_SQRT_MAX_LONG ? a : b).h(j, j2);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }

        public abstract long b(long j, long j2, long j3);

        public final long c(long j, long j2, long j3) {
            long jB = 1;
            while (j2 != 0) {
                if ((j2 & 1) != 0) {
                    jB = b(jB, j, j3);
                }
                j = e(j, j3);
                j2 >>= 1;
            }
            return jB;
        }

        public abstract long e(long j, long j2);

        public final boolean h(long j, long j2) {
            long j3 = j2 - 1;
            int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
            long j4 = j3 >> iNumberOfTrailingZeros;
            long j5 = j % j2;
            if (j5 == 0) {
                return true;
            }
            long jC = c(j5, j4, j2);
            if (jC == 1) {
                return true;
            }
            int i = 0;
            while (jC != j3) {
                i++;
                if (i == iNumberOfTrailingZeros) {
                    return false;
                }
                jC = e(jC, j2);
            }
            return true;
        }

        public /* synthetic */ b(String str, int i, a aVar) {
            this(str, i);
        }
    }

    private LongMath() {
    }

    public static long binomial(int i, int i2) {
        AbstractC1776bB.e("n", i);
        AbstractC1776bB.e("k", i2);
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        long jMultiplyFraction = 1;
        if (i2 == 0) {
            return 1L;
        }
        if (i2 == 1) {
            return i;
        }
        long[] jArr = factorials;
        if (i < jArr.length) {
            return jArr[i] / (jArr[i2] * jArr[i - i2]);
        }
        int[] iArr = biggestBinomials;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i2 < iArr2.length && i <= iArr2[i2]) {
            int i3 = i - 1;
            long j = i;
            for (int i4 = 2; i4 <= i2; i4++) {
                j = (j * ((long) i3)) / ((long) i4);
                i3--;
            }
            return j;
        }
        long j2 = i;
        int iLog2 = log2(j2, RoundingMode.CEILING);
        int i5 = i - 1;
        int i6 = iLog2;
        long j3 = j2;
        int i7 = 2;
        long j4 = 1;
        while (i7 <= i2) {
            i6 += iLog2;
            if (i6 < 63) {
                j3 *= (long) i5;
                j4 *= (long) i7;
            } else {
                jMultiplyFraction = multiplyFraction(jMultiplyFraction, j3, j4);
                j3 = i5;
                j4 = i7;
                i6 = iLog2;
            }
            i7++;
            i5--;
        }
        return multiplyFraction(jMultiplyFraction, j3, j4);
    }

    @Beta
    public static long ceilingPowerOfTwo(long j) {
        AbstractC1776bB.i("x", j);
        if (j <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j - 1));
        }
        StringBuilder sb = new StringBuilder(70);
        sb.append("ceilingPowerOfTwo(");
        sb.append(j);
        sb.append(") is not representable as a long");
        throw new ArithmeticException(sb.toString());
    }

    @GwtIncompatible
    public static long checkedAdd(long j, long j2) {
        long j3 = j + j2;
        AbstractC1776bB.c(((j ^ j2) < 0) | ((j ^ j3) >= 0), "checkedAdd", j, j2);
        return j3;
    }

    public static long checkedMultiply(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j2);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        AbstractC1776bB.c(iNumberOfLeadingZeros >= 64, "checkedMultiply", j, j2);
        AbstractC1776bB.c((j >= 0) | (j2 != Long.MIN_VALUE), "checkedMultiply", j, j2);
        long j3 = j * j2;
        AbstractC1776bB.c(j == 0 || j3 / j == j2, "checkedMultiply", j, j2);
        return j3;
    }

    @GwtIncompatible
    public static long checkedPow(long j, int i) {
        AbstractC1776bB.e("exponent", i);
        long j2 = 1;
        if (!(j >= -2) || !(j <= 2)) {
            long j3 = j;
            int i2 = i;
            while (i2 != 0) {
                if (i2 == 1) {
                    return checkedMultiply(j2, j3);
                }
                long jCheckedMultiply = (i2 & 1) != 0 ? checkedMultiply(j2, j3) : j2;
                int i3 = i2 >> 1;
                if (i3 > 0) {
                    AbstractC1776bB.c(-3037000499L <= j3 && j3 <= FLOOR_SQRT_MAX_LONG, "checkedPow", j3, i3);
                    j3 *= j3;
                }
                j2 = jCheckedMultiply;
                i2 = i3;
            }
            return j2;
        }
        int i4 = (int) j;
        if (i4 == -2) {
            AbstractC1776bB.c(i < 64, "checkedPow", j, i);
            return (i & 1) == 0 ? 1 << i : (-1) << i;
        }
        if (i4 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        }
        if (i4 == 0) {
            return i == 0 ? 1L : 0L;
        }
        if (i4 == 1) {
            return 1L;
        }
        if (i4 != 2) {
            throw new AssertionError();
        }
        AbstractC1776bB.c(i < 63, "checkedPow", j, i);
        return 1 << i;
    }

    @GwtIncompatible
    public static long checkedSubtract(long j, long j2) {
        long j3 = j - j2;
        AbstractC1776bB.c(((j ^ j2) >= 0) | ((j ^ j3) >= 0), "checkedSubtract", j, j2);
        return j3;
    }

    @GwtIncompatible
    public static long divide(long j, long j2, RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        if (j4 == 0) {
            return j3;
        }
        int i = ((int) ((j ^ j2) >> 63)) | 1;
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AbstractC1776bB.k(j4 == 0);
                return j3;
            case 2:
                return j3;
            case 3:
                if (i >= 0) {
                    return j3;
                }
                break;
            case 4:
                break;
            case 5:
                if (i <= 0) {
                    return j3;
                }
                break;
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j4);
                long jAbs2 = jAbs - (Math.abs(j2) - jAbs);
                if (jAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j3) == 0)) {
                        return j3;
                    }
                } else if (jAbs2 <= 0) {
                    return j3;
                }
            default:
                throw new AssertionError();
        }
        return j3 + ((long) i);
    }

    @GwtIncompatible
    public static long factorial(int i) {
        AbstractC1776bB.e("n", i);
        long[] jArr = factorials;
        return i < jArr.length ? jArr[i] : LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public static boolean fitsInInt(long j) {
        return ((long) ((int) j)) == j;
    }

    @Beta
    public static long floorPowerOfTwo(long j) {
        AbstractC1776bB.i("x", j);
        return 1 << (63 - Long.numberOfLeadingZeros(j));
    }

    public static long gcd(long j, long j2) {
        AbstractC1776bB.f("a", j);
        AbstractC1776bB.f("b", j2);
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long jNumberOfTrailingZeros = j >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j3 = j2 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j3) {
            long j4 = jNumberOfTrailingZeros - j3;
            long j5 = (j4 >> 63) & j4;
            long j6 = (j4 - j5) - j5;
            j3 += j5;
            jNumberOfTrailingZeros = j6 >> Long.numberOfTrailingZeros(j6);
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j) {
        return (j > 0) & ((j & (j - 1)) == 0);
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(long j) {
        if (j < 2) {
            AbstractC1776bB.f("n", j);
            return false;
        }
        if (j < 66) {
            return ((722865708377213483 >> (((int) j) + (-2))) & 1) != 0;
        }
        if (((1 << ((int) (j % 30))) & SIEVE_30) != 0 || j % 7 == 0 || j % 11 == 0 || j % 13 == 0) {
            return false;
        }
        if (j < 289) {
            return true;
        }
        for (long[] jArr : millerRabinBaseSets) {
            if (j <= jArr[0]) {
                for (int i = 1; i < jArr.length; i++) {
                    if (!b.f(jArr[i], j)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new AssertionError();
    }

    @VisibleForTesting
    public static int lessThanBranchFree(long j, long j2) {
        return (int) ((~(~(j - j2))) >>> 63);
    }

    @GwtIncompatible
    public static int log10(long j, RoundingMode roundingMode) {
        int iLessThanBranchFree;
        AbstractC1776bB.i("x", j);
        int iLog10Floor = log10Floor(j);
        long j2 = powersOf10[iLog10Floor];
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AbstractC1776bB.k(j == j2);
            case 2:
            case 3:
                return iLog10Floor;
            case 4:
            case 5:
                iLessThanBranchFree = lessThanBranchFree(j2, j);
                return iLog10Floor + iLessThanBranchFree;
            case 6:
            case 7:
            case 8:
                iLessThanBranchFree = lessThanBranchFree(halfPowersOf10[iLog10Floor], j);
                return iLog10Floor + iLessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static int log10Floor(long j) {
        byte b2 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j)];
        return b2 - lessThanBranchFree(j, powersOf10[b2]);
    }

    public static int log2(long j, RoundingMode roundingMode) {
        AbstractC1776bB.i("x", j);
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AbstractC1776bB.k(isPowerOfTwo(j));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j);
                return (63 - iNumberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> iNumberOfLeadingZeros, j);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j);
    }

    public static long mean(long j, long j2) {
        return (j & j2) + ((j ^ j2) >> 1);
    }

    @GwtIncompatible
    public static int mod(long j, int i) {
        return (int) mod(j, i);
    }

    public static long multiplyFraction(long j, long j2, long j3) {
        if (j == 1) {
            return j2 / j3;
        }
        long jGcd = gcd(j, j3);
        return (j / jGcd) * (j2 / (j3 / jGcd));
    }

    @GwtIncompatible
    public static long pow(long j, int i) {
        AbstractC1776bB.e("exponent", i);
        if (-2 > j || j > 2) {
            long j2 = 1;
            while (i != 0) {
                if (i == 1) {
                    return j2 * j;
                }
                j2 *= (i & 1) == 0 ? 1L : j;
                j *= j;
                i >>= 1;
            }
            return j2;
        }
        int i2 = (int) j;
        if (i2 == -2) {
            if (i < 64) {
                return (i & 1) == 0 ? 1 << i : -(1 << i);
            }
            return 0L;
        }
        if (i2 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        }
        if (i2 == 0) {
            return i == 0 ? 1L : 0L;
        }
        if (i2 == 1) {
            return 1L;
        }
        if (i2 != 2) {
            throw new AssertionError();
        }
        if (i < 64) {
            return 1 << i;
        }
        return 0L;
    }

    @GwtIncompatible
    public static double roundToDouble(long j, RoundingMode roundingMode) {
        double dNextUp;
        long jCeil;
        double d = j;
        long jFloor = (long) d;
        int iCompare = jFloor == LocationRequestCompat.PASSIVE_INTERVAL ? -1 : Longs.compare(j, jFloor);
        int[] iArr = a.a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                AbstractC1776bB.k(iCompare == 0);
                return d;
            case 2:
                if (j >= 0) {
                    return iCompare >= 0 ? d : AbstractC0992Vj.f(d);
                }
                return iCompare <= 0 ? d : Math.nextUp(d);
            case 3:
                return iCompare >= 0 ? d : AbstractC0992Vj.f(d);
            case 4:
                if (j >= 0) {
                    return iCompare <= 0 ? d : Math.nextUp(d);
                }
                return iCompare >= 0 ? d : AbstractC0992Vj.f(d);
            case 5:
                return iCompare <= 0 ? d : Math.nextUp(d);
            case 6:
            case 7:
            case 8:
                if (iCompare >= 0) {
                    dNextUp = Math.nextUp(d);
                    jCeil = (long) Math.ceil(dNextUp);
                } else {
                    double dF = AbstractC0992Vj.f(d);
                    jFloor = (long) Math.floor(dF);
                    dNextUp = d;
                    d = dF;
                    jCeil = jFloor;
                }
                long j2 = j - jFloor;
                long j3 = jCeil - j;
                if (jCeil == LocationRequestCompat.PASSIVE_INTERVAL) {
                    j3++;
                }
                int iCompare2 = Longs.compare(j2, j3);
                if (iCompare2 < 0) {
                    return d;
                }
                if (iCompare2 > 0) {
                    return dNextUp;
                }
                int i = iArr[roundingMode.ordinal()];
                if (i == 6) {
                    return j >= 0 ? d : dNextUp;
                }
                if (i == 7) {
                    return j >= 0 ? dNextUp : d;
                }
                if (i == 8) {
                    return (AbstractC0992Vj.c(d) & 1) == 0 ? d : dNextUp;
                }
                throw new AssertionError("impossible");
            default:
                throw new AssertionError("impossible");
        }
    }

    @Beta
    public static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) < 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + LocationRequestCompat.PASSIVE_INTERVAL;
    }

    @Beta
    public static long saturatedMultiply(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j2);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + LocationRequestCompat.PASSIVE_INTERVAL;
        if ((iNumberOfLeadingZeros < 64) || ((j2 == Long.MIN_VALUE) & (j < 0))) {
            return j3;
        }
        long j4 = j * j2;
        return (j == 0 || j4 / j == j2) ? j4 : j3;
    }

    @Beta
    public static long saturatedPow(long j, int i) {
        AbstractC1776bB.e("exponent", i);
        long jSaturatedMultiply = 1;
        if (!(j >= -2) || !(j <= 2)) {
            long j2 = ((j >>> 63) & ((long) (i & 1))) + LocationRequestCompat.PASSIVE_INTERVAL;
            while (i != 0) {
                if (i == 1) {
                    return saturatedMultiply(jSaturatedMultiply, j);
                }
                if ((i & 1) != 0) {
                    jSaturatedMultiply = saturatedMultiply(jSaturatedMultiply, j);
                }
                i >>= 1;
                if (i > 0) {
                    if ((-3037000499L > j) || (j > FLOOR_SQRT_MAX_LONG)) {
                        return j2;
                    }
                    j *= j;
                }
            }
            return jSaturatedMultiply;
        }
        int i2 = (int) j;
        if (i2 == -2) {
            if (i >= 64) {
                return ((long) (i & 1)) + LocationRequestCompat.PASSIVE_INTERVAL;
            }
            return (i & 1) == 0 ? 1 << i : (-1) << i;
        }
        if (i2 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        }
        if (i2 == 0) {
            return i == 0 ? 1L : 0L;
        }
        if (i2 == 1) {
            return 1L;
        }
        if (i2 == 2) {
            return i >= 63 ? LocationRequestCompat.PASSIVE_INTERVAL : 1 << i;
        }
        throw new AssertionError();
    }

    @Beta
    public static long saturatedSubtract(long j, long j2) {
        long j3 = j - j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) >= 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + LocationRequestCompat.PASSIVE_INTERVAL;
    }

    @GwtIncompatible
    public static long sqrt(long j, RoundingMode roundingMode) {
        AbstractC1776bB.f("x", j);
        if (fitsInInt(j)) {
            return IntMath.sqrt((int) j, roundingMode);
        }
        long jSqrt = (long) Math.sqrt(j);
        long j2 = jSqrt * jSqrt;
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AbstractC1776bB.k(j2 == j);
                return jSqrt;
            case 2:
            case 3:
                return j < j2 ? jSqrt - 1 : jSqrt;
            case 4:
            case 5:
                return j > j2 ? jSqrt + 1 : jSqrt;
            case 6:
            case 7:
            case 8:
                long j3 = jSqrt - ((long) (j < j2 ? 1 : 0));
                return j3 + ((long) lessThanBranchFree((j3 * j3) + j3, j));
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long mod(long j, long j2) {
        if (j2 <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }
}
