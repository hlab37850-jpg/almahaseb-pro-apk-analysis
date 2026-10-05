package androidx.compose.ui.util;

import com.itextpdf.text.Annotation;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ListUtilsKt {
    public static final <T> boolean fastAll(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!((Boolean) interfaceC3750qp.invoke(list.get(i))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean fastAny(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((Boolean) interfaceC3750qp.invoke(list.get(i))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T> T fastFirstOrNull(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            if (((Boolean) interfaceC3750qp.invoke(t)).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    public static final <T> void fastForEach(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "action");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            interfaceC3750qp.invoke(list.get(i));
        }
    }

    public static final <T> void fastForEachIndexed(List<? extends T> list, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "action");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            interfaceC0526Fp.mo13invoke(Integer.valueOf(i), list.get(i));
        }
    }

    public static final <T> void fastForEachReversed(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "action");
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            interfaceC3750qp.invoke(list.get(size));
            if (i < 0) {
                return;
            } else {
                size = i;
            }
        }
    }

    public static final <T> T fastLastOrNull(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        int size = list.size() - 1;
        if (size < 0) {
            return null;
        }
        while (true) {
            int i = size - 1;
            T t = list.get(size);
            if (((Boolean) interfaceC3750qp.invoke(t)).booleanValue()) {
                return t;
            }
            if (i < 0) {
                return null;
            }
            size = i;
        }
    }

    public static final <T, R> List<R> fastMap(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(interfaceC3750qp.invoke(list.get(i)));
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C fastMapTo(List<? extends T> list, C c, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(c, Annotation.DESTINATION);
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c.add(interfaceC3750qp.invoke(list.get(i)));
        }
        return c;
    }

    public static final <T, R extends Comparable<? super R>> T fastMaxBy(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "selector");
        if (list.isEmpty()) {
            return null;
        }
        T t = list.get(0);
        Comparable comparable = (Comparable) interfaceC3750qp.invoke(t);
        int iO = AbstractC1886cc.o(list);
        int i = 1;
        if (1 <= iO) {
            while (true) {
                T t2 = list.get(i);
                Comparable comparable2 = (Comparable) interfaceC3750qp.invoke(t2);
                if (comparable.compareTo(comparable2) < 0) {
                    t = t2;
                    comparable = comparable2;
                }
                if (i == iO) {
                    break;
                }
                i++;
            }
        }
        return t;
    }

    public static final <T> int fastSumBy(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "selector");
        int size = list.size();
        int iIntValue = 0;
        for (int i = 0; i < size; i++) {
            iIntValue += ((Number) interfaceC3750qp.invoke(list.get(i))).intValue();
        }
        return iIntValue;
    }
}
