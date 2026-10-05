package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: Ya, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1077Ya extends G implements InterfaceC1009Wa {
    public final InterfaceC1009Wa c;

    public AbstractC1077Ya(InterfaceC0988Vf interfaceC0988Vf, InterfaceC1009Wa interfaceC1009Wa, boolean z, boolean z2) {
        super(interfaceC0988Vf, z, z2);
        this.c = interfaceC1009Wa;
    }

    @Override // defpackage.C3674pu
    public void G(Throwable th) {
        CancellationException cancellationExceptionW0 = C3674pu.w0(this, th, null, 1, null);
        this.c.cancel(cancellationExceptionW0);
        D(cancellationExceptionW0);
    }

    public final InterfaceC1009Wa I0() {
        return this.c;
    }

    @Override // defpackage.IJ
    public Object b(InterfaceC0793Of interfaceC0793Of) {
        Object objB = this.c.b(interfaceC0793Of);
        AbstractC0378Bt.d();
        return objB;
    }

    @Override // defpackage.C3674pu, defpackage.InterfaceC1830bu
    public final void cancel(CancellationException cancellationException) {
        if (a0()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new C1987cu(J(), null, this);
        }
        G(cancellationException);
    }

    @Override // defpackage.InterfaceC4038uO
    public boolean close(Throwable th) {
        return this.c.close(th);
    }

    @Override // defpackage.IJ
    public Object d() {
        return this.c.d();
    }

    @Override // defpackage.IJ
    public Object f(InterfaceC0793Of interfaceC0793Of) {
        return this.c.f(interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC4038uO
    public InterfaceC3552oO getOnSend() {
        return this.c.getOnSend();
    }

    @Override // defpackage.InterfaceC4038uO
    public void invokeOnClose(InterfaceC3750qp interfaceC3750qp) {
        this.c.invokeOnClose(interfaceC3750qp);
    }

    @Override // defpackage.InterfaceC4038uO
    public boolean isClosedForSend() {
        return this.c.isClosedForSend();
    }

    @Override // defpackage.IJ
    public InterfaceC2205fb iterator() {
        return this.c.iterator();
    }

    @Override // defpackage.InterfaceC4038uO
    public boolean offer(Object obj) {
        return this.c.offer(obj);
    }

    @Override // defpackage.InterfaceC4038uO
    public Object send(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return this.c.send(obj, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC4038uO
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo0trySendJP2dKIU(Object obj) {
        return this.c.mo0trySendJP2dKIU(obj);
    }

    public final InterfaceC1009Wa H0() {
        return this;
    }
}
