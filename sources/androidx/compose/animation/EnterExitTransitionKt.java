package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C0774Nm;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class EnterExitTransitionKt {
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(EnterExitTransitionKt$TransformOriginVectorConverter$1.INSTANCE, EnterExitTransitionKt$TransformOriginVectorConverter$2.INSTANCE);
    private static final MutableFloatState DefaultAlpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5269boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5312boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final Integer invoke(int i) {
            return 0;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $initialWidth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$initialWidth = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.m5312boximpl(m52invokemzRDjE0(((IntSize) obj).m5324unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m52invokemzRDjE0(long j) {
            return IntSizeKt.IntSize(((Number) this.$initialWidth.invoke(Integer.valueOf(IntSize.m5320getWidthimpl(j)))).intValue(), IntSize.m5319getHeightimpl(j));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$expandIn$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12711 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12711 INSTANCE = new C12711();

        public C12711() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.m5312boximpl(m53invokemzRDjE0(((IntSize) obj).m5324unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m53invokemzRDjE0(long j) {
            return IntSizeKt.IntSize(0, 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12721 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12721 INSTANCE = new C12721();

        public C12721() {
            super(1);
        }

        public final Integer invoke(int i) {
            return 0;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12732 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $initialHeight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12732(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$initialHeight = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.m5312boximpl(m54invokemzRDjE0(((IntSize) obj).m5324unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m54invokemzRDjE0(long j) {
            return IntSizeKt.IntSize(IntSize.m5320getWidthimpl(j), ((Number) this.$initialHeight.invoke(Integer.valueOf(IntSize.m5319getHeightimpl(j)))).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12741 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ State<ChangeSize> $expand;
        final /* synthetic */ String $labelPrefix;
        final /* synthetic */ State<ChangeSize> $shrink;
        final /* synthetic */ Transition<EnterExitState> $transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12741(Transition<EnterExitState> transition, State<ChangeSize> state, State<ChangeSize> state2, String str) {
            super(3);
            this.$transition = transition;
            this.$expand = state;
            this.$shrink = state2;
            this.$labelPrefix = str;
        }

        private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
            return mutableState.getValue().booleanValue();
        }

        private static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        /* JADX WARN: Code duplicated, block: B:31:0x00ad  */
        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            Alignment alignment;
            ChangeSize value;
            Modifier modifierThen = modifier;
            AbstractC4492zt.h(modifierThen, "$this$composed");
            composer.startReplaceableGroup(-140634085);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-140634085, i, -1, "androidx.compose.animation.shrinkExpand.<anonymous> (EnterExitTransition.kt:1030)");
            }
            Transition<EnterExitState> transition = this.$transition;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(transition);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            if (this.$transition.getCurrentState() == this.$transition.getTargetState() && !this.$transition.isSeeking()) {
                invoke$lambda$2(mutableState, false);
            } else if (this.$expand.getValue() != null || this.$shrink.getValue() != null) {
                invoke$lambda$2(mutableState, true);
            }
            if (invoke$lambda$1(mutableState)) {
                boolean zIsTransitioningTo = this.$transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible);
                State<ChangeSize> state = this.$expand;
                State<ChangeSize> state2 = this.$shrink;
                if (zIsTransitioningTo) {
                    ChangeSize value2 = state.getValue();
                    if (value2 == null || (alignment = value2.getAlignment()) == null) {
                        ChangeSize value3 = state2.getValue();
                        if (value3 != null) {
                            alignment = value3.getAlignment();
                        } else {
                            alignment = null;
                        }
                    }
                } else {
                    ChangeSize value4 = state2.getValue();
                    if (value4 == null || (alignment = value4.getAlignment()) == null) {
                        ChangeSize value5 = state.getValue();
                        if (value5 != null) {
                            alignment = value5.getAlignment();
                        } else {
                            alignment = null;
                        }
                    }
                }
                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(alignment, composer, 0);
                Transition<EnterExitState> transition2 = this.$transition;
                TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.Companion);
                String str = this.$labelPrefix;
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = str + " shrink/expand";
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition2, vectorConverter, (String) objRememberedValue2, composer, 448, 0);
                composer.startMovableGroup(-1553213689, Boolean.valueOf(this.$transition.getCurrentState() == this.$transition.getTargetState()));
                Transition<EnterExitState> transition3 = this.$transition;
                TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
                String str2 = this.$labelPrefix;
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = str2 + " InterruptionHandlingOffset";
                    composer.updateRememberedValue(objRememberedValue3);
                }
                composer.endReplaceableGroup();
                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation2 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition3, vectorConverter2, (String) objRememberedValue3, composer, 448, 0);
                composer.endMovableGroup();
                Transition<EnterExitState> transition4 = this.$transition;
                State<ChangeSize> state3 = this.$expand;
                State<ChangeSize> state4 = this.$shrink;
                composer.startReplaceableGroup(1157296644);
                boolean zChanged2 = composer.changed(transition4);
                Object objRememberedValue4 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new ExpandShrinkModifier(deferredAnimationCreateDeferredAnimation, deferredAnimationCreateDeferredAnimation2, state3, state4, stateRememberUpdatedState);
                    composer.updateRememberedValue(objRememberedValue4);
                }
                composer.endReplaceableGroup();
                ExpandShrinkModifier expandShrinkModifier = (ExpandShrinkModifier) objRememberedValue4;
                if (this.$transition.getCurrentState() == this.$transition.getTargetState()) {
                    expandShrinkModifier.setCurrentAlignment(null);
                } else if (expandShrinkModifier.getCurrentAlignment() == null) {
                    Alignment topStart = (Alignment) stateRememberUpdatedState.getValue();
                    if (topStart == null) {
                        topStart = Alignment.Companion.getTopStart();
                    }
                    expandShrinkModifier.setCurrentAlignment(topStart);
                }
                ChangeSize value6 = this.$expand.getValue();
                modifierThen = modifierThen.then(((value6 == null || value6.getClip()) && ((value = this.$shrink.getValue()) == null || value.getClip())) ? ClipKt.clipToBounds(Modifier.Companion) : Modifier.Companion).then(expandShrinkModifier);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12751 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12751 INSTANCE = new C12751();

        public C12751() {
            super(1);
        }

        public final Integer invoke(int i) {
            return 0;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12762 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $targetWidth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12762(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$targetWidth = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.m5312boximpl(m55invokemzRDjE0(((IntSize) obj).m5324unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m55invokemzRDjE0(long j) {
            return IntSizeKt.IntSize(((Number) this.$targetWidth.invoke(Integer.valueOf(IntSize.m5320getWidthimpl(j)))).intValue(), IntSize.m5319getHeightimpl(j));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkOut$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12771 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12771 INSTANCE = new C12771();

        public C12771() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.m5312boximpl(m56invokemzRDjE0(((IntSize) obj).m5324unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m56invokemzRDjE0(long j) {
            return IntSizeKt.IntSize(0, 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12781 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12781 INSTANCE = new C12781();

        public C12781() {
            super(1);
        }

        public final Integer invoke(int i) {
            return 0;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12792 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $targetHeight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12792(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$targetHeight = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.m5312boximpl(m57invokemzRDjE0(((IntSize) obj).m5324unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mzRDjE0, reason: not valid java name */
        public final long m57invokemzRDjE0(long j) {
            return IntSizeKt.IntSize(IntSize.m5320getWidthimpl(j), ((Number) this.$targetHeight.invoke(Integer.valueOf(IntSize.m5319getHeightimpl(j)))).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12801 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12801 INSTANCE = new C12801();

        public C12801() {
            super(1);
        }

        public final Integer invoke(int i) {
            return Integer.valueOf((-i) / 2);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12812 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $initialOffsetX;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12812(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$initialOffsetX = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntOffset.m5269boximpl(m58invokemHKZG7I(((IntSize) obj).m5324unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
        public final long m58invokemHKZG7I(long j) {
            return IntOffsetKt.IntOffset(((Number) this.$initialOffsetX.invoke(Integer.valueOf(IntSize.m5320getWidthimpl(j)))).intValue(), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideInOut$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12821 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ String $labelPrefix;
        final /* synthetic */ State<Slide> $slideIn;
        final /* synthetic */ State<Slide> $slideOut;
        final /* synthetic */ Transition<EnterExitState> $transition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12821(Transition<EnterExitState> transition, State<Slide> state, State<Slide> state2, String str) {
            super(3);
            this.$transition = transition;
            this.$slideIn = state;
            this.$slideOut = state2;
            this.$labelPrefix = str;
        }

        private static final boolean invoke$lambda$1(MutableState<Boolean> mutableState) {
            return mutableState.getValue().booleanValue();
        }

        private static final void invoke$lambda$2(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(158379472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(158379472, i, -1, "androidx.compose.animation.slideInOut.<anonymous> (EnterExitTransition.kt:949)");
            }
            Transition<EnterExitState> transition = this.$transition;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(transition);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            if (this.$transition.getCurrentState() == this.$transition.getTargetState() && !this.$transition.isSeeking()) {
                invoke$lambda$2(mutableState, false);
            } else if (this.$slideIn.getValue() != null || this.$slideOut.getValue() != null) {
                invoke$lambda$2(mutableState, true);
            }
            if (invoke$lambda$1(mutableState)) {
                Transition<EnterExitState> transition2 = this.$transition;
                TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
                String str = this.$labelPrefix;
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue2 = composer.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = str + " slide";
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                Transition.DeferredAnimation deferredAnimationCreateDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition2, vectorConverter, (String) objRememberedValue2, composer, 448, 0);
                Transition<EnterExitState> transition3 = this.$transition;
                State<Slide> state = this.$slideIn;
                State<Slide> state2 = this.$slideOut;
                composer.startReplaceableGroup(1157296644);
                boolean zChanged2 = composer.changed(transition3);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                    objRememberedValue3 = new SlideModifier(deferredAnimationCreateDeferredAnimation, state, state2);
                    composer.updateRememberedValue(objRememberedValue3);
                }
                composer.endReplaceableGroup();
                modifier = modifier.then((SlideModifier) objRememberedValue3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifier;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12831 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12831 INSTANCE = new C12831();

        public C12831() {
            super(1);
        }

        public final Integer invoke(int i) {
            return Integer.valueOf((-i) / 2);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12842 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $initialOffsetY;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12842(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$initialOffsetY = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntOffset.m5269boximpl(m59invokemHKZG7I(((IntSize) obj).m5324unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
        public final long m59invokemHKZG7I(long j) {
            return IntOffsetKt.IntOffset(0, ((Number) this.$initialOffsetY.invoke(Integer.valueOf(IntSize.m5319getHeightimpl(j)))).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12851 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12851 INSTANCE = new C12851();

        public C12851() {
            super(1);
        }

        public final Integer invoke(int i) {
            return Integer.valueOf((-i) / 2);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12862 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $targetOffsetX;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12862(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$targetOffsetX = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntOffset.m5269boximpl(m60invokemHKZG7I(((IntSize) obj).m5324unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
        public final long m60invokemHKZG7I(long j) {
            return IntOffsetKt.IntOffset(((Number) this.$targetOffsetX.invoke(Integer.valueOf(IntSize.m5320getWidthimpl(j)))).intValue(), 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12871 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C12871 INSTANCE = new C12871();

        public C12871() {
            super(1);
        }

        public final Integer invoke(int i) {
            return Integer.valueOf((-i) / 2);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12882 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ InterfaceC3750qp $targetOffsetY;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12882(InterfaceC3750qp interfaceC3750qp) {
            super(1);
            this.$targetOffsetY = interfaceC3750qp;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntOffset.m5269boximpl(m61invokemHKZG7I(((IntSize) obj).m5324unboximpl()));
        }

        /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
        public final long m61invokemHKZG7I(long j) {
            return IntOffsetKt.IntOffset(0, ((Number) this.$targetOffsetY.invoke(Integer.valueOf(IntSize.m5319getHeightimpl(j)))).intValue());
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:159:0x0436  */
    /* JADX WARN: Code duplicated, block: B:190:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:47:0x0194  */
    /* JADX WARN: Code duplicated, block: B:78:0x021b  */
    /* JADX WARN: Code duplicated, block: B:99:0x02f6  */
    @Composable
    public static final Modifier createModifier(Transition<EnterExitState> transition, EnterTransition enterTransition, ExitTransition exitTransition, String str, Composer composer, int i) {
        MutableState mutableState;
        TransformOrigin transformOrigin;
        int i2;
        State stateCreateTransitionAnimation;
        float scale;
        TransformOrigin transformOriginM3381boximpl;
        TransformOrigin transformOriginM3381boximpl2;
        float alpha;
        float alpha2;
        AbstractC4492zt.h(transition, "<this>");
        AbstractC4492zt.h(enterTransition, "enter");
        AbstractC4492zt.h(exitTransition, "exit");
        AbstractC4492zt.h(str, HTML.Tag.LABEL);
        composer.startReplaceableGroup(914000546);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(914000546, i, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:819)");
        }
        Modifier modifierShrinkExpand = shrinkExpand(slideInOut(Modifier.Companion, transition, SnapshotStateKt.rememberUpdatedState(enterTransition.getData$animation_release().getSlide(), composer, 0), SnapshotStateKt.rememberUpdatedState(exitTransition.getData$animation_release().getSlide(), composer, 0), str), transition, SnapshotStateKt.rememberUpdatedState(enterTransition.getData$animation_release().getChangeSize(), composer, 0), SnapshotStateKt.rememberUpdatedState(exitTransition.getData$animation_release().getChangeSize(), composer, 0), str);
        int i3 = i & 14;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState2 = (MutableState) objRememberedValue;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged2 = composer.changed(transition);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        MutableState mutableState3 = (MutableState) objRememberedValue2;
        if (transition.getCurrentState() != transition.getTargetState() || transition.isSeeking()) {
            if (enterTransition.getData$animation_release().getFade() != null || exitTransition.getData$animation_release().getFade() != null) {
                createModifier$lambda$2(mutableState2, true);
            }
            if (enterTransition.getData$animation_release().getScale() != null || exitTransition.getData$animation_release().getScale() != null) {
                createModifier$lambda$5(mutableState3, true);
            }
        } else {
            createModifier$lambda$2(mutableState2, false);
            createModifier$lambda$5(mutableState3, false);
        }
        composer.startReplaceableGroup(1657241561);
        float scale2 = 1.0f;
        if (createModifier$lambda$1(mutableState2)) {
            EnterExitTransitionKt$createModifier$alpha$2 enterExitTransitionKt$createModifier$alpha$2 = new EnterExitTransitionKt$createModifier$alpha$2(enterTransition, exitTransition);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = str + " alpha";
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            String str2 = (String) objRememberedValue3;
            composer.startReplaceableGroup(-1338768149);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(C0774Nm.a);
            int i4 = ((i3 | 384) & 14) | 3072;
            composer.startReplaceableGroup(-142660079);
            EnterExitState currentState = transition.getCurrentState();
            composer.startReplaceableGroup(755689166);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755689166, 0, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:870)");
            }
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i5 = iArr[currentState.ordinal()];
            if (i5 == 1) {
                alpha = 1.0f;
            } else if (i5 == 2) {
                Fade fade = enterTransition.getData$animation_release().getFade();
                if (fade != null) {
                    alpha = fade.getAlpha();
                } else {
                    alpha = 1.0f;
                }
            } else {
                if (i5 != 3) {
                    throw new AD();
                }
                Fade fade2 = exitTransition.getData$animation_release().getFade();
                if (fade2 != null) {
                    alpha = fade2.getAlpha();
                } else {
                    alpha = 1.0f;
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            Float fValueOf = Float.valueOf(alpha);
            EnterExitState targetState = transition.getTargetState();
            composer.startReplaceableGroup(755689166);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755689166, 0, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:870)");
            }
            int i6 = iArr[targetState.ordinal()];
            if (i6 != 1) {
                if (i6 == 2) {
                    Fade fade3 = enterTransition.getData$animation_release().getFade();
                    if (fade3 != null) {
                        alpha2 = fade3.getAlpha();
                    }
                } else {
                    if (i6 != 3) {
                        throw new AD();
                    }
                    Fade fade4 = exitTransition.getData$animation_release().getFade();
                    if (fade4 != null) {
                        alpha2 = fade4.getAlpha();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                mutableState = mutableState3;
                transformOrigin = null;
                i2 = -492369756;
                stateCreateTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, fValueOf, Float.valueOf(alpha2), (FiniteAnimationSpec) enterExitTransitionKt$createModifier$alpha$2.invoke((Object) transition.getSegment(), (Object) composer, (Object) 0), vectorConverter, str2, composer, (i4 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            }
            alpha2 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            mutableState = mutableState3;
            transformOrigin = null;
            i2 = -492369756;
            stateCreateTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, fValueOf, Float.valueOf(alpha2), (FiniteAnimationSpec) enterExitTransitionKt$createModifier$alpha$2.invoke((Object) transition.getSegment(), (Object) composer, (Object) 0), vectorConverter, str2, composer, (i4 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else {
            mutableState = mutableState3;
            mutableState2 = mutableState2;
            transformOrigin = null;
            i2 = -492369756;
            stateCreateTransitionAnimation = DefaultAlpha;
        }
        State state = stateCreateTransitionAnimation;
        composer.endReplaceableGroup();
        if (createModifier$lambda$4(mutableState)) {
            composer.startReplaceableGroup(1657242461);
            EnterExitTransitionKt$createModifier$scale$2 enterExitTransitionKt$createModifier$scale$2 = new EnterExitTransitionKt$createModifier$scale$2(enterTransition, exitTransition);
            composer.startReplaceableGroup(i2);
            Object objRememberedValue4 = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = str + " scale";
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceableGroup();
            String str3 = (String) objRememberedValue4;
            composer.startReplaceableGroup(-1338768149);
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(C0774Nm.a);
            int i7 = ((i3 | 384) & 14) | 3072;
            composer.startReplaceableGroup(-142660079);
            EnterExitState currentState2 = transition.getCurrentState();
            composer.startReplaceableGroup(-596129937);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-596129937, 0, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:893)");
            }
            int[] iArr2 = WhenMappings.$EnumSwitchMapping$0;
            int i8 = iArr2[currentState2.ordinal()];
            if (i8 == 1) {
                scale = 1.0f;
            } else if (i8 == 2) {
                Scale scale3 = enterTransition.getData$animation_release().getScale();
                if (scale3 != null) {
                    scale = scale3.getScale();
                } else {
                    scale = 1.0f;
                }
            } else {
                if (i8 != 3) {
                    throw new AD();
                }
                Scale scale4 = exitTransition.getData$animation_release().getScale();
                if (scale4 != null) {
                    scale = scale4.getScale();
                } else {
                    scale = 1.0f;
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            Float fValueOf2 = Float.valueOf(scale);
            EnterExitState targetState2 = transition.getTargetState();
            composer.startReplaceableGroup(-596129937);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-596129937, 0, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:893)");
            }
            int i9 = iArr2[targetState2.ordinal()];
            if (i9 != 1) {
                if (i9 == 2) {
                    Scale scale5 = enterTransition.getData$animation_release().getScale();
                    if (scale5 != null) {
                        scale2 = scale5.getScale();
                    }
                } else {
                    if (i9 != 3) {
                        throw new AD();
                    }
                    Scale scale6 = exitTransition.getData$animation_release().getScale();
                    if (scale6 != null) {
                        scale2 = scale6.getScale();
                    }
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            State stateCreateTransitionAnimation2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, fValueOf2, Float.valueOf(scale2), (FiniteAnimationSpec) enterExitTransitionKt$createModifier$scale$2.invoke((Object) transition.getSegment(), (Object) composer, (Object) 0), vectorConverter2, str3, composer, (i7 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (transition.getCurrentState() == EnterExitState.PreEnter) {
                Scale scale7 = enterTransition.getData$animation_release().getScale();
                if (scale7 == null && (scale7 = exitTransition.getData$animation_release().getScale()) == null) {
                    transformOriginM3381boximpl = transformOrigin;
                } else {
                    transformOriginM3381boximpl = TransformOrigin.m3381boximpl(scale7.m69getTransformOriginSzJe1aQ());
                }
            } else {
                Scale scale8 = exitTransition.getData$animation_release().getScale();
                if (scale8 == null && (scale8 = enterTransition.getData$animation_release().getScale()) == null) {
                    transformOriginM3381boximpl = transformOrigin;
                } else {
                    transformOriginM3381boximpl = TransformOrigin.m3381boximpl(scale8.m69getTransformOriginSzJe1aQ());
                }
            }
            TwoWayConverter<TransformOrigin, AnimationVector2D> twoWayConverter = TransformOriginVectorConverter;
            int i10 = i3 | 3136;
            composer.startReplaceableGroup(-142660079);
            EnterExitTransitionKt$createModifier$$inlined$animateValue$1 enterExitTransitionKt$createModifier$$inlined$animateValue$1 = EnterExitTransitionKt$createModifier$$inlined$animateValue$1.INSTANCE;
            EnterExitState currentState3 = transition.getCurrentState();
            composer.startReplaceableGroup(-288165413);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-288165413, 0, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:911)");
            }
            int i11 = iArr2[currentState3.ordinal()];
            if (i11 == 1) {
                transformOriginM3381boximpl2 = transformOriginM3381boximpl;
            } else if (i11 == 2) {
                Scale scale9 = enterTransition.getData$animation_release().getScale();
                if (scale9 == null && (scale9 = exitTransition.getData$animation_release().getScale()) == null) {
                    transformOriginM3381boximpl2 = transformOrigin;
                } else {
                    transformOriginM3381boximpl2 = TransformOrigin.m3381boximpl(scale9.m69getTransformOriginSzJe1aQ());
                }
            } else {
                if (i11 != 3) {
                    throw new AD();
                }
                Scale scale10 = exitTransition.getData$animation_release().getScale();
                if (scale10 == null && (scale10 = enterTransition.getData$animation_release().getScale()) == null) {
                    transformOriginM3381boximpl2 = transformOrigin;
                } else {
                    transformOriginM3381boximpl2 = TransformOrigin.m3381boximpl(scale10.m69getTransformOriginSzJe1aQ());
                }
            }
            long jM3393unboximpl = transformOriginM3381boximpl2 != null ? transformOriginM3381boximpl2.m3393unboximpl() : TransformOrigin.Companion.m3394getCenterSzJe1aQ();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            TransformOrigin transformOriginM3381boximpl3 = TransformOrigin.m3381boximpl(jM3393unboximpl);
            EnterExitState targetState3 = transition.getTargetState();
            composer.startReplaceableGroup(-288165413);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-288165413, 0, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:911)");
            }
            int i12 = iArr2[targetState3.ordinal()];
            if (i12 != 1) {
                if (i12 == 2) {
                    Scale scale11 = enterTransition.getData$animation_release().getScale();
                    if (scale11 == null && (scale11 = exitTransition.getData$animation_release().getScale()) == null) {
                        transformOriginM3381boximpl = transformOrigin;
                    } else {
                        transformOriginM3381boximpl = TransformOrigin.m3381boximpl(scale11.m69getTransformOriginSzJe1aQ());
                    }
                } else {
                    if (i12 != 3) {
                        throw new AD();
                    }
                    Scale scale12 = exitTransition.getData$animation_release().getScale();
                    if (scale12 == null && (scale12 = enterTransition.getData$animation_release().getScale()) == null) {
                        transformOriginM3381boximpl = transformOrigin;
                    } else {
                        transformOriginM3381boximpl = TransformOrigin.m3381boximpl(scale12.m69getTransformOriginSzJe1aQ());
                    }
                }
            }
            long jM3393unboximpl2 = transformOriginM3381boximpl != null ? transformOriginM3381boximpl.m3393unboximpl() : TransformOrigin.Companion.m3394getCenterSzJe1aQ();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            State stateCreateTransitionAnimation3 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, transformOriginM3381boximpl3, TransformOrigin.m3381boximpl(jM3393unboximpl2), (FiniteAnimationSpec) enterExitTransitionKt$createModifier$$inlined$animateValue$1.invoke((Object) transition.getSegment(), (Object) composer, (Object) 0), twoWayConverter, "TransformOriginInterruptionHandling", composer, (i10 & 14) | 229376);
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(1618982084);
            boolean zChanged3 = composer.changed(state) | composer.changed(stateCreateTransitionAnimation2) | composer.changed(stateCreateTransitionAnimation3);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new EnterExitTransitionKt$createModifier$1$1(state, stateCreateTransitionAnimation2, stateCreateTransitionAnimation3);
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            modifierShrinkExpand = GraphicsLayerModifierKt.graphicsLayer(modifierShrinkExpand, (InterfaceC3750qp) objRememberedValue5);
            composer.endReplaceableGroup();
        } else if (createModifier$lambda$1(mutableState2)) {
            composer.startReplaceableGroup(1657244550);
            composer.startReplaceableGroup(1157296644);
            boolean zChanged4 = composer.changed(state);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue6 == Composer.Companion.getEmpty()) {
                objRememberedValue6 = new EnterExitTransitionKt$createModifier$2$1(state);
                composer.updateRememberedValue(objRememberedValue6);
            }
            composer.endReplaceableGroup();
            modifierShrinkExpand = GraphicsLayerModifierKt.graphicsLayer(modifierShrinkExpand, (InterfaceC3750qp) objRememberedValue6);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1657244642);
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifierShrinkExpand;
    }

    private static final boolean createModifier$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float createModifier$lambda$11(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long createModifier$lambda$13(State<TransformOrigin> state) {
        return state.getValue().m3393unboximpl();
    }

    private static final void createModifier$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean createModifier$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void createModifier$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float createModifier$lambda$8(State<Float> state) {
        return state.getValue().floatValue();
    }

    @Stable
    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(horizontal, "expandFrom");
        AbstractC4492zt.h(interfaceC3750qp, "initialWidth");
        return expandIn(finiteAnimationSpec, toAlignment(horizontal), z, new AnonymousClass2(interfaceC3750qp));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5312boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            interfaceC3750qp = AnonymousClass1.INSTANCE;
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, interfaceC3750qp);
    }

    @Stable
    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(alignment, "expandFrom");
        AbstractC4492zt.h(interfaceC3750qp, "initialSize");
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, interfaceC3750qp, finiteAnimationSpec, z), null, 11, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5312boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            interfaceC3750qp = C12711.INSTANCE;
        }
        return expandIn(finiteAnimationSpec, alignment, z, interfaceC3750qp);
    }

    @Stable
    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(vertical, "expandFrom");
        AbstractC4492zt.h(interfaceC3750qp, "initialHeight");
        return expandIn(finiteAnimationSpec, toAlignment(vertical), z, new C12732(interfaceC3750qp));
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5312boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            interfaceC3750qp = C12721.INSTANCE;
        }
        return expandVertically(finiteAnimationSpec, vertical, z, interfaceC3750qp);
    }

    @Stable
    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    @Stable
    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    @Stable
    /* JADX INFO: renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m46scaleInL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, finiteAnimationSpec, null), 7, null));
    }

    /* JADX INFO: renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m47scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m3394getCenterSzJe1aQ();
        }
        return m46scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    @Stable
    /* JADX INFO: renamed from: scaleOut-L8ZKh-E, reason: not valid java name */
    public static final ExitTransition m48scaleOutL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, finiteAnimationSpec, null), 7, null));
    }

    /* JADX INFO: renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m49scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m3394getCenterSzJe1aQ();
        }
        return m48scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    private static final Modifier shrinkExpand(Modifier modifier, Transition<EnterExitState> transition, State<ChangeSize> state, State<ChangeSize> state2, String str) {
        return ComposedModifierKt.composed$default(modifier, null, new C12741(transition, state, state2, str), 1, null);
    }

    @Stable
    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(horizontal, "shrinkTowards");
        AbstractC4492zt.h(interfaceC3750qp, "targetWidth");
        return shrinkOut(finiteAnimationSpec, toAlignment(horizontal), z, new C12762(interfaceC3750qp));
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5312boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            interfaceC3750qp = C12751.INSTANCE;
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, interfaceC3750qp);
    }

    @Stable
    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(alignment, "shrinkTowards");
        AbstractC4492zt.h(interfaceC3750qp, "targetSize");
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, interfaceC3750qp, finiteAnimationSpec, z), null, 11, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5312boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            interfaceC3750qp = C12771.INSTANCE;
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, interfaceC3750qp);
    }

    @Stable
    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(vertical, "shrinkTowards");
        AbstractC4492zt.h(interfaceC3750qp, "targetHeight");
        return shrinkOut(finiteAnimationSpec, toAlignment(vertical), z, new C12792(interfaceC3750qp));
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m5312boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            interfaceC3750qp = C12781.INSTANCE;
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, interfaceC3750qp);
    }

    @Stable
    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "initialOffset");
        return new EnterTransitionImpl(new TransitionData(null, new Slide(interfaceC3750qp, finiteAnimationSpec), null, null, 13, null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5269boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        return slideIn(finiteAnimationSpec, interfaceC3750qp);
    }

    @Stable
    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "initialOffsetX");
        return slideIn(finiteAnimationSpec, new C12812(interfaceC3750qp));
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5269boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            interfaceC3750qp = C12801.INSTANCE;
        }
        return slideInHorizontally(finiteAnimationSpec, interfaceC3750qp);
    }

    private static final Modifier slideInOut(Modifier modifier, Transition<EnterExitState> transition, State<Slide> state, State<Slide> state2, String str) {
        return ComposedModifierKt.composed$default(modifier, null, new C12821(transition, state, state2, str), 1, null);
    }

    @Stable
    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "initialOffsetY");
        return slideIn(finiteAnimationSpec, new C12842(interfaceC3750qp));
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5269boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            interfaceC3750qp = C12831.INSTANCE;
        }
        return slideInVertically(finiteAnimationSpec, interfaceC3750qp);
    }

    @Stable
    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "targetOffset");
        return new ExitTransitionImpl(new TransitionData(null, new Slide(interfaceC3750qp, finiteAnimationSpec), null, null, 13, null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5269boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        return slideOut(finiteAnimationSpec, interfaceC3750qp);
    }

    @Stable
    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "targetOffsetX");
        return slideOut(finiteAnimationSpec, new C12862(interfaceC3750qp));
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5269boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            interfaceC3750qp = C12851.INSTANCE;
        }
        return slideOutHorizontally(finiteAnimationSpec, interfaceC3750qp);
    }

    @Stable
    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(finiteAnimationSpec, "animationSpec");
        AbstractC4492zt.h(interfaceC3750qp, "targetOffsetY");
        return slideOut(finiteAnimationSpec, new C12882(interfaceC3750qp));
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5269boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            interfaceC3750qp = C12871.INSTANCE;
        }
        return slideOutVertically(finiteAnimationSpec, interfaceC3750qp);
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        Alignment.Companion companion = Alignment.Companion;
        if (AbstractC4492zt.d(horizontal, companion.getStart())) {
            return companion.getCenterStart();
        }
        return AbstractC4492zt.d(horizontal, companion.getEnd()) ? companion.getCenterEnd() : companion.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        Alignment.Companion companion = Alignment.Companion;
        if (AbstractC4492zt.d(vertical, companion.getTop())) {
            return companion.getTopCenter();
        }
        return AbstractC4492zt.d(vertical, companion.getBottom()) ? companion.getBottomCenter() : companion.getCenter();
    }
}
