package androidx.compose.material3;

import defpackage.AbstractC0723Lm;
import defpackage.AbstractC4492zt;
import defpackage.C1001Vs;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterial3Api
public final class CalendarMonth {
    private final int daysFromStartOfWeekToFirstOfMonth;
    private final long endUtcTimeMillis;
    private final int month;
    private final int numberOfDays;
    private final long startUtcTimeMillis;
    private final int year;

    public CalendarMonth(int i, int i2, int i3, int i4, long j) {
        this.year = i;
        this.month = i2;
        this.numberOfDays = i3;
        this.daysFromStartOfWeekToFirstOfMonth = i4;
        this.startUtcTimeMillis = j;
        this.endUtcTimeMillis = (j + (((long) i3) * CalendarModelKt.MillisecondsIn24Hours)) - 1;
    }

    public static /* synthetic */ CalendarMonth copy$default(CalendarMonth calendarMonth, int i, int i2, int i3, int i4, long j, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = calendarMonth.year;
        }
        if ((i5 & 2) != 0) {
            i2 = calendarMonth.month;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = calendarMonth.numberOfDays;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = calendarMonth.daysFromStartOfWeekToFirstOfMonth;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            j = calendarMonth.startUtcTimeMillis;
        }
        return calendarMonth.copy(i, i6, i7, i8, j);
    }

    public static /* synthetic */ String format$default(CalendarMonth calendarMonth, CalendarModel calendarModel, String str, Locale locale, int i, Object obj) {
        if ((i & 4) != 0) {
            locale = Locale.getDefault();
            AbstractC4492zt.g(locale, "getDefault()");
        }
        return calendarMonth.format(calendarModel, str, locale);
    }

    public final int component1() {
        return this.year;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.numberOfDays;
    }

    public final int component4() {
        return this.daysFromStartOfWeekToFirstOfMonth;
    }

    public final long component5() {
        return this.startUtcTimeMillis;
    }

    public final CalendarMonth copy(int i, int i2, int i3, int i4, long j) {
        return new CalendarMonth(i, i2, i3, i4, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarMonth)) {
            return false;
        }
        CalendarMonth calendarMonth = (CalendarMonth) obj;
        return this.year == calendarMonth.year && this.month == calendarMonth.month && this.numberOfDays == calendarMonth.numberOfDays && this.daysFromStartOfWeekToFirstOfMonth == calendarMonth.daysFromStartOfWeekToFirstOfMonth && this.startUtcTimeMillis == calendarMonth.startUtcTimeMillis;
    }

    public final String format(CalendarModel calendarModel, String str, Locale locale) {
        AbstractC4492zt.h(calendarModel, "calendarModel");
        AbstractC4492zt.h(str, "skeleton");
        AbstractC4492zt.h(locale, "locale");
        return calendarModel.formatWithSkeleton(this, str, locale);
    }

    public final int getDaysFromStartOfWeekToFirstOfMonth() {
        return this.daysFromStartOfWeekToFirstOfMonth;
    }

    public final long getEndUtcTimeMillis() {
        return this.endUtcTimeMillis;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getNumberOfDays() {
        return this.numberOfDays;
    }

    public final long getStartUtcTimeMillis() {
        return this.startUtcTimeMillis;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((((((this.year * 31) + this.month) * 31) + this.numberOfDays) * 31) + this.daysFromStartOfWeekToFirstOfMonth) * 31) + AbstractC0723Lm.a(this.startUtcTimeMillis);
    }

    public final int indexIn(C1001Vs c1001Vs) {
        AbstractC4492zt.h(c1001Vs, "years");
        return (((this.year - c1001Vs.b()) * 12) + this.month) - 1;
    }

    public String toString() {
        return "CalendarMonth(year=" + this.year + ", month=" + this.month + ", numberOfDays=" + this.numberOfDays + ", daysFromStartOfWeekToFirstOfMonth=" + this.daysFromStartOfWeekToFirstOfMonth + ", startUtcTimeMillis=" + this.startUtcTimeMillis + ')';
    }
}
