package androidx.compose.material3;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3779r9;
import defpackage.AbstractC4492zt;
import defpackage.C2020dG;
import defpackage.HV;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
public final class CalendarModelImpl implements CalendarModel {
    public static final Companion Companion = new Companion(null);
    private static final ZoneId utcTimeZoneId;
    private final int firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek().getValue();
    private final List<C2020dG> weekdayNames;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final String formatWithPattern(long j, String str, Locale locale) {
            AbstractC4492zt.h(str, "pattern");
            AbstractC4492zt.h(locale, "locale");
            DateTimeFormatter dateTimeFormatterWithDecimalStyle = DateTimeFormatter.ofPattern(str, locale).withDecimalStyle(DecimalStyle.of(locale));
            AbstractC4492zt.g(dateTimeFormatterWithDecimalStyle, "ofPattern(pattern, local…(DecimalStyle.of(locale))");
            String str2 = Instant.ofEpochMilli(j).atZone(getUtcTimeZoneId$material3_release()).toLocalDate().format(dateTimeFormatterWithDecimalStyle);
            AbstractC4492zt.g(str2, "ofEpochMilli(utcTimeMill…       .format(formatter)");
            return str2;
        }

        public final ZoneId getUtcTimeZoneId$material3_release() {
            return CalendarModelImpl.utcTimeZoneId;
        }

        private Companion() {
        }
    }

    static {
        ZoneId zoneIdOf = ZoneId.of("UTC");
        AbstractC4492zt.g(zoneIdOf, "of(\"UTC\")");
        utcTimeZoneId = zoneIdOf;
    }

    public CalendarModelImpl() {
        Locale locale = Locale.getDefault();
        DayOfWeek[] dayOfWeekArrValues = DayOfWeek.values();
        ArrayList arrayList = new ArrayList(dayOfWeekArrValues.length);
        for (DayOfWeek dayOfWeek : dayOfWeekArrValues) {
            arrayList.add(HV.a(dayOfWeek.getDisplayName(TextStyle.FULL, locale), dayOfWeek.getDisplayName(TextStyle.NARROW, locale)));
        }
        this.weekdayNames = arrayList;
    }

    private final LocalDate toLocalDate(CalendarMonth calendarMonth) {
        LocalDate localDate = Instant.ofEpochMilli(calendarMonth.getStartUtcTimeMillis()).atZone(utcTimeZoneId).toLocalDate();
        AbstractC4492zt.g(localDate, "ofEpochMilli(startUtcTim…TimeZoneId).toLocalDate()");
        return localDate;
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
        LocalDate localDate = Instant.ofEpochMilli(j).atZone(utcTimeZoneId).toLocalDate();
        return new CalendarDate(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), localDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * ((long) 1000));
    }

    @Override // androidx.compose.material3.CalendarModel
    public DateInputFormat getDateInputFormat(Locale locale) {
        AbstractC4492zt.h(locale, "locale");
        String localizedDateTimePattern = DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.SHORT, null, Chronology.ofLocale(locale), locale);
        AbstractC4492zt.g(localizedDateTimePattern, "getLocalizedDateTimePatt…= */ locale\n            )");
        return CalendarModelKt.datePatternAsInputFormat(localizedDateTimePattern);
    }

    @Override // androidx.compose.material3.CalendarModel
    public int getDayOfWeek(CalendarDate calendarDate) {
        AbstractC4492zt.h(calendarDate, DublinCoreProperties.DATE);
        return toLocalDate(calendarDate).getDayOfWeek().getValue();
    }

    @Override // androidx.compose.material3.CalendarModel
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth getMonth(long j) {
        LocalDate localDate = Instant.ofEpochMilli(j).atZone(utcTimeZoneId).withDayOfMonth(1).toLocalDate();
        AbstractC4492zt.g(localDate, "ofEpochMilli(timeInMilli…           .toLocalDate()");
        return getMonth(localDate);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarDate getToday() {
        LocalDate localDateNow = LocalDate.now();
        return new CalendarDate(localDateNow.getYear(), localDateNow.getMonthValue(), localDateNow.getDayOfMonth(), localDateNow.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli());
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
        LocalDate localDateMinusMonths = toLocalDate(calendarMonth).minusMonths(i);
        AbstractC4492zt.g(localDateMinusMonths, "earlierMonth");
        return getMonth(localDateMinusMonths);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarDate parse(String str, String str2) {
        AbstractC4492zt.h(str, DublinCoreProperties.DATE);
        AbstractC4492zt.h(str2, "pattern");
        try {
            LocalDate localDate = LocalDate.parse(str, DateTimeFormatter.ofPattern(str2));
            return new CalendarDate(localDate.getYear(), localDate.getMonth().getValue(), localDate.getDayOfMonth(), localDate.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli());
        } catch (DateTimeParseException unused) {
            return null;
        }
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth plusMonths(CalendarMonth calendarMonth, int i) {
        AbstractC4492zt.h(calendarMonth, TypedValues.TransitionType.S_FROM);
        if (i <= 0) {
            return calendarMonth;
        }
        LocalDate localDatePlusMonths = toLocalDate(calendarMonth).plusMonths(i);
        AbstractC4492zt.g(localDatePlusMonths, "laterMonth");
        return getMonth(localDatePlusMonths);
    }

    public String toString() {
        return "CalendarModel";
    }

    private final LocalDate toLocalDate(CalendarDate calendarDate) {
        LocalDate localDateOf = LocalDate.of(calendarDate.getYear(), calendarDate.getMonth(), calendarDate.getDayOfMonth());
        AbstractC4492zt.g(localDateOf, "of(\n            this.yea…this.dayOfMonth\n        )");
        return localDateOf;
    }

    @Override // androidx.compose.material3.CalendarModel
    public /* synthetic */ String formatWithSkeleton(CalendarMonth calendarMonth, String str, Locale locale) {
        return AbstractC3779r9.b(this, calendarMonth, str, locale);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth getMonth(CalendarDate calendarDate) {
        AbstractC4492zt.h(calendarDate, DublinCoreProperties.DATE);
        LocalDate localDateOf = LocalDate.of(calendarDate.getYear(), calendarDate.getMonth(), 1);
        AbstractC4492zt.g(localDateOf, "of(date.year, date.month, 1)");
        return getMonth(localDateOf);
    }

    @Override // androidx.compose.material3.CalendarModel
    public CalendarMonth getMonth(int i, int i2) {
        LocalDate localDateOf = LocalDate.of(i, i2, 1);
        AbstractC4492zt.g(localDateOf, "of(year, month, 1)");
        return getMonth(localDateOf);
    }

    private final CalendarMonth getMonth(LocalDate localDate) {
        int value = localDate.getDayOfWeek().getValue() - getFirstDayOfWeek();
        if (value < 0) {
            value += 7;
        }
        return new CalendarMonth(localDate.getYear(), localDate.getMonthValue(), localDate.lengthOfMonth(), value, localDate.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli());
    }
}
