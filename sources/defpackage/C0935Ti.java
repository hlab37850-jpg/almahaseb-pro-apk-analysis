package defpackage;

/* JADX INFO: renamed from: Ti, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0935Ti extends AbstractC3775r7 {
    public final InterfaceC3866sE a;
    public Object b;

    public C0935Ti(InterfaceC3866sE interfaceC3866sE) {
        this.a = interfaceC3866sE;
    }

    @Override // defpackage.InterfaceC1865cJ
    public final int c(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    @Override // defpackage.InterfaceC4283xQ
    public final void clear() {
        lazySet(32);
        this.b = null;
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        set(4);
        this.b = null;
    }

    public final void e(Object obj) {
        int i = get();
        if ((i & 54) != 0) {
            return;
        }
        InterfaceC3866sE interfaceC3866sE = this.a;
        if (i == 8) {
            this.b = obj;
            lazySet(16);
            interfaceC3866sE.b(null);
        } else {
            lazySet(2);
            interfaceC3866sE.b(obj);
        }
        if (get() != 4) {
            interfaceC3866sE.onComplete();
        }
    }

    @Override // defpackage.InterfaceC0624Jj
    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // defpackage.InterfaceC4283xQ
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // defpackage.InterfaceC4283xQ
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        Object obj = this.b;
        this.b = null;
        lazySet(32);
        return obj;
    }
}
