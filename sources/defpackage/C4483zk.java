package defpackage;

import java.util.Iterator;

/* JADX INFO: renamed from: zk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4483zk implements InterfaceC4362yO, InterfaceC0343Ak {
    public final InterfaceC4362yO a;
    public final int b;

    /* JADX INFO: renamed from: zk$a */
    public static final class a implements Iterator, InterfaceC0756Mu {
        public final Iterator a;
        public int b;

        public a(C4483zk c4483zk) {
            this.a = c4483zk.a.iterator();
            this.b = c4483zk.b;
        }

        public final void a() {
            while (this.b > 0 && this.a.hasNext()) {
                this.a.next();
                this.b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C4483zk(InterfaceC4362yO interfaceC4362yO, int i) {
        AbstractC4492zt.h(interfaceC4362yO, "sequence");
        this.a = interfaceC4362yO;
        this.b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // defpackage.InterfaceC0343Ak
    public InterfaceC4362yO a(int i) {
        int i2 = this.b;
        int i3 = i2 + i;
        return i3 < 0 ? new C4043uT(this, i) : new GS(this.a, i2, i3);
    }

    @Override // defpackage.InterfaceC0343Ak
    public InterfaceC4362yO b(int i) {
        int i2 = this.b + i;
        return i2 < 0 ? new C4483zk(this, i) : new C4483zk(this.a, i2);
    }

    @Override // defpackage.InterfaceC4362yO
    public Iterator iterator() {
        return new a(this);
    }
}
