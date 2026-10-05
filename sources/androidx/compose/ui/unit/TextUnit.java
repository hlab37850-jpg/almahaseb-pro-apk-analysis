package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0723Lm;
import defpackage.C0774Nm;

/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextUnit {
    public static final Companion Companion = new Companion(null);
    private static final TextUnitType[] TextUnitTypes;
    private static final long Unspecified;
    private final long packedValue;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-XSAIIZE$annotations, reason: not valid java name */
        public static /* synthetic */ void m5351getUnspecifiedXSAIIZE$annotations() {
        }

        public final TextUnitType[] getTextUnitTypes$ui_unit_release() {
            return TextUnit.TextUnitTypes;
        }

        /* JADX INFO: renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m5352getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }

        private Companion() {
        }
    }

    static {
        TextUnitType.Companion companion = TextUnitType.Companion;
        TextUnitTypes = new TextUnitType[]{TextUnitType.m5366boximpl(companion.m5375getUnspecifiedUIouoOA()), TextUnitType.m5366boximpl(companion.m5374getSpUIouoOA()), TextUnitType.m5366boximpl(companion.m5373getEmUIouoOA())};
        Unspecified = TextUnitKt.pack(0L, Float.NaN);
    }

    private /* synthetic */ TextUnit(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m5331boximpl(long j) {
        return new TextUnit(j);
    }

    /* JADX INFO: renamed from: compareTo--R2X_6o, reason: not valid java name */
    public static final int m5332compareToR2X_6o(long j, long j2) {
        TextUnitKt.m5355checkArithmeticNB67dxo(j, j2);
        return Float.compare(m5341getValueimpl(j), m5341getValueimpl(j2));
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m5333constructorimpl(long j) {
        return j;
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m5335divkPz2Gy4(long j, float f) {
        TextUnitKt.m5354checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5339getRawTypeimpl(j), m5341getValueimpl(j) / f);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m5337equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).m5350unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5338equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getRawType$annotations() {
    }

    /* JADX INFO: renamed from: getRawType-impl, reason: not valid java name */
    public static final long m5339getRawTypeimpl(long j) {
        return j & 1095216660480L;
    }

    /* JADX INFO: renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m5340getTypeUIouoOA(long j) {
        return TextUnitTypes[(int) (m5339getRawTypeimpl(j) >>> 32)].m5372unboximpl();
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    public static final float m5341getValueimpl(long j) {
        C0774Nm c0774Nm = C0774Nm.a;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m5342hashCodeimpl(long j) {
        return AbstractC0723Lm.a(j);
    }

    /* JADX INFO: renamed from: isEm-impl, reason: not valid java name */
    public static final boolean m5343isEmimpl(long j) {
        return m5339getRawTypeimpl(j) == 8589934592L;
    }

    /* JADX INFO: renamed from: isSp-impl, reason: not valid java name */
    public static final boolean m5344isSpimpl(long j) {
        return m5339getRawTypeimpl(j) == 4294967296L;
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m5346timeskPz2Gy4(long j, float f) {
        TextUnitKt.m5354checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5339getRawTypeimpl(j), m5341getValueimpl(j) * f);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m5348toStringimpl(long j) {
        long jM5340getTypeUIouoOA = m5340getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5375getUnspecifiedUIouoOA())) {
            return "Unspecified";
        }
        if (TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5374getSpUIouoOA())) {
            return m5341getValueimpl(j) + ".sp";
        }
        if (!TextUnitType.m5369equalsimpl0(jM5340getTypeUIouoOA, companion.m5373getEmUIouoOA())) {
            return "Invalid";
        }
        return m5341getValueimpl(j) + ".em";
    }

    /* JADX INFO: renamed from: unaryMinus-XSAIIZE, reason: not valid java name */
    public static final long m5349unaryMinusXSAIIZE(long j) {
        TextUnitKt.m5354checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5339getRawTypeimpl(j), -m5341getValueimpl(j));
    }

    public boolean equals(Object obj) {
        return m5337equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5342hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m5348toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5350unboximpl() {
        return this.packedValue;
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m5334divkPz2Gy4(long j, double d) {
        TextUnitKt.m5354checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5339getRawTypeimpl(j), (float) (((double) m5341getValueimpl(j)) / d));
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m5345timeskPz2Gy4(long j, double d) {
        TextUnitKt.m5354checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5339getRawTypeimpl(j), (float) (((double) m5341getValueimpl(j)) * d));
    }

    /* JADX INFO: renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m5336divkPz2Gy4(long j, int i) {
        TextUnitKt.m5354checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5339getRawTypeimpl(j), m5341getValueimpl(j) / i);
    }

    /* JADX INFO: renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m5347timeskPz2Gy4(long j, int i) {
        TextUnitKt.m5354checkArithmeticR2X_6o(j);
        return TextUnitKt.pack(m5339getRawTypeimpl(j), m5341getValueimpl(j) * i);
    }
}
