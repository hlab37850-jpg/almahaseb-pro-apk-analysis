package defpackage;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;

/* JADX INFO: loaded from: classes2.dex */
public final class Z10 implements InterfaceC4252x20 {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ DeferredLifecycleHelper b;

    public Z10(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.b = deferredLifecycleHelper;
        this.a = bundle;
    }

    @Override // defpackage.InterfaceC4252x20
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.b.zaa.onCreate(this.a);
    }

    @Override // defpackage.InterfaceC4252x20
    public final int zaa() {
        return 1;
    }
}
