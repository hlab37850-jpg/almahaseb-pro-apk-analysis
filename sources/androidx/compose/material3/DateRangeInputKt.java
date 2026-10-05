package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3955tM;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DateRangeInputKt {
    private static final float TextFieldSpacing = Dp.m5160constructorimpl(8);

    /* JADX INFO: renamed from: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ StateData $stateData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StateData stateData, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, int i) {
            super(2);
            this.$stateData = stateData;
            this.$dateFormatter = datePickerFormatter;
            this.$dateValidator = interfaceC3750qp;
            this.$$changed = i;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return FW.a;
        }

        public final void invoke(Composer composer, int i) {
            DateRangeInputKt.DateRangeInputContent(this.$stateData, this.$dateFormatter, this.$dateValidator, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DateRangeInputContent(StateData stateData, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, Composer composer, int i) {
        int i2;
        int i3;
        Composer composer2;
        AbstractC4492zt.h(stateData, "stateData");
        AbstractC4492zt.h(datePickerFormatter, "dateFormatter");
        AbstractC4492zt.h(interfaceC3750qp, "dateValidator");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1163802470);
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
        int i4 = i2;
        if ((i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1163802470, i4, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:31)");
            }
            Locale localeDefaultLocale = CalendarModel_androidKt.defaultLocale(composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(localeDefaultLocale);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = stateData.getCalendarModel().getDateInputFormat(localeDefaultLocale);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            DateInputFormat dateInputFormat = (DateInputFormat) objRememberedValue;
            Strings.Companion companion = Strings.Companion;
            String strM1841getStringNWtq28 = Strings_androidKt.m1841getStringNWtq28(companion.m1787getDateInputInvalidForPatternadMyvUU(), composerStartRestartGroup, 6);
            String strM1841getStringNWtq29 = Strings_androidKt.m1841getStringNWtq28(companion.m1789getDateInputInvalidYearRangeadMyvUU(), composerStartRestartGroup, 6);
            String strM1841getStringNWtq210 = Strings_androidKt.m1841getStringNWtq28(companion.m1788getDateInputInvalidNotAllowedadMyvUU(), composerStartRestartGroup, 6);
            String strM1841getStringNWtq211 = Strings_androidKt.m1841getStringNWtq28(companion.m1808getDateRangeInputInvalidRangeInputadMyvUU(), composerStartRestartGroup, 6);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged2 = composerStartRestartGroup.changed(dateInputFormat) | composerStartRestartGroup.changed(datePickerFormatter);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                i3 = 6;
                DateInputValidator dateInputValidator = new DateInputValidator(stateData, dateInputFormat, datePickerFormatter, interfaceC3750qp, strM1841getStringNWtq28, strM1841getStringNWtq29, strM1841getStringNWtq210, strM1841getStringNWtq211);
                composerStartRestartGroup.updateRememberedValue(dateInputValidator);
                objRememberedValue2 = dateInputValidator;
            } else {
                i3 = 6;
            }
            composerStartRestartGroup.endReplaceableGroup();
            DateInputValidator dateInputValidator2 = (DateInputValidator) objRememberedValue2;
            Modifier.Companion companion2 = Modifier.Companion;
            Modifier modifierPadding = PaddingKt.padding(companion2, DateInputKt.getInputTextFieldPadding());
            Arrangement.HorizontalOrVertical horizontalOrVerticalM399spacedBy0680j_4 = Arrangement.INSTANCE.m399spacedBy0680j_4(TextFieldSpacing);
            composerStartRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM399spacedBy0680j_4, Alignment.Companion.getTop(), composerStartRestartGroup, i3);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            InterfaceC3588op constructor = companion3.getConstructor();
            InterfaceC0552Gp interfaceC0552GpMaterializerOf = LayoutKt.materializerOf(modifierPadding);
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
            String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            AbstractC4492zt.g(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            String strM1841getStringNWtq212 = Strings_androidKt.m1841getStringNWtq28(companion.m1814getDateRangePickerStartHeadlineadMyvUU(), composerStartRestartGroup, i3);
            Modifier modifierA = AbstractC3955tM.a(rowScopeInstance, companion2, 0.5f, false, 2, null);
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 576559191, true, new DateRangeInputKt$DateRangeInputContent$1$1(strM1841getStringNWtq212, upperCase));
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1726391478, true, new DateRangeInputKt$DateRangeInputContent$1$2(upperCase));
            CalendarDate value = stateData.getSelectedStartDate().getValue();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged3 = composerStartRestartGroup.changed(stateData);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new DateRangeInputKt$DateRangeInputContent$1$3$1(stateData);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            InputIdentifier.Companion companion4 = InputIdentifier.Companion;
            int i5 = ((i4 << 9) & 7168) | 1075315120;
            composer2 = composerStartRestartGroup;
            DateInputKt.m1487DateInputTextFieldzm97o8M(modifierA, composableLambda, composableLambda2, stateData, value, (InterfaceC3750qp) objRememberedValue3, companion4.m1619getStartDateInputJ2x2o4M(), dateInputValidator2, dateInputFormat, localeDefaultLocale, composerStartRestartGroup, i5);
            String strM1841getStringNWtq213 = Strings_androidKt.m1841getStringNWtq28(companion.m1811getDateRangePickerEndHeadlineadMyvUU(), composer2, i3);
            Modifier modifierA2 = AbstractC3955tM.a(rowScopeInstance, companion2, 0.5f, false, 2, null);
            ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(composer2, -663502784, true, new DateRangeInputKt$DateRangeInputContent$1$4(strM1841getStringNWtq213, upperCase));
            ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(composer2, 518729951, true, new DateRangeInputKt$DateRangeInputContent$1$5(upperCase));
            CalendarDate value2 = stateData.getSelectedEndDate().getValue();
            composer2.startReplaceableGroup(1157296644);
            boolean zChanged4 = composer2.changed(stateData);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChanged4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new DateRangeInputKt$DateRangeInputContent$1$6$1(stateData);
                composer2.updateRememberedValue(objRememberedValue4);
            }
            composer2.endReplaceableGroup();
            DateInputKt.m1487DateInputTextFieldzm97o8M(modifierA2, composableLambda3, composableLambda4, stateData, value2, (InterfaceC3750qp) objRememberedValue4, companion4.m1617getEndDateInputJ2x2o4M(), dateInputValidator2, dateInputFormat, localeDefaultLocale, composer2, i5);
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
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(stateData, datePickerFormatter, interfaceC3750qp, i));
    }
}
