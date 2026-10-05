package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: gq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2310gq implements InterfaceC4362yO {
    public final InterfaceC3588op a;
    public final InterfaceC3750qp b;

    /* JADX INFO: renamed from: gq$a */
    public static final class a implements Iterator, InterfaceC0756Mu {
        public Object a;
        public int b = -2;

        public a() {
        }

        private final void a() {
            Object objInvoke;
            if (this.b == -2) {
                objInvoke = C2310gq.this.a.invoke();
            } else {
                InterfaceC3750qp interfaceC3750qp = C2310gq.this.b;
                Object obj = this.a;
                AbstractC4492zt.e(obj);
                objInvoke = interfaceC3750qp.invoke(obj);
            }
            this.a = objInvoke;
            this.b = objInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.b < 0) {
                a();
            }
            return this.b == 1;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.b < 0) {
                a();
            }
            if (this.b == 0) {
                throw new NoSuchElementException();
            }
            Object obj = this.a;
            AbstractC4492zt.f(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.b = -1;
            return obj;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C2310gq(InterfaceC3588op interfaceC3588op, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(interfaceC3588op, "getInitialValue");
        AbstractC4492zt.h(interfaceC3750qp, "getNextValue");
        this.a = interfaceC3588op;
        this.b = interfaceC3750qp;
    }

    @Override // defpackage.InterfaceC4362yO
    public Iterator iterator() {
        return new a();
    }
}
