package org.apache.poi.hssf.record.formula.functions;

import java.util.regex.Pattern;
import org.apache.poi.hssf.record.formula.eval.BlankEval;
import org.apache.poi.hssf.record.formula.eval.BoolEval;
import org.apache.poi.hssf.record.formula.eval.ErrorEval;
import org.apache.poi.hssf.record.formula.eval.EvaluationException;
import org.apache.poi.hssf.record.formula.eval.NumberEval;
import org.apache.poi.hssf.record.formula.eval.OperandResolver;
import org.apache.poi.hssf.record.formula.eval.RefEval;
import org.apache.poi.hssf.record.formula.eval.StringEval;
import org.apache.poi.hssf.record.formula.eval.ValueEval;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.usermodel.ErrorConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class Countif extends Fixed2ArgFunction {

    public static final class BooleanMatcher extends MatcherBase {
        private final int _value;

        public BooleanMatcher(boolean z, CmpOp cmpOp) {
            super(cmpOp);
            this._value = boolToInt(z);
        }

        private static int boolToInt(boolean z) {
            return z ? 1 : 0;
        }

        @Override // org.apache.poi.hssf.record.formula.functions.Countif.MatcherBase
        public String getValueText() {
            return this._value == 1 ? "TRUE" : "FALSE";
        }

        @Override // org.apache.poi.hssf.record.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            if (!(valueEval instanceof StringEval) && (valueEval instanceof BoolEval)) {
                return evaluate(boolToInt(((BoolEval) valueEval).getBooleanValue()) - this._value);
            }
            return false;
        }
    }

    public static final class ErrorMatcher extends MatcherBase {
        private final int _value;

        public ErrorMatcher(int i, CmpOp cmpOp) {
            super(cmpOp);
            this._value = i;
        }

        @Override // org.apache.poi.hssf.record.formula.functions.Countif.MatcherBase
        public String getValueText() {
            return ErrorConstants.getText(this._value);
        }

        @Override // org.apache.poi.hssf.record.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            if (valueEval instanceof ErrorEval) {
                return evaluate(((ErrorEval) valueEval).getErrorCode() - this._value);
            }
            return false;
        }
    }

    public static abstract class MatcherBase implements CountUtils.I_MatchPredicate {
        private final CmpOp _operator;

        public MatcherBase(CmpOp cmpOp) {
            this._operator = cmpOp;
        }

        public final boolean evaluate(int i) {
            return this._operator.evaluate(i);
        }

        public final int getCode() {
            return this._operator.getCode();
        }

        public abstract String getValueText();

        public final String toString() {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(getClass().getName());
            stringBuffer.append(" [");
            stringBuffer.append(this._operator.getRepresentation());
            stringBuffer.append(getValueText());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }

        public final boolean evaluate(boolean z) {
            return this._operator.evaluate(z);
        }
    }

    public static final class NumberMatcher extends MatcherBase {
        private final double _value;

        public NumberMatcher(double d, CmpOp cmpOp) {
            super(cmpOp);
            this._value = d;
        }

        @Override // org.apache.poi.hssf.record.formula.functions.Countif.MatcherBase
        public String getValueText() {
            return String.valueOf(this._value);
        }

        @Override // org.apache.poi.hssf.record.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            if (!(valueEval instanceof StringEval)) {
                if (valueEval instanceof NumberEval) {
                    return evaluate(Double.compare(((NumberEval) valueEval).getNumberValue(), this._value));
                }
                return false;
            }
            int code = getCode();
            if (code != 0 && code != 1) {
                return code == 2;
            }
            Double d = OperandResolver.parseDouble(((StringEval) valueEval).getStringValue());
            return d != null && this._value == d.doubleValue();
        }
    }

    public static final class StringMatcher extends MatcherBase {
        private final Pattern _pattern;
        private final String _value;

        public StringMatcher(String str, CmpOp cmpOp) {
            super(cmpOp);
            this._value = str;
            int code = cmpOp.getCode();
            if (code == 0 || code == 1 || code == 2) {
                this._pattern = getWildCardPattern(str);
            } else {
                this._pattern = null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:30:0x005e  */
        private static Pattern getWildCardPattern(String str) {
            char cCharAt;
            int length = str.length();
            StringBuffer stringBuffer = new StringBuffer(length);
            int i = 0;
            boolean z = false;
            while (i < length) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 == '$' || cCharAt2 == '.') {
                    stringBuffer.append("\\");
                    stringBuffer.append(cCharAt2);
                    continue;
                } else {
                    if (cCharAt2 == '?') {
                        stringBuffer.append('.');
                    } else if (cCharAt2 == '[') {
                        stringBuffer.append("\\");
                        stringBuffer.append(cCharAt2);
                        continue;
                    } else if (cCharAt2 == '~') {
                        int i2 = i + 1;
                        if (i2 >= length || !((cCharAt = str.charAt(i2)) == '*' || cCharAt == '?')) {
                            stringBuffer.append('~');
                        } else {
                            stringBuffer.append('[');
                            stringBuffer.append(cCharAt);
                            stringBuffer.append(']');
                            i = i2;
                        }
                    } else if (cCharAt2 != ']' && cCharAt2 != '^') {
                        switch (cCharAt2) {
                            case '(':
                            case ')':
                                stringBuffer.append("\\");
                                stringBuffer.append(cCharAt2);
                                continue;
                            case '*':
                                stringBuffer.append(".*");
                                break;
                            default:
                                stringBuffer.append(cCharAt2);
                                continue;
                        }
                    } else {
                        stringBuffer.append("\\");
                        stringBuffer.append(cCharAt2);
                        continue;
                    }
                    z = true;
                }
                i++;
            }
            if (z) {
                return Pattern.compile(stringBuffer.toString());
            }
            return null;
        }

        @Override // org.apache.poi.hssf.record.formula.functions.Countif.MatcherBase
        public String getValueText() {
            Pattern pattern = this._pattern;
            return pattern == null ? this._value : pattern.pattern();
        }

        @Override // org.apache.poi.hssf.record.formula.functions.CountUtils.I_MatchPredicate
        public boolean matches(ValueEval valueEval) {
            if (valueEval instanceof BlankEval) {
                int code = getCode();
                return (code == 0 || code == 1) && this._value.length() == 0;
            }
            if (!(valueEval instanceof StringEval)) {
                return false;
            }
            String stringValue = ((StringEval) valueEval).getStringValue();
            if (stringValue.length() >= 1 || this._value.length() >= 1) {
                Pattern pattern = this._pattern;
                return pattern != null ? evaluate(pattern.matcher(stringValue).matches()) : evaluate(stringValue.compareTo(this._value));
            }
            int code2 = getCode();
            return code2 == 0 || code2 == 2;
        }
    }

    private double countMatchingCellsInArea(ValueEval valueEval, CountUtils.I_MatchPredicate i_MatchPredicate) {
        int iCountMatchingCellsInArea;
        if (valueEval instanceof RefEval) {
            iCountMatchingCellsInArea = CountUtils.countMatchingCell((RefEval) valueEval, i_MatchPredicate);
        } else {
            if (!(valueEval instanceof TwoDEval)) {
                throw new IllegalArgumentException("Bad range arg type (" + valueEval.getClass().getName() + ")");
            }
            iCountMatchingCellsInArea = CountUtils.countMatchingCellsInArea((TwoDEval) valueEval, i_MatchPredicate);
        }
        return iCountMatchingCellsInArea;
    }

    public static CountUtils.I_MatchPredicate createCriteriaPredicate(ValueEval valueEval, int i, int i2) {
        ValueEval valueEvalEvaluateCriteriaArg = evaluateCriteriaArg(valueEval, i, i2);
        if (valueEvalEvaluateCriteriaArg instanceof NumberEval) {
            return new NumberMatcher(((NumberEval) valueEvalEvaluateCriteriaArg).getNumberValue(), CmpOp.OP_NONE);
        }
        if (valueEvalEvaluateCriteriaArg instanceof BoolEval) {
            return new BooleanMatcher(((BoolEval) valueEvalEvaluateCriteriaArg).getBooleanValue(), CmpOp.OP_NONE);
        }
        if (valueEvalEvaluateCriteriaArg instanceof StringEval) {
            return createGeneralMatchPredicate((StringEval) valueEvalEvaluateCriteriaArg);
        }
        if (valueEvalEvaluateCriteriaArg instanceof ErrorEval) {
            return new ErrorMatcher(((ErrorEval) valueEvalEvaluateCriteriaArg).getErrorCode(), CmpOp.OP_NONE);
        }
        if (valueEvalEvaluateCriteriaArg == BlankEval.instance) {
            return null;
        }
        throw new RuntimeException("Unexpected type for criteria (" + valueEvalEvaluateCriteriaArg.getClass().getName() + ")");
    }

    private static CountUtils.I_MatchPredicate createGeneralMatchPredicate(StringEval stringEval) {
        String stringValue = stringEval.getStringValue();
        CmpOp operator = CmpOp.getOperator(stringValue);
        String strSubstring = stringValue.substring(operator.getLength());
        Boolean bool = parseBoolean(strSubstring);
        if (bool != null) {
            return new BooleanMatcher(bool.booleanValue(), operator);
        }
        Double d = OperandResolver.parseDouble(strSubstring);
        if (d != null) {
            return new NumberMatcher(d.doubleValue(), operator);
        }
        ErrorEval error = parseError(strSubstring);
        return error != null ? new ErrorMatcher(error.getErrorCode(), operator) : new StringMatcher(strSubstring, operator);
    }

    private static ValueEval evaluateCriteriaArg(ValueEval valueEval, int i, int i2) {
        try {
            return OperandResolver.getSingleValue(valueEval, i, (short) i2);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001f  */
    /* JADX WARN: Code duplicated, block: B:16:0x0027  */
    /* JADX WARN: Code duplicated, block: B:18:0x002a  */
    /* JADX WARN: Code duplicated, block: B:20:0x0032  */
    public static Boolean parseBoolean(String str) {
        if (str.length() < 1) {
            return null;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt == 'F') {
            if ("FALSE".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
        } else if (cCharAt == 'T') {
            if ("TRUE".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
        } else if (cCharAt != 'f') {
            if (cCharAt == 't') {
                if ("TRUE".equalsIgnoreCase(str)) {
                    return Boolean.TRUE;
                }
            }
        } else if ("FALSE".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static ErrorEval parseError(String str) {
        if (str.length() >= 4 && str.charAt(0) == '#') {
            if (str.equals("#NULL!")) {
                return ErrorEval.NULL_INTERSECTION;
            }
            if (str.equals("#DIV/0!")) {
                return ErrorEval.DIV_ZERO;
            }
            if (str.equals("#VALUE!")) {
                return ErrorEval.VALUE_INVALID;
            }
            if (str.equals("#REF!")) {
                return ErrorEval.REF_INVALID;
            }
            if (str.equals("#NAME?")) {
                return ErrorEval.NAME_INVALID;
            }
            if (str.equals("#NUM!")) {
                return ErrorEval.NUM_ERROR;
            }
            if (str.equals("#N/A")) {
                return ErrorEval.NA;
            }
        }
        return null;
    }

    @Override // org.apache.poi.hssf.record.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        CountUtils.I_MatchPredicate i_MatchPredicateCreateCriteriaPredicate = createCriteriaPredicate(valueEval2, i, i2);
        return i_MatchPredicateCreateCriteriaPredicate == null ? NumberEval.ZERO : new NumberEval(countMatchingCellsInArea(valueEval, i_MatchPredicateCreateCriteriaPredicate));
    }

    public static final class CmpOp {
        public static final int EQ = 1;
        public static final int GE = 6;
        public static final int GT = 5;
        public static final int LE = 3;
        public static final int LT = 4;
        public static final int NE = 2;
        public static final int NONE = 0;
        private final int _code;
        private final String _representation;
        public static final CmpOp OP_NONE = op("", 0);
        public static final CmpOp OP_EQ = op("=", 1);
        public static final CmpOp OP_NE = op("<>", 2);
        public static final CmpOp OP_LE = op("<=", 3);
        public static final CmpOp OP_LT = op("<", 4);
        public static final CmpOp OP_GT = op(">", 5);
        public static final CmpOp OP_GE = op(">=", 6);

        private CmpOp(String str, int i) {
            this._representation = str;
            this._code = i;
        }

        public static CmpOp getOperator(String str) {
            int length = str.length();
            if (length < 1) {
                return OP_NONE;
            }
            switch (str.charAt(0)) {
                case '<':
                    if (length > 1) {
                        char cCharAt = str.charAt(1);
                        if (cCharAt == '=') {
                            return OP_LE;
                        }
                        if (cCharAt == '>') {
                            return OP_NE;
                        }
                    }
                    return OP_LT;
                case '=':
                    return OP_EQ;
                case '>':
                    return (length <= 1 || str.charAt(1) != '=') ? OP_GT : OP_GE;
                default:
                    return OP_NONE;
            }
        }

        private static CmpOp op(String str, int i) {
            return new CmpOp(str, i);
        }

        public boolean evaluate(boolean z) {
            int i = this._code;
            if (i == 0 || i == 1) {
                return z;
            }
            if (i == 2) {
                return !z;
            }
            throw new RuntimeException("Cannot call boolean evaluate on non-equality operator '" + this._representation + "'");
        }

        public int getCode() {
            return this._code;
        }

        public int getLength() {
            return this._representation.length();
        }

        public String getRepresentation() {
            return this._representation;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(CmpOp.class.getName());
            stringBuffer.append(" [");
            stringBuffer.append(this._representation);
            stringBuffer.append("]");
            return stringBuffer.toString();
        }

        public boolean evaluate(int i) {
            switch (this._code) {
                case 0:
                case 1:
                    return i == 0;
                case 2:
                    return i != 0;
                case 3:
                    return i <= 0;
                case 4:
                    return i < 0;
                case 5:
                    return i > 0;
                case 6:
                    return i <= 0;
                default:
                    throw new RuntimeException("Cannot call boolean evaluate on non-equality operator '" + this._representation + "'");
            }
        }
    }
}
