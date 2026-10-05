package defpackage;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: sN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3875sN implements InterfaceC3430mv, Serializable {
    public static final a d = new a(null);
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(C3875sN.class, Object.class, "b");
    public volatile InterfaceC3588op a;
    public volatile Object b;
    public final Object c;

    /* JADX INFO: renamed from: sN$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
        }
    }

    public C3875sN(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "initializer");
        this.a = interfaceC3588op;
        C3314lW c3314lW = C3314lW.a;
        this.b = c3314lW;
        this.c = c3314lW;
    }

    @Override // defpackage.InterfaceC3430mv
    public Object getValue() {
        Object obj = this.b;
        C3314lW c3314lW = C3314lW.a;
        if (obj != c3314lW) {
            return obj;
        }
        InterfaceC3588op interfaceC3588op = this.a;
        if (interfaceC3588op != null) {
            Object objInvoke = interfaceC3588op.invoke();
            if (AbstractC2403i0.a(e, this, c3314lW, objInvoke)) {
                this.a = null;
                return objInvoke;
            }
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
