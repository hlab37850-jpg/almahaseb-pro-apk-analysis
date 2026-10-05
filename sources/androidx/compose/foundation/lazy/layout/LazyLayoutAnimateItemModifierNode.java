package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.LL;
import defpackage.O8;
import defpackage.XS;

/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutAnimateItemModifierNode extends Modifier.Node {
    public static final Companion Companion = new Companion(null);
    private static final long NotInitialized = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private final MutableState isAnimationInProgress$delegate;
    private FiniteAnimationSpec<IntOffset> placementAnimationSpec;
    private final MutableState placementDelta$delegate;
    private final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation;
    private long rawOffset;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        /* JADX INFO: renamed from: getNotInitialized-nOcc-ac, reason: not valid java name */
        public final long m631getNotInitializednOccac() {
            return LazyLayoutAnimateItemModifierNode.NotInitialized;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$cancelAnimation$1, reason: invalid class name */
    @InterfaceC3252ki(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode$cancelAnimation$1", f = "LazyLayoutAnimateItemModifierNode.kt", l = {69}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
        int label;

        public AnonymousClass1(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return LazyLayoutAnimateItemModifierNode.this.new AnonymousClass1(interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((AnonymousClass1) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                Animatable animatable = LazyLayoutAnimateItemModifierNode.this.placementDeltaAnimation;
                IntOffset intOffsetM5269boximpl = IntOffset.m5269boximpl(IntOffset.Companion.m5288getZeronOccac());
                this.label = 1;
                if (animatable.snapTo(intOffsetM5269boximpl, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            LazyLayoutAnimateItemModifierNode.this.m626setPlacementDeltagyyYBs(IntOffset.Companion.m5288getZeronOccac());
            LazyLayoutAnimateItemModifierNode.this.setAnimationInProgress(false);
            return FW.a;
        }
    }

    public LazyLayoutAnimateItemModifierNode(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        AbstractC4492zt.h(finiteAnimationSpec, "placementAnimationSpec");
        this.placementAnimationSpec = finiteAnimationSpec;
        this.isAnimationInProgress$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.rawOffset = NotInitialized;
        IntOffset.Companion companion = IntOffset.Companion;
        this.placementDeltaAnimation = new Animatable<>(IntOffset.m5269boximpl(companion.m5288getZeronOccac()), VectorConvertersKt.getVectorConverter(companion), null, null, 12, null);
        this.placementDelta$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m5269boximpl(companion.m5288getZeronOccac()), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationInProgress(boolean z) {
        this.isAnimationInProgress$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setPlacementDelta--gyyYBs, reason: not valid java name */
    public final void m626setPlacementDeltagyyYBs(long j) {
        this.placementDelta$delegate.setValue(IntOffset.m5269boximpl(j));
    }

    /* JADX INFO: renamed from: animatePlacementDelta--gyyYBs, reason: not valid java name */
    public final void m627animatePlacementDeltagyyYBs(long j) {
        long jM628getPlacementDeltanOccac = m628getPlacementDeltanOccac();
        long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m5278getXimpl(jM628getPlacementDeltanOccac) - IntOffset.m5278getXimpl(j), IntOffset.m5279getYimpl(jM628getPlacementDeltanOccac) - IntOffset.m5279getYimpl(j));
        m626setPlacementDeltagyyYBs(jIntOffset);
        setAnimationInProgress(true);
        O8.d(getCoroutineScope(), null, null, new LazyLayoutAnimateItemModifierNode$animatePlacementDelta$1(this, jIntOffset, null), 3, null);
    }

    public final void cancelAnimation() {
        if (isAnimationInProgress()) {
            O8.d(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
        }
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementAnimationSpec() {
        return this.placementAnimationSpec;
    }

    /* JADX INFO: renamed from: getPlacementDelta-nOcc-ac, reason: not valid java name */
    public final long m628getPlacementDeltanOccac() {
        return ((IntOffset) this.placementDelta$delegate.getValue()).m5287unboximpl();
    }

    /* JADX INFO: renamed from: getRawOffset-nOcc-ac, reason: not valid java name */
    public final long m629getRawOffsetnOccac() {
        return this.rawOffset;
    }

    public final boolean isAnimationInProgress() {
        return ((Boolean) this.isAnimationInProgress$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        m626setPlacementDeltagyyYBs(IntOffset.Companion.m5288getZeronOccac());
        setAnimationInProgress(false);
        this.rawOffset = NotInitialized;
    }

    public final void setPlacementAnimationSpec(FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        AbstractC4492zt.h(finiteAnimationSpec, "<set-?>");
        this.placementAnimationSpec = finiteAnimationSpec;
    }

    /* JADX INFO: renamed from: setRawOffset--gyyYBs, reason: not valid java name */
    public final void m630setRawOffsetgyyYBs(long j) {
        this.rawOffset = j;
    }
}
