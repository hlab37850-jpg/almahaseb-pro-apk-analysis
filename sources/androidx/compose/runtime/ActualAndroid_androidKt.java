package androidx.compose.runtime;

import android.util.Log;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import defpackage.AbstractC3756qv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3430mv;

/* JADX INFO: loaded from: classes.dex */
public final class ActualAndroid_androidKt {
    private static final InterfaceC3430mv DefaultMonotonicFrameClock$delegate = AbstractC3756qv.a(ActualAndroid_androidKt$DefaultMonotonicFrameClock$2.INSTANCE);
    private static final boolean DisallowDefaultMonotonicFrameClock = false;
    private static final String LogTag = "ComposeInternal";

    public static final MutableDoubleState createSnapshotMutableDoubleState(double d) {
        return new ParcelableSnapshotMutableDoubleState(d);
    }

    public static final MutableFloatState createSnapshotMutableFloatState(float f) {
        return new ParcelableSnapshotMutableFloatState(f);
    }

    public static final MutableIntState createSnapshotMutableIntState(int i) {
        return new ParcelableSnapshotMutableIntState(i);
    }

    public static final MutableLongState createSnapshotMutableLongState(long j) {
        return new ParcelableSnapshotMutableLongState(j);
    }

    public static final <T> SnapshotMutableState<T> createSnapshotMutableState(T t, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        AbstractC4492zt.h(snapshotMutationPolicy, "policy");
        return new ParcelableSnapshotMutableState(t, snapshotMutationPolicy);
    }

    public static final MonotonicFrameClock getDefaultMonotonicFrameClock() {
        return (MonotonicFrameClock) DefaultMonotonicFrameClock$delegate.getValue();
    }

    public static /* synthetic */ void getDefaultMonotonicFrameClock$annotations() {
    }

    public static final void logError(String str, Throwable th) {
        AbstractC4492zt.h(str, "message");
        AbstractC4492zt.h(th, "e");
        Log.e(LogTag, str, th);
    }
}
