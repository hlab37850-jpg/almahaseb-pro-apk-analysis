package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class PdfArtifact implements IAccessibleElement {
    private static final HashSet<String> allowedArtifactTypes = new HashSet<>(Arrays.asList("Pagination", "Layout", "Page", "Background"));
    protected PdfName role = PdfName.ARTIFACT;
    protected HashMap<PdfName, PdfObject> accessibleAttributes = null;
    protected AccessibleElementId id = new AccessibleElementId();

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.PdfArtifact$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$PdfArtifact$ArtifactType;

        static {
            int[] iArr = new int[ArtifactType.values().length];
            $SwitchMap$com$itextpdf$text$pdf$PdfArtifact$ArtifactType = iArr;
            try {
                iArr[ArtifactType.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PdfArtifact$ArtifactType[ArtifactType.LAYOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PdfArtifact$ArtifactType[ArtifactType.PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PdfArtifact$ArtifactType[ArtifactType.PAGINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum ArtifactType {
        PAGINATION,
        LAYOUT,
        PAGE,
        BACKGROUND
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

    public PdfArray getAttached() {
        HashMap<PdfName, PdfObject> map = this.accessibleAttributes;
        if (map == null) {
            return null;
        }
        return (PdfArray) map.get(PdfName.ATTACHED);
    }

    public PdfArray getBBox() {
        HashMap<PdfName, PdfObject> map = this.accessibleAttributes;
        if (map == null) {
            return null;
        }
        return (PdfArray) map.get(PdfName.BBOX);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public AccessibleElementId getId() {
        return this.id;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public PdfName getRole() {
        return this.role;
    }

    public PdfString getType() {
        HashMap<PdfName, PdfObject> map = this.accessibleAttributes;
        if (map == null) {
            return null;
        }
        return (PdfString) map.get(PdfName.TYPE);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public boolean isInline() {
        return true;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setAccessibleAttribute(PdfName pdfName, PdfObject pdfObject) {
        if (this.accessibleAttributes == null) {
            this.accessibleAttributes = new HashMap<>();
        }
        this.accessibleAttributes.put(pdfName, pdfObject);
    }

    public void setAttached(PdfArray pdfArray) {
        setAccessibleAttribute(PdfName.ATTACHED, pdfArray);
    }

    public void setBBox(PdfArray pdfArray) {
        setAccessibleAttribute(PdfName.BBOX, pdfArray);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setId(AccessibleElementId accessibleElementId) {
        this.id = accessibleElementId;
    }

    @Override // com.itextpdf.text.pdf.interfaces.IAccessibleElement
    public void setRole(PdfName pdfName) {
    }

    public void setType(PdfString pdfString) {
        if (!allowedArtifactTypes.contains(pdfString.toString())) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.artifact.type.1.is.invalid", pdfString));
        }
        setAccessibleAttribute(PdfName.TYPE, pdfString);
    }

    public void setType(ArtifactType artifactType) {
        PdfString pdfString;
        int i = AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$PdfArtifact$ArtifactType[artifactType.ordinal()];
        if (i == 1) {
            pdfString = new PdfString("Background");
        } else if (i == 2) {
            pdfString = new PdfString("Layout");
        } else if (i != 3) {
            pdfString = i != 4 ? null : new PdfString("Pagination");
        } else {
            pdfString = new PdfString("Page");
        }
        setAccessibleAttribute(PdfName.TYPE, pdfString);
    }
}
