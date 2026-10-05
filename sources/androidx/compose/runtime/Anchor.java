package androidx.compose.runtime;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class Anchor {
    private int location;

    public Anchor(int i) {
        this.location = i;
    }

    public final int getLocation$runtime_release() {
        return this.location;
    }

    public final boolean getValid() {
        return this.location != Integer.MIN_VALUE;
    }

    public final void setLocation$runtime_release(int i) {
        this.location = i;
    }

    public final int toIndexFor(SlotTable slotTable) {
        AbstractC4492zt.h(slotTable, "slots");
        return slotTable.anchorIndex(this);
    }

    public final int toIndexFor(SlotWriter slotWriter) {
        AbstractC4492zt.h(slotWriter, "writer");
        return slotWriter.anchorIndex(this);
    }
}
