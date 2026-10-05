package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: Gt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0556Gt extends AbstractC2068du {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(C0556Gt.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;
    public final InterfaceC3750qp e;

    public C0556Gt(InterfaceC3750qp interfaceC3750qp) {
        this.e = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        x((Throwable) obj);
        return FW.a;
    }

    @Override // defpackage.AbstractC2293ge
    public void x(Throwable th) {
        if (f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }
}
