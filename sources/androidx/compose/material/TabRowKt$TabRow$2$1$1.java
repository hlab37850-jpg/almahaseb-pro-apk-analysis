package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC1886cc;
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
public final class TabRowKt$TabRow$2$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $divider;
    final /* synthetic */ InterfaceC0552Gp $indicator;
    final /* synthetic */ InterfaceC0526Fp $tabs;

    /* JADX INFO: renamed from: androidx.compose.material.TabRowKt$TabRow$2$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ long $constraints;
        final /* synthetic */ InterfaceC0526Fp $divider;
        final /* synthetic */ InterfaceC0552Gp $indicator;
        final /* synthetic */ List<Placeable> $tabPlaceables;
        final /* synthetic */ List<TabPosition> $tabPositions;
        final /* synthetic */ int $tabRowHeight;
        final /* synthetic */ int $tabRowWidth;
        final /* synthetic */ int $tabWidth;
        final /* synthetic */ SubcomposeMeasureScope $this_SubcomposeLayout;

        /* JADX INFO: renamed from: androidx.compose.material.TabRowKt$TabRow$2$1$1$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ InterfaceC0552Gp $indicator;
            final /* synthetic */ List<TabPosition> $tabPositions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(InterfaceC0552Gp interfaceC0552Gp, List<TabPosition> list, int i) {
                super(2);
                this.$indicator = interfaceC0552Gp;
                this.$tabPositions = list;
                this.$$dirty = i;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return FW.a;
            }

            @Composable
            public final void invoke(Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1341594997, i, -1, "androidx.compose.material.TabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:175)");
                }
                this.$indicator.invoke(this.$tabPositions, composer, Integer.valueOf(((this.$$dirty >> 9) & 112) | 8));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(List<? extends Placeable> list, SubcomposeMeasureScope subcomposeMeasureScope, InterfaceC0526Fp interfaceC0526Fp, int i, long j, int i2, InterfaceC0552Gp interfaceC0552Gp, List<TabPosition> list2, int i3, int i4) {
            super(1);
            this.$tabPlaceables = list;
            this.$this_SubcomposeLayout = subcomposeMeasureScope;
            this.$divider = interfaceC0526Fp;
            this.$tabWidth = i;
            this.$constraints = j;
            this.$tabRowHeight = i2;
            this.$indicator = interfaceC0552Gp;
            this.$tabPositions = list2;
            this.$$dirty = i3;
            this.$tabRowWidth = i4;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Placeable.PlacementScope) obj);
            return FW.a;
        }

        public final void invoke(Placeable.PlacementScope placementScope) {
            AbstractC4492zt.h(placementScope, "$this$layout");
            List<Placeable> list = this.$tabPlaceables;
            int i = this.$tabWidth;
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    AbstractC1886cc.w();
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) obj, i2 * i, 0, 0.0f, 4, null);
                i2 = i3;
            }
            List<Measurable> listSubcompose = this.$this_SubcomposeLayout.subcompose(TabSlots.Divider, this.$divider);
            long j = this.$constraints;
            int i4 = this.$tabRowHeight;
            Iterator<T> it = listSubcompose.iterator();
            while (it.hasNext()) {
                Placeable placeableMo4159measureBRTryo0 = ((Measurable) it.next()).mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo4159measureBRTryo0, 0, i4 - placeableMo4159measureBRTryo0.getHeight(), 0.0f, 4, null);
                i4 = i4;
                j = j;
            }
            List<Measurable> listSubcompose2 = this.$this_SubcomposeLayout.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(-1341594997, true, new AnonymousClass3(this.$indicator, this.$tabPositions, this.$$dirty)));
            int i5 = this.$tabRowWidth;
            int i6 = this.$tabRowHeight;
            Iterator<T> it2 = listSubcompose2.iterator();
            while (it2.hasNext()) {
                Placeable.PlacementScope.placeRelative$default(placementScope, ((Measurable) it2.next()).mo4159measureBRTryo0(Constraints.Companion.m5136fixedJhjzzOo(i5, i6)), 0, 0, 0.0f, 4, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabRowKt$TabRow$2$1$1(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0552Gp interfaceC0552Gp, int i) {
        super(2);
        this.$tabs = interfaceC0526Fp;
        this.$divider = interfaceC0526Fp2;
        this.$indicator = interfaceC0552Gp;
        this.$$dirty = i;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m1260invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
    }

    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m1260invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        Object next;
        AbstractC4492zt.h(subcomposeMeasureScope, "$this$SubcomposeLayout");
        int iM5128getMaxWidthimpl = Constraints.m5128getMaxWidthimpl(j);
        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, this.$tabs);
        int size = listSubcompose.size();
        int i = iM5128getMaxWidthimpl / size;
        List<Measurable> list = listSubcompose;
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, i, i, 0, 0, 12, null)));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int height = ((Placeable) next).getHeight();
                do {
                    Object next2 = it2.next();
                    int height2 = ((Placeable) next2).getHeight();
                    if (height < height2) {
                        next = next2;
                        height = height2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Placeable placeable = (Placeable) next;
        int height3 = placeable != null ? placeable.getHeight() : 0;
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(new TabPosition(Dp.m5160constructorimpl(subcomposeMeasureScope.mo330toDpu2uoSUM(i) * i2), subcomposeMeasureScope.mo330toDpu2uoSUM(i), null));
        }
        return MeasureScope.CC.q(subcomposeMeasureScope, iM5128getMaxWidthimpl, height3, null, new AnonymousClass1(arrayList, subcomposeMeasureScope, this.$divider, i, j, height3, this.$indicator, arrayList2, this.$$dirty, iM5128getMaxWidthimpl), 4, null);
    }
}
