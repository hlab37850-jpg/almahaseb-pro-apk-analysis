package defpackage;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: renamed from: z2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4423z2 extends Ordering implements Serializable {
    public static final C4423z2 a = new C4423z2();

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.Ordering
    public ImmutableList immutableSortedCopy(Iterable iterable) {
        return ImmutableList.copyOf(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public List sortedCopy(Iterable iterable) {
        return Lists.newArrayList(iterable);
    }

    public String toString() {
        return "Ordering.allEqual()";
    }

    @Override // com.google.common.collect.Ordering
    public Ordering reverse() {
        return this;
    }
}
