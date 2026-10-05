package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: cr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1984cr extends AbstractC2065dr implements InterfaceC1017Wi {
    private volatile C1984cr _immediate;
    public final Handler a;
    public final String b;
    public final boolean c;
    public final C1984cr d;

    /* JADX INFO: renamed from: cr$a */
    public static final class a implements Runnable {
        public final /* synthetic */ InterfaceC4293xa a;
        public final /* synthetic */ C1984cr b;

        public a(InterfaceC4293xa interfaceC4293xa, C1984cr c1984cr) {
            this.a = interfaceC4293xa;
            this.b = c1984cr;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h(this.b, FW.a);
        }
    }

    /* JADX INFO: renamed from: cr$b */
    public static final class b extends AbstractC2233fv implements InterfaceC3750qp {
        public final /* synthetic */ Runnable b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Runnable runnable) {
            super(1);
            this.b = runnable;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return FW.a;
        }

        public final void invoke(Throwable th) {
            C1984cr.this.a.removeCallbacks(this.b);
        }
    }

    public C1984cr(Handler handler, String str, boolean z) {
        super(null);
        this.a = handler;
        this.b = str;
        this.c = z;
        this._immediate = z ? this : null;
        C1984cr c1984cr = this._immediate;
        if (c1984cr == null) {
            c1984cr = new C1984cr(handler, str, true);
            this._immediate = c1984cr;
        }
        this.d = c1984cr;
    }

    public static final void N(C1984cr c1984cr, Runnable runnable) {
        c1984cr.a.removeCallbacks(runnable);
    }

    public final void L(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        AbstractC3347lu.c(interfaceC0988Vf, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        C0368Bj.b().dispatch(interfaceC0988Vf, runnable);
    }

    @Override // defpackage.AbstractC2065dr
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C1984cr I() {
        return this.d;
    }

    @Override // defpackage.InterfaceC1017Wi
    public InterfaceC0745Mj d(long j, final Runnable runnable, InterfaceC0988Vf interfaceC0988Vf) {
        if (this.a.postDelayed(runnable, AbstractC3871sJ.h(j, 4611686018427387903L))) {
            return new InterfaceC0745Mj() { // from class: br
                @Override // defpackage.InterfaceC0745Mj
                public final void dispose() {
                    C1984cr.N(this.a, runnable);
                }
            };
        }
        L(interfaceC0988Vf, runnable);
        return DD.a;
    }

    @Override // defpackage.AbstractC1040Xf
    public void dispatch(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        if (this.a.post(runnable)) {
            return;
        }
        L(interfaceC0988Vf, runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1984cr) && ((C1984cr) obj).a == this.a;
    }

    @Override // defpackage.InterfaceC1017Wi
    public void g(long j, InterfaceC4293xa interfaceC4293xa) {
        a aVar = new a(interfaceC4293xa, this);
        if (this.a.postDelayed(aVar, AbstractC3871sJ.h(j, 4611686018427387903L))) {
            interfaceC4293xa.e(new b(aVar));
        } else {
            L(interfaceC4293xa.getContext(), aVar);
        }
    }

    public int hashCode() {
        return System.identityHashCode(this.a);
    }

    @Override // defpackage.AbstractC1040Xf
    public boolean isDispatchNeeded(InterfaceC0988Vf interfaceC0988Vf) {
        return (this.c && AbstractC4492zt.d(Looper.myLooper(), this.a.getLooper())) ? false : true;
    }

    @Override // defpackage.AbstractC1040Xf
    public String toString() {
        String strH = H();
        if (strH != null) {
            return strH;
        }
        String string = this.b;
        if (string == null) {
            string = this.a.toString();
        }
        if (!this.c) {
            return string;
        }
        return string + ".immediate";
    }

    public /* synthetic */ C1984cr(Handler handler, String str, int i, AbstractC0419Di abstractC0419Di) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public C1984cr(Handler handler, String str) {
        this(handler, str, false);
    }
}
