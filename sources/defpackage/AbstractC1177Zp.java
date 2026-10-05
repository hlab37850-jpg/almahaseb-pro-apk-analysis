package defpackage;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: renamed from: Zp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1177Zp {
    public static final InterfaceC0777Np a = new g();
    public static final Runnable b = new d();
    public static final Y1 c = new a();
    public static final InterfaceC2295gf d = new b();
    public static final InterfaceC2295gf e = new e();
    public static final InterfaceC2295gf f = new j();
    public static final InterfaceC1751ax g = new c();
    public static final CH h = new k();
    public static final CH i = new f();
    public static final US j = new i();
    public static final InterfaceC2295gf k = new h();

    /* JADX INFO: renamed from: Zp$c */
    public static final class c implements InterfaceC1751ax {
    }

    /* JADX INFO: renamed from: Zp$e */
    public static final class e implements InterfaceC2295gf {
        @Override // defpackage.InterfaceC2295gf
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            FM.m(th);
        }
    }

    /* JADX INFO: renamed from: Zp$f */
    public static final class f implements CH {
        @Override // defpackage.CH
        public boolean test(Object obj) {
            return false;
        }
    }

    /* JADX INFO: renamed from: Zp$h */
    public static final class h implements InterfaceC2295gf {
        @Override // defpackage.InterfaceC2295gf
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(PS ps) {
            ps.l(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    /* JADX INFO: renamed from: Zp$i */
    public static final class i implements US {
        @Override // defpackage.US
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: renamed from: Zp$j */
    public static final class j implements InterfaceC2295gf {
        @Override // defpackage.InterfaceC2295gf
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            FM.m(new JE(th));
        }
    }

    /* JADX INFO: renamed from: Zp$k */
    public static final class k implements CH {
        @Override // defpackage.CH
        public boolean test(Object obj) {
            return true;
        }
    }

    public static CH a() {
        return h;
    }

    public static InterfaceC2295gf b() {
        return d;
    }

    /* JADX INFO: renamed from: Zp$a */
    public static final class a implements Y1 {
        public String toString() {
            return "EmptyAction";
        }

        @Override // defpackage.Y1
        public void run() {
        }
    }

    /* JADX INFO: renamed from: Zp$b */
    public static final class b implements InterfaceC2295gf {
        public String toString() {
            return "EmptyConsumer";
        }

        @Override // defpackage.InterfaceC2295gf
        public void accept(Object obj) {
        }
    }

    /* JADX INFO: renamed from: Zp$d */
    public static final class d implements Runnable {
        public String toString() {
            return "EmptyRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: renamed from: Zp$g */
    public static final class g implements InterfaceC0777Np {
        public String toString() {
            return "IdentityFunction";
        }

        @Override // defpackage.InterfaceC0777Np
        public Object apply(Object obj) {
            return obj;
        }
    }
}
