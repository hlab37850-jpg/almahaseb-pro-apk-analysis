package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import defpackage.AbstractC4492zt;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class InternalPointerEvent {
    private final Map<PointerId, PointerInputChange> changes;
    private final PointerInputEvent pointerInputEvent;
    private boolean suppressMovementConsumption;

    public InternalPointerEvent(Map<PointerId, PointerInputChange> map, PointerInputEvent pointerInputEvent) {
        AbstractC4492zt.h(map, "changes");
        AbstractC4492zt.h(pointerInputEvent, "pointerInputEvent");
        this.changes = map;
        this.pointerInputEvent = pointerInputEvent;
    }

    public final Map<PointerId, PointerInputChange> getChanges() {
        return this.changes;
    }

    public final MotionEvent getMotionEvent() {
        return this.pointerInputEvent.getMotionEvent();
    }

    public final PointerInputEvent getPointerInputEvent() {
        return this.pointerInputEvent;
    }

    public final boolean getSuppressMovementConsumption() {
        return this.suppressMovementConsumption;
    }

    /* JADX INFO: renamed from: issuesEnterExitEvent-0FcD4WY, reason: not valid java name */
    public final boolean m3983issuesEnterExitEvent0FcD4WY(long j) {
        PointerInputEventData pointerInputEventData;
        List<PointerInputEventData> pointers = this.pointerInputEvent.getPointers();
        int size = pointers.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputEventData = null;
                break;
            }
            pointerInputEventData = pointers.get(i);
            if (PointerId.m4037equalsimpl0(pointerInputEventData.m4067getIdJ3iCeTQ(), j)) {
                break;
            }
            i++;
        }
        PointerInputEventData pointerInputEventData2 = pointerInputEventData;
        if (pointerInputEventData2 != null) {
            return pointerInputEventData2.getIssuesEnterExit();
        }
        return false;
    }

    public final void setSuppressMovementConsumption(boolean z) {
        this.suppressMovementConsumption = z;
    }
}
