package androidx.paging;

import androidx.annotation.RestrictTo;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0939Tm;
import defpackage.InterfaceC1830bu;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.InterfaceC4038uO;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class CancelableChannelFlowKt {

    /* JADX INFO: renamed from: androidx.paging.CancelableChannelFlowKt$cancelableChannelFlow$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.CancelableChannelFlowKt$cancelableChannelFlow$1", f = "CancelableChannelFlow.kt", l = {33}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $block;
        final /* synthetic */ InterfaceC1830bu $controller;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.CancelableChannelFlowKt$cancelableChannelFlow$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01471 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ SimpleProducerScope<T> $$this$simpleChannelFlow;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01471(SimpleProducerScope<T> simpleProducerScope) {
                super(1);
                this.$$this$simpleChannelFlow = simpleProducerScope;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return FW.a;
            }

            public final void invoke(Throwable th) {
                InterfaceC4038uO.a.a(this.$$this$simpleChannelFlow, null, 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC1830bu interfaceC1830bu, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$controller = interfaceC1830bu;
            this.$block = interfaceC0526Fp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$controller, this.$block, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(SimpleProducerScope<T> simpleProducerScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(simpleProducerScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
                this.$controller.C(new C01471(simpleProducerScope));
                InterfaceC0526Fp interfaceC0526Fp = this.$block;
                this.label = 1;
                if (interfaceC0526Fp.mo13invoke(simpleProducerScope, this) == objD) {
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

    public static final <T> InterfaceC0939Tm cancelableChannelFlow(InterfaceC1830bu interfaceC1830bu, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC1830bu, "controller");
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        return SimpleChannelFlowKt.simpleChannelFlow(new AnonymousClass1(interfaceC1830bu, interfaceC0526Fp, null));
    }
}
