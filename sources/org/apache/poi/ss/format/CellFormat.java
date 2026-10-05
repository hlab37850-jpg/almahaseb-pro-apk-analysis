package org.apache.poi.ss.format;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import org.apache.poi.ss.usermodel.Cell;

/* JADX INFO: loaded from: classes4.dex */
public class CellFormat {
    private final String format;
    private final CellFormatPart negNumFmt;
    private final CellFormatPart posNumFmt;
    private final CellFormatPart textFmt;
    private final CellFormatPart zeroNumFmt;
    private static final Pattern ONE_PART = Pattern.compile(CellFormatPart.FORMAT_PAT.pattern() + "(;|$)", 6);
    private static final CellFormatPart DEFAULT_TEXT_FORMAT = new CellFormatPart("@");
    public static final CellFormat GENERAL_FORMAT = new CellFormat("General") { // from class: org.apache.poi.ss.format.CellFormat.1
        @Override // org.apache.poi.ss.format.CellFormat
        public CellFormatResult apply(Object obj) {
            String string;
            if (obj == null) {
                string = "";
            } else {
                string = obj instanceof Number ? CellNumberFormatter.SIMPLE_NUMBER.format(obj) : obj.toString();
            }
            return new CellFormatResult(true, string, null);
        }
    };
    private static final Map<String, CellFormat> formatCache = new WeakHashMap();

    public static CellFormat getInstance(String str) {
        Map<String, CellFormat> map = formatCache;
        CellFormat cellFormat = map.get(str);
        if (cellFormat == null) {
            cellFormat = str.equals("General") ? GENERAL_FORMAT : new CellFormat(str);
            map.put(str, cellFormat);
        }
        return cellFormat;
    }

    public static int ultimateType(Cell cell) {
        int cellType = cell.getCellType();
        return cellType == 2 ? cell.getCachedFormulaResultType() : cellType;
    }

    public CellFormatResult apply(Object obj) {
        if (!(obj instanceof Number)) {
            return this.textFmt.apply(obj);
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (dDoubleValue > 0.0d) {
            return this.posNumFmt.apply(obj);
        }
        return dDoubleValue < 0.0d ? this.negNumFmt.apply(Double.valueOf(-dDoubleValue)) : this.zeroNumFmt.apply(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CellFormat) {
            return this.format.equals(((CellFormat) obj).format);
        }
        return false;
    }

    public int hashCode() {
        return this.format.hashCode();
    }

    private CellFormat(String str) {
        this.format = str;
        Matcher matcher = ONE_PART.matcher(str);
        ArrayList arrayList = new ArrayList();
        while (matcher.find()) {
            try {
                String strGroup = matcher.group();
                arrayList.add(new CellFormatPart(strGroup.endsWith(";") ? strGroup.substring(0, strGroup.length() - 1) : strGroup));
            } catch (RuntimeException e) {
                CellFormatter.logger.log(Level.WARNING, "Invalid format: " + CellFormatter.quote(matcher.group()), (Throwable) e);
                arrayList.add(null);
            }
        }
        int size = arrayList.size();
        if (size == 1) {
            CellFormatPart cellFormatPart = (CellFormatPart) arrayList.get(0);
            this.negNumFmt = cellFormatPart;
            this.zeroNumFmt = cellFormatPart;
            this.posNumFmt = cellFormatPart;
            this.textFmt = DEFAULT_TEXT_FORMAT;
            return;
        }
        if (size == 2) {
            CellFormatPart cellFormatPart2 = (CellFormatPart) arrayList.get(0);
            this.zeroNumFmt = cellFormatPart2;
            this.posNumFmt = cellFormatPart2;
            this.negNumFmt = (CellFormatPart) arrayList.get(1);
            this.textFmt = DEFAULT_TEXT_FORMAT;
            return;
        }
        if (size != 3) {
            this.posNumFmt = (CellFormatPart) arrayList.get(0);
            this.zeroNumFmt = (CellFormatPart) arrayList.get(1);
            this.negNumFmt = (CellFormatPart) arrayList.get(2);
            this.textFmt = (CellFormatPart) arrayList.get(3);
            return;
        }
        this.posNumFmt = (CellFormatPart) arrayList.get(0);
        this.zeroNumFmt = (CellFormatPart) arrayList.get(1);
        this.negNumFmt = (CellFormatPart) arrayList.get(2);
        this.textFmt = DEFAULT_TEXT_FORMAT;
    }

    public CellFormatResult apply(Cell cell) {
        int iUltimateType = ultimateType(cell);
        if (iUltimateType == 0) {
            return apply(Double.valueOf(cell.getNumericCellValue()));
        }
        if (iUltimateType == 1) {
            return apply(cell.getStringCellValue());
        }
        if (iUltimateType == 3) {
            return apply("");
        }
        if (iUltimateType != 4) {
            return apply("?");
        }
        return apply(cell.getStringCellValue());
    }

    public CellFormatResult apply(JLabel jLabel, Object obj) {
        CellFormatResult cellFormatResultApply = apply(obj);
        jLabel.setText(cellFormatResultApply.text);
        Color color = cellFormatResultApply.textColor;
        if (color != null) {
            jLabel.setForeground(color);
        }
        return cellFormatResultApply;
    }

    public CellFormatResult apply(JLabel jLabel, Cell cell) {
        int iUltimateType = ultimateType(cell);
        if (iUltimateType == 0) {
            return apply(jLabel, Double.valueOf(cell.getNumericCellValue()));
        }
        if (iUltimateType == 1) {
            return apply(jLabel, cell.getStringCellValue());
        }
        if (iUltimateType == 3) {
            return apply(jLabel, "");
        }
        if (iUltimateType != 4) {
            return apply(jLabel, "?");
        }
        return apply(jLabel, cell.getStringCellValue());
    }
}
