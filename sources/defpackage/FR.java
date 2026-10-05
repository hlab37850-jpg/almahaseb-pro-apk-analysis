package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class FR extends AbstractC3436n0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(FR.class, Object.class, "_state");
    volatile /* synthetic */ Object _state = null;

    @Override // defpackage.AbstractC3436n0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(DR dr) {
        if (this._state != null) {
            return false;
        }
        this._state = ER.a;
        return true;
    }

    public final Object d(InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        if (!AbstractC2403i0.a(a, this, ER.a, c4374ya)) {
            KL.a aVar = KL.a;
            c4374ya.resumeWith(KL.a(FW.a));
        }
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX == AbstractC0378Bt.d() ? objX : FW.a;
    }

    @Override // defpackage.AbstractC3436n0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public InterfaceC0793Of[] b(DR dr) {
        this._state = null;
        return AbstractC3354m0.a;
    }

    public final void f() {
        while (true) {
            Object obj = this._state;
            if (obj == null || obj == ER.b) {
                return;
            }
            if (obj == ER.a) {
                if (AbstractC2403i0.a(a, this, obj, ER.b)) {
                    return;
                }
            } else if (AbstractC2403i0.a(a, this, obj, ER.a)) {
                KL.a aVar = KL.a;
                ((C4374ya) obj).resumeWith(KL.a(FW.a));
                return;
            }
        }
    }

    public final boolean g() {
        Object andSet = a.getAndSet(this, ER.a);
        AbstractC4492zt.e(andSet);
        return andSet == ER.b;
    }
}
