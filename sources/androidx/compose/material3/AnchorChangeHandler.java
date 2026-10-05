package androidx.compose.material3;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterial3Api
public interface AnchorChangeHandler<T> {
    void onAnchorsChanged(T t, Map<T, Float> map, Map<T, Float> map2);
}
