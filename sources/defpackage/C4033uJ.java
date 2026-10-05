package defpackage;

/* JADX INFO: renamed from: uJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4033uJ implements NS {
    public final long a;
    public PS b;
    public final InterfaceC1009Wa c;

    /* JADX INFO: renamed from: uJ$a */
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
            return C4033uJ.this.e(this);
        }
    }

    public C4033uJ(int i, I8 i8, long j) {
        this.a = j;
        this.c = AbstractC2287gb.b(i == 0 ? 1 : i, i8, null, 4, null);
    }

    @Override // defpackage.NS, defpackage.InterfaceC4071un
    public void a(PS ps) {
        this.b = ps;
        d();
    }

    @Override // defpackage.NS
    public void b(Object obj) {
        if (C2451ib.j(this.c.mo0trySendJP2dKIU(obj))) {
            return;
        }
        throw new IllegalArgumentException(("Element " + obj + " was not added to channel because it was full, " + this.c).toString());
    }

    public final void c() {
        PS ps = this.b;
        if (ps == null) {
            AbstractC4492zt.x("subscription");
            ps = null;
        }
        ps.cancel();
    }

    public final void d() {
        PS ps = this.b;
        if (ps == null) {
            AbstractC4492zt.x("subscription");
            ps = null;
        }
        ps.l(this.a);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        a aVar;
        Object objB;
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
        Object obj = aVar.a;
        Object objD = AbstractC0378Bt.d();
        int i2 = aVar.c;
        if (i2 == 0) {
            LL.b(obj);
            InterfaceC1009Wa interfaceC1009Wa = this.c;
            aVar.c = 1;
            objB = interfaceC1009Wa.b(aVar);
            if (objB == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            objB = ((C2451ib) obj).l();
        }
        Throwable thE = C2451ib.e(objB);
        if (thE != null) {
            throw thE;
        }
        if (!(objB instanceof C2451ib.c)) {
            return objB;
        }
        C2451ib.e(objB);
        return null;
    }

    @Override // defpackage.NS
    public void onComplete() {
        InterfaceC4038uO.a.a(this.c, null, 1, null);
    }

    @Override // defpackage.NS
    public void onError(Throwable th) {
        this.c.close(th);
    }
}
