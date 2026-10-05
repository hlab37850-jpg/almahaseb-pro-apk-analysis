package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class Paragraph extends Phrase implements Indentable, Spaceable, IAccessibleElement {
    private static final long serialVersionUID = 7852314969733375514L;
    protected HashMap<PdfName, PdfObject> accessibleAttributes;
    protected int alignment;
    private float extraParagraphSpace;
    private float firstLineIndent;
    protected AccessibleElementId id;
    protected float indentationLeft;
    protected float indentationRight;
    protected boolean keeptogether;
    protected float paddingTop;
    protected PdfName role;
    protected float spacingAfter;
    protected float spacingBefore;

    public Paragraph() {
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
        this.role = PdfName.P;
        this.accessibleAttributes = null;
        this.id = null;
    }

    public java.util.List<Element> breakUp() {
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it = iterator();
        Paragraph paragraphCloneShallow = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Element next = it.next();
            if (next.type() == 14 || next.type() == 23 || next.type() == 12) {
                if (paragraphCloneShallow != null && paragraphCloneShallow.size() > 0) {
                    paragraphCloneShallow.setSpacingAfter(0.0f);
                    arrayList.add(paragraphCloneShallow);
                    paragraphCloneShallow = cloneShallow(false);
                }
                if (arrayList.size() == 0) {
                    int iType = next.type();
                    if (iType == 12) {
                        ((Paragraph) next).setSpacingBefore(getSpacingBefore());
                    } else if (iType == 14) {
                        ListItem firstItem = ((List) next).getFirstItem();
                        if (firstItem != null) {
                            firstItem.setSpacingBefore(getSpacingBefore());
                        }
                    } else if (iType == 23) {
                        ((PdfPTable) next).setSpacingBefore(getSpacingBefore());
                    }
                }
                arrayList.add(next);
            } else {
                if (paragraphCloneShallow == null) {
                    paragraphCloneShallow = cloneShallow(arrayList.size() == 0);
                }
                paragraphCloneShallow.add(next);
            }
        }
        if (paragraphCloneShallow != null && paragraphCloneShallow.size() > 0) {
            arrayList.add(paragraphCloneShallow);
        }
        if (arrayList.size() != 0) {
            Element element = (Element) arrayList.get(arrayList.size() - 1);
            int iType2 = element.type();
            if (iType2 == 12) {
                ((Paragraph) element).setSpacingAfter(getSpacingAfter());
            } else if (iType2 == 14) {
                ListItem lastItem = ((List) element).getLastItem();
                if (lastItem != null) {
                    lastItem.setSpacingAfter(getSpacingAfter());
                }
            } else if (iType2 == 23) {
                ((PdfPTable) element).setSpacingAfter(getSpacingAfter());
            }
        }
        return arrayList;
    }

    public Paragraph cloneShallow(boolean z) {
        Paragraph paragraph = new Paragraph();
        populateProperties(paragraph, z);
        return paragraph;
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

    public int getAlignment() {
        return this.alignment;
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public float getFirstLineIndent() {
        return this.firstLineIndent;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        if (this.id == null) {
            this.id = new AccessibleElementId();
        }
        return this.id;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    @Override // com.itextpdf.text.api.Indentable
    public float getIndentationRight() {
        return this.indentationRight;
    }

    public boolean getKeepTogether() {
        return this.keeptogether;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getPaddingTop() {
        return this.paddingTop;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return false;
    }

    public void populateProperties(Paragraph paragraph, boolean z) {
        paragraph.setFont(getFont());
        paragraph.setAlignment(getAlignment());
        paragraph.setLeading(getLeading(), this.multipliedLeading);
        paragraph.setIndentationLeft(getIndentationLeft());
        paragraph.setIndentationRight(getIndentationRight());
        paragraph.setFirstLineIndent(getFirstLineIndent());
        paragraph.setSpacingAfter(getSpacingAfter());
        if (z) {
            paragraph.setSpacingBefore(getSpacingBefore());
        }
        paragraph.setExtraParagraphSpace(getExtraParagraphSpace());
        paragraph.setRole(this.role);
        paragraph.id = getId();
        if (this.accessibleAttributes != null) {
            paragraph.accessibleAttributes = new HashMap<>(this.accessibleAttributes);
        }
        paragraph.setTabSettings(getTabSettings());
        paragraph.setKeepTogether(getKeepTogether());
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    public void setFirstLineIndent(float f) {
        this.firstLineIndent = f;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.id = accessibleElementId;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    @Override // com.itextpdf.text.api.Indentable
    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setKeepTogether(boolean z) {
        this.keeptogether = z;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
        this.role = pdfName;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    @Override // com.itextpdf.text.api.Spaceable
    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    @Deprecated
    public float spacingAfter() {
        return this.spacingAfter;
    }

    @Deprecated
    public float spacingBefore() {
        return getSpacingBefore();
    }

    @Override // com.itextpdf.text.Phrase, com.itextpdf.text.Element
    public int type() {
        return 12;
    }

    @Override // com.itextpdf.text.Phrase, java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Element element) {
        if (element instanceof List) {
            List list = (List) element;
            list.setIndentationLeft(list.getIndentationLeft() + this.indentationLeft);
            list.setIndentationRight(this.indentationRight);
            return super.add((Element) list);
        }
        if (element instanceof Image) {
            super.addSpecial(element);
            return true;
        }
        if (!(element instanceof Paragraph)) {
            return super.add(element);
        }
        super.addSpecial(element);
        return true;
    }

    public Paragraph(float f) {
        super(f);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
        this.role = PdfName.P;
        this.accessibleAttributes = null;
        this.id = null;
    }

    public Paragraph(Chunk chunk) {
        super(chunk);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
        this.role = PdfName.P;
        this.accessibleAttributes = null;
        this.id = null;
    }

    public Paragraph(float f, Chunk chunk) {
        super(f, chunk);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
        this.role = PdfName.P;
        this.accessibleAttributes = null;
        this.id = null;
    }

    public Paragraph(String str) {
        super(str);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
        this.role = PdfName.P;
        this.accessibleAttributes = null;
        this.id = null;
    }

    public Paragraph(String str, Font font) {
        super(str, font);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
        this.role = PdfName.P;
        this.accessibleAttributes = null;
        this.id = null;
    }

    public Paragraph(float f, String str) {
        super(f, str);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
        this.role = PdfName.P;
        this.accessibleAttributes = null;
        this.id = null;
    }

    public Paragraph(float f, String str, Font font) {
        super(f, str, font);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
        this.role = PdfName.P;
        this.accessibleAttributes = null;
        this.id = null;
    }

    public Paragraph(Phrase phrase) {
        super(phrase);
        this.alignment = -1;
        this.firstLineIndent = 0.0f;
        this.extraParagraphSpace = 0.0f;
        this.keeptogether = false;
        this.role = PdfName.P;
        this.accessibleAttributes = null;
        this.id = null;
        if (phrase instanceof Paragraph) {
            Paragraph paragraph = (Paragraph) phrase;
            setAlignment(paragraph.alignment);
            setIndentationLeft(paragraph.getIndentationLeft());
            setIndentationRight(paragraph.getIndentationRight());
            setFirstLineIndent(paragraph.getFirstLineIndent());
            setSpacingAfter(paragraph.getSpacingAfter());
            setSpacingBefore(paragraph.getSpacingBefore());
            setExtraParagraphSpace(paragraph.getExtraParagraphSpace());
            setRole(paragraph.role);
            this.id = paragraph.getId();
            if (paragraph.accessibleAttributes != null) {
                this.accessibleAttributes = new HashMap<>(paragraph.accessibleAttributes);
            }
        }
    }
}
