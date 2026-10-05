package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$SliderImpl$gestureEndAction$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ SliderDraggableState $draggableState;
    final /* synthetic */ InterfaceC3588op $onValueChangeFinished;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$SliderImpl$gestureEndAction$1(SliderDraggableState sliderDraggableState, InterfaceC3588op interfaceC3588op) {
        super(0);
        this.$draggableState = sliderDraggableState;
        this.$onValueChangeFinished = interfaceC3588op;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        m1756invoke();
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1756invoke() {
        InterfaceC3588op interfaceC3588op;
        if (this.$draggableState.isDragging() || (interfaceC3588op = this.$onValueChangeFinished) == null) {
            return;
        }
        interfaceC3588op.invoke();
    }
}
