package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.itextpdf.text.pdf.security.LtvVerification;
import com.itextpdf.text.xml.xmp.PdfSchema;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PdfStamper implements PdfViewerPreferences, PdfEncryptionSettings {
    protected boolean hasSignature;
    private Map<String, String> moreInfo;
    protected PdfSignatureAppearance sigApp;
    protected XmlSignatureAppearance sigXmlApp;
    protected PdfStamperImp stamper;
    private LtvVerification verification;

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream) {
        this.stamper = new PdfStamperImp(pdfReader, outputStream, (char) 0, false);
    }

    public static PdfStamper createSignature(PdfReader pdfReader, OutputStream outputStream, char c, File file, boolean z) throws IOException {
        PdfStamper pdfStamper;
        if (file == null) {
            ByteBuffer byteBuffer = new ByteBuffer();
            pdfStamper = new PdfStamper(pdfReader, byteBuffer, c, z);
            PdfSignatureAppearance pdfSignatureAppearance = new PdfSignatureAppearance(pdfStamper.stamper);
            pdfStamper.sigApp = pdfSignatureAppearance;
            pdfSignatureAppearance.setSigout(byteBuffer);
        } else {
            if (file.isDirectory()) {
                file = File.createTempFile(PdfSchema.DEFAULT_XPATH_ID, ".pdf", file);
            }
            PdfStamper pdfStamper2 = new PdfStamper(pdfReader, new FileOutputStream(file), c, z);
            PdfSignatureAppearance pdfSignatureAppearance2 = new PdfSignatureAppearance(pdfStamper2.stamper);
            pdfStamper2.sigApp = pdfSignatureAppearance2;
            pdfSignatureAppearance2.setTempFile(file);
            pdfStamper = pdfStamper2;
        }
        pdfStamper.sigApp.setOriginalout(outputStream);
        pdfStamper.sigApp.setStamper(pdfStamper);
        pdfStamper.hasSignature = true;
        PdfDictionary catalog = pdfReader.getCatalog();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.ACROFORM), catalog);
        if (pdfDictionary != null) {
            pdfDictionary.remove(PdfName.NEEDAPPEARANCES);
            pdfStamper.stamper.markUsed(pdfDictionary);
        }
        return pdfStamper;
    }

    public static PdfStamper createXmlSignature(PdfReader pdfReader, OutputStream outputStream) {
        PdfStamper pdfStamper = new PdfStamper(pdfReader, outputStream);
        XmlSignatureAppearance xmlSignatureAppearance = new XmlSignatureAppearance(pdfStamper.stamper);
        pdfStamper.sigXmlApp = xmlSignatureAppearance;
        xmlSignatureAppearance.setStamper(pdfStamper);
        return pdfStamper;
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation, int i) {
        this.stamper.addAnnotation(pdfAnnotation, i);
    }

    public void addComments(FdfReader fdfReader) {
        this.stamper.addComments(fdfReader);
    }

    public void addFileAttachment(String str, byte[] bArr, String str2, String str3) {
        addFileAttachment(str, PdfFileSpecification.fileEmbedded(this.stamper, str2, str3, bArr));
    }

    public void addJavaScript(String str) {
        this.stamper.addJavaScript(str, !PdfEncodings.isPdfDocEncoding(str));
    }

    public boolean addNamedDestination(String str, int i, PdfDestination pdfDestination) {
        HashMap<Object, PdfObject> namedDestinations = this.stamper.getNamedDestinations();
        if (getReader().getNamedDestination().containsKey(str)) {
            return false;
        }
        PdfDestination pdfDestination2 = new PdfDestination(pdfDestination);
        pdfDestination2.addPage(getReader().getPageOrigRef(i));
        namedDestinations.put(str, new PdfArray((PdfArray) pdfDestination2));
        return true;
    }

    public PdfFormField addSignature(String str, int i, float f, float f2, float f3, float f4) {
        PdfAcroForm acroForm = this.stamper.getAcroForm();
        PdfFormField pdfFormFieldCreateSignature = PdfFormField.createSignature(this.stamper);
        acroForm.setSignatureParams(pdfFormFieldCreateSignature, str, f, f2, f3, f4);
        acroForm.drawSignatureAppearences(pdfFormFieldCreateSignature, f, f2, f3, f4);
        addAnnotation(pdfFormFieldCreateSignature, i);
        return pdfFormFieldCreateSignature;
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.stamper.addViewerPreference(pdfName, pdfObject);
    }

    public void close() throws DocumentException {
        if (this.stamper.closed) {
            return;
        }
        if (this.hasSignature) {
            throw new DocumentException("Signature defined. Must be closed in PdfSignatureAppearance.");
        }
        mergeVerification();
        this.stamper.close(this.moreInfo);
    }

    public void createXmpMetadata() {
        this.stamper.createXmpMetadata();
    }

    public void flush() {
        try {
            this.stamper.alterContents();
            this.stamper.pagesToContent.clear();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public AcroFields getAcroFields() {
        return this.stamper.getAcroFields();
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        return this.stamper.getImportedPage(pdfReader, i);
    }

    public LtvVerification getLtvVerification() {
        if (this.verification == null) {
            this.verification = new LtvVerification(this);
        }
        return this.verification;
    }

    public Map<String, String> getMoreInfo() {
        return this.moreInfo;
    }

    public PdfContentByte getOverContent(int i) {
        return this.stamper.getOverContent(i);
    }

    public Map<String, PdfLayer> getPdfLayers() {
        return this.stamper.getPdfLayers();
    }

    public PdfReader getReader() {
        return this.stamper.reader;
    }

    public PdfSignatureAppearance getSignatureAppearance() {
        return this.sigApp;
    }

    public PdfContentByte getUnderContent(int i) {
        return this.stamper.getUnderContent(i);
    }

    public PdfWriter getWriter() {
        return this.stamper;
    }

    public XmlSignatureAppearance getXmlSignatureAppearance() {
        return this.sigXmlApp;
    }

    public XmpWriter getXmpWriter() {
        return this.stamper.getXmpWriter();
    }

    public void insertPage(int i, Rectangle rectangle) {
        this.stamper.insertPage(i, rectangle);
    }

    public boolean isFullCompression() {
        return this.stamper.isFullCompression();
    }

    public boolean isRotateContents() {
        return this.stamper.isRotateContents();
    }

    public void makePackage(PdfName pdfName) {
        PdfCollection pdfCollection = new PdfCollection(0);
        pdfCollection.put(PdfName.VIEW, pdfName);
        this.stamper.makePackage(pdfCollection);
    }

    public void markUsed(PdfObject pdfObject) {
        this.stamper.markUsed(pdfObject);
    }

    public void mergeVerification() {
        LtvVerification ltvVerification = this.verification;
        if (ltvVerification == null) {
            return;
        }
        ltvVerification.merge();
    }

    public boolean partialFormFlattening(String str) {
        return this.stamper.partialFormFlattening(str);
    }

    public void replacePage(PdfReader pdfReader, int i, int i2) {
        this.stamper.replacePage(pdfReader, i, i2);
    }

    public void setAnnotationFlattening(boolean z) {
        this.stamper.setFlatAnnotations(z);
    }

    public void setDuration(int i, int i2) {
        this.stamper.setDuration(i, i2);
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        if (this.stamper.isAppend()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("append.mode.does.not.support.changing.the.encryption.status", new Object[0]));
        }
        if (this.stamper.isContentWritten()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("content.was.already.written.to.the.output", new Object[0]));
        }
        this.stamper.setEncryption(bArr, bArr2, i, z ? 1 : 0);
    }

    public void setFormFlattening(boolean z) {
        this.stamper.setFormFlattening(z);
    }

    public void setFreeTextFlattening(boolean z) {
        this.stamper.setFreeTextFlattening(z);
    }

    public void setFullCompression() {
        if (this.stamper.isAppend()) {
            return;
        }
        PdfStamperImp pdfStamperImp = this.stamper;
        pdfStamperImp.fullCompression = true;
        pdfStamperImp.setAtLeastPdfVersion(PdfWriter.VERSION_1_5);
    }

    public void setMoreInfo(Map<String, String> map) {
        this.moreInfo = map;
    }

    public void setOutlines(List<HashMap<String, Object>> list) {
        this.stamper.setOutlines(list);
    }

    public void setPageAction(PdfName pdfName, PdfAction pdfAction, int i) {
        this.stamper.setPageAction(pdfName, pdfAction, i);
    }

    public void setRotateContents(boolean z) {
        this.stamper.setRotateContents(z);
    }

    public void setThumbnail(Image image, int i) {
        this.stamper.setThumbnail(image, i);
    }

    public void setTransition(PdfTransition pdfTransition, int i) {
        this.stamper.setTransition(pdfTransition, i);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfViewerPreferences
    public void setViewerPreferences(int i) {
        this.stamper.setViewerPreferences(i);
    }

    public void setXmpMetadata(byte[] bArr) {
        this.stamper.setXmpMetadata(bArr);
    }

    public void addFileAttachment(String str, PdfFileSpecification pdfFileSpecification) {
        this.stamper.addFileAttachment(str, pdfFileSpecification);
    }

    public void addJavaScript(String str, String str2) {
        PdfStamperImp pdfStamperImp = this.stamper;
        pdfStamperImp.addJavaScript(str, PdfAction.javaScript(str2, pdfStamperImp, !PdfEncodings.isPdfDocEncoding(str2)));
    }

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream, char c) {
        this.stamper = new PdfStamperImp(pdfReader, outputStream, c, false);
    }

    public void makePackage(PdfCollection pdfCollection) {
        this.stamper.makePackage(pdfCollection);
    }

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream, char c, boolean z) {
        this.stamper = new PdfStamperImp(pdfReader, outputStream, c, z);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        if (!this.stamper.isAppend()) {
            if (!this.stamper.isContentWritten()) {
                this.stamper.setEncryption(bArr, bArr2, i, i2);
                return;
            }
            throw new DocumentException(MessageLocalization.getComposedMessage("content.was.already.written.to.the.output", new Object[0]));
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("append.mode.does.not.support.changing.the.encryption.status", new Object[0]));
    }

    public PdfStamper() {
    }

    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i, z);
    }

    public void setEncryption(int i, String str, String str2, int i2) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i2, i);
    }

    @Override // com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings
    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        if (!this.stamper.isAppend()) {
            if (!this.stamper.isContentWritten()) {
                this.stamper.setEncryption(certificateArr, iArr, i);
                return;
            }
            throw new DocumentException(MessageLocalization.getComposedMessage("content.was.already.written.to.the.output", new Object[0]));
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("append.mode.does.not.support.changing.the.encryption.status", new Object[0]));
    }

    public static PdfStamper createSignature(PdfReader pdfReader, OutputStream outputStream, char c) {
        return createSignature(pdfReader, outputStream, c, null, false);
    }

    public static PdfStamper createSignature(PdfReader pdfReader, OutputStream outputStream, char c, File file) {
        return createSignature(pdfReader, outputStream, c, file, false);
    }
}
