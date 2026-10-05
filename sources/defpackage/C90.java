package defpackage;

/* JADX INFO: loaded from: classes2.dex */
public final class C90 implements T90 {
    public T90[] a;

    public C90(T90... t90Arr) {
        this.a = t90Arr;
    }

    @Override // defpackage.T90
    public final boolean a(Class cls) {
        for (T90 t90 : this.a) {
            if (t90.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.T90
    public final P90 b(Class cls) {
        for (T90 t90 : this.a) {
            if (t90.a(cls)) {
                return t90.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
