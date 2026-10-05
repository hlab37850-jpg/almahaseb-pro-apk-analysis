package androidx.compose.ui.platform;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class DisposableSaveableStateRegistry implements SaveableStateRegistry {
    private final /* synthetic */ SaveableStateRegistry $$delegate_0;
    private final InterfaceC3588op onDispose;

    public DisposableSaveableStateRegistry(SaveableStateRegistry saveableStateRegistry, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(saveableStateRegistry, "saveableStateRegistry");
        AbstractC4492zt.h(interfaceC3588op, "onDispose");
        this.onDispose = interfaceC3588op;
        this.$$delegate_0 = saveableStateRegistry;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(Object obj) {
        AbstractC4492zt.h(obj, "value");
        return this.$$delegate_0.canBeSaved(obj);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object consumeRestored(String str) {
        AbstractC4492zt.h(str, "key");
        return this.$$delegate_0.consumeRestored(str);
    }

    public final void dispose() {
        this.onDispose.invoke();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Map<String, List<Object>> performSave() {
        return this.$$delegate_0.performSave();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry registerProvider(String str, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(str, "key");
        AbstractC4492zt.h(interfaceC3588op, "valueProvider");
        return this.$$delegate_0.registerProvider(str, interfaceC3588op);
    }
}
