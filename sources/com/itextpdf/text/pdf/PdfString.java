package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class PdfString extends PdfObject {
    protected String encoding;
    protected boolean hexWriting;
    protected int objGen;
    protected int objNum;
    protected String originalValue;
    protected String value;

    public PdfString() {
        super(3);
        this.value = "";
        this.originalValue = null;
        this.encoding = PdfObject.TEXT_PDFDOCENCODING;
        this.objNum = 0;
        this.objGen = 0;
        this.hexWriting = false;
    }

    public void decrypt(PdfReader pdfReader) {
        PdfEncryption decrypt = pdfReader.getDecrypt();
        if (decrypt != null) {
            this.originalValue = this.value;
            decrypt.setHashKey(this.objNum, this.objGen);
            byte[] bArrConvertToBytes = PdfEncodings.convertToBytes(this.value, (String) null);
            this.bytes = bArrConvertToBytes;
            byte[] bArrDecryptByteArray = decrypt.decryptByteArray(bArrConvertToBytes);
            this.bytes = bArrDecryptByteArray;
            this.value = PdfEncodings.convertToString(bArrDecryptByteArray, null);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public byte[] getBytes() {
        if (this.bytes == null) {
            String str = this.encoding;
            if (str != null && str.equals(PdfObject.TEXT_UNICODE) && PdfEncodings.isPdfDocEncoding(this.value)) {
                this.bytes = PdfEncodings.convertToBytes(this.value, PdfObject.TEXT_PDFDOCENCODING);
            } else {
                this.bytes = PdfEncodings.convertToBytes(this.value, this.encoding);
            }
        }
        return this.bytes;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public byte[] getOriginalBytes() {
        String str = this.originalValue;
        return str == null ? getBytes() : PdfEncodings.convertToBytes(str, (String) null);
    }

    public boolean isHexWriting() {
        return this.hexWriting;
    }

    public PdfString setHexWriting(boolean z) {
        this.hexWriting = z;
        return this;
    }

    public void setObjNum(int i, int i2) {
        this.objNum = i;
        this.objGen = i2;
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        PdfWriter.checkPdfIsoConformance(pdfWriter, 11, this);
        byte[] bytes = getBytes();
        PdfEncryption encryption = pdfWriter != null ? pdfWriter.getEncryption() : null;
        if (encryption != null && !encryption.isEmbeddedFilesOnly()) {
            bytes = encryption.encryptByteArray(bytes);
        }
        if (!this.hexWriting) {
            outputStream.write(StringUtils.escapeString(bytes));
            return;
        }
        ByteBuffer byteBuffer = new ByteBuffer();
        byteBuffer.append('<');
        for (byte b : bytes) {
            byteBuffer.appendHex(b);
        }
        byteBuffer.append('>');
        outputStream.write(byteBuffer.toByteArray());
    }

    @Override // com.itextpdf.text.pdf.PdfObject
    public String toString() {
        return this.value;
    }

    public String toUnicodeString() {
        String str = this.encoding;
        if (str != null && str.length() != 0) {
            return this.value;
        }
        getBytes();
        byte[] bArr = this.bytes;
        return (bArr.length >= 2 && bArr[0] == -2 && bArr[1] == -1) ? PdfEncodings.convertToString(bArr, PdfObject.TEXT_UNICODE) : PdfEncodings.convertToString(bArr, PdfObject.TEXT_PDFDOCENCODING);
    }

    public PdfString(String str) {
        super(3);
        this.originalValue = null;
        this.encoding = PdfObject.TEXT_PDFDOCENCODING;
        this.objNum = 0;
        this.objGen = 0;
        this.hexWriting = false;
        this.value = str;
    }

    public PdfString(String str, String str2) {
        super(3);
        this.originalValue = null;
        this.objNum = 0;
        this.objGen = 0;
        this.hexWriting = false;
        this.value = str;
        this.encoding = str2;
    }

    public PdfString(byte[] bArr) {
        super(3);
        this.value = "";
        this.originalValue = null;
        this.encoding = PdfObject.TEXT_PDFDOCENCODING;
        this.objNum = 0;
        this.objGen = 0;
        this.hexWriting = false;
        this.value = PdfEncodings.convertToString(bArr, null);
        this.encoding = "";
    }
}
