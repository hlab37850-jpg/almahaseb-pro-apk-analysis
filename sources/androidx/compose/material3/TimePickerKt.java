package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2044dc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC2260gB;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC3648pb;
import defpackage.AbstractC4492zt;
import defpackage.C1172Zk;
import defpackage.C2020dG;
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
import defpackage.O8;
import defpackage.XS;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.poi.hpsf.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt {
    private static final float ClockFaceBottomMargin;
    private static final float DisplaySeparatorWidth;
    private static final List<Integer> ExtraHours;
    private static final float FullCircle = 6.2831855f;
    private static final List<Integer> Hours;
    private static final float PeriodToggleMargin;
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float TimeInputBottomPadding;
    private static final float OuterCircleSizeRadius = Dp.m5160constructorimpl(101);
    private static final float InnerCircleRadius = Dp.m5160constructorimpl(69);
    private static final float ClockDisplayBottomMargin = Dp.m5160constructorimpl(36);
    private static final float SupportLabelTop = Dp.m5160constructorimpl(7);
    private static final float MaxDistance = Dp.m5160constructorimpl(74);
    private static final float MinimumInteractiveSize = Dp.m5160constructorimpl(48);
    private static final List<Integer> Minutes = AbstractC1886cc.p(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockDisplayNumbers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TimePickerState timePickerState, TimePickerColors timePickerColors, int i) {
            super(2);
            this.$state = timePickerState;
            this.$colors = timePickerColors;
            this.$$dirty = i;
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
                ComposerKt.traceEventStart(-477913269, i, -1, "androidx.compose.material3.ClockDisplayNumbers.<anonymous> (TimePicker.kt:845)");
            }
            TimePickerState timePickerState = this.$state;
            TimePickerColors timePickerColors = this.$colors;
            int i2 = this.$$dirty;
            composer.startReplaceableGroup(693286680);
            Modifier.Companion companion = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
            Modifier modifierM534sizeVpY3zN4 = SizeKt.m534sizeVpY3zN4(companion, timePickerTokens.m2561getTimeSelectorContainerWidthD9Ej5fM(), timePickerTokens.m2560getTimeSelectorContainerHeightD9Ej5fM());
            int hourForDisplay$material3_release = timePickerState.getHourForDisplay$material3_release();
            Selection.Companion companion3 = Selection.Companion;
            int i3 = ((i2 << 9) & 57344) | ((i2 << 6) & 896) | 3078;
            TimePickerKt.m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN4, hourForDisplay$material3_release, timePickerState, companion3.m1750getHourJiIwxys(), timePickerColors, composer, i3);
            TimePickerKt.DisplaySeparator(SizeKt.m534sizeVpY3zN4(companion, TimePickerKt.DisplaySeparatorWidth, timePickerTokens.m2557getPeriodSelectorVerticalContainerHeightD9Ej5fM()), composer, 6);
            TimePickerKt.m1947TimeSelectoruXwN82Y(SizeKt.m534sizeVpY3zN4(companion, timePickerTokens.m2561getTimeSelectorContainerWidthD9Ej5fM(), timePickerTokens.m2560getTimeSelectorContainerHeightD9Ej5fM()), timePickerState.getMinute(), timePickerState, companion3.m1751getMinuteJiIwxys(), timePickerColors, composer, i3);
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockDisplayNumbers$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TimePickerState timePickerState, TimePickerColors timePickerColors, int i) {
            super(2);
            this.$state = timePickerState;
            this.$colors = timePickerColors;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.ClockDisplayNumbers(this.$state, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockFace$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15881 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C15881 INSTANCE = new C15881();

        public C15881() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, false);
            SemanticsPropertiesKt.selectableGroup(semanticsPropertyReceiver);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockFace$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15892 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ TimePickerState $state;

        /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockFace$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ boolean $autoSwitchToMinute;
            final /* synthetic */ TimePickerColors $colors;
            final /* synthetic */ List<Integer> $screen;
            final /* synthetic */ TimePickerState $state;

            /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockFace$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01251 extends AbstractC2233fv implements InterfaceC0526Fp {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ boolean $autoSwitchToMinute;
                final /* synthetic */ List<Integer> $screen;
                final /* synthetic */ TimePickerState $state;

                /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockFace$2$1$1$2, reason: invalid class name and collision with other inner class name */
                public static final class C01262 extends AbstractC2233fv implements InterfaceC0526Fp {
                    final /* synthetic */ int $$dirty;
                    final /* synthetic */ boolean $autoSwitchToMinute;
                    final /* synthetic */ TimePickerState $state;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C01262(TimePickerState timePickerState, boolean z, int i) {
                        super(2);
                        this.$state = timePickerState;
                        this.$autoSwitchToMinute = z;
                        this.$$dirty = i;
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
                            ComposerKt.traceEventStart(-448649404, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1167)");
                        }
                        int size = TimePickerKt.ExtraHours.size();
                        TimePickerState timePickerState = this.$state;
                        boolean z = this.$autoSwitchToMinute;
                        int i2 = this.$$dirty;
                        for (int i3 = 0; i3 < size; i3++) {
                            TimePickerKt.ClockText(timePickerState, ((Number) TimePickerKt.ExtraHours.get(i3)).intValue(), z, composer, i2 & 910);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01251(List<Integer> list, TimePickerState timePickerState, boolean z, int i) {
                    super(2);
                    this.$screen = list;
                    this.$state = timePickerState;
                    this.$autoSwitchToMinute = z;
                    this.$$dirty = i;
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
                        ComposerKt.traceEventStart(-2018362505, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1150)");
                    }
                    composer.startReplaceableGroup(-504302349);
                    int size = this.$screen.size();
                    TimePickerState timePickerState = this.$state;
                    List<Integer> list = this.$screen;
                    boolean z = this.$autoSwitchToMinute;
                    int i2 = this.$$dirty;
                    for (int i3 = 0; i3 < size; i3++) {
                        TimePickerKt.ClockText(timePickerState, (!timePickerState.is24hour() || Selection.m1746equalsimpl0(timePickerState.m1974getSelectionJiIwxys$material3_release(), Selection.Companion.m1751getMinuteJiIwxys())) ? list.get(i3).intValue() : list.get(i3).intValue() % 12, z, composer, i2 & 910);
                    }
                    composer.endReplaceableGroup();
                    if (Selection.m1746equalsimpl0(this.$state.m1974getSelectionJiIwxys$material3_release(), Selection.Companion.m1750getHourJiIwxys()) && this.$state.is24hour()) {
                        TimePickerKt.m1944CircularLayoutuFdPcIQ(BackgroundKt.m166backgroundbw27NRU(SizeKt.m532size3ABfNKs(LayoutIdKt.layoutId(Modifier.Companion, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m2549getClockDialContainerSizeD9Ej5fM()), Color.Companion.m3067getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), TimePickerKt.InnerCircleRadius, ComposableLambdaKt.composableLambda(composer, -448649404, true, new C01262(this.$state, this.$autoSwitchToMinute, this.$$dirty)), composer, 432, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TimePickerColors timePickerColors, List<Integer> list, TimePickerState timePickerState, boolean z, int i) {
                super(2);
                this.$colors = timePickerColors;
                this.$screen = list;
                this.$state = timePickerState;
                this.$autoSwitchToMinute = z;
                this.$$dirty = i;
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
                    ComposerKt.traceEventStart(-1385633737, i, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1147)");
                }
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(this.$colors.m1933clockDialContentColorvNxB06k$material3_release(false)))}, ComposableLambdaKt.composableLambda(composer, -2018362505, true, new C01251(this.$screen, this.$state, this.$autoSwitchToMinute, this.$$dirty)), composer, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15892(TimePickerState timePickerState, boolean z, TimePickerColors timePickerColors, int i) {
            super(3);
            this.$state = timePickerState;
            this.$autoSwitchToMinute = z;
            this.$colors = timePickerColors;
            this.$$dirty = i;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((List<Integer>) obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(List<Integer> list, Composer composer, int i) {
            AbstractC4492zt.h(list, "screen");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1628166511, i, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1140)");
            }
            TimePickerKt.m1944CircularLayoutuFdPcIQ(TimePickerKt.drawSelector(SizeKt.m532size3ABfNKs(TimePickerKt.clockDial(Modifier.Companion, this.$state, this.$autoSwitchToMinute), TimePickerTokens.INSTANCE.m2549getClockDialContainerSizeD9Ej5fM()), this.$state, this.$colors), TimePickerKt.OuterCircleSizeRadius, ComposableLambdaKt.composableLambda(composer, -1385633737, true, new AnonymousClass1(this.$colors, list, this.$state, this.$autoSwitchToMinute, this.$$dirty)), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockFace$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(TimePickerState timePickerState, TimePickerColors timePickerColors, boolean z, int i) {
            super(2);
            this.$state = timePickerState;
            this.$colors = timePickerColors;
            this.$autoSwitchToMinute = z;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.ClockFace(this.$state, this.$colors, this.$autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockText$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15902 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ MutableState<Offset> $center$delegate;
        final /* synthetic */ float $maxDist;
        final /* synthetic */ InterfaceC2052dg $scope;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ TimePickerState $state;

        /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
            final /* synthetic */ boolean $autoSwitchToMinute;
            final /* synthetic */ MutableState<Offset> $center$delegate;
            final /* synthetic */ float $maxDist;
            final /* synthetic */ InterfaceC2052dg $scope;
            final /* synthetic */ TimePickerState $state;

            /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1$1, reason: invalid class name and collision with other inner class name */
            @InterfaceC3252ki(c = "androidx.compose.material3.TimePickerKt$ClockText$2$1$1", f = "TimePicker.kt", l = {1318}, m = "invokeSuspend")
            public static final class C01271 extends XS implements InterfaceC0526Fp {
                final /* synthetic */ boolean $autoSwitchToMinute;
                final /* synthetic */ MutableState<Offset> $center$delegate;
                final /* synthetic */ float $maxDist;
                final /* synthetic */ TimePickerState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01271(TimePickerState timePickerState, float f, boolean z, MutableState<Offset> mutableState, InterfaceC0793Of interfaceC0793Of) {
                    super(2, interfaceC0793Of);
                    this.$state = timePickerState;
                    this.$maxDist = f;
                    this.$autoSwitchToMinute = z;
                    this.$center$delegate = mutableState;
                }

                @Override // defpackage.AbstractC2171f7
                public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                    return new C01271(this.$state, this.$maxDist, this.$autoSwitchToMinute, this.$center$delegate, interfaceC0793Of);
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                    return ((C01271) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objD = AbstractC0378Bt.d();
                    int i = this.label;
                    if (i == 0) {
                        LL.b(obj);
                        TimePickerState timePickerState = this.$state;
                        float fM2798getXimpl = Offset.m2798getXimpl(TimePickerKt.ClockText$lambda$29(this.$center$delegate));
                        float fM2799getYimpl = Offset.m2799getYimpl(TimePickerKt.ClockText$lambda$29(this.$center$delegate));
                        float f = this.$maxDist;
                        boolean z = this.$autoSwitchToMinute;
                        this.label = 1;
                        if (timePickerState.onTap$material3_release(fM2798getXimpl, fM2799getYimpl, f, z, this) == objD) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(InterfaceC2052dg interfaceC2052dg, TimePickerState timePickerState, float f, boolean z, MutableState<Offset> mutableState) {
                super(0);
                this.$scope = interfaceC2052dg;
                this.$state = timePickerState;
                this.$maxDist = f;
                this.$autoSwitchToMinute = z;
                this.$center$delegate = mutableState;
            }

            @Override // defpackage.InterfaceC3588op
            public final Boolean invoke() {
                O8.d(this.$scope, null, null, new C01271(this.$state, this.$maxDist, this.$autoSwitchToMinute, this.$center$delegate, null), 3, null);
                return Boolean.TRUE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15902(boolean z, InterfaceC2052dg interfaceC2052dg, TimePickerState timePickerState, float f, boolean z2, MutableState<Offset> mutableState) {
            super(1);
            this.$selected = z;
            this.$scope = interfaceC2052dg;
            this.$state = timePickerState;
            this.$maxDist = f;
            this.$autoSwitchToMinute = z2;
            this.$center$delegate = mutableState;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new AnonymousClass1(this.$scope, this.$state, this.$maxDist, this.$autoSwitchToMinute, this.$center$delegate), 1, null);
            SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, this.$selected);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockText$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ TimePickerState $state;
        final /* synthetic */ int $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(TimePickerState timePickerState, int i, boolean z, int i2) {
            super(2);
            this.$state = timePickerState;
            this.$value = i;
            this.$autoSwitchToMinute = z;
            this.$$changed = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.ClockText(this.$state, this.$value, this.$autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$DisplaySeparator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15911 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C15911 INSTANCE = new C15911();

        public C15911() {
            super(1);
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$clearAndSetSemantics");
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$DisplaySeparator$3, reason: invalid class name and case insensitive filesystem */
    public static final class C15923 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15923(Modifier modifier, int i) {
            super(2);
            this.$modifier = modifier;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.DisplaySeparator(this.$modifier, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$HorizontalClockDisplay$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15932 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15932(TimePickerState timePickerState, TimePickerColors timePickerColors, int i) {
            super(2);
            this.$state = timePickerState;
            this.$colors = timePickerColors;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.HorizontalClockDisplay(this.$state, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15941 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15941(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, int i) {
            super(2);
            this.$modifier = modifier;
            this.$state = timePickerState;
            this.$colors = timePickerColors;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.HorizontalPeriodToggle(this.$modifier, this.$state, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$HorizontalTimePicker$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15952 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15952(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, boolean z, int i, int i2) {
            super(2);
            this.$state = timePickerState;
            this.$modifier = modifier;
            this.$colors = timePickerColors;
            this.$autoSwitchToMinute = z;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.HorizontalTimePicker(this.$state, this.$modifier, this.$colors, this.$autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$3, reason: invalid class name and case insensitive filesystem */
    public static final class C15963 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ Shape $endShape;
        final /* synthetic */ MeasurePolicy $measurePolicy;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Shape $startShape;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15963(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, MeasurePolicy measurePolicy, Shape shape, Shape shape2, int i) {
            super(2);
            this.$modifier = modifier;
            this.$state = timePickerState;
            this.$colors = timePickerColors;
            this.$measurePolicy = measurePolicy;
            this.$startShape = shape;
            this.$endShape = shape2;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.PeriodToggleImpl(this.$modifier, this.$state, this.$colors, this.$measurePolicy, this.$startShape, this.$endShape, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$TimeInput$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15971 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15971(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, int i2) {
            super(2);
            this.$state = timePickerState;
            this.$modifier = modifier;
            this.$colors = timePickerColors;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.TimeInput(this.$state, this.$modifier, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$TimeInputImpl$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15982 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15982(Modifier modifier, TimePickerColors timePickerColors, TimePickerState timePickerState, int i) {
            super(2);
            this.$modifier = modifier;
            this.$colors = timePickerColors;
            this.$state = timePickerState;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.TimeInputImpl(this.$modifier, this.$colors, this.$state, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ToggleItem$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15992 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ boolean $checked;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ InterfaceC0552Gp $content;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ Shape $shape;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15992(boolean z, Shape shape, InterfaceC3588op interfaceC3588op, TimePickerColors timePickerColors, InterfaceC0552Gp interfaceC0552Gp, int i) {
            super(2);
            this.$checked = z;
            this.$shape = shape;
            this.$onClick = interfaceC3588op;
            this.$colors = timePickerColors;
            this.$content = interfaceC0552Gp;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.ToggleItem(this.$checked, this.$shape, this.$onClick, this.$colors, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$VerticalClockDisplay$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16002 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16002(TimePickerState timePickerState, TimePickerColors timePickerColors, int i) {
            super(2);
            this.$state = timePickerState;
            this.$colors = timePickerColors;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.VerticalClockDisplay(this.$state, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16011 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16011(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, int i) {
            super(2);
            this.$modifier = modifier;
            this.$state = timePickerState;
            this.$colors = timePickerColors;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.VerticalPeriodToggle(this.$modifier, this.$state, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$VerticalTimePicker$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16022 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16022(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, boolean z, int i, int i2) {
            super(2);
            this.$state = timePickerState;
            this.$modifier = modifier;
            this.$colors = timePickerColors;
            this.$autoSwitchToMinute = z;
            this.$$changed = i;
            this.$$default = i2;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            TimePickerKt.VerticalTimePicker(this.$state, this.$modifier, this.$colors, this.$autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2, reason: invalid class name and case insensitive filesystem */
    public static final class C16032 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ TimePickerState $state;

        /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2, reason: invalid class name and collision with other inner class name */
        @InterfaceC3252ki(c = "androidx.compose.material3.TimePickerKt$clockDial$2$2", f = "TimePicker.kt", l = {Constants.CP_WINDOWS_1255}, m = "invokeSuspend")
        public static final class C01282 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ boolean $autoSwitchToMinute;
            final /* synthetic */ float $maxDist;
            final /* synthetic */ MutableState<Float> $offsetX$delegate;
            final /* synthetic */ MutableState<Float> $offsetY$delegate;
            final /* synthetic */ InterfaceC2052dg $scope;
            final /* synthetic */ TimePickerState $state;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2$1, reason: invalid class name */
            @InterfaceC3252ki(c = "androidx.compose.material3.TimePickerKt$clockDial$2$2$1", f = "TimePicker.kt", l = {}, m = "invokeSuspend")
            public static final class AnonymousClass1 extends XS implements InterfaceC0552Gp {
                final /* synthetic */ MutableState<Float> $offsetX$delegate;
                final /* synthetic */ MutableState<Float> $offsetY$delegate;
                /* synthetic */ long J$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(MutableState<Float> mutableState, MutableState<Float> mutableState2, InterfaceC0793Of interfaceC0793Of) {
                    super(3, interfaceC0793Of);
                    this.$offsetX$delegate = mutableState;
                    this.$offsetY$delegate = mutableState2;
                }

                @Override // defpackage.InterfaceC0552Gp
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return m1960invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2808unboximpl(), (InterfaceC0793Of) obj3);
                }

                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                public final Object m1960invoked4ec7I(PressGestureScope pressGestureScope, long j, InterfaceC0793Of interfaceC0793Of) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$offsetX$delegate, this.$offsetY$delegate, interfaceC0793Of);
                    anonymousClass1.J$0 = j;
                    return anonymousClass1.invokeSuspend(FW.a);
                }

                @Override // defpackage.AbstractC2171f7
                public final Object invokeSuspend(Object obj) throws Throwable {
                    AbstractC0378Bt.d();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                    long j = this.J$0;
                    C16032.invoke$lambda$2(this.$offsetX$delegate, Offset.m2798getXimpl(j));
                    C16032.invoke$lambda$5(this.$offsetY$delegate, Offset.m2799getYimpl(j));
                    return FW.a;
                }
            }

            /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2$2, reason: invalid class name and collision with other inner class name */
            public static final class C01292 extends AbstractC2233fv implements InterfaceC3750qp {
                final /* synthetic */ boolean $autoSwitchToMinute;
                final /* synthetic */ float $maxDist;
                final /* synthetic */ InterfaceC2052dg $scope;
                final /* synthetic */ TimePickerState $state;

                /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$2$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.compose.material3.TimePickerKt$clockDial$2$2$2$1", f = "TimePicker.kt", l = {1261}, m = "invokeSuspend")
                public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
                    final /* synthetic */ boolean $autoSwitchToMinute;
                    final /* synthetic */ long $it;
                    final /* synthetic */ float $maxDist;
                    final /* synthetic */ TimePickerState $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(TimePickerState timePickerState, long j, float f, boolean z, InterfaceC0793Of interfaceC0793Of) {
                        super(2, interfaceC0793Of);
                        this.$state = timePickerState;
                        this.$it = j;
                        this.$maxDist = f;
                        this.$autoSwitchToMinute = z;
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                        return new AnonymousClass1(this.$state, this.$it, this.$maxDist, this.$autoSwitchToMinute, interfaceC0793Of);
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
                            TimePickerState timePickerState = this.$state;
                            float fM2798getXimpl = Offset.m2798getXimpl(this.$it);
                            float fM2799getYimpl = Offset.m2799getYimpl(this.$it);
                            float f = this.$maxDist;
                            boolean z = this.$autoSwitchToMinute;
                            this.label = 1;
                            if (timePickerState.onTap$material3_release(fM2798getXimpl, fM2799getYimpl, f, z, this) == objD) {
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

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01292(InterfaceC2052dg interfaceC2052dg, TimePickerState timePickerState, float f, boolean z) {
                    super(1);
                    this.$scope = interfaceC2052dg;
                    this.$state = timePickerState;
                    this.$maxDist = f;
                    this.$autoSwitchToMinute = z;
                }

                @Override // defpackage.InterfaceC3750qp
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m1961invokek4lQ0M(((Offset) obj).m2808unboximpl());
                    return FW.a;
                }

                /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m1961invokek4lQ0M(long j) {
                    O8.d(this.$scope, null, null, new AnonymousClass1(this.$state, j, this.$maxDist, this.$autoSwitchToMinute, null), 3, null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01282(MutableState<Float> mutableState, MutableState<Float> mutableState2, InterfaceC2052dg interfaceC2052dg, TimePickerState timePickerState, float f, boolean z, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$offsetX$delegate = mutableState;
                this.$offsetY$delegate = mutableState2;
                this.$scope = interfaceC2052dg;
                this.$state = timePickerState;
                this.$maxDist = f;
                this.$autoSwitchToMinute = z;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                C01282 c01282 = new C01282(this.$offsetX$delegate, this.$offsetY$delegate, this.$scope, this.$state, this.$maxDist, this.$autoSwitchToMinute, interfaceC0793Of);
                c01282.L$0 = obj;
                return c01282;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
                return ((C01282) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$offsetX$delegate, this.$offsetY$delegate, null);
                    C01292 c01292 = new C01292(this.$scope, this.$state, this.$maxDist, this.$autoSwitchToMinute);
                    this.label = 1;
                    if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, anonymousClass1, c01292, this, 3, null) == objD) {
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

        /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3, reason: invalid class name */
        @InterfaceC3252ki(c = "androidx.compose.material3.TimePickerKt$clockDial$2$3", f = "TimePicker.kt", l = {1266}, m = "invokeSuspend")
        public static final class AnonymousClass3 extends XS implements InterfaceC0526Fp {
            final /* synthetic */ boolean $autoSwitchToMinute;
            final /* synthetic */ float $maxDist;
            final /* synthetic */ MutableState<Float> $offsetX$delegate;
            final /* synthetic */ MutableState<Float> $offsetY$delegate;
            final /* synthetic */ InterfaceC2052dg $scope;
            final /* synthetic */ TimePickerState $state;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3$1, reason: invalid class name */
            public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
                final /* synthetic */ boolean $autoSwitchToMinute;
                final /* synthetic */ InterfaceC2052dg $scope;
                final /* synthetic */ TimePickerState $state;

                /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3$1$1, reason: invalid class name and collision with other inner class name */
                @InterfaceC3252ki(c = "androidx.compose.material3.TimePickerKt$clockDial$2$3$1$1", f = "TimePicker.kt", l = {1270, 1272}, m = "invokeSuspend")
                public static final class C01301 extends XS implements InterfaceC0526Fp {
                    final /* synthetic */ boolean $autoSwitchToMinute;
                    final /* synthetic */ TimePickerState $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C01301(TimePickerState timePickerState, boolean z, InterfaceC0793Of interfaceC0793Of) {
                        super(2, interfaceC0793Of);
                        this.$state = timePickerState;
                        this.$autoSwitchToMinute = z;
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                        return new C01301(this.$state, this.$autoSwitchToMinute, interfaceC0793Of);
                    }

                    @Override // defpackage.InterfaceC0526Fp
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
                        return ((C01301) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objD = AbstractC0378Bt.d();
                        int i = this.label;
                        if (i == 0) {
                            LL.b(obj);
                            int iM1974getSelectionJiIwxys$material3_release = this.$state.m1974getSelectionJiIwxys$material3_release();
                            Selection.Companion companion = Selection.Companion;
                            if (Selection.m1746equalsimpl0(iM1974getSelectionJiIwxys$material3_release, companion.m1750getHourJiIwxys()) && this.$autoSwitchToMinute) {
                                this.$state.m1977setSelectioniHAOin8$material3_release(companion.m1751getMinuteJiIwxys());
                                TimePickerState timePickerState = this.$state;
                                this.label = 1;
                                if (timePickerState.animateToCurrent$material3_release(this) == objD) {
                                    return objD;
                                }
                            } else if (Selection.m1746equalsimpl0(this.$state.m1974getSelectionJiIwxys$material3_release(), companion.m1751getMinuteJiIwxys())) {
                                TimePickerState timePickerState2 = this.$state;
                                this.label = 2;
                                if (timePickerState2.settle(this) == objD) {
                                    return objD;
                                }
                            }
                        } else {
                            if (i != 1 && i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            LL.b(obj);
                        }
                        return FW.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(InterfaceC2052dg interfaceC2052dg, TimePickerState timePickerState, boolean z) {
                    super(0);
                    this.$scope = interfaceC2052dg;
                    this.$state = timePickerState;
                    this.$autoSwitchToMinute = z;
                }

                @Override // defpackage.InterfaceC3588op
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1962invoke();
                    return FW.a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1962invoke() {
                    O8.d(this.$scope, null, null, new C01301(this.$state, this.$autoSwitchToMinute, null), 3, null);
                }
            }

            /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3$2, reason: invalid class name and collision with other inner class name */
            public static final class C01312 extends AbstractC2233fv implements InterfaceC0526Fp {
                final /* synthetic */ float $maxDist;
                final /* synthetic */ MutableState<Float> $offsetX$delegate;
                final /* synthetic */ MutableState<Float> $offsetY$delegate;
                final /* synthetic */ InterfaceC2052dg $scope;
                final /* synthetic */ TimePickerState $state;

                /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$clockDial$2$3$2$1, reason: invalid class name */
                @InterfaceC3252ki(c = "androidx.compose.material3.TimePickerKt$clockDial$2$3$2$1", f = "TimePicker.kt", l = {1279}, m = "invokeSuspend")
                public static final class AnonymousClass1 extends XS implements InterfaceC0526Fp {
                    final /* synthetic */ long $dragAmount;
                    final /* synthetic */ MutableState<Float> $offsetX$delegate;
                    final /* synthetic */ MutableState<Float> $offsetY$delegate;
                    final /* synthetic */ TimePickerState $state;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(long j, TimePickerState timePickerState, MutableState<Float> mutableState, MutableState<Float> mutableState2, InterfaceC0793Of interfaceC0793Of) {
                        super(2, interfaceC0793Of);
                        this.$dragAmount = j;
                        this.$state = timePickerState;
                        this.$offsetX$delegate = mutableState;
                        this.$offsetY$delegate = mutableState2;
                    }

                    @Override // defpackage.AbstractC2171f7
                    public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                        return new AnonymousClass1(this.$dragAmount, this.$state, this.$offsetX$delegate, this.$offsetY$delegate, interfaceC0793Of);
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
                            MutableState<Float> mutableState = this.$offsetX$delegate;
                            C16032.invoke$lambda$2(mutableState, C16032.invoke$lambda$1(mutableState) + Offset.m2798getXimpl(this.$dragAmount));
                            MutableState<Float> mutableState2 = this.$offsetY$delegate;
                            C16032.invoke$lambda$5(mutableState2, C16032.invoke$lambda$4(mutableState2) + Offset.m2799getYimpl(this.$dragAmount));
                            TimePickerState timePickerState = this.$state;
                            float fAtan = TimePickerKt.atan(C16032.invoke$lambda$4(this.$offsetY$delegate) - IntOffset.m5279getYimpl(this.$state.m1973getCenternOccac$material3_release()), C16032.invoke$lambda$1(this.$offsetX$delegate) - IntOffset.m5278getXimpl(this.$state.m1973getCenternOccac$material3_release()));
                            this.label = 1;
                            if (TimePickerState.update$material3_release$default(timePickerState, fAtan, false, this, 2, null) == objD) {
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

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01312(InterfaceC2052dg interfaceC2052dg, TimePickerState timePickerState, float f, MutableState<Float> mutableState, MutableState<Float> mutableState2) {
                    super(2);
                    this.$scope = interfaceC2052dg;
                    this.$state = timePickerState;
                    this.$maxDist = f;
                    this.$offsetX$delegate = mutableState;
                    this.$offsetY$delegate = mutableState2;
                }

                @Override // defpackage.InterfaceC0526Fp
                /* JADX INFO: renamed from: invoke */
                public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                    m1963invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m2808unboximpl());
                    return FW.a;
                }

                /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m1963invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                    AbstractC4492zt.h(pointerInputChange, "<anonymous parameter 0>");
                    O8.d(this.$scope, null, null, new AnonymousClass1(j, this.$state, this.$offsetX$delegate, this.$offsetY$delegate, null), 3, null);
                    this.$state.moveSelector$material3_release(C16032.invoke$lambda$1(this.$offsetX$delegate), C16032.invoke$lambda$4(this.$offsetY$delegate), this.$maxDist);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(InterfaceC2052dg interfaceC2052dg, TimePickerState timePickerState, boolean z, float f, MutableState<Float> mutableState, MutableState<Float> mutableState2, InterfaceC0793Of interfaceC0793Of) {
                super(2, interfaceC0793Of);
                this.$scope = interfaceC2052dg;
                this.$state = timePickerState;
                this.$autoSwitchToMinute = z;
                this.$maxDist = f;
                this.$offsetX$delegate = mutableState;
                this.$offsetY$delegate = mutableState2;
            }

            @Override // defpackage.AbstractC2171f7
            public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$scope, this.$state, this.$autoSwitchToMinute, this.$maxDist, this.$offsetX$delegate, this.$offsetY$delegate, interfaceC0793Of);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo13invoke(PointerInputScope pointerInputScope, InterfaceC0793Of interfaceC0793Of) {
                return ((AnonymousClass3) create(pointerInputScope, interfaceC0793Of)).invokeSuspend(FW.a);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = AbstractC0378Bt.d();
                int i = this.label;
                if (i == 0) {
                    LL.b(obj);
                    PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, this.$state, this.$autoSwitchToMinute);
                    C01312 c01312 = new C01312(this.$scope, this.$state, this.$maxDist, this.$offsetX$delegate, this.$offsetY$delegate);
                    this.label = 1;
                    if (DragGestureDetectorKt.detectDragGestures$default(pointerInputScope, null, anonymousClass1, null, c01312, this, 5, null) == objD) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16032(TimePickerState timePickerState, boolean z) {
            super(3);
            this.$state = timePickerState;
            this.$autoSwitchToMinute = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$1(MutableState<Float> mutableState) {
            return mutableState.getValue().floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(MutableState<Float> mutableState, float f) {
            mutableState.setValue(Float.valueOf(f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float invoke$lambda$4(MutableState<Float> mutableState) {
            return mutableState.getValue().floatValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$5(MutableState<Float> mutableState, float f) {
            mutableState.setValue(Float.valueOf(f));
        }

        private static final long invoke$lambda$7(MutableState<IntOffset> mutableState) {
            return mutableState.getValue().m5287unboximpl();
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        }

        @Composable
        public final Modifier invoke(Modifier modifier, Composer composer, int i) {
            AbstractC4492zt.h(modifier, "$this$composed");
            composer.startReplaceableGroup(-1645090088);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1645090088, i, -1, "androidx.compose.material3.clockDial.<anonymous> (TimePicker.kt:1244)");
            }
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m5269boximpl(IntOffset.Companion.m5288getZeronOccac()), null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            MutableState mutableState3 = (MutableState) objRememberedValue3;
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue4 = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue4).getCoroutineScope();
            composer.endReplaceableGroup();
            float fMo333toPx0680j_4 = ((Density) composer.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(TimePickerKt.MaxDistance);
            Modifier.Companion companion2 = Modifier.Companion;
            TimePickerState timePickerState = this.$state;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(timePickerState);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new TimePickerKt$clockDial$2$1$1(timePickerState);
                composer.updateRememberedValue(objRememberedValue5);
            }
            composer.endReplaceableGroup();
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(OnRemeasuredModifierKt.onSizeChanged(companion2, (InterfaceC3750qp) objRememberedValue5), new Object[]{this.$state, IntOffset.m5269boximpl(invoke$lambda$7(mutableState3)), Float.valueOf(fMo333toPx0680j_4)}, (InterfaceC0526Fp) new C01282(mutableState, mutableState2, coroutineScope, this.$state, fMo333toPx0680j_4, this.$autoSwitchToMinute, null)), new Object[]{this.$state, IntOffset.m5269boximpl(invoke$lambda$7(mutableState3)), Float.valueOf(fMo333toPx0680j_4)}, (InterfaceC0526Fp) new AnonymousClass3(coroutineScope, this.$state, this.$autoSwitchToMinute, fMo333toPx0680j_4, mutableState, mutableState2, null));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return modifierPointerInput;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$drawSelector$1, reason: invalid class name and case insensitive filesystem */
    public static final class C16041 extends AbstractC2233fv implements InterfaceC3750qp {
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ TimePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C16041(TimePickerState timePickerState, TimePickerColors timePickerColors) {
            super(1);
            this.$state = timePickerState;
            this.$colors = timePickerColors;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ContentDrawScope) obj);
            return FW.a;
        }

        public final void invoke(ContentDrawScope contentDrawScope) {
            AbstractC4492zt.h(contentDrawScope, "$this$drawWithContent");
            long jOffset = OffsetKt.Offset(contentDrawScope.mo333toPx0680j_4(DpOffset.m5221getXD9Ej5fM(this.$state.m1975getSelectorPosRKDOV3M$material3_release())), contentDrawScope.mo333toPx0680j_4(DpOffset.m5223getYD9Ej5fM(this.$state.m1975getSelectorPosRKDOV3M$material3_release())));
            TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
            float f = 2;
            float fMo333toPx0680j_4 = contentDrawScope.mo333toPx0680j_4(timePickerTokens.m2551getClockDialSelectorHandleContainerSizeD9Ej5fM()) / f;
            long jM1937getSelectorColor0d7_KjU$material3_release = this.$colors.m1937getSelectorColor0d7_KjU$material3_release();
            long jM3058getBlack0d7_KjU = Color.Companion.m3058getBlack0d7_KjU();
            BlendMode.Companion companion = BlendMode.Companion;
            AbstractC3255kk.x(contentDrawScope, jM3058getBlack0d7_KjU, fMo333toPx0680j_4, jOffset, 0.0f, null, null, companion.m2955getClear0nO6VwU(), 56, null);
            contentDrawScope.drawContent();
            AbstractC3255kk.x(contentDrawScope, jM1937getSelectorColor0d7_KjU$material3_release, fMo333toPx0680j_4, jOffset, 0.0f, null, null, companion.m2983getXor0nO6VwU(), 56, null);
            AbstractC3255kk.C(contentDrawScope, jM1937getSelectorColor0d7_KjU$material3_release, androidx.compose.ui.geometry.SizeKt.m2877getCenteruvyYCjk(contentDrawScope.mo3469getSizeNHjbRc()), Offset.m2802minusMKHz9U(jOffset, OffsetKt.Offset(((float) Math.cos(this.$state.getCurrentAngle$material3_release().getValue().floatValue())) * fMo333toPx0680j_4, ((float) Math.sin(this.$state.getCurrentAngle$material3_release().getValue().floatValue())) * fMo333toPx0680j_4)), contentDrawScope.mo333toPx0680j_4(timePickerTokens.m2552getClockDialSelectorTrackContainerWidthD9Ej5fM()), 0, null, 0.0f, null, companion.m2982getSrcOver0nO6VwU(), 240, null);
            AbstractC3255kk.x(contentDrawScope, jM1937getSelectorColor0d7_KjU$material3_release, contentDrawScope.mo333toPx0680j_4(timePickerTokens.m2550getClockDialSelectorCenterContainerSizeD9Ej5fM()) / f, androidx.compose.ui.geometry.SizeKt.m2877getCenteruvyYCjk(contentDrawScope.mo3469getSizeNHjbRc()), 0.0f, null, null, 0, 120, null);
            AbstractC3255kk.x(contentDrawScope, this.$colors.m1933clockDialContentColorvNxB06k$material3_release(true), fMo333toPx0680j_4, jOffset, 0.0f, null, null, companion.m2965getDstOver0nO6VwU(), 56, null);
        }
    }

    static {
        float f = 24;
        ClockFaceBottomMargin = Dp.m5160constructorimpl(f);
        DisplaySeparatorWidth = Dp.m5160constructorimpl(f);
        TimeInputBottomPadding = Dp.m5160constructorimpl(f);
        List<Integer> listP = AbstractC1886cc.p(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Hours = listP;
        List<Integer> list = listP;
        ArrayList arrayList = new ArrayList(AbstractC2044dc.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf((((Number) it.next()).intValue() % 12) + 12));
        }
        ExtraHours = arrayList;
        PeriodToggleMargin = Dp.m5160constructorimpl(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: CircularLayout-uFdPcIQ, reason: not valid java name */
    public static final void m1944CircularLayoutuFdPcIQ(Modifier modifier, final float f, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1548175696);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 256 : 128;
        }
        if ((i3 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1548175696, i3, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1497)");
            }
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
                    return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i5);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
                    return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i5);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    Object next;
                    Object next2;
                    AbstractC4492zt.h(measureScope, "$this$Layout");
                    AbstractC4492zt.h(list, "measurables");
                    float fMo333toPx0680j_4 = measureScope.mo333toPx0680j_4(f);
                    long jM5119copyZbe2FdA$default = Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                    List<? extends Measurable> list2 = list;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list2) {
                        Measurable measurable = (Measurable) obj;
                        if (LayoutIdKt.getLayoutId(measurable) != LayoutId.Selector && LayoutIdKt.getLayoutId(measurable) != LayoutId.InnerCircle) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(arrayList, 10));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((Measurable) it.next()).mo4159measureBRTryo0(jM5119copyZbe2FdA$default));
                    }
                    Iterator<T> it2 = list2.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (LayoutIdKt.getLayoutId((Measurable) next) != LayoutId.Selector);
                    Measurable measurable2 = (Measurable) next;
                    Iterator<T> it3 = list2.iterator();
                    do {
                        if (!it3.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it3.next();
                    } while (LayoutIdKt.getLayoutId((Measurable) next2) != LayoutId.InnerCircle);
                    Measurable measurable3 = (Measurable) next2;
                    return MeasureScope.CC.q(measureScope, Constraints.m5130getMinWidthimpl(j), Constraints.m5129getMinHeightimpl(j), null, new TimePickerKt$CircularLayout$1$measure$1(measurable2 != null ? measurable2.mo4159measureBRTryo0(jM5119copyZbe2FdA$default) : null, arrayList2, measurable3 != null ? measurable3.mo4159measureBRTryo0(jM5119copyZbe2FdA$default) : null, j, fMo333toPx0680j_4, 6.2831855f / arrayList2.size()), 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
                    return AbstractC2260gB.c(this, intrinsicMeasureScope, list, i5);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i5) {
                    return AbstractC2260gB.d(this, intrinsicMeasureScope, list, i5);
                }
            };
            int i5 = ((i3 >> 6) & 14) | ((i3 << 3) & 112);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifier);
            int i6 = ((i5 << 9) & 7168) | 6;
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            interfaceC0526Fp.mo13invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 9) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$CircularLayout$2(modifier2, f, interfaceC0526Fp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ClockDisplayNumbers(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-934561141);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, i2, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:839)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont()))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -477913269, true, new AnonymousClass1(timePickerState, timePickerColors, i2)), composerStartRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(timePickerState, timePickerColors, i));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ClockFace(TimePickerState timePickerState, TimePickerColors timePickerColors, boolean z, Composer composer, int i) {
        int i2;
        AbstractC4492zt.h(timePickerState, "state");
        AbstractC4492zt.h(timePickerColors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1525091100);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1525091100, i2, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1125)");
            }
            CrossfadeKt.Crossfade(timePickerState.getValues$material3_release(), SemanticsModifierKt.semantics$default(SizeKt.m532size3ABfNKs(BackgroundKt.m166backgroundbw27NRU(Modifier.Companion, timePickerColors.m1934getClockDialColor0d7_KjU$material3_release(), RoundedCornerShapeKt.getCircleShape()), TimePickerTokens.INSTANCE.m2549getClockDialContainerSizeD9Ej5fM()), false, C15881.INSTANCE, 1, null), AnimationSpecKt.tween$default(350, 0, null, 6, null), (String) null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1628166511, true, new C15892(timePickerState, z, timePickerColors, i2)), composerStartRestartGroup, 24584, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(timePickerState, timePickerColors, z, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:52:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:55:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:56:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:61:0x0229  */
    /* JADX WARN: Code duplicated, block: B:64:0x0279  */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ClockText(TimePickerState timePickerState, int i, boolean z, Composer composer, int i2) {
        int i3;
        String str;
        InterfaceC3588op constructor;
        boolean zChanged;
        Object objRememberedValue;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1317232110);
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1317232110, i3, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1286)");
            }
            TextStyle textStyleCopyAndSetFontPadding = IncludeFontPaddingHelper_androidKt.copyAndSetFontPadding(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), TimePickerTokens.INSTANCE.getClockDialLabelTextFont()), false);
            float fMo333toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo333toPx0680j_4(MaxDistance);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2787boximpl(Offset.Companion.m2814getZeroF1C5BW0()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue2;
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue3 = compositionScopedCoroutineScopeCanceller;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue3).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            String strM1952numberContentDescriptionYKJpE6Y = m1952numberContentDescriptionYKJpE6Y(timePickerState.m1974getSelectionJiIwxys$material3_release(), timePickerState.is24hour(), i, composerStartRestartGroup, (i3 << 3) & 896);
            String localString = toLocalString(i, 1);
            boolean zD = Selection.m1746equalsimpl0(timePickerState.m1974getSelectionJiIwxys$material3_release(), Selection.Companion.m1751getMinuteJiIwxys()) ? AbstractC4492zt.d(toLocalString(timePickerState.getMinute(), 1), localString) : AbstractC4492zt.d(toLocalString(timePickerState.getHour(), 1), localString);
            Alignment center = Alignment.Companion.getCenter();
            Modifier.Companion companion2 = Modifier.Companion;
            Modifier modifierM532size3ABfNKs = SizeKt.m532size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(companion2), MinimumInteractiveSize);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                str = localString;
            } else {
                str = localString;
                if (objRememberedValue4 == companion.getEmpty()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                String str2 = str;
                Modifier modifierSemantics = SemanticsModifierKt.semantics(FocusableKt.focusable$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM532size3ABfNKs, (InterfaceC3750qp) objRememberedValue4), false, null, 3, null), true, new C15902(zD, coroutineScope, timePickerState, fMo333toPx0680j_4, z, mutableState));
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                constructor = companion3.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierSemantics);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1952numberContentDescriptionYKJpE6Y);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = new TimePickerKt$ClockText$3$1$1(strM1952numberContentDescriptionYKJpE6Y);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composer2 = composerStartRestartGroup;
                TextKt.m1930Text4IGK_g(str2, SemanticsModifierKt.clearAndSetSemantics(companion2, (InterfaceC3750qp) objRememberedValue), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, textStyleCopyAndSetFontPadding, composer2, 0, 0, 65532);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            objRememberedValue4 = new TimePickerKt$ClockText$1$1(mutableState);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            composerStartRestartGroup.endReplaceableGroup();
            String str3 = str;
            Modifier modifierSemantics2 = SemanticsModifierKt.semantics(FocusableKt.focusable$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM532size3ABfNKs, (InterfaceC3750qp) objRememberedValue4), false, null, 3, null), true, new C15902(zD, coroutineScope, timePickerState, fMo333toPx0680j_4, z, mutableState));
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
            constructor = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierSemantics2);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion4.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion4.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion4.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(strM1952numberContentDescriptionYKJpE6Y);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new TimePickerKt$ClockText$3$1$1(strM1952numberContentDescriptionYKJpE6Y);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new TimePickerKt$ClockText$3$1$1(strM1952numberContentDescriptionYKJpE6Y);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            TextKt.m1930Text4IGK_g(str3, SemanticsModifierKt.clearAndSetSemantics(companion2, (InterfaceC3750qp) objRememberedValue), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, textStyleCopyAndSetFontPadding, composer2, 0, 0, 65532);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(timePickerState, i, z, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$29(MutableState<Offset> mutableState) {
        return mutableState.getValue().m2808unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText$lambda$30(MutableState<Offset> mutableState, long j) {
        mutableState.setValue(Offset.m2787boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DisplaySeparator(Modifier modifier, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2100674302);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, i, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1046)");
            }
            TextStyle textStyle = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
            TextStyle textStyleCopyAndSetFontPadding = IncludeFontPaddingHelper_androidKt.copyAndSetFontPadding(textStyle.m4719copyCXVQc50((4128601 & 1) != 0 ? textStyle.spanStyle.m4664getColor0d7_KjU() : 0L, (4128601 & 2) != 0 ? textStyle.spanStyle.m4665getFontSizeXSAIIZE() : 0L, (4128601 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (4128601 & 8) != 0 ? textStyle.spanStyle.m4666getFontStyle4Lr2A7w() : null, (4128601 & 16) != 0 ? textStyle.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (4128601 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (4128601 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (4128601 & 128) != 0 ? textStyle.spanStyle.m4668getLetterSpacingXSAIIZE() : 0L, (4128601 & 256) != 0 ? textStyle.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (4128601 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (4128601 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (4128601 & 2048) != 0 ? textStyle.spanStyle.m4662getBackground0d7_KjU() : 0L, (4128601 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (4128601 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (4128601 & 16384) != 0 ? textStyle.paragraphStyle.m4620getTextAlignbuA522U() : TextAlign.m5059boximpl(TextAlign.Companion.m5066getCentere0LSkKk()), (4128601 & 32768) != 0 ? textStyle.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (4128601 & 65536) != 0 ? textStyle.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (4128601 & 131072) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (4128601 & 262144) != 0 ? textStyle.platformStyle : null, (4128601 & 524288) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : new LineHeightStyle(LineHeightStyle.Alignment.Companion.m5043getCenterPIaL0Z0(), LineHeightStyle.Trim.Companion.m5055getBothEVpEnUU(), null), (4128601 & 1048576) != 0 ? textStyle.paragraphStyle.m4617getLineBreakLgCVezo() : null, (4128601 & 2097152) != 0 ? textStyle.paragraphStyle.m4615getHyphensEaSxIns() : null), false);
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, C15911.INSTANCE);
            Alignment center = Alignment.Companion.getCenter();
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierClearAndSetSemantics);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2 = composerStartRestartGroup;
            TextKt.m1930Text4IGK_g(":", (Modifier) null, ColorSchemeKt.toColor(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), composerStartRestartGroup, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, textStyleCopyAndSetFontPadding, composer2, 6, 0, 65530);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15923(modifier, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void HorizontalClockDisplay(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(755539561);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755539561, i2, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:801)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion;
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, companion2.getStart(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ClockDisplayNumbers(timePickerState, timePickerColors, composerStartRestartGroup, i2 & 126);
            composerStartRestartGroup.startReplaceableGroup(-552398963);
            if (!timePickerState.is24hour()) {
                Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(companion, 0.0f, PeriodToggleMargin, 0.0f, 0.0f, 13, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                InterfaceC3588op constructor2 = companion3.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
                int i3 = i2 << 3;
                HorizontalPeriodToggle(SizeKt.m534sizeVpY3zN4(companion, timePickerTokens.m2555getPeriodSelectorHorizontalContainerWidthD9Ej5fM(), timePickerTokens.m2554getPeriodSelectorHorizontalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, (i3 & 896) | (i3 & 112) | 6);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15932(timePickerState, timePickerColors, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void HorizontalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1261215927);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, i2, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:878)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$MeasurePolicy");
                        AbstractC4492zt.h(list, "measurables");
                        List<? extends Measurable> list2 = list;
                        for (Measurable measurable : list2) {
                            if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable), "Spacer")) {
                                Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, AbstractC1210aB.c(measureScope.mo333toPx0680j_4(TimePickerTokens.INSTANCE.m2556getPeriodSelectorOutlineWidthD9Ej5fM())), 0, 0, 12, null));
                                ArrayList arrayList = new ArrayList();
                                for (Object obj : list2) {
                                    if (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) obj), "Spacer")) {
                                        arrayList.add(obj);
                                    }
                                }
                                ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(arrayList, 10));
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    arrayList2.add(((Measurable) it.next()).mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, Constraints.m5128getMaxWidthimpl(j) / 2, 0, 0, 12, null)));
                                }
                                return MeasureScope.CC.q(measureScope, Constraints.m5128getMaxWidthimpl(j), Constraints.m5127getMaxHeightimpl(j), null, new TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1$measure$1(arrayList2, placeableMo4159measureBRTryo0), 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
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
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            Shape shape = ShapesKt.toShape(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            AbstractC4492zt.f(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shape;
            PeriodToggleImpl(modifier, timePickerState, timePickerColors, measurePolicy, ShapesKt.start(cornerBasedShape), ShapesKt.end(cornerBasedShape), composerStartRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15941(modifier, timePickerState, timePickerColors, i));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:73:0x015c  */
    /* JADX WARN: Code duplicated, block: B:76:0x0168  */
    /* JADX WARN: Code duplicated, block: B:77:0x016c  */
    /* JADX WARN: Code duplicated, block: B:80:0x01da  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void HorizontalTimePicker(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, boolean z, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        TimePickerColors timePickerColorsM1942colorsu3YEpmA;
        int i4;
        int i5;
        Modifier modifier3;
        Composer composer2;
        Composer composer3;
        InterfaceC3588op constructor;
        Modifier modifier4;
        TimePickerColors timePickerColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(timePickerState, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(5079681);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    timePickerColorsM1942colorsu3YEpmA = timePickerColors;
                    int i7 = composerStartRestartGroup.changed(timePickerColorsM1942colorsu3YEpmA) ? 256 : 128;
                    i3 |= i7;
                } else {
                    timePickerColorsM1942colorsu3YEpmA = timePickerColors;
                }
                i3 |= i7;
            } else {
                timePickerColorsM1942colorsu3YEpmA = timePickerColors;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
                i3 |= i4;
            }
            i5 = i3;
            if ((i5 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        i5 &= -897;
                        modifier2 = modifier3;
                        timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 24576, 16383);
                    } else {
                        composer2 = composerStartRestartGroup;
                        modifier2 = modifier3;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i5 &= -897;
                    }
                    composer2 = composerStartRestartGroup;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(5079681, i5, -1, "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:676)");
                }
                Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(modifier2, 0.0f, 0.0f, 0.0f, ClockFaceBottomMargin, 7, null);
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                composer3 = composer2;
                composer3.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                composer3.startReplaceableGroup(-1323940314);
                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                constructor = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default);
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                composer3.disableReusing();
                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer3);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
                composer3.enableReusing();
                interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer3)), composer3, 0);
                composer3.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i8 = i5 >> 3;
                int i9 = (i5 & 14) | (i8 & 112);
                HorizontalClockDisplay(timePickerState, timePickerColorsM1942colorsu3YEpmA, composer3, i9);
                SpacerKt.Spacer(SizeKt.m537width3ABfNKs(Modifier.Companion, ClockDisplayBottomMargin), composer3, 6);
                ClockFace(timePickerState, timePickerColorsM1942colorsu3YEpmA, z, composer3, i9 | (i8 & 896));
                composer3.endReplaceableGroup();
                composer3.endNode();
                composer3.endReplaceableGroup();
                composer3.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier2;
                timePickerColors2 = timePickerColorsM1942colorsu3YEpmA;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                timePickerColors2 = timePickerColorsM1942colorsu3YEpmA;
                composer3 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C15952(timePickerState, modifier4, timePickerColors2, z, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                timePickerColorsM1942colorsu3YEpmA = timePickerColors;
                if (composerStartRestartGroup.changed(timePickerColorsM1942colorsu3YEpmA)) {
                }
                i3 |= i7;
            } else {
                timePickerColorsM1942colorsu3YEpmA = timePickerColors;
            }
            i3 |= i7;
        } else {
            timePickerColorsM1942colorsu3YEpmA = timePickerColors;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        i5 = i3;
        if ((i5 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    i5 &= -897;
                    modifier2 = modifier3;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 24576, 16383);
                } else {
                    composer2 = composerStartRestartGroup;
                    modifier2 = modifier3;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    i5 &= -897;
                    modifier2 = modifier3;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 24576, 16383);
                } else {
                    composer2 = composerStartRestartGroup;
                    modifier2 = modifier3;
                }
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(5079681, i5, -1, "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:676)");
            }
            Modifier modifierM489paddingqDBjuR0$default2 = PaddingKt.m489paddingqDBjuR0$default(modifier2, 0.0f, 0.0f, 0.0f, ClockFaceBottomMargin, 7, null);
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            composer3 = composer2;
            composer3.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer3, 48);
            composer3.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default2);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            composer3.disableReusing();
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer3);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
            composer3.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer3)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            int i10 = i5 >> 3;
            int i11 = (i5 & 14) | (i10 & 112);
            HorizontalClockDisplay(timePickerState, timePickerColorsM1942colorsu3YEpmA, composer3, i11);
            SpacerKt.Spacer(SizeKt.m537width3ABfNKs(Modifier.Companion, ClockDisplayBottomMargin), composer3, 6);
            ClockFace(timePickerState, timePickerColorsM1942colorsu3YEpmA, z, composer3, i11 | (i10 & 896));
            composer3.endReplaceableGroup();
            composer3.endNode();
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier2;
            timePickerColors2 = timePickerColorsM1942colorsu3YEpmA;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    i5 &= -897;
                    modifier2 = modifier3;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 24576, 16383);
                } else {
                    composer2 = composerStartRestartGroup;
                    modifier2 = modifier3;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    i5 &= -897;
                    modifier2 = modifier3;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 24576, 16383);
                } else {
                    composer2 = composerStartRestartGroup;
                    modifier2 = modifier3;
                }
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(5079681, i5, -1, "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:676)");
            }
            Modifier modifierM489paddingqDBjuR0$default3 = PaddingKt.m489paddingqDBjuR0$default(modifier2, 0.0f, 0.0f, 0.0f, ClockFaceBottomMargin, 7, null);
            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
            composer3 = composer2;
            composer3.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composer3, 48);
            composer3.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default3);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            composer3.disableReusing();
            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composer3);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyRowMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion3.getSetViewConfiguration());
            composer3.enableReusing();
            interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer3)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            int i12 = i5 >> 3;
            int i13 = (i5 & 14) | (i12 & 112);
            HorizontalClockDisplay(timePickerState, timePickerColorsM1942colorsu3YEpmA, composer3, i13);
            SpacerKt.Spacer(SizeKt.m537width3ABfNKs(Modifier.Companion, ClockDisplayBottomMargin), composer3, 6);
            ClockFace(timePickerState, timePickerColorsM1942colorsu3YEpmA, z, composer3, i13 | (i12 & 896));
            composer3.endReplaceableGroup();
            composer3.endNode();
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier2;
            timePickerColors2 = timePickerColorsM1942colorsu3YEpmA;
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15952(timePickerState, modifier4, timePickerColors2, z, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PeriodToggleImpl(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, MeasurePolicy measurePolicy, Shape shape, Shape shape2, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1374241901);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(measurePolicy) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(shape2) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1374241901, i2, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:964)");
            }
            TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
            BorderStroke borderStrokeM194BorderStrokecXLIe8U = BorderStrokeKt.m194BorderStrokecXLIe8U(timePickerTokens.m2556getPeriodSelectorOutlineWidthD9Ej5fM(), timePickerColors.m1936getPeriodSelectorBorderColor0d7_KjU$material3_release());
            Shape shape3 = ShapesKt.toShape(timePickerTokens.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            AbstractC4492zt.f(shape3, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shape3;
            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1838getTimePickerPeriodToggleadMyvUU(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new TimePickerKt$PeriodToggleImpl$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierBorder = BorderKt.border(SelectableGroupKt.selectableGroup(SemanticsModifierKt.semantics$default(modifier, false, (InterfaceC3750qp) objRememberedValue, 1, null)).then(modifier), borderStrokeM194BorderStrokecXLIe8U, cornerBasedShape);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierBorder);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            boolean z = !timePickerState.isAfternoonToggle$material3_release();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(timePickerState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new TimePickerKt$PeriodToggleImpl$2$1$1(timePickerState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ComposableSingletons$TimePickerKt composableSingletons$TimePickerKt = ComposableSingletons$TimePickerKt.INSTANCE;
            int i3 = (i2 << 3) & 7168;
            ToggleItem(z, shape, (InterfaceC3588op) objRememberedValue2, timePickerColors, composableSingletons$TimePickerKt.m1484getLambda1$material3_release(), composerStartRestartGroup, ((i2 >> 9) & 112) | 24576 | i3);
            SpacerKt.Spacer(BackgroundKt.m167backgroundbw27NRU$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(LayoutIdKt.layoutId(Modifier.Companion, "Spacer"), 2.0f), 0.0f, 1, null), ColorSchemeKt.toColor(timePickerTokens.getPeriodSelectorOutlineColor(), composerStartRestartGroup, 6), null, 2, null), composerStartRestartGroup, 0);
            boolean zIsAfternoonToggle$material3_release = timePickerState.isAfternoonToggle$material3_release();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged3 = composerStartRestartGroup.changed(timePickerState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new TimePickerKt$PeriodToggleImpl$2$2$1(timePickerState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ToggleItem(zIsAfternoonToggle$material3_release, shape2, (InterfaceC3588op) objRememberedValue3, timePickerColors, composableSingletons$TimePickerKt.m1485getLambda2$material3_release(), composerStartRestartGroup, ((i2 >> 12) & 112) | 24576 | i3);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15963(modifier, timePickerState, timePickerColors, measurePolicy, shape, shape2, i));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterial3Api
    public static final void TimeInput(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        TimePickerColors timePickerColorsM1942colorsu3YEpmA;
        Modifier modifier3;
        TimePickerColors timePickerColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(timePickerState, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-760850373);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    timePickerColorsM1942colorsu3YEpmA = timePickerColors;
                    int i5 = composerStartRestartGroup.changed(timePickerColorsM1942colorsu3YEpmA) ? 256 : 128;
                    i3 |= i5;
                } else {
                    timePickerColorsM1942colorsu3YEpmA = timePickerColors;
                }
                i3 |= i5;
            } else {
                timePickerColorsM1942colorsu3YEpmA = timePickerColors;
            }
            if ((i3 & 731) == 146 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                    }
                    modifier2 = modifier3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-760850373, i3, -1, "androidx.compose.material3.TimeInput (TimePicker.kt:230)");
                }
                TimeInputImpl(modifier2, timePickerColorsM1942colorsu3YEpmA, timePickerState, composerStartRestartGroup, ((i3 >> 3) & 126) | ((i3 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            timePickerColors2 = timePickerColorsM1942colorsu3YEpmA;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C15971(timePickerState, modifier2, timePickerColors2, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                timePickerColorsM1942colorsu3YEpmA = timePickerColors;
                if (composerStartRestartGroup.changed(timePickerColorsM1942colorsu3YEpmA)) {
                }
                i3 |= i5;
            } else {
                timePickerColorsM1942colorsu3YEpmA = timePickerColors;
            }
            i3 |= i5;
        } else {
            timePickerColorsM1942colorsu3YEpmA = timePickerColors;
        }
        if ((i3 & 731) == 146) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                }
                modifier2 = modifier3;
            } else {
                if (i4 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                }
                modifier2 = modifier3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-760850373, i3, -1, "androidx.compose.material3.TimeInput (TimePicker.kt:230)");
            }
            TimeInputImpl(modifier2, timePickerColorsM1942colorsu3YEpmA, timePickerState, composerStartRestartGroup, ((i3 >> 3) & 126) | ((i3 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                }
                modifier2 = modifier3;
            } else {
                if (i4 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                }
                modifier2 = modifier3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-760850373, i3, -1, "androidx.compose.material3.TimeInput (TimePicker.kt:230)");
            }
            TimeInputImpl(modifier2, timePickerColorsM1942colorsu3YEpmA, timePickerState, composerStartRestartGroup, ((i3 >> 3) & 126) | ((i3 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        timePickerColors2 = timePickerColorsM1942colorsu3YEpmA;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15971(timePickerState, modifier2, timePickerColors2, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TimeInputImpl(Modifier modifier, TimePickerColors timePickerColors, TimePickerState timePickerState, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-475657989);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerState) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475657989, i3, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:693)");
            }
            Object[] objArr = new Object[0];
            TextFieldValue.Companion companion = TextFieldValue.Companion;
            Saver<TextFieldValue, Object> saver = companion.getSaver();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(timePickerState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new TimePickerKt$TimeInputImpl$hourValue$2$1(timePickerState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableState mutableStateRememberSaveable = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (String) null, (InterfaceC3588op) objRememberedValue, composerStartRestartGroup, 72, 4);
            Object[] objArr2 = new Object[0];
            Saver<TextFieldValue, Object> saver2 = companion.getSaver();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(timePickerState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new TimePickerKt$TimeInputImpl$minuteValue$2$1(timePickerState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableState mutableStateRememberSaveable2 = RememberSaveableKt.rememberSaveable(objArr2, (Saver) saver2, (String) null, (InterfaceC3588op) objRememberedValue2, composerStartRestartGroup, 72, 4);
            composer2 = composerStartRestartGroup;
            Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, TimeInputBottomPadding, 7, null);
            Alignment.Companion companion2 = Alignment.Companion;
            Alignment.Vertical top = companion2.getTop();
            composer2.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), top, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Typography typography = MaterialTheme.INSTANCE.getTypography(composer2, 6);
            TimeInputTokens timeInputTokens = TimeInputTokens.INSTANCE;
            TextStyle textStyleFromToken = TypographyKt.fromToken(typography, timeInputTokens.getTimeFieldLabelTextFont());
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(textStyleFromToken.m4719copyCXVQc50((4128601 & 1) != 0 ? textStyleFromToken.spanStyle.m4664getColor0d7_KjU() : timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), (4128601 & 2) != 0 ? textStyleFromToken.spanStyle.m4665getFontSizeXSAIIZE() : 0L, (4128601 & 4) != 0 ? textStyleFromToken.spanStyle.getFontWeight() : null, (4128601 & 8) != 0 ? textStyleFromToken.spanStyle.m4666getFontStyle4Lr2A7w() : null, (4128601 & 16) != 0 ? textStyleFromToken.spanStyle.m4667getFontSynthesisZQGJjVo() : null, (4128601 & 32) != 0 ? textStyleFromToken.spanStyle.getFontFamily() : null, (4128601 & 64) != 0 ? textStyleFromToken.spanStyle.getFontFeatureSettings() : null, (4128601 & 128) != 0 ? textStyleFromToken.spanStyle.m4668getLetterSpacingXSAIIZE() : 0L, (4128601 & 256) != 0 ? textStyleFromToken.spanStyle.m4663getBaselineShift5SSeXJ0() : null, (4128601 & 512) != 0 ? textStyleFromToken.spanStyle.getTextGeometricTransform() : null, (4128601 & 1024) != 0 ? textStyleFromToken.spanStyle.getLocaleList() : null, (4128601 & 2048) != 0 ? textStyleFromToken.spanStyle.m4662getBackground0d7_KjU() : 0L, (4128601 & 4096) != 0 ? textStyleFromToken.spanStyle.getTextDecoration() : null, (4128601 & 8192) != 0 ? textStyleFromToken.spanStyle.getShadow() : null, (4128601 & 16384) != 0 ? textStyleFromToken.paragraphStyle.m4620getTextAlignbuA522U() : TextAlign.m5059boximpl(TextAlign.Companion.m5066getCentere0LSkKk()), (4128601 & 32768) != 0 ? textStyleFromToken.paragraphStyle.m4622getTextDirectionmmuk1to() : null, (4128601 & 65536) != 0 ? textStyleFromToken.paragraphStyle.m4619getLineHeightXSAIIZE() : 0L, (4128601 & 131072) != 0 ? textStyleFromToken.paragraphStyle.getTextIndent() : null, (4128601 & 262144) != 0 ? textStyleFromToken.platformStyle : null, (4128601 & 524288) != 0 ? textStyleFromToken.paragraphStyle.getLineHeightStyle() : null, (4128601 & 1048576) != 0 ? textStyleFromToken.paragraphStyle.m4617getLineBreakLgCVezo() : null, (4128601 & 2097152) != 0 ? textStyleFromToken.paragraphStyle.m4615getHyphensEaSxIns() : null))}, ComposableLambdaKt.composableLambda(composer2, 1306700887, true, new TimePickerKt$TimeInputImpl$1$1(mutableStateRememberSaveable, timePickerState, i3, timePickerColors, mutableStateRememberSaveable2)), composer2, 56);
            composer2.startReplaceableGroup(565119480);
            if (!timePickerState.is24hour()) {
                Modifier modifierM489paddingqDBjuR0$default2 = PaddingKt.m489paddingqDBjuR0$default(modifier, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                InterfaceC3588op constructor2 = companion3.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default2);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer2);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                composer2.enableReusing();
                interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                VerticalPeriodToggle(SizeKt.m534sizeVpY3zN4(Modifier.Companion, timeInputTokens.m2544getPeriodSelectorContainerWidthD9Ej5fM(), timeInputTokens.m2543getPeriodSelectorContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composer2, ((i3 >> 3) & 112) | 6 | ((i3 << 3) & 896));
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15982(modifier, timePickerColors, timePickerState, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$5(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$8(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x004c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0063  */
    /* JADX WARN: Code duplicated, block: B:39:0x0067  */
    /* JADX WARN: Code duplicated, block: B:41:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:75:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:78:0x0106  */
    /* JADX WARN: Code duplicated, block: B:81:0x011d  */
    /* JADX WARN: Code duplicated, block: B:82:0x013a  */
    /* JADX WARN: Code duplicated, block: B:85:0x015b  */
    /* JADX WARN: Code duplicated, block: B:90:0x0168  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterial3Api
    /* JADX INFO: renamed from: TimePicker-mT9BvqQ, reason: not valid java name */
    public static final void m1945TimePickermT9BvqQ(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, Composer composer, int i2, int i3) {
        int i4;
        Modifier modifier2;
        TimePickerColors timePickerColors2;
        int i5;
        Modifier modifier3;
        TimePickerColors timePickerColorsM1942colorsu3YEpmA;
        Modifier modifier4;
        TimePickerColors timePickerColors3;
        int iM1943layoutTypesDNSZnc;
        State<Boolean> state;
        Composer composer2;
        Modifier modifier5;
        TimePickerColors timePickerColors4;
        int i6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(timePickerState, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-619286452);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i7 = i3 & 2;
        if (i7 == 0) {
            if ((i2 & 112) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 896) == 0) {
                if ((i3 & 4) == 0) {
                    timePickerColors2 = timePickerColors;
                    int i8 = composerStartRestartGroup.changed(timePickerColors2) ? 256 : 128;
                    i4 |= i8;
                } else {
                    timePickerColors2 = timePickerColors;
                }
                i4 |= i8;
            } else {
                timePickerColors2 = timePickerColors;
            }
            if ((i2 & 7168) == 0) {
                if ((i3 & 8) == 0) {
                    i5 = i;
                    int i9 = composerStartRestartGroup.changed(i5) ? 2048 : 1024;
                    i4 |= i9;
                } else {
                    i5 = i;
                }
                i4 |= i9;
            } else {
                i5 = i;
            }
            if ((i4 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i3 & 4) != 0) {
                        timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                        i4 &= -897;
                    } else {
                        timePickerColorsM1942colorsu3YEpmA = timePickerColors2;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                        modifier4 = modifier3;
                        timePickerColors3 = timePickerColorsM1942colorsu3YEpmA;
                        iM1943layoutTypesDNSZnc = TimePickerDefaults.INSTANCE.m1943layoutTypesDNSZnc(composerStartRestartGroup, 6);
                    } else {
                        modifier4 = modifier3;
                        timePickerColors3 = timePickerColorsM1942colorsu3YEpmA;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-619286452, i4, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:188)");
                    }
                    state = TouchExplorationStateProvider_androidKt.touchExplorationState(composerStartRestartGroup, 0);
                    if (TimePickerLayoutType.m1967equalsimpl0(iM1943layoutTypesDNSZnc, TimePickerLayoutType.Companion.m1972getVerticalQJTpgSE())) {
                        composerStartRestartGroup.startReplaceableGroup(1318081657);
                        composer2 = composerStartRestartGroup;
                        VerticalTimePicker(timePickerState, modifier4, timePickerColors3, !TimePicker_mT9BvqQ$lambda$0(state), composerStartRestartGroup, i4 & 1022, 0);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.startReplaceableGroup(1318081863);
                        HorizontalTimePicker(timePickerState, modifier4, timePickerColors3, !TimePicker_mT9BvqQ$lambda$0(state), composer2, i4 & 1022, 0);
                        composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    timePickerColors4 = timePickerColors3;
                    i6 = iM1943layoutTypesDNSZnc;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    modifier4 = modifier2;
                    timePickerColors3 = timePickerColors2;
                }
                iM1943layoutTypesDNSZnc = i5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-619286452, i4, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:188)");
                }
                state = TouchExplorationStateProvider_androidKt.touchExplorationState(composerStartRestartGroup, 0);
                if (TimePickerLayoutType.m1967equalsimpl0(iM1943layoutTypesDNSZnc, TimePickerLayoutType.Companion.m1972getVerticalQJTpgSE())) {
                    composerStartRestartGroup.startReplaceableGroup(1318081657);
                    composer2 = composerStartRestartGroup;
                    VerticalTimePicker(timePickerState, modifier4, timePickerColors3, !TimePicker_mT9BvqQ$lambda$0(state), composerStartRestartGroup, i4 & 1022, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceableGroup(1318081863);
                    HorizontalTimePicker(timePickerState, modifier4, timePickerColors3, !TimePicker_mT9BvqQ$lambda$0(state), composer2, i4 & 1022, 0);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                timePickerColors4 = timePickerColors3;
                i6 = iM1943layoutTypesDNSZnc;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier2;
                timePickerColors4 = timePickerColors2;
                i6 = i5;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimePicker$1(timePickerState, modifier5, timePickerColors4, i6, i2, i3));
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 896) == 0) {
            if ((i3 & 4) == 0) {
                timePickerColors2 = timePickerColors;
                if (composerStartRestartGroup.changed(timePickerColors2)) {
                }
                i4 |= i8;
            } else {
                timePickerColors2 = timePickerColors;
            }
            i4 |= i8;
        } else {
            timePickerColors2 = timePickerColors;
        }
        if ((i2 & 7168) == 0) {
            if ((i3 & 8) == 0) {
                i5 = i;
                if (composerStartRestartGroup.changed(i5)) {
                }
                i4 |= i9;
            } else {
                i5 = i;
            }
            i4 |= i9;
        } else {
            i5 = i;
        }
        if ((i4 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 4) != 0) {
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                    i4 &= -897;
                } else {
                    timePickerColorsM1942colorsu3YEpmA = timePickerColors2;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                    modifier4 = modifier3;
                    timePickerColors3 = timePickerColorsM1942colorsu3YEpmA;
                    iM1943layoutTypesDNSZnc = TimePickerDefaults.INSTANCE.m1943layoutTypesDNSZnc(composerStartRestartGroup, 6);
                } else {
                    modifier4 = modifier3;
                    timePickerColors3 = timePickerColorsM1942colorsu3YEpmA;
                    iM1943layoutTypesDNSZnc = i5;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 4) != 0) {
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                    i4 &= -897;
                } else {
                    timePickerColorsM1942colorsu3YEpmA = timePickerColors2;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                    modifier4 = modifier3;
                    timePickerColors3 = timePickerColorsM1942colorsu3YEpmA;
                    iM1943layoutTypesDNSZnc = TimePickerDefaults.INSTANCE.m1943layoutTypesDNSZnc(composerStartRestartGroup, 6);
                } else {
                    modifier4 = modifier3;
                    timePickerColors3 = timePickerColorsM1942colorsu3YEpmA;
                    iM1943layoutTypesDNSZnc = i5;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-619286452, i4, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:188)");
            }
            state = TouchExplorationStateProvider_androidKt.touchExplorationState(composerStartRestartGroup, 0);
            if (TimePickerLayoutType.m1967equalsimpl0(iM1943layoutTypesDNSZnc, TimePickerLayoutType.Companion.m1972getVerticalQJTpgSE())) {
                composerStartRestartGroup.startReplaceableGroup(1318081657);
                composer2 = composerStartRestartGroup;
                VerticalTimePicker(timePickerState, modifier4, timePickerColors3, !TimePicker_mT9BvqQ$lambda$0(state), composerStartRestartGroup, i4 & 1022, 0);
                composer2.endReplaceableGroup();
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(1318081863);
                HorizontalTimePicker(timePickerState, modifier4, timePickerColors3, !TimePicker_mT9BvqQ$lambda$0(state), composer2, i4 & 1022, 0);
                composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            timePickerColors4 = timePickerColors3;
            i6 = iM1943layoutTypesDNSZnc;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 4) != 0) {
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                    i4 &= -897;
                } else {
                    timePickerColorsM1942colorsu3YEpmA = timePickerColors2;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                    modifier4 = modifier3;
                    timePickerColors3 = timePickerColorsM1942colorsu3YEpmA;
                    iM1943layoutTypesDNSZnc = TimePickerDefaults.INSTANCE.m1943layoutTypesDNSZnc(composerStartRestartGroup, 6);
                } else {
                    modifier4 = modifier3;
                    timePickerColors3 = timePickerColorsM1942colorsu3YEpmA;
                    iM1943layoutTypesDNSZnc = i5;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i3 & 4) != 0) {
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 24576, 16383);
                    i4 &= -897;
                } else {
                    timePickerColorsM1942colorsu3YEpmA = timePickerColors2;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                    modifier4 = modifier3;
                    timePickerColors3 = timePickerColorsM1942colorsu3YEpmA;
                    iM1943layoutTypesDNSZnc = TimePickerDefaults.INSTANCE.m1943layoutTypesDNSZnc(composerStartRestartGroup, 6);
                } else {
                    modifier4 = modifier3;
                    timePickerColors3 = timePickerColorsM1942colorsu3YEpmA;
                    iM1943layoutTypesDNSZnc = i5;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-619286452, i4, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:188)");
            }
            state = TouchExplorationStateProvider_androidKt.touchExplorationState(composerStartRestartGroup, 0);
            if (TimePickerLayoutType.m1967equalsimpl0(iM1943layoutTypesDNSZnc, TimePickerLayoutType.Companion.m1972getVerticalQJTpgSE())) {
                composerStartRestartGroup.startReplaceableGroup(1318081657);
                composer2 = composerStartRestartGroup;
                VerticalTimePicker(timePickerState, modifier4, timePickerColors3, !TimePicker_mT9BvqQ$lambda$0(state), composerStartRestartGroup, i4 & 1022, 0);
                composer2.endReplaceableGroup();
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(1318081863);
                HorizontalTimePicker(timePickerState, modifier4, timePickerColors3, !TimePicker_mT9BvqQ$lambda$0(state), composer2, i4 & 1022, 0);
                composer2.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            timePickerColors4 = timePickerColors3;
            i6 = iM1943layoutTypesDNSZnc;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimePicker$1(timePickerState, modifier5, timePickerColors4, i6, i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x013c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0154  */
    /* JADX WARN: Code duplicated, block: B:106:0x016e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0249  */
    /* JADX WARN: Code duplicated, block: B:112:0x0255  */
    /* JADX WARN: Code duplicated, block: B:113:0x0259  */
    /* JADX WARN: Code duplicated, block: B:116:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:118:0x02be  */
    /* JADX WARN: Code duplicated, block: B:119:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:121:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:124:0x030a  */
    /* JADX WARN: Code duplicated, block: B:125:0x0311  */
    /* JADX WARN: Code duplicated, block: B:128:0x0363  */
    /* JADX WARN: Code duplicated, block: B:131:0x036f  */
    /* JADX WARN: Code duplicated, block: B:132:0x0373  */
    /* JADX WARN: Code duplicated, block: B:135:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:137:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:140:0x051a  */
    /* JADX WARN: Code duplicated, block: B:142:0x0524  */
    /* JADX WARN: Code duplicated, block: B:145:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:147:0x05aa  */
    /* JADX WARN: Code duplicated, block: B:150:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:155:0x05d0  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x007f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0082  */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:42:0x008c  */
    /* JADX WARN: Code duplicated, block: B:43:0x008f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0098  */
    /* JADX WARN: Code duplicated, block: B:48:0x009b  */
    /* JADX WARN: Code duplicated, block: B:50:0x009f  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00af  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:88:0x010b  */
    /* JADX WARN: Code duplicated, block: B:92:0x011c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x011e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0127  */
    /* JADX WARN: Code duplicated, block: B:96:0x012b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0134  */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: TimePickerTextField-lxUZ_iY, reason: not valid java name */
    public static final void m1946TimePickerTextFieldlxUZ_iY(Modifier modifier, TextFieldValue textFieldValue, InterfaceC3750qp interfaceC3750qp, TimePickerState timePickerState, int i, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, TimePickerColors timePickerColors, Composer composer, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        KeyboardOptions keyboardOptions2;
        int i8;
        int i9;
        KeyboardActions keyboardActions2;
        int i10;
        int i11;
        KeyboardOptions keyboardOptions3;
        KeyboardActions keyboardActions3;
        Object objRememberedValue;
        Composer.Companion companion;
        Object objRememberedValue2;
        FocusRequester focusRequester;
        boolean zM1746equalsimpl0;
        InterfaceC3588op constructor;
        boolean z;
        ?? r7;
        Selection.Companion companion2;
        int iM1832getTimePickerHourTextFieldadMyvUU;
        String strM1841getStringNWtq28;
        InterfaceC3588op constructor2;
        boolean zChanged;
        Object objRememberedValue3;
        int iM1833getTimePickerMinuteadMyvUU;
        Composer composer2;
        boolean zChanged2;
        Object objRememberedValue4;
        KeyboardOptions keyboardOptions4;
        KeyboardActions keyboardActions4;
        int minute;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-367523658);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(textFieldValue) ? 32 : 16;
        }
        int i12 = i4;
        if ((i3 & 4) == 0) {
            if ((i2 & 896) == 0) {
                i12 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 256 : 128;
            }
            if ((i3 & 8) != 0) {
                i12 |= 3072;
            } else if ((i2 & 7168) == 0) {
                if (composerStartRestartGroup.changed(timePickerState)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i12 |= i5;
            }
            if ((16 & i3) != 0) {
                i12 |= 24576;
            } else if ((i2 & 57344) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i12 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((458752 & i2) == 0) {
                    keyboardOptions2 = keyboardOptions;
                    if (composerStartRestartGroup.changed(keyboardOptions2)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i12 |= i8;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i12 |= 1572864;
                    keyboardActions2 = keyboardActions;
                } else {
                    keyboardActions2 = keyboardActions;
                    if ((i2 & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(keyboardActions2)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i12 |= i10;
                    }
                }
                if ((128 & i3) != 0) {
                    if ((i2 & 29360128) == 0) {
                        if (composerStartRestartGroup.changed(timePickerColors)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                    }
                    if ((23967451 & i12) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        if (i7 != 0) {
                            keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                        } else {
                            keyboardOptions3 = keyboardOptions2;
                        }
                        if (i9 != 0) {
                            keyboardActions3 = KeyboardActions.Companion.getDefault();
                        } else {
                            keyboardActions3 = keyboardActions2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                        }
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.Companion;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        focusRequester = (FocusRequester) objRememberedValue2;
                        TextFieldColors textFieldColorsM1686colors0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                        zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                        composerStartRestartGroup.startReplaceableGroup(-483455358);
                        Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                        Alignment.Companion companion3 = Alignment.Companion;
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                        constructor = companion4.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifier);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion4.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl, density, companion4.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion4.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion4.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        composerStartRestartGroup.startReplaceableGroup(896149831);
                        if (zM1746equalsimpl0) {
                            z = zM1746equalsimpl0;
                            r7 = 0;
                        } else {
                            Modifier.Companion companion5 = Modifier.Companion;
                            TimeInputTokens timeInputTokens = TimeInputTokens.INSTANCE;
                            Modifier modifierM534sizeVpY3zN4 = SizeKt.m534sizeVpY3zN4(companion5, timeInputTokens.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens.m2546getTimeFieldContainerHeightD9Ej5fM());
                            if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                                minute = timePickerState.getHourForDisplay$material3_release();
                            } else {
                                minute = timePickerState.getMinute();
                            }
                            int i13 = i12 >> 3;
                            z = zM1746equalsimpl0;
                            r7 = 0;
                            m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN4, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i13 & 7168) | (i13 & 896) | 6 | ((i12 >> 9) & 57344));
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        companion2 = Selection.Companion;
                        if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                            iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                        } else {
                            iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                        }
                        strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                        Modifier.Companion companion6 = Modifier.Companion;
                        Modifier modifierVisible = visible(companion6, z);
                        composerStartRestartGroup.startReplaceableGroup(733328855);
                        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), r7, composerStartRestartGroup, r7);
                        composerStartRestartGroup.startReplaceableGroup(-1323940314);
                        Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        constructor2 = companion4.getConstructor();
                        InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierVisible);
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor2);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerStartRestartGroup.disableReusing();
                        Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                        Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                        Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion4.getSetDensity());
                        Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion4.getSetLayoutDirection());
                        Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion4.getSetViewConfiguration());
                        composerStartRestartGroup.enableReusing();
                        interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(2058660585);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(companion6, r21);
                        TimeInputTokens timeInputTokens2 = TimeInputTokens.INSTANCE;
                        Modifier modifierM534sizeVpY3zN5 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester, timeInputTokens2.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens2.m2546getTimeFieldContainerHeightD9Ej5fM());
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN5, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                        TextStyle textStyle = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                        Brush.Companion companion7 = Brush.Companion;
                        Float fValueOf = Float.valueOf(0.0f);
                        Color.Companion companion8 = Color.Companion;
                        C2020dG c2020dGA = HV.a(fValueOf, Color.m3022boximpl(companion8.m3067getTransparent0d7_KjU()));
                        C2020dG c2020dGA2 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion8.m3067getTransparent0d7_KjU()));
                        Float fValueOf2 = Float.valueOf(0.1f);
                        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                        int i14 = i12 >> 3;
                        int i15 = i12 << 3;
                        BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default, true, false, textStyle, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource, Brush.Companion.m2996verticalGradient8A3gB4$default(companion7, new C2020dG[]{c2020dGA, c2020dGA2, HV.a(fValueOf2, Color.m3022boximpl(materialTheme.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion8.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion8.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource, textFieldColorsM1686colors0hiis_0)), composerStartRestartGroup, (i14 & 112) | (i14 & 14) | 100666368 | (i15 & 3670016) | (i15 & 29360128), 199680, 7696);
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endNode();
                        composerStartRestartGroup.endReplaceableGroup();
                        composerStartRestartGroup.endReplaceableGroup();
                        Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion6, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                        if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                            iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                        } else {
                            iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                        }
                        composer2 = composerStartRestartGroup;
                        TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics, ColorSchemeKt.toColor(timeInputTokens2.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme.getTypography(composer2, 6), timeInputTokens2.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        Selection selectionM1743boximpl = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                        Selection selectionM1743boximpl2 = Selection.m1743boximpl(i);
                        composer2.startReplaceableGroup(1618982084);
                        zChanged2 = composer2.changed(selectionM1743boximpl2) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                        objRememberedValue4 = composer2.rememberedValue();
                        if (zChanged2 || objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        composer2.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(selectionM1743boximpl, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        keyboardOptions4 = keyboardOptions3;
                        keyboardActions4 = keyboardActions3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        keyboardOptions4 = keyboardOptions2;
                        composer2 = composerStartRestartGroup;
                        keyboardActions4 = keyboardActions2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimePickerTextField$3(modifier, textFieldValue, interfaceC3750qp, timePickerState, i, keyboardOptions4, keyboardActions4, timePickerColors, i2, i3));
                }
                i11 = 12582912;
                i12 |= i11;
                if ((23967451 & i12) == 4793490) {
                    if (i7 != 0) {
                        keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                    } else {
                        keyboardOptions3 = keyboardOptions2;
                    }
                    if (i9 != 0) {
                        keyboardActions3 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions3 = keyboardActions2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue2;
                    TextFieldColors textFieldColorsM1686colors0hiis_1 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                    zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                    composerStartRestartGroup.startReplaceableGroup(-483455358);
                    Arrangement.Vertical top2 = Arrangement.INSTANCE.getTop();
                    Alignment.Companion companion9 = Alignment.Companion;
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, companion9.getStart(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density3 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection3 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion10 = ComposeUiNode.Companion;
                    constructor = companion10.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifier);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyColumnMeasurePolicy2, companion10.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion10.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion10.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion10.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(896149831);
                    if (zM1746equalsimpl0) {
                        Modifier.Companion companion11 = Modifier.Companion;
                        TimeInputTokens timeInputTokens3 = TimeInputTokens.INSTANCE;
                        Modifier modifierM534sizeVpY3zN6 = SizeKt.m534sizeVpY3zN4(companion11, timeInputTokens3.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens3.m2546getTimeFieldContainerHeightD9Ej5fM());
                        if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                            minute = timePickerState.getHourForDisplay$material3_release();
                        } else {
                            minute = timePickerState.getMinute();
                        }
                        int i16 = i12 >> 3;
                        z = zM1746equalsimpl0;
                        r7 = 0;
                        m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN6, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i16 & 7168) | (i16 & 896) | 6 | ((i12 >> 9) & 57344));
                    } else {
                        z = zM1746equalsimpl0;
                        r7 = 0;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companion2 = Selection.Companion;
                    if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                    } else {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                    Modifier.Companion companion12 = Modifier.Companion;
                    Modifier modifierVisible2 = visible(companion12, z);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion9.getTopStart(), r7, composerStartRestartGroup, r7);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density4 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection4 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration4 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion10.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf4 = LayoutKt.materializerOf(modifierVisible2);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl4 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl4, measurePolicyRememberBoxMeasurePolicy2, companion10.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl4, density4, companion10.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl4, layoutDirection4, companion10.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl4, viewConfiguration4, companion10.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf4.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    Modifier modifierFocusRequester2 = FocusRequesterModifierKt.focusRequester(companion12, r21);
                    TimeInputTokens timeInputTokens4 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN7 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester2, timeInputTokens4.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens4.m2546getTimeFieldContainerHeightD9Ej5fM());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN7, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                    TextStyle textStyle2 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                    Brush.Companion companion13 = Brush.Companion;
                    Float fValueOf3 = Float.valueOf(0.0f);
                    Color.Companion companion14 = Color.Companion;
                    C2020dG c2020dGA3 = HV.a(fValueOf3, Color.m3022boximpl(companion14.m3067getTransparent0d7_KjU()));
                    C2020dG c2020dGA4 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion14.m3067getTransparent0d7_KjU()));
                    Float fValueOf4 = Float.valueOf(0.1f);
                    MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                    int i17 = i12 >> 3;
                    int i18 = i12 << 3;
                    BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default2, true, false, textStyle2, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource2, Brush.Companion.m2996verticalGradient8A3gB4$default(companion13, new C2020dG[]{c2020dGA3, c2020dGA4, HV.a(fValueOf4, Color.m3022boximpl(materialTheme2.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme2.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion14.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion14.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource2, textFieldColorsM1686colors0hiis_1)), composerStartRestartGroup, (i17 & 112) | (i17 & 14) | 100666368 | (i18 & 3670016) | (i18 & 29360128), 199680, 7696);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierClearAndSetSemantics2 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion12, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                    if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                    } else {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                    }
                    composer2 = composerStartRestartGroup;
                    TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics2, ColorSchemeKt.toColor(timeInputTokens4.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme2.getTypography(composer2, 6), timeInputTokens4.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    Selection selectionM1743boximpl3 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                    Selection selectionM1743boximpl4 = Selection.m1743boximpl(i);
                    composer2.startReplaceableGroup(1618982084);
                    zChanged2 = composer2.changed(selectionM1743boximpl4) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(selectionM1743boximpl3, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions4 = keyboardActions3;
                } else {
                    if (i7 != 0) {
                        keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                    } else {
                        keyboardOptions3 = keyboardOptions2;
                    }
                    if (i9 != 0) {
                        keyboardActions3 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions3 = keyboardActions2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    MutableInteractionSource mutableInteractionSource3 = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue2;
                    TextFieldColors textFieldColorsM1686colors0hiis_2 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                    zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                    composerStartRestartGroup.startReplaceableGroup(-483455358);
                    Arrangement.Vertical top3 = Arrangement.INSTANCE.getTop();
                    Alignment.Companion companion15 = Alignment.Companion;
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(top3, companion15.getStart(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density5 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection5 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration5 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion16 = ComposeUiNode.Companion;
                    constructor = companion16.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf5 = LayoutKt.materializerOf(modifier);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl5 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl5, measurePolicyColumnMeasurePolicy3, companion16.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl5, density5, companion16.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl5, layoutDirection5, companion16.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl5, viewConfiguration5, companion16.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf5.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(896149831);
                    if (zM1746equalsimpl0) {
                        Modifier.Companion companion17 = Modifier.Companion;
                        TimeInputTokens timeInputTokens5 = TimeInputTokens.INSTANCE;
                        Modifier modifierM534sizeVpY3zN8 = SizeKt.m534sizeVpY3zN4(companion17, timeInputTokens5.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens5.m2546getTimeFieldContainerHeightD9Ej5fM());
                        if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                            minute = timePickerState.getHourForDisplay$material3_release();
                        } else {
                            minute = timePickerState.getMinute();
                        }
                        int i19 = i12 >> 3;
                        z = zM1746equalsimpl0;
                        r7 = 0;
                        m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN8, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i19 & 7168) | (i19 & 896) | 6 | ((i12 >> 9) & 57344));
                    } else {
                        z = zM1746equalsimpl0;
                        r7 = 0;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companion2 = Selection.Companion;
                    if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                    } else {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                    Modifier.Companion companion18 = Modifier.Companion;
                    Modifier modifierVisible3 = visible(companion18, z);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion15.getTopStart(), r7, composerStartRestartGroup, r7);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density6 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection6 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration6 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion16.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf6 = LayoutKt.materializerOf(modifierVisible3);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl6 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl6, measurePolicyRememberBoxMeasurePolicy3, companion16.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl6, density6, companion16.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl6, layoutDirection6, companion16.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl6, viewConfiguration6, companion16.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf6.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    Modifier modifierFocusRequester3 = FocusRequesterModifierKt.focusRequester(companion18, r21);
                    TimeInputTokens timeInputTokens6 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN9 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester3, timeInputTokens6.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens6.m2546getTimeFieldContainerHeightD9Ej5fM());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN9, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                    TextStyle textStyle3 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                    Brush.Companion companion19 = Brush.Companion;
                    Float fValueOf5 = Float.valueOf(0.0f);
                    Color.Companion companion110 = Color.Companion;
                    C2020dG c2020dGA5 = HV.a(fValueOf5, Color.m3022boximpl(companion110.m3067getTransparent0d7_KjU()));
                    C2020dG c2020dGA6 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion110.m3067getTransparent0d7_KjU()));
                    Float fValueOf6 = Float.valueOf(0.1f);
                    MaterialTheme materialTheme3 = MaterialTheme.INSTANCE;
                    int i110 = i12 >> 3;
                    int i111 = i12 << 3;
                    BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default3, true, false, textStyle3, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource3, Brush.Companion.m2996verticalGradient8A3gB4$default(companion19, new C2020dG[]{c2020dGA5, c2020dGA6, HV.a(fValueOf6, Color.m3022boximpl(materialTheme3.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme3.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion110.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion110.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource3, textFieldColorsM1686colors0hiis_2)), composerStartRestartGroup, (i110 & 112) | (i110 & 14) | 100666368 | (i111 & 3670016) | (i111 & 29360128), 199680, 7696);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierClearAndSetSemantics3 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion18, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                    if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                    } else {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                    }
                    composer2 = composerStartRestartGroup;
                    TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics3, ColorSchemeKt.toColor(timeInputTokens6.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme3.getTypography(composer2, 6), timeInputTokens6.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    Selection selectionM1743boximpl5 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                    Selection selectionM1743boximpl6 = Selection.m1743boximpl(i);
                    composer2.startReplaceableGroup(1618982084);
                    zChanged2 = composer2.changed(selectionM1743boximpl6) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(selectionM1743boximpl5, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions4 = keyboardActions3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimePickerTextField$3(modifier, textFieldValue, interfaceC3750qp, timePickerState, i, keyboardOptions4, keyboardActions4, timePickerColors, i2, i3));
            }
            i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            keyboardOptions2 = keyboardOptions;
            i9 = i3 & 64;
            if (i9 != 0) {
                i12 |= 1572864;
                keyboardActions2 = keyboardActions;
            } else {
                keyboardActions2 = keyboardActions;
                if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(keyboardActions2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i12 |= i10;
                }
            }
            if ((128 & i3) != 0) {
                if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(timePickerColors)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                }
                if ((23967451 & i12) == 4793490) {
                    if (i7 != 0) {
                        keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                    } else {
                        keyboardOptions3 = keyboardOptions2;
                    }
                    if (i9 != 0) {
                        keyboardActions3 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions3 = keyboardActions2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    MutableInteractionSource mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue2;
                    TextFieldColors textFieldColorsM1686colors0hiis_3 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                    zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                    composerStartRestartGroup.startReplaceableGroup(-483455358);
                    Arrangement.Vertical top4 = Arrangement.INSTANCE.getTop();
                    Alignment.Companion companion111 = Alignment.Companion;
                    MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(top4, companion111.getStart(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density7 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection7 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration7 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion112 = ComposeUiNode.Companion;
                    constructor = companion112.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf7 = LayoutKt.materializerOf(modifier);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl7 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl7, measurePolicyColumnMeasurePolicy4, companion112.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl7, density7, companion112.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl7, layoutDirection7, companion112.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl7, viewConfiguration7, companion112.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf7.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(896149831);
                    if (zM1746equalsimpl0) {
                        Modifier.Companion companion113 = Modifier.Companion;
                        TimeInputTokens timeInputTokens7 = TimeInputTokens.INSTANCE;
                        Modifier modifierM534sizeVpY3zN10 = SizeKt.m534sizeVpY3zN4(companion113, timeInputTokens7.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens7.m2546getTimeFieldContainerHeightD9Ej5fM());
                        if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                            minute = timePickerState.getHourForDisplay$material3_release();
                        } else {
                            minute = timePickerState.getMinute();
                        }
                        int i112 = i12 >> 3;
                        z = zM1746equalsimpl0;
                        r7 = 0;
                        m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN10, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i112 & 7168) | (i112 & 896) | 6 | ((i12 >> 9) & 57344));
                    } else {
                        z = zM1746equalsimpl0;
                        r7 = 0;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companion2 = Selection.Companion;
                    if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                    } else {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                    Modifier.Companion companion114 = Modifier.Companion;
                    Modifier modifierVisible4 = visible(companion114, z);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(companion111.getTopStart(), r7, composerStartRestartGroup, r7);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density8 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection8 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration8 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion112.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf8 = LayoutKt.materializerOf(modifierVisible4);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl8 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl8, measurePolicyRememberBoxMeasurePolicy4, companion112.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl8, density8, companion112.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl8, layoutDirection8, companion112.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl8, viewConfiguration8, companion112.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf8.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    Modifier modifierFocusRequester4 = FocusRequesterModifierKt.focusRequester(companion114, r21);
                    TimeInputTokens timeInputTokens8 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN11 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester4, timeInputTokens8.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens8.m2546getTimeFieldContainerHeightD9Ej5fM());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN11, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                    TextStyle textStyle4 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                    Brush.Companion companion115 = Brush.Companion;
                    Float fValueOf7 = Float.valueOf(0.0f);
                    Color.Companion companion116 = Color.Companion;
                    C2020dG c2020dGA7 = HV.a(fValueOf7, Color.m3022boximpl(companion116.m3067getTransparent0d7_KjU()));
                    C2020dG c2020dGA8 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion116.m3067getTransparent0d7_KjU()));
                    Float fValueOf8 = Float.valueOf(0.1f);
                    MaterialTheme materialTheme4 = MaterialTheme.INSTANCE;
                    int i113 = i12 >> 3;
                    int i114 = i12 << 3;
                    BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default4, true, false, textStyle4, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource4, Brush.Companion.m2996verticalGradient8A3gB4$default(companion115, new C2020dG[]{c2020dGA7, c2020dGA8, HV.a(fValueOf8, Color.m3022boximpl(materialTheme4.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme4.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion116.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion116.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource4, textFieldColorsM1686colors0hiis_3)), composerStartRestartGroup, (i113 & 112) | (i113 & 14) | 100666368 | (i114 & 3670016) | (i114 & 29360128), 199680, 7696);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierClearAndSetSemantics4 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion114, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                    if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                    } else {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                    }
                    composer2 = composerStartRestartGroup;
                    TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics4, ColorSchemeKt.toColor(timeInputTokens8.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme4.getTypography(composer2, 6), timeInputTokens8.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    Selection selectionM1743boximpl7 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                    Selection selectionM1743boximpl8 = Selection.m1743boximpl(i);
                    composer2.startReplaceableGroup(1618982084);
                    zChanged2 = composer2.changed(selectionM1743boximpl8) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(selectionM1743boximpl7, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions4 = keyboardActions3;
                } else {
                    if (i7 != 0) {
                        keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                    } else {
                        keyboardOptions3 = keyboardOptions2;
                    }
                    if (i9 != 0) {
                        keyboardActions3 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions3 = keyboardActions2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    MutableInteractionSource mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue2;
                    TextFieldColors textFieldColorsM1686colors0hiis_4 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                    zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                    composerStartRestartGroup.startReplaceableGroup(-483455358);
                    Arrangement.Vertical top5 = Arrangement.INSTANCE.getTop();
                    Alignment.Companion companion117 = Alignment.Companion;
                    MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(top5, companion117.getStart(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density9 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection9 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration9 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion118 = ComposeUiNode.Companion;
                    constructor = companion118.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf9 = LayoutKt.materializerOf(modifier);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl9 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl9, measurePolicyColumnMeasurePolicy5, companion118.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl9, density9, companion118.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl9, layoutDirection9, companion118.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl9, viewConfiguration9, companion118.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf9.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(896149831);
                    if (zM1746equalsimpl0) {
                        Modifier.Companion companion119 = Modifier.Companion;
                        TimeInputTokens timeInputTokens9 = TimeInputTokens.INSTANCE;
                        Modifier modifierM534sizeVpY3zN12 = SizeKt.m534sizeVpY3zN4(companion119, timeInputTokens9.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens9.m2546getTimeFieldContainerHeightD9Ej5fM());
                        if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                            minute = timePickerState.getHourForDisplay$material3_release();
                        } else {
                            minute = timePickerState.getMinute();
                        }
                        int i115 = i12 >> 3;
                        z = zM1746equalsimpl0;
                        r7 = 0;
                        m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN12, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i115 & 7168) | (i115 & 896) | 6 | ((i12 >> 9) & 57344));
                    } else {
                        z = zM1746equalsimpl0;
                        r7 = 0;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companion2 = Selection.Companion;
                    if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                    } else {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                    Modifier.Companion companion1110 = Modifier.Companion;
                    Modifier modifierVisible5 = visible(companion1110, z);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(companion117.getTopStart(), r7, composerStartRestartGroup, r7);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density10 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection10 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration10 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion118.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf10 = LayoutKt.materializerOf(modifierVisible5);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl10 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl10, measurePolicyRememberBoxMeasurePolicy5, companion118.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl10, density10, companion118.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl10, layoutDirection10, companion118.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl10, viewConfiguration10, companion118.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf10.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    Modifier modifierFocusRequester5 = FocusRequesterModifierKt.focusRequester(companion1110, r21);
                    TimeInputTokens timeInputTokens10 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN13 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester5, timeInputTokens10.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens10.m2546getTimeFieldContainerHeightD9Ej5fM());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN13, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                    TextStyle textStyle5 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                    Brush.Companion companion1111 = Brush.Companion;
                    Float fValueOf9 = Float.valueOf(0.0f);
                    Color.Companion companion1112 = Color.Companion;
                    C2020dG c2020dGA9 = HV.a(fValueOf9, Color.m3022boximpl(companion1112.m3067getTransparent0d7_KjU()));
                    C2020dG c2020dGA10 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion1112.m3067getTransparent0d7_KjU()));
                    Float fValueOf10 = Float.valueOf(0.1f);
                    MaterialTheme materialTheme5 = MaterialTheme.INSTANCE;
                    int i116 = i12 >> 3;
                    int i117 = i12 << 3;
                    BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default5, true, false, textStyle5, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource5, Brush.Companion.m2996verticalGradient8A3gB4$default(companion1111, new C2020dG[]{c2020dGA9, c2020dGA10, HV.a(fValueOf10, Color.m3022boximpl(materialTheme5.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme5.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion1112.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion1112.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource5, textFieldColorsM1686colors0hiis_4)), composerStartRestartGroup, (i116 & 112) | (i116 & 14) | 100666368 | (i117 & 3670016) | (i117 & 29360128), 199680, 7696);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierClearAndSetSemantics5 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion1110, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                    if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                    } else {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                    }
                    composer2 = composerStartRestartGroup;
                    TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics5, ColorSchemeKt.toColor(timeInputTokens10.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme5.getTypography(composer2, 6), timeInputTokens10.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    Selection selectionM1743boximpl9 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                    Selection selectionM1743boximpl10 = Selection.m1743boximpl(i);
                    composer2.startReplaceableGroup(1618982084);
                    zChanged2 = composer2.changed(selectionM1743boximpl10) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(selectionM1743boximpl9, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions4 = keyboardActions3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimePickerTextField$3(modifier, textFieldValue, interfaceC3750qp, timePickerState, i, keyboardOptions4, keyboardActions4, timePickerColors, i2, i3));
            }
            i11 = 12582912;
            i12 |= i11;
            if ((23967451 & i12) == 4793490) {
                if (i7 != 0) {
                    keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions3 = keyboardOptions2;
                }
                if (i9 != 0) {
                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions3 = keyboardActions2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                MutableInteractionSource mutableInteractionSource6 = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue2;
                TextFieldColors textFieldColorsM1686colors0hiis_5 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                Arrangement.Vertical top6 = Arrangement.INSTANCE.getTop();
                Alignment.Companion companion1113 = Alignment.Companion;
                MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(top6, companion1113.getStart(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density11 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection11 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration11 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion1114 = ComposeUiNode.Companion;
                constructor = companion1114.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf11 = LayoutKt.materializerOf(modifier);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl11 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl11, measurePolicyColumnMeasurePolicy6, companion1114.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl11, density11, companion1114.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl11, layoutDirection11, companion1114.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl11, viewConfiguration11, companion1114.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf11.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(896149831);
                if (zM1746equalsimpl0) {
                    Modifier.Companion companion1115 = Modifier.Companion;
                    TimeInputTokens timeInputTokens11 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN14 = SizeKt.m534sizeVpY3zN4(companion1115, timeInputTokens11.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens11.m2546getTimeFieldContainerHeightD9Ej5fM());
                    if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                        minute = timePickerState.getHourForDisplay$material3_release();
                    } else {
                        minute = timePickerState.getMinute();
                    }
                    int i118 = i12 >> 3;
                    z = zM1746equalsimpl0;
                    r7 = 0;
                    m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN14, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i118 & 7168) | (i118 & 896) | 6 | ((i12 >> 9) & 57344));
                } else {
                    z = zM1746equalsimpl0;
                    r7 = 0;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companion2 = Selection.Companion;
                if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                } else {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                Modifier.Companion companion1116 = Modifier.Companion;
                Modifier modifierVisible6 = visible(companion1116, z);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(companion1113.getTopStart(), r7, composerStartRestartGroup, r7);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density12 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection12 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration12 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion1114.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf12 = LayoutKt.materializerOf(modifierVisible6);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl12 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl12, measurePolicyRememberBoxMeasurePolicy6, companion1114.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl12, density12, companion1114.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl12, layoutDirection12, companion1114.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl12, viewConfiguration12, companion1114.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf12.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                Modifier modifierFocusRequester6 = FocusRequesterModifierKt.focusRequester(companion1116, r21);
                TimeInputTokens timeInputTokens12 = TimeInputTokens.INSTANCE;
                Modifier modifierM534sizeVpY3zN15 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester6, timeInputTokens12.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens12.m2546getTimeFieldContainerHeightD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN15, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                TextStyle textStyle6 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                Brush.Companion companion1117 = Brush.Companion;
                Float fValueOf11 = Float.valueOf(0.0f);
                Color.Companion companion1118 = Color.Companion;
                C2020dG c2020dGA11 = HV.a(fValueOf11, Color.m3022boximpl(companion1118.m3067getTransparent0d7_KjU()));
                C2020dG c2020dGA12 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion1118.m3067getTransparent0d7_KjU()));
                Float fValueOf12 = Float.valueOf(0.1f);
                MaterialTheme materialTheme6 = MaterialTheme.INSTANCE;
                int i119 = i12 >> 3;
                int i1110 = i12 << 3;
                BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default6, true, false, textStyle6, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource6, Brush.Companion.m2996verticalGradient8A3gB4$default(companion1117, new C2020dG[]{c2020dGA11, c2020dGA12, HV.a(fValueOf12, Color.m3022boximpl(materialTheme6.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme6.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion1118.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion1118.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource6, textFieldColorsM1686colors0hiis_5)), composerStartRestartGroup, (i119 & 112) | (i119 & 14) | 100666368 | (i1110 & 3670016) | (i1110 & 29360128), 199680, 7696);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierClearAndSetSemantics6 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion1116, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                } else {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics6, ColorSchemeKt.toColor(timeInputTokens12.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme6.getTypography(composer2, 6), timeInputTokens12.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                Selection selectionM1743boximpl11 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                Selection selectionM1743boximpl12 = Selection.m1743boximpl(i);
                composer2.startReplaceableGroup(1618982084);
                zChanged2 = composer2.changed(selectionM1743boximpl12) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                objRememberedValue4 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect(selectionM1743boximpl11, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
            } else {
                if (i7 != 0) {
                    keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions3 = keyboardOptions2;
                }
                if (i9 != 0) {
                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions3 = keyboardActions2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                MutableInteractionSource mutableInteractionSource7 = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue2;
                TextFieldColors textFieldColorsM1686colors0hiis_6 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                Arrangement.Vertical top7 = Arrangement.INSTANCE.getTop();
                Alignment.Companion companion1119 = Alignment.Companion;
                MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(top7, companion1119.getStart(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density13 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection13 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration13 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion11110 = ComposeUiNode.Companion;
                constructor = companion11110.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf13 = LayoutKt.materializerOf(modifier);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl13 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl13, measurePolicyColumnMeasurePolicy7, companion11110.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl13, density13, companion11110.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl13, layoutDirection13, companion11110.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl13, viewConfiguration13, companion11110.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf13.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(896149831);
                if (zM1746equalsimpl0) {
                    Modifier.Companion companion11111 = Modifier.Companion;
                    TimeInputTokens timeInputTokens13 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN16 = SizeKt.m534sizeVpY3zN4(companion11111, timeInputTokens13.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens13.m2546getTimeFieldContainerHeightD9Ej5fM());
                    if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                        minute = timePickerState.getHourForDisplay$material3_release();
                    } else {
                        minute = timePickerState.getMinute();
                    }
                    int i1111 = i12 >> 3;
                    z = zM1746equalsimpl0;
                    r7 = 0;
                    m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN16, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i1111 & 7168) | (i1111 & 896) | 6 | ((i12 >> 9) & 57344));
                } else {
                    z = zM1746equalsimpl0;
                    r7 = 0;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companion2 = Selection.Companion;
                if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                } else {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                Modifier.Companion companion11112 = Modifier.Companion;
                Modifier modifierVisible7 = visible(companion11112, z);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(companion1119.getTopStart(), r7, composerStartRestartGroup, r7);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density14 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection14 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration14 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion11110.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf14 = LayoutKt.materializerOf(modifierVisible7);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl14 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl14, measurePolicyRememberBoxMeasurePolicy7, companion11110.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl14, density14, companion11110.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl14, layoutDirection14, companion11110.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl14, viewConfiguration14, companion11110.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf14.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                Modifier modifierFocusRequester7 = FocusRequesterModifierKt.focusRequester(companion11112, r21);
                TimeInputTokens timeInputTokens14 = TimeInputTokens.INSTANCE;
                Modifier modifierM534sizeVpY3zN17 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester7, timeInputTokens14.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens14.m2546getTimeFieldContainerHeightD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN17, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                TextStyle textStyle7 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                Brush.Companion companion11113 = Brush.Companion;
                Float fValueOf13 = Float.valueOf(0.0f);
                Color.Companion companion11114 = Color.Companion;
                C2020dG c2020dGA13 = HV.a(fValueOf13, Color.m3022boximpl(companion11114.m3067getTransparent0d7_KjU()));
                C2020dG c2020dGA14 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion11114.m3067getTransparent0d7_KjU()));
                Float fValueOf14 = Float.valueOf(0.1f);
                MaterialTheme materialTheme7 = MaterialTheme.INSTANCE;
                int i1112 = i12 >> 3;
                int i1113 = i12 << 3;
                BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default7, true, false, textStyle7, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource7, Brush.Companion.m2996verticalGradient8A3gB4$default(companion11113, new C2020dG[]{c2020dGA13, c2020dGA14, HV.a(fValueOf14, Color.m3022boximpl(materialTheme7.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme7.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion11114.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion11114.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource7, textFieldColorsM1686colors0hiis_6)), composerStartRestartGroup, (i1112 & 112) | (i1112 & 14) | 100666368 | (i1113 & 3670016) | (i1113 & 29360128), 199680, 7696);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierClearAndSetSemantics7 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion11112, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                } else {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics7, ColorSchemeKt.toColor(timeInputTokens14.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme7.getTypography(composer2, 6), timeInputTokens14.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                Selection selectionM1743boximpl13 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                Selection selectionM1743boximpl14 = Selection.m1743boximpl(i);
                composer2.startReplaceableGroup(1618982084);
                zChanged2 = composer2.changed(selectionM1743boximpl14) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                objRememberedValue4 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect(selectionM1743boximpl13, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimePickerTextField$3(modifier, textFieldValue, interfaceC3750qp, timePickerState, i, keyboardOptions4, keyboardActions4, timePickerColors, i2, i3));
        }
        i12 |= 384;
        if ((i3 & 8) != 0) {
            i12 |= 3072;
        } else if ((i2 & 7168) == 0) {
            if (composerStartRestartGroup.changed(timePickerState)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i12 |= i5;
        }
        if ((16 & i3) != 0) {
            i12 |= 24576;
        } else if ((i2 & 57344) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i12 |= i6;
        }
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((458752 & i2) == 0) {
                keyboardOptions2 = keyboardOptions;
                if (composerStartRestartGroup.changed(keyboardOptions2)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i12 |= i8;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i12 |= 1572864;
                keyboardActions2 = keyboardActions;
            } else {
                keyboardActions2 = keyboardActions;
                if ((i2 & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(keyboardActions2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i12 |= i10;
                }
            }
            if ((128 & i3) != 0) {
                if ((i2 & 29360128) == 0) {
                    if (composerStartRestartGroup.changed(timePickerColors)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                }
                if ((23967451 & i12) == 4793490) {
                    if (i7 != 0) {
                        keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                    } else {
                        keyboardOptions3 = keyboardOptions2;
                    }
                    if (i9 != 0) {
                        keyboardActions3 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions3 = keyboardActions2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    MutableInteractionSource mutableInteractionSource8 = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue2;
                    TextFieldColors textFieldColorsM1686colors0hiis_7 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                    zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                    composerStartRestartGroup.startReplaceableGroup(-483455358);
                    Arrangement.Vertical top8 = Arrangement.INSTANCE.getTop();
                    Alignment.Companion companion11115 = Alignment.Companion;
                    MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(top8, companion11115.getStart(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density15 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection15 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration15 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion11116 = ComposeUiNode.Companion;
                    constructor = companion11116.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf15 = LayoutKt.materializerOf(modifier);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl15 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl15, measurePolicyColumnMeasurePolicy8, companion11116.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl15, density15, companion11116.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl15, layoutDirection15, companion11116.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl15, viewConfiguration15, companion11116.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf15.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(896149831);
                    if (zM1746equalsimpl0) {
                        Modifier.Companion companion11117 = Modifier.Companion;
                        TimeInputTokens timeInputTokens15 = TimeInputTokens.INSTANCE;
                        Modifier modifierM534sizeVpY3zN18 = SizeKt.m534sizeVpY3zN4(companion11117, timeInputTokens15.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens15.m2546getTimeFieldContainerHeightD9Ej5fM());
                        if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                            minute = timePickerState.getHourForDisplay$material3_release();
                        } else {
                            minute = timePickerState.getMinute();
                        }
                        int i1114 = i12 >> 3;
                        z = zM1746equalsimpl0;
                        r7 = 0;
                        m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN18, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i1114 & 7168) | (i1114 & 896) | 6 | ((i12 >> 9) & 57344));
                    } else {
                        z = zM1746equalsimpl0;
                        r7 = 0;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companion2 = Selection.Companion;
                    if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                    } else {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                    Modifier.Companion companion11118 = Modifier.Companion;
                    Modifier modifierVisible8 = visible(companion11118, z);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy8 = BoxKt.rememberBoxMeasurePolicy(companion11115.getTopStart(), r7, composerStartRestartGroup, r7);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density16 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection16 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration16 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion11116.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf16 = LayoutKt.materializerOf(modifierVisible8);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl16 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl16, measurePolicyRememberBoxMeasurePolicy8, companion11116.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl16, density16, companion11116.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl16, layoutDirection16, companion11116.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl16, viewConfiguration16, companion11116.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf16.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                    Modifier modifierFocusRequester8 = FocusRequesterModifierKt.focusRequester(companion11118, r21);
                    TimeInputTokens timeInputTokens16 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN19 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester8, timeInputTokens16.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens16.m2546getTimeFieldContainerHeightD9Ej5fM());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default8 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN19, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                    TextStyle textStyle8 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                    Brush.Companion companion11119 = Brush.Companion;
                    Float fValueOf15 = Float.valueOf(0.0f);
                    Color.Companion companion111110 = Color.Companion;
                    C2020dG c2020dGA15 = HV.a(fValueOf15, Color.m3022boximpl(companion111110.m3067getTransparent0d7_KjU()));
                    C2020dG c2020dGA16 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion111110.m3067getTransparent0d7_KjU()));
                    Float fValueOf16 = Float.valueOf(0.1f);
                    MaterialTheme materialTheme8 = MaterialTheme.INSTANCE;
                    int i1115 = i12 >> 3;
                    int i1116 = i12 << 3;
                    BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default8, true, false, textStyle8, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource8, Brush.Companion.m2996verticalGradient8A3gB4$default(companion11119, new C2020dG[]{c2020dGA15, c2020dGA16, HV.a(fValueOf16, Color.m3022boximpl(materialTheme8.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme8.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion111110.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion111110.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource8, textFieldColorsM1686colors0hiis_7)), composerStartRestartGroup, (i1115 & 112) | (i1115 & 14) | 100666368 | (i1116 & 3670016) | (i1116 & 29360128), 199680, 7696);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierClearAndSetSemantics8 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion11118, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                    if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                    } else {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                    }
                    composer2 = composerStartRestartGroup;
                    TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics8, ColorSchemeKt.toColor(timeInputTokens16.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme8.getTypography(composer2, 6), timeInputTokens16.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    Selection selectionM1743boximpl15 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                    Selection selectionM1743boximpl16 = Selection.m1743boximpl(i);
                    composer2.startReplaceableGroup(1618982084);
                    zChanged2 = composer2.changed(selectionM1743boximpl16) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(selectionM1743boximpl15, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions4 = keyboardActions3;
                } else {
                    if (i7 != 0) {
                        keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                    } else {
                        keyboardOptions3 = keyboardOptions2;
                    }
                    if (i9 != 0) {
                        keyboardActions3 = KeyboardActions.Companion.getDefault();
                    } else {
                        keyboardActions3 = keyboardActions2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                    }
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.Companion;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    MutableInteractionSource mutableInteractionSource9 = (MutableInteractionSource) objRememberedValue;
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    focusRequester = (FocusRequester) objRememberedValue2;
                    TextFieldColors textFieldColorsM1686colors0hiis_8 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                    zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                    composerStartRestartGroup.startReplaceableGroup(-483455358);
                    Arrangement.Vertical top9 = Arrangement.INSTANCE.getTop();
                    Alignment.Companion companion111111 = Alignment.Companion;
                    MeasurePolicy measurePolicyColumnMeasurePolicy9 = ColumnKt.columnMeasurePolicy(top9, companion111111.getStart(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density17 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection17 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration17 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion111112 = ComposeUiNode.Companion;
                    constructor = companion111112.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf17 = LayoutKt.materializerOf(modifier);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl17 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl17, measurePolicyColumnMeasurePolicy9, companion111112.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl17, density17, companion111112.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl17, layoutDirection17, companion111112.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl17, viewConfiguration17, companion111112.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf17.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    ColumnScopeInstance columnScopeInstance9 = ColumnScopeInstance.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(896149831);
                    if (zM1746equalsimpl0) {
                        Modifier.Companion companion111113 = Modifier.Companion;
                        TimeInputTokens timeInputTokens17 = TimeInputTokens.INSTANCE;
                        Modifier modifierM534sizeVpY3zN110 = SizeKt.m534sizeVpY3zN4(companion111113, timeInputTokens17.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens17.m2546getTimeFieldContainerHeightD9Ej5fM());
                        if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                            minute = timePickerState.getHourForDisplay$material3_release();
                        } else {
                            minute = timePickerState.getMinute();
                        }
                        int i1117 = i12 >> 3;
                        z = zM1746equalsimpl0;
                        r7 = 0;
                        m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN110, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i1117 & 7168) | (i1117 & 896) | 6 | ((i12 >> 9) & 57344));
                    } else {
                        z = zM1746equalsimpl0;
                        r7 = 0;
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companion2 = Selection.Companion;
                    if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                    } else {
                        iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                    }
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                    Modifier.Companion companion111114 = Modifier.Companion;
                    Modifier modifierVisible9 = visible(companion111114, z);
                    composerStartRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy9 = BoxKt.rememberBoxMeasurePolicy(companion111111.getTopStart(), r7, composerStartRestartGroup, r7);
                    composerStartRestartGroup.startReplaceableGroup(-1323940314);
                    Density density18 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection18 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration18 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    constructor2 = companion111112.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf18 = LayoutKt.materializerOf(modifierVisible9);
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerStartRestartGroup.disableReusing();
                    Composer composerM2661constructorimpl18 = Updater.m2661constructorimpl(composerStartRestartGroup);
                    Updater.m2668setimpl(composerM2661constructorimpl18, measurePolicyRememberBoxMeasurePolicy9, companion111112.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl18, density18, companion111112.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl18, layoutDirection18, companion111112.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl18, viewConfiguration18, companion111112.getSetViewConfiguration());
                    composerStartRestartGroup.enableReusing();
                    interfaceC0552GpMaterializerOf18.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(2058660585);
                    BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                    Modifier modifierFocusRequester9 = FocusRequesterModifierKt.focusRequester(companion111114, r21);
                    TimeInputTokens timeInputTokens18 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN111 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester9, timeInputTokens18.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens18.m2546getTimeFieldContainerHeightD9Ej5fM());
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierSemantics$default9 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN111, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                    TextStyle textStyle9 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                    Brush.Companion companion111115 = Brush.Companion;
                    Float fValueOf17 = Float.valueOf(0.0f);
                    Color.Companion companion111116 = Color.Companion;
                    C2020dG c2020dGA17 = HV.a(fValueOf17, Color.m3022boximpl(companion111116.m3067getTransparent0d7_KjU()));
                    C2020dG c2020dGA18 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion111116.m3067getTransparent0d7_KjU()));
                    Float fValueOf18 = Float.valueOf(0.1f);
                    MaterialTheme materialTheme9 = MaterialTheme.INSTANCE;
                    int i1118 = i12 >> 3;
                    int i1119 = i12 << 3;
                    BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default9, true, false, textStyle9, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource9, Brush.Companion.m2996verticalGradient8A3gB4$default(companion111115, new C2020dG[]{c2020dGA17, c2020dGA18, HV.a(fValueOf18, Color.m3022boximpl(materialTheme9.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme9.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion111116.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion111116.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource9, textFieldColorsM1686colors0hiis_8)), composerStartRestartGroup, (i1118 & 112) | (i1118 & 14) | 100666368 | (i1119 & 3670016) | (i1119 & 29360128), 199680, 7696);
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endNode();
                    composerStartRestartGroup.endReplaceableGroup();
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierClearAndSetSemantics9 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion111114, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                    if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                    } else {
                        iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                    }
                    composer2 = composerStartRestartGroup;
                    TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics9, ColorSchemeKt.toColor(timeInputTokens18.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme9.getTypography(composer2, 6), timeInputTokens18.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    Selection selectionM1743boximpl17 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                    Selection selectionM1743boximpl18 = Selection.m1743boximpl(i);
                    composer2.startReplaceableGroup(1618982084);
                    zChanged2 = composer2.changed(selectionM1743boximpl18) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (zChanged2) {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    composer2.endReplaceableGroup();
                    EffectsKt.LaunchedEffect(selectionM1743boximpl17, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    keyboardOptions4 = keyboardOptions3;
                    keyboardActions4 = keyboardActions3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimePickerTextField$3(modifier, textFieldValue, interfaceC3750qp, timePickerState, i, keyboardOptions4, keyboardActions4, timePickerColors, i2, i3));
            }
            i11 = 12582912;
            i12 |= i11;
            if ((23967451 & i12) == 4793490) {
                if (i7 != 0) {
                    keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions3 = keyboardOptions2;
                }
                if (i9 != 0) {
                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions3 = keyboardActions2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                MutableInteractionSource mutableInteractionSource10 = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue2;
                TextFieldColors textFieldColorsM1686colors0hiis_9 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                Arrangement.Vertical top10 = Arrangement.INSTANCE.getTop();
                Alignment.Companion companion111117 = Alignment.Companion;
                MeasurePolicy measurePolicyColumnMeasurePolicy10 = ColumnKt.columnMeasurePolicy(top10, companion111117.getStart(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density19 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection19 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration19 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion111118 = ComposeUiNode.Companion;
                constructor = companion111118.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf19 = LayoutKt.materializerOf(modifier);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl19 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl19, measurePolicyColumnMeasurePolicy10, companion111118.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl19, density19, companion111118.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl19, layoutDirection19, companion111118.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl19, viewConfiguration19, companion111118.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf19.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance10 = ColumnScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(896149831);
                if (zM1746equalsimpl0) {
                    Modifier.Companion companion111119 = Modifier.Companion;
                    TimeInputTokens timeInputTokens19 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN112 = SizeKt.m534sizeVpY3zN4(companion111119, timeInputTokens19.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens19.m2546getTimeFieldContainerHeightD9Ej5fM());
                    if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                        minute = timePickerState.getHourForDisplay$material3_release();
                    } else {
                        minute = timePickerState.getMinute();
                    }
                    int i11110 = i12 >> 3;
                    z = zM1746equalsimpl0;
                    r7 = 0;
                    m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN112, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i11110 & 7168) | (i11110 & 896) | 6 | ((i12 >> 9) & 57344));
                } else {
                    z = zM1746equalsimpl0;
                    r7 = 0;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companion2 = Selection.Companion;
                if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                } else {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                Modifier.Companion companion1111110 = Modifier.Companion;
                Modifier modifierVisible10 = visible(companion1111110, z);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy10 = BoxKt.rememberBoxMeasurePolicy(companion111117.getTopStart(), r7, composerStartRestartGroup, r7);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density110 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection110 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration110 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion111118.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf110 = LayoutKt.materializerOf(modifierVisible10);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl110 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl110, measurePolicyRememberBoxMeasurePolicy10, companion111118.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl110, density110, companion111118.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl110, layoutDirection110, companion111118.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl110, viewConfiguration110, companion111118.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                Modifier modifierFocusRequester10 = FocusRequesterModifierKt.focusRequester(companion1111110, r21);
                TimeInputTokens timeInputTokens110 = TimeInputTokens.INSTANCE;
                Modifier modifierM534sizeVpY3zN113 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester10, timeInputTokens110.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens110.m2546getTimeFieldContainerHeightD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default10 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN113, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                TextStyle textStyle10 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                Brush.Companion companion1111111 = Brush.Companion;
                Float fValueOf19 = Float.valueOf(0.0f);
                Color.Companion companion1111112 = Color.Companion;
                C2020dG c2020dGA19 = HV.a(fValueOf19, Color.m3022boximpl(companion1111112.m3067getTransparent0d7_KjU()));
                C2020dG c2020dGA110 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion1111112.m3067getTransparent0d7_KjU()));
                Float fValueOf110 = Float.valueOf(0.1f);
                MaterialTheme materialTheme10 = MaterialTheme.INSTANCE;
                int i11111 = i12 >> 3;
                int i11112 = i12 << 3;
                BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default10, true, false, textStyle10, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource10, Brush.Companion.m2996verticalGradient8A3gB4$default(companion1111111, new C2020dG[]{c2020dGA19, c2020dGA110, HV.a(fValueOf110, Color.m3022boximpl(materialTheme10.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme10.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion1111112.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion1111112.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource10, textFieldColorsM1686colors0hiis_9)), composerStartRestartGroup, (i11111 & 112) | (i11111 & 14) | 100666368 | (i11112 & 3670016) | (i11112 & 29360128), 199680, 7696);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierClearAndSetSemantics10 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion1111110, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                } else {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics10, ColorSchemeKt.toColor(timeInputTokens110.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme10.getTypography(composer2, 6), timeInputTokens110.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                Selection selectionM1743boximpl19 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                Selection selectionM1743boximpl110 = Selection.m1743boximpl(i);
                composer2.startReplaceableGroup(1618982084);
                zChanged2 = composer2.changed(selectionM1743boximpl110) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                objRememberedValue4 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect(selectionM1743boximpl19, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
            } else {
                if (i7 != 0) {
                    keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions3 = keyboardOptions2;
                }
                if (i9 != 0) {
                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions3 = keyboardActions2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                MutableInteractionSource mutableInteractionSource11 = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue2;
                TextFieldColors textFieldColorsM1686colors0hiis_10 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                Arrangement.Vertical top11 = Arrangement.INSTANCE.getTop();
                Alignment.Companion companion1111113 = Alignment.Companion;
                MeasurePolicy measurePolicyColumnMeasurePolicy11 = ColumnKt.columnMeasurePolicy(top11, companion1111113.getStart(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density111 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection111 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration111 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion1111114 = ComposeUiNode.Companion;
                constructor = companion1111114.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf111 = LayoutKt.materializerOf(modifier);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl111 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl111, measurePolicyColumnMeasurePolicy11, companion1111114.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl111, density111, companion1111114.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl111, layoutDirection111, companion1111114.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl111, viewConfiguration111, companion1111114.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf111.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance11 = ColumnScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(896149831);
                if (zM1746equalsimpl0) {
                    Modifier.Companion companion1111115 = Modifier.Companion;
                    TimeInputTokens timeInputTokens111 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN114 = SizeKt.m534sizeVpY3zN4(companion1111115, timeInputTokens111.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens111.m2546getTimeFieldContainerHeightD9Ej5fM());
                    if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                        minute = timePickerState.getHourForDisplay$material3_release();
                    } else {
                        minute = timePickerState.getMinute();
                    }
                    int i11113 = i12 >> 3;
                    z = zM1746equalsimpl0;
                    r7 = 0;
                    m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN114, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i11113 & 7168) | (i11113 & 896) | 6 | ((i12 >> 9) & 57344));
                } else {
                    z = zM1746equalsimpl0;
                    r7 = 0;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companion2 = Selection.Companion;
                if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                } else {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                Modifier.Companion companion1111116 = Modifier.Companion;
                Modifier modifierVisible11 = visible(companion1111116, z);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy11 = BoxKt.rememberBoxMeasurePolicy(companion1111113.getTopStart(), r7, composerStartRestartGroup, r7);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density112 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection112 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration112 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion1111114.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf112 = LayoutKt.materializerOf(modifierVisible11);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl112 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl112, measurePolicyRememberBoxMeasurePolicy11, companion1111114.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl112, density112, companion1111114.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl112, layoutDirection112, companion1111114.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl112, viewConfiguration112, companion1111114.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf112.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                Modifier modifierFocusRequester11 = FocusRequesterModifierKt.focusRequester(companion1111116, r21);
                TimeInputTokens timeInputTokens112 = TimeInputTokens.INSTANCE;
                Modifier modifierM534sizeVpY3zN115 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester11, timeInputTokens112.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens112.m2546getTimeFieldContainerHeightD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default11 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN115, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                TextStyle textStyle11 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                Brush.Companion companion1111117 = Brush.Companion;
                Float fValueOf111 = Float.valueOf(0.0f);
                Color.Companion companion1111118 = Color.Companion;
                C2020dG c2020dGA111 = HV.a(fValueOf111, Color.m3022boximpl(companion1111118.m3067getTransparent0d7_KjU()));
                C2020dG c2020dGA112 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion1111118.m3067getTransparent0d7_KjU()));
                Float fValueOf112 = Float.valueOf(0.1f);
                MaterialTheme materialTheme11 = MaterialTheme.INSTANCE;
                int i11114 = i12 >> 3;
                int i11115 = i12 << 3;
                BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default11, true, false, textStyle11, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource11, Brush.Companion.m2996verticalGradient8A3gB4$default(companion1111117, new C2020dG[]{c2020dGA111, c2020dGA112, HV.a(fValueOf112, Color.m3022boximpl(materialTheme11.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme11.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion1111118.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion1111118.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource11, textFieldColorsM1686colors0hiis_10)), composerStartRestartGroup, (i11114 & 112) | (i11114 & 14) | 100666368 | (i11115 & 3670016) | (i11115 & 29360128), 199680, 7696);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierClearAndSetSemantics11 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion1111116, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                } else {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics11, ColorSchemeKt.toColor(timeInputTokens112.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme11.getTypography(composer2, 6), timeInputTokens112.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                Selection selectionM1743boximpl111 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                Selection selectionM1743boximpl112 = Selection.m1743boximpl(i);
                composer2.startReplaceableGroup(1618982084);
                zChanged2 = composer2.changed(selectionM1743boximpl112) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                objRememberedValue4 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect(selectionM1743boximpl111, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimePickerTextField$3(modifier, textFieldValue, interfaceC3750qp, timePickerState, i, keyboardOptions4, keyboardActions4, timePickerColors, i2, i3));
        }
        i12 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        keyboardOptions2 = keyboardOptions;
        i9 = i3 & 64;
        if (i9 != 0) {
            i12 |= 1572864;
            keyboardActions2 = keyboardActions;
        } else {
            keyboardActions2 = keyboardActions;
            if ((i2 & 3670016) == 0) {
                if (composerStartRestartGroup.changed(keyboardActions2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i12 |= i10;
            }
        }
        if ((128 & i3) != 0) {
            if ((i2 & 29360128) == 0) {
                if (composerStartRestartGroup.changed(timePickerColors)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
            }
            if ((23967451 & i12) == 4793490) {
                if (i7 != 0) {
                    keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions3 = keyboardOptions2;
                }
                if (i9 != 0) {
                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions3 = keyboardActions2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                MutableInteractionSource mutableInteractionSource12 = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue2;
                TextFieldColors textFieldColorsM1686colors0hiis_11 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                Arrangement.Vertical top12 = Arrangement.INSTANCE.getTop();
                Alignment.Companion companion1111119 = Alignment.Companion;
                MeasurePolicy measurePolicyColumnMeasurePolicy12 = ColumnKt.columnMeasurePolicy(top12, companion1111119.getStart(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density113 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection113 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration113 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion11111110 = ComposeUiNode.Companion;
                constructor = companion11111110.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf113 = LayoutKt.materializerOf(modifier);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl113 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl113, measurePolicyColumnMeasurePolicy12, companion11111110.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl113, density113, companion11111110.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl113, layoutDirection113, companion11111110.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl113, viewConfiguration113, companion11111110.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf113.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance12 = ColumnScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(896149831);
                if (zM1746equalsimpl0) {
                    Modifier.Companion companion11111111 = Modifier.Companion;
                    TimeInputTokens timeInputTokens113 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN116 = SizeKt.m534sizeVpY3zN4(companion11111111, timeInputTokens113.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens113.m2546getTimeFieldContainerHeightD9Ej5fM());
                    if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                        minute = timePickerState.getHourForDisplay$material3_release();
                    } else {
                        minute = timePickerState.getMinute();
                    }
                    int i11116 = i12 >> 3;
                    z = zM1746equalsimpl0;
                    r7 = 0;
                    m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN116, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i11116 & 7168) | (i11116 & 896) | 6 | ((i12 >> 9) & 57344));
                } else {
                    z = zM1746equalsimpl0;
                    r7 = 0;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companion2 = Selection.Companion;
                if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                } else {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                Modifier.Companion companion11111112 = Modifier.Companion;
                Modifier modifierVisible12 = visible(companion11111112, z);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy12 = BoxKt.rememberBoxMeasurePolicy(companion1111119.getTopStart(), r7, composerStartRestartGroup, r7);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density114 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection114 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration114 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion11111110.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf114 = LayoutKt.materializerOf(modifierVisible12);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl114 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl114, measurePolicyRememberBoxMeasurePolicy12, companion11111110.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl114, density114, companion11111110.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl114, layoutDirection114, companion11111110.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl114, viewConfiguration114, companion11111110.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf114.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                Modifier modifierFocusRequester12 = FocusRequesterModifierKt.focusRequester(companion11111112, r21);
                TimeInputTokens timeInputTokens114 = TimeInputTokens.INSTANCE;
                Modifier modifierM534sizeVpY3zN117 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester12, timeInputTokens114.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens114.m2546getTimeFieldContainerHeightD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default12 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN117, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                TextStyle textStyle12 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                Brush.Companion companion11111113 = Brush.Companion;
                Float fValueOf113 = Float.valueOf(0.0f);
                Color.Companion companion11111114 = Color.Companion;
                C2020dG c2020dGA113 = HV.a(fValueOf113, Color.m3022boximpl(companion11111114.m3067getTransparent0d7_KjU()));
                C2020dG c2020dGA114 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion11111114.m3067getTransparent0d7_KjU()));
                Float fValueOf114 = Float.valueOf(0.1f);
                MaterialTheme materialTheme12 = MaterialTheme.INSTANCE;
                int i11117 = i12 >> 3;
                int i11118 = i12 << 3;
                BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default12, true, false, textStyle12, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource12, Brush.Companion.m2996verticalGradient8A3gB4$default(companion11111113, new C2020dG[]{c2020dGA113, c2020dGA114, HV.a(fValueOf114, Color.m3022boximpl(materialTheme12.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme12.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion11111114.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion11111114.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource12, textFieldColorsM1686colors0hiis_11)), composerStartRestartGroup, (i11117 & 112) | (i11117 & 14) | 100666368 | (i11118 & 3670016) | (i11118 & 29360128), 199680, 7696);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierClearAndSetSemantics12 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion11111112, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                } else {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics12, ColorSchemeKt.toColor(timeInputTokens114.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme12.getTypography(composer2, 6), timeInputTokens114.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                Selection selectionM1743boximpl113 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                Selection selectionM1743boximpl114 = Selection.m1743boximpl(i);
                composer2.startReplaceableGroup(1618982084);
                zChanged2 = composer2.changed(selectionM1743boximpl114) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                objRememberedValue4 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect(selectionM1743boximpl113, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
            } else {
                if (i7 != 0) {
                    keyboardOptions3 = KeyboardOptions.Companion.getDefault();
                } else {
                    keyboardOptions3 = keyboardOptions2;
                }
                if (i9 != 0) {
                    keyboardActions3 = KeyboardActions.Companion.getDefault();
                } else {
                    keyboardActions3 = keyboardActions2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
                }
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.Companion;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                MutableInteractionSource mutableInteractionSource13 = (MutableInteractionSource) objRememberedValue;
                composerStartRestartGroup.startReplaceableGroup(-492369756);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                focusRequester = (FocusRequester) objRememberedValue2;
                TextFieldColors textFieldColorsM1686colors0hiis_12 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
                zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
                composerStartRestartGroup.startReplaceableGroup(-483455358);
                Arrangement.Vertical top13 = Arrangement.INSTANCE.getTop();
                Alignment.Companion companion11111115 = Alignment.Companion;
                MeasurePolicy measurePolicyColumnMeasurePolicy13 = ColumnKt.columnMeasurePolicy(top13, companion11111115.getStart(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density115 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection115 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration115 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion11111116 = ComposeUiNode.Companion;
                constructor = companion11111116.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf115 = LayoutKt.materializerOf(modifier);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl115 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl115, measurePolicyColumnMeasurePolicy13, companion11111116.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl115, density115, companion11111116.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl115, layoutDirection115, companion11111116.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl115, viewConfiguration115, companion11111116.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf115.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance13 = ColumnScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(896149831);
                if (zM1746equalsimpl0) {
                    Modifier.Companion companion11111117 = Modifier.Companion;
                    TimeInputTokens timeInputTokens115 = TimeInputTokens.INSTANCE;
                    Modifier modifierM534sizeVpY3zN118 = SizeKt.m534sizeVpY3zN4(companion11111117, timeInputTokens115.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens115.m2546getTimeFieldContainerHeightD9Ej5fM());
                    if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                        minute = timePickerState.getHourForDisplay$material3_release();
                    } else {
                        minute = timePickerState.getMinute();
                    }
                    int i11119 = i12 >> 3;
                    z = zM1746equalsimpl0;
                    r7 = 0;
                    m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN118, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i11119 & 7168) | (i11119 & 896) | 6 | ((i12 >> 9) & 57344));
                } else {
                    z = zM1746equalsimpl0;
                    r7 = 0;
                }
                composerStartRestartGroup.endReplaceableGroup();
                companion2 = Selection.Companion;
                if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
                } else {
                    iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
                }
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
                Modifier.Companion companion11111118 = Modifier.Companion;
                Modifier modifierVisible13 = visible(companion11111118, z);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy13 = BoxKt.rememberBoxMeasurePolicy(companion11111115.getTopStart(), r7, composerStartRestartGroup, r7);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density116 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection116 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration116 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                constructor2 = companion11111116.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf116 = LayoutKt.materializerOf(modifierVisible13);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl116 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl116, measurePolicyRememberBoxMeasurePolicy13, companion11111116.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl116, density116, companion11111116.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl116, layoutDirection116, companion11111116.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl116, viewConfiguration116, companion11111116.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf116.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                Modifier modifierFocusRequester13 = FocusRequesterModifierKt.focusRequester(companion11111118, r21);
                TimeInputTokens timeInputTokens116 = TimeInputTokens.INSTANCE;
                Modifier modifierM534sizeVpY3zN119 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester13, timeInputTokens116.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens116.m2546getTimeFieldContainerHeightD9Ej5fM());
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierSemantics$default13 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN119, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
                TextStyle textStyle13 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
                Brush.Companion companion11111119 = Brush.Companion;
                Float fValueOf115 = Float.valueOf(0.0f);
                Color.Companion companion111111110 = Color.Companion;
                C2020dG c2020dGA115 = HV.a(fValueOf115, Color.m3022boximpl(companion111111110.m3067getTransparent0d7_KjU()));
                C2020dG c2020dGA116 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion111111110.m3067getTransparent0d7_KjU()));
                Float fValueOf116 = Float.valueOf(0.1f);
                MaterialTheme materialTheme13 = MaterialTheme.INSTANCE;
                int i111110 = i12 >> 3;
                int i111111 = i12 << 3;
                BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default13, true, false, textStyle13, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource13, Brush.Companion.m2996verticalGradient8A3gB4$default(companion11111119, new C2020dG[]{c2020dGA115, c2020dGA116, HV.a(fValueOf116, Color.m3022boximpl(materialTheme13.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme13.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion111111110.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion111111110.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource13, textFieldColorsM1686colors0hiis_12)), composerStartRestartGroup, (i111110 & 112) | (i111110 & 14) | 100666368 | (i111111 & 3670016) | (i111111 & 29360128), 199680, 7696);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierClearAndSetSemantics13 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion11111118, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
                if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
                } else {
                    iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
                }
                composer2 = composerStartRestartGroup;
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics13, ColorSchemeKt.toColor(timeInputTokens116.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme13.getTypography(composer2, 6), timeInputTokens116.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                Selection selectionM1743boximpl115 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
                Selection selectionM1743boximpl116 = Selection.m1743boximpl(i);
                composer2.startReplaceableGroup(1618982084);
                zChanged2 = composer2.changed(selectionM1743boximpl116) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
                objRememberedValue4 = composer2.rememberedValue();
                if (zChanged2) {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                composer2.endReplaceableGroup();
                EffectsKt.LaunchedEffect(selectionM1743boximpl115, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                keyboardOptions4 = keyboardOptions3;
                keyboardActions4 = keyboardActions3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimePickerTextField$3(modifier, textFieldValue, interfaceC3750qp, timePickerState, i, keyboardOptions4, keyboardActions4, timePickerColors, i2, i3));
        }
        i11 = 12582912;
        i12 |= i11;
        if ((23967451 & i12) == 4793490) {
            if (i7 != 0) {
                keyboardOptions3 = KeyboardOptions.Companion.getDefault();
            } else {
                keyboardOptions3 = keyboardOptions2;
            }
            if (i9 != 0) {
                keyboardActions3 = KeyboardActions.Companion.getDefault();
            } else {
                keyboardActions3 = keyboardActions2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableInteractionSource mutableInteractionSource14 = (MutableInteractionSource) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            focusRequester = (FocusRequester) objRememberedValue2;
            TextFieldColors textFieldColorsM1686colors0hiis_13 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
            zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Arrangement.Vertical top14 = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion111111111 = Alignment.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy14 = ColumnKt.columnMeasurePolicy(top14, companion111111111.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density117 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection117 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration117 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion111111112 = ComposeUiNode.Companion;
            constructor = companion111111112.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf117 = LayoutKt.materializerOf(modifier);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl117 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl117, measurePolicyColumnMeasurePolicy14, companion111111112.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl117, density117, companion111111112.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl117, layoutDirection117, companion111111112.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl117, viewConfiguration117, companion111111112.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf117.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance14 = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(896149831);
            if (zM1746equalsimpl0) {
                Modifier.Companion companion111111113 = Modifier.Companion;
                TimeInputTokens timeInputTokens117 = TimeInputTokens.INSTANCE;
                Modifier modifierM534sizeVpY3zN1110 = SizeKt.m534sizeVpY3zN4(companion111111113, timeInputTokens117.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens117.m2546getTimeFieldContainerHeightD9Ej5fM());
                if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                    minute = timePickerState.getHourForDisplay$material3_release();
                } else {
                    minute = timePickerState.getMinute();
                }
                int i111112 = i12 >> 3;
                z = zM1746equalsimpl0;
                r7 = 0;
                m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN1110, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i111112 & 7168) | (i111112 & 896) | 6 | ((i12 >> 9) & 57344));
            } else {
                z = zM1746equalsimpl0;
                r7 = 0;
            }
            composerStartRestartGroup.endReplaceableGroup();
            companion2 = Selection.Companion;
            if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
            } else {
                iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
            }
            strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
            Modifier.Companion companion111111114 = Modifier.Companion;
            Modifier modifierVisible14 = visible(companion111111114, z);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy14 = BoxKt.rememberBoxMeasurePolicy(companion111111111.getTopStart(), r7, composerStartRestartGroup, r7);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density118 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection118 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration118 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor2 = companion111111112.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf118 = LayoutKt.materializerOf(modifierVisible14);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl118 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl118, measurePolicyRememberBoxMeasurePolicy14, companion111111112.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl118, density118, companion111111112.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl118, layoutDirection118, companion111111112.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl118, viewConfiguration118, companion111111112.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf118.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
            Modifier modifierFocusRequester14 = FocusRequesterModifierKt.focusRequester(companion111111114, r21);
            TimeInputTokens timeInputTokens118 = TimeInputTokens.INSTANCE;
            Modifier modifierM534sizeVpY3zN1111 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester14, timeInputTokens118.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens118.m2546getTimeFieldContainerHeightD9Ej5fM());
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierSemantics$default14 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN1111, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
            TextStyle textStyle14 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
            Brush.Companion companion111111115 = Brush.Companion;
            Float fValueOf117 = Float.valueOf(0.0f);
            Color.Companion companion111111116 = Color.Companion;
            C2020dG c2020dGA117 = HV.a(fValueOf117, Color.m3022boximpl(companion111111116.m3067getTransparent0d7_KjU()));
            C2020dG c2020dGA118 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion111111116.m3067getTransparent0d7_KjU()));
            Float fValueOf118 = Float.valueOf(0.1f);
            MaterialTheme materialTheme14 = MaterialTheme.INSTANCE;
            int i111113 = i12 >> 3;
            int i111114 = i12 << 3;
            BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default14, true, false, textStyle14, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource14, Brush.Companion.m2996verticalGradient8A3gB4$default(companion111111115, new C2020dG[]{c2020dGA117, c2020dGA118, HV.a(fValueOf118, Color.m3022boximpl(materialTheme14.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme14.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion111111116.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion111111116.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource14, textFieldColorsM1686colors0hiis_13)), composerStartRestartGroup, (i111113 & 112) | (i111113 & 14) | 100666368 | (i111114 & 3670016) | (i111114 & 29360128), 199680, 7696);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierClearAndSetSemantics14 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion111111114, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
            if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
            } else {
                iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
            }
            composer2 = composerStartRestartGroup;
            TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics14, ColorSchemeKt.toColor(timeInputTokens118.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme14.getTypography(composer2, 6), timeInputTokens118.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            Selection selectionM1743boximpl117 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
            Selection selectionM1743boximpl118 = Selection.m1743boximpl(i);
            composer2.startReplaceableGroup(1618982084);
            zChanged2 = composer2.changed(selectionM1743boximpl118) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
            objRememberedValue4 = composer2.rememberedValue();
            if (zChanged2) {
                objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(selectionM1743boximpl117, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions4 = keyboardOptions3;
            keyboardActions4 = keyboardActions3;
        } else {
            if (i7 != 0) {
                keyboardOptions3 = KeyboardOptions.Companion.getDefault();
            } else {
                keyboardOptions3 = keyboardOptions2;
            }
            if (i9 != 0) {
                keyboardActions3 = KeyboardActions.Companion.getDefault();
            } else {
                keyboardActions3 = keyboardActions2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-367523658, i12, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1386)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableInteractionSource mutableInteractionSource15 = (MutableInteractionSource) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            focusRequester = (FocusRequester) objRememberedValue2;
            TextFieldColors textFieldColorsM1686colors0hiis_14 = OutlinedTextFieldDefaults.INSTANCE.m1686colors0hiis_0(timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(true), 0L, 0L, 0L, timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(true), 0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, 0, 0, 3072, 2147483598, 4095);
            zM1746equalsimpl0 = Selection.m1746equalsimpl0(i, timePickerState.m1974getSelectionJiIwxys$material3_release());
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Arrangement.Vertical top15 = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion111111117 = Alignment.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy15 = ColumnKt.columnMeasurePolicy(top15, companion111111117.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density119 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection119 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration119 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion111111118 = ComposeUiNode.Companion;
            constructor = companion111111118.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf119 = LayoutKt.materializerOf(modifier);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl119 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl119, measurePolicyColumnMeasurePolicy15, companion111111118.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl119, density119, companion111111118.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl119, layoutDirection119, companion111111118.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl119, viewConfiguration119, companion111111118.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf119.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance15 = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(896149831);
            if (zM1746equalsimpl0) {
                Modifier.Companion companion111111119 = Modifier.Companion;
                TimeInputTokens timeInputTokens119 = TimeInputTokens.INSTANCE;
                Modifier modifierM534sizeVpY3zN1112 = SizeKt.m534sizeVpY3zN4(companion111111119, timeInputTokens119.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens119.m2546getTimeFieldContainerHeightD9Ej5fM());
                if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                    minute = timePickerState.getHourForDisplay$material3_release();
                } else {
                    minute = timePickerState.getMinute();
                }
                int i111115 = i12 >> 3;
                z = zM1746equalsimpl0;
                r7 = 0;
                m1947TimeSelectoruXwN82Y(modifierM534sizeVpY3zN1112, minute, timePickerState, i, timePickerColors, composerStartRestartGroup, (i111115 & 7168) | (i111115 & 896) | 6 | ((i12 >> 9) & 57344));
            } else {
                z = zM1746equalsimpl0;
                r7 = 0;
            }
            composerStartRestartGroup.endReplaceableGroup();
            companion2 = Selection.Companion;
            if (Selection.m1746equalsimpl0(i, companion2.m1751getMinuteJiIwxys())) {
                iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1836getTimePickerMinuteTextFieldadMyvUU();
            } else {
                iM1832getTimePickerHourTextFieldadMyvUU = Strings.Companion.m1832getTimePickerHourTextFieldadMyvUU();
            }
            strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(iM1832getTimePickerHourTextFieldadMyvUU, composerStartRestartGroup, r7);
            Modifier.Companion companion1111111110 = Modifier.Companion;
            Modifier modifierVisible15 = visible(companion1111111110, z);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy15 = BoxKt.rememberBoxMeasurePolicy(companion111111117.getTopStart(), r7, composerStartRestartGroup, r7);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density1110 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection1110 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration1110 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            constructor2 = companion111111118.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf1110 = LayoutKt.materializerOf(modifierVisible15);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl1110 = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl1110, measurePolicyRememberBoxMeasurePolicy15, companion111111118.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl1110, density1110, companion111111118.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl1110, layoutDirection1110, companion111111118.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl1110, viewConfiguration1110, companion111111118.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf1110.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
            Modifier modifierFocusRequester15 = FocusRequesterModifierKt.focusRequester(companion1111111110, r21);
            TimeInputTokens timeInputTokens1110 = TimeInputTokens.INSTANCE;
            Modifier modifierM534sizeVpY3zN1113 = SizeKt.m534sizeVpY3zN4(modifierFocusRequester15, timeInputTokens1110.m2547getTimeFieldContainerWidthD9Ej5fM(), timeInputTokens1110.m2546getTimeFieldContainerHeightD9Ej5fM());
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new TimePickerKt$TimePickerTextField$1$1$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierSemantics$default15 = SemanticsModifierKt.semantics$default(modifierM534sizeVpY3zN1113, false, (InterfaceC3750qp) objRememberedValue3, 1, null);
            TextStyle textStyle15 = (TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle());
            Brush.Companion companion1111111111 = Brush.Companion;
            Float fValueOf119 = Float.valueOf(0.0f);
            Color.Companion companion1111111112 = Color.Companion;
            C2020dG c2020dGA119 = HV.a(fValueOf119, Color.m3022boximpl(companion1111111112.m3067getTransparent0d7_KjU()));
            C2020dG c2020dGA1110 = HV.a(Float.valueOf(0.1f), Color.m3022boximpl(companion1111111112.m3067getTransparent0d7_KjU()));
            Float fValueOf1110 = Float.valueOf(0.1f);
            MaterialTheme materialTheme15 = MaterialTheme.INSTANCE;
            int i111116 = i12 >> 3;
            int i111117 = i12 << 3;
            BasicTextFieldKt.BasicTextField(textFieldValue, interfaceC3750qp, modifierSemantics$default15, true, false, textStyle15, keyboardOptions3, keyboardActions3, true, 0, 0, (VisualTransformation) null, (InterfaceC3750qp) null, mutableInteractionSource15, Brush.Companion.m2996verticalGradient8A3gB4$default(companion1111111111, new C2020dG[]{c2020dGA119, c2020dGA1110, HV.a(fValueOf1110, Color.m3022boximpl(materialTheme15.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(materialTheme15.getColorScheme(composerStartRestartGroup, 6).m1408getPrimary0d7_KjU())), HV.a(Float.valueOf(0.9f), Color.m3022boximpl(companion1111111112.m3067getTransparent0d7_KjU())), HV.a(Float.valueOf(1.0f), Color.m3022boximpl(companion1111111112.m3067getTransparent0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (InterfaceC0552Gp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 2133555260, true, new TimePickerKt$TimePickerTextField$1$1$2(textFieldValue, mutableInteractionSource15, textFieldColorsM1686colors0hiis_14)), composerStartRestartGroup, (i111116 & 112) | (i111116 & 14) | 100666368 | (i111117 & 3670016) | (i111117 & 29360128), 199680, 7696);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierClearAndSetSemantics15 = SemanticsModifierKt.clearAndSetSemantics(androidx.compose.foundation.layout.OffsetKt.m446offsetVpY3zN4$default(companion1111111110, 0.0f, SupportLabelTop, 1, null), TimePickerKt$TimePickerTextField$1$2.INSTANCE);
            if (Selection.m1746equalsimpl0(i, companion2.m1750getHourJiIwxys())) {
                iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1829getTimePickerHouradMyvUU();
            } else {
                iM1833getTimePickerMinuteadMyvUU = Strings.Companion.m1833getTimePickerMinuteadMyvUU();
            }
            composer2 = composerStartRestartGroup;
            TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(iM1833getTimePickerMinuteadMyvUU, composer2, 0), modifierClearAndSetSemantics15, ColorSchemeKt.toColor(timeInputTokens1110.getTimeFieldSupportingTextColor(), composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, TypographyKt.fromToken(materialTheme15.getTypography(composer2, 6), timeInputTokens1110.getTimeFieldSupportingTextFont()), composer2, 0, 0, 65528);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            Selection selectionM1743boximpl119 = Selection.m1743boximpl(timePickerState.m1974getSelectionJiIwxys$material3_release());
            Selection selectionM1743boximpl1110 = Selection.m1743boximpl(i);
            composer2.startReplaceableGroup(1618982084);
            zChanged2 = composer2.changed(selectionM1743boximpl1110) | composer2.changed(timePickerState) | composer2.changed(focusRequester);
            objRememberedValue4 = composer2.rememberedValue();
            if (zChanged2) {
                objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new TimePickerKt$TimePickerTextField$2$1(timePickerState, i, focusRequester, null);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(selectionM1743boximpl119, (InterfaceC0526Fp) objRememberedValue4, composer2, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            keyboardOptions4 = keyboardOptions3;
            keyboardActions4 = keyboardActions3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimePickerTextField$3(modifier, textFieldValue, interfaceC3750qp, timePickerState, i, keyboardOptions4, keyboardActions4, timePickerColors, i2, i3));
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: TimeSelector-uXwN82Y, reason: not valid java name */
    public static final void m1947TimeSelectoruXwN82Y(Modifier modifier, int i, TimePickerState timePickerState, int i2, TimePickerColors timePickerColors, Composer composer, int i3) {
        int i4;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(21099367);
        if ((i3 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(timePickerState) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
        }
        if ((57344 & i3) == 0) {
            i4 |= composerStartRestartGroup.changed(timePickerColors) ? 16384 : 8192;
        }
        int i5 = i4;
        if ((46811 & i5) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(21099367, i5, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1070)");
            }
            boolean zM1746equalsimpl0 = Selection.m1746equalsimpl0(timePickerState.m1974getSelectionJiIwxys$material3_release(), i2);
            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Selection.m1746equalsimpl0(i2, Selection.Companion.m1750getHourJiIwxys()) ? Strings.Companion.m1830getTimePickerHourSelectionadMyvUU() : Strings.Companion.m1834getTimePickerMinuteSelectionadMyvUU(), composerStartRestartGroup, 0);
            long jM1940timeSelectorContainerColorvNxB06k$material3_release = timePickerColors.m1940timeSelectorContainerColorvNxB06k$material3_release(zM1746equalsimpl0);
            long jM1941timeSelectorContentColorvNxB06k$material3_release = timePickerColors.m1941timeSelectorContentColorvNxB06k$material3_release(zM1746equalsimpl0);
            composerStartRestartGroup.startReplaceableGroup(773894976);
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composerStartRestartGroup));
                composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(strM1841getStringNWtq28);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new TimePickerKt$TimeSelector$1$1(strM1841getStringNWtq28);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1851Surfaced85dljk(zM1746equalsimpl0, (InterfaceC3588op) new TimePickerKt$TimeSelector$2(i2, timePickerState, coroutineScope), SemanticsModifierKt.semantics(modifier, true, (InterfaceC3750qp) objRememberedValue2), false, ShapesKt.toShape(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), composerStartRestartGroup, 6), jM1940timeSelectorContainerColorvNxB06k$material3_release, 0L, 0.0f, 0.0f, (BorderStroke) null, (MutableInteractionSource) null, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1338709103, true, new TimePickerKt$TimeSelector$3(i2, timePickerState, i, i5, jM1941timeSelectorContentColorvNxB06k$material3_release)), composer2, 0, 48, 1992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TimePickerKt$TimeSelector$4(modifier, i, timePickerState, i2, timePickerColors, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ToggleItem(boolean z, Shape shape, InterfaceC3588op interfaceC3588op, TimePickerColors timePickerColors, InterfaceC0552Gp interfaceC0552Gp, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1937408098);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0552Gp) ? 16384 : 8192;
        }
        if ((46811 & i2) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937408098, i2, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1019)");
            }
            long jM1939periodSelectorContentColorvNxB06k$material3_release = timePickerColors.m1939periodSelectorContentColorvNxB06k$material3_release(z);
            long jM1938periodSelectorContainerColorvNxB06k$material3_release = timePickerColors.m1938periodSelectorContainerColorvNxB06k$material3_release(z);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, z ? 0.0f : 1.0f), 0.0f, 1, null);
            Boolean boolValueOf = Boolean.valueOf(z);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new TimePickerKt$ToggleItem$1$1(z);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            ButtonKt.TextButton(interfaceC3588op, SemanticsModifierKt.semantics$default(modifierFillMaxSize$default, false, (InterfaceC3750qp) objRememberedValue, 1, null), false, shape, ButtonDefaults.INSTANCE.m1367textButtonColorsro_MJ88(jM1938periodSelectorContainerColorvNxB06k$material3_release, jM1939periodSelectorContentColorvNxB06k$material3_release, 0L, 0L, composerStartRestartGroup, 24576, 12), null, null, PaddingKt.m478PaddingValues0680j_4(Dp.m5160constructorimpl(0)), null, interfaceC0552Gp, composerStartRestartGroup, ((i2 >> 6) & 14) | 12582912 | ((i2 << 6) & 7168) | ((i2 << 15) & 1879048192), 356);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15992(z, shape, interfaceC3588op, timePickerColors, interfaceC0552Gp, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VerticalClockDisplay(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2054675515);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054675515, i2, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:820)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            Modifier.Companion companion = Modifier.Companion;
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, companion2.getTop(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composerStartRestartGroup);
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ClockDisplayNumbers(timePickerState, timePickerColors, composerStartRestartGroup, i2 & 126);
            composerStartRestartGroup.startReplaceableGroup(952907597);
            if (!timePickerState.is24hour()) {
                Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(companion, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                InterfaceC3588op constructor2 = companion3.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM489paddingqDBjuR0$default);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerStartRestartGroup.disableReusing();
                Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composerStartRestartGroup);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
                int i3 = i2 << 3;
                VerticalPeriodToggle(SizeKt.m534sizeVpY3zN4(companion, timePickerTokens.m2558getPeriodSelectorVerticalContainerWidthD9Ej5fM(), timePickerTokens.m2557getPeriodSelectorVerticalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, (i3 & 896) | (i3 & 112) | 6);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C16002(timePickerState, timePickerColors, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VerticalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1898918107);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerState) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, i2, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:921)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return AbstractC2260gB.a(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return AbstractC2260gB.b(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo17measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        AbstractC4492zt.h(measureScope, "$this$MeasurePolicy");
                        AbstractC4492zt.h(list, "measurables");
                        List<? extends Measurable> list2 = list;
                        for (Measurable measurable : list2) {
                            if (AbstractC4492zt.d(LayoutIdKt.getLayoutId(measurable), "Spacer")) {
                                Placeable placeableMo4159measureBRTryo0 = measurable.mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, AbstractC1210aB.c(measureScope.mo333toPx0680j_4(TimePickerTokens.INSTANCE.m2556getPeriodSelectorOutlineWidthD9Ej5fM())), 3, null));
                                ArrayList arrayList = new ArrayList();
                                for (Object obj : list2) {
                                    if (!AbstractC4492zt.d(LayoutIdKt.getLayoutId((Measurable) obj), "Spacer")) {
                                        arrayList.add(obj);
                                    }
                                }
                                ArrayList arrayList2 = new ArrayList(AbstractC2044dc.x(arrayList, 10));
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    arrayList2.add(((Measurable) it.next()).mo4159measureBRTryo0(Constraints.m5119copyZbe2FdA$default(j, 0, 0, 0, Constraints.m5127getMaxHeightimpl(j) / 2, 3, null)));
                                }
                                return MeasureScope.CC.q(measureScope, Constraints.m5128getMaxWidthimpl(j), Constraints.m5127getMaxHeightimpl(j), null, new TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1$measure$1(arrayList2, placeableMo4159measureBRTryo0), 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
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
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            Shape shape = ShapesKt.toShape(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            AbstractC4492zt.f(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) shape;
            PeriodToggleImpl(modifier, timePickerState, timePickerColors, measurePolicy, ShapesKt.top(cornerBasedShape), ShapesKt.bottom(cornerBasedShape), composerStartRestartGroup, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C16011(modifier, timePickerState, timePickerColors, i));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:73:0x014e  */
    /* JADX WARN: Code duplicated, block: B:76:0x015a  */
    /* JADX WARN: Code duplicated, block: B:77:0x015e  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterial3Api
    public static final void VerticalTimePicker(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, boolean z, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        TimePickerColors timePickerColorsM1942colorsu3YEpmA;
        int i4;
        int i5;
        Modifier modifier3;
        Composer composer2;
        Composer composer3;
        InterfaceC3588op constructor;
        Modifier modifier4;
        TimePickerColors timePickerColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(timePickerState, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(310683247);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(timePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                if ((i2 & 4) == 0) {
                    timePickerColorsM1942colorsu3YEpmA = timePickerColors;
                    int i7 = composerStartRestartGroup.changed(timePickerColorsM1942colorsu3YEpmA) ? 256 : 128;
                    i3 |= i7;
                } else {
                    timePickerColorsM1942colorsu3YEpmA = timePickerColors;
                }
                i3 |= i7;
            } else {
                timePickerColorsM1942colorsu3YEpmA = timePickerColors;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
                i3 |= i4;
            }
            i5 = i3;
            if ((i5 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        i5 &= -897;
                        modifier2 = modifier3;
                        timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 24576, 16383);
                    } else {
                        composer2 = composerStartRestartGroup;
                        modifier2 = modifier3;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i5 &= -897;
                    }
                    composer2 = composerStartRestartGroup;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(310683247, i5, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:661)");
                }
                Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
                int i8 = i5 >> 3;
                composer3 = composer2;
                composer3.startReplaceableGroup(-483455358);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer3, 48);
                composer3.startReplaceableGroup(-1323940314);
                Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                constructor = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifier2);
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                composer3.disableReusing();
                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer3);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
                composer3.enableReusing();
                interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer3)), composer3, 0);
                composer3.startReplaceableGroup(2058660585);
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i9 = (i5 & 14) | (i8 & 112);
                VerticalClockDisplay(timePickerState, timePickerColorsM1942colorsu3YEpmA, composer3, i9);
                Modifier.Companion companion2 = Modifier.Companion;
                SpacerKt.Spacer(SizeKt.m518height3ABfNKs(companion2, ClockDisplayBottomMargin), composer3, 6);
                ClockFace(timePickerState, timePickerColorsM1942colorsu3YEpmA, z, composer3, i9 | (i8 & 896));
                SpacerKt.Spacer(SizeKt.m518height3ABfNKs(companion2, ClockFaceBottomMargin), composer3, 6);
                composer3.endReplaceableGroup();
                composer3.endNode();
                composer3.endReplaceableGroup();
                composer3.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier2;
                timePickerColors2 = timePickerColorsM1942colorsu3YEpmA;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                timePickerColors2 = timePickerColorsM1942colorsu3YEpmA;
                composer3 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C16022(timePickerState, modifier4, timePickerColors2, z, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                timePickerColorsM1942colorsu3YEpmA = timePickerColors;
                if (composerStartRestartGroup.changed(timePickerColorsM1942colorsu3YEpmA)) {
                }
                i3 |= i7;
            } else {
                timePickerColorsM1942colorsu3YEpmA = timePickerColors;
            }
            i3 |= i7;
        } else {
            timePickerColorsM1942colorsu3YEpmA = timePickerColors;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        i5 = i3;
        if ((i5 & 5851) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    i5 &= -897;
                    modifier2 = modifier3;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 24576, 16383);
                } else {
                    composer2 = composerStartRestartGroup;
                    modifier2 = modifier3;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    i5 &= -897;
                    modifier2 = modifier3;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 24576, 16383);
                } else {
                    composer2 = composerStartRestartGroup;
                    modifier2 = modifier3;
                }
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(310683247, i5, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:661)");
            }
            Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
            int i10 = i5 >> 3;
            composer3 = composer2;
            composer3.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composer3, 48);
            composer3.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifier2);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            composer3.disableReusing();
            Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer3);
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyColumnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
            composer3.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer3)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i11 = (i5 & 14) | (i10 & 112);
            VerticalClockDisplay(timePickerState, timePickerColorsM1942colorsu3YEpmA, composer3, i11);
            Modifier.Companion companion4 = Modifier.Companion;
            SpacerKt.Spacer(SizeKt.m518height3ABfNKs(companion4, ClockDisplayBottomMargin), composer3, 6);
            ClockFace(timePickerState, timePickerColorsM1942colorsu3YEpmA, z, composer3, i11 | (i10 & 896));
            SpacerKt.Spacer(SizeKt.m518height3ABfNKs(companion4, ClockFaceBottomMargin), composer3, 6);
            composer3.endReplaceableGroup();
            composer3.endNode();
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier2;
            timePickerColors2 = timePickerColorsM1942colorsu3YEpmA;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    i5 &= -897;
                    modifier2 = modifier3;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 24576, 16383);
                } else {
                    composer2 = composerStartRestartGroup;
                    modifier2 = modifier3;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    i5 &= -897;
                    modifier2 = modifier3;
                    timePickerColorsM1942colorsu3YEpmA = TimePickerDefaults.INSTANCE.m1942colorsu3YEpmA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, 24576, 16383);
                } else {
                    composer2 = composerStartRestartGroup;
                    modifier2 = modifier3;
                }
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(310683247, i5, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:661)");
            }
            Alignment.Horizontal centerHorizontally3 = Alignment.Companion.getCenterHorizontally();
            int i12 = i5 >> 3;
            composer3 = composer2;
            composer3.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally3, composer3, 48);
            composer3.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion5 = ComposeUiNode.Companion;
            constructor = companion5.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifier2);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            composer3.disableReusing();
            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composer3);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyColumnMeasurePolicy3, companion5.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion5.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion5.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion5.getSetViewConfiguration());
            composer3.enableReusing();
            interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer3)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
            int i13 = (i5 & 14) | (i12 & 112);
            VerticalClockDisplay(timePickerState, timePickerColorsM1942colorsu3YEpmA, composer3, i13);
            Modifier.Companion companion6 = Modifier.Companion;
            SpacerKt.Spacer(SizeKt.m518height3ABfNKs(companion6, ClockDisplayBottomMargin), composer3, 6);
            ClockFace(timePickerState, timePickerColorsM1942colorsu3YEpmA, z, composer3, i13 | (i12 & 896));
            SpacerKt.Spacer(SizeKt.m518height3ABfNKs(companion6, ClockFaceBottomMargin), composer3, 6);
            composer3.endReplaceableGroup();
            composer3.endNode();
            composer3.endReplaceableGroup();
            composer3.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier2;
            timePickerColors2 = timePickerColorsM1942colorsu3YEpmA;
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C16022(timePickerState, modifier4, timePickerColors2, z, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float atan(float f, float f2) {
        float fAtan2 = ((float) Math.atan2(f, f2)) - 1.5707964f;
        return fAtan2 < 0.0f ? fAtan2 + FullCircle : fAtan2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier clockDial(Modifier modifier, TimePickerState timePickerState, boolean z) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TimePickerKt$clockDial$$inlined$debugInspectorInfo$1(timePickerState) : InspectableValueKt.getNoInspectorInfo(), new C16032(timePickerState, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dist(float f, float f2, int i, int i2) {
        return (float) Math.hypot(i - f, i2 - f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier drawSelector(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors) {
        return DrawModifierKt.drawWithContent(modifier, new C16041(timePickerState, timePickerColors));
    }

    @Composable
    @ReadOnlyComposable
    /* JADX INFO: renamed from: numberContentDescription-YKJpE6Y, reason: not valid java name */
    public static final String m1952numberContentDescriptionYKJpE6Y(int i, boolean z, int i2, Composer composer, int i3) {
        int iM1827getTimePicker24HourSuffixadMyvUU;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1826155772, i3, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1542)");
        }
        if (Selection.m1746equalsimpl0(i, Selection.Companion.m1751getMinuteJiIwxys())) {
            iM1827getTimePicker24HourSuffixadMyvUU = Strings.Companion.m1835getTimePickerMinuteSuffixadMyvUU();
        } else {
            iM1827getTimePicker24HourSuffixadMyvUU = z ? Strings.Companion.m1827getTimePicker24HourSuffixadMyvUU() : Strings.Companion.m1831getTimePickerHourSuffixadMyvUU();
        }
        String strM1842getStringiSCLEhQ = Strings_androidKt.m1842getStringiSCLEhQ(iM1827getTimePicker24HourSuffixadMyvUU, new Object[]{Integer.valueOf(i2)}, composer, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return strM1842getStringiSCLEhQ;
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final TimePickerState rememberTimePickerState(int i, int i2, boolean z, Composer composer, int i3, int i4) {
        composer.startReplaceableGroup(1237715277);
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = TimeFormat_androidKt.is24HourFormat(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1237715277, i3, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:438)");
        }
        Object[] objArr = new Object[0];
        Saver<TimePickerState, ?> Saver = TimePickerState.Companion.Saver();
        Integer numValueOf = Integer.valueOf(i);
        Integer numValueOf2 = Integer.valueOf(i2);
        Boolean boolValueOf = Boolean.valueOf(z);
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(numValueOf) | composer.changed(numValueOf2) | composer.changed(boolValueOf);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new TimePickerKt$rememberTimePickerState$1$1(i, i2, z);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TimePickerState timePickerState = (TimePickerState) RememberSaveableKt.m2674rememberSaveable(objArr, (Saver) Saver, (String) null, (InterfaceC3588op) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return timePickerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: timeInputOnChange-gIWD5Rc, reason: not valid java name */
    public static final void m1953timeInputOnChangegIWD5Rc(int i, TimePickerState timePickerState, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, int i2, InterfaceC3750qp interfaceC3750qp) {
        if (AbstractC4492zt.d(textFieldValue.getText(), textFieldValue2.getText())) {
            interfaceC3750qp.invoke(textFieldValue);
            return;
        }
        if (textFieldValue.getText().length() == 0) {
            if (Selection.m1746equalsimpl0(i, Selection.Companion.m1750getHourJiIwxys())) {
                timePickerState.setHour$material3_release(0);
            } else {
                timePickerState.setMinute$material3_release(0);
            }
            interfaceC3750qp.invoke(TextFieldValue.m4918copy3r_uNRQ$default(textFieldValue, "", 0L, (TextRange) null, 6, (Object) null));
            return;
        }
        try {
            int iG = (textFieldValue.getText().length() == 3 && TextRange.m4705getStartimpl(textFieldValue.m4922getSelectiond9O1mEE()) == 1) ? AbstractC3648pb.g(textFieldValue.getText().charAt(0)) : Integer.parseInt(textFieldValue.getText());
            if (iG <= i2) {
                Selection.Companion companion = Selection.Companion;
                if (Selection.m1746equalsimpl0(i, companion.m1750getHourJiIwxys())) {
                    timePickerState.setHour$material3_release(iG);
                    if (iG > 1 && !timePickerState.is24hour()) {
                        timePickerState.m1977setSelectioniHAOin8$material3_release(companion.m1751getMinuteJiIwxys());
                    }
                } else {
                    timePickerState.setMinute$material3_release(iG);
                }
                if (textFieldValue.getText().length() > 2) {
                    textFieldValue = TextFieldValue.m4918copy3r_uNRQ$default(textFieldValue, String.valueOf(textFieldValue.getText().charAt(0)), 0L, (TextRange) null, 6, (Object) null);
                }
                interfaceC3750qp.invoke(textFieldValue);
            }
        } catch (NumberFormatException | IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toLocalString(int i, int i2) {
        NumberFormat integerInstance = NumberFormat.getIntegerInstance();
        integerInstance.setGroupingUsed(false);
        integerInstance.setMinimumIntegerDigits(i2);
        String str = integerInstance.format(Integer.valueOf(i));
        AbstractC4492zt.g(str, "formatter.format(this)");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C2020dG valuesForAnimation(float f, float f2) {
        if (Math.abs(f - f2) <= 3.141592653589793d) {
            return new C2020dG(Float.valueOf(f), Float.valueOf(f2));
        }
        double d = f;
        if (d > 3.141592653589793d && f2 < 3.141592653589793d) {
            f2 += FullCircle;
        } else if (d < 3.141592653589793d && f2 > 3.141592653589793d) {
            f += FullCircle;
        }
        return new C2020dG(Float.valueOf(f), Float.valueOf(f2));
    }

    @Stable
    private static final Modifier visible(Modifier modifier, boolean z) {
        return modifier.then(new VisibleModifier(z, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TimePickerKt$visible$$inlined$debugInspectorInfo$1(z) : InspectableValueKt.getNoInspectorInfo()));
    }
}
