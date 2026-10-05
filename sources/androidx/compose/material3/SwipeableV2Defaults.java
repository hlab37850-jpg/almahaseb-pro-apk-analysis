package androidx.compose.material3;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class SwipeableV2Defaults {
    public static final SwipeableV2Defaults INSTANCE = new SwipeableV2Defaults();
    private static final SpringSpec<Float> AnimationSpec = new SpringSpec<>(0.0f, 0.0f, null, 7, null);
    private static final float VelocityThreshold = Dp.m5160constructorimpl(125);
    private static final InterfaceC0526Fp PositionalThreshold = SwipeableV2Kt.m1866fixedPositionalThreshold0680j_4(Dp.m5160constructorimpl(56));

    private SwipeableV2Defaults() {
    }

    @ExperimentalMaterial3Api
    public static /* synthetic */ void getAnimationSpec$annotations() {
    }

    @ExperimentalMaterial3Api
    public static /* synthetic */ void getPositionalThreshold$annotations() {
    }

    @ExperimentalMaterial3Api
    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m1864getVelocityThresholdD9Ej5fM$annotations() {
    }

    @ExperimentalMaterial3Api
    public final <T> AnchorChangeHandler<T> ReconcileAnimationOnAnchorChangeHandler$material3_release(final SwipeableV2State<T> swipeableV2State, final InterfaceC0526Fp interfaceC0526Fp, final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(swipeableV2State, "state");
        AbstractC4492zt.h(interfaceC0526Fp, "animate");
        AbstractC4492zt.h(interfaceC3750qp, "snap");
        return new AnchorChangeHandler<T>() { // from class: androidx.compose.material3.SwipeableV2Defaults$ReconcileAnimationOnAnchorChangeHandler$1
            @Override // androidx.compose.material3.AnchorChangeHandler
            public final void onAnchorsChanged(T t, Map<T, Float> map, Map<T, Float> map2) {
                AbstractC4492zt.h(map, "previousAnchors");
                AbstractC4492zt.h(map2, "newAnchors");
                Float f = map.get(t);
                Float f2 = map2.get(t);
                if (AbstractC4492zt.c(f, f2)) {
                    return;
                }
                if (f2 != null) {
                    interfaceC0526Fp.mo13invoke(t, Float.valueOf(swipeableV2State.getLastVelocity()));
                } else {
                    interfaceC3750qp.invoke(SwipeableV2Kt.closestAnchor$default(map2, swipeableV2State.requireOffset(), false, 2, null));
                }
            }
        };
    }

    public final SpringSpec<Float> getAnimationSpec() {
        return AnimationSpec;
    }

    public final InterfaceC0526Fp getPositionalThreshold() {
        return PositionalThreshold;
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM, reason: not valid java name */
    public final float m1865getVelocityThresholdD9Ej5fM() {
        return VelocityThreshold;
    }
}
