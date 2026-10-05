package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchKt$Switch$5$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ AnchoredDraggableState<Boolean> $anchoredDraggableState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchKt$Switch$5$1$1(AnchoredDraggableState<Boolean> anchoredDraggableState) {
        super(0);
        this.$anchoredDraggableState = anchoredDraggableState;
    }

    @Override // defpackage.InterfaceC3588op
    public final Float invoke() {
        return Float.valueOf(this.$anchoredDraggableState.requireOffset());
    }
}
