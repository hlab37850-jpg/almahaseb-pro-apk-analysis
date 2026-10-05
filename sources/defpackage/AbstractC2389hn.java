package defpackage;

/* JADX INFO: renamed from: hn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC2389hn {

    /* JADX INFO: renamed from: hn$a */
    public static final class a extends XS implements InterfaceC0526Fp {
        public int a;
        public final /* synthetic */ InterfaceC2110eP b;
        public final /* synthetic */ InterfaceC0939Tm c;
        public final /* synthetic */ CC d;
        public final /* synthetic */ Object e;

        /* JADX INFO: renamed from: hn$a$a, reason: collision with other inner class name */
        public static final class C0287a extends XS implements InterfaceC0526Fp {
            public int a;
            public /* synthetic */ int b;

            public C0287a(InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                C0287a c0287a = new C0287a(interfaceC0793Of);
                c0287a.b = ((Number) obj).intValue();
                return c0287a;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                return l(((Number) obj).intValue(), (InterfaceC0793Of) obj2);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0378Bt.d();
                if (this.a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
                return E8.a(this.b > 0);
            }

            public final Object l(int i, InterfaceC0793Of interfaceC0793Of) {
                return ((C0287a) create(Integer.valueOf(i), interfaceC0793Of)).invokeSuspend(FW.a);
            }
        }

        /* JADX INFO: renamed from: hn$a$b */
        public static final class b extends XS implements InterfaceC0526Fp {
            public int a;
            public /* synthetic */ Object b;
            public final /* synthetic */ InterfaceC0939Tm c;
            public final /* synthetic */ CC d;
            public final /* synthetic */ Object e;

            /* JADX INFO: renamed from: hn$a$b$a, reason: collision with other inner class name */
            public /* synthetic */ class C0288a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC1871cP.values().length];
                    iArr[EnumC1871cP.START.ordinal()] = 1;
                    iArr[EnumC1871cP.STOP.ordinal()] = 2;
                    iArr[EnumC1871cP.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                    a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InterfaceC0939Tm interfaceC0939Tm, CC cc, Object obj, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.c = interfaceC0939Tm;
                this.d = cc;
                this.e = obj;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                b bVar = new b(this.c, this.d, this.e, interfaceC0793Of);
                bVar.b = obj;
                return bVar;
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.a;
                if (i == 0) {
                    LL.b(obj);
                    int i2 = C0288a.a[((EnumC1871cP) this.b).ordinal()];
                    if (i2 == 1) {
                        InterfaceC0939Tm interfaceC0939Tm = this.c;
                        CC cc = this.d;
                        this.a = 1;
                        if (interfaceC0939Tm.collect(cc, this) == objD) {
                            return objD;
                        }
                    } else if (i2 == 3) {
                        Object obj2 = this.e;
                        if (obj2 == AbstractC1224aP.a) {
                            this.d.c();
                        } else {
                            this.d.f(obj2);
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(EnumC1871cP enumC1871cP, InterfaceC0793Of interfaceC0793Of) {
                return ((b) create(enumC1871cP, interfaceC0793Of)).invokeSuspend(FW.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC2110eP interfaceC2110eP, InterfaceC0939Tm interfaceC0939Tm, CC cc, Object obj, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.b = interfaceC2110eP;
            this.c = interfaceC0939Tm;
            this.d = cc;
            this.e = obj;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new a(this.b, this.c, this.d, this.e, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((a) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0068 A[RETURN] */
        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC0939Tm interfaceC0939Tm;
            CC cc;
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        LL.b(obj);
                        interfaceC0939Tm = this.c;
                        cc = this.d;
                        this.a = 3;
                        if (interfaceC0939Tm.collect(cc, this) == objD) {
                            return objD;
                        }
                    } else if (i != 3 && i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                LL.b(obj);
            } else {
                LL.b(obj);
                InterfaceC2110eP interfaceC2110eP = this.b;
                InterfaceC2110eP.a aVar = InterfaceC2110eP.a;
                if (interfaceC2110eP == aVar.c()) {
                    InterfaceC0939Tm interfaceC0939Tm2 = this.c;
                    CC cc2 = this.d;
                    this.a = 1;
                    if (interfaceC0939Tm2.collect(cc2, this) == objD) {
                        return objD;
                    }
                } else if (this.b == aVar.d()) {
                    CR crI = this.d.i();
                    C0287a c0287a = new C0287a(null);
                    this.a = 2;
                    if (AbstractC1047Xm.q(crI, c0287a, this) == objD) {
                        return objD;
                    }
                    interfaceC0939Tm = this.c;
                    cc = this.d;
                    this.a = 3;
                    if (interfaceC0939Tm.collect(cc, this) == objD) {
                        return objD;
                    }
                } else {
                    InterfaceC0939Tm interfaceC0939TmJ = AbstractC1047Xm.j(this.b.a(this.d.i()));
                    b bVar = new b(this.c, this.d, this.e, null);
                    this.a = 4;
                    if (AbstractC1047Xm.g(interfaceC0939TmJ, bVar, this) == objD) {
                        return objD;
                    }
                }
            }
            return FW.a;
        }
    }

    public static final YO a(CC cc) {
        return new C4276xJ(cc, null);
    }

    public static final CR b(DC dc) {
        return new C4357yJ(dc, null);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    public static final C2029dP c(InterfaceC0939Tm interfaceC0939Tm, int i) {
        AbstractC1162Za abstractC1162Za;
        InterfaceC0939Tm interfaceC0939TmJ;
        int iD = AbstractC3871sJ.d(i, InterfaceC1009Wa.m.a()) - i;
        if (!(interfaceC0939Tm instanceof AbstractC1162Za) || (interfaceC0939TmJ = (abstractC1162Za = (AbstractC1162Za) interfaceC0939Tm).j()) == null) {
            return new C2029dP(interfaceC0939Tm, iD, I8.SUSPEND, C1172Zk.a);
        }
        int i2 = abstractC1162Za.b;
        if (i2 != -3 && i2 != -2 && i2 != 0) {
            iD = i2;
        } else if (abstractC1162Za.c == I8.SUSPEND) {
            if (i2 == 0) {
                iD = 0;
            }
        } else if (i == 0) {
            iD = 1;
        } else {
            iD = 0;
        }
        return new C2029dP(interfaceC0939TmJ, iD, abstractC1162Za.c, abstractC1162Za.a);
    }

    public static final InterfaceC1830bu d(InterfaceC2052dg interfaceC2052dg, InterfaceC0988Vf interfaceC0988Vf, InterfaceC0939Tm interfaceC0939Tm, CC cc, InterfaceC2110eP interfaceC2110eP, Object obj) {
        return M8.c(interfaceC2052dg, interfaceC0988Vf, AbstractC4492zt.d(interfaceC2110eP, InterfaceC2110eP.a.c()) ? EnumC2379hg.DEFAULT : EnumC2379hg.UNDISPATCHED, new a(interfaceC2110eP, interfaceC0939Tm, cc, obj, null));
    }

    public static final YO e(YO yo, InterfaceC0526Fp interfaceC0526Fp) {
        return new KS(yo, interfaceC0526Fp);
    }

    public static final YO f(InterfaceC0939Tm interfaceC0939Tm, InterfaceC2052dg interfaceC2052dg, InterfaceC2110eP interfaceC2110eP, int i) {
        C2029dP c2029dPC = c(interfaceC0939Tm, i);
        CC ccA = AbstractC1224aP.a(i, c2029dPC.b, c2029dPC.c);
        return new C4276xJ(ccA, d(interfaceC2052dg, c2029dPC.d, c2029dPC.a, ccA, interfaceC2110eP, AbstractC1224aP.a));
    }

    public static final CR g(InterfaceC0939Tm interfaceC0939Tm, InterfaceC2052dg interfaceC2052dg, InterfaceC2110eP interfaceC2110eP, Object obj) {
        C2029dP c2029dPC = c(interfaceC0939Tm, 1);
        DC dcA = ER.a(obj);
        return new C4357yJ(dcA, d(interfaceC2052dg, c2029dPC.d, c2029dPC.a, dcA, interfaceC2110eP, obj));
    }
}
