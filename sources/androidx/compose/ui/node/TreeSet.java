package androidx.compose.ui.node;

import defpackage.AbstractC4492zt;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class TreeSet<E> extends java.util.TreeSet<E> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TreeSet(Comparator<? super E> comparator) {
        super(comparator);
        AbstractC4492zt.h(comparator, "comparator");
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.TreeSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
