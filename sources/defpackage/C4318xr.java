package defpackage;

import java.util.Arrays;

/* JADX INFO: renamed from: xr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4318xr extends FV {
    public short[] c;
    public short[] d;

    public C4318xr(EV ev) {
        super(1752003704);
        int iU = ((C2015dB) ev.h("maxp")).u();
        this.c = new short[((C4237wr) ev.h("hhea")).r()];
        this.d = new short[iU];
    }

    @Override // defpackage.FV
    public T8 b() {
        T8 t8B = T8.b(h());
        for (int i = 0; i < this.d.length; i++) {
            short[] sArr = this.c;
            if (i < sArr.length) {
                t8B.E(sArr[i]);
            }
            t8B.E(this.d[i]);
        }
        t8B.f();
        return t8B;
    }

    @Override // defpackage.FV
    public void d(T8 t8) {
        int i = 0;
        while (i < this.d.length && t8.r()) {
            short[] sArr = this.c;
            if (i < sArr.length) {
                sArr[i] = t8.p();
            }
            this.d[i] = t8.p();
            i++;
        }
        short[] sArr2 = this.c;
        if (i < sArr2.length) {
            Arrays.fill(sArr2, i, sArr2.length - 1, (short) 0);
        }
        short[] sArr3 = this.d;
        if (i < sArr3.length) {
            Arrays.fill(sArr3, i, sArr3.length - 1, (short) 0);
        }
    }

    public short g(int i) {
        short[] sArr = this.c;
        return i < sArr.length ? sArr[i] : sArr[sArr.length - 1];
    }

    public int h() {
        return (this.c.length * 2) + (this.d.length * 2);
    }
}
