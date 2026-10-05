package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleOwner;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC1830bu;

/* JADX INFO: loaded from: classes2.dex */
@MainThread
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State state, DispatchQueue dispatchQueue, final InterfaceC1830bu interfaceC1830bu) {
        AbstractC4492zt.h(lifecycle, "lifecycle");
        AbstractC4492zt.h(state, "minState");
        AbstractC4492zt.h(dispatchQueue, "dispatchQueue");
        AbstractC4492zt.h(interfaceC1830bu, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: Bv
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LifecycleController.observer$lambda$0(this.a, interfaceC1830bu, lifecycleOwner, event);
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            lifecycle.addObserver(lifecycleEventObserver);
        } else {
            InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
            finish();
        }
    }

    private final void handleDestroy(InterfaceC1830bu interfaceC1830bu) {
        InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController lifecycleController, InterfaceC1830bu interfaceC1830bu, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        AbstractC4492zt.h(lifecycleController, "this$0");
        AbstractC4492zt.h(interfaceC1830bu, "$parentJob");
        AbstractC4492zt.h(lifecycleOwner, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(event, "<anonymous parameter 1>");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
            lifecycleController.finish();
        } else if (lifecycleOwner.getLifecycle().getCurrentState().compareTo(lifecycleController.minState) < 0) {
            lifecycleController.dispatchQueue.pause();
        } else {
            lifecycleController.dispatchQueue.resume();
        }
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
