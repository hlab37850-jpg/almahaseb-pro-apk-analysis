package defpackage;

import java.io.Serializable;

/* JADX INFO: renamed from: f7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2171f7 implements InterfaceC0793Of, InterfaceC2297gg, Serializable {
    private final InterfaceC0793Of completion;

    public AbstractC2171f7(InterfaceC0793Of interfaceC0793Of) {
        this.completion = interfaceC0793Of;
    }

    public InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
        AbstractC4492zt.h(interfaceC0793Of, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // defpackage.InterfaceC2297gg
    public InterfaceC2297gg getCallerFrame() {
        InterfaceC0793Of interfaceC0793Of = this.completion;
        if (interfaceC0793Of instanceof InterfaceC2297gg) {
            return (InterfaceC2297gg) interfaceC0793Of;
        }
        return null;
    }

    public final InterfaceC0793Of getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return AbstractC3334li.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // defpackage.InterfaceC0793Of
    public final void resumeWith(Object obj) {
        InterfaceC0793Of interfaceC0793Of = this;
        while (true) {
            AbstractC3416mi.b(interfaceC0793Of);
            AbstractC2171f7 abstractC2171f7 = (AbstractC2171f7) interfaceC0793Of;
            InterfaceC0793Of interfaceC0793Of2 = abstractC2171f7.completion;
            AbstractC4492zt.e(interfaceC0793Of2);
            try {
                Object objInvokeSuspend = abstractC2171f7.invokeSuspend(obj);
                if (objInvokeSuspend == AbstractC0378Bt.d()) {
                    return;
                } else {
                    obj = KL.a(objInvokeSuspend);
                }
            } catch (Throwable th) {
                KL.a aVar = KL.a;
                obj = KL.a(LL.a(th));
            }
            abstractC2171f7.releaseIntercepted();
            if (!(interfaceC0793Of2 instanceof AbstractC2171f7)) {
                interfaceC0793Of2.resumeWith(obj);
                return;
            }
            interfaceC0793Of = interfaceC0793Of2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        AbstractC4492zt.h(interfaceC0793Of, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
