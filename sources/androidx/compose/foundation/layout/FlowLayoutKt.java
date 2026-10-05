package androidx.compose.foundation.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC0919Ss;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0604Ip;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.R5;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START;
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP;

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.FlowLayoutKt$getHorizontalArrangement$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0604Ip {
        final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Arrangement.Horizontal horizontal) {
            super(5);
            this.$horizontalArrangement = horizontal;
        }

        @Override // defpackage.InterfaceC0604Ip
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            invoke(((Number) obj).intValue(), (int[]) obj2, (LayoutDirection) obj3, (Density) obj4, (int[]) obj5);
            return FW.a;
        }

        public final void invoke(int i, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
            AbstractC4492zt.h(iArr, "size");
            AbstractC4492zt.h(layoutDirection, "layoutDirection");
            AbstractC4492zt.h(density, "density");
            AbstractC4492zt.h(iArr2, "outPosition");
            this.$horizontalArrangement.arrange(density, i, iArr, layoutDirection, iArr2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.FlowLayoutKt$getVerticalArrangement$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13451 extends AbstractC2233fv implements InterfaceC0604Ip {
        final /* synthetic */ Arrangement.Vertical $verticalArrangement;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13451(Arrangement.Vertical vertical) {
            super(5);
            this.$verticalArrangement = vertical;
        }

        @Override // defpackage.InterfaceC0604Ip
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            invoke(((Number) obj).intValue(), (int[]) obj2, (LayoutDirection) obj3, (Density) obj4, (int[]) obj5);
            return FW.a;
        }

        public final void invoke(int i, int[] iArr, LayoutDirection layoutDirection, Density density, int[] iArr2) {
            AbstractC4492zt.h(iArr, "size");
            AbstractC4492zt.h(layoutDirection, "<anonymous parameter 2>");
            AbstractC4492zt.h(density, "density");
            AbstractC4492zt.h(iArr2, "outPosition");
            this.$verticalArrangement.arrange(density, i, iArr, iArr2);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.FlowLayoutKt$intrinsicCrossAxisSize$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13461 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int[] $mainAxisSizes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13461(int[] iArr) {
            super(3);
            this.$mainAxisSizes = iArr;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i, int i2) {
            AbstractC4492zt.h(intrinsicMeasurable, "$this$intrinsicCrossAxisSize");
            return Integer.valueOf(this.$mainAxisSizes[i]);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.FlowLayoutKt$intrinsicCrossAxisSize$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int[] $crossAxisSizes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int[] iArr) {
            super(3);
            this.$crossAxisSizes = iArr;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i, int i2) {
            AbstractC4492zt.h(intrinsicMeasurable, "$this$intrinsicCrossAxisSize");
            return Integer.valueOf(this.$crossAxisSizes[i]);
        }
    }

    static {
        CrossAxisAlignment.Companion companion = CrossAxisAlignment.Companion;
        Alignment.Companion companion2 = Alignment.Companion;
        CROSS_AXIS_ALIGNMENT_TOP = companion.vertical$foundation_layout_release(companion2.getTop());
        CROSS_AXIS_ALIGNMENT_START = companion.horizontal$foundation_layout_release(companion2.getStart());
    }

    @Composable
    @ExperimentalLayoutApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i2, int i3) {
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        composer.startReplaceableGroup(-310290901);
        if ((i3 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i3 & 2) != 0) {
            vertical = Arrangement.INSTANCE.getTop();
        }
        if ((i3 & 4) != 0) {
            horizontal = Arrangement.INSTANCE.getStart();
        }
        if ((i3 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        MeasurePolicy measurePolicyColumnMeasurementHelper = columnMeasurementHelper(vertical, horizontal, i, composer, (i2 >> 3) & 1022);
        composer.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion.getConstructor();
        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurementHelper, companion.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        interfaceC0552Gp.invoke(FlowColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i2 >> 9) & 112) | 6));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    @ExperimentalLayoutApi
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i2, int i3) {
        AbstractC4492zt.h(interfaceC0552Gp, Annotation.CONTENT);
        composer.startReplaceableGroup(1098475987);
        if ((i3 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        if ((i3 & 2) != 0) {
            horizontal = Arrangement.INSTANCE.getStart();
        }
        if ((i3 & 4) != 0) {
            vertical = Arrangement.INSTANCE.getTop();
        }
        if ((i3 & 8) != 0) {
            i = Integer.MAX_VALUE;
        }
        MeasurePolicy measurePolicyRowMeasurementHelper = rowMeasurementHelper(horizontal, vertical, i, composer, (i2 >> 3) & 1022);
        composer.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion.getConstructor();
        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurementHelper, companion.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        interfaceC0552Gp.invoke(FlowRowScopeInstance.INSTANCE, composer, Integer.valueOf(((i2 >> 9) & 112) | 6));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d3  */
    /* JADX INFO: renamed from: breakDownItems-w1Onq5I, reason: not valid java name */
    public static final FlowResult m432breakDownItemsw1Onq5I(MeasureScope measureScope, RowColumnMeasurementHelper rowColumnMeasurementHelper, LayoutOrientation layoutOrientation, long j, int i) {
        Integer numValueOf;
        AbstractC4492zt.h(measureScope, "$this$breakDownItems");
        AbstractC4492zt.h(rowColumnMeasurementHelper, "measureHelper");
        AbstractC4492zt.h(layoutOrientation, "orientation");
        MutableVector mutableVector = new MutableVector(new RowColumnMeasureHelperResult[16], 0);
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        int iM5130getMinWidthimpl = Constraints.m5130getMinWidthimpl(j);
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        List<Measurable> measurables = rowColumnMeasurementHelper.getMeasurables();
        Placeable[] placeables = rowColumnMeasurementHelper.getPlaceables();
        int iCeil = (int) Math.ceil(measureScope.mo333toPx0680j_4(rowColumnMeasurementHelper.m511getArrangementSpacingD9Ej5fM()));
        long jM452constructorimpl = OrientationIndependentConstraints.m452constructorimpl(iM5130getMinWidthimpl, iM5128getMaxWidthimpl, 0, iM5127getMaxHeightimpl);
        Measurable measurable = (Measurable) AbstractC3240kc.e0(measurables, 0);
        Integer numValueOf2 = measurable != null ? Integer.valueOf(m434measureAndCache6m2dt9o(measurable, jM452constructorimpl, layoutOrientation, new FlowLayoutKt$breakDownItems$nextSize$1(placeables))) : null;
        Integer[] numArr = new Integer[measurables.size()];
        int size = measurables.size();
        int i2 = iM5128getMaxWidthimpl;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < size) {
            AbstractC4492zt.e(numValueOf2);
            int iIntValue = numValueOf2.intValue();
            int i7 = i4 + iIntValue;
            i2 -= iIntValue;
            int i8 = i3 + 1;
            Measurable measurable2 = (Measurable) AbstractC3240kc.e0(measurables, i8);
            Integer numValueOf3 = measurable2 != null ? Integer.valueOf(m434measureAndCache6m2dt9o(measurable2, jM452constructorimpl, layoutOrientation, new FlowLayoutKt$breakDownItems$1(placeables, i3)) + iCeil) : null;
            if (i8 >= measurables.size() || i8 - i5 >= i) {
                int iMin = Math.min(Math.max(iM5130getMinWidthimpl, i7), iM5128getMaxWidthimpl);
                numArr[i6] = Integer.valueOf(i8);
                i6++;
                if (numValueOf3 != null) {
                    numValueOf = Integer.valueOf(numValueOf3.intValue() - iCeil);
                } else {
                    numValueOf = null;
                }
                i2 = iM5128getMaxWidthimpl;
                numValueOf3 = numValueOf;
                i5 = i8;
                i4 = 0;
                iM5130getMinWidthimpl = iMin;
            } else {
                if (i2 - (numValueOf3 != null ? numValueOf3.intValue() : 0) < 0) {
                    int iMin2 = Math.min(Math.max(iM5130getMinWidthimpl, i7), iM5128getMaxWidthimpl);
                    numArr[i6] = Integer.valueOf(i8);
                    i6++;
                    if (numValueOf3 != null) {
                        numValueOf = Integer.valueOf(numValueOf3.intValue() - iCeil);
                    } else {
                        numValueOf = null;
                    }
                    i2 = iM5128getMaxWidthimpl;
                    numValueOf3 = numValueOf;
                    i5 = i8;
                    i4 = 0;
                    iM5130getMinWidthimpl = iMin2;
                } else {
                    i4 = i7;
                }
            }
            i3 = i8;
            numValueOf2 = numValueOf3;
        }
        int iMax = iM5130getMinWidthimpl;
        long jM467toBoxConstraintsOenEA2s = OrientationIndependentConstraints.m467toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m456copyyUG9Ft0$default(jM452constructorimpl, iMax, 0, 0, 0, 14, null), layoutOrientation);
        Integer num = (Integer) R5.Q(numArr, 0);
        int iIntValue2 = 0;
        int crossAxisSize = 0;
        int i9 = 0;
        while (num != null) {
            RowColumnMeasureHelperResult rowColumnMeasureHelperResultM512measureWithoutPlacing_EkL_Y = rowColumnMeasurementHelper.m512measureWithoutPlacing_EkL_Y(measureScope, jM467toBoxConstraintsOenEA2s, iIntValue2, num.intValue());
            crossAxisSize += rowColumnMeasureHelperResultM512measureWithoutPlacing_EkL_Y.getCrossAxisSize();
            iMax = Math.max(iMax, rowColumnMeasureHelperResultM512measureWithoutPlacing_EkL_Y.getMainAxisSize());
            mutableVector.add(rowColumnMeasureHelperResultM512measureWithoutPlacing_EkL_Y);
            iIntValue2 = num.intValue();
            i9++;
            num = (Integer) R5.Q(numArr, i9);
        }
        return new FlowResult(Math.max(iMax, Constraints.m5130getMinWidthimpl(j)), Math.max(crossAxisSize, Constraints.m5129getMinHeightimpl(j)), mutableVector);
    }

    @Composable
    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Composer composer, int i2) {
        AbstractC4492zt.h(vertical, "verticalArrangement");
        AbstractC4492zt.h(horizontal, "horizontalArrangement");
        composer.startReplaceableGroup(-2013098357);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i2, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:184)");
        }
        Integer numValueOf = Integer.valueOf(i);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(numValueOf) | composer.changed(vertical) | composer.changed(horizontal);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = m433flowMeasurePolicybs7tms(LayoutOrientation.Vertical, getVerticalArrangement(vertical), vertical.mo405getSpacingD9Ej5fM(), SizeMode.Wrap, CROSS_AXIS_ALIGNMENT_START, getHorizontalArrangement(horizontal), horizontal.mo405getSpacingD9Ej5fM(), i);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    public static final int crossAxisMin(Measurable measurable, LayoutOrientation layoutOrientation, int i) {
        AbstractC4492zt.h(measurable, "<this>");
        AbstractC4492zt.h(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? measurable.minIntrinsicHeight(i) : measurable.minIntrinsicWidth(i);
    }

    public static final int crossAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        AbstractC4492zt.h(placeable, "<this>");
        AbstractC4492zt.h(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: flowMeasurePolicy-bs7tm-s, reason: not valid java name */
    public static final MeasurePolicy m433flowMeasurePolicybs7tms(final LayoutOrientation layoutOrientation, final InterfaceC0604Ip interfaceC0604Ip, final float f, final SizeMode sizeMode, final CrossAxisAlignment crossAxisAlignment, final InterfaceC0604Ip interfaceC0604Ip2, final float f2, final int i) {
        return new MeasurePolicy(interfaceC0604Ip, f, sizeMode, crossAxisAlignment, i, f2, interfaceC0604Ip2) { // from class: androidx.compose.foundation.layout.FlowLayoutKt$flowMeasurePolicy$1
            final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
            final /* synthetic */ InterfaceC0604Ip $crossAxisArrangement;
            final /* synthetic */ float $crossAxisArrangementSpacing;
            final /* synthetic */ SizeMode $crossAxisSize;
            final /* synthetic */ InterfaceC0604Ip $mainAxisArrangement;
            final /* synthetic */ float $mainAxisArrangementSpacing;
            final /* synthetic */ int $maxItemsInMainAxis;
            private final InterfaceC0552Gp maxCrossAxisIntrinsicItemSize;
            private final InterfaceC0552Gp maxMainAxisIntrinsicItemSize;
            private final InterfaceC0552Gp minCrossAxisIntrinsicItemSize;
            private final InterfaceC0552Gp minMainAxisIntrinsicItemSize;

            {
                this.$mainAxisArrangement = interfaceC0604Ip;
                this.$mainAxisArrangementSpacing = f;
                this.$crossAxisSize = sizeMode;
                this.$crossAxisAlignment = crossAxisAlignment;
                this.$maxItemsInMainAxis = i;
                this.$crossAxisArrangementSpacing = f2;
                this.$crossAxisArrangement = interfaceC0604Ip2;
                LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
                this.maxMainAxisIntrinsicItemSize = this.$orientation == layoutOrientation2 ? FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$1.INSTANCE : FlowLayoutKt$flowMeasurePolicy$1$maxMainAxisIntrinsicItemSize$2.INSTANCE;
                this.maxCrossAxisIntrinsicItemSize = this.$orientation == layoutOrientation2 ? FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$1.INSTANCE : FlowLayoutKt$flowMeasurePolicy$1$maxCrossAxisIntrinsicItemSize$2.INSTANCE;
                this.minCrossAxisIntrinsicItemSize = this.$orientation == layoutOrientation2 ? FlowLayoutKt$flowMeasurePolicy$1$minCrossAxisIntrinsicItemSize$1.INSTANCE : FlowLayoutKt$flowMeasurePolicy$1$minCrossAxisIntrinsicItemSize$2.INSTANCE;
                this.minMainAxisIntrinsicItemSize = this.$orientation == layoutOrientation2 ? FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$1.INSTANCE : FlowLayoutKt$flowMeasurePolicy$1$minMainAxisIntrinsicItemSize$2.INSTANCE;
            }

            public final InterfaceC0552Gp getMaxCrossAxisIntrinsicItemSize() {
                return this.maxCrossAxisIntrinsicItemSize;
            }

            public final InterfaceC0552Gp getMaxMainAxisIntrinsicItemSize() {
                return this.maxMainAxisIntrinsicItemSize;
            }

            public final InterfaceC0552Gp getMinCrossAxisIntrinsicItemSize() {
                return this.minCrossAxisIntrinsicItemSize;
            }

            public final InterfaceC0552Gp getMinMainAxisIntrinsicItemSize() {
                return this.minMainAxisIntrinsicItemSize;
            }

            public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, int i2, int i3, int i4) {
                AbstractC4492zt.h(list, "measurables");
                return FlowLayoutKt.intrinsicCrossAxisSize((List<? extends IntrinsicMeasurable>) list, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, i2, i3, i4, this.$maxItemsInMainAxis);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i2) {
                AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
                AbstractC4492zt.h(list, "measurables");
                return this.$orientation == LayoutOrientation.Horizontal ? intrinsicCrossAxisSize(list, i2, intrinsicMeasureScope.mo327roundToPx0680j_4(this.$mainAxisArrangementSpacing), intrinsicMeasureScope.mo327roundToPx0680j_4(this.$crossAxisArrangementSpacing)) : maxIntrinsicMainAxisSize(list, i2, intrinsicMeasureScope.mo327roundToPx0680j_4(this.$mainAxisArrangementSpacing));
            }

            public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, int i2, int i3) {
                AbstractC4492zt.h(list, "measurables");
                return FlowLayoutKt.maxIntrinsicMainAxisSize(list, this.maxMainAxisIntrinsicItemSize, i2, i3, this.$maxItemsInMainAxis);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i2) {
                AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
                AbstractC4492zt.h(list, "measurables");
                return this.$orientation == LayoutOrientation.Horizontal ? maxIntrinsicMainAxisSize(list, i2, intrinsicMeasureScope.mo327roundToPx0680j_4(this.$mainAxisArrangementSpacing)) : intrinsicCrossAxisSize(list, i2, intrinsicMeasureScope.mo327roundToPx0680j_4(this.$mainAxisArrangementSpacing), intrinsicMeasureScope.mo327roundToPx0680j_4(this.$crossAxisArrangementSpacing));
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                int mainAxisTotalSize;
                AbstractC4492zt.h(measureScope, "$this$measure");
                AbstractC4492zt.h(list, "measurables");
                if (list.isEmpty()) {
                    return MeasureScope.CC.q(measureScope, 0, 0, null, FlowLayoutKt$flowMeasurePolicy$1$measure$1.INSTANCE, 4, null);
                }
                RowColumnMeasurementHelper rowColumnMeasurementHelper = new RowColumnMeasurementHelper(this.$orientation, this.$mainAxisArrangement, this.$mainAxisArrangementSpacing, this.$crossAxisSize, this.$crossAxisAlignment, list, new Placeable[list.size()], null);
                FlowResult flowResultM432breakDownItemsw1Onq5I = FlowLayoutKt.m432breakDownItemsw1Onq5I(measureScope, rowColumnMeasurementHelper, this.$orientation, OrientationIndependentConstraints.m454constructorimpl(j, this.$orientation), this.$maxItemsInMainAxis);
                MutableVector<RowColumnMeasureHelperResult> items = flowResultM432breakDownItemsw1Onq5I.getItems();
                int size = items.getSize();
                int[] iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = items.getContent()[i2].getCrossAxisSize();
                }
                int[] iArr2 = new int[size];
                int crossAxisTotalSize = flowResultM432breakDownItemsw1Onq5I.getCrossAxisTotalSize() + (measureScope.mo327roundToPx0680j_4(this.$crossAxisArrangementSpacing) * (items.getSize() - 1));
                this.$crossAxisArrangement.invoke(Integer.valueOf(crossAxisTotalSize), iArr, measureScope.getLayoutDirection(), measureScope, iArr2);
                if (this.$orientation == LayoutOrientation.Horizontal) {
                    crossAxisTotalSize = flowResultM432breakDownItemsw1Onq5I.getMainAxisTotalSize();
                    mainAxisTotalSize = crossAxisTotalSize;
                } else {
                    mainAxisTotalSize = flowResultM432breakDownItemsw1Onq5I.getMainAxisTotalSize();
                }
                return MeasureScope.CC.q(measureScope, ConstraintsKt.m5142constrainWidthK40F9xA(j, crossAxisTotalSize), ConstraintsKt.m5141constrainHeightK40F9xA(j, mainAxisTotalSize), null, new FlowLayoutKt$flowMeasurePolicy$1$measure$2(flowResultM432breakDownItemsw1Onq5I, rowColumnMeasurementHelper, iArr2, measureScope), 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i2) {
                AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
                AbstractC4492zt.h(list, "measurables");
                return this.$orientation == LayoutOrientation.Horizontal ? intrinsicCrossAxisSize(list, i2, intrinsicMeasureScope.mo327roundToPx0680j_4(this.$mainAxisArrangementSpacing), intrinsicMeasureScope.mo327roundToPx0680j_4(this.$crossAxisArrangementSpacing)) : minIntrinsicMainAxisSize(list, i2, intrinsicMeasureScope.mo327roundToPx0680j_4(this.$mainAxisArrangementSpacing), intrinsicMeasureScope.mo327roundToPx0680j_4(this.$crossAxisArrangementSpacing));
            }

            public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, int i2, int i3, int i4) {
                AbstractC4492zt.h(list, "measurables");
                return FlowLayoutKt.minIntrinsicMainAxisSize(list, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, i2, i3, i4, this.$maxItemsInMainAxis);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i2) {
                AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
                AbstractC4492zt.h(list, "measurables");
                return this.$orientation == LayoutOrientation.Horizontal ? minIntrinsicMainAxisSize(list, i2, intrinsicMeasureScope.mo327roundToPx0680j_4(this.$mainAxisArrangementSpacing), intrinsicMeasureScope.mo327roundToPx0680j_4(this.$crossAxisArrangementSpacing)) : intrinsicCrossAxisSize(list, i2, intrinsicMeasureScope.mo327roundToPx0680j_4(this.$mainAxisArrangementSpacing), intrinsicMeasureScope.mo327roundToPx0680j_4(this.$crossAxisArrangementSpacing));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC0604Ip getHorizontalArrangement(Arrangement.Horizontal horizontal) {
        return new AnonymousClass1(horizontal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC0604Ip getVerticalArrangement(Arrangement.Vertical vertical) {
        return new C13451(vertical);
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4) {
        return intrinsicCrossAxisSize(list, new C13461(iArr), new AnonymousClass2(iArr2), i, i2, i3, i4);
    }

    public static final int mainAxisMin(Measurable measurable, LayoutOrientation layoutOrientation, int i) {
        AbstractC4492zt.h(measurable, "<this>");
        AbstractC4492zt.h(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? measurable.minIntrinsicWidth(i) : measurable.minIntrinsicHeight(i);
    }

    public static final int mainAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        AbstractC4492zt.h(placeable, "<this>");
        AbstractC4492zt.h(layoutOrientation, "orientation");
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, InterfaceC0552Gp interfaceC0552Gp, int i, int i2, int i3) {
        int size = list.size();
        int i4 = 0;
        int iMax = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            int iIntValue = ((Number) interfaceC0552Gp.invoke(list.get(i4), Integer.valueOf(i4), Integer.valueOf(i))).intValue() + i2;
            int i7 = i4 + 1;
            if (i7 - i5 == i3 || i7 == list.size()) {
                iMax = Math.max(iMax, (i6 + iIntValue) - i2);
                i5 = i4;
                i6 = 0;
            } else {
                i6 += iIntValue;
            }
            i4 = i7;
        }
        return iMax;
    }

    /* JADX INFO: renamed from: measureAndCache-6m2dt9o, reason: not valid java name */
    private static final int m434measureAndCache6m2dt9o(Measurable measurable, long j, LayoutOrientation layoutOrientation, InterfaceC3750qp interfaceC3750qp) {
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable)) != 0.0f) {
            return mainAxisMin(measurable, layoutOrientation, Integer.MAX_VALUE);
        }
        Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(OrientationIndependentConstraints.m467toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m456copyyUG9Ft0$default(j, 0, 0, 0, 0, 14, null), layoutOrientation));
        interfaceC3750qp.invoke(placeableMo4159measureBRTryo0);
        return mainAxisSize(placeableMo4159measureBRTryo0, layoutOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, int i, int i2, int i3, int i4) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr[i5] = 0;
        }
        int size2 = list.size();
        int[] iArr2 = new int[size2];
        for (int i6 = 0; i6 < size2; i6++) {
            iArr2[i6] = 0;
        }
        int size3 = list.size();
        for (int i7 = 0; i7 < size3; i7++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i7);
            int iIntValue = ((Number) interfaceC0552Gp.invoke(intrinsicMeasurable, Integer.valueOf(i7), Integer.valueOf(i))).intValue();
            iArr[i7] = iIntValue;
            iArr2[i7] = ((Number) interfaceC0552Gp2.invoke(intrinsicMeasurable, Integer.valueOf(i7), Integer.valueOf(iIntValue))).intValue();
        }
        int iH0 = R5.h0(iArr);
        if (size2 == 0) {
            throw new NoSuchElementException();
        }
        int iIntrinsicCrossAxisSize = iArr2[0];
        AbstractC0919Ss it = new C1001Vs(1, R5.N(iArr2)).iterator();
        while (it.hasNext()) {
            int i8 = iArr2[it.nextInt()];
            if (iIntrinsicCrossAxisSize < i8) {
                iIntrinsicCrossAxisSize = i8;
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i9 = iArr[0];
        AbstractC0919Ss it2 = new C1001Vs(1, R5.N(iArr)).iterator();
        while (it2.hasNext()) {
            int i10 = iArr[it2.nextInt()];
            if (i9 < i10) {
                i9 = i10;
            }
        }
        int i11 = iH0;
        while (i9 < i11) {
            if (iIntrinsicCrossAxisSize == i) {
                return iH0;
            }
            int i12 = (i9 + i11) / 2;
            iIntrinsicCrossAxisSize = intrinsicCrossAxisSize(list, iArr, iArr2, i12, i2, i3, i4);
            if (iIntrinsicCrossAxisSize == i) {
                return i12;
            }
            if (iIntrinsicCrossAxisSize > i) {
                i9 = i12 + 1;
            } else {
                i11 = i12 - 1;
            }
            iH0 = i12;
        }
        return iH0;
    }

    @Composable
    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, Composer composer, int i2) {
        AbstractC4492zt.h(horizontal, "horizontalArrangement");
        AbstractC4492zt.h(vertical, "verticalArrangement");
        composer.startReplaceableGroup(1479255111);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i2, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:163)");
        }
        Integer numValueOf = Integer.valueOf(i);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(numValueOf) | composer.changed(horizontal) | composer.changed(vertical);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = m433flowMeasurePolicybs7tms(LayoutOrientation.Horizontal, getHorizontalArrangement(horizontal), horizontal.mo405getSpacingD9Ej5fM(), SizeMode.Wrap, CROSS_AXIS_ALIGNMENT_TOP, getVerticalArrangement(vertical), vertical.mo405getSpacingD9Ej5fM(), i);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, int i, int i2, int i3, int i4) {
        if (list.isEmpty()) {
            return 0;
        }
        Object objE0 = AbstractC3240kc.e0(list, 0);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) objE0;
        int iIntValue = intrinsicMeasurable != null ? ((Number) interfaceC0552Gp2.invoke(intrinsicMeasurable, 0, Integer.valueOf(i))).intValue() : 0;
        int iIntValue2 = intrinsicMeasurable != null ? ((Number) interfaceC0552Gp.invoke(intrinsicMeasurable, 0, Integer.valueOf(iIntValue))).intValue() : 0;
        int size = list.size();
        int i5 = i;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i6 < size) {
            list.get(i6);
            AbstractC4492zt.e(objE0);
            i5 -= iIntValue2;
            int iMax = Math.max(i8, iIntValue);
            i6++;
            Object objE1 = AbstractC3240kc.e0(list, i6);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) objE1;
            int iIntValue3 = intrinsicMeasurable2 != null ? ((Number) interfaceC0552Gp2.invoke(intrinsicMeasurable2, Integer.valueOf(i6), Integer.valueOf(i))).intValue() : 0;
            int iIntValue4 = intrinsicMeasurable2 != null ? ((Number) interfaceC0552Gp.invoke(intrinsicMeasurable2, Integer.valueOf(i6), Integer.valueOf(iIntValue3))).intValue() + i2 : 0;
            if (i5 >= 0 && i6 != list.size()) {
                if (i6 - i9 == i4 || i5 - iIntValue4 < 0) {
                }
                int i10 = iIntValue3;
                i8 = iMax;
                objE0 = objE1;
                iIntValue2 = iIntValue4;
                iIntValue = i10;
            }
            i7 += iMax + i3;
            iIntValue4 -= i2;
            i5 = i;
            i9 = i6;
            iMax = 0;
            int i11 = iIntValue3;
            i8 = iMax;
            objE0 = objE1;
            iIntValue2 = iIntValue4;
            iIntValue = i11;
        }
        return i7 - i3;
    }
}
