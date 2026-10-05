package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.factories.RomanAlphabetFactory;
import com.itextpdf.text.factories.RomanNumberFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPageLabels {
    public static final int DECIMAL_ARABIC_NUMERALS = 0;
    public static final int EMPTY = 5;
    public static final int LOWERCASE_LETTERS = 4;
    public static final int LOWERCASE_ROMAN_NUMERALS = 2;
    public static final int UPPERCASE_LETTERS = 3;
    public static final int UPPERCASE_ROMAN_NUMERALS = 1;
    static PdfName[] numberingStyle = {PdfName.D, PdfName.R, new PdfName("r"), PdfName.A, new PdfName("a")};
    private HashMap<Integer, PdfDictionary> map = new HashMap<>();

    public static class PdfPageLabelFormat {
        public int logicalPage;
        public int numberStyle;
        public int physicalPage;
        public String prefix;

        public PdfPageLabelFormat(int i, int i2, String str, int i3) {
            this.physicalPage = i;
            this.numberStyle = i2;
            this.prefix = str;
            this.logicalPage = i3;
        }

        public String toString() {
            return String.format("Physical page %s: style: %s; prefix '%s'; logical page: %s", Integer.valueOf(this.physicalPage), Integer.valueOf(this.numberStyle), this.prefix, Integer.valueOf(this.logicalPage));
        }
    }

    public PdfPageLabels() {
        addPageLabel(1, 0, null, 1);
    }

    public static PdfPageLabelFormat[] getPageLabelFormats(PdfReader pdfReader) {
        int i;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.PAGELABELS));
        if (pdfDictionary == null) {
            return null;
        }
        HashMap<Integer, PdfObject> tree = PdfNumberTree.readTree(pdfDictionary);
        Integer[] numArr = (Integer[]) tree.keySet().toArray(new Integer[tree.size()]);
        Arrays.sort(numArr);
        PdfPageLabelFormat[] pdfPageLabelFormatArr = new PdfPageLabelFormat[tree.size()];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            Integer num = numArr[i2];
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease(tree.get(num));
            PdfName pdfName = PdfName.ST;
            int iIntValue = pdfDictionary2.contains(pdfName) ? ((PdfNumber) pdfDictionary2.get(pdfName)).intValue() : 1;
            PdfName pdfName2 = PdfName.P;
            String unicodeString = pdfDictionary2.contains(pdfName2) ? ((PdfString) pdfDictionary2.get(pdfName2)).toUnicodeString() : "";
            PdfName pdfName3 = PdfName.S;
            if (pdfDictionary2.contains(pdfName3)) {
                char cCharAt = ((PdfName) pdfDictionary2.get(pdfName3)).toString().charAt(1);
                if (cCharAt == 'A') {
                    i = 3;
                } else if (cCharAt == 'R') {
                    i = 1;
                } else if (cCharAt != 'a') {
                    i = cCharAt != 'r' ? 0 : 2;
                } else {
                    i = 4;
                }
            } else {
                i = 5;
            }
            pdfPageLabelFormatArr[i2] = new PdfPageLabelFormat(num.intValue() + 1, i, unicodeString, iIntValue);
        }
        return pdfPageLabelFormatArr;
    }

    public static String[] getPageLabels(PdfReader pdfReader) {
        int numberOfPages = pdfReader.getNumberOfPages();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.PAGELABELS));
        if (pdfDictionary == null) {
            return null;
        }
        String[] strArr = new String[numberOfPages];
        HashMap<Integer, PdfObject> tree = PdfNumberTree.readTree(pdfDictionary);
        char cCharAt = 'D';
        String unicodeString = "";
        int iIntValue = 1;
        for (int i = 0; i < numberOfPages; i++) {
            Integer numValueOf = Integer.valueOf(i);
            if (tree.containsKey(numValueOf)) {
                PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease(tree.get(numValueOf));
                PdfName pdfName = PdfName.ST;
                iIntValue = pdfDictionary2.contains(pdfName) ? ((PdfNumber) pdfDictionary2.get(pdfName)).intValue() : 1;
                PdfName pdfName2 = PdfName.P;
                unicodeString = pdfDictionary2.contains(pdfName2) ? ((PdfString) pdfDictionary2.get(pdfName2)).toUnicodeString() : "";
                PdfName pdfName3 = PdfName.S;
                cCharAt = pdfDictionary2.contains(pdfName3) ? ((PdfName) pdfDictionary2.get(pdfName3)).toString().charAt(1) : Barcode128.CODE_BC_TO_A;
            }
            if (cCharAt == 'A') {
                strArr[i] = unicodeString + RomanAlphabetFactory.getUpperCaseString(iIntValue);
            } else if (cCharAt == 'R') {
                strArr[i] = unicodeString + RomanNumberFactory.getUpperCaseString(iIntValue);
            } else if (cCharAt == 'a') {
                strArr[i] = unicodeString + RomanAlphabetFactory.getLowerCaseString(iIntValue);
            } else if (cCharAt == 'e') {
                strArr[i] = unicodeString;
            } else if (cCharAt != 'r') {
                strArr[i] = unicodeString + iIntValue;
            } else {
                strArr[i] = unicodeString + RomanNumberFactory.getLowerCaseString(iIntValue);
            }
            iIntValue++;
        }
        return strArr;
    }

    public void addPageLabel(int i, int i2, String str, int i3) {
        if (i < 1 || i3 < 1) {
            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("in.a.page.label.the.page.numbers.must.be.greater.or.equal.to.1", new Object[0]));
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (i2 >= 0 && i2 < numberingStyle.length) {
            pdfDictionary.put(PdfName.S, numberingStyle[i2]);
        }
        if (str != null) {
            pdfDictionary.put(PdfName.P, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        if (i3 != 1) {
            pdfDictionary.put(PdfName.ST, new PdfNumber(i3));
        }
        this.map.put(Integer.valueOf(i - 1), pdfDictionary);
    }

    public PdfDictionary getDictionary(PdfWriter pdfWriter) {
        try {
            return PdfNumberTree.writeTree(this.map, pdfWriter);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void removePageLabel(int i) {
        if (i <= 1) {
            return;
        }
        this.map.remove(Integer.valueOf(i - 1));
    }

    public void addPageLabel(int i, int i2, String str, int i3, boolean z) {
        if (i >= 1 && i3 >= 1) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (i2 >= 0 && i2 < numberingStyle.length) {
                pdfDictionary.put(PdfName.S, numberingStyle[i2]);
            }
            if (str != null) {
                pdfDictionary.put(PdfName.P, new PdfString(str, PdfObject.TEXT_UNICODE));
            }
            if (i3 != 1 || z) {
                pdfDictionary.put(PdfName.ST, new PdfNumber(i3));
            }
            this.map.put(Integer.valueOf(i - 1), pdfDictionary);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("in.a.page.label.the.page.numbers.must.be.greater.or.equal.to.1", new Object[0]));
    }

    public void addPageLabel(int i, int i2, String str) {
        addPageLabel(i, i2, str, 1);
    }

    public void addPageLabel(int i, int i2) {
        addPageLabel(i, i2, null, 1);
    }

    public void addPageLabel(PdfPageLabelFormat pdfPageLabelFormat) {
        addPageLabel(pdfPageLabelFormat.physicalPage, pdfPageLabelFormat.numberStyle, pdfPageLabelFormat.prefix, pdfPageLabelFormat.logicalPage);
    }
}
