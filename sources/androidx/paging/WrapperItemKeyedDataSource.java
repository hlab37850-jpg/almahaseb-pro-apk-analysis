package androidx.paging;

import androidx.arch.core.util.Function;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class WrapperItemKeyedDataSource<K, A, B> extends ItemKeyedDataSource<K, B> {
    private final IdentityHashMap<B, K> keyMap;
    private final Function<List<A>, List<B>> listFunction;
    private final ItemKeyedDataSource<K, A> source;

    public WrapperItemKeyedDataSource(ItemKeyedDataSource<K, A> itemKeyedDataSource, Function<List<A>, List<B>> function) {
        AbstractC4492zt.h(itemKeyedDataSource, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(function, "listFunction");
        this.source = itemKeyedDataSource;
        this.listFunction = function;
        this.keyMap = new IdentityHashMap<>();
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(DataSource.InvalidatedCallback invalidatedCallback) {
        AbstractC4492zt.h(invalidatedCallback, "onInvalidatedCallback");
        this.source.addInvalidatedCallback(invalidatedCallback);
    }

    public final List<B> convertWithStashedKeys(List<? extends A> list) {
        AbstractC4492zt.h(list, DublinCoreProperties.SOURCE);
        List<B> listConvert$paging_common = DataSource.Companion.convert$paging_common(this.listFunction, list);
        synchronized (this.keyMap) {
            try {
                int size = listConvert$paging_common.size();
                for (int i = 0; i < size; i++) {
                    this.keyMap.put(listConvert$paging_common.get(i), this.source.getKey(list.get(i)));
                }
                FW fw = FW.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return listConvert$paging_common;
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public K getKey(B b) {
        K k;
        AbstractC4492zt.h(b, "item");
        synchronized (this.keyMap) {
            k = this.keyMap.get(b);
            AbstractC4492zt.e(k);
        }
        return k;
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.source.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.source.isInvalid();
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadAfter(ItemKeyedDataSource.LoadParams<K> loadParams, final ItemKeyedDataSource.LoadCallback<B> loadCallback) {
        AbstractC4492zt.h(loadParams, "params");
        AbstractC4492zt.h(loadCallback, "callback");
        this.source.loadAfter(loadParams, new ItemKeyedDataSource.LoadCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource.loadAfter.1
            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends A> list) {
                AbstractC4492zt.h(list, "data");
                loadCallback.onResult(this.convertWithStashedKeys(list));
            }
        });
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadBefore(ItemKeyedDataSource.LoadParams<K> loadParams, final ItemKeyedDataSource.LoadCallback<B> loadCallback) {
        AbstractC4492zt.h(loadParams, "params");
        AbstractC4492zt.h(loadCallback, "callback");
        this.source.loadBefore(loadParams, new ItemKeyedDataSource.LoadCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource.loadBefore.1
            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends A> list) {
                AbstractC4492zt.h(list, "data");
                loadCallback.onResult(this.convertWithStashedKeys(list));
            }
        });
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void loadInitial(ItemKeyedDataSource.LoadInitialParams<K> loadInitialParams, final ItemKeyedDataSource.LoadInitialCallback<B> loadInitialCallback) {
        AbstractC4492zt.h(loadInitialParams, "params");
        AbstractC4492zt.h(loadInitialCallback, "callback");
        this.source.loadInitial(loadInitialParams, new ItemKeyedDataSource.LoadInitialCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource.loadInitial.1
            @Override // androidx.paging.ItemKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends A> list, int i, int i2) {
                AbstractC4492zt.h(list, "data");
                loadInitialCallback.onResult(this.convertWithStashedKeys(list), i, i2);
            }

            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends A> list) {
                AbstractC4492zt.h(list, "data");
                loadInitialCallback.onResult(this.convertWithStashedKeys(list));
            }
        });
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback invalidatedCallback) {
        AbstractC4492zt.h(invalidatedCallback, "onInvalidatedCallback");
        this.source.removeInvalidatedCallback(invalidatedCallback);
    }
}
