package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class QJ {
    public static final RJ a;
    public static final InterfaceC0635Ju[] b;

    static {
        RJ rj = null;
        try {
            rj = (RJ) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (rj == null) {
            rj = new RJ();
        }
        a = rj;
        b = new InterfaceC0635Ju[0];
    }

    public static InterfaceC0730Lu a(AbstractC0890Rp abstractC0890Rp) {
        return a.a(abstractC0890Rp);
    }

    public static InterfaceC0635Ju b(Class cls) {
        return a.b(cls);
    }

    public static InterfaceC0705Ku c(Class cls) {
        return a.c(cls, "");
    }

    public static InterfaceC0895Ru d(AbstractC4269xC abstractC4269xC) {
        return a.d(abstractC4269xC);
    }

    public static InterfaceC0921Su e(AbstractC4441zC abstractC4441zC) {
        return a.e(abstractC4441zC);
    }

    public static InterfaceC1003Vu f(AbstractC3628pI abstractC3628pI) {
        return a.f(abstractC3628pI);
    }

    public static InterfaceC1029Wu g(AbstractC3789rI abstractC3789rI) {
        return a.g(abstractC3789rI);
    }

    public static String h(InterfaceC0829Pp interfaceC0829Pp) {
        return a.h(interfaceC0829Pp);
    }

    public static String i(AbstractC2233fv abstractC2233fv) {
        return a.i(abstractC2233fv);
    }
}
