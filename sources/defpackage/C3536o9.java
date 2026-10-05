package defpackage;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Vector;

/* JADX INFO: renamed from: o9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3536o9 {
    public PriorityQueue a;
    public PriorityQueue b;
    public Vector c;

    /* JADX INFO: renamed from: o9$a */
    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC1781bG abstractC1781bG, AbstractC1781bG abstractC1781bG2) {
            if (abstractC1781bG.a() == abstractC1781bG2.a()) {
                return 0;
            }
            return abstractC1781bG.a() > abstractC1781bG2.a() ? 1 : -1;
        }
    }

    public C3536o9() {
        int i = InterfaceC1245af.a;
        this.b = new PriorityQueue(i, new a());
        this.a = new PriorityQueue(i, new a());
        this.c = new Vector();
    }

    public Vector a() {
        Vector vector = new Vector(this.a);
        vector.addAll(this.b);
        return vector;
    }

    public Vector b() {
        return this.c;
    }

    public void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((AbstractC1781bG) it.next()).c().recycle();
        }
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            ((AbstractC1781bG) it2.next()).c().recycle();
        }
        Iterator it3 = this.c.iterator();
        while (it3.hasNext()) {
            ((AbstractC1781bG) it3.next()).c().recycle();
        }
        this.a.clear();
        this.b.clear();
        this.c.clear();
    }
}
