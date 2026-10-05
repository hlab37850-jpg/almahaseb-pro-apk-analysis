package androidx.compose.material;

import androidx.compose.runtime.MutableFloatState;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
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
public final class SliderKt$Slider$3$gestureEndAction$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ SliderDraggableState $draggableState;
    final /* synthetic */ LJ $maxPx;
    final /* synthetic */ LJ $minPx;
    final /* synthetic */ InterfaceC3588op $onValueChangeFinished;
    final /* synthetic */ MutableFloatState $rawOffset;
    final /* synthetic */ InterfaceC2052dg $scope;
    final /* synthetic */ List<Float> $tickFractions;

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", f = "Slider.kt", l = {213}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ float $current;
        final /* synthetic */ SliderDraggableState $draggableState;
        final /* synthetic */ InterfaceC3588op $onValueChangeFinished;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SliderDraggableState sliderDraggableState, float f, float f2, float f3, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$draggableState = sliderDraggableState;
            this.$current = f;
            this.$target = f2;
            this.$velocity = f3;
            this.$onValueChangeFinished = interfaceC3588op;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass1(this.$draggableState, this.$current, this.$target, this.$velocity, this.$onValueChangeFinished, interfaceC0793Of);
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
                SliderDraggableState sliderDraggableState = this.$draggableState;
                float f = this.$current;
                float f2 = this.$target;
                float f3 = this.$velocity;
                this.label = 1;
                if (SliderKt.animateToTarget(sliderDraggableState, f, f2, f3, this) == objD) {
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
    public SliderKt$Slider$3$gestureEndAction$1(MutableFloatState mutableFloatState, List<Float> list, LJ lj, LJ lj2, InterfaceC2052dg interfaceC2052dg, SliderDraggableState sliderDraggableState, InterfaceC3588op interfaceC3588op) {
        super(1);
        this.$rawOffset = mutableFloatState;
        this.$tickFractions = list;
        this.$minPx = lj;
        this.$maxPx = lj2;
        this.$scope = interfaceC2052dg;
        this.$draggableState = sliderDraggableState;
        this.$onValueChangeFinished = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return FW.a;
    }

    public final void invoke(float f) {
        InterfaceC3588op interfaceC3588op;
        float floatValue = this.$rawOffset.getFloatValue();
        float fSnapValueToTick = SliderKt.snapValueToTick(floatValue, this.$tickFractions, this.$minPx.a, this.$maxPx.a);
        if (floatValue != fSnapValueToTick) {
            O8.d(this.$scope, null, null, new AnonymousClass1(this.$draggableState, floatValue, fSnapValueToTick, f, this.$onValueChangeFinished, null), 3, null);
        } else {
            if (this.$draggableState.isDragging() || (interfaceC3588op = this.$onValueChangeFinished) == null) {
                return;
            }
            interfaceC3588op.invoke();
        }
    }
}
