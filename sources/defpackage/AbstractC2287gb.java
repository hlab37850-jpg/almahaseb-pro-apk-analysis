package defpackage;

/* JADX INFO: renamed from: gb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2287gb {
    public static final InterfaceC1009Wa a(int i, I8 i8, InterfaceC3750qp interfaceC3750qp) {
        if (i == -2) {
            return new X4(i8 == I8.SUSPEND ? InterfaceC1009Wa.m.a() : 1, i8, interfaceC3750qp);
        }
        if (i == -1) {
            if (i8 == I8.SUSPEND) {
                return new C0879Re(interfaceC3750qp);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i == 0) {
            return i8 == I8.SUSPEND ? new C3303lL(interfaceC3750qp) : new X4(1, i8, interfaceC3750qp);
        }
        if (i != Integer.MAX_VALUE) {
            return (i == 1 && i8 == I8.DROP_OLDEST) ? new C0879Re(interfaceC3750qp) : new X4(i, i8, interfaceC3750qp);
        }
        return new C0584Hv(interfaceC3750qp);
    }

    public static /* synthetic */ InterfaceC1009Wa b(int i, I8 i8, InterfaceC3750qp interfaceC3750qp, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            i8 = I8.SUSPEND;
        }
        if ((i2 & 4) != 0) {
            interfaceC3750qp = null;
        }
        return a(i, i8, interfaceC3750qp);
    }
}
