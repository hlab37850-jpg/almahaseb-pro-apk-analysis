package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class DateInputKt$DateInputTextField$text$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ DateInputFormat $dateInputFormat;
    final /* synthetic */ CalendarDate $initialDate;
    final /* synthetic */ Locale $locale;
    final /* synthetic */ StateData $stateData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateInputKt$DateInputTextField$text$2(StateData stateData, CalendarDate calendarDate, DateInputFormat dateInputFormat, Locale locale) {
        super(0);
        this.$stateData = stateData;
        this.$initialDate = calendarDate;
        this.$dateInputFormat = dateInputFormat;
        this.$locale = locale;
    }

    @Override // defpackage.InterfaceC3588op
    public final MutableState<TextFieldValue> invoke() {
        String withPattern;
        StateData stateData = this.$stateData;
        CalendarDate calendarDate = this.$initialDate;
        DateInputFormat dateInputFormat = this.$dateInputFormat;
        Locale locale = this.$locale;
        if (calendarDate == null || (withPattern = stateData.getCalendarModel().formatWithPattern(calendarDate.getUtcTimeMillis(), dateInputFormat.getPatternWithoutDelimiters(), locale)) == null) {
            withPattern = "";
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(withPattern, TextRangeKt.TextRange(0, 0), (TextRange) null, 4, (AbstractC0419Di) null), null, 2, null);
    }
}
