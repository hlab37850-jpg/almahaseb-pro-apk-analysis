package defpackage;

import java.util.Iterator;

/* JADX INFO: renamed from: jV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3149jV implements InterfaceC4362yO {
    public final InterfaceC4362yO a;
    public final InterfaceC3750qp b;

    /* JADX INFO: renamed from: jV$a */
    public static final class a implements Iterator, InterfaceC0756Mu {
        public final Iterator a;

        public a() {
            this.a = C3149jV.this.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return C3149jV.this.b.invoke(this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C3149jV(InterfaceC4362yO interfaceC4362yO, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC4362yO, "sequence");
        AbstractC4492zt.h(interfaceC3750qp, "transformer");
        this.a = interfaceC4362yO;
        this.b = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC4362yO
    public Iterator iterator() {
        return new a();
    }
}
