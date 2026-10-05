package org.apache.poi.ss.usermodel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class DateUtil {
    private static final int BAD_DATE = -1;
    private static final long DAY_MILLISECONDS = 86400000;
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final Pattern TIME_SEPARATOR_PATTERN = Pattern.compile(":");
    private static final Pattern date_ptrn1 = Pattern.compile("^\\[\\$\\-.*?\\]");
    private static final Pattern date_ptrn2 = Pattern.compile("^\\[[a-zA-Z]+\\]");
    private static final Pattern date_ptrn3 = Pattern.compile("^[yYmMdDhHsS\\-/,. :\"\\\\]+0?[ampAMP/]*$");

    public static final class FormatException extends Exception {
        public FormatException(String str) {
            super(str);
        }
    }

    public static int absoluteDay(Calendar calendar, boolean z) {
        return calendar.get(6) + daysInPriorYears(calendar.get(1), z);
    }

    public static double convertTime(String str) {
        try {
            return convertTimeInternal(str);
        } catch (FormatException e) {
            throw new IllegalArgumentException("Bad time format '" + str + "' expected 'HH:MM' or 'HH:MM:SS' - " + e.getMessage());
        }
    }

    private static double convertTimeInternal(String str) throws FormatException {
        String str2;
        int length = str.length();
        if (length < 4 || length > 8) {
            throw new FormatException("Bad length");
        }
        String[] strArrSplit = TIME_SEPARATOR_PATTERN.split(str);
        int length2 = strArrSplit.length;
        if (length2 == 2) {
            str2 = "00";
        } else {
            if (length2 != 3) {
                throw new FormatException("Expected 2 or 3 fields but got (" + strArrSplit.length + ")");
            }
            str2 = strArrSplit[2];
        }
        String str3 = strArrSplit[0];
        return ((double) (parseInt(str2, "second", 60) + ((parseInt(strArrSplit[1], "minute", 60) + (parseInt(str3, "hour", 24) * 60)) * 60))) / 86400.0d;
    }

    private static Calendar dayStart(Calendar calendar) {
        calendar.get(11);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.get(11);
        return calendar;
    }

    private static int daysInPriorYears(int i, boolean z) {
        if ((!z && i < 1900) || (z && i < 1900)) {
            throw new IllegalArgumentException("'year' must be 1900 or greater");
        }
        int i2 = i - 1;
        return ((i - (z ? 1904 : 1900)) * 365) + ((((i2 / 4) - (i2 / 100)) + (i2 / 400)) - 460);
    }

    public static double getExcelDate(Date date) {
        return getExcelDate(date, false);
    }

    public static Date getJavaDate(double d) {
        return getJavaDate(d, false);
    }

    private static double internalGetExcelDate(Calendar calendar, boolean z) {
        if (!z && calendar.get(1) < 1900) {
            return -1.0d;
        }
        if (z && calendar.get(1) < 1904) {
            return -1.0d;
        }
        double dAbsoluteDay = (((double) ((((((calendar.get(11) * 60) + calendar.get(12)) * 60) + calendar.get(13)) * 1000) + calendar.get(14))) / 8.64E7d) + ((double) absoluteDay(dayStart(calendar), z));
        if (z || dAbsoluteDay < 60.0d) {
            return z ? dAbsoluteDay - 1.0d : dAbsoluteDay;
        }
        return dAbsoluteDay + 1.0d;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004c  */
    public static boolean isADateFormat(int i, String str) {
        if (isInternalDateFormat(i)) {
            return true;
        }
        if (str == null || str.length() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int i2 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (i2 < str.length() - 1) {
                int i3 = i2 + 1;
                char cCharAt2 = str.charAt(i3);
                if (cCharAt == '\\') {
                    if (cCharAt2 != ' ' && cCharAt2 != '\\') {
                        switch (cCharAt2) {
                            case ',':
                            case '-':
                            case '.':
                                break;
                            default:
                                sb.append(cCharAt);
                                break;
                        }
                    }
                } else if (cCharAt == ';' && cCharAt2 == '@') {
                    i2 = i3;
                } else {
                    sb.append(cCharAt);
                }
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        String strReplaceAll = date_ptrn2.matcher(date_ptrn1.matcher(sb.toString()).replaceAll("")).replaceAll("");
        if (strReplaceAll.indexOf(59) > 0 && strReplaceAll.indexOf(59) < strReplaceAll.length() - 1) {
            strReplaceAll = strReplaceAll.substring(0, strReplaceAll.indexOf(59));
        }
        return date_ptrn3.matcher(strReplaceAll).matches();
    }

    public static boolean isCellDateFormatted(Cell cell) {
        CellStyle cellStyle;
        if (cell == null || !isValidExcelDate(cell.getNumericCellValue()) || (cellStyle = cell.getCellStyle()) == null) {
            return false;
        }
        return isADateFormat(cellStyle.getDataFormat(), cellStyle.getDataFormatString());
    }

    public static boolean isCellInternalDateFormatted(Cell cell) {
        if (cell != null && isValidExcelDate(cell.getNumericCellValue())) {
            return isInternalDateFormat(cell.getCellStyle().getDataFormat());
        }
        return false;
    }

    public static boolean isInternalDateFormat(int i) {
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return true;
            default:
                switch (i) {
                    case 45:
                    case 46:
                    case 47:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public static boolean isValidExcelDate(double d) {
        return d > -4.9E-324d;
    }

    private static int parseInt(String str, String str2, int i) {
        return parseInt(str, str2, 0, i - 1);
    }

    public static Date parseYYYYMMDDDate(String str) {
        try {
            return parseYYYYMMDDDateInternal(str);
        } catch (FormatException e) {
            throw new IllegalArgumentException("Bad time format " + str + " expected 'YYYY/MM/DD' - " + e.getMessage());
        }
    }

    private static Date parseYYYYMMDDDateInternal(String str) throws FormatException {
        if (str.length() != 10) {
            throw new FormatException("Bad length");
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(parseInt(str.substring(0, 4), "year", -32768, 32767), parseInt(str.substring(5, 7), "month", 1, 12) - 1, parseInt(str.substring(8, 10), "day", 1, 31), 0, 0, 0);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTime();
    }

    public static void setCalendar(Calendar calendar, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            i3 = 1;
            i4 = 1904;
        } else {
            i3 = i < 61 ? 0 : -1;
            i4 = 1900;
        }
        calendar.set(i4, 0, i + i3, 0, 0, 0);
        calendar.set(14, i2);
    }

    public static double getExcelDate(Date date, boolean z) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return internalGetExcelDate(gregorianCalendar, z);
    }

    public static Date getJavaDate(double d, boolean z) {
        if (!isValidExcelDate(d)) {
            return null;
        }
        int iFloor = (int) Math.floor(d);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        setCalendar(gregorianCalendar, iFloor, (int) (((d - ((double) iFloor)) * 8.64E7d) + 0.5d), z);
        return gregorianCalendar.getTime();
    }

    private static int parseInt(String str, String str2, int i, int i2) throws FormatException {
        try {
            int i3 = Integer.parseInt(str);
            if (i3 >= i && i3 <= i2) {
                return i3;
            }
            throw new FormatException(str2 + " value (" + i3 + ") is outside the allowable range(0.." + i2 + ")");
        } catch (NumberFormatException unused) {
            throw new FormatException("Bad int format '" + str + "' for " + str2 + " field");
        }
    }

    public static double getExcelDate(Calendar calendar, boolean z) {
        return internalGetExcelDate((Calendar) calendar.clone(), z);
    }
}
