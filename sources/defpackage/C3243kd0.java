package defpackage;

import com.google.android.gms.internal.auth.zzgp;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: kd0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C3243kd0 implements Iterator {
    public int a = -1;
    public boolean b;
    public Iterator c;
    public final /* synthetic */ AbstractC3734qd0 d;

    public /* synthetic */ C3243kd0(AbstractC3734qd0 abstractC3734qd0, zzgp zzgpVar) {
        this.d = abstractC3734qd0;
    }

    public final Iterator a() {
        if (this.c == null) {
            this.c = this.d.c.entrySet().iterator();
        }
        return this.c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.a + 1 >= this.d.b.size()) {
            return !this.d.c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
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
        this.d.o();
        if (this.a >= this.d.b.size()) {
            a().remove();
            return;
        }
        AbstractC3734qd0 abstractC3734qd0 = this.d;
        int i = this.a;
        this.a = i - 1;
        abstractC3734qd0.m(i);
    }
}
