package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class KW implements InterfaceC3430mv, Serializable {
    public InterfaceC3588op a;
    public Object b;

    public KW(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "initializer");
        this.a = interfaceC3588op;
        this.b = C3314lW.a;
    }

    @Override // defpackage.InterfaceC3430mv
    public Object getValue() {
        if (this.b == C3314lW.a) {
            InterfaceC3588op interfaceC3588op = this.a;
            AbstractC4492zt.e(interfaceC3588op);
            this.b = interfaceC3588op.invoke();
            this.a = null;
        }
        return this.b;
    }

    @Override // defpackage.InterfaceC3430mv
    public boolean isInitialized() {
        return this.b != C3314lW.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
