package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class AndroidConfig implements ScrollConfig {
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    private AndroidConfig() {
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    /* JADX INFO: renamed from: calculateMouseWheelScroll-8xgXZGE, reason: not valid java name */
    public long mo254calculateMouseWheelScroll8xgXZGE(Density density, PointerEvent pointerEvent, long j) {
        AbstractC4492zt.h(density, "$this$calculateMouseWheelScroll");
        AbstractC4492zt.h(pointerEvent, NotificationCompat.CATEGORY_EVENT);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        Offset offsetM2787boximpl = Offset.m2787boximpl(Offset.Companion.m2814getZeroF1C5BW0());
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            offsetM2787boximpl = Offset.m2787boximpl(Offset.m2803plusMKHz9U(offsetM2787boximpl.m2808unboximpl(), changes.get(i).m4056getScrollDeltaF1C5BW0()));
        }
        return Offset.m2805timestuRUvjQ(offsetM2787boximpl.m2808unboximpl(), -density.mo333toPx0680j_4(Dp.m5160constructorimpl(64)));
    }
}
