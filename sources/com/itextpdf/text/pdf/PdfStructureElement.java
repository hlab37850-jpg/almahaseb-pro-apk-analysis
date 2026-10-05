package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListBody;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.ListLabel;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.interfaces.IPdfStructureElement;
import java.io.OutputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PdfStructureElement extends PdfDictionary implements IPdfStructureElement {
    private AccessibleElementId elementId;
    private transient PdfStructureElement parent;
    private PdfIndirectReference reference;
    private PdfName structureType;
    private transient PdfStructureTreeRoot top;

    public PdfStructureElement(PdfStructureElement pdfStructureElement, PdfName pdfName) {
        this.top = pdfStructureElement.top;
        init(pdfStructureElement, pdfName);
        this.parent = pdfStructureElement;
        put(PdfName.P, pdfStructureElement.reference);
        put(PdfName.TYPE, PdfName.STRUCTELEM);
    }

    private boolean colorsEqual(PdfArray pdfArray, float[] fArr) {
        return Float.compare(fArr[0], pdfArray.getAsNumber(0).floatValue()) == 0 && Float.compare(fArr[1], pdfArray.getAsNumber(1).floatValue()) == 0 && Float.compare(fArr[2], pdfArray.getAsNumber(2).floatValue()) == 0;
    }

    private PdfObject getParentAttribute(IPdfStructureElement iPdfStructureElement, PdfName pdfName) {
        if (iPdfStructureElement == null) {
            return null;
        }
        return iPdfStructureElement.getAttribute(pdfName);
    }

    private void init(PdfDictionary pdfDictionary, PdfName pdfName) {
        PdfArray pdfArray;
        PdfDictionary asDict;
        if (this.top.getWriter().getStandardStructElems().contains(pdfName)) {
            this.structureType = pdfName;
        } else {
            PdfDictionary asDict2 = this.top.getAsDict(PdfName.ROLEMAP);
            if (asDict2 == null || !asDict2.contains(pdfName)) {
                throw new ExceptionConverter(new DocumentException(MessageLocalization.getComposedMessage("unknown.structure.element.role.1", pdfName.toString())));
            }
            this.structureType = asDict2.getAsName(pdfName);
        }
        PdfName pdfName2 = PdfName.K;
        PdfObject pdfObject = pdfDictionary.get(pdfName2);
        if (pdfObject == null) {
            pdfArray = new PdfArray();
            pdfDictionary.put(pdfName2, pdfArray);
        } else if (pdfObject instanceof PdfArray) {
            pdfArray = (PdfArray) pdfObject;
        } else {
            PdfArray pdfArray2 = new PdfArray();
            pdfArray2.add(pdfObject);
            pdfDictionary.put(pdfName2, pdfArray2);
            pdfArray = pdfArray2;
        }
        if (pdfArray.size() > 0) {
            if (pdfArray.getAsNumber(0) != null) {
                pdfArray.remove(0);
            }
            if (pdfArray.size() > 0 && (asDict = pdfArray.getAsDict(0)) != null && PdfName.MCR.equals(asDict.getAsName(PdfName.TYPE))) {
                pdfArray.remove(0);
            }
        }
        put(PdfName.S, pdfName);
        PdfIndirectReference pdfIndirectReference = this.top.getWriter().getPdfIndirectReference();
        this.reference = pdfIndirectReference;
        pdfArray.add(pdfIndirectReference);
    }

    private void setColorAttribute(BaseColor baseColor, PdfObject pdfObject, PdfName pdfName) {
        float[] fArr = {baseColor.getRed() / 255.0f, baseColor.getGreen() / 255.0f, baseColor.getBlue() / 255.0f};
        if (pdfObject == null || !(pdfObject instanceof PdfArray)) {
            setAttribute(pdfName, new PdfArray(fArr));
        } else if (colorsEqual((PdfArray) pdfObject, fArr)) {
            setAttribute(pdfName, new PdfArray(fArr));
        } else {
            setAttribute(pdfName, new PdfArray(fArr));
        }
    }

    private void setTextAlignAttribute(int i) {
        PdfName pdfName;
        if (i == 0) {
            pdfName = PdfName.START;
        } else if (i == 1) {
            pdfName = PdfName.CENTER;
        } else if (i != 2) {
            pdfName = i != 3 ? null : PdfName.JUSTIFY;
        } else {
            pdfName = PdfName.END;
        }
        PdfStructureElement pdfStructureElement = this.parent;
        PdfName pdfName2 = PdfName.TEXTALIGN;
        PdfObject parentAttribute = getParentAttribute(pdfStructureElement, pdfName2);
        if (!(parentAttribute instanceof PdfName)) {
            if (pdfName == null || PdfName.START.equals(pdfName)) {
                return;
            }
            setAttribute(pdfName2, pdfName);
            return;
        }
        PdfName pdfName3 = (PdfName) parentAttribute;
        if (pdfName == null || pdfName3.equals(pdfName)) {
            return;
        }
        setAttribute(pdfName2, pdfName);
    }

    private void writeAttributes(Document document) {
    }

    @Override // com.itextpdf.text.pdf.interfaces.IPdfStructureElement
    public PdfObject getAttribute(PdfName pdfName) {
        PdfDictionary asDict = getAsDict(PdfName.A);
        if (asDict != null && asDict.contains(pdfName)) {
            return asDict.get(pdfName);
        }
        PdfDictionary parent = getParent();
        if (parent instanceof PdfStructureElement) {
            return ((PdfStructureElement) parent).getAttribute(pdfName);
        }
        return parent instanceof PdfStructureTreeRoot ? ((PdfStructureTreeRoot) parent).getAttribute(pdfName) : new PdfNull();
    }

    public AccessibleElementId getElementId() {
        return this.elementId;
    }

    public PdfDictionary getParent() {
        return getParent(false);
    }

    public PdfIndirectReference getReference() {
        return this.reference;
    }

    public PdfName getStructureType() {
        return this.structureType;
    }

    public void setAnnotation(PdfAnnotation pdfAnnotation, PdfIndirectReference pdfIndirectReference) {
        PdfName pdfName = PdfName.K;
        PdfArray asArray = getAsArray(pdfName);
        if (asArray == null) {
            asArray = new PdfArray();
            PdfObject pdfObject = get(pdfName);
            if (pdfObject != null) {
                asArray.add(pdfObject);
            }
            put(pdfName, asArray);
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.TYPE, PdfName.OBJR);
        pdfDictionary.put(PdfName.OBJ, pdfAnnotation.getIndirectReference());
        if (pdfAnnotation.getRole() == PdfName.FORM) {
            pdfDictionary.put(PdfName.PG, pdfIndirectReference);
        }
        asArray.add(pdfDictionary);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IPdfStructureElement
    public void setAttribute(PdfName pdfName, PdfObject pdfObject) {
        PdfName pdfName2 = PdfName.A;
        PdfDictionary asDict = getAsDict(pdfName2);
        if (asDict == null) {
            asDict = new PdfDictionary();
            put(pdfName2, asDict);
        }
        asDict.put(pdfName, pdfObject);
    }

    public void setPageMark(int i, int i2) {
        if (i2 >= 0) {
            put(PdfName.K, new PdfNumber(i2));
        }
        this.top.setPageMark(i, this.reference);
    }

    public void setStructureElementParent(PdfStructureElement pdfStructureElement) {
        this.parent = pdfStructureElement;
    }

    public void setStructureTreeRoot(PdfStructureTreeRoot pdfStructureTreeRoot) {
        this.top = pdfStructureTreeRoot;
    }

    @Override // com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfObject
    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) {
        PdfWriter.checkPdfIsoConformance(pdfWriter, 16, this);
        super.toPdf(pdfWriter, outputStream);
    }

    private void writeAttributes(ListBody listBody) {
    }

    public PdfDictionary getParent(boolean z) {
        PdfStructureElement pdfStructureElement = this.parent;
        return (pdfStructureElement == null && z) ? this.top : pdfStructureElement;
    }

    private void writeAttributes(PdfPTableBody pdfPTableBody) {
    }

    private void writeAttributes(PdfPTableFooter pdfPTableFooter) {
    }

    public void writeAttributes(IAccessibleElement iAccessibleElement) {
        if (iAccessibleElement instanceof ListItem) {
            writeAttributes((ListItem) iAccessibleElement);
        } else if (iAccessibleElement instanceof Paragraph) {
            writeAttributes((Paragraph) iAccessibleElement);
        } else if (iAccessibleElement instanceof Chunk) {
            writeAttributes((Chunk) iAccessibleElement);
        } else if (iAccessibleElement instanceof Image) {
            writeAttributes((Image) iAccessibleElement);
        } else if (iAccessibleElement instanceof List) {
            writeAttributes((List) iAccessibleElement);
        } else if (iAccessibleElement instanceof ListLabel) {
            writeAttributes((ListLabel) iAccessibleElement);
        } else if (iAccessibleElement instanceof ListBody) {
            writeAttributes((ListBody) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPTable) {
            writeAttributes((PdfPTable) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPRow) {
            writeAttributes((PdfPRow) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPHeaderCell) {
            writeAttributes((PdfPHeaderCell) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPCell) {
            writeAttributes((PdfPCell) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPTableHeader) {
            writeAttributes((PdfPTableHeader) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPTableFooter) {
            writeAttributes((PdfPTableFooter) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPTableBody) {
            writeAttributes((PdfPTableBody) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfDiv) {
            writeAttributes((PdfDiv) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfTemplate) {
            writeAttributes((PdfTemplate) iAccessibleElement);
        } else if (iAccessibleElement instanceof Document) {
            writeAttributes((Document) iAccessibleElement);
        }
        if (iAccessibleElement.getAccessibleAttributes() != null) {
            for (PdfName pdfName : iAccessibleElement.getAccessibleAttributes().keySet()) {
                if (pdfName.equals(PdfName.ID)) {
                    PdfObject accessibleAttribute = iAccessibleElement.getAccessibleAttribute(pdfName);
                    put(pdfName, accessibleAttribute);
                    this.top.putIDTree(accessibleAttribute.toString(), getReference());
                } else if (!pdfName.equals(PdfName.LANG) && !pdfName.equals(PdfName.ALT) && !pdfName.equals(PdfName.ACTUALTEXT) && !pdfName.equals(PdfName.E) && !pdfName.equals(PdfName.T)) {
                    setAttribute(pdfName, iAccessibleElement.getAccessibleAttribute(pdfName));
                } else {
                    put(pdfName, iAccessibleElement.getAccessibleAttribute(pdfName));
                }
            }
        }
    }

    public PdfStructureElement(PdfStructureTreeRoot pdfStructureTreeRoot, PdfName pdfName) {
        this.top = pdfStructureTreeRoot;
        init(pdfStructureTreeRoot, pdfName);
        put(PdfName.P, pdfStructureTreeRoot.getReference());
        put(PdfName.TYPE, PdfName.STRUCTELEM);
    }

    public PdfStructureElement(PdfDictionary pdfDictionary, PdfName pdfName, AccessibleElementId accessibleElementId) {
        this.elementId = accessibleElementId;
        if (pdfDictionary instanceof PdfStructureElement) {
            PdfStructureElement pdfStructureElement = (PdfStructureElement) pdfDictionary;
            this.top = pdfStructureElement.top;
            init(pdfDictionary, pdfName);
            this.parent = pdfStructureElement;
            put(PdfName.P, pdfStructureElement.reference);
            put(PdfName.TYPE, PdfName.STRUCTELEM);
            return;
        }
        if (pdfDictionary instanceof PdfStructureTreeRoot) {
            PdfStructureTreeRoot pdfStructureTreeRoot = (PdfStructureTreeRoot) pdfDictionary;
            this.top = pdfStructureTreeRoot;
            init(pdfDictionary, pdfName);
            put(PdfName.P, pdfStructureTreeRoot.getReference());
            put(PdfName.TYPE, PdfName.STRUCTELEM);
        }
    }

    private void writeAttributes(Chunk chunk) {
        if (chunk != null) {
            if (chunk.getImage() != null) {
                writeAttributes(chunk.getImage());
                return;
            }
            HashMap<String, Object> attributes = chunk.getAttributes();
            if (attributes != null) {
                setAttribute(PdfName.O, PdfName.LAYOUT);
                if (attributes.containsKey(Chunk.UNDERLINE)) {
                    setAttribute(PdfName.TEXTDECORATIONTYPE, PdfName.UNDERLINE);
                }
                if (attributes.containsKey(Chunk.BACKGROUND)) {
                    BaseColor baseColor = (BaseColor) ((Object[]) attributes.get(Chunk.BACKGROUND))[0];
                    setAttribute(PdfName.BACKGROUNDCOLOR, new PdfArray(new float[]{baseColor.getRed() / 255.0f, baseColor.getGreen() / 255.0f, baseColor.getBlue() / 255.0f}));
                }
                IPdfStructureElement iPdfStructureElement = (IPdfStructureElement) getParent(true);
                PdfName pdfName = PdfName.COLOR;
                PdfObject parentAttribute = getParentAttribute(iPdfStructureElement, pdfName);
                if (chunk.getFont() != null && chunk.getFont().getColor() != null) {
                    setColorAttribute(chunk.getFont().getColor(), parentAttribute, pdfName);
                }
                PdfName pdfName2 = PdfName.TEXTDECORATIONTHICKNESS;
                PdfObject parentAttribute2 = getParentAttribute(iPdfStructureElement, pdfName2);
                PdfName pdfName3 = PdfName.TEXTDECORATIONCOLOR;
                PdfObject parentAttribute3 = getParentAttribute(iPdfStructureElement, pdfName3);
                if (attributes.containsKey(Chunk.UNDERLINE)) {
                    Object[][] objArr = (Object[][]) attributes.get(Chunk.UNDERLINE);
                    Object[] objArr2 = objArr[objArr.length - 1];
                    BaseColor baseColor2 = (BaseColor) objArr2[0];
                    float f = ((float[]) objArr2[1])[0];
                    if (!(parentAttribute2 instanceof PdfNumber) || Float.compare(f, ((PdfNumber) parentAttribute2).floatValue()) != 0) {
                        setAttribute(pdfName2, new PdfNumber(f));
                    }
                    if (baseColor2 != null) {
                        setColorAttribute(baseColor2, parentAttribute3, pdfName3);
                    }
                }
                if (attributes.containsKey(Chunk.LINEHEIGHT)) {
                    float fFloatValue = ((Float) attributes.get(Chunk.LINEHEIGHT)).floatValue();
                    PdfName pdfName4 = PdfName.LINEHEIGHT;
                    PdfObject parentAttribute4 = getParentAttribute(iPdfStructureElement, pdfName4);
                    if (parentAttribute4 instanceof PdfNumber) {
                        if (Float.compare(((PdfNumber) parentAttribute4).floatValue(), fFloatValue) != 0) {
                            setAttribute(pdfName4, new PdfNumber(fFloatValue));
                            return;
                        }
                        return;
                    }
                    setAttribute(pdfName4, new PdfNumber(fFloatValue));
                }
            }
        }
    }

    private void writeAttributes(Image image) {
        if (image != null) {
            setAttribute(PdfName.O, PdfName.LAYOUT);
            if (image.getWidth() > 0.0f) {
                setAttribute(PdfName.WIDTH, new PdfNumber(image.getWidth()));
            }
            if (image.getHeight() > 0.0f) {
                setAttribute(PdfName.HEIGHT, new PdfNumber(image.getHeight()));
            }
            setAttribute(PdfName.BBOX, new PdfRectangle(image, image.getRotation()));
            if (image.getBackgroundColor() != null) {
                BaseColor backgroundColor = image.getBackgroundColor();
                setAttribute(PdfName.BACKGROUNDCOLOR, new PdfArray(new float[]{backgroundColor.getRed() / 255.0f, backgroundColor.getGreen() / 255.0f, backgroundColor.getBlue() / 255.0f}));
            }
        }
    }

    private void writeAttributes(PdfTemplate pdfTemplate) {
        if (pdfTemplate != null) {
            setAttribute(PdfName.O, PdfName.LAYOUT);
            if (pdfTemplate.getWidth() > 0.0f) {
                setAttribute(PdfName.WIDTH, new PdfNumber(pdfTemplate.getWidth()));
            }
            if (pdfTemplate.getHeight() > 0.0f) {
                setAttribute(PdfName.HEIGHT, new PdfNumber(pdfTemplate.getHeight()));
            }
            setAttribute(PdfName.BBOX, new PdfRectangle(pdfTemplate.getBoundingBox()));
        }
    }

    private void writeAttributes(Paragraph paragraph) {
        if (paragraph != null) {
            setAttribute(PdfName.O, PdfName.LAYOUT);
            if (Float.compare(paragraph.getSpacingBefore(), 0.0f) != 0) {
                setAttribute(PdfName.SPACEBEFORE, new PdfNumber(paragraph.getSpacingBefore()));
            }
            if (Float.compare(paragraph.getSpacingAfter(), 0.0f) != 0) {
                setAttribute(PdfName.SPACEAFTER, new PdfNumber(paragraph.getSpacingAfter()));
            }
            IPdfStructureElement iPdfStructureElement = (IPdfStructureElement) getParent(true);
            PdfName pdfName = PdfName.COLOR;
            PdfObject parentAttribute = getParentAttribute(iPdfStructureElement, pdfName);
            if (paragraph.getFont() != null && paragraph.getFont().getColor() != null) {
                setColorAttribute(paragraph.getFont().getColor(), parentAttribute, pdfName);
            }
            PdfName pdfName2 = PdfName.TEXTINDENT;
            PdfObject parentAttribute2 = getParentAttribute(iPdfStructureElement, pdfName2);
            if (Float.compare(paragraph.getFirstLineIndent(), 0.0f) != 0 && (!(parentAttribute2 instanceof PdfNumber) || Float.compare(((PdfNumber) parentAttribute2).floatValue(), new Float(paragraph.getFirstLineIndent()).floatValue()) != 0)) {
                setAttribute(pdfName2, new PdfNumber(paragraph.getFirstLineIndent()));
            }
            PdfName pdfName3 = PdfName.STARTINDENT;
            PdfObject parentAttribute3 = getParentAttribute(iPdfStructureElement, pdfName3);
            if (parentAttribute3 instanceof PdfNumber) {
                if (Float.compare(((PdfNumber) parentAttribute3).floatValue(), paragraph.getIndentationLeft()) != 0) {
                    setAttribute(pdfName3, new PdfNumber(paragraph.getIndentationLeft()));
                }
            } else if (Math.abs(paragraph.getIndentationLeft()) > Float.MIN_VALUE) {
                setAttribute(pdfName3, new PdfNumber(paragraph.getIndentationLeft()));
            }
            PdfName pdfName4 = PdfName.ENDINDENT;
            PdfObject parentAttribute4 = getParentAttribute(iPdfStructureElement, pdfName4);
            if (parentAttribute4 instanceof PdfNumber) {
                if (Float.compare(((PdfNumber) parentAttribute4).floatValue(), paragraph.getIndentationRight()) != 0) {
                    setAttribute(pdfName4, new PdfNumber(paragraph.getIndentationRight()));
                }
            } else if (Float.compare(paragraph.getIndentationRight(), 0.0f) != 0) {
                setAttribute(pdfName4, new PdfNumber(paragraph.getIndentationRight()));
            }
            setTextAlignAttribute(paragraph.getAlignment());
        }
    }

    private void writeAttributes(List list) {
        if (list != null) {
            setAttribute(PdfName.O, PdfName.LIST);
            if (list.isAutoindent()) {
                if (list.isNumbered()) {
                    if (list.isLettered()) {
                        if (list.isLowercase()) {
                            setAttribute(PdfName.LISTNUMBERING, PdfName.LOWERROMAN);
                        } else {
                            setAttribute(PdfName.LISTNUMBERING, PdfName.UPPERROMAN);
                        }
                    } else {
                        setAttribute(PdfName.LISTNUMBERING, PdfName.DECIMAL);
                    }
                } else if (list.isLettered()) {
                    if (list.isLowercase()) {
                        setAttribute(PdfName.LISTNUMBERING, PdfName.LOWERALPHA);
                    } else {
                        setAttribute(PdfName.LISTNUMBERING, PdfName.UPPERALPHA);
                    }
                }
            }
            PdfStructureElement pdfStructureElement = this.parent;
            PdfName pdfName = PdfName.STARTINDENT;
            PdfObject parentAttribute = getParentAttribute(pdfStructureElement, pdfName);
            if (parentAttribute instanceof PdfNumber) {
                if (Float.compare(((PdfNumber) parentAttribute).floatValue(), list.getIndentationLeft()) != 0) {
                    setAttribute(pdfName, new PdfNumber(list.getIndentationLeft()));
                }
            } else if (Math.abs(list.getIndentationLeft()) > Float.MIN_VALUE) {
                setAttribute(pdfName, new PdfNumber(list.getIndentationLeft()));
            }
            PdfStructureElement pdfStructureElement2 = this.parent;
            PdfName pdfName2 = PdfName.ENDINDENT;
            PdfObject parentAttribute2 = getParentAttribute(pdfStructureElement2, pdfName2);
            if (parentAttribute2 instanceof PdfNumber) {
                if (Float.compare(((PdfNumber) parentAttribute2).floatValue(), list.getIndentationRight()) != 0) {
                    setAttribute(pdfName2, new PdfNumber(list.getIndentationRight()));
                }
            } else if (Float.compare(list.getIndentationRight(), 0.0f) != 0) {
                setAttribute(pdfName2, new PdfNumber(list.getIndentationRight()));
            }
        }
    }

    private void writeAttributes(ListItem listItem) {
        if (listItem != null) {
            PdfStructureElement pdfStructureElement = this.parent;
            PdfName pdfName = PdfName.STARTINDENT;
            PdfObject parentAttribute = getParentAttribute(pdfStructureElement, pdfName);
            if (parentAttribute instanceof PdfNumber) {
                if (Float.compare(((PdfNumber) parentAttribute).floatValue(), listItem.getIndentationLeft()) != 0) {
                    setAttribute(pdfName, new PdfNumber(listItem.getIndentationLeft()));
                }
            } else if (Math.abs(listItem.getIndentationLeft()) > Float.MIN_VALUE) {
                setAttribute(pdfName, new PdfNumber(listItem.getIndentationLeft()));
            }
            PdfStructureElement pdfStructureElement2 = this.parent;
            PdfName pdfName2 = PdfName.ENDINDENT;
            PdfObject parentAttribute2 = getParentAttribute(pdfStructureElement2, pdfName2);
            if (parentAttribute2 instanceof PdfNumber) {
                if (Float.compare(((PdfNumber) parentAttribute2).floatValue(), listItem.getIndentationRight()) != 0) {
                    setAttribute(pdfName2, new PdfNumber(listItem.getIndentationRight()));
                }
            } else if (Float.compare(listItem.getIndentationRight(), 0.0f) != 0) {
                setAttribute(pdfName2, new PdfNumber(listItem.getIndentationRight()));
            }
        }
    }

    private void writeAttributes(ListLabel listLabel) {
        if (listLabel != null) {
            PdfStructureElement pdfStructureElement = this.parent;
            PdfName pdfName = PdfName.STARTINDENT;
            PdfObject parentAttribute = getParentAttribute(pdfStructureElement, pdfName);
            if (parentAttribute instanceof PdfNumber) {
                if (Float.compare(((PdfNumber) parentAttribute).floatValue(), listLabel.getIndentation()) != 0) {
                    setAttribute(pdfName, new PdfNumber(listLabel.getIndentation()));
                }
            } else if (Math.abs(listLabel.getIndentation()) > Float.MIN_VALUE) {
                setAttribute(pdfName, new PdfNumber(listLabel.getIndentation()));
            }
        }
    }

    private void writeAttributes(PdfPTable pdfPTable) {
        if (pdfPTable != null) {
            setAttribute(PdfName.O, PdfName.TABLE);
            if (Float.compare(pdfPTable.getSpacingBefore(), 0.0f) != 0) {
                setAttribute(PdfName.SPACEBEFORE, new PdfNumber(pdfPTable.getSpacingBefore()));
            }
            if (Float.compare(pdfPTable.getSpacingAfter(), 0.0f) != 0) {
                setAttribute(PdfName.SPACEAFTER, new PdfNumber(pdfPTable.getSpacingAfter()));
            }
            if (pdfPTable.getTotalHeight() > 0.0f) {
                setAttribute(PdfName.HEIGHT, new PdfNumber(pdfPTable.getTotalHeight()));
            }
            if (pdfPTable.getTotalWidth() > 0.0f) {
                setAttribute(PdfName.WIDTH, new PdfNumber(pdfPTable.getTotalWidth()));
            }
        }
    }

    private void writeAttributes(PdfPRow pdfPRow) {
        if (pdfPRow != null) {
            setAttribute(PdfName.O, PdfName.TABLE);
        }
    }

    private void writeAttributes(PdfPCell pdfPCell) {
        if (pdfPCell != null) {
            setAttribute(PdfName.O, PdfName.TABLE);
            if (pdfPCell.getColspan() != 1) {
                setAttribute(PdfName.COLSPAN, new PdfNumber(pdfPCell.getColspan()));
            }
            if (pdfPCell.getRowspan() != 1) {
                setAttribute(PdfName.ROWSPAN, new PdfNumber(pdfPCell.getRowspan()));
            }
            if (pdfPCell.getHeaders() != null) {
                PdfArray pdfArray = new PdfArray();
                for (PdfPHeaderCell pdfPHeaderCell : pdfPCell.getHeaders()) {
                    if (pdfPHeaderCell.getName() != null) {
                        pdfArray.add(new PdfString(pdfPHeaderCell.getName()));
                    }
                }
                if (!pdfArray.isEmpty()) {
                    setAttribute(PdfName.HEADERS, pdfArray);
                }
            }
            if (pdfPCell.getCalculatedHeight() > 0.0f) {
                setAttribute(PdfName.HEIGHT, new PdfNumber(pdfPCell.getCalculatedHeight()));
            }
            if (pdfPCell.getWidth() > 0.0f) {
                setAttribute(PdfName.WIDTH, new PdfNumber(pdfPCell.getWidth()));
            }
            if (pdfPCell.getBackgroundColor() != null) {
                BaseColor backgroundColor = pdfPCell.getBackgroundColor();
                setAttribute(PdfName.BACKGROUNDCOLOR, new PdfArray(new float[]{backgroundColor.getRed() / 255.0f, backgroundColor.getGreen() / 255.0f, backgroundColor.getBlue() / 255.0f}));
            }
        }
    }

    private void writeAttributes(PdfPHeaderCell pdfPHeaderCell) {
        if (pdfPHeaderCell != null) {
            if (pdfPHeaderCell.getScope() != 0) {
                int scope = pdfPHeaderCell.getScope();
                if (scope == 1) {
                    setAttribute(PdfName.SCOPE, PdfName.ROW);
                } else if (scope == 2) {
                    setAttribute(PdfName.SCOPE, PdfName.COLUMN);
                } else if (scope == 3) {
                    setAttribute(PdfName.SCOPE, PdfName.BOTH);
                }
            }
            if (pdfPHeaderCell.getName() != null) {
                setAttribute(PdfName.NAME, new PdfName(pdfPHeaderCell.getName()));
            }
            writeAttributes((PdfPCell) pdfPHeaderCell);
        }
    }

    private void writeAttributes(PdfPTableHeader pdfPTableHeader) {
        if (pdfPTableHeader != null) {
            setAttribute(PdfName.O, PdfName.TABLE);
        }
    }

    private void writeAttributes(PdfDiv pdfDiv) {
        if (pdfDiv != null) {
            if (pdfDiv.getBackgroundColor() != null) {
                setColorAttribute(pdfDiv.getBackgroundColor(), null, PdfName.BACKGROUNDCOLOR);
            }
            setTextAlignAttribute(pdfDiv.getTextAlignment());
        }
    }
}
