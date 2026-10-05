package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: uT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4043uT implements InterfaceC4362yO, InterfaceC0343Ak {
    public final InterfaceC4362yO a;
    public final int b;

    /* JADX INFO: renamed from: uT$a */
    public static final class a implements Iterator, InterfaceC0756Mu {
        public int a;
        public final Iterator b;

        public a(C4043uT c4043uT) {
            this.a = c4043uT.b;
            this.b = c4043uT.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a > 0 && this.b.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            int i = this.a;
            if (i == 0) {
                throw new NoSuchElementException();
            }
            this.a = i - 1;
            return this.b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C4043uT(InterfaceC4362yO interfaceC4362yO, int i) {
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
        return i >= this.b ? this : new C4043uT(this.a, i);
    }

    @Override // defpackage.InterfaceC0343Ak
    public InterfaceC4362yO b(int i) {
        int i2 = this.b;
        return i >= i2 ? DO.e() : new GS(this.a, i, i2);
    }

    @Override // defpackage.InterfaceC4362yO
    public Iterator iterator() {
        return new a(this);
    }
}
