package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import defpackage.C2451ib;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC2052dg;

/* JADX INFO: loaded from: classes.dex */
final class PredictiveBackHandlerCallback extends OnBackPressedCallback {
    private InterfaceC0526Fp currentOnBack;
    private OnBackInstance onBackInstance;
    private InterfaceC2052dg onBackScope;

    public PredictiveBackHandlerCallback(boolean z, InterfaceC2052dg interfaceC2052dg, InterfaceC0526Fp interfaceC0526Fp) {
        super(z);
        this.onBackScope = interfaceC2052dg;
        this.currentOnBack = interfaceC0526Fp;
    }

    public final InterfaceC0526Fp getCurrentOnBack() {
        return this.currentOnBack;
    }

    public final InterfaceC2052dg getOnBackScope() {
        return this.onBackScope;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackCancelled() {
        super.handleOnBackCancelled();
        OnBackInstance onBackInstance = this.onBackInstance;
        if (onBackInstance != null) {
            onBackInstance.cancel();
        }
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 == null) {
            return;
        }
        onBackInstance2.setPredictiveBack(false);
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        OnBackInstance onBackInstance = this.onBackInstance;
        if (onBackInstance != null && !onBackInstance.isPredictiveBack()) {
            onBackInstance.cancel();
            this.onBackInstance = null;
        }
        if (this.onBackInstance == null) {
            this.onBackInstance = new OnBackInstance(this.onBackScope, false, this.currentOnBack, this);
        }
        OnBackInstance onBackInstance2 = this.onBackInstance;
        if (onBackInstance2 != null) {
            onBackInstance2.close();
        }
        OnBackInstance onBackInstance3 = this.onBackInstance;
        if (onBackInstance3 == null) {
            return;
        }
        onBackInstance3.setPredictiveBack(false);
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
        super.handleOnBackProgressed(backEventCompat);
        OnBackInstance onBackInstance = this.onBackInstance;
        if (onBackInstance != null) {
            C2451ib.b(onBackInstance.m9sendJP2dKIU(backEventCompat));
        }
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackStarted(BackEventCompat backEventCompat) {
        super.handleOnBackStarted(backEventCompat);
        OnBackInstance onBackInstance = this.onBackInstance;
        if (onBackInstance != null) {
            onBackInstance.cancel();
        }
        if (isEnabled()) {
            this.onBackInstance = new OnBackInstance(this.onBackScope, true, this.currentOnBack, this);
        }
    }

    public final void setCurrentOnBack(InterfaceC0526Fp interfaceC0526Fp) {
        this.currentOnBack = interfaceC0526Fp;
    }

    public final void setIsEnabled(boolean z) {
        OnBackInstance onBackInstance;
        if (!z && isEnabled() && (onBackInstance = this.onBackInstance) != null) {
            onBackInstance.cancel();
        }
        setEnabled(z);
    }

    public final void setOnBackScope(InterfaceC2052dg interfaceC2052dg) {
        this.onBackScope = interfaceC2052dg;
    }
}
