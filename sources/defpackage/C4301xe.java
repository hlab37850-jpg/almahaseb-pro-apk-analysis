package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

/* JADX INFO: renamed from: xe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4301xe implements Provider {
    public final ComponentRuntime a;
    public final Component b;

    public C4301xe(ComponentRuntime componentRuntime, Component component) {
        this.a = componentRuntime;
        this.b = component;
    }

    public static Provider a(ComponentRuntime componentRuntime, Component component) {
        return new C4301xe(componentRuntime, component);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        ComponentRuntime componentRuntime = this.a;
        Component component = this.b;
        return component.getFactory().create(new HL(component, componentRuntime));
    }
}
