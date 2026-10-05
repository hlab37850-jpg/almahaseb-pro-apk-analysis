package androidx.compose.runtime;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0756Mu;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class DataIterator implements Iterable<Object>, Iterator<Object>, InterfaceC0756Mu {
    private final int end;
    private final int group;
    private int index;
    private final int start;
    private final SlotTable table;

    public DataIterator(SlotTable slotTable, int i) {
        AbstractC4492zt.h(slotTable, "table");
        this.table = slotTable;
        this.group = i;
        int iDataAnchor = SlotTableKt.dataAnchor(slotTable.getGroups(), i);
        this.start = iDataAnchor;
        this.end = i + 1 < slotTable.getGroupsSize() ? SlotTableKt.dataAnchor(slotTable.getGroups(), i + 1) : slotTable.getSlotsSize();
        this.index = iDataAnchor;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getGroup() {
        return this.group;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getStart() {
        return this.start;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.end;
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return this;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.index;
        Object obj = (i < 0 || i >= this.table.getSlots().length) ? null : this.table.getSlots()[this.index];
        this.index++;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
