package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: renamed from: hc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2371hc extends AbstractC2289gc {
    public static boolean C(Collection collection, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(collection, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "elements");
        Iterator it = interfaceC4362yO.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static boolean D(Collection collection, Iterable iterable) {
        AbstractC4492zt.h(collection, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static boolean E(Collection collection, Object[] objArr) {
        AbstractC4492zt.h(collection, "<this>");
        AbstractC4492zt.h(objArr, "elements");
        return collection.addAll(Q5.c(objArr));
    }

    public static final Collection F(Iterable iterable) {
        AbstractC4492zt.h(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            iterable = AbstractC3240kc.C0(iterable);
        }
        return (Collection) iterable;
    }

    public static final boolean G(Iterable iterable, InterfaceC3750qp interfaceC3750qp, boolean z) {
        Iterator it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (((Boolean) interfaceC3750qp.invoke(it.next())).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static final boolean H(List list, InterfaceC3750qp interfaceC3750qp, boolean z) {
        int i;
        if (!(list instanceof RandomAccess)) {
            AbstractC4492zt.f(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return G(NV.b(list), interfaceC3750qp, z);
        }
        int iO = AbstractC1886cc.o(list);
        if (iO >= 0) {
            int i2 = 0;
            i = 0;
            while (true) {
                Object obj = list.get(i2);
                if (((Boolean) interfaceC3750qp.invoke(obj)).booleanValue() != z) {
                    if (i != i2) {
                        list.set(i, obj);
                    }
                    i++;
                }
                if (i2 == iO) {
                    break;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        int iO2 = AbstractC1886cc.o(list);
        if (i > iO2) {
            return true;
        }
        while (true) {
            list.remove(iO2);
            if (iO2 == i) {
                return true;
            }
            iO2--;
        }
    }

    public static boolean I(Iterable iterable, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(iterable, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        return G(iterable, interfaceC3750qp, true);
    }

    public static boolean J(Collection collection, InterfaceC4362yO interfaceC4362yO) {
        AbstractC4492zt.h(collection, "<this>");
        AbstractC4492zt.h(interfaceC4362yO, "elements");
        List listV = FO.v(interfaceC4362yO);
        return !listV.isEmpty() && collection.removeAll(listV);
    }

    public static boolean K(Collection collection, Iterable iterable) {
        AbstractC4492zt.h(collection, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        return collection.removeAll(F(iterable));
    }

    public static boolean L(Collection collection, Object[] objArr) {
        AbstractC4492zt.h(collection, "<this>");
        AbstractC4492zt.h(objArr, "elements");
        return !(objArr.length == 0) && collection.removeAll(Q5.c(objArr));
    }

    public static boolean M(List list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(list, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        return H(list, interfaceC3750qp, true);
    }

    public static Object N(List list) {
        AbstractC4492zt.h(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    public static Object O(List list) {
        AbstractC4492zt.h(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    public static Object P(List list) {
        AbstractC4492zt.h(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(AbstractC1886cc.o(list));
    }

    public static boolean Q(Iterable iterable, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(iterable, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        return G(iterable, interfaceC3750qp, false);
    }

    public static boolean R(Collection collection, Iterable iterable) {
        AbstractC4492zt.h(collection, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        return collection.retainAll(F(iterable));
    }
}
