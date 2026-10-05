package org.apache.poi.hssf.record.formula;

/* JADX INFO: loaded from: classes4.dex */
public final class FormulaShifter {
    private final int _amountToMove;
    private final int _externSheetIndex;
    private final int _firstMovedIndex;
    private final int _lastMovedIndex;

    private FormulaShifter(int i, int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("amountToMove must not be zero");
        }
        if (i2 > i3) {
            throw new IllegalArgumentException("firstMovedIndex, lastMovedIndex out of order");
        }
        this._externSheetIndex = i;
        this._firstMovedIndex = i2;
        this._lastMovedIndex = i3;
        this._amountToMove = i4;
    }

    private Ptg adjustPtg(Ptg ptg, int i) {
        return adjustPtgDueToRowMove(ptg, i);
    }

    private Ptg adjustPtgDueToRowMove(Ptg ptg, int i) {
        if (ptg instanceof RefPtg) {
            if (i != this._externSheetIndex) {
                return null;
            }
            return rowMoveRefPtg((RefPtg) ptg);
        }
        if (ptg instanceof Ref3DPtg) {
            Ref3DPtg ref3DPtg = (Ref3DPtg) ptg;
            if (this._externSheetIndex != ref3DPtg.getExternSheetIndex()) {
                return null;
            }
            return rowMoveRefPtg(ref3DPtg);
        }
        if (ptg instanceof Area2DPtgBase) {
            return i != this._externSheetIndex ? ptg : rowMoveAreaPtg((Area2DPtgBase) ptg);
        }
        if (!(ptg instanceof Area3DPtg)) {
            return null;
        }
        Area3DPtg area3DPtg = (Area3DPtg) ptg;
        if (this._externSheetIndex != area3DPtg.getExternSheetIndex()) {
            return null;
        }
        return rowMoveAreaPtg(area3DPtg);
    }

    private static Ptg createDeletedRef(Ptg ptg) {
        if (ptg instanceof RefPtg) {
            return new RefErrorPtg();
        }
        if (ptg instanceof Ref3DPtg) {
            return new DeletedRef3DPtg(((Ref3DPtg) ptg).getExternSheetIndex());
        }
        if (ptg instanceof AreaPtg) {
            return new AreaErrPtg();
        }
        if (ptg instanceof Area3DPtg) {
            return new DeletedArea3DPtg(((Area3DPtg) ptg).getExternSheetIndex());
        }
        throw new IllegalArgumentException("Unexpected ref ptg class (" + ptg.getClass().getName() + ")");
    }

    public static FormulaShifter createForRowShift(int i, int i2, int i3, int i4) {
        return new FormulaShifter(i, i2, i3, i4);
    }

    private Ptg rowMoveAreaPtg(AreaPtgBase areaPtgBase) {
        int firstRow = areaPtgBase.getFirstRow();
        int lastRow = areaPtgBase.getLastRow();
        int i = this._firstMovedIndex;
        if (i <= firstRow && lastRow <= this._lastMovedIndex) {
            areaPtgBase.setFirstRow(firstRow + this._amountToMove);
            areaPtgBase.setLastRow(lastRow + this._amountToMove);
            return areaPtgBase;
        }
        int i2 = this._amountToMove;
        int i3 = i + i2;
        int i4 = this._lastMovedIndex;
        int i5 = i4 + i2;
        if (firstRow < i && i4 < lastRow) {
            if (i3 < firstRow && firstRow <= i5) {
                areaPtgBase.setFirstRow(i5 + 1);
                return areaPtgBase;
            }
            if (i3 > lastRow || lastRow >= i5) {
                return null;
            }
            areaPtgBase.setLastRow(i3 - 1);
            return areaPtgBase;
        }
        if (i <= firstRow && firstRow <= i4) {
            if (i2 < 0) {
                areaPtgBase.setFirstRow(firstRow + i2);
                return areaPtgBase;
            }
            if (i3 > lastRow) {
                return null;
            }
            int i6 = firstRow + i2;
            if (i5 < lastRow) {
                areaPtgBase.setFirstRow(i6);
                return areaPtgBase;
            }
            int i7 = i4 + 1;
            if (i3 > i7) {
                i6 = i7;
            }
            areaPtgBase.setFirstRow(i6);
            areaPtgBase.setLastRow(Math.max(lastRow, i5));
            return areaPtgBase;
        }
        if (i <= lastRow && lastRow <= i4) {
            if (i2 > 0) {
                areaPtgBase.setLastRow(lastRow + i2);
                return areaPtgBase;
            }
            if (i5 < firstRow) {
                return null;
            }
            int i8 = lastRow + i2;
            if (i3 > firstRow) {
                areaPtgBase.setLastRow(i8);
                return areaPtgBase;
            }
            int i9 = i - 1;
            if (i5 < i9) {
                i8 = i9;
            }
            areaPtgBase.setFirstRow(Math.min(firstRow, i3));
            areaPtgBase.setLastRow(i8);
            return areaPtgBase;
        }
        if (i5 < firstRow || lastRow < i3) {
            return null;
        }
        if (i3 <= firstRow && lastRow <= i5) {
            return createDeletedRef(areaPtgBase);
        }
        if (firstRow <= i3 && i5 <= lastRow) {
            return null;
        }
        if (i3 < firstRow && firstRow <= i5) {
            areaPtgBase.setFirstRow(i5 + 1);
            return areaPtgBase;
        }
        if (i3 < lastRow && lastRow <= i5) {
            areaPtgBase.setLastRow(i3 - 1);
            return areaPtgBase;
        }
        throw new IllegalStateException("Situation not covered: (" + this._firstMovedIndex + ", " + this._lastMovedIndex + ", " + this._amountToMove + ", " + firstRow + ", " + lastRow + ")");
    }

    private Ptg rowMoveRefPtg(RefPtgBase refPtgBase) {
        int row = refPtgBase.getRow();
        int i = this._firstMovedIndex;
        if (i <= row && row <= this._lastMovedIndex) {
            refPtgBase.setRow(row + this._amountToMove);
            return refPtgBase;
        }
        int i2 = this._amountToMove;
        int i3 = i + i2;
        int i4 = this._lastMovedIndex + i2;
        if (i4 < row || row < i3) {
            return null;
        }
        if (i3 <= row && row <= i4) {
            return createDeletedRef(refPtgBase);
        }
        throw new IllegalStateException("Situation not covered: (" + this._firstMovedIndex + ", " + this._lastMovedIndex + ", " + this._amountToMove + ", " + row + ", " + row + ")");
    }

    public boolean adjustFormula(Ptg[] ptgArr, int i) {
        boolean z = false;
        for (int i2 = 0; i2 < ptgArr.length; i2++) {
            Ptg ptgAdjustPtg = adjustPtg(ptgArr[i2], i);
            if (ptgAdjustPtg != null) {
                ptgArr[i2] = ptgAdjustPtg;
                z = true;
            }
        }
        return z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(FormulaShifter.class.getName());
        stringBuffer.append(" [");
        stringBuffer.append(this._firstMovedIndex);
        stringBuffer.append(this._lastMovedIndex);
        stringBuffer.append(this._amountToMove);
        return stringBuffer.toString();
    }
}
