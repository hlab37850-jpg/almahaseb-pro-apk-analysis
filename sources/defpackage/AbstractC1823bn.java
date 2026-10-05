package defpackage;

/* JADX INFO: renamed from: bn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC1823bn {
    public static final InterfaceC0939Tm a(InterfaceC0939Tm interfaceC0939Tm, int i, I8 i8) {
        int i2;
        I8 i9;
        if (i < 0 && i != -2 && i != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i).toString());
        }
        if (i == -1 && i8 != I8.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i == -1) {
            i9 = I8.DROP_OLDEST;
            i2 = 0;
        } else {
            i2 = i;
            i9 = i8;
        }
        if (interfaceC0939Tm instanceof InterfaceC1826bq) {
            return InterfaceC1826bq.a.a((InterfaceC1826bq) interfaceC0939Tm, null, i2, i9, 1, null);
        }
        return new C2042db(interfaceC0939Tm, null, i2, i9, 2, null);
    }

    public static /* synthetic */ InterfaceC0939Tm b(InterfaceC0939Tm interfaceC0939Tm, int i, I8 i8, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            i8 = I8.SUSPEND;
        }
        return AbstractC1047Xm.c(interfaceC0939Tm, i, i8);
    }

    public static final InterfaceC0939Tm c(InterfaceC0939Tm interfaceC0939Tm) {
        return b(interfaceC0939Tm, -1, null, 2, null);
    }
}
