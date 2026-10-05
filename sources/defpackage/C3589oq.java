package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: oq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3589oq extends C3507nq {
    public a[] f;
    public byte[] g;

    /* JADX INFO: renamed from: oq$a */
    public class a {
        public short a;
        public short b;
        public int c;
        public int d;
        public float e = 1.0f;
        public float f = 0.0f;
        public float g = 0.0f;
        public float h = 1.0f;
        public float i = 0.0f;
        public float j = 0.0f;

        public a() {
        }
    }

    @Override // defpackage.C3507nq
    public T8 a() {
        return super.a();
    }

    @Override // defpackage.C3507nq
    public short c() {
        return super.c();
    }

    @Override // defpackage.C3507nq
    public void i(T8 t8) {
        a aVar;
        byte[] bArr;
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        do {
            aVar = new a();
            aVar.a = t8.p();
            aVar.b = t8.p();
            short s = aVar.a;
            if ((s & 1) != 0 && (s & 2) != 0) {
                aVar.i = t8.p();
                aVar.j = t8.p();
            } else if ((s & 1) == 0 && (s & 2) != 0) {
                aVar.i = t8.h();
                aVar.j = t8.h();
            } else if ((s & 1) == 0 || (s & 2) != 0) {
                aVar.c = t8.h();
                aVar.d = t8.h();
            } else {
                aVar.c = t8.p();
                aVar.d = t8.p();
            }
            short s2 = aVar.a;
            if ((s2 & 8) != 0) {
                float fP = t8.p() / 16384.0f;
                aVar.e = fP;
                aVar.h = fP;
            } else if ((s2 & 64) != 0) {
                aVar.e = t8.p() / 16384.0f;
                aVar.h = t8.p() / 16384.0f;
            } else if ((s2 & 128) != 0) {
                aVar.e = t8.p() / 16384.0f;
                aVar.f = t8.p() / 16384.0f;
                aVar.g = t8.p() / 16384.0f;
                aVar.h = t8.p() / 16384.0f;
            }
            if ((aVar.a & 256) != 0) {
                z = true;
            }
            arrayList.add(aVar);
        } while ((aVar.a & 32) != 0);
        a[] aVarArr = new a[arrayList.size()];
        arrayList.toArray(aVarArr);
        r(aVarArr);
        if (z) {
            int iP = t8.p();
            bArr = new byte[iP];
            for (int i = 0; i < iP; i++) {
                bArr[i] = t8.h();
            }
        } else {
            bArr = new byte[0];
        }
        s(bArr);
    }

    public short o(int i) {
        return this.f[i].b;
    }

    public int p() {
        return this.f.length;
    }

    public float[] q(int i) {
        a aVar = this.f[i];
        float fMax = Math.max(Math.abs(aVar.e), Math.abs(aVar.f));
        if (Math.abs(Math.abs(aVar.e) - Math.abs(aVar.g)) < 0.0f) {
            fMax *= 2.0f;
        }
        float fMax2 = Math.max(Math.abs(aVar.g), Math.abs(aVar.h));
        if (Math.abs(Math.abs(aVar.g) - Math.abs(aVar.h)) < 0.0f) {
            fMax2 *= 2.0f;
        }
        return new float[]{aVar.e, aVar.f, aVar.g, aVar.h, fMax * aVar.i, fMax2 * aVar.j};
    }

    public void r(a[] aVarArr) {
        this.f = aVarArr;
    }

    public void s(byte[] bArr) {
        this.g = bArr;
    }
}
