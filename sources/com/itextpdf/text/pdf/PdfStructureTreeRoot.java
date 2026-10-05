package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.interfaces.IPdfStructureElement;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PdfStructureTreeRoot extends PdfDictionary implements IPdfStructureElement {
    private PdfDictionary classMap;
    protected HashMap<PdfName, PdfObject> classes;
    private HashMap<String, PdfObject> idTreeMap;
    private HashMap<Integer, PdfIndirectReference> numTree;
    private HashMap<Integer, PdfObject> parentTree;
    private PdfIndirectReference reference;
    private PdfWriter writer;

    public PdfStructureTreeRoot(PdfWriter pdfWriter) {
        super(PdfName.STRUCTTREEROOT);
        this.parentTree = new HashMap<>();
        this.classMap = null;
        this.classes = null;
        this.numTree = null;
        this.writer = pdfWriter;
        this.reference = pdfWriter.getPdfIndirectReference();
    }

    private void createNumTree() {
        if (this.numTree != null) {
            return;
        }
        this.numTree = new HashMap<>();
        for (Integer num : this.parentTree.keySet()) {
            PdfObject pdfObject = this.parentTree.get(num);
            if (pdfObject.isArray()) {
                this.numTree.put(num, this.writer.addToBody((PdfArray) pdfObject).getIndirectReference());
            } else if (pdfObject instanceof PdfIndirectReference) {
                this.numTree.put(num, (PdfIndirectReference) pdfObject);
            }
        }
    }

    public void buildTree() {
        createNumTree();
        PdfDictionary pdfDictionaryWriteTree = PdfNumberTree.writeTree(this.numTree, this.writer);
        if (pdfDictionaryWriteTree != null) {
            put(PdfName.PARENTTREE, this.writer.addToBody(pdfDictionaryWriteTree).getIndirectReference());
        }
        if (this.classMap != null && !this.classes.isEmpty()) {
            for (Map.Entry<PdfName, PdfObject> entry : this.classes.entrySet()) {
                PdfObject value = entry.getValue();
                if (value.isDictionary()) {
                    this.classMap.put(entry.getKey(), this.writer.addToBody(value).getIndirectReference());
                } else if (value.isArray()) {
                    PdfArray pdfArray = new PdfArray();
                    PdfArray pdfArray2 = (PdfArray) value;
                    for (int i = 0; i < pdfArray2.size(); i++) {
                        if (pdfArray2.getPdfObject(i).isDictionary()) {
                            pdfArray.add(this.writer.addToBody(pdfArray2.getAsDict(i)).getIndirectReference());
                        }
                    }
                    this.classMap.put(entry.getKey(), pdfArray);
                }
            }
            put(PdfName.CLASSMAP, this.writer.addToBody(this.classMap).getIndirectReference());
        }
        HashMap<String, PdfObject> map = this.idTreeMap;
        if (map != null && !map.isEmpty()) {
            put(PdfName.IDTREE, PdfNameTree.writeTree(this.idTreeMap, this.writer));
        }
        this.writer.addToBody(this, this.reference);
    }

    @Override // com.itextpdf.text.pdf.interfaces.IPdfStructureElement
    public PdfObject getAttribute(PdfName pdfName) {
        PdfDictionary asDict = getAsDict(PdfName.A);
        if (asDict == null || !asDict.contains(pdfName)) {
            return null;
        }
        return asDict.get(pdfName);
    }

    public PdfObject getMappedClass(PdfName pdfName) {
        HashMap<PdfName, PdfObject> map = this.classes;
        if (map == null) {
            return null;
        }
        return map.get(pdfName);
    }

    public HashMap<Integer, PdfIndirectReference> getNumTree() {
        if (this.numTree == null) {
            createNumTree();
        }
        return this.numTree;
    }

    public PdfIndirectReference getReference() {
        return this.reference;
    }

    public PdfWriter getWriter() {
        return this.writer;
    }

    public void mapClass(PdfName pdfName, PdfObject pdfObject) {
        if (this.classMap == null) {
            this.classMap = new PdfDictionary();
            this.classes = new HashMap<>();
        }
        this.classes.put(pdfName, pdfObject);
    }

    public void mapRole(PdfName pdfName, PdfName pdfName2) {
        PdfName pdfName3 = PdfName.ROLEMAP;
        PdfDictionary pdfDictionary = (PdfDictionary) get(pdfName3);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            put(pdfName3, pdfDictionary);
        }
        pdfDictionary.put(pdfName, pdfName2);
    }

    public void putIDTree(String str, PdfObject pdfObject) {
        if (this.idTreeMap == null) {
            this.idTreeMap = new HashMap<>();
        }
        this.idTreeMap.put(str, pdfObject);
    }

    public void setAnnotationMark(int i, PdfIndirectReference pdfIndirectReference) {
        this.parentTree.put(Integer.valueOf(i), pdfIndirectReference);
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

    public void setPageMark(int i, PdfIndirectReference pdfIndirectReference) {
        Integer numValueOf = Integer.valueOf(i);
        PdfArray pdfArray = (PdfArray) this.parentTree.get(numValueOf);
        if (pdfArray == null) {
            pdfArray = new PdfArray();
            this.parentTree.put(numValueOf, pdfArray);
        }
        pdfArray.add(pdfIndirectReference);
    }
}
