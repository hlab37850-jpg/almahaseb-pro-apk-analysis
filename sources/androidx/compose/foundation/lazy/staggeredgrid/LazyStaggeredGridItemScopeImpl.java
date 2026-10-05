package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LazyStaggeredGridItemScopeImpl implements LazyStaggeredGridItemScope {
    public static final LazyStaggeredGridItemScopeImpl INSTANCE = new LazyStaggeredGridItemScopeImpl();

    private LazyStaggeredGridItemScopeImpl() {
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope
    @ExperimentalFoundationApi
    public Modifier animateItemPlacement(Modifier modifier, FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        return modifier.then(new AnimateItemPlacementElement(finiteAnimationSpec));
    }
}
