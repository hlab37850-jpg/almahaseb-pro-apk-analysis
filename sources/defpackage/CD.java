package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class CD extends H implements InterfaceC1830bu {
    public static final CD a = new CD();

    public CD() {
        super(InterfaceC1830bu.s);
    }

    @Override // defpackage.InterfaceC1830bu
    public InterfaceC4214wb A(InterfaceC4376yb interfaceC4376yb) {
        return DD.a;
    }

    @Override // defpackage.InterfaceC1830bu
    public InterfaceC0745Mj C(InterfaceC3750qp interfaceC3750qp) {
        return DD.a;
    }

    @Override // defpackage.InterfaceC1830bu
    public Object F(InterfaceC0793Of interfaceC0793Of) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // defpackage.InterfaceC1830bu
    public InterfaceC0745Mj c(boolean z, boolean z2, InterfaceC3750qp interfaceC3750qp) {
        return DD.a;
    }

    @Override // defpackage.InterfaceC1830bu
    public CancellationException i() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // defpackage.InterfaceC1830bu
    public boolean isActive() {
        return true;
    }

    @Override // defpackage.InterfaceC1830bu
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // defpackage.InterfaceC1830bu
    public void cancel(CancellationException cancellationException) {
    }
}
