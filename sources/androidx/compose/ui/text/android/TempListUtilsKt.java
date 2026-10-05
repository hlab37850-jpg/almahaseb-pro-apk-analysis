package androidx.compose.ui.text.android;

import com.itextpdf.text.Annotation;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TempListUtilsKt {
    public static final <T> void fastForEach(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "action");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            interfaceC3750qp.invoke(list.get(i));
        }
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

    public static final <T, R> List<R> fastZipWithNext(List<? extends T> list, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "transform");
        if (list.size() == 0 || list.size() == 1) {
            return AbstractC1886cc.m();
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        T t = list.get(0);
        int iO = AbstractC1886cc.o(list);
        while (i < iO) {
            i++;
            T t2 = list.get(i);
            arrayList.add(interfaceC0526Fp.mo13invoke(t, t2));
            t = t2;
        }
        return arrayList;
    }
}
