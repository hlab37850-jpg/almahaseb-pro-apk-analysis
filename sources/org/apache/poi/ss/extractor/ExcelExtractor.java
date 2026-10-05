package org.apache.poi.ss.extractor;

/* JADX INFO: loaded from: classes4.dex */
public interface ExcelExtractor {
    String getText();

    void setFormulasNotResults(boolean z);

    void setIncludeCellComments(boolean z);

    void setIncludeSheetNames(boolean z);
}
