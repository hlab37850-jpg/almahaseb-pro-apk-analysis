package defpackage;

import java.util.Arrays;

/* JADX INFO: renamed from: qb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3729qb {
    public static final C3729qb l = new C3729qb();
    public C3729qb a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public String[] e;
    public a[] f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;

    /* JADX INFO: renamed from: qb$a */
    public static final class a {
        public final String a;
        public final a b;
        public final int c;

        public a(String str, a aVar) {
            this.a = str;
            this.b = aVar;
            this.c = aVar != null ? 1 + aVar.c : 1;
        }

        public String a(char[] cArr, int i, int i2) {
            String strC = this.a;
            a aVarB = this.b;
            while (true) {
                if (strC.length() == i2) {
                    int i3 = 0;
                    while (strC.charAt(i3) == cArr[i + i3] && (i3 = i3 + 1) < i2) {
                    }
                    if (i3 == i2) {
                        return strC;
                    }
                }
                if (aVarB == null) {
                    return null;
                }
                strC = aVarB.c();
                aVarB = aVarB.b();
            }
        }

        public a b() {
            return this.b;
        }

        public String c() {
            return this.a;
        }

        public int d() {
            return this.c;
        }
    }

    public C3729qb() {
        this.d = true;
        this.c = true;
        this.k = true;
        this.b = 0;
        this.j = 0;
        j(64);
    }

    public static int b(int i) {
        return i - (i >> 2);
    }

    public static C3729qb f() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return g((((int) jCurrentTimeMillis) + ((int) (jCurrentTimeMillis >>> 32))) | 1);
    }

    public static C3729qb g(int i) {
        return l.l(i);
    }

    public int a(int i) {
        return (i + (i >>> 15)) & this.i;
    }

    public int c(String str) {
        int length = str.length();
        int iCharAt = this.b;
        for (int i = 0; i < length; i++) {
            iCharAt = (iCharAt * 33) + str.charAt(i);
        }
        if (iCharAt == 0) {
            return 1;
        }
        return iCharAt;
    }

    public int d(char[] cArr, int i, int i2) {
        int i3 = this.b;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 33) + cArr[i4];
        }
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public final void e() {
        String[] strArr = this.e;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        this.e = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, length);
        a[] aVarArr = this.f;
        int length2 = aVarArr.length;
        a[] aVarArr2 = new a[length2];
        this.f = aVarArr2;
        System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
    }

    public String h(char[] cArr, int i, int i2, int i3) {
        String strA;
        if (i2 < 1) {
            return "";
        }
        if (!this.d) {
            return new String(cArr, i, i2);
        }
        int iA = a(i3);
        String str = this.e[iA];
        if (str != null) {
            if (str.length() == i2) {
                int i4 = 0;
                while (str.charAt(i4) == cArr[i + i4] && (i4 = i4 + 1) < i2) {
                }
                if (i4 == i2) {
                    return str;
                }
            }
            a aVar = this.f[iA >> 1];
            if (aVar != null && (strA = aVar.a(cArr, i, i2)) != null) {
                return strA;
            }
        }
        if (!this.k) {
            e();
            this.k = true;
        } else if (this.g >= this.h) {
            o();
            iA = a(d(cArr, i, i2));
        }
        String str2 = new String(cArr, i, i2);
        if (this.c) {
            str2 = C4077ut.a.a(str2);
        }
        this.g++;
        String[] strArr = this.e;
        if (strArr[iA] == null) {
            strArr[iA] = str2;
        } else {
            int i5 = iA >> 1;
            a aVar2 = new a(str2, this.f[i5]);
            this.f[i5] = aVar2;
            int iMax = Math.max(aVar2.d(), this.j);
            this.j = iMax;
            if (iMax > 255) {
                q(255);
            }
        }
        return str2;
    }

    public int i() {
        return this.b;
    }

    public final void j(int i) {
        this.e = new String[i];
        this.f = new a[i >> 1];
        this.i = i - 1;
        this.g = 0;
        this.j = 0;
        this.h = b(i);
    }

    public C3729qb k(boolean z, boolean z2) {
        String[] strArr;
        a[] aVarArr;
        int i;
        int i2;
        int i3;
        synchronized (this) {
            strArr = this.e;
            aVarArr = this.f;
            i = this.g;
            i2 = this.b;
            i3 = this.j;
        }
        return new C3729qb(this, z, z2, strArr, aVarArr, i, i2, i3);
    }

    public final C3729qb l(int i) {
        return new C3729qb(null, true, true, this.e, this.f, this.g, i, this.j);
    }

    public boolean m() {
        return this.k;
    }

    public final void n(C3729qb c3729qb) {
        if (c3729qb.r() > 12000 || c3729qb.j > 63) {
            synchronized (this) {
                j(64);
                this.k = false;
            }
        } else {
            if (c3729qb.r() <= r()) {
                return;
            }
            synchronized (this) {
                this.e = c3729qb.e;
                this.f = c3729qb.f;
                this.g = c3729qb.g;
                this.h = c3729qb.h;
                this.i = c3729qb.i;
                this.j = c3729qb.j;
                this.k = false;
            }
        }
    }

    public final void o() {
        String[] strArr = this.e;
        int length = strArr.length;
        int i = length + length;
        if (i > 65536) {
            this.g = 0;
            Arrays.fill(strArr, (Object) null);
            Arrays.fill(this.f, (Object) null);
            this.k = true;
            return;
        }
        a[] aVarArr = this.f;
        this.e = new String[i];
        this.f = new a[i >> 1];
        this.i = i - 1;
        this.h = b(i);
        int i2 = 0;
        int iMax = 0;
        for (String str : strArr) {
            if (str != null) {
                i2++;
                int iA = a(c(str));
                String[] strArr2 = this.e;
                if (strArr2[iA] == null) {
                    strArr2[iA] = str;
                } else {
                    int i3 = iA >> 1;
                    a aVar = new a(str, this.f[i3]);
                    this.f[i3] = aVar;
                    iMax = Math.max(iMax, aVar.d());
                }
            }
        }
        int i4 = length >> 1;
        for (int i5 = 0; i5 < i4; i5++) {
            for (a aVarB = aVarArr[i5]; aVarB != null; aVarB = aVarB.b()) {
                i2++;
                String strC = aVarB.c();
                int iA2 = a(c(strC));
                String[] strArr3 = this.e;
                if (strArr3[iA2] == null) {
                    strArr3[iA2] = strC;
                } else {
                    int i6 = iA2 >> 1;
                    a aVar2 = new a(strC, this.f[i6]);
                    this.f[i6] = aVar2;
                    iMax = Math.max(iMax, aVar2.d());
                }
            }
        }
        this.j = iMax;
        if (i2 == this.g) {
            return;
        }
        throw new Error("Internal error on SymbolTable.rehash(): had " + this.g + " entries; now have " + i2 + ".");
    }

    public void p() {
        C3729qb c3729qb;
        if (m() && (c3729qb = this.a) != null) {
            c3729qb.n(this);
            this.k = false;
        }
    }

    public void q(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.g + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }

    public int r() {
        return this.g;
    }

    public C3729qb(C3729qb c3729qb, boolean z, boolean z2, String[] strArr, a[] aVarArr, int i, int i2, int i3) {
        this.a = c3729qb;
        this.d = z;
        this.c = z2;
        this.e = strArr;
        this.f = aVarArr;
        this.g = i;
        this.b = i2;
        int length = strArr.length;
        this.h = b(length);
        this.i = length - 1;
        this.j = i3;
        this.k = false;
    }
}
