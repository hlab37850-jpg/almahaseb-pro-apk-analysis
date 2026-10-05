package androidx.paging;

/* JADX INFO: loaded from: classes2.dex */
public final class PagedListConfigKt {
    public static final /* synthetic */ PagedList.Config Config(int i, int i2, boolean z, int i3, int i4) {
        return new PagedList.Config.Builder().setPageSize(i).setPrefetchDistance(i2).setEnablePlaceholders(z).setInitialLoadSizeHint(i3).setMaxSize(i4).build();
    }

    public static /* synthetic */ PagedList.Config Config$default(int i, int i2, boolean z, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = i;
        }
        if ((i5 & 4) != 0) {
            z = true;
        }
        if ((i5 & 8) != 0) {
            i3 = i * 3;
        }
        if ((i5 & 16) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Config(i, i2, z, i3, i4);
    }
}
