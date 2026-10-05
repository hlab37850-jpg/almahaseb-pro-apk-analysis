package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.NJ;

/* JADX INFO: loaded from: classes.dex */
public final class DraggableKt$awaitDownAndSlop$postPointerSlop$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ NJ $initialDelta;
    final /* synthetic */ VelocityTracker $velocityTracker;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggableKt$awaitDownAndSlop$postPointerSlop$1(VelocityTracker velocityTracker, NJ nj) {
        super(2);
        this.$velocityTracker = velocityTracker;
        this.$initialDelta = nj;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        m311invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m2808unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
    public final void m311invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
        AbstractC4492zt.h(pointerInputChange, NotificationCompat.CATEGORY_EVENT);
        VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, pointerInputChange);
        pointerInputChange.consume();
        this.$initialDelta.a = j;
    }
}
