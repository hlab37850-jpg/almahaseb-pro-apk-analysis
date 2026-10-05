package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@Stable
@ExperimentalMaterial3Api
public final class DatePickerDefaults {
    public static final int $stable = 0;
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    public static final DatePickerDefaults INSTANCE = new DatePickerDefaults();
    private static final C1001Vs YearRange = new C1001Vs(1900, 2100);
    private static final float TonalElevation = DatePickerModalTokens.INSTANCE.m2170getContainerElevationD9Ej5fM();

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerDefaults$DatePickerHeadline$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ DatePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, Modifier modifier, int i, int i2) {
            super(2);
            this.$state = datePickerState;
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
            DatePickerDefaults.this.DatePickerHeadline(this.$state, this.$dateFormatter, this.$modifier, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerDefaults$DatePickerTitle$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ DatePickerState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DatePickerState datePickerState, Modifier modifier, int i, int i2) {
            super(2);
            this.$state = datePickerState;
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
            DatePickerDefaults.this.DatePickerTitle(this.$state, this.$modifier, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
        }
    }

    private DatePickerDefaults() {
    }

    /* JADX WARN: Code duplicated, block: B:40:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:53:0x0107  */
    /* JADX WARN: Code duplicated, block: B:54:0x011b  */
    /* JADX WARN: Code duplicated, block: B:57:0x0130  */
    /* JADX WARN: Code duplicated, block: B:59:0x014a  */
    /* JADX WARN: Code duplicated, block: B:60:0x015e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0168  */
    /* JADX WARN: Code duplicated, block: B:63:0x017c  */
    /* JADX WARN: Code duplicated, block: B:66:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:67:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:73:0x0200  */
    /* JADX WARN: Code duplicated, block: B:75:0x0208  */
    /* JADX WARN: Code duplicated, block: B:78:0x024d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0258  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void DatePickerHeadline(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter, Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        Modifier modifier3;
        StateData stateData$material3_release;
        String date$material3_release$default;
        String date$material3_release;
        String strM1841getStringNWtq28;
        int iM1535unboximpl;
        DisplayMode.Companion companion;
        String str;
        boolean zChanged;
        Object objRememberedValue;
        Composer composer2;
        Modifier modifier4;
        int iM1535unboximpl2;
        DisplayMode.Companion companion2;
        int iM1535unboximpl3;
        DisplayMode.Companion companion3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(datePickerState, "state");
        AbstractC4492zt.h(datePickerFormatter, "dateFormatter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1893194407);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(datePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(datePickerFormatter) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 896) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 731) == 146 || !composerStartRestartGroup.getSkipping()) {
                if (i4 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1893194407, i, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:442)");
                }
                stateData$material3_release = datePickerState.getStateData$material3_release();
                Locale localeDefaultLocale = CalendarModel_androidKt.defaultLocale(composerStartRestartGroup, 0);
                date$material3_release$default = DatePickerFormatter.formatDate$material3_release$default(datePickerFormatter, stateData$material3_release.getSelectedStartDate().getValue(), stateData$material3_release.getCalendarModel(), localeDefaultLocale, false, 8, null);
                date$material3_release = datePickerFormatter.formatDate$material3_release(stateData$material3_release.getSelectedStartDate().getValue(), stateData$material3_release.getCalendarModel(), localeDefaultLocale, true);
                composerStartRestartGroup.startReplaceableGroup(729783869);
                strM1841getStringNWtq28 = "";
                if (date$material3_release == null) {
                    iM1535unboximpl3 = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
                    companion3 = DisplayMode.Companion;
                    if (DisplayMode.m1532equalsimpl0(iM1535unboximpl3, companion3.m1537getPickerjFl4v0())) {
                        composerStartRestartGroup.startReplaceableGroup(933108990);
                        date$material3_release = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1796getDatePickerNoSelectionDescriptionadMyvUU(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl3, companion3.m1536getInputjFl4v0())) {
                        composerStartRestartGroup.startReplaceableGroup(933109079);
                        date$material3_release = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1791getDateInputNoInputDescriptionadMyvUU(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1138387422);
                        composerStartRestartGroup.endReplaceableGroup();
                        date$material3_release = "";
                    }
                }
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.startReplaceableGroup(729784366);
                if (date$material3_release$default == null) {
                    iM1535unboximpl2 = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
                    companion2 = DisplayMode.Companion;
                    if (DisplayMode.m1532equalsimpl0(iM1535unboximpl2, companion2.m1537getPickerjFl4v0())) {
                        composerStartRestartGroup.startReplaceableGroup(933109281);
                        date$material3_release$default = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1793getDatePickerHeadlineadMyvUU(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl2, companion2.m1536getInputjFl4v0())) {
                        composerStartRestartGroup.startReplaceableGroup(933109356);
                        date$material3_release$default = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1785getDateInputHeadlineadMyvUU(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceableGroup();
                    } else {
                        composerStartRestartGroup.startReplaceableGroup(-1138379145);
                        composerStartRestartGroup.endReplaceableGroup();
                        date$material3_release$default = "";
                    }
                }
                composerStartRestartGroup.endReplaceableGroup();
                iM1535unboximpl = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
                companion = DisplayMode.Companion;
                if (DisplayMode.m1532equalsimpl0(iM1535unboximpl, companion.m1537getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(933109538);
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1794getDatePickerHeadlineDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl, companion.m1536getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(933109624);
                    strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1786getDateInputHeadlineDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1138370496);
                    composerStartRestartGroup.endReplaceableGroup();
                }
                str = String.format(strM1841getStringNWtq28, Arrays.copyOf(new Object[]{date$material3_release}, 1));
                AbstractC4492zt.g(str, "format(this, *args)");
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                zChanged = composerStartRestartGroup.changed(str);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new DatePickerDefaults$DatePickerHeadline$1$1$1(str);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                composer2 = composerStartRestartGroup;
                TextKt.m1930Text4IGK_g(date$material3_release$default, SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (InterfaceC3750qp) null, (TextStyle) null, composer2, 0, 3072, 122876);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier4 = modifier2;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(datePickerState, datePickerFormatter, modifier4, i, i2));
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 731) == 146) {
            if (i4 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1893194407, i, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:442)");
            }
            stateData$material3_release = datePickerState.getStateData$material3_release();
            Locale localeDefaultLocale2 = CalendarModel_androidKt.defaultLocale(composerStartRestartGroup, 0);
            date$material3_release$default = DatePickerFormatter.formatDate$material3_release$default(datePickerFormatter, stateData$material3_release.getSelectedStartDate().getValue(), stateData$material3_release.getCalendarModel(), localeDefaultLocale2, false, 8, null);
            date$material3_release = datePickerFormatter.formatDate$material3_release(stateData$material3_release.getSelectedStartDate().getValue(), stateData$material3_release.getCalendarModel(), localeDefaultLocale2, true);
            composerStartRestartGroup.startReplaceableGroup(729783869);
            strM1841getStringNWtq28 = "";
            if (date$material3_release == null) {
                iM1535unboximpl3 = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
                companion3 = DisplayMode.Companion;
                if (DisplayMode.m1532equalsimpl0(iM1535unboximpl3, companion3.m1537getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(933108990);
                    date$material3_release = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1796getDatePickerNoSelectionDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl3, companion3.m1536getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(933109079);
                    date$material3_release = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1791getDateInputNoInputDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1138387422);
                    composerStartRestartGroup.endReplaceableGroup();
                    date$material3_release = "";
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(729784366);
            if (date$material3_release$default == null) {
                iM1535unboximpl2 = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
                companion2 = DisplayMode.Companion;
                if (DisplayMode.m1532equalsimpl0(iM1535unboximpl2, companion2.m1537getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(933109281);
                    date$material3_release$default = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1793getDatePickerHeadlineadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl2, companion2.m1536getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(933109356);
                    date$material3_release$default = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1785getDateInputHeadlineadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1138379145);
                    composerStartRestartGroup.endReplaceableGroup();
                    date$material3_release$default = "";
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
            iM1535unboximpl = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
            companion = DisplayMode.Companion;
            if (DisplayMode.m1532equalsimpl0(iM1535unboximpl, companion.m1537getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(933109538);
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1794getDatePickerHeadlineDescriptionadMyvUU(), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl, companion.m1536getInputjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(933109624);
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1786getDateInputHeadlineDescriptionadMyvUU(), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1138370496);
                composerStartRestartGroup.endReplaceableGroup();
            }
            str = String.format(strM1841getStringNWtq28, Arrays.copyOf(new Object[]{date$material3_release}, 1));
            AbstractC4492zt.g(str, "format(this, *args)");
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(str);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new DatePickerDefaults$DatePickerHeadline$1$1$1(str);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new DatePickerDefaults$DatePickerHeadline$1$1$1(str);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            TextKt.m1930Text4IGK_g(date$material3_release$default, SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (InterfaceC3750qp) null, (TextStyle) null, composer2, 0, 3072, 122876);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        } else {
            if (i4 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1893194407, i, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:442)");
            }
            stateData$material3_release = datePickerState.getStateData$material3_release();
            Locale localeDefaultLocale3 = CalendarModel_androidKt.defaultLocale(composerStartRestartGroup, 0);
            date$material3_release$default = DatePickerFormatter.formatDate$material3_release$default(datePickerFormatter, stateData$material3_release.getSelectedStartDate().getValue(), stateData$material3_release.getCalendarModel(), localeDefaultLocale3, false, 8, null);
            date$material3_release = datePickerFormatter.formatDate$material3_release(stateData$material3_release.getSelectedStartDate().getValue(), stateData$material3_release.getCalendarModel(), localeDefaultLocale3, true);
            composerStartRestartGroup.startReplaceableGroup(729783869);
            strM1841getStringNWtq28 = "";
            if (date$material3_release == null) {
                iM1535unboximpl3 = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
                companion3 = DisplayMode.Companion;
                if (DisplayMode.m1532equalsimpl0(iM1535unboximpl3, companion3.m1537getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(933108990);
                    date$material3_release = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1796getDatePickerNoSelectionDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl3, companion3.m1536getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(933109079);
                    date$material3_release = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1791getDateInputNoInputDescriptionadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1138387422);
                    composerStartRestartGroup.endReplaceableGroup();
                    date$material3_release = "";
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(729784366);
            if (date$material3_release$default == null) {
                iM1535unboximpl2 = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
                companion2 = DisplayMode.Companion;
                if (DisplayMode.m1532equalsimpl0(iM1535unboximpl2, companion2.m1537getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(933109281);
                    date$material3_release$default = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1793getDatePickerHeadlineadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl2, companion2.m1536getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(933109356);
                    date$material3_release$default = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1785getDateInputHeadlineadMyvUU(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-1138379145);
                    composerStartRestartGroup.endReplaceableGroup();
                    date$material3_release$default = "";
                }
            }
            composerStartRestartGroup.endReplaceableGroup();
            iM1535unboximpl = stateData$material3_release.getDisplayMode().getValue().m1535unboximpl();
            companion = DisplayMode.Companion;
            if (DisplayMode.m1532equalsimpl0(iM1535unboximpl, companion.m1537getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(933109538);
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1794getDatePickerHeadlineDescriptionadMyvUU(), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (DisplayMode.m1532equalsimpl0(iM1535unboximpl, companion.m1536getInputjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(933109624);
                strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1786getDateInputHeadlineDescriptionadMyvUU(), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-1138370496);
                composerStartRestartGroup.endReplaceableGroup();
            }
            str = String.format(strM1841getStringNWtq28, Arrays.copyOf(new Object[]{date$material3_release}, 1));
            AbstractC4492zt.g(str, "format(this, *args)");
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            zChanged = composerStartRestartGroup.changed(str);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue = new DatePickerDefaults$DatePickerHeadline$1$1$1(str);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new DatePickerDefaults$DatePickerHeadline$1$1$1(str);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            TextKt.m1930Text4IGK_g(date$material3_release$default, SemanticsModifierKt.semantics$default(modifier3, false, (InterfaceC3750qp) objRememberedValue, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (InterfaceC3750qp) null, (TextStyle) null, composer2, 0, 3072, 122876);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(datePickerState, datePickerFormatter, modifier4, i, i2));
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
    public final void DatePickerTitle(DatePickerState datePickerState, Modifier modifier, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Modifier modifier3;
        int iM1512getDisplayModejFl4v0;
        DisplayMode.Companion companion;
        Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        AbstractC4492zt.h(datePickerState, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1157401173);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = i | (composerStartRestartGroup.changed(datePickerState) ? 4 : 2);
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
                    ComposerKt.traceEventStart(-1157401173, i4, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:419)");
                }
                iM1512getDisplayModejFl4v0 = datePickerState.m1512getDisplayModejFl4v0();
                companion = DisplayMode.Companion;
                if (DisplayMode.m1532equalsimpl0(iM1512getDisplayModejFl4v0, companion.m1537getPickerjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(-2065111000);
                    TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1805getDatePickerTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                    composerStartRestartGroup.endReplaceableGroup();
                } else if (DisplayMode.m1532equalsimpl0(iM1512getDisplayModejFl4v0, companion.m1536getInputjFl4v0())) {
                    composerStartRestartGroup.startReplaceableGroup(-2065110842);
                    TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1792getDateInputTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                    composerStartRestartGroup.endReplaceableGroup();
                } else {
                    composerStartRestartGroup.startReplaceableGroup(-2065110710);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(datePickerState, modifier4, i, i2));
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
                ComposerKt.traceEventStart(-1157401173, i4, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:419)");
            }
            iM1512getDisplayModejFl4v0 = datePickerState.m1512getDisplayModejFl4v0();
            companion = DisplayMode.Companion;
            if (DisplayMode.m1532equalsimpl0(iM1512getDisplayModejFl4v0, companion.m1537getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(-2065111000);
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1805getDatePickerTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (DisplayMode.m1532equalsimpl0(iM1512getDisplayModejFl4v0, companion.m1536getInputjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(-2065110842);
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1792getDateInputTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-2065110710);
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
                ComposerKt.traceEventStart(-1157401173, i4, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:419)");
            }
            iM1512getDisplayModejFl4v0 = datePickerState.m1512getDisplayModejFl4v0();
            companion = DisplayMode.Companion;
            if (DisplayMode.m1532equalsimpl0(iM1512getDisplayModejFl4v0, companion.m1537getPickerjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(-2065111000);
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1805getDatePickerTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                composerStartRestartGroup.endReplaceableGroup();
            } else if (DisplayMode.m1532equalsimpl0(iM1512getDisplayModejFl4v0, companion.m1536getInputjFl4v0())) {
                composerStartRestartGroup.startReplaceableGroup(-2065110842);
                TextKt.m1930Text4IGK_g(Strings_androidKt.m1841getStringNWtq28(Strings.Companion.m1792getDateInputTitleadMyvUU(), composerStartRestartGroup, 6), modifier3, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composerStartRestartGroup, i4 & 112, 0, 131068);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-2065110710);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(datePickerState, modifier4, i, i2));
    }

    @Composable
    /* JADX INFO: renamed from: colors-1m2Cg-Y, reason: not valid java name */
    public final DatePickerColors m1496colors1m2CgY(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, Composer composer, int i, int i2, int i3) {
        composer.startReplaceableGroup(543433842);
        long color = (i3 & 1) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long color2 = (i3 & 2) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor(), composer, 6) : j2;
        long color3 = (i3 & 4) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor(), composer, 6) : j3;
        long color4 = (i3 & 8) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor(), composer, 6) : j4;
        long color5 = (i3 & 16) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor(), composer, 6) : j5;
        long color6 = (i3 & 32) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor(), composer, 6) : j6;
        long color7 = (i3 & 64) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor(), composer, 6) : j7;
        long color8 = (i3 & 128) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor(), composer, 6) : j8;
        long color9 = (i3 & 256) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor(), composer, 6) : j9;
        long color10 = (i3 & 512) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor(), composer, 6) : j10;
        long jM3031copywmQWz5c$default = (i3 & 1024) != 0 ? Color.m3031copywmQWz5c$default(color10, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long color11 = (i3 & 2048) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor(), composer, 6) : j12;
        long jM3031copywmQWz5c$default2 = (i3 & 4096) != 0 ? Color.m3031copywmQWz5c$default(color11, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long color12 = (i3 & 8192) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor(), composer, 6) : j14;
        long jM3031copywmQWz5c$default3 = (i3 & 16384) != 0 ? Color.m3031copywmQWz5c$default(color12, 0.38f, 0.0f, 0.0f, 0.0f, 14, null) : j15;
        long color13 = (32768 & i3) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor(), composer, 6) : j16;
        long color14 = (65536 & i3) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor(), composer, 6) : j17;
        long color15 = (131072 & i3) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor(), composer, 6) : j18;
        long color16 = (i3 & 262144) != 0 ? ColorSchemeKt.toColor(DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor(), composer, 6) : j19;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(543433842, i, i2, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:358)");
        }
        DatePickerColors datePickerColors = new DatePickerColors(color, color2, color3, color4, color5, color6, color7, color8, color9, color10, jM3031copywmQWz5c$default, color11, jM3031copywmQWz5c$default2, color12, jM3031copywmQWz5c$default3, color13, color14, color16, color15, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return datePickerColors;
    }

    @Composable
    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(700927667);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(700927667, i, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:518)");
        }
        Shape shape = ShapesKt.toShape(DatePickerModalTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m1497getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    public final C1001Vs getYearRange() {
        return YearRange;
    }

    @Composable
    public final FlingBehavior rememberSnapFlingBehavior$material3_release(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer composer, int i, int i2) {
        AbstractC4492zt.h(lazyListState, "lazyListState");
        composer.startReplaceableGroup(-2036003494);
        if ((i2 & 2) != 0) {
            decayAnimationSpec = DecayAnimationSpecKt.exponentialDecay$default(0.0f, 0.0f, 3, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2036003494, i, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:496)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(density);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new SnapFlingBehavior(lazyListState, decayAnimationSpec, AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), density);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return snapFlingBehavior;
    }
}
