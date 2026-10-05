package defpackage;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class Zb0 {
    public final ConcurrentHashMap a = new ConcurrentHashMap(16, 0.75f, 10);
    public final ReferenceQueue b = new ReferenceQueue();

    public final List a(Throwable th, boolean z) {
        Reference referencePoll = this.b.poll();
        while (referencePoll != null) {
            this.a.remove(referencePoll);
            referencePoll = this.b.poll();
        }
        List list = (List) this.a.get(new Wb0(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List list2 = (List) this.a.putIfAbsent(new Wb0(th, this.b), vector);
        return list2 == null ? vector : list2;
    }
}
