package info.aalmoghalis.inventory.activity;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

/* JADX INFO: loaded from: classes3.dex */
public class FragmentStatePagerSupport_Main_LifecycleAdapter implements GeneratedAdapter {
    public final FragmentStatePagerSupport_Main a;

    public FragmentStatePagerSupport_Main_LifecycleAdapter(FragmentStatePagerSupport_Main fragmentStatePagerSupport_Main) {
        this.a = fragmentStatePagerSupport_Main;
    }

    @Override // androidx.lifecycle.GeneratedAdapter
    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (z) {
            return;
        }
        if (event == Lifecycle.Event.ON_RESUME) {
            if (!z2 || methodCallsLogger.approveCall("onResume", 1)) {
                this.a.onResume();
                return;
            }
            return;
        }
        if (event == Lifecycle.Event.ON_PAUSE) {
            if (!z2 || methodCallsLogger.approveCall("onPause", 1)) {
                this.a.onPause();
            }
        }
    }
}
