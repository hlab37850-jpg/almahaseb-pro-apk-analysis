package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class TimePickerKt$TimeInputImpl$1$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ MutableState<TextFieldValue> $minuteValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimePickerKt$TimeInputImpl$1$1(MutableState<TextFieldValue> mutableState, TimePickerState timePickerState, int i, TimePickerColors timePickerColors, MutableState<TextFieldValue> mutableState2) {
        super(2);
        this.$hourValue$delegate = mutableState;
        this.$state = timePickerState;
        this.$$dirty = i;
        this.$colors = timePickerColors;
        this.$minuteValue$delegate = mutableState2;
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
            ComposerKt.traceEventStart(1306700887, i, -1, "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:715)");
        }
        Modifier.Companion companion = Modifier.Companion;
        MutableState<TextFieldValue> mutableState = this.$hourValue$delegate;
        TimePickerState timePickerState = this.$state;
        composer.startReplaceableGroup(511388516);
        boolean zChanged = composer.changed(mutableState) | composer.changed(timePickerState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new TimePickerKt$TimeInputImpl$1$1$1$1(timePickerState, mutableState);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(companion, (InterfaceC3750qp) objRememberedValue);
        TextFieldValue textFieldValueTimeInputImpl$lambda$5 = TimePickerKt.TimeInputImpl$lambda$5(this.$hourValue$delegate);
        TimePickerState timePickerState2 = this.$state;
        MutableState<TextFieldValue> mutableState2 = this.$hourValue$delegate;
        composer.startReplaceableGroup(511388516);
        boolean zChanged2 = composer.changed(timePickerState2) | composer.changed(mutableState2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new TimePickerKt$TimeInputImpl$1$1$2$1(timePickerState2, mutableState2);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        InterfaceC3750qp interfaceC3750qp = (InterfaceC3750qp) objRememberedValue2;
        TimePickerState timePickerState3 = this.$state;
        Selection.Companion companion2 = Selection.Companion;
        int iM1750getHourJiIwxys = companion2.m1750getHourJiIwxys();
        ImeAction.Companion companion3 = ImeAction.Companion;
        int iM4865getNexteUduSuo = companion3.m4865getNexteUduSuo();
        KeyboardType.Companion companion4 = KeyboardType.Companion;
        KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, companion4.m4911getNumberPjHm6EE(), iM4865getNexteUduSuo, 3, null);
        TimePickerState timePickerState4 = this.$state;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged3 = composer.changed(timePickerState4);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.Companion.getEmpty()) {
            objRememberedValue3 = new TimePickerKt$TimeInputImpl$1$1$3$1(timePickerState4);
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceableGroup();
        KeyboardActions keyboardActions = new KeyboardActions(null, null, (InterfaceC3750qp) objRememberedValue3, null, null, null, 59, null);
        TimePickerColors timePickerColors = this.$colors;
        int i2 = this.$$dirty;
        TimePickerKt.m1946TimePickerTextFieldlxUZ_iY(modifierOnKeyEvent, textFieldValueTimeInputImpl$lambda$5, interfaceC3750qp, timePickerState3, iM1750getHourJiIwxys, keyboardOptions, keyboardActions, timePickerColors, composer, ((i2 << 3) & 7168) | 24576 | ((i2 << 18) & 29360128), 0);
        TimePickerKt.DisplaySeparator(SizeKt.m534sizeVpY3zN4(companion, TimePickerKt.DisplaySeparatorWidth, TimeInputTokens.INSTANCE.m2543getPeriodSelectorContainerHeightD9Ej5fM()), composer, 6);
        MutableState<TextFieldValue> mutableState3 = this.$minuteValue$delegate;
        TimePickerState timePickerState5 = this.$state;
        composer.startReplaceableGroup(511388516);
        boolean zChanged4 = composer.changed(mutableState3) | composer.changed(timePickerState5);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue4 == Composer.Companion.getEmpty()) {
            objRememberedValue4 = new TimePickerKt$TimeInputImpl$1$1$4$1(timePickerState5, mutableState3);
            composer.updateRememberedValue(objRememberedValue4);
        }
        composer.endReplaceableGroup();
        Modifier modifierOnPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(companion, (InterfaceC3750qp) objRememberedValue4);
        TextFieldValue textFieldValueTimeInputImpl$lambda$8 = TimePickerKt.TimeInputImpl$lambda$8(this.$minuteValue$delegate);
        TimePickerState timePickerState6 = this.$state;
        MutableState<TextFieldValue> mutableState4 = this.$minuteValue$delegate;
        composer.startReplaceableGroup(511388516);
        boolean zChanged5 = composer.changed(timePickerState6) | composer.changed(mutableState4);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged5 || objRememberedValue5 == Composer.Companion.getEmpty()) {
            objRememberedValue5 = new TimePickerKt$TimeInputImpl$1$1$5$1(timePickerState6, mutableState4);
            composer.updateRememberedValue(objRememberedValue5);
        }
        composer.endReplaceableGroup();
        InterfaceC3750qp interfaceC3750qp2 = (InterfaceC3750qp) objRememberedValue5;
        TimePickerState timePickerState7 = this.$state;
        int iM1751getMinuteJiIwxys = companion2.m1751getMinuteJiIwxys();
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, false, companion4.m4911getNumberPjHm6EE(), companion3.m4863getDoneeUduSuo(), 3, null);
        TimePickerState timePickerState8 = this.$state;
        composer.startReplaceableGroup(1157296644);
        boolean zChanged6 = composer.changed(timePickerState8);
        Object objRememberedValue6 = composer.rememberedValue();
        if (zChanged6 || objRememberedValue6 == Composer.Companion.getEmpty()) {
            objRememberedValue6 = new TimePickerKt$TimeInputImpl$1$1$6$1(timePickerState8);
            composer.updateRememberedValue(objRememberedValue6);
        }
        composer.endReplaceableGroup();
        KeyboardActions keyboardActions2 = new KeyboardActions(null, null, (InterfaceC3750qp) objRememberedValue6, null, null, null, 59, null);
        TimePickerColors timePickerColors2 = this.$colors;
        int i3 = this.$$dirty;
        TimePickerKt.m1946TimePickerTextFieldlxUZ_iY(modifierOnPreviewKeyEvent, textFieldValueTimeInputImpl$lambda$8, interfaceC3750qp2, timePickerState7, iM1751getMinuteJiIwxys, keyboardOptions2, keyboardActions2, timePickerColors2, composer, ((i3 << 3) & 7168) | 24576 | ((i3 << 18) & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
