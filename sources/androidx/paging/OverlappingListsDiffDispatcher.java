package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class OverlappingListsDiffDispatcher {
    public static final OverlappingListsDiffDispatcher INSTANCE = new OverlappingListsDiffDispatcher();

    public static final class PlaceholderUsingUpdateCallback<T> implements ListUpdateCallback {
        public static final Companion Companion = new Companion(null);
        private static final int UNUSED = 1;
        private static final int USED_FOR_ADDITION = 3;
        private static final int USED_FOR_REMOVAL = 2;
        private final ListUpdateCallback callback;
        private final NullPaddedList<T> newList;
        private final NullPaddedList<T> oldList;
        private int placeholdersAfter;
        private int placeholdersAfterState;
        private int placeholdersBefore;
        private int placeholdersBeforeState;
        private int storageCount;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            private Companion() {
            }
        }

        public PlaceholderUsingUpdateCallback(NullPaddedList<T> nullPaddedList, NullPaddedList<T> nullPaddedList2, ListUpdateCallback listUpdateCallback) {
            AbstractC4492zt.h(nullPaddedList, "oldList");
            AbstractC4492zt.h(nullPaddedList2, "newList");
            AbstractC4492zt.h(listUpdateCallback, "callback");
            this.oldList = nullPaddedList;
            this.newList = nullPaddedList2;
            this.callback = listUpdateCallback;
            this.placeholdersBefore = nullPaddedList.getPlaceholdersBefore();
            this.placeholdersAfter = nullPaddedList.getPlaceholdersAfter();
            this.storageCount = nullPaddedList.getStorageCount();
            this.placeholdersBeforeState = 1;
            this.placeholdersAfterState = 1;
        }

        private final boolean dispatchInsertAsPlaceholderAfter(int i, int i2) {
            if (i < this.storageCount || this.placeholdersAfterState == 2) {
                return false;
            }
            int iMin = Math.min(i2, this.placeholdersAfter);
            if (iMin > 0) {
                this.placeholdersAfterState = 3;
                this.callback.onChanged(this.placeholdersBefore + i, iMin, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.placeholdersAfter -= iMin;
            }
            int i3 = i2 - iMin;
            if (i3 <= 0) {
                return true;
            }
            this.callback.onInserted(i + iMin + this.placeholdersBefore, i3);
            return true;
        }

        private final boolean dispatchInsertAsPlaceholderBefore(int i, int i2) {
            if (i > 0 || this.placeholdersBeforeState == 2) {
                return false;
            }
            int iMin = Math.min(i2, this.placeholdersBefore);
            if (iMin > 0) {
                this.placeholdersBeforeState = 3;
                this.callback.onChanged((0 - iMin) + this.placeholdersBefore, iMin, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                this.placeholdersBefore -= iMin;
            }
            int i3 = i2 - iMin;
            if (i3 <= 0) {
                return true;
            }
            this.callback.onInserted(this.placeholdersBefore, i3);
            return true;
        }

        private final boolean dispatchRemovalAsPlaceholdersAfter(int i, int i2) {
            if (i + i2 < this.storageCount || this.placeholdersAfterState == 3) {
                return false;
            }
            int iD = AbstractC3871sJ.d(Math.min(this.newList.getPlaceholdersAfter() - this.placeholdersAfter, i2), 0);
            int i3 = i2 - iD;
            if (iD > 0) {
                this.placeholdersAfterState = 2;
                this.callback.onChanged(this.placeholdersBefore + i, iD, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                this.placeholdersAfter += iD;
            }
            if (i3 <= 0) {
                return true;
            }
            this.callback.onRemoved(i + iD + this.placeholdersBefore, i3);
            return true;
        }

        private final boolean dispatchRemovalAsPlaceholdersBefore(int i, int i2) {
            if (i > 0 || this.placeholdersBeforeState == 3) {
                return false;
            }
            int iD = AbstractC3871sJ.d(Math.min(this.newList.getPlaceholdersBefore() - this.placeholdersBefore, i2), 0);
            int i3 = i2 - iD;
            if (i3 > 0) {
                this.callback.onRemoved(this.placeholdersBefore, i3);
            }
            if (iD <= 0) {
                return true;
            }
            this.placeholdersBeforeState = 2;
            this.callback.onChanged(this.placeholdersBefore, iD, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
            this.placeholdersBefore += iD;
            return true;
        }

        private final void fixLeadingPlaceholders() {
            int iMin = Math.min(this.oldList.getPlaceholdersBefore(), this.placeholdersBefore);
            int placeholdersBefore = this.newList.getPlaceholdersBefore() - this.placeholdersBefore;
            if (placeholdersBefore > 0) {
                if (iMin > 0) {
                    this.callback.onChanged(0, iMin, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
                this.callback.onInserted(0, placeholdersBefore);
            } else if (placeholdersBefore < 0) {
                this.callback.onRemoved(0, -placeholdersBefore);
                int i = iMin + placeholdersBefore;
                if (i > 0) {
                    this.callback.onChanged(0, i, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
            }
            this.placeholdersBefore = this.newList.getPlaceholdersBefore();
        }

        private final void fixTrailingPlaceholders() {
            int iMin = Math.min(this.oldList.getPlaceholdersAfter(), this.placeholdersAfter);
            int placeholdersAfter = this.newList.getPlaceholdersAfter();
            int i = this.placeholdersAfter;
            int i2 = placeholdersAfter - i;
            int i3 = this.placeholdersBefore + this.storageCount + i;
            int i4 = i3 - iMin;
            boolean z = i4 != this.oldList.getSize() - iMin;
            if (i2 > 0) {
                this.callback.onInserted(i3, i2);
            } else if (i2 < 0) {
                this.callback.onRemoved(i3 + i2, -i2);
                iMin += i2;
            }
            if (iMin > 0 && z) {
                this.callback.onChanged(i4, iMin, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            }
            this.placeholdersAfter = this.newList.getPlaceholdersAfter();
        }

        private final int offsetForDispatch(int i) {
            return i + this.placeholdersBefore;
        }

        public final void fixPlaceholders() {
            fixLeadingPlaceholders();
            fixTrailingPlaceholders();
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            this.callback.onChanged(i + this.placeholdersBefore, i2, obj);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i2) {
            if (!dispatchInsertAsPlaceholderAfter(i, i2) && !dispatchInsertAsPlaceholderBefore(i, i2)) {
                this.callback.onInserted(i + this.placeholdersBefore, i2);
            }
            this.storageCount += i2;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i2) {
            ListUpdateCallback listUpdateCallback = this.callback;
            int i3 = this.placeholdersBefore;
            listUpdateCallback.onMoved(i + i3, i2 + i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            if (!dispatchRemovalAsPlaceholdersAfter(i, i2) && !dispatchRemovalAsPlaceholdersBefore(i, i2)) {
                this.callback.onRemoved(i + this.placeholdersBefore, i2);
            }
            this.storageCount -= i2;
        }
    }

    private OverlappingListsDiffDispatcher() {
    }

    public final <T> void dispatchDiff(NullPaddedList<T> nullPaddedList, NullPaddedList<T> nullPaddedList2, ListUpdateCallback listUpdateCallback, NullPaddedDiffResult nullPaddedDiffResult) {
        AbstractC4492zt.h(nullPaddedList, "oldList");
        AbstractC4492zt.h(nullPaddedList2, "newList");
        AbstractC4492zt.h(listUpdateCallback, "callback");
        AbstractC4492zt.h(nullPaddedDiffResult, "diffResult");
        PlaceholderUsingUpdateCallback placeholderUsingUpdateCallback = new PlaceholderUsingUpdateCallback(nullPaddedList, nullPaddedList2, listUpdateCallback);
        nullPaddedDiffResult.getDiff().dispatchUpdatesTo(placeholderUsingUpdateCallback);
        placeholderUsingUpdateCallback.fixPlaceholders();
    }
}
