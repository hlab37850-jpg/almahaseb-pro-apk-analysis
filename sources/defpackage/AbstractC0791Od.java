package defpackage;

import com.google.common.base.Objects;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;

/* JADX INFO: renamed from: Od, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0791Od {
    public static Object a(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            if (i <= 256) {
                return new byte[i];
            }
            return i <= 65536 ? new short[i] : new int[i];
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("must be power of 2 between 2^1 and 2^30: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int b(int i, int i2) {
        return i & (~i2);
    }

    public static int c(int i, int i2) {
        return i & i2;
    }

    public static int d(int i, int i2, int i3) {
        return (i & (~i3)) | (i2 & i3);
    }

    public static int e(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    public static int f(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iD = AbstractC3590or.d(obj);
        int i2 = iD & i;
        int iH = h(obj3, i2);
        if (iH == 0) {
            return -1;
        }
        int iB = b(iD, i);
        int i3 = -1;
        while (true) {
            int i4 = iH - 1;
            int i5 = iArr[i4];
            if (b(i5, i) == iB && Objects.equal(obj, objArr[i4]) && (objArr2 == null || Objects.equal(obj2, objArr2[i4]))) {
                int iC = c(i5, i);
                if (i3 == -1) {
                    i(obj3, i2, iC);
                } else {
                    iArr[i3] = d(iArr[i3], iC, i);
                }
                return i4;
            }
            int iC2 = c(i5, i);
            if (iC2 == 0) {
                return -1;
            }
            i3 = i4;
            iH = iC2;
        }
    }

    public static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    public static int h(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & UnsignedBytes.MAX_VALUE;
        }
        return obj instanceof short[] ? ((short[]) obj)[i] & 65535 : ((int[]) obj)[i];
    }

    public static void i(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    public static int j(int i) {
        return Math.max(4, AbstractC3590or.a(i + 1, 1.0d));
    }
}
