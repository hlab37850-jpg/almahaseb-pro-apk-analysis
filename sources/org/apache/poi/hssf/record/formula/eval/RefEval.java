package org.apache.poi.hssf.record.formula.eval;

/* JADX INFO: loaded from: classes4.dex */
public interface RefEval extends ValueEval {
    int getColumn();

    ValueEval getInnerValueEval();

    int getRow();

    AreaEval offset(int i, int i2, int i3, int i4);
}
