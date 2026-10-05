package com.itextpdf.text.pdf;

import com.itextpdf.text.log.LoggerFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class TtfUnicodeWriter {
    protected PdfWriter writer;

    public TtfUnicodeWriter(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    public void writeFont(TrueTypeFontUnicode trueTypeFontUnicode, PdfIndirectReference pdfIndirectReference, Object[] objArr, byte[] bArr) {
        byte[] bArrProcess;
        PdfIndirectReference indirectReference;
        HashMap<Integer, int[]> map = (HashMap) objArr[0];
        trueTypeFontUnicode.addRangeUni(map, true, trueTypeFontUnicode.subset);
        int[][] iArr = (int[][]) map.values().toArray(new int[0][]);
        Arrays.sort(iArr, trueTypeFontUnicode);
        if (trueTypeFontUnicode.cff) {
            byte[] cffFont = trueTypeFontUnicode.readCffFont();
            if (trueTypeFontUnicode.subset || trueTypeFontUnicode.subsetRanges != null) {
                CFFFontSubset cFFFontSubset = new CFFFontSubset(new RandomAccessFileOrArray(cffFont), map);
                try {
                    cffFont = cFFFontSubset.Process(cFFFontSubset.getNames()[0]);
                } catch (Exception e) {
                    LoggerFactory.getLogger((Class<?>) TtfUnicodeWriter.class).error("Issue in CFF font subsetting.Subsetting was disabled", e);
                    trueTypeFontUnicode.setSubset(false);
                    trueTypeFontUnicode.addRangeUni(map, true, trueTypeFontUnicode.subset);
                    iArr = (int[][]) map.values().toArray(new int[0][]);
                    Arrays.sort(iArr, trueTypeFontUnicode);
                }
            }
            indirectReference = this.writer.addToBody(new BaseFont.StreamFont(cffFont, "CIDFontType0C", trueTypeFontUnicode.compressionLevel)).getIndirectReference();
        } else {
            if (trueTypeFontUnicode.subset || trueTypeFontUnicode.directoryOffset != 0) {
                synchronized (trueTypeFontUnicode.rf) {
                    bArrProcess = new TrueTypeFontSubSet(trueTypeFontUnicode.fileName, new RandomAccessFileOrArray(trueTypeFontUnicode.rf), new HashSet(map.keySet()), trueTypeFontUnicode.directoryOffset, true, false).process();
                }
            } else {
                bArrProcess = trueTypeFontUnicode.getFullFont();
            }
            indirectReference = this.writer.addToBody(new BaseFont.StreamFont(bArrProcess, new int[]{bArrProcess.length}, trueTypeFontUnicode.compressionLevel)).getIndirectReference();
        }
        String strCreateSubsetPrefix = trueTypeFontUnicode.subset ? BaseFont.createSubsetPrefix() : "";
        PdfIndirectReference indirectReference2 = this.writer.addToBody(trueTypeFontUnicode.getCIDFontType2(this.writer.addToBody(trueTypeFontUnicode.getFontDescriptor(indirectReference, strCreateSubsetPrefix, null)).getIndirectReference(), strCreateSubsetPrefix, iArr)).getIndirectReference();
        PdfStream toUnicode = trueTypeFontUnicode.getToUnicode(iArr);
        this.writer.addToBody(trueTypeFontUnicode.getFontBaseType(indirectReference2, strCreateSubsetPrefix, toUnicode != null ? this.writer.addToBody(toUnicode).getIndirectReference() : null), pdfIndirectReference);
    }
}
