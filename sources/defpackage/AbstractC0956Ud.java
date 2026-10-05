package defpackage;

import java.util.Comparator;

/* JADX INFO: renamed from: Ud, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0956Ud {
    public static Comparator b(final InterfaceC3750qp... interfaceC3750qpArr) {
        AbstractC4492zt.h(interfaceC3750qpArr, "selectors");
        if (interfaceC3750qpArr.length > 0) {
            return new Comparator() { // from class: Td
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return AbstractC0956Ud.c(interfaceC3750qpArr, obj, obj2);
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static final int c(InterfaceC3750qp[] interfaceC3750qpArr, Object obj, Object obj2) {
        return e(obj, obj2, interfaceC3750qpArr);
    }

    public static int d(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    public static final int e(Object obj, Object obj2, InterfaceC3750qp[] interfaceC3750qpArr) {
        for (InterfaceC3750qp interfaceC3750qp : interfaceC3750qpArr) {
            int iD = d((Comparable) interfaceC3750qp.invoke(obj), (Comparable) interfaceC3750qp.invoke(obj2));
            if (iD != 0) {
                return iD;
            }
        }
        return 0;
    }

    public static Comparator f() {
        C1778bD c1778bD = C1778bD.a;
        AbstractC4492zt.f(c1778bD, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return c1778bD;
    }
}
