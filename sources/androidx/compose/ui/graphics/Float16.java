package androidx.compose.ui.graphics;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC3566ob;
import defpackage.AbstractC4492zt;
import defpackage.C0774Nm;
import defpackage.SJ;
import org.apache.poi.ss.usermodel.Font;

/* JADX INFO: loaded from: classes.dex */
public final class Float16 implements Comparable<Float16> {
    private static final int FP16_COMBINED = 32767;
    private static final int FP16_EXPONENT_BIAS = 15;
    private static final int FP16_EXPONENT_MASK = 31;
    private static final int FP16_EXPONENT_MAX = 31744;
    private static final int FP16_EXPONENT_SHIFT = 10;
    private static final int FP16_SIGNIFICAND_MASK = 1023;
    private static final int FP16_SIGN_MASK = 32768;
    private static final int FP16_SIGN_SHIFT = 15;
    private static final float FP32_DENORMAL_FLOAT;
    private static final int FP32_DENORMAL_MAGIC = 1056964608;
    private static final int FP32_EXPONENT_BIAS = 127;
    private static final int FP32_EXPONENT_MASK = 255;
    private static final int FP32_EXPONENT_SHIFT = 23;
    private static final int FP32_QNAN_MASK = 4194304;
    private static final int FP32_SIGNIFICAND_MASK = 8388607;
    private static final int FP32_SIGN_SHIFT = 31;
    public static final int MaxExponent = 15;
    public static final int MinExponent = -14;
    public static final int Size = 16;
    private final short halfValue;
    public static final Companion Companion = new Companion(null);
    private static final short Epsilon = m3136constructorimpl((short) 5120);
    private static final short LowestValue = m3136constructorimpl((short) -1025);
    private static final short MaxValue = m3136constructorimpl((short) 31743);
    private static final short MinNormal = m3136constructorimpl((short) 1024);
    private static final short MinValue = m3136constructorimpl((short) 1);
    private static final short NaN = m3136constructorimpl((short) 32256);
    private static final short NegativeInfinity = m3136constructorimpl((short) -1024);
    private static final short NegativeZero = m3136constructorimpl(Short.MIN_VALUE);
    private static final short PositiveInfinity = m3136constructorimpl((short) 31744);
    private static final short PositiveZero = m3136constructorimpl((short) 0);
    private static final short One = m3135constructorimpl(1.0f);
    private static final short NegativeOne = m3135constructorimpl(-1.0f);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final short floatToHalf(float f) {
            int i;
            int iFloatToRawIntBits = Float.floatToRawIntBits(f);
            int i2 = iFloatToRawIntBits >>> 31;
            int i3 = (iFloatToRawIntBits >>> 23) & 255;
            int i4 = Float16.FP32_SIGNIFICAND_MASK & iFloatToRawIntBits;
            int i5 = 31;
            int i6 = 0;
            if (i3 != 255) {
                int i7 = i3 - 112;
                if (i7 >= 31) {
                    i5 = 49;
                } else {
                    if (i7 > 0) {
                        i6 = i4 >> 13;
                        if ((iFloatToRawIntBits & 4096) != 0) {
                            i = (((i7 << 10) | i6) + 1) | (i2 << 15);
                        } else {
                            i5 = i7;
                        }
                        return (short) i;
                    }
                    if (i7 >= -10) {
                        int i8 = (8388608 | i4) >> (1 - i7);
                        if ((i8 & 4096) != 0) {
                            i8 += 8192;
                        }
                        i6 = i8 >> 13;
                    }
                    i5 = 0;
                }
            } else if (i4 != 0) {
                i6 = 512;
            }
            i = (i2 << 15) | (i5 << 10) | i6;
            return (short) i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int toCompareValue(short s) {
            return (s & Short.MIN_VALUE) != 0 ? 32768 - (s & 65535) : s & 65535;
        }

        /* JADX INFO: renamed from: getEpsilon-slo4al4, reason: not valid java name */
        public final short m3163getEpsilonslo4al4() {
            return Float16.Epsilon;
        }

        /* JADX INFO: renamed from: getLowestValue-slo4al4, reason: not valid java name */
        public final short m3164getLowestValueslo4al4() {
            return Float16.LowestValue;
        }

        /* JADX INFO: renamed from: getMaxValue-slo4al4, reason: not valid java name */
        public final short m3165getMaxValueslo4al4() {
            return Float16.MaxValue;
        }

        /* JADX INFO: renamed from: getMinNormal-slo4al4, reason: not valid java name */
        public final short m3166getMinNormalslo4al4() {
            return Float16.MinNormal;
        }

        /* JADX INFO: renamed from: getMinValue-slo4al4, reason: not valid java name */
        public final short m3167getMinValueslo4al4() {
            return Float16.MinValue;
        }

        /* JADX INFO: renamed from: getNaN-slo4al4, reason: not valid java name */
        public final short m3168getNaNslo4al4() {
            return Float16.NaN;
        }

        /* JADX INFO: renamed from: getNegativeInfinity-slo4al4, reason: not valid java name */
        public final short m3169getNegativeInfinityslo4al4() {
            return Float16.NegativeInfinity;
        }

        /* JADX INFO: renamed from: getNegativeZero-slo4al4, reason: not valid java name */
        public final short m3170getNegativeZeroslo4al4() {
            return Float16.NegativeZero;
        }

        /* JADX INFO: renamed from: getPositiveInfinity-slo4al4, reason: not valid java name */
        public final short m3171getPositiveInfinityslo4al4() {
            return Float16.PositiveInfinity;
        }

        /* JADX INFO: renamed from: getPositiveZero-slo4al4, reason: not valid java name */
        public final short m3172getPositiveZeroslo4al4() {
            return Float16.PositiveZero;
        }

        private Companion() {
        }
    }

    static {
        C0774Nm c0774Nm = C0774Nm.a;
        FP32_DENORMAL_FLOAT = Float.intBitsToFloat(FP32_DENORMAL_MAGIC);
    }

    private /* synthetic */ Float16(short s) {
        this.halfValue = s;
    }

    /* JADX INFO: renamed from: absoluteValue-slo4al4, reason: not valid java name */
    public static final short m3130absoluteValueslo4al4(short s) {
        return m3136constructorimpl((short) (s & Font.COLOR_NORMAL));
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Float16 m3131boximpl(short s) {
        return new Float16(s);
    }

    /* JADX INFO: renamed from: ceil-slo4al4, reason: not valid java name */
    public static final short m3132ceilslo4al4(short s) {
        int i = 65535 & s;
        int i2 = s & Font.COLOR_NORMAL;
        if (i2 < 15360) {
            i = ((-((~(i >> 15)) & (i2 == 0 ? 0 : 1))) & 15360) | (s & Short.MIN_VALUE);
        } else if (i2 < 25600) {
            int i3 = (1 << (25 - (i2 >> 10))) - 1;
            i = (i + (((i >> 15) - 1) & i3)) & (~i3);
        }
        return m3136constructorimpl((short) i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m3136constructorimpl(short s) {
        return s;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m3137equalsimpl(short s, Object obj) {
        return (obj instanceof Float16) && s == ((Float16) obj).m3162unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3138equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* JADX INFO: renamed from: floor-slo4al4, reason: not valid java name */
    public static final short m3139floorslo4al4(short s) {
        int i = s & 65535;
        int i2 = s & Font.COLOR_NORMAL;
        if (i2 < 15360) {
            i = (s & Short.MIN_VALUE) | ((i <= 32768 ? 0 : 65535) & 15360);
        } else if (i2 < 25600) {
            int i3 = (1 << (25 - (i2 >> 10))) - 1;
            i = (i + ((-(i >> 15)) & i3)) & (~i3);
        }
        return m3136constructorimpl((short) i);
    }

    /* JADX INFO: renamed from: getExponent-impl, reason: not valid java name */
    public static final int m3140getExponentimpl(short s) {
        return ((s >>> 10) & 31) - 15;
    }

    /* JADX INFO: renamed from: getSign-slo4al4, reason: not valid java name */
    public static final short m3141getSignslo4al4(short s) {
        if (m3146isNaNimpl(s)) {
            return NaN;
        }
        if (m3133compareTo41bOqos(s, NegativeZero) < 0) {
            return NegativeOne;
        }
        return m3133compareTo41bOqos(s, PositiveZero) > 0 ? One : s;
    }

    /* JADX INFO: renamed from: getSignificand-impl, reason: not valid java name */
    public static final int m3142getSignificandimpl(short s) {
        return s & 1023;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m3143hashCodeimpl(short s) {
        return s;
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m3144isFiniteimpl(short s) {
        return (s & Font.COLOR_NORMAL) != FP16_EXPONENT_MAX;
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m3145isInfiniteimpl(short s) {
        return (s & Font.COLOR_NORMAL) == FP16_EXPONENT_MAX;
    }

    /* JADX INFO: renamed from: isNaN-impl, reason: not valid java name */
    public static final boolean m3146isNaNimpl(short s) {
        return (s & Font.COLOR_NORMAL) > FP16_EXPONENT_MAX;
    }

    /* JADX INFO: renamed from: isNormalized-impl, reason: not valid java name */
    public static final boolean m3147isNormalizedimpl(short s) {
        int i = s & FP16_EXPONENT_MAX;
        return (i == 0 || i == FP16_EXPONENT_MAX) ? false : true;
    }

    /* JADX INFO: renamed from: round-slo4al4, reason: not valid java name */
    public static final short m3148roundslo4al4(short s) {
        int i = s & 65535;
        int i2 = s & Font.COLOR_NORMAL;
        if (i2 < 15360) {
            i = (s & Short.MIN_VALUE) | ((i2 < 14336 ? 0 : 65535) & 15360);
        } else if (i2 < 25600) {
            int i3 = i2 >> 10;
            i = (i + (1 << (24 - i3))) & (~((1 << (25 - i3)) - 1));
        }
        return m3136constructorimpl((short) i);
    }

    /* JADX INFO: renamed from: toBits-impl, reason: not valid java name */
    public static final int m3149toBitsimpl(short s) {
        return m3146isNaNimpl(s) ? NaN : s & 65535;
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    public static final byte m3150toByteimpl(short s) {
        return (byte) m3152toFloatimpl(s);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m3151toDoubleimpl(short s) {
        return m3152toFloatimpl(s);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    public static final float m3152toFloatimpl(short s) {
        int i;
        int i2;
        int i3 = Short.MIN_VALUE & s;
        int i4 = ((65535 & s) >>> 10) & 31;
        int i5 = s & 1023;
        if (i4 != 0) {
            int i6 = i5 << 13;
            if (i4 == 31) {
                if (i6 != 0) {
                    i6 |= 4194304;
                }
                i = i6;
                i2 = 255;
            } else {
                int i7 = i4 + 112;
                i = i6;
                i2 = i7;
            }
        } else {
            if (i5 != 0) {
                C0774Nm c0774Nm = C0774Nm.a;
                float fIntBitsToFloat = Float.intBitsToFloat(i5 + FP32_DENORMAL_MAGIC) - FP32_DENORMAL_FLOAT;
                return i3 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i2 = 0;
            i = 0;
        }
        int i8 = (i2 << 23) | (i3 << 16) | i;
        C0774Nm c0774Nm2 = C0774Nm.a;
        return Float.intBitsToFloat(i8);
    }

    /* JADX INFO: renamed from: toHexString-impl, reason: not valid java name */
    public static final String m3153toHexStringimpl(short s) {
        StringBuilder sb = new StringBuilder();
        int i = 65535 & s;
        int i2 = i >>> 15;
        int i3 = (i >>> 10) & 31;
        int i4 = s & 1023;
        if (i3 != 31) {
            if (i2 == 1) {
                sb.append('-');
            }
            if (i3 != 0) {
                sb.append("0x1.");
                String string = Integer.toString(i4, AbstractC3566ob.a(16));
                AbstractC4492zt.g(string, "toString(this, checkRadix(radix))");
                sb.append(new SJ("0{2,}$").f(string, ""));
                sb.append('p');
                sb.append(String.valueOf(i3 - 15));
            } else if (i4 == 0) {
                sb.append("0x0.0p0");
            } else {
                sb.append("0x0.");
                String string2 = Integer.toString(i4, AbstractC3566ob.a(16));
                AbstractC4492zt.g(string2, "toString(this, checkRadix(radix))");
                sb.append(new SJ("0{2,}$").f(string2, ""));
                sb.append("p-14");
            }
        } else if (i4 == 0) {
            if (i2 != 0) {
                sb.append('-');
            }
            sb.append("Infinity");
        } else {
            sb.append("NaN");
        }
        String string3 = sb.toString();
        AbstractC4492zt.g(string3, "o.toString()");
        return string3;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m3154toIntimpl(short s) {
        return (int) m3152toFloatimpl(s);
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m3155toLongimpl(short s) {
        return (long) m3152toFloatimpl(s);
    }

    /* JADX INFO: renamed from: toRawBits-impl, reason: not valid java name */
    public static final int m3156toRawBitsimpl(short s) {
        return s & 65535;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    public static final short m3157toShortimpl(short s) {
        return (short) m3152toFloatimpl(s);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m3158toStringimpl(short s) {
        return String.valueOf(m3152toFloatimpl(s));
    }

    /* JADX INFO: renamed from: trunc-slo4al4, reason: not valid java name */
    public static final short m3159truncslo4al4(short s) {
        int i = 65535 & s;
        int i2 = s & Font.COLOR_NORMAL;
        if (i2 < 15360) {
            i = Short.MIN_VALUE & s;
        } else if (i2 < 25600) {
            i &= ~((1 << (25 - (i2 >> 10))) - 1);
        }
        return m3136constructorimpl((short) i);
    }

    /* JADX INFO: renamed from: withSign-qCeQghg, reason: not valid java name */
    public static final short m3160withSignqCeQghg(short s, short s2) {
        return m3136constructorimpl((short) ((s & Font.COLOR_NORMAL) | (s2 & Short.MIN_VALUE)));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Float16 float16) {
        return m3161compareTo41bOqos(float16.m3162unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-41bOqos, reason: not valid java name */
    public int m3161compareTo41bOqos(short s) {
        return m3133compareTo41bOqos(this.halfValue, s);
    }

    public boolean equals(Object obj) {
        return m3137equalsimpl(this.halfValue, obj);
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    public int hashCode() {
        return m3143hashCodeimpl(this.halfValue);
    }

    public String toString() {
        return m3158toStringimpl(this.halfValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m3162unboximpl() {
        return this.halfValue;
    }

    /* JADX INFO: renamed from: compareTo-41bOqos, reason: not valid java name */
    public static int m3133compareTo41bOqos(short s, short s2) {
        if (m3146isNaNimpl(s)) {
            return !m3146isNaNimpl(s2) ? 1 : 0;
        }
        if (m3146isNaNimpl(s2)) {
            return -1;
        }
        Companion companion = Companion;
        return AbstractC4492zt.j(companion.toCompareValue(s), companion.toCompareValue(s2));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m3135constructorimpl(float f) {
        return m3136constructorimpl(Companion.floatToHalf(f));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m3134constructorimpl(double d) {
        return m3135constructorimpl((float) d);
    }
}
