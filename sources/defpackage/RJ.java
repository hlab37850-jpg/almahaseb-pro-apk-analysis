package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class RJ {
    public InterfaceC0635Ju b(Class cls) {
        return new C0512Fb(cls);
    }

    public InterfaceC0705Ku c(Class cls, String str) {
        return new UF(cls, str);
    }

    public String h(InterfaceC0829Pp interfaceC0829Pp) {
        String string = interfaceC0829Pp.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String i(AbstractC2233fv abstractC2233fv) {
        return h(abstractC2233fv);
    }

    public InterfaceC0730Lu a(AbstractC0890Rp abstractC0890Rp) {
        return abstractC0890Rp;
    }

    public InterfaceC0895Ru d(AbstractC4269xC abstractC4269xC) {
        return abstractC4269xC;
    }

    public InterfaceC0921Su e(AbstractC4441zC abstractC4441zC) {
        return abstractC4441zC;
    }

    public InterfaceC1003Vu f(AbstractC3628pI abstractC3628pI) {
        return abstractC3628pI;
    }

    public InterfaceC1029Wu g(AbstractC3789rI abstractC3789rI) {
        return abstractC3789rI;
    }
}
