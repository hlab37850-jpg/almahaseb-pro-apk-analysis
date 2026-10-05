package androidx.compose.material3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC1805bc;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC3779r9;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.R5;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class LegacyCalendarModelImpl implements CalendarModel {
    public static final Companion Companion = new Companion(null);
    private static final TimeZone utcTimeZone;
    private final int firstDayOfWeek = dayInISO8601(Calendar.getInstance().getFirstDayOfWeek());
    private final List<C2020dG> weekdayNames;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final String formatWithPattern(long j, String str, Locale locale) {
            AbstractC4492zt.h(str, "pattern");
            AbstractC4492zt.h(locale, "locale");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
            simpleDateFormat.setTimeZone(getUtcTimeZone$material3_release());
            Calendar calendar = Calendar.getInstance(getUtcTimeZone$material3_release());
            calendar.setTimeInMillis(j);
            String str2 = simpleDateFormat.format(Long.valueOf(calendar.getTimeInMillis()));
            AbstractC4492zt.g(str2, "dateFormat.format(calendar.timeInMillis)");
            return str2;
        }

        public final TimeZone getUtcTimeZone$material3_release() {
            return LegacyCalendarModelImpl.utcTimeZone;
        }

        private Companion() {
        }
    }

    static {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        AbstractC4492zt.g(timeZone, "getTimeZone(\"UTC\")");
        utcTimeZone = timeZone;
    }

    public LegacyCalendarModelImpl() {
        List listC = AbstractC1805bc.c();
        String[] weekdays = new DateFormatSymbols(Locale.getDefault()).getWeekdays();
        String[] shortWeekdays = new DateFormatSymbols(Locale.getDefault()).getShortWeekdays();
        AbstractC4492zt.g(weekdays, "weekdays");
        int i = 0;
        for (Object obj : R5.G(weekdays, 2)) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC1886cc.w();
            }
            listC.add(new C2020dG((String) obj, shortWeekdays[i + 2]));
            i = i2;
        }
        listC.add(new C2020dG(weekdays[1], shortWeekdays[1]));
        this.weekdayNames = AbstractC1805bc.a(listC);
    }

    private final int dayInISO8601(int i) {
        int i2 = (i + 6) % 7;
        if (i2 == 0) {
            return 7;
        }
        return i2;
    }

    private final Calendar toCalendar(CalendarMonth calendarMonth) {
        Calendar calendar = Calendar.getInstance(utcTimeZone);
        calendar.setTimeInMillis(calendarMonth.getStartUtcTimeMillis());
        AbstractC4492zt.g(calendar, "calendar");
        return calendar;
    }

    @Override // androidx.compose.material3.CalendarModel
    public String formatWithPattern(long j, String str, Locale locale) {
        AbstractC4492zt.h(str, "pattern");
        AbstractC4492zt.h(locale, "locale");
        return Companion.formatWithPattern(j, str, locale);
    }

    @Override // androidx.compose.material3.CalendarModel
    public /* synthetic */ String formatWithSkeleton(CalendarDate calendarDate, String str, Locale locale) {
        return AbstractC3779r9.a(this, calendarDate, str, locale);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarDate getCanonicalDate(long j) {
        Calendar calendar = Calendar.getInstance(utcTimeZone);
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return new CalendarDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.getTimeInMillis());
    }

    @Override // androidx.compose.material3.CalendarModel
    public DateInputFormat getDateInputFormat(Locale locale) {
        AbstractC4492zt.h(locale, "locale");
        DateFormat dateInstance = DateFormat.getDateInstance(3, locale);
        AbstractC4492zt.f(dateInstance, "null cannot be cast to non-null type java.text.SimpleDateFormat");
        String pattern = ((SimpleDateFormat) dateInstance).toPattern();
        AbstractC4492zt.g(pattern, "DateFormat.getDateInstan…leDateFormat).toPattern()");
        return CalendarModelKt.datePatternAsInputFormat(pattern);
    }

    @Override // androidx.compose.material3.CalendarModel
    public int getDayOfWeek(CalendarDate calendarDate) {
        AbstractC4492zt.h(calendarDate, DublinCoreProperties.DATE);
        TimeZone timeZone = TimeZone.getDefault();
        AbstractC4492zt.g(timeZone, "getDefault()");
        return dayInISO8601(toCalendar(calendarDate, timeZone).get(7));
    }

    @Override // androidx.compose.material3.CalendarModel
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth getMonth(long j) {
        Calendar calendar = Calendar.getInstance(utcTimeZone);
        calendar.setTimeInMillis(j);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        AbstractC4492zt.g(calendar, "firstDayCalendar");
        return getMonth(calendar);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarDate getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return new CalendarDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.getTimeInMillis() + ((long) (calendar.get(15) + calendar.get(16))));
    }

    @Override // androidx.compose.material3.CalendarModel
    public List<C2020dG> getWeekdayNames() {
        return this.weekdayNames;
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth minusMonths(CalendarMonth calendarMonth, int i) {
        AbstractC4492zt.h(calendarMonth, TypedValues.TransitionType.S_FROM);
        if (i <= 0) {
            return calendarMonth;
        }
        Calendar calendar = toCalendar(calendarMonth);
        calendar.add(2, -i);
        return getMonth(calendar);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarDate parse(String str, String str2) {
        AbstractC4492zt.h(str, DublinCoreProperties.DATE);
        AbstractC4492zt.h(str2, "pattern");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
        TimeZone timeZone = utcTimeZone;
        simpleDateFormat.setTimeZone(timeZone);
        simpleDateFormat.setLenient(false);
        try {
            Date date = simpleDateFormat.parse(str);
            if (date == null) {
                return null;
            }
            Calendar calendar = Calendar.getInstance(timeZone);
            calendar.setTime(date);
            return new CalendarDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.getTimeInMillis());
        } catch (ParseException unused) {
            return null;
        }
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth plusMonths(CalendarMonth calendarMonth, int i) {
        AbstractC4492zt.h(calendarMonth, TypedValues.TransitionType.S_FROM);
        if (i <= 0) {
            return calendarMonth;
        }
        Calendar calendar = toCalendar(calendarMonth);
        calendar.add(2, i);
        return getMonth(calendar);
    }

    public String toString() {
        return "LegacyCalendarModel";
    }

    @Override // androidx.compose.material3.CalendarModel
    public /* synthetic */ String formatWithSkeleton(CalendarMonth calendarMonth, String str, Locale locale) {
        return AbstractC3779r9.b(this, calendarMonth, str, locale);
    }

    private final Calendar toCalendar(CalendarDate calendarDate, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.clear();
        calendar.set(1, calendarDate.getYear());
        calendar.set(2, calendarDate.getMonth() - 1);
        calendar.set(5, calendarDate.getDayOfMonth());
        AbstractC4492zt.g(calendar, "calendar");
        return calendar;
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth getMonth(CalendarDate calendarDate) {
        AbstractC4492zt.h(calendarDate, DublinCoreProperties.DATE);
        return getMonth(calendarDate.getYear(), calendarDate.getMonth());
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth getMonth(int i, int i2) {
        Calendar calendar = Calendar.getInstance(utcTimeZone);
        calendar.clear();
        calendar.set(1, i);
        calendar.set(2, i2 - 1);
        calendar.set(5, 1);
        AbstractC4492zt.g(calendar, "firstDayCalendar");
        return getMonth(calendar);
    }

    private final CalendarMonth getMonth(Calendar calendar) {
        int iDayInISO8601 = dayInISO8601(calendar.get(7)) - getFirstDayOfWeek();
        if (iDayInISO8601 < 0) {
            iDayInISO8601 += 7;
        }
        return new CalendarMonth(calendar.get(1), calendar.get(2) + 1, calendar.getActualMaximum(5), iDayInISO8601, calendar.getTimeInMillis());
    }
}
