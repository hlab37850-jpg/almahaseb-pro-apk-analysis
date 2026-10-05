package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* JADX INFO: renamed from: ke, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3244ke implements ComponentFactory {
    public final Object a;

    public C3244ke(Object obj) {
        this.a = obj;
    }

    public static ComponentFactory a(Object obj) {
        return new C3244ke(obj);
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return Component.lambda$of$0(this.a, componentContainer);
    }
}
