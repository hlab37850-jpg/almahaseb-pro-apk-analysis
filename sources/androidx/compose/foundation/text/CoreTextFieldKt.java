package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC4243wx;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.DV;
import defpackage.FW;
import defpackage.HV;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3252ki;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import defpackage.LL;
import defpackage.XS;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CoreTextFieldKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(TextLayoutResult textLayoutResult) {
            AbstractC4492zt.h(textLayoutResult, "it");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((TextLayoutResult) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ TextFieldState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TextFieldState textFieldState) {
            super(1);
            this.$state = textFieldState;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            final TextFieldState textFieldState = this.$state;
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    if (textFieldState.getHasFocus()) {
                        CoreTextFieldKt.onBlur(textFieldState);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ TextFieldSelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(TextFieldSelectionManager textFieldSelectionManager) {
            super(1);
            this.$manager = textFieldSelectionManager;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ ImeOptions $imeOptions;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ TextInputService $textInputService;
        final /* synthetic */ TextFieldValue $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions) {
            super(1);
            this.$textInputService = textInputService;
            this.$state = textFieldState;
            this.$value = textFieldValue;
            this.$imeOptions = imeOptions;
        }

        @Override // defpackage.InterfaceC3750qp
        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
            AbstractC4492zt.h(disposableEffectScope, "$this$DisposableEffect");
            if (this.$textInputService != null && this.$state.getHasFocus()) {
                TextFieldState textFieldState = this.$state;
                textFieldState.setInputSession(TextFieldDelegate.Companion.restartInput$foundation_release(this.$textInputService, this.$value, textFieldState.getProcessor(), this.$imeOptions, this.$state.getOnValueChange(), this.$state.getOnImeActionPerformed()));
            }
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
        final /* synthetic */ Modifier $cursorModifier;
        final /* synthetic */ InterfaceC0552Gp $decorationBox;
        final /* synthetic */ Density $density;
        final /* synthetic */ Modifier $drawModifier;
        final /* synthetic */ Modifier $magnifierModifier;
        final /* synthetic */ TextFieldSelectionManager $manager;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ int $minLines;
        final /* synthetic */ OffsetMapping $offsetMapping;
        final /* synthetic */ Modifier $onPositionedModifier;
        final /* synthetic */ InterfaceC3750qp $onTextLayout;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
        final /* synthetic */ boolean $showHandleAndMagnifier;
        final /* synthetic */ TextFieldState $state;
        final /* synthetic */ TextStyle $textStyle;
        final /* synthetic */ TextFieldValue $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
            final /* synthetic */ Modifier $cursorModifier;
            final /* synthetic */ Density $density;
            final /* synthetic */ Modifier $drawModifier;
            final /* synthetic */ Modifier $magnifierModifier;
            final /* synthetic */ TextFieldSelectionManager $manager;
            final /* synthetic */ int $maxLines;
            final /* synthetic */ int $minLines;
            final /* synthetic */ OffsetMapping $offsetMapping;
            final /* synthetic */ Modifier $onPositionedModifier;
            final /* synthetic */ InterfaceC3750qp $onTextLayout;
            final /* synthetic */ boolean $readOnly;
            final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
            final /* synthetic */ boolean $showHandleAndMagnifier;
            final /* synthetic */ TextFieldState $state;
            final /* synthetic */ TextStyle $textStyle;
            final /* synthetic */ TextFieldValue $value;
            final /* synthetic */ VisualTransformation $visualTransformation;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00521 extends AbstractC2233fv implements InterfaceC0526Fp {
                final /* synthetic */ Density $density;
                final /* synthetic */ TextFieldSelectionManager $manager;
                final /* synthetic */ int $maxLines;
                final /* synthetic */ OffsetMapping $offsetMapping;
                final /* synthetic */ InterfaceC3750qp $onTextLayout;
                final /* synthetic */ boolean $readOnly;
                final /* synthetic */ boolean $showHandleAndMagnifier;
                final /* synthetic */ TextFieldState $state;
                final /* synthetic */ TextFieldValue $value;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00521(TextFieldSelectionManager textFieldSelectionManager, TextFieldState textFieldState, boolean z, boolean z2, InterfaceC3750qp interfaceC3750qp, TextFieldValue textFieldValue, OffsetMapping offsetMapping, Density density, int i) {
                    super(2);
                    this.$manager = textFieldSelectionManager;
                    this.$state = textFieldState;
                    this.$showHandleAndMagnifier = z;
                    this.$readOnly = z2;
                    this.$onTextLayout = interfaceC3750qp;
                    this.$value = textFieldValue;
                    this.$offsetMapping = offsetMapping;
                    this.$density = density;
                    this.$maxLines = i;
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
                        ComposerKt.traceEventStart(-363167407, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:623)");
                    }
                    final TextFieldState textFieldState = this.$state;
                    final InterfaceC3750qp interfaceC3750qp = this.$onTextLayout;
                    final TextFieldValue textFieldValue = this.$value;
                    final OffsetMapping offsetMapping = this.$offsetMapping;
                    final Density density = this.$density;
                    final int i2 = this.$maxLines;
                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                            return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i3);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i3) {
                            AbstractC4492zt.h(intrinsicMeasureScope, "<this>");
                            AbstractC4492zt.h(list, "measurables");
                            textFieldState.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                            return textFieldState.getTextDelegate().getMaxIntrinsicWidth();
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            AbstractC4492zt.h(measureScope, "$this$measure");
                            AbstractC4492zt.h(list, "measurables");
                            Snapshot.Companion companion = Snapshot.Companion;
                            TextFieldState textFieldState2 = textFieldState;
                            Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
                            try {
                                Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                                try {
                                    TextLayoutResultProxy layoutResult = textFieldState2.getLayoutResult();
                                    TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                                    snapshotCreateNonObservableSnapshot.dispose();
                                    DV dvM817layout_EkL_Y$foundation_release = TextFieldDelegate.Companion.m817layout_EkL_Y$foundation_release(textFieldState.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                    int iIntValue = ((Number) dvM817layout_EkL_Y$foundation_release.a()).intValue();
                                    int iIntValue2 = ((Number) dvM817layout_EkL_Y$foundation_release.b()).intValue();
                                    TextLayoutResult textLayoutResult = (TextLayoutResult) dvM817layout_EkL_Y$foundation_release.c();
                                    if (!AbstractC4492zt.d(value, textLayoutResult)) {
                                        textFieldState.setLayoutResult(new TextLayoutResultProxy(textLayoutResult));
                                        interfaceC3750qp.invoke(textLayoutResult);
                                        CoreTextFieldKt.notifyFocusedRect(textFieldState, textFieldValue, offsetMapping);
                                    }
                                    textFieldState.m837setMinHeightForSingleLineField0680j_4(density.mo330toDpu2uoSUM(i2 == 1 ? TextDelegateKt.ceilToIntPx(textLayoutResult.getLineBottom(0)) : 0));
                                    return measureScope.layout(iIntValue, iIntValue2, AbstractC4243wx.j(HV.a(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(AbstractC1210aB.c(textLayoutResult.getFirstBaseline()))), HV.a(AlignmentLineKt.getLastBaseline(), Integer.valueOf(AbstractC1210aB.c(textLayoutResult.getLastBaseline())))), CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2.INSTANCE);
                                } catch (Throwable th) {
                                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                snapshotCreateNonObservableSnapshot.dispose();
                                throw th2;
                            }
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                            return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i3);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                            return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i3);
                        }
                    };
                    composer.startReplaceableGroup(-1323940314);
                    Modifier.Companion companion = Modifier.Companion;
                    boolean z = false;
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    InterfaceC3588op constructor = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                    InterfaceC0526Fp setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                    if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                    composer.startReplaceableGroup(2058660585);
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    TextFieldSelectionManager textFieldSelectionManager = this.$manager;
                    if (this.$state.getHandleState() == HandleState.Selection && this.$state.getLayoutCoordinates() != null) {
                        LayoutCoordinates layoutCoordinates = this.$state.getLayoutCoordinates();
                        AbstractC4492zt.e(layoutCoordinates);
                        if (layoutCoordinates.isAttached() && this.$showHandleAndMagnifier) {
                            z = true;
                        }
                    }
                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager, z, composer, 8);
                    if (this.$state.getHandleState() == HandleState.Cursor && !this.$readOnly && this.$showHandleAndMagnifier) {
                        CoreTextFieldKt.TextFieldCursorHandle(this.$manager, composer, 8);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TextFieldState textFieldState, TextStyle textStyle, int i, int i2, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, InterfaceC3750qp interfaceC3750qp, OffsetMapping offsetMapping, Density density) {
                super(2);
                this.$state = textFieldState;
                this.$textStyle = textStyle;
                this.$minLines = i;
                this.$maxLines = i2;
                this.$scrollerPosition = textFieldScrollerPosition;
                this.$value = textFieldValue;
                this.$visualTransformation = visualTransformation;
                this.$cursorModifier = modifier;
                this.$drawModifier = modifier2;
                this.$onPositionedModifier = modifier3;
                this.$magnifierModifier = modifier4;
                this.$bringIntoViewRequester = bringIntoViewRequester;
                this.$manager = textFieldSelectionManager;
                this.$showHandleAndMagnifier = z;
                this.$readOnly = z2;
                this.$onTextLayout = interfaceC3750qp;
                this.$offsetMapping = offsetMapping;
                this.$density = density;
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
                    ComposerKt.traceEventStart(2032502107, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:598)");
                }
                SimpleLayoutKt.SimpleLayout(BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(HeightInLinesModifierKt.heightInLines(SizeKt.m520heightInVpY3zN4$default(Modifier.Companion, this.$state.m836getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), this.$textStyle, this.$minLines, this.$maxLines), this.$scrollerPosition, this.$value, this.$visualTransformation, new CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1(this.$state)).then(this.$cursorModifier).then(this.$drawModifier), this.$textStyle).then(this.$onPositionedModifier).then(this.$magnifierModifier), this.$bringIntoViewRequester), ComposableLambdaKt.composableLambda(composer, -363167407, true, new C00521(this.$manager, this.$state, this.$showHandleAndMagnifier, this.$readOnly, this.$onTextLayout, this.$value, this.$offsetMapping, this.$density, this.$maxLines)), composer, 48, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(InterfaceC0552Gp interfaceC0552Gp, int i, TextFieldState textFieldState, TextStyle textStyle, int i2, int i3, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, InterfaceC3750qp interfaceC3750qp, OffsetMapping offsetMapping, Density density) {
            super(2);
            this.$decorationBox = interfaceC0552Gp;
            this.$$dirty1 = i;
            this.$state = textFieldState;
            this.$textStyle = textStyle;
            this.$minLines = i2;
            this.$maxLines = i3;
            this.$scrollerPosition = textFieldScrollerPosition;
            this.$value = textFieldValue;
            this.$visualTransformation = visualTransformation;
            this.$cursorModifier = modifier;
            this.$drawModifier = modifier2;
            this.$onPositionedModifier = modifier3;
            this.$magnifierModifier = modifier4;
            this.$bringIntoViewRequester = bringIntoViewRequester;
            this.$manager = textFieldSelectionManager;
            this.$showHandleAndMagnifier = z;
            this.$readOnly = z2;
            this.$onTextLayout = interfaceC3750qp;
            this.$offsetMapping = offsetMapping;
            this.$density = density;
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
                ComposerKt.traceEventStart(-374338080, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:597)");
            }
            this.$decorationBox.invoke(ComposableLambdaKt.composableLambda(composer, 2032502107, true, new AnonymousClass1(this.$state, this.$textStyle, this.$minLines, this.$maxLines, this.$scrollerPosition, this.$value, this.$visualTransformation, this.$cursorModifier, this.$drawModifier, this.$onPositionedModifier, this.$magnifierModifier, this.$bringIntoViewRequester, this.$manager, this.$showHandleAndMagnifier, this.$readOnly, this.$onTextLayout, this.$offsetMapping, this.$density)), composer, Integer.valueOf(((this.$$dirty1 >> 12) & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6, reason: invalid class name */
    public static final class AnonymousClass6 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ Brush $cursorBrush;
        final /* synthetic */ InterfaceC0552Gp $decorationBox;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ ImeOptions $imeOptions;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ KeyboardActions $keyboardActions;
        final /* synthetic */ int $maxLines;
        final /* synthetic */ int $minLines;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onTextLayout;
        final /* synthetic */ InterfaceC3750qp $onValueChange;
        final /* synthetic */ boolean $readOnly;
        final /* synthetic */ boolean $softWrap;
        final /* synthetic */ TextStyle $textStyle;
        final /* synthetic */ TextFieldValue $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(TextFieldValue textFieldValue, InterfaceC3750qp interfaceC3750qp, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, InterfaceC3750qp interfaceC3750qp2, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, InterfaceC0552Gp interfaceC0552Gp, int i3, int i4, int i5) {
            super(2);
            this.$value = textFieldValue;
            this.$onValueChange = interfaceC3750qp;
            this.$modifier = modifier;
            this.$textStyle = textStyle;
            this.$visualTransformation = visualTransformation;
            this.$onTextLayout = interfaceC3750qp2;
            this.$interactionSource = mutableInteractionSource;
            this.$cursorBrush = brush;
            this.$softWrap = z;
            this.$maxLines = i;
            this.$minLines = i2;
            this.$imeOptions = imeOptions;
            this.$keyboardActions = keyboardActions;
            this.$enabled = z2;
            this.$readOnly = z3;
            this.$decorationBox = interfaceC0552Gp;
            this.$$changed = i3;
            this.$$changed1 = i4;
            this.$$default = i5;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            CoreTextFieldKt.CoreTextField(this.$value, this.$onValueChange, this.$modifier, this.$textStyle, this.$visualTransformation, this.$onTextLayout, this.$interactionSource, this.$cursorBrush, this.$softWrap, this.$maxLines, this.$minLines, this.$imeOptions, this.$keyboardActions, this.$enabled, this.$readOnly, this.$decorationBox, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13902 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ TextFieldSelectionManager $manager;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13902(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$modifier = modifier;
            this.$manager = textFieldSelectionManager;
            this.$content = interfaceC0526Fp;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            CoreTextFieldKt.CoreTextFieldRootBox(this.$modifier, this.$manager, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$SelectionToolbarAndHandles$2, reason: invalid class name and case insensitive filesystem */
    public static final class C13912 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TextFieldSelectionManager $manager;
        final /* synthetic */ boolean $show;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13912(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i) {
            super(2);
            this.$manager = textFieldSelectionManager;
            this.$show = z;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            CoreTextFieldKt.SelectionToolbarAndHandles(this.$manager, this.$show, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC3252ki(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1", f = "CoreTextField.kt", l = {1077}, m = "invokeSuspend")
    public static final class C13921 extends XS implements InterfaceC0526Fp {
        final /* synthetic */ TextDragObserver $observer;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13921(TextDragObserver textDragObserver, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.$observer = textDragObserver;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            C13921 c13921 = new C13921(this.$observer, interfaceC0793Of);
            c13921.L$0 = obj;
            return c13921;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
            return ((C13921) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.label;
            if (i == 0) {
                LL.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                TextDragObserver textDragObserver = this.$observer;
                this.label = 1;
                if (LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(pointerInputScope, textDragObserver, this) == objD) {
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

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3, reason: invalid class name and case insensitive filesystem */
    public static final class C13933 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TextFieldSelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13933(TextFieldSelectionManager textFieldSelectionManager, int i) {
            super(2);
            this.$manager = textFieldSelectionManager;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            CoreTextFieldKt.TextFieldCursorHandle(this.$manager, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextFieldKt$previewKeyEventToDeselectOnBack$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13941 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ TextFieldSelectionManager $manager;
        final /* synthetic */ TextFieldState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13941(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager) {
            super(1);
            this.$state = textFieldState;
            this.$manager = textFieldSelectionManager;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m761invokeZmokQxo(((KeyEvent) obj).m3928unboximpl());
        }

        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
        public final Boolean m761invokeZmokQxo(android.view.KeyEvent keyEvent) {
            boolean z;
            AbstractC4492zt.h(keyEvent, "keyEvent");
            if (this.$state.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m763cancelsTextSelectionZmokQxo(keyEvent)) {
                z = true;
                TextFieldSelectionManager.m951deselect_kEHs6E$foundation_release$default(this.$manager, null, 1, null);
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0142  */
    /* JADX WARN: Code duplicated, block: B:103:0x014a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0150  */
    /* JADX WARN: Code duplicated, block: B:106:0x0153  */
    /* JADX WARN: Code duplicated, block: B:109:0x015a  */
    /* JADX WARN: Code duplicated, block: B:110:0x015f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0165  */
    /* JADX WARN: Code duplicated, block: B:115:0x016c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0171  */
    /* JADX WARN: Code duplicated, block: B:120:0x0177  */
    /* JADX WARN: Code duplicated, block: B:122:0x017f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0188  */
    /* JADX WARN: Code duplicated, block: B:128:0x018f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0196  */
    /* JADX WARN: Code duplicated, block: B:133:0x019b  */
    /* JADX WARN: Code duplicated, block: B:135:0x019f  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:138:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:140:0x01af  */
    /* JADX WARN: Code duplicated, block: B:143:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:145:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:147:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:149:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:150:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:152:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:155:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:156:0x01db  */
    /* JADX WARN: Code duplicated, block: B:158:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:160:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:161:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:165:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:166:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:168:0x0207  */
    /* JADX WARN: Code duplicated, block: B:170:0x020d  */
    /* JADX WARN: Code duplicated, block: B:171:0x0210  */
    /* JADX WARN: Code duplicated, block: B:175:0x021e  */
    /* JADX WARN: Code duplicated, block: B:181:0x0250  */
    /* JADX WARN: Code duplicated, block: B:183:0x0258  */
    /* JADX WARN: Code duplicated, block: B:190:0x02a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:191:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:192:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:194:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:195:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:197:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:198:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:200:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:201:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:203:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:204:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:206:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:207:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:209:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:210:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:212:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:213:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:215:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:217:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:220:0x0305  */
    /* JADX WARN: Code duplicated, block: B:221:0x030e  */
    /* JADX WARN: Code duplicated, block: B:223:0x0312  */
    /* JADX WARN: Code duplicated, block: B:224:0x0319  */
    /* JADX WARN: Code duplicated, block: B:226:0x031d  */
    /* JADX WARN: Code duplicated, block: B:227:0x031f  */
    /* JADX WARN: Code duplicated, block: B:229:0x0323  */
    /* JADX WARN: Code duplicated, block: B:230:0x0325  */
    /* JADX WARN: Code duplicated, block: B:232:0x0329  */
    /* JADX WARN: Code duplicated, block: B:234:0x0348  */
    /* JADX WARN: Code duplicated, block: B:237:0x0367  */
    /* JADX WARN: Code duplicated, block: B:240:0x0381  */
    /* JADX WARN: Code duplicated, block: B:243:0x03c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:248:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:251:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:253:0x0400  */
    /* JADX WARN: Code duplicated, block: B:256:0x043c  */
    /* JADX WARN: Code duplicated, block: B:258:0x0442  */
    /* JADX WARN: Code duplicated, block: B:260:0x0450  */
    /* JADX WARN: Code duplicated, block: B:262:0x045c  */
    /* JADX WARN: Code duplicated, block: B:266:0x0487  */
    /* JADX WARN: Code duplicated, block: B:269:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:272:0x0527  */
    /* JADX WARN: Code duplicated, block: B:275:0x058e  */
    /* JADX WARN: Code duplicated, block: B:278:0x05b9  */
    /* JADX WARN: Code duplicated, block: B:281:0x05ec A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:283:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:286:0x0606  */
    /* JADX WARN: Code duplicated, block: B:287:0x0639  */
    /* JADX WARN: Code duplicated, block: B:290:0x0694 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:292:0x0698  */
    /* JADX WARN: Code duplicated, block: B:295:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:296:0x06cd  */
    /* JADX WARN: Code duplicated, block: B:299:0x071e  */
    /* JADX WARN: Code duplicated, block: B:304:0x072d  */
    /* JADX WARN: Code duplicated, block: B:306:0x0731  */
    /* JADX WARN: Code duplicated, block: B:307:0x0738  */
    /* JADX WARN: Code duplicated, block: B:310:0x0795  */
    /* JADX WARN: Code duplicated, block: B:315:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:317:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0086  */
    /* JADX WARN: Code duplicated, block: B:39:0x008b  */
    /* JADX WARN: Code duplicated, block: B:41:0x008f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0097  */
    /* JADX WARN: Code duplicated, block: B:44:0x009a  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00be  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00db  */
    /* JADX WARN: Code duplicated, block: B:69:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:79:0x0102  */
    /* JADX WARN: Code duplicated, block: B:81:0x010a  */
    /* JADX WARN: Code duplicated, block: B:83:0x0110  */
    /* JADX WARN: Code duplicated, block: B:84:0x0113  */
    /* JADX WARN: Code duplicated, block: B:88:0x011b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0122  */
    /* JADX WARN: Code duplicated, block: B:91:0x012a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0130  */
    /* JADX WARN: Code duplicated, block: B:94:0x0133  */
    /* JADX WARN: Code duplicated, block: B:98:0x013b  */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]]")
    public static final void CoreTextField(TextFieldValue textFieldValue, InterfaceC3750qp interfaceC3750qp, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, InterfaceC3750qp interfaceC3750qp2, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        Modifier modifier2;
        TextStyle textStyle2;
        VisualTransformation none;
        InterfaceC3750qp interfaceC3750qp3;
        MutableInteractionSource mutableInteractionSource2;
        Brush solidColor;
        boolean z4;
        int i32;
        int i33;
        ImeOptions imeOptions2;
        KeyboardActions keyboardActions2;
        boolean z5;
        boolean z6;
        InterfaceC0552Gp interfaceC0552GpM759getLambda1$foundation_release;
        int i34;
        Brush brush2;
        Object objRememberedValue;
        Composer.Companion companion;
        FocusRequester focusRequester;
        Density density;
        FontFamily.Resolver resolver;
        Orientation orientation;
        Orientation orientation2;
        int i35;
        boolean zChanged;
        Object objRememberedValue2;
        boolean zChanged2;
        Object objRememberedValue3;
        TransformedText transformedTextFilterWithValidation;
        TextRange textRangeM4921getCompositionMzsxiRA;
        AnnotatedString text;
        OffsetMapping offsetMapping;
        RecomposeScope currentRecomposeScope;
        Object objRememberedValue4;
        TextFieldState textFieldState;
        Object objRememberedValue5;
        UndoManager undoManager;
        Object objRememberedValue6;
        TextFieldSelectionManager textFieldSelectionManager;
        Object objRememberedValue7;
        Object objRememberedValue8;
        Modifier.Companion companion2;
        Modifier modifierPointerHoverIcon$default;
        boolean z7;
        boolean z8;
        boolean z9;
        Modifier modifierTextFieldMagnifier;
        Composer composer2;
        Modifier modifier3;
        TextStyle textStyle3;
        InterfaceC3750qp interfaceC3750qp4;
        boolean z10;
        Brush brush3;
        boolean z11;
        int i36;
        KeyboardActions keyboardActions3;
        boolean z12;
        InterfaceC0552Gp interfaceC0552Gp2;
        ImeOptions imeOptions3;
        int i37;
        MutableInteractionSource mutableInteractionSource3;
        VisualTransformation visualTransformation2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i38;
        AbstractC4492zt.h(textFieldValue, "value");
        AbstractC4492zt.h(interfaceC3750qp, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-958708118);
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i6 = i3 | (composerStartRestartGroup.changed(textFieldValue) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 112) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        int i39 = i6;
        int i40 = i5 & 4;
        if (i40 == 0) {
            if ((i3 & 896) == 0) {
                i39 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
            }
            i7 = i5 & 8;
            if (i7 != 0) {
                if ((i3 & 7168) == 0) {
                    if (composerStartRestartGroup.changed(textStyle)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i39 |= i8;
                }
                i9 = i5 & 16;
                if (i9 != 0) {
                    i39 |= 24576;
                } else if ((i3 & 57344) == 0) {
                    if (composerStartRestartGroup.changed(visualTransformation)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i39 |= i10;
                }
                i11 = i5 & 32;
                if (i11 != 0) {
                    i39 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i3 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i39 |= i12;
                }
                i13 = i5 & 64;
                if (i13 != 0) {
                    i39 |= 1572864;
                } else if ((i3 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i39 |= i14;
                }
                i15 = i5 & 128;
                if (i15 != 0) {
                    i39 |= 12582912;
                } else if ((i3 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(brush)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i39 |= i16;
                }
                i17 = i5 & 256;
                if (i17 != 0) {
                    i39 |= 100663296;
                } else if ((i3 & 234881024) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i18 = 67108864;
                    } else {
                        i18 = 33554432;
                    }
                    i39 |= i18;
                }
                i19 = i5 & 512;
                if (i19 != 0) {
                    if ((i3 & 1879048192) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i20 = PropertyOptions.DELETE_EXISTING;
                        } else {
                            i20 = 268435456;
                        }
                    }
                    i21 = i5 & 1024;
                    if (i21 != 0) {
                        i22 = i4 | 6;
                    } else if ((i4 & 14) == 0) {
                        i22 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                    } else {
                        i22 = i4;
                    }
                    if ((i4 & 112) != 0) {
                        if ((i5 & 2048) == 0 || !composerStartRestartGroup.changed(imeOptions)) {
                            i38 = 16;
                        } else {
                            i38 = 32;
                        }
                        i22 |= i38;
                    }
                    i23 = i22;
                    i24 = i5 & 4096;
                    if (i24 != 0) {
                        i23 |= 384;
                    } else if ((i4 & 896) != 0) {
                        if (composerStartRestartGroup.changed(keyboardActions)) {
                            i25 = 256;
                        } else {
                            i25 = 128;
                        }
                        i23 |= i25;
                    }
                    i26 = i5 & 8192;
                    if (i26 != 0) {
                        i23 |= 3072;
                    } else if ((i4 & 7168) != 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i27 = 2048;
                        } else {
                            i27 = 1024;
                        }
                        i23 |= i27;
                    }
                    i28 = i5 & 16384;
                    if (i28 != 0) {
                        i23 |= 24576;
                    } else if ((i4 & 57344) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i29 = 16384;
                        } else {
                            i29 = 8192;
                        }
                        i23 |= i29;
                    }
                    i30 = i5 & 32768;
                    if (i30 != 0) {
                        i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i4 & 458752) == 0) {
                        if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                            i31 = 131072;
                        } else {
                            i31 = 65536;
                        }
                        i23 |= i31;
                    }
                    if ((i39 & 1533916891) != 306783378 && (374491 & i23) == 74898 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        textStyle3 = textStyle;
                        visualTransformation2 = visualTransformation;
                        interfaceC3750qp4 = interfaceC3750qp2;
                        mutableInteractionSource3 = mutableInteractionSource;
                        brush3 = brush;
                        z11 = z;
                        i37 = i;
                        i36 = i2;
                        imeOptions3 = imeOptions;
                        keyboardActions3 = keyboardActions;
                        z10 = z2;
                        z12 = z3;
                        interfaceC0552Gp2 = interfaceC0552Gp;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i3 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i40 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i7 != 0) {
                                textStyle2 = TextStyle.Companion.getDefault();
                            } else {
                                textStyle2 = textStyle;
                            }
                            if (i9 != 0) {
                                none = VisualTransformation.Companion.getNone();
                            } else {
                                none = visualTransformation;
                            }
                            if (i11 != 0) {
                                interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i13 != 0) {
                                mutableInteractionSource2 = null;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            if (i15 != 0) {
                                solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                            } else {
                                solidColor = brush;
                            }
                            if (i17 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            if (i19 != 0) {
                                i32 = Integer.MAX_VALUE;
                            } else {
                                i32 = i;
                            }
                            if (i21 != 0) {
                                i33 = 1;
                            } else {
                                i33 = i2;
                            }
                            if ((2048 & i5) != 0) {
                                imeOptions2 = ImeOptions.Companion.getDefault();
                                i23 &= -113;
                            } else {
                                imeOptions2 = imeOptions;
                            }
                            if (i24 != 0) {
                                keyboardActions2 = KeyboardActions.Companion.getDefault();
                            } else {
                                keyboardActions2 = keyboardActions;
                            }
                            if (i26 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i28 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (i30 != 0) {
                                interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                            } else {
                                interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                            }
                            i34 = i32;
                            brush2 = solidColor;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((2048 & i5) != 0) {
                                int i41 = i23 & (-113);
                                modifier2 = modifier;
                                textStyle2 = textStyle;
                                none = visualTransformation;
                                interfaceC3750qp3 = interfaceC3750qp2;
                                mutableInteractionSource2 = mutableInteractionSource;
                                brush2 = brush;
                                z4 = z;
                                i34 = i;
                                i33 = i2;
                                imeOptions2 = imeOptions;
                                keyboardActions2 = keyboardActions;
                                z5 = z2;
                                z6 = z3;
                                interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                                i23 = i41;
                            } else {
                                modifier2 = modifier;
                                textStyle2 = textStyle;
                                none = visualTransformation;
                                interfaceC3750qp3 = interfaceC3750qp2;
                                mutableInteractionSource2 = mutableInteractionSource;
                                brush2 = brush;
                                z4 = z;
                                i34 = i;
                                i33 = i2;
                                keyboardActions2 = keyboardActions;
                                z5 = z2;
                                z6 = z3;
                                interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                                i23 = i23;
                                imeOptions2 = imeOptions;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        focusRequester = (FocusRequester) objRememberedValue;
                        TextInputService textInputService = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                        density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                        long jM966getBackgroundColor0d7_KjU = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                        FocusManager focusManager = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        if (i34 == 1 || z4 || !imeOptions2.getSingleLine()) {
                            orientation = Orientation.Vertical;
                        } else {
                            orientation = Orientation.Horizontal;
                        }
                        orientation2 = orientation;
                        Modifier modifier4 = modifier2;
                        Object[] objArr = {orientation2};
                        Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.Companion.getSaver();
                        i35 = i34;
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(orientation2);
                        int i42 = i23;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TextFieldScrollerPosition textFieldScrollerPosition = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr, (Saver) saver, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                        composerStartRestartGroup.startReplaceableGroup(511388516);
                        zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                            transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                            textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                            if (textRangeM4921getCompositionMzsxiRA != null || (objRememberedValue3 = TextFieldDelegate.Companion.m816applyCompositionDecoration72CqOWE(textRangeM4921getCompositionMzsxiRA.m4709unboximpl(), transformedTextFilterWithValidation)) == null) {
                                objRememberedValue3 = transformedTextFilterWithValidation;
                            }
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        TransformedText transformedText = (TransformedText) objRememberedValue3;
                        text = transformedText.getText();
                        offsetMapping = transformedText.getOffsetMapping();
                        currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        textFieldState = (TextFieldState) objRememberedValue4;
                        textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager, jM966getBackgroundColor0d7_KjU);
                        textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new UndoManager(0, 1, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        undoManager = (UndoManager) objRememberedValue5;
                        UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                        textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                        textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                        textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                        textFieldSelectionManager.setState$foundation_release(textFieldState);
                        textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                        textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                        textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                        textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                        textFieldSelectionManager.setFocusRequester(focusRequester);
                        textFieldSelectionManager.setEditable(!z6);
                        composerStartRestartGroup.startReplaceableGroup(773894976);
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                            composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            objRememberedValue7 = compositionScopedCoroutineScopeCanceller;
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue8 == companion.getEmpty()) {
                            objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) objRememberedValue8;
                        companion2 = Modifier.Companion;
                        Modifier modifierTextFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope, bringIntoViewRequester));
                        composerStartRestartGroup.startReplaceableGroup(-55008291);
                        if (!z5 && !z6) {
                            EffectsKt.DisposableEffect(textFieldState, new AnonymousClass2(textFieldState), composerStartRestartGroup, 8);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        if (TouchMode_androidKt.isInTouchMode()) {
                            modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                        } else {
                            modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                        }
                        Modifier modifierDrawBehind = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                        Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                        Modifier modifierSemantics = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                        if (z5 || z6) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        Modifier modifierCursor = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                        EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                        EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i42 >> 3) & 14);
                        InterfaceC3750qp onValueChange = textFieldState.getOnValueChange();
                        boolean z13 = !z6;
                        if (i35 == 1) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                        Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier4.then(modifierTextFieldFocusModifier), textFieldState, focusManager), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange, z13, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition, mutableInteractionSource4, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                        if (!z5 && textFieldState.getHasFocus() && TouchMode_androidKt.isInTouchMode()) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        if (z9) {
                            modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                        } else {
                            modifierTextFieldMagnifier = companion2;
                        }
                        boolean z14 = z5;
                        ImeOptions imeOptions4 = imeOptions2;
                        VisualTransformation visualTransformation3 = none;
                        composer2 = composerStartRestartGroup;
                        CoreTextFieldRootBox(modifierOnGloballyPositioned2, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i42, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition, textFieldValue, none, modifierCursor, modifierDrawBehind, modifierOnGloballyPositioned, modifierTextFieldMagnifier, bringIntoViewRequester, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        textStyle3 = textStyle2;
                        interfaceC3750qp4 = interfaceC3750qp3;
                        z10 = z14;
                        brush3 = brush2;
                        z11 = z4;
                        i36 = i33;
                        keyboardActions3 = keyboardActions2;
                        z12 = z6;
                        interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                        imeOptions3 = imeOptions4;
                        i37 = i35;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        visualTransformation2 = visualTransformation3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(textFieldValue, interfaceC3750qp, modifier3, textStyle3, visualTransformation2, interfaceC3750qp4, mutableInteractionSource3, brush3, z11, i37, i36, imeOptions3, keyboardActions3, z10, z12, interfaceC0552Gp2, i3, i4, i5));
                }
                i20 = 805306368;
                i39 |= i20;
                i21 = i5 & 1024;
                if (i21 != 0) {
                    i22 = i4 | 6;
                } else if ((i4 & 14) == 0) {
                    i22 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                } else {
                    i22 = i4;
                }
                if ((i4 & 112) != 0) {
                    if ((i5 & 2048) == 0) {
                        i38 = 16;
                    } else {
                        i38 = 16;
                    }
                    i22 |= i38;
                }
                i23 = i22;
                i24 = i5 & 4096;
                if (i24 != 0) {
                    i23 |= 384;
                } else if ((i4 & 896) != 0) {
                    if (composerStartRestartGroup.changed(keyboardActions)) {
                        i25 = 256;
                    } else {
                        i25 = 128;
                    }
                    i23 |= i25;
                }
                i26 = i5 & 8192;
                if (i26 != 0) {
                    i23 |= 3072;
                } else if ((i4 & 7168) != 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i27 = 2048;
                    } else {
                        i27 = 1024;
                    }
                    i23 |= i27;
                }
                i28 = i5 & 16384;
                if (i28 != 0) {
                    i23 |= 24576;
                } else if ((i4 & 57344) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i29 = 16384;
                    } else {
                        i29 = 8192;
                    }
                    i23 |= i29;
                }
                i30 = i5 & 32768;
                if (i30 != 0) {
                    i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i31 = 131072;
                    } else {
                        i31 = 65536;
                    }
                    i23 |= i31;
                }
                if ((i39 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    } else {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue;
                    TextInputService textInputService2 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                    long jM966getBackgroundColor0d7_KjU2 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                    FocusManager focusManager2 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    if (i34 == 1) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Vertical;
                    }
                    orientation2 = orientation;
                    Modifier modifier5 = modifier2;
                    Object[] objArr2 = {orientation2};
                    Saver<TextFieldScrollerPosition, Object> saver2 = TextFieldScrollerPosition.Companion.getSaver();
                    i35 = i34;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(orientation2);
                    int i43 = i23;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldScrollerPosition textFieldScrollerPosition2 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr2, (Saver) saver2, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TransformedText transformedText2 = (TransformedText) objRememberedValue3;
                    text = transformedText2.getText();
                    offsetMapping = transformedText2.getOffsetMapping();
                    currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldState = (TextFieldState) objRememberedValue4;
                    textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager2, jM966getBackgroundColor0d7_KjU2);
                    textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new UndoManager(0, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    undoManager = (UndoManager) objRememberedValue5;
                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                    textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                    textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                    textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                    textFieldSelectionManager.setState$foundation_release(textFieldState);
                    textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                    textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                    textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                    textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                    textFieldSelectionManager.setFocusRequester(focusRequester);
                    textFieldSelectionManager.setEditable(!z6);
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                        objRememberedValue7 = compositionScopedCoroutineScopeCanceller2;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BringIntoViewRequester bringIntoViewRequester2 = (BringIntoViewRequester) objRememberedValue8;
                    companion2 = Modifier.Companion;
                    Modifier modifierTextFieldFocusModifier2 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService2, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope2, bringIntoViewRequester2));
                    composerStartRestartGroup.startReplaceableGroup(-55008291);
                    if (!z5) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (TouchMode_androidKt.isInTouchMode()) {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    } else {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    }
                    Modifier modifierDrawBehind2 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                    Modifier modifierOnGloballyPositioned3 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                    Modifier modifierSemantics2 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText2, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierCursor2 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                    EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                    EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService2, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i43 >> 3) & 14);
                    InterfaceC3750qp onValueChange2 = textFieldState.getOnValueChange();
                    boolean z15 = !z6;
                    if (i35 == 1) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                    Modifier modifierOnGloballyPositioned4 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier5.then(modifierTextFieldFocusModifier2), textFieldState, focusManager2), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange2, z15, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition2, mutableInteractionSource5, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics2), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                    if (!z5) {
                        z9 = false;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                    } else {
                        modifierTextFieldMagnifier = companion2;
                    }
                    boolean z16 = z5;
                    ImeOptions imeOptions5 = imeOptions2;
                    VisualTransformation visualTransformation4 = none;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldRootBox(modifierOnGloballyPositioned4, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i43, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition2, textFieldValue, none, modifierCursor2, modifierDrawBehind2, modifierOnGloballyPositioned3, modifierTextFieldMagnifier, bringIntoViewRequester2, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    textStyle3 = textStyle2;
                    interfaceC3750qp4 = interfaceC3750qp3;
                    z10 = z16;
                    brush3 = brush2;
                    z11 = z4;
                    i36 = i33;
                    keyboardActions3 = keyboardActions2;
                    z12 = z6;
                    interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                    imeOptions3 = imeOptions5;
                    i37 = i35;
                    mutableInteractionSource3 = mutableInteractionSource5;
                    visualTransformation2 = visualTransformation4;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    } else {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue;
                    TextInputService textInputService3 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                    long jM966getBackgroundColor0d7_KjU3 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                    FocusManager focusManager3 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    if (i34 == 1) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Vertical;
                    }
                    orientation2 = orientation;
                    Modifier modifier6 = modifier2;
                    Object[] objArr3 = {orientation2};
                    Saver<TextFieldScrollerPosition, Object> saver3 = TextFieldScrollerPosition.Companion.getSaver();
                    i35 = i34;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(orientation2);
                    int i44 = i23;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldScrollerPosition textFieldScrollerPosition3 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr3, (Saver) saver3, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TransformedText transformedText3 = (TransformedText) objRememberedValue3;
                    text = transformedText3.getText();
                    offsetMapping = transformedText3.getOffsetMapping();
                    currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldState = (TextFieldState) objRememberedValue4;
                    textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager3, jM966getBackgroundColor0d7_KjU3);
                    textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new UndoManager(0, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    undoManager = (UndoManager) objRememberedValue5;
                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                    textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                    textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                    textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                    textFieldSelectionManager.setState$foundation_release(textFieldState);
                    textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                    textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                    textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                    textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                    textFieldSelectionManager.setFocusRequester(focusRequester);
                    textFieldSelectionManager.setEditable(!z6);
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller3 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller3);
                        objRememberedValue7 = compositionScopedCoroutineScopeCanceller3;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope3 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BringIntoViewRequester bringIntoViewRequester3 = (BringIntoViewRequester) objRememberedValue8;
                    companion2 = Modifier.Companion;
                    Modifier modifierTextFieldFocusModifier3 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService3, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope3, bringIntoViewRequester3));
                    composerStartRestartGroup.startReplaceableGroup(-55008291);
                    if (!z5) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (TouchMode_androidKt.isInTouchMode()) {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    } else {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    }
                    Modifier modifierDrawBehind3 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                    Modifier modifierOnGloballyPositioned5 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                    Modifier modifierSemantics3 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText3, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierCursor3 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                    EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                    EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService3, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i44 >> 3) & 14);
                    InterfaceC3750qp onValueChange3 = textFieldState.getOnValueChange();
                    boolean z17 = !z6;
                    if (i35 == 1) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                    Modifier modifierOnGloballyPositioned6 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier6.then(modifierTextFieldFocusModifier3), textFieldState, focusManager3), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange3, z17, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition3, mutableInteractionSource6, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics3), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                    if (!z5) {
                        z9 = false;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                    } else {
                        modifierTextFieldMagnifier = companion2;
                    }
                    boolean z18 = z5;
                    ImeOptions imeOptions6 = imeOptions2;
                    VisualTransformation visualTransformation5 = none;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldRootBox(modifierOnGloballyPositioned6, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i44, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition3, textFieldValue, none, modifierCursor3, modifierDrawBehind3, modifierOnGloballyPositioned5, modifierTextFieldMagnifier, bringIntoViewRequester3, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    textStyle3 = textStyle2;
                    interfaceC3750qp4 = interfaceC3750qp3;
                    z10 = z18;
                    brush3 = brush2;
                    z11 = z4;
                    i36 = i33;
                    keyboardActions3 = keyboardActions2;
                    z12 = z6;
                    interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                    imeOptions3 = imeOptions6;
                    i37 = i35;
                    mutableInteractionSource3 = mutableInteractionSource6;
                    visualTransformation2 = visualTransformation5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(textFieldValue, interfaceC3750qp, modifier3, textStyle3, visualTransformation2, interfaceC3750qp4, mutableInteractionSource3, brush3, z11, i37, i36, imeOptions3, keyboardActions3, z10, z12, interfaceC0552Gp2, i3, i4, i5));
            }
            i39 |= 3072;
            i9 = i5 & 16;
            if (i9 != 0) {
                i39 |= 24576;
            } else if ((i3 & 57344) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i39 |= i10;
            }
            i11 = i5 & 32;
            if (i11 != 0) {
                i39 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i39 |= i12;
            }
            i13 = i5 & 64;
            if (i13 != 0) {
                i39 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i39 |= i14;
            }
            i15 = i5 & 128;
            if (i15 != 0) {
                i39 |= 12582912;
            } else if ((i3 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(brush)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i39 |= i16;
            }
            i17 = i5 & 256;
            if (i17 != 0) {
                i39 |= 100663296;
            } else if ((i3 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i18 = 67108864;
                } else {
                    i18 = 33554432;
                }
                i39 |= i18;
            }
            i19 = i5 & 512;
            if (i19 != 0) {
                if ((i3 & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i20 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i20 = 268435456;
                    }
                }
                i21 = i5 & 1024;
                if (i21 != 0) {
                    i22 = i4 | 6;
                } else if ((i4 & 14) == 0) {
                    i22 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                } else {
                    i22 = i4;
                }
                if ((i4 & 112) != 0) {
                    if ((i5 & 2048) == 0) {
                        i38 = 16;
                    } else {
                        i38 = 16;
                    }
                    i22 |= i38;
                }
                i23 = i22;
                i24 = i5 & 4096;
                if (i24 != 0) {
                    i23 |= 384;
                } else if ((i4 & 896) != 0) {
                    if (composerStartRestartGroup.changed(keyboardActions)) {
                        i25 = 256;
                    } else {
                        i25 = 128;
                    }
                    i23 |= i25;
                }
                i26 = i5 & 8192;
                if (i26 != 0) {
                    i23 |= 3072;
                } else if ((i4 & 7168) != 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i27 = 2048;
                    } else {
                        i27 = 1024;
                    }
                    i23 |= i27;
                }
                i28 = i5 & 16384;
                if (i28 != 0) {
                    i23 |= 24576;
                } else if ((i4 & 57344) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i29 = 16384;
                    } else {
                        i29 = 8192;
                    }
                    i23 |= i29;
                }
                i30 = i5 & 32768;
                if (i30 != 0) {
                    i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i31 = 131072;
                    } else {
                        i31 = 65536;
                    }
                    i23 |= i31;
                }
                if ((i39 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    } else {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue;
                    TextInputService textInputService4 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                    long jM966getBackgroundColor0d7_KjU4 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                    FocusManager focusManager4 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    if (i34 == 1) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Vertical;
                    }
                    orientation2 = orientation;
                    Modifier modifier7 = modifier2;
                    Object[] objArr4 = {orientation2};
                    Saver<TextFieldScrollerPosition, Object> saver4 = TextFieldScrollerPosition.Companion.getSaver();
                    i35 = i34;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(orientation2);
                    int i45 = i23;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldScrollerPosition textFieldScrollerPosition4 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr4, (Saver) saver4, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TransformedText transformedText4 = (TransformedText) objRememberedValue3;
                    text = transformedText4.getText();
                    offsetMapping = transformedText4.getOffsetMapping();
                    currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldState = (TextFieldState) objRememberedValue4;
                    textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager4, jM966getBackgroundColor0d7_KjU4);
                    textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new UndoManager(0, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    undoManager = (UndoManager) objRememberedValue5;
                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                    textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                    textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                    textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                    textFieldSelectionManager.setState$foundation_release(textFieldState);
                    textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                    textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                    textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                    textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                    textFieldSelectionManager.setFocusRequester(focusRequester);
                    textFieldSelectionManager.setEditable(!z6);
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller4 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller4);
                        objRememberedValue7 = compositionScopedCoroutineScopeCanceller4;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope4 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BringIntoViewRequester bringIntoViewRequester4 = (BringIntoViewRequester) objRememberedValue8;
                    companion2 = Modifier.Companion;
                    Modifier modifierTextFieldFocusModifier4 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService4, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope4, bringIntoViewRequester4));
                    composerStartRestartGroup.startReplaceableGroup(-55008291);
                    if (!z5) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (TouchMode_androidKt.isInTouchMode()) {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    } else {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    }
                    Modifier modifierDrawBehind4 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                    Modifier modifierOnGloballyPositioned7 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                    Modifier modifierSemantics4 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText4, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierCursor4 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                    EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                    EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService4, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i45 >> 3) & 14);
                    InterfaceC3750qp onValueChange4 = textFieldState.getOnValueChange();
                    boolean z19 = !z6;
                    if (i35 == 1) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                    Modifier modifierOnGloballyPositioned8 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier7.then(modifierTextFieldFocusModifier4), textFieldState, focusManager4), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange4, z19, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition4, mutableInteractionSource7, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics4), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                    if (!z5) {
                        z9 = false;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                    } else {
                        modifierTextFieldMagnifier = companion2;
                    }
                    boolean z110 = z5;
                    ImeOptions imeOptions7 = imeOptions2;
                    VisualTransformation visualTransformation6 = none;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldRootBox(modifierOnGloballyPositioned8, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i45, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition4, textFieldValue, none, modifierCursor4, modifierDrawBehind4, modifierOnGloballyPositioned7, modifierTextFieldMagnifier, bringIntoViewRequester4, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    textStyle3 = textStyle2;
                    interfaceC3750qp4 = interfaceC3750qp3;
                    z10 = z110;
                    brush3 = brush2;
                    z11 = z4;
                    i36 = i33;
                    keyboardActions3 = keyboardActions2;
                    z12 = z6;
                    interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                    imeOptions3 = imeOptions7;
                    i37 = i35;
                    mutableInteractionSource3 = mutableInteractionSource7;
                    visualTransformation2 = visualTransformation6;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    } else {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue;
                    TextInputService textInputService5 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                    long jM966getBackgroundColor0d7_KjU5 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                    FocusManager focusManager5 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    if (i34 == 1) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Vertical;
                    }
                    orientation2 = orientation;
                    Modifier modifier8 = modifier2;
                    Object[] objArr5 = {orientation2};
                    Saver<TextFieldScrollerPosition, Object> saver5 = TextFieldScrollerPosition.Companion.getSaver();
                    i35 = i34;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(orientation2);
                    int i46 = i23;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldScrollerPosition textFieldScrollerPosition5 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr5, (Saver) saver5, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TransformedText transformedText5 = (TransformedText) objRememberedValue3;
                    text = transformedText5.getText();
                    offsetMapping = transformedText5.getOffsetMapping();
                    currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldState = (TextFieldState) objRememberedValue4;
                    textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager5, jM966getBackgroundColor0d7_KjU5);
                    textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new UndoManager(0, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    undoManager = (UndoManager) objRememberedValue5;
                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                    textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                    textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                    textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                    textFieldSelectionManager.setState$foundation_release(textFieldState);
                    textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                    textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                    textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                    textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                    textFieldSelectionManager.setFocusRequester(focusRequester);
                    textFieldSelectionManager.setEditable(!z6);
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller5 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller5);
                        objRememberedValue7 = compositionScopedCoroutineScopeCanceller5;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope5 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BringIntoViewRequester bringIntoViewRequester5 = (BringIntoViewRequester) objRememberedValue8;
                    companion2 = Modifier.Companion;
                    Modifier modifierTextFieldFocusModifier5 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService5, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope5, bringIntoViewRequester5));
                    composerStartRestartGroup.startReplaceableGroup(-55008291);
                    if (!z5) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (TouchMode_androidKt.isInTouchMode()) {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    } else {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    }
                    Modifier modifierDrawBehind5 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                    Modifier modifierOnGloballyPositioned9 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                    Modifier modifierSemantics5 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText5, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierCursor5 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                    EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                    EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService5, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i46 >> 3) & 14);
                    InterfaceC3750qp onValueChange5 = textFieldState.getOnValueChange();
                    boolean z111 = !z6;
                    if (i35 == 1) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                    Modifier modifierOnGloballyPositioned10 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier8.then(modifierTextFieldFocusModifier5), textFieldState, focusManager5), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange5, z111, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition5, mutableInteractionSource8, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics5), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                    if (!z5) {
                        z9 = false;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                    } else {
                        modifierTextFieldMagnifier = companion2;
                    }
                    boolean z112 = z5;
                    ImeOptions imeOptions8 = imeOptions2;
                    VisualTransformation visualTransformation7 = none;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldRootBox(modifierOnGloballyPositioned10, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i46, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition5, textFieldValue, none, modifierCursor5, modifierDrawBehind5, modifierOnGloballyPositioned9, modifierTextFieldMagnifier, bringIntoViewRequester5, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier8;
                    textStyle3 = textStyle2;
                    interfaceC3750qp4 = interfaceC3750qp3;
                    z10 = z112;
                    brush3 = brush2;
                    z11 = z4;
                    i36 = i33;
                    keyboardActions3 = keyboardActions2;
                    z12 = z6;
                    interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                    imeOptions3 = imeOptions8;
                    i37 = i35;
                    mutableInteractionSource3 = mutableInteractionSource8;
                    visualTransformation2 = visualTransformation7;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(textFieldValue, interfaceC3750qp, modifier3, textStyle3, visualTransformation2, interfaceC3750qp4, mutableInteractionSource3, brush3, z11, i37, i36, imeOptions3, keyboardActions3, z10, z12, interfaceC0552Gp2, i3, i4, i5));
            }
            i20 = 805306368;
            i39 |= i20;
            i21 = i5 & 1024;
            if (i21 != 0) {
                i22 = i4 | 6;
            } else if ((i4 & 14) == 0) {
                i22 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
            } else {
                i22 = i4;
            }
            if ((i4 & 112) != 0) {
                if ((i5 & 2048) == 0) {
                    i38 = 16;
                } else {
                    i38 = 16;
                }
                i22 |= i38;
            }
            i23 = i22;
            i24 = i5 & 4096;
            if (i24 != 0) {
                i23 |= 384;
            } else if ((i4 & 896) != 0) {
                if (composerStartRestartGroup.changed(keyboardActions)) {
                    i25 = 256;
                } else {
                    i25 = 128;
                }
                i23 |= i25;
            }
            i26 = i5 & 8192;
            if (i26 != 0) {
                i23 |= 3072;
            } else if ((i4 & 7168) != 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i27 = 2048;
                } else {
                    i27 = 1024;
                }
                i23 |= i27;
            }
            i28 = i5 & 16384;
            if (i28 != 0) {
                i23 |= 24576;
            } else if ((i4 & 57344) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i29 = 16384;
                } else {
                    i29 = 8192;
                }
                i23 |= i29;
            }
            i30 = i5 & 32768;
            if (i30 != 0) {
                i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i31 = 131072;
                } else {
                    i31 = 65536;
                }
                i23 |= i31;
            }
            if ((i39 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                } else {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue;
                TextInputService textInputService6 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                long jM966getBackgroundColor0d7_KjU6 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                FocusManager focusManager6 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                if (i34 == 1) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Vertical;
                }
                orientation2 = orientation;
                Modifier modifier9 = modifier2;
                Object[] objArr6 = {orientation2};
                Saver<TextFieldScrollerPosition, Object> saver6 = TextFieldScrollerPosition.Companion.getSaver();
                i35 = i34;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(orientation2);
                int i47 = i23;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldScrollerPosition textFieldScrollerPosition6 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr6, (Saver) saver6, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TransformedText transformedText6 = (TransformedText) objRememberedValue3;
                text = transformedText6.getText();
                offsetMapping = transformedText6.getOffsetMapping();
                currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldState = (TextFieldState) objRememberedValue4;
                textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager6, jM966getBackgroundColor0d7_KjU6);
                textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new UndoManager(0, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                undoManager = (UndoManager) objRememberedValue5;
                UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                textFieldSelectionManager.setState$foundation_release(textFieldState);
                textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                textFieldSelectionManager.setFocusRequester(focusRequester);
                textFieldSelectionManager.setEditable(!z6);
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller6 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller6);
                    objRememberedValue7 = compositionScopedCoroutineScopeCanceller6;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope6 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BringIntoViewRequester bringIntoViewRequester6 = (BringIntoViewRequester) objRememberedValue8;
                companion2 = Modifier.Companion;
                Modifier modifierTextFieldFocusModifier6 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService6, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope6, bringIntoViewRequester6));
                composerStartRestartGroup.startReplaceableGroup(-55008291);
                if (!z5) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (TouchMode_androidKt.isInTouchMode()) {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                } else {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                }
                Modifier modifierDrawBehind6 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                Modifier modifierOnGloballyPositioned11 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                Modifier modifierSemantics6 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText6, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierCursor6 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService6, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i47 >> 3) & 14);
                InterfaceC3750qp onValueChange6 = textFieldState.getOnValueChange();
                boolean z113 = !z6;
                if (i35 == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
                Modifier modifierOnGloballyPositioned12 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier9.then(modifierTextFieldFocusModifier6), textFieldState, focusManager6), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange6, z113, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition6, mutableInteractionSource9, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics6), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                if (!z5) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                if (z9) {
                    modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                } else {
                    modifierTextFieldMagnifier = companion2;
                }
                boolean z114 = z5;
                ImeOptions imeOptions9 = imeOptions2;
                VisualTransformation visualTransformation8 = none;
                composer2 = composerStartRestartGroup;
                CoreTextFieldRootBox(modifierOnGloballyPositioned12, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i47, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition6, textFieldValue, none, modifierCursor6, modifierDrawBehind6, modifierOnGloballyPositioned11, modifierTextFieldMagnifier, bringIntoViewRequester6, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier9;
                textStyle3 = textStyle2;
                interfaceC3750qp4 = interfaceC3750qp3;
                z10 = z114;
                brush3 = brush2;
                z11 = z4;
                i36 = i33;
                keyboardActions3 = keyboardActions2;
                z12 = z6;
                interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                imeOptions3 = imeOptions9;
                i37 = i35;
                mutableInteractionSource3 = mutableInteractionSource9;
                visualTransformation2 = visualTransformation8;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                } else {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue;
                TextInputService textInputService7 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                long jM966getBackgroundColor0d7_KjU7 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                FocusManager focusManager7 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                if (i34 == 1) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Vertical;
                }
                orientation2 = orientation;
                Modifier modifier10 = modifier2;
                Object[] objArr7 = {orientation2};
                Saver<TextFieldScrollerPosition, Object> saver7 = TextFieldScrollerPosition.Companion.getSaver();
                i35 = i34;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(orientation2);
                int i48 = i23;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldScrollerPosition textFieldScrollerPosition7 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr7, (Saver) saver7, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TransformedText transformedText7 = (TransformedText) objRememberedValue3;
                text = transformedText7.getText();
                offsetMapping = transformedText7.getOffsetMapping();
                currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldState = (TextFieldState) objRememberedValue4;
                textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager7, jM966getBackgroundColor0d7_KjU7);
                textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new UndoManager(0, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                undoManager = (UndoManager) objRememberedValue5;
                UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                textFieldSelectionManager.setState$foundation_release(textFieldState);
                textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                textFieldSelectionManager.setFocusRequester(focusRequester);
                textFieldSelectionManager.setEditable(!z6);
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller7 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller7);
                    objRememberedValue7 = compositionScopedCoroutineScopeCanceller7;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope7 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BringIntoViewRequester bringIntoViewRequester7 = (BringIntoViewRequester) objRememberedValue8;
                companion2 = Modifier.Companion;
                Modifier modifierTextFieldFocusModifier7 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService7, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope7, bringIntoViewRequester7));
                composerStartRestartGroup.startReplaceableGroup(-55008291);
                if (!z5) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (TouchMode_androidKt.isInTouchMode()) {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                } else {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                }
                Modifier modifierDrawBehind7 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                Modifier modifierOnGloballyPositioned13 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                Modifier modifierSemantics7 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText7, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierCursor7 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService7, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i48 >> 3) & 14);
                InterfaceC3750qp onValueChange7 = textFieldState.getOnValueChange();
                boolean z115 = !z6;
                if (i35 == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
                Modifier modifierOnGloballyPositioned14 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier10.then(modifierTextFieldFocusModifier7), textFieldState, focusManager7), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange7, z115, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition7, mutableInteractionSource10, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics7), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                if (!z5) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                if (z9) {
                    modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                } else {
                    modifierTextFieldMagnifier = companion2;
                }
                boolean z116 = z5;
                ImeOptions imeOptions10 = imeOptions2;
                VisualTransformation visualTransformation9 = none;
                composer2 = composerStartRestartGroup;
                CoreTextFieldRootBox(modifierOnGloballyPositioned14, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i48, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition7, textFieldValue, none, modifierCursor7, modifierDrawBehind7, modifierOnGloballyPositioned13, modifierTextFieldMagnifier, bringIntoViewRequester7, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                textStyle3 = textStyle2;
                interfaceC3750qp4 = interfaceC3750qp3;
                z10 = z116;
                brush3 = brush2;
                z11 = z4;
                i36 = i33;
                keyboardActions3 = keyboardActions2;
                z12 = z6;
                interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                imeOptions3 = imeOptions10;
                i37 = i35;
                mutableInteractionSource3 = mutableInteractionSource10;
                visualTransformation2 = visualTransformation9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(textFieldValue, interfaceC3750qp, modifier3, textStyle3, visualTransformation2, interfaceC3750qp4, mutableInteractionSource3, brush3, z11, i37, i36, imeOptions3, keyboardActions3, z10, z12, interfaceC0552Gp2, i3, i4, i5));
        }
        i39 |= 384;
        i7 = i5 & 8;
        if (i7 != 0) {
            if ((i3 & 7168) == 0) {
                if (composerStartRestartGroup.changed(textStyle)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i39 |= i8;
            }
            i9 = i5 & 16;
            if (i9 != 0) {
                i39 |= 24576;
            } else if ((i3 & 57344) == 0) {
                if (composerStartRestartGroup.changed(visualTransformation)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i39 |= i10;
            }
            i11 = i5 & 32;
            if (i11 != 0) {
                i39 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i39 |= i12;
            }
            i13 = i5 & 64;
            if (i13 != 0) {
                i39 |= 1572864;
            } else if ((i3 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i39 |= i14;
            }
            i15 = i5 & 128;
            if (i15 != 0) {
                i39 |= 12582912;
            } else if ((i3 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(brush)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i39 |= i16;
            }
            i17 = i5 & 256;
            if (i17 != 0) {
                i39 |= 100663296;
            } else if ((i3 & 234881024) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i18 = 67108864;
                } else {
                    i18 = 33554432;
                }
                i39 |= i18;
            }
            i19 = i5 & 512;
            if (i19 != 0) {
                if ((i3 & 1879048192) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i20 = PropertyOptions.DELETE_EXISTING;
                    } else {
                        i20 = 268435456;
                    }
                }
                i21 = i5 & 1024;
                if (i21 != 0) {
                    i22 = i4 | 6;
                } else if ((i4 & 14) == 0) {
                    i22 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
                } else {
                    i22 = i4;
                }
                if ((i4 & 112) != 0) {
                    if ((i5 & 2048) == 0) {
                        i38 = 16;
                    } else {
                        i38 = 16;
                    }
                    i22 |= i38;
                }
                i23 = i22;
                i24 = i5 & 4096;
                if (i24 != 0) {
                    i23 |= 384;
                } else if ((i4 & 896) != 0) {
                    if (composerStartRestartGroup.changed(keyboardActions)) {
                        i25 = 256;
                    } else {
                        i25 = 128;
                    }
                    i23 |= i25;
                }
                i26 = i5 & 8192;
                if (i26 != 0) {
                    i23 |= 3072;
                } else if ((i4 & 7168) != 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i27 = 2048;
                    } else {
                        i27 = 1024;
                    }
                    i23 |= i27;
                }
                i28 = i5 & 16384;
                if (i28 != 0) {
                    i23 |= 24576;
                } else if ((i4 & 57344) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i29 = 16384;
                    } else {
                        i29 = 8192;
                    }
                    i23 |= i29;
                }
                i30 = i5 & 32768;
                if (i30 != 0) {
                    i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i4 & 458752) == 0) {
                    if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                        i31 = 131072;
                    } else {
                        i31 = 65536;
                    }
                    i23 |= i31;
                }
                if ((i39 & 1533916891) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    } else {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue;
                    TextInputService textInputService8 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                    long jM966getBackgroundColor0d7_KjU8 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                    FocusManager focusManager8 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    if (i34 == 1) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Vertical;
                    }
                    orientation2 = orientation;
                    Modifier modifier11 = modifier2;
                    Object[] objArr8 = {orientation2};
                    Saver<TextFieldScrollerPosition, Object> saver8 = TextFieldScrollerPosition.Companion.getSaver();
                    i35 = i34;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(orientation2);
                    int i49 = i23;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldScrollerPosition textFieldScrollerPosition8 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr8, (Saver) saver8, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TransformedText transformedText8 = (TransformedText) objRememberedValue3;
                    text = transformedText8.getText();
                    offsetMapping = transformedText8.getOffsetMapping();
                    currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldState = (TextFieldState) objRememberedValue4;
                    textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager8, jM966getBackgroundColor0d7_KjU8);
                    textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new UndoManager(0, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    undoManager = (UndoManager) objRememberedValue5;
                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                    textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                    textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                    textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                    textFieldSelectionManager.setState$foundation_release(textFieldState);
                    textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                    textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                    textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                    textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                    textFieldSelectionManager.setFocusRequester(focusRequester);
                    textFieldSelectionManager.setEditable(!z6);
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller8 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller8);
                        objRememberedValue7 = compositionScopedCoroutineScopeCanceller8;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope8 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BringIntoViewRequester bringIntoViewRequester8 = (BringIntoViewRequester) objRememberedValue8;
                    companion2 = Modifier.Companion;
                    Modifier modifierTextFieldFocusModifier8 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService8, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope8, bringIntoViewRequester8));
                    composerStartRestartGroup.startReplaceableGroup(-55008291);
                    if (!z5) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (TouchMode_androidKt.isInTouchMode()) {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    } else {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    }
                    Modifier modifierDrawBehind8 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                    Modifier modifierOnGloballyPositioned15 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                    Modifier modifierSemantics8 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText8, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierCursor8 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                    EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                    EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService8, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i49 >> 3) & 14);
                    InterfaceC3750qp onValueChange8 = textFieldState.getOnValueChange();
                    boolean z117 = !z6;
                    if (i35 == 1) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource2;
                    Modifier modifierOnGloballyPositioned16 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier11.then(modifierTextFieldFocusModifier8), textFieldState, focusManager8), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange8, z117, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition8, mutableInteractionSource11, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics8), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                    if (!z5) {
                        z9 = false;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                    } else {
                        modifierTextFieldMagnifier = companion2;
                    }
                    boolean z118 = z5;
                    ImeOptions imeOptions11 = imeOptions2;
                    VisualTransformation visualTransformation10 = none;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldRootBox(modifierOnGloballyPositioned16, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i49, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition8, textFieldValue, none, modifierCursor8, modifierDrawBehind8, modifierOnGloballyPositioned15, modifierTextFieldMagnifier, bringIntoViewRequester8, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11;
                    textStyle3 = textStyle2;
                    interfaceC3750qp4 = interfaceC3750qp3;
                    z10 = z118;
                    brush3 = brush2;
                    z11 = z4;
                    i36 = i33;
                    keyboardActions3 = keyboardActions2;
                    z12 = z6;
                    interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                    imeOptions3 = imeOptions11;
                    i37 = i35;
                    mutableInteractionSource3 = mutableInteractionSource11;
                    visualTransformation2 = visualTransformation10;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    } else {
                        if (i40 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i7 != 0) {
                            textStyle2 = TextStyle.Companion.getDefault();
                        } else {
                            textStyle2 = textStyle;
                        }
                        if (i9 != 0) {
                            none = VisualTransformation.Companion.getNone();
                        } else {
                            none = visualTransformation;
                        }
                        if (i11 != 0) {
                            interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        if (i15 != 0) {
                            solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                        } else {
                            solidColor = brush;
                        }
                        if (i17 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if (i19 != 0) {
                            i32 = Integer.MAX_VALUE;
                        } else {
                            i32 = i;
                        }
                        if (i21 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if ((2048 & i5) != 0) {
                            imeOptions2 = ImeOptions.Companion.getDefault();
                            i23 &= -113;
                        } else {
                            imeOptions2 = imeOptions;
                        }
                        if (i24 != 0) {
                            keyboardActions2 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions2 = keyboardActions;
                        }
                        if (i26 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i28 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i30 != 0) {
                            interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                        } else {
                            interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                        }
                        i34 = i32;
                        brush2 = solidColor;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue;
                    TextInputService textInputService9 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                    density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                    long jM966getBackgroundColor0d7_KjU9 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                    FocusManager focusManager9 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    if (i34 == 1) {
                        orientation = Orientation.Vertical;
                    } else {
                        orientation = Orientation.Vertical;
                    }
                    orientation2 = orientation;
                    Modifier modifier12 = modifier2;
                    Object[] objArr9 = {orientation2};
                    Saver<TextFieldScrollerPosition, Object> saver9 = TextFieldScrollerPosition.Companion.getSaver();
                    i35 = i34;
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(orientation2);
                    int i410 = i23;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldScrollerPosition textFieldScrollerPosition9 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr9, (Saver) saver9, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                    composerStartRestartGroup.startReplaceableGroup(511388516);
                    zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                        textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                        if (textRangeM4921getCompositionMzsxiRA != null) {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        } else {
                            objRememberedValue3 = transformedTextFilterWithValidation;
                        }
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TransformedText transformedText9 = (TransformedText) objRememberedValue3;
                    text = transformedText9.getText();
                    offsetMapping = transformedText9.getOffsetMapping();
                    currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldState = (TextFieldState) objRememberedValue4;
                    textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager9, jM966getBackgroundColor0d7_KjU9);
                    textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = new UndoManager(0, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    undoManager = (UndoManager) objRememberedValue5;
                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == companion.getEmpty()) {
                        objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                    textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                    textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                    textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                    textFieldSelectionManager.setState$foundation_release(textFieldState);
                    textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                    textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                    textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                    textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                    textFieldSelectionManager.setFocusRequester(focusRequester);
                    textFieldSelectionManager.setEditable(!z6);
                    composerStartRestartGroup.startReplaceableGroup(773894976);
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == companion.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller9 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller9);
                        objRememberedValue7 = compositionScopedCoroutineScopeCanceller9;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    InterfaceC2052dg coroutineScope9 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue8 == companion.getEmpty()) {
                        objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    BringIntoViewRequester bringIntoViewRequester9 = (BringIntoViewRequester) objRememberedValue8;
                    companion2 = Modifier.Companion;
                    Modifier modifierTextFieldFocusModifier9 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService9, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope9, bringIntoViewRequester9));
                    composerStartRestartGroup.startReplaceableGroup(-55008291);
                    if (!z5) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    if (TouchMode_androidKt.isInTouchMode()) {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    } else {
                        modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    }
                    Modifier modifierDrawBehind9 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                    Modifier modifierOnGloballyPositioned17 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                    Modifier modifierSemantics9 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText9, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                    if (z5) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierCursor9 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                    EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                    EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService9, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i410 >> 3) & 14);
                    InterfaceC3750qp onValueChange9 = textFieldState.getOnValueChange();
                    boolean z119 = !z6;
                    if (i35 == 1) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource2;
                    Modifier modifierOnGloballyPositioned18 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier12.then(modifierTextFieldFocusModifier9), textFieldState, focusManager9), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange9, z119, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition9, mutableInteractionSource12, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics9), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                    if (!z5) {
                        z9 = false;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                    } else {
                        modifierTextFieldMagnifier = companion2;
                    }
                    boolean z1110 = z5;
                    ImeOptions imeOptions12 = imeOptions2;
                    VisualTransformation visualTransformation11 = none;
                    composer2 = composerStartRestartGroup;
                    CoreTextFieldRootBox(modifierOnGloballyPositioned18, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i410, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition9, textFieldValue, none, modifierCursor9, modifierDrawBehind9, modifierOnGloballyPositioned17, modifierTextFieldMagnifier, bringIntoViewRequester9, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier12;
                    textStyle3 = textStyle2;
                    interfaceC3750qp4 = interfaceC3750qp3;
                    z10 = z1110;
                    brush3 = brush2;
                    z11 = z4;
                    i36 = i33;
                    keyboardActions3 = keyboardActions2;
                    z12 = z6;
                    interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                    imeOptions3 = imeOptions12;
                    i37 = i35;
                    mutableInteractionSource3 = mutableInteractionSource12;
                    visualTransformation2 = visualTransformation11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(textFieldValue, interfaceC3750qp, modifier3, textStyle3, visualTransformation2, interfaceC3750qp4, mutableInteractionSource3, brush3, z11, i37, i36, imeOptions3, keyboardActions3, z10, z12, interfaceC0552Gp2, i3, i4, i5));
            }
            i20 = 805306368;
            i39 |= i20;
            i21 = i5 & 1024;
            if (i21 != 0) {
                i22 = i4 | 6;
            } else if ((i4 & 14) == 0) {
                i22 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
            } else {
                i22 = i4;
            }
            if ((i4 & 112) != 0) {
                if ((i5 & 2048) == 0) {
                    i38 = 16;
                } else {
                    i38 = 16;
                }
                i22 |= i38;
            }
            i23 = i22;
            i24 = i5 & 4096;
            if (i24 != 0) {
                i23 |= 384;
            } else if ((i4 & 896) != 0) {
                if (composerStartRestartGroup.changed(keyboardActions)) {
                    i25 = 256;
                } else {
                    i25 = 128;
                }
                i23 |= i25;
            }
            i26 = i5 & 8192;
            if (i26 != 0) {
                i23 |= 3072;
            } else if ((i4 & 7168) != 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i27 = 2048;
                } else {
                    i27 = 1024;
                }
                i23 |= i27;
            }
            i28 = i5 & 16384;
            if (i28 != 0) {
                i23 |= 24576;
            } else if ((i4 & 57344) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i29 = 16384;
                } else {
                    i29 = 8192;
                }
                i23 |= i29;
            }
            i30 = i5 & 32768;
            if (i30 != 0) {
                i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i31 = 131072;
                } else {
                    i31 = 65536;
                }
                i23 |= i31;
            }
            if ((i39 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                } else {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue;
                TextInputService textInputService10 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                long jM966getBackgroundColor0d7_KjU10 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                FocusManager focusManager10 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                if (i34 == 1) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Vertical;
                }
                orientation2 = orientation;
                Modifier modifier13 = modifier2;
                Object[] objArr10 = {orientation2};
                Saver<TextFieldScrollerPosition, Object> saver10 = TextFieldScrollerPosition.Companion.getSaver();
                i35 = i34;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(orientation2);
                int i411 = i23;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldScrollerPosition textFieldScrollerPosition10 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr10, (Saver) saver10, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TransformedText transformedText10 = (TransformedText) objRememberedValue3;
                text = transformedText10.getText();
                offsetMapping = transformedText10.getOffsetMapping();
                currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldState = (TextFieldState) objRememberedValue4;
                textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager10, jM966getBackgroundColor0d7_KjU10);
                textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new UndoManager(0, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                undoManager = (UndoManager) objRememberedValue5;
                UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                textFieldSelectionManager.setState$foundation_release(textFieldState);
                textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                textFieldSelectionManager.setFocusRequester(focusRequester);
                textFieldSelectionManager.setEditable(!z6);
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller10 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller10);
                    objRememberedValue7 = compositionScopedCoroutineScopeCanceller10;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope10 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BringIntoViewRequester bringIntoViewRequester10 = (BringIntoViewRequester) objRememberedValue8;
                companion2 = Modifier.Companion;
                Modifier modifierTextFieldFocusModifier10 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService10, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope10, bringIntoViewRequester10));
                composerStartRestartGroup.startReplaceableGroup(-55008291);
                if (!z5) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (TouchMode_androidKt.isInTouchMode()) {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                } else {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                }
                Modifier modifierDrawBehind10 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                Modifier modifierOnGloballyPositioned19 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                Modifier modifierSemantics10 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText10, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierCursor10 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService10, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i411 >> 3) & 14);
                InterfaceC3750qp onValueChange10 = textFieldState.getOnValueChange();
                boolean z1111 = !z6;
                if (i35 == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource2;
                Modifier modifierOnGloballyPositioned110 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier13.then(modifierTextFieldFocusModifier10), textFieldState, focusManager10), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange10, z1111, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition10, mutableInteractionSource13, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics10), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                if (!z5) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                if (z9) {
                    modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                } else {
                    modifierTextFieldMagnifier = companion2;
                }
                boolean z1112 = z5;
                ImeOptions imeOptions13 = imeOptions2;
                VisualTransformation visualTransformation12 = none;
                composer2 = composerStartRestartGroup;
                CoreTextFieldRootBox(modifierOnGloballyPositioned110, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i411, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition10, textFieldValue, none, modifierCursor10, modifierDrawBehind10, modifierOnGloballyPositioned19, modifierTextFieldMagnifier, bringIntoViewRequester10, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier13;
                textStyle3 = textStyle2;
                interfaceC3750qp4 = interfaceC3750qp3;
                z10 = z1112;
                brush3 = brush2;
                z11 = z4;
                i36 = i33;
                keyboardActions3 = keyboardActions2;
                z12 = z6;
                interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                imeOptions3 = imeOptions13;
                i37 = i35;
                mutableInteractionSource3 = mutableInteractionSource13;
                visualTransformation2 = visualTransformation12;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                } else {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue;
                TextInputService textInputService11 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                long jM966getBackgroundColor0d7_KjU11 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                FocusManager focusManager11 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                if (i34 == 1) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Vertical;
                }
                orientation2 = orientation;
                Modifier modifier14 = modifier2;
                Object[] objArr11 = {orientation2};
                Saver<TextFieldScrollerPosition, Object> saver11 = TextFieldScrollerPosition.Companion.getSaver();
                i35 = i34;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(orientation2);
                int i412 = i23;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldScrollerPosition textFieldScrollerPosition11 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr11, (Saver) saver11, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TransformedText transformedText11 = (TransformedText) objRememberedValue3;
                text = transformedText11.getText();
                offsetMapping = transformedText11.getOffsetMapping();
                currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldState = (TextFieldState) objRememberedValue4;
                textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager11, jM966getBackgroundColor0d7_KjU11);
                textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new UndoManager(0, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                undoManager = (UndoManager) objRememberedValue5;
                UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                textFieldSelectionManager.setState$foundation_release(textFieldState);
                textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                textFieldSelectionManager.setFocusRequester(focusRequester);
                textFieldSelectionManager.setEditable(!z6);
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller11 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller11);
                    objRememberedValue7 = compositionScopedCoroutineScopeCanceller11;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope11 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BringIntoViewRequester bringIntoViewRequester11 = (BringIntoViewRequester) objRememberedValue8;
                companion2 = Modifier.Companion;
                Modifier modifierTextFieldFocusModifier11 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService11, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope11, bringIntoViewRequester11));
                composerStartRestartGroup.startReplaceableGroup(-55008291);
                if (!z5) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (TouchMode_androidKt.isInTouchMode()) {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                } else {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                }
                Modifier modifierDrawBehind11 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                Modifier modifierOnGloballyPositioned111 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                Modifier modifierSemantics11 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText11, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierCursor11 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService11, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i412 >> 3) & 14);
                InterfaceC3750qp onValueChange11 = textFieldState.getOnValueChange();
                boolean z1113 = !z6;
                if (i35 == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource2;
                Modifier modifierOnGloballyPositioned112 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier14.then(modifierTextFieldFocusModifier11), textFieldState, focusManager11), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange11, z1113, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition11, mutableInteractionSource14, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics11), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                if (!z5) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                if (z9) {
                    modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                } else {
                    modifierTextFieldMagnifier = companion2;
                }
                boolean z1114 = z5;
                ImeOptions imeOptions14 = imeOptions2;
                VisualTransformation visualTransformation13 = none;
                composer2 = composerStartRestartGroup;
                CoreTextFieldRootBox(modifierOnGloballyPositioned112, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i412, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition11, textFieldValue, none, modifierCursor11, modifierDrawBehind11, modifierOnGloballyPositioned111, modifierTextFieldMagnifier, bringIntoViewRequester11, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier14;
                textStyle3 = textStyle2;
                interfaceC3750qp4 = interfaceC3750qp3;
                z10 = z1114;
                brush3 = brush2;
                z11 = z4;
                i36 = i33;
                keyboardActions3 = keyboardActions2;
                z12 = z6;
                interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                imeOptions3 = imeOptions14;
                i37 = i35;
                mutableInteractionSource3 = mutableInteractionSource14;
                visualTransformation2 = visualTransformation13;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(textFieldValue, interfaceC3750qp, modifier3, textStyle3, visualTransformation2, interfaceC3750qp4, mutableInteractionSource3, brush3, z11, i37, i36, imeOptions3, keyboardActions3, z10, z12, interfaceC0552Gp2, i3, i4, i5));
        }
        i39 |= 3072;
        i9 = i5 & 16;
        if (i9 != 0) {
            i39 |= 24576;
        } else if ((i3 & 57344) == 0) {
            if (composerStartRestartGroup.changed(visualTransformation)) {
                i10 = 16384;
            } else {
                i10 = 8192;
            }
            i39 |= i10;
        }
        i11 = i5 & 32;
        if (i11 != 0) {
            i39 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & 458752) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                i12 = 131072;
            } else {
                i12 = 65536;
            }
            i39 |= i12;
        }
        i13 = i5 & 64;
        if (i13 != 0) {
            i39 |= 1572864;
        } else if ((i3 & 3670016) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i14 = 1048576;
            } else {
                i14 = 524288;
            }
            i39 |= i14;
        }
        i15 = i5 & 128;
        if (i15 != 0) {
            i39 |= 12582912;
        } else if ((i3 & 29360128) == 0) {
            if (composerStartRestartGroup.changed(brush)) {
                i16 = 8388608;
            } else {
                i16 = 4194304;
            }
            i39 |= i16;
        }
        i17 = i5 & 256;
        if (i17 != 0) {
            i39 |= 100663296;
        } else if ((i3 & 234881024) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i18 = 67108864;
            } else {
                i18 = 33554432;
            }
            i39 |= i18;
        }
        i19 = i5 & 512;
        if (i19 != 0) {
            if ((i3 & 1879048192) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i20 = PropertyOptions.DELETE_EXISTING;
                } else {
                    i20 = 268435456;
                }
            }
            i21 = i5 & 1024;
            if (i21 != 0) {
                i22 = i4 | 6;
            } else if ((i4 & 14) == 0) {
                i22 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
            } else {
                i22 = i4;
            }
            if ((i4 & 112) != 0) {
                if ((i5 & 2048) == 0) {
                    i38 = 16;
                } else {
                    i38 = 16;
                }
                i22 |= i38;
            }
            i23 = i22;
            i24 = i5 & 4096;
            if (i24 != 0) {
                i23 |= 384;
            } else if ((i4 & 896) != 0) {
                if (composerStartRestartGroup.changed(keyboardActions)) {
                    i25 = 256;
                } else {
                    i25 = 128;
                }
                i23 |= i25;
            }
            i26 = i5 & 8192;
            if (i26 != 0) {
                i23 |= 3072;
            } else if ((i4 & 7168) != 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i27 = 2048;
                } else {
                    i27 = 1024;
                }
                i23 |= i27;
            }
            i28 = i5 & 16384;
            if (i28 != 0) {
                i23 |= 24576;
            } else if ((i4 & 57344) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i29 = 16384;
                } else {
                    i29 = 8192;
                }
                i23 |= i29;
            }
            i30 = i5 & 32768;
            if (i30 != 0) {
                i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i4 & 458752) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                    i31 = 131072;
                } else {
                    i31 = 65536;
                }
                i23 |= i31;
            }
            if ((i39 & 1533916891) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                } else {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue;
                TextInputService textInputService12 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                long jM966getBackgroundColor0d7_KjU12 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                FocusManager focusManager12 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                if (i34 == 1) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Vertical;
                }
                orientation2 = orientation;
                Modifier modifier15 = modifier2;
                Object[] objArr12 = {orientation2};
                Saver<TextFieldScrollerPosition, Object> saver12 = TextFieldScrollerPosition.Companion.getSaver();
                i35 = i34;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(orientation2);
                int i413 = i23;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldScrollerPosition textFieldScrollerPosition12 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr12, (Saver) saver12, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TransformedText transformedText12 = (TransformedText) objRememberedValue3;
                text = transformedText12.getText();
                offsetMapping = transformedText12.getOffsetMapping();
                currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldState = (TextFieldState) objRememberedValue4;
                textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager12, jM966getBackgroundColor0d7_KjU12);
                textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new UndoManager(0, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                undoManager = (UndoManager) objRememberedValue5;
                UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                textFieldSelectionManager.setState$foundation_release(textFieldState);
                textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                textFieldSelectionManager.setFocusRequester(focusRequester);
                textFieldSelectionManager.setEditable(!z6);
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller12 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller12);
                    objRememberedValue7 = compositionScopedCoroutineScopeCanceller12;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope12 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BringIntoViewRequester bringIntoViewRequester12 = (BringIntoViewRequester) objRememberedValue8;
                companion2 = Modifier.Companion;
                Modifier modifierTextFieldFocusModifier12 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService12, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope12, bringIntoViewRequester12));
                composerStartRestartGroup.startReplaceableGroup(-55008291);
                if (!z5) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (TouchMode_androidKt.isInTouchMode()) {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                } else {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                }
                Modifier modifierDrawBehind12 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                Modifier modifierOnGloballyPositioned113 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                Modifier modifierSemantics12 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText12, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierCursor12 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService12, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i413 >> 3) & 14);
                InterfaceC3750qp onValueChange12 = textFieldState.getOnValueChange();
                boolean z1115 = !z6;
                if (i35 == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource2;
                Modifier modifierOnGloballyPositioned114 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier15.then(modifierTextFieldFocusModifier12), textFieldState, focusManager12), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange12, z1115, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition12, mutableInteractionSource15, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics12), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                if (!z5) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                if (z9) {
                    modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                } else {
                    modifierTextFieldMagnifier = companion2;
                }
                boolean z1116 = z5;
                ImeOptions imeOptions15 = imeOptions2;
                VisualTransformation visualTransformation14 = none;
                composer2 = composerStartRestartGroup;
                CoreTextFieldRootBox(modifierOnGloballyPositioned114, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i413, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition12, textFieldValue, none, modifierCursor12, modifierDrawBehind12, modifierOnGloballyPositioned113, modifierTextFieldMagnifier, bringIntoViewRequester12, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier15;
                textStyle3 = textStyle2;
                interfaceC3750qp4 = interfaceC3750qp3;
                z10 = z1116;
                brush3 = brush2;
                z11 = z4;
                i36 = i33;
                keyboardActions3 = keyboardActions2;
                z12 = z6;
                interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                imeOptions3 = imeOptions15;
                i37 = i35;
                mutableInteractionSource3 = mutableInteractionSource15;
                visualTransformation2 = visualTransformation14;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                } else {
                    if (i40 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i7 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = textStyle;
                    }
                    if (i9 != 0) {
                        none = VisualTransformation.Companion.getNone();
                    } else {
                        none = visualTransformation;
                    }
                    if (i11 != 0) {
                        interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource2 = null;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    if (i15 != 0) {
                        solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                    } else {
                        solidColor = brush;
                    }
                    if (i17 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if (i19 != 0) {
                        i32 = Integer.MAX_VALUE;
                    } else {
                        i32 = i;
                    }
                    if (i21 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if ((2048 & i5) != 0) {
                        imeOptions2 = ImeOptions.Companion.getDefault();
                        i23 &= -113;
                    } else {
                        imeOptions2 = imeOptions;
                    }
                    if (i24 != 0) {
                        keyboardActions2 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions2 = keyboardActions;
                    }
                    if (i26 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i28 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i30 != 0) {
                        interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                    } else {
                        interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                    }
                    i34 = i32;
                    brush2 = solidColor;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue;
                TextInputService textInputService13 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                long jM966getBackgroundColor0d7_KjU13 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
                FocusManager focusManager13 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                if (i34 == 1) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Vertical;
                }
                orientation2 = orientation;
                Modifier modifier16 = modifier2;
                Object[] objArr13 = {orientation2};
                Saver<TextFieldScrollerPosition, Object> saver13 = TextFieldScrollerPosition.Companion.getSaver();
                i35 = i34;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(orientation2);
                int i414 = i23;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TextFieldScrollerPosition textFieldScrollerPosition13 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr13, (Saver) saver13, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
                composerStartRestartGroup.startReplaceableGroup(511388516);
                zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                    textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                    if (textRangeM4921getCompositionMzsxiRA != null) {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    } else {
                        objRememberedValue3 = transformedTextFilterWithValidation;
                    }
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                TransformedText transformedText13 = (TransformedText) objRememberedValue3;
                text = transformedText13.getText();
                offsetMapping = transformedText13.getOffsetMapping();
                currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldState = (TextFieldState) objRememberedValue4;
                textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager13, jM966getBackgroundColor0d7_KjU13);
                textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = new UndoManager(0, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceableGroup();
                undoManager = (UndoManager) objRememberedValue5;
                UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == companion.getEmpty()) {
                    objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceableGroup();
                textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
                textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                textFieldSelectionManager.setVisualTransformation$foundation_release(none);
                textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
                textFieldSelectionManager.setState$foundation_release(textFieldState);
                textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                textFieldSelectionManager.setFocusRequester(focusRequester);
                textFieldSelectionManager.setEditable(!z6);
                composerStartRestartGroup.startReplaceableGroup(773894976);
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller13 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                    composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller13);
                    objRememberedValue7 = compositionScopedCoroutineScopeCanceller13;
                }
                composerStartRestartGroup.endReplaceableGroup();
                InterfaceC2052dg coroutineScope13 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == companion.getEmpty()) {
                    objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                composerStartRestartGroup.endReplaceableGroup();
                BringIntoViewRequester bringIntoViewRequester13 = (BringIntoViewRequester) objRememberedValue8;
                companion2 = Modifier.Companion;
                Modifier modifierTextFieldFocusModifier13 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService13, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope13, bringIntoViewRequester13));
                composerStartRestartGroup.startReplaceableGroup(-55008291);
                if (!z5) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                if (TouchMode_androidKt.isInTouchMode()) {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                } else {
                    modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                }
                Modifier modifierDrawBehind13 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
                Modifier modifierOnGloballyPositioned115 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
                Modifier modifierSemantics13 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText13, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
                if (z5) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                Modifier modifierCursor13 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
                EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
                EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService13, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i414 >> 3) & 14);
                InterfaceC3750qp onValueChange13 = textFieldState.getOnValueChange();
                boolean z1117 = !z6;
                if (i35 == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource2;
                Modifier modifierOnGloballyPositioned116 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier16.then(modifierTextFieldFocusModifier13), textFieldState, focusManager13), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange13, z1117, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition13, mutableInteractionSource16, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics13), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
                if (!z5) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                if (z9) {
                    modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
                } else {
                    modifierTextFieldMagnifier = companion2;
                }
                boolean z1118 = z5;
                ImeOptions imeOptions16 = imeOptions2;
                VisualTransformation visualTransformation15 = none;
                composer2 = composerStartRestartGroup;
                CoreTextFieldRootBox(modifierOnGloballyPositioned116, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i414, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition13, textFieldValue, none, modifierCursor13, modifierDrawBehind13, modifierOnGloballyPositioned115, modifierTextFieldMagnifier, bringIntoViewRequester13, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier16;
                textStyle3 = textStyle2;
                interfaceC3750qp4 = interfaceC3750qp3;
                z10 = z1118;
                brush3 = brush2;
                z11 = z4;
                i36 = i33;
                keyboardActions3 = keyboardActions2;
                z12 = z6;
                interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
                imeOptions3 = imeOptions16;
                i37 = i35;
                mutableInteractionSource3 = mutableInteractionSource16;
                visualTransformation2 = visualTransformation15;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(textFieldValue, interfaceC3750qp, modifier3, textStyle3, visualTransformation2, interfaceC3750qp4, mutableInteractionSource3, brush3, z11, i37, i36, imeOptions3, keyboardActions3, z10, z12, interfaceC0552Gp2, i3, i4, i5));
        }
        i20 = 805306368;
        i39 |= i20;
        i21 = i5 & 1024;
        if (i21 != 0) {
            i22 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i22 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
        } else {
            i22 = i4;
        }
        if ((i4 & 112) != 0) {
            if ((i5 & 2048) == 0) {
                i38 = 16;
            } else {
                i38 = 16;
            }
            i22 |= i38;
        }
        i23 = i22;
        i24 = i5 & 4096;
        if (i24 != 0) {
            i23 |= 384;
        } else if ((i4 & 896) != 0) {
            if (composerStartRestartGroup.changed(keyboardActions)) {
                i25 = 256;
            } else {
                i25 = 128;
            }
            i23 |= i25;
        }
        i26 = i5 & 8192;
        if (i26 != 0) {
            i23 |= 3072;
        } else if ((i4 & 7168) != 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i27 = 2048;
            } else {
                i27 = 1024;
            }
            i23 |= i27;
        }
        i28 = i5 & 16384;
        if (i28 != 0) {
            i23 |= 24576;
        } else if ((i4 & 57344) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i29 = 16384;
            } else {
                i29 = 8192;
            }
            i23 |= i29;
        }
        i30 = i5 & 32768;
        if (i30 != 0) {
            i23 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i4 & 458752) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0552Gp)) {
                i31 = 131072;
            } else {
                i31 = 65536;
            }
            i23 |= i31;
        }
        if ((i39 & 1533916891) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
                if (i40 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i7 != 0) {
                    textStyle2 = TextStyle.Companion.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i9 != 0) {
                    none = VisualTransformation.Companion.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i11 != 0) {
                    interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (i13 != 0) {
                    mutableInteractionSource2 = null;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if (i15 != 0) {
                    solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                } else {
                    solidColor = brush;
                }
                if (i17 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i19 != 0) {
                    i32 = Integer.MAX_VALUE;
                } else {
                    i32 = i;
                }
                if (i21 != 0) {
                    i33 = 1;
                } else {
                    i33 = i2;
                }
                if ((2048 & i5) != 0) {
                    imeOptions2 = ImeOptions.Companion.getDefault();
                    i23 &= -113;
                } else {
                    imeOptions2 = imeOptions;
                }
                if (i24 != 0) {
                    keyboardActions2 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i26 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i28 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i30 != 0) {
                    interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                } else {
                    interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                }
                i34 = i32;
                brush2 = solidColor;
            } else {
                if (i40 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i7 != 0) {
                    textStyle2 = TextStyle.Companion.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i9 != 0) {
                    none = VisualTransformation.Companion.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i11 != 0) {
                    interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (i13 != 0) {
                    mutableInteractionSource2 = null;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if (i15 != 0) {
                    solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                } else {
                    solidColor = brush;
                }
                if (i17 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i19 != 0) {
                    i32 = Integer.MAX_VALUE;
                } else {
                    i32 = i;
                }
                if (i21 != 0) {
                    i33 = 1;
                } else {
                    i33 = i2;
                }
                if ((2048 & i5) != 0) {
                    imeOptions2 = ImeOptions.Companion.getDefault();
                    i23 &= -113;
                } else {
                    imeOptions2 = imeOptions;
                }
                if (i24 != 0) {
                    keyboardActions2 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i26 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i28 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i30 != 0) {
                    interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                } else {
                    interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                }
                i34 = i32;
                brush2 = solidColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            focusRequester = (FocusRequester) objRememberedValue;
            TextInputService textInputService14 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
            long jM966getBackgroundColor0d7_KjU14 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
            FocusManager focusManager14 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            if (i34 == 1) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Vertical;
            }
            orientation2 = orientation;
            Modifier modifier17 = modifier2;
            Object[] objArr14 = {orientation2};
            Saver<TextFieldScrollerPosition, Object> saver14 = TextFieldScrollerPosition.Companion.getSaver();
            i35 = i34;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(orientation2);
            int i415 = i23;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldScrollerPosition textFieldScrollerPosition14 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr14, (Saver) saver14, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                if (textRangeM4921getCompositionMzsxiRA != null) {
                    objRememberedValue3 = transformedTextFilterWithValidation;
                } else {
                    objRememberedValue3 = transformedTextFilterWithValidation;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                if (textRangeM4921getCompositionMzsxiRA != null) {
                    objRememberedValue3 = transformedTextFilterWithValidation;
                } else {
                    objRememberedValue3 = transformedTextFilterWithValidation;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TransformedText transformedText14 = (TransformedText) objRememberedValue3;
            text = transformedText14.getText();
            offsetMapping = transformedText14.getOffsetMapping();
            currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            textFieldState = (TextFieldState) objRememberedValue4;
            textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager14, jM966getBackgroundColor0d7_KjU14);
            textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new UndoManager(0, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceableGroup();
            undoManager = (UndoManager) objRememberedValue5;
            UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
            textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
            textFieldSelectionManager.setVisualTransformation$foundation_release(none);
            textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
            textFieldSelectionManager.setState$foundation_release(textFieldState);
            textFieldSelectionManager.setValue$foundation_release(textFieldValue);
            textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
            textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
            textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
            textFieldSelectionManager.setFocusRequester(focusRequester);
            textFieldSelectionManager.setEditable(!z6);
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller14 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller14);
                objRememberedValue7 = compositionScopedCoroutineScopeCanceller14;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope14 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            composerStartRestartGroup.endReplaceableGroup();
            BringIntoViewRequester bringIntoViewRequester14 = (BringIntoViewRequester) objRememberedValue8;
            companion2 = Modifier.Companion;
            Modifier modifierTextFieldFocusModifier14 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService14, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope14, bringIntoViewRequester14));
            composerStartRestartGroup.startReplaceableGroup(-55008291);
            if (!z5) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (TouchMode_androidKt.isInTouchMode()) {
                modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
            } else {
                modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
            }
            Modifier modifierDrawBehind14 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
            Modifier modifierOnGloballyPositioned117 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
            Modifier modifierSemantics14 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText14, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
            if (z5) {
                z7 = false;
            } else {
                z7 = false;
            }
            Modifier modifierCursor14 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
            EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
            EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService14, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i415 >> 3) & 14);
            InterfaceC3750qp onValueChange14 = textFieldState.getOnValueChange();
            boolean z1119 = !z6;
            if (i35 == 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource2;
            Modifier modifierOnGloballyPositioned118 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier17.then(modifierTextFieldFocusModifier14), textFieldState, focusManager14), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange14, z1119, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition14, mutableInteractionSource17, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics14), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
            if (!z5) {
                z9 = false;
            } else {
                z9 = false;
            }
            if (z9) {
                modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
            } else {
                modifierTextFieldMagnifier = companion2;
            }
            boolean z11110 = z5;
            ImeOptions imeOptions17 = imeOptions2;
            VisualTransformation visualTransformation16 = none;
            composer2 = composerStartRestartGroup;
            CoreTextFieldRootBox(modifierOnGloballyPositioned118, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i415, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition14, textFieldValue, none, modifierCursor14, modifierDrawBehind14, modifierOnGloballyPositioned117, modifierTextFieldMagnifier, bringIntoViewRequester14, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier17;
            textStyle3 = textStyle2;
            interfaceC3750qp4 = interfaceC3750qp3;
            z10 = z11110;
            brush3 = brush2;
            z11 = z4;
            i36 = i33;
            keyboardActions3 = keyboardActions2;
            z12 = z6;
            interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
            imeOptions3 = imeOptions17;
            i37 = i35;
            mutableInteractionSource3 = mutableInteractionSource17;
            visualTransformation2 = visualTransformation16;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
                if (i40 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i7 != 0) {
                    textStyle2 = TextStyle.Companion.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i9 != 0) {
                    none = VisualTransformation.Companion.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i11 != 0) {
                    interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (i13 != 0) {
                    mutableInteractionSource2 = null;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if (i15 != 0) {
                    solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                } else {
                    solidColor = brush;
                }
                if (i17 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i19 != 0) {
                    i32 = Integer.MAX_VALUE;
                } else {
                    i32 = i;
                }
                if (i21 != 0) {
                    i33 = 1;
                } else {
                    i33 = i2;
                }
                if ((2048 & i5) != 0) {
                    imeOptions2 = ImeOptions.Companion.getDefault();
                    i23 &= -113;
                } else {
                    imeOptions2 = imeOptions;
                }
                if (i24 != 0) {
                    keyboardActions2 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i26 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i28 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i30 != 0) {
                    interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                } else {
                    interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                }
                i34 = i32;
                brush2 = solidColor;
            } else {
                if (i40 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i7 != 0) {
                    textStyle2 = TextStyle.Companion.getDefault();
                } else {
                    textStyle2 = textStyle;
                }
                if (i9 != 0) {
                    none = VisualTransformation.Companion.getNone();
                } else {
                    none = visualTransformation;
                }
                if (i11 != 0) {
                    interfaceC3750qp3 = AnonymousClass1.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (i13 != 0) {
                    mutableInteractionSource2 = null;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                if (i15 != 0) {
                    solidColor = new SolidColor(Color.Companion.m3068getUnspecified0d7_KjU(), null);
                } else {
                    solidColor = brush;
                }
                if (i17 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if (i19 != 0) {
                    i32 = Integer.MAX_VALUE;
                } else {
                    i32 = i;
                }
                if (i21 != 0) {
                    i33 = 1;
                } else {
                    i33 = i2;
                }
                if ((2048 & i5) != 0) {
                    imeOptions2 = ImeOptions.Companion.getDefault();
                    i23 &= -113;
                } else {
                    imeOptions2 = imeOptions;
                }
                if (i24 != 0) {
                    keyboardActions2 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions2 = keyboardActions;
                }
                if (i26 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i28 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i30 != 0) {
                    interfaceC0552GpM759getLambda1$foundation_release = ComposableSingletons$CoreTextFieldKt.INSTANCE.m759getLambda1$foundation_release();
                } else {
                    interfaceC0552GpM759getLambda1$foundation_release = interfaceC0552Gp;
                }
                i34 = i32;
                brush2 = solidColor;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-958708118, i39, i23, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:183)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            focusRequester = (FocusRequester) objRememberedValue;
            TextInputService textInputService15 = (TextInputService) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextInputService());
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            resolver = (FontFamily.Resolver) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
            long jM966getBackgroundColor0d7_KjU15 = ((TextSelectionColors) composerStartRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).m966getBackgroundColor0d7_KjU();
            FocusManager focusManager15 = (FocusManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            if (i34 == 1) {
                orientation = Orientation.Vertical;
            } else {
                orientation = Orientation.Vertical;
            }
            orientation2 = orientation;
            Modifier modifier18 = modifier2;
            Object[] objArr15 = {orientation2};
            Saver<TextFieldScrollerPosition, Object> saver15 = TextFieldScrollerPosition.Companion.getSaver();
            i35 = i34;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(orientation2);
            int i416 = i23;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(orientation2);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldScrollerPosition textFieldScrollerPosition15 = (TextFieldScrollerPosition) RememberSaveableKt.m2674rememberSaveable(objArr15, (Saver) saver15, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            zChanged2 = composerStartRestartGroup.changed(textFieldValue) | composerStartRestartGroup.changed(none);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                if (textRangeM4921getCompositionMzsxiRA != null) {
                    objRememberedValue3 = transformedTextFilterWithValidation;
                } else {
                    objRememberedValue3 = transformedTextFilterWithValidation;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                transformedTextFilterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(none, textFieldValue.getAnnotatedString());
                textRangeM4921getCompositionMzsxiRA = textFieldValue.m4921getCompositionMzsxiRA();
                if (textRangeM4921getCompositionMzsxiRA != null) {
                    objRememberedValue3 = transformedTextFilterWithValidation;
                } else {
                    objRememberedValue3 = transformedTextFilterWithValidation;
                }
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TransformedText transformedText15 = (TransformedText) objRememberedValue3;
            text = transformedText15.getText();
            offsetMapping = transformedText15.getOffsetMapping();
            currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new TextFieldState(new TextDelegate(text, textStyle2, 0, 0, z4, 0, density, resolver, null, 300, null), currentRecomposeScope);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            composerStartRestartGroup.endReplaceableGroup();
            textFieldState = (TextFieldState) objRememberedValue4;
            textFieldState.m838updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle2, z4, density, resolver, interfaceC3750qp, keyboardActions2, focusManager15, jM966getBackgroundColor0d7_KjU15);
            textFieldState.getProcessor().reset(textFieldValue, textFieldState.getInputSession());
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new UndoManager(0, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceableGroup();
            undoManager = (UndoManager) objRememberedValue5;
            UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new TextFieldSelectionManager(undoManager);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            composerStartRestartGroup.endReplaceableGroup();
            textFieldSelectionManager = (TextFieldSelectionManager) objRememberedValue6;
            textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
            textFieldSelectionManager.setVisualTransformation$foundation_release(none);
            textFieldSelectionManager.setOnValueChange$foundation_release(textFieldState.getOnValueChange());
            textFieldSelectionManager.setState$foundation_release(textFieldState);
            textFieldSelectionManager.setValue$foundation_release(textFieldValue);
            textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
            textFieldSelectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
            textFieldSelectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
            textFieldSelectionManager.setFocusRequester(focusRequester);
            textFieldSelectionManager.setEditable(!z6);
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller15 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller15);
                objRememberedValue7 = compositionScopedCoroutineScopeCanceller15;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope15 = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue7).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = BringIntoViewRequesterKt.BringIntoViewRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            composerStartRestartGroup.endReplaceableGroup();
            BringIntoViewRequester bringIntoViewRequester15 = (BringIntoViewRequester) objRememberedValue8;
            companion2 = Modifier.Companion;
            Modifier modifierTextFieldFocusModifier15 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z5, focusRequester, mutableInteractionSource2, new CoreTextFieldKt$CoreTextField$focusModifier$1(textFieldState, textInputService15, textFieldValue, imeOptions2, offsetMapping, textFieldSelectionManager, coroutineScope15, bringIntoViewRequester15));
            composerStartRestartGroup.startReplaceableGroup(-55008291);
            if (!z5) {
            }
            composerStartRestartGroup.endReplaceableGroup();
            if (TouchMode_androidKt.isInTouchMode()) {
                modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(companion2, mutableInteractionSource2, z5, new CoreTextFieldKt$CoreTextField$pointerModifier$1(textFieldState, focusRequester, z6, textFieldSelectionManager, offsetMapping)).then(TextFieldGestureModifiersKt.longPressDragGestureFilter(companion2, textFieldSelectionManager.getTouchSelectionObserver$foundation_release(), z5)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
            } else {
                modifierPointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(TextFieldGestureModifiersKt.mouseDragGestureDetector(companion2, textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), z5), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
            }
            Modifier modifierDrawBehind15 = DrawModifierKt.drawBehind(companion2, new CoreTextFieldKt$CoreTextField$drawModifier$1(textFieldState, textFieldValue, offsetMapping));
            Modifier modifierOnGloballyPositioned119 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, new CoreTextFieldKt$CoreTextField$onPositionedModifier$1(textFieldState, z5, textFieldSelectionManager, textFieldValue, offsetMapping));
            Modifier modifierSemantics15 = SemanticsModifierKt.semantics(companion2, true, new CoreTextFieldKt$CoreTextField$semanticsModifier$1(imeOptions2, transformedText15, textFieldValue, z5, none instanceof PasswordVisualTransformation, z6, textFieldState, offsetMapping, textFieldSelectionManager, focusRequester));
            if (z5) {
                z7 = false;
            } else {
                z7 = false;
            }
            Modifier modifierCursor15 = TextFieldCursorKt.cursor(companion2, textFieldState, textFieldValue, offsetMapping, brush2, z7);
            EffectsKt.DisposableEffect(textFieldSelectionManager, new AnonymousClass3(textFieldSelectionManager), composerStartRestartGroup, 8);
            EffectsKt.DisposableEffect(imeOptions2, new AnonymousClass4(textInputService15, textFieldState, textFieldValue, imeOptions2), composerStartRestartGroup, (i416 >> 3) & 14);
            InterfaceC3750qp onValueChange15 = textFieldState.getOnValueChange();
            boolean z11111 = !z6;
            if (i35 == 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource2;
            Modifier modifierOnGloballyPositioned1110 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(modifier18.then(modifierTextFieldFocusModifier15), textFieldState, focusManager15), textFieldState, textFieldSelectionManager).then(TextFieldKeyInputKt.m824textFieldKeyInput2WJ9YEU(companion2, textFieldState, textFieldSelectionManager, textFieldValue, onValueChange15, z11111, z8, offsetMapping, undoManager, imeOptions2.m4873getImeActioneUduSuo())), textFieldScrollerPosition15, mutableInteractionSource18, z5).then(modifierPointerHoverIcon$default).then(modifierSemantics15), new CoreTextFieldKt$CoreTextField$decorationBoxModifier$1(textFieldState));
            if (!z5) {
                z9 = false;
            } else {
                z9 = false;
            }
            if (z9) {
                modifierTextFieldMagnifier = TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager);
            } else {
                modifierTextFieldMagnifier = companion2;
            }
            boolean z11112 = z5;
            ImeOptions imeOptions18 = imeOptions2;
            VisualTransformation visualTransformation17 = none;
            composer2 = composerStartRestartGroup;
            CoreTextFieldRootBox(modifierOnGloballyPositioned1110, textFieldSelectionManager, ComposableLambdaKt.composableLambda(composer2, -374338080, true, new AnonymousClass5(interfaceC0552GpM759getLambda1$foundation_release, i416, textFieldState, textStyle2, i33, i35, textFieldScrollerPosition15, textFieldValue, none, modifierCursor15, modifierDrawBehind15, modifierOnGloballyPositioned119, modifierTextFieldMagnifier, bringIntoViewRequester15, textFieldSelectionManager, z9, z6, interfaceC3750qp3, offsetMapping, density)), composer2, 448);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier18;
            textStyle3 = textStyle2;
            interfaceC3750qp4 = interfaceC3750qp3;
            z10 = z11112;
            brush3 = brush2;
            z11 = z4;
            i36 = i33;
            keyboardActions3 = keyboardActions2;
            z12 = z6;
            interfaceC0552Gp2 = interfaceC0552GpM759getLambda1$foundation_release;
            imeOptions3 = imeOptions18;
            i37 = i35;
            mutableInteractionSource3 = mutableInteractionSource18;
            visualTransformation2 = visualTransformation17;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass6(textFieldValue, interfaceC3750qp, modifier3, textStyle3, visualTransformation2, interfaceC3750qp4, mutableInteractionSource3, brush3, z11, i37, i36, imeOptions3, keyboardActions3, z10, z12, interfaceC0552Gp2, i3, i4, i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void CoreTextFieldRootBox(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-20551815);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20551815, i, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:697)");
        }
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composerStartRestartGroup, 48);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        InterfaceC3588op constructor = companion.getConstructor();
        InterfaceC0552Gp interfaceC0552GpModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2668setimpl(composerM2661constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        InterfaceC0526Fp setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (composerM2661constructorimpl.getInserting() || !AbstractC4492zt.d(composerM2661constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM2661constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM2661constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        interfaceC0552GpModifierMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceableGroup(-1985516685);
        interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf(((((i >> 3) & 112) | 8) >> 3) & 14));
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C13902(modifier, textFieldSelectionManager, interfaceC0526Fp, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager textFieldSelectionManager, boolean z, Composer composer, int i) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer composerStartRestartGroup = composer.startRestartGroup(626339208);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626339208, i, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1025)");
        }
        if (z) {
            TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
            TextLayoutResult textLayoutResult = null;
            if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                TextFieldState state$foundation_release2 = textFieldSelectionManager.getState$foundation_release();
                if (!(state$foundation_release2 != null ? state$foundation_release2.isLayoutResultStale() : true)) {
                    textLayoutResult = value;
                }
            }
            if (textLayoutResult != null) {
                if (!TextRange.m4699getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().m4922getSelectiond9O1mEE())) {
                    int iOriginalToTransformed = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m4705getStartimpl(textFieldSelectionManager.getValue$foundation_release().m4922getSelectiond9O1mEE()));
                    int iOriginalToTransformed2 = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m4700getEndimpl(textFieldSelectionManager.getValue$foundation_release().m4922getSelectiond9O1mEE()));
                    ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(iOriginalToTransformed);
                    ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(iOriginalToTransformed2 - 1, 0));
                    composerStartRestartGroup.startReplaceableGroup(-498389736);
                    TextFieldState state$foundation_release3 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release3 != null && state$foundation_release3.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, composerStartRestartGroup, TIFFConstants.TIFFTAG_JPEGPOINTTRANSFORM);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    TextFieldState state$foundation_release4 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release4 != null && state$foundation_release4.getShowSelectionHandleEnd()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, composerStartRestartGroup, TIFFConstants.TIFFTAG_JPEGPOINTTRANSFORM);
                    }
                }
                TextFieldState state$foundation_release5 = textFieldSelectionManager.getState$foundation_release();
                if (state$foundation_release5 != null) {
                    if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                        state$foundation_release5.setShowFloatingToolbar(false);
                    }
                    if (state$foundation_release5.getHasFocus()) {
                        if (state$foundation_release5.getShowFloatingToolbar()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C13912(textFieldSelectionManager, z, i));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextFieldCursorHandle(TextFieldSelectionManager textFieldSelectionManager, Composer composer, int i) {
        AbstractC4492zt.h(textFieldSelectionManager, "manager");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1436003720);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1436003720, i, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1068)");
        }
        TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release != null && state$foundation_release.getShowCursorHandle()) {
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(textFieldSelectionManager);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
            long jM956getCursorPositiontuRUvjQ$foundation_release = textFieldSelectionManager.m956getCursorPositiontuRUvjQ$foundation_release((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, textDragObserver, new C13921(textDragObserver, null));
            Offset offsetM2787boximpl = Offset.m2787boximpl(jM956getCursorPositiontuRUvjQ$foundation_release);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(offsetM2787boximpl);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(jM956getCursorPositiontuRUvjQ$foundation_release);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            AndroidCursorHandle_androidKt.m740CursorHandleULxng0E(jM956getCursorPositiontuRUvjQ$foundation_release, SemanticsModifierKt.semantics$default(modifierPointerInput, false, (InterfaceC3750qp) objRememberedValue2, 1, null), null, composerStartRestartGroup, 384);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C13933(textFieldSelectionManager, i));
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, InterfaceC0793Of interfaceC0793Of) {
        Rect boundingBox;
        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m4702getMaximpl(textFieldValue.m4922getSelectiond9O1mEE()));
        if (iOriginalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            boundingBox = textLayoutResult.getBoundingBox(iOriginalToTransformed);
        } else {
            boundingBox = iOriginalToTransformed != 0 ? textLayoutResult.getBoundingBox(iOriginalToTransformed - 1) : new Rect(0.0f, 0.0f, 1.0f, IntSize.m5319getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null)));
        }
        Object objBringIntoView = bringIntoViewRequester.bringIntoView(boundingBox, interfaceC0793Of);
        return objBringIntoView == AbstractC0378Bt.d() ? objBringIntoView : FW.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusedRect(TextFieldState textFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot snapshotCreateNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
            try {
                TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                if (layoutResult == null) {
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    snapshotCreateNonObservableSnapshot.dispose();
                    return;
                }
                TextInputSession inputSession = textFieldState.getInputSession();
                if (inputSession == null) {
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    snapshotCreateNonObservableSnapshot.dispose();
                    return;
                }
                LayoutCoordinates layoutCoordinates = textFieldState.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    snapshotCreateNonObservableSnapshot.dispose();
                } else {
                    TextFieldDelegate.Companion.notifyFocusedRect$foundation_release(textFieldValue, textFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, textFieldState.getHasFocus(), offsetMapping);
                    FW fw = FW.a;
                    snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    snapshotCreateNonObservableSnapshot.dispose();
                }
            } catch (Throwable th) {
                snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                throw th;
            }
        } catch (Throwable th2) {
            snapshotCreateNonObservableSnapshot.dispose();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyTextInputServiceOnFocusChange(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        if (!textFieldState.getHasFocus()) {
            onBlur(textFieldState);
        } else {
            textFieldState.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, textFieldValue, textFieldState.getProcessor(), imeOptions, textFieldState.getOnValueChange(), textFieldState.getOnImeActionPerformed()));
            notifyFocusedRect(textFieldState, textFieldValue, offsetMapping);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBlur(TextFieldState textFieldState) {
        TextInputSession inputSession = textFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.Companion.onBlur$foundation_release(inputSession, textFieldState.getProcessor(), textFieldState.getOnValueChange());
        }
        textFieldState.setInputSession(null);
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new C13941(textFieldState, textFieldSelectionManager));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState textFieldState, FocusRequester focusRequester, boolean z) {
        TextInputSession inputSession;
        if (!textFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!z || (inputSession = textFieldState.getInputSession()) == null) {
                return;
            }
            inputSession.showSoftwareKeyboard();
        }
    }
}
