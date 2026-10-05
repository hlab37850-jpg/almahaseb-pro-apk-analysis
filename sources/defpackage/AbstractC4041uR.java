package defpackage;

/* JADX INFO: renamed from: uR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4041uR {
    public static final String a;
    public static final String b;

    static {
        Object objA;
        Object objA2;
        try {
            KL.a aVar = KL.a;
            objA = KL.a(AbstractC2171f7.class.getCanonicalName());
        } catch (Throwable th) {
            KL.a aVar2 = KL.a;
            objA = KL.a(LL.a(th));
        }
        if (KL.b(objA) != null) {
            objA = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) objA;
        try {
            objA2 = KL.a(AbstractC4041uR.class.getCanonicalName());
        } catch (Throwable th2) {
            KL.a aVar3 = KL.a;
            objA2 = KL.a(LL.a(th2));
        }
        if (KL.b(objA2) != null) {
            objA2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        b = (String) objA2;
    }

    public static final Throwable a(Throwable th) {
        return th;
    }
}
