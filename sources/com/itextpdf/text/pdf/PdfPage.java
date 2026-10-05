package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPage extends PdfDictionary {
    PdfRectangle mediaBox;
    private static final String[] boxStrings = {"crop", "trim", "art", "bleed"};
    private static final PdfName[] boxNames = {PdfName.CROPBOX, PdfName.TRIMBOX, PdfName.ARTBOX, PdfName.BLEEDBOX};
    public static final PdfNumber PORTRAIT = new PdfNumber(0);
    public static final PdfNumber LANDSCAPE = new PdfNumber(90);
    public static final PdfNumber INVERTEDPORTRAIT = new PdfNumber(ShapeTypes.MATH_EQUAL);
    public static final PdfNumber SEASCAPE = new PdfNumber(TIFFConstants.TIFFTAG_IMAGEDESCRIPTION);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PdfPage(PdfRectangle pdfRectangle, HashMap<String, PdfRectangle> map, PdfDictionary pdfDictionary, int i) throws DocumentException {
        super(PdfDictionary.PAGE);
        int i2 = 0;
        this.mediaBox = pdfRectangle;
        if (pdfRectangle != null && (pdfRectangle.width() > 14400.0f || pdfRectangle.height() > 14400.0f)) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.page.size.must.be.smaller.than.14400.by.14400.its.1.by.2", Float.valueOf(pdfRectangle.width()), Float.valueOf(pdfRectangle.height())));
        }
        put(PdfName.MEDIABOX, pdfRectangle);
        put(PdfName.RESOURCES, pdfDictionary);
        if (i != 0) {
            put(PdfName.ROTATE, new PdfNumber(i));
        }
        while (true) {
            String[] strArr = boxStrings;
            if (i2 >= strArr.length) {
                return;
            }
            PdfRectangle pdfRectangle2 = map.get(strArr[i2]);
            if (pdfRectangle2 != null) {
                put(boxNames[i2], pdfRectangle2);
            }
            i2++;
        }
    }

    public void add(PdfIndirectReference pdfIndirectReference) {
        put(PdfName.CONTENTS, pdfIndirectReference);
    }

    public PdfRectangle getMediaBox() {
        return this.mediaBox;
    }

    public boolean isParent() {
        return false;
    }

    public PdfRectangle rotateMediaBox() {
        PdfRectangle pdfRectangleRotate = this.mediaBox.rotate();
        this.mediaBox = pdfRectangleRotate;
        put(PdfName.MEDIABOX, pdfRectangleRotate);
        return this.mediaBox;
    }

    public PdfPage(PdfRectangle pdfRectangle, HashMap<String, PdfRectangle> map, PdfDictionary pdfDictionary) {
        this(pdfRectangle, map, pdfDictionary, 0);
    }
}
