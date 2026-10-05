package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.KJ;
import defpackage.LL;
import defpackage.XS;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class Animatable<T, V extends AnimationVector> {
    public static final int $stable = 8;
    private final SpringSpec<T> defaultSpringSpec;
    private final AnimationState<T, V> internalState;
    private final MutableState isRunning$delegate;
    private final String label;
    private T lowerBound;
    private V lowerBoundVector;
    private final MutatorMutex mutatorMutex;
    private final V negativeInfinityBounds;
    private final V positiveInfinityBounds;
    private final MutableState targetValue$delegate;
    private final TwoWayConverter<T, V> typeConverter;
    private T upperBound;
    private V upperBoundVector;
    private final T visibilityThreshold;

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$runAnimation$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.animation.core.Animatable$runAnimation$2", f = "Animatable.kt", l = {305}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC3750qp {
        final /* synthetic */ Animation<T, V> $animation;
        final /* synthetic */ InterfaceC3750qp $block;
        final /* synthetic */ T $initialVelocity;
        final /* synthetic */ long $startTime;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$runAnimation$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ InterfaceC3750qp $block;
            final /* synthetic */ KJ $clampingNeeded;
            final /* synthetic */ AnimationState<T, V> $endState;
            final /* synthetic */ Animatable<T, V> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Animatable<T, V> animatable, AnimationState<T, V> animationState, InterfaceC3750qp interfaceC3750qp, KJ kj) {
                super(1);
                this.this$0 = animatable;
                this.$endState = animationState;
                this.$block = interfaceC3750qp;
                this.$clampingNeeded = kj;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AnimationScope) obj);
                return FW.a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(AnimationScope<T, V> animationScope) {
                AbstractC4492zt.h(animationScope, "$this$animate");
                SuspendAnimationKt.updateState(animationScope, this.this$0.getInternalState$animation_core_release());
                Object objClampToBounds = this.this$0.clampToBounds(animationScope.getValue());
                if (AbstractC4492zt.d(objClampToBounds, animationScope.getValue())) {
                    InterfaceC3750qp interfaceC3750qp = this.$block;
                    if (interfaceC3750qp != null) {
                        interfaceC3750qp.invoke(this.this$0);
                        return;
                    }
                    return;
                }
                this.this$0.getInternalState$animation_core_release().setValue$animation_core_release(objClampToBounds);
                this.$endState.setValue$animation_core_release((T) objClampToBounds);
                InterfaceC3750qp interfaceC3750qp2 = this.$block;
                if (interfaceC3750qp2 != null) {
                    interfaceC3750qp2.invoke(this.this$0);
                }
                animationScope.cancelAnimation();
                this.$clampingNeeded.a = true;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Animatable<T, V> animatable, T t, Animation<T, V> animation, long j, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
            this.this$0 = animatable;
            this.$initialVelocity = t;
            this.$animation = animation;
            this.$startTime = j;
            this.$block = interfaceC3750qp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.this$0, this.$initialVelocity, this.$animation, this.$startTime, this.$block, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AnimationState animationState;
            KJ kj;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            try {
                if (i == 0) {
                    LL.b(obj);
                    this.this$0.getInternalState$animation_core_release().setVelocityVector$animation_core_release((AnimationVector) this.this$0.getTypeConverter().getConvertToVector().invoke(this.$initialVelocity));
                    this.this$0.setTargetValue(this.$animation.getTargetValue());
                    this.this$0.setRunning(true);
                    AnimationState animationStateCopy$default = AnimationStateKt.copy$default((AnimationState) this.this$0.getInternalState$animation_core_release(), (Object) null, (AnimationVector) null, 0L, Long.MIN_VALUE, false, 23, (Object) null);
                    KJ kj2 = new KJ();
                    Animation<T, V> animation = this.$animation;
                    long j = this.$startTime;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, animationStateCopy$default, this.$block, kj2);
                    this.L$0 = animationStateCopy$default;
                    this.L$1 = kj2;
                    this.label = 1;
                    if (SuspendAnimationKt.animate(animationStateCopy$default, animation, j, anonymousClass1, this) == objD) {
                        return objD;
                    }
                    animationState = animationStateCopy$default;
                    kj = kj2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kj = (KJ) this.L$1;
                    animationState = (AnimationState) this.L$0;
                    LL.b(obj);
                }
                AnimationEndReason animationEndReason = kj.a ? AnimationEndReason.BoundReached : AnimationEndReason.Finished;
                this.this$0.endAnimation();
                return new AnimationResult(animationState, animationEndReason);
            } catch (CancellationException e) {
                this.this$0.endAnimation();
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.animation.core.Animatable$snapTo$2", f = "Animatable.kt", l = {}, m = "invokeSuspend")
    public static final class C12892 extends XS implements InterfaceC3750qp {
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12892(Animatable<T, V> animatable, T t, InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
            this.this$0 = animatable;
            this.$targetValue = t;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new C12892(this.this$0, this.$targetValue, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((C12892) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            this.this$0.endAnimation();
            Object objClampToBounds = this.this$0.clampToBounds(this.$targetValue);
            this.this$0.getInternalState$animation_core_release().setValue$animation_core_release(objClampToBounds);
            this.this$0.setTargetValue(objClampToBounds);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$stop$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.animation.core.Animatable$stop$2", f = "Animatable.kt", l = {}, m = "invokeSuspend")
    public static final class C12902 extends XS implements InterfaceC3750qp {
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12902(Animatable<T, V> animatable, InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
            this.this$0 = animatable;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new C12902(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((C12902) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            this.this$0.endAnimation();
            return FW.a;
        }
    }

    public Animatable(T t, TwoWayConverter<T, V> twoWayConverter, T t2, String str) {
        AbstractC4492zt.h(twoWayConverter, "typeConverter");
        AbstractC4492zt.h(str, HTML.Tag.LABEL);
        this.typeConverter = twoWayConverter;
        this.visibilityThreshold = t2;
        this.label = str;
        this.internalState = new AnimationState<>(twoWayConverter, t, null, 0L, 0L, false, 60, null);
        this.isRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec<>(0.0f, 0.0f, t2, 3, null);
        V v = (V) createVector(t, Float.NEGATIVE_INFINITY);
        this.negativeInfinityBounds = v;
        V v2 = (V) createVector(t, Float.POSITIVE_INFINITY);
        this.positiveInfinityBounds = v2;
        this.lowerBoundVector = v;
        this.upperBoundVector = v2;
    }

    public static /* synthetic */ Object animateDecay$default(Animatable animatable, Object obj, DecayAnimationSpec decayAnimationSpec, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of, int i, Object obj2) {
        if ((i & 4) != 0) {
            interfaceC3750qp = null;
        }
        return animatable.animateDecay(obj, decayAnimationSpec, interfaceC3750qp, interfaceC0793Of);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(Animatable animatable, Object obj, AnimationSpec animationSpec, Object obj2, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of, int i, Object obj3) {
        if ((i & 2) != 0) {
            animationSpec = animatable.defaultSpringSpec;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            obj2 = animatable.getVelocity();
        }
        Object obj4 = obj2;
        if ((i & 8) != 0) {
            interfaceC3750qp = null;
        }
        return animatable.animateTo(obj, animationSpec2, obj4, interfaceC3750qp, interfaceC0793Of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T clampToBounds(T t) {
        if (AbstractC4492zt.d(this.lowerBoundVector, this.negativeInfinityBounds) && AbstractC4492zt.d(this.upperBoundVector, this.positiveInfinityBounds)) {
            return t;
        }
        AnimationVector animationVector = (AnimationVector) this.typeConverter.getConvertToVector().invoke(t);
        int size$animation_core_release = animationVector.getSize$animation_core_release();
        boolean z = false;
        for (int i = 0; i < size$animation_core_release; i++) {
            if (animationVector.get$animation_core_release(i) < this.lowerBoundVector.get$animation_core_release(i) || animationVector.get$animation_core_release(i) > this.upperBoundVector.get$animation_core_release(i)) {
                animationVector.set$animation_core_release(i, AbstractC3871sJ.k(animationVector.get$animation_core_release(i), this.lowerBoundVector.get$animation_core_release(i), this.upperBoundVector.get$animation_core_release(i)));
                z = true;
            }
        }
        return z ? (T) this.typeConverter.getConvertFromVector().invoke(animationVector) : t;
    }

    private final V createVector(T t, float f) {
        V v = (V) this.typeConverter.getConvertToVector().invoke(t);
        int size$animation_core_release = v.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            v.set$animation_core_release(i, f);
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAnimation() {
        AnimationState<T, V> animationState = this.internalState;
        animationState.getVelocityVector().reset$animation_core_release();
        animationState.setLastFrameTimeNanos$animation_core_release(Long.MIN_VALUE);
        setRunning(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runAnimation(Animation<T, V> animation, T t, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(this, t, animation, this.internalState.getLastFrameTimeNanos(), interfaceC3750qp, null), interfaceC0793Of, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRunning(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTargetValue(T t) {
        this.targetValue$delegate.setValue(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateBounds$default(Animatable animatable, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = animatable.lowerBound;
        }
        if ((i & 2) != 0) {
            obj2 = animatable.upperBound;
        }
        animatable.updateBounds(obj, obj2);
    }

    public final Object animateDecay(T t, DecayAnimationSpec<T> decayAnimationSpec, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return runAnimation(new DecayAnimation((DecayAnimationSpec) decayAnimationSpec, (TwoWayConverter<T, AnimationVector>) this.typeConverter, (Object) getValue(), (AnimationVector) this.typeConverter.getConvertToVector().invoke(t)), t, interfaceC3750qp, interfaceC0793Of);
    }

    public final Object animateTo(T t, AnimationSpec<T> animationSpec, T t2, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return runAnimation(AnimationKt.TargetBasedAnimation(animationSpec, this.typeConverter, getValue(), t, t2), t2, interfaceC3750qp, interfaceC0793Of);
    }

    public final State<T> asState() {
        return this.internalState;
    }

    public final SpringSpec<T> getDefaultSpringSpec$animation_core_release() {
        return this.defaultSpringSpec;
    }

    public final AnimationState<T, V> getInternalState$animation_core_release() {
        return this.internalState;
    }

    public final String getLabel() {
        return this.label;
    }

    public final T getLowerBound() {
        return this.lowerBound;
    }

    public final T getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final T getUpperBound() {
        return this.upperBound;
    }

    public final T getValue() {
        return this.internalState.getValue();
    }

    public final T getVelocity() {
        return (T) this.typeConverter.getConvertFromVector().invoke(getVelocityVector());
    }

    public final V getVelocityVector() {
        return (V) this.internalState.getVelocityVector();
    }

    public final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    public final Object snapTo(T t, InterfaceC0793Of interfaceC0793Of) {
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C12892(this, t, null), interfaceC0793Of, 1, null);
        return objMutate$default == AbstractC0378Bt.d() ? objMutate$default : FW.a;
    }

    public final Object stop(InterfaceC0793Of interfaceC0793Of) {
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C12902(this, null), interfaceC0793Of, 1, null);
        return objMutate$default == AbstractC0378Bt.d() ? objMutate$default : FW.a;
    }

    public final void updateBounds(T t, T t2) {
        V v;
        V v2;
        if (t == null || (v = (V) this.typeConverter.getConvertToVector().invoke(t)) == null) {
            v = this.negativeInfinityBounds;
        }
        if (t2 == null || (v2 = (V) this.typeConverter.getConvertToVector().invoke(t2)) == null) {
            v2 = this.positiveInfinityBounds;
        }
        int size$animation_core_release = v.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            if (v.get$animation_core_release(i) > v2.get$animation_core_release(i)) {
                throw new IllegalStateException(("Lower bound must be no greater than upper bound on *all* dimensions. The provided lower bound: " + v + " is greater than upper bound " + v2 + " on index " + i).toString());
            }
        }
        this.lowerBoundVector = v;
        this.upperBoundVector = v2;
        this.upperBound = t2;
        this.lowerBound = t;
        if (isRunning()) {
            return;
        }
        T tClampToBounds = clampToBounds(getValue());
        if (AbstractC4492zt.d(tClampToBounds, getValue())) {
            return;
        }
        this.internalState.setValue$animation_core_release(tClampToBounds);
    }

    public /* synthetic */ Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2, String str, int i, AbstractC0419Di abstractC0419Di) {
        this(obj, twoWayConverter, (i & 4) != 0 ? null : obj2, (i & 8) != 0 ? "Animatable" : str);
    }

    public /* synthetic */ Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2, int i, AbstractC0419Di abstractC0419Di) {
        this(obj, twoWayConverter, (i & 4) != 0 ? null : obj2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2) {
        this(obj, twoWayConverter, obj2, "Animatable");
        AbstractC4492zt.h(twoWayConverter, "typeConverter");
    }
}
