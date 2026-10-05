package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class TL extends Ordering implements Serializable {
    public final Ordering a;

    public TL(Ordering ordering) {
        this.a = (Ordering) Preconditions.checkNotNull(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.a.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TL) {
            return this.a.equals(((TL) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return -this.a.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    public Object max(Object obj, Object obj2) {
        return this.a.min(obj, obj2);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Object obj, Object obj2) {
        return this.a.max(obj, obj2);
    }

    @Override // com.google.common.collect.Ordering
    public Ordering reverse() {
        return this.a;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 10);
        sb.append(strValueOf);
        sb.append(".reverse()");
        return sb.toString();
    }

    @Override // com.google.common.collect.Ordering
    public Object max(Object obj, Object obj2, Object obj3, Object... objArr) {
        return this.a.min(obj, obj2, obj3, objArr);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Object obj, Object obj2, Object obj3, Object... objArr) {
        return this.a.max(obj, obj2, obj3, objArr);
    }

    @Override // com.google.common.collect.Ordering
    public Object max(Iterator it) {
        return this.a.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Iterator it) {
        return this.a.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public Object max(Iterable iterable) {
        return this.a.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Iterable iterable) {
        return this.a.max(iterable);
    }
}
