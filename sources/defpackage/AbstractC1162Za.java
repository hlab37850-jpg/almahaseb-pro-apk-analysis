package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: Za, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1162Za implements InterfaceC1826bq {
    public final InterfaceC0988Vf a;
    public final int b;
    public final I8 c;

    /* JADX INFO: renamed from: Za$a */
    public static final class a extends XS implements InterfaceC0526Fp {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ InterfaceC0995Vm c;
        public final /* synthetic */ AbstractC1162Za d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0995Vm interfaceC0995Vm, AbstractC1162Za abstractC1162Za, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.c = interfaceC0995Vm;
            this.d = abstractC1162Za;
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

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.b;
                InterfaceC0995Vm interfaceC0995Vm = this.c;
                IJ ijM = this.d.m(interfaceC2052dg);
                this.a = 1;
                if (AbstractC1047Xm.n(interfaceC0995Vm, ijM, this) == objD) {
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

    /* JADX INFO: renamed from: Za$b */
    public static final class b extends XS implements InterfaceC0526Fp {
        public int a;
        public /* synthetic */ Object b;

        public b(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            b bVar = AbstractC1162Za.this.new b(interfaceC0793Of);
            bVar.b = obj;
            return bVar;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) {
            return ((b) create(interfaceC2103eI, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2103eI interfaceC2103eI = (InterfaceC2103eI) this.b;
                AbstractC1162Za abstractC1162Za = AbstractC1162Za.this;
                this.a = 1;
                if (abstractC1162Za.g(interfaceC2103eI, this) == objD) {
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

    public AbstractC1162Za(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        this.a = interfaceC0988Vf;
        this.b = i;
        this.c = i8;
    }

    public static /* synthetic */ Object e(AbstractC1162Za abstractC1162Za, InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        Object objD = AbstractC2133eg.d(new a(interfaceC0995Vm, abstractC1162Za, null), interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    @Override // defpackage.InterfaceC1826bq
    public InterfaceC0939Tm a(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        InterfaceC0988Vf interfaceC0988VfPlus = interfaceC0988Vf.plus(this.a);
        if (i8 == I8.SUSPEND) {
            int i2 = this.b;
            if (i2 != -3) {
                if (i == -3) {
                    i = i2;
                } else if (i2 != -2) {
                    if (i == -2) {
                        i = i2;
                    } else {
                        i += i2;
                        if (i < 0) {
                            i = Integer.MAX_VALUE;
                        }
                    }
                }
            }
            i8 = this.c;
        }
        return (AbstractC4492zt.d(interfaceC0988VfPlus, this.a) && i == this.b && i8 == this.c) ? this : h(interfaceC0988VfPlus, i, i8);
    }

    @Override // defpackage.InterfaceC0939Tm
    public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        return e(this, interfaceC0995Vm, interfaceC0793Of);
    }

    public String d() {
        return null;
    }

    public abstract Object g(InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of);

    public abstract AbstractC1162Za h(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8);

    public InterfaceC0939Tm j() {
        return null;
    }

    public final InterfaceC0526Fp k() {
        return new b(null);
    }

    public final int l() {
        int i = this.b;
        if (i == -3) {
            return -2;
        }
        return i;
    }

    public IJ m(InterfaceC2052dg interfaceC2052dg) {
        return AbstractC1864cI.d(interfaceC2052dg, this.a, l(), this.c, EnumC2379hg.ATOMIC, null, k(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strD = d();
        if (strD != null) {
            arrayList.add(strD);
        }
        if (this.a != C1172Zk.a) {
            arrayList.add("context=" + this.a);
        }
        if (this.b != -3) {
            arrayList.add("capacity=" + this.b);
        }
        if (this.c != I8.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.c);
        }
        return AbstractC3498ni.a(this) + '[' + AbstractC3240kc.j0(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
