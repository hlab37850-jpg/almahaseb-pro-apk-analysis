package org.apache.poi.hssf.record.formula.eval;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RefEvalBase implements RefEval {
    private final int _columnIndex;
    private final int _rowIndex;

    public RefEvalBase(int i, int i2) {
        this._rowIndex = i;
        this._columnIndex = i2;
    }

    @Override // org.apache.poi.hssf.record.formula.eval.RefEval
    public final int getColumn() {
        return this._columnIndex;
    }

    @Override // org.apache.poi.hssf.record.formula.eval.RefEval
    public final int getRow() {
        return this._rowIndex;
    }
}
