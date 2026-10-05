package defpackage;

/* JADX INFO: renamed from: eb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2123eb extends AbstractC1884cb {
    public final InterfaceC0552Gp e;

    /* JADX INFO: renamed from: eb$a */
    public static final class a extends XS implements InterfaceC0526Fp {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ InterfaceC0995Vm d;

        /* JADX INFO: renamed from: eb$a$a, reason: collision with other inner class name */
        public static final class C0279a implements InterfaceC0995Vm {
            public final /* synthetic */ OJ a;
            public final /* synthetic */ InterfaceC2052dg b;
            public final /* synthetic */ C2123eb c;
            public final /* synthetic */ InterfaceC0995Vm d;

            /* JADX INFO: renamed from: eb$a$a$a, reason: collision with other inner class name */
            public static final class C0280a extends XS implements InterfaceC0526Fp {
                public int a;
                public final /* synthetic */ C2123eb b;
                public final /* synthetic */ InterfaceC0995Vm c;
                public final /* synthetic */ Object d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0280a(C2123eb c2123eb, InterfaceC0995Vm interfaceC0995Vm, Object obj, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.b = c2123eb;
                    this.c = interfaceC0995Vm;
                    this.d = obj;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new C0280a(this.b, this.c, this.d, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((C0280a) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.a;
                    if (i == 0) {
                        LL.b(obj);
                        InterfaceC0552Gp interfaceC0552Gp = this.b.e;
                        InterfaceC0995Vm interfaceC0995Vm = this.c;
                        Object obj2 = this.d;
                        this.a = 1;
                        if (interfaceC0552Gp.invoke(interfaceC0995Vm, obj2, this) == objD) {
                            return objD;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj);
                    }
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: eb$a$a$b */
            public static final class b extends AbstractC0819Pf {
                public Object a;
                public Object b;
                public Object c;
                public /* synthetic */ Object d;
                public int f;

                public b(InterfaceC0793Of interfaceC0793Of) {
                    super(interfaceC0793Of);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) {
                    this.d = obj;
                    this.f |= Integer.MIN_VALUE;
                    return C0279a.this.emit(null, this);
                }
            }

            public C0279a(OJ oj, InterfaceC2052dg interfaceC2052dg, C2123eb c2123eb, InterfaceC0995Vm interfaceC0995Vm) {
                this.a = oj;
                this.b = interfaceC2052dg;
                this.c = c2123eb;
                this.d = interfaceC0995Vm;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                b bVar;
                C0279a c0279a;
                if (interfaceC0793Of instanceof b) {
                    bVar = (b) interfaceC0793Of;
                    int i = bVar.f;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        bVar.f = i - Integer.MIN_VALUE;
                    } else {
                        bVar = new b(interfaceC0793Of);
                    }
                } else {
                    bVar = new b(interfaceC0793Of);
                }
                Object obj2 = bVar.d;
                Object objD = AbstractC0378Bt.d();
                int i2 = bVar.f;
                if (i2 == 0) {
                    LL.b(obj2);
                    InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) this.a.a;
                    if (interfaceC1830bu != null) {
                        interfaceC1830bu.cancel(new C4052ub());
                        bVar.a = this;
                        bVar.b = obj;
                        bVar.c = interfaceC1830bu;
                        bVar.f = 1;
                        if (interfaceC1830bu.F(bVar) == objD) {
                            return objD;
                        }
                    }
                    c0279a = this;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj = bVar.b;
                    c0279a = (C0279a) bVar.a;
                    LL.b(obj2);
                }
                c0279a.a.a = O8.d(c0279a.b, null, EnumC2379hg.UNDISPATCHED, new C0280a(c0279a.c, c0279a.d, obj, null), 1, null);
                return FW.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.d = interfaceC0995Vm;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            a aVar = C2123eb.this.new a(this.d, interfaceC0793Of);
            aVar.b = obj;
            return aVar;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((a) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.b;
                OJ oj = new OJ();
                C2123eb c2123eb = C2123eb.this;
                InterfaceC0939Tm interfaceC0939Tm = c2123eb.d;
                C0279a c0279a = new C0279a(oj, interfaceC2052dg, c2123eb, this.d);
                this.a = 1;
                if (interfaceC0939Tm.collect(c0279a, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    public /* synthetic */ C2123eb(InterfaceC0552Gp interfaceC0552Gp, InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8, int i2, AbstractC0419Di abstractC0419Di) {
        this(interfaceC0552Gp, interfaceC0939Tm, (i2 & 4) != 0 ? C1172Zk.a : interfaceC0988Vf, (i2 & 8) != 0 ? -2 : i, (i2 & 16) != 0 ? I8.SUSPEND : i8);
    }

    @Override // defpackage.AbstractC1162Za
    public AbstractC1162Za h(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return new C2123eb(this.e, this.d, interfaceC0988Vf, i, i8);
    }

    @Override // defpackage.AbstractC1884cb
    public Object q(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        Object objD = AbstractC2133eg.d(new a(interfaceC0995Vm, null), interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    public C2123eb(InterfaceC0552Gp interfaceC0552Gp, InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        super(interfaceC0939Tm, interfaceC0988Vf, i, i8);
        this.e = interfaceC0552Gp;
    }
}
