package defpackage;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import java.util.Iterator;

/* JADX INFO: renamed from: q10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3684q10 implements OnDelegateCreatedListener {
    public final /* synthetic */ DeferredLifecycleHelper a;

    public C3684q10(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
        this.a.zaa = lifecycleDelegate;
        Iterator it = this.a.zac.iterator();
        while (it.hasNext()) {
            ((InterfaceC4252x20) it.next()).a(this.a.zaa);
        }
        this.a.zac.clear();
        this.a.zab = null;
    }
}
