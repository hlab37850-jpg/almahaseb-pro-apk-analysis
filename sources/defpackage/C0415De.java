package defpackage;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: renamed from: De, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0415De implements InterfaceC0624Jj, InterfaceC0694Kj {
    public RE a;
    public volatile boolean b;

    @Override // defpackage.InterfaceC0694Kj
    public boolean a(InterfaceC0624Jj interfaceC0624Jj) {
        Objects.requireNonNull(interfaceC0624Jj, "disposable is null");
        if (!this.b) {
            synchronized (this) {
                try {
                    if (!this.b) {
                        RE re = this.a;
                        if (re == null) {
                            re = new RE();
                            this.a = re;
                        }
                        re.a(interfaceC0624Jj);
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
        Objects.requireNonNull(interfaceC0624Jj, "disposable is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.b) {
                    return false;
                }
                RE re = this.a;
                if (re != null && re.e(interfaceC0624Jj)) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(RE re) {
        if (re == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : re.b()) {
            if (obj instanceof InterfaceC0624Jj) {
                try {
                    ((InterfaceC0624Jj) obj).dispose();
                } catch (Throwable th) {
                    AbstractC0722Ll.b(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
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
                RE re = this.a;
                this.a = null;
                d(re);
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
