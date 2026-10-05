package androidx.compose.material3;

import defpackage.C2020dG;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalMaterial3Api
public interface CalendarModel {
    String formatWithPattern(long j, String str, Locale locale);

    String formatWithSkeleton(CalendarDate calendarDate, String str, Locale locale);

    String formatWithSkeleton(CalendarMonth calendarMonth, String str, Locale locale);

    CalendarDate getCanonicalDate(long j);

    DateInputFormat getDateInputFormat(Locale locale);

    int getDayOfWeek(CalendarDate calendarDate);

    int getFirstDayOfWeek();

    CalendarMonth getMonth(int i, int i2);

    CalendarMonth getMonth(long j);

    CalendarMonth getMonth(CalendarDate calendarDate);

    CalendarDate getToday();

    List<C2020dG> getWeekdayNames();

    CalendarMonth minusMonths(CalendarMonth calendarMonth, int i);

    CalendarDate parse(String str, String str2);

    CalendarMonth plusMonths(CalendarMonth calendarMonth, int i);
}
