package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class KS implements YO {
    public final YO a;
    public final InterfaceC0526Fp b;

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
            return KS.this.collect(null, this);
        }
    }

    public KS(YO yo, InterfaceC0526Fp interfaceC0526Fp) {
        this.a = yo;
        this.b = interfaceC0526Fp;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // defpackage.YO, defpackage.InterfaceC0939Tm
    public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) throws Throwable {
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
        Object obj = aVar.a;
        Object objD = AbstractC0378Bt.d();
        int i2 = aVar.c;
        if (i2 == 0) {
            LL.b(obj);
            YO yo = this.a;
            JS js = new JS(interfaceC0995Vm, this.b);
            aVar.c = 1;
            if (yo.collect(js, aVar) == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
        }
        throw new C1182Zu();
    }
}
