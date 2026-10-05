package defpackage;

/* JADX INFO: renamed from: na, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3482na extends AbstractC1237ab {
    public final InterfaceC0526Fp e;

    /* JADX INFO: renamed from: na$a */
    public static final class a extends AbstractC0819Pf {
        public Object a;
        public /* synthetic */ Object b;
        public int d;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return C3482na.this.g(null, this);
        }
    }

    public /* synthetic */ C3482na(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8, int i2, AbstractC0419Di abstractC0419Di) {
        this(interfaceC0526Fp, (i2 & 2) != 0 ? C1172Zk.a : interfaceC0988Vf, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? I8.SUSPEND : i8);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // defpackage.AbstractC1237ab, defpackage.AbstractC1162Za
    public Object g(InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        a aVar;
        if (interfaceC0793Of instanceof a) {
            aVar = (a) interfaceC0793Of;
            int i = aVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.d = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(interfaceC0793Of);
            }
        } else {
            aVar = new a(interfaceC0793Of);
        }
        Object obj = aVar.b;
        Object objD = AbstractC0378Bt.d();
        int i2 = aVar.d;
        if (i2 == 0) {
            LL.b(obj);
            aVar.a = interfaceC2103eI;
            aVar.d = 1;
            if (super.g(interfaceC2103eI, aVar) == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            interfaceC2103eI = (InterfaceC2103eI) aVar.a;
            LL.b(obj);
        }
        if (interfaceC2103eI.isClosedForSend()) {
            return FW.a;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }

    @Override // defpackage.AbstractC1162Za
    public AbstractC1162Za h(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return new C3482na(this.e, interfaceC0988Vf, i, i8);
    }

    public C3482na(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        super(interfaceC0526Fp, interfaceC0988Vf, i, i8);
        this.e = interfaceC0526Fp;
    }
}
