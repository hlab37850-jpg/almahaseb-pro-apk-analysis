package defpackage;

import com.google.android.gms.internal.vision.zzjp;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: xf0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4304xf0 implements Iterator {
    public Iterator a;

    public C4304xf0(Iterator it) {
        this.a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.a.next();
        return entry.getValue() instanceof zzjp ? new C4476zf0(entry) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}
