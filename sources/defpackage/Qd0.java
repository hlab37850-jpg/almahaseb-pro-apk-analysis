package defpackage;

import com.google.android.gms.internal.auth.zzhd;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class Qd0 implements Iterator {
    public final Iterator a;
    public final /* synthetic */ zzhd b;

    public Qd0(zzhd zzhdVar) {
        this.b = zzhdVar;
        this.a = zzhdVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
