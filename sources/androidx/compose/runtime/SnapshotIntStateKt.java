package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import defpackage.InterfaceC0977Uu;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotIntStateKt {
    public static final int getValue(IntState intState, Object obj, InterfaceC0977Uu interfaceC0977Uu) {
        return SnapshotIntStateKt__SnapshotIntStateKt.getValue(intState, obj, interfaceC0977Uu);
    }

    @StateFactoryMarker
    public static final MutableIntState mutableIntStateOf(int i) {
        return SnapshotIntStateKt__SnapshotIntStateKt.mutableIntStateOf(i);
    }

    public static final void setValue(MutableIntState mutableIntState, Object obj, InterfaceC0977Uu interfaceC0977Uu, int i) {
        SnapshotIntStateKt__SnapshotIntStateKt.setValue(mutableIntState, obj, interfaceC0977Uu, i);
    }
}
