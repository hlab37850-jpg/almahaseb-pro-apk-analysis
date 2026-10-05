package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* JADX INFO: renamed from: me, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3408me implements ComponentFactory {
    public final Object a;

    public C3408me(Object obj) {
        this.a = obj;
    }

    public static ComponentFactory a(Object obj) {
        return new C3408me(obj);
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return Component.lambda$intoSet$2(this.a, componentContainer);
    }
}
