package com.itextpdf.text.pdf;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

/* JADX INFO: loaded from: classes3.dex */
public class PdfDate extends PdfString {
    private static final int[] DATE_SPACE = {1, 4, 0, 2, 2, -1, 5, 2, 0, 11, 2, 0, 12, 2, 0, 13, 2, 0};

    public PdfDate(Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer("D:");
        stringBuffer.append(setLength(calendar.get(1), 4));
        stringBuffer.append(setLength(calendar.get(2) + 1, 2));
        stringBuffer.append(setLength(calendar.get(5), 2));
        stringBuffer.append(setLength(calendar.get(11), 2));
        stringBuffer.append(setLength(calendar.get(12), 2));
        stringBuffer.append(setLength(calendar.get(13), 2));
        int i = (calendar.get(15) + calendar.get(16)) / 3600000;
        if (i == 0) {
            stringBuffer.append('Z');
        } else if (i < 0) {
            stringBuffer.append('-');
            i = -i;
        } else {
            stringBuffer.append('+');
        }
        if (i != 0) {
            stringBuffer.append(setLength(i, 2));
            stringBuffer.append('\'');
            stringBuffer.append(setLength(Math.abs((calendar.get(15) + calendar.get(16)) / 60000) - (i * 60), 2));
            stringBuffer.append('\'');
        }
        this.value = stringBuffer.toString();
    }

    public static Calendar decode(String str) {
        GregorianCalendar gregorianCalendar;
        try {
            if (str.startsWith("D:")) {
                str = str.substring(2);
            }
            int length = str.length();
            int iIndexOf = str.indexOf(90);
            int i = 0;
            if (iIndexOf >= 0) {
                gregorianCalendar = new GregorianCalendar(new SimpleTimeZone(0, "ZPDF"));
            } else {
                iIndexOf = str.indexOf(43);
                int i2 = 1;
                if (iIndexOf < 0 && (iIndexOf = str.indexOf(45)) >= 0) {
                    i2 = -1;
                }
                if (iIndexOf < 0) {
                    iIndexOf = length;
                    gregorianCalendar = new GregorianCalendar();
                } else {
                    int i3 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf + 3)) * 60;
                    if (iIndexOf + 5 < str.length()) {
                        i3 += Integer.parseInt(str.substring(iIndexOf + 4, iIndexOf + 6));
                    }
                    gregorianCalendar = new GregorianCalendar(new SimpleTimeZone(i3 * i2 * 60000, "ZPDF"));
                }
            }
            gregorianCalendar.clear();
            int i4 = 0;
            while (true) {
                int[] iArr = DATE_SPACE;
                if (i >= iArr.length || i4 >= iIndexOf) {
                    break;
                    break;
                }
                int i5 = i + 1;
                gregorianCalendar.set(iArr[i], Integer.parseInt(str.substring(i4, iArr[i5] + i4)) + iArr[i + 2]);
                i4 += iArr[i5];
                i += 3;
            }
            return gregorianCalendar;
        } catch (Exception unused) {
            return null;
        }
    }

    private String setLength(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i);
        while (stringBuffer.length() < i2) {
            stringBuffer.insert(0, "0");
        }
        stringBuffer.setLength(i2);
        return stringBuffer.toString();
    }

    public String getW3CDate() {
        return getW3CDate(this.value);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ee  */
    public static String getW3CDate(String str) {
        String strSubstring;
        if (str.startsWith("D:")) {
            str = str.substring(2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() < 4) {
            return "0000";
        }
        stringBuffer.append(str.substring(0, 4));
        String strSubstring2 = str.substring(4);
        if (strSubstring2.length() < 2) {
            return stringBuffer.toString();
        }
        stringBuffer.append('-');
        stringBuffer.append(strSubstring2.substring(0, 2));
        String strSubstring3 = strSubstring2.substring(2);
        if (strSubstring3.length() < 2) {
            return stringBuffer.toString();
        }
        stringBuffer.append('-');
        stringBuffer.append(strSubstring3.substring(0, 2));
        String strSubstring4 = strSubstring3.substring(2);
        if (strSubstring4.length() < 2) {
            return stringBuffer.toString();
        }
        stringBuffer.append('T');
        stringBuffer.append(strSubstring4.substring(0, 2));
        String strSubstring5 = strSubstring4.substring(2);
        if (strSubstring5.length() < 2) {
            stringBuffer.append(":00Z");
            return stringBuffer.toString();
        }
        stringBuffer.append(':');
        stringBuffer.append(strSubstring5.substring(0, 2));
        String strSubstring6 = strSubstring5.substring(2);
        if (strSubstring6.length() < 2) {
            stringBuffer.append('Z');
            return stringBuffer.toString();
        }
        stringBuffer.append(':');
        stringBuffer.append(strSubstring6.substring(0, 2));
        String strSubstring7 = strSubstring6.substring(2);
        if (strSubstring7.startsWith("-") || strSubstring7.startsWith("+")) {
            String strSubstring8 = strSubstring7.substring(0, 1);
            String strSubstring9 = strSubstring7.substring(1);
            if (strSubstring9.length() >= 2) {
                String strSubstring10 = strSubstring9.substring(0, 2);
                if (strSubstring9.length() > 2) {
                    String strSubstring11 = strSubstring9.substring(3);
                    if (strSubstring11.length() >= 2) {
                        strSubstring = strSubstring11.substring(0, 2);
                    } else {
                        strSubstring = "00";
                    }
                } else {
                    strSubstring = "00";
                }
                stringBuffer.append(strSubstring8);
                stringBuffer.append(strSubstring10);
                stringBuffer.append(':');
                stringBuffer.append(strSubstring);
                return stringBuffer.toString();
            }
        }
        stringBuffer.append('Z');
        return stringBuffer.toString();
    }

    public PdfDate() {
        this(new GregorianCalendar());
    }
}
