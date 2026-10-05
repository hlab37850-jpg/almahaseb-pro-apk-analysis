package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@InternalComposeApi
public final class MovableContentState {
    public static final int $stable = 8;
    private final SlotTable slotTable;

    public MovableContentState(SlotTable slotTable) {
        AbstractC4492zt.h(slotTable, "slotTable");
        this.slotTable = slotTable;
    }

    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }
}
