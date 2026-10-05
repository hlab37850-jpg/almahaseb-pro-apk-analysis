package defpackage;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: s10, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3845s10 extends LifecycleCallback {
    public List a;

    public C3845s10(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.a = new ArrayList();
        this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }

    public static /* bridge */ /* synthetic */ C3845s10 a(Activity activity) {
        C3845s10 c3845s10;
        synchronized (activity) {
            try {
                LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
                c3845s10 = (C3845s10) fragment.getCallbackOrNull("LifecycleObserverOnStop", C3845s10.class);
                if (c3845s10 == null) {
                    c3845s10 = new C3845s10(fragment);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c3845s10;
    }

    public final synchronized void c(Runnable runnable) {
        this.a.add(runnable);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        List list;
        synchronized (this) {
            list = this.a;
            this.a = new ArrayList();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }
}
