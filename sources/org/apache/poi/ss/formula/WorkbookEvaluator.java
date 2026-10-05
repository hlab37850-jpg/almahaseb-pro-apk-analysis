package org.apache.poi.ss.formula;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Stack;
import org.apache.poi.hssf.record.formula.Area3DPtg;
import org.apache.poi.hssf.record.formula.AreaErrPtg;
import org.apache.poi.hssf.record.formula.AreaPtg;
import org.apache.poi.hssf.record.formula.AttrPtg;
import org.apache.poi.hssf.record.formula.BoolPtg;
import org.apache.poi.hssf.record.formula.ControlPtg;
import org.apache.poi.hssf.record.formula.DeletedArea3DPtg;
import org.apache.poi.hssf.record.formula.DeletedRef3DPtg;
import org.apache.poi.hssf.record.formula.ErrPtg;
import org.apache.poi.hssf.record.formula.ExpPtg;
import org.apache.poi.hssf.record.formula.FuncVarPtg;
import org.apache.poi.hssf.record.formula.IntPtg;
import org.apache.poi.hssf.record.formula.MemAreaPtg;
import org.apache.poi.hssf.record.formula.MemErrPtg;
import org.apache.poi.hssf.record.formula.MemFuncPtg;
import org.apache.poi.hssf.record.formula.MissingArgPtg;
import org.apache.poi.hssf.record.formula.NamePtg;
import org.apache.poi.hssf.record.formula.NameXPtg;
import org.apache.poi.hssf.record.formula.NumberPtg;
import org.apache.poi.hssf.record.formula.OperationPtg;
import org.apache.poi.hssf.record.formula.Ptg;
import org.apache.poi.hssf.record.formula.Ref3DPtg;
import org.apache.poi.hssf.record.formula.RefErrorPtg;
import org.apache.poi.hssf.record.formula.RefPtg;
import org.apache.poi.hssf.record.formula.StringPtg;
import org.apache.poi.hssf.record.formula.UnionPtg;
import org.apache.poi.hssf.record.formula.UnknownPtg;
import org.apache.poi.hssf.record.formula.eval.BlankEval;
import org.apache.poi.hssf.record.formula.eval.BoolEval;
import org.apache.poi.hssf.record.formula.eval.ErrorEval;
import org.apache.poi.hssf.record.formula.eval.EvaluationException;
import org.apache.poi.hssf.record.formula.eval.MissingArgEval;
import org.apache.poi.hssf.record.formula.eval.NameEval;
import org.apache.poi.hssf.record.formula.eval.NumberEval;
import org.apache.poi.hssf.record.formula.eval.OperandResolver;
import org.apache.poi.hssf.record.formula.eval.StringEval;
import org.apache.poi.hssf.record.formula.eval.ValueEval;
import org.apache.poi.hssf.record.formula.functions.Choose;
import org.apache.poi.hssf.record.formula.functions.FreeRefFunction;
import org.apache.poi.hssf.record.formula.functions.IfFunc;
import org.apache.poi.hssf.record.formula.udf.UDFFinder;
import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.formula.eval.NotImplementedException;

/* JADX INFO: loaded from: classes4.dex */
public final class WorkbookEvaluator {
    private EvaluationCache _cache;
    private CollaboratingWorkbooksEnvironment _collaboratingWorkbookEnvironment;
    private final IEvaluationListener _evaluationListener;
    private final Map<String, Integer> _sheetIndexesByName;
    private final Map<EvaluationSheet, Integer> _sheetIndexesBySheet;
    private final IStabilityClassifier _stabilityClassifier;
    private final UDFFinder _udfFinder;
    private final EvaluationWorkbook _workbook;
    private int _workbookIx;

    public WorkbookEvaluator(EvaluationWorkbook evaluationWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this(evaluationWorkbook, null, iStabilityClassifier, uDFFinder);
    }

    private NotImplementedException addExceptionInfo(NotImplementedException notImplementedException, int i, int i2, int i3) {
        try {
            return new NotImplementedException("Error evaluating cell " + new CellReference(this._workbook.getSheetName(i), i2, i3, false, false).formatAsString(), notImplementedException);
        } catch (Exception e) {
            e.printStackTrace();
            return notImplementedException;
        }
    }

    private static int countTokensToBeSkipped(Ptg[] ptgArr, int i, int i2) {
        int i3 = i;
        while (i2 != 0) {
            i3++;
            i2 -= ptgArr[i3].getSize();
            if (i2 < 0) {
                throw new RuntimeException("Bad skip distance (wrong token size calculation).");
            }
            if (i3 >= ptgArr.length) {
                throw new RuntimeException("Skip distance too far (ran out of formula tokens).");
            }
        }
        return i3 - i;
    }

    public static ValueEval dereferenceResult(ValueEval valueEval, int i, int i2) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
            return singleValue == BlankEval.instance ? NumberEval.ZERO : singleValue;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private ValueEval evaluateAny(EvaluationCell evaluationCell, int i, int i2, int i3, EvaluationTracker evaluationTracker) {
        ValueEval valueEvalEvaluateFormula;
        IStabilityClassifier iStabilityClassifier = this._stabilityClassifier;
        boolean z = true;
        if (iStabilityClassifier != null && iStabilityClassifier.isCellFinal(i, i2, i3)) {
            z = false;
        }
        if (evaluationCell == null || evaluationCell.getCellType() != 2) {
            ValueEval valueFromNonFormulaCell = getValueFromNonFormulaCell(evaluationCell);
            if (z) {
                evaluationTracker.acceptPlainValueDependency(this._workbookIx, i, i2, i3, valueFromNonFormulaCell);
            }
            return valueFromNonFormulaCell;
        }
        FormulaCellCacheEntry orCreateFormulaCellEntry = this._cache.getOrCreateFormulaCellEntry(evaluationCell);
        if (z || orCreateFormulaCellEntry.isInputSensitive()) {
            evaluationTracker.acceptFormulaDependency(orCreateFormulaCellEntry);
        }
        IEvaluationListener iEvaluationListener = this._evaluationListener;
        if (orCreateFormulaCellEntry.getValue() != null) {
            if (iEvaluationListener != null) {
                iEvaluationListener.onCacheHit(i, i2, i3, orCreateFormulaCellEntry.getValue());
            }
            return orCreateFormulaCellEntry.getValue();
        }
        if (!evaluationTracker.startEvaluate(orCreateFormulaCellEntry)) {
            return ErrorEval.CIRCULAR_REF_ERROR;
        }
        OperationEvaluationContext operationEvaluationContext = new OperationEvaluationContext(this, this._workbook, i, i2, i3, evaluationTracker);
        try {
            try {
                Ptg[] formulaTokens = this._workbook.getFormulaTokens(evaluationCell);
                if (iEvaluationListener == null) {
                    valueEvalEvaluateFormula = evaluateFormula(operationEvaluationContext, formulaTokens);
                } else {
                    iEvaluationListener.onStartEvaluate(evaluationCell, orCreateFormulaCellEntry);
                    valueEvalEvaluateFormula = evaluateFormula(operationEvaluationContext, formulaTokens);
                    iEvaluationListener.onEndEvaluate(orCreateFormulaCellEntry, valueEvalEvaluateFormula);
                }
                evaluationTracker.updateCacheResult(valueEvalEvaluateFormula);
                evaluationTracker.endEvaluate(orCreateFormulaCellEntry);
                if (isDebugLogEnabled()) {
                    logDebug("Evaluated " + getSheetName(i) + "!" + new CellReference(i2, i3).formatAsString() + " to " + valueEvalEvaluateFormula.toString());
                }
                return valueEvalEvaluateFormula;
            } catch (NotImplementedException e) {
                throw addExceptionInfo(e, i, i2, i3);
            }
        } catch (Throwable th) {
            evaluationTracker.endEvaluate(orCreateFormulaCellEntry);
            throw th;
        }
    }

    private ValueEval getEvalForPtg(Ptg ptg, OperationEvaluationContext operationEvaluationContext) {
        if (ptg instanceof NamePtg) {
            EvaluationName name = this._workbook.getName((NamePtg) ptg);
            if (name.isFunctionName()) {
                return new NameEval(name.getNameText());
            }
            if (name.hasFormula()) {
                return evaluateNameFormula(name.getNameDefinition(), operationEvaluationContext);
            }
            throw new RuntimeException("Don't now how to evalate name '" + name.getNameText() + "'");
        }
        if (ptg instanceof NameXPtg) {
            return operationEvaluationContext.getNameXEval((NameXPtg) ptg);
        }
        if (ptg instanceof IntPtg) {
            return new NumberEval(((IntPtg) ptg).getValue());
        }
        if (ptg instanceof NumberPtg) {
            return new NumberEval(((NumberPtg) ptg).getValue());
        }
        if (ptg instanceof StringPtg) {
            return new StringEval(((StringPtg) ptg).getValue());
        }
        if (ptg instanceof BoolPtg) {
            return BoolEval.valueOf(((BoolPtg) ptg).getValue());
        }
        if (ptg instanceof ErrPtg) {
            return ErrorEval.valueOf(((ErrPtg) ptg).getErrorCode());
        }
        if (ptg instanceof MissingArgPtg) {
            return MissingArgEval.instance;
        }
        if ((ptg instanceof AreaErrPtg) || (ptg instanceof RefErrorPtg) || (ptg instanceof DeletedArea3DPtg) || (ptg instanceof DeletedRef3DPtg)) {
            return ErrorEval.REF_INVALID;
        }
        if (ptg instanceof Ref3DPtg) {
            Ref3DPtg ref3DPtg = (Ref3DPtg) ptg;
            return operationEvaluationContext.getRef3DEval(ref3DPtg.getRow(), ref3DPtg.getColumn(), ref3DPtg.getExternSheetIndex());
        }
        if (ptg instanceof Area3DPtg) {
            Area3DPtg area3DPtg = (Area3DPtg) ptg;
            return operationEvaluationContext.getArea3DEval(area3DPtg.getFirstRow(), area3DPtg.getFirstColumn(), area3DPtg.getLastRow(), area3DPtg.getLastColumn(), area3DPtg.getExternSheetIndex());
        }
        if (ptg instanceof RefPtg) {
            RefPtg refPtg = (RefPtg) ptg;
            return operationEvaluationContext.getRefEval(refPtg.getRow(), refPtg.getColumn());
        }
        if (ptg instanceof AreaPtg) {
            AreaPtg areaPtg = (AreaPtg) ptg;
            return operationEvaluationContext.getAreaEval(areaPtg.getFirstRow(), areaPtg.getFirstColumn(), areaPtg.getLastRow(), areaPtg.getLastColumn());
        }
        if (ptg instanceof UnknownPtg) {
            throw new RuntimeException("UnknownPtg not allowed");
        }
        if (ptg instanceof ExpPtg) {
            throw new RuntimeException("ExpPtg currently not supported");
        }
        throw new RuntimeException("Unexpected ptg class (" + ptg.getClass().getName() + ")");
    }

    private int getSheetIndex(EvaluationSheet evaluationSheet) {
        Integer numValueOf = this._sheetIndexesBySheet.get(evaluationSheet);
        if (numValueOf == null) {
            int sheetIndex = this._workbook.getSheetIndex(evaluationSheet);
            if (sheetIndex < 0) {
                throw new RuntimeException("Specified sheet from a different book");
            }
            numValueOf = Integer.valueOf(sheetIndex);
            this._sheetIndexesBySheet.put(evaluationSheet, numValueOf);
        }
        return numValueOf.intValue();
    }

    public static ValueEval getValueFromNonFormulaCell(EvaluationCell evaluationCell) {
        if (evaluationCell == null) {
            return BlankEval.instance;
        }
        int cellType = evaluationCell.getCellType();
        if (cellType == 0) {
            return new NumberEval(evaluationCell.getNumericCellValue());
        }
        if (cellType == 1) {
            return new StringEval(evaluationCell.getStringCellValue());
        }
        if (cellType == 3) {
            return BlankEval.instance;
        }
        if (cellType == 4) {
            return BoolEval.valueOf(evaluationCell.getBooleanCellValue());
        }
        if (cellType == 5) {
            return ErrorEval.valueOf(evaluationCell.getErrorCellValue());
        }
        throw new RuntimeException("Unexpected cell type (" + cellType + ")");
    }

    private static boolean isDebugLogEnabled() {
        return false;
    }

    private static void logDebug(String str) {
        if (isDebugLogEnabled()) {
            System.out.println(str);
        }
    }

    public void attachToEnvironment(CollaboratingWorkbooksEnvironment collaboratingWorkbooksEnvironment, EvaluationCache evaluationCache, int i) {
        this._collaboratingWorkbookEnvironment = collaboratingWorkbooksEnvironment;
        this._cache = evaluationCache;
        this._workbookIx = i;
    }

    public void clearAllCachedResultValues() {
        this._cache.clear();
        this._sheetIndexesBySheet.clear();
    }

    public void detachFromEnvironment() {
        this._collaboratingWorkbookEnvironment = CollaboratingWorkbooksEnvironment.EMPTY;
        this._cache = new EvaluationCache(this._evaluationListener);
        this._workbookIx = 0;
    }

    public ValueEval evaluate(EvaluationCell evaluationCell) {
        return evaluateAny(evaluationCell, getSheetIndex(evaluationCell.getSheet()), evaluationCell.getRowIndex(), evaluationCell.getColumnIndex(), new EvaluationTracker(this._cache));
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e2 A[PHI: r3
      0x00e2: PHI (r3v1 org.apache.poi.hssf.record.formula.Ptg) = (r3v0 org.apache.poi.hssf.record.formula.Ptg), (r3v6 org.apache.poi.hssf.record.formula.Ptg) binds: [B:5:0x000e, B:39:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:56:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:59:0x0100  */
    /* JADX WARN: Code duplicated, block: B:61:0x0109 A[LOOP:1: B:60:0x0107->B:61:0x0109, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:63:0x0119  */
    /* JADX WARN: Code duplicated, block: B:65:0x011f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x012b A[SYNTHETIC] */
    public ValueEval evaluateFormula(OperationEvaluationContext operationEvaluationContext, Ptg[] ptgArr) {
        ValueEval evalForPtg;
        OperationPtg operationPtg;
        ValueEval[] valueEvalArr;
        int i;
        int iCountTokensToBeSkipped;
        int chooseFuncOffset;
        int i2;
        Stack stack = new Stack();
        int length = ptgArr.length;
        int iCountTokensToBeSkipped2 = 0;
        while (iCountTokensToBeSkipped2 < length) {
            Ptg ptg = ptgArr[iCountTokensToBeSkipped2];
            if (ptg instanceof AttrPtg) {
                AttrPtg attrPtg = (AttrPtg) ptg;
                if (attrPtg.isSum()) {
                    ptg = FuncVarPtg.SUM;
                }
                if (attrPtg.isOptimizedChoose()) {
                    ValueEval valueEval = (ValueEval) stack.pop();
                    int[] jumpTable = attrPtg.getJumpTable();
                    int length2 = jumpTable.length;
                    try {
                        int iEvaluateFirstArg = Choose.evaluateFirstArg(valueEval, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                        if (iEvaluateFirstArg < 1 || iEvaluateFirstArg > length2) {
                            stack.push(ErrorEval.VALUE_INVALID);
                            chooseFuncOffset = attrPtg.getChooseFuncOffset();
                            i2 = chooseFuncOffset + 4;
                        } else {
                            i2 = jumpTable[iEvaluateFirstArg - 1];
                        }
                    } catch (EvaluationException e) {
                        stack.push(e.getErrorEval());
                        chooseFuncOffset = attrPtg.getChooseFuncOffset();
                    }
                    iCountTokensToBeSkipped = countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, i2 - ((length2 * 2) + 2));
                } else if (attrPtg.isOptimizedIf()) {
                    try {
                        if (!IfFunc.evaluateFirstArg((ValueEval) stack.pop(), operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex())) {
                            iCountTokensToBeSkipped2 += countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, attrPtg.getData());
                            int i3 = iCountTokensToBeSkipped2 + 1;
                            Ptg ptg2 = ptgArr[i3];
                            if ((ptgArr[iCountTokensToBeSkipped2] instanceof AttrPtg) && (ptg2 instanceof FuncVarPtg)) {
                                stack.push(BoolEval.FALSE);
                                iCountTokensToBeSkipped2 = i3;
                            }
                        }
                    } catch (EvaluationException e2) {
                        stack.push(e2.getErrorEval());
                        iCountTokensToBeSkipped2 += countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, attrPtg.getData());
                        iCountTokensToBeSkipped = countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, ((AttrPtg) ptgArr[iCountTokensToBeSkipped2]).getData() + 1);
                        iCountTokensToBeSkipped2 += iCountTokensToBeSkipped;
                    }
                } else if (attrPtg.isSkip()) {
                    iCountTokensToBeSkipped2 += countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, attrPtg.getData() + 1);
                    if (stack.peek() == MissingArgEval.instance) {
                        stack.pop();
                        stack.push(BlankEval.instance);
                    }
                } else if ((ptg instanceof ControlPtg) && !(ptg instanceof MemFuncPtg) && !(ptg instanceof MemAreaPtg) && !(ptg instanceof MemErrPtg)) {
                    if (ptg instanceof OperationPtg) {
                        operationPtg = (OperationPtg) ptg;
                        if (operationPtg instanceof UnionPtg) {
                            continue;
                        } else {
                            int numberOfOperands = operationPtg.getNumberOfOperands();
                            valueEvalArr = new ValueEval[numberOfOperands];
                            for (i = numberOfOperands - 1; i >= 0; i--) {
                                valueEvalArr[i] = (ValueEval) stack.pop();
                            }
                            evalForPtg = OperationEvaluatorFactory.evaluate(operationPtg, valueEvalArr, operationEvaluationContext);
                        }
                    } else {
                        evalForPtg = getEvalForPtg(ptg, operationEvaluationContext);
                    }
                    if (evalForPtg != null) {
                        throw new RuntimeException("Evaluation result must not be null");
                    }
                    stack.push(evalForPtg);
                }
                iCountTokensToBeSkipped2 += iCountTokensToBeSkipped;
            } else if (ptg instanceof ControlPtg) {
                continue;
            } else {
                if (ptg instanceof OperationPtg) {
                    operationPtg = (OperationPtg) ptg;
                    if (operationPtg instanceof UnionPtg) {
                        continue;
                    } else {
                        int numberOfOperands2 = operationPtg.getNumberOfOperands();
                        valueEvalArr = new ValueEval[numberOfOperands2];
                        while (i >= 0) {
                            valueEvalArr[i] = (ValueEval) stack.pop();
                        }
                        evalForPtg = OperationEvaluatorFactory.evaluate(operationPtg, valueEvalArr, operationEvaluationContext);
                    }
                } else {
                    evalForPtg = getEvalForPtg(ptg, operationEvaluationContext);
                }
                if (evalForPtg != null) {
                    throw new RuntimeException("Evaluation result must not be null");
                }
                stack.push(evalForPtg);
            }
            iCountTokensToBeSkipped2++;
        }
        ValueEval valueEval2 = (ValueEval) stack.pop();
        if (stack.isEmpty()) {
            return dereferenceResult(valueEval2, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        }
        throw new IllegalStateException("evaluation stack not empty");
    }

    public ValueEval evaluateNameFormula(Ptg[] ptgArr, OperationEvaluationContext operationEvaluationContext) {
        if (ptgArr.length <= 1) {
            return getEvalForPtg(ptgArr[0], operationEvaluationContext);
        }
        throw new RuntimeException("Complex name formulas not supported yet");
    }

    public ValueEval evaluateReference(EvaluationSheet evaluationSheet, int i, int i2, int i3, EvaluationTracker evaluationTracker) {
        return evaluateAny(evaluationSheet.getCell(i2, i3), i, i2, i3, evaluationTracker);
    }

    public FreeRefFunction findUserDefinedFunction(String str) {
        return this._udfFinder.findFunction(str);
    }

    public CollaboratingWorkbooksEnvironment getEnvironment() {
        return this._collaboratingWorkbookEnvironment;
    }

    public IEvaluationListener getEvaluationListener() {
        return this._evaluationListener;
    }

    public EvaluationName getName(String str, int i) {
        EvaluationWorkbook evaluationWorkbook = this._workbook;
        NamePtg namePtgCreatePtg = evaluationWorkbook instanceof HSSFEvaluationWorkbook ? ((HSSFEvaluationWorkbook) evaluationWorkbook).getName(str, i).createPtg() : null;
        if (namePtgCreatePtg == null) {
            return null;
        }
        return this._workbook.getName(namePtgCreatePtg);
    }

    public WorkbookEvaluator getOtherWorkbookEvaluator(String str) {
        return this._collaboratingWorkbookEnvironment.getWorkbookEvaluator(str);
    }

    public EvaluationSheet getSheet(int i) {
        return this._workbook.getSheet(i);
    }

    public int getSheetIndexByExternIndex(int i) {
        return this._workbook.convertFromExternSheetIndex(i);
    }

    public String getSheetName(int i) {
        return this._workbook.getSheetName(i);
    }

    public void notifyDeleteCell(EvaluationCell evaluationCell) {
        this._cache.notifyDeleteCell(this._workbookIx, getSheetIndex(evaluationCell.getSheet()), evaluationCell);
    }

    public void notifyUpdateCell(EvaluationCell evaluationCell) {
        this._cache.notifyUpdateCell(this._workbookIx, getSheetIndex(evaluationCell.getSheet()), evaluationCell);
    }

    public WorkbookEvaluator(EvaluationWorkbook evaluationWorkbook, IEvaluationListener iEvaluationListener, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this._workbook = evaluationWorkbook;
        this._evaluationListener = iEvaluationListener;
        this._cache = new EvaluationCache(iEvaluationListener);
        this._sheetIndexesBySheet = new IdentityHashMap();
        this._sheetIndexesByName = new IdentityHashMap();
        this._collaboratingWorkbookEnvironment = CollaboratingWorkbooksEnvironment.EMPTY;
        this._workbookIx = 0;
        this._stabilityClassifier = iStabilityClassifier;
        this._udfFinder = uDFFinder == null ? UDFFinder.DEFAULT : uDFFinder;
    }

    public int getSheetIndex(String str) {
        Integer numValueOf = this._sheetIndexesByName.get(str);
        if (numValueOf == null) {
            int sheetIndex = this._workbook.getSheetIndex(str);
            if (sheetIndex < 0) {
                return -1;
            }
            numValueOf = Integer.valueOf(sheetIndex);
            this._sheetIndexesByName.put(str, numValueOf);
        }
        return numValueOf.intValue();
    }
}
