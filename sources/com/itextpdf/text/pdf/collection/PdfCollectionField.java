package com.itextpdf.text.pdf.collection;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

/* JADX INFO: loaded from: classes3.dex */
public class PdfCollectionField extends PdfDictionary {
    public static final int CREATIONDATE = 6;
    public static final int DATE = 1;
    public static final int DESC = 4;
    public static final int FILENAME = 3;
    public static final int MODDATE = 5;
    public static final int NUMBER = 2;
    public static final int SIZE = 7;
    public static final int TEXT = 0;
    protected int fieldType;

    public PdfCollectionField(String str, int i) {
        super(PdfName.COLLECTIONFIELD);
        PdfName pdfName = PdfName.N;
        put(pdfName, new PdfString(str, PdfObject.TEXT_UNICODE));
        this.fieldType = i;
        switch (i) {
            case 1:
                put(PdfName.SUBTYPE, PdfName.D);
                break;
            case 2:
                put(PdfName.SUBTYPE, pdfName);
                break;
            case 3:
                put(PdfName.SUBTYPE, PdfName.F);
                break;
            case 4:
                put(PdfName.SUBTYPE, PdfName.DESC);
                break;
            case 5:
                put(PdfName.SUBTYPE, PdfName.MODDATE);
                break;
            case 6:
                put(PdfName.SUBTYPE, PdfName.CREATIONDATE);
                break;
            case 7:
                put(PdfName.SUBTYPE, PdfName.SIZE);
                break;
            default:
                put(PdfName.SUBTYPE, PdfName.S);
                break;
        }
    }

    public PdfObject getValue(String str) {
        int i = this.fieldType;
        if (i == 0) {
            return new PdfString(str, PdfObject.TEXT_UNICODE);
        }
        if (i == 1) {
            return new PdfDate(PdfDate.decode(str));
        }
        if (i == 2) {
            return new PdfNumber(str);
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.is.not.an.acceptable.value.for.the.field.2", str, get(PdfName.N).toString()));
    }

    public boolean isCollectionItem() {
        int i = this.fieldType;
        return i == 0 || i == 1 || i == 2;
    }

    public void setEditable(boolean z) {
        put(PdfName.E, new PdfBoolean(z));
    }

    public void setOrder(int i) {
        put(PdfName.O, new PdfNumber(i));
    }

    public void setVisible(boolean z) {
        put(PdfName.V, new PdfBoolean(z));
    }
}
