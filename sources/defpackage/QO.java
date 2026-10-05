package defpackage;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class QO extends PO {
    public static Set e() {
        return C2387hl.a;
    }

    public static Set f(Object... objArr) {
        AbstractC4492zt.h(objArr, "elements");
        return (Set) R5.k0(objArr, new LinkedHashSet(AbstractC4162vx.d(objArr.length)));
    }

    public static final Set g(Set set) {
        AbstractC4492zt.h(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : PO.c(set.iterator().next());
        }
        return e();
    }

    public static Set h(Object... objArr) {
        AbstractC4492zt.h(objArr, "elements");
        return R5.p0(objArr);
    }
}
