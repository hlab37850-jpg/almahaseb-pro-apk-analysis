package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2304gk;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.E8;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;
import defpackage.LL;
import defpackage.XS;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public class SwipeableState<T> {
    public static final Companion Companion = new Companion(null);
    private final MutableState<Float> absoluteOffset;
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState<Float> animationTarget;
    private final InterfaceC3750qp confirmStateChange;
    private final MutableState currentValue$delegate;
    private final DraggableState draggableState;
    private final MutableState isAnimationRunning$delegate;
    private final InterfaceC0939Tm latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;
    private final MutableState<Float> offsetState;
    private final MutableState<Float> overflowState;
    private final MutableState resistance$delegate;
    private final MutableState thresholds$delegate;
    private final MutableState velocityThreshold$delegate;

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(T t) {
            return Boolean.TRUE;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final <T> Saver<SwipeableState<T>, T> Saver(AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(animationSpec, "animationSpec");
            AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
            return SaverKt.Saver(SwipeableState$Companion$Saver$1.INSTANCE, new SwipeableState$Companion$Saver$2(animationSpec, interfaceC3750qp));
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableState$animateInternalToOffset$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.SwipeableState$animateInternalToOffset$2", f = "Swipeable.kt", l = {223}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ AnimationSpec<Float> $spec;
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        /* JADX INFO: renamed from: androidx.compose.material3.SwipeableState$animateInternalToOffset$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ DragScope $$this$drag;
            final /* synthetic */ LJ $prevValue;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(DragScope dragScope, LJ lj) {
                super(1);
                this.$$this$drag = dragScope;
                this.$prevValue = lj;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Animatable<Float, AnimationVector1D>) obj);
                return FW.a;
            }

            public final void invoke(Animatable<Float, AnimationVector1D> animatable) {
                AbstractC4492zt.h(animatable, "$this$animateTo");
                this.$$this$drag.dragBy(animatable.getValue().floatValue() - this.$prevValue.a);
                this.$prevValue.a = animatable.getValue().floatValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SwipeableState<T> swipeableState, float f, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = swipeableState;
            this.$target = f;
            this.$spec = animationSpec;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$target, this.$spec, interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(DragScope dragScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(dragScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            try {
                if (i == 0) {
                    LL.b(obj);
                    DragScope dragScope = (DragScope) this.L$0;
                    LJ lj = new LJ();
                    lj.a = ((Number) ((SwipeableState) this.this$0).absoluteOffset.getValue()).floatValue();
                    ((SwipeableState) this.this$0).animationTarget.setValue(E8.b(this.$target));
                    this.this$0.setAnimationRunning(true);
                    Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(lj.a, 0.0f, 2, null);
                    Float fB = E8.b(this.$target);
                    AnimationSpec<Float> animationSpec = this.$spec;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(dragScope, lj);
                    this.label = 1;
                    if (Animatable.animateTo$default(animatableAnimatable$default, fB, animationSpec, null, anonymousClass1, this, 4, null) == objD) {
                        return objD;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                ((SwipeableState) this.this$0).animationTarget.setValue(null);
                this.this$0.setAnimationRunning(false);
                return FW.a;
            } catch (Throwable th) {
                ((SwipeableState) this.this$0).animationTarget.setValue(null);
                this.this$0.setAnimationRunning(false);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableState$snapInternalToOffset$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.SwipeableState$snapInternalToOffset$2", f = "Swipeable.kt", l = {}, m = "invokeSuspend")
    public static final class C15682 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15682(float f, SwipeableState<T> swipeableState, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$target = f;
            this.this$0 = swipeableState;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C15682 c15682 = new C15682(this.$target, this.this$0, interfaceC0793Of);
            c15682.L$0 = obj;
            return c15682;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(DragScope dragScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C15682) create(dragScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            ((DragScope) this.L$0).dragBy(this.$target - ((Number) ((SwipeableState) this.this$0).absoluteOffset.getValue()).floatValue());
            return FW.a;
        }
    }

    public SwipeableState(T t, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(animationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "confirmStateChange");
        this.animationSpec = animationSpec;
        this.confirmStateChange = interfaceC3750qp;
        this.currentValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.isAnimationRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        Float fValueOf = Float.valueOf(0.0f);
        this.offsetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.overflowState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.absoluteOffset = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.animationTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AbstractC4243wx.g(), null, 2, null);
        final InterfaceC0939Tm interfaceC0939TmSnapshotFlow = SnapshotStateKt.snapshotFlow(new SwipeableState$latestNonEmptyAnchorsFlow$1(this));
        this.latestNonEmptyAnchorsFlow = AbstractC1047Xm.F(new InterfaceC0939Tm() { // from class: androidx.compose.material3.SwipeableState$special$$inlined$filter$1

            /* JADX INFO: renamed from: androidx.compose.material3.SwipeableState$special$$inlined$filter$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
                final /* synthetic */ InterfaceC0995Vm $this_unsafeFlow;

                /* JADX INFO: renamed from: androidx.compose.material3.SwipeableState$special$$inlined$filter$1$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.compose.material3.SwipeableState$special$$inlined$filter$1$2", f = "Swipeable.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends AbstractC0819Pf {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
                        super(interfaceC0793Of);
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0995Vm interfaceC0995Vm) {
                    this.$this_unsafeFlow = interfaceC0995Vm;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // defpackage.InterfaceC0995Vm
                public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                    AnonymousClass1 anonymousClass1;
                    if (interfaceC0793Of instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object objD = AbstractC0378Bt.d();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        LL.b(obj2);
                        InterfaceC0995Vm interfaceC0995Vm = this.$this_unsafeFlow;
                        if (!((Map) obj).isEmpty()) {
                            anonymousClass1.label = 1;
                            if (interfaceC0995Vm.emit(obj, anonymousClass1) == objD) {
                                return objD;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj2);
                    }
                    return FW.a;
                }
            }

            @Override // defpackage.InterfaceC0939Tm
            public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
                Object objCollect = interfaceC0939TmSnapshotFlow.collect(new AnonymousClass2(interfaceC0995Vm), interfaceC0793Of);
                return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
            }
        }, 1);
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(SwipeableState$thresholds$2.INSTANCE, null, 2, null);
        this.velocityThreshold$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fValueOf, null, 2, null);
        this.resistance$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggableState = DraggableKt.DraggableState(new SwipeableState$draggableState$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateInternalToOffset(float f, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) {
        Object objA = AbstractC2304gk.a(this.draggableState, null, new AnonymousClass2(this, f, animationSpec, null), interfaceC0793Of, 1, null);
        return objA == AbstractC0378Bt.d() ? objA : FW.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$material3_release$default(SwipeableState swipeableState, Object obj, AnimationSpec animationSpec, InterfaceC0793Of interfaceC0793Of, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        }
        if ((i & 2) != 0) {
            animationSpec = swipeableState.animationSpec;
        }
        return swipeableState.animateTo$material3_release(obj, animationSpec, interfaceC0793Of);
    }

    @ExperimentalMaterial3Api
    public static /* synthetic */ void getDirection$material3_release$annotations() {
    }

    @ExperimentalMaterial3Api
    public static /* synthetic */ void getProgress$material3_release$annotations() {
    }

    @ExperimentalMaterial3Api
    public static /* synthetic */ void getTargetValue$material3_release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z) {
        this.isAnimationRunning$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object snapInternalToOffset(float f, InterfaceC0793Of interfaceC0793Of) {
        Object objA = AbstractC2304gk.a(this.draggableState, null, new C15682(f, this, null), interfaceC0793Of, 1, null);
        return objA == AbstractC0378Bt.d() ? objA : FW.a;
    }

    @ExperimentalMaterial3Api
    public final Object animateTo$material3_release(T t, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new SwipeableState$animateTo$2(t, this, animationSpec), interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    public final void ensureInit$material3_release(Map<Float, ? extends T> map) {
        AbstractC4492zt.h(map, "newAnchors");
        if (getAnchors$material3_release().isEmpty()) {
            Float offset = SwipeableKt.getOffset(map, getCurrentValue());
            if (offset == null) {
                throw new IllegalArgumentException("The initial value must have an associated anchor.");
            }
            this.offsetState.setValue(offset);
            this.absoluteOffset.setValue(offset);
        }
    }

    public final Map<Float, T> getAnchors$material3_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final AnimationSpec<Float> getAnimationSpec$material3_release() {
        return this.animationSpec;
    }

    public final InterfaceC3750qp getConfirmStateChange$material3_release() {
        return this.confirmStateChange;
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final float getDirection$material3_release() {
        Float offset = SwipeableKt.getOffset(getAnchors$material3_release(), getCurrentValue());
        if (offset == null) {
            return 0.0f;
        }
        return Math.signum(getOffset().getValue().floatValue() - offset.floatValue());
    }

    public final DraggableState getDraggableState$material3_release() {
        return this.draggableState;
    }

    public final float getMaxBound$material3_release() {
        return this.maxBound;
    }

    public final float getMinBound$material3_release() {
        return this.minBound;
    }

    public final State<Float> getOffset() {
        return this.offsetState;
    }

    public final State<Float> getOverflow() {
        return this.overflowState;
    }

    public final SwipeProgress<T> getProgress$material3_release() {
        Object currentValue;
        Object objH;
        float fFloatValue;
        List listFindBounds = SwipeableKt.findBounds(getOffset().getValue().floatValue(), getAnchors$material3_release().keySet());
        int size = listFindBounds.size();
        if (size != 0) {
            if (size != 1) {
                C2020dG c2020dGA = getDirection$material3_release() > 0.0f ? HV.a(listFindBounds.get(0), listFindBounds.get(1)) : HV.a(listFindBounds.get(1), listFindBounds.get(0));
                float fFloatValue2 = ((Number) c2020dGA.a()).floatValue();
                float fFloatValue3 = ((Number) c2020dGA.b()).floatValue();
                objH = AbstractC4243wx.h(getAnchors$material3_release(), Float.valueOf(fFloatValue2));
                currentValue = AbstractC4243wx.h(getAnchors$material3_release(), Float.valueOf(fFloatValue3));
                fFloatValue = (getOffset().getValue().floatValue() - fFloatValue2) / (fFloatValue3 - fFloatValue2);
            } else {
                Object objH2 = AbstractC4243wx.h(getAnchors$material3_release(), listFindBounds.get(0));
                currentValue = AbstractC4243wx.h(getAnchors$material3_release(), listFindBounds.get(0));
                objH = objH2;
            }
            return new SwipeProgress<>(objH, currentValue, fFloatValue);
        }
        T currentValue2 = getCurrentValue();
        currentValue = getCurrentValue();
        objH = currentValue2;
        fFloatValue = 1.0f;
        return new SwipeProgress<>(objH, currentValue, fFloatValue);
    }

    public final ResistanceConfig getResistance$material3_release() {
        return (ResistanceConfig) this.resistance$delegate.getValue();
    }

    public final T getTargetValue$material3_release() {
        float fComputeTarget;
        Float value = this.animationTarget.getValue();
        if (value != null) {
            fComputeTarget = value.floatValue();
        } else {
            float fFloatValue = getOffset().getValue().floatValue();
            Float offset = SwipeableKt.getOffset(getAnchors$material3_release(), getCurrentValue());
            fComputeTarget = SwipeableKt.computeTarget(fFloatValue, offset != null ? offset.floatValue() : getOffset().getValue().floatValue(), getAnchors$material3_release().keySet(), getThresholds$material3_release(), 0.0f, Float.POSITIVE_INFINITY);
        }
        T t = getAnchors$material3_release().get(Float.valueOf(fComputeTarget));
        return t == null ? getCurrentValue() : t;
    }

    public final InterfaceC0526Fp getThresholds$material3_release() {
        return (InterfaceC0526Fp) this.thresholds$delegate.getValue();
    }

    public final float getVelocityThreshold$material3_release() {
        return ((Number) this.velocityThreshold$delegate.getValue()).floatValue();
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning$delegate.getValue()).booleanValue();
    }

    public final float performDrag$material3_release(float f) {
        float fK = AbstractC3871sJ.k(this.absoluteOffset.getValue().floatValue() + f, this.minBound, this.maxBound) - this.absoluteOffset.getValue().floatValue();
        if (Math.abs(fK) > 0.0f) {
            this.draggableState.dispatchRawDelta(fK);
        }
        return fK;
    }

    public final Object performFling$material3_release(final float f, InterfaceC0793Of interfaceC0793Of) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new InterfaceC0995Vm(this) { // from class: androidx.compose.material3.SwipeableState$performFling$2
            final /* synthetic */ SwipeableState<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(Map<Float, ? extends T> map, InterfaceC0793Of interfaceC0793Of2) {
                Float offset = SwipeableKt.getOffset(map, this.this$0.getCurrentValue());
                AbstractC4492zt.e(offset);
                float fFloatValue = offset.floatValue();
                Object obj = map.get(E8.b(SwipeableKt.computeTarget(this.this$0.getOffset().getValue().floatValue(), fFloatValue, map.keySet(), this.this$0.getThresholds$material3_release(), f, this.this$0.getVelocityThreshold$material3_release())));
                if (obj != null && ((Boolean) this.this$0.getConfirmStateChange$material3_release().invoke(obj)).booleanValue()) {
                    Object objAnimateTo$material3_release$default = SwipeableState.animateTo$material3_release$default(this.this$0, obj, null, interfaceC0793Of2, 2, null);
                    return objAnimateTo$material3_release$default == AbstractC0378Bt.d() ? objAnimateTo$material3_release$default : FW.a;
                }
                SwipeableState<T> swipeableState = this.this$0;
                Object objAnimateInternalToOffset = swipeableState.animateInternalToOffset(fFloatValue, swipeableState.getAnimationSpec$material3_release(), interfaceC0793Of2);
                return objAnimateInternalToOffset == AbstractC0378Bt.d() ? objAnimateInternalToOffset : FW.a;
            }
        }, interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:86:0x0216 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x0217  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v21, types: [float] */
    /* JADX WARN: Type inference failed for: r10v76, types: [float] */
    /* JADX WARN: Type inference failed for: r10v78, types: [float] */
    /* JADX WARN: Type inference failed for: r10v89 */
    /* JADX WARN: Type inference failed for: r10v90 */
    /* JADX WARN: Type inference failed for: r10v91 */
    /* JADX WARN: Type inference failed for: r10v92 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    public final Object processNewAnchors$material3_release(Map<Float, ? extends T> map, Map<Float, ? extends T> map2, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        SwipeableState$processNewAnchors$1 swipeableState$processNewAnchors$1;
        SwipeableState swipeableState;
        SwipeableState<T> swipeableState2;
        SwipeableState swipeableState3;
        SwipeableState swipeableState4;
        float f;
        float f2;
        if (interfaceC0793Of instanceof SwipeableState$processNewAnchors$1) {
            swipeableState$processNewAnchors$1 = (SwipeableState$processNewAnchors$1) interfaceC0793Of;
            int i = swipeableState$processNewAnchors$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                swipeableState$processNewAnchors$1.label = i - Integer.MIN_VALUE;
            } else {
                swipeableState$processNewAnchors$1 = new SwipeableState$processNewAnchors$1(this, interfaceC0793Of);
            }
        } else {
            swipeableState$processNewAnchors$1 = new SwipeableState$processNewAnchors$1(this, interfaceC0793Of);
        }
        Object obj = swipeableState$processNewAnchors$1.result;
        Object objD = AbstractC0378Bt.d();
        ?? r2 = swipeableState$processNewAnchors$1.label;
        try {
            if (r2 == 0) {
                LL.b(obj);
                if (map.isEmpty()) {
                    Float fO0 = AbstractC3240kc.o0(map2.keySet());
                    AbstractC4492zt.e(fO0);
                    this.minBound = fO0.floatValue();
                    Float fM0 = AbstractC3240kc.m0(map2.keySet());
                    AbstractC4492zt.e(fM0);
                    this.maxBound = fM0.floatValue();
                    Float offset = SwipeableKt.getOffset(map2, getCurrentValue());
                    if (offset == null) {
                        throw new IllegalArgumentException("The initial value must have an associated anchor.");
                    }
                    float fFloatValue = offset.floatValue();
                    swipeableState$processNewAnchors$1.label = 1;
                    if (snapInternalToOffset(fFloatValue, swipeableState$processNewAnchors$1) == objD) {
                        return objD;
                    }
                    return FW.a;
                }
                if (!AbstractC4492zt.d(map2, map)) {
                    this.minBound = Float.NEGATIVE_INFINITY;
                    this.maxBound = Float.POSITIVE_INFINITY;
                    Float value = this.animationTarget.getValue();
                    Object next = null;
                    if (value != null) {
                        Float offset2 = SwipeableKt.getOffset(map2, map.get(value));
                        if (offset2 != null) {
                            map = (Map<Float, ? extends T>) offset2.floatValue();
                        } else {
                            Iterator<T> it = map2.keySet().iterator();
                            if (it.hasNext()) {
                                next = it.next();
                                if (it.hasNext()) {
                                    float fAbs = Math.abs(((Number) next).floatValue() - value.floatValue());
                                    do {
                                        Object next2 = it.next();
                                        float fAbs2 = Math.abs(((Number) next2).floatValue() - value.floatValue());
                                        if (Float.compare(fAbs, fAbs2) > 0) {
                                            next = next2;
                                            fAbs = fAbs2;
                                        }
                                    } while (it.hasNext());
                                }
                            }
                            AbstractC4492zt.e(next);
                            map = (Map<Float, ? extends T>) ((Number) next).floatValue();
                        }
                    } else {
                        Object currentValue = map.get(getOffset().getValue());
                        if (AbstractC4492zt.d(currentValue, getCurrentValue())) {
                            currentValue = getCurrentValue();
                        }
                        Float offset3 = SwipeableKt.getOffset(map2, currentValue);
                        if (offset3 != null) {
                            map = offset3.floatValue();
                        } else {
                            Iterator<T> it2 = map2.keySet().iterator();
                            if (it2.hasNext()) {
                                next = it2.next();
                                if (it2.hasNext()) {
                                    float fAbs3 = Math.abs(((Number) next).floatValue() - getOffset().getValue().floatValue());
                                    do {
                                        Object next3 = it2.next();
                                        float fAbs4 = Math.abs(((Number) next3).floatValue() - getOffset().getValue().floatValue());
                                        if (Float.compare(fAbs3, fAbs4) > 0) {
                                            next = next3;
                                            fAbs3 = fAbs4;
                                        }
                                    } while (it2.hasNext());
                                }
                            }
                            AbstractC4492zt.e(next);
                            map = ((Number) next).floatValue();
                        }
                    }
                    try {
                        AnimationSpec<Float> animationSpec = this.animationSpec;
                        swipeableState$processNewAnchors$1.L$0 = this;
                        swipeableState$processNewAnchors$1.L$1 = map2;
                        swipeableState$processNewAnchors$1.F$0 = (float) map;
                        swipeableState$processNewAnchors$1.label = 2;
                        if (animateInternalToOffset((float) map, animationSpec, swipeableState$processNewAnchors$1) == objD) {
                            return objD;
                        }
                        swipeableState3 = this;
                        f = map;
                        swipeableState3.setCurrentValue(AbstractC4243wx.h(map2, E8.b(f)));
                        Float fO1 = AbstractC3240kc.o0(map2.keySet());
                        AbstractC4492zt.e(fO1);
                        swipeableState3.minBound = fO1.floatValue();
                        Float fM1 = AbstractC3240kc.m0(map2.keySet());
                        AbstractC4492zt.e(fM1);
                        swipeableState3.maxBound = fM1.floatValue();
                    } catch (CancellationException unused) {
                        swipeableState2 = this;
                        swipeableState$processNewAnchors$1.L$0 = swipeableState2;
                        swipeableState$processNewAnchors$1.L$1 = map2;
                        swipeableState$processNewAnchors$1.F$0 = map;
                        swipeableState$processNewAnchors$1.label = 3;
                        if (swipeableState2.snapInternalToOffset(map, swipeableState$processNewAnchors$1) == objD) {
                            return objD;
                        }
                        swipeableState4 = swipeableState2;
                        f2 = map;
                        swipeableState4.setCurrentValue(AbstractC4243wx.h(map2, E8.b(f2)));
                        Float fO2 = AbstractC3240kc.o0(map2.keySet());
                        AbstractC4492zt.e(fO2);
                        swipeableState4.minBound = fO2.floatValue();
                        Float fM2 = AbstractC3240kc.m0(map2.keySet());
                        AbstractC4492zt.e(fM2);
                        swipeableState4.maxBound = fM2.floatValue();
                    } catch (Throwable th) {
                        th = th;
                        swipeableState = this;
                        swipeableState.setCurrentValue(AbstractC4243wx.h(map2, E8.b(map)));
                        Float fO3 = AbstractC3240kc.o0(map2.keySet());
                        AbstractC4492zt.e(fO3);
                        swipeableState.minBound = fO3.floatValue();
                        Float fM3 = AbstractC3240kc.m0(map2.keySet());
                        AbstractC4492zt.e(fM3);
                        swipeableState.maxBound = fM3.floatValue();
                        throw th;
                    }
                }
            } else {
                if (r2 == 1) {
                    LL.b(obj);
                    return FW.a;
                }
                if (r2 == 2) {
                    map = (Map<Float, ? extends T>) swipeableState$processNewAnchors$1.F$0;
                    map2 = (Map) swipeableState$processNewAnchors$1.L$1;
                    swipeableState2 = (SwipeableState) swipeableState$processNewAnchors$1.L$0;
                    try {
                        LL.b(obj);
                        swipeableState3 = swipeableState2;
                        f = map;
                        swipeableState3.setCurrentValue(AbstractC4243wx.h(map2, E8.b(f)));
                        Float fO4 = AbstractC3240kc.o0(map2.keySet());
                        AbstractC4492zt.e(fO4);
                        swipeableState3.minBound = fO4.floatValue();
                        Float fM4 = AbstractC3240kc.m0(map2.keySet());
                        AbstractC4492zt.e(fM4);
                        swipeableState3.maxBound = fM4.floatValue();
                    } catch (CancellationException unused2) {
                        swipeableState$processNewAnchors$1.L$0 = swipeableState2;
                        swipeableState$processNewAnchors$1.L$1 = map2;
                        swipeableState$processNewAnchors$1.F$0 = map;
                        swipeableState$processNewAnchors$1.label = 3;
                        if (swipeableState2.snapInternalToOffset(map, swipeableState$processNewAnchors$1) == objD) {
                            return objD;
                        }
                        swipeableState4 = swipeableState2;
                        f2 = map;
                        swipeableState4.setCurrentValue(AbstractC4243wx.h(map2, E8.b(f2)));
                        Float fO5 = AbstractC3240kc.o0(map2.keySet());
                        AbstractC4492zt.e(fO5);
                        swipeableState4.minBound = fO5.floatValue();
                        Float fM5 = AbstractC3240kc.m0(map2.keySet());
                        AbstractC4492zt.e(fM5);
                        swipeableState4.maxBound = fM5.floatValue();
                    }
                } else {
                    if (r2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map = (Map<Float, ? extends T>) swipeableState$processNewAnchors$1.F$0;
                    map2 = (Map) swipeableState$processNewAnchors$1.L$1;
                    swipeableState = (SwipeableState) swipeableState$processNewAnchors$1.L$0;
                    try {
                        LL.b(obj);
                        swipeableState4 = swipeableState;
                        f2 = map;
                        swipeableState4.setCurrentValue(AbstractC4243wx.h(map2, E8.b(f2)));
                        Float fO6 = AbstractC3240kc.o0(map2.keySet());
                        AbstractC4492zt.e(fO6);
                        swipeableState4.minBound = fO6.floatValue();
                        Float fM6 = AbstractC3240kc.m0(map2.keySet());
                        AbstractC4492zt.e(fM6);
                        swipeableState4.maxBound = fM6.floatValue();
                    } catch (Throwable th2) {
                        th = th2;
                        swipeableState.setCurrentValue(AbstractC4243wx.h(map2, E8.b(map)));
                        Float fO7 = AbstractC3240kc.o0(map2.keySet());
                        AbstractC4492zt.e(fO7);
                        swipeableState.minBound = fO7.floatValue();
                        Float fM7 = AbstractC3240kc.m0(map2.keySet());
                        AbstractC4492zt.e(fM7);
                        swipeableState.maxBound = fM7.floatValue();
                        throw th;
                    }
                }
            }
            return FW.a;
        } catch (Throwable th3) {
            th = th3;
            swipeableState = r2;
        }
    }

    public final void setAnchors$material3_release(Map<Float, ? extends T> map) {
        AbstractC4492zt.h(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final void setMaxBound$material3_release(float f) {
        this.maxBound = f;
    }

    public final void setMinBound$material3_release(float f) {
        this.minBound = f;
    }

    public final void setResistance$material3_release(ResistanceConfig resistanceConfig) {
        this.resistance$delegate.setValue(resistanceConfig);
    }

    public final void setThresholds$material3_release(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "<set-?>");
        this.thresholds$delegate.setValue(interfaceC0526Fp);
    }

    public final void setVelocityThreshold$material3_release(float f) {
        this.velocityThreshold$delegate.setValue(Float.valueOf(f));
    }

    @ExperimentalMaterial3Api
    public final Object snapTo$material3_release(T t, InterfaceC0793Of interfaceC0793Of) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new SwipeableState$snapTo$2(t, this), interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    public /* synthetic */ SwipeableState(Object obj, AnimationSpec animationSpec, InterfaceC3750qp interfaceC3750qp, int i, AbstractC0419Di abstractC0419Di) {
        this(obj, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec$material3_release() : animationSpec, (i & 4) != 0 ? AnonymousClass1.INSTANCE : interfaceC3750qp);
    }
}
