package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1", f = "LazyLayoutAnimateItemModifierNode.kt", l = {97, 103}, m = "invokeSuspend")
public final class LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutAnimateItemModifierNode this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ long $animationTarget;
        final /* synthetic */ LazyLayoutAnimateItemModifierNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode, long j) {
            super(1);
            this.this$0 = lazyLayoutAnimateItemModifierNode;
            this.$animationTarget = j;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Animatable<IntOffset, AnimationVector2D>) obj);
            return FW.a;
        }

        public final void invoke(Animatable<IntOffset, AnimationVector2D> animatable) {
            AbstractC4492zt.h(animatable, "$this$animateTo");
            LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode = this.this$0;
            long jM5287unboximpl = animatable.getValue().m5287unboximpl();
            long j = this.$animationTarget;
            lazyLayoutAnimateItemModifierNode.m626setPlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM5287unboximpl) - IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(jM5287unboximpl) - IntOffset.m5279getYimpl(j)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode, long j, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.this$0 = lazyLayoutAnimateItemModifierNode;
        this.$totalDelta = j;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return new LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(this.this$0, this.$totalDelta, interfaceC0793Of);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
        return ((LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec;
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    finiteAnimationSpec = (FiniteAnimationSpec) this.L$0;
                    LL.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                this.this$0.setAnimationInProgress(false);
                return FW.a;
            }
            LL.b(obj);
            FiniteAnimationSpec<IntOffset> placementAnimationSpec = (!this.this$0.placementDeltaAnimation.isRunning() || (this.this$0.getPlacementAnimationSpec() instanceof SpringSpec)) ? this.this$0.getPlacementAnimationSpec() : LazyLayoutAnimateItemModifierNodeKt.InterruptionSpec;
            finiteAnimationSpec = placementAnimationSpec;
            if (!this.this$0.placementDeltaAnimation.isRunning()) {
                Animatable animatable = this.this$0.placementDeltaAnimation;
                IntOffset intOffsetM5269boximpl = IntOffset.m5269boximpl(this.$totalDelta);
                this.L$0 = finiteAnimationSpec;
                this.label = 1;
                if (animatable.snapTo(intOffsetM5269boximpl, this) == objD) {
                    return objD;
                }
            }
            FiniteAnimationSpec<IntOffset> finiteAnimationSpec2 = finiteAnimationSpec;
            long jM5287unboximpl = ((IntOffset) this.this$0.placementDeltaAnimation.getValue()).m5287unboximpl();
            long j = this.$totalDelta;
            long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM5287unboximpl) - IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(jM5287unboximpl) - IntOffset.m5279getYimpl(j));
            Animatable animatable2 = this.this$0.placementDeltaAnimation;
            IntOffset intOffsetM5269boximpl2 = IntOffset.m5269boximpl(jIntOffset);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, jIntOffset);
            this.L$0 = null;
            this.label = 2;
            if (Animatable.animateTo$default(animatable2, intOffsetM5269boximpl2, finiteAnimationSpec2, null, anonymousClass1, this, 4, null) == objD) {
                return objD;
            }
            this.this$0.setAnimationInProgress(false);
        } catch (CancellationException unused) {
        }
        return FW.a;
    }
}
