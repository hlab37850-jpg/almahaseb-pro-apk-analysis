package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PdfStream extends PdfDictionary {
    public static final int BEST_COMPRESSION = 9;
    public static final int BEST_SPEED = 1;
    public static final int DEFAULT_COMPRESSION = -1;
    static final byte[] ENDSTREAM;
    public static final int NO_COMPRESSION = 0;
    static final int SIZESTREAM;
    static final byte[] STARTSTREAM;
    protected InputStream inputStream;
    protected int rawLength;
    protected PdfIndirectReference ref;
    protected PdfWriter writer;
    protected boolean compressed = false;
    protected int compressionLevel = 0;
    protected ByteArrayOutputStream streamBytes = null;
    protected int inputStreamLength = -1;

    static {
        byte[] iSOBytes = DocWriter.getISOBytes("stream\n");
        STARTSTREAM = iSOBytes;
        byte[] iSOBytes2 = DocWriter.getISOBytes("\nendstream");
        ENDSTREAM = iSOBytes2;
        SIZESTREAM = iSOBytes.length + iSOBytes2.length;
    }

    public PdfStream(byte[] bArr) {
        this.type = 7;
        this.bytes = bArr;
        this.rawLength = bArr.length;
        put(PdfName.LENGTH, new PdfNumber(bArr.length));
    }

    public void flateCompress() {
        flateCompress(-1);
    }

    public int getRawLength() {
        return this.rawLength;
    }

    public void superToPdf(PdfWriter pdfWriter, OutputStream outputStream) {
        super.toPdf(pdfWriter, outputStream);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.itextpdf.text.pdf.OutputStreamEncryption] */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
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
        PdfName pdfName2 = PdfName.LENGTH;
        PdfObject pdfObject2 = get(pdfName2);
        if (encryption == null || pdfObject2 == null || !pdfObject2.isNumber()) {
            superToPdf(pdfWriter, outputStream);
        } else {
            put(pdfName2, new PdfNumber(encryption.calculateStreamSize(((PdfNumber) pdfObject2).intValue())));
            superToPdf(pdfWriter, outputStream);
            put(pdfName2, pdfObject2);
        }
        PdfWriter.checkPdfIsoConformance(pdfWriter, 9, this);
        outputStream.write(STARTSTREAM);
        if (this.inputStream != null) {
            this.rawLength = 0;
            OutputStreamCounter outputStreamCounter = new OutputStreamCounter(outputStream);
            if (encryption == null || encryption.isEmbeddedFilesOnly()) {
                encryptionStream = outputStreamCounter;
                r3 = 0;
            } else {
                encryptionStream = encryption.getEncryptionStream(outputStreamCounter);
                r3 = encryptionStream;
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
        } else if (encryption == null || encryption.isEmbeddedFilesOnly()) {
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
        outputStream.write(ENDSTREAM);
    }

    @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
    public String toString() {
        PdfName pdfName = PdfName.TYPE;
        if (get(pdfName) == null) {
            return "Stream";
        }
        return "Stream of type: " + get(pdfName);
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.streamBytes;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.writeTo(outputStream);
            return;
        }
        byte[] bArr = this.bytes;
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public void writeLength() throws IOException {
        if (this.inputStream == null) {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("writelength.can.only.be.called.in.a.contructed.pdfstream.inputstream.pdfwriter", new Object[0]));
        }
        int i = this.inputStreamLength;
        if (i == -1) {
            throw new IOException(MessageLocalization.getComposedMessage("writelength.can.only.be.called.after.output.of.the.stream.body", new Object[0]));
        }
        this.writer.addToBody((PdfObject) new PdfNumber(i), this.ref, false);
    }

    public void flateCompress(int i) {
        if (Document.compress && !this.compressed) {
            this.compressionLevel = i;
            if (this.inputStream != null) {
                this.compressed = true;
                return;
            }
            PdfName pdfName = PdfName.FILTER;
            PdfObject pdfObject = PdfReader.getPdfObject(get(pdfName));
            if (pdfObject != null) {
                if (pdfObject.isName()) {
                    if (PdfName.FLATEDECODE.equals(pdfObject)) {
                        return;
                    }
                } else {
                    if (!pdfObject.isArray()) {
                        throw new RuntimeException(MessageLocalization.getComposedMessage("stream.could.not.be.compressed.filter.is.not.a.name.or.array", new Object[0]));
                    }
                    if (((PdfArray) pdfObject).contains(PdfName.FLATEDECODE)) {
                        return;
                    }
                }
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Deflater deflater = new Deflater(i);
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                ByteArrayOutputStream byteArrayOutputStream2 = this.streamBytes;
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.writeTo(deflaterOutputStream);
                } else {
                    deflaterOutputStream.write(this.bytes);
                }
                deflaterOutputStream.close();
                deflater.end();
                this.streamBytes = byteArrayOutputStream;
                this.bytes = null;
                put(PdfName.LENGTH, new PdfNumber(byteArrayOutputStream.size()));
                if (pdfObject == null) {
                    put(pdfName, PdfName.FLATEDECODE);
                } else {
                    PdfArray pdfArray = new PdfArray(pdfObject);
                    pdfArray.add(0, PdfName.FLATEDECODE);
                    put(pdfName, pdfArray);
                }
                this.compressed = true;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public PdfStream(InputStream inputStream, PdfWriter pdfWriter) {
        this.type = 7;
        this.inputStream = inputStream;
        this.writer = pdfWriter;
        PdfIndirectReference pdfIndirectReference = pdfWriter.getPdfIndirectReference();
        this.ref = pdfIndirectReference;
        put(PdfName.LENGTH, pdfIndirectReference);
    }

    public PdfStream() {
        this.type = 7;
    }
}
