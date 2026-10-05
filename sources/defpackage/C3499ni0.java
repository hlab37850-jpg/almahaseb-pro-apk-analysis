package defpackage;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: ni0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3499ni0 extends LifecycleCallback {
    public final List a;

    public C3499ni0(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.a = new ArrayList();
        this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }

    public static C3499ni0 a(Activity activity) {
        C3499ni0 c3499ni0;
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        synchronized (fragment) {
            try {
                c3499ni0 = (C3499ni0) fragment.getCallbackOrNull("TaskOnStopCallback", C3499ni0.class);
                if (c3499ni0 == null) {
                    c3499ni0 = new C3499ni0(fragment);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c3499ni0;
    }

    public final void b(Bh0 bh0) {
        synchronized (this.a) {
            this.a.add(new WeakReference(bh0));
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        synchronized (this.a) {
            try {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    Bh0 bh0 = (Bh0) ((WeakReference) it.next()).get();
                    if (bh0 != null) {
                        bh0.zzc();
                    }
                }
                this.a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
