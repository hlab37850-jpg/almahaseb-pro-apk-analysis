package androidx.compose.runtime.saveable;

import defpackage.InterfaceC3588op;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface SaveableStateRegistry {

    public interface Entry {
        void unregister();
    }

    boolean canBeSaved(Object obj);

    Object consumeRestored(String str);

    Map<String, List<Object>> performSave();

    Entry registerProvider(String str, InterfaceC3588op interfaceC3588op);
}
