package androidx.compose.runtime.saveable;

import defpackage.AbstractC1886cc;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class SaveableStateRegistryImpl implements SaveableStateRegistry {
    private final InterfaceC3750qp canBeSaved;
    private final Map<String, List<Object>> restored;
    private final Map<String, List<InterfaceC3588op>> valueProviders;

    public SaveableStateRegistryImpl(Map<String, ? extends List<? extends Object>> map, InterfaceC3750qp interfaceC3750qp) {
        Map<String, List<Object>> mapV;
        AbstractC4492zt.h(interfaceC3750qp, "canBeSaved");
        this.canBeSaved = interfaceC3750qp;
        this.restored = (map == null || (mapV = AbstractC4243wx.v(map)) == null) ? new LinkedHashMap<>() : mapV;
        this.valueProviders = new LinkedHashMap();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(Object obj) {
        AbstractC4492zt.h(obj, "value");
        return ((Boolean) this.canBeSaved.invoke(obj)).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object consumeRestored(String str) {
        AbstractC4492zt.h(str, "key");
        List<Object> listRemove = this.restored.remove(str);
        if (listRemove == null || listRemove.isEmpty()) {
            return null;
        }
        if (listRemove.size() > 1) {
            this.restored.put(str, listRemove.subList(1, listRemove.size()));
        }
        return listRemove.get(0);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Map<String, List<Object>> performSave() {
        Map<String, List<Object>> mapV = AbstractC4243wx.v(this.restored);
        for (Map.Entry<String, List<InterfaceC3588op>> entry : this.valueProviders.entrySet()) {
            String key = entry.getKey();
            List<InterfaceC3588op> value = entry.getValue();
            if (value.size() == 1) {
                Object objInvoke = value.get(0).invoke();
                if (objInvoke == null) {
                    continue;
                } else {
                    if (!canBeSaved(objInvoke)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    mapV.put(key, AbstractC1886cc.g(objInvoke));
                }
            } else {
                int size = value.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    Object objInvoke2 = value.get(i).invoke();
                    if (objInvoke2 != null && !canBeSaved(objInvoke2)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    arrayList.add(objInvoke2);
                }
                mapV.put(key, arrayList);
            }
        }
        return mapV;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry registerProvider(final String str, final InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(str, "key");
        AbstractC4492zt.h(interfaceC3588op, "valueProvider");
        if (AbstractC3961tS.T(str)) {
            throw new IllegalArgumentException("Registered key is empty or blank");
        }
        Map<String, List<InterfaceC3588op>> map = this.valueProviders;
        List<InterfaceC3588op> arrayList = map.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(str, arrayList);
        }
        arrayList.add(interfaceC3588op);
        return new SaveableStateRegistry.Entry() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryImpl.registerProvider.3
            @Override // androidx.compose.runtime.saveable.SaveableStateRegistry.Entry
            public void unregister() {
                List list = (List) SaveableStateRegistryImpl.this.valueProviders.remove(str);
                if (list != null) {
                    list.remove(interfaceC3588op);
                }
                if (list == null || list.isEmpty()) {
                    return;
                }
                SaveableStateRegistryImpl.this.valueProviders.put(str, list);
            }
        };
    }
}
