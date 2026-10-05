package defpackage;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;

/* JADX INFO: renamed from: v20, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4090v20 implements InterfaceC4252x20 {
    public final /* synthetic */ DeferredLifecycleHelper a;

    public C4090v20(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.a = deferredLifecycleHelper;
    }

    @Override // defpackage.InterfaceC4252x20
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.a.zaa.onResume();
    }

    @Override // defpackage.InterfaceC4252x20
    public final int zaa() {
        return 5;
    }
}
