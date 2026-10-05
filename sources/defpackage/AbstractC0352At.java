package defpackage;

/* JADX INFO: renamed from: At, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0352At {

    /* JADX INFO: renamed from: At$a */
    public static final class a extends IL {
        public int a;
        public final /* synthetic */ InterfaceC3750qp b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0793Of interfaceC0793Of, InterfaceC3750qp interfaceC3750qp) {
            super(interfaceC0793Of);
            this.b = interfaceC3750qp;
            AbstractC4492zt.f(interfaceC0793Of, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // defpackage.AbstractC2171f7
        public Object invokeSuspend(Object obj) throws Throwable {
            int i = this.a;
            if (i == 0) {
                this.a = 1;
                LL.b(obj);
                AbstractC4492zt.f(this.b, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                return ((InterfaceC3750qp) NV.d(this.b, 1)).invoke(this);
            }
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.a = 2;
            LL.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: At$b */
    public static final class b extends AbstractC0819Pf {
        public int a;
        public final /* synthetic */ InterfaceC3750qp b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC0793Of interfaceC0793Of, InterfaceC0988Vf interfaceC0988Vf, InterfaceC3750qp interfaceC3750qp) {
            super(interfaceC0793Of, interfaceC0988Vf);
            this.b = interfaceC3750qp;
            AbstractC4492zt.f(interfaceC0793Of, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // defpackage.AbstractC2171f7
        public Object invokeSuspend(Object obj) throws Throwable {
            int i = this.a;
            if (i == 0) {
                this.a = 1;
                LL.b(obj);
                AbstractC4492zt.f(this.b, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$0>, kotlin.Any?>");
                return ((InterfaceC3750qp) NV.d(this.b, 1)).invoke(this);
            }
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.a = 2;
            LL.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: At$c */
    public static final class c extends IL {
        public int a;
        public final /* synthetic */ InterfaceC0526Fp b;
        public final /* synthetic */ Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC0793Of interfaceC0793Of, InterfaceC0526Fp interfaceC0526Fp, Object obj) {
            super(interfaceC0793Of);
            this.b = interfaceC0526Fp;
            this.c = obj;
            AbstractC4492zt.f(interfaceC0793Of, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // defpackage.AbstractC2171f7
        public Object invokeSuspend(Object obj) throws Throwable {
            int i = this.a;
            if (i == 0) {
                this.a = 1;
                LL.b(obj);
                AbstractC4492zt.f(this.b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((InterfaceC0526Fp) NV.d(this.b, 2)).mo13invoke(this.c, this);
            }
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.a = 2;
            LL.b(obj);
            return obj;
        }
    }

    /* JADX INFO: renamed from: At$d */
    public static final class d extends AbstractC0819Pf {
        public int a;
        public final /* synthetic */ InterfaceC0526Fp b;
        public final /* synthetic */ Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC0793Of interfaceC0793Of, InterfaceC0988Vf interfaceC0988Vf, InterfaceC0526Fp interfaceC0526Fp, Object obj) {
            super(interfaceC0793Of, interfaceC0988Vf);
            this.b = interfaceC0526Fp;
            this.c = obj;
            AbstractC4492zt.f(interfaceC0793Of, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // defpackage.AbstractC2171f7
        public Object invokeSuspend(Object obj) throws Throwable {
            int i = this.a;
            if (i == 0) {
                this.a = 1;
                LL.b(obj);
                AbstractC4492zt.f(this.b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((InterfaceC0526Fp) NV.d(this.b, 2)).mo13invoke(this.c, this);
            }
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.a = 2;
            LL.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static InterfaceC0793Of a(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        AbstractC4492zt.h(interfaceC3750qp, "<this>");
        AbstractC4492zt.h(interfaceC0793Of, "completion");
        InterfaceC0793Of interfaceC0793OfA = AbstractC3416mi.a(interfaceC0793Of);
        if (interfaceC3750qp instanceof AbstractC2171f7) {
            return ((AbstractC2171f7) interfaceC3750qp).create(interfaceC0793OfA);
        }
        InterfaceC0988Vf context = interfaceC0793OfA.getContext();
        return context == C1172Zk.a ? new a(interfaceC0793OfA, interfaceC3750qp) : new b(interfaceC0793OfA, context, interfaceC3750qp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static InterfaceC0793Of b(InterfaceC0526Fp interfaceC0526Fp, Object obj, InterfaceC0793Of interfaceC0793Of) {
        AbstractC4492zt.h(interfaceC0526Fp, "<this>");
        AbstractC4492zt.h(interfaceC0793Of, "completion");
        InterfaceC0793Of interfaceC0793OfA = AbstractC3416mi.a(interfaceC0793Of);
        if (interfaceC0526Fp instanceof AbstractC2171f7) {
            return ((AbstractC2171f7) interfaceC0526Fp).create(obj, interfaceC0793OfA);
        }
        InterfaceC0988Vf context = interfaceC0793OfA.getContext();
        return context == C1172Zk.a ? new c(interfaceC0793OfA, interfaceC0526Fp, obj) : new d(interfaceC0793OfA, context, interfaceC0526Fp, obj);
    }

    public static InterfaceC0793Of c(InterfaceC0793Of interfaceC0793Of) {
        InterfaceC0793Of interfaceC0793OfIntercepted;
        AbstractC4492zt.h(interfaceC0793Of, "<this>");
        AbstractC0819Pf abstractC0819Pf = interfaceC0793Of instanceof AbstractC0819Pf ? (AbstractC0819Pf) interfaceC0793Of : null;
        return (abstractC0819Pf == null || (interfaceC0793OfIntercepted = abstractC0819Pf.intercepted()) == null) ? interfaceC0793Of : interfaceC0793OfIntercepted;
    }
}
