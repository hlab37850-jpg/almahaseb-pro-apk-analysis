package defpackage;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* JADX INFO: renamed from: ye, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4382ye implements Provider {
    public final Set a;

    public C4382ye(Set set) {
        this.a = set;
    }

    public static Provider a(Set set) {
        return new C4382ye(set);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return ComponentRuntime.lambda$processSetComponents$1(this.a);
    }
}
