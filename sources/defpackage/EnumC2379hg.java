package defpackage;

/* JADX INFO: renamed from: hg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC2379hg {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* JADX INFO: renamed from: hg$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC2379hg.values().length];
            iArr[EnumC2379hg.DEFAULT.ordinal()] = 1;
            iArr[EnumC2379hg.ATOMIC.ordinal()] = 2;
            iArr[EnumC2379hg.UNDISPATCHED.ordinal()] = 3;
            iArr[EnumC2379hg.LAZY.ordinal()] = 4;
            a = iArr;
        }
    }

    public final void b(InterfaceC0526Fp interfaceC0526Fp, Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        int i = a.a[ordinal()];
        if (i == 1) {
            AbstractC0385Ca.e(interfaceC0526Fp, obj, interfaceC0793Of, null, 4, null);
            return;
        }
        if (i == 2) {
            AbstractC0880Rf.b(interfaceC0526Fp, obj, interfaceC0793Of);
        } else if (i == 3) {
            AbstractC4461zW.a(interfaceC0526Fp, obj, interfaceC0793Of);
        } else if (i != 4) {
            throw new AD();
        }
    }

    public final boolean c() {
        return this == LAZY;
    }
}
