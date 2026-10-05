package defpackage;

import com.itextpdf.text.Annotation;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Q5 extends P5 {
    public static void A(Object[] objArr, Comparator comparator, int i, int i2) {
        AbstractC4492zt.h(objArr, "<this>");
        AbstractC4492zt.h(comparator, "comparator");
        Arrays.sort(objArr, i, i2, comparator);
    }

    public static List c(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        List listA = S5.a(objArr);
        AbstractC4492zt.g(listA, "asList(...)");
        return listA;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        AbstractC4492zt.h(bArr, "<this>");
        AbstractC4492zt.h(bArr2, Annotation.DESTINATION);
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static char[] e(char[] cArr, char[] cArr2, int i, int i2, int i3) {
        AbstractC4492zt.h(cArr, "<this>");
        AbstractC4492zt.h(cArr2, Annotation.DESTINATION);
        System.arraycopy(cArr, i2, cArr2, i, i3 - i2);
        return cArr2;
    }

    public static float[] f(float[] fArr, float[] fArr2, int i, int i2, int i3) {
        AbstractC4492zt.h(fArr, "<this>");
        AbstractC4492zt.h(fArr2, Annotation.DESTINATION);
        System.arraycopy(fArr, i2, fArr2, i, i3 - i2);
        return fArr2;
    }

    public static int[] g(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        AbstractC4492zt.h(iArr, "<this>");
        AbstractC4492zt.h(iArr2, Annotation.DESTINATION);
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
        return iArr2;
    }

    public static long[] h(long[] jArr, long[] jArr2, int i, int i2, int i3) {
        AbstractC4492zt.h(jArr, "<this>");
        AbstractC4492zt.h(jArr2, Annotation.DESTINATION);
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
        return jArr2;
    }

    public static Object[] i(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        AbstractC4492zt.h(objArr, "<this>");
        AbstractC4492zt.h(objArr2, Annotation.DESTINATION);
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
        return objArr2;
    }

    public static /* synthetic */ byte[] j(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return d(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ float[] k(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length;
        }
        return f(fArr, fArr2, i, i2, i3);
    }

    public static /* synthetic */ int[] l(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return g(iArr, iArr2, i, i2, i3);
    }

    public static /* synthetic */ Object[] m(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return i(objArr, objArr2, i, i2, i3);
    }

    public static byte[] n(byte[] bArr, int i, int i2) {
        AbstractC4492zt.h(bArr, "<this>");
        O5.b(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        AbstractC4492zt.g(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] o(Object[] objArr, int i, int i2) {
        AbstractC4492zt.h(objArr, "<this>");
        O5.b(i2, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i2);
        AbstractC4492zt.g(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static final void p(float[] fArr, float f, int i, int i2) {
        AbstractC4492zt.h(fArr, "<this>");
        Arrays.fill(fArr, i, i2, f);
    }

    public static void q(int[] iArr, int i, int i2, int i3) {
        AbstractC4492zt.h(iArr, "<this>");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static void r(Object[] objArr, Object obj, int i, int i2) {
        AbstractC4492zt.h(objArr, "<this>");
        Arrays.fill(objArr, i, i2, obj);
    }

    public static /* synthetic */ void s(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        p(fArr, f, i, i2);
    }

    public static /* synthetic */ void t(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        q(iArr, i, i2, i3);
    }

    public static /* synthetic */ void u(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        r(objArr, obj, i, i2);
    }

    public static int[] v(int[] iArr, int i) {
        AbstractC4492zt.h(iArr, "<this>");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
        iArrCopyOf[length] = i;
        AbstractC4492zt.e(iArrCopyOf);
        return iArrCopyOf;
    }

    public static int[] w(int[] iArr, int[] iArr2) {
        AbstractC4492zt.h(iArr, "<this>");
        AbstractC4492zt.h(iArr2, "elements");
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, iArrCopyOf, length, length2);
        AbstractC4492zt.e(iArrCopyOf);
        return iArrCopyOf;
    }

    public static Object[] x(Object[] objArr, Object obj) {
        AbstractC4492zt.h(objArr, "<this>");
        int length = objArr.length;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, length + 1);
        objArrCopyOf[length] = obj;
        AbstractC4492zt.e(objArrCopyOf);
        return objArrCopyOf;
    }

    public static void y(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }

    public static final void z(Object[] objArr, Comparator comparator) {
        AbstractC4492zt.h(objArr, "<this>");
        AbstractC4492zt.h(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
