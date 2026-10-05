package androidx.compose.runtime;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ComposerImpl$startProviders$currentProviders$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ PersistentCompositionLocalMap $parentScope;
    final /* synthetic */ ProvidedValue<?>[] $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerImpl$startProviders$currentProviders$1(ProvidedValue<?>[] providedValueArr, PersistentCompositionLocalMap persistentCompositionLocalMap) {
        super(2);
        this.$values = providedValueArr;
        this.$parentScope = persistentCompositionLocalMap;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return invoke((Composer) obj, ((Number) obj2).intValue());
    }

    @Composable
    public final PersistentCompositionLocalMap invoke(Composer composer, int i) {
        composer.startReplaceableGroup(-948105361);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-948105361, i, -1, "androidx.compose.runtime.ComposerImpl.startProviders.<anonymous> (Composer.kt:1994)");
        }
        PersistentCompositionLocalMap persistentCompositionLocalMapCompositionLocalMapOf = CompositionLocalMapKt.compositionLocalMapOf(this.$values, this.$parentScope, composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return persistentCompositionLocalMapCompositionLocalMapOf;
    }
}
