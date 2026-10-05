package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class LW {
    public static final int a(long j, long j2) {
        return AbstractC4492zt.k(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    public static final double b(long j) {
        return ((j >>> 11) * ((double) 2048)) + (j & 2047);
    }

    public static final String c(long j, int i) {
        if (j >= 0) {
            String string = Long.toString(j, AbstractC3566ob.a(i));
            AbstractC4492zt.g(string, "toString(...)");
            return string;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String string2 = Long.toString(j3, AbstractC3566ob.a(i));
        AbstractC4492zt.g(string2, "toString(...)");
        sb.append(string2);
        String string3 = Long.toString(j4, AbstractC3566ob.a(i));
        AbstractC4492zt.g(string3, "toString(...)");
        sb.append(string3);
        return sb.toString();
    }
}
