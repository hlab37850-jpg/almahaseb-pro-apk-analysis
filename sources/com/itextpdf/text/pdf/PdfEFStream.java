package com.itextpdf.text.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PdfEFStream extends PdfStream {
    public PdfEFStream(InputStream inputStream, PdfWriter pdfWriter) {
        super(inputStream, pdfWriter);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.itextpdf.text.pdf.OutputStreamEncryption] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfEFStream, com.itextpdf.text.pdf.PdfObject, com.itextpdf.text.pdf.PdfStream] */
    @Override // com.itextpdf.text.pdf.PdfStream, com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        OutputStream encryptionStream;
        ?? r3;
        Deflater deflater;
        OutputStream deflaterOutputStream;
        PdfObject pdfObject;
        if (this.inputStream != null && this.compressed) {
            put(PdfName.FILTER, PdfName.FLATEDECODE);
        }
        ?? r0 = 0;
        PdfEncryption encryption = pdfWriter != null ? pdfWriter.getEncryption() : null;
        if (encryption != null && (pdfObject = get(PdfName.FILTER)) != null) {
            PdfName pdfName = PdfName.CRYPT;
            if (pdfName.equals(pdfObject)) {
                encryption = null;
            } else if (pdfObject.isArray()) {
                PdfArray pdfArray = (PdfArray) pdfObject;
                if (!pdfArray.isEmpty() && pdfName.equals(pdfArray.getPdfObject(0))) {
                    encryption = null;
                }
            }
        }
        if (encryption != null && encryption.isEmbeddedFilesOnly()) {
            PdfArray pdfArray2 = new PdfArray();
            PdfArray pdfArray3 = new PdfArray();
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.NAME, PdfName.STDCF);
            pdfArray2.add(PdfName.CRYPT);
            pdfArray3.add(pdfDictionary);
            if (this.compressed) {
                pdfArray2.add(PdfName.FLATEDECODE);
                pdfArray3.add(new PdfNull());
            }
            put(PdfName.FILTER, pdfArray2);
            put(PdfName.DECODEPARMS, pdfArray3);
        }
        PdfName pdfName2 = PdfName.LENGTH;
        PdfObject pdfObject2 = get(pdfName2);
        if (encryption == null || pdfObject2 == null || !pdfObject2.isNumber()) {
            superToPdf(pdfWriter, outputStream);
        } else {
            put(pdfName2, new PdfNumber(encryption.calculateStreamSize(((PdfNumber) pdfObject2).intValue())));
            superToPdf(pdfWriter, outputStream);
            put(pdfName2, pdfObject2);
        }
        outputStream.write(PdfStream.STARTSTREAM);
        if (this.inputStream != null) {
            this.rawLength = 0;
            OutputStreamCounter outputStreamCounter = new OutputStreamCounter(outputStream);
            if (encryption != null) {
                encryptionStream = encryption.getEncryptionStream(outputStreamCounter);
                r3 = encryptionStream;
            } else {
                encryptionStream = outputStreamCounter;
                r3 = 0;
            }
            if (this.compressed) {
                Deflater deflater2 = new Deflater(this.compressionLevel);
                deflaterOutputStream = new DeflaterOutputStream(encryptionStream, deflater2, 32768);
                deflater = deflater2;
                r0 = deflaterOutputStream;
            } else {
                deflater = null;
                deflaterOutputStream = encryptionStream;
            }
            byte[] bArr = new byte[4192];
            while (true) {
                int i = this.inputStream.read(bArr);
                if (i <= 0) {
                    break;
                }
                deflaterOutputStream.write(bArr, 0, i);
                this.rawLength += i;
            }
            if (r0 != 0) {
                r0.finish();
                deflater.end();
            }
            if (r3 != 0) {
                r3.finish();
            }
            this.inputStreamLength = (int) outputStreamCounter.getCounter();
        } else if (encryption == null) {
            ByteArrayOutputStream byteArrayOutputStream = this.streamBytes;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.writeTo(outputStream);
            } else {
                outputStream.write(this.bytes);
            }
        } else {
            ByteArrayOutputStream byteArrayOutputStream2 = this.streamBytes;
            outputStream.write(byteArrayOutputStream2 != null ? encryption.encryptByteArray(byteArrayOutputStream2.toByteArray()) : encryption.encryptByteArray(this.bytes));
        }
        outputStream.write(PdfStream.ENDSTREAM);
    }

    public PdfEFStream(byte[] bArr) {
        super(bArr);
    }
}
