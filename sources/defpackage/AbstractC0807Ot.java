package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: Ot, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0807Ot extends GG {

    /* JADX INFO: renamed from: Ot$a */
    public static final class a {
        public static final a a = new a();
        public static final Integer b;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            b = num2;
        }
    }

    private final boolean c(int i) {
        Integer num = a.b;
        return num == null || num.intValue() >= i;
    }

    @Override // defpackage.GG
    public void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        AbstractC4492zt.h(th, "cause");
        AbstractC4492zt.h(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
