package defpackage;

/* JADX INFO: renamed from: nq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3507nq {
    public short a;
    public short b;
    public short c;
    public short d;
    public short e;

    public static C3507nq b(T8 t8) {
        C3507nq c3670pq;
        short sP = t8.p();
        if (sP == 0) {
            c3670pq = new C3507nq();
        } else if (sP == -1) {
            c3670pq = new C3589oq();
        } else {
            if (sP <= 0) {
                throw new IllegalArgumentException("Unknown glyf type: " + ((int) sP));
            }
            c3670pq = new C3670pq();
        }
        c3670pq.n(sP);
        c3670pq.l(t8.p());
        c3670pq.m(t8.p());
        c3670pq.j(t8.p());
        c3670pq.k(t8.p());
        c3670pq.i(t8);
        return c3670pq;
    }

    public T8 a() {
        T8 t8B = T8.b(c());
        t8B.E(h());
        t8B.E(f());
        t8B.E(g());
        t8B.E(d());
        t8B.E(e());
        return t8B;
    }

    public short c() {
        return (short) 10;
    }

    public short d() {
        return this.d;
    }

    public short e() {
        return this.e;
    }

    public short f() {
        return this.b;
    }

    public short g() {
        return this.c;
    }

    public short h() {
        return this.a;
    }

    public void j(short s) {
        this.d = s;
    }

    public void k(short s) {
        this.e = s;
    }

    public void l(short s) {
        this.b = s;
    }

    public void m(short s) {
        this.c = s;
    }

    public void n(short s) {
        this.a = s;
    }

    public void i(T8 t8) {
    }
}
