package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0368Bj;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DataSource<Key, Value> {
    public static final Companion Companion = new Companion(null);
    private final InvalidateCallbackTracker<InvalidatedCallback> invalidateCallbackTracker;
    private final boolean isContiguous;
    private final boolean supportsPageDropping;
    private final KeyType type;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <A, B> List<B> convert$paging_common(Function<List<A>, List<B>> function, List<? extends A> list) {
            AbstractC4492zt.h(function, "function");
            AbstractC4492zt.h(list, DublinCoreProperties.SOURCE);
            List<B> listApply = function.apply(list);
            if (listApply.size() == list.size()) {
                AbstractC4492zt.g(listApply, "dest");
                return listApply;
            }
            throw new IllegalStateException("Invalid Function " + function + " changed return size. This is not supported.");
        }

        private Companion() {
        }
    }

    public static abstract class Factory<Key, Value> {
        public static /* synthetic */ InterfaceC3588op asPagingSourceFactory$default(Factory factory, AbstractC1040Xf abstractC1040Xf, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asPagingSourceFactory");
            }
            if ((i & 1) != 0) {
                abstractC1040Xf = C0368Bj.b();
            }
            return factory.asPagingSourceFactory(abstractC1040Xf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List map$lambda$1(Function function, List list) {
            AbstractC4492zt.h(function, "$function");
            AbstractC4492zt.g(list, "list");
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(function.apply(it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List map$lambda$2(InterfaceC3750qp interfaceC3750qp, List list) {
            AbstractC4492zt.h(interfaceC3750qp, "$function");
            AbstractC4492zt.g(list, "list");
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(interfaceC3750qp.invoke(it.next()));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List mapByPage$lambda$3(InterfaceC3750qp interfaceC3750qp, List list) {
            AbstractC4492zt.h(interfaceC3750qp, "$function");
            AbstractC4492zt.g(list, "it");
            return (List) interfaceC3750qp.invoke(list);
        }

        public final InterfaceC3588op asPagingSourceFactory() {
            return asPagingSourceFactory$default(this, null, 1, null);
        }

        public abstract DataSource<Key, Value> create();

        public <ToValue> Factory<Key, ToValue> map(final Function<Value, ToValue> function) {
            AbstractC4492zt.h(function, "function");
            return mapByPage(new Function() { // from class: Dh
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return DataSource.Factory.map$lambda$1(function, (List) obj);
                }
            });
        }

        public <ToValue> Factory<Key, ToValue> mapByPage(final Function<List<Value>, List<ToValue>> function) {
            AbstractC4492zt.h(function, "function");
            return new Factory<Key, ToValue>(this) { // from class: androidx.paging.DataSource$Factory$mapByPage$1
                final /* synthetic */ DataSource.Factory<Key, Value> this$0;

                {
                    this.this$0 = this;
                }

                @Override // androidx.paging.DataSource.Factory
                public DataSource<Key, ToValue> create() {
                    return this.this$0.create().mapByPage((Function) function);
                }
            };
        }

        public final InterfaceC3588op asPagingSourceFactory(AbstractC1040Xf abstractC1040Xf) {
            AbstractC4492zt.h(abstractC1040Xf, "fetchDispatcher");
            return new SuspendingPagingSourceFactory(abstractC1040Xf, new DataSource$Factory$asPagingSourceFactory$1(abstractC1040Xf, this));
        }

        public /* synthetic */ Factory map(final InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "function");
            return mapByPage(new Function() { // from class: Eh
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return DataSource.Factory.map$lambda$2(interfaceC3750qp, (List) obj);
                }
            });
        }

        public /* synthetic */ Factory mapByPage(final InterfaceC3750qp interfaceC3750qp) {
            AbstractC4492zt.h(interfaceC3750qp, "function");
            return mapByPage(new Function() { // from class: Fh
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return DataSource.Factory.mapByPage$lambda$3(interfaceC3750qp, (List) obj);
                }
            });
        }
    }

    public interface InvalidatedCallback {
        @AnyThread
        void onInvalidated();
    }

    public enum KeyType {
        POSITIONAL,
        PAGE_KEYED,
        ITEM_KEYED
    }

    public static final class Params<K> {
        private final int initialLoadSize;
        private final K key;
        private final int pageSize;
        private final boolean placeholdersEnabled;
        private final LoadType type;

        public Params(LoadType loadType, K k, int i, boolean z, int i2) {
            AbstractC4492zt.h(loadType, "type");
            this.type = loadType;
            this.key = k;
            this.initialLoadSize = i;
            this.placeholdersEnabled = z;
            this.pageSize = i2;
            if (loadType != LoadType.REFRESH && k == null) {
                throw new IllegalArgumentException("Key must be non-null for prepend/append");
            }
        }

        public final int getInitialLoadSize() {
            return this.initialLoadSize;
        }

        public final K getKey() {
            return this.key;
        }

        public final int getPageSize() {
            return this.pageSize;
        }

        public final boolean getPlaceholdersEnabled() {
            return this.placeholdersEnabled;
        }

        public final LoadType getType$paging_common() {
            return this.type;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.DataSource$map$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ Function<Value, ToValue> $function;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function<Value, ToValue> function) {
            super(1);
            this.$function = function;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // defpackage.InterfaceC3750qp
        public final List<ToValue> invoke(List<? extends Value> list) {
            AbstractC4492zt.h(list, "list");
            List<? extends Value> list2 = list;
            Function<Value, ToValue> function = this.$function;
            ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(function.apply((Value) it.next()));
            }
            return arrayList;
        }
    }

    public DataSource(KeyType keyType) {
        AbstractC4492zt.h(keyType, "type");
        this.type = keyType;
        this.invalidateCallbackTracker = new InvalidateCallbackTracker<>(DataSource$invalidateCallbackTracker$1.INSTANCE, new DataSource$invalidateCallbackTracker$2(this));
        this.isContiguous = true;
        this.supportsPageDropping = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object map$lambda$1(InterfaceC3750qp interfaceC3750qp, Object obj) {
        AbstractC4492zt.h(interfaceC3750qp, "$function");
        AbstractC4492zt.g(obj, "it");
        return interfaceC3750qp.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List mapByPage$lambda$0(InterfaceC3750qp interfaceC3750qp, List list) {
        AbstractC4492zt.h(interfaceC3750qp, "$function");
        AbstractC4492zt.g(list, "it");
        return (List) interfaceC3750qp.invoke(list);
    }

    @AnyThread
    public void addInvalidatedCallback(InvalidatedCallback invalidatedCallback) {
        AbstractC4492zt.h(invalidatedCallback, "onInvalidatedCallback");
        this.invalidateCallbackTracker.registerInvalidatedCallback$paging_common(invalidatedCallback);
    }

    @VisibleForTesting
    public final int getInvalidateCallbackCount$paging_common() {
        return this.invalidateCallbackTracker.callbackCount$paging_common();
    }

    public abstract Key getKeyInternal$paging_common(Value value);

    public boolean getSupportsPageDropping$paging_common() {
        return this.supportsPageDropping;
    }

    public final KeyType getType$paging_common() {
        return this.type;
    }

    @AnyThread
    public void invalidate() {
        this.invalidateCallbackTracker.invalidate$paging_common();
    }

    public boolean isContiguous$paging_common() {
        return this.isContiguous;
    }

    @WorkerThread
    public boolean isInvalid() {
        return this.invalidateCallbackTracker.getInvalid$paging_common();
    }

    public abstract Object load$paging_common(Params<Key> params, InterfaceC0793Of interfaceC0793Of);

    public <ToValue> DataSource<Key, ToValue> map(Function<Value, ToValue> function) {
        AbstractC4492zt.h(function, "function");
        return mapByPage(new AnonymousClass1(function));
    }

    public <ToValue> DataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        AbstractC4492zt.h(function, "function");
        return new WrapperDataSource(this, function);
    }

    @AnyThread
    public void removeInvalidatedCallback(InvalidatedCallback invalidatedCallback) {
        AbstractC4492zt.h(invalidatedCallback, "onInvalidatedCallback");
        this.invalidateCallbackTracker.unregisterInvalidatedCallback$paging_common(invalidatedCallback);
    }

    public /* synthetic */ DataSource map(final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "function");
        return map(new Function() { // from class: Bh
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return DataSource.map$lambda$1(interfaceC3750qp, obj);
            }
        });
    }

    public /* synthetic */ DataSource mapByPage(final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "function");
        return mapByPage(new Function() { // from class: Ch
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return DataSource.mapByPage$lambda$0(interfaceC3750qp, (List) obj);
            }
        });
    }

    public static final class BaseResult<Value> {
        public static final Companion Companion = new Companion(null);
        public final List<Value> data;
        private final int itemsAfter;
        private final int itemsBefore;
        private final Object nextKey;
        private final Object prevKey;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            public final <ToValue, Value> BaseResult<Value> convert$paging_common(BaseResult<ToValue> baseResult, Function<List<ToValue>, List<Value>> function) {
                AbstractC4492zt.h(baseResult, "result");
                AbstractC4492zt.h(function, "function");
                return new BaseResult<>(DataSource.Companion.convert$paging_common(function, baseResult.data), baseResult.getPrevKey(), baseResult.getNextKey(), baseResult.getItemsBefore(), baseResult.getItemsAfter());
            }

            public final <T> BaseResult<T> empty$paging_common() {
                return new BaseResult<>(AbstractC1886cc.m(), null, null, 0, 0);
            }

            private Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BaseResult(List<? extends Value> list, Object obj, Object obj2, int i, int i2) {
            AbstractC4492zt.h(list, "data");
            this.data = list;
            this.prevKey = obj;
            this.nextKey = obj2;
            this.itemsBefore = i;
            this.itemsAfter = i2;
            if (i < 0 && i != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Position must be non-negative");
            }
            if (list.isEmpty() && (i > 0 || i2 > 0)) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            }
            if (i2 < 0 && i2 != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BaseResult)) {
                return false;
            }
            BaseResult baseResult = (BaseResult) obj;
            return AbstractC4492zt.d(this.data, baseResult.data) && AbstractC4492zt.d(this.prevKey, baseResult.prevKey) && AbstractC4492zt.d(this.nextKey, baseResult.nextKey) && this.itemsBefore == baseResult.itemsBefore && this.itemsAfter == baseResult.itemsAfter;
        }

        public final int getItemsAfter() {
            return this.itemsAfter;
        }

        public final int getItemsBefore() {
            return this.itemsBefore;
        }

        public final Object getNextKey() {
            return this.nextKey;
        }

        public final Object getPrevKey() {
            return this.prevKey;
        }

        public final void validateForInitialTiling$paging_common(int i) {
            int i2;
            if (this.itemsBefore == Integer.MIN_VALUE || (i2 = this.itemsAfter) == Integer.MIN_VALUE) {
                throw new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
            }
            if (i2 <= 0 || this.data.size() % i == 0) {
                if (this.itemsBefore % i == 0) {
                    return;
                }
                throw new IllegalArgumentException("Initial load must be pageSize aligned.Position = " + this.itemsBefore + ", pageSize = " + i);
            }
            throw new IllegalArgumentException("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize " + this.data.size() + ", position " + this.itemsBefore + ", totalCount " + (this.itemsBefore + this.data.size() + this.itemsAfter) + ", pageSize " + i);
        }

        public /* synthetic */ BaseResult(List list, Object obj, Object obj2, int i, int i2, int i3, AbstractC0419Di abstractC0419Di) {
            this(list, obj, obj2, (i3 & 8) != 0 ? Integer.MIN_VALUE : i, (i3 & 16) != 0 ? Integer.MIN_VALUE : i2);
        }
    }
}
