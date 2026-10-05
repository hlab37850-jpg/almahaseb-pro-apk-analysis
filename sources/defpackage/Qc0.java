package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public final class Qc0 implements InterfaceC1889cd0 {
    public final InterfaceC1889cd0[] a;

    public Qc0(InterfaceC1889cd0... interfaceC1889cd0Arr) {
        this.a = interfaceC1889cd0Arr;
    }

    @Override // defpackage.InterfaceC1889cd0
    public final boolean a(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.a[i].a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.InterfaceC1889cd0
    public final InterfaceC1242ad0 b(Class cls) {
        for (int i = 0; i < 2; i++) {
            InterfaceC1889cd0 interfaceC1889cd0 = this.a[i];
            if (interfaceC1889cd0.a(cls)) {
                return interfaceC1889cd0.b(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
