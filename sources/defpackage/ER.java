package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ER {
    public static final YS a = new YS("NONE");
    public static final YS b = new YS("PENDING");

    public static final DC a(Object obj) {
        if (obj == null) {
            obj = VD.a;
        }
        return new DR(obj);
    }

    public static final InterfaceC0939Tm d(CR cr, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return (((i < 0 || i >= 2) && i != -2) || i8 != I8.DROP_OLDEST) ? AbstractC1224aP.e(cr, interfaceC0988Vf, i, i8) : cr;
    }
}
