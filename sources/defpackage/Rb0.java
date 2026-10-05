package defpackage;

import com.google.android.gms.internal.clearcut.zzfa;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class Rb0 implements Iterator {
    public Iterator a;
    public final /* synthetic */ zzfa b;

    public Rb0(zzfa zzfaVar) {
        this.b = zzfaVar;
        this.a = zzfaVar.zzpb.iterator();
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
