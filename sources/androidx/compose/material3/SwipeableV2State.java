package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;
import defpackage.LL;
import defpackage.XS;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class SwipeableV2State<T> {
    public static final Companion Companion = new Companion(null);
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState animationTarget$delegate;
    private final InterfaceC3750qp confirmValueChange;
    private final MutableState currentValue$delegate;
    private Density density;
    private final MutableState lastVelocity$delegate;
    private final State maxOffset$delegate;
    private final State minOffset$delegate;
    private final MutableState offset$delegate;
    private final InterfaceC0526Fp positionalThreshold;
    private final State progress$delegate;
    private final DraggableState swipeDraggableState;
    private final InternalMutatorMutex swipeMutex;
    private final State targetValue$delegate;
    private final float velocityThreshold;

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2State$1, reason: invalid class name */
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

        @ExperimentalMaterial3Api
        /* JADX INFO: renamed from: Saver-eqLRuRQ, reason: not valid java name */
        public final <T> Saver<SwipeableV2State<T>, T> m1869SavereqLRuRQ(AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, float f) {
            AbstractC4492zt.h(animationSpec, "animationSpec");
            AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
            AbstractC4492zt.h(interfaceC0526Fp, "positionalThreshold");
            return SaverKt.Saver(SwipeableV2State$Companion$Saver$1.INSTANCE, new SwipeableV2State$Companion$Saver$2(animationSpec, interfaceC3750qp, interfaceC0526Fp, f));
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2State$animateTo$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.SwipeableV2State", f = "SwipeableV2.kt", l = {350}, m = "animateTo")
    public static final class C15731 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15731(SwipeableV2State<T> swipeableV2State, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = swipeableV2State;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.animateTo(null, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2State$animateTo$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material3.SwipeableV2State$animateTo$2", f = "SwipeableV2.kt", l = {353}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC3750qp {
        final /* synthetic */ Float $targetOffset;
        final /* synthetic */ T $targetValue;
        final /* synthetic */ float $velocity;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2State$animateTo$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ LJ $prev;
            final /* synthetic */ SwipeableV2State<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SwipeableV2State<T> swipeableV2State, LJ lj) {
                super(2);
                this.this$0 = swipeableV2State;
                this.$prev = lj;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                return FW.a;
            }

            public final void invoke(float f, float f2) {
                this.this$0.setOffset(Float.valueOf(f));
                this.$prev.a = f;
                this.this$0.setLastVelocity(f2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SwipeableV2State<T> swipeableV2State, T t, Float f, float f2, InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
            this.this$0 = swipeableV2State;
            this.$targetValue = t;
            this.$targetOffset = f;
            this.$velocity = f2;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.this$0, this.$targetValue, this.$targetOffset, this.$velocity, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                this.this$0.setAnimationTarget(this.$targetValue);
                LJ lj = new LJ();
                Float offset = this.this$0.getOffset();
                float fFloatValue = offset != null ? offset.floatValue() : 0.0f;
                lj.a = fFloatValue;
                float fFloatValue2 = this.$targetOffset.floatValue();
                float f = this.$velocity;
                AnimationSpec<Float> animationSpec$material3_release = this.this$0.getAnimationSpec$material3_release();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, lj);
                this.label = 1;
                if (SuspendAnimationKt.animate(fFloatValue, fFloatValue2, f, animationSpec$material3_release, anonymousClass1, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            this.this$0.setLastVelocity(0.0f);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2State$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.SwipeableV2State$snapTo$2", f = "SwipeableV2.kt", l = {}, m = "invokeSuspend")
    public static final class C15742 extends XS implements InterfaceC3750qp {
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15742(SwipeableV2State<T> swipeableV2State, T t, InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
            this.this$0 = swipeableV2State;
            this.$targetValue = t;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new C15742(this.this$0, this.$targetValue, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((C15742) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            this.this$0.snap(this.$targetValue);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2State$swipe$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.SwipeableV2State$swipe$2", f = "SwipeableV2.kt", l = {462}, m = "invokeSuspend")
    public static final class C15752 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC3750qp $action;
        final /* synthetic */ MutatePriority $swipePriority;
        int label;
        final /* synthetic */ SwipeableV2State<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15752(SwipeableV2State<T> swipeableV2State, MutatePriority mutatePriority, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = swipeableV2State;
            this.$swipePriority = mutatePriority;
            this.$action = interfaceC3750qp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new C15752(this.this$0, this.$swipePriority, this.$action, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C15752) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InternalMutatorMutex internalMutatorMutex = ((SwipeableV2State) this.this$0).swipeMutex;
                MutatePriority mutatePriority = this.$swipePriority;
                InterfaceC3750qp interfaceC3750qp = this.$action;
                this.label = 1;
                if (internalMutatorMutex.mutate(mutatePriority, interfaceC3750qp, this) == objD) {
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

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, float f, AbstractC0419Di abstractC0419Di) {
        this(obj, animationSpec, interfaceC3750qp, interfaceC0526Fp, f);
    }

    public static /* synthetic */ Object animateTo$default(SwipeableV2State swipeableV2State, Object obj, float f, InterfaceC0793Of interfaceC0793Of, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = swipeableV2State.getLastVelocity();
        }
        return swipeableV2State.animateTo(obj, f, interfaceC0793Of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTarget(float f, T t, float f2) {
        Object objClosestAnchor;
        Map<T, Float> anchors$material3_release = getAnchors$material3_release();
        Float f3 = anchors$material3_release.get(t);
        Density densityRequireDensity = requireDensity();
        float fMo333toPx0680j_4 = densityRequireDensity.mo333toPx0680j_4(this.velocityThreshold);
        if (AbstractC4492zt.b(f3, f) || f3 == null) {
            return t;
        }
        if (f3.floatValue() < f) {
            if (f2 >= fMo333toPx0680j_4) {
                return (T) SwipeableV2Kt.closestAnchor(anchors$material3_release, f, true);
            }
            objClosestAnchor = SwipeableV2Kt.closestAnchor(anchors$material3_release, f, true);
            if (f < Math.abs(f3.floatValue() + Math.abs(((Number) this.positionalThreshold.mo13invoke(densityRequireDensity, Float.valueOf(Math.abs(((Number) AbstractC4243wx.h(anchors$material3_release, objClosestAnchor)).floatValue() - f3.floatValue())))).floatValue()))) {
                return t;
            }
        } else {
            if (f2 <= (-fMo333toPx0680j_4)) {
                return (T) SwipeableV2Kt.closestAnchor(anchors$material3_release, f, false);
            }
            objClosestAnchor = SwipeableV2Kt.closestAnchor(anchors$material3_release, f, false);
            float fAbs = Math.abs(f3.floatValue() - Math.abs(((Number) this.positionalThreshold.mo13invoke(densityRequireDensity, Float.valueOf(Math.abs(f3.floatValue() - ((Number) AbstractC4243wx.h(anchors$material3_release, objClosestAnchor)).floatValue())))).floatValue()));
            if (f < 0.0f) {
                if (Math.abs(f) < fAbs) {
                    return t;
                }
            } else if (f > fAbs) {
                return t;
            }
        }
        return (T) objClosestAnchor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T getAnimationTarget() {
        return this.animationTarget$delegate.getValue();
    }

    private final Density requireDensity() {
        Density density = this.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("SwipeableState did not have a density attached. Are you using Modifier.swipeable with this=" + this + " SwipeableState?").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationTarget(T t) {
        this.animationTarget$delegate.setValue(t);
    }

    private final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity$delegate.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOffset(Float f) {
        this.offset$delegate.setValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void snap(T t) {
        Float f = getAnchors$material3_release().get(t);
        if (f == null) {
            setCurrentValue(t);
            return;
        }
        float fFloatValue = f.floatValue();
        Float offset = getOffset();
        dispatchRawDelta(fFloatValue - (offset != null ? offset.floatValue() : 0.0f));
        setCurrentValue(t);
        setAnimationTarget(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object swipe(MutatePriority mutatePriority, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        Object objD = AbstractC2133eg.d(new C15752(this, mutatePriority, interfaceC3750qp, null), interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    public static /* synthetic */ Object swipe$default(SwipeableV2State swipeableV2State, MutatePriority mutatePriority, InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return swipeableV2State.swipe(mutatePriority, interfaceC3750qp, interfaceC0793Of);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00af  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object animateTo(T t, float f, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C15731 c15731;
        SwipeableV2State swipeableV2State;
        SwipeableV2State swipeableV2State2;
        float fRequireOffset;
        Iterator<T> it;
        T next;
        Object key;
        float fRequireOffset2;
        Iterator<T> it2;
        T next2;
        if (interfaceC0793Of instanceof C15731) {
            c15731 = (C15731) interfaceC0793Of;
            int i = c15731.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15731.label = i - Integer.MIN_VALUE;
            } else {
                c15731 = new C15731(this, interfaceC0793Of);
            }
        } else {
            c15731 = new C15731(this, interfaceC0793Of);
        }
        C15731 c15732 = c15731;
        Object obj = c15732.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c15732.label;
        if (i2 == 0) {
            LL.b(obj);
            Float f2 = getAnchors$material3_release().get(t);
            if (f2 != null) {
                try {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, t, f2, f, null);
                    c15732.L$0 = this;
                    c15732.label = 1;
                    if (swipe$default(this, null, anonymousClass2, c15732, 1, null) == objD) {
                        return objD;
                    }
                    swipeableV2State2 = this;
                    swipeableV2State2.setAnimationTarget(null);
                    fRequireOffset2 = swipeableV2State2.requireOffset();
                    it2 = swipeableV2State2.getAnchors$material3_release().entrySet().iterator();
                    do {
                        if (it2.hasNext()) {
                            next2 = (T) null;
                            break;
                        }
                        next2 = it2.next();
                    } while (Math.abs(((Number) ((Map.Entry) next2).getValue()).floatValue() - fRequireOffset2) >= 0.5f);
                    Map.Entry entry = next2;
                    if (entry != null) {
                    }
                    if (key == null) {
                        key = swipeableV2State2.getCurrentValue();
                    }
                    swipeableV2State2.setCurrentValue(key);
                } catch (Throwable th) {
                    th = th;
                    swipeableV2State = this;
                    swipeableV2State.setAnimationTarget(null);
                    fRequireOffset = swipeableV2State.requireOffset();
                    it = swipeableV2State.getAnchors$material3_release().entrySet().iterator();
                    do {
                        if (it.hasNext()) {
                            next = (T) null;
                            break;
                        }
                        next = it.next();
                    } while (Math.abs(((Number) ((Map.Entry) next).getValue()).floatValue() - fRequireOffset) >= 0.5f);
                    Map.Entry entry2 = next;
                    if (entry2 != null) {
                    }
                    if (key == null) {
                        key = swipeableV2State.getCurrentValue();
                    }
                    swipeableV2State.setCurrentValue(key);
                    throw th;
                }
            } else {
                setCurrentValue(t);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            swipeableV2State = (SwipeableV2State) c15732.L$0;
            try {
                LL.b(obj);
                swipeableV2State2 = swipeableV2State;
                swipeableV2State2.setAnimationTarget(null);
                fRequireOffset2 = swipeableV2State2.requireOffset();
                it2 = swipeableV2State2.getAnchors$material3_release().entrySet().iterator();
                do {
                    if (it2.hasNext()) {
                        next2 = (T) null;
                        break;
                    }
                    next2 = it2.next();
                } while (Math.abs(((Number) ((Map.Entry) next2).getValue()).floatValue() - fRequireOffset2) >= 0.5f);
                Map.Entry entry3 = next2;
                key = entry3 != null ? entry3.getKey() : null;
                if (key == null) {
                    key = swipeableV2State2.getCurrentValue();
                }
                swipeableV2State2.setCurrentValue(key);
            } catch (Throwable th2) {
                th = th2;
                swipeableV2State.setAnimationTarget(null);
                fRequireOffset = swipeableV2State.requireOffset();
                it = swipeableV2State.getAnchors$material3_release().entrySet().iterator();
                do {
                    if (it.hasNext()) {
                        next = (T) null;
                        break;
                    }
                    next = it.next();
                } while (Math.abs(((Number) ((Map.Entry) next).getValue()).floatValue() - fRequireOffset) >= 0.5f);
                Map.Entry entry4 = next;
                key = entry4 != null ? entry4.getKey() : null;
                if (key == null) {
                    key = swipeableV2State.getCurrentValue();
                }
                swipeableV2State.setCurrentValue(key);
                throw th;
            }
        }
        return FW.a;
    }

    public final float dispatchRawDelta(float f) {
        Float offset = getOffset();
        float fFloatValue = offset != null ? offset.floatValue() : 0.0f;
        float fK = AbstractC3871sJ.k(f + fFloatValue, getMinOffset(), getMaxOffset()) - fFloatValue;
        if (Math.abs(fK) >= 0.0f) {
            Float offset2 = getOffset();
            setOffset(Float.valueOf(AbstractC3871sJ.k((offset2 != null ? offset2.floatValue() : 0.0f) + fK, getMinOffset(), getMaxOffset())));
        }
        return fK;
    }

    public final Map<T, Float> getAnchors$material3_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final AnimationSpec<Float> getAnimationSpec$material3_release() {
        return this.animationSpec;
    }

    public final InterfaceC3750qp getConfirmValueChange$material3_release() {
        return this.confirmValueChange;
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final Density getDensity$material3_release() {
        return this.density;
    }

    public final float getLastVelocity() {
        return ((Number) this.lastVelocity$delegate.getValue()).floatValue();
    }

    public final float getMaxOffset() {
        return ((Number) this.maxOffset$delegate.getValue()).floatValue();
    }

    public final float getMinOffset() {
        return ((Number) this.minOffset$delegate.getValue()).floatValue();
    }

    public final Float getOffset() {
        return (Float) this.offset$delegate.getValue();
    }

    public final InterfaceC0526Fp getPositionalThreshold$material3_release() {
        return this.positionalThreshold;
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    public final DraggableState getSwipeDraggableState$material3_release() {
        return this.swipeDraggableState;
    }

    public final T getTargetValue() {
        return (T) this.targetValue$delegate.getValue();
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM$material3_release, reason: not valid java name */
    public final float m1868getVelocityThresholdD9Ej5fM$material3_release() {
        return this.velocityThreshold;
    }

    public final boolean hasAnchorForValue(T t) {
        return getAnchors$material3_release().containsKey(t);
    }

    public final boolean isAnimationRunning() {
        return getAnimationTarget() != null;
    }

    public final float requireOffset() {
        Float offset = getOffset();
        if (offset != null) {
            return offset.floatValue();
        }
        throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
    }

    public final void setAnchors$material3_release(Map<T, Float> map) {
        AbstractC4492zt.h(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final void setDensity$material3_release(Density density) {
        this.density = density;
    }

    public final Object settle(float f, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        T currentValue = getCurrentValue();
        T tComputeTarget = computeTarget(requireOffset(), currentValue, f);
        if (((Boolean) this.confirmValueChange.invoke(tComputeTarget)).booleanValue()) {
            Object objAnimateTo = animateTo(tComputeTarget, f, interfaceC0793Of);
            return objAnimateTo == AbstractC0378Bt.d() ? objAnimateTo : FW.a;
        }
        Object objAnimateTo2 = animateTo(currentValue, f, interfaceC0793Of);
        return objAnimateTo2 == AbstractC0378Bt.d() ? objAnimateTo2 : FW.a;
    }

    public final Object snapTo(T t, InterfaceC0793Of interfaceC0793Of) {
        Object objSwipe$default = swipe$default(this, null, new C15742(this, t, null), interfaceC0793Of, 1, null);
        return objSwipe$default == AbstractC0378Bt.d() ? objSwipe$default : FW.a;
    }

    public final boolean trySnapTo$material3_release(T t) {
        return this.swipeMutex.tryMutate(new SwipeableV2State$trySnapTo$1(this, t));
    }

    public final boolean updateAnchors$material3_release(Map<T, Float> map) {
        boolean z;
        AbstractC4492zt.h(map, "newAnchors");
        boolean zIsEmpty = getAnchors$material3_release().isEmpty();
        setAnchors$material3_release(map);
        if (zIsEmpty) {
            T currentValue = getCurrentValue();
            z = getAnchors$material3_release().get(currentValue) != null;
            if (z) {
                trySnapTo$material3_release(currentValue);
            }
        } else {
            z = true;
        }
        return (z && zIsEmpty) ? false : true;
    }

    private SwipeableV2State(T t, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, float f) {
        AbstractC4492zt.h(animationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
        AbstractC4492zt.h(interfaceC0526Fp, "positionalThreshold");
        this.animationSpec = animationSpec;
        this.confirmValueChange = interfaceC3750qp;
        this.positionalThreshold = interfaceC0526Fp;
        this.velocityThreshold = f;
        this.swipeMutex = new InternalMutatorMutex();
        this.swipeDraggableState = new SwipeableV2State$swipeDraggableState$1(this);
        this.currentValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$targetValue$2(this));
        this.offset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$progress$2(this));
        this.lastVelocity$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.minOffset$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$minOffset$2(this));
        this.maxOffset$delegate = SnapshotStateKt.derivedStateOf(new SwipeableV2State$maxOffset$2(this));
        this.animationTarget$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AbstractC4243wx.g(), null, 2, null);
    }

    public /* synthetic */ SwipeableV2State(Object obj, AnimationSpec animationSpec, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, float f, int i, AbstractC0419Di abstractC0419Di) {
        this(obj, (i & 2) != 0 ? SwipeableV2Defaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? AnonymousClass1.INSTANCE : interfaceC3750qp, (i & 8) != 0 ? SwipeableV2Defaults.INSTANCE.getPositionalThreshold() : interfaceC0526Fp, (i & 16) != 0 ? SwipeableV2Defaults.INSTANCE.m1865getVelocityThresholdD9Ej5fM() : f, null);
    }
}
