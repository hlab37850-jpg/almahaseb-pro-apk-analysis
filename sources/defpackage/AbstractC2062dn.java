package defpackage;

/* JADX INFO: renamed from: dn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC2062dn {

    /* JADX INFO: renamed from: dn$a */
    public static final class a extends AbstractC0819Pf {
        public Object a;
        public /* synthetic */ Object b;
        public int c;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return AbstractC2062dn.c(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: dn$b */
    public static final class b implements InterfaceC0939Tm {
        public final /* synthetic */ InterfaceC0939Tm a;
        public final /* synthetic */ InterfaceC0552Gp b;

        /* JADX INFO: renamed from: dn$b$a */
        public static final class a extends AbstractC0819Pf {
            public /* synthetic */ Object a;
            public int b;
            public Object d;
            public Object e;

            public a(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return b.this.collect(null, this);
            }
        }

        public b(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0552Gp interfaceC0552Gp) {
            this.a = interfaceC0939Tm;
            this.b = interfaceC0552Gp;
        }

        /* JADX WARN: Code duplicated, block: B:34:0x0086 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x0087  */
        /* JADX WARN: Code duplicated, block: B:46:0x00ab A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0939Tm
        public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            a aVar;
            b bVar;
            DU du;
            InterfaceC0552Gp interfaceC0552Gp;
            C3387mN c3387mN;
            Throwable th;
            C3387mN c3387mN2;
            Object objInvoke;
            if (interfaceC0793Of instanceof a) {
                aVar = (a) interfaceC0793Of;
                int i = aVar.b;
                if ((i & Integer.MIN_VALUE) != 0) {
                    aVar.b = i - Integer.MIN_VALUE;
                } else {
                    aVar = new a(interfaceC0793Of);
                }
            } else {
                aVar = new a(interfaceC0793Of);
            }
            Object obj = aVar.a;
            Object objD = AbstractC0378Bt.d();
            int i2 = aVar.b;
            if (i2 == 0) {
                LL.b(obj);
                try {
                    InterfaceC0939Tm interfaceC0939Tm = this.a;
                    aVar.d = this;
                    aVar.e = interfaceC0995Vm;
                    aVar.b = 1;
                    if (interfaceC0939Tm.collect(interfaceC0995Vm, aVar) == objD) {
                        return objD;
                    }
                    bVar = this;
                    c3387mN = new C3387mN(interfaceC0995Vm, aVar.getContext());
                    InterfaceC0552Gp interfaceC0552Gp2 = bVar.b;
                    aVar.d = c3387mN;
                    aVar.e = null;
                    aVar.b = 3;
                    AbstractC0703Ks.c(6);
                    objInvoke = interfaceC0552Gp2.invoke(c3387mN, null, aVar);
                    AbstractC0703Ks.c(7);
                    if (objInvoke == objD) {
                        return objD;
                    }
                    c3387mN2 = c3387mN;
                    c3387mN2.releaseIntercepted();
                    return FW.a;
                } catch (Throwable th2) {
                    th = th2;
                    bVar = this;
                    du = new DU(th);
                    interfaceC0552Gp = bVar.b;
                    aVar.d = th;
                    aVar.e = null;
                    aVar.b = 2;
                    if (AbstractC2062dn.c(du, interfaceC0552Gp, th, aVar) == objD) {
                        return objD;
                    }
                    throw th;
                }
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    Throwable th3 = (Throwable) aVar.d;
                    LL.b(obj);
                    throw th3;
                }
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c3387mN2 = (C3387mN) aVar.d;
                try {
                    LL.b(obj);
                    c3387mN2.releaseIntercepted();
                    return FW.a;
                } catch (Throwable th4) {
                    th = th4;
                    c3387mN2.releaseIntercepted();
                    throw th;
                }
            }
            interfaceC0995Vm = (InterfaceC0995Vm) aVar.e;
            bVar = (b) aVar.d;
            try {
                LL.b(obj);
                c3387mN = new C3387mN(interfaceC0995Vm, aVar.getContext());
                try {
                    InterfaceC0552Gp interfaceC0552Gp3 = bVar.b;
                    aVar.d = c3387mN;
                    aVar.e = null;
                    aVar.b = 3;
                    AbstractC0703Ks.c(6);
                    objInvoke = interfaceC0552Gp3.invoke(c3387mN, null, aVar);
                    AbstractC0703Ks.c(7);
                    if (objInvoke == objD) {
                        return objD;
                    }
                    c3387mN2 = c3387mN;
                    c3387mN2.releaseIntercepted();
                    return FW.a;
                } catch (Throwable th5) {
                    th = th5;
                    c3387mN2 = c3387mN;
                    c3387mN2.releaseIntercepted();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                du = new DU(th);
                interfaceC0552Gp = bVar.b;
                aVar.d = th;
                aVar.e = null;
                aVar.b = 2;
                if (AbstractC2062dn.c(du, interfaceC0552Gp, th, aVar) == objD) {
                    return objD;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: dn$c */
    public static final class c implements InterfaceC0939Tm {
        public final /* synthetic */ InterfaceC0526Fp a;
        public final /* synthetic */ InterfaceC0939Tm b;

        /* JADX INFO: renamed from: dn$c$a */
        public static final class a extends AbstractC0819Pf {
            public /* synthetic */ Object a;
            public int b;
            public Object d;
            public Object e;
            public Object f;

            public a(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return c.this.collect(null, this);
            }
        }

        public c(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0939Tm interfaceC0939Tm) {
            this.a = interfaceC0526Fp;
            this.b = interfaceC0939Tm;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0082 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0939Tm
        public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            a aVar;
            Throwable th;
            C3387mN c3387mN;
            c cVar;
            InterfaceC0995Vm interfaceC0995Vm2;
            InterfaceC0939Tm interfaceC0939Tm;
            if (interfaceC0793Of instanceof a) {
                aVar = (a) interfaceC0793Of;
                int i = aVar.b;
                if ((i & Integer.MIN_VALUE) != 0) {
                    aVar.b = i - Integer.MIN_VALUE;
                } else {
                    aVar = new a(interfaceC0793Of);
                }
            } else {
                aVar = new a(interfaceC0793Of);
            }
            Object obj = aVar.a;
            Object objD = AbstractC0378Bt.d();
            int i2 = aVar.b;
            if (i2 == 0) {
                LL.b(obj);
                C3387mN c3387mN2 = new C3387mN(interfaceC0995Vm, aVar.getContext());
                try {
                    InterfaceC0526Fp interfaceC0526Fp = this.a;
                    aVar.d = this;
                    aVar.e = interfaceC0995Vm;
                    aVar.f = c3387mN2;
                    aVar.b = 1;
                    AbstractC0703Ks.c(6);
                    Object objMo13invoke = interfaceC0526Fp.mo13invoke(c3387mN2, aVar);
                    AbstractC0703Ks.c(7);
                    if (objMo13invoke == objD) {
                        return objD;
                    }
                    cVar = this;
                    interfaceC0995Vm2 = interfaceC0995Vm;
                    c3387mN = c3387mN2;
                    c3387mN.releaseIntercepted();
                    interfaceC0939Tm = cVar.b;
                    aVar.d = null;
                    aVar.e = null;
                    aVar.f = null;
                    aVar.b = 2;
                    if (interfaceC0939Tm.collect(interfaceC0995Vm2, aVar) == objD) {
                        return objD;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    c3387mN = c3387mN2;
                    c3387mN.releaseIntercepted();
                    throw th;
                }
            } else if (i2 == 1) {
                c3387mN = (C3387mN) aVar.f;
                interfaceC0995Vm2 = (InterfaceC0995Vm) aVar.e;
                cVar = (c) aVar.d;
                try {
                    LL.b(obj);
                    c3387mN.releaseIntercepted();
                    interfaceC0939Tm = cVar.b;
                    aVar.d = null;
                    aVar.e = null;
                    aVar.f = null;
                    aVar.b = 2;
                    if (interfaceC0939Tm.collect(interfaceC0995Vm2, aVar) == objD) {
                        return objD;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    c3387mN.releaseIntercepted();
                    throw th;
                }
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    public static final void b(InterfaceC0995Vm interfaceC0995Vm) {
        if (interfaceC0995Vm instanceof DU) {
            throw ((DU) interfaceC0995Vm).a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object c(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0552Gp interfaceC0552Gp, Throwable th, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        a aVar;
        if (interfaceC0793Of instanceof a) {
            aVar = (a) interfaceC0793Of;
            int i = aVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.c = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(interfaceC0793Of);
            }
        } else {
            aVar = new a(interfaceC0793Of);
        }
        Object obj = aVar.b;
        Object objD = AbstractC0378Bt.d();
        int i2 = aVar.c;
        try {
            if (i2 == 0) {
                LL.b(obj);
                aVar.a = th;
                aVar.c = 1;
                if (interfaceC0552Gp.invoke(interfaceC0995Vm, th, aVar) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) aVar.a;
                LL.b(obj);
            }
            return FW.a;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                AbstractC0773Nl.a(th2, th);
            }
            throw th2;
        }
    }

    public static final InterfaceC0939Tm d(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0552Gp interfaceC0552Gp) {
        return new b(interfaceC0939Tm, interfaceC0552Gp);
    }

    public static final InterfaceC0939Tm e(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
        return new c(interfaceC0526Fp, interfaceC0939Tm);
    }
}
