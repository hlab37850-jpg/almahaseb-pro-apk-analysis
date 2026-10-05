package androidx.paging;

import androidx.arch.core.util.Function;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC4492zt;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class WrapperPositionalDataSource<A, B> extends PositionalDataSource<B> {
    private final Function<List<A>, List<B>> listFunction;
    private final PositionalDataSource<A> source;

    public WrapperPositionalDataSource(PositionalDataSource<A> positionalDataSource, Function<List<A>, List<B>> function) {
        AbstractC4492zt.h(positionalDataSource, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(function, "listFunction");
        this.source = positionalDataSource;
        this.listFunction = function;
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(DataSource.InvalidatedCallback invalidatedCallback) {
        AbstractC4492zt.h(invalidatedCallback, "onInvalidatedCallback");
        this.source.addInvalidatedCallback(invalidatedCallback);
    }

    public final Function<List<A>, List<B>> getListFunction() {
        return this.listFunction;
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.source.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.source.isInvalid();
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadInitial(PositionalDataSource.LoadInitialParams loadInitialParams, final PositionalDataSource.LoadInitialCallback<B> loadInitialCallback) {
        AbstractC4492zt.h(loadInitialParams, "params");
        AbstractC4492zt.h(loadInitialCallback, "callback");
        this.source.loadInitial(loadInitialParams, new PositionalDataSource.LoadInitialCallback<A>() { // from class: androidx.paging.WrapperPositionalDataSource.loadInitial.1
            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public void onResult(List<? extends A> list, int i, int i2) {
                AbstractC4492zt.h(list, "data");
                loadInitialCallback.onResult(DataSource.Companion.convert$paging_common(this.getListFunction(), list), i, i2);
            }

            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public void onResult(List<? extends A> list, int i) {
                AbstractC4492zt.h(list, "data");
                loadInitialCallback.onResult(DataSource.Companion.convert$paging_common(this.getListFunction(), list), i);
            }
        });
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadRange(PositionalDataSource.LoadRangeParams loadRangeParams, final PositionalDataSource.LoadRangeCallback<B> loadRangeCallback) {
        AbstractC4492zt.h(loadRangeParams, "params");
        AbstractC4492zt.h(loadRangeCallback, "callback");
        this.source.loadRange(loadRangeParams, new PositionalDataSource.LoadRangeCallback<A>() { // from class: androidx.paging.WrapperPositionalDataSource.loadRange.1
            @Override // androidx.paging.PositionalDataSource.LoadRangeCallback
            public void onResult(List<? extends A> list) {
                AbstractC4492zt.h(list, "data");
                loadRangeCallback.onResult(DataSource.Companion.convert$paging_common(this.getListFunction(), list));
            }
        });
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback invalidatedCallback) {
        AbstractC4492zt.h(invalidatedCallback, "onInvalidatedCallback");
        this.source.removeInvalidatedCallback(invalidatedCallback);
    }
}
