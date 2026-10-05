package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.StateFactoryMarker;
import defpackage.C2020dG;
import defpackage.CR;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0977Uu;
import defpackage.InterfaceC0988Vf;
import defpackage.InterfaceC3588op;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotStateKt {
    @Composable
    public static final <T extends R, R> State<R> collectAsState(InterfaceC0939Tm interfaceC0939Tm, R r, InterfaceC0988Vf interfaceC0988Vf, Composer composer, int i, int i2) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(interfaceC0939Tm, r, interfaceC0988Vf, composer, i, i2);
    }

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        return SnapshotStateKt__DerivedStateKt.derivedStateObservers();
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(InterfaceC3588op interfaceC3588op) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(interfaceC3588op);
    }

    public static final <T> T getValue(State<? extends T> state, Object obj, InterfaceC0977Uu interfaceC0977Uu) {
        return (T) SnapshotStateKt__SnapshotStateKt.getValue(state, obj, interfaceC0977Uu);
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    @StateFactoryMarker
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    @StateFactoryMarker
    public static final <T> MutableState<T> mutableStateOf(T t, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(t, snapshotMutationPolicy);
    }

    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final <R> void observeDerivedStateRecalculations(DerivedStateObserver derivedStateObserver, InterfaceC3588op interfaceC3588op) {
        SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(derivedStateObserver, interfaceC3588op);
    }

    @Composable
    public static final <T> State<T> produceState(T t, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t, interfaceC0526Fp, composer, i);
    }

    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    @Composable
    public static final <T> State<T> rememberUpdatedState(T t, Composer composer, int i) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(t, composer, i);
    }

    public static final <T> void setValue(MutableState<T> mutableState, Object obj, InterfaceC0977Uu interfaceC0977Uu, T t) {
        SnapshotStateKt__SnapshotStateKt.setValue(mutableState, obj, interfaceC0977Uu, t);
    }

    public static final <T> InterfaceC0939Tm snapshotFlow(InterfaceC3588op interfaceC3588op) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(interfaceC3588op);
    }

    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    public static final <T> SnapshotStateList<T> toMutableStateList(Collection<? extends T> collection) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateList(collection);
    }

    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(Iterable<? extends C2020dG> iterable) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateMap(iterable);
    }

    @Composable
    public static final <T> State<T> collectAsState(CR cr, InterfaceC0988Vf interfaceC0988Vf, Composer composer, int i, int i2) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(cr, interfaceC0988Vf, composer, i, i2);
    }

    @StateFactoryMarker
    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> snapshotMutationPolicy, InterfaceC3588op interfaceC3588op) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(snapshotMutationPolicy, interfaceC3588op);
    }

    @StateFactoryMarker
    public static final <T> SnapshotStateList<T> mutableStateListOf(T... tArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(tArr);
    }

    @StateFactoryMarker
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(C2020dG... c2020dGArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf(c2020dGArr);
    }

    @Composable
    public static final <T> State<T> produceState(T t, Object obj, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t, obj, interfaceC0526Fp, composer, i);
    }

    @Composable
    public static final <T> State<T> produceState(T t, Object obj, Object obj2, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t, obj, obj2, interfaceC0526Fp, composer, i);
    }

    @Composable
    public static final <T> State<T> produceState(T t, Object obj, Object obj2, Object obj3, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState(t, obj, obj2, obj3, interfaceC0526Fp, composer, i);
    }

    @Composable
    public static final <T> State<T> produceState(T t, Object[] objArr, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        return SnapshotStateKt__ProduceStateKt.produceState((Object) t, objArr, interfaceC0526Fp, composer, i);
    }
}
