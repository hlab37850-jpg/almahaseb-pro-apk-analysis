package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: bc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1805bc {
    public static List a(List list) {
        AbstractC4492zt.h(list, "builder");
        return ((C0610Iv) list).o();
    }

    public static final Object[] b(Object[] objArr, boolean z) {
        AbstractC4492zt.h(objArr, "<this>");
        if (z && AbstractC4492zt.d(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        AbstractC4492zt.g(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static List c() {
        return new C0610Iv(0, 1, null);
    }

    public static List d(int i) {
        return new C0610Iv(i);
    }

    public static List e(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        AbstractC4492zt.g(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static Object[] f(int i, Object[] objArr) {
        AbstractC4492zt.h(objArr, "array");
        if (i < objArr.length) {
            objArr[i] = null;
        }
        return objArr;
    }
}
