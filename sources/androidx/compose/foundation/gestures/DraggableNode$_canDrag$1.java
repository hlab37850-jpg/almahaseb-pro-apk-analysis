package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DraggableNode$_canDrag$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ DraggableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableNode$_canDrag$1(DraggableNode draggableNode) {
        super(1);
        this.this$0 = draggableNode;
    }

    @Override // defpackage.InterfaceC3750qp
    public final Boolean invoke(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "it");
        return (Boolean) this.this$0.canDrag.invoke(pointerInputChange);
    }
}
