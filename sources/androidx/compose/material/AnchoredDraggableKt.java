package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C2;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableKt {

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1", f = "AnchoredDraggable.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ AnchoredDraggableState<T> $state;
        /* synthetic */ float F$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1$1", f = "AnchoredDraggable.kt", l = {82}, m = "invokeSuspend")
        public static final class C00671 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ AnchoredDraggableState<T> $state;
            final /* synthetic */ float $velocity;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00671(AnchoredDraggableState<T> anchoredDraggableState, float f, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$state = anchoredDraggableState;
                this.$velocity = f;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new C00671(this.$state, this.$velocity, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C00671) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    AnchoredDraggableState<T> anchoredDraggableState = this.$state;
                    float f = this.$velocity;
                    this.label = 1;
                    if (anchoredDraggableState.settle(f, this) == objD) {
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
        public AnonymousClass1(AnchoredDraggableState<T> anchoredDraggableState, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$state = anchoredDraggableState;
        }

        public final Object invoke(InterfaceC2052dg interfaceC2052dg, float f, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, interfaceC0793Of);
            anonymousClass1.L$0 = interfaceC2052dg;
            anonymousClass1.F$0 = f;
            return anonymousClass1.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            O8.d((InterfaceC2052dg) this.L$0, null, null, new C00671(this.$state, this.F$0, null), 3, null);
            return FW.a;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((InterfaceC2052dg) obj, ((Number) obj2).floatValue(), (InterfaceC0793Of) obj3);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$animateTo$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material.AnchoredDraggableKt$animateTo$2", f = "AnchoredDraggable.kt", l = {586}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ T $targetValue;
        final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$animateTo$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ AnchoredDragScope $$this$anchoredDrag;
            final /* synthetic */ LJ $prev;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(AnchoredDragScope anchoredDragScope, LJ lj) {
                super(2);
                this.$$this$anchoredDrag = anchoredDragScope;
                this.$prev = lj;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                return FW.a;
            }

            public final void invoke(float f, float f2) {
                this.$$this$anchoredDrag.dragTo(f, f2);
                this.$prev.a = f;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(T t, AnchoredDraggableState<T> anchoredDraggableState, float f, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$targetValue = t;
            this.$this_animateTo = anchoredDraggableState;
            this.$velocity = f;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(AnchoredDragScope anchoredDragScope, Map<T, Float> map, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$targetValue, this.$this_animateTo, this.$velocity, interfaceC0793Of);
            anonymousClass2.L$0 = anchoredDragScope;
            anonymousClass2.L$1 = map;
            return anonymousClass2.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                Float f = (Float) ((Map) this.L$1).get(this.$targetValue);
                if (f != null) {
                    LJ lj = new LJ();
                    float offset = Float.isNaN(this.$this_animateTo.getOffset()) ? 0.0f : this.$this_animateTo.getOffset();
                    lj.a = offset;
                    float fFloatValue = f.floatValue();
                    float f2 = this.$velocity;
                    AnimationSpec<Float> animationSpec = this.$this_animateTo.getAnimationSpec();
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(anchoredDragScope, lj);
                    this.L$0 = null;
                    this.label = 1;
                    if (SuspendAnimationKt.animate(offset, fFloatValue, f2, animationSpec, anonymousClass1, this) == objD) {
                        return objD;
                    }
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

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$rememberAnchoredDraggableState$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14071 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C14071 INSTANCE = new C14071();

        public C14071() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(T t) {
            AbstractC4492zt.h(t, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$rememberAnchoredDraggableState$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14082 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ InterfaceC3750qp $confirmValueChange;
        final /* synthetic */ T $initialValue;
        final /* synthetic */ InterfaceC3750qp $positionalThreshold;
        final /* synthetic */ InterfaceC3588op $velocityThreshold;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14082(T t, InterfaceC3750qp interfaceC3750qp, InterfaceC3588op interfaceC3588op, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp2) {
            super(0);
            this.$initialValue = t;
            this.$positionalThreshold = interfaceC3750qp;
            this.$velocityThreshold = interfaceC3588op;
            this.$animationSpec = animationSpec;
            this.$confirmValueChange = interfaceC3750qp2;
        }

        @Override // defpackage.InterfaceC3588op
        public final AnchoredDraggableState<T> invoke() {
            return new AnchoredDraggableState<>(this.$initialValue, this.$positionalThreshold, this.$velocityThreshold, this.$animationSpec, this.$confirmValueChange);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.AnchoredDraggableKt$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material.AnchoredDraggableKt$snapTo$2", f = "AnchoredDraggable.kt", l = {}, m = "invokeSuspend")
    public static final class C14092 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ T $targetValue;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14092(T t, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$targetValue = t;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(AnchoredDragScope anchoredDragScope, Map<T, Float> map, InterfaceC0793Of interfaceC0793Of) {
            C14092 c14092 = new C14092(this.$targetValue, interfaceC0793Of);
            c14092.L$0 = anchoredDragScope;
            c14092.L$1 = map;
            return c14092.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
            Float f = (Float) ((Map) this.L$1).get(this.$targetValue);
            if (f != null) {
                C2.a(anchoredDragScope, f.floatValue(), 0.0f, 2, null);
            }
            return FW.a;
        }
    }

    @ExperimentalMaterialApi
    public static final <T> Modifier anchoredDraggable(Modifier modifier, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(anchoredDraggableState, "state");
        AbstractC4492zt.h(orientation, "orientation");
        return DraggableKt.draggable(modifier, anchoredDraggableState.getDraggableState$material_release(), orientation, (188 & 4) != 0 ? true : z, (188 & 8) != 0 ? null : mutableInteractionSource, (188 & 16) != 0 ? false : anchoredDraggableState.isAnimationRunning(), (188 & 32) != 0 ? new DraggableKt.C13201(null) : null, (188 & 64) != 0 ? new DraggableKt.AnonymousClass2(null) : new AnonymousClass1(anchoredDraggableState, null), (188 & 128) != 0 ? false : z2);
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? true : z;
        boolean z4 = (i & 8) != 0 ? false : z2;
        if ((i & 16) != 0) {
            mutableInteractionSource = null;
        }
        return anchoredDraggable(modifier, anchoredDraggableState, orientation, z3, z4, mutableInteractionSource);
    }

    @ExperimentalMaterialApi
    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, T t, float f, InterfaceC0793Of interfaceC0793Of) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new AnonymousClass2(t, anchoredDraggableState, f, null), interfaceC0793Of, 2, null);
        return objAnchoredDrag$default == AbstractC0378Bt.d() ? objAnchoredDrag$default : FW.a;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState anchoredDraggableState, Object obj, float f, InterfaceC0793Of interfaceC0793Of, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = anchoredDraggableState.getLastVelocity();
        }
        return animateTo(anchoredDraggableState, obj, f, interfaceC0793Of);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T closestAnchor(Map<T, Float> map, float f, boolean z) {
        if (map.isEmpty()) {
            throw new IllegalArgumentException("The anchors were empty when trying to find the closest anchor");
        }
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        T next = it.next();
        if (it.hasNext()) {
            float fFloatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
            float f2 = z ? fFloatValue - f : f - fFloatValue;
            if (f2 < 0.0f) {
                f2 = Float.POSITIVE_INFINITY;
            }
            do {
                T next2 = it.next();
                float fFloatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                float f3 = z ? fFloatValue2 - f : f - fFloatValue2;
                if (f3 < 0.0f) {
                    f3 = Float.POSITIVE_INFINITY;
                }
                if (Float.compare(f2, f3) > 0) {
                    next = next2;
                    f2 = f3;
                }
            } while (it.hasNext());
        }
        return (T) next.getKey();
    }

    public static /* synthetic */ Object closestAnchor$default(Map map, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return closestAnchor(map, f, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float maxOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float minOrNull(Map<T, Float> map) {
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @Composable
    @ExperimentalMaterialApi
    public static final <T> AnchoredDraggableState<T> rememberAnchoredDraggableState(T t, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        AbstractC4492zt.h(t, "initialValue");
        composer.startReplaceableGroup(-1812391462);
        AnimationSpec<Float> animationSpec2 = (i2 & 2) != 0 ? AnchoredDraggableDefaults.INSTANCE.getAnimationSpec() : animationSpec;
        InterfaceC3750qp interfaceC3750qp2 = (i2 & 4) != 0 ? C14071.INSTANCE : interfaceC3750qp;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1812391462, i, -1, "androidx.compose.material.rememberAnchoredDraggableState (AnchoredDraggable.kt:606)");
        }
        AnchoredDraggableDefaults anchoredDraggableDefaults = AnchoredDraggableDefaults.INSTANCE;
        InterfaceC3750qp positionalThreshold = anchoredDraggableDefaults.getPositionalThreshold(composer, 6);
        InterfaceC3588op velocityThreshold = anchoredDraggableDefaults.getVelocityThreshold(composer, 6);
        AnchoredDraggableState<T> anchoredDraggableState = (AnchoredDraggableState) RememberSaveableKt.m2674rememberSaveable(new Object[]{t, animationSpec2, interfaceC3750qp2, positionalThreshold, velocityThreshold}, (Saver) AnchoredDraggableState.Companion.Saver(animationSpec2, interfaceC3750qp2, positionalThreshold, velocityThreshold), (String) null, (InterfaceC3588op) new C14082(t, positionalThreshold, velocityThreshold, animationSpec2, interfaceC3750qp2), composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return anchoredDraggableState;
    }

    @ExperimentalMaterialApi
    public static final <T> Object snapTo(AnchoredDraggableState<T> anchoredDraggableState, T t, InterfaceC0793Of interfaceC0793Of) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new C14092(t, null), interfaceC0793Of, 2, null);
        return objAnchoredDrag$default == AbstractC0378Bt.d() ? objAnchoredDrag$default : FW.a;
    }
}
