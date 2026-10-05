package com.itextpdf.text.pdf.fonts.cmaps;

import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.IntHashtable;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

/* JADX INFO: loaded from: classes3.dex */
public class CMapCidUni extends AbstractCMap {
    private IntHashtable map = new IntHashtable(65537);

    @Override // com.itextpdf.text.pdf.fonts.cmaps.AbstractCMap
    public void addChar(PdfString pdfString, PdfObject pdfObject) {
        if (pdfObject instanceof PdfNumber) {
            String strDecodeStringToUnicode = decodeStringToUnicode(pdfString);
            this.map.put(((PdfNumber) pdfObject).intValue(), Utilities.isSurrogatePair(strDecodeStringToUnicode, 0) ? Utilities.convertToUtf32(strDecodeStringToUnicode, 0) : strDecodeStringToUnicode.charAt(0));
        }
    }

    public int lookup(int i) {
        return this.map.get(i);
    }
}
