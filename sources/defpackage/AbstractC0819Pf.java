package defpackage;

/* JADX INFO: renamed from: Pf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0819Pf extends AbstractC2171f7 {
    private final InterfaceC0988Vf _context;
    private transient InterfaceC0793Of intercepted;

    public AbstractC0819Pf(InterfaceC0793Of interfaceC0793Of, InterfaceC0988Vf interfaceC0988Vf) {
        super(interfaceC0793Of);
        this._context = interfaceC0988Vf;
    }

    @Override // defpackage.InterfaceC0793Of
    public InterfaceC0988Vf getContext() {
        InterfaceC0988Vf interfaceC0988Vf = this._context;
        AbstractC4492zt.e(interfaceC0988Vf);
        return interfaceC0988Vf;
    }

    public final InterfaceC0793Of intercepted() {
        InterfaceC0793Of interfaceC0793OfInterceptContinuation = this.intercepted;
        if (interfaceC0793OfInterceptContinuation == null) {
            InterfaceC0854Qf interfaceC0854Qf = (InterfaceC0854Qf) getContext().get(InterfaceC0854Qf.o);
            if (interfaceC0854Qf == null || (interfaceC0793OfInterceptContinuation = interfaceC0854Qf.interceptContinuation(this)) == null) {
                interfaceC0793OfInterceptContinuation = this;
            }
            this.intercepted = interfaceC0793OfInterceptContinuation;
        }
        return interfaceC0793OfInterceptContinuation;
    }

    @Override // defpackage.AbstractC2171f7
    public void releaseIntercepted() {
        InterfaceC0793Of interfaceC0793Of = this.intercepted;
        if (interfaceC0793Of != null && interfaceC0793Of != this) {
            InterfaceC0988Vf.b bVar = getContext().get(InterfaceC0854Qf.o);
            AbstractC4492zt.e(bVar);
            ((InterfaceC0854Qf) bVar).releaseInterceptedContinuation(interfaceC0793Of);
        }
        this.intercepted = C2048de.a;
    }

    public AbstractC0819Pf(InterfaceC0793Of interfaceC0793Of) {
        this(interfaceC0793Of, interfaceC0793Of != null ? interfaceC0793Of.getContext() : null);
    }
}
