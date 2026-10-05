package defpackage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.datatransport.TransportRegistrar;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class AV implements ComponentFactory {
    public static final AV a = new AV();

    public static ComponentFactory a() {
        return a;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return TransportRegistrar.lambda$getComponents$0(componentContainer);
    }
}
