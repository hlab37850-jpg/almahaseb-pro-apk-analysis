package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: cT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1875cT implements InterfaceC3430mv, Serializable {
    public InterfaceC3588op a;
    public volatile Object b;
    public final Object c;

    public C1875cT(InterfaceC3588op interfaceC3588op, Object obj) {
        AbstractC4492zt.h(interfaceC3588op, "initializer");
        this.a = interfaceC3588op;
        this.b = C3314lW.a;
        this.c = obj == null ? this : obj;
    }

    @Override // defpackage.InterfaceC3430mv
    public Object getValue() {
        Object objInvoke;
        Object obj = this.b;
        C3314lW c3314lW = C3314lW.a;
        if (obj != c3314lW) {
            return obj;
        }
        synchronized (this.c) {
            objInvoke = this.b;
            if (objInvoke == c3314lW) {
                InterfaceC3588op interfaceC3588op = this.a;
                AbstractC4492zt.e(interfaceC3588op);
                objInvoke = interfaceC3588op.invoke();
                this.b = objInvoke;
                this.a = null;
            }
        }
        return objInvoke;
    }

    @Override // defpackage.InterfaceC3430mv
    public boolean isInitialized() {
        return this.b != C3314lW.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ C1875cT(InterfaceC3588op interfaceC3588op, Object obj, int i, AbstractC0419Di abstractC0419Di) {
        this(interfaceC3588op, (i & 2) != 0 ? null : obj);
    }
}
