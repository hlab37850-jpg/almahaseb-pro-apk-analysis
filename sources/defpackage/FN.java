package defpackage;

import com.itextpdf.text.pdf.PdfBoolean;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FN {
    public static final boolean a = b(true, "rx3.purge-enabled", true, true, new a());

    public static final class a implements InterfaceC0777Np {
        @Override // defpackage.InterfaceC0777Np
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, threadFactory);
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(a);
        return scheduledThreadPoolExecutor;
    }

    public static boolean b(boolean z, String str, boolean z2, boolean z3, InterfaceC0777Np interfaceC0777Np) {
        if (!z) {
            return z3;
        }
        try {
            String str2 = (String) interfaceC0777Np.apply(str);
            return str2 == null ? z2 : PdfBoolean.TRUE.equals(str2);
        } catch (Throwable th) {
            AbstractC0722Ll.b(th);
            return z2;
        }
    }
}
