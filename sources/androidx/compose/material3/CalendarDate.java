package androidx.compose.material3;

import defpackage.AbstractC0723Lm;
import defpackage.AbstractC4492zt;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterial3Api
public final class CalendarDate implements Comparable<CalendarDate> {
    private final int dayOfMonth;
    private final int month;
    private final long utcTimeMillis;
    private final int year;

    public CalendarDate(int i, int i2, int i3, long j) {
        this.year = i;
        this.month = i2;
        this.dayOfMonth = i3;
        this.utcTimeMillis = j;
    }

    public static /* synthetic */ CalendarDate copy$default(CalendarDate calendarDate, int i, int i2, int i3, long j, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = calendarDate.year;
        }
        if ((i4 & 2) != 0) {
            i2 = calendarDate.month;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = calendarDate.dayOfMonth;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            j = calendarDate.utcTimeMillis;
        }
        return calendarDate.copy(i, i5, i6, j);
    }

    public static /* synthetic */ String format$default(CalendarDate calendarDate, CalendarModel calendarModel, String str, Locale locale, int i, Object obj) {
        if ((i & 4) != 0) {
            locale = Locale.getDefault();
            AbstractC4492zt.g(locale, "getDefault()");
        }
        return calendarDate.format(calendarModel, str, locale);
    }

    public final int component1() {
        return this.year;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.dayOfMonth;
    }

    public final long component4() {
        return this.utcTimeMillis;
    }

    public final CalendarDate copy(int i, int i2, int i3, long j) {
        return new CalendarDate(i, i2, i3, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarDate)) {
            return false;
        }
        CalendarDate calendarDate = (CalendarDate) obj;
        return this.year == calendarDate.year && this.month == calendarDate.month && this.dayOfMonth == calendarDate.dayOfMonth && this.utcTimeMillis == calendarDate.utcTimeMillis;
    }

    public final String format(CalendarModel calendarModel, String str, Locale locale) {
        AbstractC4492zt.h(calendarModel, "calendarModel");
        AbstractC4492zt.h(str, "skeleton");
        AbstractC4492zt.h(locale, "locale");
        return calendarModel.formatWithSkeleton(this, str, locale);
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getMonth() {
        return this.month;
    }

    public final long getUtcTimeMillis() {
        return this.utcTimeMillis;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((((this.year * 31) + this.month) * 31) + this.dayOfMonth) * 31) + AbstractC0723Lm.a(this.utcTimeMillis);
    }

    public String toString() {
        return "CalendarDate(year=" + this.year + ", month=" + this.month + ", dayOfMonth=" + this.dayOfMonth + ", utcTimeMillis=" + this.utcTimeMillis + ')';
    }

    @Override // java.lang.Comparable
    public int compareTo(CalendarDate calendarDate) {
        AbstractC4492zt.h(calendarDate, "other");
        return AbstractC4492zt.k(this.utcTimeMillis, calendarDate.utcTimeMillis);
    }
}
