package androidx.paging;

import androidx.annotation.IntRange;
import defpackage.AbstractC0419Di;

/* JADX INFO: loaded from: classes2.dex */
public final class PagingConfig {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INITIAL_PAGE_MULTIPLIER = 3;
    public static final int MAX_SIZE_UNBOUNDED = Integer.MAX_VALUE;
    public final boolean enablePlaceholders;
    public final int initialLoadSize;
    public final int jumpThreshold;
    public final int maxSize;
    public final int pageSize;
    public final int prefetchDistance;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ void getMAX_SIZE_UNBOUNDED$annotations() {
        }

        private Companion() {
        }
    }

    public PagingConfig(int i) {
        this(i, 0, false, 0, 0, 0, 62, null);
    }

    public PagingConfig(int i, @IntRange(from = 0) int i2) {
        this(i, i2, false, 0, 0, 0, 60, null);
    }

    public PagingConfig(int i, @IntRange(from = 0) int i2, boolean z) {
        this(i, i2, z, 0, 0, 0, 56, null);
    }

    public PagingConfig(int i, @IntRange(from = 0) int i2, boolean z, @IntRange(from = 1) int i3) {
        this(i, i2, z, i3, 0, 0, 48, null);
    }

    public PagingConfig(int i, @IntRange(from = 0) int i2, boolean z, @IntRange(from = 1) int i3, @IntRange(from = 2) int i4) {
        this(i, i2, z, i3, i4, 0, 32, null);
    }

    public PagingConfig(int i, @IntRange(from = 0) int i2, boolean z, @IntRange(from = 1) int i3, @IntRange(from = 2) int i4, int i5) {
        this.pageSize = i;
        this.prefetchDistance = i2;
        this.enablePlaceholders = z;
        this.initialLoadSize = i3;
        this.maxSize = i4;
        this.jumpThreshold = i5;
        if (!z && i2 == 0) {
            throw new IllegalArgumentException("Placeholders and prefetch are the only ways to trigger loading of more data in PagingData, so either placeholders must be enabled, or prefetch distance must be > 0.");
        }
        if (i4 == Integer.MAX_VALUE || i4 >= (i2 * 2) + i) {
            if (i5 != Integer.MIN_VALUE && i5 <= 0) {
                throw new IllegalArgumentException("jumpThreshold must be positive to enable jumps or COUNT_UNDEFINED to disable jumping.");
            }
            return;
        }
        throw new IllegalArgumentException("Maximum size must be at least pageSize + 2*prefetchDist, pageSize=" + i + ", prefetchDist=" + i2 + ", maxSize=" + i4);
    }

    public /* synthetic */ PagingConfig(int i, int i2, boolean z, int i3, int i4, int i5, int i6, AbstractC0419Di abstractC0419Di) {
        this(i, (i6 & 2) != 0 ? i : i2, (i6 & 4) != 0 ? true : z, (i6 & 8) != 0 ? i * 3 : i3, (i6 & 16) != 0 ? Integer.MAX_VALUE : i4, (i6 & 32) != 0 ? Integer.MIN_VALUE : i5);
    }
}
