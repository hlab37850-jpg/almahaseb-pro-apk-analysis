package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EM {

    public static final class a extends XS implements InterfaceC0526Fp {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ InterfaceC0939Tm c;
        public final /* synthetic */ InterfaceC3296lE d;

        /* JADX INFO: renamed from: EM$a$a, reason: collision with other inner class name */
        public static final class C0003a implements InterfaceC0995Vm {
            public final /* synthetic */ InterfaceC3296lE a;

            public C0003a(InterfaceC3296lE interfaceC3296lE) {
                this.a = interfaceC3296lE;
            }

            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) {
                this.a.b(obj);
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0939Tm interfaceC0939Tm, InterfaceC3296lE interfaceC3296lE, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.c = interfaceC0939Tm;
            this.d = interfaceC3296lE;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            a aVar = new a(this.c, this.d, interfaceC0793Of);
            aVar.b = obj;
            return aVar;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((a) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0047  */
        /* JADX WARN: Code duplicated, block: B:25:0x004f  */
        /* JADX WARN: Code duplicated, block: B:26:0x0057  */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC2052dg interfaceC2052dg;
            Throwable th;
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg2 = (InterfaceC2052dg) this.b;
                try {
                    InterfaceC0939Tm interfaceC0939Tm = this.c;
                    C0003a c0003a = new C0003a(this.d);
                    this.b = interfaceC2052dg2;
                    this.a = 1;
                    if (interfaceC0939Tm.collect(c0003a, this) == objD) {
                        return objD;
                    }
                    interfaceC2052dg = interfaceC2052dg2;
                } catch (Throwable th2) {
                    interfaceC2052dg = interfaceC2052dg2;
                    th = th2;
                    if (!(th instanceof CancellationException)) {
                        this.d.onComplete();
                    } else if (!this.d.a(th)) {
                        CM.a(th, interfaceC2052dg.getCoroutineContext());
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC2052dg = (InterfaceC2052dg) this.b;
                try {
                    LL.b(obj);
                } catch (Throwable th3) {
                    th = th3;
                    if (!(th instanceof CancellationException)) {
                        this.d.onComplete();
                    } else if (!this.d.a(th)) {
                        CM.a(th, interfaceC2052dg.getCoroutineContext());
                    }
                }
            }
            this.d.onComplete();
            return FW.a;
        }
    }

    public static final AbstractC3258kn b(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf) {
        return AbstractC3258kn.e(AbstractC3952tJ.b(interfaceC0939Tm, interfaceC0988Vf));
    }

    public static /* synthetic */ AbstractC3258kn c(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0988Vf = C1172Zk.a;
        }
        return b(interfaceC0939Tm, interfaceC0988Vf);
    }

    public static final AbstractC3132jE d(final InterfaceC0939Tm interfaceC0939Tm, final InterfaceC0988Vf interfaceC0988Vf) {
        return AbstractC3132jE.c(new InterfaceC3624pE() { // from class: DM
            @Override // defpackage.InterfaceC3624pE
            public final void subscribe(InterfaceC3296lE interfaceC3296lE) {
                EM.f(interfaceC0988Vf, interfaceC0939Tm, interfaceC3296lE);
            }
        });
    }

    public static /* synthetic */ AbstractC3132jE e(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0988Vf = C1172Zk.a;
        }
        return d(interfaceC0939Tm, interfaceC0988Vf);
    }

    public static final void f(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0939Tm interfaceC0939Tm, InterfaceC3296lE interfaceC3296lE) {
        interfaceC3296lE.c(new BM(M8.c(C3343lq.a, C0368Bj.d().plus(interfaceC0988Vf), EnumC2379hg.ATOMIC, new a(interfaceC0939Tm, interfaceC3296lE, null))));
    }
}
