package androidx.compose.material3;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import defpackage.AD;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0552Gp $body;
    final /* synthetic */ InterfaceC0552Gp $bottomSheet;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ InterfaceC3588op $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ InterfaceC0526Fp $snackbarHost;
    final /* synthetic */ InterfaceC0526Fp $topBar;

    /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Placeable $bodyPlaceable;
        final /* synthetic */ int $sheetOffsetX;
        final /* synthetic */ int $sheetOffsetY;
        final /* synthetic */ Placeable $sheetPlaceable;
        final /* synthetic */ int $snackbarOffsetX;
        final /* synthetic */ int $snackbarOffsetY;
        final /* synthetic */ Placeable $snackbarPlaceable;
        final /* synthetic */ int $topBarHeight;
        final /* synthetic */ Placeable $topBarPlaceable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Placeable placeable, int i, Placeable placeable2, Placeable placeable3, int i2, int i3, Placeable placeable4, int i4, int i5) {
            super(1);
            this.$bodyPlaceable = placeable;
            this.$topBarHeight = i;
            this.$topBarPlaceable = placeable2;
            this.$sheetPlaceable = placeable3;
            this.$sheetOffsetX = i2;
            this.$sheetOffsetY = i3;
            this.$snackbarPlaceable = placeable4;
            this.$snackbarOffsetX = i4;
            this.$snackbarOffsetY = i5;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Placeable.PlacementScope) obj);
            return FW.a;
        }

        public final void invoke(Placeable.PlacementScope placementScope) {
            AbstractC4492zt.h(placementScope, "$this$layout");
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$bodyPlaceable, 0, this.$topBarHeight, 0.0f, 4, null);
            Placeable placeable = this.$topBarPlaceable;
            if (placeable != null) {
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$sheetPlaceable, this.$sheetOffsetX, this.$sheetOffsetY, 0.0f, 4, null);
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$snackbarPlaceable, this.$snackbarOffsetX, this.$snackbarOffsetY, 0.0f, 4, null);
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetValue.Hidden.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, SheetState sheetState, InterfaceC0552Gp interfaceC0552Gp, int i, Modifier modifier, long j, long j2, InterfaceC0552Gp interfaceC0552Gp2, float f) {
        super(2);
        this.$sheetOffset = interfaceC3588op;
        this.$topBar = interfaceC0526Fp;
        this.$snackbarHost = interfaceC0526Fp2;
        this.$sheetState = sheetState;
        this.$bottomSheet = interfaceC0552Gp;
        this.$$dirty = i;
        this.$modifier = modifier;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$body = interfaceC0552Gp2;
        this.$sheetPeekHeight = f;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m1354invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m1354invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        Placeable placeableMo4159measureBRTryo0;
        int height;
        AbstractC4492zt.h(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        long jM5119copyZbe2FdA$default = Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        Placeable placeableMo4159measureBRTryo1 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Sheet, ComposableLambdaKt.composableLambdaInstance(-1192048628, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceable$1(this.$bottomSheet, iM5127getMaxHeightimpl, this.$$dirty))).get(0).mo4159measureBRTryo0(jM5119copyZbe2FdA$default);
        int iC = AbstractC1210aB.c(((Number) this.$sheetOffset.invoke()).floatValue());
        int iMax = Math.max(0, (iM5128getMaxWidthimpl - placeableMo4159measureBRTryo1.getWidth()) / 2);
        InterfaceC0526Fp interfaceC0526Fp = this.$topBar;
        if (interfaceC0526Fp != null) {
            placeableMo4159measureBRTryo0 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(-873203005, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$topBarPlaceable$1$1(interfaceC0526Fp, this.$$dirty))).get(0).mo4159measureBRTryo0(jM5119copyZbe2FdA$default);
        } else {
            placeableMo4159measureBRTryo0 = null;
        }
        Placeable placeable = placeableMo4159measureBRTryo0;
        int height2 = placeable != null ? placeable.getHeight() : 0;
        Placeable placeableMo4159measureBRTryo2 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Body, ComposableLambdaKt.composableLambdaInstance(-1459220575, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1(this.$modifier, this.$containerColor, this.$contentColor, this.$$dirty, this.$body, this.$sheetPeekHeight))).get(0).mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(jM5119copyZbe2FdA$default, 0, 0, 0, iM5127getMaxHeightimpl - height2, 7, null));
        Placeable placeableMo4159measureBRTryo3 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, this.$snackbarHost).get(0).mo4159measureBRTryo0(jM5119copyZbe2FdA$default);
        int width = (iM5128getMaxWidthimpl - placeableMo4159measureBRTryo3.getWidth()) / 2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.$sheetState.getCurrentValue().ordinal()];
        if (i == 1) {
            height = iC - placeableMo4159measureBRTryo3.getHeight();
        } else {
            if (i != 2 && i != 3) {
                throw new AD();
            }
            height = iM5127getMaxHeightimpl - placeableMo4159measureBRTryo3.getHeight();
        }
        return MeasureScope.CC.q(subcomposeMeasureScope, iM5128getMaxWidthimpl, iM5127getMaxHeightimpl, null, new AnonymousClass1(placeableMo4159measureBRTryo2, height2, placeable, placeableMo4159measureBRTryo1, iMax, iC, placeableMo4159measureBRTryo3, width, height), 4, null);
    }
}
