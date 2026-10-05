package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class DateRangePickerDefaults {
    public static final int $stable = 0;
    public static final DateRangePickerDefaults INSTANCE = new DateRangePickerDefaults();

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ String $startDateText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(2);
            this.$startDateText = str;
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
                ComposerKt.traceEventStart(-1382084760, i, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:341)");
            }
            TextKt.m1930Text4IGK_g(this.$startDateText, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ String $endDateText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(2);
            this.$endDateText = str;
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
                ComposerKt.traceEventStart(-199852025, i, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline.<anonymous> (DateRangePicker.kt:342)");
            }
            TextKt.m1930Text4IGK_g(this.$endDateText, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$3, reason: invalid class name */
    public static final class AnonymousClass3 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ DateRangePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, Modifier modifier, int i, int i2) {
            super(2);
            this.$state = dateRangePickerState;
            this.$dateFormatter = datePickerFormatter;
            this.$modifier = modifier;
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
            DateRangePickerDefaults.this.DateRangePickerHeadline(this.$state, this.$dateFormatter, this.$modifier, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerHeadline$5, reason: invalid class name */
    public static final class AnonymousClass5 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC0526Fp $datesDelimiter;
        final /* synthetic */ InterfaceC0526Fp $endDatePlaceholder;
        final /* synthetic */ String $endDateText;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ InterfaceC0526Fp $startDatePlaceholder;
        final /* synthetic */ String $startDateText;
        final /* synthetic */ DateRangePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, Modifier modifier, String str, String str2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, int i) {
            super(2);
            this.$state = dateRangePickerState;
            this.$dateFormatter = datePickerFormatter;
            this.$modifier = modifier;
            this.$startDateText = str;
            this.$endDateText = str2;
            this.$startDatePlaceholder = interfaceC0526Fp;
            this.$endDatePlaceholder = interfaceC0526Fp2;
            this.$datesDelimiter = interfaceC0526Fp3;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            DateRangePickerDefaults.this.DateRangePickerHeadline(this.$state, this.$dateFormatter, this.$modifier, this.$startDateText, this.$endDateText, this.$startDatePlaceholder, this.$endDatePlaceholder, this.$datesDelimiter, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangePickerDefaults$DateRangePickerTitle$1, reason: invalid class name and case insensitive filesystem */
    public static final class C15061 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ DateRangePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15061(DateRangePickerState dateRangePickerState, Modifier modifier, int i, int i2) {
            super(2);
            this.$state = dateRangePickerState;
            this.$modifier = modifier;
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
            DateRangePickerDefaults.this.DateRangePickerTitle(this.$state, this.$modifier, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    private DateRangePickerDefaults() {
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x0092  */
    /* JADX WARN: Code duplicated, block: B:52:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:63:0x0107  */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void DateRangePickerHeadline(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Modifier modifier3;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(dateRangePickerState, "state");
        AbstractC4492zt.h(datePickerFormatter, "dateFormatter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-332090137);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(dateRangePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(datePickerFormatter) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                if (composerStartRestartGroup.changed(this)) {
                    i4 = 2048;
                } else {
                    i4 = 1024;
                }
                i3 |= i4;
            }
            if ((i3 & 5851) == 1170 || !composerStartRestartGroup.getSkipping()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-332090137, i3, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:328)");
                }
                Strings.Companion companion = Strings.Companion;
                String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(companion.m1814getDateRangePickerStartHeadlineadMyvUU(), composerStartRestartGroup, 6);
                String strM1841getStringNWtq29 = Strings_androidKt.m1841getStringNWtq28(companion.m1811getDateRangePickerEndHeadlineadMyvUU(), composerStartRestartGroup, 6);
                DateRangePickerHeadline(dateRangePickerState, datePickerFormatter, modifier3, strM1841getStringNWtq28, strM1841getStringNWtq29, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1382084760, true, new AnonymousClass1(strM1841getStringNWtq28)), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -199852025, true, new AnonymousClass2(strM1841getStringNWtq29)), ComposableSingletons$DateRangePickerKt.INSTANCE.m1471getLambda1$material3_release(), composerStartRestartGroup, 14352384 | (i3 & 14) | (i3 & 112) | (i3 & 896) | ((i3 << 15) & 234881024));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dateRangePickerState, datePickerFormatter, modifier4, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            if (composerStartRestartGroup.changed(this)) {
                i4 = 2048;
            } else {
                i4 = 1024;
            }
            i3 |= i4;
        }
        if ((i3 & 5851) == 1170) {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-332090137, i3, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:328)");
            }
            Strings.Companion companion2 = Strings.Companion;
            String strM1841getStringNWtq210 = Strings_androidKt.m1841getStringNWtq28(companion2.m1814getDateRangePickerStartHeadlineadMyvUU(), composerStartRestartGroup, 6);
            String strM1841getStringNWtq211 = Strings_androidKt.m1841getStringNWtq28(companion2.m1811getDateRangePickerEndHeadlineadMyvUU(), composerStartRestartGroup, 6);
            DateRangePickerHeadline(dateRangePickerState, datePickerFormatter, modifier3, strM1841getStringNWtq210, strM1841getStringNWtq211, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1382084760, true, new AnonymousClass1(strM1841getStringNWtq210)), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -199852025, true, new AnonymousClass2(strM1841getStringNWtq211)), ComposableSingletons$DateRangePickerKt.INSTANCE.m1471getLambda1$material3_release(), composerStartRestartGroup, 14352384 | (i3 & 14) | (i3 & 112) | (i3 & 896) | ((i3 << 15) & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        } else {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-332090137, i3, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:328)");
            }
            Strings.Companion companion3 = Strings.Companion;
            String strM1841getStringNWtq212 = Strings_androidKt.m1841getStringNWtq28(companion3.m1814getDateRangePickerStartHeadlineadMyvUU(), composerStartRestartGroup, 6);
            String strM1841getStringNWtq213 = Strings_androidKt.m1841getStringNWtq28(companion3.m1811getDateRangePickerEndHeadlineadMyvUU(), composerStartRestartGroup, 6);
            DateRangePickerHeadline(dateRangePickerState, datePickerFormatter, modifier3, strM1841getStringNWtq212, strM1841getStringNWtq213, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -1382084760, true, new AnonymousClass1(strM1841getStringNWtq212)), ComposableLambdaKt.composableLambda(composerStartRestartGroup, -199852025, true, new AnonymousClass2(strM1841getStringNWtq213)), ComposableSingletons$DateRangePickerKt.INSTANCE.m1471getLambda1$material3_release(), composerStartRestartGroup, 14352384 | (i3 & 14) | (i3 & 112) | (i3 & 896) | ((i3 << 15) & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass3(dateRangePickerState, datePickerFormatter, modifier4, i, i2));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x007f  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:46:0x010e  */
    /* JADX WARN: Code duplicated, block: B:51:0x011a  */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void DateRangePickerTitle(DateRangePickerState dateRangePickerState, Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Modifier modifier3;
        int iM1519getDisplayModejFl4v0;
        DisplayMode.Companion companion;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(dateRangePickerState, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(499073135);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = i | (composerStartRestartGroup.changed(dateRangePickerState) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 112) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i3;
            if ((i4 & 91) == 18 || !composerStartRestartGroup.getSkipping()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(499073135, i4, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:302)");
                }
                iM1519getDisplayModejFl4v0 = dateRangePickerState.m1519getDisplayModejFl4v0();
                companion = DisplayMode.Companion;
                if (DisplayMode.m1532equalsimpl0(iM1519getDisplayModejFl4v0, companion.m1537getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(585814427);
                    TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1815getDateRangePickerTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1532equalsimpl0(iM1519getDisplayModejFl4v0, companion.m1536getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(585814583);
                    TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1809getDateRangeInputTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(585814713);
                    composerStartRestartGroup.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new C15061(dateRangePickerState, modifier4, i, i2));
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 91) == 18) {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(499073135, i4, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:302)");
            }
            iM1519getDisplayModejFl4v0 = dateRangePickerState.m1519getDisplayModejFl4v0();
            companion = DisplayMode.Companion;
            if (DisplayMode.m1532equalsimpl0(iM1519getDisplayModejFl4v0, companion.m1537getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(585814427);
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1815getDateRangePickerTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (DisplayMode.m1532equalsimpl0(iM1519getDisplayModejFl4v0, companion.m1536getInputjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(585814583);
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1809getDateRangeInputTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(585814713);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        } else {
            if (i5 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(499073135, i4, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:302)");
            }
            iM1519getDisplayModejFl4v0 = dateRangePickerState.m1519getDisplayModejFl4v0();
            companion = DisplayMode.Companion;
            if (DisplayMode.m1532equalsimpl0(iM1519getDisplayModejFl4v0, companion.m1537getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(585814427);
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1815getDateRangePickerTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (DisplayMode.m1532equalsimpl0(iM1519getDisplayModejFl4v0, companion.m1536getInputjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(585814583);
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1809getDateRangeInputTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(585814713);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C15061(dateRangePickerState, modifier4, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public final void DateRangePickerHeadline(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter, Modifier modifier, String str, String str2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Composer composer, int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-861159957);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(dateRangePickerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(datePickerFormatter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp2) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(interfaceC0526Fp3) ? 8388608 : 4194304;
        }
        int i3 = i2;
        if ((23967451 & i3) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-861159957, i3, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:368)");
            }
            StateData stateData$material3_release = dateRangePickerState.getStateData$material3_release();
            Locale localeDefaultLocale = CalendarModel_androidKt.defaultLocale(composerStartRestartGroup, 0);
            String date$material3_release$default = DatePickerFormatter.formatDate$material3_release$default(datePickerFormatter, stateData$material3_release.getSelectedStartDate().getValue(), stateData$material3_release.getCalendarModel(), localeDefaultLocale, false, 8, null);
            String date$material3_release$default2 = DatePickerFormatter.formatDate$material3_release$default(datePickerFormatter, stateData$material3_release.getSelectedEndDate().getValue(), stateData$material3_release.getCalendarModel(), localeDefaultLocale, false, 8, null);
            String date$material3_release = datePickerFormatter.formatDate$material3_release(stateData$material3_release.getSelectedStartDate().getValue(), stateData$material3_release.getCalendarModel(), localeDefaultLocale, true);
            composerStartRestartGroup.startReplaceableGroup(-1212634278);
            String strM1841getStringNWtq28 = "";
            if (date$material3_release == null) {
                int iM1535unboximpl = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
                DisplayMode.Companion companion = DisplayMode.Companion;
                if (DisplayMode.m1532equalsimpl0(iM1535unboximpl, companion.m1537getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(1922096411);
                    date$material3_release = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1796getDatePickerNoSelectionDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl, companion.m1536getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(1922096500);
                    date$material3_release = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1791getDateInputNoInputDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-544548443);
                    composerStartRestartGroup.endReplaceableGroup();
                    date$material3_release = "";
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
            String date$material3_release2 = datePickerFormatter.formatDate$material3_release(stateData$material3_release.getSelectedEndDate().getValue(), stateData$material3_release.getCalendarModel(), localeDefaultLocale, true);
            composerStartRestartGroup.startReplaceableGroup(-1212633768);
            if (date$material3_release2 == null) {
                int iM1535unboximpl2 = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
                DisplayMode.Companion companion2 = DisplayMode.Companion;
                if (DisplayMode.m1532equalsimpl0(iM1535unboximpl2, companion2.m1537getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(1922096919);
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1796getDatePickerNoSelectionDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl2, companion2.m1536getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(1922097008);
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1791getDateInputNoInputDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-544532695);
                    composerStartRestartGroup.endReplaceableGroup();
                }
            } else {
                strM1841getStringNWtq28 = date$material3_release2;
            }
            composerStartRestartGroup.endReplaceableGroup();
            String str3 = str + ": " + date$material3_release;
            String str4 = str2 + ": " + strM1841getStringNWtq28;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(str3) | composerStartRestartGroup.changed(str4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new DateRangePickerDefaults$DateRangePickerHeadline$4$1$1(str3, str4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, (InterfaceC3750qp) objRememberedValue);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(Dp.m5160constructorimpl(4));
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM399spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
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
            Updater.m2668setimpl(composerM2661constructorimpl, measurePolicyRowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2668setimpl(composerM2661constructorimpl, density, companion3.getSetDensity());
            Updater.m2668setimpl(composerM2661constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2668setimpl(composerM2661constructorimpl, viewConfiguration, companion3.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            interfaceC0552GpMaterializerOf.invoke(SkippableUpdater.m2650boximpl(SkippableUpdater.m2651constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (date$material3_release$default != null) {
                composerStartRestartGroup.startReplaceableGroup(990390609);
                composer2 = composerStartRestartGroup;
                TextKt.m1930Text4IGK_g(date$material3_release$default, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceableGroup();
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceableGroup(990390686);
                interfaceC0526Fp.mo13invoke(composer2, Integer.valueOf((i3 >> 15) & 14));
                composer2.endReplaceableGroup();
            }
            interfaceC0526Fp3.mo13invoke(composer2, Integer.valueOf((i3 >> 21) & 14));
            if (date$material3_release$default2 != null) {
                composer2.startReplaceableGroup(990390828);
                TextKt.m1930Text4IGK_g(date$material3_release$default2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composer2, 0, 0, 131070);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(990390903);
                interfaceC0526Fp2.mo13invoke(composer2, Integer.valueOf((i3 >> 18) & 14));
                composer2.endReplaceableGroup();
            }
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
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(dateRangePickerState, datePickerFormatter, modifier, str, str2, interfaceC0526Fp, interfaceC0526Fp2, interfaceC0526Fp3, i));
    }
}
