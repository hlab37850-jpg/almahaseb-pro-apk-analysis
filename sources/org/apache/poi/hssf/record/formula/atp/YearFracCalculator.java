package org.apache.poi.hssf.record.formula.atp;

import androidx.compose.material3.CalendarModelKt;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.poi.hssf.record.formula.eval.ErrorEval;
import org.apache.poi.hssf.record.formula.eval.EvaluationException;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes4.dex */
final class YearFracCalculator {
    private static final int DAYS_PER_LEAP_YEAR = 366;
    private static final int DAYS_PER_NORMAL_YEAR = 365;
    private static final int LONG_FEB_LEN = 29;
    private static final int LONG_MONTH_LEN = 31;
    private static final int MS_PER_DAY = 86400000;
    private static final int MS_PER_HOUR = 3600000;
    private static final int SHORT_FEB_LEN = 28;
    private static final int SHORT_MONTH_LEN = 30;
    private static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");

    public static final class SimpleDate {
        public static final int FEBRUARY = 2;
        public static final int JANUARY = 1;
        public final int day;
        public final int month;
        public long tsMilliseconds;
        public final int year;

        public SimpleDate(Calendar calendar) {
            this.year = calendar.get(1);
            this.month = calendar.get(2) + 1;
            this.day = calendar.get(5);
            this.tsMilliseconds = calendar.getTimeInMillis();
        }
    }

    private YearFracCalculator() {
    }

    private static double averageYearLength(int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 <= i2; i4++) {
            i3 = isLeapYear(i4) ? i3 + DAYS_PER_LEAP_YEAR : i3 + DAYS_PER_NORMAL_YEAR;
        }
        return ((double) i3) / ((double) ((i2 - i) + 1));
    }

    /* JADX WARN: Code duplicated, block: B:5:0x0014  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    public static double basis0(int i, int i2) {
        SimpleDate simpleDateCreateDate = createDate(i);
        SimpleDate simpleDateCreateDate2 = createDate(i2);
        int i3 = simpleDateCreateDate.day;
        int i4 = simpleDateCreateDate2.day;
        if (i3 == 31 && i4 == 31) {
            i3 = 30;
            i4 = 30;
        } else if (i3 == 31) {
            i3 = 30;
        } else if (i3 == 30 && i4 == 31) {
            i4 = 30;
        } else if (simpleDateCreateDate.month == 2 && isLastDayOfMonth(simpleDateCreateDate)) {
            if (simpleDateCreateDate2.month == 2 && isLastDayOfMonth(simpleDateCreateDate2)) {
                i3 = 30;
                i4 = 30;
            } else {
                i3 = 30;
            }
        }
        return calculateAdjusted(simpleDateCreateDate, simpleDateCreateDate2, i3, i4);
    }

    public static double basis1(int i, int i2) {
        double dAverageYearLength;
        SimpleDate simpleDateCreateDate = createDate(i);
        SimpleDate simpleDateCreateDate2 = createDate(i2);
        if (isGreaterThanOneYear(simpleDateCreateDate, simpleDateCreateDate2)) {
            dAverageYearLength = averageYearLength(simpleDateCreateDate.year, simpleDateCreateDate2.year);
        } else {
            dAverageYearLength = shouldCountFeb29(simpleDateCreateDate, simpleDateCreateDate2) ? 366.0d : 365.0d;
        }
        return ((double) dateDiff(simpleDateCreateDate.tsMilliseconds, simpleDateCreateDate2.tsMilliseconds)) / dAverageYearLength;
    }

    public static double basis2(int i, int i2) {
        return ((double) (i2 - i)) / 360.0d;
    }

    public static double basis3(double d, double d2) {
        return (d2 - d) / 365.0d;
    }

    public static double basis4(int i, int i2) {
        SimpleDate simpleDateCreateDate = createDate(i);
        SimpleDate simpleDateCreateDate2 = createDate(i2);
        int i3 = simpleDateCreateDate.day;
        int i4 = simpleDateCreateDate2.day;
        if (i3 == 31) {
            i3 = 30;
        }
        if (i4 == 31) {
            i4 = 30;
        }
        return calculateAdjusted(simpleDateCreateDate, simpleDateCreateDate2, i3, i4);
    }

    public static double calculate(double d, double d2, int i) throws EvaluationException {
        if (i < 0 || i >= 5) {
            throw new EvaluationException(ErrorEval.NUM_ERROR);
        }
        int iFloor = (int) Math.floor(d);
        int iFloor2 = (int) Math.floor(d2);
        if (iFloor == iFloor2) {
            return 0.0d;
        }
        if (iFloor > iFloor2) {
            iFloor2 = iFloor;
            iFloor = iFloor2;
        }
        if (i == 0) {
            return basis0(iFloor, iFloor2);
        }
        if (i == 1) {
            return basis1(iFloor, iFloor2);
        }
        if (i == 2) {
            return basis2(iFloor, iFloor2);
        }
        if (i == 3) {
            return basis3(iFloor, iFloor2);
        }
        if (i == 4) {
            return basis4(iFloor, iFloor2);
        }
        throw new IllegalStateException("cannot happen");
    }

    private static double calculateAdjusted(SimpleDate simpleDate, SimpleDate simpleDate2, int i, int i2) {
        return ((double) ((((simpleDate2.year - simpleDate.year) * 360) + ((simpleDate2.month - simpleDate.month) * 30)) + (i2 - i))) / 360.0d;
    }

    private static SimpleDate createDate(int i) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(UTC_TIME_ZONE);
        DateUtil.setCalendar(gregorianCalendar, i, 0, false);
        return new SimpleDate(gregorianCalendar);
    }

    private static int dateDiff(long j, long j2) {
        long j3 = j2 - j;
        if (((int) ((j3 % CalendarModelKt.MillisecondsIn24Hours) / 3600000)) == 0) {
            return (int) ((j3 / 8.64E7d) + 0.5d);
        }
        throw new RuntimeException("Unexpected date diff between " + j + " and " + j2);
    }

    private static int getLastDayOfMonth(SimpleDate simpleDate) {
        switch (simpleDate.month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
            default:
                return isLeapYear(simpleDate.year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
    }

    private static boolean isGreaterThanOneYear(SimpleDate simpleDate, SimpleDate simpleDate2) {
        int i = simpleDate.year;
        int i2 = simpleDate2.year;
        if (i == i2) {
            return false;
        }
        if (i + 1 != i2) {
            return true;
        }
        int i3 = simpleDate.month;
        int i4 = simpleDate2.month;
        if (i3 > i4) {
            return false;
        }
        return i3 < i4 || simpleDate.day < simpleDate2.day;
    }

    private static boolean isLastDayOfMonth(SimpleDate simpleDate) {
        int i = simpleDate.day;
        return i >= 28 && i == getLastDayOfMonth(simpleDate);
    }

    private static boolean isLeapYear(int i) {
        if (i % 4 != 0) {
            return false;
        }
        return i % 400 == 0 || i % 100 != 0;
    }

    private static boolean shouldCountFeb29(SimpleDate simpleDate, SimpleDate simpleDate2) {
        int i;
        boolean zIsLeapYear = isLeapYear(simpleDate.year);
        if (zIsLeapYear && simpleDate.year == simpleDate2.year) {
            return true;
        }
        boolean zIsLeapYear2 = isLeapYear(simpleDate2.year);
        if (!zIsLeapYear && !zIsLeapYear2) {
            return false;
        }
        if (zIsLeapYear) {
            int i2 = simpleDate.month;
            return i2 == 1 || i2 == 2;
        }
        if (!zIsLeapYear2 || (i = simpleDate2.month) == 1) {
            return false;
        }
        return i != 2 || simpleDate2.day == 29;
    }
}
