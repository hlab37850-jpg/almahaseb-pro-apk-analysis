package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.hssf.record.aggregates.CFRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.Region;

/* JADX INFO: loaded from: classes4.dex */
public final class HSSFSheetConditionalFormatting {
    private final ConditionalFormattingTable _conditionalFormattingTable;
    private final HSSFSheet _sheet;

    public HSSFSheetConditionalFormatting(HSSFSheet hSSFSheet) {
        this._sheet = hSSFSheet;
        this._conditionalFormattingTable = hSSFSheet.getSheet().getConditionalFormattingTable();
    }

    public int addConditionalFormatting(HSSFConditionalFormatting hSSFConditionalFormatting) {
        return this._conditionalFormattingTable.add(hSSFConditionalFormatting.getCFRecordsAggregate().cloneCFAggregate());
    }

    public HSSFConditionalFormattingRule createConditionalFormattingRule(byte b, String str, String str2) {
        return new HSSFConditionalFormattingRule(this._sheet.getWorkbook(), CFRuleRecord.create(this._sheet, b, str, str2));
    }

    public HSSFConditionalFormatting getConditionalFormattingAt(int i) {
        CFRecordsAggregate cFRecordsAggregate = this._conditionalFormattingTable.get(i);
        if (cFRecordsAggregate == null) {
            return null;
        }
        return new HSSFConditionalFormatting(this._sheet.getWorkbook(), cFRecordsAggregate);
    }

    public int getNumConditionalFormattings() {
        return this._conditionalFormattingTable.size();
    }

    public void removeConditionalFormatting(int i) {
        this._conditionalFormattingTable.remove(i);
    }

    public int addConditionalFormatting(Region[] regionArr, HSSFConditionalFormattingRule[] hSSFConditionalFormattingRuleArr) {
        return addConditionalFormatting(Region.convertRegionsToCellRanges(regionArr), hSSFConditionalFormattingRuleArr);
    }

    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, HSSFConditionalFormattingRule[] hSSFConditionalFormattingRuleArr) {
        if (cellRangeAddressArr != null) {
            for (CellRangeAddress cellRangeAddress : cellRangeAddressArr) {
                cellRangeAddress.validate(SpreadsheetVersion.EXCEL97);
            }
            if (hSSFConditionalFormattingRuleArr != null) {
                if (hSSFConditionalFormattingRuleArr.length != 0) {
                    if (hSSFConditionalFormattingRuleArr.length <= 3) {
                        CFRuleRecord[] cFRuleRecordArr = new CFRuleRecord[hSSFConditionalFormattingRuleArr.length];
                        for (int i = 0; i != hSSFConditionalFormattingRuleArr.length; i++) {
                            cFRuleRecordArr[i] = hSSFConditionalFormattingRuleArr[i].getCfRuleRecord();
                        }
                        return this._conditionalFormattingTable.add(new CFRecordsAggregate(cellRangeAddressArr, cFRuleRecordArr));
                    }
                    throw new IllegalArgumentException("Number of rules must not exceed 3");
                }
                throw new IllegalArgumentException("cfRules must not be empty");
            }
            throw new IllegalArgumentException("cfRules must not be null");
        }
        throw new IllegalArgumentException("regions must not be null");
    }

    public HSSFConditionalFormattingRule createConditionalFormattingRule(String str) {
        return new HSSFConditionalFormattingRule(this._sheet.getWorkbook(), CFRuleRecord.create(this._sheet, str));
    }

    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, HSSFConditionalFormattingRule hSSFConditionalFormattingRule) {
        return addConditionalFormatting(cellRangeAddressArr, new HSSFConditionalFormattingRule[]{hSSFConditionalFormattingRule});
    }

    public int addConditionalFormatting(CellRangeAddress[] cellRangeAddressArr, HSSFConditionalFormattingRule hSSFConditionalFormattingRule, HSSFConditionalFormattingRule hSSFConditionalFormattingRule2) {
        return addConditionalFormatting(cellRangeAddressArr, new HSSFConditionalFormattingRule[]{hSSFConditionalFormattingRule, hSSFConditionalFormattingRule2});
    }
}
