package androidx.compose.material;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3750qp;
import defpackage.MJ;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TabRowKt$ScrollableTabRow$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0526Fp $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ InterfaceC0552Gp $indicator;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ InterfaceC0526Fp $tabs;

    /* JADX INFO: renamed from: androidx.compose.material.TabRowKt$ScrollableTabRow$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $divider;
        final /* synthetic */ float $edgePadding;
        final /* synthetic */ InterfaceC0552Gp $indicator;
        final /* synthetic */ ScrollableTabData $scrollableTabData;
        final /* synthetic */ int $selectedTabIndex;
        final /* synthetic */ InterfaceC0526Fp $tabs;

        /* JADX INFO: renamed from: androidx.compose.material.TabRowKt$ScrollableTabRow$2$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ long $constraints;
            final /* synthetic */ InterfaceC0526Fp $divider;
            final /* synthetic */ InterfaceC0552Gp $indicator;
            final /* synthetic */ MJ $layoutHeight;
            final /* synthetic */ MJ $layoutWidth;
            final /* synthetic */ int $padding;
            final /* synthetic */ ScrollableTabData $scrollableTabData;
            final /* synthetic */ int $selectedTabIndex;
            final /* synthetic */ List<Placeable> $tabPlaceables;
            final /* synthetic */ SubcomposeMeasureScope $this_SubcomposeLayout;

            /* JADX INFO: renamed from: androidx.compose.material.TabRowKt$ScrollableTabRow$2$1$2$3, reason: invalid class name */
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
                        ComposerKt.traceEventStart(230769237, i, -1, "androidx.compose.material.ScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:300)");
                    }
                    this.$indicator.invoke(this.$tabPositions, composer, Integer.valueOf(((this.$$dirty >> 12) & 112) | 8));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(int i, List<? extends Placeable> list, SubcomposeMeasureScope subcomposeMeasureScope, InterfaceC0526Fp interfaceC0526Fp, ScrollableTabData scrollableTabData, int i2, long j, MJ mj, MJ mj2, InterfaceC0552Gp interfaceC0552Gp, int i3) {
                super(1);
                this.$padding = i;
                this.$tabPlaceables = list;
                this.$this_SubcomposeLayout = subcomposeMeasureScope;
                this.$divider = interfaceC0526Fp;
                this.$scrollableTabData = scrollableTabData;
                this.$selectedTabIndex = i2;
                this.$constraints = j;
                this.$layoutWidth = mj;
                this.$layoutHeight = mj2;
                this.$indicator = interfaceC0552Gp;
                this.$$dirty = i3;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return FW.a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                AbstractC4492zt.h(placementScope, "$this$layout");
                ArrayList arrayList = new ArrayList();
                int i = this.$padding;
                List<Placeable> list = this.$tabPlaceables;
                SubcomposeMeasureScope subcomposeMeasureScope = this.$this_SubcomposeLayout;
                int width = i;
                for (Placeable placeable : list) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, 0, 0.0f, 4, null);
                    arrayList.add(new TabPosition(subcomposeMeasureScope.mo330toDpu2uoSUM(width), subcomposeMeasureScope.mo330toDpu2uoSUM(placeable.getWidth()), null));
                    width += placeable.getWidth();
                }
                List<Measurable> listSubcompose = this.$this_SubcomposeLayout.subcompose(TabSlots.Divider, this.$divider);
                long j = this.$constraints;
                MJ mj = this.$layoutWidth;
                MJ mj2 = this.$layoutHeight;
                for (Measurable measurable : listSubcompose) {
                    int i2 = mj.a;
                    Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, i2, i2, 0, 0, 8, null));
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo4159measureBRTryo0, 0, mj2.a - placeableMo4159measureBRTryo0.getHeight(), 0.0f, 4, null);
                    mj = mj;
                    mj2 = mj2;
                    j = j;
                }
                List<Measurable> listSubcompose2 = this.$this_SubcomposeLayout.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(230769237, true, new AnonymousClass3(this.$indicator, arrayList, this.$$dirty)));
                MJ mj3 = this.$layoutWidth;
                MJ mj4 = this.$layoutHeight;
                Iterator<T> it = listSubcompose2.iterator();
                while (it.hasNext()) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, ((Measurable) it.next()).mo4159measureBRTryo0(Constraints.Companion.m5136fixedJhjzzOo(mj3.a, mj4.a)), 0, 0, 0.0f, 4, null);
                }
                this.$scrollableTabData.onLaidOut(this.$this_SubcomposeLayout, this.$padding, arrayList, this.$selectedTabIndex);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(float f, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, ScrollableTabData scrollableTabData, int i, InterfaceC0552Gp interfaceC0552Gp, int i2) {
            super(2);
            this.$edgePadding = f;
            this.$tabs = interfaceC0526Fp;
            this.$divider = interfaceC0526Fp2;
            this.$scrollableTabData = scrollableTabData;
            this.$selectedTabIndex = i;
            this.$indicator = interfaceC0552Gp;
            this.$$dirty = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return m1259invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m5134unboximpl());
        }

        /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
        public final MeasureResult m1259invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
            AbstractC4492zt.h(subcomposeMeasureScope, "$this$SubcomposeLayout");
            int iMo327roundToPx0680j_4 = subcomposeMeasureScope.mo327roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
            int iMo327roundToPx0680j_5 = subcomposeMeasureScope.mo327roundToPx0680j_4(this.$edgePadding);
            long jM5119copyZbe2FdA$default = Constraints.m5119copyZbe2FdA$default(j, iMo327roundToPx0680j_4, 0, 0, 0, 14, null);
            List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, this.$tabs);
            ArrayList<Placeable> arrayList = new ArrayList(AbstractC2044dc.x(listSubcompose, 10));
            Iterator<T> it = listSubcompose.iterator();
            while (it.hasNext()) {
                arrayList.add(((Measurable) it.next()).mo4159measureBRTryo0(jM5119copyZbe2FdA$default));
            }
            MJ mj = new MJ();
            mj.a = iMo327roundToPx0680j_5 * 2;
            MJ mj2 = new MJ();
            for (Placeable placeable : arrayList) {
                mj.a += placeable.getWidth();
                mj2.a = Math.max(mj2.a, placeable.getHeight());
            }
            return MeasureScope.CC.q(subcomposeMeasureScope, mj.a, mj2.a, null, new AnonymousClass2(iMo327roundToPx0680j_5, arrayList, subcomposeMeasureScope, this.$divider, this.$scrollableTabData, this.$selectedTabIndex, j, mj, mj2, this.$indicator, this.$$dirty), 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabRowKt$ScrollableTabRow$2(float f, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, int i, InterfaceC0552Gp interfaceC0552Gp, int i2) {
        super(2);
        this.$edgePadding = f;
        this.$tabs = interfaceC0526Fp;
        this.$divider = interfaceC0526Fp2;
        this.$selectedTabIndex = i;
        this.$indicator = interfaceC0552Gp;
        this.$$dirty = i2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1455860572, i, -1, "androidx.compose.material.ScrollableTabRow.<anonymous> (TabRow.kt:244)");
        }
        ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
        composer.startReplaceableGroup(773894976);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(scrollStateRememberScrollState) | composer.changed(coroutineScope);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new ScrollableTabData(scrollStateRememberScrollState, coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        SubcomposeLayoutKt.SubcomposeLayout(ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Alignment.Companion.getCenterStart(), false, 2, null), scrollStateRememberScrollState, false, null, false, 14, null))), new AnonymousClass1(this.$edgePadding, this.$tabs, this.$divider, (ScrollableTabData) objRememberedValue2, this.$selectedTabIndex, this.$indicator, this.$$dirty), composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
