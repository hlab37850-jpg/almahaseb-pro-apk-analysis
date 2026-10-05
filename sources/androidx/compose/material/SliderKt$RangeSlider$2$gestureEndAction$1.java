package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.State;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3790rJ;
import defpackage.AbstractC4492zt;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0789Ob;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LJ;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$RangeSlider$2$gestureEndAction$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ LJ $maxPx;
    final /* synthetic */ LJ $minPx;
    final /* synthetic */ InterfaceC3588op $onValueChangeFinished;
    final /* synthetic */ State<InterfaceC3750qp> $onValueChangeState;
    final /* synthetic */ MutableFloatState $rawOffsetEnd;
    final /* synthetic */ MutableFloatState $rawOffsetStart;
    final /* synthetic */ InterfaceC2052dg $scope;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ InterfaceC0789Ob $valueRange;

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1", f = "Slider.kt", l = {361}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ float $current;
        final /* synthetic */ boolean $isStart;
        final /* synthetic */ LJ $maxPx;
        final /* synthetic */ LJ $minPx;
        final /* synthetic */ InterfaceC3588op $onValueChangeFinished;
        final /* synthetic */ State<InterfaceC3750qp> $onValueChangeState;
        final /* synthetic */ MutableFloatState $rawOffsetEnd;
        final /* synthetic */ MutableFloatState $rawOffsetStart;
        final /* synthetic */ float $target;
        final /* synthetic */ InterfaceC0789Ob $valueRange;
        int label;

        /* JADX INFO: renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00831 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ boolean $isStart;
            final /* synthetic */ LJ $maxPx;
            final /* synthetic */ LJ $minPx;
            final /* synthetic */ State<InterfaceC3750qp> $onValueChangeState;
            final /* synthetic */ MutableFloatState $rawOffsetEnd;
            final /* synthetic */ MutableFloatState $rawOffsetStart;
            final /* synthetic */ InterfaceC0789Ob $valueRange;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00831(boolean z, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, State<? extends InterfaceC3750qp> state, LJ lj, LJ lj2, InterfaceC0789Ob interfaceC0789Ob) {
                super(1);
                this.$isStart = z;
                this.$rawOffsetStart = mutableFloatState;
                this.$rawOffsetEnd = mutableFloatState2;
                this.$onValueChangeState = state;
                this.$minPx = lj;
                this.$maxPx = lj2;
                this.$valueRange = interfaceC0789Ob;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Animatable<Float, AnimationVector1D>) obj);
                return FW.a;
            }

            public final void invoke(Animatable<Float, AnimationVector1D> animatable) {
                AbstractC4492zt.h(animatable, "$this$animateTo");
                (this.$isStart ? this.$rawOffsetStart : this.$rawOffsetEnd).setFloatValue(animatable.getValue().floatValue());
                this.$onValueChangeState.getValue().invoke(SliderKt.C14352.invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, AbstractC3790rJ.b(this.$rawOffsetStart.getFloatValue(), this.$rawOffsetEnd.getFloatValue())));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(float f, float f2, InterfaceC3588op interfaceC3588op, boolean z, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, State<? extends InterfaceC3750qp> state, LJ lj, LJ lj2, InterfaceC0789Ob interfaceC0789Ob, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$current = f;
            this.$target = f2;
            this.$onValueChangeFinished = interfaceC3588op;
            this.$isStart = z;
            this.$rawOffsetStart = mutableFloatState;
            this.$rawOffsetEnd = mutableFloatState2;
            this.$onValueChangeState = state;
            this.$minPx = lj;
            this.$maxPx = lj2;
            this.$valueRange = interfaceC0789Ob;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$current, this.$target, this.$onValueChangeFinished, this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                Animatable animatableAnimatable$default = AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null);
                Float fB = E8.b(this.$target);
                TweenSpec tweenSpec = SliderKt.SliderToTickAnimation;
                Float fB2 = E8.b(0.0f);
                C00831 c00831 = new C00831(this.$isStart, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange);
                this.label = 1;
                if (animatableAnimatable$default.animateTo(fB, tweenSpec, fB2, c00831, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            InterfaceC3588op interfaceC3588op = this.$onValueChangeFinished;
            if (interfaceC3588op != null) {
                interfaceC3588op.invoke();
            }
            return FW.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$RangeSlider$2$gestureEndAction$1(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, List<Float> list, LJ lj, LJ lj2, InterfaceC3588op interfaceC3588op, InterfaceC2052dg interfaceC2052dg, State<? extends InterfaceC3750qp> state, InterfaceC0789Ob interfaceC0789Ob) {
        super(1);
        this.$rawOffsetStart = mutableFloatState;
        this.$rawOffsetEnd = mutableFloatState2;
        this.$tickFractions = list;
        this.$minPx = lj;
        this.$maxPx = lj2;
        this.$onValueChangeFinished = interfaceC3588op;
        this.$scope = interfaceC2052dg;
        this.$onValueChangeState = state;
        this.$valueRange = interfaceC0789Ob;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return FW.a;
    }

    public final void invoke(boolean z) {
        float floatValue = (z ? this.$rawOffsetStart : this.$rawOffsetEnd).getFloatValue();
        float fSnapValueToTick = SliderKt.snapValueToTick(floatValue, this.$tickFractions, this.$minPx.a, this.$maxPx.a);
        if (floatValue != fSnapValueToTick) {
            O8.d(this.$scope, null, null, new AnonymousClass1(floatValue, fSnapValueToTick, this.$onValueChangeFinished, z, this.$rawOffsetStart, this.$rawOffsetEnd, this.$onValueChangeState, this.$minPx, this.$maxPx, this.$valueRange, null), 3, null);
            return;
        }
        InterfaceC3588op interfaceC3588op = this.$onValueChangeFinished;
        if (interfaceC3588op != null) {
            interfaceC3588op.invoke();
        }
    }
}
