package defpackage;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.zxing.client.android.R;

/* JADX INFO: renamed from: oa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3564oa {
    public static final String n = "oa";
    public C3888sa a;
    public C3807ra b;
    public C3646pa c;
    public Handler d;
    public C0546Gj e;
    public Handler h;
    public boolean f = false;
    public boolean g = true;
    public C3727qa i = new C3727qa();
    public Runnable j = new c();
    public Runnable k = new d();
    public Runnable l = new e();
    public Runnable m = new f();

    /* JADX INFO: renamed from: oa$a */
    public class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3564oa.this.c.s(this.a);
        }
    }

    /* JADX INFO: renamed from: oa$b */
    public class b implements Runnable {
        public final /* synthetic */ LH a;

        /* JADX INFO: renamed from: oa$b$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C3564oa.this.c.l(b.this.a);
            }
        }

        public b(LH lh) {
            this.a = lh;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C3564oa.this.f) {
                C3564oa.this.a.c(new a());
            } else {
                Log.d(C3564oa.n, "Camera is closed, not requesting preview");
            }
        }
    }

    /* JADX INFO: renamed from: oa$c */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(C3564oa.n, "Opening camera");
                C3564oa.this.c.k();
            } catch (Exception e) {
                C3564oa.this.o(e);
                Log.e(C3564oa.n, "Failed to open camera", e);
            }
        }
    }

    /* JADX INFO: renamed from: oa$d */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(C3564oa.n, "Configuring camera");
                C3564oa.this.c.d();
                if (C3564oa.this.d != null) {
                    C3564oa.this.d.obtainMessage(R.id.zxing_prewiew_size_ready, C3564oa.this.m()).sendToTarget();
                }
            } catch (Exception e) {
                C3564oa.this.o(e);
                Log.e(C3564oa.n, "Failed to configure camera", e);
            }
        }
    }

    /* JADX INFO: renamed from: oa$e */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(C3564oa.n, "Starting preview");
                C3564oa.this.c.r(C3564oa.this.b);
                C3564oa.this.c.t();
            } catch (Exception e) {
                C3564oa.this.o(e);
                Log.e(C3564oa.n, "Failed to start preview", e);
            }
        }
    }

    /* JADX INFO: renamed from: oa$f */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(C3564oa.n, "Closing camera");
                C3564oa.this.c.u();
                C3564oa.this.c.c();
            } catch (Exception e) {
                Log.e(C3564oa.n, "Failed to close camera", e);
            }
            C3564oa.this.g = true;
            C3564oa.this.d.sendEmptyMessage(R.id.zxing_camera_closed);
            C3564oa.this.a.b();
        }
    }

    public C3564oa(Context context) {
        AbstractC3804rX.a();
        this.a = C3888sa.d();
        C3646pa c3646pa = new C3646pa(context);
        this.c = c3646pa;
        c3646pa.n(this.i);
        this.h = new Handler();
    }

    public void j() {
        AbstractC3804rX.a();
        if (this.f) {
            this.a.c(this.m);
        } else {
            this.g = true;
        }
        this.f = false;
    }

    public void k() {
        AbstractC3804rX.a();
        x();
        this.a.c(this.k);
    }

    public C0546Gj l() {
        return this.e;
    }

    public final NQ m() {
        return this.c.g();
    }

    public boolean n() {
        return this.g;
    }

    public final void o(Exception exc) {
        Handler handler = this.d;
        if (handler != null) {
            handler.obtainMessage(R.id.zxing_camera_error, exc).sendToTarget();
        }
    }

    public void p() {
        AbstractC3804rX.a();
        this.f = true;
        this.g = false;
        this.a.e(this.j);
    }

    public void q(LH lh) {
        this.h.post(new b(lh));
    }

    public void r(C3727qa c3727qa) {
        if (this.f) {
            return;
        }
        this.i = c3727qa;
        this.c.n(c3727qa);
    }

    public void s(C0546Gj c0546Gj) {
        this.e = c0546Gj;
        this.c.p(c0546Gj);
    }

    public void t(Handler handler) {
        this.d = handler;
    }

    public void u(C3807ra c3807ra) {
        this.b = c3807ra;
    }

    public void v(boolean z) {
        AbstractC3804rX.a();
        if (this.f) {
            this.a.c(new a(z));
        }
    }

    public void w() {
        AbstractC3804rX.a();
        x();
        this.a.c(this.l);
    }

    public final void x() {
        if (!this.f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }
}
