package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3566ob;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class RememberSaveableKt {
    private static final int MaxSupportedRadix = 36;

    /* JADX INFO: renamed from: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ String $finalKey;
        final /* synthetic */ SaveableStateRegistry $registry;
        final /* synthetic */ State<Saver<T, Object>> $saverState;
        final /* synthetic */ State<T> $valueState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(SaveableStateRegistry saveableStateRegistry, String str, State<? extends Saver<T, Object>> state, State<? extends T> state2) {
            super(1);
            this.$registry = saveableStateRegistry;
            this.$finalKey = str;
            this.$saverState = state;
            this.$valueState = state2;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            RememberSaveableKt$rememberSaveable$1$valueProvider$1 rememberSaveableKt$rememberSaveable$1$valueProvider$1 = new RememberSaveableKt$rememberSaveable$1$valueProvider$1(this.$saverState, this.$valueState, this.$registry);
            RememberSaveableKt.requireCanBeSaved(this.$registry, rememberSaveableKt$rememberSaveable$1$valueProvider$1.invoke());
            final SaveableStateRegistry.Entry entryRegisterProvider = this.$registry.registerProvider(this.$finalKey, rememberSaveableKt$rememberSaveable$1$valueProvider$1);
            return new DisposableEffectResult() { // from class: androidx.compose.runtime.saveable.RememberSaveableKt$rememberSaveable$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    entryRegisterProvider.unregister();
                }
            };
        }
    }

    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(Saver<T, ? extends Object> saver) {
        AbstractC4492zt.f(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        return SaverKt.Saver(new RememberSaveableKt$mutableStateSaver$1$1(saver), new RememberSaveableKt$mutableStateSaver$1$2(saver));
    }

    @Composable
    /* JADX INFO: renamed from: rememberSaveable, reason: collision with other method in class */
    public static final <T> T m2674rememberSaveable(Object[] objArr, Saver<T, ? extends Object> saver, String str, InterfaceC3588op interfaceC3588op, Composer composer, int i, int i2) {
        Object objConsumeRestored;
        AbstractC4492zt.h(objArr, "inputs");
        AbstractC4492zt.h(interfaceC3588op, "init");
        composer.startReplaceableGroup(441892779);
        if ((i2 & 2) != 0) {
            saver = SaverKt.autoSaver();
        }
        T tRestore = null;
        if ((i2 & 4) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441892779, i, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:65)");
        }
        composer.startReplaceableGroup(1059366469);
        if (str == null || str.length() == 0) {
            str = Integer.toString(ComposablesKt.getCurrentCompositeKeyHash(composer, 0), AbstractC3566ob.a(MaxSupportedRadix));
            AbstractC4492zt.g(str, "toString(this, checkRadix(radix))");
        }
        composer.endReplaceableGroup();
        AbstractC4492zt.f(saver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) composer.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (Object obj : objArrCopyOf) {
            zChanged |= composer.changed(obj);
        }
        T t = (T) composer.rememberedValue();
        if (zChanged || t == Composer.Companion.getEmpty()) {
            if (saveableStateRegistry != null && (objConsumeRestored = saveableStateRegistry.consumeRestored(str)) != null) {
                tRestore = saver.restore(objConsumeRestored);
            }
            t = tRestore == null ? (T) interfaceC3588op.invoke() : tRestore;
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        if (saveableStateRegistry != null) {
            EffectsKt.DisposableEffect(saveableStateRegistry, str, new AnonymousClass1(saveableStateRegistry, str, SnapshotStateKt.rememberUpdatedState(saver, composer, 0), SnapshotStateKt.rememberUpdatedState(t, composer, 0)), composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requireCanBeSaved(SaveableStateRegistry saveableStateRegistry, Object obj) {
        String str;
        if (obj == null || saveableStateRegistry.canBeSaved(obj)) {
            return;
        }
        if (obj instanceof SnapshotMutableState) {
            SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
            if (snapshotMutableState.getPolicy() == SnapshotStateKt.neverEqualPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.structuralEqualityPolicy() || snapshotMutableState.getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
                str = "MutableState containing " + snapshotMutableState.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
            } else {
                str = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
            }
        } else {
            str = obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
        }
        throw new IllegalArgumentException(str);
    }

    @Composable
    public static final <T> MutableState<T> rememberSaveable(Object[] objArr, Saver<T, ? extends Object> saver, String str, InterfaceC3588op interfaceC3588op, Composer composer, int i, int i2) {
        AbstractC4492zt.h(objArr, "inputs");
        AbstractC4492zt.h(saver, "stateSaver");
        AbstractC4492zt.h(interfaceC3588op, "init");
        composer.startReplaceableGroup(-202053668);
        if ((i2 & 4) != 0) {
            str = null;
        }
        String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-202053668, i, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:136)");
        }
        MutableState<T> mutableState = (MutableState) m2674rememberSaveable(Arrays.copyOf(objArr, objArr.length), mutableStateSaver(saver), str2, interfaceC3588op, composer, (i & 896) | 8 | (i & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutableState;
    }
}
