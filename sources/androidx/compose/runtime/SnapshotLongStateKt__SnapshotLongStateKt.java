package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0977Uu;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SnapshotLongStateKt__SnapshotLongStateKt {
    public static final long getValue(LongState longState, Object obj, InterfaceC0977Uu interfaceC0977Uu) {
        AbstractC4492zt.h(longState, "<this>");
        AbstractC4492zt.h(interfaceC0977Uu, "property");
        return longState.getLongValue();
    }

    @StateFactoryMarker
    public static final MutableLongState mutableLongStateOf(long j) {
        return ActualAndroid_androidKt.createSnapshotMutableLongState(j);
    }

    public static final void setValue(MutableLongState mutableLongState, Object obj, InterfaceC0977Uu interfaceC0977Uu, long j) {
        AbstractC4492zt.h(mutableLongState, "<this>");
        AbstractC4492zt.h(interfaceC0977Uu, "property");
        mutableLongState.setLongValue(j);
    }
}
