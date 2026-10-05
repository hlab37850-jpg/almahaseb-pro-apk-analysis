package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PdfTemplate extends PdfContentByte implements IAccessibleElement {
    public static final int TYPE_IMPORTED = 2;
    public static final int TYPE_PATTERN = 3;
    public static final int TYPE_TEMPLATE = 1;
    protected HashMap<PdfName, PdfObject> accessibleAttributes;
    private PdfDictionary additional;
    protected Rectangle bBox;
    protected boolean contentTagged;
    protected PdfTransparencyGroup group;
    private AccessibleElementId id;
    protected PdfOCG layer;
    protected PdfArray matrix;
    protected PdfIndirectReference pageReference;
    protected PageResources pageResources;
    protected PdfName role;
    protected PdfIndirectReference thisReference;
    protected int type;

    public PdfTemplate() {
        super(null);
        this.bBox = new Rectangle(0.0f, 0.0f);
        this.contentTagged = false;
        this.additional = null;
        this.role = PdfName.FIGURE;
        this.accessibleAttributes = null;
        this.id = null;
        this.type = 1;
    }

    public static PdfTemplate createTemplate(PdfWriter pdfWriter, float f, float f2) {
        return createTemplate(pdfWriter, f, f2, null);
    }

    public void beginVariableText() {
        this.content.append("/Tx BMC ");
    }

    public void endVariableText() {
        this.content.append("EMC ");
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfObject getAccessibleAttribute(PdfName pdfName) {
        HashMap<PdfName, PdfObject> map = this.accessibleAttributes;
        if (map != null) {
            return map.get(pdfName);
        }
        return null;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public HashMap<PdfName, PdfObject> getAccessibleAttributes() {
        return this.accessibleAttributes;
    }

    public PdfDictionary getAdditional() {
        return this.additional;
    }

    public Rectangle getBoundingBox() {
        return this.bBox;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PdfIndirectReference getCurrentPage() {
        PdfIndirectReference pdfIndirectReference = this.pageReference;
        return pdfIndirectReference == null ? this.writer.getCurrentPage() : pdfIndirectReference;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PdfContentByte getDuplicate() {
        PdfTemplate pdfTemplate = new PdfTemplate();
        pdfTemplate.writer = this.writer;
        pdfTemplate.pdf = this.pdf;
        pdfTemplate.thisReference = this.thisReference;
        pdfTemplate.pageResources = this.pageResources;
        pdfTemplate.bBox = new Rectangle(this.bBox);
        pdfTemplate.group = this.group;
        pdfTemplate.layer = this.layer;
        PdfArray pdfArray = this.matrix;
        if (pdfArray != null) {
            pdfTemplate.matrix = new PdfArray(pdfArray);
        }
        pdfTemplate.separator = this.separator;
        pdfTemplate.additional = this.additional;
        pdfTemplate.contentTagged = this.contentTagged;
        pdfTemplate.duplicatedFrom = this;
        return pdfTemplate;
    }

    public PdfStream getFormXObject(int i) {
        return new PdfFormXObject(this, i);
    }

    public PdfTransparencyGroup getGroup() {
        return this.group;
    }

    public float getHeight() {
        return this.bBox.getHeight();
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        if (this.id == null) {
            this.id = new AccessibleElementId();
        }
        return this.id;
    }

    public PdfIndirectReference getIndirectReference() {
        if (this.thisReference == null) {
            this.thisReference = this.writer.getPdfIndirectReference();
        }
        return this.thisReference;
    }

    public PdfOCG getLayer() {
        return this.layer;
    }

    public PdfArray getMatrix() {
        return this.matrix;
    }

    public PdfIndirectReference getPageReference() {
        return this.pageReference;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public PageResources getPageResources() {
        return this.pageResources;
    }

    public PdfObject getResources() {
        return getPageResources().getResources();
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    public int getType() {
        return this.type;
    }

    public float getWidth() {
        return this.bBox.getWidth();
    }

    public boolean isContentTagged() {
        return this.contentTagged;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return true;
    }

    @Override // com.itextpdf.text.pdf.PdfContentByte
    public boolean isTagged() {
        return super.isTagged() && this.contentTagged;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    public void setAdditional(PdfDictionary pdfDictionary) {
        this.additional = pdfDictionary;
    }

    public void setBoundingBox(Rectangle rectangle) {
        this.bBox = rectangle;
    }

    public void setContentTagged(boolean z) {
        this.contentTagged = z;
    }

    public void setGroup(PdfTransparencyGroup pdfTransparencyGroup) {
        this.group = pdfTransparencyGroup;
    }

    public void setHeight(float f) {
        this.bBox.setBottom(0.0f);
        this.bBox.setTop(f);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.id = accessibleElementId;
    }

    public void setLayer(PdfOCG pdfOCG) {
        this.layer = pdfOCG;
    }

    public void setMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        PdfArray pdfArray = new PdfArray();
        this.matrix = pdfArray;
        pdfArray.add(new PdfNumber(f));
        this.matrix.add(new PdfNumber(f2));
        this.matrix.add(new PdfNumber(f3));
        this.matrix.add(new PdfNumber(f4));
        this.matrix.add(new PdfNumber(f5));
        this.matrix.add(new PdfNumber(f6));
    }

    public void setPageReference(PdfIndirectReference pdfIndirectReference) {
        this.pageReference = pdfIndirectReference;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    public void setWidth(float f) {
        this.bBox.setLeft(0.0f);
        this.bBox.setRight(f);
    }

    public static PdfTemplate createTemplate(PdfWriter pdfWriter, float f, float f2, PdfName pdfName) {
        PdfTemplate pdfTemplate = new PdfTemplate(pdfWriter);
        pdfTemplate.setWidth(f);
        pdfTemplate.setHeight(f2);
        pdfWriter.addDirectTemplateSimple(pdfTemplate, pdfName);
        return pdfTemplate;
    }

    public PdfTemplate(PdfWriter pdfWriter) {
        super(pdfWriter);
        this.bBox = new Rectangle(0.0f, 0.0f);
        this.contentTagged = false;
        this.additional = null;
        this.role = PdfName.FIGURE;
        this.accessibleAttributes = null;
        this.id = null;
        this.type = 1;
        PageResources pageResources = new PageResources();
        this.pageResources = pageResources;
        pageResources.addDefaultColor(pdfWriter.getDefaultColorspace());
        this.thisReference = this.writer.getPdfIndirectReference();
    }
}
