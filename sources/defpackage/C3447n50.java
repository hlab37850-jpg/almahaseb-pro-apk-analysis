package defpackage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.Registrar;

/* JADX INFO: renamed from: n50, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3447n50 implements ComponentFactory {
    public static final ComponentFactory a = new C3447n50();

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        return new Registrar.a((FirebaseInstanceId) componentContainer.get(FirebaseInstanceId.class));
    }
}
