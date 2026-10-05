package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: qg0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3740qg0 implements Iterator {
    public int a;
    public Iterator b;
    public final /* synthetic */ AbstractC3577og0 c;

    public C3740qg0(AbstractC3577og0 abstractC3577og0) {
        this.c = abstractC3577og0;
        this.a = abstractC3577og0.b.size();
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
        if (a().hasNext()) {
            return (Map.Entry) a().next();
        }
        List list = this.c.b;
        int i = this.a - 1;
        this.a = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ C3740qg0(AbstractC3577og0 abstractC3577og0, C3495ng0 c3495ng0) {
        this(abstractC3577og0);
    }
}
