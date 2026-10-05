package defpackage;

import com.google.android.gms.internal.vision.zzcz;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Fa0 {
    public static int a(int i, int i2, int i3) {
        return (i & (~i3)) | (i2 & i3);
    }

    public static int b(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & UnsignedBytes.MAX_VALUE;
        }
        return obj instanceof short[] ? ((short[]) obj)[i] & 65535 : ((int[]) obj)[i];
    }

    public static int c(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iB = La0.b(obj);
        int i2 = iB & i;
        int iB2 = b(obj3, i2);
        if (iB2 == 0) {
            return -1;
        }
        int i3 = ~i;
        int i4 = iB & i3;
        int i5 = -1;
        while (true) {
            int i6 = iB2 - 1;
            int i7 = iArr[i6];
            if ((i7 & i3) == i4 && zzcz.zza(obj, objArr[i6]) && (objArr2 == null || zzcz.zza(obj2, objArr2[i6]))) {
                int i8 = i7 & i;
                if (i5 == -1) {
                    e(obj3, i2, i8);
                } else {
                    iArr[i5] = a(iArr[i5], i8, i);
                }
                return i6;
            }
            int i9 = i7 & i;
            if (i9 == 0) {
                return -1;
            }
            i5 = i6;
            iB2 = i9;
        }
    }

    public static Object d(int i) {
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

    public static void e(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    public static int f(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }
}
