package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Stable
final class AnimatedPaddingValues implements PaddingValues {
    private final State<Float> animationProgress;
    private final State<Dp> topPadding;

    public AnimatedPaddingValues(State<Float> state, State<Dp> state2) {
        AbstractC4492zt.h(state, "animationProgress");
        AbstractC4492zt.h(state2, "topPadding");
        this.animationProgress = state;
        this.topPadding = state2;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
    public float mo435calculateBottomPaddingD9Ej5fM() {
        return Dp.m5160constructorimpl(SearchBarKt.getSearchBarVerticalPadding() * this.animationProgress.getValue().floatValue());
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
    public float mo436calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        return Dp.m5160constructorimpl(0);
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
    public float mo437calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        AbstractC4492zt.h(layoutDirection, "layoutDirection");
        return Dp.m5160constructorimpl(0);
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
    public float mo438calculateTopPaddingD9Ej5fM() {
        return Dp.m5160constructorimpl(this.topPadding.getValue().m5174unboximpl() * this.animationProgress.getValue().floatValue());
    }

    public final State<Float> getAnimationProgress() {
        return this.animationProgress;
    }

    public final State<Dp> getTopPadding() {
        return this.topPadding;
    }
}
