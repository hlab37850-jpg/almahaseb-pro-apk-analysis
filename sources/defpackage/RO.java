package defpackage;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RO extends QO {
    public static Set i(Set set, Iterable iterable) {
        int size;
        AbstractC4492zt.h(set, "<this>");
        AbstractC4492zt.h(iterable, "elements");
        Integer numY = AbstractC2044dc.y(iterable);
        if (numY != null) {
            size = set.size() + numY.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(AbstractC4162vx.d(size));
        linkedHashSet.addAll(set);
        AbstractC2371hc.D(linkedHashSet, iterable);
        return linkedHashSet;
    }
}
