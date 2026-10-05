package defpackage;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: renamed from: Vj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0992Vj {
    public static double a(BigInteger bigInteger) {
        BigInteger bigIntegerAbs = bigInteger.abs();
        int iBitLength = bigIntegerAbs.bitLength();
        int i = iBitLength - 1;
        if (i < 63) {
            return bigInteger.longValue();
        }
        if (i > 1023) {
            return ((double) bigInteger.signum()) * Double.POSITIVE_INFINITY;
        }
        int i2 = iBitLength - 54;
        long jLongValue = bigIntegerAbs.shiftRight(i2).longValue();
        long j = jLongValue >> 1;
        long j2 = IEEEDouble.FRAC_MASK & j;
        if ((jLongValue & 1) != 0 && ((j & 1) != 0 || bigIntegerAbs.getLowestSetBit() < i2)) {
            j2++;
        }
        return Double.longBitsToDouble(((((long) (iBitLength + 1022)) << 52) + j2) | (((long) bigInteger.signum()) & Long.MIN_VALUE));
    }

    public static double b(double d) {
        Preconditions.checkArgument(!Double.isNaN(d));
        return Math.max(d, 0.0d);
    }

    public static long c(double d) {
        Preconditions.checkArgument(d(d), "not a normal value");
        int exponent = Math.getExponent(d);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d) & IEEEDouble.FRAC_MASK;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | IEEEDouble.FRAC_ASSUMED_HIGH_BIT;
    }

    public static boolean d(double d) {
        return Math.getExponent(d) <= 1023;
    }

    public static boolean e(double d) {
        return Math.getExponent(d) >= -1022;
    }

    public static double f(double d) {
        return -Math.nextUp(-d);
    }

    public static double g(double d) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d) & IEEEDouble.FRAC_MASK) | 4607182418800017408L);
    }
}
