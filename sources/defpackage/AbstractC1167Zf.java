package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* JADX INFO: renamed from: Zf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1167Zf {
    public static final List a = FO.v(DO.c(ServiceLoader.load(InterfaceC1082Yf.class, InterfaceC1082Yf.class.getClassLoader()).iterator()));

    public static final void a(InterfaceC0988Vf interfaceC0988Vf, Throwable th) {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            try {
                ((InterfaceC1082Yf) it.next()).handleException(interfaceC0988Vf, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, AbstractC1247ag.b(th, th2));
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        try {
            KL.a aVar = KL.a;
            AbstractC0773Nl.a(th, new C2466ij(interfaceC0988Vf));
            KL.a(FW.a);
        } catch (Throwable th3) {
            KL.a aVar2 = KL.a;
            KL.a(LL.a(th3));
        }
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
