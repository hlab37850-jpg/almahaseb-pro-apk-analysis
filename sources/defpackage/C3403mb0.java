package defpackage;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: mb0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3403mb0 implements Iterator {
    public int a;
    public boolean b;
    public Iterator c;
    public final /* synthetic */ Za0 d;

    public C3403mb0(Za0 za0) {
        this.d = za0;
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
        return (Map.Entry) (i < this.d.b.size() ? this.d.b.get(this.a) : a().next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.b = false;
        this.d.p();
        if (this.a >= this.d.b.size()) {
            a().remove();
            return;
        }
        Za0 za0 = this.d;
        int i = this.a;
        this.a = i - 1;
        za0.h(i);
    }

    public /* synthetic */ C3403mb0(Za0 za0, C1804bb0 c1804bb0) {
        this(za0);
    }
}
