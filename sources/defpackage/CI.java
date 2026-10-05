package defpackage;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: loaded from: classes3.dex */
public final class CI extends AbstractC1162Za {
    public final BI d;

    public static final class a extends AbstractC0819Pf {
        public Object a;
        public Object b;
        public Object c;
        public long d;
        public /* synthetic */ Object e;
        public int g;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return CI.this.o(null, null, this);
        }
    }

    public static final class b extends XS implements InterfaceC0526Fp {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ InterfaceC0995Vm c;
        public final /* synthetic */ CI d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC0995Vm interfaceC0995Vm, CI ci, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.c = interfaceC0995Vm;
            this.d = ci;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            b bVar = new b(this.c, this.d, interfaceC0793Of);
            bVar.b = obj;
            return bVar;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((b) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i == 0) {
                LL.b(obj);
                InterfaceC2052dg interfaceC2052dg = (InterfaceC2052dg) this.b;
                InterfaceC0995Vm interfaceC0995Vm = this.c;
                CI ci = this.d;
                IJ ijM = ci.m(AbstractC2133eg.f(interfaceC2052dg, ci.a));
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

    public /* synthetic */ CI(BI bi, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8, int i2, AbstractC0419Di abstractC0419Di) {
        this(bi, (i2 & 2) != 0 ? C1172Zk.a : interfaceC0988Vf, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? I8.SUSPEND : i8);
    }

    @Override // defpackage.AbstractC1162Za, defpackage.InterfaceC0939Tm
    public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        InterfaceC0988Vf context = interfaceC0793Of.getContext();
        InterfaceC0988Vf interfaceC0988Vf = this.a;
        InterfaceC0854Qf.b bVar = InterfaceC0854Qf.o;
        InterfaceC0854Qf interfaceC0854Qf = (InterfaceC0854Qf) interfaceC0988Vf.get(bVar);
        if (interfaceC0854Qf == null || AbstractC4492zt.d(interfaceC0854Qf, context.get(bVar))) {
            Object objO = o(context.plus(this.a), interfaceC0995Vm, interfaceC0793Of);
            return objO == AbstractC0378Bt.d() ? objO : FW.a;
        }
        Object objP = p(interfaceC0995Vm, interfaceC0793Of);
        return objP == AbstractC0378Bt.d() ? objP : FW.a;
    }

    @Override // defpackage.AbstractC1162Za
    public Object g(InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        Object objO = o(interfaceC2103eI.getCoroutineContext(), new C4281xO(interfaceC2103eI.getChannel()), interfaceC0793Of);
        return objO == AbstractC0378Bt.d() ? objO : FW.a;
    }

    @Override // defpackage.AbstractC1162Za
    public AbstractC1162Za h(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return new CI(this.d, interfaceC0988Vf, i, i8);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0090  */
    /* JADX WARN: Code duplicated, block: B:28:0x0097  */
    /* JADX WARN: Code duplicated, block: B:30:0x009d A[Catch: all -> 0x0042, TRY_ENTER, TryCatch #0 {all -> 0x0042, blocks: (B:13:0x003c, B:33:0x00b5, B:35:0x00c1, B:23:0x007f, B:30:0x009d, B:20:0x005b), top: B:40:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c1 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:13:0x003c, B:33:0x00b5, B:35:0x00c1, B:23:0x007f, B:30:0x009d, B:20:0x005b), top: B:40:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v8, types: [uJ] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00b2 -> B:14:0x003f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object o(defpackage.InterfaceC0988Vf r18, defpackage.InterfaceC0995Vm r19, defpackage.InterfaceC0793Of r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.CI.o(Vf, Vm, Of):java.lang.Object");
    }

    public final Object p(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        Object objD = AbstractC2133eg.d(new b(interfaceC0995Vm, this, null), interfaceC0793Of);
        return objD == AbstractC0378Bt.d() ? objD : FW.a;
    }

    public final long q() {
        if (this.c != I8.SUSPEND) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        int i = this.b;
        if (i == -2) {
            return InterfaceC1009Wa.m.a();
        }
        if (i == 0) {
            return 1L;
        }
        if (i == Integer.MAX_VALUE) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        long j = i;
        if (j >= 1) {
            return j;
        }
        throw new IllegalStateException("Check failed.");
    }

    public CI(BI bi, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        super(interfaceC0988Vf, i, i8);
        this.d = bi;
    }
}
