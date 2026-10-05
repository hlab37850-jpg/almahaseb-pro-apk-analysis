package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public interface LazyAnimateScrollScope {
    float expectedDistanceTo(int i, int i2);

    Density getDensity();

    int getFirstVisibleItemIndex();

    int getFirstVisibleItemScrollOffset();

    int getItemCount();

    int getLastVisibleItemIndex();

    int getNumOfItemsForTeleport();

    Integer getTargetItemOffset(int i);

    Object scroll(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of);

    void snapToItem(ScrollScope scrollScope, int i, int i2);
}
