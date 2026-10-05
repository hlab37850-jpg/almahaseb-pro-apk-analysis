package defpackage;

import com.google.android.gms.internal.play_billing.zzfv;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: vc0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C4136vc0 implements Iterator {
    public final Iterator a;

    public C4136vc0(Iterator it) {
        this.a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.a.next();
        return entry.getValue() instanceof zzfv ? new C3974tc0(entry, null) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.a.remove();
    }
}
