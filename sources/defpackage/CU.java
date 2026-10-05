package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class CU {
    public final InterfaceC0988Vf a;
    public final Object[] b;
    public final InterfaceC4287xU[] c;
    public int d;

    public CU(InterfaceC0988Vf interfaceC0988Vf, int i) {
        this.a = interfaceC0988Vf;
        this.b = new Object[i];
        this.c = new InterfaceC4287xU[i];
    }

    public final void a(InterfaceC4287xU interfaceC4287xU, Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        objArr[i] = obj;
        InterfaceC4287xU[] interfaceC4287xUArr = this.c;
        this.d = i + 1;
        interfaceC4287xUArr[i] = interfaceC4287xU;
    }

    public final void b(InterfaceC0988Vf interfaceC0988Vf) {
        int length = this.c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            InterfaceC4287xU interfaceC4287xU = this.c[length];
            AbstractC4492zt.e(interfaceC4287xU);
            interfaceC4287xU.restoreThreadContext(interfaceC0988Vf, this.b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }
}
