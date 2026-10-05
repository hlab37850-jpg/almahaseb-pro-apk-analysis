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
public final class EnterExitTransitionKt$createModifier$alpha$2 extends AbstractC2233fv implements InterfaceC0552Gp {
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterExitTransitionKt$createModifier$alpha$2(EnterTransition enterTransition, ExitTransition exitTransition) {
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
        Fade fade;
        AbstractC4492zt.h(segment, "$this$animateFloat");
        composer.startReplaceableGroup(-57153604);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-57153604, i, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:860)");
        }
        EnterExitState enterExitState = EnterExitState.PreEnter;
        EnterExitState enterExitState2 = EnterExitState.Visible;
        if (segment.isTransitioningTo(enterExitState, enterExitState2)) {
            Fade fade2 = this.$enter.getData$animation_release().getFade();
            if (fade2 == null || (animationSpec = fade2.getAnimationSpec()) == null) {
                animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
        } else if (!segment.isTransitioningTo(enterExitState2, EnterExitState.PostExit) || (fade = this.$exit.getData$animation_release().getFade()) == null || (animationSpec = fade.getAnimationSpec()) == null) {
            animationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animationSpec;
    }
}
