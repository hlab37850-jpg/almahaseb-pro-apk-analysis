package com.google.common.collect;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends Ordering implements Serializable {
    public final ImmutableMap a;

    public p(List list) {
        this(Maps.indexMap(list));
    }

    public final int a(Object obj) {
        Integer num = (Integer) this.a.get(obj);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.c(obj);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return a(obj) - a(obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.a.equals(((p) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        String strValueOf = String.valueOf(this.a.keySet());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 19);
        sb.append("Ordering.explicit(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }

    public p(ImmutableMap immutableMap) {
        this.a = immutableMap;
    }
}
