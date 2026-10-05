package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import defpackage.KJ;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ KJ $draggingStart;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ State<InterfaceC0526Fp> $onDrag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1(State<? extends InterfaceC0526Fp> state, KJ kj, boolean z) {
        super(1);
        this.$onDrag = state;
        this.$draggingStart = kj;
        this.$isRtl = z;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return FW.a;
    }

    public final void invoke(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "it");
        float fM2798getXimpl = Offset.m2798getXimpl(PointerEventKt.positionChange(pointerInputChange));
        InterfaceC0526Fp value = this.$onDrag.getValue();
        Boolean boolValueOf = Boolean.valueOf(this.$draggingStart.a);
        if (this.$isRtl) {
            fM2798getXimpl = -fM2798getXimpl;
        }
        value.mo13invoke(boolValueOf, Float.valueOf(fM2798getXimpl));
    }
}
