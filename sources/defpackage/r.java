package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends CancellationException {
    public final transient InterfaceC0995Vm a;

    public r(InterfaceC0995Vm interfaceC0995Vm) {
        super("Flow was aborted, no more elements needed");
        this.a = interfaceC0995Vm;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
