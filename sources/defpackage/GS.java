package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class GS implements InterfaceC4362yO, InterfaceC0343Ak {
    public final InterfaceC4362yO a;
    public final int b;
    public final int c;

    public static final class a implements Iterator, InterfaceC0756Mu {
        public final Iterator a;
        public int b;

        public a() {
            this.a = GS.this.a.iterator();
        }

        private final void a() {
            while (this.b < GS.this.b && this.a.hasNext()) {
                this.a.next();
                this.b++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.b < GS.this.c && this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (this.b >= GS.this.c) {
                throw new NoSuchElementException();
            }
            this.b++;
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public GS(InterfaceC4362yO interfaceC4362yO, int i, int i2) {
        AbstractC4492zt.h(interfaceC4362yO, "sequence");
        this.a = interfaceC4362yO;
        this.b = i;
        this.c = i2;
        if (i < 0) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i2).toString());
        }
        if (i2 >= i) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i2 + " < " + i).toString());
    }

    @Override // defpackage.InterfaceC0343Ak
    public InterfaceC4362yO a(int i) {
        if (i >= f()) {
            return this;
        }
        InterfaceC4362yO interfaceC4362yO = this.a;
        int i2 = this.b;
        return new GS(interfaceC4362yO, i2, i + i2);
    }

    @Override // defpackage.InterfaceC0343Ak
    public InterfaceC4362yO b(int i) {
        return i >= f() ? DO.e() : new GS(this.a, this.b + i, this.c);
    }

    public final int f() {
        return this.c - this.b;
    }

    @Override // defpackage.InterfaceC4362yO
    public Iterator iterator() {
        return new a();
    }
}
