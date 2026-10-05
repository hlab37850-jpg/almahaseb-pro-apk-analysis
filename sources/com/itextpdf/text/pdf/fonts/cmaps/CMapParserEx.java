package com.itextpdf.text.pdf.fonts.cmaps;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class CMapParserEx {
    private static final PdfName CMAPNAME = new PdfName("CMapName");
    private static final String DEF = "def";
    private static final String ENDBFCHAR = "endbfchar";
    private static final String ENDBFRANGE = "endbfrange";
    private static final String ENDCIDCHAR = "endcidchar";
    private static final String ENDCIDRANGE = "endcidrange";
    private static final int MAXLEVEL = 10;
    private static final String USECMAP = "usecmap";

    private static void encodeSequence(int i, byte[] bArr, char c, ArrayList<char[]> arrayList) {
        int i2 = i - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            char[] cArr = arrayList.get(i3);
            int i5 = bArr[i4] & UnsignedBytes.MAX_VALUE;
            char size = cArr[i5];
            if (size != 0 && (size & 32768) == 0) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.mapping", new Object[0]));
            }
            if (size == 0) {
                arrayList.add(new char[256]);
                size = (char) ((arrayList.size() - 1) | 32768);
                cArr[i5] = size;
            }
            i3 = size & BaseFont.CID_NEWLINE;
        }
        char[] cArr2 = arrayList.get(i3);
        int i6 = bArr[i2] & UnsignedBytes.MAX_VALUE;
        if ((cArr2[i6] & 32768) != 0) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("inconsistent.mapping", new Object[0]));
        }
        cArr2[i6] = c;
    }

    public static void parseCid(String str, AbstractCMap abstractCMap, CidLocation cidLocation) {
        parseCid(str, abstractCMap, cidLocation, 0);
    }

    private static void parseCid(String str, AbstractCMap abstractCMap, CidLocation cidLocation, int i) {
        if (i >= 10) {
            return;
        }
        PRTokeniser location = cidLocation.getLocation(str);
        try {
            ArrayList<PdfObject> arrayList = new ArrayList<>();
            PdfContentParser pdfContentParser = new PdfContentParser(location);
            int i2 = 50;
            while (true) {
                try {
                    pdfContentParser.parse(arrayList);
                    if (!arrayList.isEmpty()) {
                        String string = arrayList.get(arrayList.size() - 1).toString();
                        int i3 = 0;
                        if (i == 0 && arrayList.size() == 3 && string.equals(DEF)) {
                            PdfObject pdfObject = arrayList.get(0);
                            if (PdfName.REGISTRY.equals(pdfObject)) {
                                abstractCMap.setRegistry(arrayList.get(1).toString());
                            } else if (PdfName.ORDERING.equals(pdfObject)) {
                                abstractCMap.setOrdering(arrayList.get(1).toString());
                            } else if (CMAPNAME.equals(pdfObject)) {
                                abstractCMap.setName(arrayList.get(1).toString());
                            } else if (PdfName.SUPPLEMENT.equals(pdfObject)) {
                                try {
                                    abstractCMap.setSupplement(((PdfNumber) arrayList.get(1)).intValue());
                                } catch (Exception unused) {
                                }
                            }
                        } else if ((string.equals(ENDCIDCHAR) || string.equals(ENDBFCHAR)) && arrayList.size() >= 3) {
                            int size = arrayList.size() - 2;
                            while (i3 < size) {
                                if (arrayList.get(i3) instanceof PdfString) {
                                    abstractCMap.addChar((PdfString) arrayList.get(i3), arrayList.get(i3 + 1));
                                }
                                i3 += 2;
                            }
                        } else if ((string.equals(ENDCIDRANGE) || string.equals(ENDBFRANGE)) && arrayList.size() >= 4) {
                            int size2 = arrayList.size() - 3;
                            while (i3 < size2) {
                                if (arrayList.get(i3) instanceof PdfString) {
                                    int i4 = i3 + 1;
                                    if (arrayList.get(i4) instanceof PdfString) {
                                        abstractCMap.addRange((PdfString) arrayList.get(i3), (PdfString) arrayList.get(i4), arrayList.get(i3 + 2));
                                    }
                                }
                                i3 += 3;
                            }
                        } else if (string.equals(USECMAP) && arrayList.size() == 2 && (arrayList.get(0) instanceof PdfName)) {
                            parseCid(PdfName.decodeName(arrayList.get(0).toString()), abstractCMap, cidLocation, i + 1);
                        }
                    }
                } catch (Exception unused2) {
                    i2--;
                    if (i2 < 0) {
                    }
                }
            }
        } finally {
            location.close();
        }
    }
}
