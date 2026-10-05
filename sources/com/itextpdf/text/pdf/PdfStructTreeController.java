package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PdfStructTreeController {
    private PdfDictionary parentTree;
    protected PdfReader reader;
    private PdfDictionary structTreeRoot;
    private PdfStructureTreeRoot structureTreeRoot;
    private PdfCopy writer;
    private PdfDictionary roleMap = null;
    private PdfDictionary sourceRoleMap = null;
    private PdfDictionary sourceClassMap = null;
    private PdfIndirectReference nullReference = null;

    /* JADX INFO: renamed from: com.itextpdf.text.pdf.PdfStructTreeController$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$itextpdf$text$pdf$PdfStructTreeController$returnType;

        static {
            int[] iArr = new int[returnType.values().length];
            $SwitchMap$com$itextpdf$text$pdf$PdfStructTreeController$returnType = iArr;
            try {
                iArr[returnType.FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PdfStructTreeController$returnType[returnType.ABOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$itextpdf$text$pdf$PdfStructTreeController$returnType[returnType.BELOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum returnType {
        BELOW,
        FOUND,
        ABOVE,
        NOTFOUND
    }

    public PdfStructTreeController(PdfReader pdfReader, PdfCopy pdfCopy) throws BadPdfFormatException {
        if (!pdfCopy.isTagged()) {
            throw new BadPdfFormatException(MessageLocalization.getComposedMessage("no.structtreeroot.found", new Object[0]));
        }
        this.writer = pdfCopy;
        PdfStructureTreeRoot structureTreeRoot = pdfCopy.getStructureTreeRoot();
        this.structureTreeRoot = structureTreeRoot;
        structureTreeRoot.put(PdfName.PARENTTREE, new PdfDictionary(PdfName.STRUCTELEM));
        setReader(pdfReader);
    }

    private void addKid(PdfObject pdfObject) {
        if (pdfObject.isIndirect()) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            RefKey refKey = new RefKey(pRIndirectReference);
            if (!this.writer.indirects.containsKey(refKey)) {
                this.writer.copyIndirect(pRIndirectReference, true, false);
            }
            PdfIndirectReference ref = this.writer.indirects.get(refKey).getRef();
            if (this.writer.updateRootKids) {
                addKid(this.structureTreeRoot, ref);
                this.writer.structureTreeRootKidsForReaderImported(this.reader);
            }
        }
    }

    public static boolean checkTagged(PdfReader pdfReader) {
        PdfObject directObject;
        PdfObject directObject2 = getDirectObject(pdfReader.getCatalog().get(PdfName.STRUCTTREEROOT));
        return directObject2 != null && directObject2.isDictionary() && (directObject = getDirectObject(((PdfDictionary) directObject2).get(PdfName.PARENTTREE))) != null && directObject.isDictionary();
    }

    public static boolean compareObjects(PdfObject pdfObject, PdfObject pdfObject2) {
        String str;
        PdfObject directObject = getDirectObject(pdfObject2);
        if (directObject == null || pdfObject.type() != directObject.type()) {
            return false;
        }
        if (pdfObject.isBoolean()) {
            if (pdfObject == directObject) {
                return true;
            }
            return (directObject instanceof PdfBoolean) && ((PdfBoolean) pdfObject).booleanValue() == ((PdfBoolean) directObject).booleanValue();
        }
        if (pdfObject.isName()) {
            return pdfObject.equals(directObject);
        }
        if (pdfObject.isNumber()) {
            if (pdfObject == directObject) {
                return true;
            }
            return (directObject instanceof PdfNumber) && ((PdfNumber) pdfObject).doubleValue() == ((PdfNumber) directObject).doubleValue();
        }
        if (pdfObject.isNull()) {
            return pdfObject == directObject || (directObject instanceof PdfNull);
        }
        if (pdfObject.isString()) {
            if (pdfObject == directObject) {
                return true;
            }
            if (!(directObject instanceof PdfString)) {
                return false;
            }
            String str2 = ((PdfString) directObject).value;
            return (str2 == null && ((PdfString) pdfObject).value == null) || ((str = ((PdfString) pdfObject).value) != null && str.equals(str2));
        }
        if (pdfObject.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            PdfArray pdfArray2 = (PdfArray) directObject;
            if (pdfArray.size() != pdfArray2.size()) {
                return false;
            }
            for (int i = 0; i < pdfArray.size(); i++) {
                if (!compareObjects(pdfArray.getPdfObject(i), pdfArray2.getPdfObject(i))) {
                    return false;
                }
            }
            return true;
        }
        if (!pdfObject.isDictionary()) {
            return false;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
        PdfDictionary pdfDictionary2 = (PdfDictionary) directObject;
        if (pdfDictionary.size() != pdfDictionary2.size()) {
            return false;
        }
        for (PdfName pdfName : pdfDictionary.hashMap.keySet()) {
            if (!compareObjects(pdfDictionary.get(pdfName), pdfDictionary2.get(pdfName))) {
                return false;
            }
        }
        return true;
    }

    private returnType copyPageMarks(PdfDictionary pdfDictionary, PdfNumber pdfNumber, int i) {
        PdfArray pdfArray = (PdfArray) getDirectObject(pdfDictionary.get(PdfName.NUMS));
        if (pdfArray != null) {
            return pdfArray.size() == 0 ? returnType.NOTFOUND : findAndCopyMarks(pdfArray, pdfNumber.intValue(), i);
        }
        PdfArray pdfArray2 = (PdfArray) getDirectObject(pdfDictionary.get(PdfName.KIDS));
        if (pdfArray2 == null) {
            return returnType.NOTFOUND;
        }
        int size = pdfArray2.size() / 2;
        int i2 = 0;
        while (true) {
            int i3 = size + i2;
            int i4 = AnonymousClass1.$SwitchMap$com$itextpdf$text$pdf$PdfStructTreeController$returnType[copyPageMarks((PdfDictionary) getDirectObject(pdfArray2.getPdfObject(i3)), pdfNumber, i).ordinal()];
            if (i4 == 1) {
                return returnType.FOUND;
            }
            if (i4 == 2) {
                int i5 = size / 2;
                int i6 = i5 != 0 ? i5 : 1;
                if (i6 + i3 == pdfArray2.size()) {
                    return returnType.ABOVE;
                }
                i2 = i3;
                size = i6;
            } else {
                if (i4 != 3) {
                    return returnType.NOTFOUND;
                }
                if (i3 == 0) {
                    return returnType.BELOW;
                }
                if (size == 0) {
                    return returnType.NOTFOUND;
                }
                size /= 2;
            }
        }
    }

    private returnType findAndCopyMarks(PdfArray pdfArray, int i, int i2) {
        if (pdfArray.getAsNumber(0).intValue() > i) {
            return returnType.BELOW;
        }
        if (pdfArray.getAsNumber(pdfArray.size() - 2).intValue() < i) {
            return returnType.ABOVE;
        }
        int size = pdfArray.size() / 4;
        int i3 = 0;
        while (true) {
            int i4 = i3 + size;
            int i5 = i4 * 2;
            int iIntValue = pdfArray.getAsNumber(i5).intValue();
            if (iIntValue == i) {
                PdfObject pdfObject = pdfArray.getPdfObject(i5 + 1);
                PdfObject pdfObjectRelease = pdfObject;
                while (pdfObjectRelease.isIndirect()) {
                    pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfObjectRelease);
                }
                if (pdfObjectRelease.isArray()) {
                    PdfObject pdfObject2 = null;
                    for (PdfObject pdfObject3 : (PdfArray) pdfObjectRelease) {
                        if (pdfObject3.isNull()) {
                            if (this.nullReference == null) {
                                this.nullReference = this.writer.addToBody(new PdfNull()).getIndirectReference();
                            }
                            this.structureTreeRoot.setPageMark(i2, this.nullReference);
                        } else {
                            PdfObject pdfObjectCopyObject = this.writer.copyObject(pdfObject3, true, false);
                            if (pdfObject2 == null) {
                                pdfObject2 = pdfObjectCopyObject;
                            }
                            this.structureTreeRoot.setPageMark(i2, (PdfIndirectReference) pdfObjectCopyObject);
                        }
                    }
                    attachStructTreeRootKids(pdfObject2);
                } else {
                    if (!pdfObjectRelease.isDictionary()) {
                        return returnType.NOTFOUND;
                    }
                    if (getKDict((PdfDictionary) pdfObjectRelease) == null) {
                        return returnType.NOTFOUND;
                    }
                    this.structureTreeRoot.setAnnotationMark(i2, (PdfIndirectReference) this.writer.copyObject(pdfObject, true, false));
                }
                return returnType.FOUND;
            }
            if (iIntValue < i) {
                if (size == 0) {
                    return returnType.NOTFOUND;
                }
                if (size != 1) {
                    size /= 2;
                }
                if (size + i4 == pdfArray.size()) {
                    return returnType.NOTFOUND;
                }
                i3 = i4;
            } else {
                if (i4 == 0) {
                    return returnType.BELOW;
                }
                if (size == 0) {
                    return returnType.NOTFOUND;
                }
                size /= 2;
            }
        }
    }

    private static PdfArray getDirectArray(PdfArray pdfArray) {
        PdfArray pdfArray2 = new PdfArray();
        for (int i = 0; i < pdfArray.size(); i++) {
            PdfObject directObject = getDirectObject(pdfArray.getPdfObject(i));
            if (directObject != null) {
                if (directObject.isArray()) {
                    pdfArray2.add(getDirectArray((PdfArray) directObject));
                } else if (directObject.isDictionary()) {
                    pdfArray2.add(getDirectDict((PdfDictionary) directObject));
                } else {
                    pdfArray2.add(directObject);
                }
            }
        }
        return pdfArray2;
    }

    private static PdfDictionary getDirectDict(PdfDictionary pdfDictionary) {
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        for (Map.Entry<PdfName, PdfObject> entry : pdfDictionary.hashMap.entrySet()) {
            PdfObject directObject = getDirectObject(entry.getValue());
            if (directObject != null) {
                if (directObject.isArray()) {
                    pdfDictionary2.put(entry.getKey(), getDirectArray((PdfArray) directObject));
                } else if (directObject.isDictionary()) {
                    pdfDictionary2.put(entry.getKey(), getDirectDict((PdfDictionary) directObject));
                } else {
                    pdfDictionary2.put(entry.getKey(), directObject);
                }
            }
        }
        return pdfDictionary2;
    }

    public static PdfObject getDirectObject(PdfObject pdfObject) {
        if (pdfObject == null) {
            return null;
        }
        while (pdfObject.isIndirect()) {
            pdfObject = PdfReader.getPdfObjectRelease(pdfObject);
        }
        return pdfObject;
    }

    public static PdfDictionary getKDict(PdfDictionary pdfDictionary) {
        PdfName pdfName = PdfName.K;
        PdfDictionary asDict = pdfDictionary.getAsDict(pdfName);
        if (asDict == null) {
            PdfArray asArray = pdfDictionary.getAsArray(pdfName);
            if (asArray == null) {
                return null;
            }
            for (int i = 0; i < asArray.size(); i++) {
                PdfDictionary asDict2 = asArray.getAsDict(i);
                if (asDict2 != null && PdfName.OBJR.equals(asDict2.getAsName(PdfName.TYPE))) {
                    return asDict2;
                }
            }
        } else if (PdfName.OBJR.equals(asDict.getAsName(PdfName.TYPE))) {
            return asDict;
        }
        return null;
    }

    public void addClass(PdfObject pdfObject) {
        PdfObject directObject = getDirectObject(pdfObject);
        if (directObject.isDictionary()) {
            PdfObject pdfObject2 = ((PdfDictionary) directObject).get(PdfName.C);
            if (pdfObject2 == null) {
                return;
            }
            if (!pdfObject2.isArray()) {
                if (pdfObject2.isName()) {
                    addClass(pdfObject2);
                    return;
                }
                return;
            } else {
                PdfArray pdfArray = (PdfArray) pdfObject2;
                for (int i = 0; i < pdfArray.size(); i++) {
                    addClass(pdfArray.getPdfObject(i));
                }
                return;
            }
        }
        if (directObject.isName()) {
            PdfName pdfName = (PdfName) directObject;
            if (this.sourceClassMap == null) {
                PdfObject directObject2 = getDirectObject(this.structTreeRoot.get(PdfName.CLASSMAP));
                if (directObject2 == null || !directObject2.isDictionary()) {
                    return;
                } else {
                    this.sourceClassMap = (PdfDictionary) directObject2;
                }
            }
            PdfObject directObject3 = getDirectObject(this.sourceClassMap.get(pdfName));
            if (directObject3 == null) {
                return;
            }
            PdfObject mappedClass = this.structureTreeRoot.getMappedClass(pdfName);
            if (mappedClass != null) {
                if (!compareObjects(mappedClass, directObject3)) {
                    throw new BadPdfFormatException(MessageLocalization.getComposedMessage("conflict.in.classmap", pdfName));
                }
            } else if (directObject3.isDictionary()) {
                this.structureTreeRoot.mapClass(pdfName, getDirectDict((PdfDictionary) directObject3));
            } else if (directObject3.isArray()) {
                this.structureTreeRoot.mapClass(pdfName, getDirectArray((PdfArray) directObject3));
            }
        }
    }

    public void addRole(PdfName pdfName) {
        if (pdfName == null) {
            return;
        }
        Iterator<PdfName> it = this.writer.getStandardStructElems().iterator();
        while (it.hasNext()) {
            if (it.next().equals(pdfName)) {
                return;
            }
        }
        if (this.sourceRoleMap == null) {
            PdfObject directObject = getDirectObject(this.structTreeRoot.get(PdfName.ROLEMAP));
            if (directObject == null || !directObject.isDictionary()) {
                return;
            } else {
                this.sourceRoleMap = (PdfDictionary) directObject;
            }
        }
        PdfObject pdfObject = this.sourceRoleMap.get(pdfName);
        if (pdfObject == null || !pdfObject.isName()) {
            return;
        }
        PdfDictionary pdfDictionary = this.roleMap;
        if (pdfDictionary == null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            this.roleMap = pdfDictionary2;
            this.structureTreeRoot.put(PdfName.ROLEMAP, pdfDictionary2);
            this.roleMap.put(pdfName, pdfObject);
            return;
        }
        PdfObject pdfObject2 = pdfDictionary.get(pdfName);
        if (pdfObject2 == null) {
            this.roleMap.put(pdfName, pdfObject);
        } else if (!pdfObject2.equals(pdfObject)) {
            throw new BadPdfFormatException(MessageLocalization.getComposedMessage("conflict.in.rolemap", pdfName));
        }
    }

    public void attachStructTreeRootKids(PdfObject pdfObject) {
        PdfObject pdfObject2 = this.structTreeRoot.get(PdfName.K);
        if (pdfObject2 == null || !(pdfObject2.isArray() || pdfObject2.isIndirect())) {
            addKid(this.structureTreeRoot, pdfObject);
        } else {
            if (pdfObject2.isIndirect()) {
                addKid(pdfObject2);
                return;
            }
            Iterator<PdfObject> it = ((PdfArray) pdfObject2).iterator();
            while (it.hasNext()) {
                addKid(it.next());
            }
        }
    }

    public void copyStructTreeForPage(PdfNumber pdfNumber, int i) {
        if (copyPageMarks(this.parentTree, pdfNumber, i) == returnType.NOTFOUND) {
            throw new BadPdfFormatException(MessageLocalization.getComposedMessage("invalid.structparent", new Object[0]));
        }
    }

    public void setReader(PdfReader pdfReader) {
        this.reader = pdfReader;
        PdfObject directObject = getDirectObject(pdfReader.getCatalog().get(PdfName.STRUCTTREEROOT));
        if (directObject == null || !directObject.isDictionary()) {
            throw new BadPdfFormatException(MessageLocalization.getComposedMessage("no.structtreeroot.found", new Object[0]));
        }
        PdfDictionary pdfDictionary = (PdfDictionary) directObject;
        this.structTreeRoot = pdfDictionary;
        PdfObject directObject2 = getDirectObject(pdfDictionary.get(PdfName.PARENTTREE));
        if (directObject2 == null || !directObject2.isDictionary()) {
            throw new BadPdfFormatException(MessageLocalization.getComposedMessage("the.document.does.not.contain.parenttree", new Object[0]));
        }
        this.parentTree = (PdfDictionary) directObject2;
        this.sourceRoleMap = null;
        this.sourceClassMap = null;
        this.nullReference = null;
    }

    public void addKid(PdfDictionary pdfDictionary, PdfObject pdfObject) {
        PdfArray pdfArray;
        PdfName pdfName = PdfName.K;
        PdfObject pdfObject2 = pdfDictionary.get(pdfName);
        if (pdfObject2 instanceof PdfArray) {
            pdfArray = (PdfArray) pdfObject2;
        } else {
            PdfArray pdfArray2 = new PdfArray();
            if (pdfObject2 != null) {
                pdfArray2.add(pdfObject2);
            }
            pdfArray = pdfArray2;
        }
        pdfArray.add(pdfObject);
        pdfDictionary.put(pdfName, pdfArray);
    }
}
