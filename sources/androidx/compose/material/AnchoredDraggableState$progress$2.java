package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableState$progress$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableState$progress$2(AnchoredDraggableState<T> anchoredDraggableState) {
        super(0);
        this.this$0 = anchoredDraggableState;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0057  */
    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        Float f = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getCurrentValue());
        float f2 = 0.0f;
        float fFloatValue = f != null ? f.floatValue() : 0.0f;
        Float f3 = (Float) this.this$0.getAnchors$material_release().get(this.this$0.getClosestValue$material_release());
        float fFloatValue2 = (f3 != null ? f3.floatValue() : 0.0f) - fFloatValue;
        if (Math.abs(fFloatValue2) > 1.0E-6f) {
            float fRequireOffset = (this.this$0.requireOffset() - fFloatValue) / fFloatValue2;
            if (fRequireOffset >= 1.0E-6f) {
                if (fRequireOffset > 0.999999f) {
                    f2 = 1.0f;
                } else {
                    f2 = fRequireOffset;
                }
            }
        } else {
            f2 = 1.0f;
        }
        return Float.valueOf(f2);
    }
}
