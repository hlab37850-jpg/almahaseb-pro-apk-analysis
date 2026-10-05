package androidx.compose.ui.text.input;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.text.InternalTextApi;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.CD;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.O8;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@InternalTextApi
public final class PlatformTextInputPluginRegistryImpl implements PlatformTextInputPluginRegistry {
    public static final int $stable = 0;
    private final SnapshotStateMap<PlatformTextInputPlugin<?>, AdapterWithRefCount<?>> adaptersByPlugin;
    private boolean adaptersMayNeedDisposal;
    private final InterfaceC0526Fp factory;
    private PlatformTextInputPlugin<?> focusedPlugin;

    @StabilityInferred(parameters = 0)
    @InternalTextApi
    public static final class AdapterHandle<T extends PlatformTextInputAdapter> {
        public static final int $stable = 8;
        private final T adapter;
        private boolean disposed;
        private final InterfaceC3588op onDispose;

        public AdapterHandle(T t, InterfaceC3588op interfaceC3588op) {
            AbstractC4492zt.h(t, "adapter");
            AbstractC4492zt.h(interfaceC3588op, "onDispose");
            this.adapter = t;
            this.onDispose = interfaceC3588op;
        }

        public final boolean dispose() {
            if (this.disposed) {
                throw new IllegalStateException("AdapterHandle already disposed");
            }
            this.disposed = true;
            return ((Boolean) this.onDispose.invoke()).booleanValue();
        }

        public final T getAdapter() {
            return this.adapter;
        }
    }

    public final class AdapterInput implements PlatformTextInput {
        private final PlatformTextInputPlugin<?> plugin;
        final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

        public AdapterInput(PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl, PlatformTextInputPlugin<?> platformTextInputPlugin) {
            AbstractC4492zt.h(platformTextInputPlugin, "plugin");
            this.this$0 = platformTextInputPluginRegistryImpl;
            this.plugin = platformTextInputPlugin;
        }

        @Override // androidx.compose.ui.text.input.PlatformTextInput
        public void releaseInputFocus() {
            if (AbstractC4492zt.d(this.this$0.focusedPlugin, this.plugin)) {
                this.this$0.focusedPlugin = null;
            }
        }

        @Override // androidx.compose.ui.text.input.PlatformTextInput
        public void requestInputFocus() {
            this.this$0.focusedPlugin = this.plugin;
        }
    }

    public final class AdapterWithRefCount<T extends PlatformTextInputAdapter> {
        private final T adapter;
        private final MutableIntState refCount$delegate;
        final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

        public AdapterWithRefCount(PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl, T t) {
            AbstractC4492zt.h(t, "adapter");
            this.this$0 = platformTextInputPluginRegistryImpl;
            this.adapter = t;
            this.refCount$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        }

        private final int getRefCount() {
            return this.refCount$delegate.getIntValue();
        }

        private final void setRefCount(int i) {
            this.refCount$delegate.setIntValue(i);
        }

        public final boolean decrementRefCount() {
            setRefCount(getRefCount() - 1);
            if (getRefCount() >= 0) {
                if (getRefCount() != 0) {
                    return false;
                }
                this.this$0.adaptersMayNeedDisposal = true;
                return true;
            }
            throw new IllegalStateException(("AdapterWithRefCount.decrementRefCount called too many times (refCount=" + getRefCount() + ')').toString());
        }

        public final T getAdapter() {
            return this.adapter;
        }

        public final void incrementRefCount() {
            setRefCount(getRefCount() + 1);
        }

        public final boolean isRefCountZero() {
            return getRefCount() == 0;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl$getOrCreateAdapter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ AdapterWithRefCount<T> $adapterWithRefCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AdapterWithRefCount<T> adapterWithRefCount) {
            super(0);
            this.$adapterWithRefCount = adapterWithRefCount;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() {
            return Boolean.valueOf(this.$adapterWithRefCount.decrementRefCount());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl$rememberAdapter$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16661 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ AdapterHandle<T> $adapterHandle;
        final /* synthetic */ InterfaceC2052dg $scope;
        final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16661(AdapterHandle<T> adapterHandle, InterfaceC2052dg interfaceC2052dg, PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl) {
            super(1);
            this.$adapterHandle = adapterHandle;
            this.$scope = interfaceC2052dg;
            this.this$0 = platformTextInputPluginRegistryImpl;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            final AdapterHandle<T> adapterHandle = this.$adapterHandle;
            final InterfaceC2052dg interfaceC2052dg = this.$scope;
            final PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl = this.this$0;
            return new DisposableEffectResult() { // from class: androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl$rememberAdapter$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    if (adapterHandle.dispose()) {
                        O8.d(interfaceC2052dg, CD.a, null, new PlatformTextInputPluginRegistryImpl$rememberAdapter$1$1$1(platformTextInputPluginRegistryImpl, null), 2, null);
                    }
                }
            };
        }
    }

    public PlatformTextInputPluginRegistryImpl(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, "factory");
        this.factory = interfaceC0526Fp;
        this.adaptersByPlugin = SnapshotStateKt.mutableStateMapOf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposeTombstonedAdapters() {
        if (this.adaptersMayNeedDisposal) {
            this.adaptersMayNeedDisposal = false;
            Set<Map.Entry<PlatformTextInputPlugin<?>, AdapterWithRefCount<?>>> setEntrySet = this.adaptersByPlugin.entrySet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : setEntrySet) {
                if (((AdapterWithRefCount) ((Map.Entry) obj).getValue()).isRefCountZero()) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Map.Entry entry = (Map.Entry) arrayList.get(i);
                PlatformTextInputPlugin platformTextInputPlugin = (PlatformTextInputPlugin) entry.getKey();
                AdapterWithRefCount adapterWithRefCount = (AdapterWithRefCount) entry.getValue();
                if (AbstractC4492zt.d(this.focusedPlugin, platformTextInputPlugin)) {
                    this.focusedPlugin = null;
                }
                this.adaptersByPlugin.remove(platformTextInputPlugin);
                PlatformTextInputAdapter_androidKt.dispose(adapterWithRefCount.getAdapter());
            }
        }
    }

    private final <T extends PlatformTextInputAdapter> AdapterWithRefCount<T> instantiateAdapter(PlatformTextInputPlugin<T> platformTextInputPlugin) {
        Object objMo13invoke = this.factory.mo13invoke(platformTextInputPlugin, new AdapterInput(this, platformTextInputPlugin));
        AbstractC4492zt.f(objMo13invoke, "null cannot be cast to non-null type T of androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl.instantiateAdapter");
        AdapterWithRefCount<T> adapterWithRefCount = new AdapterWithRefCount<>(this, (PlatformTextInputAdapter) objMo13invoke);
        this.adaptersByPlugin.put(platformTextInputPlugin, adapterWithRefCount);
        return adapterWithRefCount;
    }

    public final PlatformTextInputAdapter getFocusedAdapter() {
        AdapterWithRefCount<?> adapterWithRefCount = this.adaptersByPlugin.get(this.focusedPlugin);
        if (adapterWithRefCount != null) {
            return adapterWithRefCount.getAdapter();
        }
        return null;
    }

    @InternalTextApi
    public final <T extends PlatformTextInputAdapter> AdapterHandle<T> getOrCreateAdapter(PlatformTextInputPlugin<T> platformTextInputPlugin) {
        AbstractC4492zt.h(platformTextInputPlugin, "plugin");
        AdapterWithRefCount<T> adapterWithRefCountInstantiateAdapter = (AdapterWithRefCount) this.adaptersByPlugin.get(platformTextInputPlugin);
        if (adapterWithRefCountInstantiateAdapter == null) {
            adapterWithRefCountInstantiateAdapter = instantiateAdapter(platformTextInputPlugin);
        }
        adapterWithRefCountInstantiateAdapter.incrementRefCount();
        return new AdapterHandle<>(adapterWithRefCountInstantiateAdapter.getAdapter(), new AnonymousClass1(adapterWithRefCountInstantiateAdapter));
    }

    @Override // androidx.compose.ui.text.input.PlatformTextInputPluginRegistry
    @Composable
    public <T extends PlatformTextInputAdapter> T rememberAdapter(PlatformTextInputPlugin<T> platformTextInputPlugin, Composer composer, int i) {
        AbstractC4492zt.h(platformTextInputPlugin, "plugin");
        composer.startReplaceableGroup(-845039128);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-845039128, i, -1, "androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl.rememberAdapter (PlatformTextInputAdapter.kt:167)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(platformTextInputPlugin);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = getOrCreateAdapter(platformTextInputPlugin);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        AdapterHandle adapterHandle = (AdapterHandle) objRememberedValue;
        composer.startReplaceableGroup(773894976);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue2 = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(adapterHandle, new C16661(adapterHandle, coroutineScope, this), composer, 8);
        T t = (T) adapterHandle.getAdapter();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return t;
    }
}
