package androidx.paging;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalPagingApi
public abstract class RemoteMediator<Key, Value> {

    public enum InitializeAction {
        LAUNCH_INITIAL_REFRESH,
        SKIP_INITIAL_REFRESH
    }

    public static abstract class MediatorResult {

        public static final class Error extends MediatorResult {
            private final Throwable throwable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Throwable th) {
                super(null);
                AbstractC4492zt.h(th, "throwable");
                this.throwable = th;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }
        }

        public static final class Success extends MediatorResult {
            private final boolean endOfPaginationReached;

            public Success(boolean z) {
                super(null);
                this.endOfPaginationReached = z;
            }

            public final boolean endOfPaginationReached() {
                return this.endOfPaginationReached;
            }
        }

        public /* synthetic */ MediatorResult(AbstractC0419Di abstractC0419Di) {
            this();
        }

        private MediatorResult() {
        }
    }

    public static /* synthetic */ <Key, Value> Object initialize$suspendImpl(RemoteMediator<Key, Value> remoteMediator, InterfaceC0793Of interfaceC0793Of) {
        return InitializeAction.LAUNCH_INITIAL_REFRESH;
    }

    public Object initialize(InterfaceC0793Of interfaceC0793Of) {
        return initialize$suspendImpl(this, interfaceC0793Of);
    }

    public abstract Object load(LoadType loadType, PagingState<Key, Value> pagingState, InterfaceC0793Of interfaceC0793Of);
}
