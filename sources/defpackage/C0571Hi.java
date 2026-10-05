package defpackage;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;

/* JADX INFO: renamed from: Hi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0571Hi implements ComponentFactory {
    public static final C0571Hi a = new C0571Hi();

    public static ComponentFactory a() {
        return a;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return DefaultHeartBeatInfo.lambda$component$0(componentContainer);
    }
}
