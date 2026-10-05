package org.apache.poi.hssf.record.formula.functions;

import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.poi.hssf.record.formula.eval.ErrorEval;
import org.apache.poi.hssf.record.formula.eval.EvaluationException;
import org.apache.poi.hssf.record.formula.eval.NumberEval;
import org.apache.poi.hssf.record.formula.eval.OperandResolver;
import org.apache.poi.hssf.record.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarFieldFunction extends Fixed1ArgFunction {
    private final int _dateFieldId;
    private final boolean _needsOneBaseAdjustment;
    public static final Function YEAR = new CalendarFieldFunction(1, false);
    public static final Function MONTH = new CalendarFieldFunction(2, true);
    public static final Function DAY = new CalendarFieldFunction(5, false);

    private CalendarFieldFunction(int i, boolean z) {
        this._dateFieldId = i;
        this._needsOneBaseAdjustment = z;
    }

    private int getCalField(int i) {
        if (i != 0) {
            Date javaDate = DateUtil.getJavaDate(i, false);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(javaDate);
            int i2 = gregorianCalendar.get(this._dateFieldId);
            return this._needsOneBaseAdjustment ? i2 + 1 : i2;
        }
        int i3 = this._dateFieldId;
        if (i3 == 1) {
            return 1900;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 5) {
            return 0;
        }
        throw new IllegalStateException("bad date field " + this._dateFieldId);
    }

    @Override // org.apache.poi.hssf.record.formula.functions.Function1Arg
    public final ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            int iCoerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i, i2));
            return iCoerceValueToInt < 0 ? ErrorEval.NUM_ERROR : new NumberEval(getCalField(iCoerceValueToInt));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
