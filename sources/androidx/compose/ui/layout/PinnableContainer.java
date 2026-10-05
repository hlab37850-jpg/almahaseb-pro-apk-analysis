package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;

/* JADX INFO: loaded from: classes.dex */
@Stable
public interface PinnableContainer {

    public interface PinnedHandle {
        void release();
    }

    PinnedHandle pin();
}
