package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: Kv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0706Kv implements InterfaceC0624Jj, InterfaceC0694Kj {
    public List a;
    public volatile boolean b;

    @Override // defpackage.InterfaceC0694Kj
    public boolean a(InterfaceC0624Jj interfaceC0624Jj) {
        Objects.requireNonNull(interfaceC0624Jj, "d is null");
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        List linkedList = this.a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.a = linkedList;
                        }
                        linkedList.add(interfaceC0624Jj);
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        interfaceC0624Jj.dispose();
        return false;
    }

    @Override // defpackage.InterfaceC0694Kj
    public boolean b(InterfaceC0624Jj interfaceC0624Jj) {
        if (!c(interfaceC0624Jj)) {
            return false;
        }
        interfaceC0624Jj.dispose();
        return true;
    }

    @Override // defpackage.InterfaceC0694Kj
    public boolean c(InterfaceC0624Jj interfaceC0624Jj) {
        Objects.requireNonNull(interfaceC0624Jj, "Disposable item is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return false;
                }
                List list = this.a;
                if (list != null && list.remove(interfaceC0624Jj)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(List list) {
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                ((InterfaceC0624Jj) it.next()).dispose();
            } catch (Throwable th) {
                AbstractC0722Ll.b(th);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new C0441Ee(arrayList);
            }
            throw AbstractC0696Kl.f((Throwable) arrayList.get(0));
        }
    }

    @Override // defpackage.InterfaceC0624Jj
    public void dispose() {
        if (this.b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                List list = this.a;
                this.a = null;
                d(list);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.InterfaceC0624Jj
    public boolean isDisposed() {
        return this.b;
    }
}
