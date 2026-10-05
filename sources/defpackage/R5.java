package defpackage;

import com.itextpdf.text.Annotation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class R5 extends Q5 {

    public static final class a implements Iterable, InterfaceC0756Mu {
        public final /* synthetic */ Object[] a;

        public a(Object[] objArr) {
            this.a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return AbstractC1199a5.a(this.a);
        }
    }

    public static final class b implements InterfaceC4362yO {
        public final /* synthetic */ Object[] a;

        public b(Object[] objArr) {
            this.a = objArr;
        }

        @Override // defpackage.InterfaceC4362yO
        public Iterator iterator() {
            return AbstractC1199a5.a(this.a);
        }
    }

    public static Iterable B(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        return objArr.length == 0 ? AbstractC1886cc.m() : new a(objArr);
    }

    public static InterfaceC4362yO C(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        return objArr.length == 0 ? DO.e() : new b(objArr);
    }

    public static boolean D(int[] iArr, int i) {
        AbstractC4492zt.h(iArr, "<this>");
        return R(iArr, i) >= 0;
    }

    public static boolean E(Object[] objArr, Object obj) {
        AbstractC4492zt.h(objArr, "<this>");
        return S(objArr, obj) >= 0;
    }

    public static List F(int[] iArr) {
        AbstractC4492zt.h(iArr, "<this>");
        return AbstractC3240kc.C0(o0(iArr));
    }

    public static List G(Object[] objArr, int i) {
        AbstractC4492zt.h(objArr, "<this>");
        if (i >= 0) {
            return i0(objArr, AbstractC3871sJ.d(objArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static List H(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        return (List) I(objArr, new ArrayList());
    }

    public static final Collection I(Object[] objArr, Collection collection) {
        AbstractC4492zt.h(objArr, "<this>");
        AbstractC4492zt.h(collection, Annotation.DESTINATION);
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static Object J(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object K(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        if (objArr.length == 0) {
            return null;
        }
        return objArr[0];
    }

    public static C1001Vs L(int[] iArr) {
        AbstractC4492zt.h(iArr, "<this>");
        return new C1001Vs(0, N(iArr));
    }

    public static int M(float[] fArr) {
        AbstractC4492zt.h(fArr, "<this>");
        return fArr.length - 1;
    }

    public static int N(int[] iArr) {
        AbstractC4492zt.h(iArr, "<this>");
        return iArr.length - 1;
    }

    public static int O(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Integer P(int[] iArr, int i) {
        AbstractC4492zt.h(iArr, "<this>");
        if (i < 0 || i >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    public static Object Q(Object[] objArr, int i) {
        AbstractC4492zt.h(objArr, "<this>");
        if (i < 0 || i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public static int R(int[] iArr, int i) {
        AbstractC4492zt.h(iArr, "<this>");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static int S(Object[] objArr, Object obj) {
        AbstractC4492zt.h(objArr, "<this>");
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (AbstractC4492zt.d(obj, objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final Appendable T(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp) throws IOException {
        AbstractC4492zt.h(objArr, "<this>");
        AbstractC4492zt.h(appendable, "buffer");
        AbstractC4492zt.h(charSequence, "separator");
        AbstractC4492zt.h(charSequence2, "prefix");
        AbstractC4492zt.h(charSequence3, "postfix");
        AbstractC4492zt.h(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : objArr) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            AbstractC3228kS.a(appendable, obj, interfaceC3750qp);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String U(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(objArr, "<this>");
        AbstractC4492zt.h(charSequence, "separator");
        AbstractC4492zt.h(charSequence2, "prefix");
        AbstractC4492zt.h(charSequence3, "postfix");
        AbstractC4492zt.h(charSequence4, "truncated");
        String string = ((StringBuilder) T(objArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, interfaceC3750qp)).toString();
        AbstractC4492zt.g(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String V(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            interfaceC3750qp = null;
        }
        return U(objArr, charSequence, charSequence5, charSequence6, i3, charSequence7, interfaceC3750qp);
    }

    public static Object W(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[O(objArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static int X(Object[] objArr, Object obj) {
        AbstractC4492zt.h(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (objArr[length] == null) {
                        return length;
                    }
                    if (i >= 0) {
                        length = i;
                    }
                }
            }
        } else {
            int length2 = objArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i2 = length2 - 1;
                    if (AbstractC4492zt.d(obj, objArr[length2])) {
                        return length2;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    length2 = i2;
                }
            }
        }
        return -1;
    }

    public static Object Y(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        if (objArr.length == 0) {
            return null;
        }
        return objArr[objArr.length - 1];
    }

    public static Integer Z(int[] iArr) {
        AbstractC4492zt.h(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int iN = N(iArr);
        int i2 = 1;
        if (1 <= iN) {
            while (true) {
                int i3 = iArr[i2];
                if (i < i3) {
                    i = i3;
                }
                if (i2 == iN) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i);
    }

    public static int a0(int[] iArr) {
        AbstractC4492zt.h(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i = iArr[0];
        int iN = N(iArr);
        int i2 = 1;
        if (1 <= iN) {
            while (true) {
                int i3 = iArr[i2];
                if (i < i3) {
                    i = i3;
                }
                if (i2 == iN) {
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    public static Integer b0(int[] iArr) {
        AbstractC4492zt.h(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int iN = N(iArr);
        int i2 = 1;
        if (1 <= iN) {
            while (true) {
                int i3 = iArr[i2];
                if (i > i3) {
                    i = i3;
                }
                if (i2 == iN) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i);
    }

    public static char c0(char[] cArr) {
        AbstractC4492zt.h(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object d0(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static List e0(Object[] objArr, C1001Vs c1001Vs) {
        AbstractC4492zt.h(objArr, "<this>");
        AbstractC4492zt.h(c1001Vs, "indices");
        return c1001Vs.isEmpty() ? AbstractC1886cc.m() : Q5.c(Q5.o(objArr, c1001Vs.getStart().intValue(), c1001Vs.getEndInclusive().intValue() + 1));
    }

    public static final Object[] f0(Object[] objArr, Comparator comparator) {
        AbstractC4492zt.h(objArr, "<this>");
        AbstractC4492zt.h(comparator, "comparator");
        if (objArr.length == 0) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(...)");
        Q5.z(objArrCopyOf, comparator);
        return objArrCopyOf;
    }

    public static List g0(Object[] objArr, Comparator comparator) {
        AbstractC4492zt.h(objArr, "<this>");
        AbstractC4492zt.h(comparator, "comparator");
        return Q5.c(f0(objArr, comparator));
    }

    public static int h0(int[] iArr) {
        AbstractC4492zt.h(iArr, "<this>");
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static final List i0(Object[] objArr, int i) {
        AbstractC4492zt.h(objArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return AbstractC1886cc.m();
        }
        int length = objArr.length;
        if (i >= length) {
            return l0(objArr);
        }
        if (i == 1) {
            return AbstractC1805bc.e(objArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(objArr[i2]);
        }
        return arrayList;
    }

    public static final Collection j0(int[] iArr, Collection collection) {
        AbstractC4492zt.h(iArr, "<this>");
        AbstractC4492zt.h(collection, Annotation.DESTINATION);
        for (int i : iArr) {
            collection.add(Integer.valueOf(i));
        }
        return collection;
    }

    public static final Collection k0(Object[] objArr, Collection collection) {
        AbstractC4492zt.h(objArr, "<this>");
        AbstractC4492zt.h(collection, Annotation.DESTINATION);
        for (Object obj : objArr) {
            collection.add(obj);
        }
        return collection;
    }

    public static List l0(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? n0(objArr) : AbstractC1805bc.e(objArr[0]);
        }
        return AbstractC1886cc.m();
    }

    public static List m0(int[] iArr) {
        AbstractC4492zt.h(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static List n0(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        return new ArrayList(AbstractC1886cc.h(objArr));
    }

    public static final Set o0(int[] iArr) {
        AbstractC4492zt.h(iArr, "<this>");
        return (Set) j0(iArr, new LinkedHashSet(AbstractC4162vx.d(iArr.length)));
    }

    public static final Set p0(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? (Set) k0(objArr, new LinkedHashSet(AbstractC4162vx.d(objArr.length))) : PO.c(objArr[0]);
        }
        return QO.e();
    }
}
