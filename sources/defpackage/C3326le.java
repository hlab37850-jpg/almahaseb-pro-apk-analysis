package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* JADX INFO: renamed from: le, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3326le implements ComponentFactory {
    public final Object a;

    public C3326le(Object obj) {
        this.a = obj;
    }

    public static ComponentFactory a(Object obj) {
        return new C3326le(obj);
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return Component.lambda$of$1(this.a, componentContainer);
    }
}
