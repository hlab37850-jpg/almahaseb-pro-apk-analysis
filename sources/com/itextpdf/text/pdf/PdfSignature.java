package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.security.PdfSignatureBuildProperties;

/* JADX INFO: loaded from: classes3.dex */
public class PdfSignature extends PdfDictionary {
    public PdfSignature(PdfName pdfName, PdfName pdfName2) {
        super(PdfName.SIG);
        put(PdfName.FILTER, pdfName);
        put(PdfName.SUBFILTER, pdfName2);
    }

    public PdfSignatureBuildProperties getPdfSignatureBuildProperties() {
        PdfName pdfName = PdfName.PROP_BUILD;
        PdfSignatureBuildProperties pdfSignatureBuildProperties = (PdfSignatureBuildProperties) getAsDict(pdfName);
        if (pdfSignatureBuildProperties != null) {
            return pdfSignatureBuildProperties;
        }
        PdfSignatureBuildProperties pdfSignatureBuildProperties2 = new PdfSignatureBuildProperties();
        put(pdfName, pdfSignatureBuildProperties2);
        return pdfSignatureBuildProperties2;
    }

    public void setByteRange(int[] iArr) {
        PdfArray pdfArray = new PdfArray();
        for (int i : iArr) {
            pdfArray.add(new PdfNumber(i));
        }
        put(PdfName.BYTERANGE, pdfArray);
    }

    public void setCert(byte[] bArr) {
        put(PdfName.CERT, new PdfString(bArr));
    }

    public void setContact(String str) {
        put(PdfName.CONTACTINFO, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setContents(byte[] bArr) {
        put(PdfName.CONTENTS, new PdfString(bArr).setHexWriting(true));
    }

    public void setDate(PdfDate pdfDate) {
        put(PdfName.M, pdfDate);
    }

    public void setLocation(String str) {
        put(PdfName.LOCATION, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setName(String str) {
        put(PdfName.NAME, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setReason(String str) {
        put(PdfName.REASON, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setSignatureCreator(String str) {
        if (str != null) {
            getPdfSignatureBuildProperties().setSignatureCreator(str);
        }
    }
}
