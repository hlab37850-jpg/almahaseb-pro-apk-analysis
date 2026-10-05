package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.security.XmlLocator;
import com.itextpdf.text.pdf.security.XpathConstructor;
import java.security.cert.Certificate;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class XmlSignatureAppearance {
    private String description;
    private String mimeType = "text/xml";
    private Certificate signCertificate;
    private Calendar signDate;
    private PdfStamper stamper;
    private PdfStamperImp writer;
    private XmlLocator xmlLocator;
    private XpathConstructor xpathConstructor;

    public XmlSignatureAppearance(PdfStamperImp pdfStamperImp) {
        this.writer = pdfStamperImp;
    }

    public void close() {
        this.writer.close(this.stamper.getMoreInfo());
    }

    public Certificate getCertificate() {
        return this.signCertificate;
    }

    public String getDescription() {
        return this.description;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Calendar getSignDate() {
        if (this.signDate == null) {
            this.signDate = Calendar.getInstance();
        }
        return this.signDate;
    }

    public PdfStamper getStamper() {
        return this.stamper;
    }

    public PdfStamperImp getWriter() {
        return this.writer;
    }

    public XmlLocator getXmlLocator() {
        return this.xmlLocator;
    }

    public XpathConstructor getXpathConstructor() {
        return this.xpathConstructor;
    }

    public void setCertificate(Certificate certificate) {
        this.signCertificate = certificate;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setSignDate(Calendar calendar) {
        this.signDate = calendar;
    }

    public void setStamper(PdfStamper pdfStamper) {
        this.stamper = pdfStamper;
    }

    public void setXmlLocator(XmlLocator xmlLocator) {
        this.xmlLocator = xmlLocator;
    }

    public void setXpathConstructor(XpathConstructor xpathConstructor) {
        this.xpathConstructor = xpathConstructor;
    }
}
