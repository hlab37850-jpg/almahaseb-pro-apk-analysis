package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.StateFactoryMarker;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0977Uu;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class PrimitiveSnapshotStateKt__SnapshotFloatStateKt {
    public static final float getValue(FloatState floatState, Object obj, InterfaceC0977Uu interfaceC0977Uu) {
        AbstractC4492zt.h(floatState, "<this>");
        AbstractC4492zt.h(interfaceC0977Uu, "property");
        return floatState.getFloatValue();
    }

    @StateFactoryMarker
    public static final MutableFloatState mutableFloatStateOf(float f) {
        return ActualAndroid_androidKt.createSnapshotMutableFloatState(f);
    }

    public static final void setValue(MutableFloatState mutableFloatState, Object obj, InterfaceC0977Uu interfaceC0977Uu, float f) {
        AbstractC4492zt.h(mutableFloatState, "<this>");
        AbstractC4492zt.h(interfaceC0977Uu, "property");
        mutableFloatState.setFloatValue(f);
    }
}
