package androidx.paging;

import androidx.annotation.RestrictTo;
import com.itextpdf.text.Annotation;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PagedStorage<T> extends AbstractList<T> implements LegacyPageFetcher.KeyProvider<Object>, NullPaddedList<T> {
    private boolean counted;
    private int lastLoadAroundLocalIndex;
    private final List<PagingSource.LoadResult.Page<?, T>> pages;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private int positionOffset;
    private int storageCount;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public interface Callback {
        void onInitialized(int i);

        void onPageAppended(int i, int i2, int i3);

        void onPagePrepended(int i, int i2, int i3);

        void onPagesRemoved(int i, int i2);

        void onPagesSwappedToPlaceholder(int i, int i2);
    }

    public PagedStorage() {
        this.pages = new ArrayList();
        this.counted = true;
    }

    public static /* synthetic */ void appendPage$paging_common$default(PagedStorage pagedStorage, PagingSource.LoadResult.Page page, Callback callback, int i, Object obj) {
        if ((i & 2) != 0) {
            callback = null;
        }
        pagedStorage.appendPage$paging_common(page, callback);
    }

    private final void init(int i, PagingSource.LoadResult.Page<?, T> page, int i2, int i3, boolean z) {
        this.placeholdersBefore = i;
        this.pages.clear();
        this.pages.add(page);
        this.placeholdersAfter = i2;
        this.positionOffset = i3;
        this.storageCount = page.getData().size();
        this.counted = z;
        this.lastLoadAroundLocalIndex = page.getData().size() / 2;
    }

    private final boolean needsTrim(int i, int i2, int i3) {
        return getStorageCount() > i && this.pages.size() > 2 && getStorageCount() - this.pages.get(i3).getData().size() >= i2;
    }

    public static /* synthetic */ void prependPage$paging_common$default(PagedStorage pagedStorage, PagingSource.LoadResult.Page page, Callback callback, int i, Object obj) {
        if ((i & 2) != 0) {
            callback = null;
        }
        pagedStorage.prependPage$paging_common(page, callback);
    }

    private final <V> V traversePages(int i, InterfaceC0526Fp interfaceC0526Fp) {
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
        return (V) interfaceC0526Fp.mo13invoke(this.pages.get(i2), Integer.valueOf(i));
    }

    public final void appendPage$paging_common(PagingSource.LoadResult.Page<?, T> page, Callback callback) {
        AbstractC4492zt.h(page, Annotation.PAGE);
        int size = page.getData().size();
        if (size == 0) {
            return;
        }
        this.pages.add(page);
        this.storageCount = getStorageCount() + size;
        int iMin = Math.min(getPlaceholdersAfter(), size);
        int i = size - iMin;
        if (iMin != 0) {
            this.placeholdersAfter = getPlaceholdersAfter() - iMin;
        }
        if (callback != null) {
            callback.onPageAppended((getPlaceholdersBefore() + getStorageCount()) - size, iMin, i);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i) {
        int placeholdersBefore = i - getPlaceholdersBefore();
        if (i >= 0 && i < size()) {
            if (placeholdersBefore < 0 || placeholdersBefore >= getStorageCount()) {
                return null;
            }
            return getFromStorage(placeholdersBefore);
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size());
    }

    public final T getFirstLoadedItem$paging_common() {
        return (T) AbstractC3240kc.b0(((PagingSource.LoadResult.Page) AbstractC3240kc.b0(this.pages)).getData());
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

    public final int getLastLoadAroundIndex() {
        return getPlaceholdersBefore() + this.lastLoadAroundLocalIndex;
    }

    public final T getLastLoadedItem$paging_common() {
        return (T) AbstractC3240kc.k0(((PagingSource.LoadResult.Page) AbstractC3240kc.k0(this.pages)).getData());
    }

    public final int getMiddleOfLoadedRange() {
        return getPlaceholdersBefore() + (getStorageCount() / 2);
    }

    @Override // androidx.paging.LegacyPageFetcher.KeyProvider
    public Object getNextKey() {
        if (!this.counted || getPlaceholdersAfter() > 0) {
            return ((PagingSource.LoadResult.Page) AbstractC3240kc.k0(this.pages)).getNextKey();
        }
        return null;
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public final int getPositionOffset() {
        return this.positionOffset;
    }

    @Override // androidx.paging.LegacyPageFetcher.KeyProvider
    public Object getPrevKey() {
        if (!this.counted || getPlaceholdersBefore() + this.positionOffset > 0) {
            return ((PagingSource.LoadResult.Page) AbstractC3240kc.b0(this.pages)).getPrevKey();
        }
        return null;
    }

    public final PagingState<?, T> getRefreshKeyInfo(PagedList.Config config) {
        AbstractC4492zt.h(config, "config");
        if (this.pages.isEmpty()) {
            return null;
        }
        List listC0 = AbstractC3240kc.C0(this.pages);
        AbstractC4492zt.f(listC0, "null cannot be cast to non-null type kotlin.collections.List<androidx.paging.PagingSource.LoadResult.Page<kotlin.Any, T of androidx.paging.PagedStorage>>");
        return new PagingState<>(listC0, Integer.valueOf(getLastLoadAroundIndex()), new PagingConfig(config.pageSize, config.prefetchDistance, config.enablePlaceholders, config.initialLoadSizeHint, config.maxSize, 0, 32, null), getPlaceholdersBefore());
    }

    @Override // androidx.paging.NullPaddedList
    public int getSize() {
        return getPlaceholdersBefore() + getStorageCount() + getPlaceholdersAfter();
    }

    @Override // androidx.paging.NullPaddedList
    public int getStorageCount() {
        return this.storageCount;
    }

    public final boolean needsTrimFromEnd(int i, int i2) {
        return needsTrim(i, i2, this.pages.size() - 1);
    }

    public final boolean needsTrimFromFront(int i, int i2) {
        return needsTrim(i, i2, 0);
    }

    public final void prependPage$paging_common(PagingSource.LoadResult.Page<?, T> page, Callback callback) {
        AbstractC4492zt.h(page, Annotation.PAGE);
        int size = page.getData().size();
        if (size == 0) {
            return;
        }
        this.pages.add(0, page);
        this.storageCount = getStorageCount() + size;
        int iMin = Math.min(getPlaceholdersBefore(), size);
        int i = size - iMin;
        if (iMin != 0) {
            this.placeholdersBefore = getPlaceholdersBefore() - iMin;
        }
        this.positionOffset -= i;
        if (callback != null) {
            callback.onPagePrepended(getPlaceholdersBefore(), iMin, i);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int i) {
        return (T) removeAt(i);
    }

    public /* bridge */ Object removeAt(int i) {
        return super.remove(i);
    }

    public final void setLastLoadAroundIndex(int i) {
        this.lastLoadAroundLocalIndex = AbstractC3871sJ.l(i - getPlaceholdersBefore(), 0, getStorageCount() - 1);
    }

    public final boolean shouldPreTrimNewPage(int i, int i2, int i3) {
        return getStorageCount() + i3 > i && this.pages.size() > 1 && getStorageCount() >= i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public final PagedStorage<T> snapshot() {
        return new PagedStorage<>(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "leading " + getPlaceholdersBefore() + ", storage " + getStorageCount() + ", trailing " + getPlaceholdersAfter() + ' ' + AbstractC3240kc.j0(this.pages, " ", null, null, 0, null, null, 62, null);
    }

    public final boolean trimFromEnd$paging_common(boolean z, int i, int i2, Callback callback) {
        AbstractC4492zt.h(callback, "callback");
        int i3 = 0;
        while (needsTrimFromEnd(i, i2)) {
            List<PagingSource.LoadResult.Page<?, T>> list = this.pages;
            int size = list.remove(list.size() - 1).getData().size();
            i3 += size;
            this.storageCount = getStorageCount() - size;
        }
        this.lastLoadAroundLocalIndex = AbstractC3871sJ.g(this.lastLoadAroundLocalIndex, getStorageCount() - 1);
        if (i3 > 0) {
            int placeholdersBefore = getPlaceholdersBefore() + getStorageCount();
            if (z) {
                this.placeholdersAfter = getPlaceholdersAfter() + i3;
                callback.onPagesSwappedToPlaceholder(placeholdersBefore, i3);
            } else {
                callback.onPagesRemoved(placeholdersBefore, i3);
            }
        }
        return i3 > 0;
    }

    public final boolean trimFromFront$paging_common(boolean z, int i, int i2, Callback callback) {
        AbstractC4492zt.h(callback, "callback");
        int i3 = 0;
        while (needsTrimFromFront(i, i2)) {
            int size = this.pages.remove(0).getData().size();
            i3 += size;
            this.storageCount = getStorageCount() - size;
        }
        this.lastLoadAroundLocalIndex = AbstractC3871sJ.d(this.lastLoadAroundLocalIndex - i3, 0);
        if (i3 > 0) {
            if (z) {
                int placeholdersBefore = getPlaceholdersBefore();
                this.placeholdersBefore = getPlaceholdersBefore() + i3;
                callback.onPagesSwappedToPlaceholder(placeholdersBefore, i3);
            } else {
                this.positionOffset += i3;
                callback.onPagesRemoved(getPlaceholdersBefore(), i3);
            }
        }
        return i3 > 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagedStorage(int i, PagingSource.LoadResult.Page<?, T> page, int i2) {
        this();
        AbstractC4492zt.h(page, Annotation.PAGE);
        init(i, page, i2, 0, true);
    }

    private PagedStorage(PagedStorage<T> pagedStorage) {
        ArrayList arrayList = new ArrayList();
        this.pages = arrayList;
        this.counted = true;
        arrayList.addAll(pagedStorage.pages);
        this.placeholdersBefore = pagedStorage.getPlaceholdersBefore();
        this.placeholdersAfter = pagedStorage.getPlaceholdersAfter();
        this.positionOffset = pagedStorage.positionOffset;
        this.counted = pagedStorage.counted;
        this.storageCount = pagedStorage.getStorageCount();
        this.lastLoadAroundLocalIndex = pagedStorage.lastLoadAroundLocalIndex;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void init(int i, PagingSource.LoadResult.Page<?, T> page, int i2, int i3, Callback callback, boolean z) {
        AbstractC4492zt.h(page, Annotation.PAGE);
        AbstractC4492zt.h(callback, "callback");
        init(i, page, i2, i3, z);
        callback.onInitialized(size());
    }
}
