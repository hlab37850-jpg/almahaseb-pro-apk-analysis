package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PdfLayer extends PdfDictionary implements PdfOCG {
    protected ArrayList<PdfLayer> children;
    private boolean on;
    private boolean onPanel;
    protected PdfLayer parent;
    protected PdfIndirectReference ref;
    protected String title;

    public PdfLayer(String str) {
        this.on = true;
        this.onPanel = true;
        this.title = str;
    }

    public static PdfLayer createTitle(String str, PdfWriter pdfWriter) {
        if (str == null) {
            throw new NullPointerException(MessageLocalization.getComposedMessage("title.cannot.be.null", new Object[0]));
        }
        PdfLayer pdfLayer = new PdfLayer(str);
        pdfWriter.registerLayer(pdfLayer);
        return pdfLayer;
    }

    private PdfDictionary getUsage() {
        PdfName pdfName = PdfName.USAGE;
        PdfDictionary asDict = getAsDict(pdfName);
        if (asDict != null) {
            return asDict;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        put(pdfName, pdfDictionary);
        return pdfDictionary;
    }

    public void addChild(PdfLayer pdfLayer) {
        if (pdfLayer.parent != null) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.layer.1.already.has.a.parent", pdfLayer.getAsString(PdfName.NAME).toUnicodeString()));
        }
        pdfLayer.parent = this;
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(pdfLayer);
    }

    public ArrayList<PdfLayer> getChildren() {
        return this.children;
    }

    public PdfLayer getParent() {
        return this.parent;
    }

    @Override // com.itextpdf.text.pdf.PdfOCG
    public PdfObject getPdfObject() {
        return this;
    }

    @Override // com.itextpdf.text.pdf.PdfOCG
    public PdfIndirectReference getRef() {
        return this.ref;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isOn() {
        return this.on;
    }

    public boolean isOnPanel() {
        return this.onPanel;
    }

    public void setCreatorInfo(String str, String str2) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.CREATOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        pdfDictionary.put(PdfName.SUBTYPE, new PdfName(str2));
        usage.put(PdfName.CREATORINFO, pdfDictionary);
    }

    public void setExport(boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.EXPORTSTATE, z ? PdfName.ON : PdfName.OFF);
        usage.put(PdfName.EXPORT, pdfDictionary);
    }

    public void setLanguage(String str, boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.LANG, new PdfString(str, PdfObject.TEXT_UNICODE));
        if (z) {
            pdfDictionary.put(PdfName.PREFERRED, PdfName.ON);
        }
        usage.put(PdfName.LANGUAGE, pdfDictionary);
    }

    public void setName(String str) {
        put(PdfName.NAME, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setOn(boolean z) {
        this.on = z;
    }

    public void setOnPanel(boolean z) {
        this.onPanel = z;
    }

    public void setPageElement(String str) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.SUBTYPE, new PdfName(str));
        usage.put(PdfName.PAGEELEMENT, pdfDictionary);
    }

    public void setPrint(String str, boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.SUBTYPE, new PdfName(str));
        pdfDictionary.put(PdfName.PRINTSTATE, z ? PdfName.ON : PdfName.OFF);
        usage.put(PdfName.PRINT, pdfDictionary);
    }

    public void setRef(PdfIndirectReference pdfIndirectReference) {
        this.ref = pdfIndirectReference;
    }

    public void setUser(String str, String... strArr) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.TYPE, new PdfName(str));
        PdfArray pdfArray = new PdfArray();
        for (String str2 : strArr) {
            pdfArray.add(new PdfString(str2, PdfObject.TEXT_UNICODE));
        }
        usage.put(PdfName.NAME, pdfArray);
        usage.put(PdfName.USER, pdfDictionary);
    }

    public void setView(boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.VIEWSTATE, z ? PdfName.ON : PdfName.OFF);
        usage.put(PdfName.VIEW, pdfDictionary);
    }

    public void setZoom(float f, float f2) {
        if (f > 0.0f || f2 >= 0.0f) {
            PdfDictionary usage = getUsage();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (f > 0.0f) {
                pdfDictionary.put(PdfName.MIN_LOWER_CASE, new PdfNumber(f));
            }
            if (f2 >= 0.0f) {
                pdfDictionary.put(PdfName.MAX_LOWER_CASE, new PdfNumber(f2));
            }
            usage.put(PdfName.ZOOM, pdfDictionary);
        }
    }

    public PdfLayer(String str, PdfWriter pdfWriter) {
        super(PdfName.OCG);
        this.on = true;
        this.onPanel = true;
        setName(str);
        if (pdfWriter instanceof PdfStamperImp) {
            this.ref = pdfWriter.addToBody(this).getIndirectReference();
        } else {
            this.ref = pdfWriter.getPdfIndirectReference();
        }
        pdfWriter.registerLayer(this);
    }
}
