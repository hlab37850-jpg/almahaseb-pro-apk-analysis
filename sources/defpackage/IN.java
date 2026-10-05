package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IN {
    public static final AN a = FM.h(new h());
    public static final AN b = FM.e(new b());
    public static final AN c = FM.f(new c());
    public static final AN d = C1877cV.a();
    public static final AN e = FM.g(new f());

    public static final class a {
        public static final AN a = new C0689Ke();
    }

    public static final class b implements US {
        @Override // defpackage.US
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AN get() {
            return a.a;
        }
    }

    public static final class c implements US {
        @Override // defpackage.US
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AN get() {
            return d.a;
        }
    }

    public static final class d {
        public static final AN a = new C0608It();
    }

    public static final class e {
        public static final AN a = new C4027uD();
    }

    public static final class f implements US {
        @Override // defpackage.US
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AN get() {
            return e.a;
        }
    }

    public static final class g {
        public static final AN a = new HQ();
    }

    public static final class h implements US {
        @Override // defpackage.US
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AN get() {
            return g.a;
        }
    }

    public static AN a(Executor executor) {
        return b(executor, false, false);
    }

    public static AN b(Executor executor, boolean z, boolean z2) {
        return FM.d(executor, z, z2);
    }

    public static AN c() {
        return FM.n(c);
    }

    public static AN d() {
        return FM.p(a);
    }
}
