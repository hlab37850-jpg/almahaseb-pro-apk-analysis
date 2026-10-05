package defpackage;

/* JADX INFO: renamed from: en, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC2143en {

    /* JADX INFO: renamed from: en$a */
    public static final class a implements InterfaceC0939Tm {
        public final /* synthetic */ InterfaceC0939Tm a;
        public final /* synthetic */ int b;

        public a(InterfaceC0939Tm interfaceC0939Tm, int i) {
            this.a = interfaceC0939Tm;
            this.b = i;
        }

        @Override // defpackage.InterfaceC0939Tm
        public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            Object objCollect = this.a.collect(new b(new MJ(), this.b, interfaceC0995Vm), interfaceC0793Of);
            return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
        }
    }

    /* JADX INFO: renamed from: en$b */
    public static final class b implements InterfaceC0995Vm {
        public final /* synthetic */ MJ a;
        public final /* synthetic */ int b;
        public final /* synthetic */ InterfaceC0995Vm c;

        /* JADX INFO: renamed from: en$b$a */
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
                return b.this.emit(null, this);
            }
        }

        public b(MJ mj, int i, InterfaceC0995Vm interfaceC0995Vm) {
            this.a = mj;
            this.b = i;
            this.c = interfaceC0995Vm;
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
                MJ mj = this.a;
                int i3 = mj.a;
                if (i3 < this.b) {
                    mj.a = i3 + 1;
                    return FW.a;
                }
                InterfaceC0995Vm interfaceC0995Vm = this.c;
                aVar.c = 1;
                if (interfaceC0995Vm.emit(obj, aVar) == objD) {
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

    /* JADX INFO: renamed from: en$c */
    public static final class c implements InterfaceC0939Tm {
        public final /* synthetic */ InterfaceC0939Tm a;
        public final /* synthetic */ InterfaceC0526Fp b;

        public c(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
            this.a = interfaceC0939Tm;
            this.b = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC0939Tm
        public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            Object objCollect = this.a.collect(new d(new KJ(), interfaceC0995Vm, this.b), interfaceC0793Of);
            return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
        }
    }

    /* JADX INFO: renamed from: en$d */
    public static final class d implements InterfaceC0995Vm {
        public final /* synthetic */ KJ a;
        public final /* synthetic */ InterfaceC0995Vm b;
        public final /* synthetic */ InterfaceC0526Fp c;

        /* JADX INFO: renamed from: en$d$a */
        public static final class a extends AbstractC0819Pf {
            public Object a;
            public Object b;
            public /* synthetic */ Object c;
            public int e;

            public a(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.c = obj;
                this.e |= Integer.MIN_VALUE;
                return d.this.emit(null, this);
            }
        }

        public d(KJ kj, InterfaceC0995Vm interfaceC0995Vm, InterfaceC0526Fp interfaceC0526Fp) {
            this.a = kj;
            this.b = interfaceC0995Vm;
            this.c = interfaceC0526Fp;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x0074  */
        /* JADX WARN: Code duplicated, block: B:33:0x0087 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x008b  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0995Vm
        public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            a aVar;
            d dVar;
            InterfaceC0995Vm interfaceC0995Vm;
            if (interfaceC0793Of instanceof a) {
                aVar = (a) interfaceC0793Of;
                int i = aVar.e;
                if ((i & Integer.MIN_VALUE) != 0) {
                    aVar.e = i - Integer.MIN_VALUE;
                } else {
                    aVar = new a(interfaceC0793Of);
                }
            } else {
                aVar = new a(interfaceC0793Of);
            }
            Object objMo13invoke = aVar.c;
            Object objD = AbstractC0378Bt.d();
            int i2 = aVar.e;
            if (i2 == 0) {
                LL.b(objMo13invoke);
                if (this.a.a) {
                    InterfaceC0995Vm interfaceC0995Vm2 = this.b;
                    aVar.e = 1;
                    if (interfaceC0995Vm2.emit(obj, aVar) == objD) {
                        return objD;
                    }
                    return FW.a;
                }
                InterfaceC0526Fp interfaceC0526Fp = this.c;
                aVar.a = this;
                aVar.b = obj;
                aVar.e = 2;
                objMo13invoke = interfaceC0526Fp.mo13invoke(obj, aVar);
                if (objMo13invoke == objD) {
                    return objD;
                }
                dVar = this;
                if (!((Boolean) objMo13invoke).booleanValue()) {
                    return FW.a;
                }
                dVar.a.a = true;
                interfaceC0995Vm = dVar.b;
                aVar.a = null;
                aVar.b = null;
                aVar.e = 3;
                if (interfaceC0995Vm.emit(obj, aVar) == objD) {
                    return objD;
                }
            } else {
                if (i2 == 1) {
                    LL.b(objMo13invoke);
                    return FW.a;
                }
                if (i2 == 2) {
                    obj = aVar.b;
                    dVar = (d) aVar.a;
                    LL.b(objMo13invoke);
                    if (!((Boolean) objMo13invoke).booleanValue()) {
                        return FW.a;
                    }
                    dVar.a.a = true;
                    interfaceC0995Vm = dVar.b;
                    aVar.a = null;
                    aVar.b = null;
                    aVar.e = 3;
                    if (interfaceC0995Vm.emit(obj, aVar) == objD) {
                        return objD;
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(objMo13invoke);
                }
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: en$e */
    public static final class e extends AbstractC0819Pf {
        public Object a;
        public /* synthetic */ Object b;
        public int c;

        public e(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return AbstractC2143en.d(null, null, this);
        }
    }

    /* JADX INFO: renamed from: en$f */
    public static final class f implements InterfaceC0939Tm {
        public final /* synthetic */ InterfaceC0939Tm a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: en$f$a */
        public static final class a extends AbstractC0819Pf {
            public /* synthetic */ Object a;
            public int b;
            public Object d;

            public a(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return f.this.collect(null, this);
            }
        }

        public f(InterfaceC0939Tm interfaceC0939Tm, int i) {
            this.a = interfaceC0939Tm;
            this.b = i;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.InterfaceC0939Tm
        public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            a aVar;
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
            try {
                if (i2 == 0) {
                    LL.b(obj);
                    MJ mj = new MJ();
                    InterfaceC0939Tm interfaceC0939Tm = this.a;
                    g gVar = new g(mj, this.b, interfaceC0995Vm);
                    aVar.d = interfaceC0995Vm;
                    aVar.b = 1;
                    Object objCollect = interfaceC0939Tm.collect(gVar, aVar);
                    interfaceC0995Vm = objCollect;
                    if (objCollect == objD) {
                        return objD;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    InterfaceC0995Vm interfaceC0995Vm2 = (InterfaceC0995Vm) aVar.d;
                    LL.b(obj);
                    interfaceC0995Vm = interfaceC0995Vm2;
                }
            } catch (r e) {
                AbstractC1021Wm.a(e, interfaceC0995Vm);
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: en$g */
    public static final class g implements InterfaceC0995Vm {
        public final /* synthetic */ MJ a;
        public final /* synthetic */ int b;
        public final /* synthetic */ InterfaceC0995Vm c;

        /* JADX INFO: renamed from: en$g$a */
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
                return g.this.emit(null, this);
            }
        }

        public g(MJ mj, int i, InterfaceC0995Vm interfaceC0995Vm) {
            this.a = mj;
            this.b = i;
            this.c = interfaceC0995Vm;
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
            if (i2 != 0) {
                if (i2 == 1) {
                    LL.b(obj2);
                    return FW.a;
                }
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj2);
                return FW.a;
            }
            LL.b(obj2);
            MJ mj = this.a;
            int i3 = mj.a + 1;
            mj.a = i3;
            if (i3 < this.b) {
                InterfaceC0995Vm interfaceC0995Vm = this.c;
                aVar.c = 1;
                if (interfaceC0995Vm.emit(obj, aVar) == objD) {
                    return objD;
                }
                return FW.a;
            }
            InterfaceC0995Vm interfaceC0995Vm2 = this.c;
            aVar.c = 2;
            if (AbstractC2143en.d(interfaceC0995Vm2, obj, aVar) == objD) {
                return objD;
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: en$h */
    public static final class h implements InterfaceC0939Tm {
        public final /* synthetic */ InterfaceC0939Tm a;
        public final /* synthetic */ InterfaceC0526Fp b;

        /* JADX INFO: renamed from: en$h$a */
        public static final class a extends AbstractC0819Pf {
            public /* synthetic */ Object a;
            public int b;
            public Object d;

            public a(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return h.this.collect(null, this);
            }
        }

        public h(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
            this.a = interfaceC0939Tm;
            this.b = interfaceC0526Fp;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0939Tm
        public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            a aVar;
            i iVar;
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
                InterfaceC0939Tm interfaceC0939Tm = this.a;
                i iVar2 = new i(this.b, interfaceC0995Vm);
                try {
                    aVar.d = iVar2;
                    aVar.b = 1;
                    if (interfaceC0939Tm.collect(iVar2, aVar) == objD) {
                        return objD;
                    }
                } catch (r e) {
                    e = e;
                    iVar = iVar2;
                    AbstractC1021Wm.a(e, iVar);
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                iVar = (i) aVar.d;
                try {
                    LL.b(obj);
                } catch (r e2) {
                    e = e2;
                    AbstractC1021Wm.a(e, iVar);
                }
            }
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: en$i */
    public static final class i implements InterfaceC0995Vm {
        public final /* synthetic */ InterfaceC0526Fp a;
        public final /* synthetic */ InterfaceC0995Vm b;

        /* JADX INFO: renamed from: en$i$a */
        public static final class a extends AbstractC0819Pf {
            public Object a;
            public /* synthetic */ Object b;
            public int c;
            public Object e;

            public a(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.c |= Integer.MIN_VALUE;
                return i.this.emit(null, this);
            }
        }

        public i(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0995Vm interfaceC0995Vm) {
            this.a = interfaceC0526Fp;
            this.b = interfaceC0995Vm;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x007e  */
        /* JADX WARN: Code duplicated, block: B:29:0x0081  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0995Vm
        public Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            a aVar;
            Object obj2;
            Object obj3;
            i iVar;
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
            Object obj4 = aVar.b;
            Object objD = AbstractC0378Bt.d();
            int i2 = aVar.c;
            boolean z = true;
            if (i2 != 0) {
                if (i2 == 1) {
                    Object obj5 = aVar.e;
                    i iVar2 = (i) aVar.a;
                    LL.b(obj4);
                    obj3 = obj5;
                    iVar = iVar2;
                    obj2 = obj4;
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    iVar = (i) aVar.a;
                    LL.b(obj4);
                }
                if (z) {
                    return FW.a;
                }
                throw new r(iVar);
            }
            LL.b(obj4);
            InterfaceC0526Fp interfaceC0526Fp = this.a;
            aVar.a = this;
            aVar.e = obj;
            aVar.c = 1;
            AbstractC0703Ks.c(6);
            Object objMo13invoke = interfaceC0526Fp.mo13invoke(obj, aVar);
            AbstractC0703Ks.c(7);
            if (objMo13invoke == objD) {
                return objD;
            }
            obj2 = objMo13invoke;
            obj3 = obj;
            iVar = this;
            if (((Boolean) obj2).booleanValue()) {
                InterfaceC0995Vm interfaceC0995Vm = iVar.b;
                aVar.a = iVar;
                aVar.e = null;
                aVar.c = 2;
                if (interfaceC0995Vm.emit(obj3, aVar) == objD) {
                    return objD;
                }
            } else {
                z = false;
            }
            if (z) {
                return FW.a;
            }
            throw new r(iVar);
        }
    }

    public static final InterfaceC0939Tm b(InterfaceC0939Tm interfaceC0939Tm, int i2) {
        if (i2 >= 0) {
            return new a(interfaceC0939Tm, i2);
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i2).toString());
    }

    public static final InterfaceC0939Tm c(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
        return new c(interfaceC0939Tm, interfaceC0526Fp);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object d(InterfaceC0995Vm interfaceC0995Vm, Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        e eVar;
        if (interfaceC0793Of instanceof e) {
            eVar = (e) interfaceC0793Of;
            int i2 = eVar.c;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                eVar.c = i2 - Integer.MIN_VALUE;
            } else {
                eVar = new e(interfaceC0793Of);
            }
        } else {
            eVar = new e(interfaceC0793Of);
        }
        Object obj2 = eVar.b;
        Object objD = AbstractC0378Bt.d();
        int i3 = eVar.c;
        if (i3 == 0) {
            LL.b(obj2);
            eVar.a = interfaceC0995Vm;
            eVar.c = 1;
            if (interfaceC0995Vm.emit(obj, eVar) == objD) {
                return objD;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC0995Vm = (InterfaceC0995Vm) eVar.a;
            LL.b(obj2);
        }
        throw new r(interfaceC0995Vm);
    }

    public static final InterfaceC0939Tm e(InterfaceC0939Tm interfaceC0939Tm, int i2) {
        if (i2 > 0) {
            return new f(interfaceC0939Tm, i2);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " should be positive").toString());
    }

    public static final InterfaceC0939Tm f(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
        return new h(interfaceC0939Tm, interfaceC0526Fp);
    }
}
