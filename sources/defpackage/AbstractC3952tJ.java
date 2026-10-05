package defpackage;

import java.util.ServiceLoader;

/* JADX INFO: renamed from: tJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3952tJ {
    public static final InterfaceC0741Mf[] a;

    static {
        Object[] array = FO.v(DO.c(ServiceLoader.load(InterfaceC0741Mf.class, InterfaceC0741Mf.class.getClassLoader()).iterator())).toArray(new InterfaceC0741Mf[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        a = (InterfaceC0741Mf[]) array;
    }

    public static final InterfaceC0939Tm a(BI bi) {
        return new CI(bi, null, 0, null, 14, null);
    }

    public static final BI b(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf) {
        return new C0965Um(interfaceC0939Tm, C0368Bj.d().plus(interfaceC0988Vf));
    }

    public static final BI c(BI bi, InterfaceC0988Vf interfaceC0988Vf) {
        InterfaceC0741Mf[] interfaceC0741MfArr = a;
        if (interfaceC0741MfArr.length <= 0) {
            return bi;
        }
        InterfaceC0741Mf interfaceC0741Mf = interfaceC0741MfArr[0];
        throw null;
    }
}
