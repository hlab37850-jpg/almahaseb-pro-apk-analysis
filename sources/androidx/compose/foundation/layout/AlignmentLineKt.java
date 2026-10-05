package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AlignmentLineKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m368alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, AlignmentLine alignmentLine, float f, float f2, Measurable measurable, long j) {
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null) : Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 14, null));
        int i = placeableMo4159measureBRTryo0.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            i = 0;
        }
        int height = getHorizontal(alignmentLine) ? placeableMo4159measureBRTryo0.getHeight() : placeableMo4159measureBRTryo0.getWidth();
        int iM5127getMaxHeightimpl = getHorizontal(alignmentLine) ? Constraints.m5127getMaxHeightimpl(j) : Constraints.m5128getMaxWidthimpl(j);
        Dp.Companion companion = Dp.Companion;
        int i2 = iM5127getMaxHeightimpl - height;
        int iL = AbstractC3871sJ.l((!Dp.m5165equalsimpl0(f, companion.m5180getUnspecifiedD9Ej5fM()) ? measureScope.mo327roundToPx0680j_4(f) : 0) - i, 0, i2);
        int iL2 = AbstractC3871sJ.l(((!Dp.m5165equalsimpl0(f2, companion.m5180getUnspecifiedD9Ej5fM()) ? measureScope.mo327roundToPx0680j_4(f2) : 0) - height) + i, 0, i2 - iL);
        int width = getHorizontal(alignmentLine) ? placeableMo4159measureBRTryo0.getWidth() : Math.max(placeableMo4159measureBRTryo0.getWidth() + iL + iL2, Constraints.m5130getMinWidthimpl(j));
        int iMax = getHorizontal(alignmentLine) ? Math.max(placeableMo4159measureBRTryo0.getHeight() + iL + iL2, Constraints.m5129getMinHeightimpl(j)) : placeableMo4159measureBRTryo0.getHeight();
        return MeasureScope.CC.q(measureScope, width, iMax, null, new AlignmentLineKt$alignmentLineOffsetMeasure$1(alignmentLine, f, iL, width, iL2, placeableMo4159measureBRTryo0, iMax), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    @Stable
    /* JADX INFO: renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m369paddingFrom4j6BHR0(Modifier modifier, AlignmentLine alignmentLine, float f, float f2) {
        AbstractC4492zt.h(modifier, "$this$paddingFrom");
        AbstractC4492zt.h(alignmentLine, "alignmentLine");
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f, f2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AlignmentLineKt$paddingFrom4j6BHR0$$inlined$debugInspectorInfo$1(alignmentLine, f, f2) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m370paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.Companion.m5180getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.Companion.m5180getUnspecifiedD9Ej5fM();
        }
        return m369paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    @Stable
    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c, reason: not valid java name */
    public static final Modifier m371paddingFromY_r0B1c(Modifier modifier, AlignmentLine alignmentLine, long j, long j2) {
        AbstractC4492zt.h(modifier, "$this$paddingFrom");
        AbstractC4492zt.h(alignmentLine, "alignmentLine");
        return modifier.then(new AlignmentLineOffsetTextUnitElement(alignmentLine, j, j2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AlignmentLineKt$paddingFromY_r0B1c$$inlined$debugInspectorInfo$1(alignmentLine, j, j2) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: paddingFrom-Y_r0B1c$default, reason: not valid java name */
    public static /* synthetic */ Modifier m372paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j = TextUnit.Companion.m5352getUnspecifiedXSAIIZE();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = TextUnit.Companion.m5352getUnspecifiedXSAIIZE();
        }
        return m371paddingFromY_r0B1c(modifier, alignmentLine, j3, j2);
    }

    @Stable
    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m373paddingFromBaselineVpY3zN4(Modifier modifier, float f, float f2) {
        AbstractC4492zt.h(modifier, "$this$paddingFromBaseline");
        Dp.Companion companion = Dp.Companion;
        return modifier.then(!Dp.m5165equalsimpl0(f, companion.m5180getUnspecifiedD9Ej5fM()) ? m370paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f, 0.0f, 4, null) : Modifier.Companion).then(!Dp.m5165equalsimpl0(f2, companion.m5180getUnspecifiedD9Ej5fM()) ? m370paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f2, 2, null) : Modifier.Companion);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m374paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m5180getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m5180getUnspecifiedD9Ej5fM();
        }
        return m373paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    @Stable
    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI, reason: not valid java name */
    public static final Modifier m375paddingFromBaselinewCyjxdI(Modifier modifier, long j, long j2) {
        AbstractC4492zt.h(modifier, "$this$paddingFromBaseline");
        return modifier.then(!TextUnitKt.m5359isUnspecifiedR2X_6o(j) ? m372paddingFromY_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), j, 0L, 4, null) : Modifier.Companion).then(!TextUnitKt.m5359isUnspecifiedR2X_6o(j2) ? m372paddingFromY_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0L, j2, 2, null) : Modifier.Companion);
    }

    /* JADX INFO: renamed from: paddingFromBaseline-wCyjxdI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m376paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.Companion.m5352getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.Companion.m5352getUnspecifiedXSAIIZE();
        }
        return m375paddingFromBaselinewCyjxdI(modifier, j, j2);
    }
}
