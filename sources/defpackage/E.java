package defpackage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class E implements ComponentContainer {
    @Override // com.google.firebase.components.ComponentContainer
    public Object get(Class cls) {
        Provider provider = getProvider(cls);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    @Override // com.google.firebase.components.ComponentContainer
    public Set setOf(Class cls) {
        return (Set) setOfProvider(cls).get();
    }
}
