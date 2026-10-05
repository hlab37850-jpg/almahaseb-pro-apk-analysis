package androidx.compose.ui.text;

import com.itextpdf.text.Annotation;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2371hc;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TempListUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void appendElement(Appendable appendable, T t, InterfaceC3750qp interfaceC3750qp) throws IOException {
        if (interfaceC3750qp != null) {
            appendable.append((CharSequence) interfaceC3750qp.invoke(t));
            return;
        }
        if (t == 0 ? true : t instanceof CharSequence) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }

    public static final <T, K> List<T> fastDistinctBy(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "selector");
        HashSet hashSet = new HashSet(list.size());
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            if (hashSet.add(interfaceC3750qp.invoke(t))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> fastDrop(List<? extends T> list, int i) {
        AbstractC4492zt.h(list, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return list;
        }
        int size = list.size() - i;
        if (size <= 0) {
            return AbstractC1886cc.m();
        }
        if (size == 1) {
            return AbstractC1805bc.e(AbstractC3240kc.k0(list));
        }
        ArrayList arrayList = new ArrayList(size);
        int size2 = list.size();
        while (i < size2) {
            arrayList.add(list.get(i));
            i++;
        }
        return arrayList;
    }

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

    public static final <T> List<T> fastFilterNot(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            if (!((Boolean) interfaceC3750qp.invoke(t)).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> fastFilterNotNull(List<? extends T> list) {
        AbstractC4492zt.h(list, "<this>");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T, R> List<R> fastFlatMap(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AbstractC2371hc.D(arrayList, (Iterable) interfaceC3750qp.invoke(list.get(i)));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, A extends Appendable> A fastJoinTo(List<? extends T> list, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp) throws IOException {
        a.append(charSequence2);
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            T t = list.get(i3);
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            appendElement(a, t, interfaceC3750qp);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <T> String fastJoinToString(List<? extends T> list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(charSequence, "separator");
        AbstractC4492zt.h(charSequence2, "prefix");
        AbstractC4492zt.h(charSequence3, "postfix");
        AbstractC4492zt.h(charSequence4, "truncated");
        String string = ((StringBuilder) fastJoinTo(list, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, interfaceC3750qp)).toString();
        AbstractC4492zt.g(string, "fastJoinTo(StringBuilder…form)\n        .toString()");
        return string;
    }

    public static /* synthetic */ String fastJoinToString$default(List list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp, int i2, Object obj) {
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
        return fastJoinToString(list, charSequence, charSequence5, charSequence6, i3, charSequence7, interfaceC3750qp);
    }

    public static final <T, R extends Comparable<? super R>> T fastMinByOrNull(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
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
                if (comparable.compareTo(comparable2) > 0) {
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

    public static final <T> List<T> fastTakeWhile(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            if (!((Boolean) interfaceC3750qp.invoke(t)).booleanValue()) {
                break;
            }
            arrayList.add(t);
        }
        return arrayList;
    }
}
