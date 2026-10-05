package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    private static final SnapshotThreadLocal<Integer> calculationBlockNestedLevel = new SnapshotThreadLocal<>();
    private static final SnapshotThreadLocal<MutableVector<DerivedStateObserver>> derivedStateObservers = new SnapshotThreadLocal<>();

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        SnapshotThreadLocal<MutableVector<DerivedStateObserver>> snapshotThreadLocal = derivedStateObservers;
        MutableVector<DerivedStateObserver> mutableVector = snapshotThreadLocal.get();
        if (mutableVector != null) {
            return mutableVector;
        }
        MutableVector<DerivedStateObserver> mutableVector2 = new MutableVector<>(new DerivedStateObserver[0], 0);
        snapshotThreadLocal.set(mutableVector2);
        return mutableVector2;
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "calculation");
        return new DerivedSnapshotState(interfaceC3588op, null);
    }

    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(DerivedState<?> derivedState, InterfaceC3588op interfaceC3588op) {
        MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
        int size = mutableVectorDerivedStateObservers.getSize();
        int i = 0;
        if (size > 0) {
            DerivedStateObserver[] content = mutableVectorDerivedStateObservers.getContent();
            int i2 = 0;
            do {
                content[i2].start(derivedState);
                i2++;
            } while (i2 < size);
        }
        try {
            R r = (R) interfaceC3588op.invoke();
            AbstractC0703Ks.b(1);
            int size2 = mutableVectorDerivedStateObservers.getSize();
            if (size2 > 0) {
                DerivedStateObserver[] content2 = mutableVectorDerivedStateObservers.getContent();
                do {
                    content2[i].done(derivedState);
                    i++;
                } while (i < size2);
            }
            return r;
        } finally {
            AbstractC0703Ks.b(1);
            int size3 = mutableVectorDerivedStateObservers.getSize();
            if (size3 > 0) {
                DerivedStateObserver[] content3 = mutableVectorDerivedStateObservers.getContent();
                do {
                    content3[i].done(derivedState);
                    i++;
                } while (i < size3);
            }
            AbstractC0703Ks.a(1);
        }
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver derivedStateObserver, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(derivedStateObserver, "observer");
        AbstractC4492zt.h(interfaceC3588op, CSS.Value.BLOCK);
        MutableVector<DerivedStateObserver> mutableVectorDerivedStateObservers = SnapshotStateKt.derivedStateObservers();
        try {
            mutableVectorDerivedStateObservers.add(derivedStateObserver);
            interfaceC3588op.invoke();
        } finally {
            AbstractC0703Ks.b(1);
            mutableVectorDerivedStateObservers.removeAt(mutableVectorDerivedStateObservers.getSize() - 1);
            AbstractC0703Ks.a(1);
        }
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> snapshotMutationPolicy, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(snapshotMutationPolicy, "policy");
        AbstractC4492zt.h(interfaceC3588op, "calculation");
        return new DerivedSnapshotState(interfaceC3588op, snapshotMutationPolicy);
    }
}
