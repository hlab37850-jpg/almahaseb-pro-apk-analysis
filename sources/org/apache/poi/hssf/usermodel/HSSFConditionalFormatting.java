package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.aggregates.CFRecordsAggregate;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.Region;

/* JADX INFO: loaded from: classes4.dex */
public final class HSSFConditionalFormatting {
    private final HSSFWorkbook _workbook;
    private final CFRecordsAggregate cfAggregate;

    public HSSFConditionalFormatting(HSSFWorkbook hSSFWorkbook, CFRecordsAggregate cFRecordsAggregate) {
        if (hSSFWorkbook == null) {
            throw new IllegalArgumentException("workbook must not be null");
        }
        if (cFRecordsAggregate == null) {
            throw new IllegalArgumentException("cfAggregate must not be null");
        }
        this._workbook = hSSFWorkbook;
        this.cfAggregate = cFRecordsAggregate;
    }

    public void addRule(HSSFConditionalFormattingRule hSSFConditionalFormattingRule) {
        this.cfAggregate.addRule(hSSFConditionalFormattingRule.getCfRuleRecord());
    }

    public CFRecordsAggregate getCFRecordsAggregate() {
        return this.cfAggregate;
    }

    public CellRangeAddress[] getFormattingRanges() {
        return this.cfAggregate.getHeader().getCellRanges();
    }

    public Region[] getFormattingRegions() {
        return Region.convertCellRangesToRegions(getFormattingRanges());
    }

    public int getNumberOfRules() {
        return this.cfAggregate.getNumberOfRules();
    }

    public HSSFConditionalFormattingRule getRule(int i) {
        return new HSSFConditionalFormattingRule(this._workbook, this.cfAggregate.getRule(i));
    }

    public void setRule(int i, HSSFConditionalFormattingRule hSSFConditionalFormattingRule) {
        this.cfAggregate.setRule(i, hSSFConditionalFormattingRule.getCfRuleRecord());
    }

    public String toString() {
        return this.cfAggregate.toString();
    }
}
