package androidx.databinding;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC1830bu;
import defpackage.O8;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ViewDataBindingKtx {
    public static final ViewDataBindingKtx INSTANCE = new ViewDataBindingKtx();
    private static final CreateWeakListener CREATE_STATE_FLOW_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.a
        @Override // androidx.databinding.CreateWeakListener
        public final WeakListener create(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
            return ViewDataBindingKtx.CREATE_STATE_FLOW_LISTENER$lambda$0(viewDataBinding, i, referenceQueue);
        }
    };

    public static final class StateFlowListener implements ObservableReference<InterfaceC0939Tm> {
        private WeakReference<LifecycleOwner> _lifecycleOwnerRef;
        private final WeakListener<InterfaceC0939Tm> listener;
        private InterfaceC1830bu observerJob;

        public StateFlowListener(ViewDataBinding viewDataBinding, int i, ReferenceQueue<ViewDataBinding> referenceQueue) {
            AbstractC4492zt.h(referenceQueue, "referenceQueue");
            this.listener = new WeakListener<>(viewDataBinding, i, this, referenceQueue);
        }

        private final void startCollection(LifecycleOwner lifecycleOwner, InterfaceC0939Tm interfaceC0939Tm) {
            InterfaceC1830bu interfaceC1830bu = this.observerJob;
            if (interfaceC1830bu != null) {
                InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
            }
            this.observerJob = O8.d(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new ViewDataBindingKtx$StateFlowListener$startCollection$1(lifecycleOwner, interfaceC0939Tm, this, null), 3, null);
        }

        @Override // androidx.databinding.ObservableReference
        public WeakListener<InterfaceC0939Tm> getListener() {
            return this.listener;
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if ((weakReference != null ? weakReference.get() : null) == lifecycleOwner) {
                return;
            }
            InterfaceC1830bu interfaceC1830bu = this.observerJob;
            if (interfaceC1830bu != null) {
                InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
            }
            if (lifecycleOwner == null) {
                this._lifecycleOwnerRef = null;
                return;
            }
            this._lifecycleOwnerRef = new WeakReference<>(lifecycleOwner);
            InterfaceC0939Tm target = this.listener.getTarget();
            if (target != null) {
                startCollection(lifecycleOwner, target);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(InterfaceC0939Tm interfaceC0939Tm) {
            LifecycleOwner lifecycleOwner;
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if (weakReference == null || (lifecycleOwner = weakReference.get()) == null || interfaceC0939Tm == null) {
                return;
            }
            startCollection(lifecycleOwner, interfaceC0939Tm);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(InterfaceC0939Tm interfaceC0939Tm) {
            InterfaceC1830bu interfaceC1830bu = this.observerJob;
            if (interfaceC1830bu != null) {
                InterfaceC1830bu.a.a(interfaceC1830bu, null, 1, null);
            }
            this.observerJob = null;
        }
    }

    private ViewDataBindingKtx() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WeakListener CREATE_STATE_FLOW_LISTENER$lambda$0(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
        AbstractC4492zt.e(referenceQueue);
        return new StateFlowListener(viewDataBinding, i, referenceQueue).getListener();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean updateStateFlowRegistration(ViewDataBinding viewDataBinding, int i, InterfaceC0939Tm interfaceC0939Tm) {
        AbstractC4492zt.h(viewDataBinding, "viewDataBinding");
        viewDataBinding.mInStateFlowRegisterObserver = true;
        try {
            return viewDataBinding.updateRegistration(i, interfaceC0939Tm, CREATE_STATE_FLOW_LISTENER);
        } finally {
            viewDataBinding.mInStateFlowRegisterObserver = false;
        }
    }
}
