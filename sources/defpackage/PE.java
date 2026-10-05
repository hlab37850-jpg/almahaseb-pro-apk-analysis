package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PE {
    public abstract Y5 a();

    public final boolean b(PE pe) {
        Y5 y5A;
        Y5 y5A2 = a();
        return (y5A2 == null || (y5A = pe.a()) == null || y5A2.f() >= y5A.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return AbstractC3498ni.a(this) + '@' + AbstractC3498ni.b(this);
    }
}
