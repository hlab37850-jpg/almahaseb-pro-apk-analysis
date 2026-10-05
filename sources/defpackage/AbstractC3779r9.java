package defpackage;

import androidx.compose.material3.CalendarDate;
import androidx.compose.material3.CalendarModel;
import androidx.compose.material3.CalendarModel_androidKt;
import androidx.compose.material3.CalendarMonth;
import androidx.compose.material3.DateInputFormat;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.Locale;

/* JADX INFO: renamed from: r9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC3779r9 {
    public static String a(CalendarModel calendarModel, CalendarDate calendarDate, String str, Locale locale) {
        AbstractC4492zt.h(calendarDate, DublinCoreProperties.DATE);
        AbstractC4492zt.h(str, "skeleton");
        AbstractC4492zt.h(locale, "locale");
        return CalendarModel_androidKt.formatWithSkeleton(calendarDate.getUtcTimeMillis(), str, locale);
    }

    public static String b(CalendarModel calendarModel, CalendarMonth calendarMonth, String str, Locale locale) {
        AbstractC4492zt.h(calendarMonth, "month");
        AbstractC4492zt.h(str, "skeleton");
        AbstractC4492zt.h(locale, "locale");
        return CalendarModel_androidKt.formatWithSkeleton(calendarMonth.getStartUtcTimeMillis(), str, locale);
    }

    public static /* synthetic */ String c(CalendarModel calendarModel, CalendarDate calendarDate, String str, Locale locale, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatWithSkeleton");
        }
        if ((i & 4) != 0) {
            locale = Locale.getDefault();
            AbstractC4492zt.g(locale, "getDefault()");
        }
        return calendarModel.formatWithSkeleton(calendarDate, str, locale);
    }

    public static /* synthetic */ String d(CalendarModel calendarModel, CalendarMonth calendarMonth, String str, Locale locale, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatWithSkeleton");
        }
        if ((i & 4) != 0) {
            locale = Locale.getDefault();
            AbstractC4492zt.g(locale, "getDefault()");
        }
        return calendarModel.formatWithSkeleton(calendarMonth, str, locale);
    }

    public static /* synthetic */ DateInputFormat e(CalendarModel calendarModel, Locale locale, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDateInputFormat");
        }
        if ((i & 1) != 0) {
            locale = Locale.getDefault();
            AbstractC4492zt.g(locale, "getDefault()");
        }
        return calendarModel.getDateInputFormat(locale);
    }
}
