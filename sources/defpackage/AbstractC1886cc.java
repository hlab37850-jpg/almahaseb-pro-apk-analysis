package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: cc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1886cc extends AbstractC1805bc {
    public static ArrayList g(Object... objArr) {
        AbstractC4492zt.h(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new V4(objArr, true));
    }

    public static final Collection h(Object[] objArr) {
        AbstractC4492zt.h(objArr, "<this>");
        return new V4(objArr, false);
    }

    public static int i(List list, int i, int i2, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "comparison");
        u(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iIntValue = ((Number) interfaceC3750qp.invoke(list.get(i4))).intValue();
            if (iIntValue < 0) {
                i = i4 + 1;
            } else {
                if (iIntValue <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static final int j(List list, Comparable comparable, int i, int i2) {
        AbstractC4492zt.h(list, "<this>");
        u(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iD = AbstractC0956Ud.d((Comparable) list.get(i4), comparable);
            if (iD < 0) {
                i = i4 + 1;
            } else {
                if (iD <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int k(List list, int i, int i2, InterfaceC3750qp interfaceC3750qp, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        return i(list, i, i2, interfaceC3750qp);
    }

    public static /* synthetic */ int l(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return j(list, comparable, i, i2);
    }

    public static List m() {
        return C2141el.a;
    }

    public static C1001Vs n(Collection collection) {
        AbstractC4492zt.h(collection, "<this>");
        return new C1001Vs(0, collection.size() - 1);
    }

    public static int o(List list) {
        AbstractC4492zt.h(list, "<this>");
        return list.size() - 1;
    }

    public static List p(Object... objArr) {
        AbstractC4492zt.h(objArr, "elements");
        return objArr.length > 0 ? Q5.c(objArr) : m();
    }

    public static List q(Object obj) {
        return obj != null ? AbstractC1805bc.e(obj) : m();
    }

    public static List r(Object... objArr) {
        AbstractC4492zt.h(objArr, "elements");
        return R5.H(objArr);
    }

    public static List s(Object... objArr) {
        AbstractC4492zt.h(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new V4(objArr, true));
    }

    public static final List t(List list) {
        AbstractC4492zt.h(list, "<this>");
        int size = list.size();
        if (size != 0) {
            return size != 1 ? list : AbstractC1805bc.e(list.get(0));
        }
        return m();
    }

    public static final void u(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }

    public static void v() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void w() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
