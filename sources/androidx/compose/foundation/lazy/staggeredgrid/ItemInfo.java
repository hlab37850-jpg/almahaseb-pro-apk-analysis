package androidx.compose.foundation.lazy.staggeredgrid;

/* JADX INFO: loaded from: classes.dex */
final class ItemInfo {
    private int crossAxisOffset;
    private int lane;
    private int span;

    public ItemInfo(int i, int i2, int i3) {
        this.lane = i;
        this.span = i2;
        this.crossAxisOffset = i3;
    }

    public final int getCrossAxisOffset() {
        return this.crossAxisOffset;
    }

    public final int getLane() {
        return this.lane;
    }

    public final int getSpan() {
        return this.span;
    }

    public final void setCrossAxisOffset(int i) {
        this.crossAxisOffset = i;
    }

    public final void setLane(int i) {
        this.lane = i;
    }

    public final void setSpan(int i) {
        this.span = i;
    }
}
