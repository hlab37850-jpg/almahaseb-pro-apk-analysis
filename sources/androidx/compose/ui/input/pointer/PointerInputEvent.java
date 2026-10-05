package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PointerInputEvent {
    private final MotionEvent motionEvent;
    private final List<PointerInputEventData> pointers;
    private final long uptime;

    public PointerInputEvent(long j, List<PointerInputEventData> list, MotionEvent motionEvent) {
        AbstractC4492zt.h(list, "pointers");
        AbstractC4492zt.h(motionEvent, "motionEvent");
        this.uptime = j;
        this.pointers = list;
        this.motionEvent = motionEvent;
    }

    public final MotionEvent getMotionEvent() {
        return this.motionEvent;
    }

    public final List<PointerInputEventData> getPointers() {
        return this.pointers;
    }

    public final long getUptime() {
        return this.uptime;
    }
}
