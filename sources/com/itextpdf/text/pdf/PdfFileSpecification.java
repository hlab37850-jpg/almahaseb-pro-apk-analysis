package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.pdf.collection.PdfCollectionItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class PdfFileSpecification extends PdfDictionary {
    protected PdfIndirectReference ref;
    protected PdfWriter writer;

    public PdfFileSpecification() {
        super(PdfName.FILESPEC);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr) {
        return fileEmbedded(pdfWriter, str, str2, bArr, 9);
    }

    public static PdfFileSpecification fileExtern(PdfWriter pdfWriter, String str) {
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.writer = pdfWriter;
        pdfFileSpecification.put(PdfName.F, new PdfString(str));
        pdfFileSpecification.setUnicodeFileName(str, false);
        return pdfFileSpecification;
    }

    public static PdfFileSpecification url(PdfWriter pdfWriter, String str) {
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.writer = pdfWriter;
        pdfFileSpecification.put(PdfName.FS, PdfName.URL);
        pdfFileSpecification.put(PdfName.F, new PdfString(str));
        return pdfFileSpecification;
    }

    public void addCollectionItem(PdfCollectionItem pdfCollectionItem) {
        put(PdfName.CI, pdfCollectionItem);
    }

    public void addDescription(String str, boolean z) {
        put(PdfName.DESC, new PdfString(str, z ? PdfObject.TEXT_UNICODE : PdfObject.TEXT_PDFDOCENCODING));
    }

    public PdfIndirectReference getReference() {
        PdfIndirectReference pdfIndirectReference = this.ref;
        if (pdfIndirectReference != null) {
            return pdfIndirectReference;
        }
        PdfIndirectReference indirectReference = this.writer.addToBody(this).getIndirectReference();
        this.ref = indirectReference;
        return indirectReference;
    }

    public void setMultiByteFileName(byte[] bArr) {
        put(PdfName.F, new PdfString(bArr).setHexWriting(true));
    }

    public void setUnicodeFileName(String str, boolean z) {
        put(PdfName.UF, new PdfString(str, z ? PdfObject.TEXT_UNICODE : PdfObject.TEXT_PDFDOCENCODING));
    }

    public void setVolatile(boolean z) {
        put(PdfName.V, new PdfBoolean(z));
    }

    @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) {
        PdfWriter.checkPdfIsoConformance(pdfWriter, 10, this);
        super.toPdf(pdfWriter, outputStream);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, int i) {
        return fileEmbedded(pdfWriter, str, str2, bArr, (String) null, (PdfDictionary) null, i);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, boolean z) {
        return fileEmbedded(pdfWriter, str, str2, bArr, (String) null, (PdfDictionary) null, z ? 9 : 0);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, boolean z, String str3, PdfDictionary pdfDictionary) {
        return fileEmbedded(pdfWriter, str, str2, bArr, str3, pdfDictionary, z ? 9 : 0);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, String str3, PdfDictionary pdfDictionary, int i) throws Throwable {
        PdfEFStream pdfEFStream;
        InputStream inputStream;
        InputStream inputStreamOpenStream;
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.writer = pdfWriter;
        pdfFileSpecification.put(PdfName.F, new PdfString(str2));
        pdfFileSpecification.setUnicodeFileName(str2, false);
        InputStream inputStream2 = null;
        PdfIndirectReference pdfIndirectReference = null;
        try {
            if (bArr == null) {
                PdfIndirectReference pdfIndirectReference2 = pdfWriter.getPdfIndirectReference();
                if (new File(str).canRead()) {
                    inputStreamOpenStream = new FileInputStream(str);
                } else if (!str.startsWith("file:/") && !str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("jar:")) {
                    inputStreamOpenStream = StreamUtil.getResourceStream(str);
                    if (inputStreamOpenStream == null) {
                        throw new IOException(MessageLocalization.getComposedMessage("1.not.found.as.file.or.resource", str));
                    }
                } else {
                    inputStreamOpenStream = new URL(str).openStream();
                }
                pdfEFStream = new PdfEFStream(inputStreamOpenStream, pdfWriter);
                inputStream = inputStreamOpenStream;
                pdfIndirectReference = pdfIndirectReference2;
            } else {
                pdfEFStream = new PdfEFStream(bArr);
                inputStream = null;
            }
            try {
                pdfEFStream.put(PdfName.TYPE, PdfName.EMBEDDEDFILE);
                pdfEFStream.flateCompress(i);
                PdfDictionary pdfDictionary2 = new PdfDictionary();
                if (pdfDictionary != null) {
                    pdfDictionary2.merge(pdfDictionary);
                }
                PdfName pdfName = PdfName.MODDATE;
                if (!pdfDictionary2.contains(pdfName)) {
                    pdfDictionary2.put(pdfName, new PdfDate());
                }
                if (bArr == null) {
                    pdfEFStream.put(PdfName.PARAMS, pdfIndirectReference);
                } else {
                    pdfDictionary2.put(PdfName.SIZE, new PdfNumber(pdfEFStream.getRawLength()));
                    pdfEFStream.put(PdfName.PARAMS, pdfDictionary2);
                }
                if (str3 != null) {
                    pdfEFStream.put(PdfName.SUBTYPE, new PdfName(str3));
                }
                PdfIndirectReference indirectReference = pdfWriter.addToBody(pdfEFStream).getIndirectReference();
                if (bArr == null) {
                    pdfEFStream.writeLength();
                    pdfDictionary2.put(PdfName.SIZE, new PdfNumber(pdfEFStream.getRawLength()));
                    pdfWriter.addToBody(pdfDictionary2, pdfIndirectReference);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                }
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                pdfDictionary3.put(PdfName.F, indirectReference);
                pdfDictionary3.put(PdfName.UF, indirectReference);
                pdfFileSpecification.put(PdfName.EF, pdfDictionary3);
                return pdfFileSpecification;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
