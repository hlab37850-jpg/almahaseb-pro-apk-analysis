package androidx.compose.material;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import defpackage.AD;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0552Gp $body;
    final /* synthetic */ InterfaceC0552Gp $bottomSheet;
    final /* synthetic */ InterfaceC0526Fp $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ InterfaceC3588op $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ BottomSheetState $sheetState;
    final /* synthetic */ InterfaceC0526Fp $snackbarHost;
    final /* synthetic */ InterfaceC0526Fp $topBar;

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ List<Placeable> $bodyPlaceables;
        final /* synthetic */ int $fabOffsetX;
        final /* synthetic */ int $fabOffsetY;
        final /* synthetic */ List<Placeable> $fabPlaceable;
        final /* synthetic */ int $sheetOffsetY;
        final /* synthetic */ List<Placeable> $sheetPlaceables;
        final /* synthetic */ int $snackbarOffsetX;
        final /* synthetic */ int $snackbarOffsetY;
        final /* synthetic */ List<Placeable> $snackbarPlaceables;
        final /* synthetic */ int $topBarHeight;
        final /* synthetic */ List<Placeable> $topBarPlaceables;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(List<? extends Placeable> list, List<? extends Placeable> list2, List<? extends Placeable> list3, List<? extends Placeable> list4, List<? extends Placeable> list5, int i, int i2, int i3, int i4, int i5, int i6) {
            super(1);
            this.$bodyPlaceables = list;
            this.$topBarPlaceables = list2;
            this.$sheetPlaceables = list3;
            this.$fabPlaceable = list4;
            this.$snackbarPlaceables = list5;
            this.$topBarHeight = i;
            this.$sheetOffsetY = i2;
            this.$fabOffsetX = i3;
            this.$fabOffsetY = i4;
            this.$snackbarOffsetX = i5;
            this.$snackbarOffsetY = i6;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Placeable.PlacementScope) obj);
            return FW.a;
        }

        public final void invoke(Placeable.PlacementScope placementScope) {
            AbstractC4492zt.h(placementScope, "$this$layout");
            List<Placeable> list = this.$bodyPlaceables;
            int i = this.$topBarHeight;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i2), 0, i, 0.0f, 4, null);
            }
            List<Placeable> list2 = this.$topBarPlaceables;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list2.get(i3), 0, 0, 0.0f, 4, null);
                }
            }
            List<Placeable> list3 = this.$sheetPlaceables;
            int i4 = this.$sheetOffsetY;
            int size3 = list3.size();
            for (int i5 = 0; i5 < size3; i5++) {
                Placeable.PlacementScope.placeRelative$default(placementScope, list3.get(i5), 0, i4, 0.0f, 4, null);
            }
            List<Placeable> list4 = this.$fabPlaceable;
            if (list4 != null) {
                int i6 = this.$fabOffsetX;
                int i7 = this.$fabOffsetY;
                int size4 = list4.size();
                for (int i8 = 0; i8 < size4; i8++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list4.get(i8), i6, i7, 0.0f, 4, null);
                }
            }
            List<Placeable> list5 = this.$snackbarPlaceables;
            int i9 = this.$snackbarOffsetX;
            int i10 = this.$snackbarOffsetY;
            int size5 = list5.size();
            for (int i11 = 0; i11 < size5; i11++) {
                Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i11), i9, i10, 0.0f, 4, null);
            }
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            try {
                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(InterfaceC3588op interfaceC3588op, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i, float f, InterfaceC0526Fp interfaceC0526Fp3, BottomSheetState bottomSheetState, InterfaceC0552Gp interfaceC0552Gp, int i2, InterfaceC0552Gp interfaceC0552Gp2) {
        super(2);
        this.$sheetOffset = interfaceC3588op;
        this.$topBar = interfaceC0526Fp;
        this.$floatingActionButton = interfaceC0526Fp2;
        this.$floatingActionButtonPosition = i;
        this.$sheetPeekHeight = f;
        this.$snackbarHost = interfaceC0526Fp3;
        this.$sheetState = bottomSheetState;
        this.$bottomSheet = interfaceC0552Gp;
        this.$$dirty = i2;
        this.$body = interfaceC0552Gp2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m1014invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:59:0x019c  */
    /* JADX WARN: Code duplicated, block: B:76:0x01df  */
    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m1014invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        ArrayList arrayList;
        int height;
        ArrayList arrayList2;
        int width;
        int height2;
        Object obj;
        Object obj2;
        int i;
        Object obj3;
        Object obj4;
        Object obj5;
        AbstractC4492zt.h(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        long jM5119copyZbe2FdA$default = Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Sheet, ComposableLambdaKt.composableLambdaInstance(835355605, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceables$1(this.$bottomSheet, iM5127getMaxHeightimpl, this.$$dirty)));
        ArrayList arrayList3 = new ArrayList(AbstractC2044dc.x(listSubcompose, 10));
        Iterator<T> it = listSubcompose.iterator();
        while (it.hasNext()) {
            arrayList3.add(((Measurable) it.next()).mo4159measureBRTryo0(jM5119copyZbe2FdA$default));
        }
        int iC = AbstractC1210aB.c(((Number) this.$sheetOffset.invoke()).floatValue());
        InterfaceC0526Fp interfaceC0526Fp = this.$topBar;
        if (interfaceC0526Fp != null) {
            List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, interfaceC0526Fp);
            ArrayList arrayList4 = new ArrayList(AbstractC2044dc.x(listSubcompose2, 10));
            Iterator<T> it2 = listSubcompose2.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((Measurable) it2.next()).mo4159measureBRTryo0(jM5119copyZbe2FdA$default));
            }
            arrayList = arrayList4;
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            height = 0;
        } else {
            if (!arrayList.isEmpty()) {
                obj5 = arrayList.get(0);
                int height3 = ((Placeable) obj5).getHeight();
                int iO = AbstractC1886cc.o(arrayList);
                if (1 <= iO) {
                    int i2 = 1;
                    while (true) {
                        Object obj6 = arrayList.get(i2);
                        int height4 = ((Placeable) obj6).getHeight();
                        if (height3 < height4) {
                            height3 = height4;
                            obj5 = obj6;
                        }
                        if (i2 == iO) {
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                obj5 = null;
            }
            Placeable placeable = (Placeable) obj5;
            if (placeable != null) {
                height = placeable.getHeight();
            } else {
                height = 0;
            }
        }
        long jM5119copyZbe2FdA$default2 = Constraints.m5119copyZbe2FdA$default(jM5119copyZbe2FdA$default, 0, 0, 0, iM5127getMaxHeightimpl - height, 7, null);
        List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Body, ComposableLambdaKt.composableLambdaInstance(-2019457358, true, new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceables$1(this.$body, this.$sheetPeekHeight, this.$$dirty)));
        ArrayList arrayList5 = new ArrayList(AbstractC2044dc.x(listSubcompose3, 10));
        Iterator<T> it3 = listSubcompose3.iterator();
        while (it3.hasNext()) {
            arrayList5.add(((Measurable) it3.next()).mo4159measureBRTryo0(jM5119copyZbe2FdA$default2));
        }
        InterfaceC0526Fp interfaceC0526Fp2 = this.$floatingActionButton;
        if (interfaceC0526Fp2 != null) {
            List<Measurable> listSubcompose4 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Fab, interfaceC0526Fp2);
            ArrayList arrayList6 = new ArrayList(AbstractC2044dc.x(listSubcompose4, 10));
            Iterator<T> it4 = listSubcompose4.iterator();
            while (it4.hasNext()) {
                arrayList6.add(((Measurable) it4.next()).mo4159measureBRTryo0(jM5119copyZbe2FdA$default));
            }
            arrayList2 = arrayList6;
        } else {
            arrayList2 = null;
        }
        if (arrayList2 == null) {
            width = 0;
        } else {
            if (!arrayList2.isEmpty()) {
                obj4 = arrayList2.get(0);
                int width2 = ((Placeable) obj4).getWidth();
                int iO2 = AbstractC1886cc.o(arrayList2);
                if (1 <= iO2) {
                    int i3 = 1;
                    while (true) {
                        Object obj7 = arrayList2.get(i3);
                        Object obj8 = obj4;
                        int width3 = ((Placeable) obj7).getWidth();
                        if (width2 < width3) {
                            width2 = width3;
                            obj4 = obj7;
                        } else {
                            obj4 = obj8;
                        }
                        if (i3 == iO2) {
                            break;
                        }
                        i3++;
                    }
                }
            } else {
                obj4 = null;
            }
            Placeable placeable2 = (Placeable) obj4;
            if (placeable2 != null) {
                width = placeable2.getWidth();
            } else {
                width = 0;
            }
        }
        if (arrayList2 == null) {
            height2 = 0;
        } else {
            if (!arrayList2.isEmpty()) {
                obj3 = arrayList2.get(0);
                int height5 = ((Placeable) obj3).getHeight();
                int iO3 = AbstractC1886cc.o(arrayList2);
                if (1 <= iO3) {
                    int i4 = 1;
                    while (true) {
                        Object obj9 = arrayList2.get(i4);
                        Object obj10 = obj3;
                        int height6 = ((Placeable) obj9).getHeight();
                        if (height5 < height6) {
                            height5 = height6;
                            obj3 = obj9;
                        } else {
                            obj3 = obj10;
                        }
                        if (i4 == iO3) {
                            break;
                        }
                        i4++;
                    }
                }
            } else {
                obj3 = null;
            }
            Placeable placeable3 = (Placeable) obj3;
            if (placeable3 != null) {
                height2 = placeable3.getHeight();
            } else {
                height2 = 0;
            }
        }
        int iMo327roundToPx0680j_4 = FabPosition.m1125equalsimpl0(this.$floatingActionButtonPosition, FabPosition.Companion.m1129getCenter5ygKITE()) ? (iM5128getMaxWidthimpl - width) / 2 : (iM5128getMaxWidthimpl - width) - subcomposeMeasureScope.mo327roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
        int i5 = height2 / 2;
        int iMo327roundToPx0680j_5 = subcomposeMeasureScope.mo333toPx0680j_4(this.$sheetPeekHeight) < ((float) i5) ? (iC - height2) - subcomposeMeasureScope.mo327roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing) : iC - i5;
        List<Measurable> listSubcompose5 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, this.$snackbarHost);
        ArrayList arrayList7 = new ArrayList(AbstractC2044dc.x(listSubcompose5, 10));
        Iterator<T> it5 = listSubcompose5.iterator();
        while (it5.hasNext()) {
            arrayList7.add(((Measurable) it5.next()).mo4159measureBRTryo0(jM5119copyZbe2FdA$default));
        }
        if (!arrayList7.isEmpty()) {
            obj = arrayList7.get(0);
            int width4 = ((Placeable) obj).getWidth();
            int iO4 = AbstractC1886cc.o(arrayList7);
            if (1 <= iO4) {
                int i6 = 1;
                while (true) {
                    Object obj11 = arrayList7.get(i6);
                    int width5 = ((Placeable) obj11).getWidth();
                    if (width4 < width5) {
                        width4 = width5;
                        obj = obj11;
                    }
                    if (i6 == iO4) {
                        break;
                    }
                    i6++;
                }
            }
        } else {
            obj = null;
        }
        Placeable placeable4 = (Placeable) obj;
        int width6 = placeable4 != null ? placeable4.getWidth() : 0;
        if (!arrayList7.isEmpty()) {
            obj2 = arrayList7.get(0);
            int height7 = ((Placeable) obj2).getHeight();
            int iO5 = AbstractC1886cc.o(arrayList7);
            if (1 <= iO5) {
                int i7 = height7;
                int i8 = 1;
                while (true) {
                    Object obj12 = arrayList7.get(i8);
                    int height8 = ((Placeable) obj12).getHeight();
                    if (i7 < height8) {
                        i7 = height8;
                        obj2 = obj12;
                    }
                    if (i8 == iO5) {
                        break;
                    }
                    i8++;
                }
            }
        } else {
            obj2 = null;
        }
        Placeable placeable5 = (Placeable) obj2;
        int height9 = placeable5 != null ? placeable5.getHeight() : 0;
        int i9 = (iM5128getMaxWidthimpl - width6) / 2;
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.$sheetState.getCurrentValue().ordinal()];
        if (i10 == 1) {
            i = iMo327roundToPx0680j_5 - height9;
        } else {
            if (i10 != 2) {
                throw new AD();
            }
            i = iM5127getMaxHeightimpl - height9;
        }
        return MeasureScope.CC.q(subcomposeMeasureScope, iM5128getMaxWidthimpl, iM5127getMaxHeightimpl, null, new AnonymousClass1(arrayList5, arrayList, arrayList3, arrayList2, arrayList7, height, iC, iMo327roundToPx0680j_4, iMo327roundToPx0680j_5, i9, i), 4, null);
    }
}
