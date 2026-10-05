package defpackage;

/* JADX INFO: renamed from: Vs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1001Vs extends C0945Ts implements InterfaceC0815Pb {
    public static final a e = new a(null);
    public static final C1001Vs f = new C1001Vs(1, 0);

    /* JADX INFO: renamed from: Vs$a */
    public static final class a {
        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final C1001Vs a() {
            return C1001Vs.f;
        }

        public a() {
        }
    }

    public C1001Vs(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // defpackage.C0945Ts
    public boolean equals(Object obj) {
        if (obj instanceof C1001Vs) {
            if (!isEmpty() || !((C1001Vs) obj).isEmpty()) {
                C1001Vs c1001Vs = (C1001Vs) obj;
                if (b() != c1001Vs.b() || c() != c1001Vs.c()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean g(int i) {
        return b() <= i && i <= c();
    }

    @Override // defpackage.InterfaceC0815Pb
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Integer getEndInclusive() {
        return Integer.valueOf(c());
    }

    @Override // defpackage.C0945Ts
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (b() * 31) + c();
    }

    @Override // defpackage.C0945Ts, defpackage.InterfaceC0815Pb
    public boolean isEmpty() {
        return b() > c();
    }

    @Override // defpackage.InterfaceC0815Pb
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Integer getStart() {
        return Integer.valueOf(b());
    }

    @Override // defpackage.C0945Ts
    public String toString() {
        return b() + ".." + c();
    }
}
