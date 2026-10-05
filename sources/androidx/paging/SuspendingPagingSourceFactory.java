package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1040Xf;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.LL;
import defpackage.M8;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
public final class SuspendingPagingSourceFactory<Key, Value> implements InterfaceC3588op {
    private final InterfaceC3588op delegate;
    private final AbstractC1040Xf dispatcher;

    /* JADX INFO: renamed from: androidx.paging.SuspendingPagingSourceFactory$create$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.SuspendingPagingSourceFactory$create$2", f = "SuspendingPagingSourceFactory.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        int label;
        final /* synthetic */ SuspendingPagingSourceFactory<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SuspendingPagingSourceFactory<Key, Value> suspendingPagingSourceFactory, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = suspendingPagingSourceFactory;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.this$0, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return ((SuspendingPagingSourceFactory) this.this$0).delegate.invoke();
        }
    }

    public SuspendingPagingSourceFactory(AbstractC1040Xf abstractC1040Xf, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(abstractC1040Xf, "dispatcher");
        AbstractC4492zt.h(interfaceC3588op, "delegate");
        this.dispatcher = abstractC1040Xf;
        this.delegate = interfaceC3588op;
    }

    public final Object create(InterfaceC0793Of interfaceC0793Of) {
        return M8.g(this.dispatcher, new AnonymousClass2(this, null), interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC3588op
    public PagingSource<Key, Value> invoke() {
        return (PagingSource) this.delegate.invoke();
    }
}
