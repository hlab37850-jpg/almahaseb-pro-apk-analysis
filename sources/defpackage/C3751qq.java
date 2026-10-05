package defpackage;

/* JADX INFO: renamed from: qq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3751qq extends FV {
    public Object[] c;
    public C2152ew d;

    public C3751qq(EV ev) {
        super(1735162214);
        this.d = (C2152ew) ev.h("loca");
        this.c = new Object[((C2015dB) ev.h("maxp")).u()];
    }

    @Override // defpackage.FV
    public T8 b() {
        T8 t8B = T8.b(h());
        int i = 0;
        while (true) {
            Object[] objArr = this.c;
            if (i >= objArr.length) {
                t8B.f();
                return t8B;
            }
            Object obj = objArr[i];
            if (obj != null) {
                T8 t8A = obj instanceof T8 ? (T8) obj : ((C3507nq) obj).a();
                t8A.H();
                t8B.y(t8A);
                t8A.f();
            }
            i++;
        }
    }

    @Override // defpackage.FV
    public void d(T8 t8) {
        for (int i = 0; i < this.c.length; i++) {
            int iH = this.d.h(i);
            int i2 = this.d.i(i);
            if (i2 != 0) {
                t8.w(iH);
                T8 t8I = t8.I();
                t8I.t(i2);
                this.c[i] = t8I;
            }
        }
    }

    public C3507nq g(int i) {
        Object obj = this.c[i];
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof T8)) {
            return (C3507nq) obj;
        }
        C3507nq c3507nqB = C3507nq.b((T8) obj);
        this.c[i] = c3507nqB;
        return c3507nqB;
    }

    public int h() {
        int i = 0;
        int iF = 0;
        while (true) {
            Object[] objArr = this.c;
            if (i >= objArr.length) {
                return iF;
            }
            Object obj = objArr[i];
            if (obj != null) {
                iF += obj instanceof T8 ? ((T8) obj).F() : ((C3507nq) obj).c();
            }
            i++;
        }
    }

    @Override // defpackage.FV
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("    Glyf Table: (" + this.c.length + " glyphs)\n");
        StringBuilder sb = new StringBuilder("    ");
        sb.append("  Glyf 0: ");
        sb.append(g(0));
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }
}
