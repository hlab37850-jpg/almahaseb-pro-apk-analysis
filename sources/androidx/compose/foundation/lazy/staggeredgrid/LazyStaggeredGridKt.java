package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$ScrollPositionUpdater$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC3588op $itemProviderLambda;
        final /* synthetic */ LazyStaggeredGridState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC3588op interfaceC3588op, LazyStaggeredGridState lazyStaggeredGridState, int i) {
            super(2);
            this.$itemProviderLambda = interfaceC3588op;
            this.$state = lazyStaggeredGridState;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            LazyStaggeredGridKt.ScrollPositionUpdater(this.$itemProviderLambda, this.$state, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: LazyStaggeredGrid-LJWHXA8, reason: not valid java name */
    public static final void m659LazyStaggeredGridLJWHXA8(LazyStaggeredGridState lazyStaggeredGridState, Orientation orientation, InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, float f, float f2, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2, int i3) {
        FlingBehavior flingBehavior2;
        int i4;
        AbstractC4492zt.h(lazyStaggeredGridState, "state");
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(interfaceC0526Fp, "slots");
        AbstractC4492zt.h(interfaceC3750qp, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1320541636);
        Modifier modifier2 = (i3 & 8) != 0 ? Modifier.Companion : modifier;
        PaddingValues paddingValuesM478PaddingValues0680j_4 = (i3 & 16) != 0 ? PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0)) : paddingValues;
        boolean z3 = (i3 & 32) != 0 ? false : z;
        if ((i3 & 64) != 0) {
            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(composerStartRestartGroup, 6);
            i4 = i & (-3670017);
        } else {
            flingBehavior2 = flingBehavior;
            i4 = i;
        }
        boolean z4 = (i3 & 128) != 0 ? true : z2;
        float fM5160constructorimpl = (i3 & 256) != 0 ? Dp.m5160constructorimpl(0) : f;
        float fM5160constructorimpl2 = (i3 & 512) != 0 ? Dp.m5160constructorimpl(0) : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1320541636, i4, i2, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:39)");
        }
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        OverscrollEffect overscrollEffect = scrollableDefaults.overscrollEffect(composerStartRestartGroup, 6);
        InterfaceC3588op interfaceC3588opRememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, interfaceC3750qp, composerStartRestartGroup, ((i2 << 3) & 112) | 8);
        int i5 = i4 >> 6;
        int i6 = i4 >> 9;
        int i7 = i4;
        boolean z5 = z3;
        Modifier modifier3 = modifier2;
        InterfaceC0526Fp interfaceC0526FpM668rememberStaggeredGridMeasurePolicynbWgWpA = LazyStaggeredGridMeasurePolicyKt.m668rememberStaggeredGridMeasurePolicynbWgWpA(lazyStaggeredGridState, interfaceC3588opRememberStaggeredGridItemProviderLambda, paddingValuesM478PaddingValues0680j_4, z3, orientation, fM5160constructorimpl, fM5160constructorimpl2, interfaceC0526Fp, composerStartRestartGroup, (i5 & 7168) | (i5 & 896) | 8 | ((i4 << 9) & 57344) | (i6 & 458752) | (3670016 & i6) | ((i4 << 15) & 29360128));
        LazyLayoutSemanticState lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z5, composerStartRestartGroup, ((i7 >> 12) & 112) | 8);
        ScrollPositionUpdater(interfaceC3588opRememberStaggeredGridItemProviderLambda, lazyStaggeredGridState, composerStartRestartGroup, 64);
        int i8 = (i7 << 6) & 7168;
        boolean z6 = z4;
        LazyLayoutKt.LazyLayout(interfaceC3588opRememberStaggeredGridItemProviderLambda, ScrollableKt.scrollable(OverscrollKt.overscroll(LazyStaggeredGridBeyondBoundsModifierKt.lazyStaggeredGridBeyondBoundsModifier(ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyStaggeredGridState.getRemeasurementModifier$foundation_release()).then(lazyStaggeredGridState.getAwaitLayoutModifier$foundation_release()), interfaceC3588opRememberStaggeredGridItemProviderLambda, lazyLayoutSemanticStateRememberLazyStaggeredGridSemanticState, orientation, z6, z5, composerStartRestartGroup, (i6 & 57344) | i8 | (i7 & 458752)), orientation), lazyStaggeredGridState, z5, orientation, composerStartRestartGroup, (i6 & 896) | 64 | i8), overscrollEffect), lazyStaggeredGridState, orientation, overscrollEffect, z6, scrollableDefaults.reverseDirection((LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation, z5), flingBehavior2, lazyStaggeredGridState.getMutableInteractionSource$foundation_release()), lazyStaggeredGridState.getPrefetchState$foundation_release(), interfaceC0526FpM668rememberStaggeredGridMeasurePolicynbWgWpA, composerStartRestartGroup, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new LazyStaggeredGridKt$LazyStaggeredGrid$1(lazyStaggeredGridState, orientation, interfaceC0526Fp, modifier3, paddingValuesM478PaddingValues0680j_4, z5, flingBehavior2, z4, fM5160constructorimpl, fM5160constructorimpl2, interfaceC3750qp, i, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final void ScrollPositionUpdater(InterfaceC3588op interfaceC3588op, LazyStaggeredGridState lazyStaggeredGridState, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(661612410);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(661612410, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.ScrollPositionUpdater (LazyStaggeredGrid.kt:120)");
        }
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) interfaceC3588op.invoke();
        if (lazyLayoutItemProvider.getItemCount() > 0) {
            LazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release$default(lazyStaggeredGridState, lazyLayoutItemProvider, null, 2, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(interfaceC3588op, lazyStaggeredGridState, i));
    }
}
