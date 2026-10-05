package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: wg0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4225wg0 implements Iterator {
    public int a;
    public boolean b;
    public Iterator c;
    public final /* synthetic */ AbstractC3577og0 d;

    public C4225wg0(AbstractC3577og0 abstractC3577og0) {
        this.d = abstractC3577og0;
        this.a = -1;
    }

    public final Iterator a() {
        if (this.c == null) {
            this.c = this.d.c.entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a + 1 < this.d.b.size() || (!this.d.c.isEmpty() && a().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.b = true;
        int i = this.a + 1;
        this.a = i;
        return i < this.d.b.size() ? (Map.Entry) this.d.b.get(this.a) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.b = false;
        this.d.q();
        if (this.a >= this.d.b.size()) {
            a().remove();
            return;
        }
        AbstractC3577og0 abstractC3577og0 = this.d;
        int i = this.a;
        this.a = i - 1;
        abstractC3577og0.l(i);
    }

    public /* synthetic */ C4225wg0(AbstractC3577og0 abstractC3577og0, C3495ng0 c3495ng0) {
        this(abstractC3577og0);
    }
}
