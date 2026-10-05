package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.PointerIconCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.itextpdf.text.Annotation;
import com.itextpdf.xmp.options.PropertyOptions;
import defpackage.AbstractC0378Bt;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3240kc;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.C1172Zk;
import defpackage.C2020dG;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC0995Vm;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DatePickerKt {
    private static final PaddingValues DatePickerHeadlinePadding;
    private static final float DatePickerHorizontalPadding;
    private static final PaddingValues DatePickerModeTogglePadding;
    private static final PaddingValues DatePickerTitlePadding;
    private static final int MaxCalendarRows = 6;
    private static final int YearsInRow = 3;
    private static final float YearsVerticalPadding;
    private static final float RecommendedSizeForAccessibility = Dp.m5160constructorimpl(48);
    private static final float MonthYearHeight = Dp.m5160constructorimpl(56);

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePicker$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        public final Boolean invoke(long j) {
            return Boolean.TRUE;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).longValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePicker$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(DatePickerState datePickerState, int i) {
            super(2);
            this.$state = datePickerState;
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
                ComposerKt.traceEventStart(448469326, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:154)");
            }
            DatePickerDefaults.INSTANCE.DatePickerTitle(this.$state, PaddingKt.padding(Modifier.Companion, DatePickerKt.DatePickerTitlePadding), composer, (this.$$dirty & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePicker$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ DatePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, int i) {
            super(2);
            this.$state = datePickerState;
            this.$dateFormatter = datePickerFormatter;
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
                ComposerKt.traceEventStart(1578326756, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:160)");
            }
            DatePickerDefaults datePickerDefaults = DatePickerDefaults.INSTANCE;
            DatePickerState datePickerState = this.$state;
            DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            Modifier modifierPadding = PaddingKt.padding(Modifier.Companion, DatePickerKt.DatePickerHeadlinePadding);
            int i2 = this.$$dirty;
            datePickerDefaults.DatePickerHeadline(datePickerState, datePickerFormatter, modifierPadding, composer, (i2 & 14) | 3456 | ((i2 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePicker$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(DatePickerState datePickerState, int i) {
            super(2);
            this.$state = datePickerState;
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
                ComposerKt.traceEventStart(-1702543532, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:175)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.Companion, DatePickerKt.getDatePickerModeTogglePadding());
            int iM1512getDisplayModejFl4v0 = this.$state.m1512getDisplayModejFl4v0();
            DatePickerState datePickerState = this.$state;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(datePickerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new DatePickerKt$DatePicker$5$1$1(datePickerState);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            DatePickerKt.m1501DisplayModeToggleButtontER2X8s(modifierPadding, iM1512getDisplayModejFl4v0, (InterfaceC3750qp) objRememberedValue, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePicker$6, reason: invalid class name */
    public static final class AnonymousClass6 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ DatePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, int i) {
            super(2);
            this.$state = datePickerState;
            this.$dateFormatter = datePickerFormatter;
            this.$dateValidator = interfaceC3750qp;
            this.$colors = datePickerColors;
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
                ComposerKt.traceEventStart(173769747, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:194)");
            }
            DatePickerState datePickerState = this.$state;
            DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            InterfaceC3750qp interfaceC3750qp = this.$dateValidator;
            DatePickerColors datePickerColors = this.$colors;
            int i2 = this.$$dirty;
            DatePickerKt.SwitchableDateEntryContent(datePickerState, datePickerFormatter, interfaceC3750qp, datePickerColors, composer, (i2 & 14) | ((i2 >> 3) & 112) | ((i2 >> 3) & 896) | ((i2 >> 12) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePicker$7, reason: invalid class name */
    public static final class AnonymousClass7 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ InterfaceC0526Fp $headline;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $showModeToggle;
        final /* synthetic */ DatePickerState $state;
        final /* synthetic */ InterfaceC0526Fp $title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(DatePickerState datePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, boolean z, DatePickerColors datePickerColors, int i, int i2) {
            super(2);
            this.$state = datePickerState;
            this.$modifier = modifier;
            this.$dateFormatter = datePickerFormatter;
            this.$dateValidator = interfaceC3750qp;
            this.$title = interfaceC0526Fp;
            this.$headline = interfaceC0526Fp2;
            this.$showModeToggle = z;
            this.$colors = datePickerColors;
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
            DatePickerKt.DatePicker(this.$state, this.$modifier, this.$dateFormatter, this.$dateValidator, this.$title, this.$headline, this.$showModeToggle, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14862 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ StateData $stateData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14862(StateData stateData, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, int i) {
            super(2);
            this.$stateData = stateData;
            this.$dateFormatter = datePickerFormatter;
            this.$dateValidator = interfaceC3750qp;
            this.$colors = datePickerColors;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            DatePickerKt.DatePickerContent(this.$stateData, this.$dateFormatter, this.$dateValidator, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$Day$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14872 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14872(InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$content = interfaceC0526Fp;
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
                ComposerKt.traceEventStart(-2031780827, i, -1, "androidx.compose.material3.Day.<anonymous> (DatePicker.kt:1619)");
            }
            Alignment center = Alignment.Companion.getCenter();
            InterfaceC0526Fp interfaceC0526Fp = this.$content;
            int i2 = this.$$dirty;
            composer.startReplaceableGroup(733328855);
            Modifier.Companion companion = Modifier.Companion;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i2 >> 27) & 14));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$Day$3, reason: invalid class name and case insensitive filesystem */
    public static final class C14883 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ boolean $animateChecked;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ String $description;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ boolean $inRange;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ boolean $today;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14883(Modifier modifier, boolean z, InterfaceC3588op interfaceC3588op, boolean z2, boolean z3, boolean z4, boolean z5, String str, DatePickerColors datePickerColors, InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$modifier = modifier;
            this.$selected = z;
            this.$onClick = interfaceC3588op;
            this.$animateChecked = z2;
            this.$enabled = z3;
            this.$today = z4;
            this.$inRange = z5;
            this.$description = str;
            this.$colors = datePickerColors;
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
            DatePickerKt.Day(this.$modifier, this.$selected, this.$onClick, this.$animateChecked, this.$enabled, this.$today, this.$inRange, this.$description, this.$colors, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01011 extends AbstractC2233fv implements InterfaceC3588op {
            public static final C01011 INSTANCE = new C01011();

            public C01011() {
                super(0);
            }

            @Override // defpackage.InterfaceC3588op
            public final Float invoke() {
                return Float.valueOf(0.0f);
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
                super(0);
            }

            @Override // defpackage.InterfaceC3588op
            public final Float invoke() {
                return Float.valueOf(0.0f);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(C01011.INSTANCE, AnonymousClass2.INSTANCE, false, 4, null));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$4, reason: invalid class name and case insensitive filesystem */
    public static final class C14894 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ LazyListState $lazyListState;
        final /* synthetic */ InterfaceC3750qp $onDateSelected;
        final /* synthetic */ StateData $stateData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14894(InterfaceC3750qp interfaceC3750qp, StateData stateData, LazyListState lazyListState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp2, DatePickerColors datePickerColors, int i) {
            super(2);
            this.$onDateSelected = interfaceC3750qp;
            this.$stateData = stateData;
            this.$lazyListState = lazyListState;
            this.$dateFormatter = datePickerFormatter;
            this.$dateValidator = interfaceC3750qp2;
            this.$colors = datePickerColors;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            DatePickerKt.HorizontalMonthsList(this.$onDateSelected, this.$stateData, this.$lazyListState, this.$dateFormatter, this.$dateValidator, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$Month$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14901 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ Locale $defaultLocale;
        final /* synthetic */ MutableState<CalendarDate> $endSelection;
        final /* synthetic */ CalendarMonth $month;
        final /* synthetic */ InterfaceC3750qp $onDateSelected;
        final /* synthetic */ Modifier $rangeSelectionDrawModifier;
        final /* synthetic */ boolean $rangeSelectionEnabled;
        final /* synthetic */ MutableState<CalendarDate> $startSelection;
        final /* synthetic */ StateData $stateData;
        final /* synthetic */ CalendarDate $today;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14901(Modifier modifier, CalendarMonth calendarMonth, CalendarDate calendarDate, MutableState<CalendarDate> mutableState, MutableState<CalendarDate> mutableState2, boolean z, int i, DatePickerFormatter datePickerFormatter, Locale locale, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, StateData stateData, InterfaceC3750qp interfaceC3750qp2) {
            super(2);
            this.$rangeSelectionDrawModifier = modifier;
            this.$month = calendarMonth;
            this.$today = calendarDate;
            this.$startSelection = mutableState;
            this.$endSelection = mutableState2;
            this.$rangeSelectionEnabled = z;
            this.$$dirty = i;
            this.$dateFormatter = datePickerFormatter;
            this.$defaultLocale = locale;
            this.$onDateSelected = interfaceC3750qp;
            this.$colors = datePickerColors;
            this.$stateData = stateData;
            this.$dateValidator = interfaceC3750qp2;
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
            int i2;
            boolean z;
            MutableState<CalendarDate> mutableState;
            InterfaceC3750qp interfaceC3750qp;
            Locale locale;
            MutableState<CalendarDate> mutableState2;
            DatePickerFormatter datePickerFormatter;
            Object obj;
            String str;
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1776200645, i, -1, "androidx.compose.material3.Month.<anonymous> (DatePicker.kt:1444)");
            }
            Modifier modifierThen = SizeKt.m521requiredHeight3ABfNKs(Modifier.Companion, Dp.m5160constructorimpl(DatePickerKt.getRecommendedSizeForAccessibility() * 6)).then(this.$rangeSelectionDrawModifier);
            Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
            CalendarMonth calendarMonth = this.$month;
            CalendarDate calendarDate = this.$today;
            MutableState<CalendarDate> mutableState3 = this.$startSelection;
            MutableState<CalendarDate> mutableState4 = this.$endSelection;
            boolean z2 = this.$rangeSelectionEnabled;
            int i3 = this.$$dirty;
            DatePickerFormatter datePickerFormatter2 = this.$dateFormatter;
            Locale locale2 = this.$defaultLocale;
            InterfaceC3750qp interfaceC3750qp2 = this.$onDateSelected;
            DatePickerColors datePickerColors = this.$colors;
            StateData stateData = this.$stateData;
            InterfaceC3750qp interfaceC3750qp3 = this.$dateValidator;
            composer.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceEvenly, Alignment.Companion.getStart(), composer, 6);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            InterfaceC3750qp interfaceC3750qp4 = interfaceC3750qp2;
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Locale locale3 = locale2;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierThen);
            DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer.startReplaceableGroup(-713647587);
            int i4 = 6;
            int i5 = 0;
            int i6 = 0;
            while (i6 < i4) {
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceEvenly2 = Arrangement.INSTANCE.getSpaceEvenly();
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                composer.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly2, centerVertically, composer, 54);
                composer.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                int i7 = i5;
                InterfaceC3588op constructor2 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierFillMaxWidth$default);
                int i8 = i6;
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer);
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
                composer.enableReusing();
                interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                composer.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                composer.startReplaceableGroup(-1111255211);
                int i9 = i7;
                int i10 = 0;
                while (i10 < 7) {
                    if (i9 < calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() || i9 >= calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth.getNumberOfDays()) {
                        i2 = i3;
                        z = z2;
                        mutableState = mutableState3;
                        interfaceC3750qp = interfaceC3750qp4;
                        locale = locale3;
                        mutableState2 = mutableState4;
                        datePickerFormatter = datePickerFormatter3;
                        composer.startReplaceableGroup(382636990);
                        SpacerKt.Spacer(SizeKt.m526requiredSizeVpY3zN4(Modifier.Companion, DatePickerKt.getRecommendedSizeForAccessibility(), DatePickerKt.getRecommendedSizeForAccessibility()), composer, 6);
                        composer.endReplaceableGroup();
                    } else {
                        composer.startReplaceableGroup(382637385);
                        int daysFromStartOfWeekToFirstOfMonth = i9 - calendarMonth.getDaysFromStartOfWeekToFirstOfMonth();
                        long startUtcTimeMillis = calendarMonth.getStartUtcTimeMillis() + (((long) daysFromStartOfWeekToFirstOfMonth) * CalendarModelKt.MillisecondsIn24Hours);
                        boolean z3 = startUtcTimeMillis == calendarDate.getUtcTimeMillis();
                        CalendarDate value = mutableState3.getValue();
                        boolean z4 = value != null && startUtcTimeMillis == value.getUtcTimeMillis();
                        CalendarDate value2 = mutableState4.getValue();
                        boolean z5 = value2 != null && startUtcTimeMillis == value2.getUtcTimeMillis();
                        Object objValueOf = Boolean.valueOf(z2);
                        Object objValueOf2 = Long.valueOf(startUtcTimeMillis);
                        int i11 = (i3 >> 12) & 14;
                        MutableState<CalendarDate> mutableState5 = mutableState4;
                        composer.startReplaceableGroup(511388516);
                        boolean zChanged = composer.changed(objValueOf) | composer.changed(objValueOf2);
                        Object objRememberedValue = composer.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = SnapshotStateKt.derivedStateOf(new DatePickerKt$Month$1$1$1$1$1$inRange$1$1(stateData, z2, startUtcTimeMillis));
                            composer.updateRememberedValue(objRememberedValue);
                        }
                        composer.endReplaceableGroup();
                        State state = (State) objRememberedValue;
                        MutableState<CalendarDate> mutableState6 = mutableState3;
                        interfaceC3750qp = interfaceC3750qp4;
                        boolean z6 = z2;
                        Locale locale4 = locale3;
                        datePickerFormatter = datePickerFormatter3;
                        i2 = i3;
                        String strDayContentDescription = DatePickerKt.dayContentDescription(z2, z3, z4, z5, ((Boolean) state.getValue()).booleanValue(), composer, i11);
                        String withSkeleton = CalendarModel_androidKt.formatWithSkeleton(startUtcTimeMillis, datePickerFormatter.getSelectedDateDescriptionSkeleton$material3_release(), locale4);
                        Modifier.Companion companion3 = Modifier.Companion;
                        boolean z7 = z4 || z5;
                        Object objValueOf3 = Long.valueOf(startUtcTimeMillis);
                        composer.startReplaceableGroup(511388516);
                        boolean zChanged2 = composer.changed(objValueOf3) | composer.changed(interfaceC3750qp);
                        Object objRememberedValue2 = composer.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = new DatePickerKt$Month$1$1$1$1$1$1$1(interfaceC3750qp, startUtcTimeMillis);
                            composer.updateRememberedValue(objRememberedValue2);
                        }
                        composer.endReplaceableGroup();
                        InterfaceC3588op interfaceC3588op = (InterfaceC3588op) objRememberedValue2;
                        Object objValueOf4 = Long.valueOf(startUtcTimeMillis);
                        composer.startReplaceableGroup(1157296644);
                        boolean zChanged3 = composer.changed(objValueOf4);
                        Object objRememberedValue3 = composer.rememberedValue();
                        if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                            obj = objRememberedValue3;
                            Boolean bool = (Boolean) interfaceC3750qp3.invoke(Long.valueOf(startUtcTimeMillis));
                            bool.booleanValue();
                            composer.updateRememberedValue(bool);
                            obj = bool;
                        }
                        obj = objRememberedValue3;
                        composer.endReplaceableGroup();
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        boolean zBooleanValue2 = ((Boolean) state.getValue()).booleanValue();
                        if (strDayContentDescription != null) {
                            str = strDayContentDescription + ", " + withSkeleton;
                        } else {
                            str = withSkeleton;
                        }
                        boolean z8 = z3;
                        z = z6;
                        mutableState2 = mutableState5;
                        mutableState = mutableState6;
                        locale = locale4;
                        DatePickerKt.Day(companion3, z7, interfaceC3588op, z4, zBooleanValue, z8, zBooleanValue2, str, datePickerColors, ComposableLambdaKt.composableLambda(composer, 1633583293, true, new DatePickerKt$Month$1$1$1$1$1$3(daysFromStartOfWeekToFirstOfMonth)), composer, ((i2 << 3) & 234881024) | 805306374);
                        composer.endReplaceableGroup();
                    }
                    i9++;
                    i10++;
                    z2 = z;
                    mutableState4 = mutableState2;
                    mutableState3 = mutableState;
                    datePickerFormatter3 = datePickerFormatter;
                    calendarMonth = calendarMonth;
                    calendarDate = calendarDate;
                    locale3 = locale;
                    i8 = i8;
                    i3 = i2;
                    interfaceC3750qp4 = interfaceC3750qp;
                    stateData = stateData;
                }
                int i12 = i8;
                DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                int i13 = i9;
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                i6 = i12 + 1;
                i5 = i13;
                datePickerFormatter3 = datePickerFormatter4;
                i4 = 6;
                interfaceC3750qp4 = interfaceC3750qp4;
                stateData = stateData;
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$Month$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14912 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ CalendarMonth $month;
        final /* synthetic */ InterfaceC3750qp $onDateSelected;
        final /* synthetic */ boolean $rangeSelectionEnabled;
        final /* synthetic */ StateData $stateData;
        final /* synthetic */ CalendarDate $today;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14912(CalendarMonth calendarMonth, InterfaceC3750qp interfaceC3750qp, CalendarDate calendarDate, StateData stateData, boolean z, InterfaceC3750qp interfaceC3750qp2, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, int i) {
            super(2);
            this.$month = calendarMonth;
            this.$onDateSelected = interfaceC3750qp;
            this.$today = calendarDate;
            this.$stateData = stateData;
            this.$rangeSelectionEnabled = z;
            this.$dateValidator = interfaceC3750qp2;
            this.$dateFormatter = datePickerFormatter;
            this.$colors = datePickerColors;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            DatePickerKt.Month(this.$month, this.$onDateSelected, this.$today, this.$stateData, this.$rangeSelectionEnabled, this.$dateValidator, this.$dateFormatter, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$MonthsNavigation$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14922 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $nextAvailable;
        final /* synthetic */ InterfaceC3588op $onNextClicked;
        final /* synthetic */ InterfaceC3588op $onPreviousClicked;
        final /* synthetic */ InterfaceC3588op $onYearPickerButtonClicked;
        final /* synthetic */ boolean $previousAvailable;
        final /* synthetic */ String $yearPickerText;
        final /* synthetic */ boolean $yearPickerVisible;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14922(Modifier modifier, boolean z, boolean z2, boolean z3, String str, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, int i) {
            super(2);
            this.$modifier = modifier;
            this.$nextAvailable = z;
            this.$previousAvailable = z2;
            this.$yearPickerVisible = z3;
            this.$yearPickerText = str;
            this.$onNextClicked = interfaceC3588op;
            this.$onPreviousClicked = interfaceC3588op2;
            this.$onYearPickerButtonClicked = interfaceC3588op3;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            DatePickerKt.MonthsNavigation(this.$modifier, this.$nextAvailable, this.$previousAvailable, this.$yearPickerVisible, this.$yearPickerText, this.$onNextClicked, this.$onPreviousClicked, this.$onYearPickerButtonClicked, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14931 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final C14931 INSTANCE = new C14931();

        public C14931() {
            super(1);
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SemanticsPropertyReceiver) obj);
            return FW.a;
        }

        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
            SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14942 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ DatePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14942(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, int i) {
            super(3);
            this.$state = datePickerState;
            this.$dateFormatter = datePickerFormatter;
            this.$dateValidator = interfaceC3750qp;
            this.$colors = datePickerColors;
            this.$$dirty = i;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            m1510invokeQujVXRc(((DisplayMode) obj).m1535unboximpl(), (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        /* JADX INFO: renamed from: invoke-QujVXRc, reason: not valid java name */
        public final void m1510invokeQujVXRc(int i, Composer composer, int i2) {
            int i3;
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(i) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i3 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1854706084, i2, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DatePicker.kt:1104)");
            }
            DisplayMode.Companion companion = DisplayMode.Companion;
            if (DisplayMode.m1532equalsimpl0(i, companion.m1537getPickerjFl4v0())) {
                composer.startReplaceableGroup(-1168728183);
                DatePickerKt.DatePickerContent(this.$state.getStateData$material3_release(), this.$dateFormatter, this.$dateValidator, this.$colors, composer, this.$$dirty & 8176);
                composer.endReplaceableGroup();
            } else if (DisplayMode.m1532equalsimpl0(i, companion.m1536getInputjFl4v0())) {
                composer.startReplaceableGroup(-1168727945);
                DateInputKt.DateInputContent(this.$state.getStateData$material3_release(), this.$dateFormatter, this.$dateValidator, composer, this.$$dirty & PointerIconCompat.TYPE_TEXT);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1168727765);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3, reason: invalid class name and case insensitive filesystem */
    public static final class C14953 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ DatePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14953(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, int i) {
            super(2);
            this.$state = datePickerState;
            this.$dateFormatter = datePickerFormatter;
            this.$dateValidator = interfaceC3750qp;
            this.$colors = datePickerColors;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            DatePickerKt.SwitchableDateEntryContent(this.$state, this.$dateFormatter, this.$dateValidator, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$WeekDays$1, reason: invalid class name and case insensitive filesystem */
    public static final class C14961 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ ArrayList<C2020dG> $dayNames;

        /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$WeekDays$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01021 extends AbstractC2233fv implements InterfaceC0526Fp {
            final /* synthetic */ ArrayList<C2020dG> $dayNames;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01021(ArrayList<C2020dG> arrayList) {
                super(2);
                this.$dayNames = arrayList;
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return FW.a;
            }

            /* JADX WARN: Type inference failed for: r9v0 */
            /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r9v3 */
            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(Composer composer, int i) {
                Composer composer2 = composer;
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2133710592, i, -1, "androidx.compose.material3.WeekDays.<anonymous>.<anonymous> (DatePicker.kt:1368)");
                }
                Alignment alignment = null;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m517defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, DatePickerKt.getRecommendedSizeForAccessibility(), 1, null), 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                ArrayList<C2020dG> arrayList = this.$dayNames;
                composer2.startReplaceableGroup(693286680);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceEvenly, centerVertically, composer2, 54);
                int i2 = -1323940314;
                composer2.startReplaceableGroup(-1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                InterfaceC3588op constructor = companion.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierFillMaxWidth$default);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer composerM2661constructorimpl = Updater.m2661constructorimpl(composer);
                Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
                composer.enableReusing();
                ?? r9 = 0;
                interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer2, 0);
                int i3 = 2058660585;
                composer2.startReplaceableGroup(2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(784203502);
                for (C2020dG c2020dG : arrayList) {
                    Modifier.Companion companion2 = Modifier.Companion;
                    composer2.startReplaceableGroup(1157296644);
                    boolean zChanged = composer2.changed(c2020dG);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new DatePickerKt$WeekDays$1$1$1$1$1$1(c2020dG);
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    Modifier modifierM534sizeVpY3zN4 = SizeKt.m534sizeVpY3zN4(SemanticsModifierKt.clearAndSetSemantics(companion2, (InterfaceC3750qp) objRememberedValue), DatePickerKt.getRecommendedSizeForAccessibility(), DatePickerKt.getRecommendedSizeForAccessibility());
                    Alignment center = Alignment.Companion.getCenter();
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, r9, composer2, 6);
                    composer2.startReplaceableGroup(i2);
                    Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                    InterfaceC3588op constructor2 = companion3.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(modifierM534sizeVpY3zN4);
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer.useNode();
                    }
                    composer.disableReusing();
                    Composer composerM2661constructorimpl2 = Updater.m2661constructorimpl(composer);
                    Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion3.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion3.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion3.getSetViewConfiguration());
                    composer.enableReusing();
                    interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer2, Integer.valueOf((int) r9));
                    composer2.startReplaceableGroup(i3);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    TextKt.m1930Text4IGK_g((String) c2020dG.e(), SizeKt.wrapContentSize$default(companion2, alignment, r9, 3, alignment), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m5059boximpl(TextAlign.Companion.m5066getCentere0LSkKk()), 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composer, 48, 0, 130556);
                    composer.endReplaceableGroup();
                    composer.endNode();
                    composer.endReplaceableGroup();
                    composer.endReplaceableGroup();
                    composer2 = composer;
                    alignment = alignment;
                    r9 = 0;
                    i3 = 2058660585;
                    i2 = -1323940314;
                }
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14961(ArrayList<C2020dG> arrayList) {
            super(2);
            this.$dayNames = arrayList;
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
                ComposerKt.traceEventStart(-1445541615, i, -1, "androidx.compose.material3.WeekDays.<anonymous> (DatePicker.kt:1365)");
            }
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont()), ComposableLambdaKt.composableLambda(composer, 2133710592, true, new C01021(this.$dayNames)), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$WeekDays$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14972 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14972(DatePickerColors datePickerColors, CalendarModel calendarModel, int i) {
            super(2);
            this.$colors = datePickerColors;
            this.$calendarModel = calendarModel;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            DatePickerKt.WeekDays(this.$colors, this.$calendarModel, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$Year$2, reason: invalid class name and case insensitive filesystem */
    public static final class C14982 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14982(InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$content = interfaceC0526Fp;
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
                ComposerKt.traceEventStart(-68753950, i, -1, "androidx.compose.material3.Year.<anonymous> (DatePicker.kt:1753)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
            Alignment center = Alignment.Companion.getCenter();
            InterfaceC0526Fp interfaceC0526Fp = this.$content;
            int i2 = this.$$dirty;
            composer.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierFillMaxWidth$default);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            interfaceC0526Fp.mo13invoke(composer, Integer.valueOf((i2 >> 18) & 14));
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$Year$3, reason: invalid class name and case insensitive filesystem */
    public static final class C14993 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ boolean $currentYear;
        final /* synthetic */ String $description;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;
        final /* synthetic */ boolean $selected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14993(Modifier modifier, boolean z, boolean z2, InterfaceC3588op interfaceC3588op, String str, DatePickerColors datePickerColors, InterfaceC0526Fp interfaceC0526Fp, int i) {
            super(2);
            this.$modifier = modifier;
            this.$selected = z;
            this.$currentYear = z2;
            this.$onClick = interfaceC3588op;
            this.$description = str;
            this.$colors = datePickerColors;
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
            DatePickerKt.Year(this.$modifier, this.$selected, this.$currentYear, this.$onClick, this.$description, this.$colors, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15001 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onYearSelected;
        final /* synthetic */ StateData $stateData;

        /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01031 extends AbstractC2233fv implements InterfaceC3750qp {
            public static final C01031 INSTANCE = new C01031();

            /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01041 extends AbstractC2233fv implements InterfaceC3588op {
                public static final C01041 INSTANCE = new C01041();

                public C01041() {
                    super(0);
                }

                @Override // defpackage.InterfaceC3588op
                public final Float invoke() {
                    return Float.valueOf(0.0f);
                }
            }

            /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3588op {
                public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

                public AnonymousClass2() {
                    super(0);
                }

                @Override // defpackage.InterfaceC3588op
                public final Float invoke() {
                    return Float.valueOf(0.0f);
                }
            }

            public C01031() {
                super(1);
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return FW.a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
                SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(C01041.INSTANCE, AnonymousClass2.INSTANCE, false, 4, null));
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ DatePickerColors $colors;
            final /* synthetic */ InterfaceC2052dg $coroutineScope;
            final /* synthetic */ int $currentYear;
            final /* synthetic */ int $displayedYear;
            final /* synthetic */ LazyGridState $lazyGridState;
            final /* synthetic */ InterfaceC3750qp $onYearSelected;
            final /* synthetic */ String $scrollToEarlierYearsLabel;
            final /* synthetic */ String $scrollToLaterYearsLabel;
            final /* synthetic */ StateData $stateData;

            /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01051 extends AbstractC2233fv implements InterfaceC0578Hp {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ DatePickerColors $colors;
                final /* synthetic */ InterfaceC2052dg $coroutineScope;
                final /* synthetic */ int $currentYear;
                final /* synthetic */ int $displayedYear;
                final /* synthetic */ LazyGridState $lazyGridState;
                final /* synthetic */ InterfaceC3750qp $onYearSelected;
                final /* synthetic */ String $scrollToEarlierYearsLabel;
                final /* synthetic */ String $scrollToLaterYearsLabel;
                final /* synthetic */ StateData $stateData;

                /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$1, reason: invalid class name and collision with other inner class name */
                public static final class C01061 extends AbstractC2233fv implements InterfaceC3750qp {
                    final /* synthetic */ InterfaceC2052dg $coroutineScope;
                    final /* synthetic */ int $it;
                    final /* synthetic */ LazyGridState $lazyGridState;
                    final /* synthetic */ String $scrollToEarlierYearsLabel;
                    final /* synthetic */ String $scrollToLaterYearsLabel;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C01061(LazyGridState lazyGridState, int i, InterfaceC2052dg interfaceC2052dg, String str, String str2) {
                        super(1);
                        this.$lazyGridState = lazyGridState;
                        this.$it = i;
                        this.$coroutineScope = interfaceC2052dg;
                        this.$scrollToEarlierYearsLabel = str;
                        this.$scrollToLaterYearsLabel = str2;
                    }

                    @Override // defpackage.InterfaceC3750qp
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return FW.a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        LazyGridItemInfo lazyGridItemInfo;
                        AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
                        SemanticsPropertiesKt.setCustomActions(semanticsPropertyReceiver, (this.$lazyGridState.getFirstVisibleItemIndex() == this.$it || ((lazyGridItemInfo = (LazyGridItemInfo) AbstractC3240kc.l0(this.$lazyGridState.getLayoutInfo().getVisibleItemsInfo())) != null && lazyGridItemInfo.getIndex() == this.$it)) ? DatePickerKt.customScrollActions(this.$lazyGridState, this.$coroutineScope, this.$scrollToEarlierYearsLabel, this.$scrollToLaterYearsLabel) : AbstractC1886cc.m());
                    }
                }

                /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$3, reason: invalid class name */
                public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
                    final /* synthetic */ String $localizedYear;

                    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1$2$1$3$1, reason: invalid class name and collision with other inner class name */
                    public static final class C01071 extends AbstractC2233fv implements InterfaceC3750qp {
                        public static final C01071 INSTANCE = new C01071();

                        public C01071() {
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

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass3(String str) {
                        super(2);
                        this.$localizedYear = str;
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
                            ComposerKt.traceEventStart(2095319565, i, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1701)");
                        }
                        TextKt.m1930Text4IGK_g(this.$localizedYear, SemanticsModifierKt.clearAndSetSemantics(Modifier.Companion, C01071.INSTANCE), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m5059boximpl(TextAlign.Companion.m5066getCentere0LSkKk()), 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composer, 0, 0, 130556);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01051(StateData stateData, int i, int i2, InterfaceC3750qp interfaceC3750qp, int i3, DatePickerColors datePickerColors, LazyGridState lazyGridState, InterfaceC2052dg interfaceC2052dg, String str, String str2) {
                    super(4);
                    this.$stateData = stateData;
                    this.$displayedYear = i;
                    this.$currentYear = i2;
                    this.$onYearSelected = interfaceC3750qp;
                    this.$$dirty = i3;
                    this.$colors = datePickerColors;
                    this.$lazyGridState = lazyGridState;
                    this.$coroutineScope = interfaceC2052dg;
                    this.$scrollToEarlierYearsLabel = str;
                    this.$scrollToLaterYearsLabel = str2;
                }

                @Override // defpackage.InterfaceC0578Hp
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return FW.a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
                    int i3;
                    AbstractC4492zt.h(lazyGridItemScope, "$this$items");
                    if ((i2 & 112) == 0) {
                        i3 = (composer.changed(i) ? 32 : 16) | i2;
                    } else {
                        i3 = i2;
                    }
                    if ((i3 & 721) == 144 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1369226173, i2, -1, "androidx.compose.material3.YearPicker.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1669)");
                    }
                    int iB = i + this.$stateData.getYearRange().b();
                    String localString = DatePickerKt.toLocalString(iB);
                    Modifier.Companion companion = Modifier.Companion;
                    DatePickerModalTokens datePickerModalTokens = DatePickerModalTokens.INSTANCE;
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(SizeKt.m526requiredSizeVpY3zN4(companion, datePickerModalTokens.m2184getSelectionYearContainerWidthD9Ej5fM(), datePickerModalTokens.m2183getSelectionYearContainerHeightD9Ej5fM()), false, new C01061(this.$lazyGridState, i, this.$coroutineScope, this.$scrollToEarlierYearsLabel, this.$scrollToLaterYearsLabel), 1, null);
                    boolean z = iB == this.$displayedYear;
                    boolean z2 = iB == this.$currentYear;
                    InterfaceC3750qp interfaceC3750qp = this.$onYearSelected;
                    Integer numValueOf = Integer.valueOf(iB);
                    InterfaceC3750qp interfaceC3750qp2 = this.$onYearSelected;
                    composer.startReplaceableGroup(511388516);
                    boolean zChanged = composer.changed(interfaceC3750qp) | composer.changed(numValueOf);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new DatePickerKt$YearPicker$1$2$1$2$1(interfaceC3750qp2, iB);
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    InterfaceC3588op interfaceC3588op = (InterfaceC3588op) objRememberedValue;
                    String str = String.format(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1795getDatePickerNavigateToYearDescriptionadMyvUU(), composer, 6), Arrays.copyOf(new Object[]{localString}, 1));
                    AbstractC4492zt.g(str, "format(this, *args)");
                    DatePickerKt.Year(modifierSemantics$default, z, z2, interfaceC3588op, str, this.$colors, ComposableLambdaKt.composableLambda(composer, 2095319565, true, new AnonymousClass3(localString)), composer, ((this.$$dirty << 9) & 458752) | 1572864);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(StateData stateData, int i, int i2, InterfaceC3750qp interfaceC3750qp, int i3, DatePickerColors datePickerColors, LazyGridState lazyGridState, InterfaceC2052dg interfaceC2052dg, String str, String str2) {
                super(1);
                this.$stateData = stateData;
                this.$displayedYear = i;
                this.$currentYear = i2;
                this.$onYearSelected = interfaceC3750qp;
                this.$$dirty = i3;
                this.$colors = datePickerColors;
                this.$lazyGridState = lazyGridState;
                this.$coroutineScope = interfaceC2052dg;
                this.$scrollToEarlierYearsLabel = str;
                this.$scrollToLaterYearsLabel = str2;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LazyGridScope) obj);
                return FW.a;
            }

            public final void invoke(LazyGridScope lazyGridScope) {
                AbstractC4492zt.h(lazyGridScope, "$this$LazyVerticalGrid");
                LazyGridScope.CC.b(lazyGridScope, AbstractC3240kc.V(this.$stateData.getYearRange()), null, null, null, ComposableLambdaKt.composableLambdaInstance(1369226173, true, new C01051(this.$stateData, this.$displayedYear, this.$currentYear, this.$onYearSelected, this.$$dirty, this.$colors, this.$lazyGridState, this.$coroutineScope, this.$scrollToEarlierYearsLabel, this.$scrollToLaterYearsLabel)), 14, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15001(StateData stateData, DatePickerColors datePickerColors, Modifier modifier, InterfaceC3750qp interfaceC3750qp, int i) {
            super(2);
            this.$stateData = stateData;
            this.$colors = datePickerColors;
            this.$modifier = modifier;
            this.$onYearSelected = interfaceC3750qp;
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
                ComposerKt.traceEventStart(-145469688, i, -1, "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:1636)");
            }
            int year = this.$stateData.getCurrentMonth().getYear();
            int year2 = this.$stateData.getDisplayedMonth().getYear();
            LazyGridState lazyGridStateRememberLazyGridState = LazyGridStateKt.rememberLazyGridState(Math.max(0, (year2 - this.$stateData.getYearRange().b()) - 3), 0, composer, 0, 2);
            composer.startReplaceableGroup(-969349200);
            long jM1489getContainerColor0d7_KjU$material3_release = this.$colors.m1489getContainerColor0d7_KjU$material3_release();
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            long jM1454surfaceColorAtElevation3ABfNKs = Color.m3033equalsimpl0(jM1489getContainerColor0d7_KjU$material3_release, materialTheme.getColorScheme(composer, 6).m1413getSurface0d7_KjU()) ? ColorSchemeKt.m1454surfaceColorAtElevation3ABfNKs(materialTheme.getColorScheme(composer, 6), ((Dp) composer.consume(SurfaceKt.getLocalAbsoluteTonalElevation())).m5174unboximpl()) : this.$colors.m1489getContainerColor0d7_KjU$material3_release();
            composer.endReplaceableGroup();
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(C1172Zk.a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            InterfaceC2052dg coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            Strings.Companion companion = Strings.Companion;
            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(companion.m1797getDatePickerScrollToShowEarlierYearsadMyvUU(), composer, 6);
            String strM1841getStringNWtq29 = Strings_androidKt.m1841getStringNWtq28(companion.m1798getDatePickerScrollToShowLaterYearsadMyvUU(), composer, 6);
            GridCells.Fixed fixed = new GridCells.Fixed(3);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(BackgroundKt.m167backgroundbw27NRU$default(this.$modifier, jM1454surfaceColorAtElevation3ABfNKs, null, 2, null), false, C01031.INSTANCE, 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            LazyGridDslKt.LazyVerticalGrid(fixed, modifierSemantics$default, lazyGridStateRememberLazyGridState, null, false, arrangement.m399spacedBy0680j_4(DatePickerKt.YearsVerticalPadding), arrangement.getSpaceEvenly(), null, false, new AnonymousClass2(this.$stateData, year2, year, this.$onYearSelected, this.$$dirty, this.$colors, lazyGridStateRememberLazyGridState, coroutineScope, strM1841getStringNWtq28, strM1841getStringNWtq29), composer, 1769472, 408);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15012 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3750qp $onYearSelected;
        final /* synthetic */ StateData $stateData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15012(Modifier modifier, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, StateData stateData, int i) {
            super(2);
            this.$modifier = modifier;
            this.$onYearSelected = interfaceC3750qp;
            this.$colors = datePickerColors;
            this.$stateData = stateData;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            DatePickerKt.YearPicker(this.$modifier, this.$onYearSelected, this.$colors, this.$stateData, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPickerMenuButton$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15021 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ boolean $expanded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15021(InterfaceC0526Fp interfaceC0526Fp, int i, boolean z) {
            super(3);
            this.$content = interfaceC0526Fp;
            this.$$dirty = i;
            this.$expanded = z;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(RowScope rowScope, Composer composer, int i) {
            String strM1841getStringNWtq28;
            AbstractC4492zt.h(rowScope, "$this$TextButton");
            if ((i & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1899012021, i, -1, "androidx.compose.material3.YearPickerMenuButton.<anonymous> (DatePicker.kt:1844)");
            }
            this.$content.mo13invoke(composer, Integer.valueOf((this.$$dirty >> 9) & 14));
            Modifier.Companion companion = Modifier.Companion;
            SpacerKt.Spacer(SizeKt.m532size3ABfNKs(companion, ButtonDefaults.INSTANCE.m1363getIconSpacingD9Ej5fM()), composer, 6);
            ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
            if (this.$expanded) {
                composer.startReplaceableGroup(1071182504);
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1800getDatePickerSwitchToDaySelectionadMyvUU(), composer, 6);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1071182591);
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1804getDatePickerSwitchToYearSelectionadMyvUU(), composer, 6);
                composer.endReplaceableGroup();
            }
            IconKt.m1602Iconww6aTOc(arrowDropDown, strM1841getStringNWtq28, RotateKt.rotate(companion, this.$expanded ? 180.0f : 0.0f), 0L, composer, 0, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPickerMenuButton$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15032 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ InterfaceC0526Fp $content;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC3588op $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15032(InterfaceC3588op interfaceC3588op, boolean z, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
            super(2);
            this.$onClick = interfaceC3588op;
            this.$expanded = z;
            this.$modifier = modifier;
            this.$content = interfaceC0526Fp;
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
            DatePickerKt.YearPickerMenuButton(this.$onClick, this.$expanded, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$updateDisplayedMonth$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15042 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ LazyListState $lazyListState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15042(LazyListState lazyListState) {
            super(0);
            this.$lazyListState = lazyListState;
        }

        @Override // defpackage.InterfaceC3588op
        public final Integer invoke() {
            return Integer.valueOf(this.$lazyListState.getFirstVisibleItemIndex());
        }
    }

    static {
        float f = 12;
        DatePickerHorizontalPadding = Dp.m5160constructorimpl(f);
        DatePickerModeTogglePadding = PaddingKt.m482PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(f), 3, null);
        float f2 = 24;
        float f3 = 16;
        DatePickerTitlePadding = PaddingKt.m482PaddingValuesa9UjIt4$default(Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f3), Dp.m5160constructorimpl(f), 0.0f, 8, null);
        DatePickerHeadlinePadding = PaddingKt.m482PaddingValuesa9UjIt4$default(Dp.m5160constructorimpl(f2), 0.0f, Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(f), 2, null);
        YearsVerticalPadding = Dp.m5160constructorimpl(f3);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DateEntryContainer-au3_HiA, reason: not valid java name */
    public static final void m1499DateEntryContainerau3_HiA(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, DatePickerColors datePickerColors, TextStyle textStyle, float f, InterfaceC0526Fp interfaceC0526Fp4, Composer composer, int i) {
        int i2;
        Composer composer2;
        AbstractC4492zt.h(modifier, "modifier");
        AbstractC4492zt.h(datePickerColors, "colors");
        AbstractC4492zt.h(textStyle, "headlineTextStyle");
        AbstractC4492zt.h(interfaceC0526Fp4, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(1507356255);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(textStyle) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp4) ? 8388608 : 4194304;
        }
        int i3 = i2;
        if ((23967451 & i3) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507356255, i3, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1011)");
            }
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(SizeKt.m536sizeInqDBjuR0$default(modifier, DatePickerModalTokens.INSTANCE.m2172getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null), false, DatePickerKt$DateEntryContainer$1.INSTANCE, 1, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierSemantics$default);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2 = composerStartRestartGroup;
            m1500DatePickerHeaderpc5RIQQ(Modifier.Companion, interfaceC0526Fp, datePickerColors.m1493getTitleContentColor0d7_KjU$material3_release(), datePickerColors.m1491getHeadlineContentColor0d7_KjU$material3_release(), f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -229007058, true, new DatePickerKt$DateEntryContainer$2$1(interfaceC0526Fp2, interfaceC0526Fp3, interfaceC0526Fp, textStyle, i3)), composer2, 196614 | (i3 & 112) | ((i3 >> 6) & 57344));
            interfaceC0526Fp4.mo13invoke(composer2, Integer.valueOf((i3 >> 21) & 14));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerKt$DateEntryContainer$3(modifier, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, datePickerColors, textStyle, f, interfaceC0526Fp4, i));
    }

    /* JADX WARN: Code duplicated, block: B:105:0x013c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x013e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0141  */
    /* JADX WARN: Code duplicated, block: B:109:0x0145  */
    /* JADX WARN: Code duplicated, block: B:111:0x0157  */
    /* JADX WARN: Code duplicated, block: B:114:0x0173  */
    /* JADX WARN: Code duplicated, block: B:115:0x0176  */
    /* JADX WARN: Code duplicated, block: B:117:0x0179  */
    /* JADX WARN: Code duplicated, block: B:118:0x0186  */
    /* JADX WARN: Code duplicated, block: B:120:0x0189  */
    /* JADX WARN: Code duplicated, block: B:121:0x0196  */
    /* JADX WARN: Code duplicated, block: B:123:0x019a  */
    /* JADX WARN: Code duplicated, block: B:124:0x019d  */
    /* JADX WARN: Code duplicated, block: B:127:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:128:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:131:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:133:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:135:0x0202  */
    /* JADX WARN: Code duplicated, block: B:138:0x0254  */
    /* JADX WARN: Code duplicated, block: B:143:0x0262  */
    /* JADX WARN: Code duplicated, block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x004f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0053  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x006a  */
    /* JADX WARN: Code duplicated, block: B:41:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00de  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ed A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:91:0x0100  */
    /* JADX WARN: Code duplicated, block: B:95:0x0115  */
    /* JADX WARN: Code duplicated, block: B:97:0x0120  */
    @Composable
    @ExperimentalMaterial3Api
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void DatePicker(DatePickerState datePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, boolean z, DatePickerColors datePickerColors, Composer composer, int i, int i2) {
        int i3;
        int i4;
        DatePickerFormatter datePickerFormatter2;
        int i5;
        int i6;
        InterfaceC3750qp interfaceC3750qp2;
        int i7;
        int i8;
        InterfaceC0526Fp interfaceC0526Fp3;
        int i9;
        int i10;
        InterfaceC0526Fp interfaceC0526Fp4;
        int i11;
        int i12;
        int i13;
        Modifier modifier2;
        InterfaceC3750qp interfaceC3750qp3;
        InterfaceC0526Fp interfaceC0526FpComposableLambda;
        InterfaceC0526Fp interfaceC0526FpComposableLambda2;
        boolean z2;
        int i14;
        DatePickerColors datePickerColorsM1496colors1m2CgY;
        Object objRememberedValue;
        boolean z3;
        ComposableLambda composableLambda;
        InterfaceC0526Fp interfaceC0526Fp5;
        InterfaceC0526Fp interfaceC0526Fp6;
        DatePickerColors datePickerColors2;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(datePickerState, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1765097918);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(datePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 == 0) {
            if ((i & 112) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 896) == 0) {
                    datePickerFormatter2 = datePickerFormatter;
                    if (composerStartRestartGroup.changed(datePickerFormatter2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 7168) == 0) {
                        interfaceC3750qp2 = interfaceC3750qp;
                        if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 57344) == 0) {
                            interfaceC0526Fp3 = interfaceC0526Fp;
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 32;
                        if (i10 != 0) {
                            if ((458752 & i) == 0) {
                                interfaceC0526Fp4 = interfaceC0526Fp2;
                                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                                    i11 = 131072;
                                } else {
                                    i11 = 65536;
                                }
                                i3 |= i11;
                            }
                            i12 = i2 & 64;
                            if (i12 != 0) {
                                i3 |= 1572864;
                            } else if ((i & 3670016) == 0) {
                                if (composerStartRestartGroup.changed(z)) {
                                    i13 = 1048576;
                                } else {
                                    i13 = 524288;
                                }
                                i3 |= i13;
                            }
                            if ((i & 29360128) != 0) {
                                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                            }
                            if ((i3 & 23967451) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                                composerStartRestartGroup.startDefaults();
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i15 != 0) {
                                        modifier2 = Modifier.Companion;
                                    } else {
                                        modifier2 = modifier;
                                    }
                                    if (i4 != 0) {
                                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                        }
                                        composerStartRestartGroup.endReplaceableGroup();
                                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                    }
                                    if (i6 != 0) {
                                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                    } else {
                                        interfaceC3750qp3 = interfaceC3750qp2;
                                    }
                                    if (i8 != 0) {
                                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                    } else {
                                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                    }
                                    if (i10 != 0) {
                                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                    } else {
                                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                    }
                                    if (i12 != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = z;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i14 = i3 & (-29360129);
                                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                    } else {
                                        i14 = i3;
                                    }
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                                    }
                                    if (z2) {
                                        z3 = true;
                                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                                    } else {
                                        z3 = true;
                                        composableLambda = null;
                                    }
                                    ComposableLambda composableLambda2 = composableLambda;
                                    Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                                    DatePickerModalTokens datePickerModalTokens = DatePickerModalTokens.INSTANCE;
                                    TextStyle textStyleFromToken = TypographyKt.fromToken(typography, datePickerModalTokens.getHeaderHeadlineFont());
                                    float fM2178getHeaderContainerHeightD9Ej5fM = datePickerModalTokens.m2178getHeaderContainerHeightD9Ej5fM();
                                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                                    int i16 = ((i14 >> 3) & 14) | 14155776;
                                    int i17 = i14 >> 9;
                                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda2, datePickerColorsM1496colors1m2CgY, textStyleFromToken, fM2178getHeaderContainerHeightD9Ej5fM, composableLambda3, composerStartRestartGroup, i16 | (i17 & 112) | (i17 & 896) | (i17 & 57344));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                                    modifier3 = modifier2;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 128) != 0) {
                                        i3 &= -29360129;
                                    }
                                    modifier2 = modifier;
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                    z2 = z;
                                    i14 = i3;
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                                }
                                if (z2) {
                                    z3 = true;
                                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                                } else {
                                    z3 = true;
                                    composableLambda = null;
                                }
                                ComposableLambda composableLambda4 = composableLambda;
                                Typography typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                                DatePickerModalTokens datePickerModalTokens2 = DatePickerModalTokens.INSTANCE;
                                TextStyle textStyleFromToken2 = TypographyKt.fromToken(typography2, datePickerModalTokens2.getHeaderHeadlineFont());
                                float fM2178getHeaderContainerHeightD9Ej5fM2 = datePickerModalTokens2.m2178getHeaderContainerHeightD9Ej5fM();
                                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                                int i18 = ((i14 >> 3) & 14) | 14155776;
                                int i19 = i14 >> 9;
                                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda4, datePickerColorsM1496colors1m2CgY, textStyleFromToken2, fM2178getHeaderContainerHeightD9Ej5fM2, composableLambda5, composerStartRestartGroup, i18 | (i19 & 112) | (i19 & 896) | (i19 & 57344));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                                modifier3 = modifier2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                modifier3 = modifier;
                                z2 = z;
                                datePickerColors2 = datePickerColors;
                                interfaceC3750qp3 = interfaceC3750qp2;
                                interfaceC0526Fp5 = interfaceC0526Fp3;
                                interfaceC0526Fp6 = interfaceC0526Fp4;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                return;
                            }
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                        }
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                        i12 = i2 & 64;
                        if (i12 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(z)) {
                                i13 = 1048576;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        }
                        if ((i & 29360128) != 0) {
                            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                        }
                        if ((i3 & 23967451) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda6 = composableLambda;
                            Typography typography3 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens3 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken3 = TypographyKt.fromToken(typography3, datePickerModalTokens3.getHeaderHeadlineFont());
                            float fM2178getHeaderContainerHeightD9Ej5fM3 = datePickerModalTokens3.m2178getHeaderContainerHeightD9Ej5fM();
                            ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i110 = ((i14 >> 3) & 14) | 14155776;
                            int i111 = i14 >> 9;
                            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda6, datePickerColorsM1496colors1m2CgY, textStyleFromToken3, fM2178getHeaderContainerHeightD9Ej5fM3, composableLambda7, composerStartRestartGroup, i110 | (i111 & 112) | (i111 & 896) | (i111 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda8 = composableLambda;
                            Typography typography4 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens4 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken4 = TypographyKt.fromToken(typography4, datePickerModalTokens4.getHeaderHeadlineFont());
                            float fM2178getHeaderContainerHeightD9Ej5fM4 = datePickerModalTokens4.m2178getHeaderContainerHeightD9Ej5fM();
                            ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i112 = ((i14 >> 3) & 14) | 14155776;
                            int i113 = i14 >> 9;
                            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda8, datePickerColorsM1496colors1m2CgY, textStyleFromToken4, fM2178getHeaderContainerHeightD9Ej5fM4, composableLambda9, composerStartRestartGroup, i112 | (i113 & 112) | (i113 & 896) | (i113 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                    }
                    i3 |= 24576;
                    interfaceC0526Fp3 = interfaceC0526Fp;
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((458752 & i) == 0) {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 64;
                        if (i12 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(z)) {
                                i13 = 1048576;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        }
                        if ((i & 29360128) != 0) {
                            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                        }
                        if ((i3 & 23967451) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda10 = composableLambda;
                            Typography typography5 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens5 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken5 = TypographyKt.fromToken(typography5, datePickerModalTokens5.getHeaderHeadlineFont());
                            float fM2178getHeaderContainerHeightD9Ej5fM5 = datePickerModalTokens5.m2178getHeaderContainerHeightD9Ej5fM();
                            ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i114 = ((i14 >> 3) & 14) | 14155776;
                            int i115 = i14 >> 9;
                            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda10, datePickerColorsM1496colors1m2CgY, textStyleFromToken5, fM2178getHeaderContainerHeightD9Ej5fM5, composableLambda11, composerStartRestartGroup, i114 | (i115 & 112) | (i115 & 896) | (i115 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda12 = composableLambda;
                            Typography typography6 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens6 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken6 = TypographyKt.fromToken(typography6, datePickerModalTokens6.getHeaderHeadlineFont());
                            float fM2178getHeaderContainerHeightD9Ej5fM6 = datePickerModalTokens6.m2178getHeaderContainerHeightD9Ej5fM();
                            ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i116 = ((i14 >> 3) & 14) | 14155776;
                            int i117 = i14 >> 9;
                            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda12, datePickerColorsM1496colors1m2CgY, textStyleFromToken6, fM2178getHeaderContainerHeightD9Ej5fM6, composableLambda13, composerStartRestartGroup, i116 | (i117 & 112) | (i117 & 896) | (i117 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                    }
                    if ((i3 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda14 = composableLambda;
                        Typography typography7 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens7 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken7 = TypographyKt.fromToken(typography7, datePickerModalTokens7.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM7 = datePickerModalTokens7.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i118 = ((i14 >> 3) & 14) | 14155776;
                        int i119 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda14, datePickerColorsM1496colors1m2CgY, textStyleFromToken7, fM2178getHeaderContainerHeightD9Ej5fM7, composableLambda15, composerStartRestartGroup, i118 | (i119 & 112) | (i119 & 896) | (i119 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda16 = composableLambda;
                        Typography typography8 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens8 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken8 = TypographyKt.fromToken(typography8, datePickerModalTokens8.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM8 = datePickerModalTokens8.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda17 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1110 = ((i14 >> 3) & 14) | 14155776;
                        int i1111 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda16, datePickerColorsM1496colors1m2CgY, textStyleFromToken8, fM2178getHeaderContainerHeightD9Ej5fM8, composableLambda17, composerStartRestartGroup, i1110 | (i1111 & 112) | (i1111 & 896) | (i1111 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                }
                i3 |= 3072;
                interfaceC3750qp2 = interfaceC3750qp;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 57344) == 0) {
                        interfaceC0526Fp3 = interfaceC0526Fp;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((458752 & i) == 0) {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 64;
                        if (i12 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(z)) {
                                i13 = 1048576;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        }
                        if ((i & 29360128) != 0) {
                            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                        }
                        if ((i3 & 23967451) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda18 = composableLambda;
                            Typography typography9 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens9 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken9 = TypographyKt.fromToken(typography9, datePickerModalTokens9.getHeaderHeadlineFont());
                            float fM2178getHeaderContainerHeightD9Ej5fM9 = datePickerModalTokens9.m2178getHeaderContainerHeightD9Ej5fM();
                            ComposableLambda composableLambda19 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i1112 = ((i14 >> 3) & 14) | 14155776;
                            int i1113 = i14 >> 9;
                            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda18, datePickerColorsM1496colors1m2CgY, textStyleFromToken9, fM2178getHeaderContainerHeightD9Ej5fM9, composableLambda19, composerStartRestartGroup, i1112 | (i1113 & 112) | (i1113 & 896) | (i1113 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda110 = composableLambda;
                            Typography typography10 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens10 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken10 = TypographyKt.fromToken(typography10, datePickerModalTokens10.getHeaderHeadlineFont());
                            float fM2178getHeaderContainerHeightD9Ej5fM10 = datePickerModalTokens10.m2178getHeaderContainerHeightD9Ej5fM();
                            ComposableLambda composableLambda111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i1114 = ((i14 >> 3) & 14) | 14155776;
                            int i1115 = i14 >> 9;
                            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda110, datePickerColorsM1496colors1m2CgY, textStyleFromToken10, fM2178getHeaderContainerHeightD9Ej5fM10, composableLambda111, composerStartRestartGroup, i1114 | (i1115 & 112) | (i1115 & 896) | (i1115 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                    }
                    if ((i3 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda112 = composableLambda;
                        Typography typography11 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens11 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken11 = TypographyKt.fromToken(typography11, datePickerModalTokens11.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM11 = datePickerModalTokens11.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1116 = ((i14 >> 3) & 14) | 14155776;
                        int i1117 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda112, datePickerColorsM1496colors1m2CgY, textStyleFromToken11, fM2178getHeaderContainerHeightD9Ej5fM11, composableLambda113, composerStartRestartGroup, i1116 | (i1117 & 112) | (i1117 & 896) | (i1117 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda114 = composableLambda;
                        Typography typography12 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens12 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken12 = TypographyKt.fromToken(typography12, datePickerModalTokens12.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM12 = datePickerModalTokens12.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1118 = ((i14 >> 3) & 14) | 14155776;
                        int i1119 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda114, datePickerColorsM1496colors1m2CgY, textStyleFromToken12, fM2178getHeaderContainerHeightD9Ej5fM12, composableLambda115, composerStartRestartGroup, i1118 | (i1119 & 112) | (i1119 & 896) | (i1119 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                }
                i3 |= 24576;
                interfaceC0526Fp3 = interfaceC0526Fp;
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                    }
                    if ((i3 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda116 = composableLambda;
                        Typography typography13 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens13 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken13 = TypographyKt.fromToken(typography13, datePickerModalTokens13.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM13 = datePickerModalTokens13.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i11110 = ((i14 >> 3) & 14) | 14155776;
                        int i11111 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda116, datePickerColorsM1496colors1m2CgY, textStyleFromToken13, fM2178getHeaderContainerHeightD9Ej5fM13, composableLambda117, composerStartRestartGroup, i11110 | (i11111 & 112) | (i11111 & 896) | (i11111 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda118 = composableLambda;
                        Typography typography14 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens14 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken14 = TypographyKt.fromToken(typography14, datePickerModalTokens14.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM14 = datePickerModalTokens14.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i11112 = ((i14 >> 3) & 14) | 14155776;
                        int i11113 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda118, datePickerColorsM1496colors1m2CgY, textStyleFromToken14, fM2178getHeaderContainerHeightD9Ej5fM14, composableLambda119, composerStartRestartGroup, i11112 | (i11113 & 112) | (i11113 & 896) | (i11113 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp4 = interfaceC0526Fp2;
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                }
                if ((i3 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda1110 = composableLambda;
                    Typography typography15 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens15 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken15 = TypographyKt.fromToken(typography15, datePickerModalTokens15.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM15 = datePickerModalTokens15.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda1111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11114 = ((i14 >> 3) & 14) | 14155776;
                    int i11115 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1110, datePickerColorsM1496colors1m2CgY, textStyleFromToken15, fM2178getHeaderContainerHeightD9Ej5fM15, composableLambda1111, composerStartRestartGroup, i11114 | (i11115 & 112) | (i11115 & 896) | (i11115 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda1112 = composableLambda;
                    Typography typography16 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens16 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken16 = TypographyKt.fromToken(typography16, datePickerModalTokens16.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM16 = datePickerModalTokens16.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda1113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11116 = ((i14 >> 3) & 14) | 14155776;
                    int i11117 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1112, datePickerColorsM1496colors1m2CgY, textStyleFromToken16, fM2178getHeaderContainerHeightD9Ej5fM16, composableLambda1113, composerStartRestartGroup, i11116 | (i11117 & 112) | (i11117 & 896) | (i11117 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
            }
            i3 |= 384;
            datePickerFormatter2 = datePickerFormatter;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC3750qp2 = interfaceC3750qp;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 57344) == 0) {
                        interfaceC0526Fp3 = interfaceC0526Fp;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((458752 & i) == 0) {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 64;
                        if (i12 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(z)) {
                                i13 = 1048576;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        }
                        if ((i & 29360128) != 0) {
                            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                        }
                        if ((i3 & 23967451) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda1114 = composableLambda;
                            Typography typography17 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens17 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken17 = TypographyKt.fromToken(typography17, datePickerModalTokens17.getHeaderHeadlineFont());
                            float fM2178getHeaderContainerHeightD9Ej5fM17 = datePickerModalTokens17.m2178getHeaderContainerHeightD9Ej5fM();
                            ComposableLambda composableLambda1115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i11118 = ((i14 >> 3) & 14) | 14155776;
                            int i11119 = i14 >> 9;
                            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1114, datePickerColorsM1496colors1m2CgY, textStyleFromToken17, fM2178getHeaderContainerHeightD9Ej5fM17, composableLambda1115, composerStartRestartGroup, i11118 | (i11119 & 112) | (i11119 & 896) | (i11119 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda1116 = composableLambda;
                            Typography typography18 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens18 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken18 = TypographyKt.fromToken(typography18, datePickerModalTokens18.getHeaderHeadlineFont());
                            float fM2178getHeaderContainerHeightD9Ej5fM18 = datePickerModalTokens18.m2178getHeaderContainerHeightD9Ej5fM();
                            ComposableLambda composableLambda1117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i111110 = ((i14 >> 3) & 14) | 14155776;
                            int i111111 = i14 >> 9;
                            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1116, datePickerColorsM1496colors1m2CgY, textStyleFromToken18, fM2178getHeaderContainerHeightD9Ej5fM18, composableLambda1117, composerStartRestartGroup, i111110 | (i111111 & 112) | (i111111 & 896) | (i111111 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                    }
                    if ((i3 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda1118 = composableLambda;
                        Typography typography19 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens19 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken19 = TypographyKt.fromToken(typography19, datePickerModalTokens19.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM19 = datePickerModalTokens19.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda1119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111112 = ((i14 >> 3) & 14) | 14155776;
                        int i111113 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1118, datePickerColorsM1496colors1m2CgY, textStyleFromToken19, fM2178getHeaderContainerHeightD9Ej5fM19, composableLambda1119, composerStartRestartGroup, i111112 | (i111113 & 112) | (i111113 & 896) | (i111113 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11110 = composableLambda;
                        Typography typography110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens110 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken110 = TypographyKt.fromToken(typography110, datePickerModalTokens110.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM110 = datePickerModalTokens110.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda11111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111114 = ((i14 >> 3) & 14) | 14155776;
                        int i111115 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11110, datePickerColorsM1496colors1m2CgY, textStyleFromToken110, fM2178getHeaderContainerHeightD9Ej5fM110, composableLambda11111, composerStartRestartGroup, i111114 | (i111115 & 112) | (i111115 & 896) | (i111115 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                }
                i3 |= 24576;
                interfaceC0526Fp3 = interfaceC0526Fp;
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                    }
                    if ((i3 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11112 = composableLambda;
                        Typography typography111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens111 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken111 = TypographyKt.fromToken(typography111, datePickerModalTokens111.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM111 = datePickerModalTokens111.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda11113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111116 = ((i14 >> 3) & 14) | 14155776;
                        int i111117 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11112, datePickerColorsM1496colors1m2CgY, textStyleFromToken111, fM2178getHeaderContainerHeightD9Ej5fM111, composableLambda11113, composerStartRestartGroup, i111116 | (i111117 & 112) | (i111117 & 896) | (i111117 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11114 = composableLambda;
                        Typography typography112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens112 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken112 = TypographyKt.fromToken(typography112, datePickerModalTokens112.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM112 = datePickerModalTokens112.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda11115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111118 = ((i14 >> 3) & 14) | 14155776;
                        int i111119 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11114, datePickerColorsM1496colors1m2CgY, textStyleFromToken112, fM2178getHeaderContainerHeightD9Ej5fM112, composableLambda11115, composerStartRestartGroup, i111118 | (i111119 & 112) | (i111119 & 896) | (i111119 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp4 = interfaceC0526Fp2;
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                }
                if ((i3 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11116 = composableLambda;
                    Typography typography113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens113 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken113 = TypographyKt.fromToken(typography113, datePickerModalTokens113.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM113 = datePickerModalTokens113.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda11117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111110 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11116, datePickerColorsM1496colors1m2CgY, textStyleFromToken113, fM2178getHeaderContainerHeightD9Ej5fM113, composableLambda11117, composerStartRestartGroup, i1111110 | (i1111111 & 112) | (i1111111 & 896) | (i1111111 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11118 = composableLambda;
                    Typography typography114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens114 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken114 = TypographyKt.fromToken(typography114, datePickerModalTokens114.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM114 = datePickerModalTokens114.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda11119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111112 = ((i14 >> 3) & 14) | 14155776;
                    int i1111113 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11118, datePickerColorsM1496colors1m2CgY, textStyleFromToken114, fM2178getHeaderContainerHeightD9Ej5fM114, composableLambda11119, composerStartRestartGroup, i1111112 | (i1111113 & 112) | (i1111113 & 896) | (i1111113 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
            }
            i3 |= 3072;
            interfaceC3750qp2 = interfaceC3750qp;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 57344) == 0) {
                    interfaceC0526Fp3 = interfaceC0526Fp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                    }
                    if ((i3 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda111110 = composableLambda;
                        Typography typography115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens115 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken115 = TypographyKt.fromToken(typography115, datePickerModalTokens115.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM115 = datePickerModalTokens115.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1111114 = ((i14 >> 3) & 14) | 14155776;
                        int i1111115 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken115, fM2178getHeaderContainerHeightD9Ej5fM115, composableLambda111111, composerStartRestartGroup, i1111114 | (i1111115 & 112) | (i1111115 & 896) | (i1111115 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda111112 = composableLambda;
                        Typography typography116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens116 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken116 = TypographyKt.fromToken(typography116, datePickerModalTokens116.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM116 = datePickerModalTokens116.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1111116 = ((i14 >> 3) & 14) | 14155776;
                        int i1111117 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken116, fM2178getHeaderContainerHeightD9Ej5fM116, composableLambda111113, composerStartRestartGroup, i1111116 | (i1111117 & 112) | (i1111117 & 896) | (i1111117 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp4 = interfaceC0526Fp2;
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                }
                if ((i3 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111114 = composableLambda;
                    Typography typography117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens117 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken117 = TypographyKt.fromToken(typography117, datePickerModalTokens117.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM117 = datePickerModalTokens117.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111118 = ((i14 >> 3) & 14) | 14155776;
                    int i1111119 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken117, fM2178getHeaderContainerHeightD9Ej5fM117, composableLambda111115, composerStartRestartGroup, i1111118 | (i1111119 & 112) | (i1111119 & 896) | (i1111119 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111116 = composableLambda;
                    Typography typography118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens118 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken118 = TypographyKt.fromToken(typography118, datePickerModalTokens118.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM118 = datePickerModalTokens118.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111110 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken118, fM2178getHeaderContainerHeightD9Ej5fM118, composableLambda111117, composerStartRestartGroup, i11111110 | (i11111111 & 112) | (i11111111 & 896) | (i11111111 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp3 = interfaceC0526Fp;
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((458752 & i) == 0) {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                }
                if ((i3 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111118 = composableLambda;
                    Typography typography119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens119 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken119 = TypographyKt.fromToken(typography119, datePickerModalTokens119.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM119 = datePickerModalTokens119.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111112 = ((i14 >> 3) & 14) | 14155776;
                    int i11111113 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken119, fM2178getHeaderContainerHeightD9Ej5fM119, composableLambda111119, composerStartRestartGroup, i11111112 | (i11111113 & 112) | (i11111113 & 896) | (i11111113 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda1111110 = composableLambda;
                    Typography typography1110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens1110 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken1110 = TypographyKt.fromToken(typography1110, datePickerModalTokens1110.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM1110 = datePickerModalTokens1110.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda1111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111114 = ((i14 >> 3) & 14) | 14155776;
                    int i11111115 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken1110, fM2178getHeaderContainerHeightD9Ej5fM1110, composableLambda1111111, composerStartRestartGroup, i11111114 | (i11111115 & 112) | (i11111115 & 896) | (i11111115 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp4 = interfaceC0526Fp2;
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
            }
            if ((i3 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111112 = composableLambda;
                Typography typography1111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens1111 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken1111 = TypographyKt.fromToken(typography1111, datePickerModalTokens1111.getHeaderHeadlineFont());
                float fM2178getHeaderContainerHeightD9Ej5fM1111 = datePickerModalTokens1111.m2178getHeaderContainerHeightD9Ej5fM();
                ComposableLambda composableLambda1111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111116 = ((i14 >> 3) & 14) | 14155776;
                int i11111117 = i14 >> 9;
                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111, fM2178getHeaderContainerHeightD9Ej5fM1111, composableLambda1111113, composerStartRestartGroup, i11111116 | (i11111117 & 112) | (i11111117 & 896) | (i11111117 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111114 = composableLambda;
                Typography typography1112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens1112 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken1112 = TypographyKt.fromToken(typography1112, datePickerModalTokens1112.getHeaderHeadlineFont());
                float fM2178getHeaderContainerHeightD9Ej5fM1112 = datePickerModalTokens1112.m2178getHeaderContainerHeightD9Ej5fM();
                ComposableLambda composableLambda1111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111118 = ((i14 >> 3) & 14) | 14155776;
                int i11111119 = i14 >> 9;
                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken1112, fM2178getHeaderContainerHeightD9Ej5fM1112, composableLambda1111115, composerStartRestartGroup, i11111118 | (i11111119 & 112) | (i11111119 & 896) | (i11111119 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
        }
        i3 |= 48;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 896) == 0) {
                datePickerFormatter2 = datePickerFormatter;
                if (composerStartRestartGroup.changed(datePickerFormatter2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 7168) == 0) {
                    interfaceC3750qp2 = interfaceC3750qp;
                    if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 57344) == 0) {
                        interfaceC0526Fp3 = interfaceC0526Fp;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 32;
                    if (i10 != 0) {
                        if ((458752 & i) == 0) {
                            interfaceC0526Fp4 = interfaceC0526Fp2;
                            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 64;
                        if (i12 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 3670016) == 0) {
                            if (composerStartRestartGroup.changed(z)) {
                                i13 = 1048576;
                            } else {
                                i13 = 524288;
                            }
                            i3 |= i13;
                        }
                        if ((i & 29360128) != 0) {
                            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                        }
                        if ((i3 & 23967451) == 4793490) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda1111116 = composableLambda;
                            Typography typography1113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens1113 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken1113 = TypographyKt.fromToken(typography1113, datePickerModalTokens1113.getHeaderHeadlineFont());
                            float fM2178getHeaderContainerHeightD9Ej5fM1113 = datePickerModalTokens1113.m2178getHeaderContainerHeightD9Ej5fM();
                            ComposableLambda composableLambda1111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i111111110 = ((i14 >> 3) & 14) | 14155776;
                            int i111111111 = i14 >> 9;
                            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken1113, fM2178getHeaderContainerHeightD9Ej5fM1113, composableLambda1111117, composerStartRestartGroup, i111111110 | (i111111111 & 112) | (i111111111 & 896) | (i111111111 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            modifier3 = modifier2;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            } else {
                                if (i15 != 0) {
                                    modifier2 = Modifier.Companion;
                                } else {
                                    modifier2 = modifier;
                                }
                                if (i4 != 0) {
                                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                                }
                                if (i6 != 0) {
                                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                                } else {
                                    interfaceC3750qp3 = interfaceC3750qp2;
                                }
                                if (i8 != 0) {
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                                } else {
                                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                                }
                                if (i12 != 0) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                if ((i2 & 128) != 0) {
                                    i14 = i3 & (-29360129);
                                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                                } else {
                                    i14 = i3;
                                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda1111118 = composableLambda;
                            Typography typography1114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens1114 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken1114 = TypographyKt.fromToken(typography1114, datePickerModalTokens1114.getHeaderHeadlineFont());
                            float fM2178getHeaderContainerHeightD9Ej5fM1114 = datePickerModalTokens1114.m2178getHeaderContainerHeightD9Ej5fM();
                            ComposableLambda composableLambda1111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i111111112 = ((i14 >> 3) & 14) | 14155776;
                            int i111111113 = i14 >> 9;
                            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken1114, fM2178getHeaderContainerHeightD9Ej5fM1114, composableLambda1111119, composerStartRestartGroup, i111111112 | (i111111113 & 112) | (i111111113 & 896) | (i111111113 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                            modifier3 = modifier2;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                    }
                    if ((i3 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11111110 = composableLambda;
                        Typography typography1115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens1115 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken1115 = TypographyKt.fromToken(typography1115, datePickerModalTokens1115.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM1115 = datePickerModalTokens1115.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda11111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111111114 = ((i14 >> 3) & 14) | 14155776;
                        int i111111115 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken1115, fM2178getHeaderContainerHeightD9Ej5fM1115, composableLambda11111111, composerStartRestartGroup, i111111114 | (i111111115 & 112) | (i111111115 & 896) | (i111111115 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11111112 = composableLambda;
                        Typography typography1116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens1116 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken1116 = TypographyKt.fromToken(typography1116, datePickerModalTokens1116.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM1116 = datePickerModalTokens1116.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda11111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111111116 = ((i14 >> 3) & 14) | 14155776;
                        int i111111117 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken1116, fM2178getHeaderContainerHeightD9Ej5fM1116, composableLambda11111113, composerStartRestartGroup, i111111116 | (i111111117 & 112) | (i111111117 & 896) | (i111111117 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                }
                i3 |= 24576;
                interfaceC0526Fp3 = interfaceC0526Fp;
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                    }
                    if ((i3 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11111114 = composableLambda;
                        Typography typography1117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens1117 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken1117 = TypographyKt.fromToken(typography1117, datePickerModalTokens1117.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM1117 = datePickerModalTokens1117.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda11111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111111118 = ((i14 >> 3) & 14) | 14155776;
                        int i111111119 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken1117, fM2178getHeaderContainerHeightD9Ej5fM1117, composableLambda11111115, composerStartRestartGroup, i111111118 | (i111111119 & 112) | (i111111119 & 896) | (i111111119 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11111116 = composableLambda;
                        Typography typography1118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens1118 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken1118 = TypographyKt.fromToken(typography1118, datePickerModalTokens1118.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM1118 = datePickerModalTokens1118.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda11111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1111111110 = ((i14 >> 3) & 14) | 14155776;
                        int i1111111111 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken1118, fM2178getHeaderContainerHeightD9Ej5fM1118, composableLambda11111117, composerStartRestartGroup, i1111111110 | (i1111111111 & 112) | (i1111111111 & 896) | (i1111111111 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp4 = interfaceC0526Fp2;
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                }
                if ((i3 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11111118 = composableLambda;
                    Typography typography1119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens1119 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken1119 = TypographyKt.fromToken(typography1119, datePickerModalTokens1119.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM1119 = datePickerModalTokens1119.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda11111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111111112 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111113 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken1119, fM2178getHeaderContainerHeightD9Ej5fM1119, composableLambda11111119, composerStartRestartGroup, i1111111112 | (i1111111113 & 112) | (i1111111113 & 896) | (i1111111113 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111111110 = composableLambda;
                    Typography typography11110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens11110 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken11110 = TypographyKt.fromToken(typography11110, datePickerModalTokens11110.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM11110 = datePickerModalTokens11110.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda111111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111111114 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111115 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken11110, fM2178getHeaderContainerHeightD9Ej5fM11110, composableLambda111111111, composerStartRestartGroup, i1111111114 | (i1111111115 & 112) | (i1111111115 & 896) | (i1111111115 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
            }
            i3 |= 3072;
            interfaceC3750qp2 = interfaceC3750qp;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 57344) == 0) {
                    interfaceC0526Fp3 = interfaceC0526Fp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                    }
                    if ((i3 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda111111112 = composableLambda;
                        Typography typography11111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens11111 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken11111 = TypographyKt.fromToken(typography11111, datePickerModalTokens11111.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM11111 = datePickerModalTokens11111.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda111111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1111111116 = ((i14 >> 3) & 14) | 14155776;
                        int i1111111117 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken11111, fM2178getHeaderContainerHeightD9Ej5fM11111, composableLambda111111113, composerStartRestartGroup, i1111111116 | (i1111111117 & 112) | (i1111111117 & 896) | (i1111111117 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda111111114 = composableLambda;
                        Typography typography11112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens11112 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken11112 = TypographyKt.fromToken(typography11112, datePickerModalTokens11112.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM11112 = datePickerModalTokens11112.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda111111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1111111118 = ((i14 >> 3) & 14) | 14155776;
                        int i1111111119 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken11112, fM2178getHeaderContainerHeightD9Ej5fM11112, composableLambda111111115, composerStartRestartGroup, i1111111118 | (i1111111119 & 112) | (i1111111119 & 896) | (i1111111119 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp4 = interfaceC0526Fp2;
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                }
                if ((i3 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111111116 = composableLambda;
                    Typography typography11113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens11113 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken11113 = TypographyKt.fromToken(typography11113, datePickerModalTokens11113.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM11113 = datePickerModalTokens11113.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda111111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111111110 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111111 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken11113, fM2178getHeaderContainerHeightD9Ej5fM11113, composableLambda111111117, composerStartRestartGroup, i11111111110 | (i11111111111 & 112) | (i11111111111 & 896) | (i11111111111 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111111118 = composableLambda;
                    Typography typography11114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens11114 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken11114 = TypographyKt.fromToken(typography11114, datePickerModalTokens11114.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM11114 = datePickerModalTokens11114.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda111111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111111112 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111113 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken11114, fM2178getHeaderContainerHeightD9Ej5fM11114, composableLambda111111119, composerStartRestartGroup, i11111111112 | (i11111111113 & 112) | (i11111111113 & 896) | (i11111111113 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp3 = interfaceC0526Fp;
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((458752 & i) == 0) {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                }
                if ((i3 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda1111111110 = composableLambda;
                    Typography typography11115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens11115 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken11115 = TypographyKt.fromToken(typography11115, datePickerModalTokens11115.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM11115 = datePickerModalTokens11115.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda1111111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111111114 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111115 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken11115, fM2178getHeaderContainerHeightD9Ej5fM11115, composableLambda1111111111, composerStartRestartGroup, i11111111114 | (i11111111115 & 112) | (i11111111115 & 896) | (i11111111115 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda1111111112 = composableLambda;
                    Typography typography11116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens11116 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken11116 = TypographyKt.fromToken(typography11116, datePickerModalTokens11116.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM11116 = datePickerModalTokens11116.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda1111111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111111116 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111117 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken11116, fM2178getHeaderContainerHeightD9Ej5fM11116, composableLambda1111111113, composerStartRestartGroup, i11111111116 | (i11111111117 & 112) | (i11111111117 & 896) | (i11111111117 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp4 = interfaceC0526Fp2;
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
            }
            if ((i3 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111111114 = composableLambda;
                Typography typography11117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens11117 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken11117 = TypographyKt.fromToken(typography11117, datePickerModalTokens11117.getHeaderHeadlineFont());
                float fM2178getHeaderContainerHeightD9Ej5fM11117 = datePickerModalTokens11117.m2178getHeaderContainerHeightD9Ej5fM();
                ComposableLambda composableLambda1111111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111111118 = ((i14 >> 3) & 14) | 14155776;
                int i11111111119 = i14 >> 9;
                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken11117, fM2178getHeaderContainerHeightD9Ej5fM11117, composableLambda1111111115, composerStartRestartGroup, i11111111118 | (i11111111119 & 112) | (i11111111119 & 896) | (i11111111119 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111111116 = composableLambda;
                Typography typography11118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens11118 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken11118 = TypographyKt.fromToken(typography11118, datePickerModalTokens11118.getHeaderHeadlineFont());
                float fM2178getHeaderContainerHeightD9Ej5fM11118 = datePickerModalTokens11118.m2178getHeaderContainerHeightD9Ej5fM();
                ComposableLambda composableLambda1111111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i111111111110 = ((i14 >> 3) & 14) | 14155776;
                int i111111111111 = i14 >> 9;
                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken11118, fM2178getHeaderContainerHeightD9Ej5fM11118, composableLambda1111111117, composerStartRestartGroup, i111111111110 | (i111111111111 & 112) | (i111111111111 & 896) | (i111111111111 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
        }
        i3 |= 384;
        datePickerFormatter2 = datePickerFormatter;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 7168) == 0) {
                interfaceC3750qp2 = interfaceC3750qp;
                if (composerStartRestartGroup.changedInstance(interfaceC3750qp2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 57344) == 0) {
                    interfaceC0526Fp3 = interfaceC0526Fp;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 32;
                if (i10 != 0) {
                    if ((458752 & i) == 0) {
                        interfaceC0526Fp4 = interfaceC0526Fp2;
                        if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 64;
                    if (i12 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i13 = 1048576;
                        } else {
                            i13 = 524288;
                        }
                        i3 |= i13;
                    }
                    if ((i & 29360128) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                    }
                    if ((i3 & 23967451) == 4793490) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda1111111118 = composableLambda;
                        Typography typography11119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens11119 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken11119 = TypographyKt.fromToken(typography11119, datePickerModalTokens11119.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM11119 = datePickerModalTokens11119.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda1111111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111111111112 = ((i14 >> 3) & 14) | 14155776;
                        int i111111111113 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken11119, fM2178getHeaderContainerHeightD9Ej5fM11119, composableLambda1111111119, composerStartRestartGroup, i111111111112 | (i111111111113 & 112) | (i111111111113 & 896) | (i111111111113 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if (i4 != 0) {
                                composerStartRestartGroup.startReplaceableGroup(-492369756);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                            }
                            if (i6 != 0) {
                                interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                            } else {
                                interfaceC3750qp3 = interfaceC3750qp2;
                            }
                            if (i8 != 0) {
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                            } else {
                                interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                            }
                            if (i12 != 0) {
                                z2 = true;
                            } else {
                                z2 = z;
                            }
                            if ((i2 & 128) != 0) {
                                i14 = i3 & (-29360129);
                                datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                            } else {
                                i14 = i3;
                                datePickerColorsM1496colors1m2CgY = datePickerColors;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11111111110 = composableLambda;
                        Typography typography111110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens111110 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken111110 = TypographyKt.fromToken(typography111110, datePickerModalTokens111110.getHeaderHeadlineFont());
                        float fM2178getHeaderContainerHeightD9Ej5fM111110 = datePickerModalTokens111110.m2178getHeaderContainerHeightD9Ej5fM();
                        ComposableLambda composableLambda11111111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111111111114 = ((i14 >> 3) & 14) | 14155776;
                        int i111111111115 = i14 >> 9;
                        m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken111110, fM2178getHeaderContainerHeightD9Ej5fM111110, composableLambda11111111111, composerStartRestartGroup, i111111111114 | (i111111111115 & 112) | (i111111111115 & 896) | (i111111111115 & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                        interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                        datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                        modifier3 = modifier2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                interfaceC0526Fp4 = interfaceC0526Fp2;
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                }
                if ((i3 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11111111112 = composableLambda;
                    Typography typography111111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111111 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111111 = TypographyKt.fromToken(typography111111, datePickerModalTokens111111.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM111111 = datePickerModalTokens111111.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda11111111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i111111111116 = ((i14 >> 3) & 14) | 14155776;
                    int i111111111117 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken111111, fM2178getHeaderContainerHeightD9Ej5fM111111, composableLambda11111111113, composerStartRestartGroup, i111111111116 | (i111111111117 & 112) | (i111111111117 & 896) | (i111111111117 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11111111114 = composableLambda;
                    Typography typography111112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111112 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111112 = TypographyKt.fromToken(typography111112, datePickerModalTokens111112.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM111112 = datePickerModalTokens111112.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda11111111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i111111111118 = ((i14 >> 3) & 14) | 14155776;
                    int i111111111119 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken111112, fM2178getHeaderContainerHeightD9Ej5fM111112, composableLambda11111111115, composerStartRestartGroup, i111111111118 | (i111111111119 & 112) | (i111111111119 & 896) | (i111111111119 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
            }
            i3 |= 24576;
            interfaceC0526Fp3 = interfaceC0526Fp;
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((458752 & i) == 0) {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                }
                if ((i3 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11111111116 = composableLambda;
                    Typography typography111113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111113 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111113 = TypographyKt.fromToken(typography111113, datePickerModalTokens111113.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM111113 = datePickerModalTokens111113.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda11111111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111111111110 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111111111 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken111113, fM2178getHeaderContainerHeightD9Ej5fM111113, composableLambda11111111117, composerStartRestartGroup, i1111111111110 | (i1111111111111 & 112) | (i1111111111111 & 896) | (i1111111111111 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11111111118 = composableLambda;
                    Typography typography111114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111114 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111114 = TypographyKt.fromToken(typography111114, datePickerModalTokens111114.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM111114 = datePickerModalTokens111114.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda11111111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111111111112 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111111113 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken111114, fM2178getHeaderContainerHeightD9Ej5fM111114, composableLambda11111111119, composerStartRestartGroup, i1111111111112 | (i1111111111113 & 112) | (i1111111111113 & 896) | (i1111111111113 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp4 = interfaceC0526Fp2;
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
            }
            if ((i3 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda111111111110 = composableLambda;
                Typography typography111115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens111115 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken111115 = TypographyKt.fromToken(typography111115, datePickerModalTokens111115.getHeaderHeadlineFont());
                float fM2178getHeaderContainerHeightD9Ej5fM111115 = datePickerModalTokens111115.m2178getHeaderContainerHeightD9Ej5fM();
                ComposableLambda composableLambda111111111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i1111111111114 = ((i14 >> 3) & 14) | 14155776;
                int i1111111111115 = i14 >> 9;
                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken111115, fM2178getHeaderContainerHeightD9Ej5fM111115, composableLambda111111111111, composerStartRestartGroup, i1111111111114 | (i1111111111115 & 112) | (i1111111111115 & 896) | (i1111111111115 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda111111111112 = composableLambda;
                Typography typography111116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens111116 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken111116 = TypographyKt.fromToken(typography111116, datePickerModalTokens111116.getHeaderHeadlineFont());
                float fM2178getHeaderContainerHeightD9Ej5fM111116 = datePickerModalTokens111116.m2178getHeaderContainerHeightD9Ej5fM();
                ComposableLambda composableLambda111111111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i1111111111116 = ((i14 >> 3) & 14) | 14155776;
                int i1111111111117 = i14 >> 9;
                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken111116, fM2178getHeaderContainerHeightD9Ej5fM111116, composableLambda111111111113, composerStartRestartGroup, i1111111111116 | (i1111111111117 & 112) | (i1111111111117 & 896) | (i1111111111117 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
        }
        i3 |= 3072;
        interfaceC3750qp2 = interfaceC3750qp;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 57344) == 0) {
                interfaceC0526Fp3 = interfaceC0526Fp;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp3)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            i10 = i2 & 32;
            if (i10 != 0) {
                if ((458752 & i) == 0) {
                    interfaceC0526Fp4 = interfaceC0526Fp2;
                    if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 64;
                if (i12 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i13 = 1048576;
                    } else {
                        i13 = 524288;
                    }
                    i3 |= i13;
                }
                if ((i & 29360128) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
                }
                if ((i3 & 23967451) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111111111114 = composableLambda;
                    Typography typography111117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111117 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111117 = TypographyKt.fromToken(typography111117, datePickerModalTokens111117.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM111117 = datePickerModalTokens111117.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda111111111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111111111118 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111111119 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken111117, fM2178getHeaderContainerHeightD9Ej5fM111117, composableLambda111111111115, composerStartRestartGroup, i1111111111118 | (i1111111111119 & 112) | (i1111111111119 & 896) | (i1111111111119 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if (i4 != 0) {
                            composerStartRestartGroup.startReplaceableGroup(-492369756);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                        }
                        if (i6 != 0) {
                            interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                        } else {
                            interfaceC3750qp3 = interfaceC3750qp2;
                        }
                        if (i8 != 0) {
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                        } else {
                            interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                        }
                        if (i12 != 0) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        if ((i2 & 128) != 0) {
                            i14 = i3 & (-29360129);
                            datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                        } else {
                            i14 = i3;
                            datePickerColorsM1496colors1m2CgY = datePickerColors;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111111111116 = composableLambda;
                    Typography typography111118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111118 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111118 = TypographyKt.fromToken(typography111118, datePickerModalTokens111118.getHeaderHeadlineFont());
                    float fM2178getHeaderContainerHeightD9Ej5fM111118 = datePickerModalTokens111118.m2178getHeaderContainerHeightD9Ej5fM();
                    ComposableLambda composableLambda111111111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111111111110 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111111111 = i14 >> 9;
                    m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken111118, fM2178getHeaderContainerHeightD9Ej5fM111118, composableLambda111111111117, composerStartRestartGroup, i11111111111110 | (i11111111111111 & 112) | (i11111111111111 & 896) | (i11111111111111 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                    interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                    datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            interfaceC0526Fp4 = interfaceC0526Fp2;
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
            }
            if ((i3 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda111111111118 = composableLambda;
                Typography typography111119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens111119 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken111119 = TypographyKt.fromToken(typography111119, datePickerModalTokens111119.getHeaderHeadlineFont());
                float fM2178getHeaderContainerHeightD9Ej5fM111119 = datePickerModalTokens111119.m2178getHeaderContainerHeightD9Ej5fM();
                ComposableLambda composableLambda111111111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111111111112 = ((i14 >> 3) & 14) | 14155776;
                int i11111111111113 = i14 >> 9;
                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken111119, fM2178getHeaderContainerHeightD9Ej5fM111119, composableLambda111111111119, composerStartRestartGroup, i11111111111112 | (i11111111111113 & 112) | (i11111111111113 & 896) | (i11111111111113 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111111111110 = composableLambda;
                Typography typography1111110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens1111110 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken1111110 = TypographyKt.fromToken(typography1111110, datePickerModalTokens1111110.getHeaderHeadlineFont());
                float fM2178getHeaderContainerHeightD9Ej5fM1111110 = datePickerModalTokens1111110.m2178getHeaderContainerHeightD9Ej5fM();
                ComposableLambda composableLambda1111111111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111111111114 = ((i14 >> 3) & 14) | 14155776;
                int i11111111111115 = i14 >> 9;
                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111110, fM2178getHeaderContainerHeightD9Ej5fM1111110, composableLambda1111111111111, composerStartRestartGroup, i11111111111114 | (i11111111111115 & 112) | (i11111111111115 & 896) | (i11111111111115 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
        }
        i3 |= 24576;
        interfaceC0526Fp3 = interfaceC0526Fp;
        i10 = i2 & 32;
        if (i10 != 0) {
            if ((458752 & i) == 0) {
                interfaceC0526Fp4 = interfaceC0526Fp2;
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp4)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            i12 = i2 & 64;
            if (i12 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i13 = 1048576;
                } else {
                    i13 = 524288;
                }
                i3 |= i13;
            }
            if ((i & 29360128) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
            }
            if ((i3 & 23967451) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111111111112 = composableLambda;
                Typography typography1111111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens1111111 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken1111111 = TypographyKt.fromToken(typography1111111, datePickerModalTokens1111111.getHeaderHeadlineFont());
                float fM2178getHeaderContainerHeightD9Ej5fM1111111 = datePickerModalTokens1111111.m2178getHeaderContainerHeightD9Ej5fM();
                ComposableLambda composableLambda1111111111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111111111116 = ((i14 >> 3) & 14) | 14155776;
                int i11111111111117 = i14 >> 9;
                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111111, fM2178getHeaderContainerHeightD9Ej5fM1111111, composableLambda1111111111113, composerStartRestartGroup, i11111111111116 | (i11111111111117 & 112) | (i11111111111117 & 896) | (i11111111111117 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                modifier3 = modifier2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i4 != 0) {
                        composerStartRestartGroup.startReplaceableGroup(-492369756);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                    }
                    if (i6 != 0) {
                        interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                    } else {
                        interfaceC3750qp3 = interfaceC3750qp2;
                    }
                    if (i8 != 0) {
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                    } else {
                        interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                    }
                    if (i12 != 0) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                    if ((i2 & 128) != 0) {
                        i14 = i3 & (-29360129);
                        datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                    } else {
                        i14 = i3;
                        datePickerColorsM1496colors1m2CgY = datePickerColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111111111114 = composableLambda;
                Typography typography1111112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens1111112 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken1111112 = TypographyKt.fromToken(typography1111112, datePickerModalTokens1111112.getHeaderHeadlineFont());
                float fM2178getHeaderContainerHeightD9Ej5fM1111112 = datePickerModalTokens1111112.m2178getHeaderContainerHeightD9Ej5fM();
                ComposableLambda composableLambda1111111111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111111111118 = ((i14 >> 3) & 14) | 14155776;
                int i11111111111119 = i14 >> 9;
                m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111112, fM2178getHeaderContainerHeightD9Ej5fM1111112, composableLambda1111111111115, composerStartRestartGroup, i11111111111118 | (i11111111111119 & 112) | (i11111111111119 & 896) | (i11111111111119 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
                interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
                datePickerColors2 = datePickerColorsM1496colors1m2CgY;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        interfaceC0526Fp4 = interfaceC0526Fp2;
        i12 = i2 & 64;
        if (i12 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(z)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i3 |= i13;
        }
        if ((i & 29360128) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(datePickerColors)) ? 4194304 : 8388608;
        }
        if ((i3 & 23967451) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                }
                if (i6 != 0) {
                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (i8 != 0) {
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                } else {
                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                }
                if (i10 != 0) {
                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                } else {
                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if ((i2 & 128) != 0) {
                    i14 = i3 & (-29360129);
                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                } else {
                    i14 = i3;
                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                }
                if (i6 != 0) {
                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (i8 != 0) {
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                } else {
                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                }
                if (i10 != 0) {
                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                } else {
                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if ((i2 & 128) != 0) {
                    i14 = i3 & (-29360129);
                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                } else {
                    i14 = i3;
                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
            }
            if (z2) {
                z3 = true;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
            } else {
                z3 = true;
                composableLambda = null;
            }
            ComposableLambda composableLambda1111111111116 = composableLambda;
            Typography typography1111113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            DatePickerModalTokens datePickerModalTokens1111113 = DatePickerModalTokens.INSTANCE;
            TextStyle textStyleFromToken1111113 = TypographyKt.fromToken(typography1111113, datePickerModalTokens1111113.getHeaderHeadlineFont());
            float fM2178getHeaderContainerHeightD9Ej5fM1111113 = datePickerModalTokens1111113.m2178getHeaderContainerHeightD9Ej5fM();
            ComposableLambda composableLambda1111111111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
            int i111111111111110 = ((i14 >> 3) & 14) | 14155776;
            int i111111111111111 = i14 >> 9;
            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111113, fM2178getHeaderContainerHeightD9Ej5fM1111113, composableLambda1111111111117, composerStartRestartGroup, i111111111111110 | (i111111111111111 & 112) | (i111111111111111 & 896) | (i111111111111111 & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
            modifier3 = modifier2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                }
                if (i6 != 0) {
                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (i8 != 0) {
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                } else {
                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                }
                if (i10 != 0) {
                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                } else {
                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if ((i2 & 128) != 0) {
                    i14 = i3 & (-29360129);
                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                } else {
                    i14 = i3;
                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if (i4 != 0) {
                    composerStartRestartGroup.startReplaceableGroup(-492369756);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new DatePickerFormatter(null, null, null, 7, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    datePickerFormatter2 = (DatePickerFormatter) objRememberedValue;
                }
                if (i6 != 0) {
                    interfaceC3750qp3 = AnonymousClass2.INSTANCE;
                } else {
                    interfaceC3750qp3 = interfaceC3750qp2;
                }
                if (i8 != 0) {
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 448469326, true, new AnonymousClass3(datePickerState, i3));
                } else {
                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                }
                if (i10 != 0) {
                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1578326756, true, new AnonymousClass4(datePickerState, datePickerFormatter2, i3));
                } else {
                    interfaceC0526FpComposableLambda2 = interfaceC0526Fp2;
                }
                if (i12 != 0) {
                    z2 = true;
                } else {
                    z2 = z;
                }
                if ((i2 & 128) != 0) {
                    i14 = i3 & (-29360129);
                    datePickerColorsM1496colors1m2CgY = DatePickerDefaults.INSTANCE.m1496colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 805306368, 524287);
                } else {
                    i14 = i3;
                    datePickerColorsM1496colors1m2CgY = datePickerColors;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1765097918, i14, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
            }
            if (z2) {
                z3 = true;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1702543532, true, new AnonymousClass5(datePickerState, i14));
            } else {
                z3 = true;
                composableLambda = null;
            }
            ComposableLambda composableLambda1111111111118 = composableLambda;
            Typography typography1111114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            DatePickerModalTokens datePickerModalTokens1111114 = DatePickerModalTokens.INSTANCE;
            TextStyle textStyleFromToken1111114 = TypographyKt.fromToken(typography1111114, datePickerModalTokens1111114.getHeaderHeadlineFont());
            float fM2178getHeaderContainerHeightD9Ej5fM1111114 = datePickerModalTokens1111114.m2178getHeaderContainerHeightD9Ej5fM();
            ComposableLambda composableLambda1111111111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 173769747, z3, new AnonymousClass6(datePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
            int i111111111111112 = ((i14 >> 3) & 14) | 14155776;
            int i111111111111113 = i14 >> 9;
            m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111114, fM2178getHeaderContainerHeightD9Ej5fM1111114, composableLambda1111111111119, composerStartRestartGroup, i111111111111112 | (i111111111111113 & 112) | (i111111111111113 & 896) | (i111111111111113 & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            interfaceC0526Fp5 = interfaceC0526FpComposableLambda;
            interfaceC0526Fp6 = interfaceC0526FpComposableLambda2;
            datePickerColors2 = datePickerColorsM1496colors1m2CgY;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(datePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DatePickerContent(StateData stateData, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1512850300);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(stateData) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerFormatter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1512850300, i3, -1, "androidx.compose.material3.DatePickerContent (DatePicker.kt:1124)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(stateData.getDisplayedMonthIndex(), 0, composerStartRestartGroup, 0, 2);
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
            boolean zChanged = composerStartRestartGroup.changed(stateData);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new DatePickerKt$DatePickerContent$onDateSelected$1$1(stateData);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC3750qp interfaceC3750qp2 = (InterfaceC3750qp) objRememberedValue2;
            MutableState mutableState = (MutableState) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) null, (String) null, (InterfaceC3588op) DatePickerKt$DatePickerContent$yearPickerVisible$2.INSTANCE, composerStartRestartGroup, 3080, 6);
            Locale localeDefaultLocale = CalendarModel_androidKt.defaultLocale(composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion2 = Modifier.Companion;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.Companion;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(companion2);
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
            float f = DatePickerHorizontalPadding;
            Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(companion2, f, 0.0f, 2, null);
            boolean canScrollForward = lazyListStateRememberLazyListState.getCanScrollForward();
            boolean canScrollBackward = lazyListStateRememberLazyListState.getCanScrollBackward();
            boolean zDatePickerContent$lambda$5 = DatePickerContent$lambda$5(mutableState);
            String monthYear$material3_release = datePickerFormatter.formatMonthYear$material3_release(stateData.getDisplayedMonth(), stateData.getCalendarModel(), localeDefaultLocale);
            if (monthYear$material3_release == null) {
                monthYear$material3_release = "-";
            }
            DatePickerKt$DatePickerContent$1$1 datePickerKt$DatePickerContent$1$1 = new DatePickerKt$DatePickerContent$1$1(coroutineScope, lazyListStateRememberLazyListState);
            DatePickerKt$DatePickerContent$1$2 datePickerKt$DatePickerContent$1$2 = new DatePickerKt$DatePickerContent$1$2(coroutineScope, lazyListStateRememberLazyListState);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new DatePickerKt$DatePickerContent$1$3$1(mutableState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MonthsNavigation(modifierM487paddingVpY3zN4$default, canScrollForward, canScrollBackward, zDatePickerContent$lambda$5, monthYear$material3_release, datePickerKt$DatePickerContent$1$1, datePickerKt$DatePickerContent$1$2, (InterfaceC3588op) objRememberedValue3, composerStartRestartGroup, 6);
            composer2 = composerStartRestartGroup;
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor2 = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(companion2);
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
            Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRememberBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion4.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion4.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion4.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierM487paddingVpY3zN4$default2 = PaddingKt.m487paddingVpY3zN4$default(companion2, f, 0.0f, 2, null);
            composer2.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            InterfaceC3588op constructor3 = companion4.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf3 = LayoutKt.materializerOf(modifierM487paddingVpY3zN4$default2);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer composerM2661constructorimpl3 = Updater.m2661constructorimpl(composer2);
            Updater.m2668setimpl(composerM2661constructorimpl3, measurePolicyColumnMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl3, density3, companion4.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl3, layoutDirection3, companion4.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl3, viewConfiguration3, companion4.getSetViewConfiguration());
            composer2.enableReusing();
            interfaceC0552GpMaterializerOf3.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            WeekDays(datePickerColors, stateData.getCalendarModel(), composer2, (i3 >> 9) & 14);
            int i4 = i3 << 6;
            HorizontalMonthsList(interfaceC3750qp2, stateData, lazyListStateRememberLazyListState, datePickerFormatter, interfaceC3750qp, datePickerColors, composer2, ((i3 << 3) & 112) | (i4 & 7168) | (57344 & i4) | (i4 & 458752));
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            AnimatedVisibilityKt.AnimatedVisibility(DatePickerContent$lambda$5(mutableState), ClipKt.clipToBounds(companion2), EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.6f, 1, null)), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null)), (String) null, ComposableLambdaKt.composableLambda(composer2, 760161496, true, new DatePickerKt$DatePickerContent$1$4$2(datePickerColors, stateData, i3, coroutineScope, mutableState, lazyListStateRememberLazyListState)), composer2, 200112, 16);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
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
        scopeUpdateScopeEndRestartGroup.updateScope(new C14862(stateData, datePickerFormatter, interfaceC3750qp, datePickerColors, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DatePickerContent$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DatePickerContent$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DatePickerHeader-pc5RIQQ, reason: not valid java name */
    public static final void m1500DatePickerHeaderpc5RIQQ(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, long j, long j2, float f, InterfaceC0526Fp interfaceC0526Fp2, Composer composer, int i) {
        int i2;
        int i3;
        AbstractC4492zt.h(modifier, "modifier");
        AbstractC4492zt.h(interfaceC0526Fp2, Annotation.CONTENT);
        Composer composerStartRestartGroup = composer.startRestartGroup(-996037719);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 131072 : 65536;
        }
        if ((374491 & i2) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-996037719, i2, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1228)");
            }
            Modifier modifierThen = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null).then(interfaceC0526Fp != null ? SizeKt.m517defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, f, 1, null) : Modifier.Companion);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.Companion.getStart(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierThen);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1127524835);
            if (interfaceC0526Fp != null) {
                i3 = 1;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1005061498, true, new DatePickerKt$DatePickerHeader$1$1(interfaceC0526Fp, i2)), composerStartRestartGroup, 56);
            } else {
                i3 = 1;
            }
            composerStartRestartGroup.endReplaceableGroup();
            ProvidedValue[] providedValueArr = new ProvidedValue[i3];
            providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(j2));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, interfaceC0526Fp2, composerStartRestartGroup, ((i2 >> 12) & 112) | 8);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerKt$DatePickerHeader$2(modifier, interfaceC0526Fp, j, j2, f, interfaceC0526Fp2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Day(Modifier modifier, boolean z, InterfaceC3588op interfaceC3588op, boolean z2, boolean z3, boolean z4, boolean z5, String str, DatePickerColors datePickerColors, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1434777861);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 67108864 : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? PropertyOptions.DELETE_EXISTING : 268435456;
        }
        int i3 = i2;
        if ((1533916891 & i3) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1434777861, i3, -1, "androidx.compose.material3.Day (DatePicker.kt:1570)");
            }
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier);
            DatePickerModalTokens datePickerModalTokens = DatePickerModalTokens.INSTANCE;
            Modifier modifierM526requiredSizeVpY3zN4 = SizeKt.m526requiredSizeVpY3zN4(modifierMinimumInteractiveComponentSize, datePickerModalTokens.m2176getDateStateLayerWidthD9Ej5fM(), datePickerModalTokens.m2175getDateStateLayerHeightD9Ej5fM());
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(str);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new DatePickerKt$Day$1$1(str);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM526requiredSizeVpY3zN4, true, (InterfaceC3750qp) objRememberedValue);
            Shape shape = ShapesKt.toShape(datePickerModalTokens.getDateContainerShape(), composerStartRestartGroup, 6);
            int i4 = i3 >> 3;
            int i5 = i3 >> 15;
            long jM3042unboximpl = datePickerColors.dayContainerColor$material3_release(z, z3, z2, composerStartRestartGroup, (i4 & 14) | ((i3 >> 9) & 112) | (i4 & 896) | (i5 & 7168)).getValue().m3042unboximpl();
            int i6 = (i5 & 14) | (i3 & 112);
            int i7 = i3 >> 12;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, modifierSemantics, z3, shape, jM3042unboximpl, datePickerColors.dayContentColor$material3_release(z4, z, z5, z3, composerStartRestartGroup, i6 | (i7 & 896) | (i4 & 7168) | (i7 & 57344)).getValue().m3042unboximpl(), 0.0f, 0.0f, (!z4 || z) ? null : BorderStrokeKt.m194BorderStrokecXLIe8U(datePickerModalTokens.m2177getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.m1494getTodayDateBorderColor0d7_KjU$material3_release()), (MutableInteractionSource) null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -2031780827, true, new C14872(interfaceC0526Fp, i3)), composer2, i4 & 7294, 48, 1408);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14883(modifier, z, interfaceC3588op, z2, z3, z4, z5, str, datePickerColors, interfaceC0526Fp, i));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: DisplayModeToggleButton-tER2X8s, reason: not valid java name */
    public static final void m1501DisplayModeToggleButtontER2X8s(Modifier modifier, int i, InterfaceC3750qp interfaceC3750qp, Composer composer, int i2) {
        int i3;
        AbstractC4492zt.h(modifier, "modifier");
        AbstractC4492zt.h(interfaceC3750qp, "onDisplayModeChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(1393846115);
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 256 : 128;
        }
        if ((i3 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1393846115, i3, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1065)");
            }
            if (DisplayMode.m1532equalsimpl0(i, DisplayMode.Companion.m1537getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(-1814971324);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                boolean zChanged = composerStartRestartGroup.changed(interfaceC3750qp);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new DatePickerKt$DisplayModeToggleButton$1$1(interfaceC3750qp);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                IconButtonKt.IconButton((InterfaceC3588op) objRememberedValue, modifier, false, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m1469getLambda1$material3_release(), composerStartRestartGroup, ((i3 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1814971040);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                boolean zChanged2 = composerStartRestartGroup.changed(interfaceC3750qp);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new DatePickerKt$DisplayModeToggleButton$2$1(interfaceC3750qp);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                IconButtonKt.IconButton((InterfaceC3588op) objRememberedValue2, modifier, false, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m1470getLambda2$material3_release(), composerStartRestartGroup, ((i3 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new DatePickerKt$DisplayModeToggleButton$3(modifier, i, interfaceC3750qp, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void HorizontalMonthsList(InterfaceC3750qp interfaceC3750qp, StateData stateData, LazyListState lazyListState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp2, DatePickerColors datePickerColors, Composer composer, int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1933363608);
        int i2 = (i & 14) == 0 ? (composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(stateData) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(lazyListState) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerFormatter) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3750qp2) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 131072 : 65536;
        }
        int i3 = i2;
        if ((374491 & i3) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1933363608, i3, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1273)");
            }
            CalendarDate today = stateData.getCalendarModel().getToday();
            C1001Vs yearRange = stateData.getYearRange();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(yearRange);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = stateData.getCalendarModel().getMonth(stateData.getYearRange().b(), 1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CalendarMonth calendarMonth = (CalendarMonth) objRememberedValue;
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, AnonymousClass1.INSTANCE, 1, null);
            int i4 = (i3 >> 6) & 14;
            FlingBehavior flingBehaviorRememberSnapFlingBehavior$material3_release = DatePickerDefaults.INSTANCE.rememberSnapFlingBehavior$material3_release(lazyListState, null, composerStartRestartGroup, i4 | 384, 2);
            Object[] objArr = {stateData, calendarMonth, interfaceC3750qp, today, interfaceC3750qp2, datePickerFormatter, datePickerColors};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            boolean zChanged2 = false;
            for (int i5 = 0; i5 < 7; i5++) {
                zChanged2 |= composerStartRestartGroup.changed(objArr[i5]);
            }
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                DatePickerKt$HorizontalMonthsList$2$1 datePickerKt$HorizontalMonthsList$2$1 = new DatePickerKt$HorizontalMonthsList$2$1(stateData, calendarMonth, interfaceC3750qp, today, interfaceC3750qp2, datePickerFormatter, datePickerColors, i3);
                composerStartRestartGroup.updateRememberedValue(datePickerKt$HorizontalMonthsList$2$1);
                objRememberedValue2 = datePickerKt$HorizontalMonthsList$2$1;
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyRow(modifierSemantics$default, lazyListState, null, false, null, null, flingBehaviorRememberSnapFlingBehavior$material3_release, false, (InterfaceC3750qp) objRememberedValue2, composer2, (i3 >> 3) & 112, 188);
            composer2.startReplaceableGroup(511388516);
            boolean zChanged3 = composer2.changed(lazyListState) | composer2.changed(stateData);
            Object objRememberedValue3 = composer2.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new DatePickerKt$HorizontalMonthsList$3$1(lazyListState, stateData, null);
                composer2.updateRememberedValue(objRememberedValue3);
            }
            composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(lazyListState, (InterfaceC0526Fp) objRememberedValue3, composer2, i4 | 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14894(interfaceC3750qp, stateData, lazyListState, datePickerFormatter, interfaceC3750qp2, datePickerColors, i));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Month(CalendarMonth calendarMonth, InterfaceC3750qp interfaceC3750qp, CalendarDate calendarDate, StateData stateData, boolean z, InterfaceC3750qp interfaceC3750qp2, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Modifier modifierDrawWithContent;
        Composer composer2;
        AbstractC4492zt.h(calendarMonth, "month");
        AbstractC4492zt.h(interfaceC3750qp, "onDateSelected");
        AbstractC4492zt.h(calendarDate, "today");
        AbstractC4492zt.h(stateData, "stateData");
        AbstractC4492zt.h(interfaceC3750qp2, "dateValidator");
        AbstractC4492zt.h(datePickerFormatter, "dateFormatter");
        AbstractC4492zt.h(datePickerColors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1561090804);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(calendarMonth) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(calendarDate) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(stateData) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3750qp2) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerFormatter) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 8388608 : 4194304;
        }
        int i3 = i2;
        if ((23967451 & i3) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1561090804, i3, -1, "androidx.compose.material3.Month (DatePicker.kt:1404)");
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new DatePickerKt$Month$rangeSelectionInfo$1$1(z, calendarMonth, stateData));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            State state = (State) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-2019479227);
            if (z) {
                Modifier.Companion companion = Modifier.Companion;
                composerStartRestartGroup.startReplaceableGroup(511388516);
                boolean zChanged2 = composerStartRestartGroup.changed(state) | composerStartRestartGroup.changed(datePickerColors);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new DatePickerKt$Month$rangeSelectionDrawModifier$1$1(state, datePickerColors);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                modifierDrawWithContent = DrawModifierKt.drawWithContent(companion, (InterfaceC3750qp) objRememberedValue2);
            } else {
                modifierDrawWithContent = Modifier.Companion;
            }
            Modifier modifier = modifierDrawWithContent;
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), DatePickerModalTokens.INSTANCE.getDateLabelTextFont()), ComposableLambdaKt.composableLambda(composer2, -1776200645, true, new C14901(modifier, calendarMonth, calendarDate, stateData.getSelectedStartDate(), stateData.getSelectedEndDate(), z, i3, datePickerFormatter, CalendarModel_androidKt.defaultLocale(composerStartRestartGroup, 0), interfaceC3750qp, datePickerColors, stateData, interfaceC3750qp2)), composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14912(calendarMonth, interfaceC3750qp, calendarDate, stateData, z, interfaceC3750qp2, datePickerFormatter, datePickerColors, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void MonthsNavigation(Modifier modifier, boolean z, boolean z2, boolean z3, String str, InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, InterfaceC3588op interfaceC3588op3, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1127095896);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op2) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op3) ? 8388608 : 4194304;
        }
        int i3 = i2;
        if ((23967451 & i3) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1127095896, i3, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:1765)");
            }
            Modifier modifierM521requiredHeight3ABfNKs = SizeKt.m521requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), MonthYearHeight);
            Arrangement.Horizontal start = z3 ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Companion companion = Alignment.Companion;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composerStartRestartGroup, 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion2.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM521requiredHeight3ABfNKs);
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            YearPickerMenuButton(interfaceC3588op3, z3, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1156508456, true, new DatePickerKt$MonthsNavigation$1$1(str, i3)), composerStartRestartGroup, ((i3 >> 21) & 14) | 3072 | ((i3 >> 6) & 112), 4);
            composerStartRestartGroup.startReplaceableGroup(979007906);
            if (z3) {
                composer2 = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceableGroup(693286680);
                Modifier.Companion companion3 = Modifier.Companion;
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion.getTop(), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                InterfaceC3588op constructor2 = companion2.getConstructor();
                InterfaceC0552Gp interfaceC0552GpMaterializerOf2 = LayoutKt.materializerOf(companion3);
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
                Updater.m2668setimpl(composerM2661constructorimpl2, measurePolicyRowMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m2668setimpl(composerM2661constructorimpl2, density2, companion2.getSetDensity());
                Updater.m2668setimpl(composerM2661constructorimpl2, layoutDirection2, companion2.getSetLayoutDirection());
                Updater.m2668setimpl(composerM2661constructorimpl2, viewConfiguration2, companion2.getSetViewConfiguration());
                composerStartRestartGroup.enableReusing();
                interfaceC0552GpMaterializerOf2.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                boolean z4 = composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
                composer2 = composerStartRestartGroup;
                IconButtonKt.IconButton(interfaceC3588op2, null, z2, null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1143715416, true, new DatePickerKt$MonthsNavigation$1$2$1(z4)), composer2, ((i3 >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i3 & 896), 26);
                IconButtonKt.IconButton(interfaceC3588op, null, z, null, null, ComposableLambdaKt.composableLambda(composer2, 1336532191, true, new DatePickerKt$MonthsNavigation$1$2$2(z4)), composer2, ((i3 >> 15) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i3 << 3) & 896), 26);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new C14922(modifier, z, z2, z3, str, interfaceC3588op, interfaceC3588op2, interfaceC3588op3, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SwitchableDateEntryContent(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1613036224);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(datePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerFormatter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1613036224, i3, -1, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1093)");
            }
            int iM1512getDisplayModejFl4v0 = datePickerState.m1512getDisplayModejFl4v0();
            CrossfadeKt.Crossfade(DisplayMode.m1529boximpl(iM1512getDisplayModejFl4v0), SemanticsModifierKt.semantics$default(Modifier.Companion, false, C14931.INSTANCE, 1, null), AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), (String) null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1854706084, true, new C14942(datePickerState, datePickerFormatter, interfaceC3750qp, datePickerColors, i3)), composerStartRestartGroup, 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14953(datePickerState, datePickerFormatter, interfaceC3750qp, datePickerColors, i));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void WeekDays(DatePickerColors datePickerColors, CalendarModel calendarModel, Composer composer, int i) {
        AbstractC4492zt.h(datePickerColors, "colors");
        AbstractC4492zt.h(calendarModel, "calendarModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1849465391);
        int i2 = (i & 14) == 0 ? (composerStartRestartGroup.changed(datePickerColors) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(calendarModel) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849465391, i, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1354)");
            }
            int firstDayOfWeek = calendarModel.getFirstDayOfWeek();
            List<C2020dG> weekdayNames = calendarModel.getWeekdayNames();
            ArrayList arrayList = new ArrayList();
            int i3 = firstDayOfWeek - 1;
            int size = weekdayNames.size();
            for (int i4 = i3; i4 < size; i4++) {
                arrayList.add(weekdayNames.get(i4));
            }
            for (int i5 = 0; i5 < i3; i5++) {
                arrayList.add(weekdayNames.get(i5));
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3022boximpl(datePickerColors.m1495getWeekdayContentColor0d7_KjU$material3_release()))}, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1445541615, true, new C14961(arrayList)), composerStartRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14972(datePickerColors, calendarModel, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void Year(Modifier modifier, boolean z, boolean z2, InterfaceC3588op interfaceC3588op, String str, DatePickerColors datePickerColors, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1441573940);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3588op) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 1048576 : 524288;
        }
        if ((2995931 & i2) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1441573940, i2, -1, "androidx.compose.material3.Year (DatePicker.kt:1716)");
            }
            Boolean boolValueOf = Boolean.valueOf(z2);
            Boolean boolValueOf2 = Boolean.valueOf(z);
            int i3 = i2 >> 6;
            int i4 = (i3 & 14) | (i2 & 112);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(boolValueOf2);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = (!z2 || z) ? null : BorderStrokeKt.m194BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.m2177getDateTodayContainerOutlineWidthD9Ej5fM(), datePickerColors.m1494getTodayDateBorderColor0d7_KjU$material3_release());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            BorderStroke borderStroke = (BorderStroke) objRememberedValue;
            int i5 = i2 >> 12;
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(str);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new DatePickerKt$Year$1$1(str);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            int i6 = (i2 >> 3) & 14;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m1851Surfaced85dljk(z, interfaceC3588op, SemanticsModifierKt.semantics(modifier, true, (InterfaceC3750qp) objRememberedValue2), false, ShapesKt.toShape(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), composerStartRestartGroup, 6), datePickerColors.yearContainerColor$material3_release(z, composerStartRestartGroup, i6 | (i5 & 112)).getValue().m3042unboximpl(), datePickerColors.yearContentColor$material3_release(z2, z, composerStartRestartGroup, i4 | ((i2 >> 9) & 896)).getValue().m3042unboximpl(), 0.0f, 0.0f, borderStroke, (MutableInteractionSource) null, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, -68753950, true, new C14982(interfaceC0526Fp, i2)), composer2, i6 | (i3 & 112), 48, 1416);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C14993(modifier, z, z2, interfaceC3588op, str, datePickerColors, interfaceC0526Fp, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void YearPicker(Modifier modifier, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, StateData stateData, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1038904873);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerColors) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(stateData) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1038904873, i3, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:1628)");
            }
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont()), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -145469688, true, new C15001(stateData, datePickerColors, modifier, interfaceC3750qp, i3)), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15012(modifier, interfaceC3750qp, datePickerColors, stateData, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x0067  */
    /* JADX WARN: Code duplicated, block: B:40:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0071  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void YearPickerMenuButton(InterfaceC3588op interfaceC3588op, boolean z, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(409654418);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(interfaceC3588op) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
                i3 |= i4;
            }
            i5 = i3;
            if ((i5 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(409654418, i5, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:1830)");
                }
                ButtonKt.TextButton(interfaceC3588op, modifier3, false, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m1367textButtonColorsro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1403getOnSurfaceVariant0d7_KjU(), 0L, 0L, composerStartRestartGroup, 24576, 13), null, null, null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1899012021, true, new C15021(interfaceC0526Fp, i5, z)), composerStartRestartGroup, 807075840 | (i5 & 14) | ((i5 >> 3) & 112), 388);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C15032(interfaceC3588op, z, modifier3, interfaceC0526Fp, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changedInstance(interfaceC0526Fp)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        i5 = i3;
        if ((i5 & 5851) == 1170) {
            if (i6 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(409654418, i5, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:1830)");
            }
            ButtonKt.TextButton(interfaceC3588op, modifier3, false, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m1367textButtonColorsro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1403getOnSurfaceVariant0d7_KjU(), 0L, 0L, composerStartRestartGroup, 24576, 13), null, null, null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1899012021, true, new C15021(interfaceC0526Fp, i5, z)), composerStartRestartGroup, 807075840 | (i5 & 14) | ((i5 >> 3) & 112), 388);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i6 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(409654418, i5, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:1830)");
            }
            ButtonKt.TextButton(interfaceC3588op, modifier3, false, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m1367textButtonColorsro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).m1403getOnSurfaceVariant0d7_KjU(), 0L, 0L, composerStartRestartGroup, 24576, 13), null, null, null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1899012021, true, new C15021(interfaceC0526Fp, i5, z)), composerStartRestartGroup, 807075840 | (i5 & 14) | ((i5 >> 3) & 112), 388);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15032(interfaceC3588op, z, modifier3, interfaceC0526Fp, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(LazyGridState lazyGridState, InterfaceC2052dg interfaceC2052dg, String str, String str2) {
        return AbstractC1886cc.p(new CustomAccessibilityAction(str, new DatePickerKt$customScrollActions$scrollUpAction$1(lazyGridState, interfaceC2052dg)), new CustomAccessibilityAction(str2, new DatePickerKt$customScrollActions$scrollDownAction$1(lazyGridState, interfaceC2052dg)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final String dayContentDescription(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Composer composer, int i) {
        composer.startReplaceableGroup(502032503);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502032503, i, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1538)");
        }
        StringBuilder sb = new StringBuilder();
        composer.startReplaceableGroup(-852204210);
        if (z) {
            if (z3) {
                composer.startReplaceableGroup(-852204120);
                sb.append(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1814getDateRangePickerStartHeadlineadMyvUU(), composer, 6));
                composer.endReplaceableGroup();
            } else if (z4) {
                composer.startReplaceableGroup(-852203980);
                sb.append(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1811getDateRangePickerEndHeadlineadMyvUU(), composer, 6));
                composer.endReplaceableGroup();
            } else if (z5) {
                composer.startReplaceableGroup(-852203842);
                sb.append(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1810getDateRangePickerDayInRangeadMyvUU(), composer, 6));
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-852203741);
                composer.endReplaceableGroup();
            }
        }
        composer.endReplaceableGroup();
        if (z2) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1806getDatePickerTodayDescriptionadMyvUU(), composer, 6));
        }
        String string = sb.length() == 0 ? null : sb.toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return string;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    @Composable
    @ExperimentalMaterial3Api
    /* JADX INFO: renamed from: rememberDatePickerState-NVmSL94, reason: not valid java name */
    public static final DatePickerState m1502rememberDatePickerStateNVmSL94(Long l, Long l2, C1001Vs c1001Vs, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(1574672255);
        if ((i3 & 1) != 0) {
            l = null;
        }
        if ((i3 & 2) != 0) {
            l2 = l;
        }
        if ((i3 & 4) != 0) {
            c1001Vs = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i3 & 8) != 0) {
            i = DisplayMode.Companion.m1537getPickerjFl4v0();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1574672255, i2, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:219)");
        }
        DatePickerState datePickerState = (DatePickerState) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) DatePickerState.Companion.Saver(), (String) null, (InterfaceC3588op) new DatePickerKt$rememberDatePickerState$1(l, l2, c1001Vs, i), composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return datePickerState;
    }

    public static final String toLocalString(int i) {
        NumberFormat integerInstance = NumberFormat.getIntegerInstance();
        integerInstance.setGroupingUsed(false);
        String str = integerInstance.format(Integer.valueOf(i));
        AbstractC4492zt.g(str, "formatter.format(this)");
        return str;
    }

    public static final Object updateDisplayedMonth(final LazyListState lazyListState, final StateData stateData, InterfaceC0793Of interfaceC0793Of) {
        Object objCollect = SnapshotStateKt.snapshotFlow(new C15042(lazyListState)).collect(new InterfaceC0995Vm() { // from class: androidx.compose.material3.DatePickerKt.updateDisplayedMonth.3
            @Override // defpackage.InterfaceC0995Vm
            public /* bridge */ /* synthetic */ Object emit(Object obj, InterfaceC0793Of interfaceC0793Of2) {
                return emit(((Number) obj).intValue(), interfaceC0793Of2);
            }

            public final Object emit(int i, InterfaceC0793Of interfaceC0793Of2) {
                int firstVisibleItemIndex = lazyListState.getFirstVisibleItemIndex() / 12;
                int firstVisibleItemIndex2 = (lazyListState.getFirstVisibleItemIndex() % 12) + 1;
                StateData stateData2 = stateData;
                if (stateData2.getDisplayedMonth().getMonth() != firstVisibleItemIndex2 || stateData2.getDisplayedMonth().getYear() != stateData2.getYearRange().b() + firstVisibleItemIndex) {
                    stateData2.setDisplayedMonth(stateData2.getCalendarModel().getMonth(stateData2.getYearRange().b() + firstVisibleItemIndex, firstVisibleItemIndex2));
                }
                return FW.a;
            }
        }, interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }
}
