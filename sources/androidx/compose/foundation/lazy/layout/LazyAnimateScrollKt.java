package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Dp;
import com.google.android.gms.common.ConnectionResult;
import com.itextpdf.text.Jpeg;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.KJ;
import defpackage.LJ;
import defpackage.MJ;
import defpackage.OJ;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
public final class LazyAnimateScrollKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m5160constructorimpl(2500);
    private static final float BoundDistance = Dp.m5160constructorimpl(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
    private static final float MinimumDistance = Dp.m5160constructorimpl(50);

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", l = {ShapeTypes.FLOW_CHART_DOCUMENT, Jpeg.M_APPD}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        final /* synthetic */ LazyAnimateScrollScope $this_animateScrollToItem;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3, reason: invalid class name */
        public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ ScrollScope $$this$scroll;
            final /* synthetic */ OJ $anim;
            final /* synthetic */ float $boundDistancePx;
            final /* synthetic */ boolean $forward;
            final /* synthetic */ int $index;
            final /* synthetic */ KJ $loop;
            final /* synthetic */ MJ $loops;
            final /* synthetic */ LJ $prevValue;
            final /* synthetic */ int $scrollOffset;
            final /* synthetic */ float $target;
            final /* synthetic */ LazyAnimateScrollScope $this_animateScrollToItem;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(LazyAnimateScrollScope lazyAnimateScrollScope, int i, float f, LJ lj, ScrollScope scrollScope, KJ kj, boolean z, float f2, MJ mj, int i2, OJ oj) {
                super(1);
                this.$this_animateScrollToItem = lazyAnimateScrollScope;
                this.$index = i;
                this.$target = f;
                this.$prevValue = lj;
                this.$$this$scroll = scrollScope;
                this.$loop = kj;
                this.$forward = z;
                this.$boundDistancePx = f2;
                this.$loops = mj;
                this.$scrollOffset = i2;
                this.$anim = oj;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AnimationScope<Float, AnimationVector1D>) obj);
                return FW.a;
            }

            public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                AbstractC4492zt.h(animationScope, "$this$animateTo");
                Integer targetItemOffset = this.$this_animateScrollToItem.getTargetItemOffset(this.$index);
                if (targetItemOffset == null) {
                    float f = (this.$target > 0.0f ? AbstractC3871sJ.f(animationScope.getValue().floatValue(), this.$target) : AbstractC3871sJ.c(animationScope.getValue().floatValue(), this.$target)) - this.$prevValue.a;
                    float fScrollBy = this.$$this$scroll.scrollBy(f);
                    Integer targetItemOffset2 = this.$this_animateScrollToItem.getTargetItemOffset(this.$index);
                    if (targetItemOffset2 == null && !AnonymousClass2.invokeSuspend$isOvershot(this.$forward, this.$this_animateScrollToItem, this.$index, this.$scrollOffset)) {
                        if (f != fScrollBy) {
                            animationScope.cancelAnimation();
                            this.$loop.a = false;
                            return;
                        }
                        this.$prevValue.a += f;
                        if (this.$forward) {
                            if (animationScope.getValue().floatValue() > this.$boundDistancePx) {
                                animationScope.cancelAnimation();
                            }
                        } else if (animationScope.getValue().floatValue() < (-this.$boundDistancePx)) {
                            animationScope.cancelAnimation();
                        }
                        if (this.$forward) {
                            if (this.$loops.a >= 2 && this.$index - this.$this_animateScrollToItem.getLastVisibleItemIndex() > this.$this_animateScrollToItem.getNumOfItemsForTeleport()) {
                                LazyAnimateScrollScope lazyAnimateScrollScope = this.$this_animateScrollToItem;
                                lazyAnimateScrollScope.snapToItem(this.$$this$scroll, this.$index - lazyAnimateScrollScope.getNumOfItemsForTeleport(), 0);
                            }
                        } else if (this.$loops.a >= 2 && this.$this_animateScrollToItem.getFirstVisibleItemIndex() - this.$index > this.$this_animateScrollToItem.getNumOfItemsForTeleport()) {
                            LazyAnimateScrollScope lazyAnimateScrollScope2 = this.$this_animateScrollToItem;
                            lazyAnimateScrollScope2.snapToItem(this.$$this$scroll, this.$index + lazyAnimateScrollScope2.getNumOfItemsForTeleport(), 0);
                        }
                    }
                    targetItemOffset = targetItemOffset2;
                }
                if (!AnonymousClass2.invokeSuspend$isOvershot(this.$forward, this.$this_animateScrollToItem, this.$index, this.$scrollOffset)) {
                    if (targetItemOffset != null) {
                        throw new ItemFoundInScroll(targetItemOffset.intValue(), (AnimationState) this.$anim.a);
                    }
                } else {
                    this.$this_animateScrollToItem.snapToItem(this.$$this$scroll, this.$index, this.$scrollOffset);
                    this.$loop.a = false;
                    animationScope.cancelAnimation();
                }
            }
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5, reason: invalid class name */
        public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ ScrollScope $$this$scroll;
            final /* synthetic */ LJ $prevValue;
            final /* synthetic */ float $target;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(float f, LJ lj, ScrollScope scrollScope) {
                super(1);
                this.$target = f;
                this.$prevValue = lj;
                this.$$this$scroll = scrollScope;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AnimationScope<Float, AnimationVector1D>) obj);
                return FW.a;
            }

            public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                AbstractC4492zt.h(animationScope, "$this$animateTo");
                float f = this.$target;
                float fC = 0.0f;
                if (f > 0.0f) {
                    fC = AbstractC3871sJ.f(animationScope.getValue().floatValue(), this.$target);
                } else if (f < 0.0f) {
                    fC = AbstractC3871sJ.c(animationScope.getValue().floatValue(), this.$target);
                }
                float f2 = fC - this.$prevValue.a;
                if (f2 != this.$$this$scroll.scrollBy(f2) || fC != animationScope.getValue().floatValue()) {
                    animationScope.cancelAnimation();
                }
                this.$prevValue.a += f2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, LazyAnimateScrollScope lazyAnimateScrollScope, int i2, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$index = i;
            this.$this_animateScrollToItem = lazyAnimateScrollScope;
            this.$scrollOffset = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$isOvershot(boolean z, LazyAnimateScrollScope lazyAnimateScrollScope, int i, int i2) {
            if (z) {
                if (lazyAnimateScrollScope.getFirstVisibleItemIndex() <= i && (lazyAnimateScrollScope.getFirstVisibleItemIndex() != i || lazyAnimateScrollScope.getFirstVisibleItemScrollOffset() <= i2)) {
                    return false;
                }
            } else if (lazyAnimateScrollScope.getFirstVisibleItemIndex() >= i && (lazyAnimateScrollScope.getFirstVisibleItemIndex() != i || lazyAnimateScrollScope.getFirstVisibleItemScrollOffset() >= i2)) {
                return false;
            }
            return true;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$index, this.$this_animateScrollToItem, this.$scrollOffset, interfaceC0793Of);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(ScrollScope scrollScope, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass2) create(scrollScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00d8 A[Catch: ItemFoundInScroll -> 0x01b4, TryCatch #0 {ItemFoundInScroll -> 0x01b4, blocks: (B:27:0x00d4, B:29:0x00d8, B:31:0x00e0, B:43:0x010d, B:47:0x0149, B:51:0x0156), top: B:79:0x00d4 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x0106 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:41:0x0108  */
        /* JADX WARN: Code duplicated, block: B:45:0x0146  */
        /* JADX WARN: Code duplicated, block: B:46:0x0148  */
        /* JADX WARN: Code duplicated, block: B:49:0x0151  */
        /* JADX WARN: Code duplicated, block: B:50:0x0154  */
        /* JADX WARN: Code duplicated, block: B:55:0x019a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:56:0x019b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x019b -> B:84:0x01a4). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // defpackage.AbstractC2171f7
        public final java.lang.Object invokeSuspend(java.lang.Object r41) {
            /*
                Method dump skipped, instruction units count: 596
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object animateScrollToItem(LazyAnimateScrollScope lazyAnimateScrollScope, int i, int i2, InterfaceC0793Of interfaceC0793Of) {
        Object objScroll = lazyAnimateScrollScope.scroll(new AnonymousClass2(i, lazyAnimateScrollScope, i2, null), interfaceC0793Of);
        return objScroll == AbstractC0378Bt.d() ? objScroll : FW.a;
    }

    private static final void debugLog(InterfaceC3588op interfaceC3588op) {
    }
}
