package defpackage;

import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: renamed from: He, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0567He extends Ordering implements Serializable {
    public final Comparator[] a;

    public C0567He(Comparator comparator, Comparator comparator2) {
        this.a = new Comparator[]{comparator, comparator2};
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int i = 0;
        while (true) {
            Comparator[] comparatorArr = this.a;
            if (i >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i].compare(obj, obj2);
            if (iCompare != 0) {
                return iCompare;
            }
            i++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0567He) {
            return Arrays.equals(this.a, ((C0567He) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        String string = Arrays.toString(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 19);
        sb.append("Ordering.compound(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    public C0567He(Iterable iterable) {
        this.a = (Comparator[]) Iterables.toArray(iterable, new Comparator[0]);
    }
}
