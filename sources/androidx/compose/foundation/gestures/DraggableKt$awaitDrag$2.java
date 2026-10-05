package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4038uO;

/* JADX INFO: loaded from: classes.dex */
public final class DraggableKt$awaitDrag$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ InterfaceC4038uO $channel;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ VelocityTracker $velocityTracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableKt$awaitDrag$2(VelocityTracker velocityTracker, InterfaceC4038uO interfaceC4038uO, boolean z) {
        super(1);
        this.$velocityTracker = velocityTracker;
        this.$channel = interfaceC4038uO;
        this.$reverseDirection = z;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return FW.a;
    }

    public final void invoke(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, NotificationCompat.CATEGORY_EVENT);
        VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, pointerInputChange);
        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            return;
        }
        long jPositionChange = PointerEventKt.positionChange(pointerInputChange);
        pointerInputChange.consume();
        InterfaceC4038uO interfaceC4038uO = this.$channel;
        if (this.$reverseDirection) {
            jPositionChange = Offset.m2805timestuRUvjQ(jPositionChange, -1.0f);
        }
        interfaceC4038uO.mo0trySendJP2dKIU(new DragEvent.DragDelta(jPositionChange, null));
    }
}
