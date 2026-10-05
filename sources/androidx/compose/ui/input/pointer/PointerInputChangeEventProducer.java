package androidx.compose.ui.input.pointer;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class PointerInputChangeEventProducer {
    private final Map<PointerId, PointerInputData> previousPointerInputData = new LinkedHashMap();

    public static final class PointerInputData {
        private final boolean down;
        private final long positionOnScreen;
        private final int type;
        private final long uptime;

        public /* synthetic */ PointerInputData(long j, long j2, boolean z, int i, AbstractC0419Di abstractC0419Di) {
            this(j, j2, z, i);
        }

        public final boolean getDown() {
            return this.down;
        }

        /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
        public final long m4058getPositionOnScreenF1C5BW0() {
            return this.positionOnScreen;
        }

        /* JADX INFO: renamed from: getType-T8wyACA, reason: not valid java name */
        public final int m4059getTypeT8wyACA() {
            return this.type;
        }

        public final long getUptime() {
            return this.uptime;
        }

        private PointerInputData(long j, long j2, boolean z, int i) {
            this.uptime = j;
            this.positionOnScreen = j2;
            this.down = z;
            this.type = i;
        }
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    public final InternalPointerEvent produce(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator) {
        long uptime;
        boolean down;
        long jMo4122screenToLocalMKHz9U;
        AbstractC4492zt.h(pointerInputEvent, "pointerInputEvent");
        AbstractC4492zt.h(positionCalculator, "positionCalculator");
        LinkedHashMap linkedHashMap = new LinkedHashMap(pointerInputEvent.getPointers().size());
        List<PointerInputEventData> pointers = pointerInputEvent.getPointers();
        int size = pointers.size();
        for (int i = 0; i < size; i++) {
            PointerInputEventData pointerInputEventData = pointers.get(i);
            PointerInputData pointerInputData = this.previousPointerInputData.get(PointerId.m4034boximpl(pointerInputEventData.m4067getIdJ3iCeTQ()));
            if (pointerInputData == null) {
                uptime = pointerInputEventData.getUptime();
                jMo4122screenToLocalMKHz9U = pointerInputEventData.m4068getPositionF1C5BW0();
                down = false;
            } else {
                long uptime2 = pointerInputData.getUptime();
                uptime = uptime2;
                down = pointerInputData.getDown();
                jMo4122screenToLocalMKHz9U = positionCalculator.mo4122screenToLocalMKHz9U(pointerInputData.m4058getPositionOnScreenF1C5BW0());
            }
            linkedHashMap.put(PointerId.m4034boximpl(pointerInputEventData.m4067getIdJ3iCeTQ()), new PointerInputChange(pointerInputEventData.m4067getIdJ3iCeTQ(), pointerInputEventData.getUptime(), pointerInputEventData.m4068getPositionF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.getPressure(), uptime, jMo4122screenToLocalMKHz9U, down, false, pointerInputEventData.m4071getTypeT8wyACA(), (List) pointerInputEventData.getHistorical(), pointerInputEventData.m4070getScrollDeltaF1C5BW0(), (AbstractC0419Di) null));
            if (pointerInputEventData.getDown()) {
                this.previousPointerInputData.put(PointerId.m4034boximpl(pointerInputEventData.m4067getIdJ3iCeTQ()), new PointerInputData(pointerInputEventData.getUptime(), pointerInputEventData.m4069getPositionOnScreenF1C5BW0(), pointerInputEventData.getDown(), pointerInputEventData.m4071getTypeT8wyACA(), null));
            } else {
                this.previousPointerInputData.remove(PointerId.m4034boximpl(pointerInputEventData.m4067getIdJ3iCeTQ()));
            }
        }
        return new InternalPointerEvent(linkedHashMap, pointerInputEvent);
    }
}
