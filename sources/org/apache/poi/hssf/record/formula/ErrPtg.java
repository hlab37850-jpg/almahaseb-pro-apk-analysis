package org.apache.poi.hssf.record.formula;

import com.google.common.base.Ascii;
import org.apache.poi.hssf.usermodel.HSSFErrorConstants;
import org.apache.poi.ss.usermodel.ErrorConstants;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes4.dex */
public final class ErrPtg extends ScalarConstantPtg {
    private static final HSSFErrorConstants EC = null;
    private static final int SIZE = 2;
    public static final short sid = 28;
    private final int field_1_error_code;
    public static final ErrPtg NULL_INTERSECTION = new ErrPtg(0);
    public static final ErrPtg DIV_ZERO = new ErrPtg(7);
    public static final ErrPtg VALUE_INVALID = new ErrPtg(15);
    public static final ErrPtg REF_INVALID = new ErrPtg(23);
    public static final ErrPtg NAME_INVALID = new ErrPtg(29);
    public static final ErrPtg NUM_ERROR = new ErrPtg(36);
    public static final ErrPtg N_A = new ErrPtg(42);

    private ErrPtg(int i) {
        if (ErrorConstants.isValidCode(i)) {
            this.field_1_error_code = i;
            return;
        }
        throw new IllegalArgumentException("Invalid error code (" + i + ")");
    }

    public static ErrPtg read(LittleEndianInput littleEndianInput) {
        return valueOf(littleEndianInput.readByte());
    }

    public static ErrPtg valueOf(int i) {
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
            return N_A;
        }
        throw new RuntimeException("Unexpected error code (" + i + ")");
    }

    public int getErrorCode() {
        return this.field_1_error_code;
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public int getSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public String toFormulaString() {
        return ErrorConstants.getText(this.field_1_error_code);
    }

    @Override // org.apache.poi.hssf.record.formula.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + Ascii.FS);
        littleEndianOutput.writeByte(this.field_1_error_code);
    }
}
