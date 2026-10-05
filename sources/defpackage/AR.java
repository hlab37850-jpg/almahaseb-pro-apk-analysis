package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class AR implements InterfaceC2110eP {

    public static final class a extends XS implements InterfaceC0526Fp {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ CR c;

        /* JADX INFO: renamed from: AR$a$a, reason: collision with other inner class name */
        public static final class C0000a implements InterfaceC0995Vm {
            public final /* synthetic */ KJ a;
            public final /* synthetic */ InterfaceC0995Vm b;

            /* JADX INFO: renamed from: AR$a$a$a, reason: collision with other inner class name */
            public static final class C0001a extends AbstractC0819Pf {
                public /* synthetic */ Object a;
                public int c;

                public C0001a(InterfaceC0793Of interfaceC0793Of) {
                    super(interfaceC0793Of);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.c |= Integer.MIN_VALUE;
                    return C0000a.this.a(0, this);
                }
            }

            public C0000a(KJ kj, InterfaceC0995Vm interfaceC0995Vm) {
                this.a = kj;
                this.b = interfaceC0995Vm;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            public final Object a(int i, InterfaceC0793Of interfaceC0793Of) throws Throwable {
                C0001a c0001a;
                if (interfaceC0793Of instanceof C0001a) {
                    c0001a = (C0001a) interfaceC0793Of;
                    int i2 = c0001a.c;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0001a.c = i2 - Integer.MIN_VALUE;
                    } else {
                        c0001a = new C0001a(interfaceC0793Of);
                    }
                } else {
                    c0001a = new C0001a(interfaceC0793Of);
                }
                Object obj = c0001a.a;
                Object objD = AbstractC0378Bt.d();
                int i3 = c0001a.c;
                if (i3 == 0) {
                    LL.b(obj);
                    if (i > 0) {
                        KJ kj = this.a;
                        if (!kj.a) {
                            kj.a = true;
                            InterfaceC0995Vm interfaceC0995Vm = this.b;
                            EnumC1871cP enumC1871cP = EnumC1871cP.START;
                            c0001a.c = 1;
                            if (interfaceC0995Vm.emit(enumC1871cP, c0001a) == objD) {
                                return objD;
                            }
                        }
                    }
                    return FW.a;
                }
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
                return FW.a;
            }

            @Override // defpackage.InterfaceC0995Vm
            public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) {
                return a(((Number) obj).intValue(), interfaceC0793Of);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CR cr, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.c = cr;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            a aVar = new a(this.c, interfaceC0793Of);
            aVar.b = obj;
            return aVar;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            return ((a) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i == 0) {
                LL.b(obj);
                InterfaceC0995Vm interfaceC0995Vm = (InterfaceC0995Vm) this.b;
                KJ kj = new KJ();
                CR cr = this.c;
                C0000a c0000a = new C0000a(kj, interfaceC0995Vm);
                this.a = 1;
                if (cr.collect(c0000a, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            throw new C1182Zu();
        }
    }

    @Override // defpackage.InterfaceC2110eP
    public InterfaceC0939Tm a(CR cr) {
        return AbstractC1047Xm.s(new a(cr, null));
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
