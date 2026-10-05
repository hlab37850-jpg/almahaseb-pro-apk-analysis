package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: Gw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0559Gw {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(C0559Gw.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public C0559Gw(boolean z) {
        this._cur = new C0585Hw(8, z);
    }

    public final boolean a(Object obj) {
        while (true) {
            C0585Hw c0585Hw = (C0585Hw) this._cur;
            int iA = c0585Hw.a(obj);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                AbstractC2403i0.a(a, this, c0585Hw, c0585Hw.i());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            C0585Hw c0585Hw = (C0585Hw) this._cur;
            if (c0585Hw.d()) {
                return;
            } else {
                AbstractC2403i0.a(a, this, c0585Hw, c0585Hw.i());
            }
        }
    }

    public final int c() {
        return ((C0585Hw) this._cur).f();
    }

    public final Object d() {
        while (true) {
            C0585Hw c0585Hw = (C0585Hw) this._cur;
            Object objJ = c0585Hw.j();
            if (objJ != C0585Hw.h) {
                return objJ;
            }
            AbstractC2403i0.a(a, this, c0585Hw, c0585Hw.i());
        }
    }
}
