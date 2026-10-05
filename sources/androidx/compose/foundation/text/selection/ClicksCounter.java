package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
final class ClicksCounter {
    private int clicks;
    private PointerInputChange prevClick;
    private final ViewConfiguration viewConfiguration;

    public ClicksCounter(ViewConfiguration viewConfiguration) {
        AbstractC4492zt.h(viewConfiguration, "viewConfiguration");
        this.viewConfiguration = viewConfiguration;
    }

    public final int getClicks() {
        return this.clicks;
    }

    public final PointerInputChange getPrevClick() {
        return this.prevClick;
    }

    public final boolean positionIsTolerable(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        AbstractC4492zt.h(pointerInputChange, "prevClick");
        AbstractC4492zt.h(pointerInputChange2, "newClick");
        return ((double) Offset.m2796getDistanceimpl(Offset.m2802minusMKHz9U(pointerInputChange2.m4054getPositionF1C5BW0(), pointerInputChange.m4054getPositionF1C5BW0()))) < 100.0d;
    }

    public final void setClicks(int i) {
        this.clicks = i;
    }

    public final void setPrevClick(PointerInputChange pointerInputChange) {
        this.prevClick = pointerInputChange;
    }

    public final boolean timeIsTolerable(PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        AbstractC4492zt.h(pointerInputChange, "prevClick");
        AbstractC4492zt.h(pointerInputChange2, "newClick");
        return pointerInputChange2.getUptimeMillis() - pointerInputChange.getUptimeMillis() < this.viewConfiguration.getDoubleTapTimeoutMillis();
    }

    public final void update(PointerEvent pointerEvent) {
        AbstractC4492zt.h(pointerEvent, NotificationCompat.CATEGORY_EVENT);
        PointerInputChange pointerInputChange = this.prevClick;
        PointerInputChange pointerInputChange2 = pointerEvent.getChanges().get(0);
        if (pointerInputChange != null && timeIsTolerable(pointerInputChange, pointerInputChange2) && positionIsTolerable(pointerInputChange, pointerInputChange2)) {
            this.clicks++;
        } else {
            this.clicks = 1;
        }
        this.prevClick = pointerInputChange2;
    }
}
