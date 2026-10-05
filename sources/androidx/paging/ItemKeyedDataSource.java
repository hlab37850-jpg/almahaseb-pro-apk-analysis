package androidx.paging;

import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.paging.ItemKeyedDataSource;
import defpackage.AD;
import defpackage.AbstractC0352At;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3416mi;
import defpackage.AbstractC4492zt;
import defpackage.C4374ya;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4293xa;
import defpackage.KL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ItemKeyedDataSource<Key, Value> extends DataSource<Key, Value> {

    public static abstract class LoadCallback<Value> {
        public abstract void onResult(List<? extends Value> list);
    }

    public static abstract class LoadInitialCallback<Value> extends LoadCallback<Value> {
        public abstract void onResult(List<? extends Value> list, int i, int i2);
    }

    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final Key requestedInitialKey;
        public final int requestedLoadSize;

        public LoadInitialParams(Key key, int i, boolean z) {
            this.requestedInitialKey = key;
            this.requestedLoadSize = i;
            this.placeholdersEnabled = z;
        }
    }

    public static class LoadParams<Key> {
        public final Key key;
        public final int requestedLoadSize;

        public LoadParams(Key key, int i) {
            AbstractC4492zt.h(key, "key");
            this.key = key;
            this.requestedLoadSize = i;
        }
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

    public ItemKeyedDataSource() {
        super(DataSource.KeyType.ITEM_KEYED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnonymousClass1 asCallback(final InterfaceC4293xa interfaceC4293xa) {
        return new LoadCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource.asCallback.1
            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends Value> list) {
                AbstractC4492zt.h(list, "data");
                InterfaceC4293xa interfaceC4293xa2 = interfaceC4293xa;
                KL.a aVar = KL.a;
                interfaceC4293xa2.resumeWith(KL.a(new DataSource.BaseResult(list, this.getPrevKey$paging_common(list), this.getNextKey$paging_common(list), 0, 0, 24, null)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List map$lambda$7(Function function, List list) {
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
    public static final List map$lambda$8(InterfaceC3750qp interfaceC3750qp, List list) {
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
    public static final List mapByPage$lambda$5(InterfaceC3750qp interfaceC3750qp, List list) {
        AbstractC4492zt.h(interfaceC3750qp, "$function");
        AbstractC4492zt.g(list, "it");
        return (List) interfaceC3750qp.invoke(list);
    }

    public abstract Key getKey(Value value);

    @Override // androidx.paging.DataSource
    public Key getKeyInternal$paging_common(Value value) {
        AbstractC4492zt.h(value, "item");
        return getKey(value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Key getNextKey$paging_common(List<? extends Value> list) {
        AbstractC4492zt.h(list, "<this>");
        Object objL0 = AbstractC3240kc.l0(list);
        if (objL0 != null) {
            return (Key) getKey(objL0);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Key getPrevKey$paging_common(List<? extends Value> list) {
        AbstractC4492zt.h(list, "<this>");
        Object objD0 = AbstractC3240kc.d0(list);
        if (objD0 != null) {
            return (Key) getKey(objD0);
        }
        return null;
    }

    @Override // androidx.paging.DataSource
    public final Object load$paging_common(DataSource.Params<Key> params, InterfaceC0793Of interfaceC0793Of) {
        int i = WhenMappings.$EnumSwitchMapping$0[params.getType$paging_common().ordinal()];
        if (i == 1) {
            return loadInitial$paging_common(new LoadInitialParams<>(params.getKey(), params.getInitialLoadSize(), params.getPlaceholdersEnabled()), interfaceC0793Of);
        }
        if (i == 2) {
            Key key = params.getKey();
            AbstractC4492zt.e(key);
            return loadBefore$paging_common(new LoadParams<>(key, params.getPageSize()), interfaceC0793Of);
        }
        if (i != 3) {
            throw new AD();
        }
        Key key2 = params.getKey();
        AbstractC4492zt.e(key2);
        return loadAfter$paging_common(new LoadParams<>(key2, params.getPageSize()), interfaceC0793Of);
    }

    public abstract void loadAfter(LoadParams<Key> loadParams, LoadCallback<Value> loadCallback);

    @VisibleForTesting
    public final Object loadAfter$paging_common(LoadParams<Key> loadParams, InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        loadAfter(loadParams, asCallback(c4374ya));
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    public abstract void loadBefore(LoadParams<Key> loadParams, LoadCallback<Value> loadCallback);

    @VisibleForTesting
    public final Object loadBefore$paging_common(LoadParams<Key> loadParams, InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        loadBefore(loadParams, asCallback(c4374ya));
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    public abstract void loadInitial(LoadInitialParams<Key> loadInitialParams, LoadInitialCallback<Value> loadInitialCallback);

    @VisibleForTesting
    public final Object loadInitial$paging_common(LoadInitialParams<Key> loadInitialParams, InterfaceC0793Of interfaceC0793Of) {
        final C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        loadInitial(loadInitialParams, new LoadInitialCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource$loadInitial$2$1
            @Override // androidx.paging.ItemKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends Value> list, int i, int i2) {
                AbstractC4492zt.h(list, "data");
                InterfaceC4293xa interfaceC4293xa = c4374ya;
                KL.a aVar = KL.a;
                interfaceC4293xa.resumeWith(KL.a(new DataSource.BaseResult(list, this.getPrevKey$paging_common(list), this.getNextKey$paging_common(list), i, (i2 - list.size()) - i)));
            }

            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends Value> list) {
                AbstractC4492zt.h(list, "data");
                InterfaceC4293xa interfaceC4293xa = c4374ya;
                KL.a aVar = KL.a;
                interfaceC4293xa.resumeWith(KL.a(new DataSource.BaseResult(list, this.getPrevKey$paging_common(list), this.getNextKey$paging_common(list), 0, 0, 24, null)));
            }
        });
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> map(final Function<Value, ToValue> function) {
        AbstractC4492zt.h(function, "function");
        return mapByPage((Function) new Function() { // from class: Mt
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ItemKeyedDataSource.map$lambda$7(function, (List) obj);
            }
        });
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        AbstractC4492zt.h(function, "function");
        return new WrapperItemKeyedDataSource(this, function);
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> map(final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "function");
        return mapByPage((Function) new Function() { // from class: Kt
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ItemKeyedDataSource.map$lambda$8(interfaceC3750qp, (List) obj);
            }
        });
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> mapByPage(final InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3750qp, "function");
        return mapByPage((Function) new Function() { // from class: Lt
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ItemKeyedDataSource.mapByPage$lambda$5(interfaceC3750qp, (List) obj);
            }
        });
    }
}
