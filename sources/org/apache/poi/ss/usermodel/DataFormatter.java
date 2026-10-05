package org.apache.poi.ss.usermodel;

import com.itextpdf.text.pdf.Barcode128;
import java.lang.reflect.InvocationTargetException;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class DataFormatter {
    private final DateFormatSymbols dateSymbols;
    private final DecimalFormatSymbols decimalSymbols;
    private Format defaultNumFormat;
    private final Map<String, Format> formats;
    private final Format generalDecimalNumFormat;
    private final Format generalWholeNumFormat;
    private static final Pattern numPattern = Pattern.compile("[0#]+");
    private static final Pattern daysAsText = Pattern.compile("([d]{3,})", 2);
    private static final Pattern amPmPattern = Pattern.compile("((A|P)[M/P]*)", 2);
    private static final Pattern specialPatternGroup = Pattern.compile("(\\[\\$[^-\\]]*-[0-9A-Z]+\\])");
    private static final Pattern colorPattern = Pattern.compile("(\\[BLACK\\])|(\\[BLUE\\])|(\\[CYAN\\])|(\\[GREEN\\])|(\\[MAGENTA\\])|(\\[RED\\])|(\\[WHITE\\])|(\\[YELLOW\\])|(\\[COLOR\\s*\\d\\])|(\\[COLOR\\s*[0-5]\\d\\])", 2);

    public DataFormatter() {
        this(Locale.getDefault());
    }

    private Format createDateFormat(String str, double d) {
        String strReplaceAll = str.replaceAll("\\\\-", "-").replaceAll("\\\\,", ",").replaceAll("\\\\ ", " ").replaceAll("\\\\/", "/").replaceAll(";@", "").replaceAll("\"/\"", "/");
        Matcher matcher = amPmPattern.matcher(strReplaceAll);
        boolean z = false;
        while (matcher.find()) {
            strReplaceAll = matcher.replaceAll("@");
            matcher = amPmPattern.matcher(strReplaceAll);
            z = true;
        }
        String strReplaceAll2 = strReplaceAll.replaceAll("@", "a");
        Matcher matcher2 = daysAsText.matcher(strReplaceAll2);
        if (matcher2.find()) {
            strReplaceAll2 = matcher2.replaceAll(matcher2.group(0).toUpperCase().replaceAll("D", "E"));
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = strReplaceAll2.toCharArray();
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (char c : charArray) {
            if (c == 'h' || c == 'H') {
                if (z) {
                    stringBuffer.append(Barcode128.START_B);
                } else {
                    stringBuffer.append('H');
                }
                z2 = false;
            } else if (c != 'm' && c != 'M') {
                if (c == 's' || c == 'S') {
                    stringBuffer.append('s');
                    for (int i = 0; i < arrayList.size(); i++) {
                        int iIntValue = ((Integer) arrayList.get(i)).intValue();
                        if (stringBuffer.charAt(iIntValue) == 'M') {
                            stringBuffer.replace(iIntValue, iIntValue + 1, "m");
                        }
                    }
                    arrayList.clear();
                } else if (Character.isLetter(c)) {
                    arrayList.clear();
                    if (c == 'y' || c == 'Y') {
                        stringBuffer.append('y');
                    } else if (c == 'd' || c == 'D') {
                        stringBuffer.append(Barcode128.CODE_AC_TO_B);
                    } else {
                        stringBuffer.append(c);
                    }
                } else {
                    stringBuffer.append(c);
                }
                z2 = true;
            } else if (z2) {
                stringBuffer.append('M');
                arrayList.add(Integer.valueOf(stringBuffer.length() - 1));
            } else {
                stringBuffer.append('m');
            }
        }
        try {
            return new ExcelStyleDateFormatter(stringBuffer.toString(), this.dateSymbols);
        } catch (IllegalArgumentException unused) {
            return getDefaultFormat(d);
        }
    }

    public static DecimalFormat createIntegerOnlyFormat(String str) {
        DecimalFormat decimalFormat = new DecimalFormat(str);
        decimalFormat.setParseIntegerOnly(true);
        return decimalFormat;
    }

    private Format createNumberFormat(String str, double d) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int i = 0;
        for (int i2 = 0; i2 < stringBuffer.length(); i2++) {
            char cCharAt = stringBuffer.charAt(i2);
            if ((cCharAt == '_' || cCharAt == '*') && (i2 <= 0 || stringBuffer.charAt(i2 - 1) != '\\')) {
                if (i2 < stringBuffer.length() - 1) {
                    stringBuffer.deleteCharAt(i2 + 1);
                }
                stringBuffer.deleteCharAt(i2);
            }
        }
        while (i < stringBuffer.length()) {
            char cCharAt2 = stringBuffer.charAt(i);
            if (cCharAt2 == '\\' || cCharAt2 == '\"') {
                stringBuffer.deleteCharAt(i);
            } else {
                if (cCharAt2 == '+' && i > 0 && stringBuffer.charAt(i - 1) == 'E') {
                    stringBuffer.deleteCharAt(i);
                }
                i++;
            }
            i--;
            i++;
        }
        try {
            DecimalFormat decimalFormat = new DecimalFormat(stringBuffer.toString(), this.decimalSymbols);
            setExcelStyleRoundingMode(decimalFormat);
            return decimalFormat;
        } catch (IllegalArgumentException unused) {
            return getDefaultFormat(d);
        }
    }

    private Format getFormat(Cell cell) {
        if (cell.getCellStyle() == null) {
            return null;
        }
        short dataFormat = cell.getCellStyle().getDataFormat();
        String dataFormatString = cell.getCellStyle().getDataFormatString();
        if (dataFormatString == null || dataFormatString.trim().length() == 0) {
            return null;
        }
        return getFormat(cell.getNumericCellValue(), dataFormat, dataFormatString);
    }

    private String getFormattedDateString(Cell cell) {
        Format format = getFormat(cell);
        if (format instanceof ExcelStyleDateFormatter) {
            ((ExcelStyleDateFormatter) format).setDateToBeFormatted(cell.getNumericCellValue());
        }
        return performDateFormatting(cell.getDateCellValue(), format);
    }

    private String getFormattedNumberString(Cell cell) {
        Format format = getFormat(cell);
        double numericCellValue = cell.getNumericCellValue();
        return format == null ? String.valueOf(numericCellValue) : format.format(new Double(numericCellValue));
    }

    private static boolean isWholeNumber(double d) {
        return d == Math.floor(d);
    }

    private String performDateFormatting(Date date, Format format) {
        return format != null ? format.format(date) : date.toString();
    }

    public static void setExcelStyleRoundingMode(DecimalFormat decimalFormat) {
        try {
            decimalFormat.getClass().getMethod("setRoundingMode", RoundingMode.class).invoke(decimalFormat, RoundingMode.HALF_UP);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to set rounding mode", e);
        } catch (NoSuchMethodException | SecurityException unused) {
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Unable to set rounding mode", e2);
        }
    }

    public void addFormat(String str, Format format) {
        this.formats.put(str, format);
    }

    public Format createFormat(Cell cell) {
        return createFormat(cell.getNumericCellValue(), cell.getCellStyle().getDataFormat(), cell.getCellStyle().getDataFormatString());
    }

    public String formatCellValue(Cell cell) {
        return formatCellValue(cell, null);
    }

    public String formatRawCellContents(double d, int i, String str) {
        return formatRawCellContents(d, i, str, false);
    }

    public Format getDefaultFormat(Cell cell) {
        return getDefaultFormat(cell.getNumericCellValue());
    }

    public void setDefaultNumberFormat(Format format) {
        for (Map.Entry<String, Format> entry : this.formats.entrySet()) {
            if (entry.getValue() == this.generalDecimalNumFormat || entry.getValue() == this.generalWholeNumFormat) {
                entry.setValue(format);
            }
        }
        this.defaultNumFormat = format;
    }

    public DataFormatter(Locale locale) {
        this.dateSymbols = new DateFormatSymbols(locale);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(locale);
        this.decimalSymbols = decimalFormatSymbols;
        this.generalWholeNumFormat = new DecimalFormat("#", decimalFormatSymbols);
        this.generalDecimalNumFormat = new DecimalFormat("#.##########", decimalFormatSymbols);
        this.formats = new HashMap();
        Format format = ZipPlusFourFormat.instance;
        addFormat("00000\\-0000", format);
        addFormat("00000-0000", format);
        Format format2 = PhoneFormat.instance;
        addFormat("[<=9999999]###\\-####;\\(###\\)\\ ###\\-####", format2);
        addFormat("[<=9999999]###-####;(###) ###-####", format2);
        addFormat("###\\-####;\\(###\\)\\ ###\\-####", format2);
        addFormat("###-####;(###) ###-####", format2);
        Format format3 = SSNFormat.instance;
        addFormat("000\\-00\\-0000", format3);
        addFormat("000-00-0000", format3);
    }

    private Format getDefaultFormat(double d) {
        Format format = this.defaultNumFormat;
        if (format != null) {
            return format;
        }
        return isWholeNumber(d) ? this.generalWholeNumFormat : this.generalDecimalNumFormat;
    }

    public String formatCellValue(Cell cell, FormulaEvaluator formulaEvaluator) {
        if (cell == null) {
            return "";
        }
        int cellType = cell.getCellType();
        if (cellType == 2) {
            if (formulaEvaluator == null) {
                return cell.getCellFormula();
            }
            cellType = formulaEvaluator.evaluateFormulaCell(cell);
        }
        if (cellType == 0) {
            return DateUtil.isCellDateFormatted(cell) ? getFormattedDateString(cell) : getFormattedNumberString(cell);
        }
        if (cellType == 1) {
            return cell.getRichStringCellValue().getString();
        }
        if (cellType == 3) {
            return "";
        }
        if (cellType == 4) {
            return String.valueOf(cell.getBooleanCellValue());
        }
        throw new RuntimeException("Unexpected celltype (" + cellType + ")");
    }

    public String formatRawCellContents(double d, int i, String str, boolean z) {
        if (!DateUtil.isADateFormat(i, str) || !DateUtil.isValidExcelDate(d)) {
            Format format = getFormat(d, i, str);
            return format == null ? String.valueOf(d) : format.format(new Double(d));
        }
        Format format2 = getFormat(d, i, str);
        if (format2 instanceof ExcelStyleDateFormatter) {
            ((ExcelStyleDateFormatter) format2).setDateToBeFormatted(d);
        }
        return performDateFormatting(DateUtil.getJavaDate(d, z), format2);
    }

    private Format createFormat(double d, int i, String str) {
        String strGroup;
        int iIndexOf;
        Matcher matcher = colorPattern.matcher(str);
        String str2 = str;
        while (matcher.find() && (iIndexOf = str2.indexOf((strGroup = matcher.group()))) != -1) {
            String str3 = str2.substring(0, iIndexOf) + str2.substring(iIndexOf + strGroup.length());
            if (str3.equals(str2)) {
                break;
            }
            matcher = colorPattern.matcher(str3);
            str2 = str3;
        }
        Matcher matcher2 = specialPatternGroup.matcher(str2);
        String str4 = str2;
        while (matcher2.find()) {
            String strGroup2 = matcher2.group();
            String strSubstring = strGroup2.substring(strGroup2.indexOf(36) + 1, strGroup2.indexOf(45));
            if (strSubstring.indexOf(36) > -1) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(strSubstring.substring(0, strSubstring.indexOf(36)));
                stringBuffer.append('\\');
                stringBuffer.append(strSubstring.substring(strSubstring.indexOf(36), strSubstring.length()));
                strSubstring = stringBuffer.toString();
            }
            String strReplaceAll = matcher2.replaceAll(strSubstring);
            matcher2 = specialPatternGroup.matcher(strReplaceAll);
            str4 = strReplaceAll;
        }
        if (str4 != null && str4.trim().length() != 0) {
            if (DateUtil.isADateFormat(i, str4) && DateUtil.isValidExcelDate(d)) {
                return createDateFormat(str4, d);
            }
            if (numPattern.matcher(str4).find()) {
                return createNumberFormat(str4, d);
            }
            return null;
        }
        return getDefaultFormat(d);
    }

    public static final class ZipPlusFourFormat extends Format {
        public static final Format instance = new ZipPlusFourFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("000000000");

        private ZipPlusFourFormat() {
        }

        public static String format(Number number) {
            String str = df.format(number);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 5));
            stringBuffer.append('-');
            stringBuffer.append(str.substring(5, 9));
            return stringBuffer.toString();
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            stringBuffer.append(format((Number) obj));
            return stringBuffer;
        }
    }

    public static final class SSNFormat extends Format {
        public static final Format instance = new SSNFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("000000000");

        private SSNFormat() {
        }

        public static String format(Number number) {
            String str = df.format(number);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 3));
            stringBuffer.append('-');
            stringBuffer.append(str.substring(3, 5));
            stringBuffer.append('-');
            stringBuffer.append(str.substring(5, 9));
            return stringBuffer.toString();
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            stringBuffer.append(format((Number) obj));
            return stringBuffer;
        }
    }

    private Format getFormat(double d, int i, String str) {
        if (str.indexOf(59) != str.lastIndexOf(59)) {
            int iLastIndexOf = str.lastIndexOf(59);
            String strSubstring = str.substring(iLastIndexOf + 1);
            str = str.substring(0, iLastIndexOf);
            if (d == 0.0d) {
                str = strSubstring;
            }
        }
        Format format = this.formats.get(str);
        if (format != null) {
            return format;
        }
        if (!"General".equals(str) && !"@".equals(str)) {
            Format formatCreateFormat = createFormat(d, i, str);
            this.formats.put(str, formatCreateFormat);
            return formatCreateFormat;
        }
        if (isWholeNumber(d)) {
            return this.generalWholeNumFormat;
        }
        return this.generalDecimalNumFormat;
    }

    public static final class PhoneFormat extends Format {
        public static final Format instance = new PhoneFormat();
        private static final DecimalFormat df = DataFormatter.createIntegerOnlyFormat("##########");

        private PhoneFormat() {
        }

        public static String format(Number number) {
            String str = df.format(number);
            StringBuffer stringBuffer = new StringBuffer();
            int length = str.length();
            if (length <= 4) {
                return str;
            }
            int i = length - 4;
            String strSubstring = str.substring(i, length);
            int i2 = length - 7;
            String strSubstring2 = str.substring(Math.max(0, i2), i);
            String strSubstring3 = str.substring(Math.max(0, length - 10), Math.max(0, i2));
            if (strSubstring3 != null && strSubstring3.trim().length() > 0) {
                stringBuffer.append('(');
                stringBuffer.append(strSubstring3);
                stringBuffer.append(") ");
            }
            if (strSubstring2 != null && strSubstring2.trim().length() > 0) {
                stringBuffer.append(strSubstring2);
                stringBuffer.append('-');
            }
            stringBuffer.append(strSubstring);
            return stringBuffer.toString();
        }

        @Override // java.text.Format
        public Object parseObject(String str, ParsePosition parsePosition) {
            return df.parseObject(str, parsePosition);
        }

        @Override // java.text.Format
        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            stringBuffer.append(format((Number) obj));
            return stringBuffer;
        }
    }
}
