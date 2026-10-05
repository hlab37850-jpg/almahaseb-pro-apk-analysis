package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: er, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2147er {
    public static final AbstractC2065dr a;
    private static volatile Choreographer choreographer;

    static {
        Object objA;
        try {
            KL.a aVar = KL.a;
            objA = KL.a(new C1984cr(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            KL.a aVar2 = KL.a;
            objA = KL.a(LL.a(th));
        }
        a = (AbstractC2065dr) (KL.c(objA) ? null : objA);
    }

    public static final Handler a(Looper looper, boolean z) throws IllegalAccessException, InvocationTargetException {
        if (!z) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (objInvoke != null) {
            return (Handler) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }

    public static final AbstractC2065dr b(Handler handler, String str) {
        return new C1984cr(handler, str);
    }
}
