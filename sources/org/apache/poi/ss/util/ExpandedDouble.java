package org.apache.poi.ss.util;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes4.dex */
final class ExpandedDouble {
    private static final BigInteger BI_FRAC_MASK = BigInteger.valueOf(IEEEDouble.FRAC_MASK);
    private static final BigInteger BI_IMPLIED_FRAC_MSB = BigInteger.valueOf(IEEEDouble.FRAC_ASSUMED_HIGH_BIT);
    private final int _binaryExponent;
    private final BigInteger _significand;

    public ExpandedDouble(long j) {
        int i = (int) (j >> 52);
        if (i != 0) {
            this._significand = getFrac(j);
            this._binaryExponent = (i & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE) - 1023;
        } else {
            BigInteger bigIntegerAnd = BigInteger.valueOf(j).and(BI_FRAC_MASK);
            int iBitLength = 64 - bigIntegerAnd.bitLength();
            this._significand = bigIntegerAnd.shiftLeft(iBitLength);
            this._binaryExponent = ((i & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE) - 1023) - iBitLength;
        }
    }

    public static ExpandedDouble fromRawBitsAndExponent(long j, int i) {
        return new ExpandedDouble(getFrac(j), i);
    }

    private static BigInteger getFrac(long j) {
        return BigInteger.valueOf(j).and(BI_FRAC_MASK).or(BI_IMPLIED_FRAC_MSB).shiftLeft(11);
    }

    public int getBinaryExponent() {
        return this._binaryExponent;
    }

    public BigInteger getSignificand() {
        return this._significand;
    }

    public NormalisedDecimal normaliseBaseTen() {
        return NormalisedDecimal.create(this._significand, this._binaryExponent);
    }

    public ExpandedDouble(BigInteger bigInteger, int i) {
        if (bigInteger.bitLength() == 64) {
            this._significand = bigInteger;
            this._binaryExponent = i;
            return;
        }
        throw new IllegalArgumentException("bad bit length");
    }
}
