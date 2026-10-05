package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0977Uu;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SnapshotIntStateKt__SnapshotIntStateKt {
    public static final int getValue(IntState intState, Object obj, InterfaceC0977Uu interfaceC0977Uu) {
        AbstractC4492zt.h(intState, "<this>");
        AbstractC4492zt.h(interfaceC0977Uu, "property");
        return intState.getIntValue();
    }

    @StateFactoryMarker
    public static final MutableIntState mutableIntStateOf(int i) {
        return ActualAndroid_androidKt.createSnapshotMutableIntState(i);
    }

    public static final void setValue(MutableIntState mutableIntState, Object obj, InterfaceC0977Uu interfaceC0977Uu, int i) {
        AbstractC4492zt.h(mutableIntState, "<this>");
        AbstractC4492zt.h(interfaceC0977Uu, "property");
        mutableIntState.setIntValue(i);
    }
}
