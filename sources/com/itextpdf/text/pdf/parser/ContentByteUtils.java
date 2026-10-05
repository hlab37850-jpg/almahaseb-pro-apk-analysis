package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public class ContentByteUtils {
    private ContentByteUtils() {
    }

    public static byte[] getContentBytesForPage(PdfReader pdfReader, int i) {
        PdfObject pdfObject = pdfReader.getPageN(i).get(PdfName.CONTENTS);
        return pdfObject == null ? new byte[0] : getContentBytesFromContentObject(pdfObject);
    }

    public static byte[] getContentBytesFromContentObject(PdfObject pdfObject) throws IOException {
        int iType = pdfObject.type();
        if (iType == 5) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ListIterator<PdfObject> listIterator = ((PdfArray) pdfObject).listIterator();
            while (listIterator.hasNext()) {
                byteArrayOutputStream.write(getContentBytesFromContentObject(listIterator.next()));
                byteArrayOutputStream.write(32);
            }
            return byteArrayOutputStream.toByteArray();
        }
        if (iType == 7) {
            return PdfReader.getStreamBytes((PRStream) PdfReader.getPdfObjectRelease(pdfObject));
        }
        if (iType == 10) {
            return getContentBytesFromContentObject(PdfReader.getPdfObjectRelease((PRIndirectReference) pdfObject));
        }
        throw new IllegalStateException("Unable to handle Content of type " + pdfObject.getClass());
    }
}
