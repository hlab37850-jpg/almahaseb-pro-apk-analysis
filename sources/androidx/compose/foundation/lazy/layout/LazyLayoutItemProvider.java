package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalFoundationApi
public interface LazyLayoutItemProvider {
    @Composable
    void Item(int i, Object obj, Composer composer, int i2);

    Object getContentType(int i);

    int getIndex(Object obj);

    int getItemCount();

    Object getKey(int i);
}
