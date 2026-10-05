package defpackage;

/* JADX INFO: renamed from: in, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC2470in {

    /* JADX INFO: renamed from: in$a */
    public static final class a implements InterfaceC0939Tm {
        public final /* synthetic */ InterfaceC0939Tm a;

        /* JADX INFO: renamed from: in$a$a, reason: collision with other inner class name */
        public static final class C0289a implements InterfaceC0995Vm {
            public final /* synthetic */ InterfaceC0995Vm a;

            /* JADX INFO: renamed from: in$a$a$a, reason: collision with other inner class name */
            public static final class C0290a extends AbstractC0819Pf {
                public /* synthetic */ Object a;
                public int b;

                public C0290a(InterfaceC0793Of interfaceC0793Of) {
                    super(interfaceC0793Of);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return C0289a.this.emit(null, this);
                }
            }

            public C0289a(InterfaceC0995Vm interfaceC0995Vm) {
                this.a = interfaceC0995Vm;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                C0290a c0290a;
                if (interfaceC0793Of instanceof C0290a) {
                    c0290a = (C0290a) interfaceC0793Of;
                    int i = c0290a.b;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        c0290a.b = i - Integer.MIN_VALUE;
                    } else {
                        c0290a = new C0290a(interfaceC0793Of);
                    }
                } else {
                    c0290a = new C0290a(interfaceC0793Of);
                }
                Object obj2 = c0290a.a;
                Object objD = AbstractC0378Bt.d();
                int i2 = c0290a.b;
                if (i2 == 0) {
                    LL.b(obj2);
                    InterfaceC0995Vm interfaceC0995Vm = this.a;
                    if (obj != null) {
                        c0290a.b = 1;
                        if (interfaceC0995Vm.emit(obj, c0290a) == objD) {
                            return objD;
                        }
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj2);
                }
                return FW.a;
            }
        }

        public a(InterfaceC0939Tm interfaceC0939Tm) {
            this.a = interfaceC0939Tm;
        }

        @Override // defpackage.InterfaceC0939Tm
        public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            Object objCollect = this.a.collect(new C0289a(interfaceC0995Vm), interfaceC0793Of);
            return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
        }
    }

    /* JADX INFO: renamed from: in$b */
    public static final class b implements InterfaceC0939Tm {
        public final /* synthetic */ InterfaceC0939Tm a;
        public final /* synthetic */ InterfaceC0526Fp b;

        /* JADX INFO: renamed from: in$b$a */
        public static final class a implements InterfaceC0995Vm {
            public final /* synthetic */ InterfaceC0995Vm a;
            public final /* synthetic */ InterfaceC0526Fp b;

            /* JADX INFO: renamed from: in$b$a$a, reason: collision with other inner class name */
            public static final class C0291a extends AbstractC0819Pf {
                public /* synthetic */ Object a;
                public int b;
                public Object d;
                public Object e;

                public C0291a(InterfaceC0793Of interfaceC0793Of) {
                    super(interfaceC0793Of);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0526Fp interfaceC0526Fp) {
                this.a = interfaceC0995Vm;
                this.b = interfaceC0526Fp;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // defpackage.InterfaceC0995Vm
            public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                C0291a c0291a;
                Object obj2;
                InterfaceC0995Vm interfaceC0995Vm;
                if (interfaceC0793Of instanceof C0291a) {
                    c0291a = (C0291a) interfaceC0793Of;
                    int i = c0291a.b;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        c0291a.b = i - Integer.MIN_VALUE;
                    } else {
                        c0291a = new C0291a(interfaceC0793Of);
                    }
                } else {
                    c0291a = new C0291a(interfaceC0793Of);
                }
                Object obj3 = c0291a.a;
                Object objD = AbstractC0378Bt.d();
                int i2 = c0291a.b;
                if (i2 != 0) {
                    if (i2 == 1) {
                        interfaceC0995Vm = (InterfaceC0995Vm) c0291a.e;
                        obj2 = c0291a.d;
                        LL.b(obj3);
                    } else {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        LL.b(obj3);
                    }
                    return FW.a;
                }
                LL.b(obj3);
                InterfaceC0995Vm interfaceC0995Vm2 = this.a;
                InterfaceC0526Fp interfaceC0526Fp = this.b;
                c0291a.d = obj;
                c0291a.e = interfaceC0995Vm2;
                c0291a.b = 1;
                AbstractC0703Ks.c(6);
                Object objMo13invoke = interfaceC0526Fp.mo13invoke(obj, c0291a);
                AbstractC0703Ks.c(7);
                if (objMo13invoke == objD) {
                    return objD;
                }
                obj2 = obj;
                interfaceC0995Vm = interfaceC0995Vm2;
                c0291a.d = null;
                c0291a.e = null;
                c0291a.b = 2;
                if (interfaceC0995Vm.emit(obj2, c0291a) == objD) {
                    return objD;
                }
                return FW.a;
            }
        }

        public b(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
            this.a = interfaceC0939Tm;
            this.b = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC0939Tm
        public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            Object objCollect = this.a.collect(new a(interfaceC0995Vm, this.b), interfaceC0793Of);
            return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
        }
    }

    /* JADX INFO: renamed from: in$c */
    public static final class c implements InterfaceC0939Tm {
        public final /* synthetic */ InterfaceC0939Tm a;

        public c(InterfaceC0939Tm interfaceC0939Tm) {
            this.a = interfaceC0939Tm;
        }

        @Override // defpackage.InterfaceC0939Tm
        public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            Object objCollect = this.a.collect(new d(interfaceC0995Vm, new MJ()), interfaceC0793Of);
            return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
        }
    }

    /* JADX INFO: renamed from: in$d */
    public static final class d implements InterfaceC0995Vm {
        public final /* synthetic */ InterfaceC0995Vm a;
        public final /* synthetic */ MJ b;

        /* JADX INFO: renamed from: in$d$a */
        public static final class a extends AbstractC0819Pf {
            public /* synthetic */ Object a;
            public int c;

            public a(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.c |= Integer.MIN_VALUE;
                return d.this.emit(null, this);
            }
        }

        public d(InterfaceC0995Vm interfaceC0995Vm, MJ mj) {
            this.a = interfaceC0995Vm;
            this.b = mj;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0995Vm
        public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
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
            Object obj2 = aVar.a;
            Object objD = AbstractC0378Bt.d();
            int i2 = aVar.c;
            if (i2 == 0) {
                LL.b(obj2);
                InterfaceC0995Vm interfaceC0995Vm = this.a;
                MJ mj = this.b;
                int i3 = mj.a;
                mj.a = i3 + 1;
                if (i3 < 0) {
                    throw new ArithmeticException("Index overflow has happened");
                }
                C0529Fs c0529Fs = new C0529Fs(i3, obj);
                aVar.c = 1;
                if (interfaceC0995Vm.emit(c0529Fs, aVar) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj2);
            }
            return FW.a;
        }
    }

    public static final InterfaceC0939Tm a(InterfaceC0939Tm interfaceC0939Tm) {
        return new a(interfaceC0939Tm);
    }

    public static final InterfaceC0939Tm b(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
        return new b(interfaceC0939Tm, interfaceC0526Fp);
    }

    public static final InterfaceC0939Tm c(InterfaceC0939Tm interfaceC0939Tm) {
        return new c(interfaceC0939Tm);
    }
}
