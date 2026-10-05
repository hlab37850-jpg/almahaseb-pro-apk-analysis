package com.itextpdf.text.pdf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
class PageResources {
    protected HashSet<PdfName> forbiddenNames;
    protected PdfDictionary originalResources;
    protected HashMap<PdfName, PdfName> usedNames;
    protected PdfDictionary fontDictionary = new PdfDictionary();
    protected PdfDictionary xObjectDictionary = new PdfDictionary();
    protected PdfDictionary colorDictionary = new PdfDictionary();
    protected PdfDictionary patternDictionary = new PdfDictionary();
    protected PdfDictionary shadingDictionary = new PdfDictionary();
    protected PdfDictionary extGStateDictionary = new PdfDictionary();
    protected PdfDictionary propertyDictionary = new PdfDictionary();
    protected int[] namePtr = {0};

    public PdfName addColor(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName pdfNameTranslateName = translateName(pdfName);
        this.colorDictionary.put(pdfNameTranslateName, pdfIndirectReference);
        return pdfNameTranslateName;
    }

    public void addDefaultColor(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.isNull()) {
            this.colorDictionary.remove(pdfName);
        } else {
            this.colorDictionary.put(pdfName, pdfObject);
        }
    }

    public void addDefaultColorDiff(PdfDictionary pdfDictionary) {
        this.colorDictionary.mergeDifferent(pdfDictionary);
    }

    public PdfName addExtGState(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName pdfNameTranslateName = translateName(pdfName);
        this.extGStateDictionary.put(pdfNameTranslateName, pdfIndirectReference);
        return pdfNameTranslateName;
    }

    public PdfName addFont(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName pdfNameTranslateName = translateName(pdfName);
        this.fontDictionary.put(pdfNameTranslateName, pdfIndirectReference);
        return pdfNameTranslateName;
    }

    public PdfName addPattern(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName pdfNameTranslateName = translateName(pdfName);
        this.patternDictionary.put(pdfNameTranslateName, pdfIndirectReference);
        return pdfNameTranslateName;
    }

    public PdfName addProperty(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName pdfNameTranslateName = translateName(pdfName);
        this.propertyDictionary.put(pdfNameTranslateName, pdfIndirectReference);
        return pdfNameTranslateName;
    }

    public PdfName addShading(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName pdfNameTranslateName = translateName(pdfName);
        this.shadingDictionary.put(pdfNameTranslateName, pdfIndirectReference);
        return pdfNameTranslateName;
    }

    public PdfName addXObject(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName pdfNameTranslateName = translateName(pdfName);
        this.xObjectDictionary.put(pdfNameTranslateName, pdfIndirectReference);
        return pdfNameTranslateName;
    }

    public PdfDictionary getResources() {
        PdfResources pdfResources = new PdfResources();
        PdfDictionary pdfDictionary = this.originalResources;
        if (pdfDictionary != null) {
            pdfResources.putAll(pdfDictionary);
        }
        pdfResources.add(PdfName.FONT, this.fontDictionary);
        pdfResources.add(PdfName.XOBJECT, this.xObjectDictionary);
        pdfResources.add(PdfName.COLORSPACE, this.colorDictionary);
        pdfResources.add(PdfName.PATTERN, this.patternDictionary);
        pdfResources.add(PdfName.SHADING, this.shadingDictionary);
        pdfResources.add(PdfName.EXTGSTATE, this.extGStateDictionary);
        pdfResources.add(PdfName.PROPERTIES, this.propertyDictionary);
        return pdfResources;
    }

    public boolean hasResources() {
        return this.fontDictionary.size() > 0 || this.xObjectDictionary.size() > 0 || this.colorDictionary.size() > 0 || this.patternDictionary.size() > 0 || this.shadingDictionary.size() > 0 || this.extGStateDictionary.size() > 0 || this.propertyDictionary.size() > 0;
    }

    public void setOriginalResources(PdfDictionary pdfDictionary, int[] iArr) {
        if (iArr != null) {
            this.namePtr = iArr;
        }
        this.forbiddenNames = new HashSet<>();
        this.usedNames = new HashMap<>();
        if (pdfDictionary == null) {
            return;
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        this.originalResources = pdfDictionary2;
        pdfDictionary2.merge(pdfDictionary);
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(pdfName));
            if (pdfObject != null && pdfObject.isDictionary()) {
                PdfDictionary pdfDictionary3 = (PdfDictionary) pdfObject;
                Iterator<PdfName> it = pdfDictionary3.getKeys().iterator();
                while (it.hasNext()) {
                    this.forbiddenNames.add(it.next());
                }
                PdfDictionary pdfDictionary4 = new PdfDictionary();
                pdfDictionary4.merge(pdfDictionary3);
                this.originalResources.put(pdfName, pdfDictionary4);
            }
        }
    }

    public PdfName translateName(PdfName pdfName) {
        if (this.forbiddenNames == null) {
            return pdfName;
        }
        PdfName pdfName2 = this.usedNames.get(pdfName);
        if (pdfName2 == null) {
            do {
                StringBuilder sb = new StringBuilder();
                sb.append("Xi");
                int[] iArr = this.namePtr;
                int i = iArr[0];
                iArr[0] = i + 1;
                sb.append(i);
                pdfName2 = new PdfName(sb.toString());
            } while (this.forbiddenNames.contains(pdfName2));
            this.usedNames.put(pdfName, pdfName2);
        }
        return pdfName2;
    }

    public void addDefaultColor(PdfDictionary pdfDictionary) {
        this.colorDictionary.merge(pdfDictionary);
    }
}
