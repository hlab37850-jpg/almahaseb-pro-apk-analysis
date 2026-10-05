package org.apache.poi.hssf.model;

import org.apache.poi.hssf.record.formula.Ptg;
import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.FormulaRenderer;

/* JADX INFO: loaded from: classes4.dex */
public final class HSSFFormulaParser {
    private HSSFFormulaParser() {
    }

    private static FormulaParsingWorkbook createParsingWorkbook(HSSFWorkbook hSSFWorkbook) {
        return HSSFEvaluationWorkbook.create(hSSFWorkbook);
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook) {
        return parse(str, hSSFWorkbook, 0);
    }

    public static String toFormulaString(HSSFWorkbook hSSFWorkbook, Ptg[] ptgArr) {
        return FormulaRenderer.toFormulaString(HSSFEvaluationWorkbook.create(hSSFWorkbook), ptgArr);
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook, int i) {
        return parse(str, hSSFWorkbook, i, -1);
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook, int i, int i2) {
        return FormulaParser.parse(str, createParsingWorkbook(hSSFWorkbook), i, i2);
    }
}
