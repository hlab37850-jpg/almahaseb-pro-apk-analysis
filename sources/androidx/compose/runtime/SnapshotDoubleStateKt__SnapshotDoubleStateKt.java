package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0977Uu;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SnapshotDoubleStateKt__SnapshotDoubleStateKt {
    public static final double getValue(DoubleState doubleState, Object obj, InterfaceC0977Uu interfaceC0977Uu) {
        AbstractC4492zt.h(doubleState, "<this>");
        AbstractC4492zt.h(interfaceC0977Uu, "property");
        return doubleState.getDoubleValue();
    }

    @StateFactoryMarker
    public static final MutableDoubleState mutableDoubleStateOf(double d) {
        return ActualAndroid_androidKt.createSnapshotMutableDoubleState(d);
    }

    public static final void setValue(MutableDoubleState mutableDoubleState, Object obj, InterfaceC0977Uu interfaceC0977Uu, double d) {
        AbstractC4492zt.h(mutableDoubleState, "<this>");
        AbstractC4492zt.h(interfaceC0977Uu, "property");
        mutableDoubleState.setDoubleValue(d);
    }
}
