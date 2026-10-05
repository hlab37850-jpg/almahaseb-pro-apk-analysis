package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import defpackage.InterfaceC0977Uu;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotLongStateKt {
    public static final long getValue(LongState longState, Object obj, InterfaceC0977Uu interfaceC0977Uu) {
        return SnapshotLongStateKt__SnapshotLongStateKt.getValue(longState, obj, interfaceC0977Uu);
    }

    @StateFactoryMarker
    public static final MutableLongState mutableLongStateOf(long j) {
        return SnapshotLongStateKt__SnapshotLongStateKt.mutableLongStateOf(j);
    }

    public static final void setValue(MutableLongState mutableLongState, Object obj, InterfaceC0977Uu interfaceC0977Uu, long j) {
        SnapshotLongStateKt__SnapshotLongStateKt.setValue(mutableLongState, obj, interfaceC0977Uu, j);
    }
}
