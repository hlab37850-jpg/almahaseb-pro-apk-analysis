package androidx.compose.foundation.gestures;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class DraggableNode$_startDragImmediately$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ DraggableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableNode$_startDragImmediately$1(DraggableNode draggableNode) {
        super(0);
        this.this$0 = draggableNode;
    }

    @Override // defpackage.InterfaceC3588op
    public final Boolean invoke() {
        return (Boolean) this.this$0.startDragImmediately.invoke();
    }
}
