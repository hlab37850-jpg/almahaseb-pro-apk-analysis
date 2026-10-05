package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import defpackage.InterfaceC3750qp;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding;
    private static final float InputTextNonErroneousBottomPadding = Dp.m5160constructorimpl(16);

    /* JADX INFO: renamed from: androidx.compose.material3.DateInputKt$DateInputContent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ String $labelText;
        final /* synthetic */ String $pattern;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2) {
            super(2);
            this.$labelText = str;
            this.$pattern = str2;
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
                ComposerKt.traceEventStart(-438341159, i, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:79)");
            }
            String str = this.$labelText;
            Modifier.Companion companion = Modifier.Companion;
            String str2 = this.$pattern;
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(str) | composer.changed(str2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new DateInputKt$DateInputContent$1$1$1(str, str2);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            TextKt.m1930Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion, false, (InterfaceC3750qp) objRememberedValue, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composer, 0, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateInputKt$DateInputContent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ String $pattern;

        /* JADX INFO: renamed from: androidx.compose.material3.DateInputKt$DateInputContent$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3750qp {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
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
        public AnonymousClass2(String str) {
            super(2);
            this.$pattern = str;
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
                ComposerKt.traceEventStart(1914447672, i, -1, "androidx.compose.material3.DateInputContent.<anonymous> (DateInput.kt:84)");
            }
            TextKt.m1930Text4IGK_g(this.$pattern, SemanticsModifierKt.clearAndSetSemantics(Modifier.Companion, AnonymousClass1.INSTANCE), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (InterfaceC3750qp) null, (TextStyle) null, composer, 0, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DateInputKt$DateInputContent$4, reason: invalid class name */
    public static final class AnonymousClass4 extends AbstractC2233fv implements InterfaceC0526Fp {
        final /* synthetic */ int $$changed;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ InterfaceC3750qp $dateValidator;
        final /* synthetic */ StateData $stateData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(StateData stateData, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, int i) {
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
            DateInputKt.DateInputContent(this.$stateData, this.$dateFormatter, this.$dateValidator, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
        }
    }

    static {
        float f = 24;
        InputTextFieldPadding = PaddingKt.m482PaddingValuesa9UjIt4$default(Dp.m5160constructorimpl(f), Dp.m5160constructorimpl(10), Dp.m5160constructorimpl(f), 0.0f, 8, null);
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DateInputContent(StateData stateData, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, Composer composer, int i) {
        int i2;
        int i3;
        Composer composer2;
        AbstractC4492zt.h(stateData, "stateData");
        AbstractC4492zt.h(datePickerFormatter, "dateFormatter");
        AbstractC4492zt.h(interfaceC3750qp, "dateValidator");
        Composer composerStartRestartGroup = composer.startRestartGroup(814303288);
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
                ComposerKt.traceEventStart(814303288, i4, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:48)");
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
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged2 = composerStartRestartGroup.changed(dateInputFormat) | composerStartRestartGroup.changed(datePickerFormatter);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                i3 = 6;
                DateInputValidator dateInputValidator = new DateInputValidator(stateData, dateInputFormat, datePickerFormatter, interfaceC3750qp, strM1841getStringNWtq28, strM1841getStringNWtq29, strM1841getStringNWtq210, "");
                composerStartRestartGroup.updateRememberedValue(dateInputValidator);
                objRememberedValue2 = dateInputValidator;
            } else {
                i3 = 6;
            }
            composerStartRestartGroup.endReplaceableGroup();
            DateInputValidator dateInputValidator2 = (DateInputValidator) objRememberedValue2;
            String upperCase = dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            AbstractC4492zt.g(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            String strM1841getStringNWtq211 = Strings_androidKt.m1841getStringNWtq28(companion.m1790getDateInputLabeladMyvUU(), composerStartRestartGroup, i3);
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), InputTextFieldPadding);
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composerStartRestartGroup, -438341159, true, new AnonymousClass1(strM1841getStringNWtq211, upperCase));
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1914447672, true, new AnonymousClass2(upperCase));
            CalendarDate value = stateData.getSelectedStartDate().getValue();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged3 = composerStartRestartGroup.changed(stateData);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new DateInputKt$DateInputContent$3$1(stateData);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            m1487DateInputTextFieldzm97o8M(modifierPadding, composableLambda, composableLambda2, stateData, value, (InterfaceC3750qp) objRememberedValue3, InputIdentifier.Companion.m1618getSingleDateInputJ2x2o4M(), dateInputValidator2, dateInputFormat, localeDefaultLocale, composerStartRestartGroup, ((i4 << 9) & 7168) | 1075315126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(stateData, datePickerFormatter, interfaceC3750qp, i));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_]]")
    /* JADX INFO: renamed from: DateInputTextField-zm97o8M, reason: not valid java name */
    public static final void m1487DateInputTextFieldzm97o8M(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, StateData stateData, CalendarDate calendarDate, InterfaceC3750qp interfaceC3750qp, int i, DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, Locale locale, Composer composer, int i2) {
        AbstractC4492zt.h(modifier, "modifier");
        AbstractC4492zt.h(stateData, "stateData");
        AbstractC4492zt.h(interfaceC3750qp, "onDateChanged");
        AbstractC4492zt.h(dateInputValidator, "dateInputValidator");
        AbstractC4492zt.h(dateInputFormat, "dateInputFormat");
        AbstractC4492zt.h(locale, "locale");
        Composer composerStartRestartGroup = composer.startRestartGroup(626552973);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626552973, i2, -1, "androidx.compose.material3.DateInputTextField (DateInput.kt:97)");
        }
        MutableState mutableState = (MutableState) RememberSaveableKt.m2674rememberSaveable(new Object[0], (Saver) null, (String) null, (InterfaceC3588op) DateInputKt$DateInputTextField$errorText$1.INSTANCE, composerStartRestartGroup, 3080, 6);
        MutableState mutableStateRememberSaveable = RememberSaveableKt.rememberSaveable(new Object[0], (Saver) TextFieldValue.Companion.getSaver(), (String) null, (InterfaceC3588op) new DateInputKt$DateInputTextField$text$2(stateData, calendarDate, dateInputFormat, locale), composerStartRestartGroup, 72, 4);
        TextFieldValue textFieldValueDateInputTextField_zm97o8M$lambda$3 = DateInputTextField_zm97o8M$lambda$3(mutableStateRememberSaveable);
        DateInputKt$DateInputTextField$1 dateInputKt$DateInputTextField$1 = new DateInputKt$DateInputTextField$1(dateInputFormat, mutableState, interfaceC3750qp, stateData, dateInputValidator, i, locale, mutableStateRememberSaveable);
        Modifier modifierM489paddingqDBjuR0$default = PaddingKt.m489paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, !AbstractC3961tS.T((CharSequence) mutableState.getValue()) ? Dp.m5160constructorimpl(0) : InputTextNonErroneousBottomPadding, 7, null);
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(mutableState);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DateInputKt$DateInputTextField$2$1(mutableState);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        OutlinedTextFieldKt.OutlinedTextField(textFieldValueDateInputTextField_zm97o8M$lambda$3, (InterfaceC3750qp) dateInputKt$DateInputTextField$1, SemanticsModifierKt.semantics$default(modifierM489paddingqDBjuR0$default, false, (InterfaceC3750qp) objRememberedValue, 1, null), false, false, (TextStyle) null, interfaceC0526Fp, interfaceC0526Fp2, (InterfaceC0526Fp) null, (InterfaceC0526Fp) null, (InterfaceC0526Fp) null, (InterfaceC0526Fp) null, (InterfaceC0526Fp) ComposableLambdaKt.composableLambda(composerStartRestartGroup, 785795078, true, new DateInputKt$DateInputTextField$3(mutableState)), !AbstractC3961tS.T((CharSequence) mutableState.getValue()), (VisualTransformation) new DateVisualTransformation(dateInputFormat), new KeyboardOptions(0, false, KeyboardType.Companion.m4911getNumberPjHm6EE(), ImeAction.Companion.m4863getDoneeUduSuo(), 1, null), (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composerStartRestartGroup, (i2 << 15) & 33030144, 12779904, 0, 8195896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new DateInputKt$DateInputTextField$4(modifier, interfaceC0526Fp, interfaceC0526Fp2, stateData, calendarDate, interfaceC3750qp, i, dateInputValidator, dateInputFormat, locale, i2));
    }

    private static final TextFieldValue DateInputTextField_zm97o8M$lambda$3(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return InputTextFieldPadding;
    }
}
