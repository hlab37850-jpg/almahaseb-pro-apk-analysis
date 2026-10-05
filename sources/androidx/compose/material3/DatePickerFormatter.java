package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@Immutable
@ExperimentalMaterial3Api
public final class DatePickerFormatter {
    public static final int $stable = 0;
    private final String selectedDateDescriptionSkeleton;
    private final String selectedDateSkeleton;
    private final String yearSelectionSkeleton;

    public DatePickerFormatter() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ String formatDate$material3_release$default(DatePickerFormatter datePickerFormatter, CalendarDate calendarDate, CalendarModel calendarModel, Locale locale, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return datePickerFormatter.formatDate$material3_release(calendarDate, calendarModel, locale, z);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DatePickerFormatter)) {
            return false;
        }
        DatePickerFormatter datePickerFormatter = (DatePickerFormatter) obj;
        return AbstractC4492zt.d(this.yearSelectionSkeleton, datePickerFormatter.yearSelectionSkeleton) && AbstractC4492zt.d(this.selectedDateSkeleton, datePickerFormatter.selectedDateSkeleton) && AbstractC4492zt.d(this.selectedDateDescriptionSkeleton, datePickerFormatter.selectedDateDescriptionSkeleton);
    }

    public final String formatDate$material3_release(CalendarDate calendarDate, CalendarModel calendarModel, Locale locale, boolean z) {
        AbstractC4492zt.h(calendarModel, "calendarModel");
        AbstractC4492zt.h(locale, "locale");
        if (calendarDate == null) {
            return null;
        }
        return calendarModel.formatWithSkeleton(calendarDate, z ? this.selectedDateDescriptionSkeleton : this.selectedDateSkeleton, locale);
    }

    public final String formatMonthYear$material3_release(CalendarMonth calendarMonth, CalendarModel calendarModel, Locale locale) {
        AbstractC4492zt.h(calendarModel, "calendarModel");
        AbstractC4492zt.h(locale, "locale");
        if (calendarMonth == null) {
            return null;
        }
        return calendarModel.formatWithSkeleton(calendarMonth, this.yearSelectionSkeleton, locale);
    }

    public final String getSelectedDateDescriptionSkeleton$material3_release() {
        return this.selectedDateDescriptionSkeleton;
    }

    public final String getSelectedDateSkeleton$material3_release() {
        return this.selectedDateSkeleton;
    }

    public final String getYearSelectionSkeleton$material3_release() {
        return this.yearSelectionSkeleton;
    }

    public int hashCode() {
        return (((this.yearSelectionSkeleton.hashCode() * 31) + this.selectedDateSkeleton.hashCode()) * 31) + this.selectedDateDescriptionSkeleton.hashCode();
    }

    public DatePickerFormatter(String str, String str2, String str3) {
        AbstractC4492zt.h(str, "yearSelectionSkeleton");
        AbstractC4492zt.h(str2, "selectedDateSkeleton");
        AbstractC4492zt.h(str3, "selectedDateDescriptionSkeleton");
        this.yearSelectionSkeleton = str;
        this.selectedDateSkeleton = str2;
        this.selectedDateDescriptionSkeleton = str3;
    }

    public /* synthetic */ DatePickerFormatter(String str, String str2, String str3, int i, AbstractC0419Di abstractC0419Di) {
        this((i & 1) != 0 ? DatePickerDefaults.YearMonthSkeleton : str, (i & 2) != 0 ? DatePickerDefaults.YearAbbrMonthDaySkeleton : str2, (i & 4) != 0 ? DatePickerDefaults.YearMonthWeekdayDaySkeleton : str3);
    }
}
