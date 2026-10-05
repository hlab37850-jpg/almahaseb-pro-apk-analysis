package androidx.compose.foundation;

import com.itextpdf.text.Annotation;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TempListUtilsKt {
    public static final <T> List<T> fastFilter(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            if (((Boolean) interfaceC3750qp.invoke(t)).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T, R> R fastFold(List<? extends T> list, R r, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            r = (R) interfaceC0526Fp.mo13invoke(r, list.get(i));
        }
        return r;
    }

    public static final <T, R> List<R> fastMapIndexedNotNull(List<? extends T> list, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object objMo13invoke = interfaceC0526Fp.mo13invoke(Integer.valueOf(i), list.get(i));
            if (objMo13invoke != null) {
                arrayList.add(objMo13invoke);
            }
        }
        return arrayList;
    }

    public static final <T, R extends Comparable<? super R>> R fastMaxOfOrNull(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "selector");
        if (list.isEmpty()) {
            return null;
        }
        R r = (R) interfaceC3750qp.invoke(list.get(0));
        int iO = AbstractC1886cc.o(list);
        int i = 1;
        if (1 <= iO) {
            while (true) {
                Comparable comparable = (Comparable) interfaceC3750qp.invoke(list.get(i));
                if (comparable.compareTo(r) > 0) {
                    r = (R) comparable;
                }
                if (i == iO) {
                    break;
                }
                i++;
            }
        }
        return r;
    }
}
