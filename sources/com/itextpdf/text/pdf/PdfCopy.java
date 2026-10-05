package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public class PdfCopy extends PdfWriter {
    private static final PdfName annotId;
    private static int annotIdCnt;
    protected static final HashSet<PdfName> fieldKeys;
    private static final PdfName iTextTag;
    protected static final HashSet<PdfName> widgetKeys;
    private static final Integer zero;
    private PdfIndirectReference acroForm;
    private ArrayList<String> calculationOrder;
    private ArrayList<Object> calculationOrderRefs;
    private int currentStructArrayNumber;
    protected HashSet<PdfObject> disableIndirects;
    protected PdfArray fieldArray;
    protected HashSet<PdfTemplate> fieldTemplates;
    private HashMap<String, Object> fieldTree;
    protected ArrayList<AcroFields> fields;
    private boolean hasSignature;
    protected ArrayList<ImportedPage> importedPages;
    protected HashMap<PdfReader, HashMap<RefKey, IndirectReferences>> indirectMap;
    protected LinkedHashMap<RefKey, PdfIndirectObject> indirectObjects;
    protected HashMap<RefKey, IndirectReferences> indirects;
    protected boolean mergeFields;
    private boolean mergeFieldsInternalCall;
    private HashMap<Integer, PdfIndirectObject> mergedMap;
    private HashSet<Object> mergedRadioButtons;
    private HashSet<PdfIndirectObject> mergedSet;
    private HashMap<Object, PdfString> mergedTextFields;
    protected int[] namePtr;
    private boolean needAppearances;
    protected HashMap<PdfObject, PdfObject> parentObjects;
    protected PdfReader reader;
    private HashSet<PdfReader> readersWithImportedStructureTreeRootKids;
    private PdfDictionary resources;
    private boolean rotateContents;
    protected ArrayList<PdfIndirectObject> savedObjects;
    private PdfStructTreeController structTreeController;
    protected PRIndirectReference structTreeRootReference;
    private HashMap<PdfArray, ArrayList<Integer>> tabOrder;
    private HashMap<RefKey, PdfIndirectObject> unmergedIndirectRefsMap;
    private HashMap<Integer, PdfIndirectObject> unmergedMap;
    protected boolean updateRootKids;
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) PdfCopy.class);
    protected static Counter COUNTER = CounterFactory.getCounter(PdfCopy.class);

    public static class ImportedPage {
        PdfIndirectReference annotsIndirectReference;
        PdfArray mergedFields;
        int pageNumber;
        PdfReader reader;

        public ImportedPage(PdfReader pdfReader, int i, boolean z) {
            this.pageNumber = i;
            this.reader = pdfReader;
            if (z) {
                this.mergedFields = new PdfArray();
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImportedPage)) {
                return false;
            }
            ImportedPage importedPage = (ImportedPage) obj;
            return this.pageNumber == importedPage.pageNumber && this.reader.equals(importedPage.reader);
        }

        public String toString() {
            return Integer.toString(this.pageNumber);
        }
    }

    public static class IndirectReferences {
        boolean hasCopied = false;
        PdfIndirectReference theRef;

        public IndirectReferences(PdfIndirectReference pdfIndirectReference) {
            this.theRef = pdfIndirectReference;
        }

        public boolean getCopied() {
            return this.hasCopied;
        }

        public PdfIndirectReference getRef() {
            return this.theRef;
        }

        public void setCopied() {
            this.hasCopied = true;
        }

        public void setNotCopied() {
            this.hasCopied = false;
        }

        public String toString() {
            String str = "";
            if (this.hasCopied) {
                str = " Copied";
            }
            return getRef() + str;
        }
    }

    public static class PageStamp {
        PdfCopy cstp;
        StampContent over;
        PdfDictionary pageN;
        PageResources pageResources;
        PdfReader reader;
        StampContent under;

        public PageStamp(PdfReader pdfReader, PdfDictionary pdfDictionary, PdfCopy pdfCopy) {
            this.pageN = pdfDictionary;
            this.reader = pdfReader;
            this.cstp = pdfCopy;
        }

        private void addDocumentField(PdfIndirectReference pdfIndirectReference) {
            PdfCopy pdfCopy = this.cstp;
            if (pdfCopy.fieldArray == null) {
                pdfCopy.fieldArray = new PdfArray();
            }
            this.cstp.fieldArray.add(pdfIndirectReference);
        }

        private void expandFields(PdfFormField pdfFormField, ArrayList<PdfAnnotation> arrayList) {
            arrayList.add(pdfFormField);
            ArrayList<PdfFormField> kids = pdfFormField.getKids();
            if (kids != null) {
                Iterator<PdfFormField> it = kids.iterator();
                while (it.hasNext()) {
                    expandFields(it.next(), arrayList);
                }
            }
        }

        public void addAnnotation(PdfAnnotation pdfAnnotation) {
            PdfArray pdfArray;
            HashSet<PdfTemplate> templates;
            try {
                ArrayList<PdfAnnotation> arrayList = new ArrayList<>();
                if (pdfAnnotation.isForm()) {
                    PdfFormField pdfFormField = (PdfFormField) pdfAnnotation;
                    if (pdfFormField.getParent() != null) {
                        return;
                    }
                    expandFields(pdfFormField, arrayList);
                    PdfCopy pdfCopy = this.cstp;
                    if (pdfCopy.fieldTemplates == null) {
                        pdfCopy.fieldTemplates = new HashSet<>();
                    }
                } else {
                    arrayList.add(pdfAnnotation);
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    PdfAnnotation pdfAnnotation2 = arrayList.get(i);
                    if (pdfAnnotation2.isForm()) {
                        if (!pdfAnnotation2.isUsed() && (templates = pdfAnnotation2.getTemplates()) != null) {
                            this.cstp.fieldTemplates.addAll(templates);
                        }
                        PdfFormField pdfFormField2 = (PdfFormField) pdfAnnotation2;
                        if (pdfFormField2.getParent() == null) {
                            addDocumentField(pdfFormField2.getIndirectReference());
                        }
                    }
                    if (pdfAnnotation2.isAnnotation()) {
                        PdfDictionary pdfDictionary = this.pageN;
                        PdfName pdfName = PdfName.ANNOTS;
                        PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(pdfName), this.pageN);
                        if (pdfObject == null || !pdfObject.isArray()) {
                            pdfArray = new PdfArray();
                            this.pageN.put(pdfName, pdfArray);
                        } else {
                            pdfArray = (PdfArray) pdfObject;
                        }
                        pdfArray.add(pdfAnnotation2.getIndirectReference());
                        if (!pdfAnnotation2.isUsed()) {
                            PdfName pdfName2 = PdfName.RECT;
                            PdfRectangle pdfRectangle = (PdfRectangle) pdfAnnotation2.get(pdfName2);
                            if (pdfRectangle != null && (pdfRectangle.left() != 0.0f || pdfRectangle.right() != 0.0f || pdfRectangle.top() != 0.0f || pdfRectangle.bottom() != 0.0f)) {
                                int pageRotation = this.reader.getPageRotation(this.pageN);
                                Rectangle pageSizeWithRotation = this.reader.getPageSizeWithRotation(this.pageN);
                                if (pageRotation == 90) {
                                    pdfAnnotation2.put(pdfName2, new PdfRectangle(pageSizeWithRotation.getTop() - pdfRectangle.bottom(), pdfRectangle.left(), pageSizeWithRotation.getTop() - pdfRectangle.top(), pdfRectangle.right()));
                                } else if (pageRotation == 180) {
                                    pdfAnnotation2.put(pdfName2, new PdfRectangle(pageSizeWithRotation.getRight() - pdfRectangle.left(), pageSizeWithRotation.getTop() - pdfRectangle.bottom(), pageSizeWithRotation.getRight() - pdfRectangle.right(), pageSizeWithRotation.getTop() - pdfRectangle.top()));
                                } else if (pageRotation == 270) {
                                    pdfAnnotation2.put(pdfName2, new PdfRectangle(pdfRectangle.bottom(), pageSizeWithRotation.getRight() - pdfRectangle.left(), pdfRectangle.top(), pageSizeWithRotation.getRight() - pdfRectangle.right()));
                                }
                            }
                        }
                    }
                    if (!pdfAnnotation2.isUsed()) {
                        pdfAnnotation2.setUsed();
                        this.cstp.addToBody(pdfAnnotation2, pdfAnnotation2.getIndirectReference());
                    }
                }
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }

        public void alterContents() {
            PdfArray pdfArray;
            if (this.over == null && this.under == null) {
                return;
            }
            PdfDictionary pdfDictionary = this.pageN;
            PdfName pdfName = PdfName.CONTENTS;
            PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(pdfName), this.pageN);
            if (pdfObject == null) {
                pdfArray = new PdfArray();
                this.pageN.put(pdfName, pdfArray);
            } else if (pdfObject.isArray()) {
                pdfArray = (PdfArray) pdfObject;
            } else if (pdfObject.isStream()) {
                pdfArray = new PdfArray();
                pdfArray.add(this.pageN.get(pdfName));
                this.pageN.put(pdfName, pdfArray);
            } else {
                pdfArray = new PdfArray();
                this.pageN.put(pdfName, pdfArray);
            }
            ByteBuffer byteBuffer = new ByteBuffer();
            if (this.under != null) {
                byteBuffer.append(PdfContents.SAVESTATE);
                applyRotation(this.pageN, byteBuffer);
                byteBuffer.append(this.under.getInternalBuffer());
                byteBuffer.append(PdfContents.RESTORESTATE);
            }
            if (this.over != null) {
                byteBuffer.append(PdfContents.SAVESTATE);
            }
            PdfStream pdfStream = new PdfStream(byteBuffer.toByteArray());
            pdfStream.flateCompress(this.cstp.getCompressionLevel());
            pdfArray.addFirst(this.cstp.addToBody(pdfStream).getIndirectReference());
            byteBuffer.reset();
            if (this.over != null) {
                byteBuffer.append(' ');
                byte[] bArr = PdfContents.RESTORESTATE;
                byteBuffer.append(bArr);
                byteBuffer.append(PdfContents.SAVESTATE);
                applyRotation(this.pageN, byteBuffer);
                byteBuffer.append(this.over.getInternalBuffer());
                byteBuffer.append(bArr);
                PdfStream pdfStream2 = new PdfStream(byteBuffer.toByteArray());
                pdfStream2.flateCompress(this.cstp.getCompressionLevel());
                pdfArray.add(this.cstp.addToBody(pdfStream2).getIndirectReference());
            }
            this.pageN.put(PdfName.RESOURCES, this.pageResources.getResources());
        }

        public void applyRotation(PdfDictionary pdfDictionary, ByteBuffer byteBuffer) {
            if (this.cstp.rotateContents) {
                Rectangle pageSizeWithRotation = this.reader.getPageSizeWithRotation(pdfDictionary);
                int rotation = pageSizeWithRotation.getRotation();
                if (rotation == 90) {
                    byteBuffer.append(PdfContents.ROTATE90);
                    byteBuffer.append(pageSizeWithRotation.getTop());
                    byteBuffer.append(' ').append('0').append(PdfContents.ROTATEFINAL);
                } else {
                    if (rotation == 180) {
                        byteBuffer.append(PdfContents.ROTATE180);
                        byteBuffer.append(pageSizeWithRotation.getRight());
                        byteBuffer.append(' ');
                        byteBuffer.append(pageSizeWithRotation.getTop());
                        byteBuffer.append(PdfContents.ROTATEFINAL);
                        return;
                    }
                    if (rotation != 270) {
                        return;
                    }
                    byteBuffer.append(PdfContents.ROTATE270);
                    byteBuffer.append('0').append(' ');
                    byteBuffer.append(pageSizeWithRotation.getRight());
                    byteBuffer.append(PdfContents.ROTATEFINAL);
                }
            }
        }

        public PdfContentByte getOverContent() {
            if (this.over == null) {
                if (this.pageResources == null) {
                    this.pageResources = new PageResources();
                    this.pageResources.setOriginalResources(this.pageN.getAsDict(PdfName.RESOURCES), this.cstp.namePtr);
                }
                this.over = new StampContent(this.cstp, this.pageResources);
            }
            return this.over;
        }

        public PdfContentByte getUnderContent() {
            if (this.under == null) {
                if (this.pageResources == null) {
                    this.pageResources = new PageResources();
                    this.pageResources.setOriginalResources(this.pageN.getAsDict(PdfName.RESOURCES), this.cstp.namePtr);
                }
                this.under = new StampContent(this.cstp, this.pageResources);
            }
            return this.under;
        }
    }

    public static class StampContent extends PdfContentByte {
        PageResources pageResources;

        public StampContent(PdfWriter pdfWriter, PageResources pageResources) {
            super(pdfWriter);
            this.pageResources = pageResources;
        }

        @Override // com.itextpdf.text.pdf.PdfContentByte
        public PdfContentByte getDuplicate() {
            return new StampContent(this.writer, this.pageResources);
        }

        @Override // com.itextpdf.text.pdf.PdfContentByte
        public PageResources getPageResources() {
            return this.pageResources;
        }
    }

    static {
        PdfName pdfName = new PdfName("iTextAnnotId");
        annotId = pdfName;
        annotIdCnt = 0;
        iTextTag = new PdfName("_iTextTag_");
        zero = 0;
        HashSet<PdfName> hashSet = new HashSet<>();
        widgetKeys = hashSet;
        HashSet<PdfName> hashSet2 = new HashSet<>();
        fieldKeys = hashSet2;
        hashSet.add(PdfName.SUBTYPE);
        hashSet.add(PdfName.CONTENTS);
        hashSet.add(PdfName.RECT);
        hashSet.add(PdfName.NM);
        hashSet.add(PdfName.M);
        hashSet.add(PdfName.F);
        hashSet.add(PdfName.BS);
        hashSet.add(PdfName.BORDER);
        hashSet.add(PdfName.AP);
        hashSet.add(PdfName.AS);
        hashSet.add(PdfName.C);
        hashSet.add(PdfName.A);
        hashSet.add(PdfName.STRUCTPARENT);
        hashSet.add(PdfName.OC);
        hashSet.add(PdfName.H);
        hashSet.add(PdfName.MK);
        hashSet.add(PdfName.DA);
        hashSet.add(PdfName.Q);
        hashSet.add(PdfName.P);
        hashSet.add(PdfName.TYPE);
        hashSet.add(pdfName);
        hashSet2.add(PdfName.AA);
        hashSet2.add(PdfName.FT);
        hashSet2.add(PdfName.TU);
        hashSet2.add(PdfName.TM);
        hashSet2.add(PdfName.FF);
        hashSet2.add(PdfName.V);
        hashSet2.add(PdfName.DV);
        hashSet2.add(PdfName.DS);
        hashSet2.add(PdfName.RV);
        hashSet2.add(PdfName.OPT);
        hashSet2.add(PdfName.MAXLEN);
        hashSet2.add(PdfName.TI);
        hashSet2.add(PdfName.I);
        hashSet2.add(PdfName.LOCK);
        hashSet2.add(PdfName.SV);
    }

    public PdfCopy(Document document, OutputStream outputStream) {
        super(new PdfDocument(), outputStream);
        this.namePtr = new int[]{0};
        this.rotateContents = true;
        this.structTreeController = null;
        this.currentStructArrayNumber = 0;
        this.updateRootKids = false;
        this.mergeFields = false;
        this.needAppearances = false;
        this.mergeFieldsInternalCall = false;
        this.mergedRadioButtons = new HashSet<>();
        this.mergedTextFields = new HashMap<>();
        this.readersWithImportedStructureTreeRootKids = new HashSet<>();
        document.addDocListener(this.pdf);
        this.pdf.addWriter(this);
        this.indirectMap = new HashMap<>();
        this.parentObjects = new HashMap<>();
        this.disableIndirects = new HashSet<>();
        this.indirectObjects = new LinkedHashMap<>();
        this.savedObjects = new ArrayList<>();
        this.importedPages = new ArrayList<>();
    }

    private void addFieldResources(PdfDictionary pdfDictionary) {
        if (this.fieldArray == null) {
            return;
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary.put(PdfName.ACROFORM, pdfDictionary2);
        pdfDictionary2.put(PdfName.FIELDS, this.fieldArray);
        pdfDictionary2.put(PdfName.DA, new PdfString("/Helv 0 Tf 0 g "));
        if (this.fieldTemplates.isEmpty()) {
            return;
        }
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        pdfDictionary2.put(PdfName.DR, pdfDictionary3);
        Iterator<PdfTemplate> it = this.fieldTemplates.iterator();
        while (it.hasNext()) {
            PdfFormField.mergeResources(pdfDictionary3, (PdfDictionary) it.next().getResources());
        }
        PdfName pdfName = PdfName.FONT;
        PdfDictionary asDict = pdfDictionary3.getAsDict(pdfName);
        if (asDict == null) {
            asDict = new PdfDictionary();
            pdfDictionary3.put(pdfName, asDict);
        }
        PdfName pdfName2 = PdfName.HELV;
        if (!asDict.contains(pdfName2)) {
            PdfDictionary pdfDictionary4 = new PdfDictionary(pdfName);
            pdfDictionary4.put(PdfName.BASEFONT, PdfName.HELVETICA);
            pdfDictionary4.put(PdfName.ENCODING, PdfName.WIN_ANSI_ENCODING);
            pdfDictionary4.put(PdfName.NAME, pdfName2);
            pdfDictionary4.put(PdfName.SUBTYPE, PdfName.TYPE1);
            asDict.put(pdfName2, addToBody(pdfDictionary4).getIndirectReference());
        }
        PdfName pdfName3 = PdfName.ZADB;
        if (asDict.contains(pdfName3)) {
            return;
        }
        PdfDictionary pdfDictionary5 = new PdfDictionary(pdfName);
        pdfDictionary5.put(PdfName.BASEFONT, PdfName.ZAPFDINGBATS);
        pdfDictionary5.put(PdfName.NAME, pdfName3);
        pdfDictionary5.put(PdfName.SUBTYPE, PdfName.TYPE1);
        asDict.put(pdfName3, addToBody(pdfDictionary5).getIndirectReference());
    }

    private void addPageOffsetToField(Map<String, AcroFields.Item> map, int i) {
        if (i == 0) {
            return;
        }
        for (AcroFields.Item item : map.values()) {
            for (int i2 = 0; i2 < item.size(); i2++) {
                item.forcePage(i2, item.getPage(i2).intValue() + i);
            }
        }
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

    private PdfArray branchForm(HashMap<String, Object> map, PdfIndirectReference pdfIndirectReference, String str) {
        Iterator<Map.Entry<String, Object>> it;
        boolean z;
        Iterator<Map.Entry<String, Object>> it2;
        PdfArray pdfArray = new PdfArray();
        Iterator<Map.Entry<String, Object>> it3 = map.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry<String, Object> next = it3.next();
            String key = next.getKey();
            Object value = next.getValue();
            PdfIndirectReference pdfIndirectReference2 = getPdfIndirectReference();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfIndirectReference != 0) {
                pdfDictionary.put(PdfName.PARENT, pdfIndirectReference);
            }
            pdfDictionary.put(PdfName.T, new PdfString(key, PdfObject.TEXT_UNICODE));
            String str2 = str + "." + key;
            int iIndexOf = this.calculationOrder.indexOf(str2);
            if (iIndexOf >= 0) {
                this.calculationOrderRefs.set(iIndexOf, pdfIndirectReference2);
            }
            int i = 1;
            if (value instanceof HashMap) {
                pdfDictionary.put(PdfName.KIDS, branchForm((HashMap) value, pdfIndirectReference2, str2));
                pdfArray.add(pdfIndirectReference2);
                addToBody((PdfObject) pdfDictionary, pdfIndirectReference2, true);
                it = it3;
            } else {
                ArrayList arrayList = (ArrayList) value;
                pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(0));
                if (arrayList.size() == 3) {
                    pdfDictionary.mergeDifferent((PdfDictionary) arrayList.get(2));
                    PdfArray pdfArray2 = this.importedPages.get(((Integer) arrayList.get(1)).intValue() - 1).mergedFields;
                    PdfName pdfName = iTextTag;
                    PdfNumber pdfNumber = (PdfNumber) pdfDictionary.get(pdfName);
                    pdfDictionary.remove(pdfName);
                    pdfDictionary.put(PdfName.TYPE, PdfName.ANNOT);
                    adjustTabOrder(pdfArray2, pdfIndirectReference2, pdfNumber);
                    it = it3;
                    z = true;
                } else {
                    PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList.get(0);
                    PdfArray pdfArray3 = new PdfArray();
                    int i2 = 1;
                    while (i2 < arrayList.size()) {
                        PdfArray pdfArray4 = this.importedPages.get(((Integer) arrayList.get(i2)).intValue() - i).mergedFields;
                        PdfDictionary pdfDictionary3 = new PdfDictionary();
                        pdfDictionary3.merge((PdfDictionary) arrayList.get(i2 + 1));
                        pdfDictionary3.put(PdfName.PARENT, pdfIndirectReference2);
                        PdfName pdfName2 = iTextTag;
                        PdfNumber pdfNumber2 = (PdfNumber) pdfDictionary3.get(pdfName2);
                        pdfDictionary3.remove(pdfName2);
                        if (isTextField(pdfDictionary2)) {
                            PdfString asString = pdfDictionary2.getAsString(PdfName.V);
                            PdfObject directObject = pdfDictionary3.getDirectObject(PdfName.AP);
                            if (asString == null || directObject == null) {
                                it2 = it3;
                            } else {
                                if (this.mergedTextFields.containsKey(arrayList)) {
                                    try {
                                        TextField textField = new TextField(this, null, null);
                                        it2 = it3;
                                        try {
                                            this.fields.get(0).decodeGenericDictionary(pdfDictionary3, textField);
                                            Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(pdfDictionary3.getAsArray(PdfName.RECT));
                                            if (textField.getRotation() == 90 || textField.getRotation() == 270) {
                                                normalizedRectangle = normalizedRectangle.rotate();
                                            }
                                            textField.setBox(normalizedRectangle);
                                            textField.setText(this.mergedTextFields.get(arrayList).toUnicodeString());
                                            ((PdfDictionary) directObject).put(PdfName.N, textField.getAppearance().getIndirectReference());
                                        } catch (DocumentException unused) {
                                        }
                                    } catch (DocumentException unused2) {
                                        it2 = it3;
                                    }
                                } else {
                                    this.mergedTextFields.put(arrayList, asString);
                                }
                                it2 = it3;
                            }
                        } else {
                            it2 = it3;
                            if (isCheckButton(pdfDictionary2)) {
                                PdfObject asName = pdfDictionary2.getAsName(PdfName.V);
                                PdfName pdfName3 = PdfName.AS;
                                PdfName asName2 = pdfDictionary3.getAsName(pdfName3);
                                if (asName != null && asName2 != null) {
                                    pdfDictionary3.put(pdfName3, asName);
                                }
                            } else if (isRadioButton(pdfDictionary2)) {
                                PdfObject asName3 = pdfDictionary2.getAsName(PdfName.V);
                                PdfName pdfName4 = PdfName.AS;
                                PdfName asName4 = pdfDictionary3.getAsName(pdfName4);
                                if (asName3 != null && asName4 != null && !asName4.equals(getOffStateName(pdfDictionary3))) {
                                    if (this.mergedRadioButtons.contains(arrayList)) {
                                        pdfDictionary3.put(pdfName4, getOffStateName(pdfDictionary3));
                                    } else {
                                        this.mergedRadioButtons.add(arrayList);
                                        pdfDictionary3.put(pdfName4, asName3);
                                    }
                                }
                            }
                        }
                        pdfDictionary3.put(PdfName.TYPE, PdfName.ANNOT);
                        PdfIndirectReference indirectReference = addToBody((PdfObject) pdfDictionary3, getPdfIndirectReference(), true).getIndirectReference();
                        adjustTabOrder(pdfArray4, indirectReference, pdfNumber2);
                        pdfArray3.add(indirectReference);
                        i2 += 2;
                        it3 = it2;
                        i = 1;
                    }
                    it = it3;
                    z = true;
                    pdfDictionary.put(PdfName.KIDS, pdfArray3);
                }
                pdfArray.add(pdfIndirectReference2);
                addToBody(pdfDictionary, pdfIndirectReference2, z);
            }
            it3 = it;
        }
        return pdfArray;
    }

    private int checkStructureTreeRootKids(ImportedPage importedPage) {
        if (this.importedPages.size() == 0) {
            return 1;
        }
        Iterator<ImportedPage> it = this.importedPages.iterator();
        while (it.hasNext()) {
            if (it.next().reader.equals(importedPage.reader)) {
                ArrayList<ImportedPage> arrayList = this.importedPages;
                ImportedPage importedPage2 = arrayList.get(arrayList.size() - 1);
                if (!importedPage2.reader.equals(importedPage.reader) || importedPage.pageNumber <= importedPage2.pageNumber) {
                    return -1;
                }
                return this.readersWithImportedStructureTreeRootKids.contains(importedPage.reader) ? 0 : 1;
            }
        }
        return 1;
    }

    private void clearIndirects(PdfReader pdfReader) {
        HashMap<RefKey, IndirectReferences> map = this.indirectMap.get(pdfReader);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<RefKey, IndirectReferences> entry : map.entrySet()) {
            PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(new RefKey(entry.getValue().theRef));
            if (pdfIndirectObject == null) {
                arrayList.add(entry.getKey());
            } else if (pdfIndirectObject.object.isArray() || pdfIndirectObject.object.isDictionary() || pdfIndirectObject.object.isStream()) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            map.remove((RefKey) it.next());
        }
    }

    private boolean containsInactivePg(PdfDictionary pdfDictionary, HashSet<RefKey> hashSet) {
        PdfObject pdfObject = pdfDictionary.get(PdfName.PG);
        return (pdfObject == null || hashSet.contains(new RefKey((PdfIndirectReference) pdfObject))) ? false : true;
    }

    private void createAcroForms() {
        if (this.fieldTree.isEmpty()) {
            for (ImportedPage importedPage : this.importedPages) {
                if (importedPage.mergedFields.size() > 0) {
                    addToBody(importedPage.mergedFields, importedPage.annotsIndirectReference);
                }
            }
            return;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.DR, propagate(this.resources));
        if (this.needAppearances) {
            pdfDictionary.put(PdfName.NEEDAPPEARANCES, PdfBoolean.PDFTRUE);
        }
        pdfDictionary.put(PdfName.DA, new PdfString("/Helv 0 Tf 0 g "));
        this.tabOrder = new HashMap<>();
        this.calculationOrderRefs = new ArrayList<>(this.calculationOrder);
        pdfDictionary.put(PdfName.FIELDS, branchForm(this.fieldTree, null, ""));
        if (this.hasSignature) {
            pdfDictionary.put(PdfName.SIGFLAGS, new PdfNumber(3));
        }
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < this.calculationOrderRefs.size(); i++) {
            Object obj = this.calculationOrderRefs.get(i);
            if (obj instanceof PdfIndirectReference) {
                pdfArray.add((PdfIndirectReference) obj);
            }
        }
        if (pdfArray.size() > 0) {
            pdfDictionary.put(PdfName.CO, pdfArray);
        }
        this.acroForm = addToBody(pdfDictionary).getIndirectReference();
        for (ImportedPage importedPage2 : this.importedPages) {
            addToBody(importedPage2.mergedFields, importedPage2.annotsIndirectReference);
        }
    }

    private void createWidgets(ArrayList<Object> arrayList, AcroFields.Item item) {
        for (int i = 0; i < item.size(); i++) {
            arrayList.add(item.getPage(i));
            PdfDictionary merged = item.getMerged(i);
            PdfObject pdfObject = merged.get(PdfName.DR);
            if (pdfObject != null) {
                PdfFormField.mergeResources(this.resources, (PdfDictionary) PdfReader.getPdfObject(pdfObject));
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            for (PdfName pdfName : merged.getKeys()) {
                if (widgetKeys.contains(pdfName)) {
                    pdfDictionary.put(pdfName, merged.get(pdfName));
                }
            }
            pdfDictionary.put(iTextTag, new PdfNumber(item.getTabOrder(i).intValue() + 1));
            arrayList.add(pdfDictionary);
        }
    }

    private ArrayList<PdfIndirectReference> findActiveParents(HashSet<RefKey> hashSet) {
        PdfObject pdfObject;
        ArrayList<PdfIndirectReference> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList(hashSet);
        for (int i = 0; i < arrayList2.size(); i++) {
            PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(arrayList2.get(i));
            if (pdfIndirectObject != null && pdfIndirectObject.object.isDictionary() && (pdfObject = ((PdfDictionary) pdfIndirectObject.object).get(PdfName.P)) != null && pdfObject.type() == 0) {
                PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) pdfObject;
                RefKey refKey = new RefKey(pdfIndirectReference);
                if (!hashSet.contains(refKey)) {
                    hashSet.add(refKey);
                    arrayList2.add(refKey);
                    arrayList.add(pdfIndirectReference);
                }
            }
        }
        return arrayList;
    }

    private void findActives(ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        PdfObject pdfObject;
        for (int i = 0; i < arrayList.size(); i++) {
            PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(new RefKey(arrayList.get(i)));
            if (pdfIndirectObject != null && (pdfObject = pdfIndirectObject.object) != null) {
                int iType = pdfObject.type();
                if (iType == 0) {
                    findActivesFromReference((PdfIndirectReference) pdfIndirectObject.object, arrayList, hashSet);
                } else if (iType == 5) {
                    findActivesFromArray((PdfArray) pdfIndirectObject.object, arrayList, hashSet, hashSet2);
                } else if (iType == 6 || iType == 7) {
                    findActivesFromDict((PdfDictionary) pdfIndirectObject.object, arrayList, hashSet, hashSet2);
                }
            }
        }
    }

    private void findActivesFromArray(PdfArray pdfArray, ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        for (PdfObject pdfObject : pdfArray) {
            int iType = pdfObject.type();
            if (iType == 0) {
                findActivesFromReference((PdfIndirectReference) pdfObject, arrayList, hashSet);
            } else if (iType == 5) {
                findActivesFromArray((PdfArray) pdfObject, arrayList, hashSet, hashSet2);
            } else if (iType == 6 || iType == 7) {
                findActivesFromDict((PdfDictionary) pdfObject, arrayList, hashSet, hashSet2);
            }
        }
    }

    private void findActivesFromDict(PdfDictionary pdfDictionary, ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        if (containsInactivePg(pdfDictionary, hashSet)) {
            return;
        }
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            PdfObject pdfObject = pdfDictionary.get(pdfName);
            if (!pdfName.equals(PdfName.P)) {
                if (!pdfName.equals(PdfName.C)) {
                    int iType = pdfObject.type();
                    if (iType == 0) {
                        findActivesFromReference((PdfIndirectReference) pdfObject, arrayList, hashSet);
                    } else if (iType == 5) {
                        findActivesFromArray((PdfArray) pdfObject, arrayList, hashSet, hashSet2);
                    } else if (iType == 6 || iType == 7) {
                        findActivesFromDict((PdfDictionary) pdfObject, arrayList, hashSet, hashSet2);
                    }
                } else if (pdfObject.isArray()) {
                    for (PdfObject pdfObject2 : (PdfArray) pdfObject) {
                        if (pdfObject2.isName()) {
                            hashSet2.add((PdfName) pdfObject2);
                        }
                    }
                } else if (pdfObject.isName()) {
                    hashSet2.add((PdfName) pdfObject);
                }
            }
        }
    }

    private void findActivesFromReference(PdfIndirectReference pdfIndirectReference, ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet) {
        RefKey refKey = new RefKey(pdfIndirectReference);
        PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(refKey);
        if ((pdfIndirectObject != null && pdfIndirectObject.object.isDictionary() && containsInactivePg((PdfDictionary) pdfIndirectObject.object, hashSet)) || hashSet.contains(refKey)) {
            return;
        }
        hashSet.add(refKey);
        arrayList.add(pdfIndirectReference);
    }

    private void fixPgKey(ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet) {
        PdfDictionary pdfDictionary;
        PdfObject pdfObject;
        PdfArray asArray;
        Iterator<PdfIndirectReference> it = arrayList.iterator();
        while (it.hasNext()) {
            PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(new RefKey(it.next()));
            if (pdfIndirectObject != null && pdfIndirectObject.object.isDictionary() && (pdfObject = (pdfDictionary = (PdfDictionary) pdfIndirectObject.object).get(PdfName.PG)) != null && !hashSet.contains(new RefKey((PdfIndirectReference) pdfObject)) && (asArray = pdfDictionary.getAsArray(PdfName.K)) != null) {
                int i = 0;
                while (i < asArray.size()) {
                    PdfObject pdfObject2 = asArray.getPdfObject(i);
                    if (pdfObject2.type() == 0) {
                        PdfIndirectObject pdfIndirectObject2 = this.indirectObjects.get(new RefKey((PdfIndirectReference) pdfObject2));
                        if (pdfIndirectObject2 != null && pdfIndirectObject2.object.isDictionary()) {
                            PdfDictionary pdfDictionary2 = (PdfDictionary) pdfIndirectObject2.object;
                            PdfName pdfName = PdfName.PG;
                            PdfObject pdfObject3 = pdfDictionary2.get(pdfName);
                            if (pdfObject3 != null && hashSet.contains(new RefKey((PdfIndirectReference) pdfObject3))) {
                                pdfDictionary.put(pdfName, pdfObject3);
                                break;
                            }
                        }
                    } else {
                        asArray.remove(i);
                        i--;
                    }
                    i++;
                }
            }
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
        return str.endsWith(".") ? str.substring(0, str.length() - 2) : str;
    }

    public static Integer getFlags(PdfDictionary pdfDictionary) {
        PdfNumber asNumber;
        if (PdfName.BTN.equals(pdfDictionary.getAsName(PdfName.FT)) && (asNumber = pdfDictionary.getAsNumber(PdfName.FF)) != null) {
            return Integer.valueOf(asNumber.intValue());
        }
        return null;
    }

    public static boolean isCheckButton(PdfDictionary pdfDictionary) {
        Integer flags = getFlags(pdfDictionary);
        return flags == null || ((flags.intValue() & 65536) == 0 && (flags.intValue() & 32768) == 0);
    }

    public static boolean isRadioButton(PdfDictionary pdfDictionary) {
        Integer flags = getFlags(pdfDictionary);
        return (flags == null || (flags.intValue() & 65536) != 0 || (flags.intValue() & 32768) == 0) ? false : true;
    }

    public static boolean isTextField(PdfDictionary pdfDictionary) {
        return PdfName.TX.equals(pdfDictionary.getAsName(PdfName.FT));
    }

    private void mergeField(String str, AcroFields.Item item) {
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
                        if (fieldKeys.contains(pdfName)) {
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
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                map.put(strNextToken, linkedHashMap);
                map = linkedHashMap;
            } else if (!(obj instanceof HashMap)) {
                return;
            } else {
                map = (HashMap) obj;
            }
        }
    }

    private void mergeFields() {
        int numberOfPages = 0;
        for (int i = 0; i < this.fields.size(); i++) {
            AcroFields acroFields = this.fields.get(i);
            Map<String, AcroFields.Item> fields = acroFields.getFields();
            if (numberOfPages < this.importedPages.size() && this.importedPages.get(numberOfPages).reader == acroFields.reader) {
                addPageOffsetToField(fields, numberOfPages);
                numberOfPages += acroFields.reader.getNumberOfPages();
            }
            mergeWithMaster(fields);
        }
    }

    private void mergeWithMaster(Map<String, AcroFields.Item> map) {
        for (Map.Entry<String, AcroFields.Item> entry : map.entrySet()) {
            mergeField(entry.getKey(), entry.getValue());
        }
    }

    private PdfObject propagate(PdfObject pdfObject) {
        if (pdfObject == null) {
            return new PdfNull();
        }
        if (pdfObject.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            for (int i = 0; i < pdfArray.size(); i++) {
                pdfArray.set(i, propagate(pdfArray.getPdfObject(i)));
            }
            return pdfArray;
        }
        if (!pdfObject.isDictionary() && !pdfObject.isStream()) {
            return pdfObject.isIndirect() ? addToBody(propagate(PdfReader.getPdfObject(pdfObject))).getIndirectReference() : pdfObject;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            pdfDictionary.put(pdfName, propagate(pdfDictionary.get(pdfName)));
        }
        return pdfDictionary;
    }

    private void removeInactiveReferences(PdfArray pdfArray, HashSet<RefKey> hashSet) {
        int i = 0;
        while (i < pdfArray.size()) {
            PdfObject pdfObject = pdfArray.getPdfObject(i);
            if ((pdfObject.type() == 0 && !hashSet.contains(new RefKey((PdfIndirectReference) pdfObject))) || (pdfObject.isDictionary() && containsInactivePg((PdfDictionary) pdfObject, hashSet))) {
                pdfArray.remove(i);
                i--;
            }
            i++;
        }
    }

    private void updateAnnotationReferences(PdfObject pdfObject) {
        PdfNumber asNumber;
        PdfIndirectObject pdfIndirectObject;
        PdfNumber asNumber2;
        PdfIndirectObject pdfIndirectObject2;
        if (pdfObject.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            for (int i = 0; i < pdfArray.size(); i++) {
                PdfObject pdfObject2 = pdfArray.getPdfObject(i);
                if (pdfObject2 == null || pdfObject2.type() != 0) {
                    updateAnnotationReferences(pdfObject2);
                } else {
                    PdfIndirectObject pdfIndirectObject3 = this.unmergedIndirectRefsMap.get(new RefKey((PdfIndirectReference) pdfObject2));
                    if (pdfIndirectObject3 != null && pdfIndirectObject3.object.isDictionary() && (asNumber2 = ((PdfDictionary) pdfIndirectObject3.object).getAsNumber(annotId)) != null && (pdfIndirectObject2 = this.mergedMap.get(Integer.valueOf(asNumber2.intValue()))) != null) {
                        pdfArray.set(i, pdfIndirectObject2.getIndirectReference());
                    }
                }
            }
            return;
        }
        if (pdfObject.isDictionary() || pdfObject.isStream()) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject3 = pdfDictionary.get(pdfName);
                if (pdfObject3 == null || pdfObject3.type() != 0) {
                    updateAnnotationReferences(pdfObject3);
                } else {
                    PdfIndirectObject pdfIndirectObject4 = this.unmergedIndirectRefsMap.get(new RefKey((PdfIndirectReference) pdfObject3));
                    if (pdfIndirectObject4 != null && pdfIndirectObject4.object.isDictionary() && (asNumber = ((PdfDictionary) pdfIndirectObject4.object).getAsNumber(annotId)) != null && (pdfIndirectObject = this.mergedMap.get(Integer.valueOf(asNumber.intValue()))) != null) {
                        pdfDictionary.put(pdfName, pdfIndirectObject.getIndirectReference());
                    }
                }
            }
        }
    }

    private void updateCalculationOrder(PdfReader pdfReader) {
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

    private void updateReferences(PdfObject pdfObject) {
        if (pdfObject.isDictionary() || pdfObject.isStream()) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject2 = pdfDictionary.get(pdfName);
                if (pdfObject2.isIndirect()) {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject2;
                    IndirectReferences indirectReferences = this.indirectMap.get(pRIndirectReference.getReader()).get(new RefKey(pRIndirectReference));
                    if (indirectReferences != null) {
                        pdfDictionary.put(pdfName, indirectReferences.getRef());
                    }
                } else {
                    updateReferences(pdfObject2);
                }
            }
            return;
        }
        if (pdfObject.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            for (int i = 0; i < pdfArray.size(); i++) {
                PdfObject pdfObject3 = pdfArray.getPdfObject(i);
                if (pdfObject3.isIndirect()) {
                    PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfObject3;
                    IndirectReferences indirectReferences2 = this.indirectMap.get(pRIndirectReference2.getReader()).get(new RefKey(pRIndirectReference2));
                    if (indirectReferences2 != null) {
                        pdfArray.set(i, indirectReferences2.getRef());
                    }
                } else {
                    updateReferences(pdfObject3);
                }
            }
        }
    }

    private void writeObjectToBody(PdfIndirectObject pdfIndirectObject) throws IOException {
        PdfDictionary pdfDictionary;
        PdfNumber asNumber;
        PdfNumber asNumber2;
        PdfIndirectObject pdfIndirectObject2;
        PdfNumber asNumber3;
        boolean z = false;
        if (this.mergeFields) {
            updateAnnotationReferences(pdfIndirectObject.object);
            if (pdfIndirectObject.object.isDictionary() || pdfIndirectObject.object.isStream()) {
                PdfDictionary pdfDictionary2 = (PdfDictionary) pdfIndirectObject.object;
                if (this.unmergedIndirectRefsMap.containsKey(new RefKey(pdfIndirectObject.number, pdfIndirectObject.generation)) && (asNumber3 = pdfDictionary2.getAsNumber(annotId)) != null && this.mergedMap.containsKey(Integer.valueOf(asNumber3.intValue()))) {
                    z = true;
                }
                if (this.mergedSet.contains(pdfIndirectObject) && (asNumber2 = pdfDictionary2.getAsNumber(annotId)) != null && (pdfIndirectObject2 = this.unmergedMap.get(Integer.valueOf(asNumber2.intValue()))) != null && pdfIndirectObject2.object.isDictionary()) {
                    PdfDictionary pdfDictionary3 = (PdfDictionary) pdfIndirectObject2.object;
                    PdfName pdfName = PdfName.STRUCTPARENT;
                    PdfNumber asNumber4 = pdfDictionary3.getAsNumber(pdfName);
                    if (asNumber4 != null) {
                        pdfDictionary2.put(pdfName, asNumber4);
                    }
                }
            }
        }
        if (z) {
            return;
        }
        if (this.mergeFields && pdfIndirectObject.object.isDictionary()) {
            pdfDictionary = (PdfDictionary) pdfIndirectObject.object;
            PdfName pdfName2 = annotId;
            asNumber = pdfDictionary.getAsNumber(pdfName2);
            if (asNumber != null) {
                pdfDictionary.remove(pdfName2);
            }
        } else {
            pdfDictionary = null;
            asNumber = null;
        }
        this.body.add(pdfIndirectObject.object, pdfIndirectObject.number, pdfIndirectObject.generation, true);
        if (asNumber != null) {
            pdfDictionary.put(annotId, asNumber);
        }
    }

    public PdfIndirectReference add(PdfOutline pdfOutline) {
        return null;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.interfaces.PdfAnnotations
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
    }

    public void addDocument(PdfReader pdfReader, List<Integer> list) throws DocumentException, BadPasswordException {
        if (this.indirectMap.containsKey(pdfReader)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("document.1.has.already.been.added", pdfReader.toString()));
        }
        pdfReader.selectPages(list, false);
        addDocument(pdfReader);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void addPage(PdfImportedPage pdfImportedPage) {
        if (this.mergeFields && !this.mergeFieldsInternalCall) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "addPage"));
        }
        int fromIPage = setFromIPage(pdfImportedPage);
        PdfDictionary pageN = this.reader.getPageN(fromIPage);
        PRIndirectReference pageOrigRef = this.reader.getPageOrigRef(fromIPage);
        this.reader.releasePage(fromIPage);
        RefKey refKey = new RefKey(pageOrigRef);
        IndirectReferences indirectReferences = this.indirects.get(refKey);
        if (indirectReferences != null && !indirectReferences.getCopied()) {
            this.pageReferences.add(indirectReferences.getRef());
            indirectReferences.setCopied();
        }
        PdfIndirectReference currentPage = getCurrentPage();
        if (indirectReferences == null) {
            indirectReferences = new IndirectReferences(currentPage);
            this.indirects.put(refKey, indirectReferences);
        }
        indirectReferences.setCopied();
        if (this.tagged) {
            this.structTreeRootReference = (PRIndirectReference) this.reader.getCatalog().get(PdfName.STRUCTTREEROOT);
        }
        PdfDictionary pdfDictionaryCopyDictionary = copyDictionary(pageN);
        if (this.mergeFields) {
            ArrayList<ImportedPage> arrayList = this.importedPages;
            ImportedPage importedPage = arrayList.get(arrayList.size() - 1);
            PdfIndirectReference pdfIndirectReference = this.body.getPdfIndirectReference();
            importedPage.annotsIndirectReference = pdfIndirectReference;
            pdfDictionaryCopyDictionary.put(PdfName.ANNOTS, pdfIndirectReference);
        }
        this.root.addPage(pdfDictionaryCopyDictionary);
        pdfImportedPage.setCopied();
        int i = this.currentPageNumber + 1;
        this.currentPageNumber = i;
        this.pdf.setPageCount(i);
        this.structTreeRootReference = null;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectObject addToBody(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) {
        return addToBody(pdfObject, pdfIndirectReference, false);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void cacheObject(PdfIndirectObject pdfIndirectObject) {
        if ((this.tagged || this.mergeFields) && this.indirectObjects != null) {
            this.savedObjects.add(pdfIndirectObject);
            RefKey refKey = new RefKey(pdfIndirectObject.number, pdfIndirectObject.generation);
            if (this.indirectObjects.containsKey(refKey)) {
                return;
            }
            this.indirectObjects.put(refKey, pdfIndirectObject);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.DocWriter, com.itextpdf.text.DocListener
    public void close() {
        if (this.open) {
            this.pdf.close();
            super.close();
        }
    }

    public PdfArray copyArray(PdfArray pdfArray, boolean z, boolean z2) {
        PdfArray pdfArray2 = new PdfArray(pdfArray.size());
        ListIterator<PdfObject> listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            PdfObject next = listIterator.next();
            this.parentObjects.put(next, pdfArray);
            PdfObject pdfObjectCopyObject = copyObject(next, z, z2);
            if (pdfObjectCopyObject != null) {
                pdfArray2.add(pdfObjectCopyObject);
            }
        }
        return pdfArray2;
    }

    public PdfDictionary copyDictionary(PdfDictionary pdfDictionary, boolean z, boolean z2) {
        PdfDictionary pdfDictionary2 = new PdfDictionary(pdfDictionary.size());
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.TYPE));
        if (z) {
            if (z2 && pdfDictionary.contains(PdfName.PG)) {
                this.disableIndirects.add(pdfDictionary);
                PdfObject pdfObject = pdfDictionary;
                while (this.parentObjects.containsKey(pdfObject) && !this.disableIndirects.contains(pdfObject)) {
                    PdfObject pdfObject2 = this.parentObjects.get(pdfObject);
                    this.disableIndirects.add(pdfObject2);
                    pdfObject = pdfObject2;
                }
                return null;
            }
            this.structTreeController.addRole(pdfDictionary.getAsName(PdfName.S));
            this.structTreeController.addClass(pdfDictionary);
        }
        PdfStructTreeController pdfStructTreeController = this.structTreeController;
        if (pdfStructTreeController != null && pdfStructTreeController.reader != null) {
            PdfName pdfName = PdfName.STRUCTPARENTS;
            if (pdfDictionary.contains(pdfName) || pdfDictionary.contains(PdfName.STRUCTPARENT)) {
                PdfName pdfName2 = PdfName.STRUCTPARENT;
                if (!pdfDictionary.contains(pdfName)) {
                    pdfName = pdfName2;
                }
                PdfObject pdfObject3 = pdfDictionary.get(pdfName);
                pdfDictionary2.put(pdfName, new PdfNumber(this.currentStructArrayNumber));
                int i = this.currentStructArrayNumber;
                this.currentStructArrayNumber = i + 1;
                this.structTreeController.copyStructTreeForPage((PdfNumber) pdfObject3, i);
            }
        }
        for (PdfName pdfName3 : pdfDictionary.getKeys()) {
            PdfObject pdfObject4 = pdfDictionary.get(pdfName3);
            PdfStructTreeController pdfStructTreeController2 = this.structTreeController;
            if (pdfStructTreeController2 == null || pdfStructTreeController2.reader == null || (!pdfName3.equals(PdfName.STRUCTPARENTS) && !pdfName3.equals(PdfName.STRUCTPARENT))) {
                if (!PdfName.PAGE.equals(pdfObjectRelease)) {
                    PdfObject reference = (this.tagged && pdfObject4.isIndirect() && isStructTreeRootReference((PRIndirectReference) pdfObject4)) ? this.structureTreeRoot.getReference() : copyObject(pdfObject4, z, z2);
                    if (reference != null) {
                        pdfDictionary2.put(pdfName3, reference);
                    }
                } else if (!pdfName3.equals(PdfName.B) && !pdfName3.equals(PdfName.PARENT)) {
                    this.parentObjects.put(pdfObject4, pdfDictionary);
                    PdfObject pdfObjectCopyObject = copyObject(pdfObject4, z, z2);
                    if (pdfObjectCopyObject != null) {
                        pdfDictionary2.put(pdfName3, pdfObjectCopyObject);
                    }
                }
            }
        }
        return pdfDictionary2;
    }

    public void copyDocumentFields(PdfReader pdfReader) throws DocumentException, BadPasswordException {
        PdfStructTreeController pdfStructTreeController;
        PdfArray asArray;
        if (!this.document.isOpen()) {
            throw new DocumentException(MessageLocalization.getComposedMessage("the.document.is.not.open.yet.you.can.only.add.meta.information", new Object[0]));
        }
        if (this.indirectMap.containsKey(pdfReader)) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("document.1.has.already.been.added", pdfReader.toString()));
        }
        if (!pdfReader.isOpenedWithFullPermissions()) {
            throw new BadPasswordException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
        }
        if (!this.mergeFields) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.method.can.be.only.used.in.mergeFields.mode.please.use.addDocument", "copyDocumentFields"));
        }
        HashMap<RefKey, IndirectReferences> map = new HashMap<>();
        this.indirects = map;
        this.indirectMap.put(pdfReader, map);
        pdfReader.consolidateNamedDestinations();
        pdfReader.shuffleSubsetNames();
        if (this.tagged && PdfStructTreeController.checkTagged(pdfReader)) {
            this.structTreeRootReference = (PRIndirectReference) pdfReader.getCatalog().get(PdfName.STRUCTTREEROOT);
            PdfStructTreeController pdfStructTreeController2 = this.structTreeController;
            if (pdfStructTreeController2 == null) {
                this.structTreeController = new PdfStructTreeController(pdfReader, this);
            } else if (pdfReader != pdfStructTreeController2.reader) {
                pdfStructTreeController2.setReader(pdfReader);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
            PdfDictionary pageNRelease = pdfReader.getPageNRelease(i);
            if (pageNRelease != null) {
                PdfName pdfName = PdfName.ANNOTS;
                if (pageNRelease.contains(pdfName) && (asArray = pageNRelease.getAsArray(pdfName)) != null && asArray.size() > 0) {
                    if (this.importedPages.size() < i) {
                        throw new DocumentException(MessageLocalization.getComposedMessage("there.are.not.enough.imported.pages.for.copied.fields", new Object[0]));
                    }
                    this.indirectMap.get(pdfReader).put(new RefKey(pdfReader.pageRefs.getPageOrigRef(i)), new IndirectReferences(this.pageReferences.get(i - 1)));
                    for (int i2 = 0; i2 < asArray.size(); i2++) {
                        PdfDictionary asDict = asArray.getAsDict(i2);
                        if (asDict != null) {
                            PdfName pdfName2 = annotId;
                            int i3 = annotIdCnt + 1;
                            annotIdCnt = i3;
                            asDict.put(pdfName2, new PdfNumber(i3));
                            arrayList.add(asArray.getPdfObject(i2));
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            copyObject((PdfObject) it.next());
        }
        if (this.tagged && (pdfStructTreeController = this.structTreeController) != null) {
            pdfStructTreeController.attachStructTreeRootKids(null);
        }
        AcroFields acroFields = pdfReader.getAcroFields();
        if (!acroFields.isGenerateAppearances()) {
            this.needAppearances = true;
        }
        this.fields.add(acroFields);
        updateCalculationOrder(pdfReader);
        this.structTreeRootReference = null;
    }

    public PdfIndirectReference copyIndirect(PRIndirectReference pRIndirectReference, boolean z, boolean z2) {
        PdfIndirectReference pdfIndirectReference;
        PdfObject pdfObjectRelease;
        RefKey refKey = new RefKey(pRIndirectReference);
        IndirectReferences indirectReferences = this.indirects.get(refKey);
        PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(pRIndirectReference);
        if (z && z2 && (pdfObjectRelease2 instanceof PdfDictionary) && ((PdfDictionary) pdfObjectRelease2).contains(PdfName.PG)) {
            return null;
        }
        if (indirectReferences != null) {
            pdfIndirectReference = indirectReferences.getRef();
            if (indirectReferences.getCopied()) {
                return pdfIndirectReference;
            }
        } else {
            pdfIndirectReference = this.body.getPdfIndirectReference();
            indirectReferences = new IndirectReferences(pdfIndirectReference);
            this.indirects.put(refKey, indirectReferences);
        }
        if (pdfObjectRelease2 != null && pdfObjectRelease2.isDictionary() && (pdfObjectRelease = PdfReader.getPdfObjectRelease(((PdfDictionary) pdfObjectRelease2).get(PdfName.TYPE))) != null) {
            if (PdfName.PAGE.equals(pdfObjectRelease)) {
                return pdfIndirectReference;
            }
            if (PdfName.CATALOG.equals(pdfObjectRelease)) {
                LOGGER.warn(MessageLocalization.getComposedMessage("make.copy.of.catalog.dictionary.is.forbidden", new Object[0]));
                return null;
            }
        }
        indirectReferences.setCopied();
        if (pdfObjectRelease2 != null) {
            this.parentObjects.put(pdfObjectRelease2, pRIndirectReference);
        }
        PdfObject pdfObjectCopyObject = copyObject(pdfObjectRelease2, z, z2);
        if (this.disableIndirects.contains(pdfObjectRelease2)) {
            indirectReferences.setNotCopied();
        }
        if (pdfObjectCopyObject != null) {
            addToBody(pdfObjectCopyObject, pdfIndirectReference);
            return pdfIndirectReference;
        }
        this.indirects.remove(refKey);
        return null;
    }

    public PdfObject copyObject(PdfObject pdfObject, boolean z, boolean z2) {
        if (pdfObject == null) {
            return PdfNull.PDFNULL;
        }
        int i = pdfObject.type;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 8:
                return pdfObject;
            case 5:
                return copyArray((PdfArray) pdfObject, z, z2);
            case 6:
                return copyDictionary((PdfDictionary) pdfObject, z, z2);
            case 7:
                return copyStream((PRStream) pdfObject);
            case 9:
            default:
                if (i < 0) {
                    String string = ((PdfLiteral) pdfObject).toString();
                    return (string.equals(PdfBoolean.TRUE) || string.equals(PdfBoolean.FALSE)) ? new PdfBoolean(string) : new PdfLiteral(string);
                }
                System.out.println("CANNOT COPY type " + pdfObject.type);
                return null;
            case 10:
                return (z || z2) ? copyIndirect((PRIndirectReference) pdfObject, z, z2) : copyIndirect((PRIndirectReference) pdfObject);
        }
    }

    public PdfStream copyStream(PRStream pRStream) {
        PRStream pRStream2 = new PRStream(pRStream, (PdfDictionary) null);
        for (PdfName pdfName : pRStream.getKeys()) {
            PdfObject pdfObject = pRStream.get(pdfName);
            this.parentObjects.put(pdfObject, pRStream);
            PdfObject pdfObjectCopyObject = copyObject(pdfObject);
            if (pdfObjectCopyObject != null) {
                pRStream2.put(pdfName, pdfObjectCopyObject);
            }
        }
        return pRStream2;
    }

    public PageStamp createPageStamp(PdfImportedPage pdfImportedPage) {
        int pageNumber = pdfImportedPage.getPageNumber();
        PdfReader reader = pdfImportedPage.getPdfReaderInstance().getReader();
        if (isTagged()) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("creating.page.stamp.not.allowed.for.tagged.reader", new Object[0]));
        }
        return new PageStamp(reader, reader.getPageN(pageNumber), this);
    }

    public void fixStructureTreeRoot(HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        HashMap<PdfName, PdfObject> map = new HashMap<>(hashSet2.size());
        for (PdfName pdfName : hashSet2) {
            PdfObject pdfObject = this.structureTreeRoot.classes.get(pdfName);
            if (pdfObject != null) {
                map.put(pdfName, pdfObject);
            }
        }
        PdfStructureTreeRoot pdfStructureTreeRoot = this.structureTreeRoot;
        pdfStructureTreeRoot.classes = map;
        PdfArray asArray = pdfStructureTreeRoot.getAsArray(PdfName.K);
        if (asArray != null) {
            int i = 0;
            while (i < asArray.size()) {
                if (!hashSet.contains(new RefKey((PdfIndirectReference) asArray.getPdfObject(i)))) {
                    asArray.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4, types: [com.itextpdf.text.pdf.PdfIndirectReference, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.itextpdf.text.pdf.PdfCopy, com.itextpdf.text.pdf.PdfWriter] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public void fixTaggedStructure() {
        PdfObject pdfObject;
        PdfDictionary kDict;
        PdfIndirectReference pdfIndirectReference;
        HashMap<Integer, PdfIndirectReference> numTree = this.structureTreeRoot.getNumTree();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        if (this.mergeFields && (pdfIndirectReference = this.acroForm) != null) {
            arrayList.add(pdfIndirectReference);
            hashSet.add(new RefKey(this.acroForm));
        }
        for (PdfIndirectReference pdfIndirectReference2 : this.pageReferences) {
            arrayList.add(pdfIndirectReference2);
            hashSet.add(new RefKey(pdfIndirectReference2));
        }
        int size = numTree.size() - 1;
        int i = 0;
        while (true) {
            ?? r6 = 0;
            if (size < 0) {
                break;
            }
            PdfIndirectReference pdfIndirectReference3 = numTree.get(Integer.valueOf(size));
            if (pdfIndirectReference3 != null) {
                RefKey refKey = new RefKey(pdfIndirectReference3);
                PdfObject pdfObject2 = this.indirectObjects.get(refKey).object;
                if (pdfObject2.isDictionary()) {
                    ArrayList<PdfIndirectReference> arrayList2 = this.pageReferences;
                    PdfDictionary pdfDictionary = (PdfDictionary) pdfObject2;
                    PdfName pdfName = PdfName.PG;
                    if (!arrayList2.contains(pdfDictionary.get(pdfName)) && ((kDict = PdfStructTreeController.getKDict(pdfDictionary)) == null || !this.pageReferences.contains(kDict.get(pdfName)))) {
                        numTree.remove(Integer.valueOf(size));
                    } else {
                        hashSet.add(refKey);
                        arrayList.add(pdfIndirectReference3);
                    }
                } else if (pdfObject2.isArray()) {
                    hashSet.add(refKey);
                    arrayList.add(pdfIndirectReference3);
                    PdfArray pdfArray = (PdfArray) pdfObject2;
                    int i2 = i + 1;
                    PdfIndirectReference pdfIndirectReference4 = this.pageReferences.get(i);
                    arrayList.add(pdfIndirectReference4);
                    hashSet.add(new RefKey(pdfIndirectReference4));
                    int i3 = 0;
                    while (i3 < pdfArray.size()) {
                        ?? r10 = (PdfIndirectReference) pdfArray.getDirectObject(i3);
                        if (!r10.equals(r6)) {
                            RefKey refKey2 = new RefKey((PdfIndirectReference) r10);
                            hashSet.add(refKey2);
                            arrayList.add(r10);
                            PdfIndirectObject pdfIndirectObject = this.indirectObjects.get(refKey2);
                            if (pdfIndirectObject.object.isDictionary()) {
                                PdfDictionary pdfDictionary2 = (PdfDictionary) pdfIndirectObject.object;
                                PdfName pdfName2 = PdfName.PG;
                                PdfIndirectReference pdfIndirectReference5 = (PdfIndirectReference) pdfDictionary2.get(pdfName2);
                                if (pdfIndirectReference5 != null && !this.pageReferences.contains(pdfIndirectReference5) && !pdfIndirectReference5.equals(pdfIndirectReference4)) {
                                    pdfDictionary2.put(pdfName2, pdfIndirectReference4);
                                    PdfArray asArray = pdfDictionary2.getAsArray(PdfName.K);
                                    if (asArray != null && asArray.getDirectObject(0).isNumber()) {
                                        asArray.remove(0);
                                    }
                                }
                            }
                            r6 = r10;
                        }
                        i3++;
                        r6 = r6;
                    }
                    i = i2;
                }
            }
            size--;
        }
        HashSet hashSet2 = new HashSet();
        findActives(arrayList, hashSet, hashSet2);
        fixPgKey(findActiveParents(hashSet), hashSet);
        fixStructureTreeRoot(hashSet, hashSet2);
        for (Map.Entry<RefKey, PdfIndirectObject> entry : this.indirectObjects.entrySet()) {
            if (!hashSet.contains(entry.getKey())) {
                entry.setValue(null);
            } else if (entry.getValue().object.isArray()) {
                removeInactiveReferences((PdfArray) entry.getValue().object, hashSet);
            } else if (entry.getValue().object.isDictionary() && (pdfObject = ((PdfDictionary) entry.getValue().object).get(PdfName.K)) != null && pdfObject.isArray()) {
                removeInactiveReferences((PdfArray) pdfObject, hashSet);
            }
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void flushAcroFields() throws IOException {
        PdfArray asArray;
        if (this.mergeFields) {
            try {
                for (ImportedPage importedPage : this.importedPages) {
                    PdfDictionary pageN = importedPage.reader.getPageN(importedPage.pageNumber);
                    if (pageN != null && (asArray = pageN.getAsArray(PdfName.ANNOTS)) != null && asArray.size() != 0) {
                        Iterator<AcroFields.Item> it = importedPage.reader.getAcroFields().getFields().values().iterator();
                        while (it.hasNext()) {
                            Iterator<PdfIndirectReference> it2 = it.next().widget_refs.iterator();
                            while (it2.hasNext()) {
                                asArray.arrayList.remove(it2.next());
                            }
                        }
                        this.indirects = this.indirectMap.get(importedPage.reader);
                        Iterator<PdfObject> it3 = asArray.arrayList.iterator();
                        while (it3.hasNext()) {
                            importedPage.mergedFields.add(copyObject(it3.next()));
                        }
                    }
                }
                Iterator<PdfReader> it4 = this.indirectMap.keySet().iterator();
                while (it4.hasNext()) {
                    it4.next().removeFields();
                }
                mergeFields();
                createAcroForms();
            } catch (ClassCastException unused) {
            } finally {
                if (!this.tagged) {
                    flushIndirectObjects();
                }
            }
        }
    }

    public void flushIndirectObjects() throws IOException {
        for (PdfIndirectObject pdfIndirectObject : this.savedObjects) {
            this.indirectObjects.remove(new RefKey(pdfIndirectObject.number, pdfIndirectObject.generation));
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry<RefKey, PdfIndirectObject> entry : this.indirectObjects.entrySet()) {
            if (entry.getValue() != null) {
                writeObjectToBody(entry.getValue());
            } else {
                hashSet.add(entry.getKey());
            }
        }
        for (PdfWriter.PdfBody.PdfCrossReference pdfCrossReference : new ArrayList(this.body.xrefs)) {
            if (hashSet.contains(new RefKey(pdfCrossReference.getRefnum(), 0))) {
                this.body.xrefs.remove(pdfCrossReference);
            }
        }
        this.indirectObjects = null;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void flushTaggedObjects() throws IOException {
        try {
            fixTaggedStructure();
        } catch (ClassCastException unused) {
        } finally {
            flushIndirectObjects();
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void freeReader(PdfReader pdfReader) {
        if (this.mergeFields) {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("it.is.not.possible.to.free.reader.in.merge.fields.mode", new Object[0]));
        }
        PdfArray asArray = pdfReader.trailer.getAsArray(PdfName.ID);
        if (asArray != null) {
            this.originalFileID = asArray.getAsString(0).getBytes();
        }
        this.indirectMap.remove(pdfReader);
        this.currentPdfReaderInstance = null;
        super.freeReader(pdfReader);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        PdfIndirectReference pdfIndirectReference2;
        try {
            PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
            buildStructTreeRootForTagged(catalog);
            if (this.fieldArray != null) {
                addFieldResources(catalog);
            } else if (this.mergeFields && (pdfIndirectReference2 = this.acroForm) != null) {
                catalog.put(PdfName.ACROFORM, pdfIndirectReference2);
            }
            return catalog;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public Counter getCounter() {
        return COUNTER;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        boolean z = this.mergeFields;
        if (z && !this.mergeFieldsInternalCall) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "getImportedPage"));
        }
        if (z) {
            this.importedPages.add(new ImportedPage(pdfReader, i, z));
        }
        PdfStructTreeController pdfStructTreeController = this.structTreeController;
        if (pdfStructTreeController != null) {
            pdfStructTreeController.reader = null;
        }
        this.disableIndirects.clear();
        this.parentObjects.clear();
        return getImportedPageImpl(pdfReader, i);
    }

    public PdfImportedPage getImportedPageImpl(PdfReader pdfReader, int i) {
        PdfReaderInstance pdfReaderInstance = this.currentPdfReaderInstance;
        if (pdfReaderInstance == null || pdfReaderInstance.getReader() != pdfReader) {
            this.currentPdfReaderInstance = super.getPdfReaderInstance(pdfReader);
        }
        return this.currentPdfReaderInstance.getImportedPage(i);
    }

    public PdfName getOffStateName(PdfDictionary pdfDictionary) {
        return PdfName.Off;
    }

    public boolean isRotateContents() {
        return this.rotateContents;
    }

    public boolean isStructTreeRootReference(PdfIndirectReference pdfIndirectReference) {
        PRIndirectReference pRIndirectReference;
        return pdfIndirectReference != null && (pRIndirectReference = this.structTreeRootReference) != null && pdfIndirectReference.number == pRIndirectReference.number && pdfIndirectReference.generation == pRIndirectReference.generation;
    }

    public int setFromIPage(PdfImportedPage pdfImportedPage) {
        int pageNumber = pdfImportedPage.getPageNumber();
        PdfReaderInstance pdfReaderInstance = pdfImportedPage.getPdfReaderInstance();
        this.currentPdfReaderInstance = pdfReaderInstance;
        PdfReader reader = pdfReaderInstance.getReader();
        this.reader = reader;
        setFromReader(reader);
        return pageNumber;
    }

    public void setFromReader(PdfReader pdfReader) {
        this.reader = pdfReader;
        HashMap<RefKey, IndirectReferences> map = this.indirectMap.get(pdfReader);
        this.indirects = map;
        if (map == null) {
            HashMap<RefKey, IndirectReferences> map2 = new HashMap<>();
            this.indirects = map2;
            this.indirectMap.put(pdfReader, map2);
        }
    }

    public void setMergeFields() {
        this.mergeFields = true;
        this.resources = new PdfDictionary();
        this.fields = new ArrayList<>();
        this.calculationOrder = new ArrayList<>();
        this.fieldTree = new LinkedHashMap();
        this.unmergedMap = new HashMap<>();
        this.unmergedIndirectRefsMap = new HashMap<>();
        this.mergedMap = new HashMap<>();
        this.mergedSet = new HashSet<>();
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public void setPageEvent(PdfPageEvent pdfPageEvent) {
        throw new UnsupportedOperationException();
    }

    public void setRotateContents(boolean z) {
        this.rotateContents = z;
    }

    public void structureTreeRootKidsForReaderImported(PdfReader pdfReader) {
        this.readersWithImportedStructureTreeRootKids.add(pdfReader);
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectReference add(PdfPage pdfPage, PdfContents pdfContents) {
        return null;
    }

    @Override // com.itextpdf.text.pdf.PdfWriter
    public PdfIndirectObject addToBody(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) {
        PdfIndirectObject pdfIndirectObject;
        PdfNumber asNumber;
        if (z) {
            updateReferences(pdfObject);
        }
        if ((this.tagged || this.mergeFields) && this.indirectObjects != null && (pdfObject.isArray() || pdfObject.isDictionary() || pdfObject.isStream() || pdfObject.isNull())) {
            RefKey refKey = new RefKey(pdfIndirectReference);
            pdfIndirectObject = this.indirectObjects.get(refKey);
            if (pdfIndirectObject == null) {
                pdfIndirectObject = new PdfIndirectObject(pdfIndirectReference, pdfObject, this);
                this.indirectObjects.put(refKey, pdfIndirectObject);
            }
        } else {
            pdfIndirectObject = super.addToBody(pdfObject, pdfIndirectReference);
        }
        if (this.mergeFields && pdfObject.isDictionary() && (asNumber = ((PdfDictionary) pdfObject).getAsNumber(annotId)) != null) {
            if (z) {
                this.mergedMap.put(Integer.valueOf(asNumber.intValue()), pdfIndirectObject);
                this.mergedSet.add(pdfIndirectObject);
            } else {
                this.unmergedMap.put(Integer.valueOf(asNumber.intValue()), pdfIndirectObject);
                this.unmergedIndirectRefsMap.put(new RefKey(pdfIndirectObject.number, pdfIndirectObject.generation), pdfIndirectObject);
            }
        }
        return pdfIndirectObject;
    }

    public void addDocument(PdfReader pdfReader) throws DocumentException, BadPasswordException {
        PdfArray asArray;
        if (this.document.isOpen()) {
            if (!this.indirectMap.containsKey(pdfReader)) {
                if (pdfReader.isOpenedWithFullPermissions()) {
                    if (this.mergeFields) {
                        pdfReader.consolidateNamedDestinations();
                        pdfReader.shuffleSubsetNames();
                        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                            PdfDictionary pageNRelease = pdfReader.getPageNRelease(i);
                            if (pageNRelease != null) {
                                PdfName pdfName = PdfName.ANNOTS;
                                if (pageNRelease.contains(pdfName) && (asArray = pageNRelease.getAsArray(pdfName)) != null) {
                                    for (int i2 = 0; i2 < asArray.size(); i2++) {
                                        PdfDictionary asDict = asArray.getAsDict(i2);
                                        if (asDict != null) {
                                            PdfName pdfName2 = annotId;
                                            int i3 = annotIdCnt + 1;
                                            annotIdCnt = i3;
                                            asDict.put(pdfName2, new PdfNumber(i3));
                                        }
                                    }
                                }
                            }
                        }
                        AcroFields acroFields = pdfReader.getAcroFields();
                        if (!acroFields.isGenerateAppearances()) {
                            this.needAppearances = true;
                        }
                        this.fields.add(acroFields);
                        updateCalculationOrder(pdfReader);
                    }
                    boolean z = this.tagged && PdfStructTreeController.checkTagged(pdfReader);
                    this.mergeFieldsInternalCall = true;
                    for (int i4 = 1; i4 <= pdfReader.getNumberOfPages(); i4++) {
                        addPage(getImportedPage(pdfReader, i4, z));
                    }
                    this.mergeFieldsInternalCall = false;
                    return;
                }
                throw new BadPasswordException(MessageLocalization.getComposedMessage("pdfreader.not.opened.with.owner.password", new Object[0]));
            }
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("document.1.has.already.been.added", pdfReader.toString()));
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("the.document.is.not.open.yet.you.can.only.add.meta.information", new Object[0]));
    }

    public PdfArray copyArray(PdfArray pdfArray) {
        return copyArray(pdfArray, false, false);
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i, boolean z) {
        boolean z2 = this.mergeFields;
        if (z2 && !this.mergeFieldsInternalCall) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "getImportedPage"));
        }
        this.updateRootKids = false;
        if (!z) {
            if (z2) {
                this.importedPages.add(new ImportedPage(pdfReader, i, z2));
            }
            return getImportedPageImpl(pdfReader, i);
        }
        PdfStructTreeController pdfStructTreeController = this.structTreeController;
        if (pdfStructTreeController != null) {
            if (pdfReader != pdfStructTreeController.reader) {
                pdfStructTreeController.setReader(pdfReader);
            }
        } else {
            this.structTreeController = new PdfStructTreeController(pdfReader, this);
        }
        ImportedPage importedPage = new ImportedPage(pdfReader, i, this.mergeFields);
        int iCheckStructureTreeRootKids = checkStructureTreeRootKids(importedPage);
        if (iCheckStructureTreeRootKids == -1) {
            clearIndirects(pdfReader);
            this.updateRootKids = true;
        } else if (iCheckStructureTreeRootKids == 0) {
            this.updateRootKids = false;
        } else if (iCheckStructureTreeRootKids == 1) {
            this.updateRootKids = true;
        }
        this.importedPages.add(importedPage);
        this.disableIndirects.clear();
        this.parentObjects.clear();
        return getImportedPageImpl(pdfReader, i);
    }

    public PdfObject copyObject(PdfObject pdfObject) {
        return copyObject(pdfObject, false, false);
    }

    public PdfIndirectReference copyIndirect(PRIndirectReference pRIndirectReference) {
        return copyIndirect(pRIndirectReference, false, false);
    }

    public void addPage(Rectangle rectangle, int i) {
        if (this.mergeFields && !this.mergeFieldsInternalCall) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "addPage"));
        }
        PdfPage pdfPage = new PdfPage(new PdfRectangle(rectangle, i), new HashMap(), new PageResources().getResources(), 0);
        pdfPage.put(PdfName.TABS, getTabs());
        this.root.addPage(pdfPage);
        int i2 = this.currentPageNumber + 1;
        this.currentPageNumber = i2;
        this.pdf.setPageCount(i2);
    }

    public PdfDictionary copyDictionary(PdfDictionary pdfDictionary) {
        return copyDictionary(pdfDictionary, false, false);
    }
}
