package androidx.compose.material;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ScaffoldKt$ScaffoldLayout$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $bottomBar;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ InterfaceC0526Fp $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ boolean $isFabDocked;
    final /* synthetic */ InterfaceC0526Fp $snackbar;
    final /* synthetic */ InterfaceC0526Fp $topBar;

    /* JADX INFO: renamed from: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $bottomBar;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ InterfaceC0526Fp $fab;
        final /* synthetic */ int $fabPosition;
        final /* synthetic */ boolean $isFabDocked;
        final /* synthetic */ int $layoutHeight;
        final /* synthetic */ int $layoutWidth;
        final /* synthetic */ long $looseConstraints;
        final /* synthetic */ InterfaceC0526Fp $snackbar;
        final /* synthetic */ SubcomposeMeasureScope $this_SubcomposeLayout;
        final /* synthetic */ InterfaceC0526Fp $topBar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SubcomposeMeasureScope subcomposeMeasureScope, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, int i, int i2, boolean z, int i3, long j, InterfaceC0526Fp interfaceC0526Fp4, int i4, InterfaceC0552Gp interfaceC0552Gp) {
            super(1);
            this.$this_SubcomposeLayout = subcomposeMeasureScope;
            this.$topBar = interfaceC0526Fp;
            this.$snackbar = interfaceC0526Fp2;
            this.$fab = interfaceC0526Fp3;
            this.$fabPosition = i;
            this.$layoutWidth = i2;
            this.$isFabDocked = z;
            this.$layoutHeight = i3;
            this.$looseConstraints = j;
            this.$bottomBar = interfaceC0526Fp4;
            this.$$dirty = i4;
            this.$content = interfaceC0552Gp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Placeable.PlacementScope) obj);
            return FW.a;
        }

        /* JADX WARN: Code duplicated, block: B:83:0x01ba  */
        public final void invoke(Placeable.PlacementScope placementScope) {
            Object obj;
            Object obj2;
            FabPlacement fabPlacement;
            Object obj3;
            Integer numValueOf;
            int height;
            int iMo327roundToPx0680j_4;
            int height2;
            Object obj4;
            Object obj5;
            AbstractC4492zt.h(placementScope, "$this$layout");
            List<Measurable> listSubcompose = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, this.$topBar);
            long j = this.$looseConstraints;
            ArrayList arrayList = new ArrayList(listSubcompose.size());
            int size = listSubcompose.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(listSubcompose.get(i2).mo4159measureBRTryo0(j));
            }
            if (!arrayList.isEmpty()) {
                obj = arrayList.get(0);
                int height3 = ((Placeable) obj).getHeight();
                int iO = AbstractC1886cc.o(arrayList);
                if (1 <= iO) {
                    int i3 = 1;
                    while (true) {
                        Object obj6 = arrayList.get(i3);
                        int height4 = ((Placeable) obj6).getHeight();
                        if (height3 < height4) {
                            obj = obj6;
                            height3 = height4;
                        }
                        if (i3 == iO) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            } else {
                obj = null;
            }
            Placeable placeable = (Placeable) obj;
            int height5 = placeable != null ? placeable.getHeight() : 0;
            List<Measurable> listSubcompose2 = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, this.$snackbar);
            long j2 = this.$looseConstraints;
            ArrayList arrayList2 = new ArrayList(listSubcompose2.size());
            int size2 = listSubcompose2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                arrayList2.add(listSubcompose2.get(i4).mo4159measureBRTryo0(j2));
            }
            if (!arrayList2.isEmpty()) {
                obj2 = arrayList2.get(0);
                int height6 = ((Placeable) obj2).getHeight();
                int iO2 = AbstractC1886cc.o(arrayList2);
                if (1 <= iO2) {
                    int i5 = 1;
                    while (true) {
                        Object obj7 = arrayList2.get(i5);
                        int height7 = ((Placeable) obj7).getHeight();
                        if (height6 < height7) {
                            obj2 = obj7;
                            height6 = height7;
                        }
                        if (i5 == iO2) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
            } else {
                obj2 = null;
            }
            Placeable placeable2 = (Placeable) obj2;
            int height8 = placeable2 != null ? placeable2.getHeight() : 0;
            List<Measurable> listSubcompose3 = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, this.$fab);
            long j3 = this.$looseConstraints;
            ArrayList arrayList3 = new ArrayList(listSubcompose3.size());
            int size3 = listSubcompose3.size();
            for (int i6 = 0; i6 < size3; i6++) {
                arrayList3.add(listSubcompose3.get(i6).mo4159measureBRTryo0(j3));
            }
            if (arrayList3.isEmpty()) {
                fabPlacement = null;
            } else {
                if (!arrayList3.isEmpty()) {
                    obj4 = arrayList3.get(0);
                    int width = ((Placeable) obj4).getWidth();
                    int iO3 = AbstractC1886cc.o(arrayList3);
                    if (1 <= iO3) {
                        int i7 = 1;
                        while (true) {
                            Object obj8 = arrayList3.get(i7);
                            int width2 = ((Placeable) obj8).getWidth();
                            if (width < width2) {
                                obj4 = obj8;
                                width = width2;
                            }
                            if (i7 == iO3) {
                                break;
                            } else {
                                i7++;
                            }
                        }
                    }
                } else {
                    obj4 = null;
                }
                Placeable placeable3 = (Placeable) obj4;
                int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                if (!arrayList3.isEmpty()) {
                    obj5 = arrayList3.get(0);
                    int height9 = ((Placeable) obj5).getHeight();
                    int iO4 = AbstractC1886cc.o(arrayList3);
                    if (1 <= iO4) {
                        int i8 = 1;
                        while (true) {
                            Object obj9 = arrayList3.get(i8);
                            int height10 = ((Placeable) obj9).getHeight();
                            if (height9 < height10) {
                                height9 = height10;
                                obj5 = obj9;
                            }
                            if (i8 == iO4) {
                                break;
                            } else {
                                i8++;
                            }
                        }
                    }
                } else {
                    obj5 = null;
                }
                Placeable placeable4 = (Placeable) obj5;
                int height11 = placeable4 != null ? placeable4.getHeight() : 0;
                if (width3 == 0 || height11 == 0) {
                    fabPlacement = null;
                } else {
                    fabPlacement = new FabPlacement(this.$isFabDocked, FabPosition.m1125equalsimpl0(this.$fabPosition, FabPosition.Companion.m1130getEnd5ygKITE()) ? this.$this_SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (this.$layoutWidth - this.$this_SubcomposeLayout.mo327roundToPx0680j_4(ScaffoldKt.FabSpacing)) - width3 : this.$this_SubcomposeLayout.mo327roundToPx0680j_4(ScaffoldKt.FabSpacing) : (this.$layoutWidth - width3) / 2, width3, height11);
                }
            }
            List<Measurable> listSubcompose4 = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(1529070963, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(fabPlacement, this.$bottomBar, this.$$dirty)));
            long j4 = this.$looseConstraints;
            ArrayList arrayList4 = new ArrayList(listSubcompose4.size());
            int size4 = listSubcompose4.size();
            for (int i9 = 0; i9 < size4; i9++) {
                arrayList4.add(listSubcompose4.get(i9).mo4159measureBRTryo0(j4));
            }
            if (!arrayList4.isEmpty()) {
                obj3 = arrayList4.get(0);
                int height12 = ((Placeable) obj3).getHeight();
                int iO5 = AbstractC1886cc.o(arrayList4);
                if (1 <= iO5) {
                    int i10 = 1;
                    while (true) {
                        Object obj10 = arrayList4.get(i10);
                        int height13 = ((Placeable) obj10).getHeight();
                        if (height12 < height13) {
                            obj3 = obj10;
                            height12 = height13;
                        }
                        if (i10 == iO5) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
            } else {
                obj3 = null;
            }
            Placeable placeable5 = (Placeable) obj3;
            int height14 = placeable5 != null ? placeable5.getHeight() : 0;
            if (fabPlacement != null) {
                SubcomposeMeasureScope subcomposeMeasureScope = this.$this_SubcomposeLayout;
                boolean z = this.$isFabDocked;
                if (height14 == 0) {
                    height = fabPlacement.getHeight();
                    iMo327roundToPx0680j_4 = subcomposeMeasureScope.mo327roundToPx0680j_4(ScaffoldKt.FabSpacing);
                } else {
                    if (z) {
                        height2 = height14 + (fabPlacement.getHeight() / 2);
                    } else {
                        height = fabPlacement.getHeight() + height14;
                        iMo327roundToPx0680j_4 = subcomposeMeasureScope.mo327roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    numValueOf = Integer.valueOf(height2);
                }
                height2 = height + iMo327roundToPx0680j_4;
                numValueOf = Integer.valueOf(height2);
            } else {
                numValueOf = null;
            }
            int iIntValue = height8 != 0 ? height8 + (numValueOf != null ? numValueOf.intValue() : height14) : 0;
            int i11 = this.$layoutHeight - height5;
            SubcomposeMeasureScope subcomposeMeasureScope2 = this.$this_SubcomposeLayout;
            List<Measurable> listSubcompose5 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(-1132241596, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(subcomposeMeasureScope2, height14, this.$content, this.$$dirty)));
            long j5 = this.$looseConstraints;
            ArrayList arrayList5 = new ArrayList(listSubcompose5.size());
            int size5 = listSubcompose5.size();
            while (i < size5) {
                arrayList5.add(listSubcompose5.get(i).mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j5, 0, 0, 0, i11, 7, null)));
                i++;
                listSubcompose5 = listSubcompose5;
                j5 = j5;
            }
            int size6 = arrayList5.size();
            int i12 = 0;
            while (i12 < size6) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList5.get(i12), 0, height5, 0.0f, 4, null);
                i12++;
                height14 = height14;
                arrayList5 = arrayList5;
            }
            int i13 = height14;
            int size7 = arrayList.size();
            for (int i14 = 0; i14 < size7; i14++) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList.get(i14), 0, 0, 0.0f, 4, null);
            }
            int i15 = this.$layoutHeight;
            int size8 = arrayList2.size();
            for (int i16 = 0; i16 < size8; i16++) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList2.get(i16), 0, i15 - iIntValue, 0.0f, 4, null);
            }
            int i17 = this.$layoutHeight;
            int size9 = arrayList4.size();
            for (int i18 = 0; i18 < size9; i18++) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList4.get(i18), 0, i17 - i13, 0.0f, 4, null);
            }
            int i19 = this.$layoutHeight;
            int size10 = arrayList3.size();
            for (int i20 = 0; i20 < size10; i20++) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList3.get(i20), fabPlacement != null ? fabPlacement.getLeft() : 0, i19 - (numValueOf != null ? numValueOf.intValue() : 0), 0.0f, 4, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$ScaffoldLayout$1$1(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, int i, boolean z, InterfaceC0526Fp interfaceC0526Fp4, int i2, InterfaceC0552Gp interfaceC0552Gp) {
        super(2);
        this.$topBar = interfaceC0526Fp;
        this.$snackbar = interfaceC0526Fp2;
        this.$fab = interfaceC0526Fp3;
        this.$fabPosition = i;
        this.$isFabDocked = z;
        this.$bottomBar = interfaceC0526Fp4;
        this.$$dirty = i2;
        this.$content = interfaceC0552Gp;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m1197invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m1197invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        AbstractC4492zt.h(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        return MeasureScope.CC.q(subcomposeMeasureScope, iM5128getMaxWidthimpl, iM5127getMaxHeightimpl, null, new AnonymousClass1(subcomposeMeasureScope, this.$topBar, this.$snackbar, this.$fab, this.$fabPosition, iM5128getMaxWidthimpl, this.$isFabDocked, iM5127getMaxHeightimpl, Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null), this.$bottomBar, this.$$dirty, this.$content), 4, null);
    }
}
