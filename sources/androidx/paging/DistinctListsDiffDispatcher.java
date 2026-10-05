package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class DistinctListsDiffDispatcher {
    public static final DistinctListsDiffDispatcher INSTANCE = new DistinctListsDiffDispatcher();

    private DistinctListsDiffDispatcher() {
    }

    private final void dispatchChange(ListUpdateCallback listUpdateCallback, int i, int i2, int i3, int i4, Object obj) {
        int i5 = i - i3;
        if (i5 > 0) {
            listUpdateCallback.onChanged(i3, i5, obj);
        }
        int i6 = i4 - i2;
        if (i6 > 0) {
            listUpdateCallback.onChanged(i2, i6, obj);
        }
    }

    public final <T> void dispatchDiff(ListUpdateCallback listUpdateCallback, NullPaddedList<T> nullPaddedList, NullPaddedList<T> nullPaddedList2) {
        AbstractC4492zt.h(listUpdateCallback, "callback");
        AbstractC4492zt.h(nullPaddedList, "oldList");
        AbstractC4492zt.h(nullPaddedList2, "newList");
        int iMax = Math.max(nullPaddedList.getPlaceholdersBefore(), nullPaddedList2.getPlaceholdersBefore());
        int iMin = Math.min(nullPaddedList.getPlaceholdersBefore() + nullPaddedList.getStorageCount(), nullPaddedList2.getPlaceholdersBefore() + nullPaddedList2.getStorageCount());
        int i = iMin - iMax;
        if (i > 0) {
            listUpdateCallback.onRemoved(iMax, i);
            listUpdateCallback.onInserted(iMax, i);
        }
        int iMin2 = Math.min(iMax, iMin);
        int iMax2 = Math.max(iMax, iMin);
        dispatchChange(listUpdateCallback, iMin2, iMax2, AbstractC3871sJ.g(nullPaddedList.getPlaceholdersBefore(), nullPaddedList2.getSize()), AbstractC3871sJ.g(nullPaddedList.getPlaceholdersBefore() + nullPaddedList.getStorageCount(), nullPaddedList2.getSize()), DiffingChangePayload.ITEM_TO_PLACEHOLDER);
        dispatchChange(listUpdateCallback, iMin2, iMax2, AbstractC3871sJ.g(nullPaddedList2.getPlaceholdersBefore(), nullPaddedList.getSize()), AbstractC3871sJ.g(nullPaddedList2.getPlaceholdersBefore() + nullPaddedList2.getStorageCount(), nullPaddedList.getSize()), DiffingChangePayload.PLACEHOLDER_TO_ITEM);
        int size = nullPaddedList2.getSize() - nullPaddedList.getSize();
        if (size > 0) {
            listUpdateCallback.onInserted(nullPaddedList.getSize(), size);
        } else if (size < 0) {
            listUpdateCallback.onRemoved(nullPaddedList.getSize() + size, -size);
        }
    }
}
