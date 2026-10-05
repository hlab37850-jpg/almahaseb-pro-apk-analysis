package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.security.XmlLocator;
import java.io.ByteArrayOutputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes3.dex */
public class XfaXmlLocator implements XmlLocator {
    private String encoding;
    private PdfStamper stamper;
    private XfaForm xfaForm;

    public XfaXmlLocator(PdfStamper pdfStamper) throws DocumentException {
        this.stamper = pdfStamper;
        try {
            createXfaForm();
        } catch (ParserConfigurationException e) {
            throw new DocumentException(e);
        } catch (SAXException e2) {
            throw new DocumentException(e2);
        }
    }

    public void createXfaForm() {
        this.xfaForm = new XfaForm(this.stamper.getReader());
    }

    @Override // com.itextpdf.text.pdf.security.XmlLocator
    public Document getDocument() {
        return this.xfaForm.getDomDocument();
    }

    @Override // com.itextpdf.text.pdf.security.XmlLocator
    public String getEncoding() {
        return this.encoding;
    }

    @Override // com.itextpdf.text.pdf.security.XmlLocator
    public void setDocument(Document document) throws DocumentException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(byteArrayOutputStream));
            this.stamper.getReader().getAcroForm().put(PdfName.XFA, this.stamper.getWriter().addToBody(new PdfStream(byteArrayOutputStream.toByteArray())).getIndirectReference());
        } catch (TransformerConfigurationException e) {
            throw new DocumentException(e);
        } catch (TransformerException e2) {
            throw new DocumentException(e2);
        }
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }
}
