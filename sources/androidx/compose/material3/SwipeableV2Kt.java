package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
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
import defpackage.O8;
import defpackage.XS;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableV2Kt {

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2Kt$fractionalPositionalThreshold$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ float $fraction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(float f) {
            super(2);
            this.$fraction = f;
        }

        public final Float invoke(Density density, float f) {
            AbstractC4492zt.h(density, "$this$null");
            return Float.valueOf(f * this.$fraction);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return invoke((Density) obj, ((Number) obj2).floatValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2Kt$rememberSwipeableV2State$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15691 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C15691 INSTANCE = new C15691();

        public C15691() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(T t) {
            AbstractC4492zt.h(t, "it");
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2Kt$rememberSwipeableV2State$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ InterfaceC3750qp $confirmValueChange;
        final /* synthetic */ T $initialValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(T t, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp) {
            super(0);
            this.$initialValue = t;
            this.$animationSpec = animationSpec;
            this.$confirmValueChange = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3588op
        public final SwipeableV2State<T> invoke() {
            Object obj = this.$initialValue;
            AnimationSpec<Float> animationSpec = this.$animationSpec;
            InterfaceC3750qp interfaceC3750qp = this.$confirmValueChange;
            SwipeableV2Defaults swipeableV2Defaults = SwipeableV2Defaults.INSTANCE;
            return new SwipeableV2State<>(obj, animationSpec, interfaceC3750qp, swipeableV2Defaults.getPositionalThreshold(), swipeableV2Defaults.m1865getVelocityThresholdD9Ej5fM(), null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2Kt$swipeAnchors$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15701 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ SwipeableV2State<T> $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15701(SwipeableV2State<T> swipeableV2State) {
            super(1);
            this.$state = swipeableV2State;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Density) obj);
            return FW.a;
        }

        public final void invoke(Density density) {
            AbstractC4492zt.h(density, "it");
            this.$state.setDensity$material3_release(density);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2Kt$swipeAnchors$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15712 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ AnchorChangeHandler<T> $anchorChangeHandler;
        final /* synthetic */ InterfaceC0526Fp $calculateAnchor;
        final /* synthetic */ Set<T> $possibleValues;
        final /* synthetic */ SwipeableV2State<T> $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C15712(SwipeableV2State<T> swipeableV2State, Set<? extends T> set, AnchorChangeHandler<T> anchorChangeHandler, InterfaceC0526Fp interfaceC0526Fp) {
            super(1);
            this.$state = swipeableV2State;
            this.$possibleValues = set;
            this.$anchorChangeHandler = anchorChangeHandler;
            this.$calculateAnchor = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m1867invokeozmzZPI(((IntSize) obj).m5324unboximpl());
            return FW.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
        public final void m1867invokeozmzZPI(long j) {
            AnchorChangeHandler<T> anchorChangeHandler;
            Map anchors$material3_release = this.$state.getAnchors$material3_release();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterable iterable = this.$possibleValues;
            InterfaceC0526Fp interfaceC0526Fp = this.$calculateAnchor;
            for (Object obj : iterable) {
                Float f = (Float) interfaceC0526Fp.mo13invoke(obj, IntSize.m5312boximpl(j));
                if (f != null) {
                    linkedHashMap.put(obj, f);
                }
            }
            if (AbstractC4492zt.d(anchors$material3_release, linkedHashMap)) {
                return;
            }
            Object targetValue = this.$state.getTargetValue();
            if (!this.$state.updateAnchors$material3_release(linkedHashMap) || (anchorChangeHandler = this.$anchorChangeHandler) == 0) {
                return;
            }
            anchorChangeHandler.onAnchorsChanged((T) targetValue, (Map<T, Float>) anchors$material3_release, linkedHashMap);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2Kt$swipeableV2$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.material3.SwipeableV2Kt$swipeableV2$1", f = "SwipeableV2.kt", l = {}, m = "invokeSuspend")
    public static final class C15721 extends XS implements InterfaceC0552Gp {
        final /* synthetic */ SwipeableV2State<T> $state;
        /* synthetic */ float F$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material3.SwipeableV2Kt$swipeableV2$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.material3.SwipeableV2Kt$swipeableV2$1$1", f = "SwipeableV2.kt", l = {91}, m = "invokeSuspend")
        public static final class C01231 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ SwipeableV2State<T> $state;
            final /* synthetic */ float $velocity;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01231(SwipeableV2State<T> swipeableV2State, float f, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$state = swipeableV2State;
                this.$velocity = f;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return new C01231(this.$state, this.$velocity, interfaceC0793Of);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C01231) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
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
                    SwipeableV2State<T> swipeableV2State = this.$state;
                    float f = this.$velocity;
                    this.label = 1;
                    if (swipeableV2State.settle(f, this) == objD) {
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
        public C15721(SwipeableV2State<T> swipeableV2State, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.$state = swipeableV2State;
        }

        public final Object invoke(InterfaceC2052dg interfaceC2052dg, float f, InterfaceC0793Of interfaceC0793Of) {
            C15721 c15721 = new C15721(this.$state, interfaceC0793Of);
            c15721.L$0 = interfaceC2052dg;
            c15721.F$0 = f;
            return c15721.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            O8.d((InterfaceC2052dg) this.L$0, null, null, new C01231(this.$state, this.F$0, null), 3, null);
            return FW.a;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((InterfaceC2052dg) obj, ((Number) obj2).floatValue(), (InterfaceC0793Of) obj3);
        }
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

    @ExperimentalMaterial3Api
    /* JADX INFO: renamed from: fixedPositionalThreshold-0680j_4, reason: not valid java name */
    public static final InterfaceC0526Fp m1866fixedPositionalThreshold0680j_4(float f) {
        return new SwipeableV2Kt$fixedPositionalThreshold$1(f);
    }

    @ExperimentalMaterial3Api
    public static final InterfaceC0526Fp fractionalPositionalThreshold(float f) {
        return new AnonymousClass1(f);
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
    @ExperimentalMaterial3Api
    public static final <T> SwipeableV2State<T> rememberSwipeableV2State(T t, AnimationSpec<Float> animationSpec, InterfaceC3750qp interfaceC3750qp, Composer composer, int i, int i2) {
        AbstractC4492zt.h(t, "initialValue");
        composer.startReplaceableGroup(856267266);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableV2Defaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            interfaceC3750qp = C15691.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(856267266, i, -1, "androidx.compose.material3.rememberSwipeableV2State (SwipeableV2.kt:517)");
        }
        SwipeableV2State.Companion companion = SwipeableV2State.Companion;
        SwipeableV2Defaults swipeableV2Defaults = SwipeableV2Defaults.INSTANCE;
        SwipeableV2State<T> swipeableV2State = (SwipeableV2State) RememberSaveableKt.m2674rememberSaveable(new Object[]{t, animationSpec, interfaceC3750qp}, (Saver) companion.m1869SavereqLRuRQ(animationSpec, interfaceC3750qp, swipeableV2Defaults.getPositionalThreshold(), swipeableV2Defaults.m1865getVelocityThresholdD9Ej5fM()), (String) null, (InterfaceC3588op) new AnonymousClass2(t, animationSpec, interfaceC3750qp), composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return swipeableV2State;
    }

    @ExperimentalMaterial3Api
    public static final <T> Modifier swipeAnchors(Modifier modifier, SwipeableV2State<T> swipeableV2State, Set<? extends T> set, AnchorChangeHandler<T> anchorChangeHandler, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(swipeableV2State, "state");
        AbstractC4492zt.h(set, "possibleValues");
        AbstractC4492zt.h(interfaceC0526Fp, "calculateAnchor");
        return modifier.then(new SwipeAnchorsModifier(new C15701(swipeableV2State), new C15712(swipeableV2State, set, anchorChangeHandler, interfaceC0526Fp), InspectableValueKt.isDebugInspectorInfoEnabled() ? new SwipeableV2Kt$swipeAnchors$$inlined$debugInspectorInfo$1(swipeableV2State, set, anchorChangeHandler, interfaceC0526Fp) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static /* synthetic */ Modifier swipeAnchors$default(Modifier modifier, SwipeableV2State swipeableV2State, Set set, AnchorChangeHandler anchorChangeHandler, InterfaceC0526Fp interfaceC0526Fp, int i, Object obj) {
        if ((i & 4) != 0) {
            anchorChangeHandler = null;
        }
        return swipeAnchors(modifier, swipeableV2State, set, anchorChangeHandler, interfaceC0526Fp);
    }

    @ExperimentalMaterial3Api
    public static final <T> Modifier swipeableV2(Modifier modifier, SwipeableV2State<T> swipeableV2State, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(swipeableV2State, "state");
        AbstractC4492zt.h(orientation, "orientation");
        return DraggableKt.draggable(modifier, swipeableV2State.getSwipeDraggableState$material3_release(), orientation, (188 & 4) != 0 ? true : z, (188 & 8) != 0 ? null : mutableInteractionSource, (188 & 16) != 0 ? false : swipeableV2State.isAnimationRunning(), (188 & 32) != 0 ? new DraggableKt.C13201(null) : null, (188 & 64) != 0 ? new DraggableKt.AnonymousClass2(null) : new C15721(swipeableV2State, null), (188 & 128) != 0 ? false : z2);
    }

    public static /* synthetic */ Modifier swipeableV2$default(Modifier modifier, SwipeableV2State swipeableV2State, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        boolean z3 = (i & 4) != 0 ? true : z;
        boolean z4 = (i & 8) != 0 ? false : z2;
        if ((i & 16) != 0) {
            mutableInteractionSource = null;
        }
        return swipeableV2(modifier, swipeableV2State, orientation, z3, z4, mutableInteractionSource);
    }
}
