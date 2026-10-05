package defpackage;

import com.google.android.gms.internal.vision.zzlz;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class Jg0 implements Iterator {
    public Iterator a;
    public final /* synthetic */ zzlz b;

    public Jg0(zzlz zzlzVar) {
        this.b = zzlzVar;
        this.a = zzlzVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return (String) this.a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
