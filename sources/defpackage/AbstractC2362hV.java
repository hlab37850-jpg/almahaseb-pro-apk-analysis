package defpackage;

import com.google.common.base.Preconditions;
import java.util.Iterator;

/* JADX INFO: renamed from: hV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2362hV implements Iterator {
    public final Iterator a;

    public AbstractC2362hV(Iterator it) {
        this.a = (Iterator) Preconditions.checkNotNull(it);
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}
