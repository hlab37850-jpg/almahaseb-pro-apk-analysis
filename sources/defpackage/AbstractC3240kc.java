package defpackage;

import com.itextpdf.text.Annotation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: renamed from: kc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3240kc extends AbstractC3158jc {

    /* JADX INFO: renamed from: kc$a */
    public static final class a implements InterfaceC4362yO {
        public final /* synthetic */ Iterable a;

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // defpackage.InterfaceC4362yO
        public Iterator iterator() {
            return this.a.iterator();
        }
    }

    public static float[] A0(Collection collection) {
        AbstractC4492zt.h(collection, "<this>");
        float[] fArr = new float[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = ((Number) it.next()).floatValue();
            i++;
        }
        return fArr;
    }

    public static int[] B0(Collection collection) {
        AbstractC4492zt.h(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Number) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public static List C0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return AbstractC1886cc.t(E0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return AbstractC1886cc.m();
        }
        if (size != 1) {
            return F0(collection);
        }
        return AbstractC1805bc.e(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static long[] D0(Collection collection) {
        AbstractC4492zt.h(collection, "<this>");
        long[] jArr = new long[collection.size()];
        Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            jArr[i] = ((Number) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public static final List E0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        return iterable instanceof Collection ? F0((Collection) iterable) : (List) z0(iterable, new ArrayList());
    }

    public static List F0(Collection collection) {
        AbstractC4492zt.h(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set G0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        return iterable instanceof Collection ? new LinkedHashSet((Collection) iterable) : (Set) z0(iterable, new LinkedHashSet());
    }

    public static Set H0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return QO.g((Set) z0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return QO.e();
        }
        if (size != 1) {
            return (Set) z0(iterable, new LinkedHashSet(AbstractC4162vx.d(collection.size())));
        }
        return PO.c(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final List I0(Iterable iterable, int i, int i2, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(iterable, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "transform");
        QQ.a(i, i2);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator itB = QQ.b(iterable.iterator(), i, i2, z, true);
            while (itB.hasNext()) {
                arrayList.add(interfaceC3750qp.invoke((List) itB.next()));
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        int i3 = 0;
        ArrayList arrayList2 = new ArrayList((size / i2) + (size % i2 == 0 ? 0 : 1));
        C3130jC c3130jC = new C3130jC(list);
        while (i3 >= 0 && i3 < size) {
            int iG = AbstractC3871sJ.g(i, size - i3);
            if (!z && iG < i) {
                break;
            }
            c3130jC.a(i3, iG + i3);
            arrayList2.add(interfaceC3750qp.invoke(c3130jC));
            i3 += i2;
        }
        return arrayList2;
    }

    public static /* synthetic */ List J0(Iterable iterable, int i, int i2, boolean z, InterfaceC3750qp interfaceC3750qp, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return I0(iterable, i, i2, z, interfaceC3750qp);
    }

    public static List K0(Iterable iterable, Iterable iterable2) {
        AbstractC4492zt.h(iterable, "<this>");
        AbstractC4492zt.h(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(AbstractC2044dc.x(iterable, 10), AbstractC2044dc.x(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(HV.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static InterfaceC4362yO T(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        return new a(iterable);
    }

    public static boolean U(Iterable iterable, Object obj) {
        AbstractC4492zt.h(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        return f0(iterable, obj) >= 0;
    }

    public static int V(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                AbstractC1886cc.v();
            }
        }
        return i;
    }

    public static List W(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        return C0(G0(iterable));
    }

    public static List X(List list, int i) {
        AbstractC4492zt.h(list, "<this>");
        if (i >= 0) {
            return y0(list, AbstractC3871sJ.d(list.size() - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static List Y(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        return (List) Z(iterable, new ArrayList());
    }

    public static final Collection Z(Iterable iterable, Collection collection) {
        AbstractC4492zt.h(iterable, "<this>");
        AbstractC4492zt.h(collection, Annotation.DESTINATION);
        for (Object obj : iterable) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static Object a0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        if (iterable instanceof List) {
            return b0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object b0(List list) {
        AbstractC4492zt.h(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object c0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object d0(List list) {
        AbstractC4492zt.h(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object e0(List list, int i) {
        AbstractC4492zt.h(list, "<this>");
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static final int f0(Iterable iterable, Object obj) {
        AbstractC4492zt.h(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i = 0;
        for (Object obj2 : iterable) {
            if (i < 0) {
                AbstractC1886cc.w();
            }
            if (AbstractC4492zt.d(obj, obj2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final Appendable g0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp) throws IOException {
        AbstractC4492zt.h(iterable, "<this>");
        AbstractC4492zt.h(appendable, "buffer");
        AbstractC4492zt.h(charSequence, "separator");
        AbstractC4492zt.h(charSequence2, "prefix");
        AbstractC4492zt.h(charSequence3, "postfix");
        AbstractC4492zt.h(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
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

    public static final String i0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(iterable, "<this>");
        AbstractC4492zt.h(charSequence, "separator");
        AbstractC4492zt.h(charSequence2, "prefix");
        AbstractC4492zt.h(charSequence3, "postfix");
        AbstractC4492zt.h(charSequence4, "truncated");
        String string = ((StringBuilder) g0(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, interfaceC3750qp)).toString();
        AbstractC4492zt.g(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String j0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, InterfaceC3750qp interfaceC3750qp, int i2, Object obj) {
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
        return i0(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, interfaceC3750qp);
    }

    public static Object k0(List list) {
        AbstractC4492zt.h(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(AbstractC1886cc.o(list));
    }

    public static Object l0(List list) {
        AbstractC4492zt.h(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Float m0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static Comparable n0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static Float o0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float fFloatValue = ((Number) it.next()).floatValue();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) it.next()).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    public static List p0(Collection collection, Iterable iterable) {
        AbstractC4492zt.h(collection, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            AbstractC2371hc.D(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List q0(Collection collection, Object obj) {
        AbstractC4492zt.h(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static List r0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return C0(iterable);
        }
        List listE0 = E0(iterable);
        AbstractC3158jc.S(listE0);
        return listE0;
    }

    public static Object s0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        if (iterable instanceof List) {
            return t0((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final Object t0(List list) {
        AbstractC4492zt.h(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static Object u0(List list) {
        AbstractC4492zt.h(list, "<this>");
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static List v0(List list, C1001Vs c1001Vs) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(c1001Vs, "indices");
        return c1001Vs.isEmpty() ? AbstractC1886cc.m() : C0(list.subList(c1001Vs.getStart().intValue(), c1001Vs.getEndInclusive().intValue() + 1));
    }

    public static List w0(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List listE0 = E0(iterable);
            AbstractC2289gc.A(listE0);
            return listE0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return C0(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        Q5.y((Comparable[]) array);
        return Q5.c(array);
    }

    public static List x0(Iterable iterable, Comparator comparator) {
        AbstractC4492zt.h(iterable, "<this>");
        AbstractC4492zt.h(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List listE0 = E0(iterable);
            AbstractC2289gc.B(listE0, comparator);
            return listE0;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return C0(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        Q5.z(array, comparator);
        return Q5.c(array);
    }

    public static final List y0(Iterable iterable, int i) {
        AbstractC4492zt.h(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return AbstractC1886cc.m();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return C0(iterable);
            }
            if (i == 1) {
                return AbstractC1805bc.e(a0(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return AbstractC1886cc.t(arrayList);
    }

    public static final Collection z0(Iterable iterable, Collection collection) {
        AbstractC4492zt.h(iterable, "<this>");
        AbstractC4492zt.h(collection, Annotation.DESTINATION);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }
}
