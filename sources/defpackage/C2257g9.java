package defpackage;

import java.util.HashMap;

/* JADX INFO: renamed from: g9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C2257g9 extends AbstractC2012d9 {
    public short c;
    public short d;
    public short[] e;
    public HashMap f;

    public C2257g9(short s) {
        super((short) 6, s);
        this.f = new HashMap();
    }

    @Override // defpackage.AbstractC2012d9
    public T8 b() {
        T8 t8B = T8.b(e());
        t8B.E(c());
        t8B.E(e());
        t8B.E(d());
        t8B.E(this.c);
        t8B.E(this.d);
        int i = 0;
        while (true) {
            short[] sArr = this.e;
            if (i >= sArr.length) {
                t8B.f();
                return t8B;
            }
            t8B.E(sArr[i]);
            i++;
        }
    }

    @Override // defpackage.AbstractC2012d9
    public short e() {
        return (short) ((this.d * 2) + 10);
    }

    @Override // defpackage.AbstractC2012d9
    public char g(char c) {
        char c2 = this.c;
        if (c < c2 || c > this.d + c2) {
            return (char) 0;
        }
        return (char) this.e[c - c2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.AbstractC2012d9
    public void h(int i, T8 t8) {
        this.c = t8.p();
        int iP = t8.p();
        this.d = iP;
        this.e = new short[iP];
        int i2 = 0;
        while (true) {
            short[] sArr = this.e;
            if (i2 >= sArr.length) {
                return;
            }
            sArr[i2] = t8.p();
            this.f.put(new Short(this.e[i2]), new Short((short) (this.c + i2)));
            i2++;
        }
    }
}
