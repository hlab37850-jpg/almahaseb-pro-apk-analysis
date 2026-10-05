package defpackage;

/* JADX INFO: renamed from: aP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1224aP {
    public static final YS a = new YS("NO_VALUE");

    public static final CC a(int i, int i2, I8 i8) {
        if (i < 0) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + i2).toString());
        }
        if (i > 0 || i2 > 0 || i8 == I8.SUSPEND) {
            int i3 = i2 + i;
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            return new ZO(i, i3, i8);
        }
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + i8).toString());
    }

    public static /* synthetic */ CC b(int i, int i2, I8 i8, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            i8 = I8.SUSPEND;
        }
        return a(i, i2, i8);
    }

    public static final InterfaceC0939Tm e(YO yo, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return ((i == 0 || i == -3) && i8 == I8.SUSPEND) ? yo : new C2042db(yo, interfaceC0988Vf, i, i8);
    }

    public static final Object f(Object[] objArr, long j) {
        return objArr[(objArr.length - 1) & ((int) j)];
    }

    public static final void g(Object[] objArr, long j, Object obj) {
        objArr[(objArr.length - 1) & ((int) j)] = obj;
    }
}
