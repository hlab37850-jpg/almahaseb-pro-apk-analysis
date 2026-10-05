package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC4492zt;
import defpackage.C0529Fs;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.MJ;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1", f = "CachedPageEventFlow.kt", l = {103}, m = "invokeSuspend")
public final class CachedPageEventFlow$downstreamFlow$1 extends XS implements InterfaceC0526Fp {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CachedPageEventFlow<T> this$0;

    /* JADX INFO: renamed from: androidx.paging.CachedPageEventFlow$downstreamFlow$1$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1$1", f = "CachedPageEventFlow.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(C0529Fs c0529Fs, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(c0529Fs, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return E8.a(((C0529Fs) this.L$0) != null);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.CachedPageEventFlow$downstreamFlow$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements InterfaceC0995Vm {
        final /* synthetic */ InterfaceC0995Vm $$this$flow;
        final /* synthetic */ MJ $maxEventIndex;

        public AnonymousClass2(MJ mj, InterfaceC0995Vm interfaceC0995Vm) {
            this.$maxEventIndex = mj;
            this.$$this$flow = interfaceC0995Vm;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0995Vm
        public final Object emit(C0529Fs c0529Fs, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            CachedPageEventFlow$downstreamFlow$1$2$emit$1 cachedPageEventFlow$downstreamFlow$1$2$emit$1;
            AnonymousClass2<T> anonymousClass2;
            if (interfaceC0793Of instanceof CachedPageEventFlow$downstreamFlow$1$2$emit$1) {
                cachedPageEventFlow$downstreamFlow$1$2$emit$1 = (CachedPageEventFlow$downstreamFlow$1$2$emit$1) interfaceC0793Of;
                int i = cachedPageEventFlow$downstreamFlow$1$2$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    cachedPageEventFlow$downstreamFlow$1$2$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    cachedPageEventFlow$downstreamFlow$1$2$emit$1 = new CachedPageEventFlow$downstreamFlow$1$2$emit$1(this, interfaceC0793Of);
                }
            } else {
                cachedPageEventFlow$downstreamFlow$1$2$emit$1 = new CachedPageEventFlow$downstreamFlow$1$2$emit$1(this, interfaceC0793Of);
            }
            Object obj = cachedPageEventFlow$downstreamFlow$1$2$emit$1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = cachedPageEventFlow$downstreamFlow$1$2$emit$1.label;
            if (i2 == 0) {
                LL.b(obj);
                AbstractC4492zt.e(c0529Fs);
                if (c0529Fs.a() > this.$maxEventIndex.a) {
                    InterfaceC0995Vm interfaceC0995Vm = this.$$this$flow;
                    Object objB = c0529Fs.b();
                    cachedPageEventFlow$downstreamFlow$1$2$emit$1.L$0 = this;
                    cachedPageEventFlow$downstreamFlow$1$2$emit$1.L$1 = c0529Fs;
                    cachedPageEventFlow$downstreamFlow$1$2$emit$1.label = 1;
                    if (interfaceC0995Vm.emit(objB, cachedPageEventFlow$downstreamFlow$1$2$emit$1) == objD) {
                        return objD;
                    }
                    anonymousClass2 = this;
                }
                return FW.a;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c0529Fs = (C0529Fs) cachedPageEventFlow$downstreamFlow$1$2$emit$1.L$1;
            anonymousClass2 = (AnonymousClass2) cachedPageEventFlow$downstreamFlow$1$2$emit$1.L$0;
            LL.b(obj);
            anonymousClass2.$maxEventIndex.a = c0529Fs.a();
            return FW.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedPageEventFlow$downstreamFlow$1(CachedPageEventFlow<T> cachedPageEventFlow, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.this$0 = cachedPageEventFlow;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        CachedPageEventFlow$downstreamFlow$1 cachedPageEventFlow$downstreamFlow$1 = new CachedPageEventFlow$downstreamFlow$1(this.this$0, interfaceC0793Of);
        cachedPageEventFlow$downstreamFlow$1.L$0 = obj;
        return cachedPageEventFlow$downstreamFlow$1;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        return ((CachedPageEventFlow$downstreamFlow$1) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            InterfaceC0995Vm interfaceC0995Vm = (InterfaceC0995Vm) this.L$0;
            MJ mj = new MJ();
            mj.a = Integer.MIN_VALUE;
            InterfaceC0939Tm interfaceC0939TmG = AbstractC1047Xm.G(((CachedPageEventFlow) this.this$0).sharedForDownstream, new AnonymousClass1(null));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(mj, interfaceC0995Vm);
            this.label = 1;
            if (interfaceC0939TmG.collect(anonymousClass2, this) == objD) {
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
