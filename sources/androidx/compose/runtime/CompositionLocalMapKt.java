package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class CompositionLocalMapKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.runtime.PersistentCompositionLocalMap] */
    @Composable
    public static final PersistentCompositionLocalMap compositionLocalMapOf(ProvidedValue<?>[] providedValueArr, PersistentCompositionLocalMap persistentCompositionLocalMap, Composer composer, int i) {
        AbstractC4492zt.h(providedValueArr, "values");
        AbstractC4492zt.h(persistentCompositionLocalMap, "parentScope");
        composer.startReplaceableGroup(-300354947);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-300354947, i, -1, "androidx.compose.runtime.compositionLocalMapOf (CompositionLocalMap.kt:91)");
        }
        PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builderBuilder2 = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf().builder2();
        for (ProvidedValue<?> providedValue : providedValueArr) {
            composer.startReplaceableGroup(680845765);
            if (providedValue.getCanOverride() || !contains(persistentCompositionLocalMap, providedValue.getCompositionLocal())) {
                CompositionLocal<?> compositionLocal = providedValue.getCompositionLocal();
                AbstractC4492zt.f(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
                builderBuilder2.put(compositionLocal, providedValue.getCompositionLocal().provided$runtime_release(providedValue.getValue(), composer, 8));
            }
            composer.endReplaceableGroup();
        }
        ?? Build2 = builderBuilder2.build2();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return Build2;
    }

    public static final <T> boolean contains(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal<T> compositionLocal) {
        AbstractC4492zt.h(persistentCompositionLocalMap, "<this>");
        AbstractC4492zt.h(compositionLocal, "key");
        return persistentCompositionLocalMap.containsKey(compositionLocal);
    }

    public static final <T> T getValueOf(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal<T> compositionLocal) {
        AbstractC4492zt.h(persistentCompositionLocalMap, "<this>");
        AbstractC4492zt.h(compositionLocal, "key");
        State<? extends Object> state = persistentCompositionLocalMap.get((Object) compositionLocal);
        if (state != null) {
            return (T) state.getValue();
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.runtime.PersistentCompositionLocalMap] */
    public static final PersistentCompositionLocalMap mutate(PersistentCompositionLocalMap persistentCompositionLocalMap, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(persistentCompositionLocalMap, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "mutator");
        PersistentMap.Builder<CompositionLocal<Object>, State<? extends Object>> builderBuilder2 = persistentCompositionLocalMap.builder2();
        interfaceC3750qp.invoke(builderBuilder2);
        return builderBuilder2.build2();
    }

    public static final <T> T read(PersistentCompositionLocalMap persistentCompositionLocalMap, CompositionLocal<T> compositionLocal) {
        AbstractC4492zt.h(persistentCompositionLocalMap, "<this>");
        AbstractC4492zt.h(compositionLocal, "key");
        return contains(persistentCompositionLocalMap, compositionLocal) ? (T) getValueOf(persistentCompositionLocalMap, compositionLocal) : compositionLocal.getDefaultValueHolder$runtime_release().getValue();
    }
}
