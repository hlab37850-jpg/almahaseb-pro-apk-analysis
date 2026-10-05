package defpackage;

/* JADX INFO: renamed from: nc0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3487nc0 implements InterfaceC4298xc0 {
    public final InterfaceC4298xc0[] a;

    public C3487nc0(InterfaceC4298xc0... interfaceC4298xc0Arr) {
        this.a = interfaceC4298xc0Arr;
    }

    @Override // defpackage.InterfaceC4298xc0
    public final boolean a(Class cls) {
        InterfaceC4298xc0[] interfaceC4298xc0Arr = this.a;
        for (int i = 0; i < 2; i++) {
            if (interfaceC4298xc0Arr[i].a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.InterfaceC4298xc0
    public final InterfaceC4217wc0 b(Class cls) {
        InterfaceC4298xc0[] interfaceC4298xc0Arr = this.a;
        for (int i = 0; i < 2; i++) {
            InterfaceC4298xc0 interfaceC4298xc0 = interfaceC4298xc0Arr[i];
            if (interfaceC4298xc0.a(cls)) {
                return interfaceC4298xc0.b(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
