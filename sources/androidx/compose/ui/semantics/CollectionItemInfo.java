package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class CollectionItemInfo {
    public static final int $stable = 0;
    private final int columnIndex;
    private final int columnSpan;
    private final int rowIndex;
    private final int rowSpan;

    public CollectionItemInfo(int i, int i2, int i3, int i4) {
        this.rowIndex = i;
        this.rowSpan = i2;
        this.columnIndex = i3;
        this.columnSpan = i4;
    }

    public final int getColumnIndex() {
        return this.columnIndex;
    }

    public final int getColumnSpan() {
        return this.columnSpan;
    }

    public final int getRowIndex() {
        return this.rowIndex;
    }

    public final int getRowSpan() {
        return this.rowSpan;
    }
}
