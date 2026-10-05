package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: classes4.dex */
public interface FormulaEvaluator {
    void clearAllCachedResultValues();

    CellValue evaluate(Cell cell);

    int evaluateFormulaCell(Cell cell);

    Cell evaluateInCell(Cell cell);

    void notifyDeleteCell(Cell cell);

    void notifySetFormula(Cell cell);

    void notifyUpdateCell(Cell cell);
}
