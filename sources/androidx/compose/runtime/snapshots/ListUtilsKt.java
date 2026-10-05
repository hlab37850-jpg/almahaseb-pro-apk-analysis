package androidx.compose.runtime.snapshots;

import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ListUtilsKt {
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

    public static final <T> List<T> fastFilterIndexed(List<? extends T> list, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC0526Fp, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            if (((Boolean) interfaceC0526Fp.mo13invoke(Integer.valueOf(i), t)).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
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

    public static final <T, K> Map<K, List<T>> fastGroupBy(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "keySelector");
        HashMap map = new HashMap(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T t = list.get(i);
            Object objInvoke = interfaceC3750qp.invoke(t);
            Object arrayList = map.get(objInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(objInvoke, arrayList);
            }
            ((ArrayList) arrayList).add(t);
        }
        return map;
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

    public static final <T, R> List<R> fastMapNotNull(List<? extends T> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object objInvoke = interfaceC3750qp.invoke(list.get(i));
            if (objInvoke != null) {
                arrayList.add(objInvoke);
            }
        }
        return arrayList;
    }

    public static final <T> Set<T> fastToSet(List<? extends T> list) {
        AbstractC4492zt.h(list, "<this>");
        HashSet hashSet = new HashSet(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            hashSet.add(list.get(i));
        }
        return hashSet;
    }
}
