package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ScaffoldKt$ScaffoldLayout$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $bottomBar;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ InterfaceC0526Fp $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ InterfaceC0526Fp $snackbar;
    final /* synthetic */ InterfaceC0526Fp $topBar;

    /* JADX INFO: renamed from: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $bottomBar;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ WindowInsets $contentWindowInsets;
        final /* synthetic */ InterfaceC0526Fp $fab;
        final /* synthetic */ int $fabPosition;
        final /* synthetic */ int $layoutHeight;
        final /* synthetic */ int $layoutWidth;
        final /* synthetic */ long $looseConstraints;
        final /* synthetic */ InterfaceC0526Fp $snackbar;
        final /* synthetic */ SubcomposeMeasureScope $this_SubcomposeLayout;
        final /* synthetic */ InterfaceC0526Fp $topBar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SubcomposeMeasureScope subcomposeMeasureScope, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, int i, int i2, WindowInsets windowInsets, long j, InterfaceC0526Fp interfaceC0526Fp4, int i3, InterfaceC0552Gp interfaceC0552Gp, int i4) {
            super(1);
            this.$this_SubcomposeLayout = subcomposeMeasureScope;
            this.$topBar = interfaceC0526Fp;
            this.$snackbar = interfaceC0526Fp2;
            this.$fab = interfaceC0526Fp3;
            this.$fabPosition = i;
            this.$layoutWidth = i2;
            this.$contentWindowInsets = windowInsets;
            this.$looseConstraints = j;
            this.$bottomBar = interfaceC0526Fp4;
            this.$$dirty = i3;
            this.$content = interfaceC0552Gp;
            this.$layoutHeight = i4;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Placeable.PlacementScope) obj);
            return FW.a;
        }

        public final void invoke(Placeable.PlacementScope placementScope) {
            Object next;
            Object next2;
            Object next3;
            FabPlacement fabPlacement;
            Object next4;
            Integer numValueOf;
            int iIntValue;
            Object next5;
            Object next6;
            AbstractC4492zt.h(placementScope, "$this$layout");
            List<Measurable> listSubcompose = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, this.$topBar);
            long j = this.$looseConstraints;
            ArrayList arrayList = new ArrayList(AbstractC2044dc.x(listSubcompose, 10));
            Iterator<T> it = listSubcompose.iterator();
            while (it.hasNext()) {
                arrayList.add(((Measurable) it.next()).mo4159measureBRTryo0(j));
            }
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    int height = ((Placeable) next).getHeight();
                    do {
                        Object next7 = it2.next();
                        int height2 = ((Placeable) next7).getHeight();
                        if (height < height2) {
                            next = next7;
                            height = height2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            Placeable placeable = (Placeable) next;
            int height3 = placeable != null ? placeable.getHeight() : 0;
            List<Measurable> listSubcompose2 = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, this.$snackbar);
            WindowInsets windowInsets = this.$contentWindowInsets;
            SubcomposeMeasureScope subcomposeMeasureScope = this.$this_SubcomposeLayout;
            long j2 = this.$looseConstraints;
            ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(listSubcompose2, 10));
            Iterator<T> it3 = listSubcompose2.iterator();
            while (it3.hasNext()) {
                arrayList2.add(((Measurable) it3.next()).mo4159measureBRTryo0(ConstraintsKt.m5144offsetNN6EwU(j2, (-windowInsets.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets.getBottom(subcomposeMeasureScope))));
            }
            Iterator it4 = arrayList2.iterator();
            if (it4.hasNext()) {
                next2 = it4.next();
                if (it4.hasNext()) {
                    int height4 = ((Placeable) next2).getHeight();
                    do {
                        Object next8 = it4.next();
                        int height5 = ((Placeable) next8).getHeight();
                        if (height4 < height5) {
                            next2 = next8;
                            height4 = height5;
                        }
                    } while (it4.hasNext());
                }
            } else {
                next2 = null;
            }
            Placeable placeable2 = (Placeable) next2;
            int height6 = placeable2 != null ? placeable2.getHeight() : 0;
            Iterator it5 = arrayList2.iterator();
            if (it5.hasNext()) {
                next3 = it5.next();
                if (it5.hasNext()) {
                    int width = ((Placeable) next3).getWidth();
                    do {
                        Object next9 = it5.next();
                        int width2 = ((Placeable) next9).getWidth();
                        if (width < width2) {
                            next3 = next9;
                            width = width2;
                        }
                    } while (it5.hasNext());
                }
            } else {
                next3 = null;
            }
            Placeable placeable3 = (Placeable) next3;
            int width3 = placeable3 != null ? placeable3.getWidth() : 0;
            List<Measurable> listSubcompose3 = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, this.$fab);
            WindowInsets windowInsets2 = this.$contentWindowInsets;
            SubcomposeMeasureScope subcomposeMeasureScope2 = this.$this_SubcomposeLayout;
            long j3 = this.$looseConstraints;
            ArrayList<Placeable> arrayList3 = new ArrayList();
            Iterator<T> it6 = listSubcompose3.iterator();
            while (it6.hasNext()) {
                Placeable placeableMo4159measureBRTryo0 = ((Measurable) it6.next()).mo4159measureBRTryo0(ConstraintsKt.m5144offsetNN6EwU(j3, (-windowInsets2.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection())) - windowInsets2.getRight(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection()), -windowInsets2.getBottom(subcomposeMeasureScope2)));
                if (placeableMo4159measureBRTryo0.getHeight() == 0 || placeableMo4159measureBRTryo0.getWidth() == 0) {
                    placeableMo4159measureBRTryo0 = null;
                }
                if (placeableMo4159measureBRTryo0 != null) {
                    arrayList3.add(placeableMo4159measureBRTryo0);
                }
            }
            if (arrayList3.isEmpty()) {
                fabPlacement = null;
            } else {
                Iterator it7 = arrayList3.iterator();
                if (it7.hasNext()) {
                    next5 = it7.next();
                    if (it7.hasNext()) {
                        int width4 = ((Placeable) next5).getWidth();
                        do {
                            Object next10 = it7.next();
                            int width5 = ((Placeable) next10).getWidth();
                            if (width4 < width5) {
                                next5 = next10;
                                width4 = width5;
                            }
                        } while (it7.hasNext());
                    }
                } else {
                    next5 = null;
                }
                AbstractC4492zt.e(next5);
                int width6 = ((Placeable) next5).getWidth();
                Iterator it8 = arrayList3.iterator();
                if (it8.hasNext()) {
                    next6 = it8.next();
                    if (it8.hasNext()) {
                        int height7 = ((Placeable) next6).getHeight();
                        do {
                            Object next11 = it8.next();
                            int height8 = ((Placeable) next11).getHeight();
                            if (height7 < height8) {
                                next6 = next11;
                                height7 = height8;
                            }
                        } while (it8.hasNext());
                    }
                } else {
                    next6 = null;
                }
                AbstractC4492zt.e(next6);
                int height9 = ((Placeable) next6).getHeight();
                fabPlacement = new FabPlacement(FabPosition.m1566equalsimpl0(this.$fabPosition, FabPosition.Companion.m1571getEndERTFSPs()) ? this.$this_SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (this.$layoutWidth - this.$this_SubcomposeLayout.mo327roundToPx0680j_4(ScaffoldKt.FabSpacing)) - width6 : this.$this_SubcomposeLayout.mo327roundToPx0680j_4(ScaffoldKt.FabSpacing) : (this.$layoutWidth - width6) / 2, width6, height9);
            }
            List<Measurable> listSubcompose4 = this.$this_SubcomposeLayout.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(-1455477816, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1(fabPlacement, this.$bottomBar, this.$$dirty)));
            long j4 = this.$looseConstraints;
            ArrayList arrayList4 = new ArrayList(AbstractC2044dc.x(listSubcompose4, 10));
            Iterator<T> it9 = listSubcompose4.iterator();
            while (it9.hasNext()) {
                arrayList4.add(((Measurable) it9.next()).mo4159measureBRTryo0(j4));
            }
            Iterator it10 = arrayList4.iterator();
            if (it10.hasNext()) {
                next4 = it10.next();
                if (it10.hasNext()) {
                    int height10 = ((Placeable) next4).getHeight();
                    do {
                        Object next12 = it10.next();
                        int height11 = ((Placeable) next12).getHeight();
                        if (height10 < height11) {
                            next4 = next12;
                            height10 = height11;
                        }
                    } while (it10.hasNext());
                }
            } else {
                next4 = null;
            }
            Placeable placeable4 = (Placeable) next4;
            Integer numValueOf2 = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
            if (fabPlacement != null) {
                SubcomposeMeasureScope subcomposeMeasureScope3 = this.$this_SubcomposeLayout;
                numValueOf = Integer.valueOf(numValueOf2 == null ? fabPlacement.getHeight() + subcomposeMeasureScope3.mo327roundToPx0680j_4(ScaffoldKt.FabSpacing) + this.$contentWindowInsets.getBottom(subcomposeMeasureScope3) : numValueOf2.intValue() + fabPlacement.getHeight() + subcomposeMeasureScope3.mo327roundToPx0680j_4(ScaffoldKt.FabSpacing));
            } else {
                numValueOf = null;
            }
            if (height6 != 0) {
                iIntValue = height6 + (numValueOf != null ? numValueOf.intValue() : numValueOf2 != null ? numValueOf2.intValue() : this.$contentWindowInsets.getBottom(this.$this_SubcomposeLayout));
            } else {
                iIntValue = 0;
            }
            SubcomposeMeasureScope subcomposeMeasureScope4 = this.$this_SubcomposeLayout;
            List<Measurable> listSubcompose5 = subcomposeMeasureScope4.subcompose(ScaffoldLayoutContent.MainContent, ComposableLambdaKt.composableLambdaInstance(1643221465, true, new ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(this.$contentWindowInsets, subcomposeMeasureScope4, arrayList, height3, arrayList4, numValueOf2, this.$content, this.$$dirty)));
            long j5 = this.$looseConstraints;
            ArrayList arrayList5 = new ArrayList(AbstractC2044dc.x(listSubcompose5, 10));
            Iterator<T> it11 = listSubcompose5.iterator();
            while (it11.hasNext()) {
                arrayList5.add(((Measurable) it11.next()).mo4159measureBRTryo0(j5));
            }
            Iterator it12 = arrayList5.iterator();
            while (it12.hasNext()) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) it12.next(), 0, 0, 0.0f, 4, null);
                arrayList4 = arrayList4;
                arrayList = arrayList;
            }
            ArrayList arrayList6 = arrayList4;
            Iterator it13 = arrayList.iterator();
            while (it13.hasNext()) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) it13.next(), 0, 0, 0.0f, 4, null);
            }
            int i = this.$layoutWidth;
            WindowInsets windowInsets3 = this.$contentWindowInsets;
            SubcomposeMeasureScope subcomposeMeasureScope5 = this.$this_SubcomposeLayout;
            int i2 = this.$layoutHeight;
            Iterator it14 = arrayList2.iterator();
            while (it14.hasNext()) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) it14.next(), windowInsets3.getLeft(subcomposeMeasureScope5, subcomposeMeasureScope5.getLayoutDirection()) + ((i - width3) / 2), i2 - iIntValue, 0.0f, 4, null);
            }
            int i3 = this.$layoutHeight;
            Iterator it15 = arrayList6.iterator();
            while (it15.hasNext()) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) it15.next(), 0, i3 - (numValueOf2 != null ? numValueOf2.intValue() : 0), 0.0f, 4, null);
            }
            if (fabPlacement != null) {
                int i4 = this.$layoutHeight;
                for (Placeable placeable5 : arrayList3) {
                    int left = fabPlacement.getLeft();
                    AbstractC4492zt.e(numValueOf);
                    Placeable.PlacementScope.place$default(placementScope, placeable5, left, i4 - numValueOf.intValue(), 0.0f, 4, null);
                }
                FW fw = FW.a;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$ScaffoldLayout$1$1(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, int i, WindowInsets windowInsets, InterfaceC0526Fp interfaceC0526Fp4, int i2, InterfaceC0552Gp interfaceC0552Gp) {
        super(2);
        this.$topBar = interfaceC0526Fp;
        this.$snackbar = interfaceC0526Fp2;
        this.$fab = interfaceC0526Fp3;
        this.$fabPosition = i;
        this.$contentWindowInsets = windowInsets;
        this.$bottomBar = interfaceC0526Fp4;
        this.$$dirty = i2;
        this.$content = interfaceC0552Gp;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m1728invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m1728invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        AbstractC4492zt.h(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        int iM5127getMaxHeightimpl = Constraints.m5127getMaxHeightimpl(j);
        return MeasureScope.CC.q(subcomposeMeasureScope, iM5128getMaxWidthimpl, iM5127getMaxHeightimpl, null, new AnonymousClass1(subcomposeMeasureScope, this.$topBar, this.$snackbar, this.$fab, this.$fabPosition, iM5128getMaxWidthimpl, this.$contentWindowInsets, Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null), this.$bottomBar, this.$$dirty, this.$content, iM5127getMaxHeightimpl), 4, null);
    }
}
