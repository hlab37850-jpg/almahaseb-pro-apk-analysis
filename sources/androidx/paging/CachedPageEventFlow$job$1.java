package androidx.paging;

import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1047Xm;
import defpackage.C0529Fs;
import defpackage.CC;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
@InterfaceC3252ki(c = "androidx.paging.CachedPageEventFlow$job$1", f = "CachedPageEventFlow.kt", l = {77}, m = "invokeSuspend")
public final class CachedPageEventFlow$job$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ InterfaceC0939Tm $src;
    int label;
    final /* synthetic */ CachedPageEventFlow<T> this$0;

    /* JADX INFO: renamed from: androidx.paging.CachedPageEventFlow$job$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements InterfaceC0995Vm {
        final /* synthetic */ CachedPageEventFlow<T> this$0;

        public AnonymousClass1(CachedPageEventFlow<T> cachedPageEventFlow) {
            this.this$0 = cachedPageEventFlow;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0995Vm
        public final Object emit(C0529Fs c0529Fs, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            CachedPageEventFlow$job$1$1$emit$1 cachedPageEventFlow$job$1$1$emit$1;
            AnonymousClass1<T> anonymousClass1;
            if (interfaceC0793Of instanceof CachedPageEventFlow$job$1$1$emit$1) {
                cachedPageEventFlow$job$1$1$emit$1 = (CachedPageEventFlow$job$1$1$emit$1) interfaceC0793Of;
                int i = cachedPageEventFlow$job$1$1$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    cachedPageEventFlow$job$1$1$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    cachedPageEventFlow$job$1$1$emit$1 = new CachedPageEventFlow$job$1$1$emit$1(this, interfaceC0793Of);
                }
            } else {
                cachedPageEventFlow$job$1$1$emit$1 = new CachedPageEventFlow$job$1$1$emit$1(this, interfaceC0793Of);
            }
            Object obj = cachedPageEventFlow$job$1$1$emit$1.result;
            Object objD = AbstractC0378Bt.d();
            int i2 = cachedPageEventFlow$job$1$1$emit$1.label;
            if (i2 != 0) {
                if (i2 == 1) {
                    c0529Fs = (C0529Fs) cachedPageEventFlow$job$1$1$emit$1.L$1;
                    anonymousClass1 = (AnonymousClass1) cachedPageEventFlow$job$1$1$emit$1.L$0;
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
            CC cc = ((CachedPageEventFlow) this.this$0).mutableSharedSrc;
            cachedPageEventFlow$job$1$1$emit$1.L$0 = this;
            cachedPageEventFlow$job$1$1$emit$1.L$1 = c0529Fs;
            cachedPageEventFlow$job$1$1$emit$1.label = 1;
            if (cc.emit(c0529Fs, cachedPageEventFlow$job$1$1$emit$1) == objD) {
                return objD;
            }
            anonymousClass1 = this;
            FlattenedPageController flattenedPageController = ((CachedPageEventFlow) anonymousClass1.this$0).pageController;
            cachedPageEventFlow$job$1$1$emit$1.L$0 = null;
            cachedPageEventFlow$job$1$1$emit$1.L$1 = null;
            cachedPageEventFlow$job$1$1$emit$1.label = 2;
            if (flattenedPageController.record(c0529Fs, cachedPageEventFlow$job$1$1$emit$1) == objD) {
                return objD;
            }
            return FW.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedPageEventFlow$job$1(InterfaceC0939Tm interfaceC0939Tm, CachedPageEventFlow<T> cachedPageEventFlow, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$src = interfaceC0939Tm;
        this.this$0 = cachedPageEventFlow;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return new CachedPageEventFlow$job$1(this.$src, this.this$0, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((CachedPageEventFlow$job$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            InterfaceC0939Tm interfaceC0939TmI = AbstractC1047Xm.I(this.$src);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (interfaceC0939TmI.collect(anonymousClass1, this) == objD) {
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
