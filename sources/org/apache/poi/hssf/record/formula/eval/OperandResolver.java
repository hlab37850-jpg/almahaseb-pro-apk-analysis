package org.apache.poi.hssf.record.formula.eval;

import com.itextpdf.text.pdf.PdfBoolean;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class OperandResolver {
    private static final String Digits = "(\\p{Digit}+)";
    private static final String Exp = "[eE][+-]?(\\p{Digit}+)";
    private static final String fpRegex = "[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?))))[\\x00-\\x20]*";

    private OperandResolver() {
    }

    public static ValueEval chooseSingleElementFromArea(AreaEval areaEval, int i, int i2) throws EvaluationException {
        ValueEval valueEvalChooseSingleElementFromAreaInternal = chooseSingleElementFromAreaInternal(areaEval, i, i2);
        if (valueEvalChooseSingleElementFromAreaInternal instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEvalChooseSingleElementFromAreaInternal);
        }
        return valueEvalChooseSingleElementFromAreaInternal;
    }

    private static ValueEval chooseSingleElementFromAreaInternal(AreaEval areaEval, int i, int i2) throws EvaluationException {
        if (areaEval.isColumn()) {
            if (areaEval.isRow()) {
                return areaEval.getRelativeValue(0, 0);
            }
            if (areaEval.containsRow(i)) {
                return areaEval.getAbsoluteValue(i, areaEval.getFirstColumn());
            }
            throw EvaluationException.invalidValue();
        }
        if (areaEval.isRow()) {
            if (areaEval.containsColumn(i2)) {
                return areaEval.getAbsoluteValue(areaEval.getFirstRow(), i2);
            }
            throw EvaluationException.invalidValue();
        }
        if (areaEval.containsRow(i) && areaEval.containsColumn(i2)) {
            return areaEval.getAbsoluteValue(areaEval.getFirstRow(), areaEval.getFirstColumn());
        }
        throw EvaluationException.invalidValue();
    }

    public static Boolean coerceValueToBoolean(ValueEval valueEval, boolean z) throws EvaluationException {
        BlankEval blankEval;
        if (valueEval == null || valueEval == (blankEval = BlankEval.instance)) {
            return null;
        }
        if (valueEval instanceof BoolEval) {
            return Boolean.valueOf(((BoolEval) valueEval).getBooleanValue());
        }
        if (valueEval == blankEval) {
            return null;
        }
        if (valueEval instanceof StringEval) {
            if (z) {
                return null;
            }
            String stringValue = ((StringEval) valueEval).getStringValue();
            if (stringValue.equalsIgnoreCase(PdfBoolean.TRUE)) {
                return Boolean.TRUE;
            }
            if (stringValue.equalsIgnoreCase(PdfBoolean.FALSE)) {
                return Boolean.FALSE;
            }
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        if (valueEval instanceof NumericValueEval) {
            double numberValue = ((NumericValueEval) valueEval).getNumberValue();
            if (Double.isNaN(numberValue)) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            return Boolean.valueOf(numberValue != 0.0d);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        throw new RuntimeException("Unexpected eval (" + valueEval.getClass().getName() + ")");
    }

    public static double coerceValueToDouble(ValueEval valueEval) throws EvaluationException {
        if (valueEval == BlankEval.instance) {
            return 0.0d;
        }
        if (valueEval instanceof NumericValueEval) {
            return ((NumericValueEval) valueEval).getNumberValue();
        }
        if (valueEval instanceof StringEval) {
            Double d = parseDouble(((StringEval) valueEval).getStringValue());
            if (d != null) {
                return d.doubleValue();
            }
            throw EvaluationException.invalidValue();
        }
        throw new RuntimeException("Unexpected arg eval type (" + valueEval.getClass().getName() + ")");
    }

    public static int coerceValueToInt(ValueEval valueEval) {
        if (valueEval == BlankEval.instance) {
            return 0;
        }
        return (int) Math.floor(coerceValueToDouble(valueEval));
    }

    public static String coerceValueToString(ValueEval valueEval) {
        if (valueEval instanceof StringValueEval) {
            return ((StringValueEval) valueEval).getStringValue();
        }
        if (valueEval == BlankEval.instance) {
            return "";
        }
        throw new IllegalArgumentException("Unexpected eval class (" + valueEval.getClass().getName() + ")");
    }

    public static ValueEval getSingleValue(ValueEval valueEval, int i, int i2) {
        if (valueEval instanceof RefEval) {
            valueEval = ((RefEval) valueEval).getInnerValueEval();
        } else if (valueEval instanceof AreaEval) {
            valueEval = chooseSingleElementFromArea((AreaEval) valueEval, i, i2);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        return valueEval;
    }

    public static Double parseDouble(String str) {
        if (Pattern.matches(fpRegex, str)) {
            try {
                return Double.valueOf(Double.parseDouble(str));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }
}
