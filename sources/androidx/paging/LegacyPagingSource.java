package androidx.paging;

import androidx.annotation.RestrictTo;
import defpackage.AD;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0916Sp;
import defpackage.FW;
import defpackage.InterfaceC0348Ap;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0803Op;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class LegacyPagingSource<Key, Value> extends PagingSource<Key, Value> {
    private static final Companion Companion = new Companion(null);
    private static final int PAGE_SIZE_NOT_SET = Integer.MIN_VALUE;
    private final DataSource<Key, Value> dataSource;
    private final InterfaceC0988Vf fetchContext;
    private int pageSize;

    /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 implements DataSource.InvalidatedCallback, InterfaceC0803Op {
        final /* synthetic */ LegacyPagingSource<Key, Value> $tmp0;

        public AnonymousClass1(LegacyPagingSource<Key, Value> legacyPagingSource) {
            this.$tmp0 = legacyPagingSource;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof DataSource.InvalidatedCallback) && (obj instanceof InterfaceC0803Op)) {
                return AbstractC4492zt.d(getFunctionDelegate(), ((InterfaceC0803Op) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // defpackage.InterfaceC0803Op
        public final InterfaceC0348Ap getFunctionDelegate() {
            return new C0916Sp(0, this.$tmp0, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.paging.DataSource.InvalidatedCallback
        public final void onInvalidated() {
            this.$tmp0.invalidate();
        }
    }

    /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ LegacyPagingSource<Key, Value> this$0;

        /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$2$1, reason: invalid class name */
        public /* synthetic */ class AnonymousClass1 implements DataSource.InvalidatedCallback, InterfaceC0803Op {
            final /* synthetic */ LegacyPagingSource<Key, Value> $tmp0;

            public AnonymousClass1(LegacyPagingSource<Key, Value> legacyPagingSource) {
                this.$tmp0 = legacyPagingSource;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof DataSource.InvalidatedCallback) && (obj instanceof InterfaceC0803Op)) {
                    return AbstractC4492zt.d(getFunctionDelegate(), ((InterfaceC0803Op) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // defpackage.InterfaceC0803Op
            public final InterfaceC0348Ap getFunctionDelegate() {
                return new C0916Sp(0, this.$tmp0, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            @Override // androidx.paging.DataSource.InvalidatedCallback
            public final void onInvalidated() {
                this.$tmp0.invalidate();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(LegacyPagingSource<Key, Value> legacyPagingSource) {
            super(0);
            this.this$0 = legacyPagingSource;
        }

        @Override // defpackage.InterfaceC3588op
        public /* bridge */ /* synthetic */ Object invoke() {
            m5429invoke();
            return FW.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m5429invoke() {
            this.this$0.getDataSource$paging_common().removeInvalidatedCallback(new AnonymousClass1(this.this$0));
            this.this$0.getDataSource$paging_common().invalidate();
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            try {
                iArr[DataSource.KeyType.POSITIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.KeyType.PAGE_KEYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.LegacyPagingSource$load$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.LegacyPagingSource$load$2", f = "LegacyPagingSource.kt", l = {110}, m = "invokeSuspend")
    public static final class C17002 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ DataSource.Params<Key> $dataSourceParams;
        final /* synthetic */ PagingSource.LoadParams<Key> $params;
        int label;
        final /* synthetic */ LegacyPagingSource<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17002(LegacyPagingSource<Key, Value> legacyPagingSource, DataSource.Params<Key> params, PagingSource.LoadParams<Key> loadParams, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = legacyPagingSource;
            this.$dataSourceParams = params;
            this.$params = loadParams;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new C17002(this.this$0, this.$dataSourceParams, this.$params, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((C17002) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                DataSource<Key, Value> dataSource$paging_common = this.this$0.getDataSource$paging_common();
                DataSource.Params<Key> params = this.$dataSourceParams;
                this.label = 1;
                obj = dataSource$paging_common.load$paging_common(params, this);
                if (obj == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            PagingSource.LoadParams<Key> loadParams = this.$params;
            DataSource.BaseResult baseResult = (DataSource.BaseResult) obj;
            List<Value> list = baseResult.data;
            return new PagingSource.LoadResult.Page(list, (list.isEmpty() && (loadParams instanceof PagingSource.LoadParams.Prepend)) ? null : baseResult.getPrevKey(), (baseResult.data.isEmpty() && (loadParams instanceof PagingSource.LoadParams.Append)) ? null : baseResult.getNextKey(), baseResult.getItemsBefore(), baseResult.getItemsAfter());
        }
    }

    public LegacyPagingSource(InterfaceC0988Vf interfaceC0988Vf, DataSource<Key, Value> dataSource) {
        AbstractC4492zt.h(interfaceC0988Vf, "fetchContext");
        AbstractC4492zt.h(dataSource, "dataSource");
        this.fetchContext = interfaceC0988Vf;
        this.dataSource = dataSource;
        this.pageSize = Integer.MIN_VALUE;
        dataSource.addInvalidatedCallback(new AnonymousClass1(this));
        registerInvalidatedCallback(new AnonymousClass2(this));
    }

    private final int guessPageSize(PagingSource.LoadParams<Key> loadParams) {
        return ((loadParams instanceof PagingSource.LoadParams.Refresh) && loadParams.getLoadSize() % 3 == 0) ? loadParams.getLoadSize() / 3 : loadParams.getLoadSize();
    }

    public final DataSource<Key, Value> getDataSource$paging_common() {
        return this.dataSource;
    }

    @Override // androidx.paging.PagingSource
    public boolean getJumpingSupported() {
        return this.dataSource.getType$paging_common() == DataSource.KeyType.POSITIONAL;
    }

    @Override // androidx.paging.PagingSource
    public Key getRefreshKey(PagingState<Key, Value> pagingState) {
        Object prevKey;
        Value valueClosestItemToPosition;
        AbstractC4492zt.h(pagingState, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[this.dataSource.getType$paging_common().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return null;
            }
            if (i != 3) {
                throw new AD();
            }
            Integer anchorPosition = pagingState.getAnchorPosition();
            if (anchorPosition == null || (valueClosestItemToPosition = pagingState.closestItemToPosition(anchorPosition.intValue())) == null) {
                return null;
            }
            return this.dataSource.getKeyInternal$paging_common(valueClosestItemToPosition);
        }
        Integer anchorPosition2 = pagingState.getAnchorPosition();
        if (anchorPosition2 == null) {
            return null;
        }
        int iIntValue = anchorPosition2.intValue();
        int size = iIntValue - ((PagingState) pagingState).leadingPlaceholderCount;
        for (int i2 = 0; i2 < AbstractC1886cc.o(pagingState.getPages()) && size > AbstractC1886cc.o(pagingState.getPages().get(i2).getData()); i2++) {
            size -= pagingState.getPages().get(i2).getData().size();
        }
        PagingSource.LoadResult.Page<Key, Value> pageClosestPageToPosition = pagingState.closestPageToPosition(iIntValue);
        if (pageClosestPageToPosition == null || (prevKey = pageClosestPageToPosition.getPrevKey()) == null) {
            prevKey = 0;
        }
        AbstractC4492zt.f(prevKey, "null cannot be cast to non-null type kotlin.Int");
        return (Key) Integer.valueOf(((Integer) prevKey).intValue() + size);
    }

    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Key> loadParams, InterfaceC0793Of interfaceC0793Of) {
        LoadType loadType;
        if (loadParams instanceof PagingSource.LoadParams.Refresh) {
            loadType = LoadType.REFRESH;
        } else if (loadParams instanceof PagingSource.LoadParams.Append) {
            loadType = LoadType.APPEND;
        } else {
            if (!(loadParams instanceof PagingSource.LoadParams.Prepend)) {
                throw new AD();
            }
            loadType = LoadType.PREPEND;
        }
        LoadType loadType2 = loadType;
        if (this.pageSize == Integer.MIN_VALUE) {
            System.out.println((Object) "WARNING: pageSize on the LegacyPagingSource is not set.\nWhen using legacy DataSource / DataSourceFactory with Paging3, page size\nshould've been set by the paging library but it is not set yet.\n\nIf you are seeing this message in tests where you are testing DataSource\nin isolation (without a Pager), it is expected and page size will be estimated\nbased on parameters.\n\nIf you are seeing this message despite using a Pager, please file a bug:\nhttps://issuetracker.google.com/issues/new?component=413106");
            this.pageSize = guessPageSize(loadParams);
        }
        return M8.g(this.fetchContext, new C17002(this, new DataSource.Params(loadType2, loadParams.getKey(), loadParams.getLoadSize(), loadParams.getPlaceholdersEnabled(), this.pageSize), loadParams, null), interfaceC0793Of);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setPageSize(int i) {
        int i2 = this.pageSize;
        if (i2 == Integer.MIN_VALUE || i == i2) {
            this.pageSize = i;
            return;
        }
        throw new IllegalStateException(("Page size is already set to " + this.pageSize + '.').toString());
    }
}
