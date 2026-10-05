package org.apache.poi.hssf.record.formula.eval;

import org.apache.poi.hssf.usermodel.HSSFErrorConstants;
import org.apache.poi.ss.usermodel.ErrorConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrorEval implements ValueEval {
    private static final HSSFErrorConstants EC = null;
    private static final int FUNCTION_NOT_IMPLEMENTED_CODE = -30;
    private int _errorCode;
    public static final ErrorEval NULL_INTERSECTION = new ErrorEval(0);
    public static final ErrorEval DIV_ZERO = new ErrorEval(7);
    public static final ErrorEval VALUE_INVALID = new ErrorEval(15);
    public static final ErrorEval REF_INVALID = new ErrorEval(23);
    public static final ErrorEval NAME_INVALID = new ErrorEval(29);
    public static final ErrorEval NUM_ERROR = new ErrorEval(36);
    public static final ErrorEval NA = new ErrorEval(42);
    private static final int CIRCULAR_REF_ERROR_CODE = -60;
    public static final ErrorEval CIRCULAR_REF_ERROR = new ErrorEval(CIRCULAR_REF_ERROR_CODE);

    private ErrorEval(int i) {
        this._errorCode = i;
    }

    public static String getText(int i) {
        if (ErrorConstants.isValidCode(i)) {
            return ErrorConstants.getText(i);
        }
        if (i == CIRCULAR_REF_ERROR_CODE) {
            return "~CIRCULAR~REF~";
        }
        if (i == FUNCTION_NOT_IMPLEMENTED_CODE) {
            return "~FUNCTION~NOT~IMPLEMENTED~";
        }
        return "~non~std~err(" + i + ")~";
    }

    public static ErrorEval valueOf(int i) {
        if (i == CIRCULAR_REF_ERROR_CODE) {
            return CIRCULAR_REF_ERROR;
        }
        if (i == 0) {
            return NULL_INTERSECTION;
        }
        if (i == 7) {
            return DIV_ZERO;
        }
        if (i == 15) {
            return VALUE_INVALID;
        }
        if (i == 23) {
            return REF_INVALID;
        }
        if (i == 29) {
            return NAME_INVALID;
        }
        if (i == 36) {
            return NUM_ERROR;
        }
        if (i == 42) {
            return NA;
        }
        throw new RuntimeException("Unexpected error code (" + i + ")");
    }

    public int getErrorCode() {
        return this._errorCode;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(ErrorEval.class.getName());
        stringBuffer.append(" [");
        stringBuffer.append(getText(this._errorCode));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
