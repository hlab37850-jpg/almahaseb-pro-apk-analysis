package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.platform.InfiniteAnimationPolicy;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0703Ks;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class InfiniteAnimationPolicyKt {

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $onFrame;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$onFrame = interfaceC3750qp;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [R, java.lang.Object] */
        public final R invoke(long j) {
            return this.$onFrame.invoke(Long.valueOf(j / AnimationKt.MillisToNanos));
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).longValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.animation.core.InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2", f = "InfiniteAnimationPolicy.kt", l = {31}, m = "invokeSuspend")
    public static final class C12912 extends XS implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $onFrame;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12912(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
            super(1, interfaceC0793Of);
            this.$onFrame = interfaceC3750qp;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(InterfaceC0793Of interfaceC0793Of) {
            return new C12912(this.$onFrame, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC3750qp
        public final Object invoke(InterfaceC0793Of interfaceC0793Of) {
            return ((C12912) create(interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                InterfaceC3750qp interfaceC3750qp = this.$onFrame;
                this.label = 1;
                obj = MonotonicFrameClockKt.withFrameNanos(interfaceC3750qp, this);
                if (obj == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return obj;
        }
    }

    public static final <R> Object withInfiniteAnimationFrameMillis(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        return withInfiniteAnimationFrameNanos(new AnonymousClass2(interfaceC3750qp), interfaceC0793Of);
    }

    private static final <R> Object withInfiniteAnimationFrameMillis$$forInline(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC3750qp);
        AbstractC0703Ks.c(0);
        Object objWithInfiniteAnimationFrameNanos = withInfiniteAnimationFrameNanos(anonymousClass2, interfaceC0793Of);
        AbstractC0703Ks.c(1);
        return objWithInfiniteAnimationFrameNanos;
    }

    public static final <R> Object withInfiniteAnimationFrameNanos(InterfaceC3750qp interfaceC3750qp, InterfaceC0793Of interfaceC0793Of) {
        InfiniteAnimationPolicy infiniteAnimationPolicy = (InfiniteAnimationPolicy) interfaceC0793Of.getContext().get(InfiniteAnimationPolicy.Key);
        return infiniteAnimationPolicy == null ? MonotonicFrameClockKt.withFrameNanos(interfaceC3750qp, interfaceC0793Of) : infiniteAnimationPolicy.onInfiniteOperation(new C12912(interfaceC3750qp, null), interfaceC0793Of);
    }
}
