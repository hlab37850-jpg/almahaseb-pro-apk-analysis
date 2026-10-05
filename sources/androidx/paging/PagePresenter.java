package androidx.paging;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.R5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PagePresenter<T> implements NullPaddedList<T> {
    public static final Companion Companion = new Companion(null);
    private static final PagePresenter<Object> INITIAL = new PagePresenter<>(PageEvent.Insert.Companion.getEMPTY_REFRESH_LOCAL());
    private final List<TransformablePage<T>> pages;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private int storageCount;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final <T> PagePresenter<T> initial$paging_common(PageEvent.Insert<T> insert) {
            if (insert != null) {
                return new PagePresenter<>(insert);
            }
            PagePresenter<T> pagePresenter = PagePresenter.INITIAL;
            AbstractC4492zt.f(pagePresenter, "null cannot be cast to non-null type androidx.paging.PagePresenter<T of androidx.paging.PagePresenter.Companion.initial>");
            return pagePresenter;
        }

        private Companion() {
        }
    }

    public interface ProcessPageEventCallback {
        void onChanged(int i, int i2);

        void onInserted(int i, int i2);

        void onRemoved(int i, int i2);

        void onStateUpdate(LoadStates loadStates, LoadStates loadStates2);

        void onStateUpdate(LoadType loadType, boolean z, LoadState loadState);
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PagePresenter(List<TransformablePage<T>> list, int i, int i2) {
        AbstractC4492zt.h(list, "pages");
        this.pages = AbstractC3240kc.F0(list);
        this.storageCount = fullCount(list);
        this.placeholdersBefore = i;
        this.placeholdersAfter = i2;
    }

    private final void checkIndex(int i) {
        if (i < 0 || i >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + getSize());
        }
    }

    private final void dropPages(PageEvent.Drop<T> drop, ProcessPageEventCallback processPageEventCallback) {
        int size = getSize();
        LoadType loadType = drop.getLoadType();
        LoadType loadType2 = LoadType.PREPEND;
        if (loadType != loadType2) {
            int placeholdersAfter = getPlaceholdersAfter();
            this.storageCount = getStorageCount() - dropPagesWithOffsets(new C1001Vs(drop.getMinPageOffset(), drop.getMaxPageOffset()));
            this.placeholdersAfter = drop.getPlaceholdersRemaining();
            int size2 = getSize() - size;
            if (size2 > 0) {
                processPageEventCallback.onInserted(size, size2);
            } else if (size2 < 0) {
                processPageEventCallback.onRemoved(size + size2, -size2);
            }
            int placeholdersRemaining = drop.getPlaceholdersRemaining() - (placeholdersAfter - (size2 < 0 ? Math.min(placeholdersAfter, -size2) : 0));
            if (placeholdersRemaining > 0) {
                processPageEventCallback.onChanged(getSize() - drop.getPlaceholdersRemaining(), placeholdersRemaining);
            }
            processPageEventCallback.onStateUpdate(LoadType.APPEND, false, LoadState.NotLoading.Companion.getIncomplete$paging_common());
            return;
        }
        int placeholdersBefore = getPlaceholdersBefore();
        this.storageCount = getStorageCount() - dropPagesWithOffsets(new C1001Vs(drop.getMinPageOffset(), drop.getMaxPageOffset()));
        this.placeholdersBefore = drop.getPlaceholdersRemaining();
        int size3 = getSize() - size;
        if (size3 > 0) {
            processPageEventCallback.onInserted(0, size3);
        } else if (size3 < 0) {
            processPageEventCallback.onRemoved(0, -size3);
        }
        int iMax = Math.max(0, placeholdersBefore + size3);
        int placeholdersRemaining2 = drop.getPlaceholdersRemaining() - iMax;
        if (placeholdersRemaining2 > 0) {
            processPageEventCallback.onChanged(iMax, placeholdersRemaining2);
        }
        processPageEventCallback.onStateUpdate(loadType2, false, LoadState.NotLoading.Companion.getIncomplete$paging_common());
    }

    private final int dropPagesWithOffsets(C1001Vs c1001Vs) {
        Iterator<TransformablePage<T>> it = this.pages.iterator();
        int size = 0;
        while (it.hasNext()) {
            TransformablePage<T> next = it.next();
            for (int i : next.getOriginalPageOffsets()) {
                if (c1001Vs.g(i)) {
                    size += next.getData().size();
                    it.remove();
                    break;
                }
            }
        }
        return size;
    }

    private final int fullCount(List<TransformablePage<T>> list) {
        Iterator<T> it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((TransformablePage) it.next()).getData().size();
        }
        return size;
    }

    private final int getOriginalPageOffsetFirst() {
        Integer numB0 = R5.b0(((TransformablePage) AbstractC3240kc.b0(this.pages)).getOriginalPageOffsets());
        AbstractC4492zt.e(numB0);
        return numB0.intValue();
    }

    private final int getOriginalPageOffsetLast() {
        Integer numZ = R5.Z(((TransformablePage) AbstractC3240kc.k0(this.pages)).getOriginalPageOffsets());
        AbstractC4492zt.e(numZ);
        return numZ.intValue();
    }

    private final void insertPage(PageEvent.Insert<T> insert, ProcessPageEventCallback processPageEventCallback) {
        int iFullCount = fullCount(insert.getPages());
        int size = getSize();
        int i = WhenMappings.$EnumSwitchMapping$0[insert.getLoadType().ordinal()];
        if (i == 1) {
            throw new IllegalStateException("Paging received a refresh event in the middle of an actively loading generation\nof PagingData. If you see this exception, it is most likely a bug in the library.\nPlease file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
        }
        if (i == 2) {
            int iMin = Math.min(getPlaceholdersBefore(), iFullCount);
            int placeholdersBefore = getPlaceholdersBefore() - iMin;
            int i2 = iFullCount - iMin;
            this.pages.addAll(0, insert.getPages());
            this.storageCount = getStorageCount() + iFullCount;
            this.placeholdersBefore = insert.getPlaceholdersBefore();
            processPageEventCallback.onChanged(placeholdersBefore, iMin);
            processPageEventCallback.onInserted(0, i2);
            int size2 = (getSize() - size) - i2;
            if (size2 > 0) {
                processPageEventCallback.onInserted(0, size2);
            } else if (size2 < 0) {
                processPageEventCallback.onRemoved(0, -size2);
            }
        } else if (i == 3) {
            int iMin2 = Math.min(getPlaceholdersAfter(), iFullCount);
            int placeholdersBefore2 = getPlaceholdersBefore() + getStorageCount();
            int i3 = iFullCount - iMin2;
            List<TransformablePage<T>> list = this.pages;
            list.addAll(list.size(), insert.getPages());
            this.storageCount = getStorageCount() + iFullCount;
            this.placeholdersAfter = insert.getPlaceholdersAfter();
            processPageEventCallback.onChanged(placeholdersBefore2, iMin2);
            processPageEventCallback.onInserted(placeholdersBefore2 + iMin2, i3);
            int size3 = (getSize() - size) - i3;
            if (size3 > 0) {
                processPageEventCallback.onInserted(getSize() - size3, size3);
            } else if (size3 < 0) {
                processPageEventCallback.onRemoved(getSize(), -size3);
            }
        }
        processPageEventCallback.onStateUpdate(insert.getSourceLoadStates(), insert.getMediatorLoadStates());
    }

    public final ViewportHint.Access accessHintForPresenterIndex(int i) {
        int i2 = 0;
        int placeholdersBefore = i - getPlaceholdersBefore();
        while (placeholdersBefore >= this.pages.get(i2).getData().size() && i2 < AbstractC1886cc.o(this.pages)) {
            placeholdersBefore -= this.pages.get(i2).getData().size();
            i2++;
        }
        return this.pages.get(i2).viewportHintFor(placeholdersBefore, i - getPlaceholdersBefore(), ((getSize() - i) - getPlaceholdersAfter()) - 1, getOriginalPageOffsetFirst(), getOriginalPageOffsetLast());
    }

    public final T get(int i) {
        checkIndex(i);
        int placeholdersBefore = i - getPlaceholdersBefore();
        if (placeholdersBefore < 0 || placeholdersBefore >= getStorageCount()) {
            return null;
        }
        return getFromStorage(placeholdersBefore);
    }

    @Override // androidx.paging.NullPaddedList
    public T getFromStorage(int i) {
        int size = this.pages.size();
        int i2 = 0;
        while (i2 < size) {
            int size2 = this.pages.get(i2).getData().size();
            if (size2 > i) {
                break;
            }
            i -= size2;
            i2++;
        }
        return this.pages.get(i2).getData().get(i);
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    @Override // androidx.paging.NullPaddedList
    public int getSize() {
        return getPlaceholdersBefore() + getStorageCount() + getPlaceholdersAfter();
    }

    @Override // androidx.paging.NullPaddedList
    public int getStorageCount() {
        return this.storageCount;
    }

    public final ViewportHint.Initial initializeHint() {
        int storageCount = getStorageCount() / 2;
        return new ViewportHint.Initial(storageCount, storageCount, getOriginalPageOffsetFirst(), getOriginalPageOffsetLast());
    }

    public final void processEvent(PageEvent<T> pageEvent, ProcessPageEventCallback processPageEventCallback) {
        AbstractC4492zt.h(pageEvent, "pageEvent");
        AbstractC4492zt.h(processPageEventCallback, "callback");
        if (pageEvent instanceof PageEvent.Insert) {
            insertPage((PageEvent.Insert) pageEvent, processPageEventCallback);
            return;
        }
        if (pageEvent instanceof PageEvent.Drop) {
            dropPages((PageEvent.Drop) pageEvent, processPageEventCallback);
        } else if (pageEvent instanceof PageEvent.LoadStateUpdate) {
            PageEvent.LoadStateUpdate loadStateUpdate = (PageEvent.LoadStateUpdate) pageEvent;
            processPageEventCallback.onStateUpdate(loadStateUpdate.getSource(), loadStateUpdate.getMediator());
        } else if (pageEvent instanceof PageEvent.StaticList) {
            throw new IllegalStateException("Paging received an event to display a static list, while still actively loading\nfrom an existing generation of PagingData. If you see this exception, it is most\nlikely a bug in the library. Please file a bug so we can fix it at:\nhttps://issuetracker.google.com/issues/new?component=413106");
        }
    }

    public final ItemSnapshotList<T> snapshot() {
        int placeholdersBefore = getPlaceholdersBefore();
        int placeholdersAfter = getPlaceholdersAfter();
        List<TransformablePage<T>> list = this.pages;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            AbstractC2371hc.D(arrayList, ((TransformablePage) it.next()).getData());
        }
        return new ItemSnapshotList<>(placeholdersBefore, placeholdersAfter, arrayList);
    }

    public String toString() {
        int storageCount = getStorageCount();
        ArrayList arrayList = new ArrayList(storageCount);
        for (int i = 0; i < storageCount; i++) {
            arrayList.add(getFromStorage(i));
        }
        return "[(" + getPlaceholdersBefore() + " placeholders), " + AbstractC3240kc.j0(arrayList, null, null, null, 0, null, null, 63, null) + ", (" + getPlaceholdersAfter() + " placeholders)]";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagePresenter(PageEvent.Insert<T> insert) {
        this(insert.getPages(), insert.getPlaceholdersBefore(), insert.getPlaceholdersAfter());
        AbstractC4492zt.h(insert, "insertEvent");
    }
}
