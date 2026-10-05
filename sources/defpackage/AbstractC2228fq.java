package defpackage;

import com.fasterxml.jackson.core.a;

/* JADX INFO: renamed from: fq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2228fq extends a {
    public int b;
    public boolean e;
    public C0531Fu d = C0531Fu.j();
    public boolean c = S(a.EnumC0168a.WRITE_NUMBERS_AS_STRINGS);

    public AbstractC2228fq(int i, AbstractC2263gE abstractC2263gE) {
        this.b = i;
    }

    public void P() {
        throw new RuntimeException("Internal error: should never end up through this code path");
    }

    public void Q(String str) throws C4159vu {
        throw new C4159vu(str);
    }

    public final C0531Fu R() {
        return this.d;
    }

    public final boolean S(a.EnumC0168a enumC0168a) {
        return (enumC0168a.c() & this.b) != 0;
    }

    @Override // com.fasterxml.jackson.core.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e = true;
    }

    @Override // com.fasterxml.jackson.core.a
    public a g() {
        return c() != null ? this : d(new C0693Ki());
    }
}
