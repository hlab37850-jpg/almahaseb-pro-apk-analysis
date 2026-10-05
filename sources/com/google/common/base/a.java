package com.google.common.base;

import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends CharMatcher.v {
    public final char[] b;
    public final boolean c;
    public final long d;

    public a(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.b = cArr;
        this.d = j;
        this.c = z;
    }

    public static int b(int i) {
        if (i == 1) {
            return 2;
        }
        int iHighestOneBit = Integer.highestOneBit(i - 1) << 1;
        while (((double) iHighestOneBit) * 0.5d < i) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static CharMatcher c(BitSet bitSet, String str) {
        int i;
        int iCardinality = bitSet.cardinality();
        boolean z = bitSet.get(0);
        int iB = b(iCardinality);
        char[] cArr = new char[iB];
        int i2 = iB - 1;
        int iNextSetBit = bitSet.nextSetBit(0);
        long j = 0;
        while (iNextSetBit != -1) {
            long j2 = (1 << iNextSetBit) | j;
            int iD = d(iNextSetBit);
            while (true) {
                i = iD & i2;
                if (cArr[i] == 0) {
                    break;
                }
                iD = i + 1;
            }
            cArr[i] = (char) iNextSetBit;
            iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1);
            j = j2;
        }
        return new a(cArr, j, z, str);
    }

    public static int d(int i) {
        return Integer.rotateLeft(i * (-862048943), 15) * 461845907;
    }

    public final boolean a(int i) {
        return 1 == ((this.d >> i) & 1);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c) {
        if (c == 0) {
            return this.c;
        }
        if (!a(c)) {
            return false;
        }
        int length = this.b.length - 1;
        int iD = d(c) & length;
        int i = iD;
        do {
            char c2 = this.b[i];
            if (c2 == 0) {
                return false;
            }
            if (c2 == c) {
                return true;
            }
            i = (i + 1) & length;
        } while (i != iD);
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    public void setBits(BitSet bitSet) {
        if (this.c) {
            bitSet.set(0);
        }
        for (char c : this.b) {
            if (c != 0) {
                bitSet.set(c);
            }
        }
    }
}
