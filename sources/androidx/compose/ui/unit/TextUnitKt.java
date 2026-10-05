package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    /* JADX INFO: renamed from: TextUnit-anM5pPY, reason: not valid java name */
    public static final long m5353TextUnitanM5pPY(float f, long j) {
        return pack(j, f);
    }

    /* JADX INFO: renamed from: checkArithmetic--R2X_6o, reason: not valid java name */
    public static final void m5354checkArithmeticR2X_6o(long j) {
        if (m5359isUnspecifiedR2X_6o(j)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
    }

    /* JADX INFO: renamed from: checkArithmetic-NB67dxo, reason: not valid java name */
    public static final void m5355checkArithmeticNB67dxo(long j, long j2) {
        if (m5359isUnspecifiedR2X_6o(j) || m5359isUnspecifiedR2X_6o(j2)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(j), TextUnit.m5340getTypeUIouoOA(j2))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m5371toStringimpl(TextUnit.m5340getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m5371toStringimpl(TextUnit.m5340getTypeUIouoOA(j2)))).toString());
    }

    /* JADX INFO: renamed from: checkArithmetic-vU-0ePk, reason: not valid java name */
    public static final void m5356checkArithmeticvU0ePk(long j, long j2, long j3) {
        if (m5359isUnspecifiedR2X_6o(j) || m5359isUnspecifiedR2X_6o(j2) || m5359isUnspecifiedR2X_6o(j3)) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(j), TextUnit.m5340getTypeUIouoOA(j2)) && TextUnitType.m5369equalsimpl0(TextUnit.m5340getTypeUIouoOA(j2), TextUnit.m5340getTypeUIouoOA(j3))) {
            return;
        }
        throw new IllegalArgumentException(("Cannot perform operation for " + ((Object) TextUnitType.m5371toStringimpl(TextUnit.m5340getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m5371toStringimpl(TextUnit.m5340getTypeUIouoOA(j2)))).toString());
    }

    public static final long getEm(float f) {
        return pack(UNIT_TYPE_EM, f);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(double d) {
    }

    public static final long getSp(float f) {
        return pack(UNIT_TYPE_SP, f);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(double d) {
    }

    /* JADX INFO: renamed from: isSpecified--R2X_6o, reason: not valid java name */
    public static final boolean m5357isSpecifiedR2X_6o(long j) {
        return !m5359isUnspecifiedR2X_6o(j);
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m5358isSpecifiedR2X_6o$annotations(long j) {
    }

    /* JADX INFO: renamed from: isUnspecified--R2X_6o, reason: not valid java name */
    public static final boolean m5359isUnspecifiedR2X_6o(long j) {
        return TextUnit.m5339getRawTypeimpl(j) == 0;
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified--R2X_6o$annotations, reason: not valid java name */
    public static /* synthetic */ void m5360isUnspecifiedR2X_6o$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m5361lerpC3pnCVY(long j, long j2, float f) {
        m5355checkArithmeticNB67dxo(j, j2);
        return pack(TextUnit.m5339getRawTypeimpl(j), MathHelpersKt.lerp(TextUnit.m5341getValueimpl(j), TextUnit.m5341getValueimpl(j2), f));
    }

    public static final long pack(long j, float f) {
        return TextUnit.m5333constructorimpl(j | (((long) Float.floatToIntBits(f)) & 4294967295L));
    }

    /* JADX INFO: renamed from: takeOrElse-eAf_CNQ, reason: not valid java name */
    public static final long m5362takeOrElseeAf_CNQ(long j, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        return !m5359isUnspecifiedR2X_6o(j) ? j : ((TextUnit) interfaceC3588op.invoke()).m5350unboximpl();
    }

    @Stable
    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m5364timesmpE4wyQ(float f, long j) {
        m5354checkArithmeticR2X_6o(j);
        return pack(TextUnit.m5339getRawTypeimpl(j), f * TextUnit.m5341getValueimpl(j));
    }

    public static final long getEm(double d) {
        return pack(UNIT_TYPE_EM, (float) d);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(float f) {
    }

    public static final long getSp(double d) {
        return pack(UNIT_TYPE_SP, (float) d);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(float f) {
    }

    public static final long getEm(int i) {
        return pack(UNIT_TYPE_EM, i);
    }

    @Stable
    public static /* synthetic */ void getEm$annotations(int i) {
    }

    public static final long getSp(int i) {
        return pack(UNIT_TYPE_SP, i);
    }

    @Stable
    public static /* synthetic */ void getSp$annotations(int i) {
    }

    @Stable
    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m5363timesmpE4wyQ(double d, long j) {
        m5354checkArithmeticR2X_6o(j);
        return pack(TextUnit.m5339getRawTypeimpl(j), ((float) d) * TextUnit.m5341getValueimpl(j));
    }

    @Stable
    /* JADX INFO: renamed from: times-mpE4wyQ, reason: not valid java name */
    public static final long m5365timesmpE4wyQ(int i, long j) {
        m5354checkArithmeticR2X_6o(j);
        return pack(TextUnit.m5339getRawTypeimpl(j), i * TextUnit.m5341getValueimpl(j));
    }
}
