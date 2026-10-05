package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DraggableKt$onDragOrUp$motionFromChange$2 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final DraggableKt$onDragOrUp$motionFromChange$2 INSTANCE = new DraggableKt$onDragOrUp$motionFromChange$2();

    public DraggableKt$onDragOrUp$motionFromChange$2() {
        super(1);
    }

    @Override // defpackage.InterfaceC3750qp
    public final Float invoke(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "it");
        return Float.valueOf(Offset.m2798getXimpl(PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange)));
    }
}
