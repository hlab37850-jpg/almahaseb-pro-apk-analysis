package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: wm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4232wm implements InterfaceC4362yO {
    public final InterfaceC4362yO a;
    public final boolean b;
    public final InterfaceC3750qp c;

    /* JADX INFO: renamed from: wm$a */
    public static final class a implements Iterator, InterfaceC0756Mu {
        public final Iterator a;
        public int b = -1;
        public Object c;

        public a() {
            this.a = C4232wm.this.a.iterator();
        }

        public final void a() {
            while (this.a.hasNext()) {
                Object next = this.a.next();
                if (((Boolean) C4232wm.this.c.invoke(next)).booleanValue() == C4232wm.this.b) {
                    this.c = next;
                    this.b = 1;
                    return;
                }
            }
            this.b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b == -1) {
                a();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.b == -1) {
                a();
            }
            if (this.b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.c;
            this.c = null;
            this.b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C4232wm(InterfaceC4362yO interfaceC4362yO, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC4362yO, "sequence");
        AbstractC4492zt.h(interfaceC3750qp, "predicate");
        this.a = interfaceC4362yO;
        this.b = z;
        this.c = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC4362yO
    public Iterator iterator() {
        return new a();
    }
}
