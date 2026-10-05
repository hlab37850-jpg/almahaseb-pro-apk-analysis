package org.apache.poi.ss.usermodel;

/* JADX INFO: loaded from: classes4.dex */
public interface CreationHelper {
    ClientAnchor createClientAnchor();

    DataFormat createDataFormat();

    FormulaEvaluator createFormulaEvaluator();

    Hyperlink createHyperlink(int i);

    RichTextString createRichTextString(String str);
}
