package defpackage;

import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BT {
    public static final String b(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j <= -999500) {
            str = ((j - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j <= 0) {
            str = ((j - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500) {
            str = ((j + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500000) {
            str = ((j + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        C2359hS c2359hS = C2359hS.a;
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        AbstractC4492zt.g(str2, "format(format, *args)");
        return str2;
    }

    public static final void c(AbstractC4124vT abstractC4124vT, DT dt, String str) {
        Logger loggerA = ET.h.a();
        StringBuilder sb = new StringBuilder();
        sb.append(dt.f());
        sb.append(' ');
        C2359hS c2359hS = C2359hS.a;
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        AbstractC4492zt.g(str2, "format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(abstractC4124vT.b());
        loggerA.fine(sb.toString());
    }
}
