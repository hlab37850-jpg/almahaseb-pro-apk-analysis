package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 extends AbstractC2233fv implements InterfaceC0552Gp {
    public static final TextFieldTransitionScope$Transition$prefixSuffixOpacity$2 INSTANCE = new TextFieldTransitionScope$Transition$prefixSuffixOpacity$2();

    public TextFieldTransitionScope$Transition$prefixSuffixOpacity$2() {
        super(3);
    }

    @Override // defpackage.InterfaceC0552Gp
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Transition.Segment<InputPhase>) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, int i) {
        AbstractC4492zt.h(segment, "$this$animateFloat");
        composer.startReplaceableGroup(1189967029);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1189967029, i, -1, "androidx.compose.material3.TextFieldTransitionScope.Transition.<anonymous> (TextFieldImpl.kt:353)");
        }
        TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return tweenSpecTween$default;
    }
}
