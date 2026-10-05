package androidx.compose.material3;

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
        float fFloatValue = ((Number) ((SwipeableState) this.this$0).absoluteOffset.getValue()).floatValue() + f;
        float fK = AbstractC3871sJ.k(fFloatValue, this.this$0.getMinBound$material3_release(), this.this$0.getMaxBound$material3_release());
        float f2 = fFloatValue - fK;
        ResistanceConfig resistance$material3_release = this.this$0.getResistance$material3_release();
        ((SwipeableState) this.this$0).offsetState.setValue(Float.valueOf(fK + (resistance$material3_release != null ? resistance$material3_release.computeResistance(f2) : 0.0f)));
        ((SwipeableState) this.this$0).overflowState.setValue(Float.valueOf(f2));
        ((SwipeableState) this.this$0).absoluteOffset.setValue(Float.valueOf(fFloatValue));
    }
}
