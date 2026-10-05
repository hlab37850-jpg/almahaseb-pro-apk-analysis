package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0819Pf;
import defpackage.AbstractC2233fv;
import defpackage.E8;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.LJ;
import defpackage.LL;
import defpackage.PN;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollExtensionsKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", l = {40}, m = "animateScrollBy")
    public static final class AnonymousClass1 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScrollExtensionsKt.animateScrollBy(null, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2", f = "ScrollExtensions.kt", l = {41}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ LJ $previousValue;
        final /* synthetic */ float $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$animateScrollBy$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ ScrollScope $$this$scroll;
            final /* synthetic */ LJ $previousValue;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(LJ lj, ScrollScope scrollScope) {
                super(2);
                this.$previousValue = lj;
                this.$$this$scroll = scrollScope;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                return FW.a;
            }

            public final void invoke(float f, float f2) {
                LJ lj = this.$previousValue;
                float f3 = lj.a;
                lj.a = f3 + this.$$this$scroll.scrollBy(f - f3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, AnimationSpec<Float> animationSpec, LJ lj, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$value = f;
            this.$animationSpec = animationSpec;
            this.$previousValue = lj;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$value, this.$animationSpec, this.$previousValue, interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(ScrollScope scrollScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(scrollScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                ScrollScope scrollScope = (ScrollScope) this.L$0;
                float f = this.$value;
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$previousValue, scrollScope);
                this.label = 1;
                if (SuspendAnimationKt.animate$default(0.0f, f, 0.0f, animationSpec, anonymousClass1, this, 4, null) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", l = {61}, m = "scrollBy")
    public static final class C13261 extends AbstractC0819Pf {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C13261(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScrollExtensionsKt.scrollBy(null, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$2", f = "ScrollExtensions.kt", l = {}, m = "invokeSuspend")
    public static final class C13272 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ LJ $consumed;
        final /* synthetic */ float $value;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13272(LJ lj, float f, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$consumed = lj;
            this.$value = f;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C13272 c13272 = new C13272(this.$consumed, this.$value, interfaceC0793Of);
            c13272.L$0 = obj;
            return c13272;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(ScrollScope scrollScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C13272) create(scrollScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            ScrollScope scrollScope = (ScrollScope) this.L$0;
            this.$consumed.a = scrollScope.scrollBy(this.$value);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollExtensionsKt$stopScroll$2, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$stopScroll$2", f = "ScrollExtensions.kt", l = {}, m = "invokeSuspend")
    public static final class C13282 extends XS implements InterfaceC0526Fp {
        int label;

        public C13282(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new C13282(interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(ScrollScope scrollScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C13282) create(scrollScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0378Bt.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LL.b(obj);
            return FW.a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object animateScrollBy(ScrollableState scrollableState, float f, AnimationSpec<Float> animationSpec, InterfaceC0793Of interfaceC0793Of) {
        AnonymousClass1 anonymousClass1;
        LJ lj;
        if (interfaceC0793Of instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) interfaceC0793Of;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(interfaceC0793Of);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = anonymousClass2.label;
        if (i2 == 0) {
            LL.b(obj);
            LJ lj2 = new LJ();
            AnonymousClass2 anonymousClass3 = new AnonymousClass2(f, animationSpec, lj2, null);
            anonymousClass2.L$0 = lj2;
            anonymousClass2.label = 1;
            if (PN.e(scrollableState, null, anonymousClass3, anonymousClass2, 1, null) == objD) {
                return objD;
            }
            lj = lj2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lj = (LJ) anonymousClass2.L$0;
            LL.b(obj);
        }
        return E8.b(lj.a);
    }

    public static /* synthetic */ Object animateScrollBy$default(ScrollableState scrollableState, float f, AnimationSpec animationSpec, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return animateScrollBy(scrollableState, f, animationSpec, interfaceC0793Of);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public static final Object scrollBy(ScrollableState scrollableState, float f, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        C13261 c13261;
        LJ lj;
        if (interfaceC0793Of instanceof C13261) {
            c13261 = (C13261) interfaceC0793Of;
            int i = c13261.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13261.label = i - Integer.MIN_VALUE;
            } else {
                c13261 = new C13261(interfaceC0793Of);
            }
        } else {
            c13261 = new C13261(interfaceC0793Of);
        }
        C13261 c13262 = c13261;
        Object obj = c13262.result;
        Object objD = AbstractC0378Bt.d();
        int i2 = c13262.label;
        if (i2 == 0) {
            LL.b(obj);
            LJ lj2 = new LJ();
            C13272 c13272 = new C13272(lj2, f, null);
            c13262.L$0 = lj2;
            c13262.label = 1;
            if (PN.e(scrollableState, null, c13272, c13262, 1, null) == objD) {
                return objD;
            }
            lj = lj2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lj = (LJ) c13262.L$0;
            LL.b(obj);
        }
        return E8.b(lj.a);
    }

    public static final Object stopScroll(ScrollableState scrollableState, MutatePriority mutatePriority, InterfaceC0793Of interfaceC0793Of) {
        Object objScroll = scrollableState.scroll(mutatePriority, new C13282(null), interfaceC0793Of);
        return objScroll == AbstractC0378Bt.d() ? objScroll : FW.a;
    }

    public static /* synthetic */ Object stopScroll$default(ScrollableState scrollableState, MutatePriority mutatePriority, InterfaceC0793Of interfaceC0793Of, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopScroll(scrollableState, mutatePriority, interfaceC0793Of);
    }
}
