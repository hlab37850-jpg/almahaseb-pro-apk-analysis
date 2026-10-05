package androidx.paging;

import defpackage.AbstractC0419Di;
import defpackage.AbstractC0564Hb;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LoadState {
    private final boolean endOfPaginationReached;

    public static final class Error extends LoadState {
        private final Throwable error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable th) {
            super(false, null);
            AbstractC4492zt.h(th, "error");
            this.error = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Error) {
                Error error = (Error) obj;
                if (getEndOfPaginationReached() == error.getEndOfPaginationReached() && AbstractC4492zt.d(this.error, error.error)) {
                    return true;
                }
            }
            return false;
        }

        public final Throwable getError() {
            return this.error;
        }

        public int hashCode() {
            return AbstractC0564Hb.a(getEndOfPaginationReached()) + this.error.hashCode();
        }

        public String toString() {
            return "Error(endOfPaginationReached=" + getEndOfPaginationReached() + ", error=" + this.error + ')';
        }
    }

    public static final class Loading extends LoadState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(false, null);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Loading) && getEndOfPaginationReached() == ((Loading) obj).getEndOfPaginationReached();
        }

        public int hashCode() {
            return AbstractC0564Hb.a(getEndOfPaginationReached());
        }

        public String toString() {
            return "Loading(endOfPaginationReached=" + getEndOfPaginationReached() + ')';
        }
    }

    public static final class NotLoading extends LoadState {
        public static final Companion Companion = new Companion(null);
        private static final NotLoading Complete = new NotLoading(true);
        private static final NotLoading Incomplete = new NotLoading(false);

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
                this();
            }

            public final NotLoading getComplete$paging_common() {
                return NotLoading.Complete;
            }

            public final NotLoading getIncomplete$paging_common() {
                return NotLoading.Incomplete;
            }

            private Companion() {
            }
        }

        public NotLoading(boolean z) {
            super(z, null);
        }

        public boolean equals(Object obj) {
            return (obj instanceof NotLoading) && getEndOfPaginationReached() == ((NotLoading) obj).getEndOfPaginationReached();
        }

        public int hashCode() {
            return AbstractC0564Hb.a(getEndOfPaginationReached());
        }

        public String toString() {
            return "NotLoading(endOfPaginationReached=" + getEndOfPaginationReached() + ')';
        }
    }

    public /* synthetic */ LoadState(boolean z, AbstractC0419Di abstractC0419Di) {
        this(z);
    }

    public final boolean getEndOfPaginationReached() {
        return this.endOfPaginationReached;
    }

    private LoadState(boolean z) {
        this.endOfPaginationReached = z;
    }
}
