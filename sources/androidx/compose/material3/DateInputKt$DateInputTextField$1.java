package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3961tS;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DateInputKt$DateInputTextField$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ DateInputFormat $dateInputFormat;
    final /* synthetic */ DateInputValidator $dateInputValidator;
    final /* synthetic */ MutableState<String> $errorText;
    final /* synthetic */ int $inputIdentifier;
    final /* synthetic */ Locale $locale;
    final /* synthetic */ InterfaceC3750qp $onDateChanged;
    final /* synthetic */ StateData $stateData;
    final /* synthetic */ MutableState<TextFieldValue> $text$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateInputKt$DateInputTextField$1(DateInputFormat dateInputFormat, MutableState<String> mutableState, InterfaceC3750qp interfaceC3750qp, StateData stateData, DateInputValidator dateInputValidator, int i, Locale locale, MutableState<TextFieldValue> mutableState2) {
        super(1);
        this.$dateInputFormat = dateInputFormat;
        this.$errorText = mutableState;
        this.$onDateChanged = interfaceC3750qp;
        this.$stateData = stateData;
        this.$dateInputValidator = dateInputValidator;
        this.$inputIdentifier = i;
        this.$locale = locale;
        this.$text$delegate = mutableState2;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return FW.a;
    }

    public final void invoke(TextFieldValue textFieldValue) {
        AbstractC4492zt.h(textFieldValue, HTML.Tag.INPUT);
        if (textFieldValue.getText().length() <= this.$dateInputFormat.getPatternWithoutDelimiters().length()) {
            String text = textFieldValue.getText();
            for (int i = 0; i < text.length(); i++) {
                if (!Character.isDigit(text.charAt(i))) {
                    return;
                }
            }
            this.$text$delegate.setValue(textFieldValue);
            String string = AbstractC3961tS.D0(textFieldValue.getText()).toString();
            if (string.length() == 0 || string.length() < this.$dateInputFormat.getPatternWithoutDelimiters().length()) {
                this.$errorText.setValue("");
                this.$onDateChanged.invoke(null);
            } else {
                CalendarDate calendarDate = this.$stateData.getCalendarModel().parse(string, this.$dateInputFormat.getPatternWithoutDelimiters());
                this.$errorText.setValue(this.$dateInputValidator.m1488validateXivgLIo(calendarDate, this.$inputIdentifier, this.$locale));
                this.$onDateChanged.invoke(this.$errorText.getValue().length() == 0 ? calendarDate : null);
            }
        }
    }
}
