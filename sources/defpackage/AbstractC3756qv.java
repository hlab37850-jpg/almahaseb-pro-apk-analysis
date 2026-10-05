package defpackage;

/* JADX INFO: renamed from: qv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3756qv {

    /* JADX INFO: renamed from: qv$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4322xv.values().length];
            try {
                iArr[EnumC4322xv.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC4322xv.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC4322xv.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static InterfaceC3430mv a(InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(interfaceC3588op, "initializer");
        return new C1875cT(interfaceC3588op, null, 2, null);
    }

    public static InterfaceC3430mv b(EnumC4322xv enumC4322xv, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(enumC4322xv, "mode");
        AbstractC4492zt.h(interfaceC3588op, "initializer");
        int i = a.a[enumC4322xv.ordinal()];
        if (i == 1) {
            return new C1875cT(interfaceC3588op, null, 2, null);
        }
        if (i == 2) {
            return new C3875sN(interfaceC3588op);
        }
        if (i == 3) {
            return new KW(interfaceC3588op);
        }
        throw new AD();
    }
}
