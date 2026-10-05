package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: ag, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1247ag {
    public static final void a(InterfaceC0988Vf interfaceC0988Vf, Throwable th) {
        try {
            InterfaceC1082Yf interfaceC1082Yf = (InterfaceC1082Yf) interfaceC0988Vf.get(InterfaceC1082Yf.r);
            if (interfaceC1082Yf != null) {
                interfaceC1082Yf.handleException(interfaceC0988Vf, th);
            } else {
                AbstractC1167Zf.a(interfaceC0988Vf, th);
            }
        } catch (Throwable th2) {
            AbstractC1167Zf.a(interfaceC0988Vf, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        AbstractC0773Nl.a(runtimeException, th);
        return runtimeException;
    }
}
