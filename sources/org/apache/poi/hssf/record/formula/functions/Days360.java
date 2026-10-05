package org.apache.poi.hssf.record.formula.functions;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.poi.hssf.record.formula.eval.EvaluationException;
import org.apache.poi.hssf.record.formula.eval.NumberEval;
import org.apache.poi.hssf.record.formula.eval.OperandResolver;
import org.apache.poi.hssf.record.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes4.dex */
public class Days360 extends Var2or3ArgFunction {
    private static Calendar getDate(double d) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(DateUtil.getJavaDate(d, false));
        return gregorianCalendar;
    }

    private static Calendar getEndingDateAccordingToStartingDate(double d, Calendar calendar) {
        Calendar date = getDate(d);
        date.setTime(DateUtil.getJavaDate(d, false));
        return (!isLastDayOfMonth(date) || calendar.get(5) >= 30) ? date : getFirstDayOfNextMonth(date);
    }

    private static Calendar getFirstDayOfNextMonth(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        if (calendar.get(2) < 11) {
            calendar2.set(2, calendar.get(2) + 1);
        } else {
            calendar2.set(2, 1);
            calendar2.set(1, calendar.get(1) + 1);
        }
        calendar2.set(5, 1);
        return calendar2;
    }

    private static Calendar getStartingDate(double d) {
        Calendar date = getDate(d);
        if (isLastDayOfMonth(date)) {
            date.set(5, 30);
        }
        return date;
    }

    private static boolean isLastDayOfMonth(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.add(2, 1);
        calendar2.add(5, -1);
        return calendar.get(5) == calendar2.get(5);
    }

    @Override // org.apache.poi.hssf.record.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            return new NumberEval(evaluate(NumericFunction.singleOperandEvaluate(valueEval, i, i2), NumericFunction.singleOperandEvaluate(valueEval2, i, i2), false));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.hssf.record.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        try {
            double dSingleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEval, i, i2);
            double dSingleOperandEvaluate2 = NumericFunction.singleOperandEvaluate(valueEval2, i, i2);
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval3, i, i2);
            boolean zBooleanValue = false;
            Boolean boolCoerceValueToBoolean = OperandResolver.coerceValueToBoolean(singleValue, false);
            if (boolCoerceValueToBoolean != null) {
                zBooleanValue = boolCoerceValueToBoolean.booleanValue();
            }
            return new NumberEval(evaluate(dSingleOperandEvaluate, dSingleOperandEvaluate2, zBooleanValue));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static double evaluate(double d, double d2, boolean z) {
        Calendar startingDate = getStartingDate(d);
        Calendar endingDateAccordingToStartingDate = getEndingDateAccordingToStartingDate(d2, startingDate);
        return ((long) ((((endingDateAccordingToStartingDate.get(1) - startingDate.get(1)) * 360) + (endingDateAccordingToStartingDate.get(2) * 30)) + endingDateAccordingToStartingDate.get(5))) - ((long) ((startingDate.get(2) * 30) + startingDate.get(5)));
    }
}
