package androidx.paging;

import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import defpackage.AD;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC3310lS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0756Mu;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PagingSource<Key, Value> {
    private final InvalidateCallbackTracker<InterfaceC3588op> invalidateCallbackTracker = new InvalidateCallbackTracker<>(PagingSource$invalidateCallbackTracker$1.INSTANCE, null, 2, 0 == true ? 1 : 0);

    public static abstract class LoadParams<Key> {
        public static final Companion Companion = new Companion(null);
        private final int loadSize;
        private final boolean placeholdersEnabled;

        public static final class Append<Key> extends LoadParams<Key> {
            private final Key key;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Append(Key key, int i, boolean z) {
                super(i, z, null);
                AbstractC4492zt.h(key, "key");
                this.key = key;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }
        }

        public static final class Companion {

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

            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            public final <Key> LoadParams<Key> create(LoadType loadType, Key key, int i, boolean z) {
                AbstractC4492zt.h(loadType, "loadType");
                int i2 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
                if (i2 == 1) {
                    return new Refresh(key, i, z);
                }
                if (i2 == 2) {
                    if (key != null) {
                        return new Prepend(key, i, z);
                    }
                    throw new IllegalArgumentException("key cannot be null for prepend");
                }
                if (i2 != 3) {
                    throw new AD();
                }
                if (key != null) {
                    return new Append(key, i, z);
                }
                throw new IllegalArgumentException("key cannot be null for append");
            }

            private Companion() {
            }
        }

        public static final class Prepend<Key> extends LoadParams<Key> {
            private final Key key;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Prepend(Key key, int i, boolean z) {
                super(i, z, null);
                AbstractC4492zt.h(key, "key");
                this.key = key;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }
        }

        public static final class Refresh<Key> extends LoadParams<Key> {
            private final Key key;

            public Refresh(Key key, int i, boolean z) {
                super(i, z, null);
                this.key = key;
            }

            @Override // androidx.paging.PagingSource.LoadParams
            public Key getKey() {
                return this.key;
            }
        }

        public /* synthetic */ LoadParams(int i, boolean z, AbstractC0419Di abstractC0419Di) {
            this(i, z);
        }

        public abstract Key getKey();

        public final int getLoadSize() {
            return this.loadSize;
        }

        public final boolean getPlaceholdersEnabled() {
            return this.placeholdersEnabled;
        }

        private LoadParams(int i, boolean z) {
            this.loadSize = i;
            this.placeholdersEnabled = z;
        }
    }

    public static abstract class LoadResult<Key, Value> {

        public static final class Error<Key, Value> extends LoadResult<Key, Value> {
            private final Throwable throwable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Throwable th) {
                super(null);
                AbstractC4492zt.h(th, "throwable");
                this.throwable = th;
            }

            public static /* synthetic */ Error copy$default(Error error, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = error.throwable;
                }
                return error.copy(th);
            }

            public final Throwable component1() {
                return this.throwable;
            }

            public final Error<Key, Value> copy(Throwable th) {
                AbstractC4492zt.h(th, "throwable");
                return new Error<>(th);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && AbstractC4492zt.d(this.throwable, ((Error) obj).throwable);
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }

            public int hashCode() {
                return this.throwable.hashCode();
            }

            public String toString() {
                return AbstractC3310lS.h("LoadResult.Error(\n                    |   throwable: " + this.throwable + "\n                    |) ", null, 1, null);
            }
        }

        public static final class Invalid<Key, Value> extends LoadResult<Key, Value> {
            public Invalid() {
                super(null);
            }

            public String toString() {
                return "LoadResult.Invalid";
            }
        }

        public static final class Page<Key, Value> extends LoadResult<Key, Value> implements Iterable<Value>, InterfaceC0756Mu {
            public static final int COUNT_UNDEFINED = Integer.MIN_VALUE;
            public static final Companion Companion = new Companion(null);
            private static final Page EMPTY = new Page(AbstractC1886cc.m(), null, null, 0, 0);
            private final List<Value> data;
            private final int itemsAfter;
            private final int itemsBefore;
            private final Key nextKey;
            private final Key prevKey;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                    this();
                }

                public static /* synthetic */ void getEMPTY$paging_common$annotations() {
                }

                public final <Key, Value> Page<Key, Value> empty$paging_common() {
                    Page<Key, Value> eMPTY$paging_common = getEMPTY$paging_common();
                    AbstractC4492zt.f(eMPTY$paging_common, "null cannot be cast to non-null type androidx.paging.PagingSource.LoadResult.Page<Key of androidx.paging.PagingSource.LoadResult.Page.Companion.empty, Value of androidx.paging.PagingSource.LoadResult.Page.Companion.empty>");
                    return eMPTY$paging_common;
                }

                public final Page getEMPTY$paging_common() {
                    return Page.EMPTY;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Page(List list, Object obj, Object obj2, int i, int i2, int i3, AbstractC0419Di abstractC0419Di) {
                this(list, obj, obj2, (i3 & 8) != 0 ? Integer.MIN_VALUE : i, (i3 & 16) != 0 ? Integer.MIN_VALUE : i2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Page copy$default(Page page, List list, Object obj, Object obj2, int i, int i2, int i3, Object obj3) {
                if ((i3 & 1) != 0) {
                    list = page.data;
                }
                if ((i3 & 2) != 0) {
                    obj = page.prevKey;
                }
                Object obj4 = obj;
                if ((i3 & 4) != 0) {
                    obj2 = page.nextKey;
                }
                Object obj5 = obj2;
                if ((i3 & 8) != 0) {
                    i = page.itemsBefore;
                }
                int i4 = i;
                if ((i3 & 16) != 0) {
                    i2 = page.itemsAfter;
                }
                return page.copy(list, obj4, obj5, i4, i2);
            }

            public final List<Value> component1() {
                return this.data;
            }

            public final Key component2() {
                return this.prevKey;
            }

            public final Key component3() {
                return this.nextKey;
            }

            public final int component4() {
                return this.itemsBefore;
            }

            public final int component5() {
                return this.itemsAfter;
            }

            public final Page<Key, Value> copy(List<? extends Value> list, Key key, Key key2, @IntRange(from = -2147483648L) int i, @IntRange(from = -2147483648L) int i2) {
                AbstractC4492zt.h(list, "data");
                return new Page<>(list, key, key2, i, i2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Page)) {
                    return false;
                }
                Page page = (Page) obj;
                return AbstractC4492zt.d(this.data, page.data) && AbstractC4492zt.d(this.prevKey, page.prevKey) && AbstractC4492zt.d(this.nextKey, page.nextKey) && this.itemsBefore == page.itemsBefore && this.itemsAfter == page.itemsAfter;
            }

            public final List<Value> getData() {
                return this.data;
            }

            public final int getItemsAfter() {
                return this.itemsAfter;
            }

            public final int getItemsBefore() {
                return this.itemsBefore;
            }

            public final Key getNextKey() {
                return this.nextKey;
            }

            public final Key getPrevKey() {
                return this.prevKey;
            }

            public int hashCode() {
                int iHashCode = this.data.hashCode() * 31;
                Key key = this.prevKey;
                int iHashCode2 = (iHashCode + (key == null ? 0 : key.hashCode())) * 31;
                Key key2 = this.nextKey;
                return ((((iHashCode2 + (key2 != null ? key2.hashCode() : 0)) * 31) + this.itemsBefore) * 31) + this.itemsAfter;
            }

            @Override // java.lang.Iterable
            public Iterator<Value> iterator() {
                return this.data.listIterator();
            }

            public String toString() {
                return AbstractC3310lS.h("LoadResult.Page(\n                    |   data size: " + this.data.size() + "\n                    |   first Item: " + AbstractC3240kc.d0(this.data) + "\n                    |   last Item: " + AbstractC3240kc.l0(this.data) + "\n                    |   nextKey: " + this.nextKey + "\n                    |   prevKey: " + this.prevKey + "\n                    |   itemsBefore: " + this.itemsBefore + "\n                    |   itemsAfter: " + this.itemsAfter + "\n                    |) ", null, 1, null);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Page(List<? extends Value> list, Key key, Key key2, @IntRange(from = -2147483648L) int i, @IntRange(from = -2147483648L) int i2) {
                super(null);
                AbstractC4492zt.h(list, "data");
                this.data = list;
                this.prevKey = key;
                this.nextKey = key2;
                this.itemsBefore = i;
                this.itemsAfter = i2;
                if (i != Integer.MIN_VALUE && i < 0) {
                    throw new IllegalArgumentException("itemsBefore cannot be negative");
                }
                if (i2 != Integer.MIN_VALUE && i2 < 0) {
                    throw new IllegalArgumentException("itemsAfter cannot be negative");
                }
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Page(List<? extends Value> list, Key key, Key key2) {
                this(list, key, key2, Integer.MIN_VALUE, Integer.MIN_VALUE);
                AbstractC4492zt.h(list, "data");
            }
        }

        public /* synthetic */ LoadResult(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private LoadResult() {
        }
    }

    public final boolean getInvalid() {
        return this.invalidateCallbackTracker.getInvalid$paging_common();
    }

    @VisibleForTesting
    public final int getInvalidateCallbackCount$paging_common() {
        return this.invalidateCallbackTracker.callbackCount$paging_common();
    }

    public boolean getJumpingSupported() {
        return false;
    }

    public boolean getKeyReuseSupported() {
        return false;
    }

    public abstract Key getRefreshKey(PagingState<Key, Value> pagingState);

    public final void invalidate() {
        Logger logger;
        if (this.invalidateCallbackTracker.invalidate$paging_common() && (logger = LoggerKt.getLOGGER()) != null && logger.isLoggable(3)) {
            logger.log(3, "Invalidated PagingSource " + this, null);
        }
    }

    public abstract Object load(LoadParams<Key> loadParams, InterfaceC0793Of interfaceC0793Of);

    public final void registerInvalidatedCallback(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "onInvalidatedCallback");
        this.invalidateCallbackTracker.registerInvalidatedCallback$paging_common(interfaceC3588op);
    }

    public final void unregisterInvalidatedCallback(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "onInvalidatedCallback");
        this.invalidateCallbackTracker.unregisterInvalidatedCallback$paging_common(interfaceC3588op);
    }
}
