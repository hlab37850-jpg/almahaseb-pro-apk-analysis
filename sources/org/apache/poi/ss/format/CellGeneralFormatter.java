package org.apache.poi.ss.format;

import java.util.Formatter;

/* JADX INFO: loaded from: classes4.dex */
public class CellGeneralFormatter extends CellFormatter {
    public CellGeneralFormatter() {
        super("General");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0057  */
    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0068 A[LOOP:0: B:26:0x0062->B:28:0x0068, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0077  */
    /* JADX WARN: Code duplicated, block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer stringBuffer, Object obj) {
        String str;
        boolean z;
        int length;
        int i;
        if (!(obj instanceof Number)) {
            stringBuffer.append(obj.toString());
            return;
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (dDoubleValue == 0.0d) {
            stringBuffer.append('0');
            return;
        }
        double dLog10 = Math.log10(Math.abs(dDoubleValue));
        if (dLog10 <= 10.0d && dLog10 >= -9.0d) {
            if (((long) dDoubleValue) != dDoubleValue) {
                str = "%1.9f";
            } else {
                str = "%1.0f";
                z = false;
            }
            new Formatter(stringBuffer).format(CellFormatter.LOCALE, str, obj);
            if (z) {
                if (str.endsWith("E")) {
                    length = stringBuffer.lastIndexOf("E");
                } else {
                    length = stringBuffer.length();
                }
                i = length - 1;
                while (stringBuffer.charAt(i) == '0') {
                    stringBuffer.deleteCharAt(i);
                    i--;
                }
                if (stringBuffer.charAt(i) == '.') {
                    stringBuffer.deleteCharAt(i);
                }
            }
        }
        str = "%1.5E";
        z = true;
        new Formatter(stringBuffer).format(CellFormatter.LOCALE, str, obj);
        if (z) {
            if (str.endsWith("E")) {
                length = stringBuffer.lastIndexOf("E");
            } else {
                length = stringBuffer.length();
            }
            i = length - 1;
            while (stringBuffer.charAt(i) == '0') {
                stringBuffer.deleteCharAt(i);
                i--;
            }
            if (stringBuffer.charAt(i) == '.') {
                stringBuffer.deleteCharAt(i);
            }
        }
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        formatValue(stringBuffer, obj);
    }
}
