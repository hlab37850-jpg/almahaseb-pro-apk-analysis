package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterialApi
public final class AnchoredDraggableState<T> {
    public static final Companion Companion = new Companion(null);
    private final AnchoredDragScope anchoredDragScope;
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState animationTarget$delegate;
    private final State closestValue$delegate;
    private final InterfaceC3750qp confirmValueChange;
    private final MutableState currentValue$delegate;
    private final InternalMutatorMutex dragMutex;
    private final DraggableState draggableState;
    private final MutableFloatState lastVelocity$delegate;
    private final State maxOffset$delegate;
    private final State minOffset$delegate;
    private final MutableState offset$delegate;
    private final InterfaceC3750qp positionalThreshold;
    private final State progress$delegate;
    private final State targetValue$delegate;
    private final InterfaceC3588op velocityThreshold;

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$1, reason: invalid class name */
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

    @ExperimentalMaterialApi
    public interface AnchorChangedCallback<T> {
        void onAnchorsChanged(T t, Map<T, Float> map, Map<T, Float> map2);
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        @ExperimentalMaterialApi
        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, InterfaceC3588op interfaceC3588op) {
            AbstractC4492zt.h(animationSpec, "animationSpec");
            AbstractC4492zt.h(interfaceC3750qp, "confirmValueChange");
            AbstractC4492zt.h(interfaceC3750qp2, "positionalThreshold");
            AbstractC4492zt.h(interfaceC3588op, "velocityThreshold");
            return SaverKt.Saver(AnchoredDraggableState$Companion$Saver$1.INSTANCE, new AnchoredDraggableState$Companion$Saver$2(interfaceC3750qp2, interfaceC3588op, animationSpec, interfaceC3750qp));
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2", f = "AnchoredDraggable.kt", l = {441}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0552Gp $block;
        final /* synthetic */ MutatePriority $dragPriority;
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2$1, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.material.AnchoredDraggableState$doAnchoredDrag$2$1", f = "AnchoredDraggable.kt", l = {443}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends XS implements InterfaceC3750qp {
            final /* synthetic */ InterfaceC0552Gp $block;
            final /* synthetic */ T $targetValue;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(T t, AnchoredDraggableState<T> anchoredDraggableState, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of) {
                super(1, interfaceC0793Of);
                this.$targetValue = t;
                this.this$0 = anchoredDraggableState;
                this.$block = interfaceC0552Gp;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
                return new AnonymousClass1(this.$targetValue, this.this$0, this.$block, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC3750qp
            public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass1) create(interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    T t = this.$targetValue;
                    if (t != null) {
                        this.this$0.setAnimationTarget(t);
                    }
                    InterfaceC0552Gp interfaceC0552Gp = this.$block;
                    AnchoredDragScope anchoredDragScope = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                    Map<T, Float> anchors$material_release = this.this$0.getAnchors$material_release();
                    this.label = 1;
                    if (interfaceC0552Gp.invoke(anchoredDragScope, anchors$material_release, this) == objD) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(T t, AnchoredDraggableState<T> anchoredDraggableState, MutatePriority mutatePriority, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$targetValue = t;
            this.this$0 = anchoredDraggableState;
            this.$dragPriority = mutatePriority;
            this.$block = interfaceC0552Gp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.$targetValue, this.this$0, this.$dragPriority, this.$block, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            T next;
            Object key;
            T next2;
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            try {
                if (i == 0) {
                    LL.b(obj);
                    if (this.$targetValue == null || this.this$0.getAnchors$material_release().containsKey(this.$targetValue)) {
                        InternalMutatorMutex internalMutatorMutex = ((AnchoredDraggableState) this.this$0).dragMutex;
                        MutatePriority mutatePriority = this.$dragPriority;
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetValue, this.this$0, this.$block, null);
                        this.label = 1;
                        if (internalMutatorMutex.mutate(mutatePriority, anonymousClass1, this) == objD) {
                            return objD;
                        }
                    } else if (((Boolean) this.this$0.getConfirmValueChange$material_release().invoke(this.$targetValue)).booleanValue()) {
                        this.this$0.setCurrentValue(this.$targetValue);
                    }
                    return FW.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
                if (this.$targetValue != null) {
                    this.this$0.setAnimationTarget(null);
                }
                Set<Map.Entry<T, Float>> setEntrySet = this.this$0.getAnchors$material_release().entrySet();
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                Iterator<T> it = setEntrySet.iterator();
                do {
                    if (!it.hasNext()) {
                        next2 = (T) null;
                        break;
                    }
                    next2 = it.next();
                } while (Math.abs(((Number) ((Map.Entry) next2).getValue()).floatValue() - anchoredDraggableState.getOffset()) >= 0.5f);
                Map.Entry entry = next2;
                key = entry != null ? entry.getKey() : null;
                if (key != null && ((Boolean) this.this$0.getConfirmValueChange$material_release().invoke(key)).booleanValue()) {
                    this.this$0.setCurrentValue(key);
                }
                return FW.a;
            } catch (Throwable th) {
                if (this.$targetValue != null) {
                    this.this$0.setAnimationTarget(null);
                }
                Set<Map.Entry<T, Float>> setEntrySet2 = this.this$0.getAnchors$material_release().entrySet();
                AnchoredDraggableState<T> anchoredDraggableState2 = this.this$0;
                Iterator<T> it2 = setEntrySet2.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = (T) null;
                        break;
                    }
                    next = it2.next();
                } while (Math.abs(((Number) ((Map.Entry) next).getValue()).floatValue() - anchoredDraggableState2.getOffset()) >= 0.5f);
                Map.Entry entry2 = next;
                key = entry2 != null ? entry2.getKey() : null;
                if (key != null && ((Boolean) this.this$0.getConfirmValueChange$material_release().invoke(key)).booleanValue()) {
                    this.this$0.setCurrentValue(key);
                }
                throw th;
            }
        }
    }

    public AnchoredDraggableState(T t, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp2) {
        AbstractC4492zt.h(interfaceC3750qp, "positionalThreshold");
        AbstractC4492zt.h(interfaceC3588op, "velocityThreshold");
        AbstractC4492zt.h(animationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp2, "confirmValueChange");
        this.positionalThreshold = interfaceC3750qp;
        this.velocityThreshold = interfaceC3588op;
        this.animationSpec = animationSpec;
        this.confirmValueChange = interfaceC3750qp2;
        this.dragMutex = new InternalMutatorMutex();
        this.draggableState = new AnchoredDraggableState$draggableState$1(this);
        this.currentValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$targetValue$2(this));
        this.closestValue$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$closestValue$2(this));
        this.offset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(Float.NaN), null, 2, null);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new AnchoredDraggableState$progress$2(this));
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.minOffset$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$minOffset$2(this));
        this.maxOffset$delegate = SnapshotStateKt.derivedStateOf(new AnchoredDraggableState$maxOffset$2(this));
        this.animationTarget$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AbstractC4243wx.g(), null, 2, null);
        this.anchoredDragScope = new AnchoredDragScope(this) { // from class: androidx.compose.material.AnchoredDraggableState$anchoredDragScope$1
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.compose.material.AnchoredDragScope
            public void dragTo(float f, float f2) {
                this.this$0.setOffset(f);
                this.this$0.setLastVelocity(f2);
            }
        };
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, interfaceC0552Gp, interfaceC0793Of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTarget(float f, T t, float f2) {
        Object objClosestAnchor;
        Map<T, Float> anchors$material_release = getAnchors$material_release();
        Float f3 = anchors$material_release.get(t);
        float fFloatValue = ((Number) this.velocityThreshold.invoke()).floatValue();
        if (AbstractC4492zt.b(f3, f) || f3 == null) {
            return t;
        }
        if (f3.floatValue() < f) {
            if (f2 >= fFloatValue) {
                return (T) AnchoredDraggableKt.closestAnchor(anchors$material_release, f, true);
            }
            objClosestAnchor = AnchoredDraggableKt.closestAnchor(anchors$material_release, f, true);
            if (f < Math.abs(f3.floatValue() + Math.abs(((Number) this.positionalThreshold.invoke(Float.valueOf(Math.abs(((Number) AbstractC4243wx.h(anchors$material_release, objClosestAnchor)).floatValue() - f3.floatValue())))).floatValue()))) {
                return t;
            }
        } else {
            if (f2 <= (-fFloatValue)) {
                return (T) AnchoredDraggableKt.closestAnchor(anchors$material_release, f, false);
            }
            objClosestAnchor = AnchoredDraggableKt.closestAnchor(anchors$material_release, f, false);
            float fAbs = Math.abs(f3.floatValue() - Math.abs(((Number) this.positionalThreshold.invoke(Float.valueOf(Math.abs(f3.floatValue() - ((Number) AbstractC4243wx.h(anchors$material_release, objClosestAnchor)).floatValue())))).floatValue()));
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
    public final T computeTargetWithoutThresholds(float f, T t) {
        Map<T, Float> anchors$material_release = getAnchors$material_release();
        Float f2 = anchors$material_release.get(t);
        if (AbstractC4492zt.b(f2, f) || f2 == null) {
            return t;
        }
        return f2.floatValue() < f ? (T) AnchoredDraggableKt.closestAnchor(anchors$material_release, f, true) : (T) AnchoredDraggableKt.closestAnchor(anchors$material_release, f, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doAnchoredDrag(T t, MutatePriority mutatePriority, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of) {
        Object objD = AbstractC2133eg.d(new AnonymousClass2(t, this, mutatePriority, interfaceC0552Gp, null), interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T getAnimationTarget() {
        return this.animationTarget$delegate.getValue();
    }

    public static /* synthetic */ void getOffset$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationTarget(T t) {
        this.animationTarget$delegate.setValue(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity$delegate.setFloatValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOffset(float f) {
        this.offset$delegate.setValue(Float.valueOf(f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$material_release$default(AnchoredDraggableState anchoredDraggableState, Map map, AnchorChangedCallback anchorChangedCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            anchorChangedCallback = null;
        }
        anchoredDraggableState.updateAnchors$material_release(map, anchorChangedCallback);
    }

    public final Object anchoredDrag(MutatePriority mutatePriority, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of) {
        Object objDoAnchoredDrag = doAnchoredDrag(null, mutatePriority, interfaceC0552Gp, interfaceC0793Of);
        return objDoAnchoredDrag == AbstractC0378Bt.d() ? objDoAnchoredDrag : FW.a;
    }

    public final float dispatchRawDelta(float f) {
        float fNewOffsetForDelta$material_release = newOffsetForDelta$material_release(f);
        float offset = Float.isNaN(getOffset()) ? 0.0f : getOffset();
        setOffset(fNewOffsetForDelta$material_release);
        return fNewOffsetForDelta$material_release - offset;
    }

    public final Map<T, Float> getAnchors$material_release() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final T getClosestValue$material_release() {
        return (T) this.closestValue$delegate.getValue();
    }

    public final InterfaceC3750qp getConfirmValueChange$material_release() {
        return this.confirmValueChange;
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final DraggableState getDraggableState$material_release() {
        return this.draggableState;
    }

    public final float getLastVelocity() {
        return this.lastVelocity$delegate.getFloatValue();
    }

    public final float getMaxOffset() {
        return ((Number) this.maxOffset$delegate.getValue()).floatValue();
    }

    public final float getMinOffset() {
        return ((Number) this.minOffset$delegate.getValue()).floatValue();
    }

    public final float getOffset() {
        return ((Number) this.offset$delegate.getValue()).floatValue();
    }

    public final InterfaceC3750qp getPositionalThreshold$material_release() {
        return this.positionalThreshold;
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue$delegate.getValue();
    }

    public final InterfaceC3588op getVelocityThreshold$material_release() {
        return this.velocityThreshold;
    }

    public final boolean hasAnchorForValue(T t) {
        return getAnchors$material_release().containsKey(t);
    }

    public final boolean isAnimationRunning() {
        return getAnimationTarget() != null;
    }

    public final float newOffsetForDelta$material_release(float f) {
        return AbstractC3871sJ.k((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + f, getMinOffset(), getMaxOffset());
    }

    public final float requireOffset() {
        if (Float.isNaN(getOffset())) {
            throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }
        return getOffset();
    }

    public final void setAnchors$material_release(Map<T, Float> map) {
        AbstractC4492zt.h(map, "<set-?>");
        this.anchors$delegate.setValue(map);
    }

    public final Object settle(float f, InterfaceC0793Of interfaceC0793Of) {
        T currentValue = getCurrentValue();
        T tComputeTarget = computeTarget(requireOffset(), currentValue, f);
        if (((Boolean) this.confirmValueChange.invoke(tComputeTarget)).booleanValue()) {
            Object objAnimateTo = AnchoredDraggableKt.animateTo(this, tComputeTarget, f, interfaceC0793Of);
            return objAnimateTo == AbstractC0378Bt.d() ? objAnimateTo : FW.a;
        }
        Object objAnimateTo2 = AnchoredDraggableKt.animateTo(this, currentValue, f, interfaceC0793Of);
        return objAnimateTo2 == AbstractC0378Bt.d() ? objAnimateTo2 : FW.a;
    }

    public final boolean trySnapTo$material_release(T t) {
        return this.dragMutex.tryMutate(new AnchoredDraggableState$trySnapTo$1(this, t));
    }

    public final void updateAnchors$material_release(Map<T, Float> map, AnchorChangedCallback<T> anchorChangedCallback) {
        AbstractC4492zt.h(map, "newAnchors");
        if (AbstractC4492zt.d(getAnchors$material_release(), map)) {
            return;
        }
        Map<T, Float> anchors$material_release = getAnchors$material_release();
        T targetValue = getTargetValue();
        boolean zIsEmpty = getAnchors$material_release().isEmpty();
        setAnchors$material_release(map);
        boolean z = getAnchors$material_release().get(getCurrentValue()) != null;
        if (zIsEmpty && z) {
            trySnapTo$material_release(getCurrentValue());
        } else if (anchorChangedCallback != null) {
            anchorChangedCallback.onAnchorsChanged(targetValue, anchors$material_release, map);
        }
    }

    public final Object anchoredDrag(T t, MutatePriority mutatePriority, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of) {
        Object objDoAnchoredDrag = doAnchoredDrag(t, mutatePriority, interfaceC0552Gp, interfaceC0793Of);
        return objDoAnchoredDrag == AbstractC0378Bt.d() ? objDoAnchoredDrag : FW.a;
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0793Of interfaceC0793Of, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, interfaceC0552Gp, interfaceC0793Of);
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, AnimationSpec animationSpec, InterfaceC3750qp interfaceC3750qp2, int i, AbstractC0419Di abstractC0419Di) {
        this(obj, interfaceC3750qp, interfaceC3588op, (i & 8) != 0 ? AnchoredDraggableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 16) != 0 ? AnonymousClass1.INSTANCE : interfaceC3750qp2);
    }
}
