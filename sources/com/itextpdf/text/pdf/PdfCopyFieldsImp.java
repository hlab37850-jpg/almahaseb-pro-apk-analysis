package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class PdfCopyFieldsImp extends PdfWriter {
    protected static final HashMap<PdfName, Integer> fieldKeys;
    protected static final HashMap<PdfName, Integer> widgetKeys;
    protected Counter COUNTER;
    private ArrayList<String> calculationOrder;
    private ArrayList<Object> calculationOrderRefs;
    boolean closing;
    HashMap<String, Object> fieldTree;
    ArrayList<AcroFields> fields;
    RandomAccessFileOrArray file;
    PdfDictionary form;
    private boolean hasSignature;
    private HashSet<Object> mergedRadioButtons;
    Document nd;
    private boolean needAppearances;
    ArrayList<PdfDictionary> pageDics;
    ArrayList<PdfIndirectReference> pageRefs;
    HashMap<PdfReader, IntHashtable> pages2intrefs;
    ArrayList<PdfReader> readers;
    HashMap<PdfReader, IntHashtable> readers2intrefs;
    PdfDictionary resources;
    private HashMap<PdfArray, ArrayList<Integer>> tabOrder;
    HashMap<PdfReader, IntHashtable> visited;
    private static final PdfName iTextTag = new PdfName("_iTextTag_");
    private static final Integer zero = 0;

    static {
        HashMap<PdfName, Integer> map = new HashMap<>();
        widgetKeys = map;
        HashMap<PdfName, Integer> map2 = new HashMap<>();
        fieldKeys = map2;
        map.put(PdfName.SUBTYPE, 1);
        map.put(PdfName.CONTENTS, 1);
        map.put(PdfName.RECT, 1);
        map.put(PdfName.NM, 1);
        map.put(PdfName.M, 1);
        map.put(PdfName.F, 1);
        map.put(PdfName.BS, 1);
        map.put(PdfName.BORDER, 1);
        map.put(PdfName.AP, 1);
        map.put(PdfName.AS, 1);
        map.put(PdfName.C, 1);
        map.put(PdfName.A, 1);
        map.put(PdfName.STRUCTPARENT, 1);
        map.put(PdfName.OC, 1);
        map.put(PdfName.H, 1);
        map.put(PdfName.MK, 1);
        map.put(PdfName.DA, 1);
        map.put(PdfName.Q, 1);
        map.put(PdfName.P, 1);
        map2.put(PdfName.AA, 1);
        map2.put(PdfName.FT, 1);
        map2.put(PdfName.TU, 1);
        map2.put(PdfName.TM, 1);
        map2.put(PdfName.FF, 1);
        map2.put(PdfName.V, 1);
        map2.put(PdfName.DV, 1);
        map2.put(PdfName.DS, 1);
        map2.put(PdfName.RV, 1);
        map2.put(PdfName.OPT, 1);
        map2.put(PdfName.MAXLEN, 1);
        map2.put(PdfName.TI, 1);
        map2.put(PdfName.I, 1);
        map2.put(PdfName.LOCK, 1);
        map2.put(PdfName.SV, 1);
    }

    public PdfCopyFieldsImp(OutputStream outputStream) {
        this(outputStream, (char) 0);
    }

    private void adjustTabOrder(PdfArray pdfArray, PdfIndirectReference pdfIndirectReference, PdfNumber pdfNumber) {
        int iIntValue = pdfNumber.intValue();
        ArrayList<Integer> arrayList = this.tabOrder.get(pdfArray);
        if (arrayList == null) {
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            int size = pdfArray.size() - 1;
            for (int i = 0; i < size; i++) {
                arrayList2.add(zero);
            }
            arrayList2.add(Integer.valueOf(iIntValue));
            this.tabOrder.put(pdfArray, arrayList2);
            pdfArray.add(pdfIndirectReference);
            return;
        }
        int size2 = arrayList.size() - 1;
        for (int i2 = size2; i2 >= 0; i2--) {
            if (arrayList.get(i2).intValue() <= iIntValue) {
                int i3 = i2 + 1;
                arrayList.add(i3, Integer.valueOf(iIntValue));
                pdfArray.add(i3, pdfIndirectReference);
                size2 = -2;
                break;
            }
        }
        if (size2 != -2) {
            arrayList.add(0, Integer.valueOf(iIntValue));
            pdfArray.add(0, pdfIndirectReference);
        }
    }

    private static String getCOName(PdfReader pdfReader, PRIndirectReference pRIndirectReference) {
        PdfObject pdfObject;
        String str = "";
        while (pRIndirectReference != null && (pdfObject = PdfReader.getPdfObject(pRIndirectReference)) != null && pdfObject.type() == 6) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            PdfString asString = pdfDictionary.getAsString(PdfName.T);
            if (asString != null) {
                str = asString.toUnicodeString() + "." + str;
            }
            pRIndirectReference = (PRIndirectReference) pdfDictionary.get(PdfName.PARENT);
        }
        return str.endsWith(".") ? str.substring(0, str.length() - 1) : str;
    }

    public void addDocument(PdfReader pdfReader, List<Integer> list) {
        if (!this.readers2intrefs.containsKey(pdfReader) && pdfReader.isTampered()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.document.was.reused", new Object[0]));
        }
        PdfReader pdfReader2 = new PdfReader(pdfReader);
        pdfReader2.selectPages(list);
        if (pdfReader2.getNumberOfPages() == 0) {
            return;
        }
        pdfReader2.setTampered(false);
        addDocument(pdfReader2);
    }

    public void addPageOffsetToField(Map<String, AcroFields.Item> map, int i) {
        if (i == 0) {
            return;
        }
        for (AcroFields.Item item : map.values()) {
            for (int i2 = 0; i2 < item.size(); i2++) {
                item.forcePage(i2, item.getPage(i2).intValue() + i);
            }
        }
    }

    public PdfArray branchForm(HashMap<String, Object> map, PdfIndirectReference pdfIndirectReference, String str) {
        Iterator<Map.Entry<String, Object>> it;
        boolean z;
        PdfIndirectReference pdfIndirectReference2;
        PdfArray pdfArray;
        Iterator<Map.Entry<String, Object>> it2;
        PdfArray pdfArray2 = new PdfArray();
        Iterator<Map.Entry<String, Object>> it3 = map.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry<String, Object> next = it3.next();
            String key = next.getKey();
            Object value = next.getValue();
            PdfIndirectReference pdfIndirectReference3 = getPdfIndirectReference();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfIndirectReference != 0) {
                pdfDictionary.put(PdfName.PARENT, pdfIndirectReference);
            }
            pdfDictionary.put(PdfName.T, new PdfString(key, PdfObject.TEXT_UNICODE));
            String str2 = str + "." + key;
            int iIndexOf = this.calculationOrder.indexOf(str2);
            if (iIndexOf >= 0) {
                this.calculationOrderRefs.set(iIndexOf, pdfIndirectReference3);
            }
            if (value instanceof HashMap) {
                pdfDictionary.put(PdfName.KIDS, branchForm((HashMap) value, pdfIndirectReference3, str2));
                pdfArray2.add(pdfIndirectReference3);
                addToBody(pdfDictionary, pdfIndirectReference3);
                it = it3;
            } else {
                ArrayList arrayList = (ArrayList) value;
                pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(0));
                int i = 1;
                if (arrayList.size() == 3) {
                    pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(2));
                    PdfDictionary pdfDictionary2 = this.pageDics.get(((Integer) arrayList.get(1)).intValue() - 1);
                    PdfName pdfName = PdfName.ANNOTS;
                    PdfArray asArray = pdfDictionary2.getAsArray(pdfName);
                    if (asArray == null) {
                        asArray = new PdfArray();
                        pdfDictionary2.put(pdfName, asArray);
                    }
                    PdfName pdfName2 = iTextTag;
                    PdfNumber pdfNumber = (PdfNumber) pdfDictionary.get(pdfName2);
                    pdfDictionary.remove(pdfName2);
                    adjustTabOrder(asArray, pdfIndirectReference3, pdfNumber);
                    it = it3;
                    z = false;
                    pdfIndirectReference2 = null;
                } else {
                    PdfDictionary pdfDictionary3 = (PdfDictionary) arrayList.get(0);
                    PdfObject asName = pdfDictionary3.getAsName(PdfName.V);
                    PdfArray pdfArray3 = new PdfArray();
                    int i2 = 1;
                    while (i2 < arrayList.size()) {
                        PdfDictionary pdfDictionary4 = this.pageDics.get(((Integer) arrayList.get(i2)).intValue() - i);
                        PdfName pdfName3 = PdfName.ANNOTS;
                        PdfArray asArray2 = pdfDictionary4.getAsArray(pdfName3);
                        if (asArray2 == null) {
                            pdfArray = new PdfArray();
                            pdfDictionary4.put(pdfName3, pdfArray);
                        } else {
                            pdfArray = asArray2;
                        }
                        PdfDictionary pdfDictionary5 = new PdfDictionary();
                        pdfDictionary5.merge((PdfDictionary) arrayList.get(i2 + 1));
                        pdfDictionary5.put(PdfName.PARENT, pdfIndirectReference3);
                        PdfName pdfName4 = iTextTag;
                        PdfNumber pdfNumber2 = (PdfNumber) pdfDictionary5.get(pdfName4);
                        pdfDictionary5.remove(pdfName4);
                        if (PdfCopy.isCheckButton(pdfDictionary3)) {
                            PdfName pdfName5 = PdfName.AS;
                            PdfName asName2 = pdfDictionary5.getAsName(pdfName5);
                            if (asName != null && asName2 != null) {
                                pdfDictionary5.put(pdfName5, asName);
                            }
                        } else {
                            if (PdfCopy.isRadioButton(pdfDictionary3)) {
                                PdfName pdfName6 = PdfName.AS;
                                PdfName asName3 = pdfDictionary5.getAsName(pdfName6);
                                if (asName != null && asName3 != null) {
                                    it2 = it3;
                                    if (!asName3.equals(getOffStateName(pdfDictionary5))) {
                                        if (this.mergedRadioButtons.contains(arrayList)) {
                                            pdfDictionary5.put(pdfName6, getOffStateName(pdfDictionary5));
                                        } else {
                                            this.mergedRadioButtons.add(arrayList);
                                            pdfDictionary5.put(pdfName6, asName);
                                        }
                                    }
                                }
                            }
                            PdfIndirectReference indirectReference = addToBody(pdfDictionary5).getIndirectReference();
                            adjustTabOrder(pdfArray, indirectReference, pdfNumber2);
                            pdfArray3.add(indirectReference);
                            propagate(pdfDictionary5, null, false);
                            i2 += 2;
                            it3 = it2;
                            i = 1;
                        }
                        it2 = it3;
                        PdfIndirectReference indirectReference2 = addToBody(pdfDictionary5).getIndirectReference();
                        adjustTabOrder(pdfArray, indirectReference2, pdfNumber2);
                        pdfArray3.add(indirectReference2);
                        propagate(pdfDictionary5, null, false);
                        i2 += 2;
                        it3 = it2;
                        i = 1;
                    }
                    it = it3;
                    z = false;
                    pdfIndirectReference2 = null;
                    pdfDictionary.put(PdfName.KIDS, pdfArray3);
                }
                pdfArray2.add(pdfIndirectReference3);
                addToBody(pdfDictionary, pdfIndirectReference3);
                propagate(pdfDictionary, pdfIndirectReference2, z);
            }
            it3 = it;
        }
        return pdfArray2;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.DocWriter, com.itextpdf.text.DocListener
    public void close() {
        if (this.closing) {
            super.close();
            return;
        }
        this.closing = true;
        try {
            closeIt();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void closeIt() {
        for (int i = 0; i < this.readers.size(); i++) {
            this.readers.get(i).removeFields();
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.readers.size()) {
                break;
            }
            PdfReader pdfReader = this.readers.get(i2);
            for (int i3 = 1; i3 <= pdfReader.getNumberOfPages(); i3++) {
                this.pageRefs.add(getNewReference(pdfReader.getPageOrigRef(i3)));
                this.pageDics.add(pdfReader.getPageN(i3));
            }
            i2++;
        }
        mergeFields();
        createAcroForms();
        for (int i4 = 0; i4 < this.readers.size(); i4++) {
            PdfReader pdfReader2 = this.readers.get(i4);
            for (int i5 = 1; i5 <= pdfReader2.getNumberOfPages(); i5++) {
                PdfDictionary pageN = pdfReader2.getPageN(i5);
                PdfIndirectReference newReference = getNewReference(pdfReader2.getPageOrigRef(i5));
                pageN.put(PdfName.PARENT, this.root.addPageRef(newReference));
                propagate(pageN, newReference, false);
            }
        }
        for (Map.Entry<PdfReader, IntHashtable> entry : this.readers2intrefs.entrySet()) {
            PdfReader key = entry.getKey();
            try {
                RandomAccessFileOrArray safeFile = key.getSafeFile();
                this.file = safeFile;
                safeFile.reOpen();
                IntHashtable value = entry.getValue();
                int[] orderedKeys = value.toOrderedKeys();
                for (int i6 = 0; i6 < orderedKeys.length; i6++) {
                    addToBody(PdfReader.getPdfObjectRelease(new PRIndirectReference(key, orderedKeys[i6])), value.get(orderedKeys[i6]));
                }
                try {
                    this.file.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                try {
                    this.file.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        this.pdf.close();
    }

    public void createAcroForms() {
        if (this.fieldTree.isEmpty()) {
            return;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        this.form = pdfDictionary;
        pdfDictionary.put(PdfName.DR, this.resources);
        propagate(this.resources, null, false);
        if (this.needAppearances) {
            this.form.put(PdfName.NEEDAPPEARANCES, PdfBoolean.PDFTRUE);
        }
        this.form.put(PdfName.DA, new PdfString("/Helv 0 Tf 0 g "));
        this.tabOrder = new HashMap<>();
        this.calculationOrderRefs = new ArrayList<>(this.calculationOrder);
        this.form.put(PdfName.FIELDS, branchForm(this.fieldTree, null, ""));
        if (this.hasSignature) {
            this.form.put(PdfName.SIGFLAGS, new PdfNumber(3));
        }
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < this.calculationOrderRefs.size(); i++) {
            Object obj = this.calculationOrderRefs.get(i);
            if (obj instanceof PdfIndirectReference) {
                pdfArray.add((PdfIndirectReference) obj);
            }
        }
        if (pdfArray.size() > 0) {
            this.form.put(PdfName.CO, pdfArray);
        }
    }

    public void createWidgets(ArrayList<Object> arrayList, AcroFields.Item item) {
        for (int i = 0; i < item.size(); i++) {
            arrayList.add(item.getPage(i));
            PdfDictionary merged = item.getMerged(i);
            PdfObject pdfObject = merged.get(PdfName.DR);
            if (pdfObject != null) {
                PdfFormField.mergeResources(this.resources, (PdfDictionary) PdfReader.getPdfObject(pdfObject));
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            for (PdfName pdfName : merged.getKeys()) {
                if (widgetKeys.containsKey(pdfName)) {
                    pdfDictionary.put(pdfName, merged.get(pdfName));
                }
            }
            pdfDictionary.put(iTextTag, new PdfNumber(item.getTabOrder(i).intValue() + 1));
            arrayList.add(pdfDictionary);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        try {
            PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
            PdfDictionary pdfDictionary = this.form;
            if (pdfDictionary != null) {
                catalog.put(PdfName.ACROFORM, addToBody(pdfDictionary).getIndirectReference());
            }
            return catalog;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public Counter getCounter() {
        return this.COUNTER;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public int getNewObjectNumber(PdfReader pdfReader, int i, int i2) {
        IntHashtable intHashtable = this.readers2intrefs.get(pdfReader);
        int i3 = intHashtable.get(i);
        if (i3 != 0) {
            return i3;
        }
        int indirectReferenceNumber = getIndirectReferenceNumber();
        intHashtable.put(i, indirectReferenceNumber);
        return indirectReferenceNumber;
    }

    public PdfIndirectReference getNewReference(PRIndirectReference pRIndirectReference) {
        return new PdfIndirectReference(0, getNewObjectNumber(pRIndirectReference.getReader(), pRIndirectReference.getNumber(), 0));
    }

    public PdfName getOffStateName(PdfDictionary pdfDictionary) {
        return PdfName.Off;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectReference getPageReference(int i) {
        return this.pageRefs.get(i - 1);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public RandomAccessFileOrArray getReaderFile(PdfReader pdfReader) {
        return this.file;
    }

    public boolean isPage(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.pages2intrefs.get(pRIndirectReference.getReader());
        if (intHashtable != null) {
            return intHashtable.containsKey(pRIndirectReference.getNumber());
        }
        return false;
    }

    public boolean isVisited(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.visited.get(pRIndirectReference.getReader());
        if (intHashtable != null) {
            return intHashtable.containsKey(pRIndirectReference.getNumber());
        }
        return false;
    }

    public void mergeField(String str, AcroFields.Item item) {
        HashMap<String, Object> map = this.fieldTree;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return;
        }
        while (true) {
            String strNextToken = stringTokenizer.nextToken();
            Object obj = map.get(strNextToken);
            if (!stringTokenizer.hasMoreTokens()) {
                if (obj instanceof HashMap) {
                    return;
                }
                int iIntValue = 0;
                PdfDictionary merged = item.getMerged(0);
                if (obj == null) {
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    if (PdfName.SIG.equals(merged.get(PdfName.FT))) {
                        this.hasSignature = true;
                    }
                    for (PdfName pdfName : merged.getKeys()) {
                        if (fieldKeys.containsKey(pdfName)) {
                            pdfDictionary.put(pdfName, merged.get(pdfName));
                        }
                    }
                    ArrayList<Object> arrayList = new ArrayList<>();
                    arrayList.add(pdfDictionary);
                    createWidgets(arrayList, item);
                    map.put(strNextToken, arrayList);
                    return;
                }
                ArrayList<Object> arrayList2 = (ArrayList) obj;
                PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList2.get(0);
                PdfName pdfName2 = PdfName.FT;
                PdfName pdfName3 = (PdfName) pdfDictionary2.get(pdfName2);
                PdfName pdfName4 = (PdfName) merged.get(pdfName2);
                if (pdfName3 == null || !pdfName3.equals(pdfName4)) {
                    return;
                }
                PdfName pdfName5 = PdfName.FF;
                PdfObject pdfObject = pdfDictionary2.get(pdfName5);
                int iIntValue2 = (pdfObject == null || !pdfObject.isNumber()) ? 0 : ((PdfNumber) pdfObject).intValue();
                PdfObject pdfObject2 = merged.get(pdfName5);
                if (pdfObject2 != null && pdfObject2.isNumber()) {
                    iIntValue = ((PdfNumber) pdfObject2).intValue();
                }
                if (pdfName3.equals(PdfName.BTN)) {
                    int i = iIntValue2 ^ iIntValue;
                    if ((i & 65536) != 0) {
                        return;
                    }
                    if ((iIntValue2 & 65536) == 0 && (32768 & i) != 0) {
                        return;
                    }
                } else if (pdfName3.equals(PdfName.CH) && ((iIntValue2 ^ iIntValue) & 131072) != 0) {
                    return;
                }
                createWidgets(arrayList2, item);
                return;
            }
            if (obj == null) {
                HashMap<String, Object> map2 = new HashMap<>();
                map.put(strNextToken, map2);
                map = map2;
            } else if (!(obj instanceof HashMap)) {
                return;
            } else {
                map = (HashMap) obj;
            }
        }
    }

    public void mergeFields() {
        int numberOfPages = 0;
        for (int i = 0; i < this.fields.size(); i++) {
            Map<String, AcroFields.Item> fields = this.fields.get(i).getFields();
            addPageOffsetToField(fields, numberOfPages);
            mergeWithMaster(fields);
            numberOfPages += this.readers.get(i).getNumberOfPages();
        }
    }

    public void mergeWithMaster(Map<String, AcroFields.Item> map) {
        for (Map.Entry<String, AcroFields.Item> entry : map.entrySet()) {
            mergeField(entry.getKey(), entry.getValue());
        }
    }

    public void openDoc() {
        if (this.nd.isOpen()) {
            return;
        }
        this.nd.open();
    }

    public void propagate(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) {
        if (pdfObject == null || (pdfObject instanceof PdfIndirectReference)) {
            return;
        }
        int iType = pdfObject.type();
        if (iType == 5) {
            ListIterator<PdfObject> listIterator = ((PdfArray) pdfObject).listIterator();
            while (listIterator.hasNext()) {
                PdfObject next = listIterator.next();
                if (next == null || !next.isIndirect()) {
                    propagate(next, null, z);
                } else {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) next;
                    if (!isVisited(pRIndirectReference) && !isPage(pRIndirectReference)) {
                        propagate(PdfReader.getPdfObjectRelease(pRIndirectReference), getNewReference(pRIndirectReference), z);
                    }
                }
            }
            return;
        }
        if (iType != 6 && iType != 7) {
            if (iType == 10) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("reference.pointing.to.reference", new Object[0]));
            }
            return;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            if (!z || (!pdfName.equals(PdfName.PARENT) && !pdfName.equals(PdfName.KIDS))) {
                PdfObject pdfObject2 = pdfDictionary.get(pdfName);
                if (pdfObject2 == null || !pdfObject2.isIndirect()) {
                    propagate(pdfObject2, null, z);
                } else {
                    PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfObject2;
                    if (!setVisited(pRIndirectReference2) && !isPage(pRIndirectReference2)) {
                        propagate(PdfReader.getPdfObjectRelease(pRIndirectReference2), getNewReference(pRIndirectReference2), z);
                    }
                }
            }
        }
    }

    public boolean setVisited(PRIndirectReference pRIndirectReference) {
        IntHashtable intHashtable = this.visited.get(pRIndirectReference.getReader());
        return (intHashtable == null || intHashtable.put(pRIndirectReference.getNumber(), 1) == 0) ? false : true;
    }

    public void updateCalculationOrder(PdfReader pdfReader) {
        PdfArray asArray;
        PdfDictionary asDict = pdfReader.getCatalog().getAsDict(PdfName.ACROFORM);
        if (asDict == null || (asArray = asDict.getAsArray(PdfName.CO)) == null || asArray.size() == 0) {
            return;
        }
        AcroFields acroFields = pdfReader.getAcroFields();
        for (int i = 0; i < asArray.size(); i++) {
            PdfObject pdfObject = asArray.getPdfObject(i);
            if (pdfObject != null && pdfObject.isIndirect()) {
                String cOName = getCOName(pdfReader, (PRIndirectReference) pdfObject);
                if (acroFields.getFieldItem(cOName) != null) {
                    String str = "." + cOName;
                    if (!this.calculationOrder.contains(str)) {
                        this.calculationOrder.add(str);
                    }
                }
            }
        }
    }

    public PdfCopyFieldsImp(OutputStream outputStream, char c) {
        super(new PdfDocument(), outputStream);
        this.readers = new ArrayList<>();
        this.readers2intrefs = new HashMap<>();
        this.pages2intrefs = new HashMap<>();
        this.visited = new HashMap<>();
        this.fields = new ArrayList<>();
        this.fieldTree = new HashMap<>();
        this.pageRefs = new ArrayList<>();
        this.pageDics = new ArrayList<>();
        this.resources = new PdfDictionary();
        this.closing = false;
        this.calculationOrder = new ArrayList<>();
        this.needAppearances = false;
        this.mergedRadioButtons = new HashSet<>();
        this.COUNTER = CounterFactory.getCounter(PdfCopyFields.class);
        this.pdf.addWriter(this);
        if (c != 0) {
            super.setPdfVersion(c);
        }
        Document document = new Document();
        this.nd = document;
        document.addDocListener(this.pdf);
    }

    public boolean isVisited(PdfReader pdfReader, int i, int i2) {
        return this.readers2intrefs.get(pdfReader).containsKey(i);
    }

    public void addDocument(PdfReader pdfReader) {
        if (pdfReader.isOpenedWithFullPermissions()) {
            openDoc();
            if (this.readers2intrefs.containsKey(pdfReader)) {
                pdfReader = new PdfReader(pdfReader);
            } else if (!pdfReader.isTampered()) {
                pdfReader.consolidateNamedDestinations();
                pdfReader.setTampered(true);
            } else {
                throw new DocumentException(MessageLocalization.getComposedMessage("the.document.was.reused", new Object[0]));
            }
            pdfReader.shuffleSubsetNames();
            this.readers2intrefs.put(pdfReader, new IntHashtable());
            this.readers.add(pdfReader);
            int numberOfPages = pdfReader.getNumberOfPages();
            IntHashtable intHashtable = new IntHashtable();
            for (int i = 1; i <= numberOfPages; i++) {
                intHashtable.put(pdfReader.getPageOrigRef(i).getNumber(), 1);
                pdfReader.releasePage(i);
            }
            this.pages2intrefs.put(pdfReader, intHashtable);
            this.visited.put(pdfReader, new IntHashtable());
            AcroFields acroFields = pdfReader.getAcroFields();
            if (!acroFields.isGenerateAppearances()) {
                this.needAppearances = true;
            }
            this.fields.add(acroFields);
            updateCalculationOrder(pdfReader);
            return;
        }
        throw new BadPasswordException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
    }
}
