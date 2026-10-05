package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.simpleparser.IanaEncodings;
import com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler;
import com.itextpdf.text.xml.simpleparser.SimpleXMLParser;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public final class SimpleBookmark implements SimpleXMLDocHandler {
    private final Stack<HashMap<String, Object>> attr = new Stack<>();
    private ArrayList<HashMap<String, Object>> topList;

    private SimpleBookmark() {
    }

    private static List<HashMap<String, Object>> bookmarkDepth(PdfReader pdfReader, PdfDictionary pdfDictionary, IntHashtable intHashtable, boolean z) {
        ArrayList arrayList = new ArrayList();
        PdfDictionary pdfDictionary2 = pdfDictionary;
        while (pdfDictionary2 != null) {
            HashMap map = new HashMap();
            map.put("Title", ((PdfString) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.TITLE))).toUnicodeString());
            PdfArray pdfArray = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.C));
            if (pdfArray != null && pdfArray.size() == 3) {
                ByteBuffer byteBuffer = new ByteBuffer();
                byteBuffer.append(pdfArray.getAsNumber(0).floatValue()).append(' ');
                byteBuffer.append(pdfArray.getAsNumber(1).floatValue()).append(' ');
                byteBuffer.append(pdfArray.getAsNumber(2).floatValue());
                map.put("Color", PdfEncodings.convertToString(byteBuffer.toByteArray(), null));
            }
            PdfName pdfName = PdfName.F;
            PdfNumber pdfNumber = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary2.get(pdfName));
            if (pdfNumber != null) {
                int iIntValue = pdfNumber.intValue();
                String str = (iIntValue & 1) != 0 ? "italic " : "";
                if ((iIntValue & 2) != 0) {
                    str = str + "bold ";
                }
                String strTrim = str.trim();
                if (strTrim.length() != 0) {
                    map.put("Style", strTrim);
                }
            }
            PdfNumber pdfNumber2 = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.COUNT));
            if (pdfNumber2 != null && pdfNumber2.intValue() < 0) {
                map.put("Open", PdfBoolean.FALSE);
            }
            try {
                PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.DEST));
                if (pdfObjectRelease != null) {
                    mapGotoBookmark(map, pdfObjectRelease, intHashtable);
                } else {
                    PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.A));
                    if (pdfDictionary3 != null) {
                        PdfName pdfName2 = PdfName.GOTO;
                        PdfName pdfName3 = PdfName.S;
                        if (pdfName2.equals(PdfReader.getPdfObjectRelease(pdfDictionary3.get(pdfName3)))) {
                            PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(pdfDictionary3.get(PdfName.D));
                            if (pdfObjectRelease2 != null) {
                                mapGotoBookmark(map, pdfObjectRelease2, intHashtable);
                            }
                        } else {
                            PdfName pdfName4 = PdfName.URI;
                            if (pdfName4.equals(PdfReader.getPdfObjectRelease(pdfDictionary3.get(pdfName3)))) {
                                map.put("Action", "URI");
                                map.put("URI", ((PdfString) PdfReader.getPdfObjectRelease(pdfDictionary3.get(pdfName4))).toUnicodeString());
                            } else if (PdfName.JAVASCRIPT.equals(PdfReader.getPdfObjectRelease(pdfDictionary3.get(pdfName3)))) {
                                map.put("Action", "JS");
                                map.put("Code", PdfReader.getPdfObjectRelease(pdfDictionary3.get(PdfName.JS)).toString());
                            } else if (PdfName.GOTOR.equals(PdfReader.getPdfObjectRelease(pdfDictionary3.get(pdfName3)))) {
                                PdfObject pdfObjectRelease3 = PdfReader.getPdfObjectRelease(pdfDictionary3.get(PdfName.D));
                                if (pdfObjectRelease3 != null) {
                                    if (pdfObjectRelease3.isString()) {
                                        map.put("Named", pdfObjectRelease3.toString());
                                    } else if (pdfObjectRelease3.isName()) {
                                        map.put("NamedN", PdfName.decodeName(pdfObjectRelease3.toString()));
                                    } else if (pdfObjectRelease3.isArray()) {
                                        PdfArray pdfArray2 = (PdfArray) pdfObjectRelease3;
                                        StringBuffer stringBuffer = new StringBuffer();
                                        stringBuffer.append(pdfArray2.getPdfObject(0).toString());
                                        stringBuffer.append(' ');
                                        stringBuffer.append(pdfArray2.getPdfObject(1).toString());
                                        for (int i = 2; i < pdfArray2.size(); i++) {
                                            stringBuffer.append(' ');
                                            stringBuffer.append(pdfArray2.getPdfObject(i).toString());
                                        }
                                        map.put("Page", stringBuffer.toString());
                                    }
                                }
                                map.put("Action", "GoToR");
                                PdfName pdfName5 = PdfName.F;
                                PdfObject pdfObjectRelease4 = PdfReader.getPdfObjectRelease(pdfDictionary3.get(pdfName5));
                                if (pdfObjectRelease4 != null) {
                                    if (pdfObjectRelease4.isString()) {
                                        map.put("File", ((PdfString) pdfObjectRelease4).toUnicodeString());
                                    } else if (pdfObjectRelease4.isDictionary()) {
                                        PdfObject pdfObject = PdfReader.getPdfObject(((PdfDictionary) pdfObjectRelease4).get(pdfName5));
                                        if (pdfObject.isString()) {
                                            map.put("File", ((PdfString) pdfObject).toUnicodeString());
                                        }
                                    }
                                }
                                PdfObject pdfObjectRelease5 = PdfReader.getPdfObjectRelease(pdfDictionary3.get(PdfName.NEWWINDOW));
                                if (pdfObjectRelease5 != null) {
                                    map.put("NewWindow", pdfObjectRelease5.toString());
                                }
                            } else if (PdfName.LAUNCH.equals(PdfReader.getPdfObjectRelease(pdfDictionary3.get(pdfName3)))) {
                                map.put("Action", "Launch");
                                PdfObject pdfObjectRelease6 = PdfReader.getPdfObjectRelease(pdfDictionary3.get(pdfName));
                                if (pdfObjectRelease6 == null) {
                                    pdfObjectRelease6 = PdfReader.getPdfObjectRelease(pdfDictionary3.get(PdfName.WIN));
                                }
                                if (pdfObjectRelease6 != null) {
                                    if (pdfObjectRelease6.isString()) {
                                        map.put("File", ((PdfString) pdfObjectRelease6).toUnicodeString());
                                    } else if (pdfObjectRelease6.isDictionary()) {
                                        PdfObject pdfObjectRelease7 = PdfReader.getPdfObjectRelease(((PdfDictionary) pdfObjectRelease6).get(pdfName));
                                        if (pdfObjectRelease7.isString()) {
                                            map.put("File", ((PdfString) pdfObjectRelease7).toUnicodeString());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
            PdfDictionary pdfDictionary4 = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.FIRST));
            if (pdfDictionary4 != null) {
                map.put("Kids", bookmarkDepth(pdfReader, pdfDictionary4, intHashtable, false));
            }
            arrayList.add(map);
            pdfDictionary2 = !z ? (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.NEXT)) : null;
        }
        return arrayList;
    }

    public static void createOutlineAction(PdfDictionary pdfDictionary, HashMap<String, Object> map, PdfWriter pdfWriter, boolean z) {
        String str;
        try {
            String str2 = (String) map.get("Action");
            int i = 0;
            if ("GoTo".equals(str2)) {
                String str3 = (String) map.get("Named");
                if (str3 != null) {
                    if (z) {
                        pdfDictionary.put(PdfName.DEST, new PdfName(str3));
                        return;
                    } else {
                        pdfDictionary.put(PdfName.DEST, new PdfString(str3, null));
                        return;
                    }
                }
                String str4 = (String) map.get("Page");
                if (str4 != null) {
                    PdfArray pdfArray = new PdfArray();
                    StringTokenizer stringTokenizer = new StringTokenizer(str4);
                    pdfArray.add(pdfWriter.getPageReference(Integer.parseInt(stringTokenizer.nextToken())));
                    if (stringTokenizer.hasMoreTokens()) {
                        String strNextToken = stringTokenizer.nextToken();
                        if (strNextToken.startsWith("/")) {
                            strNextToken = strNextToken.substring(1);
                        }
                        pdfArray.add(new PdfName(strNextToken));
                        while (i < 4 && stringTokenizer.hasMoreTokens()) {
                            String strNextToken2 = stringTokenizer.nextToken();
                            if (strNextToken2.equals("null")) {
                                pdfArray.add(PdfNull.PDFNULL);
                            } else {
                                pdfArray.add(new PdfNumber(strNextToken2));
                            }
                            i++;
                        }
                    } else {
                        pdfArray.add(PdfName.XYZ);
                        pdfArray.add(new float[]{0.0f, 10000.0f, 0.0f});
                    }
                    pdfDictionary.put(PdfName.DEST, pdfArray);
                    return;
                }
                return;
            }
            if (!"GoToR".equals(str2)) {
                if ("URI".equals(str2)) {
                    String str5 = (String) map.get("URI");
                    if (str5 != null) {
                        PdfDictionary pdfDictionary2 = new PdfDictionary();
                        PdfName pdfName = PdfName.S;
                        PdfName pdfName2 = PdfName.URI;
                        pdfDictionary2.put(pdfName, pdfName2);
                        pdfDictionary2.put(pdfName2, new PdfString(str5));
                        pdfDictionary.put(PdfName.A, pdfDictionary2);
                        return;
                    }
                    return;
                }
                if ("JS".equals(str2)) {
                    String str6 = (String) map.get("Code");
                    if (str6 != null) {
                        pdfDictionary.put(PdfName.A, PdfAction.javaScript(str6, pdfWriter));
                        return;
                    }
                    return;
                }
                if (!"Launch".equals(str2) || (str = (String) map.get("File")) == null) {
                    return;
                }
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                pdfDictionary3.put(PdfName.S, PdfName.LAUNCH);
                pdfDictionary3.put(PdfName.F, new PdfString(str));
                pdfDictionary.put(PdfName.A, pdfDictionary3);
                return;
            }
            PdfDictionary pdfDictionary4 = new PdfDictionary();
            String str7 = (String) map.get("Named");
            if (str7 != null) {
                pdfDictionary4.put(PdfName.D, new PdfString(str7, null));
            } else {
                String str8 = (String) map.get("NamedN");
                if (str8 != null) {
                    pdfDictionary4.put(PdfName.D, new PdfName(str8));
                } else {
                    String str9 = (String) map.get("Page");
                    if (str9 != null) {
                        PdfArray pdfArray2 = new PdfArray();
                        StringTokenizer stringTokenizer2 = new StringTokenizer(str9);
                        pdfArray2.add(new PdfNumber(stringTokenizer2.nextToken()));
                        if (stringTokenizer2.hasMoreTokens()) {
                            String strNextToken3 = stringTokenizer2.nextToken();
                            if (strNextToken3.startsWith("/")) {
                                strNextToken3 = strNextToken3.substring(1);
                            }
                            pdfArray2.add(new PdfName(strNextToken3));
                            while (i < 4 && stringTokenizer2.hasMoreTokens()) {
                                String strNextToken4 = stringTokenizer2.nextToken();
                                if (strNextToken4.equals("null")) {
                                    pdfArray2.add(PdfNull.PDFNULL);
                                } else {
                                    pdfArray2.add(new PdfNumber(strNextToken4));
                                }
                                i++;
                            }
                        } else {
                            pdfArray2.add(PdfName.XYZ);
                            pdfArray2.add(new float[]{0.0f, 10000.0f, 0.0f});
                        }
                        pdfDictionary4.put(PdfName.D, pdfArray2);
                    }
                }
            }
            String str10 = (String) map.get("File");
            if (pdfDictionary4.size() <= 0 || str10 == null) {
                return;
            }
            pdfDictionary4.put(PdfName.S, PdfName.GOTOR);
            pdfDictionary4.put(PdfName.F, new PdfString(str10));
            String str11 = (String) map.get("NewWindow");
            if (str11 != null) {
                if (str11.equals(PdfBoolean.TRUE)) {
                    pdfDictionary4.put(PdfName.NEWWINDOW, PdfBoolean.PDFTRUE);
                } else if (str11.equals(PdfBoolean.FALSE)) {
                    pdfDictionary4.put(PdfName.NEWWINDOW, PdfBoolean.PDFFALSE);
                }
            }
            pdfDictionary.put(PdfName.A, pdfDictionary4);
        } catch (Exception unused) {
        }
    }

    public static void eliminatePages(List<HashMap<String, Object>> list, int[] iArr) {
        String str;
        if (list == null) {
            return;
        }
        ListIterator<HashMap<String, Object>> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            HashMap<String, Object> next = listIterator.next();
            boolean z = false;
            if ("GoTo".equals(next.get("Action")) && (str = (String) next.get("Page")) != null) {
                String strTrim = str.trim();
                int iIndexOf = strTrim.indexOf(32);
                int i = iIndexOf < 0 ? Integer.parseInt(strTrim) : Integer.parseInt(strTrim.substring(0, iIndexOf));
                int length = iArr.length & (-2);
                for (int i2 = 0; i2 < length; i2 += 2) {
                    if (i >= iArr[i2] && i <= iArr[i2 + 1]) {
                        z = true;
                        break;
                    }
                }
            }
            List list2 = (List) next.get("Kids");
            if (list2 != null) {
                eliminatePages(list2, iArr);
                if (list2.isEmpty()) {
                    next.remove("Kids");
                    list2 = null;
                }
            }
            if (z) {
                if (list2 == null) {
                    listIterator.remove();
                } else {
                    next.remove("Action");
                    next.remove("Page");
                    next.remove("Named");
                }
            }
        }
    }

    public static void exportToXML(List<HashMap<String, Object>> list, OutputStream outputStream, String str, boolean z) throws IOException {
        exportToXML(list, new BufferedWriter(new OutputStreamWriter(outputStream, IanaEncodings.getJavaEncoding(str))), str, z);
    }

    public static void exportToXMLNode(List<HashMap<String, Object>> list, Writer writer, int i, boolean z) throws IOException {
        String str;
        if (i != -1) {
            str = "";
            for (int i2 = 0; i2 < i; i2++) {
                str = str + "  ";
            }
        } else {
            str = "";
        }
        for (HashMap<String, Object> map : list) {
            writer.write(str);
            writer.write("<Title ");
            String str2 = null;
            List list2 = null;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key.equals("Title")) {
                    str2 = (String) entry.getValue();
                } else if (key.equals("Kids")) {
                    list2 = (List) entry.getValue();
                } else {
                    writer.write(key);
                    writer.write("=\"");
                    String strEscapeBinaryString = (String) entry.getValue();
                    if (key.equals("Named") || key.equals("NamedN")) {
                        strEscapeBinaryString = SimpleNamedDestination.escapeBinaryString(strEscapeBinaryString);
                    }
                    writer.write(XMLUtil.escapeXML(strEscapeBinaryString, z));
                    writer.write("\" ");
                }
            }
            writer.write(">");
            if (str2 == null) {
                str2 = "";
            }
            writer.write(XMLUtil.escapeXML(str2, z));
            if (list2 != null) {
                writer.write(StringUtilities.LF);
                exportToXMLNode(list2, writer, i == -1 ? i : i + 1, z);
                writer.write(str);
            }
            writer.write("</Title>\n");
        }
    }

    public static List<HashMap<String, Object>> getBookmark(PdfReader pdfReader) {
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.OUTLINES));
        if (pdfObjectRelease == null || !pdfObjectRelease.isDictionary()) {
            return null;
        }
        return getBookmark(pdfReader, (PdfDictionary) pdfObjectRelease, false);
    }

    private static int getNumber(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfIndirectReference);
        PdfName pdfName = PdfName.TYPE;
        if (pdfDictionary.contains(pdfName) && pdfDictionary.get(pdfName).equals(PdfName.PAGES)) {
            PdfName pdfName2 = PdfName.KIDS;
            if (pdfDictionary.contains(pdfName2)) {
                pdfIndirectReference = (PdfIndirectReference) ((PdfArray) pdfDictionary.get(pdfName2)).getPdfObject(0);
            }
        }
        return pdfIndirectReference.getNumber();
    }

    public static List<HashMap<String, Object>> importFromXML(InputStream inputStream) throws IOException {
        SimpleBookmark simpleBookmark = new SimpleBookmark();
        SimpleXMLParser.parse(simpleBookmark, inputStream);
        return simpleBookmark.topList;
    }

    public static Object[] iterateOutlines(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, List<HashMap<String, Object>> list, boolean z) {
        int i = 3;
        char c = 2;
        int size = list.size();
        PdfIndirectReference[] pdfIndirectReferenceArr = new PdfIndirectReference[size];
        char c2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            pdfIndirectReferenceArr[i2] = pdfWriter.getPdfIndirectReference();
        }
        ListIterator<HashMap<String, Object>> listIterator = list.listIterator();
        int i3 = 0;
        int i4 = 0;
        while (listIterator.hasNext()) {
            HashMap<String, Object> next = listIterator.next();
            List list2 = (List) next.get("Kids");
            Object[] objArrIterateOutlines = (list2 == null || list2.isEmpty()) ? null : iterateOutlines(pdfWriter, pdfIndirectReferenceArr[i4], list2, z);
            PdfDictionary pdfDictionary = new PdfDictionary();
            i3++;
            if (objArrIterateOutlines != null) {
                pdfDictionary.put(PdfName.FIRST, (PdfIndirectReference) objArrIterateOutlines[c2]);
                pdfDictionary.put(PdfName.LAST, (PdfIndirectReference) objArrIterateOutlines[1]);
                int iIntValue = ((Integer) objArrIterateOutlines[c]).intValue();
                if (PdfBoolean.FALSE.equals(next.get("Open"))) {
                    pdfDictionary.put(PdfName.COUNT, new PdfNumber(-iIntValue));
                } else {
                    pdfDictionary.put(PdfName.COUNT, new PdfNumber(iIntValue));
                    i3 += iIntValue;
                }
            }
            pdfDictionary.put(PdfName.PARENT, pdfIndirectReference);
            if (i4 > 0) {
                pdfDictionary.put(PdfName.PREV, pdfIndirectReferenceArr[i4 - 1]);
            }
            if (i4 < size - 1) {
                pdfDictionary.put(PdfName.NEXT, pdfIndirectReferenceArr[i4 + 1]);
            }
            pdfDictionary.put(PdfName.TITLE, new PdfString((String) next.get("Title"), PdfObject.TEXT_UNICODE));
            String str = (String) next.get("Color");
            if (str != null) {
                try {
                    PdfArray pdfArray = new PdfArray();
                    StringTokenizer stringTokenizer = new StringTokenizer(str);
                    int i5 = 0;
                    while (i5 < i) {
                        float f = Float.parseFloat(stringTokenizer.nextToken());
                        if (f < 0.0f) {
                            f = 0.0f;
                        }
                        if (f > 1.0f) {
                            f = 1.0f;
                        }
                        pdfArray.add(new PdfNumber(f));
                        i5++;
                        i = 3;
                    }
                    pdfDictionary.put(PdfName.C, pdfArray);
                } catch (Exception unused) {
                }
            }
            String str2 = (String) next.get("Style");
            if (str2 != null) {
                String lowerCase = str2.toLowerCase();
                int i6 = lowerCase.indexOf("italic") >= 0 ? 1 : 0;
                if (lowerCase.indexOf("bold") >= 0) {
                    i6 |= 2;
                }
                if (i6 != 0) {
                    pdfDictionary.put(PdfName.F, new PdfNumber(i6));
                }
            }
            createOutlineAction(pdfDictionary, next, pdfWriter, z);
            pdfWriter.addToBody(pdfDictionary, pdfIndirectReferenceArr[i4]);
            i4++;
            i = 3;
            c = 2;
            c2 = 0;
        }
        return new Object[]{pdfIndirectReferenceArr[0], pdfIndirectReferenceArr[size - 1], Integer.valueOf(i3)};
    }

    private static String makeBookmarkParam(PdfArray pdfArray, IntHashtable intHashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        PdfObject pdfObject = pdfArray.getPdfObject(0);
        if (pdfObject.isNumber()) {
            stringBuffer.append(((PdfNumber) pdfObject).intValue() + 1);
        } else {
            stringBuffer.append(intHashtable.get(getNumber((PdfIndirectReference) pdfObject)));
        }
        stringBuffer.append(' ');
        stringBuffer.append(pdfArray.getPdfObject(1).toString().substring(1));
        for (int i = 2; i < pdfArray.size(); i++) {
            stringBuffer.append(' ');
            stringBuffer.append(pdfArray.getPdfObject(i).toString());
        }
        return stringBuffer.toString();
    }

    private static void mapGotoBookmark(HashMap<String, Object> map, PdfObject pdfObject, IntHashtable intHashtable) {
        if (pdfObject.isString()) {
            map.put("Named", pdfObject.toString());
        } else if (pdfObject.isName()) {
            map.put("Named", PdfName.decodeName(pdfObject.toString()));
        } else if (pdfObject.isArray()) {
            map.put("Page", makeBookmarkParam((PdfArray) pdfObject, intHashtable));
        }
        map.put("Action", "GoTo");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX WARN: Code duplicated, block: B:25:0x005f  */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x005f, please report this as an issue */
    public static void shiftPageNumbers(List<HashMap<String, Object>> list, int i, int[] iArr) {
        String str;
        if (list == null) {
            return;
        }
        ListIterator<HashMap<String, Object>> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            HashMap next = listIterator.next();
            if ("GoTo".equals(next.get("Action")) && (str = (String) next.get("Page")) != null) {
                String strTrim = str.trim();
                int iIndexOf = strTrim.indexOf(32);
                int i2 = 0;
                int i3 = iIndexOf < 0 ? Integer.parseInt(strTrim) : Integer.parseInt(strTrim.substring(0, iIndexOf));
                if (iArr != null) {
                    int length = iArr.length & (-2);
                    while (true) {
                        if (i2 < length) {
                            if (i3 < iArr[i2] || i3 > iArr[i2 + 1]) {
                                i2 += 2;
                            } else if (iIndexOf < 0) {
                                strTrim = Integer.toString(i3 + i);
                            } else {
                                strTrim = (i3 + i) + strTrim.substring(iIndexOf);
                            }
                        }
                    }
                } else if (iIndexOf < 0) {
                    strTrim = Integer.toString(i3 + i);
                } else {
                    strTrim = (i3 + i) + strTrim.substring(iIndexOf);
                }
                next.put("Page", strTrim);
            }
            List list2 = (List) next.get("Kids");
            if (list2 != null) {
                shiftPageNumbers(list2, i, iArr);
            }
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void endElement(String str) {
        if (str.equals("Bookmark")) {
            if (!this.attr.isEmpty()) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("bookmark.end.tag.out.of.place", new Object[0]));
            }
            return;
        }
        if (!str.equals("Title")) {
            throw new RuntimeException(MessageLocalization.getComposedMessage("invalid.end.tag.1", str));
        }
        HashMap<String, Object> mapPop = this.attr.pop();
        mapPop.put("Title", ((String) mapPop.get("Title")).trim());
        String str2 = (String) mapPop.get("Named");
        if (str2 != null) {
            mapPop.put("Named", SimpleNamedDestination.unEscapeBinaryString(str2));
        }
        String str3 = (String) mapPop.get("NamedN");
        if (str3 != null) {
            mapPop.put("NamedN", SimpleNamedDestination.unEscapeBinaryString(str3));
        }
        if (this.attr.isEmpty()) {
            this.topList.add(mapPop);
            return;
        }
        HashMap mapPeek = this.attr.peek();
        List arrayList = (List) mapPeek.get("Kids");
        if (arrayList == null) {
            arrayList = new ArrayList();
            mapPeek.put("Kids", arrayList);
        }
        arrayList.add(mapPop);
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startDocument() {
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void startElement(String str, Map<String, String> map) {
        if (this.topList == null) {
            if (!str.equals("Bookmark")) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("root.element.is.not.bookmark.1", str));
            }
            this.topList = new ArrayList<>();
        } else {
            if (!str.equals("Title")) {
                throw new RuntimeException(MessageLocalization.getComposedMessage("tag.1.not.allowed", str));
            }
            HashMap<String, Object> map2 = new HashMap<>(map);
            map2.put("Title", "");
            map2.remove("Kids");
            this.attr.push(map2);
        }
    }

    @Override // com.itextpdf.text.xml.simpleparser.SimpleXMLDocHandler
    public void text(String str) {
        if (this.attr.isEmpty()) {
            return;
        }
        HashMap<String, Object> mapPeek = this.attr.peek();
        mapPeek.put("Title", ((String) mapPeek.get("Title")) + str);
    }

    public static void exportToXML(List<HashMap<String, Object>> list, Writer writer, String str, boolean z) throws IOException {
        writer.write("<?xml version=\"1.0\" encoding=\"");
        writer.write(XMLUtil.escapeXML(str, z));
        writer.write("\"?>\n<Bookmark>\n");
        exportToXMLNode(list, writer, 1, z);
        writer.write("</Bookmark>\n");
        writer.flush();
    }

    public static List<HashMap<String, Object>> importFromXML(Reader reader) throws IOException {
        SimpleBookmark simpleBookmark = new SimpleBookmark();
        SimpleXMLParser.parse(simpleBookmark, reader);
        return simpleBookmark.topList;
    }

    public static List<HashMap<String, Object>> getBookmark(PdfReader pdfReader, PdfDictionary pdfDictionary, boolean z) {
        pdfReader.getCatalog();
        if (pdfDictionary == null) {
            return null;
        }
        IntHashtable intHashtable = new IntHashtable();
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            intHashtable.put(pdfReader.getPageOrigRef(i).getNumber(), i);
            pdfReader.releasePage(i);
        }
        if (z) {
            return bookmarkDepth(pdfReader, pdfDictionary, intHashtable, true);
        }
        return bookmarkDepth(pdfReader, (PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIRST)), intHashtable, false);
    }
}
