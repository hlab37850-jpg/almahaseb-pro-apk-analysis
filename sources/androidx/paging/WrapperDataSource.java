package androidx.paging;

import androidx.arch.core.util.Function;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.LL;
import java.util.IdentityHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class WrapperDataSource<Key, ValueFrom, ValueTo> extends DataSource<Key, ValueTo> {
    private final IdentityHashMap<ValueTo, Key> keyMap;
    private final Function<List<ValueFrom>, List<ValueTo>> listFunction;
    private final DataSource<Key, ValueFrom> source;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            try {
                iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WrapperDataSource(DataSource<Key, ValueFrom> dataSource, Function<List<ValueFrom>, List<ValueTo>> function) {
        super(dataSource.getType$paging_common());
        AbstractC4492zt.h(dataSource, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(function, "listFunction");
        this.source = dataSource;
        this.listFunction = function;
        this.keyMap = WhenMappings.$EnumSwitchMapping$0[dataSource.getType$paging_common().ordinal()] == 1 ? new IdentityHashMap<>() : null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ <Key, ValueFrom, ValueTo> Object load$suspendImpl(WrapperDataSource<Key, ValueFrom, ValueTo> wrapperDataSource, DataSource.Params<Key> params, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        WrapperDataSource$load$1 wrapperDataSource$load$1;
        WrapperDataSource wrapperDataSource2;
        if (interfaceC0793Of instanceof WrapperDataSource$load$1) {
            wrapperDataSource$load$1 = (WrapperDataSource$load$1) interfaceC0793Of;
            int i = wrapperDataSource$load$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                wrapperDataSource$load$1.label = i - Integer.MIN_VALUE;
            } else {
                wrapperDataSource$load$1 = new WrapperDataSource$load$1(wrapperDataSource, interfaceC0793Of);
            }
        } else {
            wrapperDataSource$load$1 = new WrapperDataSource$load$1(wrapperDataSource, interfaceC0793Of);
        }
        Object objLoad$paging_common = wrapperDataSource$load$1.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = wrapperDataSource$load$1.label;
        if (i2 == 0) {
            LL.b(objLoad$paging_common);
            DataSource<Key, ValueFrom> dataSource = ((WrapperDataSource) wrapperDataSource).source;
            wrapperDataSource$load$1.L$0 = wrapperDataSource;
            wrapperDataSource$load$1.label = 1;
            objLoad$paging_common = dataSource.load$paging_common(params, wrapperDataSource$load$1);
            if (objLoad$paging_common == objD) {
                wrapperDataSource2 = wrapperDataSource;
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z = (WrapperDataSource<Key, ValueFrom, ValueTo>) ((WrapperDataSource) wrapperDataSource$load$1.L$0);
            LL.b(objLoad$paging_common);
            wrapperDataSource2 = z;
        }
        wrapperDataSource2 = wrapperDataSource;
        DataSource.BaseResult baseResult = (DataSource.BaseResult) objLoad$paging_common;
        DataSource.BaseResult baseResultConvert$paging_common = DataSource.BaseResult.Companion.convert$paging_common(baseResult, wrapperDataSource2.listFunction);
        wrapperDataSource2.stashKeysIfNeeded(baseResult.data, baseResultConvert$paging_common.data);
        return baseResultConvert$paging_common;
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(DataSource.InvalidatedCallback invalidatedCallback) {
        AbstractC4492zt.h(invalidatedCallback, "onInvalidatedCallback");
        this.source.addInvalidatedCallback(invalidatedCallback);
    }

    @Override // androidx.paging.DataSource
    public Key getKeyInternal$paging_common(ValueTo valueto) {
        Key key;
        AbstractC4492zt.h(valueto, "item");
        IdentityHashMap<ValueTo, Key> identityHashMap = this.keyMap;
        if (identityHashMap == null) {
            throw new IllegalStateException("Cannot get key by item in non-item keyed DataSource");
        }
        synchronized (identityHashMap) {
            key = this.keyMap.get(valueto);
            AbstractC4492zt.e(key);
        }
        return key;
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.source.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.source.isInvalid();
    }

    @Override // androidx.paging.DataSource
    public Object load$paging_common(DataSource.Params<Key> params, InterfaceC0793Of interfaceC0793Of) {
        return load$suspendImpl(this, params, interfaceC0793Of);
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback invalidatedCallback) {
        AbstractC4492zt.h(invalidatedCallback, "onInvalidatedCallback");
        this.source.removeInvalidatedCallback(invalidatedCallback);
    }

    public final void stashKeysIfNeeded(List<? extends ValueFrom> list, List<? extends ValueTo> list2) {
        AbstractC4492zt.h(list, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(list2, "dest");
        IdentityHashMap<ValueTo, Key> identityHashMap = this.keyMap;
        if (identityHashMap != null) {
            synchronized (identityHashMap) {
                try {
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        IdentityHashMap<ValueTo, Key> identityHashMap2 = this.keyMap;
                        ValueTo valueto = list2.get(i);
                        DataSource<Key, ValueFrom> dataSource = this.source;
                        AbstractC4492zt.f(dataSource, "null cannot be cast to non-null type androidx.paging.ItemKeyedDataSource<Key of androidx.paging.WrapperDataSource.stashKeysIfNeeded$lambda$1, ValueFrom of androidx.paging.WrapperDataSource.stashKeysIfNeeded$lambda$1>");
                        identityHashMap2.put(valueto, (Key) ((ItemKeyedDataSource) dataSource).getKey(list.get(i)));
                    }
                    FW fw = FW.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
