package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public final class Of0 implements Uf0 {
    public Uf0[] a;

    public Of0(Uf0... uf0Arr) {
        this.a = uf0Arr;
    }

    @Override // defpackage.Uf0
    public final boolean a(Class cls) {
        for (Uf0 uf0 : this.a) {
            if (uf0.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.Uf0
    public final Sf0 b(Class cls) {
        for (Uf0 uf0 : this.a) {
            if (uf0.a(cls)) {
                return uf0.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
