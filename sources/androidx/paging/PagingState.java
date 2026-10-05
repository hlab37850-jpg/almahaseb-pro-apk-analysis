package androidx.paging;

import androidx.annotation.IntRange;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingState<Key, Value> {
    private final Integer anchorPosition;
    private final PagingConfig config;
    private final int leadingPlaceholderCount;
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;

    public PagingState(List<PagingSource.LoadResult.Page<Key, Value>> list, Integer num, PagingConfig pagingConfig, @IntRange(from = 0) int i) {
        AbstractC4492zt.h(list, "pages");
        AbstractC4492zt.h(pagingConfig, "config");
        this.pages = list;
        this.anchorPosition = num;
        this.config = pagingConfig;
        this.leadingPlaceholderCount = i;
    }

    public final <T> T anchorPositionToPagedIndices$paging_common(int i, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        int size = i - this.leadingPlaceholderCount;
        int i2 = 0;
        while (i2 < AbstractC1886cc.o(getPages()) && size > AbstractC1886cc.o(getPages().get(i2).getData())) {
            size -= getPages().get(i2).getData().size();
            i2++;
        }
        return (T) interfaceC0526Fp.mo13invoke(Integer.valueOf(i2), Integer.valueOf(size));
    }

    public final Value closestItemToPosition(int i) {
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                int size = i - this.leadingPlaceholderCount;
                int i2 = 0;
                while (i2 < AbstractC1886cc.o(getPages()) && size > AbstractC1886cc.o(getPages().get(i2).getData())) {
                    size -= getPages().get(i2).getData().size();
                    i2++;
                }
                Iterator<T> it2 = this.pages.iterator();
                while (it2.hasNext()) {
                    PagingSource.LoadResult.Page page = (PagingSource.LoadResult.Page) it2.next();
                    if (!page.getData().isEmpty()) {
                        List<PagingSource.LoadResult.Page<Key, Value>> list2 = this.pages;
                        ListIterator<PagingSource.LoadResult.Page<Key, Value>> listIterator = list2.listIterator(list2.size());
                        while (listIterator.hasPrevious()) {
                            PagingSource.LoadResult.Page<Key, Value> pagePrevious = listIterator.previous();
                            if (!pagePrevious.getData().isEmpty()) {
                                if (size < 0) {
                                    return (Value) AbstractC3240kc.b0(page.getData());
                                }
                                return (i2 != AbstractC1886cc.o(this.pages) || size <= AbstractC1886cc.o(((PagingSource.LoadResult.Page) AbstractC3240kc.k0(this.pages)).getData())) ? this.pages.get(i2).getData().get(size) : (Value) AbstractC3240kc.k0(pagePrevious.getData());
                            }
                        }
                        throw new NoSuchElementException("List contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        return null;
    }

    public final PagingSource.LoadResult.Page<Key, Value> closestPageToPosition(int i) {
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                int size = i - this.leadingPlaceholderCount;
                int i2 = 0;
                while (i2 < AbstractC1886cc.o(getPages()) && size > AbstractC1886cc.o(getPages().get(i2).getData())) {
                    size -= getPages().get(i2).getData().size();
                    i2++;
                }
                return size < 0 ? (PagingSource.LoadResult.Page) AbstractC3240kc.b0(this.pages) : this.pages.get(i2);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PagingState) {
            PagingState pagingState = (PagingState) obj;
            if (AbstractC4492zt.d(this.pages, pagingState.pages) && AbstractC4492zt.d(this.anchorPosition, pagingState.anchorPosition) && AbstractC4492zt.d(this.config, pagingState.config) && this.leadingPlaceholderCount == pagingState.leadingPlaceholderCount) {
                return true;
            }
        }
        return false;
    }

    public final Value firstItemOrNull() {
        Object next;
        List<Value> data;
        Iterator<T> it = this.pages.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((PagingSource.LoadResult.Page) next).getData().isEmpty());
        PagingSource.LoadResult.Page page = (PagingSource.LoadResult.Page) next;
        if (page == null || (data = page.getData()) == null) {
            return null;
        }
        return (Value) AbstractC3240kc.d0(data);
    }

    public final Integer getAnchorPosition() {
        return this.anchorPosition;
    }

    public final PagingConfig getConfig() {
        return this.config;
    }

    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages() {
        return this.pages;
    }

    public int hashCode() {
        int iHashCode = this.pages.hashCode();
        Integer num = this.anchorPosition;
        return iHashCode + (num != null ? num.hashCode() : 0) + this.config.hashCode() + this.leadingPlaceholderCount;
    }

    public final boolean isEmpty() {
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final Value lastItemOrNull() {
        PagingSource.LoadResult.Page<Key, Value> pagePrevious;
        List<Value> data;
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        ListIterator<PagingSource.LoadResult.Page<Key, Value>> listIterator = list.listIterator(list.size());
        do {
            if (!listIterator.hasPrevious()) {
                pagePrevious = null;
                break;
            }
            pagePrevious = listIterator.previous();
        } while (pagePrevious.getData().isEmpty());
        PagingSource.LoadResult.Page<Key, Value> page = pagePrevious;
        if (page == null || (data = page.getData()) == null) {
            return null;
        }
        return (Value) AbstractC3240kc.l0(data);
    }

    public String toString() {
        return "PagingState(pages=" + this.pages + ", anchorPosition=" + this.anchorPosition + ", config=" + this.config + ", leadingPlaceholderCount=" + this.leadingPlaceholderCount + ')';
    }
}
