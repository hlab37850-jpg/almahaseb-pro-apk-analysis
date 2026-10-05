package org.apache.poi.ss.formula;

import org.apache.poi.hssf.record.formula.AreaI;
import org.apache.poi.hssf.record.formula.eval.AreaEval;
import org.apache.poi.hssf.record.formula.eval.AreaEvalBase;
import org.apache.poi.hssf.record.formula.eval.ValueEval;
import org.apache.poi.hssf.util.CellReference;

/* JADX INFO: loaded from: classes4.dex */
final class LazyAreaEval extends AreaEvalBase {
    private final SheetRefEvaluator _evaluator;

    public LazyAreaEval(AreaI areaI, SheetRefEvaluator sheetRefEvaluator) {
        super(areaI);
        this._evaluator = sheetRefEvaluator;
    }

    @Override // org.apache.poi.hssf.record.formula.eval.AreaEvalBase, org.apache.poi.hssf.record.formula.eval.AreaEval
    public ValueEval getRelativeValue(int i, int i2) {
        return this._evaluator.getEvalForCell((i + getFirstRow()) & 65535, (i2 + getFirstColumn()) & 255);
    }

    @Override // org.apache.poi.hssf.record.formula.eval.AreaEval
    public AreaEval offset(int i, int i2, int i3, int i4) {
        return new LazyAreaEval(new AreaI.OffsetArea(getFirstRow(), getFirstColumn(), i, i2, i3, i4), this._evaluator);
    }

    public String toString() {
        CellReference cellReference = new CellReference(getFirstRow(), getFirstColumn());
        CellReference cellReference2 = new CellReference(getLastRow(), getLastColumn());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(LazyAreaEval.class.getName());
        stringBuffer.append("[");
        stringBuffer.append(this._evaluator.getSheetName());
        stringBuffer.append('!');
        stringBuffer.append(cellReference.formatAsString());
        stringBuffer.append(':');
        stringBuffer.append(cellReference2.formatAsString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public LazyAreaEval getColumn(int i) {
        if (i < getWidth()) {
            int firstColumn = getFirstColumn() + i;
            return new LazyAreaEval(getFirstRow(), firstColumn, getLastRow(), firstColumn, this._evaluator);
        }
        throw new IllegalArgumentException("Invalid columnIndex " + i + ".  Allowable range is (0.." + getWidth() + ").");
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public LazyAreaEval getRow(int i) {
        if (i < getHeight()) {
            int firstRow = getFirstRow() + i;
            return new LazyAreaEval(firstRow, getFirstColumn(), firstRow, getLastColumn(), this._evaluator);
        }
        throw new IllegalArgumentException("Invalid rowIndex " + i + ".  Allowable range is (0.." + getHeight() + ").");
    }

    public LazyAreaEval(int i, int i2, int i3, int i4, SheetRefEvaluator sheetRefEvaluator) {
        super(i, i2, i3, i4);
        this._evaluator = sheetRefEvaluator;
    }
}
