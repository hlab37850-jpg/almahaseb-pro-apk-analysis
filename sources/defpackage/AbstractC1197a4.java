package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: a4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1197a4 {
    public static final AN a = AbstractC4451zM.d(new Callable() { // from class: Z3
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return AbstractC1197a4.a.a;
        }
    });

    /* JADX INFO: renamed from: a4$a */
    public static final class a {
        public static final AN a = AbstractC1197a4.b(Looper.getMainLooper());
    }

    public static AN b(Looper looper) {
        return c(looper, true);
    }

    public static AN c(Looper looper, boolean z) {
        if (looper == null) {
            throw new NullPointerException("looper == null");
        }
        int i = Build.VERSION.SDK_INT;
        if (z && i < 22) {
            Message messageObtain = Message.obtain();
            try {
                messageObtain.setAsynchronous(true);
            } catch (NoSuchMethodError unused) {
                z = false;
            }
            messageObtain.recycle();
        }
        return new C2229fr(new Handler(looper), z);
    }

    public static AN e() {
        return AbstractC4451zM.e(a);
    }
}
