package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class AnchoredDraggableState$maxOffset$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableState$maxOffset$2(AnchoredDraggableState<T> anchoredDraggableState) {
        super(0);
        this.this$0 = anchoredDraggableState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        Float fMaxOrNull = AnchoredDraggableKt.maxOrNull(this.this$0.getAnchors$material_release());
        return Float.valueOf(fMaxOrNull != null ? fMaxOrNull.floatValue() : Float.POSITIVE_INFINITY);
    }
}
