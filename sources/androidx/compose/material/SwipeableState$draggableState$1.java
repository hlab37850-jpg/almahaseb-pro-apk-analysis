package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SwipeableState$draggableState$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ SwipeableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableState$draggableState$1(SwipeableState<T> swipeableState) {
        super(1);
        this.this$0 = swipeableState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return FW.a;
    }

    public final void invoke(float f) {
        float floatValue = ((SwipeableState) this.this$0).absoluteOffset.getFloatValue() + f;
        float fK = AbstractC3871sJ.k(floatValue, this.this$0.getMinBound$material_release(), this.this$0.getMaxBound$material_release());
        float f2 = floatValue - fK;
        ResistanceConfig resistance$material_release = this.this$0.getResistance$material_release();
        ((SwipeableState) this.this$0).offsetState.setFloatValue(fK + (resistance$material_release != null ? resistance$material_release.computeResistance(f2) : 0.0f));
        ((SwipeableState) this.this$0).overflowState.setFloatValue(f2);
        ((SwipeableState) this.this$0).absoluteOffset.setFloatValue(floatValue);
    }
}
