package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionKt$createModifier$scale$2 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterExitTransitionKt$createModifier$scale$2(EnterTransition enterTransition, ExitTransition exitTransition) {
        super(3);
        this.$enter = enterTransition;
        this.$exit = exitTransition;
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<EnterExitState>) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment, Composer composer, int i) {
        FiniteAnimationSpec<Float> animationSpec;
        Scale scale;
        AbstractC4492zt.h(segment, "$this$animateFloat");
        composer.startReplaceableGroup(-53984035);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-53984035, i, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:883)");
        }
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
            Scale scale2 = this.$enter.getData$animation_release().getScale();
            if (scale2 == null || (animationSpec = scale2.getAnimationSpec()) == null) {
                animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
        } else if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit) || (scale = this.$exit.getData$animation_release().getScale()) == null || (animationSpec = scale.getAnimationSpec()) == null) {
            animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animationSpec;
    }
}
