package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: vj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4148vj extends ON {
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(C4148vj.class, "_decision");
    private volatile /* synthetic */ int _decision;

    public C4148vj(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0793Of interfaceC0793Of) {
        super(interfaceC0988Vf, interfaceC0793Of);
        this._decision = 0;
    }

    @Override // defpackage.ON, defpackage.G
    public void D0(Object obj) {
        if (J0()) {
            return;
        }
        AbstractC4067uj.c(AbstractC0352At.c(this.c), AbstractC2457ie.a(obj, this.c), null, 2, null);
    }

    public final Object I0() {
        if (K0()) {
            return AbstractC0378Bt.d();
        }
        Object objH = AbstractC3755qu.h(W());
        if (objH instanceof C2129ee) {
            throw ((C2129ee) objH).a;
        }
        return objH;
    }

    public final boolean J0() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!d.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean K0() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!d.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // defpackage.ON, defpackage.C3674pu
    public void w(Object obj) {
        D0(obj);
    }
}
