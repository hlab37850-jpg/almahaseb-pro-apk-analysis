package defpackage;

/* JADX INFO: renamed from: xW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4289xW implements InterfaceC0995Vm {
    public final InterfaceC0988Vf a;
    public final Object b;
    public final InterfaceC0526Fp c;

    /* JADX INFO: renamed from: xW$a */
    public static final class a extends XS implements InterfaceC0526Fp {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ InterfaceC0995Vm c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.c = interfaceC0995Vm;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            a aVar = new a(this.c, interfaceC0793Of);
            aVar.b = obj;
            return aVar;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return ((a) create(obj, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i == 0) {
                LL.b(obj);
                Object obj2 = this.b;
                InterfaceC0995Vm interfaceC0995Vm = this.c;
                this.a = 1;
                if (interfaceC0995Vm.emit(obj2, this) == objD) {
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

    public C4289xW(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0988Vf interfaceC0988Vf) {
        this.a = interfaceC0988Vf;
        this.b = AbstractC4368yU.b(interfaceC0988Vf);
        this.c = new a(interfaceC0995Vm, null);
    }

    @Override // defpackage.InterfaceC0995Vm
    public Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) {
        Object objB = AbstractC1803bb.b(this.a, obj, this.b, this.c, interfaceC0793Of);
        return objB == AbstractC0378Bt.d() ? objB : FW.a;
    }
}
