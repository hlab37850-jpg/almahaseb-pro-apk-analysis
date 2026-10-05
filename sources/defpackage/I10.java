package defpackage;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;

/* JADX INFO: loaded from: classes2.dex */
public final class I10 implements InterfaceC4252x20 {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ Bundle c;
    public final /* synthetic */ DeferredLifecycleHelper d;

    public I10(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.d = deferredLifecycleHelper;
        this.a = activity;
        this.b = bundle;
        this.c = bundle2;
    }

    @Override // defpackage.InterfaceC4252x20
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.d.zaa.onInflate(this.a, this.b, this.c);
    }

    @Override // defpackage.InterfaceC4252x20
    public final int zaa() {
        return 0;
    }
}
