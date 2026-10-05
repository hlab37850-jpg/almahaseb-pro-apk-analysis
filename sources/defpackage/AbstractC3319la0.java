package defpackage;

import com.google.android.gms.internal.vision.zzde;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: la0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3319la0 implements Iterator {
    public int a;
    public int b;
    public int c;
    public final /* synthetic */ V90 d;

    public AbstractC3319la0(V90 v90) {
        this.d = v90;
        this.a = v90.e;
        this.b = v90.s();
        this.c = -1;
    }

    public abstract Object a(int i);

    public final void b() {
        if (this.d.e != this.a) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b >= 0;
    }

    @Override // java.util.Iterator
    public Object next() {
        b();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.b;
        this.c = i;
        Object objA = a(i);
        this.b = this.d.a(this.b);
        return objA;
    }

    @Override // java.util.Iterator
    public void remove() {
        b();
        zzde.zzb(this.c >= 0, "no calls to next() since the last call to remove()");
        this.a += 32;
        V90 v90 = this.d;
        v90.remove(v90.c[this.c]);
        this.b = V90.k(this.b, this.c);
        this.c = -1;
    }

    public /* synthetic */ AbstractC3319la0(V90 v90, C1802ba0 c1802ba0) {
        this(v90);
    }
}
