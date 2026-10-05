package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SaveableStateHolderImpl$SaveableStateProvider$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Object $key;
    final /* synthetic */ SaveableStateHolderImpl.RegistryHolder $registryHolder;
    final /* synthetic */ SaveableStateHolderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveableStateHolderImpl$SaveableStateProvider$1$1(SaveableStateHolderImpl saveableStateHolderImpl, Object obj, SaveableStateHolderImpl.RegistryHolder registryHolder) {
        super(1);
        this.this$0 = saveableStateHolderImpl;
        this.$key = obj;
        this.$registryHolder = registryHolder;
    }

    @Override // defpackage.InterfaceC3750qp
    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
        boolean zContainsKey = this.this$0.registryHolders.containsKey(this.$key);
        Object obj = this.$key;
        if (zContainsKey) {
            throw new IllegalArgumentException(("Key " + obj + " was used multiple times ").toString());
        }
        this.this$0.savedStates.remove(this.$key);
        this.this$0.registryHolders.put(this.$key, this.$registryHolder);
        final SaveableStateHolderImpl.RegistryHolder registryHolder = this.$registryHolder;
        final SaveableStateHolderImpl saveableStateHolderImpl = this.this$0;
        final Object obj2 = this.$key;
        return new DisposableEffectResult() { // from class: androidx.compose.runtime.saveable.SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                registryHolder.saveTo(saveableStateHolderImpl.savedStates);
                saveableStateHolderImpl.registryHolders.remove(obj2);
            }
        };
    }
}
