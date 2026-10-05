package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: cb0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1885cb0 implements Iterator {
    public int a;
    public Iterator b;
    public final /* synthetic */ Za0 c;

    public C1885cb0(Za0 za0) {
        this.c = za0;
        this.a = za0.b.size();
    }

    public final Iterator a() {
        if (this.b == null) {
            this.b = this.c.f.entrySet().iterator();
        }
        return this.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.a;
        return (i > 0 && i <= this.c.b.size()) || a().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Object next;
        if (a().hasNext()) {
            next = a().next();
        } else {
            List list = this.c.b;
            int i = this.a - 1;
            this.a = i;
            next = list.get(i);
        }
        return (Map.Entry) next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ C1885cb0(Za0 za0, C1804bb0 c1804bb0) {
        this(za0);
    }
}
