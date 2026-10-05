package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: zO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4453zO extends AO implements Iterator, InterfaceC0793Of, InterfaceC0756Mu {
    public int a;
    public Object b;
    public Iterator c;
    public InterfaceC0793Of d;

    @Override // defpackage.AO
    public Object b(Object obj, InterfaceC0793Of interfaceC0793Of) {
        this.b = obj;
        this.a = 3;
        this.d = interfaceC0793Of;
        Object objD = AbstractC0378Bt.d();
        if (objD == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    @Override // defpackage.AO
    public Object d(Iterator it, InterfaceC0793Of interfaceC0793Of) {
        if (!it.hasNext()) {
            return FW.a;
        }
        this.c = it;
        this.a = 2;
        this.d = interfaceC0793Of;
        Object objD = AbstractC0378Bt.d();
        if (objD == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    public final Throwable f() {
        int i = this.a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    public final Object g() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // defpackage.InterfaceC0793Of
    public InterfaceC0988Vf getContext() {
        return C1172Zk.a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw f();
                }
                Iterator it = this.c;
                AbstractC4492zt.e(it);
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.c = null;
            }
            this.a = 5;
            InterfaceC0793Of interfaceC0793Of = this.d;
            AbstractC4492zt.e(interfaceC0793Of);
            this.d = null;
            KL.a aVar = KL.a;
            interfaceC0793Of.resumeWith(KL.a(FW.a));
        }
    }

    public final void l(InterfaceC0793Of interfaceC0793Of) {
        this.d = interfaceC0793Of;
    }

    @Override // java.util.Iterator
    public Object next() throws Throwable {
        int i = this.a;
        if (i == 0 || i == 1) {
            return g();
        }
        if (i == 2) {
            this.a = 1;
            Iterator it = this.c;
            AbstractC4492zt.e(it);
            return it.next();
        }
        if (i != 3) {
            throw f();
        }
        this.a = 0;
        Object obj = this.b;
        this.b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // defpackage.InterfaceC0793Of
    public void resumeWith(Object obj) throws Throwable {
        LL.b(obj);
        this.a = 4;
    }
}
