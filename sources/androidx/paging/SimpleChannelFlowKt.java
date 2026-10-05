package androidx.paging;

import androidx.annotation.RestrictTo;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1047Xm;
import defpackage.AbstractC1823bn;
import defpackage.AbstractC2133eg;
import defpackage.AbstractC4492zt;
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
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class SimpleChannelFlowKt {

    /* JADX INFO: renamed from: androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1", f = "SimpleChannelFlow.kt", l = {49}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ InterfaceC0526Fp $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1", f = "SimpleChannelFlow.kt", l = {67, 68}, m = "invokeSuspend")
        public static final class C01601 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ InterfaceC0995Vm $$this$flow;
            final /* synthetic */ InterfaceC0526Fp $block;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01601(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$$this$flow = interfaceC0995Vm;
                this.$block = interfaceC0526Fp;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                C01601 c01601 = new C01601(this.$$this$flow, this.$block, interfaceC0793Of);
                c01601.L$0 = obj;
                return c01601;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                return ((C01601) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            /* JADX WARN: Code duplicated, block: B:14:0x005e A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:15:0x005f  */
            /* JADX WARN: Code duplicated, block: B:18:0x006b  */
            /* JADX WARN: Code duplicated, block: B:20:0x007d A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:21:0x007e  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007b -> B:7:0x001a). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // defpackage.AbstractC2171f7
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = defpackage.AbstractC0378Bt.d()
                    int r1 = r12.label
                    r2 = 2
                    r3 = 1
                    r4 = 0
                    if (r1 == 0) goto L31
                    if (r1 == r3) goto L25
                    if (r1 != r2) goto L1d
                    java.lang.Object r1 = r12.L$1
                    fb r1 = (defpackage.InterfaceC2205fb) r1
                    java.lang.Object r5 = r12.L$0
                    bu r5 = (defpackage.InterfaceC1830bu) r5
                    defpackage.LL.b(r13)
                L1a:
                    r13 = r1
                    r1 = r5
                    goto L52
                L1d:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L25:
                    java.lang.Object r1 = r12.L$1
                    fb r1 = (defpackage.InterfaceC2205fb) r1
                    java.lang.Object r5 = r12.L$0
                    bu r5 = (defpackage.InterfaceC1830bu) r5
                    defpackage.LL.b(r13)
                    goto L63
                L31:
                    defpackage.LL.b(r13)
                    java.lang.Object r13 = r12.L$0
                    r5 = r13
                    dg r5 = (defpackage.InterfaceC2052dg) r5
                    r13 = 0
                    r1 = 6
                    Wa r13 = defpackage.AbstractC2287gb.b(r13, r4, r4, r1, r4)
                    androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1 r8 = new androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1$1$producer$1
                    Fp r1 = r12.$block
                    r8.<init>(r13, r1, r4)
                    r9 = 3
                    r10 = 0
                    r6 = 0
                    r7 = 0
                    bu r1 = defpackage.M8.d(r5, r6, r7, r8, r9, r10)
                    fb r13 = r13.iterator()
                L52:
                    r12.L$0 = r1
                    r12.L$1 = r13
                    r12.label = r3
                    java.lang.Object r5 = r13.a(r12)
                    if (r5 != r0) goto L5f
                    return r0
                L5f:
                    r11 = r1
                    r1 = r13
                    r13 = r5
                    r5 = r11
                L63:
                    java.lang.Boolean r13 = (java.lang.Boolean) r13
                    boolean r13 = r13.booleanValue()
                    if (r13 == 0) goto L7e
                    java.lang.Object r13 = r1.next()
                    Vm r6 = r12.$$this$flow
                    r12.L$0 = r5
                    r12.L$1 = r1
                    r12.label = r2
                    java.lang.Object r13 = r6.emit(r13, r12)
                    if (r13 != r0) goto L1a
                    return r0
                L7e:
                    defpackage.InterfaceC1830bu.a.a(r5, r4, r3, r4)
                    FW r13 = defpackage.FW.a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SimpleChannelFlowKt.AnonymousClass1.C01601.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$block = interfaceC0526Fp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$block, interfaceC0793Of);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                C01601 c01601 = new C01601((InterfaceC0995Vm) this.L$0, this.$block, null);
                this.label = 1;
                if (AbstractC2133eg.d(c01601, this) == objD) {
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

    public static final <T> InterfaceC0939Tm simpleChannelFlow(InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC4492zt.h(interfaceC0526Fp, CSS.Value.BLOCK);
        return AbstractC1823bn.b(AbstractC1047Xm.s(new AnonymousClass1(interfaceC0526Fp, null)), -2, null, 2, null);
    }
}
