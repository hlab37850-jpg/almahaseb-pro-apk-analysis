package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CM {
    public static final void a(Throwable th, InterfaceC0988Vf interfaceC0988Vf) throws IllegalAccessException, InvocationTargetException {
        if (th instanceof CancellationException) {
            return;
        }
        try {
            FM.m(th);
        } catch (Throwable th2) {
            AbstractC0773Nl.a(th, th2);
            AbstractC1247ag.a(interfaceC0988Vf, th);
        }
    }
}
