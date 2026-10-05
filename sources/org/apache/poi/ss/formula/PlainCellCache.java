package org.apache.poi.ss.formula;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class PlainCellCache {
    private Map<Loc, PlainValueCellCacheEntry> _plainValueEntriesByLoc = new HashMap();

    public void clear() {
        this._plainValueEntriesByLoc.clear();
    }

    public PlainValueCellCacheEntry get(Loc loc) {
        return this._plainValueEntriesByLoc.get(loc);
    }

    public void put(Loc loc, PlainValueCellCacheEntry plainValueCellCacheEntry) {
        this._plainValueEntriesByLoc.put(loc, plainValueCellCacheEntry);
    }

    public void remove(Loc loc) {
        this._plainValueEntriesByLoc.remove(loc);
    }

    public static final class Loc {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final int _bookSheetColumn;
        private final int _rowIndex;

        public Loc(int i, int i2, int i3, int i4) {
            this._bookSheetColumn = toBookSheetColumn(i, i2, i4);
            this._rowIndex = i3;
        }

        public static int toBookSheetColumn(int i, int i2, int i3) {
            return ((i & 255) << 24) + ((i2 & 255) << 16) + (65535 & i3);
        }

        public boolean equals(Object obj) {
            Loc loc = (Loc) obj;
            return this._bookSheetColumn == loc._bookSheetColumn && this._rowIndex == loc._rowIndex;
        }

        public int getColumnIndex() {
            return this._bookSheetColumn & 65535;
        }

        public int getRowIndex() {
            return this._rowIndex;
        }

        public int hashCode() {
            return this._bookSheetColumn + (this._rowIndex * 17);
        }

        public Loc(int i, int i2) {
            this._bookSheetColumn = i;
            this._rowIndex = i2;
        }
    }
}
