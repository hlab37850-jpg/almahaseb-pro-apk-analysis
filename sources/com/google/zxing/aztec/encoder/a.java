package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import defpackage.SU;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a e = new a(SU.b, 0, 0, 0);
    public final int a;
    public final SU b;
    public final int c;
    public final int d;

    public a(SU su, int i, int i2, int i3) {
        this.b = su;
        this.a = i;
        this.c = i2;
        this.d = i3;
    }

    public static int b(a aVar) {
        int i = aVar.c;
        if (i > 62) {
            return 21;
        }
        if (i > 31) {
            return 20;
        }
        return i > 0 ? 10 : 0;
    }

    public a a(int i) {
        int i2;
        SU suA = this.b;
        int i3 = this.a;
        int i4 = this.d;
        if (i3 == 4 || i3 == 2) {
            int i5 = HighLevelEncoder.LATCH_TABLE[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            suA = suA.a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.c;
        if (i8 == 0 || i8 == 31) {
            i2 = 18;
        } else {
            i2 = i8 == 62 ? 9 : 8;
        }
        a aVar = new a(suA, i3, i8 + 1, i4 + i2);
        return aVar.c == 2078 ? aVar.c(i + 1) : aVar;
    }

    public a c(int i) {
        int i2 = this.c;
        return i2 == 0 ? this : new a(this.b.b(i - i2, i2), this.a, 0, this.d);
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.a;
    }

    public boolean g(a aVar) {
        int iB = this.d + (HighLevelEncoder.LATCH_TABLE[this.a][aVar.a] >> 16);
        int i = this.c;
        int i2 = aVar.c;
        if (i < i2) {
            iB += b(aVar) - b(this);
        } else if (i > i2 && i2 > 0) {
            iB += 10;
        }
        return iB <= aVar.d;
    }

    public a h(int i, int i2) {
        int i3 = this.d;
        SU suA = this.b;
        int i4 = this.a;
        if (i != i4) {
            int i5 = HighLevelEncoder.LATCH_TABLE[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            suA = suA.a(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new a(suA.a(i2, i8), i, 0, i3 + i8);
    }

    public a i(int i, int i2) {
        SU su = this.b;
        int i3 = this.a;
        int i4 = i3 == 2 ? 4 : 5;
        return new a(su.a(HighLevelEncoder.SHIFT_TABLE[i3][i], i4).a(i2, 5), this.a, 0, this.d + i4 + 5);
    }

    public BitArray j(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (SU suD = c(bArr.length).b; suD != null; suD = suD.d()) {
            linkedList.addFirst(suD);
        }
        BitArray bitArray = new BitArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((SU) it.next()).c(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.a], Integer.valueOf(this.d), Integer.valueOf(this.c));
    }
}
