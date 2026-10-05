package defpackage;

import com.google.android.gms.internal.play_billing.zzhc;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Ld0 implements Iterator {
    public int a;
    public boolean b;
    public Iterator c;
    public final /* synthetic */ Sd0 d;

    public /* synthetic */ Ld0(Sd0 sd0, zzhc zzhcVar) {
        Objects.requireNonNull(sd0);
        this.d = sd0;
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
        int i = this.a + 1;
        Sd0 sd0 = this.d;
        if (i >= sd0.b) {
            return !sd0.c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.b = true;
        int i = this.a + 1;
        this.a = i;
        Sd0 sd0 = this.d;
        return i < sd0.b ? (C4300xd0) sd0.a[i] : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.b = false;
        Sd0 sd0 = this.d;
        sd0.p();
        int i = this.a;
        if (i >= sd0.b) {
            a().remove();
        } else {
            this.a = i - 1;
            sd0.n(i);
        }
    }
}
