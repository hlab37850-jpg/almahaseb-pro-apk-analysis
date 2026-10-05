package defpackage;

/* JADX INFO: renamed from: Pt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0833Pt extends AbstractC0807Ot {

    /* JADX INFO: renamed from: Pt$a */
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

    @Override // defpackage.GG
    public AbstractC3465nJ b() {
        return c(34) ? new LG() : super.b();
    }

    public final boolean c(int i) {
        Integer num = a.b;
        return num == null || num.intValue() >= i;
    }
}
