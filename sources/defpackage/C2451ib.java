package defpackage;

/* JADX INFO: renamed from: ib, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2451ib {
    public static final b b = new b(null);
    public static final c c = new c();
    public final Object a;

    /* JADX INFO: renamed from: ib$a */
    public static final class a extends c {
        public final Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && AbstractC4492zt.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // defpackage.C2451ib.c
        public String toString() {
            return "Closed(" + this.a + ')';
        }
    }

    /* JADX INFO: renamed from: ib$b */
    public static final class b {
        public /* synthetic */ b(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Object a(Throwable th) {
            return C2451ib.c(new a(th));
        }

        public final Object b() {
            return C2451ib.c(C2451ib.c);
        }

        public final Object c(Object obj) {
            return C2451ib.c(obj);
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: ib$c */
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ C2451ib(Object obj) {
        this.a = obj;
    }

    public static final /* synthetic */ C2451ib b(Object obj) {
        return new C2451ib(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof C2451ib) && AbstractC4492zt.d(obj, ((C2451ib) obj2).l());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.a;
        }
        return null;
    }

    public static final Object f(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static final Object g(Object obj) throws Throwable {
        Throwable th;
        if (!(obj instanceof c)) {
            return obj;
        }
        if ((obj instanceof a) && (th = ((a) obj).a) != null) {
            throw th;
        }
        throw new IllegalStateException(("Trying to call 'getOrThrow' on a failed channel result: " + obj).toString());
    }

    public static int h(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean i(Object obj) {
        return obj instanceof a;
    }

    public static final boolean j(Object obj) {
        return !(obj instanceof c);
    }

    public static String k(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public int hashCode() {
        return h(this.a);
    }

    public final /* synthetic */ Object l() {
        return this.a;
    }

    public String toString() {
        return k(this.a);
    }

    public static Object c(Object obj) {
        return obj;
    }
}
