package defpackage;

import java.math.BigDecimal;
import java.util.ArrayList;

/* JADX INFO: renamed from: cU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1876cU {
    public static final char[] l = new char[0];
    public final J8 a;
    public char[] b;
    public int c;
    public int d;
    public ArrayList e;
    public boolean f = false;
    public int g;
    public char[] h;
    public int i;
    public String j;
    public char[] k;

    public C1876cU(J8 j8) {
        this.a = j8;
    }

    public final char[] a(int i) {
        return new char[i];
    }

    public void b(char[] cArr, int i, int i2) {
        if (this.c >= 0) {
            y(i2);
        }
        this.j = null;
        this.k = null;
        char[] cArr2 = this.h;
        int length = cArr2.length;
        int i3 = this.i;
        int i4 = length - i3;
        if (i4 >= i2) {
            System.arraycopy(cArr, i, cArr2, i3, i2);
            this.i += i2;
            return;
        }
        if (i4 > 0) {
            System.arraycopy(cArr, i, cArr2, i3, i4);
            i += i4;
            i2 -= i4;
        }
        do {
            j(i2);
            int iMin = Math.min(this.h.length, i2);
            System.arraycopy(cArr, i, this.h, 0, iMin);
            this.i += iMin;
            i += iMin;
            i2 -= iMin;
        } while (i2 > 0);
    }

    public final char[] c() {
        int i;
        String str = this.j;
        if (str != null) {
            return str.toCharArray();
        }
        if (this.c >= 0) {
            int i2 = this.d;
            if (i2 < 1) {
                return l;
            }
            char[] cArrA = a(i2);
            System.arraycopy(this.b, this.c, cArrA, 0, this.d);
            return cArrA;
        }
        int iX = x();
        if (iX < 1) {
            return l;
        }
        char[] cArrA2 = a(iX);
        ArrayList arrayList = this.e;
        if (arrayList != null) {
            int size = arrayList.size();
            i = 0;
            for (int i3 = 0; i3 < size; i3++) {
                char[] cArr = (char[]) this.e.get(i3);
                int length = cArr.length;
                System.arraycopy(cArr, 0, cArrA2, i, length);
                i += length;
            }
        } else {
            i = 0;
        }
        System.arraycopy(this.h, 0, cArrA2, i, this.i);
        return cArrA2;
    }

    public final void d() {
        this.f = false;
        this.e.clear();
        this.g = 0;
        this.i = 0;
    }

    public char[] e() {
        char[] cArr = this.k;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrC = c();
        this.k = cArrC;
        return cArrC;
    }

    public BigDecimal f() {
        if (this.k != null) {
            return new BigDecimal(this.k);
        }
        if (this.c >= 0) {
            return new BigDecimal(this.b, this.c, this.d);
        }
        return this.g == 0 ? new BigDecimal(this.h, 0, this.i) : new BigDecimal(e());
    }

    public double g() {
        return AbstractC1779bE.b(h());
    }

    public String h() {
        if (this.j == null) {
            char[] cArr = this.k;
            if (cArr != null) {
                this.j = new String(cArr);
            } else {
                int i = this.c;
                if (i >= 0) {
                    int i2 = this.d;
                    if (i2 < 1) {
                        this.j = "";
                        return "";
                    }
                    this.j = new String(this.b, i, i2);
                } else {
                    int i3 = this.g;
                    int i4 = this.i;
                    if (i3 == 0) {
                        this.j = i4 != 0 ? new String(this.h, 0, i4) : "";
                    } else {
                        StringBuilder sb = new StringBuilder(i3 + i4);
                        ArrayList arrayList = this.e;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                char[] cArr2 = (char[]) this.e.get(i5);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this.h, 0, this.i);
                        this.j = sb.toString();
                    }
                }
            }
        }
        return this.j;
    }

    public char[] i() {
        this.c = -1;
        this.i = 0;
        this.d = 0;
        this.b = null;
        this.j = null;
        this.k = null;
        if (this.f) {
            d();
        }
        char[] cArr = this.h;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrL = l(0);
        this.h = cArrL;
        return cArrL;
    }

    public final void j(int i) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        char[] cArr = this.h;
        this.f = true;
        this.e.add(cArr);
        this.g += cArr.length;
        int length = cArr.length;
        int i2 = length >> 1;
        if (i2 >= i) {
            i = i2;
        }
        char[] cArrA = a(Math.min(262144, length + i));
        this.i = 0;
        this.h = cArrA;
    }

    public char[] k() {
        char[] cArr = this.h;
        int length = cArr.length;
        char[] cArrA = a(length == 262144 ? 262145 : Math.min(262144, (length >> 1) + length));
        this.h = cArrA;
        System.arraycopy(cArr, 0, cArrA, 0, length);
        return this.h;
    }

    public final char[] l(int i) {
        J8 j8 = this.a;
        return j8 != null ? j8.c(J8.b.TEXT_BUFFER, i) : new char[Math.max(i, 1000)];
    }

    public char[] m() {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.f = true;
        this.e.add(this.h);
        int length = this.h.length;
        this.g += length;
        char[] cArrA = a(Math.min(length + (length >> 1), 262144));
        this.i = 0;
        this.h = cArrA;
        return cArrA;
    }

    public char[] n() {
        if (this.c >= 0) {
            y(1);
        } else {
            char[] cArr = this.h;
            if (cArr == null) {
                this.h = l(0);
            } else if (this.i >= cArr.length) {
                j(1);
            }
        }
        return this.h;
    }

    public int o() {
        return this.i;
    }

    public char[] p() {
        if (this.c >= 0) {
            return this.b;
        }
        char[] cArr = this.k;
        if (cArr != null) {
            return cArr;
        }
        String str = this.j;
        if (str == null) {
            return !this.f ? this.h : e();
        }
        char[] charArray = str.toCharArray();
        this.k = charArray;
        return charArray;
    }

    public int q() {
        int i = this.c;
        if (i >= 0) {
            return i;
        }
        return 0;
    }

    public void r() {
        if (this.a == null) {
            t();
        } else if (this.h != null) {
            t();
            char[] cArr = this.h;
            this.h = null;
            this.a.g(J8.b.TEXT_BUFFER, cArr);
        }
    }

    public void s(char[] cArr, int i, int i2) {
        this.b = null;
        this.c = -1;
        this.d = 0;
        this.j = null;
        this.k = null;
        if (this.f) {
            d();
        } else if (this.h == null) {
            this.h = l(i2);
        }
        this.g = 0;
        this.i = 0;
        b(cArr, i, i2);
    }

    public void t() {
        this.c = -1;
        this.i = 0;
        this.d = 0;
        this.b = null;
        this.j = null;
        this.k = null;
        if (this.f) {
            d();
        }
    }

    public String toString() {
        return h();
    }

    public void u(char[] cArr, int i, int i2) {
        this.j = null;
        this.k = null;
        this.b = cArr;
        this.c = i;
        this.d = i2;
        if (this.f) {
            d();
        }
    }

    public void v(String str) {
        this.b = null;
        this.c = -1;
        this.d = 0;
        this.j = str;
        this.k = null;
        if (this.f) {
            d();
        }
        this.i = 0;
    }

    public void w(int i) {
        this.i = i;
    }

    public int x() {
        if (this.c >= 0) {
            return this.d;
        }
        char[] cArr = this.k;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.j;
        return str != null ? str.length() : this.g + this.i;
    }

    public final void y(int i) {
        int i2 = this.d;
        this.d = 0;
        char[] cArr = this.b;
        this.b = null;
        int i3 = this.c;
        this.c = -1;
        int i4 = i + i2;
        char[] cArr2 = this.h;
        if (cArr2 == null || i4 > cArr2.length) {
            this.h = l(i4);
        }
        if (i2 > 0) {
            System.arraycopy(cArr, i3, this.h, 0, i2);
        }
        this.g = 0;
        this.i = i2;
    }
}
