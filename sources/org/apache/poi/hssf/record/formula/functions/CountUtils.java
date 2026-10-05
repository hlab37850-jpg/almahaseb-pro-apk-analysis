package org.apache.poi.hssf.record.formula.functions;

import org.apache.poi.hssf.record.formula.eval.RefEval;
import org.apache.poi.hssf.record.formula.eval.ValueEval;
import org.apache.poi.ss.formula.TwoDEval;

/* JADX INFO: loaded from: classes4.dex */
final class CountUtils {

    public interface I_MatchPredicate {
        boolean matches(ValueEval valueEval);
    }

    private CountUtils() {
    }

    public static int countArg(ValueEval valueEval, I_MatchPredicate i_MatchPredicate) {
        if (valueEval == null) {
            throw new IllegalArgumentException("eval must not be null");
        }
        if (valueEval instanceof TwoDEval) {
            return countMatchingCellsInArea((TwoDEval) valueEval, i_MatchPredicate);
        }
        return valueEval instanceof RefEval ? countMatchingCell((RefEval) valueEval, i_MatchPredicate) : i_MatchPredicate.matches(valueEval) ? 1 : 0;
    }

    public static int countMatchingCell(RefEval refEval, I_MatchPredicate i_MatchPredicate) {
        return i_MatchPredicate.matches(refEval.getInnerValueEval()) ? 1 : 0;
    }

    public static int countMatchingCellsInArea(TwoDEval twoDEval, I_MatchPredicate i_MatchPredicate) {
        int height = twoDEval.getHeight();
        int width = twoDEval.getWidth();
        int i = 0;
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                if (i_MatchPredicate.matches(twoDEval.getValue(i2, i3))) {
                    i++;
                }
            }
        }
        return i;
    }
}
