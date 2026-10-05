package androidx.paging.multicast;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC1165Zd;
import defpackage.AbstractC2287gb;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC1009Wa;
import defpackage.InterfaceC1038Xd;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC4038uO;
import defpackage.LL;
import defpackage.XS;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StoreRealActor<T> {
    private final InterfaceC1038Xd closeCompleted;
    private final AtomicBoolean didClose;
    private final InterfaceC1009Wa inboundChannel;
    public static final Companion Companion = new Companion(null);
    private static final Object CLOSE_TOKEN = new Object();

    /* JADX INFO: renamed from: androidx.paging.multicast.StoreRealActor$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.multicast.StoreRealActor$1", f = "StoreRealActor.kt", l = {45}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ StoreRealActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreRealActor<T> storeRealActor, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.this$0 = storeRealActor;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(obj, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                Object obj2 = this.L$0;
                if (obj2 == StoreRealActor.Companion.getCLOSE_TOKEN()) {
                    this.this$0.doClose();
                } else {
                    StoreRealActor<T> storeRealActor = this.this$0;
                    this.label = 1;
                    if (storeRealActor.handle((T) obj2, this) == objD) {
                        return objD;
                    }
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

    /* JADX INFO: renamed from: androidx.paging.multicast.StoreRealActor$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.multicast.StoreRealActor$2", f = "StoreRealActor.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0552Gp {
        int label;
        final /* synthetic */ StoreRealActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StoreRealActor<T> storeRealActor, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.this$0 = storeRealActor;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(InterfaceC0995Vm interfaceC0995Vm, Throwable th, InterfaceC0793Of interfaceC0793Of) {
            return new AnonymousClass2(this.this$0, interfaceC0793Of).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            this.this$0.doClose();
            return FW.a;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Object getCLOSE_TOKEN() {
            return StoreRealActor.CLOSE_TOKEN;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.paging.multicast.StoreRealActor$close$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.paging.multicast.StoreRealActor", f = "StoreRealActor.kt", l = {74, 76}, m = "close")
    public static final class C17321 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StoreRealActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17321(StoreRealActor<T> storeRealActor, InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
            this.this$0 = storeRealActor;
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.close(this);
        }
    }

    public StoreRealActor(InterfaceC2052dg interfaceC2052dg) {
        AbstractC4492zt.h(interfaceC2052dg, "scope");
        InterfaceC1009Wa interfaceC1009WaB = AbstractC2287gb.b(0, null, null, 6, null);
        this.inboundChannel = interfaceC1009WaB;
        this.closeCompleted = AbstractC1165Zd.b(null, 1, null);
        this.didClose = new AtomicBoolean(false);
        AbstractC1047Xm.v(AbstractC1047Xm.z(AbstractC1047Xm.A(AbstractC1047Xm.i(interfaceC1009WaB), new AnonymousClass1(this, null)), new AnonymousClass2(this, null)), interfaceC2052dg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doClose() {
        if (this.didClose.compareAndSet(false, true)) {
            try {
                onClosed();
            } finally {
                InterfaceC4038uO.a.a(this.inboundChannel, null, 1, null);
                this.closeCompleted.v(FW.a);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object close(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C17321 c17321;
        StoreRealActor<T> storeRealActor;
        if (interfaceC0793Of instanceof C17321) {
            c17321 = (C17321) interfaceC0793Of;
            int i = c17321.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c17321.label = i - Integer.MIN_VALUE;
            } else {
                c17321 = new C17321(this, interfaceC0793Of);
            }
        } else {
            c17321 = new C17321(this, interfaceC0793Of);
        }
        Object obj = c17321.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c17321.label;
        if (i2 != 0) {
            if (i2 == 1) {
                storeRealActor = (StoreRealActor) c17321.L$0;
                LL.b(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
        LL.b(obj);
        InterfaceC1009Wa interfaceC1009Wa = this.inboundChannel;
        Object obj2 = CLOSE_TOKEN;
        c17321.L$0 = this;
        c17321.label = 1;
        if (interfaceC1009Wa.send(obj2, c17321) == objD) {
            return objD;
        }
        storeRealActor = this;
        InterfaceC1038Xd interfaceC1038Xd = storeRealActor.closeCompleted;
        c17321.L$0 = null;
        c17321.label = 2;
        if (interfaceC1038Xd.u(c17321) == objD) {
            return objD;
        }
        return FW.a;
    }

    public abstract Object handle(T t, InterfaceC0793Of interfaceC0793Of);

    public void onClosed() {
    }

    public final Object send(T t, InterfaceC0793Of interfaceC0793Of) {
        Object objSend = this.inboundChannel.send(t, interfaceC0793Of);
        return objSend == AbstractC0378Bt.d() ? objSend : FW.a;
    }
}
