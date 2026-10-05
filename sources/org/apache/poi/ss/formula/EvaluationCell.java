package org.apache.poi.ss.formula;

/* JADX INFO: loaded from: classes4.dex */
public interface EvaluationCell {
    boolean getBooleanCellValue();

    int getCellType();

    int getColumnIndex();

    int getErrorCellValue();

    Object getIdentityKey();

    double getNumericCellValue();

    int getRowIndex();

    EvaluationSheet getSheet();

    String getStringCellValue();
}
