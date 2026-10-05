package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt {

    /* JADX INFO: renamed from: androidx.compose.animation.TransitionKt$animateColor$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Composable
        public final SpringSpec<Color> invoke(Transition.Segment<S> segment, Composer composer, int i) {
            AbstractC4492zt.h(segment, "$this$null");
            composer.startReplaceableGroup(-1457805428);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1457805428, i, -1, "androidx.compose.animation.animateColor.<anonymous> (Transition.kt:64)");
            }
            SpringSpec<Color> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return springSpecSpring$default;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Color> animateColor(Transition<S> transition, InterfaceC0552Gp interfaceC0552Gp, String str, InterfaceC0552Gp interfaceC0552Gp2, Composer composer, int i, int i2) {
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(interfaceC0552Gp2, "targetValueByState");
        composer.startReplaceableGroup(-1939694975);
        if ((i2 & 1) != 0) {
            interfaceC0552Gp = AnonymousClass1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = "ColorAnimation";
        }
        String str2 = str;
        ColorSpace colorSpaceM3036getColorSpaceimpl = Color.m3036getColorSpaceimpl(((Color) interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf((i >> 6) & 112))).m3042unboximpl());
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(colorSpaceM3036getColorSpaceimpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpaceM3036getColorSpaceimpl);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        int i3 = (i & 14) | 64;
        int i4 = i << 3;
        int i5 = i3 | (i4 & 896) | (i4 & 7168) | (i4 & 57344);
        composer.startReplaceableGroup(-142660079);
        int i6 = (i5 >> 9) & 112;
        State<Color> stateCreateTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, interfaceC0552Gp2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i6)), interfaceC0552Gp2.invoke(transition.getTargetState(), composer, Integer.valueOf(i6)), (FiniteAnimationSpec) interfaceC0552Gp.invoke(transition.getSegment(), composer, Integer.valueOf((i5 >> 3) & 112)), (TwoWayConverter) objRememberedValue, str2, composer, (i5 & 14) | 32768 | ((i5 << 6) & 458752));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return stateCreateTransitionAnimation;
    }

    @Composable
    /* JADX INFO: renamed from: animateColor-DTcfvLk, reason: not valid java name */
    public static final State<Color> m82animateColorDTcfvLk(InfiniteTransition infiniteTransition, long j, long j2, InfiniteRepeatableSpec<Color> infiniteRepeatableSpec, String str, Composer composer, int i, int i2) {
        AbstractC4492zt.h(infiniteTransition, "$this$animateColor");
        AbstractC4492zt.h(infiniteRepeatableSpec, "animationSpec");
        composer.startReplaceableGroup(1901963533);
        String str2 = (i2 & 8) != 0 ? "ColorAnimation" : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1901963533, i, -1, "androidx.compose.animation.animateColor (Transition.kt:96)");
        }
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m3036getColorSpaceimpl(j2));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        int i3 = i << 3;
        State<Color> stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransition, Color.m3022boximpl(j), Color.m3022boximpl(j2), (TwoWayConverter) objRememberedValue, infiniteRepeatableSpec, str2, composer, InfiniteTransition.$stable | 4096 | (i & 14) | (i & 112) | (i & 896) | (InfiniteRepeatableSpec.$stable << 12) | (57344 & i3) | (i3 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateAnimateValue;
    }

    @Composable
    /* JADX INFO: renamed from: animateColor-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ State m83animateColorRIQooxk(InfiniteTransition infiniteTransition, long j, long j2, InfiniteRepeatableSpec infiniteRepeatableSpec, Composer composer, int i) {
        AbstractC4492zt.h(infiniteTransition, "$this$animateColor");
        AbstractC4492zt.h(infiniteRepeatableSpec, "animationSpec");
        composer.startReplaceableGroup(1400583834);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1400583834, i, -1, "androidx.compose.animation.animateColor (Transition.kt:113)");
        }
        State<Color> stateM82animateColorDTcfvLk = m82animateColorDTcfvLk(infiniteTransition, j, j2, infiniteRepeatableSpec, "ColorAnimation", composer, InfiniteTransition.$stable | 24576 | (i & 14) | (i & 112) | (i & 896) | (InfiniteRepeatableSpec.$stable << 9) | (i & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateM82animateColorDTcfvLk;
    }
}
