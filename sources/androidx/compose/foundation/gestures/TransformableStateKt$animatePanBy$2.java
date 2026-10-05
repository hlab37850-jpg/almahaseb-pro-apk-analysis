package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC2116eV;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.NJ;
import defpackage.XS;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC3252ki(c = "androidx.compose.foundation.gestures.TransformableStateKt$animatePanBy$2", f = "TransformableState.kt", l = {ShapeTypes.CORNER_TABS}, m = "invokeSuspend")
public final class TransformableStateKt$animatePanBy$2 extends XS implements InterfaceC0526Fp {
    final /* synthetic */ AnimationSpec<Offset> $animationSpec;
    final /* synthetic */ long $offset;
    final /* synthetic */ NJ $previous;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animatePanBy$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ TransformScope $$this$transform;
        final /* synthetic */ NJ $previous;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(NJ nj, TransformScope transformScope) {
            super(1);
            this.$previous = nj;
            this.$$this$transform = transformScope;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AnimationScope<Offset, AnimationVector2D>) obj);
            return FW.a;
        }

        public final void invoke(AnimationScope<Offset, AnimationVector2D> animationScope) {
            AbstractC4492zt.h(animationScope, "$this$animateTo");
            AbstractC2116eV.a(this.$$this$transform, 0.0f, Offset.m2802minusMKHz9U(animationScope.getValue().m2808unboximpl(), this.$previous.a), 0.0f, 5, null);
            this.$previous.a = animationScope.getValue().m2808unboximpl();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformableStateKt$animatePanBy$2(NJ nj, long j, AnimationSpec<Offset> animationSpec, InterfaceC0793Of interfaceC0793Of) {
        super(2, interfaceC0793Of);
        this.$previous = nj;
        this.$offset = j;
        this.$animationSpec = animationSpec;
    }

    @Override // defpackage.AbstractC2171f7
    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
        TransformableStateKt$animatePanBy$2 transformableStateKt$animatePanBy$2 = new TransformableStateKt$animatePanBy$2(this.$previous, this.$offset, this.$animationSpec, interfaceC0793Of);
        transformableStateKt$animatePanBy$2.L$0 = obj;
        return transformableStateKt$animatePanBy$2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo13invoke(TransformScope transformScope, InterfaceC0793Of interfaceC0793Of) {
        return ((TransformableStateKt$animatePanBy$2) create(transformScope, interfaceC0793Of)).invokeSuspend(FW.a);
    }

    @Override // defpackage.AbstractC2171f7
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = AbstractC0378Bt.d();
        int i = this.label;
        if (i == 0) {
            LL.b(obj);
            TransformScope transformScope = (TransformScope) this.L$0;
            AnimationState animationState = new AnimationState(VectorConvertersKt.getVectorConverter(Offset.Companion), Offset.m2787boximpl(this.$previous.a), null, 0L, 0L, false, 60, null);
            Offset offsetM2787boximpl = Offset.m2787boximpl(this.$offset);
            AnimationSpec<Offset> animationSpec = this.$animationSpec;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$previous, transformScope);
            this.label = 1;
            if (SuspendAnimationKt.animateTo$default(animationState, offsetM2787boximpl, animationSpec, false, anonymousClass1, this, 4, null) == objD) {
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
