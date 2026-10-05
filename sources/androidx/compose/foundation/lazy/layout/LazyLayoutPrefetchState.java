package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public final class LazyLayoutPrefetchState {
    public static final int $stable = 0;
    private Prefetcher prefetcher;

    public interface PrefetchHandle {
        void cancel();
    }

    public interface Prefetcher {
        /* JADX INFO: renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
        PrefetchHandle mo643schedulePrefetch0kLqBqw(int i, long j);
    }

    public final Prefetcher getPrefetcher$foundation_release() {
        return this.prefetcher;
    }

    /* JADX INFO: renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
    public final PrefetchHandle m642schedulePrefetch0kLqBqw(int i, long j) {
        PrefetchHandle prefetchHandleMo643schedulePrefetch0kLqBqw;
        Prefetcher prefetcher = this.prefetcher;
        return (prefetcher == null || (prefetchHandleMo643schedulePrefetch0kLqBqw = prefetcher.mo643schedulePrefetch0kLqBqw(i, j)) == null) ? DummyHandle.INSTANCE : prefetchHandleMo643schedulePrefetch0kLqBqw;
    }

    public final void setPrefetcher$foundation_release(Prefetcher prefetcher) {
        this.prefetcher = prefetcher;
    }
}
