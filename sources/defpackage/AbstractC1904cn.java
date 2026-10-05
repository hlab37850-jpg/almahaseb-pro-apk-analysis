package defpackage;

/* JADX INFO: renamed from: cn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC1904cn {
    public static final InterfaceC3750qp a = b.a;
    public static final InterfaceC0526Fp b = a.a;

    /* JADX INFO: renamed from: cn$a */
    public static final class a extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean mo13invoke(Object obj, Object obj2) {
            return Boolean.valueOf(AbstractC4492zt.d(obj, obj2));
        }
    }

    public static final InterfaceC0939Tm a(InterfaceC0939Tm interfaceC0939Tm) {
        return interfaceC0939Tm instanceof CR ? interfaceC0939Tm : b(interfaceC0939Tm, a, b);
    }

    public static final InterfaceC0939Tm b(InterfaceC0939Tm interfaceC0939Tm, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp) {
        if (interfaceC0939Tm instanceof C0884Rj) {
            C0884Rj c0884Rj = (C0884Rj) interfaceC0939Tm;
            if (c0884Rj.b == interfaceC3750qp && c0884Rj.c == interfaceC0526Fp) {
                return interfaceC0939Tm;
            }
        }
        return new C0884Rj(interfaceC0939Tm, interfaceC3750qp, interfaceC0526Fp);
    }

    /* JADX INFO: renamed from: cn$b */
    public static final class b extends AbstractC2233fv implements InterfaceC3750qp {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(Object obj) {
            return obj;
        }
    }
}
