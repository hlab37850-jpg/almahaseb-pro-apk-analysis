package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class PdfCopyFields implements PdfViewerPreferences, PdfEncryptionSettings {
    private PdfCopyFieldsImp fc;

    public PdfCopyFields(OutputStream outputStream) {
        this.fc = new PdfCopyFieldsImp(outputStream);
    }

    public void addDocument(PdfReader pdfReader) {
        this.fc.addDocument(pdfReader);
    }

    public void addJavaScript(String str) {
        this.fc.addJavaScript(str, !PdfEncodings.isPdfDocEncoding(str));
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.fc.addViewerPreference(pdfName, pdfObject);
    }

    public void close() {
        this.fc.close();
    }

    public PdfWriter getWriter() {
        return this.fc;
    }

    public boolean isFullCompression() {
        return this.fc.isFullCompression();
    }

    public void open() {
        this.fc.openDoc();
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        this.fc.setEncryption(bArr, bArr2, i, z ? 1 : 0);
    }

    public void setFullCompression() throws DocumentException {
        this.fc.setFullCompression();
    }

    public void setOutlines(List<HashMap<String, Object>> list) {
        this.fc.setOutlines(list);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void setViewerPreferences(int i) {
        this.fc.setViewerPreferences(i);
    }

    public void addDocument(PdfReader pdfReader, List<Integer> list) {
        this.fc.addDocument(pdfReader, list);
    }

    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i, z);
    }

    public PdfCopyFields(OutputStream outputStream, char c) {
        this.fc = new PdfCopyFieldsImp(outputStream, c);
    }

    public void addDocument(PdfReader pdfReader, String str) {
        this.fc.addDocument(pdfReader, SequenceList.expand(str, pdfReader.getNumberOfPages()));
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        this.fc.setEncryption(bArr, bArr2, i, i2);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        this.fc.setEncryption(certificateArr, iArr, i);
    }
}
