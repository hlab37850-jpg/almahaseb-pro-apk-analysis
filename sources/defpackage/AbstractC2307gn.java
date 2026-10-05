package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: gn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC2307gn {

    /* JADX INFO: renamed from: gn$a */
    public static final class a implements InterfaceC0995Vm {
        public final /* synthetic */ InterfaceC0526Fp a;
        public final /* synthetic */ OJ b;

        /* JADX INFO: renamed from: gn$a$a, reason: collision with other inner class name */
        public static final class C0284a extends AbstractC0819Pf {
            public Object a;
            public /* synthetic */ Object b;
            public int c;
            public Object e;

            public C0284a(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.c |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        public a(InterfaceC0526Fp interfaceC0526Fp, OJ oj) {
            this.a = interfaceC0526Fp;
            this.b = oj;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0995Vm
        public Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            C0284a c0284a;
            a aVar;
            if (interfaceC0793Of instanceof C0284a) {
                c0284a = (C0284a) interfaceC0793Of;
                int i = c0284a.c;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c0284a.c = i - Integer.MIN_VALUE;
                } else {
                    c0284a = new C0284a(interfaceC0793Of);
                }
            } else {
                c0284a = new C0284a(interfaceC0793Of);
            }
            Object objMo13invoke = c0284a.b;
            Object objD = AbstractC0378Bt.d();
            int i2 = c0284a.c;
            if (i2 == 0) {
                LL.b(objMo13invoke);
                InterfaceC0526Fp interfaceC0526Fp = this.a;
                c0284a.a = this;
                c0284a.e = obj;
                c0284a.c = 1;
                AbstractC0703Ks.c(6);
                objMo13invoke = interfaceC0526Fp.mo13invoke(obj, c0284a);
                AbstractC0703Ks.c(7);
                if (objMo13invoke == objD) {
                    return objD;
                }
                aVar = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = c0284a.e;
                aVar = (a) c0284a.a;
                LL.b(objMo13invoke);
            }
            if (!((Boolean) objMo13invoke).booleanValue()) {
                return FW.a;
            }
            aVar.b.a = obj;
            throw new r(aVar);
        }
    }

    /* JADX INFO: renamed from: gn$b */
    public static final class b extends AbstractC0819Pf {
        public Object a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public b(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return AbstractC1047Xm.q(null, null, this);
        }
    }

    /* JADX INFO: renamed from: gn$c */
    public static final class c implements InterfaceC0995Vm {
        public final /* synthetic */ InterfaceC0526Fp a;
        public final /* synthetic */ OJ b;

        /* JADX INFO: renamed from: gn$c$a */
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
                return c.this.emit(null, this);
            }
        }

        public c(InterfaceC0526Fp interfaceC0526Fp, OJ oj) {
            this.a = interfaceC0526Fp;
            this.b = oj;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0995Vm
        public Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            a aVar;
            c cVar;
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
            Object objMo13invoke = aVar.b;
            Object objD = AbstractC0378Bt.d();
            int i2 = aVar.c;
            if (i2 == 0) {
                LL.b(objMo13invoke);
                InterfaceC0526Fp interfaceC0526Fp = this.a;
                aVar.a = this;
                aVar.e = obj;
                aVar.c = 1;
                AbstractC0703Ks.c(6);
                objMo13invoke = interfaceC0526Fp.mo13invoke(obj, aVar);
                AbstractC0703Ks.c(7);
                if (objMo13invoke == objD) {
                    return objD;
                }
                cVar = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = aVar.e;
                cVar = (c) aVar.a;
                LL.b(objMo13invoke);
            }
            if (!((Boolean) objMo13invoke).booleanValue()) {
                return FW.a;
            }
            cVar.b.a = obj;
            throw new r(cVar);
        }
    }

    /* JADX INFO: renamed from: gn$d */
    public static final class d extends AbstractC0819Pf {
        public Object a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public d(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return AbstractC1047Xm.r(null, null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        b bVar;
        InterfaceC0526Fp interfaceC0526Fp2;
        OJ oj;
        r e;
        InterfaceC0995Vm interfaceC0995Vm;
        if (interfaceC0793Of instanceof b) {
            bVar = (b) interfaceC0793Of;
            int i = bVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.e = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(interfaceC0793Of);
            }
        } else {
            bVar = new b(interfaceC0793Of);
        }
        Object obj = bVar.d;
        Object objD = AbstractC0378Bt.d();
        int i2 = bVar.e;
        if (i2 == 0) {
            LL.b(obj);
            OJ oj2 = new OJ();
            oj2.a = VD.a;
            InterfaceC0995Vm aVar = new a(interfaceC0526Fp, oj2);
            try {
                bVar.a = interfaceC0526Fp;
                bVar.b = oj2;
                bVar.c = aVar;
                bVar.e = 1;
                if (interfaceC0939Tm.collect(aVar, bVar) == objD) {
                    return objD;
                }
                interfaceC0526Fp2 = interfaceC0526Fp;
                oj = oj2;
            } catch (r e2) {
                interfaceC0526Fp2 = interfaceC0526Fp;
                oj = oj2;
                e = e2;
                interfaceC0995Vm = aVar;
                AbstractC1021Wm.a(e, interfaceC0995Vm);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC0995Vm = (a) bVar.c;
            oj = (OJ) bVar.b;
            interfaceC0526Fp2 = (InterfaceC0526Fp) bVar.a;
            try {
                LL.b(obj);
            } catch (r e3) {
                e = e3;
                AbstractC1021Wm.a(e, interfaceC0995Vm);
            }
        }
        Object obj2 = oj.a;
        if (obj2 != VD.a) {
            return obj2;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate " + interfaceC0526Fp2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        d dVar;
        OJ oj;
        r e;
        InterfaceC0995Vm interfaceC0995Vm;
        if (interfaceC0793Of instanceof d) {
            dVar = (d) interfaceC0793Of;
            int i = dVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.d = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(interfaceC0793Of);
            }
        } else {
            dVar = new d(interfaceC0793Of);
        }
        Object obj = dVar.c;
        Object objD = AbstractC0378Bt.d();
        int i2 = dVar.d;
        if (i2 == 0) {
            LL.b(obj);
            OJ oj2 = new OJ();
            InterfaceC0995Vm cVar = new c(interfaceC0526Fp, oj2);
            try {
                dVar.a = oj2;
                dVar.b = cVar;
                dVar.d = 1;
                if (interfaceC0939Tm.collect(cVar, dVar) == objD) {
                    return objD;
                }
                oj = oj2;
            } catch (r e2) {
                oj = oj2;
                e = e2;
                interfaceC0995Vm = cVar;
                AbstractC1021Wm.a(e, interfaceC0995Vm);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC0995Vm = (c) dVar.b;
            oj = (OJ) dVar.a;
            try {
                LL.b(obj);
            } catch (r e3) {
                e = e3;
                AbstractC1021Wm.a(e, interfaceC0995Vm);
            }
        }
        return oj.a;
    }
}
