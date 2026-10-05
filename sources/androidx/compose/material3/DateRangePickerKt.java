package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
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
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.PointerIconCompat;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC3675pv;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.C1172Zk;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC2052dg;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DateRangePickerKt {
    private static final PaddingValues DateRangePickerHeadlinePadding;
    private static final PaddingValues DateRangePickerTitlePadding;
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m482PaddingValuesa9UjIt4$default(Dp.m5160constructorimpl(24), Dp.m5160constructorimpl(20), 0.0f, Dp.m5160constructorimpl(8), 4, null);
    private static final float HeaderHeightOffset = Dp.m5160constructorimpl(60);

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePicker$2, reason: invalid class name */
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

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePicker$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DateRangePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(DateRangePickerState dateRangePickerState, int i) {
            super(2);
            this.$state = dateRangePickerState;
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
                ComposerKt.traceEventStart(492752701, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:89)");
            }
            DateRangePickerDefaults.INSTANCE.DateRangePickerTitle(this.$state, PaddingKt.padding(Modifier.Companion, DateRangePickerKt.DateRangePickerTitlePadding), composer, (this.$$dirty & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ DateRangePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, int i) {
            super(2);
            this.$state = dateRangePickerState;
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
                ComposerKt.traceEventStart(-204181785, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:95)");
            }
            DateRangePickerDefaults dateRangePickerDefaults = DateRangePickerDefaults.INSTANCE;
            DateRangePickerState dateRangePickerState = this.$state;
            DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            Modifier modifierPadding = PaddingKt.padding(Modifier.Companion, DateRangePickerKt.DateRangePickerHeadlinePadding);
            int i2 = this.$$dirty;
            dateRangePickerDefaults.DateRangePickerHeadline(dateRangePickerState, datePickerFormatter, modifierPadding, composer, (i2 & 14) | 3456 | ((i2 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DateRangePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(DateRangePickerState dateRangePickerState, int i) {
            super(2);
            this.$state = dateRangePickerState;
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
                ComposerKt.traceEventStart(-1062265737, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:110)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.Companion, DatePickerKt.getDatePickerModeTogglePadding());
            int iM1519getDisplayModejFl4v0 = this.$state.m1519getDisplayModejFl4v0();
            DateRangePickerState dateRangePickerState = this.$state;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(dateRangePickerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new DateRangePickerKt$DateRangePicker$5$1$1(dateRangePickerState);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            DatePickerKt.m1501DisplayModeToggleButtontER2X8s(modifierPadding, iM1519getDisplayModejFl4v0, (InterfaceC3750qp) objRememberedValue, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePicker$6, reason: invalid class name */
    public static final class AnonymousClass6 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ DateRangePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, int i) {
            super(2);
            this.$state = dateRangePickerState;
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
                ComposerKt.traceEventStart(-186850856, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:130)");
            }
            DateRangePickerState dateRangePickerState = this.$state;
            DatePickerFormatter datePickerFormatter = this.$dateFormatter;
            InterfaceC3750qp interfaceC3750qp = this.$dateValidator;
            DatePickerColors datePickerColors = this.$colors;
            int i2 = this.$$dirty;
            DateRangePickerKt.SwitchableDateEntryContent(dateRangePickerState, datePickerFormatter, interfaceC3750qp, datePickerColors, composer, (i2 & 14) | ((i2 >> 3) & 112) | ((i2 >> 3) & 896) | ((i2 >> 12) & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePicker$7, reason: invalid class name */
    public static final class AnonymousClass7 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ InterfaceC0526Fp $headline;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ boolean $showModeToggle;
        final /* synthetic */ DateRangePickerState $state;
        final /* synthetic */ InterfaceC0526Fp $title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass7(DateRangePickerState dateRangePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, boolean z, DatePickerColors datePickerColors, int i, int i2) {
            super(2);
            this.$state = dateRangePickerState;
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
            DateRangePickerKt.DateRangePicker(this.$state, this.$modifier, this.$dateFormatter, this.$dateValidator, this.$title, this.$headline, this.$showModeToggle, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$DateRangePickerContent$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15072 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ StateData $stateData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15072(StateData stateData, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, int i) {
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
            DateRangePickerKt.DateRangePickerContent(this.$stateData, this.$dateFormatter, this.$dateValidator, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
            SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$2, reason: invalid class name and case insensitive filesystem */
    public static final class C15082 extends AbstractC2233fv implements InterfaceC0552Gp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ DateRangePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15082(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, int i) {
            super(3);
            this.$state = dateRangePickerState;
            this.$dateFormatter = datePickerFormatter;
            this.$dateValidator = interfaceC3750qp;
            this.$colors = datePickerColors;
            this.$$dirty = i;
        }

        @Override // defpackage.InterfaceC0552Gp
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            m1517invokeQujVXRc(((DisplayMode) obj).m1535unboximpl(), (Composer) obj2, ((Number) obj3).intValue());
            return FW.a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        /* JADX INFO: renamed from: invoke-QujVXRc, reason: not valid java name */
        public final void m1517invokeQujVXRc(int i, Composer composer, int i2) {
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
                ComposerKt.traceEventStart(1354418636, i2, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:458)");
            }
            DisplayMode.Companion companion = DisplayMode.Companion;
            if (DisplayMode.m1532equalsimpl0(i, companion.m1537getPickerjFl4v0())) {
                composer.startReplaceableGroup(-1168754929);
                DateRangePickerKt.DateRangePickerContent(this.$state.getStateData$material3_release(), this.$dateFormatter, this.$dateValidator, this.$colors, composer, this.$$dirty & 8176);
                composer.endReplaceableGroup();
            } else if (DisplayMode.m1532equalsimpl0(i, companion.m1536getInputjFl4v0())) {
                composer.startReplaceableGroup(-1168754686);
                DateRangeInputKt.DateRangeInputContent(this.$state.getStateData$material3_release(), this.$dateFormatter, this.$dateValidator, composer, this.$$dirty & PointerIconCompat.TYPE_TEXT);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1168754501);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$3, reason: invalid class name and case insensitive filesystem */
    public static final class C15093 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ DateRangePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15093(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, int i) {
            super(2);
            this.$state = dateRangePickerState;
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
            DateRangePickerKt.SwitchableDateEntryContent(this.$state, this.$dateFormatter, this.$dateValidator, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15101 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ CalendarMonth $firstMonth;
        final /* synthetic */ LazyListState $lazyListState;
        final /* synthetic */ InterfaceC3750qp $onDateSelected;
        final /* synthetic */ StateData $stateData;
        final /* synthetic */ CalendarDate $today;

        /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01081 extends AbstractC2233fv implements InterfaceC3750qp {
            public static final C01081 INSTANCE = new C01081();

            /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01091 extends AbstractC2233fv implements InterfaceC3588op {
                public static final C01091 INSTANCE = new C01091();

                public C01091() {
                    super(0);
                }

                @Override // defpackage.InterfaceC3588op
                public final Float invoke() {
                    return Float.valueOf(0.0f);
                }
            }

            /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$1$2, reason: invalid class name */
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

            public C01081() {
                super(1);
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return FW.a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                AbstractC4492zt.h(semanticsPropertyReceiver, "$this$semantics");
                SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(C01091.INSTANCE, AnonymousClass2.INSTANCE, false, 4, null));
            }
        }

        /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC3750qp {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ DatePickerColors $colors;
            final /* synthetic */ InterfaceC2052dg $coroutineScope;
            final /* synthetic */ DatePickerFormatter $dateFormatter;
            final /* synthetic */ InterfaceC3750qp $dateValidator;
            final /* synthetic */ CalendarMonth $firstMonth;
            final /* synthetic */ LazyListState $lazyListState;
            final /* synthetic */ InterfaceC3750qp $onDateSelected;
            final /* synthetic */ String $scrollToNextMonthLabel;
            final /* synthetic */ String $scrollToPreviousMonthLabel;
            final /* synthetic */ StateData $stateData;
            final /* synthetic */ CalendarDate $today;

            /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01101 extends AbstractC2233fv implements InterfaceC0578Hp {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ DatePickerColors $colors;
                final /* synthetic */ InterfaceC2052dg $coroutineScope;
                final /* synthetic */ DatePickerFormatter $dateFormatter;
                final /* synthetic */ InterfaceC3750qp $dateValidator;
                final /* synthetic */ CalendarMonth $firstMonth;
                final /* synthetic */ LazyListState $lazyListState;
                final /* synthetic */ InterfaceC3750qp $onDateSelected;
                final /* synthetic */ String $scrollToNextMonthLabel;
                final /* synthetic */ String $scrollToPreviousMonthLabel;
                final /* synthetic */ StateData $stateData;
                final /* synthetic */ CalendarDate $today;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01101(StateData stateData, CalendarMonth calendarMonth, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, InterfaceC3750qp interfaceC3750qp, CalendarDate calendarDate, InterfaceC3750qp interfaceC3750qp2, int i, LazyListState lazyListState, InterfaceC2052dg interfaceC2052dg, String str, String str2) {
                    super(4);
                    this.$stateData = stateData;
                    this.$firstMonth = calendarMonth;
                    this.$dateFormatter = datePickerFormatter;
                    this.$colors = datePickerColors;
                    this.$onDateSelected = interfaceC3750qp;
                    this.$today = calendarDate;
                    this.$dateValidator = interfaceC3750qp2;
                    this.$$dirty = i;
                    this.$lazyListState = lazyListState;
                    this.$coroutineScope = interfaceC2052dg;
                    this.$scrollToPreviousMonthLabel = str;
                    this.$scrollToNextMonthLabel = str2;
                }

                @Override // defpackage.InterfaceC0578Hp
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return FW.a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                    int i3;
                    AbstractC4492zt.h(lazyItemScope, "$this$items");
                    if ((i2 & 14) == 0) {
                        i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                    } else {
                        i3 = i2;
                    }
                    if ((i2 & 112) == 0) {
                        i3 |= composer.changed(i) ? 32 : 16;
                    }
                    if ((i3 & 731) == 146 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1246706073, i2, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:542)");
                    }
                    CalendarMonth calendarMonthPlusMonths = this.$stateData.getCalendarModel().plusMonths(this.$firstMonth, i);
                    Modifier.Companion companion = Modifier.Companion;
                    Modifier modifierD = AbstractC3675pv.d(lazyItemScope, companion, 0.0f, 1, null);
                    DatePickerFormatter datePickerFormatter = this.$dateFormatter;
                    StateData stateData = this.$stateData;
                    DatePickerColors datePickerColors = this.$colors;
                    InterfaceC3750qp interfaceC3750qp = this.$onDateSelected;
                    CalendarDate calendarDate = this.$today;
                    InterfaceC3750qp interfaceC3750qp2 = this.$dateValidator;
                    int i4 = this.$$dirty;
                    LazyListState lazyListState = this.$lazyListState;
                    InterfaceC2052dg interfaceC2052dg = this.$coroutineScope;
                    String str = this.$scrollToPreviousMonthLabel;
                    String str2 = this.$scrollToNextMonthLabel;
                    composer.startReplaceableGroup(-483455358);
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
                    composer.startReplaceableGroup(-1323940314);
                    Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                    InterfaceC3588op constructor = companion2.getConstructor();
                    InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierD);
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
                    Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyColumnMeasurePolicy, companion2.getSetMeasurePolicy());
                    Updater.m2668setimpl(composerM2661constructorimpl, density, companion2.getSetDensity());
                    Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                    Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                    composer.enableReusing();
                    interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composer)), composer, 0);
                    composer.startReplaceableGroup(2058660585);
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    String monthYear$material3_release = datePickerFormatter.formatMonthYear$material3_release(calendarMonthPlusMonths, stateData.getCalendarModel(), CalendarModel_androidKt.defaultLocale(composer, 0));
                    if (monthYear$material3_release == null) {
                        monthYear$material3_release = "-";
                    }
                    TextKt.m1930Text4IGK_g(monthYear$material3_release, SemanticsModifierKt.semantics$default(ClickableKt.m200clickableXHw0xAI$default(PaddingKt.padding(companion, DateRangePickerKt.getCalendarMonthSubheadPadding()), false, null, null, DateRangePickerKt$VerticalMonthsList$1$2$1$1$1.INSTANCE, 7, null), false, new DateRangePickerKt$VerticalMonthsList$1$2$1$1$2(lazyListState, interfaceC2052dg, str, str2), 1, null), datePickerColors.m1492getSubheadContentColor0d7_KjU$material3_release(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composer, 0, 0, 131064);
                    int i5 = i4 << 3;
                    int i6 = i4 << 6;
                    DatePickerKt.Month(calendarMonthPlusMonths, interfaceC3750qp, calendarDate, stateData, true, interfaceC3750qp2, datePickerFormatter, datePickerColors, composer, ((i4 << 9) & 3670016) | (i5 & 458752) | (i5 & 112) | 24576 | (i6 & 7168) | (29360128 & i6));
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
            public AnonymousClass2(StateData stateData, CalendarMonth calendarMonth, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, InterfaceC3750qp interfaceC3750qp, CalendarDate calendarDate, InterfaceC3750qp interfaceC3750qp2, int i, LazyListState lazyListState, InterfaceC2052dg interfaceC2052dg, String str, String str2) {
                super(1);
                this.$stateData = stateData;
                this.$firstMonth = calendarMonth;
                this.$dateFormatter = datePickerFormatter;
                this.$colors = datePickerColors;
                this.$onDateSelected = interfaceC3750qp;
                this.$today = calendarDate;
                this.$dateValidator = interfaceC3750qp2;
                this.$$dirty = i;
                this.$lazyListState = lazyListState;
                this.$coroutineScope = interfaceC2052dg;
                this.$scrollToPreviousMonthLabel = str;
                this.$scrollToNextMonthLabel = str2;
            }

            @Override // defpackage.InterfaceC3750qp
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LazyListScope) obj);
                return FW.a;
            }

            public final void invoke(LazyListScope lazyListScope) {
                AbstractC4492zt.h(lazyListScope, "$this$LazyColumn");
                LazyListScope.CC.k(lazyListScope, this.$stateData.getTotalMonthsInRange(), null, null, ComposableLambdaKt.composableLambdaInstance(1246706073, true, new C01101(this.$stateData, this.$firstMonth, this.$dateFormatter, this.$colors, this.$onDateSelected, this.$today, this.$dateValidator, this.$$dirty, this.$lazyListState, this.$coroutineScope, this.$scrollToPreviousMonthLabel, this.$scrollToNextMonthLabel)), 6, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15101(LazyListState lazyListState, int i, StateData stateData, CalendarMonth calendarMonth, DatePickerFormatter datePickerFormatter, DatePickerColors datePickerColors, InterfaceC3750qp interfaceC3750qp, CalendarDate calendarDate, InterfaceC3750qp interfaceC3750qp2) {
            super(2);
            this.$lazyListState = lazyListState;
            this.$$dirty = i;
            this.$stateData = stateData;
            this.$firstMonth = calendarMonth;
            this.$dateFormatter = datePickerFormatter;
            this.$colors = datePickerColors;
            this.$onDateSelected = interfaceC3750qp;
            this.$today = calendarDate;
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
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(56792252, i, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:530)");
            }
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
            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(companion.m1813getDateRangePickerScrollToShowPreviousMonthadMyvUU(), composer, 6);
            String strM1841getStringNWtq29 = Strings_androidKt.m1841getStringNWtq28(companion.m1812getDateRangePickerScrollToShowNextMonthadMyvUU(), composer, 6);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, C01081.INSTANCE, 1, null);
            LazyListState lazyListState = this.$lazyListState;
            LazyDslKt.LazyColumn(modifierSemantics$default, lazyListState, null, false, null, null, null, false, new AnonymousClass2(this.$stateData, this.$firstMonth, this.$dateFormatter, this.$colors, this.$onDateSelected, this.$today, this.$dateValidator, this.$$dirty, lazyListState, coroutineScope, strM1841getStringNWtq28, strM1841getStringNWtq29), composer, (this.$$dirty >> 3) & 112, 252);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$3, reason: invalid class name and case insensitive filesystem */
    public static final class C15113 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ LazyListState $lazyListState;
        final /* synthetic */ InterfaceC3750qp $onDateSelected;
        final /* synthetic */ StateData $stateData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15113(InterfaceC3750qp interfaceC3750qp, StateData stateData, LazyListState lazyListState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp2, DatePickerColors datePickerColors, int i) {
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
            DateRangePickerKt.VerticalMonthsList(this.$onDateSelected, this.$stateData, this.$lazyListState, this.$dateFormatter, this.$dateValidator, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    static {
        float f = 64;
        float f2 = 12;
        DateRangePickerTitlePadding = PaddingKt.m482PaddingValuesa9UjIt4$default(Dp.m5160constructorimpl(f), 0.0f, Dp.m5160constructorimpl(f2), 0.0f, 10, null);
        DateRangePickerHeadlinePadding = PaddingKt.m482PaddingValuesa9UjIt4$default(Dp.m5160constructorimpl(f), 0.0f, Dp.m5160constructorimpl(f2), Dp.m5160constructorimpl(f2), 2, null);
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
    /* JADX WARN: Code duplicated, block: B:138:0x025b  */
    /* JADX WARN: Code duplicated, block: B:143:0x0269  */
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
    public static final void DateRangePicker(DateRangePickerState dateRangePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, boolean z, DatePickerColors datePickerColors, Composer composer, int i, int i2) {
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
        AbstractC4492zt.h(dateRangePickerState, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1835392055);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(dateRangePickerState) ? 4 : 2) | i;
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
                                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                    } else {
                                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                    }
                                    if (i10 != 0) {
                                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                                    }
                                    if (z2) {
                                        z3 = true;
                                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                                    } else {
                                        z3 = true;
                                        composableLambda = null;
                                    }
                                    ComposableLambda composableLambda2 = composableLambda;
                                    Typography typography = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                                    DatePickerModalTokens datePickerModalTokens = DatePickerModalTokens.INSTANCE;
                                    TextStyle textStyleFromToken = TypographyKt.fromToken(typography, datePickerModalTokens.getRangeSelectionHeaderHeadlineFont());
                                    float fM5160constructorimpl = Dp.m5160constructorimpl(datePickerModalTokens.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                                    ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                                    int i16 = ((i14 >> 3) & 14) | 14155776;
                                    int i17 = i14 >> 9;
                                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda2, datePickerColorsM1496colors1m2CgY, textStyleFromToken, fM5160constructorimpl, composableLambda3, composerStartRestartGroup, i16 | (i17 & 112) | (i17 & 896) | (i17 & 57344));
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
                                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                                }
                                if (z2) {
                                    z3 = true;
                                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                                } else {
                                    z3 = true;
                                    composableLambda = null;
                                }
                                ComposableLambda composableLambda4 = composableLambda;
                                Typography typography2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                                DatePickerModalTokens datePickerModalTokens2 = DatePickerModalTokens.INSTANCE;
                                TextStyle textStyleFromToken2 = TypographyKt.fromToken(typography2, datePickerModalTokens2.getRangeSelectionHeaderHeadlineFont());
                                float fM5160constructorimpl2 = Dp.m5160constructorimpl(datePickerModalTokens2.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                                int i18 = ((i14 >> 3) & 14) | 14155776;
                                int i19 = i14 >> 9;
                                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda4, datePickerColorsM1496colors1m2CgY, textStyleFromToken2, fM5160constructorimpl2, composableLambda5, composerStartRestartGroup, i18 | (i19 & 112) | (i19 & 896) | (i19 & 57344));
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
                            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda6 = composableLambda;
                            Typography typography3 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens3 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken3 = TypographyKt.fromToken(typography3, datePickerModalTokens3.getRangeSelectionHeaderHeadlineFont());
                            float fM5160constructorimpl3 = Dp.m5160constructorimpl(datePickerModalTokens3.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            ComposableLambda composableLambda7 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i110 = ((i14 >> 3) & 14) | 14155776;
                            int i111 = i14 >> 9;
                            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda6, datePickerColorsM1496colors1m2CgY, textStyleFromToken3, fM5160constructorimpl3, composableLambda7, composerStartRestartGroup, i110 | (i111 & 112) | (i111 & 896) | (i111 & 57344));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda8 = composableLambda;
                            Typography typography4 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens4 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken4 = TypographyKt.fromToken(typography4, datePickerModalTokens4.getRangeSelectionHeaderHeadlineFont());
                            float fM5160constructorimpl4 = Dp.m5160constructorimpl(datePickerModalTokens4.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            ComposableLambda composableLambda9 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i112 = ((i14 >> 3) & 14) | 14155776;
                            int i113 = i14 >> 9;
                            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda8, datePickerColorsM1496colors1m2CgY, textStyleFromToken4, fM5160constructorimpl4, composableLambda9, composerStartRestartGroup, i112 | (i113 & 112) | (i113 & 896) | (i113 & 57344));
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda10 = composableLambda;
                            Typography typography5 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens5 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken5 = TypographyKt.fromToken(typography5, datePickerModalTokens5.getRangeSelectionHeaderHeadlineFont());
                            float fM5160constructorimpl5 = Dp.m5160constructorimpl(datePickerModalTokens5.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            ComposableLambda composableLambda11 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i114 = ((i14 >> 3) & 14) | 14155776;
                            int i115 = i14 >> 9;
                            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda10, datePickerColorsM1496colors1m2CgY, textStyleFromToken5, fM5160constructorimpl5, composableLambda11, composerStartRestartGroup, i114 | (i115 & 112) | (i115 & 896) | (i115 & 57344));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda12 = composableLambda;
                            Typography typography6 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens6 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken6 = TypographyKt.fromToken(typography6, datePickerModalTokens6.getRangeSelectionHeaderHeadlineFont());
                            float fM5160constructorimpl6 = Dp.m5160constructorimpl(datePickerModalTokens6.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            ComposableLambda composableLambda13 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i116 = ((i14 >> 3) & 14) | 14155776;
                            int i117 = i14 >> 9;
                            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda12, datePickerColorsM1496colors1m2CgY, textStyleFromToken6, fM5160constructorimpl6, composableLambda13, composerStartRestartGroup, i116 | (i117 & 112) | (i117 & 896) | (i117 & 57344));
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda14 = composableLambda;
                        Typography typography7 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens7 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken7 = TypographyKt.fromToken(typography7, datePickerModalTokens7.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl7 = Dp.m5160constructorimpl(datePickerModalTokens7.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda15 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i118 = ((i14 >> 3) & 14) | 14155776;
                        int i119 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda14, datePickerColorsM1496colors1m2CgY, textStyleFromToken7, fM5160constructorimpl7, composableLambda15, composerStartRestartGroup, i118 | (i119 & 112) | (i119 & 896) | (i119 & 57344));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda16 = composableLambda;
                        Typography typography8 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens8 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken8 = TypographyKt.fromToken(typography8, datePickerModalTokens8.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl8 = Dp.m5160constructorimpl(datePickerModalTokens8.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda17 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1110 = ((i14 >> 3) & 14) | 14155776;
                        int i1111 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda16, datePickerColorsM1496colors1m2CgY, textStyleFromToken8, fM5160constructorimpl8, composableLambda17, composerStartRestartGroup, i1110 | (i1111 & 112) | (i1111 & 896) | (i1111 & 57344));
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda18 = composableLambda;
                            Typography typography9 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens9 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken9 = TypographyKt.fromToken(typography9, datePickerModalTokens9.getRangeSelectionHeaderHeadlineFont());
                            float fM5160constructorimpl9 = Dp.m5160constructorimpl(datePickerModalTokens9.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            ComposableLambda composableLambda19 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i1112 = ((i14 >> 3) & 14) | 14155776;
                            int i1113 = i14 >> 9;
                            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda18, datePickerColorsM1496colors1m2CgY, textStyleFromToken9, fM5160constructorimpl9, composableLambda19, composerStartRestartGroup, i1112 | (i1113 & 112) | (i1113 & 896) | (i1113 & 57344));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda110 = composableLambda;
                            Typography typography10 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens10 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken10 = TypographyKt.fromToken(typography10, datePickerModalTokens10.getRangeSelectionHeaderHeadlineFont());
                            float fM5160constructorimpl10 = Dp.m5160constructorimpl(datePickerModalTokens10.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            ComposableLambda composableLambda111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i1114 = ((i14 >> 3) & 14) | 14155776;
                            int i1115 = i14 >> 9;
                            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda110, datePickerColorsM1496colors1m2CgY, textStyleFromToken10, fM5160constructorimpl10, composableLambda111, composerStartRestartGroup, i1114 | (i1115 & 112) | (i1115 & 896) | (i1115 & 57344));
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda112 = composableLambda;
                        Typography typography11 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens11 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken11 = TypographyKt.fromToken(typography11, datePickerModalTokens11.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl11 = Dp.m5160constructorimpl(datePickerModalTokens11.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1116 = ((i14 >> 3) & 14) | 14155776;
                        int i1117 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda112, datePickerColorsM1496colors1m2CgY, textStyleFromToken11, fM5160constructorimpl11, composableLambda113, composerStartRestartGroup, i1116 | (i1117 & 112) | (i1117 & 896) | (i1117 & 57344));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda114 = composableLambda;
                        Typography typography12 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens12 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken12 = TypographyKt.fromToken(typography12, datePickerModalTokens12.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl12 = Dp.m5160constructorimpl(datePickerModalTokens12.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1118 = ((i14 >> 3) & 14) | 14155776;
                        int i1119 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda114, datePickerColorsM1496colors1m2CgY, textStyleFromToken12, fM5160constructorimpl12, composableLambda115, composerStartRestartGroup, i1118 | (i1119 & 112) | (i1119 & 896) | (i1119 & 57344));
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda116 = composableLambda;
                        Typography typography13 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens13 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken13 = TypographyKt.fromToken(typography13, datePickerModalTokens13.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl13 = Dp.m5160constructorimpl(datePickerModalTokens13.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i11110 = ((i14 >> 3) & 14) | 14155776;
                        int i11111 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda116, datePickerColorsM1496colors1m2CgY, textStyleFromToken13, fM5160constructorimpl13, composableLambda117, composerStartRestartGroup, i11110 | (i11111 & 112) | (i11111 & 896) | (i11111 & 57344));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda118 = composableLambda;
                        Typography typography14 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens14 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken14 = TypographyKt.fromToken(typography14, datePickerModalTokens14.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl14 = Dp.m5160constructorimpl(datePickerModalTokens14.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i11112 = ((i14 >> 3) & 14) | 14155776;
                        int i11113 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda118, datePickerColorsM1496colors1m2CgY, textStyleFromToken14, fM5160constructorimpl14, composableLambda119, composerStartRestartGroup, i11112 | (i11113 & 112) | (i11113 & 896) | (i11113 & 57344));
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda1110 = composableLambda;
                    Typography typography15 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens15 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken15 = TypographyKt.fromToken(typography15, datePickerModalTokens15.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl15 = Dp.m5160constructorimpl(datePickerModalTokens15.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda1111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11114 = ((i14 >> 3) & 14) | 14155776;
                    int i11115 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1110, datePickerColorsM1496colors1m2CgY, textStyleFromToken15, fM5160constructorimpl15, composableLambda1111, composerStartRestartGroup, i11114 | (i11115 & 112) | (i11115 & 896) | (i11115 & 57344));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda1112 = composableLambda;
                    Typography typography16 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens16 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken16 = TypographyKt.fromToken(typography16, datePickerModalTokens16.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl16 = Dp.m5160constructorimpl(datePickerModalTokens16.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda1113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11116 = ((i14 >> 3) & 14) | 14155776;
                    int i11117 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1112, datePickerColorsM1496colors1m2CgY, textStyleFromToken16, fM5160constructorimpl16, composableLambda1113, composerStartRestartGroup, i11116 | (i11117 & 112) | (i11117 & 896) | (i11117 & 57344));
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
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda1114 = composableLambda;
                            Typography typography17 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens17 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken17 = TypographyKt.fromToken(typography17, datePickerModalTokens17.getRangeSelectionHeaderHeadlineFont());
                            float fM5160constructorimpl17 = Dp.m5160constructorimpl(datePickerModalTokens17.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            ComposableLambda composableLambda1115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i11118 = ((i14 >> 3) & 14) | 14155776;
                            int i11119 = i14 >> 9;
                            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1114, datePickerColorsM1496colors1m2CgY, textStyleFromToken17, fM5160constructorimpl17, composableLambda1115, composerStartRestartGroup, i11118 | (i11119 & 112) | (i11119 & 896) | (i11119 & 57344));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda1116 = composableLambda;
                            Typography typography18 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens18 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken18 = TypographyKt.fromToken(typography18, datePickerModalTokens18.getRangeSelectionHeaderHeadlineFont());
                            float fM5160constructorimpl18 = Dp.m5160constructorimpl(datePickerModalTokens18.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            ComposableLambda composableLambda1117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i111110 = ((i14 >> 3) & 14) | 14155776;
                            int i111111 = i14 >> 9;
                            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1116, datePickerColorsM1496colors1m2CgY, textStyleFromToken18, fM5160constructorimpl18, composableLambda1117, composerStartRestartGroup, i111110 | (i111111 & 112) | (i111111 & 896) | (i111111 & 57344));
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda1118 = composableLambda;
                        Typography typography19 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens19 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken19 = TypographyKt.fromToken(typography19, datePickerModalTokens19.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl19 = Dp.m5160constructorimpl(datePickerModalTokens19.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda1119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111112 = ((i14 >> 3) & 14) | 14155776;
                        int i111113 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1118, datePickerColorsM1496colors1m2CgY, textStyleFromToken19, fM5160constructorimpl19, composableLambda1119, composerStartRestartGroup, i111112 | (i111113 & 112) | (i111113 & 896) | (i111113 & 57344));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11110 = composableLambda;
                        Typography typography110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens110 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken110 = TypographyKt.fromToken(typography110, datePickerModalTokens110.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl110 = Dp.m5160constructorimpl(datePickerModalTokens110.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda11111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111114 = ((i14 >> 3) & 14) | 14155776;
                        int i111115 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11110, datePickerColorsM1496colors1m2CgY, textStyleFromToken110, fM5160constructorimpl110, composableLambda11111, composerStartRestartGroup, i111114 | (i111115 & 112) | (i111115 & 896) | (i111115 & 57344));
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11112 = composableLambda;
                        Typography typography111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens111 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken111 = TypographyKt.fromToken(typography111, datePickerModalTokens111.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl111 = Dp.m5160constructorimpl(datePickerModalTokens111.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda11113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111116 = ((i14 >> 3) & 14) | 14155776;
                        int i111117 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11112, datePickerColorsM1496colors1m2CgY, textStyleFromToken111, fM5160constructorimpl111, composableLambda11113, composerStartRestartGroup, i111116 | (i111117 & 112) | (i111117 & 896) | (i111117 & 57344));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11114 = composableLambda;
                        Typography typography112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens112 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken112 = TypographyKt.fromToken(typography112, datePickerModalTokens112.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl112 = Dp.m5160constructorimpl(datePickerModalTokens112.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda11115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111118 = ((i14 >> 3) & 14) | 14155776;
                        int i111119 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11114, datePickerColorsM1496colors1m2CgY, textStyleFromToken112, fM5160constructorimpl112, composableLambda11115, composerStartRestartGroup, i111118 | (i111119 & 112) | (i111119 & 896) | (i111119 & 57344));
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11116 = composableLambda;
                    Typography typography113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens113 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken113 = TypographyKt.fromToken(typography113, datePickerModalTokens113.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl113 = Dp.m5160constructorimpl(datePickerModalTokens113.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda11117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111110 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11116, datePickerColorsM1496colors1m2CgY, textStyleFromToken113, fM5160constructorimpl113, composableLambda11117, composerStartRestartGroup, i1111110 | (i1111111 & 112) | (i1111111 & 896) | (i1111111 & 57344));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11118 = composableLambda;
                    Typography typography114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens114 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken114 = TypographyKt.fromToken(typography114, datePickerModalTokens114.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl114 = Dp.m5160constructorimpl(datePickerModalTokens114.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda11119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111112 = ((i14 >> 3) & 14) | 14155776;
                    int i1111113 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11118, datePickerColorsM1496colors1m2CgY, textStyleFromToken114, fM5160constructorimpl114, composableLambda11119, composerStartRestartGroup, i1111112 | (i1111113 & 112) | (i1111113 & 896) | (i1111113 & 57344));
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
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda111110 = composableLambda;
                        Typography typography115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens115 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken115 = TypographyKt.fromToken(typography115, datePickerModalTokens115.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl115 = Dp.m5160constructorimpl(datePickerModalTokens115.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1111114 = ((i14 >> 3) & 14) | 14155776;
                        int i1111115 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken115, fM5160constructorimpl115, composableLambda111111, composerStartRestartGroup, i1111114 | (i1111115 & 112) | (i1111115 & 896) | (i1111115 & 57344));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda111112 = composableLambda;
                        Typography typography116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens116 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken116 = TypographyKt.fromToken(typography116, datePickerModalTokens116.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl116 = Dp.m5160constructorimpl(datePickerModalTokens116.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1111116 = ((i14 >> 3) & 14) | 14155776;
                        int i1111117 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken116, fM5160constructorimpl116, composableLambda111113, composerStartRestartGroup, i1111116 | (i1111117 & 112) | (i1111117 & 896) | (i1111117 & 57344));
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111114 = composableLambda;
                    Typography typography117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens117 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken117 = TypographyKt.fromToken(typography117, datePickerModalTokens117.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl117 = Dp.m5160constructorimpl(datePickerModalTokens117.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111118 = ((i14 >> 3) & 14) | 14155776;
                    int i1111119 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken117, fM5160constructorimpl117, composableLambda111115, composerStartRestartGroup, i1111118 | (i1111119 & 112) | (i1111119 & 896) | (i1111119 & 57344));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111116 = composableLambda;
                    Typography typography118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens118 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken118 = TypographyKt.fromToken(typography118, datePickerModalTokens118.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl118 = Dp.m5160constructorimpl(datePickerModalTokens118.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111110 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken118, fM5160constructorimpl118, composableLambda111117, composerStartRestartGroup, i11111110 | (i11111111 & 112) | (i11111111 & 896) | (i11111111 & 57344));
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
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111118 = composableLambda;
                    Typography typography119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens119 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken119 = TypographyKt.fromToken(typography119, datePickerModalTokens119.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl119 = Dp.m5160constructorimpl(datePickerModalTokens119.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111112 = ((i14 >> 3) & 14) | 14155776;
                    int i11111113 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken119, fM5160constructorimpl119, composableLambda111119, composerStartRestartGroup, i11111112 | (i11111113 & 112) | (i11111113 & 896) | (i11111113 & 57344));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda1111110 = composableLambda;
                    Typography typography1110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens1110 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken1110 = TypographyKt.fromToken(typography1110, datePickerModalTokens1110.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl1110 = Dp.m5160constructorimpl(datePickerModalTokens1110.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda1111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111114 = ((i14 >> 3) & 14) | 14155776;
                    int i11111115 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken1110, fM5160constructorimpl1110, composableLambda1111111, composerStartRestartGroup, i11111114 | (i11111115 & 112) | (i11111115 & 896) | (i11111115 & 57344));
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
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111112 = composableLambda;
                Typography typography1111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens1111 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken1111 = TypographyKt.fromToken(typography1111, datePickerModalTokens1111.getRangeSelectionHeaderHeadlineFont());
                float fM5160constructorimpl1111 = Dp.m5160constructorimpl(datePickerModalTokens1111.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                ComposableLambda composableLambda1111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111116 = ((i14 >> 3) & 14) | 14155776;
                int i11111117 = i14 >> 9;
                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111, fM5160constructorimpl1111, composableLambda1111113, composerStartRestartGroup, i11111116 | (i11111117 & 112) | (i11111117 & 896) | (i11111117 & 57344));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111114 = composableLambda;
                Typography typography1112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens1112 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken1112 = TypographyKt.fromToken(typography1112, datePickerModalTokens1112.getRangeSelectionHeaderHeadlineFont());
                float fM5160constructorimpl1112 = Dp.m5160constructorimpl(datePickerModalTokens1112.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                ComposableLambda composableLambda1111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111118 = ((i14 >> 3) & 14) | 14155776;
                int i11111119 = i14 >> 9;
                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken1112, fM5160constructorimpl1112, composableLambda1111115, composerStartRestartGroup, i11111118 | (i11111119 & 112) | (i11111119 & 896) | (i11111119 & 57344));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda1111116 = composableLambda;
                            Typography typography1113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens1113 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken1113 = TypographyKt.fromToken(typography1113, datePickerModalTokens1113.getRangeSelectionHeaderHeadlineFont());
                            float fM5160constructorimpl1113 = Dp.m5160constructorimpl(datePickerModalTokens1113.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            ComposableLambda composableLambda1111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i111111110 = ((i14 >> 3) & 14) | 14155776;
                            int i111111111 = i14 >> 9;
                            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken1113, fM5160constructorimpl1113, composableLambda1111117, composerStartRestartGroup, i111111110 | (i111111111 & 112) | (i111111111 & 896) | (i111111111 & 57344));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                                } else {
                                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                                }
                                if (i10 != 0) {
                                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                            }
                            if (z2) {
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                            } else {
                                z3 = true;
                                composableLambda = null;
                            }
                            ComposableLambda composableLambda1111118 = composableLambda;
                            Typography typography1114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                            DatePickerModalTokens datePickerModalTokens1114 = DatePickerModalTokens.INSTANCE;
                            TextStyle textStyleFromToken1114 = TypographyKt.fromToken(typography1114, datePickerModalTokens1114.getRangeSelectionHeaderHeadlineFont());
                            float fM5160constructorimpl1114 = Dp.m5160constructorimpl(datePickerModalTokens1114.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                            ComposableLambda composableLambda1111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                            int i111111112 = ((i14 >> 3) & 14) | 14155776;
                            int i111111113 = i14 >> 9;
                            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken1114, fM5160constructorimpl1114, composableLambda1111119, composerStartRestartGroup, i111111112 | (i111111113 & 112) | (i111111113 & 896) | (i111111113 & 57344));
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11111110 = composableLambda;
                        Typography typography1115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens1115 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken1115 = TypographyKt.fromToken(typography1115, datePickerModalTokens1115.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl1115 = Dp.m5160constructorimpl(datePickerModalTokens1115.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda11111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111111114 = ((i14 >> 3) & 14) | 14155776;
                        int i111111115 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken1115, fM5160constructorimpl1115, composableLambda11111111, composerStartRestartGroup, i111111114 | (i111111115 & 112) | (i111111115 & 896) | (i111111115 & 57344));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11111112 = composableLambda;
                        Typography typography1116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens1116 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken1116 = TypographyKt.fromToken(typography1116, datePickerModalTokens1116.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl1116 = Dp.m5160constructorimpl(datePickerModalTokens1116.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda11111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111111116 = ((i14 >> 3) & 14) | 14155776;
                        int i111111117 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken1116, fM5160constructorimpl1116, composableLambda11111113, composerStartRestartGroup, i111111116 | (i111111117 & 112) | (i111111117 & 896) | (i111111117 & 57344));
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11111114 = composableLambda;
                        Typography typography1117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens1117 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken1117 = TypographyKt.fromToken(typography1117, datePickerModalTokens1117.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl1117 = Dp.m5160constructorimpl(datePickerModalTokens1117.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda11111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111111118 = ((i14 >> 3) & 14) | 14155776;
                        int i111111119 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken1117, fM5160constructorimpl1117, composableLambda11111115, composerStartRestartGroup, i111111118 | (i111111119 & 112) | (i111111119 & 896) | (i111111119 & 57344));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11111116 = composableLambda;
                        Typography typography1118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens1118 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken1118 = TypographyKt.fromToken(typography1118, datePickerModalTokens1118.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl1118 = Dp.m5160constructorimpl(datePickerModalTokens1118.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda11111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1111111110 = ((i14 >> 3) & 14) | 14155776;
                        int i1111111111 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken1118, fM5160constructorimpl1118, composableLambda11111117, composerStartRestartGroup, i1111111110 | (i1111111111 & 112) | (i1111111111 & 896) | (i1111111111 & 57344));
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11111118 = composableLambda;
                    Typography typography1119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens1119 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken1119 = TypographyKt.fromToken(typography1119, datePickerModalTokens1119.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl1119 = Dp.m5160constructorimpl(datePickerModalTokens1119.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda11111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111111112 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111113 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken1119, fM5160constructorimpl1119, composableLambda11111119, composerStartRestartGroup, i1111111112 | (i1111111113 & 112) | (i1111111113 & 896) | (i1111111113 & 57344));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111111110 = composableLambda;
                    Typography typography11110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens11110 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken11110 = TypographyKt.fromToken(typography11110, datePickerModalTokens11110.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl11110 = Dp.m5160constructorimpl(datePickerModalTokens11110.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda111111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111111114 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111115 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken11110, fM5160constructorimpl11110, composableLambda111111111, composerStartRestartGroup, i1111111114 | (i1111111115 & 112) | (i1111111115 & 896) | (i1111111115 & 57344));
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
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda111111112 = composableLambda;
                        Typography typography11111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens11111 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken11111 = TypographyKt.fromToken(typography11111, datePickerModalTokens11111.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl11111 = Dp.m5160constructorimpl(datePickerModalTokens11111.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda111111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1111111116 = ((i14 >> 3) & 14) | 14155776;
                        int i1111111117 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken11111, fM5160constructorimpl11111, composableLambda111111113, composerStartRestartGroup, i1111111116 | (i1111111117 & 112) | (i1111111117 & 896) | (i1111111117 & 57344));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda111111114 = composableLambda;
                        Typography typography11112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens11112 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken11112 = TypographyKt.fromToken(typography11112, datePickerModalTokens11112.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl11112 = Dp.m5160constructorimpl(datePickerModalTokens11112.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda111111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i1111111118 = ((i14 >> 3) & 14) | 14155776;
                        int i1111111119 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken11112, fM5160constructorimpl11112, composableLambda111111115, composerStartRestartGroup, i1111111118 | (i1111111119 & 112) | (i1111111119 & 896) | (i1111111119 & 57344));
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111111116 = composableLambda;
                    Typography typography11113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens11113 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken11113 = TypographyKt.fromToken(typography11113, datePickerModalTokens11113.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl11113 = Dp.m5160constructorimpl(datePickerModalTokens11113.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda111111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111111110 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111111 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken11113, fM5160constructorimpl11113, composableLambda111111117, composerStartRestartGroup, i11111111110 | (i11111111111 & 112) | (i11111111111 & 896) | (i11111111111 & 57344));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111111118 = composableLambda;
                    Typography typography11114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens11114 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken11114 = TypographyKt.fromToken(typography11114, datePickerModalTokens11114.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl11114 = Dp.m5160constructorimpl(datePickerModalTokens11114.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda111111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111111112 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111113 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken11114, fM5160constructorimpl11114, composableLambda111111119, composerStartRestartGroup, i11111111112 | (i11111111113 & 112) | (i11111111113 & 896) | (i11111111113 & 57344));
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
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda1111111110 = composableLambda;
                    Typography typography11115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens11115 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken11115 = TypographyKt.fromToken(typography11115, datePickerModalTokens11115.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl11115 = Dp.m5160constructorimpl(datePickerModalTokens11115.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda1111111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111111114 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111115 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken11115, fM5160constructorimpl11115, composableLambda1111111111, composerStartRestartGroup, i11111111114 | (i11111111115 & 112) | (i11111111115 & 896) | (i11111111115 & 57344));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda1111111112 = composableLambda;
                    Typography typography11116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens11116 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken11116 = TypographyKt.fromToken(typography11116, datePickerModalTokens11116.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl11116 = Dp.m5160constructorimpl(datePickerModalTokens11116.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda1111111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111111116 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111117 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken11116, fM5160constructorimpl11116, composableLambda1111111113, composerStartRestartGroup, i11111111116 | (i11111111117 & 112) | (i11111111117 & 896) | (i11111111117 & 57344));
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
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111111114 = composableLambda;
                Typography typography11117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens11117 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken11117 = TypographyKt.fromToken(typography11117, datePickerModalTokens11117.getRangeSelectionHeaderHeadlineFont());
                float fM5160constructorimpl11117 = Dp.m5160constructorimpl(datePickerModalTokens11117.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                ComposableLambda composableLambda1111111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111111118 = ((i14 >> 3) & 14) | 14155776;
                int i11111111119 = i14 >> 9;
                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken11117, fM5160constructorimpl11117, composableLambda1111111115, composerStartRestartGroup, i11111111118 | (i11111111119 & 112) | (i11111111119 & 896) | (i11111111119 & 57344));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111111116 = composableLambda;
                Typography typography11118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens11118 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken11118 = TypographyKt.fromToken(typography11118, datePickerModalTokens11118.getRangeSelectionHeaderHeadlineFont());
                float fM5160constructorimpl11118 = Dp.m5160constructorimpl(datePickerModalTokens11118.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                ComposableLambda composableLambda1111111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i111111111110 = ((i14 >> 3) & 14) | 14155776;
                int i111111111111 = i14 >> 9;
                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken11118, fM5160constructorimpl11118, composableLambda1111111117, composerStartRestartGroup, i111111111110 | (i111111111111 & 112) | (i111111111111 & 896) | (i111111111111 & 57344));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda1111111118 = composableLambda;
                        Typography typography11119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens11119 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken11119 = TypographyKt.fromToken(typography11119, datePickerModalTokens11119.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl11119 = Dp.m5160constructorimpl(datePickerModalTokens11119.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda1111111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111111111112 = ((i14 >> 3) & 14) | 14155776;
                        int i111111111113 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken11119, fM5160constructorimpl11119, composableLambda1111111119, composerStartRestartGroup, i111111111112 | (i111111111113 & 112) | (i111111111113 & 896) | (i111111111113 & 57344));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                                interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                            } else {
                                interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                            }
                            if (i10 != 0) {
                                interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                        }
                        if (z2) {
                            z3 = true;
                            composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                        } else {
                            z3 = true;
                            composableLambda = null;
                        }
                        ComposableLambda composableLambda11111111110 = composableLambda;
                        Typography typography111110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                        DatePickerModalTokens datePickerModalTokens111110 = DatePickerModalTokens.INSTANCE;
                        TextStyle textStyleFromToken111110 = TypographyKt.fromToken(typography111110, datePickerModalTokens111110.getRangeSelectionHeaderHeadlineFont());
                        float fM5160constructorimpl111110 = Dp.m5160constructorimpl(datePickerModalTokens111110.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                        ComposableLambda composableLambda11111111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                        int i111111111114 = ((i14 >> 3) & 14) | 14155776;
                        int i111111111115 = i14 >> 9;
                        DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken111110, fM5160constructorimpl111110, composableLambda11111111111, composerStartRestartGroup, i111111111114 | (i111111111115 & 112) | (i111111111115 & 896) | (i111111111115 & 57344));
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11111111112 = composableLambda;
                    Typography typography111111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111111 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111111 = TypographyKt.fromToken(typography111111, datePickerModalTokens111111.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl111111 = Dp.m5160constructorimpl(datePickerModalTokens111111.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda11111111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i111111111116 = ((i14 >> 3) & 14) | 14155776;
                    int i111111111117 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken111111, fM5160constructorimpl111111, composableLambda11111111113, composerStartRestartGroup, i111111111116 | (i111111111117 & 112) | (i111111111117 & 896) | (i111111111117 & 57344));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11111111114 = composableLambda;
                    Typography typography111112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111112 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111112 = TypographyKt.fromToken(typography111112, datePickerModalTokens111112.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl111112 = Dp.m5160constructorimpl(datePickerModalTokens111112.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda11111111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i111111111118 = ((i14 >> 3) & 14) | 14155776;
                    int i111111111119 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken111112, fM5160constructorimpl111112, composableLambda11111111115, composerStartRestartGroup, i111111111118 | (i111111111119 & 112) | (i111111111119 & 896) | (i111111111119 & 57344));
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
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11111111116 = composableLambda;
                    Typography typography111113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111113 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111113 = TypographyKt.fromToken(typography111113, datePickerModalTokens111113.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl111113 = Dp.m5160constructorimpl(datePickerModalTokens111113.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda11111111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111111111110 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111111111 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken111113, fM5160constructorimpl111113, composableLambda11111111117, composerStartRestartGroup, i1111111111110 | (i1111111111111 & 112) | (i1111111111111 & 896) | (i1111111111111 & 57344));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda11111111118 = composableLambda;
                    Typography typography111114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111114 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111114 = TypographyKt.fromToken(typography111114, datePickerModalTokens111114.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl111114 = Dp.m5160constructorimpl(datePickerModalTokens111114.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda11111111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111111111112 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111111113 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda11111111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken111114, fM5160constructorimpl111114, composableLambda11111111119, composerStartRestartGroup, i1111111111112 | (i1111111111113 & 112) | (i1111111111113 & 896) | (i1111111111113 & 57344));
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
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda111111111110 = composableLambda;
                Typography typography111115 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens111115 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken111115 = TypographyKt.fromToken(typography111115, datePickerModalTokens111115.getRangeSelectionHeaderHeadlineFont());
                float fM5160constructorimpl111115 = Dp.m5160constructorimpl(datePickerModalTokens111115.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                ComposableLambda composableLambda111111111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i1111111111114 = ((i14 >> 3) & 14) | 14155776;
                int i1111111111115 = i14 >> 9;
                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken111115, fM5160constructorimpl111115, composableLambda111111111111, composerStartRestartGroup, i1111111111114 | (i1111111111115 & 112) | (i1111111111115 & 896) | (i1111111111115 & 57344));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda111111111112 = composableLambda;
                Typography typography111116 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens111116 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken111116 = TypographyKt.fromToken(typography111116, datePickerModalTokens111116.getRangeSelectionHeaderHeadlineFont());
                float fM5160constructorimpl111116 = Dp.m5160constructorimpl(datePickerModalTokens111116.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                ComposableLambda composableLambda111111111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i1111111111116 = ((i14 >> 3) & 14) | 14155776;
                int i1111111111117 = i14 >> 9;
                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken111116, fM5160constructorimpl111116, composableLambda111111111113, composerStartRestartGroup, i1111111111116 | (i1111111111117 & 112) | (i1111111111117 & 896) | (i1111111111117 & 57344));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111111111114 = composableLambda;
                    Typography typography111117 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111117 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111117 = TypographyKt.fromToken(typography111117, datePickerModalTokens111117.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl111117 = Dp.m5160constructorimpl(datePickerModalTokens111117.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda111111111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i1111111111118 = ((i14 >> 3) & 14) | 14155776;
                    int i1111111111119 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken111117, fM5160constructorimpl111117, composableLambda111111111115, composerStartRestartGroup, i1111111111118 | (i1111111111119 & 112) | (i1111111111119 & 896) | (i1111111111119 & 57344));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                            interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                        } else {
                            interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                        }
                        if (i10 != 0) {
                            interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                    }
                    if (z2) {
                        z3 = true;
                        composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                    } else {
                        z3 = true;
                        composableLambda = null;
                    }
                    ComposableLambda composableLambda111111111116 = composableLambda;
                    Typography typography111118 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                    DatePickerModalTokens datePickerModalTokens111118 = DatePickerModalTokens.INSTANCE;
                    TextStyle textStyleFromToken111118 = TypographyKt.fromToken(typography111118, datePickerModalTokens111118.getRangeSelectionHeaderHeadlineFont());
                    float fM5160constructorimpl111118 = Dp.m5160constructorimpl(datePickerModalTokens111118.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                    ComposableLambda composableLambda111111111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                    int i11111111111110 = ((i14 >> 3) & 14) | 14155776;
                    int i11111111111111 = i14 >> 9;
                    DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken111118, fM5160constructorimpl111118, composableLambda111111111117, composerStartRestartGroup, i11111111111110 | (i11111111111111 & 112) | (i11111111111111 & 896) | (i11111111111111 & 57344));
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
                scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda111111111118 = composableLambda;
                Typography typography111119 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens111119 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken111119 = TypographyKt.fromToken(typography111119, datePickerModalTokens111119.getRangeSelectionHeaderHeadlineFont());
                float fM5160constructorimpl111119 = Dp.m5160constructorimpl(datePickerModalTokens111119.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                ComposableLambda composableLambda111111111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111111111112 = ((i14 >> 3) & 14) | 14155776;
                int i11111111111113 = i14 >> 9;
                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda111111111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken111119, fM5160constructorimpl111119, composableLambda111111111119, composerStartRestartGroup, i11111111111112 | (i11111111111113 & 112) | (i11111111111113 & 896) | (i11111111111113 & 57344));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111111111110 = composableLambda;
                Typography typography1111110 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens1111110 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken1111110 = TypographyKt.fromToken(typography1111110, datePickerModalTokens1111110.getRangeSelectionHeaderHeadlineFont());
                float fM5160constructorimpl1111110 = Dp.m5160constructorimpl(datePickerModalTokens1111110.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                ComposableLambda composableLambda1111111111111 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111111111114 = ((i14 >> 3) & 14) | 14155776;
                int i11111111111115 = i14 >> 9;
                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111111110, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111110, fM5160constructorimpl1111110, composableLambda1111111111111, composerStartRestartGroup, i11111111111114 | (i11111111111115 & 112) | (i11111111111115 & 896) | (i11111111111115 & 57344));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111111111112 = composableLambda;
                Typography typography1111111 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens1111111 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken1111111 = TypographyKt.fromToken(typography1111111, datePickerModalTokens1111111.getRangeSelectionHeaderHeadlineFont());
                float fM5160constructorimpl1111111 = Dp.m5160constructorimpl(datePickerModalTokens1111111.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                ComposableLambda composableLambda1111111111113 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111111111116 = ((i14 >> 3) & 14) | 14155776;
                int i11111111111117 = i14 >> 9;
                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111111112, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111111, fM5160constructorimpl1111111, composableLambda1111111111113, composerStartRestartGroup, i11111111111116 | (i11111111111117 & 112) | (i11111111111117 & 896) | (i11111111111117 & 57344));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                        interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                    } else {
                        interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                    }
                    if (i10 != 0) {
                        interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
                }
                if (z2) {
                    z3 = true;
                    composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
                } else {
                    z3 = true;
                    composableLambda = null;
                }
                ComposableLambda composableLambda1111111111114 = composableLambda;
                Typography typography1111112 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
                DatePickerModalTokens datePickerModalTokens1111112 = DatePickerModalTokens.INSTANCE;
                TextStyle textStyleFromToken1111112 = TypographyKt.fromToken(typography1111112, datePickerModalTokens1111112.getRangeSelectionHeaderHeadlineFont());
                float fM5160constructorimpl1111112 = Dp.m5160constructorimpl(datePickerModalTokens1111112.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
                ComposableLambda composableLambda1111111111115 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
                int i11111111111118 = ((i14 >> 3) & 14) | 14155776;
                int i11111111111119 = i14 >> 9;
                DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111111114, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111112, fM5160constructorimpl1111112, composableLambda1111111111115, composerStartRestartGroup, i11111111111118 | (i11111111111119 & 112) | (i11111111111119 & 896) | (i11111111111119 & 57344));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
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
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                } else {
                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                }
                if (i10 != 0) {
                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                } else {
                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                }
                if (i10 != 0) {
                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
            }
            if (z2) {
                z3 = true;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
            } else {
                z3 = true;
                composableLambda = null;
            }
            ComposableLambda composableLambda1111111111116 = composableLambda;
            Typography typography1111113 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            DatePickerModalTokens datePickerModalTokens1111113 = DatePickerModalTokens.INSTANCE;
            TextStyle textStyleFromToken1111113 = TypographyKt.fromToken(typography1111113, datePickerModalTokens1111113.getRangeSelectionHeaderHeadlineFont());
            float fM5160constructorimpl1111113 = Dp.m5160constructorimpl(datePickerModalTokens1111113.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
            ComposableLambda composableLambda1111111111117 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
            int i111111111111110 = ((i14 >> 3) & 14) | 14155776;
            int i111111111111111 = i14 >> 9;
            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111111116, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111113, fM5160constructorimpl1111113, composableLambda1111111111117, composerStartRestartGroup, i111111111111110 | (i111111111111111 & 112) | (i111111111111111 & 896) | (i111111111111111 & 57344));
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
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                } else {
                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                }
                if (i10 != 0) {
                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                    interfaceC0526FpComposableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 492752701, true, new AnonymousClass3(dateRangePickerState, i3));
                } else {
                    interfaceC0526FpComposableLambda = interfaceC0526Fp3;
                }
                if (i10 != 0) {
                    interfaceC0526FpComposableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -204181785, true, new AnonymousClass4(dateRangePickerState, datePickerFormatter2, i3));
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
                ComposerKt.traceEventStart(-1835392055, i14, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
            }
            if (z2) {
                z3 = true;
                composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1062265737, true, new AnonymousClass5(dateRangePickerState, i14));
            } else {
                z3 = true;
                composableLambda = null;
            }
            ComposableLambda composableLambda1111111111118 = composableLambda;
            Typography typography1111114 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6);
            DatePickerModalTokens datePickerModalTokens1111114 = DatePickerModalTokens.INSTANCE;
            TextStyle textStyleFromToken1111114 = TypographyKt.fromToken(typography1111114, datePickerModalTokens1111114.getRangeSelectionHeaderHeadlineFont());
            float fM5160constructorimpl1111114 = Dp.m5160constructorimpl(datePickerModalTokens1111114.m2182getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset);
            ComposableLambda composableLambda1111111111119 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -186850856, z3, new AnonymousClass6(dateRangePickerState, datePickerFormatter2, interfaceC3750qp3, datePickerColorsM1496colors1m2CgY, i14));
            int i111111111111112 = ((i14 >> 3) & 14) | 14155776;
            int i111111111111113 = i14 >> 9;
            DatePickerKt.m1499DateEntryContainerau3_HiA(modifier2, interfaceC0526FpComposableLambda, interfaceC0526FpComposableLambda2, composableLambda1111111111118, datePickerColorsM1496colors1m2CgY, textStyleFromToken1111114, fM5160constructorimpl1111114, composableLambda1111111111119, composerStartRestartGroup, i111111111111112 | (i111111111111113 & 112) | (i111111111111113 & 896) | (i111111111111113 & 57344));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass7(dateRangePickerState, modifier3, datePickerFormatter2, interfaceC3750qp3, interfaceC0526Fp5, interfaceC0526Fp6, z2, datePickerColors2, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DateRangePickerContent(StateData stateData, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1003501610);
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
        if ((i2 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1003501610, i2, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:478)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(stateData.getDisplayedMonthIndex(), 0, composerStartRestartGroup, 0, 2);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(stateData);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new DateRangePickerKt$DateRangePickerContent$onDateSelected$1$1(stateData);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            InterfaceC3750qp interfaceC3750qp2 = (InterfaceC3750qp) objRememberedValue;
            Modifier modifierM487paddingVpY3zN4$default = PaddingKt.m487paddingVpY3zN4$default(Modifier.Companion, DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, null);
            composerStartRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierM487paddingVpY3zN4$default);
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
            DatePickerKt.WeekDays(datePickerColors, stateData.getCalendarModel(), composerStartRestartGroup, (i2 >> 9) & 14);
            int i3 = (i2 << 3) & 112;
            int i4 = i2 << 6;
            VerticalMonthsList(interfaceC3750qp2, stateData, lazyListStateRememberLazyListState, datePickerFormatter, interfaceC3750qp, datePickerColors, composerStartRestartGroup, i3 | (i4 & 7168) | (57344 & i4) | (i4 & 458752));
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
        scopeUpdateScopeEndRestartGroup.updateScope(new C15072(stateData, datePickerFormatter, interfaceC3750qp, datePickerColors, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SwitchableDateEntryContent(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(984055784);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(dateRangePickerState) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(984055784, i3, -1, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:447)");
            }
            int iM1519getDisplayModejFl4v0 = dateRangePickerState.m1519getDisplayModejFl4v0();
            CrossfadeKt.Crossfade(DisplayMode.m1529boximpl(iM1519getDisplayModejFl4v0), SemanticsModifierKt.semantics$default(Modifier.Companion, false, AnonymousClass1.INSTANCE, 1, null), AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), (String) null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1354418636, true, new C15082(dateRangePickerState, datePickerFormatter, interfaceC3750qp, datePickerColors, i3)), composerStartRestartGroup, 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15093(dateRangePickerState, datePickerFormatter, interfaceC3750qp, datePickerColors, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VerticalMonthsList(InterfaceC3750qp interfaceC3750qp, StateData stateData, LazyListState lazyListState, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp2, DatePickerColors datePickerColors, Composer composer, int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-837198453);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(interfaceC3750qp) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
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
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-837198453, i3, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:511)");
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
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadFont()), ComposableLambdaKt.composableLambda(composerStartRestartGroup, 56792252, true, new C15101(lazyListState, i3, stateData, (CalendarMonth) objRememberedValue, datePickerFormatter, datePickerColors, interfaceC3750qp, today, interfaceC3750qp2)), composerStartRestartGroup, 48);
            int i4 = (i3 >> 6) & 14;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged2 = composerStartRestartGroup.changed(lazyListState) | composerStartRestartGroup.changed(stateData);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState, stateData, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(lazyListState, (InterfaceC0526Fp) objRememberedValue2, composerStartRestartGroup, i4 | 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15113(interfaceC3750qp, stateData, lazyListState, datePickerFormatter, interfaceC3750qp2, datePickerColors, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(LazyListState lazyListState, InterfaceC2052dg interfaceC2052dg, String str, String str2) {
        return AbstractC1886cc.p(new CustomAccessibilityAction(str, new DateRangePickerKt$customScrollActions$scrollUpAction$1(lazyListState, interfaceC2052dg)), new CustomAccessibilityAction(str2, new DateRangePickerKt$customScrollActions$scrollDownAction$1(lazyListState, interfaceC2052dg)));
    }

    /* JADX INFO: renamed from: drawRangeBackground-mxwnekA, reason: not valid java name */
    public static final void m1514drawRangeBackgroundmxwnekA(ContentDrawScope contentDrawScope, SelectedRangeInfo selectedRangeInfo, long j) {
        AbstractC4492zt.h(contentDrawScope, "$this$drawRangeBackground");
        AbstractC4492zt.h(selectedRangeInfo, "selectedRangeInfo");
        float fMo333toPx0680j_4 = contentDrawScope.mo333toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float fMo333toPx0680j_5 = contentDrawScope.mo333toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float fMo333toPx0680j_6 = contentDrawScope.mo333toPx0680j_4(DatePickerModalTokens.INSTANCE.m2175getDateStateLayerHeightD9Ej5fM());
        float f = 2;
        float f2 = (fMo333toPx0680j_5 - fMo333toPx0680j_6) / f;
        float f3 = 7;
        float fM2867getWidthimpl = (Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()) - (f3 * fMo333toPx0680j_4)) / f3;
        long jM5287unboximpl = ((IntOffset) selectedRangeInfo.getGridCoordinates().c()).m5287unboximpl();
        int iM5270component1impl = IntOffset.m5270component1impl(jM5287unboximpl);
        int iM5271component2impl = IntOffset.m5271component2impl(jM5287unboximpl);
        long jM5287unboximpl2 = ((IntOffset) selectedRangeInfo.getGridCoordinates().e()).m5287unboximpl();
        int iM5270component1impl2 = IntOffset.m5270component1impl(jM5287unboximpl2);
        int iM5271component2impl2 = IntOffset.m5271component2impl(jM5287unboximpl2);
        float f4 = fMo333toPx0680j_4 + fM2867getWidthimpl;
        float f5 = fM2867getWidthimpl / f;
        float fM2867getWidthimpl2 = (iM5270component1impl * f4) + (selectedRangeInfo.getFirstIsSelectionStart() ? fMo333toPx0680j_4 / f : 0.0f) + f5;
        float f6 = (iM5271component2impl * fMo333toPx0680j_5) + f2;
        float f7 = iM5270component1impl2 * f4;
        if (selectedRangeInfo.getLastIsSelectionEnd()) {
            fMo333toPx0680j_4 /= f;
        }
        float fM2867getWidthimpl3 = f7 + fMo333toPx0680j_4 + f5;
        float f8 = (iM5271component2impl2 * fMo333toPx0680j_5) + f2;
        boolean z = contentDrawScope.getLayoutDirection() == LayoutDirection.Rtl;
        if (z) {
            fM2867getWidthimpl2 = Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()) - fM2867getWidthimpl2;
            fM2867getWidthimpl3 = Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()) - fM2867getWidthimpl3;
        }
        float fM2867getWidthimpl4 = fM2867getWidthimpl3;
        AbstractC3255kk.K(contentDrawScope, j, OffsetKt.Offset(fM2867getWidthimpl2, f6), SizeKt.Size(iM5271component2impl == iM5271component2impl2 ? fM2867getWidthimpl4 - fM2867getWidthimpl2 : z ? -fM2867getWidthimpl2 : Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()) - fM2867getWidthimpl2, fMo333toPx0680j_6), 0.0f, null, null, 0, 120, null);
        if (iM5271component2impl != iM5271component2impl2) {
            for (int i = (iM5271component2impl2 - iM5271component2impl) - 1; i > 0; i--) {
                AbstractC3255kk.K(contentDrawScope, j, OffsetKt.Offset(0.0f, f6 + (i * fMo333toPx0680j_5)), SizeKt.Size(Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()), fMo333toPx0680j_6), 0.0f, null, null, 0, 120, null);
            }
            long jOffset = OffsetKt.Offset(contentDrawScope.getLayoutDirection() == LayoutDirection.Ltr ? 0.0f : Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()), f8);
            if (z) {
                fM2867getWidthimpl4 -= Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc());
            }
            AbstractC3255kk.K(contentDrawScope, j, jOffset, SizeKt.Size(fM2867getWidthimpl4, fMo333toPx0680j_6), 0.0f, null, null, 0, 120, null);
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    @Composable
    @ExperimentalMaterial3Api
    /* JADX INFO: renamed from: rememberDateRangePickerState-pMw4iz8, reason: not valid java name */
    public static final DateRangePickerState m1515rememberDateRangePickerStatepMw4iz8(Long l, Long l2, Long l3, C1001Vs c1001Vs, int i, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(501019096);
        Long l4 = (i3 & 1) != 0 ? null : l;
        Long l5 = (i3 & 2) != 0 ? null : l2;
        Long l6 = (i3 & 4) != 0 ? l4 : l3;
        C1001Vs yearRange = (i3 & 8) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : c1001Vs;
        int iM1537getPickerjFl4v0 = (i3 & 16) != 0 ? DisplayMode.Companion.m1537getPickerjFl4v0() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(501019096, i2, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:157)");
        }
        DateRangePickerState dateRangePickerState = (DateRangePickerState) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) DateRangePickerState.Companion.Saver(), (String) null, (InterfaceC3588op) new DateRangePickerKt$rememberDateRangePickerState$1(l4, l5, l6, yearRange, iM1537getPickerjFl4v0), composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dateRangePickerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDateSelection(StateData stateData, long j) {
        CalendarDate canonicalDate = stateData.getCalendarModel().getCanonicalDate(j);
        CalendarDate value = stateData.getSelectedStartDate().getValue();
        CalendarDate value2 = stateData.getSelectedEndDate().getValue();
        if ((value == null && value2 == null) || ((value != null && value2 != null) || (value != null && canonicalDate.compareTo(value) < 0))) {
            stateData.getSelectedStartDate().setValue(canonicalDate);
            stateData.getSelectedEndDate().setValue(null);
        } else {
            if (value == null || canonicalDate.compareTo(value) < 0) {
                return;
            }
            stateData.getSelectedEndDate().setValue(canonicalDate);
        }
    }
}
