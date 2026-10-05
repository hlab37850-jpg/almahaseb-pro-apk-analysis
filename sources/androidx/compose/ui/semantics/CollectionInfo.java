package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class CollectionInfo {
    public static final int $stable = 0;
    private final int columnCount;
    private final int rowCount;

    public CollectionInfo(int i, int i2) {
        this.rowCount = i;
        this.columnCount = i2;
    }

    public final int getColumnCount() {
        return this.columnCount;
    }

    public final int getRowCount() {
        return this.rowCount;
    }
}
