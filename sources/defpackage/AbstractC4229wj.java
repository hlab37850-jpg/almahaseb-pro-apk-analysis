package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: renamed from: wj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4229wj extends AbstractRunnableC4205wT {
    public int c;

    public AbstractC4229wj(int i) {
        this.c = i;
    }

    public abstract void b(Object obj, Throwable th);

    public abstract InterfaceC0793Of c();

    public Throwable d(Object obj) {
        C2129ee c2129ee = obj instanceof C2129ee ? (C2129ee) obj : null;
        if (c2129ee != null) {
            return c2129ee.a;
        }
        return null;
    }

    public final void g(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            AbstractC0773Nl.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        AbstractC4492zt.e(th);
        AbstractC1247ag.a(c().getContext(), new C2460ig("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        Object objA;
        Object objA2;
        InterfaceC4286xT interfaceC4286xT = this.b;
        try {
            C3986tj c3986tj = (C3986tj) c();
            InterfaceC0793Of interfaceC0793Of = c3986tj.e;
            Object obj = c3986tj.g;
            InterfaceC0988Vf context = interfaceC0793Of.getContext();
            Object objC = AbstractC4368yU.c(context, obj);
            C4370yW c4370yWG = objC != AbstractC4368yU.a ? AbstractC1014Wf.g(interfaceC0793Of, context, objC) : null;
            try {
                InterfaceC0988Vf context2 = interfaceC0793Of.getContext();
                Object objI = i();
                Throwable thD = d(objI);
                InterfaceC1830bu interfaceC1830bu = (thD == null && AbstractC4310xj.b(this.c)) ? (InterfaceC1830bu) context2.get(InterfaceC1830bu.s) : null;
                if (interfaceC1830bu != null && !interfaceC1830bu.isActive()) {
                    CancellationException cancellationExceptionI = interfaceC1830bu.i();
                    b(objI, cancellationExceptionI);
                    KL.a aVar = KL.a;
                    interfaceC0793Of.resumeWith(KL.a(LL.a(cancellationExceptionI)));
                } else if (thD != null) {
                    KL.a aVar2 = KL.a;
                    interfaceC0793Of.resumeWith(KL.a(LL.a(thD)));
                } else {
                    KL.a aVar3 = KL.a;
                    interfaceC0793Of.resumeWith(KL.a(f(objI)));
                }
                FW fw = FW.a;
                if (c4370yWG == null || c4370yWG.I0()) {
                    AbstractC4368yU.a(context, objC);
                }
                try {
                    interfaceC4286xT.a();
                    objA2 = KL.a(FW.a);
                } catch (Throwable th) {
                    KL.a aVar4 = KL.a;
                    objA2 = KL.a(LL.a(th));
                }
                g(null, KL.b(objA2));
            } catch (Throwable th2) {
                if (c4370yWG == null || c4370yWG.I0()) {
                    AbstractC4368yU.a(context, objC);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                KL.a aVar5 = KL.a;
                interfaceC4286xT.a();
                objA = KL.a(FW.a);
            } catch (Throwable th4) {
                KL.a aVar6 = KL.a;
                objA = KL.a(LL.a(th4));
            }
            g(th3, KL.b(objA));
        }
    }

    public Object f(Object obj) {
        return obj;
    }
}
