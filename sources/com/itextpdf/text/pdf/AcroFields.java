package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.io.RASInputStream;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.io.WindowRandomAccessSource;
import com.itextpdf.text.pdf.codec.Base64;
import com.itextpdf.text.pdf.security.PdfPKCS7;
import com.itextpdf.text.xml.XmlToTxt;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public class AcroFields {
    public static final int DA_COLOR = 2;
    public static final int DA_FONT = 0;
    public static final int DA_SIZE = 1;
    public static final int FIELD_TYPE_CHECKBOX = 2;
    public static final int FIELD_TYPE_COMBO = 6;
    public static final int FIELD_TYPE_LIST = 5;
    public static final int FIELD_TYPE_NONE = 0;
    public static final int FIELD_TYPE_PUSHBUTTON = 1;
    public static final int FIELD_TYPE_RADIOBUTTON = 3;
    public static final int FIELD_TYPE_SIGNATURE = 7;
    public static final int FIELD_TYPE_TEXT = 4;
    private static final PdfName[] buttonRemove;
    private static final HashMap<String, String[]> stdFieldFontNames;
    private boolean append;
    private float extraMarginLeft;
    private float extraMarginTop;
    private Map<String, TextField> fieldCache;
    Map<String, Item> fields;
    private boolean lastWasString;
    private ArrayList<String> orderedSignatureNames;
    PdfReader reader;
    private HashMap<String, int[]> sigNames;
    private ArrayList<BaseFont> substitutionFonts;
    private int topFirst;
    private int totalRevisions;
    PdfWriter writer;
    private XfaForm xfa;
    private HashMap<Integer, BaseFont> extensionFonts = new HashMap<>();
    private boolean generateAppearances = true;
    private HashMap<String, BaseFont> localFonts = new HashMap<>();

    public static class FieldPosition {
        public int page;
        public Rectangle position;
    }

    public static class InstHit {
        IntHashtable hits;

        public InstHit(int[] iArr) {
            if (iArr == null) {
                return;
            }
            this.hits = new IntHashtable();
            for (int i : iArr) {
                this.hits.put(i, 1);
            }
        }

        public boolean isHit(int i) {
            IntHashtable intHashtable = this.hits;
            if (intHashtable == null) {
                return true;
            }
            return intHashtable.containsKey(i);
        }
    }

    public static class Item {
        public static final int WRITE_MERGED = 1;
        public static final int WRITE_VALUE = 4;
        public static final int WRITE_WIDGET = 2;
        protected ArrayList<PdfDictionary> values = new ArrayList<>();
        protected ArrayList<PdfDictionary> widgets = new ArrayList<>();
        protected ArrayList<PdfIndirectReference> widget_refs = new ArrayList<>();
        protected ArrayList<PdfDictionary> merged = new ArrayList<>();
        protected ArrayList<Integer> page = new ArrayList<>();
        protected ArrayList<Integer> tabOrder = new ArrayList<>();

        public void addMerged(PdfDictionary pdfDictionary) {
            this.merged.add(pdfDictionary);
        }

        public void addPage(int i) {
            this.page.add(Integer.valueOf(i));
        }

        public void addTabOrder(int i) {
            this.tabOrder.add(Integer.valueOf(i));
        }

        public void addValue(PdfDictionary pdfDictionary) {
            this.values.add(pdfDictionary);
        }

        public void addWidget(PdfDictionary pdfDictionary) {
            this.widgets.add(pdfDictionary);
        }

        public void addWidgetRef(PdfIndirectReference pdfIndirectReference) {
            this.widget_refs.add(pdfIndirectReference);
        }

        public void forcePage(int i, int i2) {
            this.page.set(i, Integer.valueOf(i2));
        }

        public PdfDictionary getMerged(int i) {
            return this.merged.get(i);
        }

        public Integer getPage(int i) {
            return this.page.get(i);
        }

        public Integer getTabOrder(int i) {
            return this.tabOrder.get(i);
        }

        public PdfDictionary getValue(int i) {
            return this.values.get(i);
        }

        public PdfDictionary getWidget(int i) {
            return this.widgets.get(i);
        }

        public PdfIndirectReference getWidgetRef(int i) {
            return this.widget_refs.get(i);
        }

        public void markUsed(AcroFields acroFields, int i) {
            if ((i & 4) != 0) {
                for (int i2 = 0; i2 < size(); i2++) {
                    acroFields.markUsed(getValue(i2));
                }
            }
            if ((i & 2) != 0) {
                for (int i3 = 0; i3 < size(); i3++) {
                    acroFields.markUsed(getWidget(i3));
                }
            }
        }

        public void remove(int i) {
            this.values.remove(i);
            this.widgets.remove(i);
            this.widget_refs.remove(i);
            this.merged.remove(i);
            this.page.remove(i);
            this.tabOrder.remove(i);
        }

        public int size() {
            return this.values.size();
        }

        public void writeToAll(PdfName pdfName, PdfObject pdfObject, int i) {
            if ((i & 1) != 0) {
                for (int i2 = 0; i2 < this.merged.size(); i2++) {
                    getMerged(i2).put(pdfName, pdfObject);
                }
            }
            if ((i & 2) != 0) {
                for (int i3 = 0; i3 < this.widgets.size(); i3++) {
                    getWidget(i3).put(pdfName, pdfObject);
                }
            }
            if ((i & 4) != 0) {
                for (int i4 = 0; i4 < this.values.size(); i4++) {
                    getValue(i4).put(pdfName, pdfObject);
                }
            }
        }
    }

    public static class SorterComparator implements Comparator<Object[]> {
        private SorterComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object[] objArr, Object[] objArr2) {
            return ((int[]) objArr[1])[0] - ((int[]) objArr2[1])[0];
        }
    }

    static {
        HashMap<String, String[]> map = new HashMap<>();
        stdFieldFontNames = map;
        map.put("CoBO", new String[]{"Courier-BoldOblique"});
        map.put("CoBo", new String[]{"Courier-Bold"});
        map.put("CoOb", new String[]{"Courier-Oblique"});
        map.put("Cour", new String[]{"Courier"});
        map.put("HeBO", new String[]{"Helvetica-BoldOblique"});
        map.put("HeBo", new String[]{"Helvetica-Bold"});
        map.put("HeOb", new String[]{"Helvetica-Oblique"});
        map.put("Helv", new String[]{"Helvetica"});
        map.put("Symb", new String[]{"Symbol"});
        map.put("TiBI", new String[]{"Times-BoldItalic"});
        map.put("TiBo", new String[]{"Times-Bold"});
        map.put("TiIt", new String[]{"Times-Italic"});
        map.put("TiRo", new String[]{"Times-Roman"});
        map.put("ZaDb", new String[]{"ZapfDingbats"});
        map.put("HySm", new String[]{"HYSMyeongJo-Medium", "UniKS-UCS2-H"});
        map.put("HyGo", new String[]{"HYGoThic-Medium", "UniKS-UCS2-H"});
        map.put("KaGo", new String[]{"HeiseiKakuGo-W5", "UniKS-UCS2-H"});
        map.put("KaMi", new String[]{"HeiseiMin-W3", "UniJIS-UCS2-H"});
        map.put("MHei", new String[]{"MHei-Medium", "UniCNS-UCS2-H"});
        map.put("MSun", new String[]{"MSung-Light", "UniCNS-UCS2-H"});
        map.put("STSo", new String[]{"STSong-Light", "UniGB-UCS2-H"});
        buttonRemove = new PdfName[]{PdfName.MK, PdfName.F, PdfName.FF, PdfName.Q, PdfName.BS, PdfName.BORDER};
    }

    public AcroFields(PdfReader pdfReader, PdfWriter pdfWriter) {
        this.reader = pdfReader;
        this.writer = pdfWriter;
        try {
            this.xfa = new XfaForm(pdfReader);
            if (pdfWriter instanceof PdfStamperImp) {
                this.append = ((PdfStamperImp) pdfWriter).isAppend();
            }
            fill();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private static void clearSigDic(PdfDictionary pdfDictionary) {
        pdfDictionary.remove(PdfName.AP);
        pdfDictionary.remove(PdfName.AS);
        pdfDictionary.remove(PdfName.V);
        pdfDictionary.remove(PdfName.DV);
        pdfDictionary.remove(PdfName.SV);
        pdfDictionary.remove(PdfName.FF);
        pdfDictionary.put(PdfName.F, new PdfNumber(4));
    }

    private String[] getListOption(String str, int i) {
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null) {
            return null;
        }
        PdfArray asArray = fieldItem.getMerged(0).getAsArray(PdfName.OPT);
        if (asArray == null) {
            return null;
        }
        String[] strArr = new String[asArray.size()];
        for (int i2 = 0; i2 < asArray.size(); i2++) {
            PdfObject directObject = asArray.getDirectObject(i2);
            try {
                if (directObject.isArray()) {
                    directObject = ((PdfArray) directObject).getDirectObject(i);
                }
                if (directObject.isString()) {
                    strArr[i2] = ((PdfString) directObject).toUnicodeString();
                } else {
                    strArr[i2] = directObject.toString();
                }
            } catch (Exception unused) {
                strArr[i2] = "";
            }
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markUsed(PdfObject pdfObject) {
        if (this.append) {
            ((PdfStamperImp) this.writer).markUsed(pdfObject);
        }
    }

    private int removeRefFromArray(PdfArray pdfArray, PdfObject pdfObject) {
        if (pdfObject == null || !pdfObject.isIndirect()) {
            return pdfArray.size();
        }
        PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) pdfObject;
        int i = 0;
        while (i < pdfArray.size()) {
            PdfObject pdfObject2 = pdfArray.getPdfObject(i);
            if (pdfObject2.isIndirect() && ((PdfIndirectReference) pdfObject2).getNumber() == pdfIndirectReference.getNumber()) {
                pdfArray.remove(i);
                i--;
            }
            i++;
        }
        return pdfArray.size();
    }

    public static Object[] splitDAelements(String str) {
        try {
            PRTokeniser pRTokeniser = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(PdfEncodings.convertToBytes(str, (String) null))));
            ArrayList arrayList = new ArrayList();
            Object[] objArr = new Object[3];
            while (pRTokeniser.nextToken()) {
                if (pRTokeniser.getTokenType() != PRTokeniser.TokenType.COMMENT) {
                    if (pRTokeniser.getTokenType() == PRTokeniser.TokenType.OTHER) {
                        String stringValue = pRTokeniser.getStringValue();
                        if (stringValue.equals("Tf")) {
                            if (arrayList.size() >= 2) {
                                objArr[0] = arrayList.get(arrayList.size() - 2);
                                objArr[1] = new Float((String) arrayList.get(arrayList.size() - 1));
                            }
                        } else if (stringValue.equals("g")) {
                            if (arrayList.size() >= 1) {
                                float fFloatValue = new Float((String) arrayList.get(arrayList.size() - 1)).floatValue();
                                if (fFloatValue != 0.0f) {
                                    objArr[2] = new GrayColor(fFloatValue);
                                }
                            }
                        } else if (stringValue.equals("rg")) {
                            if (arrayList.size() >= 3) {
                                objArr[2] = new BaseColor(new Float((String) arrayList.get(arrayList.size() - 3)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 2)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 1)).floatValue());
                            }
                        } else if (stringValue.equals("k") && arrayList.size() >= 4) {
                            objArr[2] = new CMYKColor(new Float((String) arrayList.get(arrayList.size() - 4)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 3)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 2)).floatValue(), new Float((String) arrayList.get(arrayList.size() - 1)).floatValue());
                        }
                        arrayList.clear();
                    } else {
                        arrayList.add(pRTokeniser.getStringValue());
                    }
                }
            }
            return objArr;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    private void updateByteRange(PdfPKCS7 pdfPKCS7, PdfDictionary pdfDictionary) throws Throwable {
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.BYTERANGE);
        RASInputStream rASInputStream = null;
        try {
            try {
                RASInputStream rASInputStream2 = new RASInputStream(new RandomAccessSourceFactory().createRanged(this.reader.getSafeFile().createSourceView(), asArray.asLongArray()));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = rASInputStream2.read(bArr, 0, 8192);
                        if (i <= 0) {
                            try {
                                rASInputStream2.close();
                                return;
                            } catch (IOException e) {
                                throw new ExceptionConverter(e);
                            }
                        }
                        pdfPKCS7.update(bArr, 0, i);
                    }
                } catch (Exception e2) {
                    e = e2;
                    throw new ExceptionConverter(e);
                } catch (Throwable th) {
                    th = th;
                    rASInputStream = rASInputStream2;
                    if (rASInputStream != null) {
                        try {
                            rASInputStream.close();
                        } catch (IOException e3) {
                            throw new ExceptionConverter(e3);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public void addSubstitutionFont(BaseFont baseFont) {
        if (this.substitutionFonts == null) {
            this.substitutionFonts = new ArrayList<>();
        }
        this.substitutionFonts.add(baseFont);
    }

    public boolean clearSignatureField(String str) {
        this.sigNames = null;
        getSignatureNames();
        if (!this.sigNames.containsKey(str)) {
            return false;
        }
        Item item = this.fields.get(str);
        item.markUsed(this, 6);
        int size = item.size();
        for (int i = 0; i < size; i++) {
            clearSigDic(item.getMerged(i));
            clearSigDic(item.getWidget(i));
            clearSigDic(item.getValue(i));
        }
        return true;
    }

    public void decodeGenericDictionary(PdfDictionary pdfDictionary, BaseField baseField) {
        PdfDictionary asDict;
        PdfObject pdfObject;
        PdfDictionary asDict2;
        PdfString asString = pdfDictionary.getAsString(PdfName.DA);
        if (asString != null) {
            Object[] objArrSplitDAelements = splitDAelements(asString.toUnicodeString());
            Object obj = objArrSplitDAelements[1];
            if (obj != null) {
                baseField.setFontSize(((Float) obj).floatValue());
            }
            Object obj2 = objArrSplitDAelements[2];
            if (obj2 != null) {
                baseField.setTextColor((BaseColor) obj2);
            }
            if (objArrSplitDAelements[0] != null) {
                PdfDictionary asDict3 = pdfDictionary.getAsDict(PdfName.DR);
                if (asDict3 == null || (asDict = asDict3.getAsDict(PdfName.FONT)) == null || (pdfObject = asDict.get(new PdfName((String) objArrSplitDAelements[0]))) == null || pdfObject.type() != 10) {
                    BaseFont baseFont = this.localFonts.get(objArrSplitDAelements[0]);
                    if (baseFont == null) {
                        String[] strArr = stdFieldFontNames.get(objArrSplitDAelements[0]);
                        if (strArr != null) {
                            try {
                                baseField.setFont(BaseFont.createFont(strArr[0], strArr.length > 1 ? strArr[1] : "winansi", false));
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        baseField.setFont(baseFont);
                    }
                } else {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                    baseField.setFont(new DocumentFont(pRIndirectReference, asDict3.getAsDict(PdfName.ENCODING)));
                    Integer numValueOf = Integer.valueOf(pRIndirectReference.getNumber());
                    BaseFont baseFontCreateFont = this.extensionFonts.get(numValueOf);
                    if (baseFontCreateFont == null && !this.extensionFonts.containsKey(numValueOf) && (asDict2 = ((PdfDictionary) PdfReader.getPdfObject(pdfObject)).getAsDict(PdfName.FONTDESCRIPTOR)) != null) {
                        PRStream pRStream = (PRStream) PdfReader.getPdfObject(asDict2.get(PdfName.FONTFILE2));
                        if (pRStream == null) {
                            pRStream = (PRStream) PdfReader.getPdfObject(asDict2.get(PdfName.FONTFILE3));
                        }
                        if (pRStream == null) {
                            this.extensionFonts.put(numValueOf, null);
                        } else {
                            try {
                                baseFontCreateFont = BaseFont.createFont("font.ttf", BaseFont.IDENTITY_H, true, false, PdfReader.getStreamBytes(pRStream), null);
                            } catch (Exception unused2) {
                            }
                            this.extensionFonts.put(numValueOf, baseFontCreateFont);
                        }
                    }
                    if (baseField instanceof TextField) {
                        ((TextField) baseField).setExtensionFont(baseFontCreateFont);
                    }
                }
            }
        }
        PdfDictionary asDict4 = pdfDictionary.getAsDict(PdfName.MK);
        if (asDict4 != null) {
            BaseColor mKColor = getMKColor(asDict4.getAsArray(PdfName.BC));
            baseField.setBorderColor(mKColor);
            if (mKColor != null) {
                baseField.setBorderWidth(1.0f);
            }
            baseField.setBackgroundColor(getMKColor(asDict4.getAsArray(PdfName.BG)));
            PdfNumber asNumber = asDict4.getAsNumber(PdfName.R);
            if (asNumber != null) {
                baseField.setRotation(asNumber.intValue());
            }
        }
        PdfNumber asNumber2 = pdfDictionary.getAsNumber(PdfName.F);
        baseField.setVisibility(2);
        if (asNumber2 != null) {
            int iIntValue = asNumber2.intValue();
            int i = iIntValue & 4;
            if (i != 0 && (iIntValue & 2) != 0) {
                baseField.setVisibility(1);
            } else if (i != 0 && (iIntValue & 32) != 0) {
                baseField.setVisibility(3);
            } else if (i != 0) {
                baseField.setVisibility(0);
            }
        }
        PdfNumber asNumber3 = pdfDictionary.getAsNumber(PdfName.FF);
        int iIntValue2 = asNumber3 != null ? asNumber3.intValue() : 0;
        baseField.setOptions(iIntValue2);
        if ((iIntValue2 & 16777216) != 0) {
            PdfNumber asNumber4 = pdfDictionary.getAsNumber(PdfName.MAXLEN);
            baseField.setMaxCharacterLength(asNumber4 != null ? asNumber4.intValue() : 0);
        }
        PdfNumber asNumber5 = pdfDictionary.getAsNumber(PdfName.Q);
        if (asNumber5 != null) {
            if (asNumber5.intValue() == 1) {
                baseField.setAlignment(1);
            } else if (asNumber5.intValue() == 2) {
                baseField.setAlignment(2);
            }
        }
        PdfDictionary asDict5 = pdfDictionary.getAsDict(PdfName.BS);
        if (asDict5 == null) {
            PdfArray asArray = pdfDictionary.getAsArray(PdfName.BORDER);
            if (asArray != null) {
                if (asArray.size() >= 3) {
                    baseField.setBorderWidth(asArray.getAsNumber(2).floatValue());
                }
                if (asArray.size() >= 4) {
                    baseField.setBorderStyle(1);
                    return;
                }
                return;
            }
            return;
        }
        PdfNumber asNumber6 = asDict5.getAsNumber(PdfName.W);
        if (asNumber6 != null) {
            baseField.setBorderWidth(asNumber6.floatValue());
        }
        PdfName asName = asDict5.getAsName(PdfName.S);
        if (PdfName.D.equals(asName)) {
            baseField.setBorderStyle(1);
            return;
        }
        if (PdfName.B.equals(asName)) {
            baseField.setBorderStyle(2);
        } else if (PdfName.I.equals(asName)) {
            baseField.setBorderStyle(3);
        } else if (PdfName.U.equals(asName)) {
            baseField.setBorderStyle(4);
        }
    }

    public boolean doesSignatureFieldExist(String str) {
        return getBlankSignatureNames().contains(str) || getSignatureNames().contains(str);
    }

    public void exportAsFdf(FdfWriter fdfWriter) {
        for (Map.Entry<String, Item> entry : this.fields.entrySet()) {
            Item value = entry.getValue();
            String key = entry.getKey();
            if (value.getMerged(0).get(PdfName.V) != null) {
                String field = getField(key);
                if (this.lastWasString) {
                    fdfWriter.setFieldAsString(key, field);
                } else {
                    fdfWriter.setFieldAsName(key, field);
                }
            }
        }
    }

    public InputStream extractRevision(String str) {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        if (!this.sigNames.containsKey(translatedFieldName)) {
            return null;
        }
        return new RASInputStream(new WindowRandomAccessSource(this.reader.getSafeFile().createSourceView(), 0L, this.sigNames.get(translatedFieldName)[0]));
    }

    public void fill() {
        this.fields = new LinkedHashMap();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(this.reader.getCatalog().get(PdfName.ACROFORM));
        if (pdfDictionary == null) {
            return;
        }
        PdfBoolean asBoolean = pdfDictionary.getAsBoolean(PdfName.NEEDAPPEARANCES);
        if (asBoolean == null || !asBoolean.booleanValue()) {
            setGenerateAppearances(true);
        } else {
            setGenerateAppearances(false);
        }
        PdfArray pdfArray = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIELDS));
        if (pdfArray == null || pdfArray.size() == 0) {
            return;
        }
        for (int i = 1; i <= this.reader.getNumberOfPages(); i++) {
            PdfDictionary pageNRelease = this.reader.getPageNRelease(i);
            PdfArray pdfArray2 = (PdfArray) PdfReader.getPdfObjectRelease(pageNRelease.get(PdfName.ANNOTS), pageNRelease);
            if (pdfArray2 != null) {
                int i2 = 0;
                while (i2 < pdfArray2.size()) {
                    PdfDictionary asDict = pdfArray2.getAsDict(i2);
                    if (asDict != null && PdfName.WIDGET.equals(asDict.getAsName(PdfName.SUBTYPE))) {
                        PdfDictionary pdfDictionary2 = new PdfDictionary();
                        pdfDictionary2.putAll(asDict);
                        PdfObject pdfObjectRelease = null;
                        String strSubstring = "";
                        PdfDictionary pdfDictionary3 = null;
                        for (PdfDictionary asDict2 = asDict; asDict2 != null; asDict2 = asDict2.getAsDict(PdfName.PARENT)) {
                            pdfDictionary2.mergeDifferent(asDict2);
                            PdfString asString = asDict2.getAsString(PdfName.T);
                            if (asString != null) {
                                strSubstring = asString.toUnicodeString() + "." + strSubstring;
                            }
                            if (pdfObjectRelease == null) {
                                PdfName pdfName = PdfName.V;
                                if (asDict2.get(pdfName) != null) {
                                    pdfObjectRelease = PdfReader.getPdfObjectRelease(asDict2.get(pdfName));
                                }
                            }
                            if (pdfDictionary3 == null && asString != null) {
                                PdfName pdfName2 = PdfName.V;
                                if (asDict2.get(pdfName2) == null && pdfObjectRelease != null) {
                                    asDict2.put(pdfName2, pdfObjectRelease);
                                }
                                pdfDictionary3 = asDict2;
                            }
                        }
                        if (strSubstring.length() > 0) {
                            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                        }
                        Item item = this.fields.get(strSubstring);
                        if (item == null) {
                            item = new Item();
                            this.fields.put(strSubstring, item);
                        }
                        if (pdfDictionary3 == null) {
                            item.addValue(asDict);
                        } else {
                            item.addValue(pdfDictionary3);
                        }
                        item.addWidget(asDict);
                        item.addWidgetRef(pdfArray2.getAsIndirectObject(i2));
                        pdfDictionary2.mergeDifferent(pdfDictionary);
                        item.addMerged(pdfDictionary2);
                        item.addPage(i);
                        item.addTabOrder(i2);
                    } else {
                        PdfReader.releaseLastXrefPartial(pdfArray2.getAsIndirectObject(i2));
                    }
                    i2++;
                }
            }
        }
        PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.SIGFLAGS);
        if (asNumber == null || (asNumber.intValue() & 1) != 1) {
            return;
        }
        for (int i3 = 0; i3 < pdfArray.size(); i3++) {
            PdfDictionary asDict3 = pdfArray.getAsDict(i3);
            if (asDict3 == null) {
                PdfReader.releaseLastXrefPartial(pdfArray.getAsIndirectObject(i3));
            } else if (!PdfName.WIDGET.equals(asDict3.getAsName(PdfName.SUBTYPE))) {
                PdfReader.releaseLastXrefPartial(pdfArray.getAsIndirectObject(i3));
            } else if (((PdfArray) PdfReader.getPdfObjectRelease(asDict3.get(PdfName.KIDS))) == null) {
                PdfDictionary pdfDictionary4 = new PdfDictionary();
                pdfDictionary4.putAll(asDict3);
                PdfString asString2 = asDict3.getAsString(PdfName.T);
                if (asString2 != null) {
                    String unicodeString = asString2.toUnicodeString();
                    if (!this.fields.containsKey(unicodeString)) {
                        Item item2 = new Item();
                        this.fields.put(unicodeString, item2);
                        item2.addValue(pdfDictionary4);
                        item2.addWidget(pdfDictionary4);
                        item2.addWidgetRef(pdfArray.getAsIndirectObject(i3));
                        item2.addMerged(pdfDictionary4);
                        item2.addPage(-1);
                        item2.addTabOrder(-1);
                    }
                }
            }
        }
    }

    public PdfAppearance getAppearance(PdfDictionary pdfDictionary, String[] strArr, String str) throws DocumentException {
        TextField textField;
        String str2;
        PdfName asName = pdfDictionary.getAsName(PdfName.FT);
        z = false;
        boolean z = false;
        if (PdfName.BTN.equals(asName)) {
            PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.FF);
            if (asNumber != null && (asNumber.intValue() & 32768) != 0) {
                z = true;
            }
            RadioCheckField radioCheckField = new RadioCheckField(this.writer, null, null, null);
            decodeGenericDictionary(pdfDictionary, radioCheckField);
            Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.RECT));
            if (radioCheckField.getRotation() == 90 || radioCheckField.getRotation() == 270) {
                normalizedRectangle = normalizedRectangle.rotate();
            }
            radioCheckField.setBox(normalizedRectangle);
            if (!z) {
                radioCheckField.setCheckType(3);
            }
            return radioCheckField.getAppearance(z, !pdfDictionary.getAsName(PdfName.AS).equals(PdfName.Off));
        }
        this.topFirst = 0;
        String str3 = strArr.length > 0 ? strArr[0] : null;
        Map<String, TextField> map = this.fieldCache;
        if (map == null || !map.containsKey(str)) {
            TextField textField2 = new TextField(this.writer, null, null);
            textField2.setExtraMargin(this.extraMarginLeft, this.extraMarginTop);
            textField2.setBorderWidth(0.0f);
            textField2.setSubstitutionFonts(this.substitutionFonts);
            decodeGenericDictionary(pdfDictionary, textField2);
            Rectangle normalizedRectangle2 = PdfReader.getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.RECT));
            if (textField2.getRotation() == 90 || textField2.getRotation() == 270) {
                normalizedRectangle2 = normalizedRectangle2.rotate();
            }
            textField2.setBox(normalizedRectangle2);
            Map<String, TextField> map2 = this.fieldCache;
            if (map2 != null) {
                map2.put(str, textField2);
            }
            textField = textField2;
        } else {
            textField = this.fieldCache.get(str);
            textField.setWriter(this.writer);
        }
        if (PdfName.TX.equals(asName)) {
            if (strArr.length > 0 && (str2 = strArr[0]) != null) {
                textField.setText(str2);
            }
            return textField.getAppearance();
        }
        if (!PdfName.CH.equals(asName)) {
            throw new DocumentException(MessageLocalization.getComposedMessage("an.appearance.was.requested.without.a.variable.text.field", new Object[0]));
        }
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.OPT);
        PdfNumber asNumber2 = pdfDictionary.getAsNumber(PdfName.FF);
        int iIntValue = (asNumber2 != null ? asNumber2.intValue() : 0) & 131072;
        if (iIntValue != 0 && asArray == null) {
            textField.setText(str3);
            return textField.getAppearance();
        }
        if (asArray != null) {
            int size = asArray.size();
            String[] strArr2 = new String[size];
            int size2 = asArray.size();
            String[] strArr3 = new String[size2];
            for (int i = 0; i < asArray.size(); i++) {
                PdfObject pdfObject = asArray.getPdfObject(i);
                if (pdfObject.isString()) {
                    String unicodeString = ((PdfString) pdfObject).toUnicodeString();
                    strArr3[i] = unicodeString;
                    strArr2[i] = unicodeString;
                } else {
                    PdfArray pdfArray = (PdfArray) pdfObject;
                    strArr3[i] = pdfArray.getAsString(0).toUnicodeString();
                    strArr2[i] = pdfArray.getAsString(1).toUnicodeString();
                }
            }
            if (iIntValue != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    if (str3.equals(strArr3[i2])) {
                        str3 = strArr2[i2];
                        break;
                    }
                }
                textField.setText(str3);
                return textField.getAppearance();
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < size2; i3++) {
                for (String str4 : strArr) {
                    if (str4 != null && str4.equals(strArr3[i3])) {
                        arrayList.add(Integer.valueOf(i3));
                        break;
                    }
                }
            }
            textField.setChoices(strArr2);
            textField.setChoiceExports(strArr3);
            textField.setChoiceSelections(arrayList);
        }
        PdfAppearance listAppearance = textField.getListAppearance();
        this.topFirst = textField.getTopFirst();
        return listAppearance;
    }

    public String[] getAppearanceStates(String str) {
        PdfDictionary asDict;
        Item item = this.fields.get(str);
        if (item == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        PdfDictionary value = item.getValue(0);
        PdfName pdfName = PdfName.OPT;
        PdfString asString = value.getAsString(pdfName);
        if (asString != null) {
            linkedHashSet.add(asString.toUnicodeString());
        } else {
            PdfArray asArray = value.getAsArray(pdfName);
            if (asArray != null) {
                for (int i = 0; i < asArray.size(); i++) {
                    PdfObject directObject = asArray.getDirectObject(i);
                    int iType = directObject.type();
                    PdfString asString2 = iType != 3 ? iType != 5 ? null : ((PdfArray) directObject).getAsString(1) : (PdfString) directObject;
                    if (asString2 != null) {
                        linkedHashSet.add(asString2.toUnicodeString());
                    }
                }
            }
        }
        for (int i2 = 0; i2 < item.size(); i2++) {
            PdfDictionary asDict2 = item.getWidget(i2).getAsDict(PdfName.AP);
            if (asDict2 != null && (asDict = asDict2.getAsDict(PdfName.N)) != null) {
                Iterator<PdfName> it = asDict.getKeys().iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(PdfName.decodeName(it.next().toString()));
                }
            }
        }
        return (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]);
    }

    public ArrayList<String> getBlankSignatureNames() {
        getSignatureNames();
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, Item> entry : this.fields.entrySet()) {
            if (PdfName.SIG.equals(entry.getValue().getMerged(0).getAsName(PdfName.FT)) && !this.sigNames.containsKey(entry.getKey())) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public String getField(String str) {
        if (this.xfa.isXfaPresent()) {
            String strFindFieldName = this.xfa.findFieldName(str, this);
            if (strFindFieldName == null) {
                return null;
            }
            return XfaForm.getNodeText(this.xfa.findDatasetsNode(XfaForm.Xml2Som.getShortName(strFindFieldName)));
        }
        Item item = this.fields.get(str);
        if (item == null) {
            return null;
        }
        this.lastWasString = false;
        PdfDictionary merged = item.getMerged(0);
        PdfObject pdfObject = PdfReader.getPdfObject(merged.get(PdfName.V));
        String unicodeString = "";
        if (pdfObject == null) {
            return "";
        }
        if (pdfObject instanceof PRStream) {
            try {
                return new String(PdfReader.getStreamBytes((PRStream) pdfObject));
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        if (!PdfName.BTN.equals(merged.getAsName(PdfName.FT))) {
            if (!(pdfObject instanceof PdfString)) {
                return pdfObject instanceof PdfName ? PdfName.decodeName(pdfObject.toString()) : "";
            }
            this.lastWasString = true;
            return ((PdfString) pdfObject).toUnicodeString();
        }
        PdfNumber asNumber = merged.getAsNumber(PdfName.FF);
        if (((asNumber != null ? asNumber.intValue() : 0) & 65536) != 0) {
            return "";
        }
        if (pdfObject instanceof PdfName) {
            unicodeString = PdfName.decodeName(pdfObject.toString());
        } else if (pdfObject instanceof PdfString) {
            unicodeString = ((PdfString) pdfObject).toUnicodeString();
        }
        PdfArray asArray = item.getValue(0).getAsArray(PdfName.OPT);
        if (asArray == null) {
            return unicodeString;
        }
        try {
            unicodeString = asArray.getAsString(Integer.parseInt(unicodeString)).toUnicodeString();
            this.lastWasString = true;
            return unicodeString;
        } catch (Exception unused) {
            return unicodeString;
        }
    }

    public Map<String, TextField> getFieldCache() {
        return this.fieldCache;
    }

    public Item getFieldItem(String str) {
        if (this.xfa.isXfaPresent() && (str = this.xfa.findFieldName(str, this)) == null) {
            return null;
        }
        return this.fields.get(str);
    }

    public List<FieldPosition> getFieldPositions(String str) {
        Rectangle rectangle;
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fieldItem.size(); i++) {
            try {
                PdfArray asArray = fieldItem.getWidget(i).getAsArray(PdfName.RECT);
                if (asArray != null) {
                    Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(asArray);
                    int iIntValue = fieldItem.getPage(i).intValue();
                    int pageRotation = this.reader.getPageRotation(iIntValue);
                    FieldPosition fieldPosition = new FieldPosition();
                    fieldPosition.page = iIntValue;
                    if (pageRotation != 0) {
                        Rectangle pageSize = this.reader.getPageSize(iIntValue);
                        if (pageRotation == 90) {
                            rectangle = new Rectangle(normalizedRectangle.getBottom(), pageSize.getRight() - normalizedRectangle.getLeft(), normalizedRectangle.getTop(), pageSize.getRight() - normalizedRectangle.getRight());
                        } else if (pageRotation != 180) {
                            if (pageRotation == 270) {
                                rectangle = new Rectangle(pageSize.getTop() - normalizedRectangle.getBottom(), normalizedRectangle.getLeft(), pageSize.getTop() - normalizedRectangle.getTop(), normalizedRectangle.getRight());
                            }
                            normalizedRectangle.normalize();
                        } else {
                            rectangle = new Rectangle(pageSize.getRight() - normalizedRectangle.getLeft(), pageSize.getTop() - normalizedRectangle.getBottom(), pageSize.getRight() - normalizedRectangle.getRight(), pageSize.getTop() - normalizedRectangle.getTop());
                        }
                        normalizedRectangle = rectangle;
                        normalizedRectangle.normalize();
                    }
                    fieldPosition.position = normalizedRectangle;
                    arrayList.add(fieldPosition);
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public String getFieldRichValue(String str) {
        Item item;
        PdfString asString;
        if (this.xfa.isXfaPresent() || (item = this.fields.get(str)) == null || (asString = item.getMerged(0).getAsString(PdfName.RV)) == null) {
            return null;
        }
        return asString.toString();
    }

    public int getFieldType(String str) {
        PdfDictionary merged;
        PdfName asName;
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null || (asName = (merged = fieldItem.getMerged(0)).getAsName(PdfName.FT)) == null) {
            return 0;
        }
        PdfNumber asNumber = merged.getAsNumber(PdfName.FF);
        int iIntValue = asNumber != null ? asNumber.intValue() : 0;
        if (PdfName.BTN.equals(asName)) {
            if ((65536 & iIntValue) != 0) {
                return 1;
            }
            return (iIntValue & 32768) != 0 ? 3 : 2;
        }
        if (PdfName.TX.equals(asName)) {
            return 4;
        }
        if (PdfName.CH.equals(asName)) {
            return (iIntValue & 131072) != 0 ? 6 : 5;
        }
        return PdfName.SIG.equals(asName) ? 7 : 0;
    }

    public Map<String, Item> getFields() {
        return this.fields;
    }

    public String[] getListOptionDisplay(String str) {
        return getListOption(str, 1);
    }

    public String[] getListOptionExport(String str) {
        return getListOption(str, 0);
    }

    public String[] getListSelection(String str) {
        PdfArray asArray;
        String field = getField(str);
        int i = 0;
        String[] strArr = field == null ? new String[0] : new String[]{field};
        Item item = this.fields.get(str);
        if (item == null || (asArray = item.getMerged(0).getAsArray(PdfName.I)) == null) {
            return strArr;
        }
        String[] strArr2 = new String[asArray.size()];
        String[] listOptionExport = getListOptionExport(str);
        ListIterator<PdfObject> listIterator = asArray.listIterator();
        while (listIterator.hasNext()) {
            strArr2[i] = listOptionExport[((PdfNumber) listIterator.next()).intValue()];
            i++;
        }
        return strArr2;
    }

    public BaseColor getMKColor(PdfArray pdfArray) {
        if (pdfArray == null) {
            return null;
        }
        int size = pdfArray.size();
        if (size == 1) {
            return new GrayColor(pdfArray.getAsNumber(0).floatValue());
        }
        if (size == 3) {
            return new BaseColor(ExtendedColor.normalize(pdfArray.getAsNumber(0).floatValue()), ExtendedColor.normalize(pdfArray.getAsNumber(1).floatValue()), ExtendedColor.normalize(pdfArray.getAsNumber(2).floatValue()));
        }
        if (size != 4) {
            return null;
        }
        return new CMYKColor(pdfArray.getAsNumber(0).floatValue(), pdfArray.getAsNumber(1).floatValue(), pdfArray.getAsNumber(2).floatValue(), pdfArray.getAsNumber(3).floatValue());
    }

    public PushbuttonField getNewPushbuttonFromField(String str) {
        return getNewPushbuttonFromField(str, 0);
    }

    public PdfIndirectReference getNormalAppearance(String str) {
        PdfDictionary asDict;
        PdfIndirectReference asIndirectObject;
        getSignatureNames();
        Item item = this.fields.get(getTranslatedFieldName(str));
        if (item == null || (asDict = item.getMerged(0).getAsDict(PdfName.AP)) == null || (asIndirectObject = asDict.getAsIndirectObject(PdfName.N)) == null) {
            return null;
        }
        return asIndirectObject;
    }

    public int getRevision(String str) {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        if (this.sigNames.containsKey(translatedFieldName)) {
            return this.sigNames.get(translatedFieldName)[1];
        }
        return 0;
    }

    public PdfDictionary getSignatureDictionary(String str) {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        if (this.sigNames.containsKey(translatedFieldName)) {
            return this.fields.get(translatedFieldName).getMerged(0).getAsDict(PdfName.V);
        }
        return null;
    }

    public ArrayList<String> getSignatureNames() {
        PdfDictionary asDict;
        PdfArray asArray;
        int size;
        if (this.sigNames != null) {
            return new ArrayList<>(this.orderedSignatureNames);
        }
        this.sigNames = new HashMap<>();
        this.orderedSignatureNames = new ArrayList<>();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Item> entry : this.fields.entrySet()) {
            PdfDictionary merged = entry.getValue().getMerged(0);
            if (PdfName.SIG.equals(merged.get(PdfName.FT)) && (asDict = merged.getAsDict(PdfName.V)) != null && asDict.getAsString(PdfName.CONTENTS) != null && (asArray = asDict.getAsArray(PdfName.BYTERANGE)) != null && (size = asArray.size()) >= 2) {
                arrayList.add(new Object[]{entry.getKey(), new int[]{asArray.getAsNumber(size - 1).intValue() + asArray.getAsNumber(size - 2).intValue(), 0}});
            }
        }
        Collections.sort(arrayList, new SorterComparator());
        if (!arrayList.isEmpty()) {
            if (((int[]) ((Object[]) arrayList.get(arrayList.size() - 1))[1])[0] == this.reader.getFileLength()) {
                this.totalRevisions = arrayList.size();
            } else {
                this.totalRevisions = arrayList.size() + 1;
            }
            int i = 0;
            while (i < arrayList.size()) {
                Object[] objArr = (Object[]) arrayList.get(i);
                String str = (String) objArr[0];
                int[] iArr = (int[]) objArr[1];
                i++;
                iArr[1] = i;
                this.sigNames.put(str, iArr);
                this.orderedSignatureNames.add(str);
            }
        }
        return new ArrayList<>(this.orderedSignatureNames);
    }

    public ArrayList<BaseFont> getSubstitutionFonts() {
        return this.substitutionFonts;
    }

    public int getTotalRevisions() {
        getSignatureNames();
        return this.totalRevisions;
    }

    public String getTranslatedFieldName(String str) {
        String strFindFieldName;
        return (!this.xfa.isXfaPresent() || (strFindFieldName = this.xfa.findFieldName(str, this)) == null) ? str : strFindFieldName;
    }

    public XfaForm getXfa() {
        return this.xfa;
    }

    public boolean isGenerateAppearances() {
        return this.generateAppearances;
    }

    public boolean isInAP(PdfDictionary pdfDictionary, PdfName pdfName) {
        return (pdfDictionary == null || pdfDictionary.get(pdfName) == null) ? false : true;
    }

    public void mergeXfaData(Node node) {
        XfaForm.Xml2SomDatasets xml2SomDatasets = new XfaForm.Xml2SomDatasets(node);
        for (String str : xml2SomDatasets.getOrder()) {
            setField(str, XfaForm.getNodeText(xml2SomDatasets.getName2Node().get(str)));
        }
    }

    public boolean regenerateField(String str) {
        String field = getField(str);
        return setField(str, field, field);
    }

    public boolean removeField(String str, int i) {
        PdfDictionary pdfDictionary;
        PdfArray asArray;
        PdfIndirectReference asIndirectObject;
        Item fieldItem = getFieldItem(str);
        int i2 = 0;
        if (fieldItem == null || (pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(this.reader.getCatalog().get(PdfName.ACROFORM), this.reader.getCatalog())) == null || (asArray = pdfDictionary.getAsArray(PdfName.FIELDS)) == null) {
            return false;
        }
        while (i2 < fieldItem.size()) {
            int iIntValue = fieldItem.getPage(i2).intValue();
            if (i == -1 || i == iIntValue) {
                PdfIndirectReference widgetRef = fieldItem.getWidgetRef(i2);
                PdfDictionary widget = fieldItem.getWidget(i2);
                PdfDictionary pageN = this.reader.getPageN(iIntValue);
                PdfArray asArray2 = pageN != null ? pageN.getAsArray(PdfName.ANNOTS) : null;
                if (asArray2 != null) {
                    if (removeRefFromArray(asArray2, widgetRef) == 0) {
                        pageN.remove(PdfName.ANNOTS);
                        markUsed(pageN);
                    } else {
                        markUsed(asArray2);
                    }
                }
                PdfReader.killIndirect(widgetRef);
                while (true) {
                    PdfName pdfName = PdfName.PARENT;
                    asIndirectObject = widget.getAsIndirectObject(pdfName);
                    if (asIndirectObject == null) {
                        break;
                    }
                    widget = widget.getAsDict(pdfName);
                    if (removeRefFromArray(widget.getAsArray(PdfName.KIDS), widgetRef) != 0) {
                        break;
                    }
                    PdfReader.killIndirect(asIndirectObject);
                    widgetRef = asIndirectObject;
                }
                if (asIndirectObject == null) {
                    removeRefFromArray(asArray, widgetRef);
                    markUsed(asArray);
                }
                if (i != -1) {
                    fieldItem.remove(i2);
                    i2--;
                }
            }
            i2++;
        }
        if (i == -1 || fieldItem.size() == 0) {
            this.fields.remove(str);
        }
        return true;
    }

    public boolean removeFieldsFromPage(int i) {
        if (i < 1) {
            return false;
        }
        int size = this.fields.size();
        String[] strArr = new String[size];
        this.fields.keySet().toArray(strArr);
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            z = z || removeField(strArr[i2], i);
        }
        return z;
    }

    public void removeXfa() {
        this.reader.getCatalog().getAsDict(PdfName.ACROFORM).remove(PdfName.XFA);
        try {
            this.xfa = new XfaForm(this.reader);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean renameField(String str, String str2) {
        Item item;
        int iLastIndexOf = str.lastIndexOf(46) + 1;
        int iLastIndexOf2 = str2.lastIndexOf(46) + 1;
        if (iLastIndexOf != iLastIndexOf2 || !str.substring(0, iLastIndexOf).equals(str2.substring(0, iLastIndexOf2)) || this.fields.containsKey(str2) || (item = this.fields.get(str)) == null) {
            return false;
        }
        String strSubstring = str2.substring(iLastIndexOf2);
        item.writeToAll(PdfName.T, new PdfString(strSubstring, PdfObject.TEXT_UNICODE), 5);
        item.markUsed(this, 4);
        this.fields.remove(str);
        this.fields.put(strSubstring, item);
        return true;
    }

    public boolean replacePushbuttonField(String str, PdfFormField pdfFormField) {
        return replacePushbuttonField(str, pdfFormField, 0);
    }

    public void setExtraMargin(float f, float f2) {
        this.extraMarginLeft = f;
        this.extraMarginTop = f2;
    }

    public boolean setField(String str, String str2) {
        return setField(str, str2, (String) null);
    }

    public void setFieldCache(Map<String, TextField> map) {
        this.fieldCache = map;
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0275  */
    public boolean setFieldProperty(String str, String str2, Object obj, int[] iArr) {
        PdfDictionary pdfDictionary;
        FontDetails fontDetailsAddSimple;
        char c = 0;
        if (this.writer == null) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("this.acrofields.instance.is.read.only", new Object[0]));
        }
        try {
            Item item = this.fields.get(str);
            if (item == null) {
                return false;
            }
            InstHit instHit = new InstHit(iArr);
            if (str2.equalsIgnoreCase("textfont")) {
                int i = 0;
                while (i < item.size()) {
                    if (instHit.isHit(i)) {
                        PdfDictionary merged = item.getMerged(i);
                        PdfName pdfName = PdfName.DA;
                        PdfString asString = merged.getAsString(pdfName);
                        PdfName pdfName2 = PdfName.DR;
                        PdfDictionary asDict = merged.getAsDict(pdfName2);
                        if (asString != null) {
                            if (asDict == null) {
                                asDict = new PdfDictionary();
                                merged.put(pdfName2, asDict);
                            }
                            Object[] objArrSplitDAelements = splitDAelements(asString.toUnicodeString());
                            PdfAppearance pdfAppearance = new PdfAppearance();
                            if (objArrSplitDAelements[c] != null) {
                                BaseFont baseFont = (BaseFont) obj;
                                PdfName pdfName3 = PdfAppearance.stdFieldFontNames.get(baseFont.getPostscriptFontName());
                                if (pdfName3 == null) {
                                    pdfName3 = new PdfName(baseFont.getPostscriptFontName());
                                }
                                PdfName pdfName4 = PdfName.FONT;
                                PdfDictionary asDict2 = asDict.getAsDict(pdfName4);
                                if (asDict2 == null) {
                                    pdfDictionary = new PdfDictionary();
                                    asDict.put(pdfName4, pdfDictionary);
                                } else {
                                    pdfDictionary = asDict2;
                                }
                                PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) pdfDictionary.get(pdfName3);
                                PdfDictionary asDict3 = this.reader.getCatalog().getAsDict(PdfName.ACROFORM);
                                markUsed(asDict3);
                                PdfDictionary asDict4 = asDict3.getAsDict(pdfName2);
                                if (asDict4 == null) {
                                    asDict4 = new PdfDictionary();
                                    asDict3.put(pdfName2, asDict4);
                                }
                                markUsed(asDict4);
                                PdfDictionary asDict5 = asDict4.getAsDict(pdfName4);
                                if (asDict5 == null) {
                                    asDict5 = new PdfDictionary();
                                    asDict4.put(pdfName4, asDict5);
                                }
                                markUsed(asDict5);
                                PdfIndirectReference pdfIndirectReference2 = (PdfIndirectReference) asDict5.get(pdfName3);
                                if (pdfIndirectReference2 != null) {
                                    if (pdfIndirectReference == null) {
                                        pdfDictionary.put(pdfName3, pdfIndirectReference2);
                                    }
                                } else if (pdfIndirectReference == null) {
                                    if (baseFont.getFontType() == 4) {
                                        fontDetailsAddSimple = new FontDetails(null, ((DocumentFont) baseFont).getIndirectReference(), baseFont);
                                    } else {
                                        baseFont.setSubset(false);
                                        fontDetailsAddSimple = this.writer.addSimple(baseFont);
                                        this.localFonts.put(pdfName3.toString().substring(1), baseFont);
                                    }
                                    asDict5.put(pdfName3, fontDetailsAddSimple.getIndirectReference());
                                    pdfDictionary.put(pdfName3, fontDetailsAddSimple.getIndirectReference());
                                }
                                pdfAppearance.getInternalBuffer().append(pdfName3.getBytes()).append(' ').append(((Float) objArrSplitDAelements[1]).floatValue()).append(" Tf ");
                                Object obj2 = objArrSplitDAelements[2];
                                if (obj2 != null) {
                                    pdfAppearance.setColorFill((BaseColor) obj2);
                                }
                                PdfString pdfString = new PdfString(pdfAppearance.toString());
                                item.getMerged(i).put(pdfName, pdfString);
                                item.getWidget(i).put(pdfName, pdfString);
                                markUsed(item.getWidget(i));
                            }
                        }
                    }
                    i++;
                    c = 0;
                }
            } else if (str2.equalsIgnoreCase("textcolor")) {
                for (int i2 = 0; i2 < item.size(); i2++) {
                    if (instHit.isHit(i2)) {
                        PdfDictionary merged2 = item.getMerged(i2);
                        PdfName pdfName5 = PdfName.DA;
                        PdfString asString2 = merged2.getAsString(pdfName5);
                        if (asString2 != null) {
                            Object[] objArrSplitDAelements2 = splitDAelements(asString2.toUnicodeString());
                            PdfAppearance pdfAppearance2 = new PdfAppearance();
                            if (objArrSplitDAelements2[0] != null) {
                                pdfAppearance2.getInternalBuffer().append(new PdfName((String) objArrSplitDAelements2[0]).getBytes()).append(' ').append(((Float) objArrSplitDAelements2[1]).floatValue()).append(" Tf ");
                                pdfAppearance2.setColorFill((BaseColor) obj);
                                PdfString pdfString2 = new PdfString(pdfAppearance2.toString());
                                item.getMerged(i2).put(pdfName5, pdfString2);
                                item.getWidget(i2).put(pdfName5, pdfString2);
                                markUsed(item.getWidget(i2));
                            }
                        }
                    }
                }
            } else if (str2.equalsIgnoreCase("textsize")) {
                for (int i3 = 0; i3 < item.size(); i3++) {
                    if (instHit.isHit(i3)) {
                        PdfDictionary merged3 = item.getMerged(i3);
                        PdfName pdfName6 = PdfName.DA;
                        PdfString asString3 = merged3.getAsString(pdfName6);
                        if (asString3 != null) {
                            Object[] objArrSplitDAelements3 = splitDAelements(asString3.toUnicodeString());
                            PdfAppearance pdfAppearance3 = new PdfAppearance();
                            if (objArrSplitDAelements3[0] != null) {
                                pdfAppearance3.getInternalBuffer().append(new PdfName((String) objArrSplitDAelements3[0]).getBytes()).append(' ').append(((Float) obj).floatValue()).append(" Tf ");
                                Object obj3 = objArrSplitDAelements3[2];
                                if (obj3 != null) {
                                    pdfAppearance3.setColorFill((BaseColor) obj3);
                                }
                                PdfString pdfString3 = new PdfString(pdfAppearance3.toString());
                                item.getMerged(i3).put(pdfName6, pdfString3);
                                item.getWidget(i3).put(pdfName6, pdfString3);
                                markUsed(item.getWidget(i3));
                            }
                        }
                    }
                }
            } else {
                if (!str2.equalsIgnoreCase(HtmlTags.BGCOLOR) && !str2.equalsIgnoreCase("bordercolor")) {
                    return false;
                }
                PdfName pdfName7 = str2.equalsIgnoreCase(HtmlTags.BGCOLOR) ? PdfName.BG : PdfName.BC;
                for (int i4 = 0; i4 < item.size(); i4++) {
                    if (instHit.isHit(i4)) {
                        PdfDictionary merged4 = item.getMerged(i4);
                        PdfName pdfName8 = PdfName.MK;
                        PdfDictionary asDict6 = merged4.getAsDict(pdfName8);
                        if (asDict6 != null) {
                            markUsed(asDict6);
                        } else {
                            if (obj == null) {
                                return true;
                            }
                            asDict6 = new PdfDictionary();
                            item.getMerged(i4).put(pdfName8, asDict6);
                            item.getWidget(i4).put(pdfName8, asDict6);
                            markUsed(item.getWidget(i4));
                        }
                        if (obj == null) {
                            asDict6.remove(pdfName7);
                        } else {
                            asDict6.put(pdfName7, PdfAnnotation.getMKColor((BaseColor) obj));
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean setFieldRichValue(String str, String str2) throws DocumentException {
        if (this.writer == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("this.acrofields.instance.is.read.only", new Object[0]));
        }
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null || getFieldType(str) != 4) {
            return false;
        }
        PdfNumber asNumber = fieldItem.getMerged(0).getAsNumber(PdfName.FF);
        if (((asNumber != null ? asNumber.intValue() : 0) & 33554432) == 0) {
            return false;
        }
        fieldItem.writeToAll(PdfName.RV, new PdfString(str2), 5);
        fieldItem.writeToAll(PdfName.V, new PdfString(XmlToTxt.parse(new ByteArrayInputStream(str2.getBytes()))), 5);
        return true;
    }

    public void setFields(FdfReader fdfReader) {
        for (String str : fdfReader.getFields().keySet()) {
            String fieldValue = fdfReader.getFieldValue(str);
            if (fieldValue != null) {
                setField(str, fieldValue);
            }
        }
    }

    public void setGenerateAppearances(boolean z) {
        this.generateAppearances = z;
        PdfDictionary asDict = this.reader.getCatalog().getAsDict(PdfName.ACROFORM);
        if (z) {
            asDict.remove(PdfName.NEEDAPPEARANCES);
        } else {
            asDict.put(PdfName.NEEDAPPEARANCES, PdfBoolean.PDFTRUE);
        }
    }

    public boolean setListOption(String str, String[] strArr, String[] strArr2) {
        String[] strArr3;
        int i = 0;
        if (strArr == null && strArr2 == null) {
            return false;
        }
        if (strArr != null && strArr2 != null && strArr.length != strArr2.length) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("the.export.and.the.display.array.must.have.the.same.size", new Object[0]));
        }
        int fieldType = getFieldType(str);
        if (fieldType != 6 && fieldType != 5) {
            return false;
        }
        Item item = this.fields.get(str);
        if (strArr != null || strArr2 == null) {
            strArr3 = (strArr == null || strArr2 != null) ? null : strArr;
        } else {
            strArr3 = strArr2;
        }
        PdfArray pdfArray = new PdfArray();
        if (strArr3 != null) {
            while (i < strArr3.length) {
                pdfArray.add(new PdfString(strArr3[i], PdfObject.TEXT_UNICODE));
                i++;
            }
        } else {
            while (i < strArr.length) {
                PdfArray pdfArray2 = new PdfArray();
                pdfArray2.add(new PdfString(strArr[i], PdfObject.TEXT_UNICODE));
                pdfArray2.add(new PdfString(strArr2[i], PdfObject.TEXT_UNICODE));
                pdfArray.add(pdfArray2);
                i++;
            }
        }
        item.writeToAll(PdfName.OPT, pdfArray, 5);
        return true;
    }

    public boolean setListSelection(String str, String[] strArr) throws DocumentException {
        Item fieldItem = getFieldItem(str);
        if (fieldItem == null) {
            return false;
        }
        PdfDictionary merged = fieldItem.getMerged(0);
        if (!PdfName.CH.equals(merged.getAsName(PdfName.FT))) {
            return false;
        }
        String[] listOptionExport = getListOptionExport(str);
        PdfArray pdfArray = new PdfArray();
        for (String str2 : strArr) {
            for (int i = 0; i < listOptionExport.length; i++) {
                if (listOptionExport[i].equals(str2)) {
                    pdfArray.add(new PdfNumber(i));
                    break;
                }
            }
        }
        fieldItem.writeToAll(PdfName.I, pdfArray, 5);
        PdfArray pdfArray2 = new PdfArray();
        for (String str3 : strArr) {
            pdfArray2.add(new PdfString(str3));
        }
        fieldItem.writeToAll(PdfName.V, pdfArray2, 5);
        PdfAppearance appearance = getAppearance(merged, strArr, str);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.N, appearance.getIndirectReference());
        fieldItem.writeToAll(PdfName.AP, pdfDictionary, 3);
        this.writer.releaseTemplate(appearance);
        fieldItem.markUsed(this, 6);
        return true;
    }

    public void setSubstitutionFonts(ArrayList<BaseFont> arrayList) {
        this.substitutionFonts = arrayList;
    }

    public boolean signatureCoversWholeDocument(String str) {
        getSignatureNames();
        String translatedFieldName = getTranslatedFieldName(str);
        return this.sigNames.containsKey(translatedFieldName) && ((long) this.sigNames.get(translatedFieldName)[0]) == this.reader.getFileLength();
    }

    public PdfPKCS7 verifySignature(String str) {
        return verifySignature(str, null);
    }

    public PushbuttonField getNewPushbuttonFromField(String str, int i) {
        int i2;
        try {
            if (getFieldType(str) != 1) {
                return null;
            }
            Item fieldItem = getFieldItem(str);
            if (i >= fieldItem.size()) {
                return null;
            }
            PushbuttonField pushbuttonField = new PushbuttonField(this.writer, getFieldPositions(str).get(i).position, null);
            PdfDictionary merged = fieldItem.getMerged(i);
            decodeGenericDictionary(merged, pushbuttonField);
            PdfDictionary asDict = merged.getAsDict(PdfName.MK);
            if (asDict != null) {
                PdfString asString = asDict.getAsString(PdfName.CA);
                if (asString != null) {
                    pushbuttonField.setText(asString.toUnicodeString());
                }
                PdfNumber asNumber = asDict.getAsNumber(PdfName.TP);
                if (asNumber != null) {
                    pushbuttonField.setLayout(asNumber.intValue() + 1);
                }
                PdfDictionary asDict2 = asDict.getAsDict(PdfName.IF);
                if (asDict2 != null) {
                    PdfName asName = asDict2.getAsName(PdfName.SW);
                    if (asName != null) {
                        if (asName.equals(PdfName.B)) {
                            i2 = 3;
                        } else if (asName.equals(PdfName.S)) {
                            i2 = 4;
                        } else {
                            i2 = asName.equals(PdfName.N) ? 2 : 1;
                        }
                        pushbuttonField.setScaleIcon(i2);
                    }
                    PdfName asName2 = asDict2.getAsName(PdfName.S);
                    if (asName2 != null && asName2.equals(PdfName.A)) {
                        pushbuttonField.setProportionalIcon(false);
                    }
                    PdfArray asArray = asDict2.getAsArray(PdfName.A);
                    if (asArray != null && asArray.size() == 2) {
                        float fFloatValue = asArray.getAsNumber(0).floatValue();
                        float fFloatValue2 = asArray.getAsNumber(1).floatValue();
                        pushbuttonField.setIconHorizontalAdjustment(fFloatValue);
                        pushbuttonField.setIconVerticalAdjustment(fFloatValue2);
                    }
                    PdfBoolean asBoolean = asDict2.getAsBoolean(PdfName.FB);
                    if (asBoolean != null && asBoolean.booleanValue()) {
                        pushbuttonField.setIconFitToBounds(true);
                    }
                }
                PdfObject pdfObject = asDict.get(PdfName.I);
                if (pdfObject != null && pdfObject.isIndirect()) {
                    pushbuttonField.setIconReference((PRIndirectReference) pdfObject);
                }
            }
            return pushbuttonField;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean replacePushbuttonField(String str, PdfFormField pdfFormField, int i) {
        int i2 = 0;
        if (getFieldType(str) != 1) {
            return false;
        }
        Item fieldItem = getFieldItem(str);
        if (i >= fieldItem.size()) {
            return false;
        }
        PdfDictionary merged = fieldItem.getMerged(i);
        PdfDictionary value = fieldItem.getValue(i);
        PdfDictionary widget = fieldItem.getWidget(i);
        while (true) {
            PdfName[] pdfNameArr = buttonRemove;
            if (i2 >= pdfNameArr.length) {
                break;
            }
            merged.remove(pdfNameArr[i2]);
            value.remove(pdfNameArr[i2]);
            widget.remove(pdfNameArr[i2]);
            i2++;
        }
        for (PdfName pdfName : pdfFormField.getKeys()) {
            if (!pdfName.equals(PdfName.T)) {
                if (pdfName.equals(PdfName.FF)) {
                    value.put(pdfName, pdfFormField.get(pdfName));
                } else {
                    widget.put(pdfName, pdfFormField.get(pdfName));
                }
                merged.put(pdfName, pdfFormField.get(pdfName));
                markUsed(value);
                markUsed(widget);
            }
        }
        return true;
    }

    public boolean setField(String str, String str2, boolean z) {
        return setField(str, str2, null, z);
    }

    public PdfPKCS7 verifySignature(String str, String str2) throws Throwable {
        PdfPKCS7 pdfPKCS7;
        PdfDictionary signatureDictionary = getSignatureDictionary(str);
        if (signatureDictionary == null) {
            return null;
        }
        try {
            PdfName asName = signatureDictionary.getAsName(PdfName.SUBFILTER);
            PdfString asString = signatureDictionary.getAsString(PdfName.CONTENTS);
            if (asName.equals(PdfName.ADBE_X509_RSA_SHA1)) {
                PdfName pdfName = PdfName.CERT;
                PdfString asString2 = signatureDictionary.getAsString(pdfName);
                if (asString2 == null) {
                    asString2 = signatureDictionary.getAsArray(pdfName).getAsString(0);
                }
                pdfPKCS7 = new PdfPKCS7(asString.getOriginalBytes(), asString2.getBytes(), str2);
            } else {
                pdfPKCS7 = new PdfPKCS7(asString.getOriginalBytes(), asName, str2);
            }
            updateByteRange(pdfPKCS7, signatureDictionary);
            PdfString asString3 = signatureDictionary.getAsString(PdfName.M);
            if (asString3 != null) {
                pdfPKCS7.setSignDate(PdfDate.decode(asString3.toString()));
            }
            PdfObject pdfObject = PdfReader.getPdfObject(signatureDictionary.get(PdfName.NAME));
            if (pdfObject != null) {
                if (pdfObject.isString()) {
                    pdfPKCS7.setSignName(((PdfString) pdfObject).toUnicodeString());
                } else if (pdfObject.isName()) {
                    pdfPKCS7.setSignName(PdfName.decodeName(pdfObject.toString()));
                }
            }
            PdfString asString4 = signatureDictionary.getAsString(PdfName.REASON);
            if (asString4 != null) {
                pdfPKCS7.setReason(asString4.toUnicodeString());
            }
            PdfString asString5 = signatureDictionary.getAsString(PdfName.LOCATION);
            if (asString5 != null) {
                pdfPKCS7.setLocation(asString5.toUnicodeString());
            }
            return pdfPKCS7;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean setField(String str, String str2, String str3) {
        return setField(str, str2, str3, false);
    }

    public boolean setField(String str, String str2, String str3, boolean z) throws DocumentException {
        if (this.writer != null) {
            if (this.xfa.isXfaPresent()) {
                str = this.xfa.findFieldName(str, this);
                if (str == null) {
                    return false;
                }
                String shortName = XfaForm.Xml2Som.getShortName(str);
                Node nodeFindDatasetsNode = this.xfa.findDatasetsNode(shortName);
                if (nodeFindDatasetsNode == null) {
                    nodeFindDatasetsNode = this.xfa.getDatasetsSom().insertNode(this.xfa.getDatasetsNode(), shortName);
                }
                this.xfa.setNodeText(nodeFindDatasetsNode, str2);
            }
            Item item = this.fields.get(str);
            if (item == null) {
                return false;
            }
            PdfDictionary merged = item.getMerged(0);
            PdfName asName = merged.getAsName(PdfName.FT);
            PdfName pdfName = PdfName.TX;
            if (pdfName.equals(asName)) {
                PdfNumber asNumber = merged.getAsNumber(PdfName.MAXLEN);
                int iIntValue = asNumber != null ? asNumber.intValue() : 0;
                if (iIntValue > 0) {
                    str2 = str2.substring(0, Math.min(iIntValue, str2.length()));
                }
            }
            if (str3 == null) {
                str3 = str2;
            }
            if (!pdfName.equals(asName) && !PdfName.CH.equals(asName)) {
                if (!PdfName.BTN.equals(asName)) {
                    return false;
                }
                PdfNumber asNumber2 = item.getMerged(0).getAsNumber(PdfName.FF);
                if (((asNumber2 != null ? asNumber2.intValue() : 0) & 65536) != 0) {
                    try {
                        Image image = Image.getInstance(Base64.decode(str2));
                        PushbuttonField newPushbuttonFromField = getNewPushbuttonFromField(str);
                        newPushbuttonFromField.setImage(image);
                        replacePushbuttonField(str, newPushbuttonFromField.getField());
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                PdfName pdfName2 = new PdfName(str2);
                ArrayList arrayList = new ArrayList();
                PdfArray asArray = item.getValue(0).getAsArray(PdfName.OPT);
                if (asArray != null) {
                    for (int i = 0; i < asArray.size(); i++) {
                        PdfString asString = asArray.getAsString(i);
                        if (asString != null) {
                            arrayList.add(asString.toUnicodeString());
                        } else {
                            arrayList.add(null);
                        }
                    }
                }
                int iIndexOf = arrayList.indexOf(str2);
                if (iIndexOf >= 0) {
                    pdfName2 = new PdfName(String.valueOf(iIndexOf));
                }
                for (int i2 = 0; i2 < item.size(); i2++) {
                    PdfDictionary merged2 = item.getMerged(i2);
                    PdfDictionary widget = item.getWidget(i2);
                    PdfDictionary value = item.getValue(i2);
                    markUsed(item.getValue(i2));
                    PdfName pdfName3 = PdfName.V;
                    value.put(pdfName3, pdfName2);
                    merged2.put(pdfName3, pdfName2);
                    markUsed(widget);
                    PdfDictionary asDict = widget.getAsDict(PdfName.AP);
                    if (asDict == null) {
                        return false;
                    }
                    PdfName pdfName4 = PdfName.N;
                    PdfDictionary asDict2 = asDict.getAsDict(pdfName4);
                    if (!isInAP(asDict2, pdfName2) && asDict2 != null) {
                        PdfName pdfName5 = PdfName.AS;
                        PdfObject pdfObject = PdfName.Off;
                        merged2.put(pdfName5, pdfObject);
                        widget.put(pdfName5, pdfObject);
                    } else {
                        PdfName pdfName6 = PdfName.AS;
                        merged2.put(pdfName6, pdfName2);
                        widget.put(pdfName6, pdfName2);
                    }
                    if (this.generateAppearances && !z) {
                        PdfAppearance appearance = getAppearance(merged2, str3, str);
                        if (asDict2 != null) {
                            asDict2.put(merged2.getAsName(PdfName.AS), appearance.getIndirectReference());
                        } else {
                            asDict.put(pdfName4, appearance.getIndirectReference());
                        }
                        this.writer.releaseTemplate(appearance);
                    }
                }
                return true;
            }
            PdfObject pdfString = new PdfString(str2, PdfObject.TEXT_UNICODE);
            for (int i3 = 0; i3 < item.size(); i3++) {
                PdfDictionary value2 = item.getValue(i3);
                PdfName pdfName7 = PdfName.V;
                value2.put(pdfName7, pdfString);
                PdfName pdfName8 = PdfName.I;
                value2.remove(pdfName8);
                markUsed(value2);
                PdfDictionary merged3 = item.getMerged(i3);
                merged3.remove(pdfName8);
                merged3.put(pdfName7, pdfString);
                PdfDictionary widget2 = item.getWidget(i3);
                if (this.generateAppearances) {
                    PdfAppearance appearance2 = getAppearance(merged3, str3, str);
                    if (PdfName.CH.equals(asName)) {
                        PdfObject pdfNumber = new PdfNumber(this.topFirst);
                        PdfName pdfName9 = PdfName.TI;
                        widget2.put(pdfName9, pdfNumber);
                        merged3.put(pdfName9, pdfNumber);
                    }
                    PdfName pdfName10 = PdfName.AP;
                    PdfDictionary asDict3 = widget2.getAsDict(pdfName10);
                    if (asDict3 == null) {
                        asDict3 = new PdfDictionary();
                        widget2.put(pdfName10, asDict3);
                        merged3.put(pdfName10, asDict3);
                    }
                    asDict3.put(PdfName.N, appearance2.getIndirectReference());
                    this.writer.releaseTemplate(appearance2);
                } else {
                    PdfName pdfName11 = PdfName.AP;
                    widget2.remove(pdfName11);
                    merged3.remove(pdfName11);
                }
                markUsed(widget2);
            }
            return true;
        }
        throw new DocumentException(MessageLocalization.getComposedMessage("this.acrofields.instance.is.read.only", new Object[0]));
    }

    public void setFields(XfdfReader xfdfReader) throws DocumentException {
        for (String str : xfdfReader.getFields().keySet()) {
            String fieldValue = xfdfReader.getFieldValue(str);
            if (fieldValue != null) {
                setField(str, fieldValue);
            }
            List<String> listValues = xfdfReader.getListValues(str);
            if (listValues != null) {
                setListSelection(fieldValue, (String[]) listValues.toArray(new String[listValues.size()]));
            }
        }
    }

    public boolean removeField(String str) {
        return removeField(str, -1);
    }

    public PdfAppearance getAppearance(PdfDictionary pdfDictionary, String str, String str2) {
        return getAppearance(pdfDictionary, new String[]{str}, str2);
    }

    public boolean setFieldProperty(String str, String str2, int i, int[] iArr) {
        int i2 = 0;
        if (this.writer != null) {
            Item item = this.fields.get(str);
            if (item == null) {
                return false;
            }
            InstHit instHit = new InstHit(iArr);
            if (str2.equalsIgnoreCase("flags")) {
                PdfNumber pdfNumber = new PdfNumber(i);
                while (i2 < item.size()) {
                    if (instHit.isHit(i2)) {
                        PdfDictionary merged = item.getMerged(i2);
                        PdfName pdfName = PdfName.F;
                        merged.put(pdfName, pdfNumber);
                        item.getWidget(i2).put(pdfName, pdfNumber);
                        markUsed(item.getWidget(i2));
                    }
                    i2++;
                }
                return true;
            }
            if (str2.equalsIgnoreCase("setflags")) {
                for (int i3 = 0; i3 < item.size(); i3++) {
                    if (instHit.isHit(i3)) {
                        PdfDictionary widget = item.getWidget(i3);
                        PdfName pdfName2 = PdfName.F;
                        PdfNumber asNumber = widget.getAsNumber(pdfName2);
                        PdfNumber pdfNumber2 = new PdfNumber((asNumber != null ? asNumber.intValue() : 0) | i);
                        item.getMerged(i3).put(pdfName2, pdfNumber2);
                        item.getWidget(i3).put(pdfName2, pdfNumber2);
                        markUsed(item.getWidget(i3));
                    }
                }
                return true;
            }
            if (str2.equalsIgnoreCase("clrflags")) {
                for (int i4 = 0; i4 < item.size(); i4++) {
                    if (instHit.isHit(i4)) {
                        PdfDictionary widget2 = item.getWidget(i4);
                        PdfName pdfName3 = PdfName.F;
                        PdfNumber asNumber2 = widget2.getAsNumber(pdfName3);
                        PdfNumber pdfNumber3 = new PdfNumber((asNumber2 != null ? asNumber2.intValue() : 0) & (~i));
                        item.getMerged(i4).put(pdfName3, pdfNumber3);
                        widget2.put(pdfName3, pdfNumber3);
                        markUsed(widget2);
                    }
                }
                return true;
            }
            if (str2.equalsIgnoreCase("fflags")) {
                PdfNumber pdfNumber4 = new PdfNumber(i);
                while (i2 < item.size()) {
                    if (instHit.isHit(i2)) {
                        PdfDictionary merged2 = item.getMerged(i2);
                        PdfName pdfName4 = PdfName.FF;
                        merged2.put(pdfName4, pdfNumber4);
                        item.getValue(i2).put(pdfName4, pdfNumber4);
                        markUsed(item.getValue(i2));
                    }
                    i2++;
                }
                return true;
            }
            if (str2.equalsIgnoreCase("setfflags")) {
                for (int i5 = 0; i5 < item.size(); i5++) {
                    if (instHit.isHit(i5)) {
                        PdfDictionary value = item.getValue(i5);
                        PdfName pdfName5 = PdfName.FF;
                        PdfNumber asNumber3 = value.getAsNumber(pdfName5);
                        PdfNumber pdfNumber5 = new PdfNumber((asNumber3 != null ? asNumber3.intValue() : 0) | i);
                        item.getMerged(i5).put(pdfName5, pdfNumber5);
                        value.put(pdfName5, pdfNumber5);
                        markUsed(value);
                    }
                }
                return true;
            }
            if (!str2.equalsIgnoreCase("clrfflags")) {
                return false;
            }
            for (int i6 = 0; i6 < item.size(); i6++) {
                if (instHit.isHit(i6)) {
                    PdfDictionary value2 = item.getValue(i6);
                    PdfName pdfName6 = PdfName.FF;
                    PdfNumber asNumber4 = value2.getAsNumber(pdfName6);
                    PdfNumber pdfNumber6 = new PdfNumber((asNumber4 != null ? asNumber4.intValue() : 0) & (~i));
                    item.getMerged(i6).put(pdfName6, pdfNumber6);
                    value2.put(pdfName6, pdfNumber6);
                    markUsed(value2);
                }
            }
            return true;
        }
        throw new RuntimeException(MessageLocalization.getComposedMessage("this.acrofields.instance.is.read.only", new Object[0]));
    }
}
