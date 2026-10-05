package defpackage;

/* JADX INFO: renamed from: Xf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1040Xf extends H implements InterfaceC0854Qf {
    public static final a Key = new a(null);

    /* JADX INFO: renamed from: Xf$a */
    public static final class a extends I {

        /* JADX INFO: renamed from: Xf$a$a, reason: collision with other inner class name */
        public static final class C0025a extends AbstractC2233fv implements InterfaceC3750qp {
            public static final C0025a a = new C0025a();

            public C0025a() {
                super(1);
            }

            @Override // defpackage.InterfaceC3750qp
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AbstractC1040Xf invoke(InterfaceC0988Vf.b bVar) {
                if (bVar instanceof AbstractC1040Xf) {
                    return (AbstractC1040Xf) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public a() {
            super(InterfaceC0854Qf.o, C0025a.a);
        }
    }

    public AbstractC1040Xf() {
        super(InterfaceC0854Qf.o);
    }

    public abstract void dispatch(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable);

    public void dispatchYield(InterfaceC0988Vf interfaceC0988Vf, Runnable runnable) {
        dispatch(interfaceC0988Vf, runnable);
    }

    @Override // defpackage.H, defpackage.InterfaceC0988Vf.b, defpackage.InterfaceC0988Vf
    public <E extends InterfaceC0988Vf.b> E get(InterfaceC0988Vf.c cVar) {
        return (E) InterfaceC0854Qf.a.a(this, cVar);
    }

    @Override // defpackage.InterfaceC0854Qf
    public final <T> InterfaceC0793Of interceptContinuation(InterfaceC0793Of interfaceC0793Of) {
        return new C3986tj(this, interfaceC0793Of);
    }

    public boolean isDispatchNeeded(InterfaceC0988Vf interfaceC0988Vf) {
        return true;
    }

    public AbstractC1040Xf limitedParallelism(int i) {
        AbstractC0458Ev.a(i);
        return new RunnableC0432Dv(this, i);
    }

    @Override // defpackage.H, defpackage.InterfaceC0988Vf
    public InterfaceC0988Vf minusKey(InterfaceC0988Vf.c cVar) {
        return InterfaceC0854Qf.a.b(this, cVar);
    }

    @Override // defpackage.InterfaceC0854Qf
    public final void releaseInterceptedContinuation(InterfaceC0793Of interfaceC0793Of) {
        ((C3986tj) interfaceC0793Of).u();
    }

    public String toString() {
        return AbstractC3498ni.a(this) + '@' + AbstractC3498ni.b(this);
    }

    public final AbstractC1040Xf plus(AbstractC1040Xf abstractC1040Xf) {
        return abstractC1040Xf;
    }
}
