package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2116eV;
import defpackage.AbstractC2198fV;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;
import defpackage.LL;
import defpackage.NJ;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
public final class TransformableStateKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2", f = "TransformableState.kt", l = {ShapeTypes.FLOW_CHART_DELAY}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $degrees;
        final /* synthetic */ LJ $previous;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ TransformScope $$this$transform;
            final /* synthetic */ LJ $previous;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(LJ lj, TransformScope transformScope) {
                super(1);
                this.$previous = lj;
                this.$$this$transform = transformScope;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AnimationScope<Float, AnimationVector1D>) obj);
                return FW.a;
            }

            public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                AbstractC4492zt.h(animationScope, "$this$animateTo");
                AbstractC2116eV.a(this.$$this$transform, 0.0f, 0L, animationScope.getValue().floatValue() - this.$previous.a, 3, null);
                this.$previous.a = animationScope.getValue().floatValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(LJ lj, float f, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$previous = lj;
            this.$degrees = f;
            this.$animationSpec = animationSpec;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$previous, this.$degrees, this.$animationSpec, interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(TransformScope transformScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(transformScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                TransformScope transformScope = (TransformScope) this.L$0;
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.a, 0.0f, 0L, 0L, false, 30, null);
                Float fB = E8.b(this.$degrees);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$previous, transformScope);
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fB, animationSpec, false, anonymousClass1, this, 4, null) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3", f = "TransformableState.kt", l = {ShapeTypes.FLOW_CHART_MULTIDOCUMENT}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ LJ $previous;
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ TransformScope $$this$transform;
            final /* synthetic */ LJ $previous;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(LJ lj, TransformScope transformScope) {
                super(1);
                this.$previous = lj;
                this.$$this$transform = transformScope;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AnimationScope<Float, AnimationVector1D>) obj);
                return FW.a;
            }

            public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                AbstractC4492zt.h(animationScope, "$this$animateTo");
                AbstractC2116eV.a(this.$$this$transform, this.$previous.a == 0.0f ? 1.0f : animationScope.getValue().floatValue() / this.$previous.a, 0L, 0.0f, 6, null);
                this.$previous.a = animationScope.getValue().floatValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(LJ lj, float f, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$previous = lj;
            this.$zoomFactor = f;
            this.$animationSpec = animationSpec;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$previous, this.$zoomFactor, this.$animationSpec, interfaceC0793Of);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(TransformScope transformScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass3) create(transformScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                TransformScope transformScope = (TransformScope) this.L$0;
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.a, 0.0f, 0L, 0L, false, 30, null);
                Float fB = E8.b(this.$zoomFactor);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$previous, transformScope);
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fB, animationSpec, false, anonymousClass1, this, 4, null) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$2", f = "TransformableState.kt", l = {}, m = "invokeSuspend")
    public static final class C13362 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ float $degrees;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13362(float f, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$degrees = f;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C13362 c13362 = new C13362(this.$degrees, interfaceC0793Of);
            c13362.L$0 = obj;
            return c13362;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(TransformScope transformScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C13362) create(transformScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            ((TransformScope) this.L$0).mo263transformByd4ec7I(1.0f, Offset.Companion.m2814getZeroF1C5BW0(), this.$degrees);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2", f = "TransformableState.kt", l = {}, m = "invokeSuspend")
    public static final class C13372 extends XS implements InterfaceC0526Fp {
        int label;

        public C13372(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new C13372(interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(TransformScope transformScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C13372) create(transformScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2", f = "TransformableState.kt", l = {}, m = "invokeSuspend")
    public static final class C13382 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13382(float f, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$zoomFactor = f;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C13382 c13382 = new C13382(this.$zoomFactor, interfaceC0793Of);
            c13382.L$0 = obj;
            return c13382;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(TransformScope transformScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C13382) create(transformScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            ((TransformScope) this.L$0).mo263transformByd4ec7I(this.$zoomFactor, Offset.Companion.m2814getZeroF1C5BW0(), 0.0f);
            return FW.a;
        }
    }

    public static final TransformableState TransformableState(InterfaceC0552Gp interfaceC0552Gp) {
        AbstractC4492zt.h(interfaceC0552Gp, "onTransformation");
        return new DefaultTransformableState(interfaceC0552Gp);
    }

    /* JADX INFO: renamed from: animatePanBy-ubNVwUQ, reason: not valid java name */
    public static final Object m362animatePanByubNVwUQ(TransformableState transformableState, long j, AnimationSpec<Offset> animationSpec, InterfaceC0793Of interfaceC0793Of) {
        NJ nj = new NJ();
        nj.a = Offset.Companion.m2814getZeroF1C5BW0();
        Object objA = AbstractC2198fV.a(transformableState, null, new TransformableStateKt$animatePanBy$2(nj, j, animationSpec, null), interfaceC0793Of, 1, null);
        return objA == AbstractC0378Bt.d() ? objA : FW.a;
    }

    /* JADX INFO: renamed from: animatePanBy-ubNVwUQ$default, reason: not valid java name */
    public static /* synthetic */ Object m363animatePanByubNVwUQ$default(TransformableState transformableState, long j, AnimationSpec animationSpec, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return m362animatePanByubNVwUQ(transformableState, j, animationSpec, interfaceC0793Of);
    }

    public static final Object animateRotateBy(TransformableState transformableState, float f, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) {
        Object objA = AbstractC2198fV.a(transformableState, null, new AnonymousClass2(new LJ(), f, animationSpec, null), interfaceC0793Of, 1, null);
        return objA == AbstractC0378Bt.d() ? objA : FW.a;
    }

    public static /* synthetic */ Object animateRotateBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateRotateBy(transformableState, f, animationSpec, interfaceC0793Of);
    }

    public static final Object animateZoomBy(TransformableState transformableState, float f, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("zoom value should be greater than 0");
        }
        LJ lj = new LJ();
        lj.a = 1.0f;
        Object objA = AbstractC2198fV.a(transformableState, null, new AnonymousClass3(lj, f, animationSpec, null), interfaceC0793Of, 1, null);
        return objA == AbstractC0378Bt.d() ? objA : FW.a;
    }

    public static /* synthetic */ Object animateZoomBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateZoomBy(transformableState, f, animationSpec, interfaceC0793Of);
    }

    /* JADX INFO: renamed from: panBy-d-4ec7I, reason: not valid java name */
    public static final Object m364panByd4ec7I(TransformableState transformableState, long j, InterfaceC0793Of interfaceC0793Of) {
        Object objA = AbstractC2198fV.a(transformableState, null, new TransformableStateKt$panBy$2(j, null), interfaceC0793Of, 1, null);
        return objA == AbstractC0378Bt.d() ? objA : FW.a;
    }

    @Composable
    public static final TransformableState rememberTransformableState(InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i) {
        AbstractC4492zt.h(interfaceC0552Gp, "onTransformation");
        composer.startReplaceableGroup(1681419281);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681419281, i, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:114)");
        }
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(interfaceC0552Gp, composer, i & 14);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = TransformableState(new TransformableStateKt$rememberTransformableState$1$1(stateRememberUpdatedState));
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TransformableState transformableState = (TransformableState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return transformableState;
    }

    public static final Object rotateBy(TransformableState transformableState, float f, InterfaceC0793Of interfaceC0793Of) {
        Object objA = AbstractC2198fV.a(transformableState, null, new C13362(f, null), interfaceC0793Of, 1, null);
        return objA == AbstractC0378Bt.d() ? objA : FW.a;
    }

    public static final Object stopTransformation(TransformableState transformableState, MutatePriority mutatePriority, InterfaceC0793Of interfaceC0793Of) {
        Object objTransform = transformableState.transform(mutatePriority, new C13372(null), interfaceC0793Of);
        return objTransform == AbstractC0378Bt.d() ? objTransform : FW.a;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState transformableState, MutatePriority mutatePriority, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopTransformation(transformableState, mutatePriority, interfaceC0793Of);
    }

    public static final Object zoomBy(TransformableState transformableState, float f, InterfaceC0793Of interfaceC0793Of) {
        Object objA = AbstractC2198fV.a(transformableState, null, new C13382(f, null), interfaceC0793Of, 1, null);
        return objA == AbstractC0378Bt.d() ? objA : FW.a;
    }
}
