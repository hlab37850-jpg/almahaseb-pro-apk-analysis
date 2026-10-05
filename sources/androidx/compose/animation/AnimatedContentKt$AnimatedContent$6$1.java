package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class AnimatedContentKt$AnimatedContent$6$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ InterfaceC0578Hp $content;
    final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S> $rootScope;
    final /* synthetic */ S $stateForContent;
    final /* synthetic */ Transition<S> $this_AnimatedContent;
    final /* synthetic */ InterfaceC3750qp $transitionSpec;

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ ContentTransform $specOnEnter;

        /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00281 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ Placeable $placeable;
            final /* synthetic */ ContentTransform $specOnEnter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00281(Placeable placeable, ContentTransform contentTransform) {
                super(1);
                this.$placeable = placeable;
                this.$specOnEnter = contentTransform;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return FW.a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                AbstractC4492zt.h(placementScope, "$this$layout");
                placementScope.place(this.$placeable, 0, 0, this.$specOnEnter.getTargetContentZIndex());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ContentTransform contentTransform) {
            super(3);
            this.$specOnEnter = contentTransform;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m15invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m5134unboximpl());
        }

        /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
        public final MeasureResult m15invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
            AbstractC4492zt.h(measureScope, "$this$layout");
            AbstractC4492zt.h(measurable, "measurable");
            Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(j);
            return MeasureScope.CC.q(measureScope, placeableMo4159measureBRTryo0.getWidth(), placeableMo4159measureBRTryo0.getHeight(), null, new C00281(placeableMo4159measureBRTryo0, this.$specOnEnter), 4, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ S $stateForContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(S s) {
            super(1);
            this.$stateForContent = s;
        }

        @Override // defpackage.InterfaceC3750qp
        public final Boolean invoke(S s) {
            return Boolean.valueOf(AbstractC4492zt.d(s, this.$stateForContent));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0578Hp $content;
        final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
        final /* synthetic */ AnimatedContentTransitionScopeImpl<S> $rootScope;
        final /* synthetic */ S $stateForContent;

        /* JADX INFO: renamed from: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ SnapshotStateList<S> $currentlyVisible;
            final /* synthetic */ AnimatedContentTransitionScopeImpl<S> $rootScope;
            final /* synthetic */ S $stateForContent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SnapshotStateList<S> snapshotStateList, S s, AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl) {
                super(1);
                this.$currentlyVisible = snapshotStateList;
                this.$stateForContent = s;
                this.$rootScope = animatedContentTransitionScopeImpl;
            }

            @Override // defpackage.InterfaceC3750qp
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
                final SnapshotStateList<S> snapshotStateList = this.$currentlyVisible;
                final Object obj = this.$stateForContent;
                final AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl = this.$rootScope;
                return new DisposableEffectResult() { // from class: androidx.compose.animation.AnimatedContentKt$AnimatedContent$6$1$4$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        snapshotStateList.remove(obj);
                        animatedContentTransitionScopeImpl.getTargetSizeMap$animation_release().remove(obj);
                    }
                };
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl, S s, SnapshotStateList<S> snapshotStateList, InterfaceC0578Hp interfaceC0578Hp, int i) {
            super(3);
            this.$rootScope = animatedContentTransitionScopeImpl;
            this.$stateForContent = s;
            this.$currentlyVisible = snapshotStateList;
            this.$content = interfaceC0578Hp;
            this.$$dirty = i;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
            AbstractC4492zt.h(animatedVisibilityScope, "$this$AnimatedVisibility");
            if ((i & 14) == 0) {
                i |= composer.changed(animatedVisibilityScope) ? 4 : 2;
            }
            if ((i & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1894897681, i, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous>.<anonymous> (AnimatedContent.kt:768)");
            }
            EffectsKt.DisposableEffect(animatedVisibilityScope, new AnonymousClass1(this.$currentlyVisible, this.$stateForContent, this.$rootScope), composer, i & 14);
            this.$rootScope.getTargetSizeMap$animation_release().put(this.$stateForContent, ((AnimatedVisibilityScopeImpl) animatedVisibilityScope).getTargetSize$animation_release());
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new AnimatedContentScopeImpl(animatedVisibilityScope);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            this.$content.invoke((AnimatedContentScopeImpl) objRememberedValue, this.$stateForContent, composer, Integer.valueOf((this.$$dirty >> 9) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatedContentKt$AnimatedContent$6$1(Transition<S> transition, S s, int i, InterfaceC3750qp interfaceC3750qp, AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl, SnapshotStateList<S> snapshotStateList, InterfaceC0578Hp interfaceC0578Hp) {
        super(2);
        this.$this_AnimatedContent = transition;
        this.$stateForContent = s;
        this.$$dirty = i;
        this.$transitionSpec = interfaceC3750qp;
        this.$rootScope = animatedContentTransitionScopeImpl;
        this.$currentlyVisible = snapshotStateList;
        this.$content = interfaceC0578Hp;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885640742, i, -1, "androidx.compose.animation.AnimatedContent.<anonymous>.<anonymous> (AnimatedContent.kt:739)");
        }
        InterfaceC3750qp interfaceC3750qp = this.$transitionSpec;
        Object obj = this.$rootScope;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = (ContentTransform) interfaceC3750qp.invoke(obj);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        ContentTransform contentTransform = (ContentTransform) objRememberedValue;
        Boolean boolValueOf = Boolean.valueOf(AbstractC4492zt.d(this.$this_AnimatedContent.getSegment().getTargetState(), this.$stateForContent));
        Transition<S> transition = this.$this_AnimatedContent;
        Object obj2 = this.$stateForContent;
        InterfaceC3750qp interfaceC3750qp2 = this.$transitionSpec;
        Object obj3 = this.$rootScope;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(boolValueOf);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = AbstractC4492zt.d(transition.getSegment().getTargetState(), obj2) ? ExitTransition.Companion.getNone() : ((ContentTransform) interfaceC3750qp2.invoke(obj3)).getInitialContentExit();
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ExitTransition exitTransition = (ExitTransition) objRememberedValue2;
        Object obj4 = this.$stateForContent;
        Transition<S> transition2 = this.$this_AnimatedContent;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == companion.getEmpty()) {
            objRememberedValue3 = new AnimatedContentTransitionScopeImpl.ChildData(AbstractC4492zt.d(obj4, transition2.getTargetState()));
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        AnimatedContentTransitionScopeImpl.ChildData childData = (AnimatedContentTransitionScopeImpl.ChildData) objRememberedValue3;
        EnterTransition targetContentEnter = contentTransform.getTargetContentEnter();
        Modifier modifierLayout = LayoutModifierKt.layout(Modifier.Companion, new AnonymousClass1(contentTransform));
        childData.setTarget(AbstractC4492zt.d(this.$stateForContent, this.$this_AnimatedContent.getTargetState()));
        AnimatedVisibilityKt.AnimatedVisibility(this.$this_AnimatedContent, new AnonymousClass3(this.$stateForContent), modifierLayout.then(childData), targetContentEnter, exitTransition, ComposableLambdaKt.composableLambda(composer, -1894897681, true, new AnonymousClass4(this.$rootScope, this.$stateForContent, this.$currentlyVisible, this.$content, this.$$dirty)), composer, 196608 | (this.$$dirty & 14), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
