package androidx.compose.material3;

import androidx.compose.runtime.Stable;
import androidx.core.location.LocationRequestCompat;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class DateInputValidator {
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final InterfaceC3750qp dateValidator;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final StateData stateData;

    public DateInputValidator(StateData stateData, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, InterfaceC3750qp interfaceC3750qp, String str, String str2, String str3, String str4) {
        AbstractC4492zt.h(stateData, "stateData");
        AbstractC4492zt.h(dateInputFormat, "dateInputFormat");
        AbstractC4492zt.h(datePickerFormatter, "dateFormatter");
        AbstractC4492zt.h(interfaceC3750qp, "dateValidator");
        AbstractC4492zt.h(str, "errorDatePattern");
        AbstractC4492zt.h(str2, "errorDateOutOfYearRange");
        AbstractC4492zt.h(str3, "errorInvalidNotAllowed");
        AbstractC4492zt.h(str4, "errorInvalidRangeInput");
        this.stateData = stateData;
        this.dateInputFormat = dateInputFormat;
        this.dateFormatter = datePickerFormatter;
        this.dateValidator = interfaceC3750qp;
        this.errorDatePattern = str;
        this.errorDateOutOfYearRange = str2;
        this.errorInvalidNotAllowed = str3;
        this.errorInvalidRangeInput = str4;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:24:0x00df  */
    /* JADX WARN: Code duplicated, block: B:26:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:27:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ff A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: validate-XivgLIo, reason: not valid java name */
    public final String m1488validateXivgLIo(CalendarDate calendarDate, int i, Locale locale) {
        long utcTimeMillis;
        CalendarDate value;
        long utcTimeMillis2;
        AbstractC4492zt.h(locale, "locale");
        if (calendarDate == null) {
            String str = this.errorDatePattern;
            String upperCase = this.dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            AbstractC4492zt.g(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            String str2 = String.format(str, Arrays.copyOf(new Object[]{upperCase}, 1));
            AbstractC4492zt.g(str2, "format(this, *args)");
            return str2;
        }
        if (!this.stateData.getYearRange().g(calendarDate.getYear())) {
            String str3 = String.format(this.errorDateOutOfYearRange, Arrays.copyOf(new Object[]{DatePickerKt.toLocalString(this.stateData.getYearRange().b()), DatePickerKt.toLocalString(this.stateData.getYearRange().c())}, 2));
            AbstractC4492zt.g(str3, "format(this, *args)");
            return str3;
        }
        if (!((Boolean) this.dateValidator.invoke(Long.valueOf(calendarDate.getUtcTimeMillis()))).booleanValue()) {
            String str4 = String.format(this.errorInvalidNotAllowed, Arrays.copyOf(new Object[]{DatePickerFormatter.formatDate$material3_release$default(this.dateFormatter, calendarDate, this.stateData.getCalendarModel(), locale, false, 8, null)}, 1));
            AbstractC4492zt.g(str4, "format(this, *args)");
            return str4;
        }
        InputIdentifier.Companion companion = InputIdentifier.Companion;
        if (InputIdentifier.m1613equalsimpl0(i, companion.m1619getStartDateInputJ2x2o4M())) {
            long utcTimeMillis3 = calendarDate.getUtcTimeMillis();
            CalendarDate value2 = this.stateData.getSelectedEndDate().getValue();
            if (utcTimeMillis3 < (value2 != null ? value2.getUtcTimeMillis() : LocationRequestCompat.PASSIVE_INTERVAL)) {
                if (InputIdentifier.m1613equalsimpl0(i, companion.m1617getEndDateInputJ2x2o4M())) {
                    return "";
                }
                utcTimeMillis = calendarDate.getUtcTimeMillis();
                value = this.stateData.getSelectedStartDate().getValue();
                if (value != null) {
                    utcTimeMillis2 = value.getUtcTimeMillis();
                } else {
                    utcTimeMillis2 = Long.MIN_VALUE;
                }
                if (utcTimeMillis > utcTimeMillis2) {
                    return "";
                }
            }
        } else {
            if (InputIdentifier.m1613equalsimpl0(i, companion.m1617getEndDateInputJ2x2o4M())) {
                return "";
            }
            utcTimeMillis = calendarDate.getUtcTimeMillis();
            value = this.stateData.getSelectedStartDate().getValue();
            if (value != null) {
                utcTimeMillis2 = value.getUtcTimeMillis();
            } else {
                utcTimeMillis2 = Long.MIN_VALUE;
            }
            if (utcTimeMillis > utcTimeMillis2) {
                return "";
            }
        }
        return this.errorInvalidRangeInput;
    }
}
