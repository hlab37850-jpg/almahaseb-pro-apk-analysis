package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Y5 extends PE {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(Y5.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = X5.a;

    @Override // defpackage.PE
    public final Object c(Object obj) {
        Object objE = this._consensus;
        if (objE == X5.a) {
            objE = e(g(obj));
        }
        d(obj, objE);
        return objE;
    }

    public abstract void d(Object obj, Object obj2);

    public final Object e(Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = X5.a;
        if (obj2 != obj3) {
            return obj2;
        }
        return AbstractC2403i0.a(a, this, obj3, obj) ? obj : this._consensus;
    }

    public long f() {
        return 0L;
    }

    public abstract Object g(Object obj);

    @Override // defpackage.PE
    public Y5 a() {
        return this;
    }
}
