package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.semantics.CollectionInfo;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public interface LazyLayoutSemanticState {
    Object animateScrollBy(float f, InterfaceC0793Of interfaceC0793Of);

    CollectionInfo collectionInfo();

    boolean getCanScrollForward();

    float getCurrentPosition();

    Object scrollToItem(int i, InterfaceC0793Of interfaceC0793Of);
}
