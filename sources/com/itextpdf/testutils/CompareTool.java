package com.itextpdf.testutils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Meta;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfLiteral;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.RefKey;
import com.itextpdf.text.pdf.parser.ContentByteUtils;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.InlineImageInfo;
import com.itextpdf.text.pdf.parser.InlineImageUtils;
import com.itextpdf.text.pdf.parser.PdfContentStreamProcessor;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TaggedPdfReaderTool;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.text.xml.XMLUtil;
import com.itextpdf.text.xml.xmp.PdfProperties;
import com.itextpdf.text.xml.xmp.XmpBasicProperties;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.XMPUtils;
import com.itextpdf.xmp.options.SerializeOptions;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes3.dex */
public class CompareTool {
    private static final String cannotOpenTargetDirectory = "Cannot open target directory for <filename>.";
    private static final String differentPages = "File <filename> differs on page <pagenumber>.";
    private static final String gsFailed = "GhostScript failed for <filename>.";
    private static final String ignoredAreasPrefix = "ignored_areas_";
    private static final String undefinedGsPath = "Path to GhostScript is not specified. Please use -DgsExec=<path_to_ghostscript> (e.g. -DgsExec=\"C:/Program Files/gs/gs9.14/bin/gswin32c.exe\")";
    private static final String unexpectedNumberOfPages = "Unexpected number of pages for <filename>.";
    private String cmpImage;
    List<PdfDictionary> cmpPages;
    List<RefKey> cmpPagesRef;
    private String cmpPdf;
    private String cmpPdfName;
    private String compareExec;
    private String gsExec;
    private String outImage;
    List<PdfDictionary> outPages;
    List<RefKey> outPagesRef;
    private String outPdf;
    private String outPdfName;
    private final String gsParams = " -dNOPAUSE -dBATCH -sDEVICE=png16m -r150 -sOutputFile=<outputfile> <inputfile>";
    private final String compareParams = " \"<image1>\" \"<image2>\" \"<difference>\"";
    private int compareByContentErrorsLimit = 1;
    private boolean generateCompareByContentXmlReport = false;
    private String xmlReportName = "report";
    private double floatComparisonError = 0.0d;
    private boolean absoluteError = true;

    public class CmpMarkedContentRenderFilter implements RenderListener {
        Map<Integer, TextExtractionStrategy> tagsByMcid = new HashMap();

        public CmpMarkedContentRenderFilter() {
        }

        @Override // com.itextpdf.text.pdf.parser.RenderListener
        public void beginTextBlock() {
            for (Integer num : this.tagsByMcid.keySet()) {
                num.intValue();
                this.tagsByMcid.get(num).beginTextBlock();
            }
        }

        @Override // com.itextpdf.text.pdf.parser.RenderListener
        public void endTextBlock() {
            for (Integer num : this.tagsByMcid.keySet()) {
                num.intValue();
                this.tagsByMcid.get(num).endTextBlock();
            }
        }

        public Map<Integer, String> getParsedTagContent() {
            HashMap map = new HashMap();
            for (Integer num : this.tagsByMcid.keySet()) {
                num.intValue();
                map.put(num, this.tagsByMcid.get(num).getResultantText());
            }
            return map;
        }

        @Override // com.itextpdf.text.pdf.parser.RenderListener
        public void renderImage(ImageRenderInfo imageRenderInfo) {
        }

        @Override // com.itextpdf.text.pdf.parser.RenderListener
        public void renderText(TextRenderInfo textRenderInfo) {
            Integer mcid = textRenderInfo.getMcid();
            if (mcid != null && this.tagsByMcid.containsKey(mcid)) {
                this.tagsByMcid.get(mcid).renderText(textRenderInfo);
            } else if (mcid != null) {
                this.tagsByMcid.put(mcid, new SimpleTextExtractionStrategy());
                this.tagsByMcid.get(mcid).renderText(textRenderInfo);
            }
        }
    }

    public class CmpPngFileFilter implements FileFilter {
        public CmpPngFileFilter() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String absolutePath = file.getAbsolutePath();
            return absolutePath.endsWith(".png") && absolutePath.contains("cmp_") && absolutePath.contains(CompareTool.this.cmpPdfName);
        }
    }

    public class CmpTaggedPdfReaderTool extends TaggedPdfReaderTool {
        Map<PdfDictionary, Map<Integer, String>> parsedTags = new HashMap();

        public CmpTaggedPdfReaderTool() {
        }

        @Override // com.itextpdf.text.pdf.parser.TaggedPdfReaderTool
        public void inspectChildDictionary(PdfDictionary pdfDictionary) {
            inspectChildDictionary(pdfDictionary, true);
        }

        @Override // com.itextpdf.text.pdf.parser.TaggedPdfReaderTool
        public void parseTag(String str, PdfObject pdfObject, PdfDictionary pdfDictionary) {
            if (!(pdfObject instanceof PdfNumber)) {
                super.parseTag(str, pdfObject, pdfDictionary);
                return;
            }
            if (!this.parsedTags.containsKey(pdfDictionary)) {
                CmpMarkedContentRenderFilter cmpMarkedContentRenderFilter = CompareTool.this.new CmpMarkedContentRenderFilter();
                new PdfContentStreamProcessor(cmpMarkedContentRenderFilter).processContent(PdfReader.getPageContent(pdfDictionary), pdfDictionary.getAsDict(PdfName.RESOURCES));
                this.parsedTags.put(pdfDictionary, cmpMarkedContentRenderFilter.getParsedTagContent());
            }
            PdfNumber pdfNumber = (PdfNumber) pdfObject;
            this.out.print(XMLUtil.escapeXML(this.parsedTags.get(pdfDictionary).containsKey(Integer.valueOf(pdfNumber.intValue())) ? this.parsedTags.get(pdfDictionary).get(Integer.valueOf(pdfNumber.intValue())) : "", true));
        }
    }

    public class CompareResult {
        protected Map<ObjectPath, String> differences = new LinkedHashMap();
        protected int messageLimit;

        public CompareResult(int i) {
            this.messageLimit = i;
        }

        public void addError(ObjectPath objectPath, String str) {
            if (this.differences.size() < this.messageLimit) {
                this.differences.put((ObjectPath) objectPath.clone(), str);
            }
        }

        public int getErrorCount() {
            return this.differences.size();
        }

        public String getReport() {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (Map.Entry<ObjectPath, String> entry : this.differences.entrySet()) {
                if (!z) {
                    sb.append("-----------------------------");
                    sb.append(StringUtilities.LF);
                }
                ObjectPath key = entry.getKey();
                sb.append(entry.getValue());
                sb.append(StringUtilities.LF);
                sb.append(key.toString());
                sb.append(StringUtilities.LF);
                z = false;
            }
            return sb.toString();
        }

        public boolean isMessageLimitReached() {
            return this.differences.size() >= this.messageLimit;
        }

        public boolean isOk() {
            return this.differences.size() == 0;
        }

        public void writeReportToXml(OutputStream outputStream) throws TransformerException {
            Document documentNewDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element elementCreateElement = documentNewDocument.createElement("report");
            Element elementCreateElement2 = documentNewDocument.createElement("errors");
            elementCreateElement2.setAttribute("count", String.valueOf(this.differences.size()));
            elementCreateElement.appendChild(elementCreateElement2);
            for (Map.Entry<ObjectPath, String> entry : this.differences.entrySet()) {
                Element elementCreateElement3 = documentNewDocument.createElement("error");
                Element elementCreateElement4 = documentNewDocument.createElement("message");
                elementCreateElement4.appendChild(documentNewDocument.createTextNode(entry.getValue()));
                Node xmlNode = entry.getKey().toXmlNode(documentNewDocument);
                elementCreateElement3.appendChild(elementCreateElement4);
                elementCreateElement3.appendChild(xmlNode);
                elementCreateElement2.appendChild(elementCreateElement3);
            }
            documentNewDocument.appendChild(elementCreateElement);
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty(HtmlTags.INDENT, "yes");
            transformerNewTransformer.transform(new DOMSource(documentNewDocument), new StreamResult(outputStream));
        }
    }

    public class ImageNameComparator implements Comparator<File> {
        public ImageNameComparator() {
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getAbsolutePath().compareTo(file2.getAbsolutePath());
        }
    }

    public class PngFileFilter implements FileFilter {
        public PngFileFilter() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String absolutePath = file.getAbsolutePath();
            return absolutePath.endsWith(".png") && !absolutePath.contains("cmp_") && absolutePath.contains(CompareTool.this.outPdfName);
        }
    }

    public CompareTool() {
        String property = System.getProperty("gsExec");
        this.gsExec = property;
        if (property == null) {
            this.gsExec = System.getenv("gsExec");
        }
        String property2 = System.getProperty("compareExec");
        this.compareExec = property2;
        if (property2 == null) {
            this.compareExec = System.getenv("compareExec");
        }
    }

    private void addPagesFromDict(PdfObject pdfObject, List<PdfDictionary> list, List<RefKey> list2) {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pdfObject);
        if (!pdfDictionary.isPages()) {
            if (pdfDictionary.isPage()) {
                list.add(pdfDictionary);
                list2.add(new RefKey((PdfIndirectReference) pdfObject));
                return;
            }
            return;
        }
        PdfArray asArray = pdfDictionary.getAsArray(PdfName.KIDS);
        if (asArray == null) {
            return;
        }
        Iterator<PdfObject> it = asArray.iterator();
        while (it.hasNext()) {
            addPagesFromDict(it.next(), list, list2);
        }
    }

    private String compare(String str, String str2, Map<Integer, List<Rectangle>> map) {
        return compare(str, str2, map, (List<Integer>) null);
    }

    private boolean compareArraysExtended(PdfArray pdfArray, PdfArray pdfArray2, ObjectPath objectPath, CompareResult compareResult) {
        if (pdfArray == null) {
            if (compareResult != null && objectPath != null) {
                compareResult.addError(objectPath, "Found null. Expected PdfArray.");
            }
            return false;
        }
        if (pdfArray.size() != pdfArray2.size()) {
            if (compareResult != null && objectPath != null) {
                compareResult.addError(objectPath, String.format("PdfArrays. Lengths are different. Expected: %s. Found: %s.", Integer.valueOf(pdfArray2.size()), Integer.valueOf(pdfArray.size())));
            }
            return false;
        }
        boolean z = true;
        for (int i = 0; i < pdfArray2.size(); i++) {
            if (objectPath != null) {
                objectPath.pushArrayItemToPath(i);
            }
            z = compareObjects(pdfArray.getPdfObject(i), pdfArray2.getPdfObject(i), objectPath, compareResult) && z;
            if (objectPath != null) {
                objectPath.pop();
            }
            if (!z && (objectPath == null || compareResult == null || compareResult.isMessageLimitReached())) {
                return false;
            }
        }
        return z;
    }

    private boolean compareBooleansExtended(PdfBoolean pdfBoolean, PdfBoolean pdfBoolean2, ObjectPath objectPath, CompareResult compareResult) {
        if (pdfBoolean2.booleanValue() == pdfBoolean.booleanValue()) {
            return true;
        }
        if (compareResult != null && objectPath != null) {
            compareResult.addError(objectPath, String.format("PdfBoolean. Expected: %s. Found: %s.", Boolean.valueOf(pdfBoolean2.booleanValue()), Boolean.valueOf(pdfBoolean.booleanValue())));
        }
        return false;
    }

    private boolean compareContentStreamsByParsingExtended(PdfObject pdfObject, PdfObject pdfObject2, PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, ObjectPath objectPath, CompareResult compareResult) {
        int i = 2;
        if (pdfObject.type() != pdfObject.type()) {
            compareResult.addError(objectPath, String.format("PdfObject. Types are different. Expected: %s. Found: %s", Integer.valueOf(pdfObject2.type()), Integer.valueOf(pdfObject.type())));
            return false;
        }
        if (pdfObject.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            PdfArray pdfArray2 = (PdfArray) pdfObject2;
            if (pdfArray2.size() != pdfArray.size()) {
                compareResult.addError(objectPath, String.format("PdfArray. Sizes are different. Expected: %s. Found: %s", Integer.valueOf(pdfArray2.size()), Integer.valueOf(pdfArray.size())));
                return false;
            }
            for (int i2 = 0; i2 < pdfArray2.size(); i2++) {
                if (!compareContentStreamsByParsingExtended(pdfArray.getPdfObject(i2), pdfArray2.getPdfObject(i2), pdfDictionary, pdfDictionary2, objectPath, compareResult)) {
                    return false;
                }
            }
        }
        PRTokeniser pRTokeniser = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(ContentByteUtils.getContentBytesFromContentObject(pdfObject2))));
        PRTokeniser pRTokeniser2 = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(ContentByteUtils.getContentBytesFromContentObject(pdfObject))));
        PdfContentParser pdfContentParser = new PdfContentParser(pRTokeniser);
        PdfContentParser pdfContentParser2 = new PdfContentParser(pRTokeniser2);
        ArrayList<PdfObject> arrayList = new ArrayList<>();
        ArrayList<PdfObject> arrayList2 = new ArrayList<>();
        PdfDictionary pdfDictionary3 = pdfDictionary;
        PdfDictionary pdfDictionary4 = pdfDictionary2;
        while (pdfContentParser.parse(arrayList).size() > 0) {
            pdfContentParser2.parse(arrayList2);
            if (arrayList.size() != arrayList2.size()) {
                Integer numValueOf = Integer.valueOf(arrayList.size());
                Integer numValueOf2 = Integer.valueOf(arrayList2.size());
                Object[] objArr = new Object[i];
                objArr[0] = numValueOf;
                objArr[1] = numValueOf2;
                compareResult.addError(objectPath, String.format("PdfObject. Different commands lengths. Expected: %s. Found: %s", objArr));
                return false;
            }
            if (arrayList.size() == 1 && compareLiterals((PdfLiteral) arrayList.get(0), new PdfLiteral("BI")) && compareLiterals((PdfLiteral) arrayList2.get(0), new PdfLiteral("BI"))) {
                PRStream pRStream = (PRStream) pdfObject2;
                PRStream pRStream2 = (PRStream) pdfObject;
                PdfName pdfName = PdfName.RESOURCES;
                if (pRStream2.getDirectObject(pdfName) != null && pRStream.getDirectObject(pdfName) != null) {
                    pdfDictionary3 = (PdfDictionary) pRStream2.getDirectObject(pdfName);
                    pdfDictionary4 = (PdfDictionary) pRStream.getDirectObject(pdfName);
                }
                PdfDictionary pdfDictionary5 = pdfDictionary3;
                PdfDictionary pdfDictionary6 = pdfDictionary4;
                ArrayList<PdfObject> arrayList3 = arrayList2;
                if (!compareInlineImagesExtended(pdfContentParser2, pdfContentParser, pdfDictionary5, pdfDictionary6, objectPath, compareResult)) {
                    return false;
                }
                arrayList2 = arrayList3;
                pdfDictionary3 = pdfDictionary5;
                pdfDictionary4 = pdfDictionary6;
            } else {
                ArrayList<PdfObject> arrayList4 = arrayList2;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    if (!compareObjects(arrayList4.get(i3), arrayList.get(i3), objectPath, compareResult)) {
                        return false;
                    }
                }
                arrayList2 = arrayList4;
            }
            i = 2;
        }
        return true;
    }

    private boolean compareDictionariesExtended(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, ObjectPath objectPath, CompareResult compareResult) {
        char c = 2;
        if ((pdfDictionary2 != null && pdfDictionary == null) || (pdfDictionary != null && pdfDictionary2 == null)) {
            compareResult.addError(objectPath, "One of the dictionaries is null, the other is not.");
            return false;
        }
        TreeSet<PdfName> treeSet = new TreeSet(pdfDictionary2.getKeys());
        treeSet.addAll(pdfDictionary.getKeys());
        boolean z = true;
        for (PdfName pdfName : treeSet) {
            if (pdfName.compareTo(PdfName.PARENT) != 0 && pdfName.compareTo(PdfName.P) != 0 && (!pdfDictionary.isStream() || !pdfDictionary2.isStream() || (!pdfName.equals(PdfName.FILTER) && !pdfName.equals(PdfName.LENGTH)))) {
                if (pdfName.compareTo(PdfName.BASEFONT) == 0 || pdfName.compareTo(PdfName.FONTNAME) == 0) {
                    PdfObject directObject = pdfDictionary2.getDirectObject(pdfName);
                    if (directObject.isName() && directObject.toString().indexOf(43) > 0) {
                        PdfObject directObject2 = pdfDictionary.getDirectObject(pdfName);
                        if (!directObject2.isName() || directObject2.toString().indexOf(43) == -1) {
                            if (compareResult != null && objectPath != null) {
                                String string = pdfName.toString();
                                String string2 = directObject.toString();
                                String string3 = directObject2.toString();
                                Object[] objArr = new Object[3];
                                objArr[0] = string;
                                objArr[1] = string2;
                                objArr[c] = string3;
                                compareResult.addError(objectPath, String.format("PdfDictionary %s entry: Expected: %s. Found: %s", objArr));
                            }
                            z = false;
                        }
                        if (directObject.toString().substring(directObject.toString().indexOf(43)).equals(directObject2.toString().substring(directObject2.toString().indexOf(43)))) {
                            c = 2;
                        } else {
                            if (compareResult == null || objectPath == null) {
                                c = 2;
                            } else {
                                c = 2;
                                compareResult.addError(objectPath, String.format("PdfDictionary %s entry: Expected: %s. Found: %s", pdfName.toString(), directObject.toString(), directObject2.toString()));
                            }
                            z = false;
                        }
                    }
                }
                if (this.floatComparisonError != 0.0d && pdfDictionary2.isPage() && pdfDictionary.isPage() && pdfName.equals(PdfName.CONTENTS)) {
                    PdfObject directObject3 = pdfDictionary.getDirectObject(pdfName);
                    PdfObject directObject4 = pdfDictionary2.getDirectObject(pdfName);
                    PdfName pdfName2 = PdfName.RESOURCES;
                    if (!compareContentStreamsByParsingExtended(directObject3, directObject4, (PdfDictionary) pdfDictionary.getDirectObject(pdfName2), (PdfDictionary) pdfDictionary2.getDirectObject(pdfName2), objectPath, compareResult)) {
                        z = false;
                    }
                } else {
                    if (objectPath != null) {
                        objectPath.pushDictItemToPath(pdfName.toString());
                    }
                    z = compareObjects(pdfDictionary.get(pdfName), pdfDictionary2.get(pdfName), objectPath, compareResult) && z;
                    if (objectPath != null) {
                        objectPath.pop();
                    }
                    if (!z && (objectPath == null || compareResult == null || compareResult.isMessageLimitReached())) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    private boolean compareInlineImagesExtended(PdfContentParser pdfContentParser, PdfContentParser pdfContentParser2, PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, ObjectPath objectPath, CompareResult compareResult) throws IOException {
        InlineImageInfo inlineImage = InlineImageUtils.parseInlineImage(pdfContentParser2, pdfDictionary2);
        InlineImageInfo inlineImage2 = InlineImageUtils.parseInlineImage(pdfContentParser, pdfDictionary);
        return compareObjects(inlineImage2.getImageDictionary(), inlineImage.getImageDictionary(), objectPath, compareResult) && Arrays.equals(inlineImage2.getSamples(), inlineImage.getSamples());
    }

    private boolean compareLiteralsExtended(PdfLiteral pdfLiteral, PdfLiteral pdfLiteral2, ObjectPath objectPath, CompareResult compareResult) {
        if (compareLiterals(pdfLiteral, pdfLiteral2)) {
            return true;
        }
        if (compareResult != null && objectPath != null) {
            compareResult.addError(objectPath, String.format("PdfLiteral. Expected: %s. Found: %s", pdfLiteral2, pdfLiteral));
        }
        return false;
    }

    private boolean compareNamesExtended(PdfName pdfName, PdfName pdfName2, ObjectPath objectPath, CompareResult compareResult) {
        if (pdfName2.compareTo(pdfName) == 0) {
            return true;
        }
        if (compareResult != null && objectPath != null) {
            compareResult.addError(objectPath, String.format("PdfName. Expected: %s. Found: %s", pdfName2.toString(), pdfName.toString()));
        }
        return false;
    }

    private boolean compareNumbersExtended(PdfNumber pdfNumber, PdfNumber pdfNumber2, ObjectPath objectPath, CompareResult compareResult) {
        if (compareNumbers(pdfNumber, pdfNumber2)) {
            return true;
        }
        if (compareResult != null && objectPath != null) {
            compareResult.addError(objectPath, String.format("PdfNumber. Expected: %s. Found: %s", pdfNumber2, pdfNumber));
        }
        return false;
    }

    private boolean compareObjects(PdfObject pdfObject, PdfObject pdfObject2, ObjectPath objectPath, CompareResult compareResult) {
        PdfObject pdfObject3 = PdfReader.getPdfObject(pdfObject);
        PdfObject pdfObject4 = PdfReader.getPdfObject(pdfObject2);
        if (pdfObject4 == null && pdfObject3 == null) {
            return true;
        }
        if (pdfObject3 == null) {
            compareResult.addError(objectPath, "Expected object was not found.");
            return false;
        }
        if (pdfObject4 == null) {
            compareResult.addError(objectPath, "Found object which was not expected to be found.");
            return false;
        }
        if (pdfObject4.type() != pdfObject3.type()) {
            compareResult.addError(objectPath, String.format("Types do not match. Expected: %s. Found: %s.", pdfObject4.getClass().getSimpleName(), pdfObject3.getClass().getSimpleName()));
            return false;
        }
        if (pdfObject2.isIndirect() && pdfObject.isIndirect()) {
            PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) pdfObject2;
            PdfIndirectReference pdfIndirectReference2 = (PdfIndirectReference) pdfObject;
            if (objectPath.isComparing(new RefKey(pdfIndirectReference), new RefKey(pdfIndirectReference2))) {
                return true;
            }
            objectPath = objectPath.resetDirectPath(new RefKey(pdfIndirectReference), new RefKey(pdfIndirectReference2));
        }
        if (pdfObject4.isDictionary() && ((PdfDictionary) pdfObject4).isPage()) {
            if (!pdfObject3.isDictionary() || !((PdfDictionary) pdfObject3).isPage()) {
                if (compareResult != null && objectPath != null) {
                    compareResult.addError(objectPath, "Expected a page. Found not a page.");
                }
                return false;
            }
            RefKey refKey = new RefKey((PdfIndirectReference) pdfObject2);
            RefKey refKey2 = new RefKey((PdfIndirectReference) pdfObject);
            if (this.cmpPagesRef.contains(refKey) && this.cmpPagesRef.indexOf(refKey) == this.outPagesRef.indexOf(refKey2)) {
                return true;
            }
            if (compareResult != null && objectPath != null) {
                compareResult.addError(objectPath, String.format("The dictionaries refer to different pages. Expected page number: %s. Found: %s", Integer.valueOf(this.cmpPagesRef.indexOf(refKey)), Integer.valueOf(this.outPagesRef.indexOf(refKey2))));
            }
            return false;
        }
        if (pdfObject4.isDictionary()) {
            if (!compareDictionariesExtended((PdfDictionary) pdfObject3, (PdfDictionary) pdfObject4, objectPath, compareResult)) {
                return false;
            }
        } else if (pdfObject4.isStream()) {
            if (!compareStreamsExtended((PRStream) pdfObject3, (PRStream) pdfObject4, objectPath, compareResult)) {
                return false;
            }
        } else if (pdfObject4.isArray()) {
            if (!compareArraysExtended((PdfArray) pdfObject3, (PdfArray) pdfObject4, objectPath, compareResult)) {
                return false;
            }
        } else if (pdfObject4.isName()) {
            if (!compareNamesExtended((PdfName) pdfObject3, (PdfName) pdfObject4, objectPath, compareResult)) {
                return false;
            }
        } else if (pdfObject4.isNumber()) {
            if (!compareNumbersExtended((PdfNumber) pdfObject3, (PdfNumber) pdfObject4, objectPath, compareResult)) {
                return false;
            }
        } else if (pdfObject4.isString()) {
            if (!compareStringsExtended((PdfString) pdfObject3, (PdfString) pdfObject4, objectPath, compareResult)) {
                return false;
            }
        } else if (pdfObject4.isBoolean()) {
            if (!compareBooleansExtended((PdfBoolean) pdfObject3, (PdfBoolean) pdfObject4, objectPath, compareResult)) {
                return false;
            }
        } else if (pdfObject4 instanceof PdfLiteral) {
            if (!compareLiteralsExtended((PdfLiteral) pdfObject3, (PdfLiteral) pdfObject4, objectPath, compareResult)) {
                return false;
            }
        } else if (!pdfObject3.isNull() || !pdfObject4.isNull()) {
            throw new UnsupportedOperationException();
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0121  */
    private boolean compareStreamsExtended(PRStream pRStream, PRStream pRStream2, ObjectPath objectPath, CompareResult compareResult) {
        boolean zEquals = PdfName.FLATEDECODE.equals(pRStream.get(PdfName.FILTER));
        byte[] streamBytesRaw = PdfReader.getStreamBytesRaw(pRStream);
        byte[] streamBytesRaw2 = PdfReader.getStreamBytesRaw(pRStream2);
        if (zEquals) {
            streamBytesRaw = PdfReader.decodeBytes(streamBytesRaw, pRStream);
            streamBytesRaw2 = PdfReader.decodeBytes(streamBytesRaw2, pRStream2);
        }
        if (this.floatComparisonError != 0.0d) {
            PdfName pdfName = PdfName.XOBJECT;
            PdfName pdfName2 = PdfName.TYPE;
            if (pdfName.equals(pRStream2.getDirectObject(pdfName2)) && pdfName.equals(pRStream.getDirectObject(pdfName2))) {
                PdfName pdfName3 = PdfName.FORM;
                PdfName pdfName4 = PdfName.SUBTYPE;
                if (pdfName3.equals(pRStream2.getDirectObject(pdfName4)) && pdfName3.equals(pRStream.getDirectObject(pdfName4))) {
                    PdfName pdfName5 = PdfName.RESOURCES;
                    return compareContentStreamsByParsingExtended(pRStream, pRStream2, pRStream.getAsDict(pdfName5), pRStream2.getAsDict(pdfName5), objectPath, compareResult) && compareDictionariesExtended(pRStream, pRStream2, objectPath, compareResult);
                }
            }
        }
        if (Arrays.equals(streamBytesRaw, streamBytesRaw2)) {
            return compareDictionariesExtended(pRStream, pRStream2, objectPath, compareResult);
        }
        if (streamBytesRaw2.length == streamBytesRaw.length) {
            int i = 0;
            while (i < streamBytesRaw2.length) {
                if (streamBytesRaw2[i] != streamBytesRaw[i]) {
                    int iMax = Math.max(0, i - 10);
                    int iMin = Math.min(streamBytesRaw2.length, i + 10);
                    if (compareResult != null && objectPath != null) {
                        objectPath.pushOffsetToPath(i);
                        int i2 = iMin - iMax;
                        compareResult.addError(objectPath, String.format("PRStream. The bytes differ at index %s. Expected: %s (%s). Found: %s (%s)", Integer.valueOf(i), new String(new byte[]{streamBytesRaw2[i]}), new String(streamBytesRaw2, iMax, i2).replaceAll("\\n", "\\\\n"), new String(new byte[]{streamBytesRaw[i]}), new String(streamBytesRaw, iMax, i2).replaceAll("\\n", "\\\\n")));
                        objectPath.pop();
                    }
                }
                i++;
                streamBytesRaw2 = streamBytesRaw2;
            }
        } else if (compareResult != null && objectPath != null) {
            compareResult.addError(objectPath, String.format("PRStream. Lengths are different. Expected: %s. Found: %s", Integer.valueOf(streamBytesRaw2.length), Integer.valueOf(streamBytesRaw.length)));
        }
        return false;
    }

    private boolean compareStringsExtended(PdfString pdfString, PdfString pdfString2, ObjectPath objectPath, CompareResult compareResult) {
        if (Arrays.equals(pdfString2.getBytes(), pdfString.getBytes())) {
            return true;
        }
        String unicodeString = pdfString2.toUnicodeString();
        String unicodeString2 = pdfString.toUnicodeString();
        if (unicodeString.length() == unicodeString2.length()) {
            for (int i = 0; i < unicodeString.length(); i++) {
                if (unicodeString.charAt(i) != unicodeString2.charAt(i)) {
                    int iMax = Math.max(0, i - 10);
                    int iMin = Math.min(unicodeString.length(), i + 10);
                    if (compareResult != null && objectPath != null) {
                        objectPath.pushOffsetToPath(i);
                        compareResult.addError(objectPath, String.format("PdfString. Characters differ at position %s. Expected: %s (%s). Found: %s (%s).", Integer.valueOf(i), Character.toString(unicodeString.charAt(i)), unicodeString.substring(iMax, iMin).replace(StringUtilities.LF, "\\n"), Character.toString(unicodeString2.charAt(i)), unicodeString2.substring(iMax, iMin).replace(StringUtilities.LF, "\\n")));
                        objectPath.pop();
                        break;
                    }
                    break;
                    break;
                }
            }
        } else if (compareResult != null && objectPath != null) {
            compareResult.addError(objectPath, String.format("PdfString. Lengths are different. Expected: %s. Found: %s", Integer.valueOf(unicodeString.length()), Integer.valueOf(unicodeString2.length())));
        }
        return false;
    }

    private String[] convertInfo(HashMap<String, String> map) {
        String[] strArr = {"", "", "", ""};
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if ("title".equalsIgnoreCase(entry.getKey())) {
                strArr[0] = entry.getValue();
            } else if (Meta.AUTHOR.equalsIgnoreCase(entry.getKey())) {
                strArr[1] = entry.getValue();
            } else if ("subject".equalsIgnoreCase(entry.getKey())) {
                strArr[2] = entry.getValue();
            } else if (Meta.KEYWORDS.equalsIgnoreCase(entry.getKey())) {
                strArr[3] = entry.getValue();
            }
        }
        return strArr;
    }

    private void init(String str, String str2) {
        this.outPdf = str;
        this.cmpPdf = str2;
        this.outPdfName = new File(str).getName();
        this.cmpPdfName = new File(str2).getName();
        this.outImage = this.outPdfName + "-%03d.png";
        if (this.cmpPdfName.startsWith("cmp_")) {
            this.cmpImage = this.cmpPdfName + "-%03d.png";
            return;
        }
        this.cmpImage = "cmp_" + this.cmpPdfName + "-%03d.png";
    }

    private boolean linksAreSame(PdfAnnotation.PdfImportedLink pdfImportedLink, PdfAnnotation.PdfImportedLink pdfImportedLink2) {
        if (pdfImportedLink.getDestinationPage() != pdfImportedLink2.getDestinationPage() || !pdfImportedLink.getRect().toString().equals(pdfImportedLink2.getRect().toString())) {
            return false;
        }
        Map<PdfName, PdfObject> parameters = pdfImportedLink.getParameters();
        Map<PdfName, PdfObject> parameters2 = pdfImportedLink2.getParameters();
        if (parameters.size() != parameters2.size()) {
            return false;
        }
        for (Map.Entry<PdfName, PdfObject> entry : parameters.entrySet()) {
            PdfObject value = entry.getValue();
            if (!parameters2.containsKey(entry.getKey())) {
                return false;
            }
            PdfObject pdfObject = parameters2.get(entry.getKey());
            if (value.type() != pdfObject.type()) {
                return false;
            }
            int iType = value.type();
            if (iType == 1 || iType == 2 || iType == 3 || iType == 4 || iType == 8) {
                if (!value.toString().equals(pdfObject.toString())) {
                    return false;
                }
            }
        }
        return true;
    }

    private void loadPagesFromReader(PdfReader pdfReader, List<PdfDictionary> list, List<RefKey> list2) {
        addPagesFromDict(pdfReader.getCatalog().get(PdfName.PAGES), list, list2);
    }

    private Process runProcess(String str, String str2) {
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        String[] strArr = new String[stringTokenizer.countTokens() + 1];
        strArr[0] = str;
        int i = 1;
        while (stringTokenizer.hasMoreTokens()) {
            strArr[i] = stringTokenizer.nextToken();
            i++;
        }
        return Runtime.getRuntime().exec(strArr);
    }

    public boolean compareArrays(PdfArray pdfArray, PdfArray pdfArray2) {
        return compareArraysExtended(pdfArray, pdfArray2, null, null);
    }

    public boolean compareBooleans(PdfBoolean pdfBoolean, PdfBoolean pdfBoolean2) {
        return Arrays.equals(pdfBoolean2.getBytes(), pdfBoolean.getBytes());
    }

    public String compareByContent(String str, String str2, Map<Integer, List<Rectangle>> map) throws DocumentException, IOException {
        System.out.print("[itext] INFO  Comparing by content..........");
        PdfReader pdfReader = new PdfReader(this.outPdf);
        this.outPages = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.outPagesRef = arrayList;
        loadPagesFromReader(pdfReader, this.outPages, arrayList);
        PdfReader pdfReader2 = new PdfReader(this.cmpPdf);
        this.cmpPages = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.cmpPagesRef = arrayList2;
        loadPagesFromReader(pdfReader2, this.cmpPages, arrayList2);
        if (this.outPages.size() != this.cmpPages.size()) {
            return compare(str, str2, map);
        }
        CompareResult compareResult = new CompareResult(this.compareByContentErrorsLimit);
        ArrayList arrayList3 = new ArrayList(this.cmpPages.size());
        for (int i = 0; i < this.cmpPages.size(); i++) {
            if (compareDictionariesExtended(this.outPages.get(i), this.cmpPages.get(i), new ObjectPath(this.cmpPagesRef.get(i), this.outPagesRef.get(i)), compareResult)) {
                arrayList3.add(Integer.valueOf(i));
            }
        }
        PdfDictionary catalog = pdfReader.getCatalog();
        PdfName pdfName = PdfName.STRUCTTREEROOT;
        PdfObject pdfObject = catalog.get(pdfName);
        PdfObject pdfObject2 = pdfReader2.getCatalog().get(pdfName);
        compareObjects(pdfObject, pdfObject2, new ObjectPath(pdfObject == null ? null : new RefKey((PdfIndirectReference) pdfObject), pdfObject2 == null ? null : new RefKey((PdfIndirectReference) pdfObject2)), compareResult);
        PdfDictionary catalog2 = pdfReader.getCatalog();
        PdfName pdfName2 = PdfName.OCPROPERTIES;
        PdfObject pdfObject3 = catalog2.get(pdfName2);
        PdfObject pdfObject4 = pdfReader2.getCatalog().get(pdfName2);
        compareObjects(pdfObject3, pdfObject4, new ObjectPath(pdfObject3 instanceof PdfIndirectReference ? new RefKey((PdfIndirectReference) pdfObject3) : null, pdfObject4 instanceof PdfIndirectReference ? new RefKey((PdfIndirectReference) pdfObject4) : null), compareResult);
        pdfReader.close();
        pdfReader2.close();
        if (this.generateCompareByContentXmlReport) {
            try {
                compareResult.writeReportToXml(new FileOutputStream(str + "/" + this.xmlReportName + ".xml"));
            } catch (Exception unused) {
            }
        }
        if (arrayList3.size() == this.cmpPages.size() && compareResult.isOk()) {
            PrintStream printStream = System.out;
            printStream.println("OK");
            printStream.flush();
            return null;
        }
        PrintStream printStream2 = System.out;
        printStream2.println("Fail");
        printStream2.flush();
        printStream2.println("Compare by content report:\n" + compareResult.getReport());
        printStream2.flush();
        String strCompare = compare(str, str2, map, arrayList3);
        return (strCompare == null || strCompare.length() == 0) ? "Compare by content fails. No visual differences" : strCompare;
    }

    public boolean compareContentStreamsByParsing(PdfObject pdfObject, PdfObject pdfObject2) {
        return compareContentStreamsByParsingExtended(pdfObject, pdfObject2, null, null, null, null);
    }

    public boolean compareDictionaries(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        return compareDictionariesExtended(pdfDictionary, pdfDictionary2, null, null);
    }

    public String compareDocumentInfo(String str, String str2) {
        String str3;
        System.out.print("[itext] INFO  Comparing document info.......");
        PdfReader pdfReader = new PdfReader(str);
        PdfReader pdfReader2 = new PdfReader(str2);
        String[] strArrConvertInfo = convertInfo(pdfReader2.getInfo());
        String[] strArrConvertInfo2 = convertInfo(pdfReader.getInfo());
        int i = 0;
        while (true) {
            if (i >= strArrConvertInfo.length) {
                str3 = null;
                break;
            }
            if (!strArrConvertInfo[i].equals(strArrConvertInfo2[i])) {
                str3 = "Document info fail";
                break;
            }
            i++;
        }
        pdfReader.close();
        pdfReader2.close();
        if (str3 == null) {
            System.out.println("OK");
        } else {
            System.out.println("Fail");
        }
        System.out.flush();
        return str3;
    }

    public String compareLinks(String str, String str2) {
        System.out.print("[itext] INFO  Comparing link annotations....");
        PdfReader pdfReader = new PdfReader(str);
        PdfReader pdfReader2 = new PdfReader(str2);
        String str3 = null;
        int i = 0;
        while (i < pdfReader.getNumberOfPages() && i < pdfReader2.getNumberOfPages()) {
            i++;
            ArrayList<PdfAnnotation.PdfImportedLink> links = pdfReader.getLinks(i);
            ArrayList<PdfAnnotation.PdfImportedLink> links2 = pdfReader2.getLinks(i);
            if (links2.size() != links.size()) {
                str3 = String.format("Different number of links on page %d.", Integer.valueOf(i));
                break;
            }
            for (int i2 = 0; i2 < links2.size(); i2++) {
                if (!linksAreSame(links2.get(i2), links.get(i2))) {
                    str3 = String.format("Different links on page %d.\n%s\n%s", Integer.valueOf(i), links2.get(i2).toString(), links.get(i2).toString());
                    break;
                }
            }
        }
        pdfReader.close();
        pdfReader2.close();
        if (str3 == null) {
            System.out.println("OK");
        } else {
            System.out.println("Fail");
        }
        System.out.flush();
        return str3;
    }

    public boolean compareLiterals(PdfLiteral pdfLiteral, PdfLiteral pdfLiteral2) {
        return Arrays.equals(pdfLiteral2.getBytes(), pdfLiteral.getBytes());
    }

    public boolean compareNames(PdfName pdfName, PdfName pdfName2) {
        return pdfName2.compareTo(pdfName) == 0;
    }

    public boolean compareNumbers(PdfNumber pdfNumber, PdfNumber pdfNumber2) {
        double dAbs = Math.abs(pdfNumber.doubleValue() - pdfNumber2.doubleValue());
        if (!this.absoluteError && pdfNumber2.doubleValue() != 0.0d) {
            dAbs /= pdfNumber2.doubleValue();
        }
        return dAbs <= this.floatComparisonError;
    }

    public boolean compareStreams(PRStream pRStream, PRStream pRStream2) {
        return compareStreamsExtended(pRStream, pRStream2, null, null);
    }

    public boolean compareStrings(PdfString pdfString, PdfString pdfString2) {
        return Arrays.equals(pdfString2.getBytes(), pdfString.getBytes());
    }

    public String compareTagStructures(String str, String str2) throws IOException {
        PrintStream printStream = System.out;
        printStream.print("[itext] INFO  Comparing tag structures......");
        String strReplace = str.replace(".pdf", ".xml");
        String strReplace2 = str.replace(".pdf", ".cmp.xml");
        PdfReader pdfReader = new PdfReader(str);
        FileOutputStream fileOutputStream = new FileOutputStream(strReplace);
        new CmpTaggedPdfReaderTool().convertToXml(pdfReader, fileOutputStream);
        pdfReader.close();
        PdfReader pdfReader2 = new PdfReader(str2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(strReplace2);
        new CmpTaggedPdfReaderTool().convertToXml(pdfReader2, fileOutputStream2);
        pdfReader2.close();
        String str3 = !compareXmls(strReplace, strReplace2) ? "The tag structures are different." : null;
        fileOutputStream.close();
        fileOutputStream2.close();
        if (str3 == null) {
            printStream.println("OK");
        } else {
            printStream.println("Fail");
        }
        printStream.flush();
        return str3;
    }

    public boolean compareXmls(byte[] bArr, byte[] bArr2) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setCoalescing(true);
        documentBuilderFactoryNewInstance.setIgnoringElementContentWhitespace(true);
        documentBuilderFactoryNewInstance.setIgnoringComments(true);
        DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
        Document document = documentBuilderNewDocumentBuilder.parse(new ByteArrayInputStream(bArr));
        document.normalizeDocument();
        Document document2 = documentBuilderNewDocumentBuilder.parse(new ByteArrayInputStream(bArr2));
        document2.normalizeDocument();
        return document2.isEqualNode(document);
    }

    public String compareXmp(byte[] bArr, byte[] bArr2) {
        return compareXmp(bArr, bArr2, false);
    }

    public String getXmlReportName() {
        return this.xmlReportName;
    }

    public CompareTool setCompareByContentErrorsLimit(int i) {
        this.compareByContentErrorsLimit = i;
        return this;
    }

    public CompareTool setFloatAbsoluteError(float f) {
        this.floatComparisonError = f;
        this.absoluteError = true;
        return this;
    }

    public CompareTool setFloatRelativeError(float f) {
        this.floatComparisonError = f;
        this.absoluteError = false;
        return this;
    }

    public void setGenerateCompareByContentXmlReport(boolean z) {
        this.generateCompareByContentXmlReport = z;
    }

    public void setXmlReportName(String str) {
        this.xmlReportName = str;
    }

    private String compare(String str, String str2, Map<Integer, List<Rectangle>> map, List<Integer> list) throws DocumentException, IOException {
        String strReplace;
        String str3 = str;
        if (this.gsExec == null) {
            return undefinedGsPath;
        }
        if (!new File(this.gsExec).exists()) {
            return new File(this.gsExec).getAbsolutePath() + " does not exist";
        }
        if (!str3.endsWith("/")) {
            str3 = str3 + "/";
        }
        File file = new File(str3);
        if (file.exists()) {
            for (File file2 : file.listFiles(new PngFileFilter())) {
                file2.delete();
            }
            for (File file3 : file.listFiles(new CmpPngFileFilter())) {
                file3.delete();
            }
        } else {
            file.mkdirs();
        }
        File file4 = new File(str3 + str2);
        if (file4.exists()) {
            file4.delete();
        }
        if (map != null && !map.isEmpty()) {
            PdfReader pdfReader = new PdfReader(this.cmpPdf);
            PdfReader pdfReader2 = new PdfReader(this.outPdf);
            PdfStamper pdfStamper = new PdfStamper(pdfReader2, new FileOutputStream(str3 + ignoredAreasPrefix + this.outPdfName));
            PdfStamper pdfStamper2 = new PdfStamper(pdfReader, new FileOutputStream(str3 + ignoredAreasPrefix + this.cmpPdfName));
            for (Map.Entry<Integer, List<Rectangle>> entry : map.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                List<Rectangle> value = entry.getValue();
                if (value != null && !value.isEmpty()) {
                    PdfContentByte overContent = pdfStamper.getOverContent(iIntValue);
                    PdfContentByte overContent2 = pdfStamper2.getOverContent(iIntValue);
                    for (Rectangle rectangle : value) {
                        rectangle.setBackgroundColor(BaseColor.BLACK);
                        overContent.rectangle(rectangle);
                        overContent2.rectangle(rectangle);
                    }
                }
            }
            pdfStamper.close();
            pdfStamper2.close();
            pdfReader2.close();
            pdfReader.close();
            init(str3 + ignoredAreasPrefix + this.outPdfName, str3 + ignoredAreasPrefix + this.cmpPdfName);
        }
        if (!file.exists()) {
            return cannotOpenTargetDirectory.replace("<filename>", this.outPdf);
        }
        Process processRunProcess = runProcess(this.gsExec, " -dNOPAUSE -dBATCH -sDEVICE=png16m -r150 -sOutputFile=<outputfile> <inputfile>".replace("<outputfile>", str3 + this.cmpImage).replace("<inputfile>", this.cmpPdf));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processRunProcess.getInputStream()));
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processRunProcess.getErrorStream()));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
        bufferedReader.close();
        while (true) {
            String line2 = bufferedReader2.readLine();
            if (line2 == null) {
                break;
            }
            System.out.println(line2);
        }
        bufferedReader2.close();
        if (processRunProcess.waitFor() != 0) {
            return gsFailed.replace("<filename>", this.cmpPdf);
        }
        Process processRunProcess2 = runProcess(this.gsExec, " -dNOPAUSE -dBATCH -sDEVICE=png16m -r150 -sOutputFile=<outputfile> <inputfile>".replace("<outputfile>", str3 + this.outImage).replace("<inputfile>", this.outPdf));
        BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(processRunProcess2.getInputStream()));
        BufferedReader bufferedReader4 = new BufferedReader(new InputStreamReader(processRunProcess2.getErrorStream()));
        while (true) {
            String line3 = bufferedReader3.readLine();
            if (line3 == null) {
                break;
            }
            System.out.println(line3);
        }
        bufferedReader3.close();
        while (true) {
            String line4 = bufferedReader4.readLine();
            if (line4 == null) {
                break;
            }
            System.out.println(line4);
        }
        bufferedReader4.close();
        if (processRunProcess2.waitFor() != 0) {
            return gsFailed.replace("<filename>", this.outPdf);
        }
        File[] fileArrListFiles = file.listFiles(new PngFileFilter());
        File[] fileArrListFiles2 = file.listFiles(new CmpPngFileFilter());
        boolean z = fileArrListFiles.length != fileArrListFiles2.length;
        int iMin = Math.min(fileArrListFiles.length, fileArrListFiles2.length);
        if (iMin < 1) {
            return "No files for comparing!!!\nThe result or sample pdf file is not processed by GhostScript.";
        }
        Arrays.sort(fileArrListFiles, new ImageNameComparator());
        Arrays.sort(fileArrListFiles2, new ImageNameComparator());
        int i = 0;
        String str4 = null;
        while (i < iMin) {
            if (list == 0 || !list.contains(Integer.valueOf(i))) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("Comparing page ");
                int i2 = i + 1;
                sb.append(Integer.toString(i2));
                sb.append(" (");
                sb.append(fileArrListFiles[i].getAbsolutePath());
                sb.append(")...");
                printStream.print(sb.toString());
                FileInputStream fileInputStream = new FileInputStream(fileArrListFiles[i]);
                FileInputStream fileInputStream2 = new FileInputStream(fileArrListFiles2[i]);
                boolean zCompareStreams = compareStreams(fileInputStream, fileInputStream2);
                fileInputStream.close();
                fileInputStream2.close();
                if (zCompareStreams) {
                    printStream.println("done.");
                } else {
                    if (this.compareExec == null || !new File(this.compareExec).exists()) {
                        str4 = differentPages.replace("<filename>", this.outPdf).replace("<pagenumber>", Integer.toString(i2)) + "\nYou can optionally specify path to ImageMagick compare tool (e.g. -DcompareExec=\"C:/Program Files/ImageMagick-6.5.4-2/compare.exe\") to visualize differences.";
                        break;
                    }
                    Process processRunProcess3 = runProcess(this.compareExec, " \"<image1>\" \"<image2>\" \"<difference>\"".replace("<image1>", fileArrListFiles[i].getAbsolutePath()).replace("<image2>", fileArrListFiles2[i].getAbsolutePath()).replace("<difference>", str3 + str2 + Integer.toString(i2) + ".png"));
                    BufferedReader bufferedReader5 = new BufferedReader(new InputStreamReader(processRunProcess3.getErrorStream()));
                    while (true) {
                        String line5 = bufferedReader5.readLine();
                        if (line5 == null) {
                            break;
                        }
                        System.out.println(line5);
                    }
                    bufferedReader5.close();
                    if (processRunProcess3.waitFor() != 0) {
                        strReplace = differentPages.replace("<filename>", this.outPdf).replace("<pagenumber>", Integer.toString(i2));
                    } else if (str4 == null) {
                        strReplace = differentPages.replace("<filename>", this.outPdf).replace("<pagenumber>", Integer.toString(i2)) + "\nPlease, examine " + str3 + str2 + Integer.toString(i2) + ".png for more details.";
                    } else {
                        strReplace = "File " + this.outPdf + " differs.\nPlease, examine difference images for more details.";
                    }
                    str4 = strReplace;
                    System.out.println(str4);
                }
            }
            i++;
            fileArrListFiles2 = fileArrListFiles2;
        }
        if (str4 != null) {
            return str4;
        }
        if (z) {
            return unexpectedNumberOfPages.replace("<filename>", this.outPdf);
        }
        return null;
    }

    private boolean compareStreams(InputStream inputStream, InputStream inputStream2) throws IOException {
        int i;
        byte[] bArr = new byte[65536];
        byte[] bArr2 = new byte[65536];
        do {
            i = inputStream.read(bArr);
            if (i != inputStream2.read(bArr2) || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } while (i != -1);
        return true;
    }

    public boolean compareContentStreamsByParsing(PdfObject pdfObject, PdfObject pdfObject2, PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        return compareContentStreamsByParsingExtended(pdfObject, pdfObject2, pdfDictionary, pdfDictionary2, null, null);
    }

    public String compareXmp(byte[] bArr, byte[] bArr2, boolean z) {
        if (z) {
            try {
                XMPMeta fromBuffer = XMPMetaFactory.parseFromBuffer(bArr);
                XMPUtils.removeProperties(fromBuffer, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.CREATEDATE, true, true);
                XMPUtils.removeProperties(fromBuffer, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.MODIFYDATE, true, true);
                XMPUtils.removeProperties(fromBuffer, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.METADATADATE, true, true);
                XMPUtils.removeProperties(fromBuffer, "http://ns.adobe.com/pdf/1.3/", PdfProperties.PRODUCER, true, true);
                bArr = XMPMetaFactory.serializeToBuffer(fromBuffer, new SerializeOptions(8192));
                XMPMeta fromBuffer2 = XMPMetaFactory.parseFromBuffer(bArr2);
                XMPUtils.removeProperties(fromBuffer2, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.CREATEDATE, true, true);
                XMPUtils.removeProperties(fromBuffer2, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.MODIFYDATE, true, true);
                XMPUtils.removeProperties(fromBuffer2, "http://ns.adobe.com/xap/1.0/", XmpBasicProperties.METADATADATE, true, true);
                XMPUtils.removeProperties(fromBuffer2, "http://ns.adobe.com/pdf/1.3/", PdfProperties.PRODUCER, true, true);
                bArr2 = XMPMetaFactory.serializeToBuffer(fromBuffer2, new SerializeOptions(8192));
            } catch (XMPException | IOException | ParserConfigurationException | SAXException unused) {
                return "XMP parsing failure!";
            }
        }
        if (compareXmls(bArr, bArr2)) {
            return null;
        }
        return "The XMP packages different!";
    }

    public class ObjectPath {
        protected RefKey baseCmpObject;
        protected RefKey baseOutObject;
        protected Stack<Pair<RefKey>> indirects;
        protected Stack<PathItem> path;

        public class ArrayPathItem extends PathItem {
            int index;

            public ArrayPathItem(int i) {
                super();
                this.index = i;
            }

            public boolean equals(Object obj) {
                return (obj instanceof ArrayPathItem) && this.index == ((ArrayPathItem) obj).index;
            }

            public int hashCode() {
                return this.index;
            }

            public String toString() {
                return "Array index: " + String.valueOf(this.index);
            }

            @Override // com.itextpdf.testutils.CompareTool.ObjectPath.PathItem
            public Node toXmlNode(Document document) {
                Element elementCreateElement = document.createElement("arrayIndex");
                elementCreateElement.appendChild(document.createTextNode(String.valueOf(this.index)));
                return elementCreateElement;
            }
        }

        public class DictPathItem extends PathItem {
            String key;

            public DictPathItem(String str) {
                super();
                this.key = str;
            }

            public boolean equals(Object obj) {
                return (obj instanceof DictPathItem) && this.key.equals(((DictPathItem) obj).key);
            }

            public int hashCode() {
                return this.key.hashCode();
            }

            public String toString() {
                return "Dict key: " + this.key;
            }

            @Override // com.itextpdf.testutils.CompareTool.ObjectPath.PathItem
            public Node toXmlNode(Document document) {
                Element elementCreateElement = document.createElement("dictKey");
                elementCreateElement.appendChild(document.createTextNode(this.key));
                return elementCreateElement;
            }
        }

        public class OffsetPathItem extends PathItem {
            int offset;

            public OffsetPathItem(int i) {
                super();
                this.offset = i;
            }

            public boolean equals(Object obj) {
                return (obj instanceof OffsetPathItem) && this.offset == ((OffsetPathItem) obj).offset;
            }

            public int hashCode() {
                return this.offset;
            }

            public String toString() {
                return "Offset: " + String.valueOf(this.offset);
            }

            @Override // com.itextpdf.testutils.CompareTool.ObjectPath.PathItem
            public Node toXmlNode(Document document) {
                Element elementCreateElement = document.createElement(TypedValues.CycleType.S_WAVE_OFFSET);
                elementCreateElement.appendChild(document.createTextNode(String.valueOf(this.offset)));
                return elementCreateElement;
            }
        }

        public class Pair<T> {
            private T first;
            private T second;

            public Pair(T t, T t2) {
                this.first = t;
                this.second = t2;
            }

            public boolean equals(Object obj) {
                if (obj instanceof Pair) {
                    Pair pair = (Pair) obj;
                    if (this.first.equals(pair.first) && this.second.equals(pair.second)) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                return (this.first.hashCode() * 31) + this.second.hashCode();
            }
        }

        public abstract class PathItem {
            private PathItem() {
            }

            public abstract Node toXmlNode(Document document);
        }

        public ObjectPath() {
            this.path = new Stack<>();
            this.indirects = new Stack<>();
        }

        public Object clone() {
            return CompareTool.this.new ObjectPath(this.baseCmpObject, this.baseOutObject, (Stack) this.path.clone());
        }

        public boolean equals(Object obj) {
            if (obj instanceof ObjectPath) {
                ObjectPath objectPath = (ObjectPath) obj;
                if (this.baseCmpObject.equals(objectPath.baseCmpObject) && this.baseOutObject.equals(objectPath.baseOutObject) && this.path.equals(objectPath.path)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            RefKey refKey = this.baseCmpObject;
            int iHashCode = refKey != null ? refKey.hashCode() : 1;
            RefKey refKey2 = this.baseOutObject;
            int iHashCode2 = (iHashCode * 31) + (refKey2 != null ? refKey2.hashCode() : 1);
            Iterator<PathItem> it = this.path.iterator();
            while (it.hasNext()) {
                iHashCode2 = (iHashCode2 * 31) + it.next().hashCode();
            }
            return iHashCode2;
        }

        public boolean isComparing(RefKey refKey, RefKey refKey2) {
            return this.indirects.contains(new Pair(refKey, refKey2));
        }

        public void pop() {
            this.path.pop();
        }

        public void pushArrayItemToPath(int i) {
            this.path.add(new ArrayPathItem(i));
        }

        public void pushDictItemToPath(String str) {
            this.path.add(new DictPathItem(str));
        }

        public void pushOffsetToPath(int i) {
            this.path.add(new OffsetPathItem(i));
        }

        public ObjectPath resetDirectPath(RefKey refKey, RefKey refKey2) {
            ObjectPath objectPath = CompareTool.this.new ObjectPath(refKey, refKey2);
            Stack<Pair<RefKey>> stack = (Stack) this.indirects.clone();
            objectPath.indirects = stack;
            stack.add(new Pair<>(refKey, refKey2));
            return objectPath;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Base cmp object: %s obj. Base out object: %s obj", this.baseCmpObject, this.baseOutObject));
            for (PathItem pathItem : this.path) {
                sb.append(StringUtilities.LF);
                sb.append(pathItem.toString());
            }
            return sb.toString();
        }

        public Node toXmlNode(Document document) {
            Element elementCreateElement = document.createElement("path");
            Element elementCreateElement2 = document.createElement(HTML.Tag.BASE);
            elementCreateElement2.setAttribute("cmp", this.baseCmpObject.toString() + " obj");
            elementCreateElement2.setAttribute("out", this.baseOutObject.toString() + " obj");
            elementCreateElement.appendChild(elementCreateElement2);
            Iterator<PathItem> it = this.path.iterator();
            while (it.hasNext()) {
                elementCreateElement.appendChild(it.next().toXmlNode(document));
            }
            return elementCreateElement;
        }

        public ObjectPath(RefKey refKey, RefKey refKey2) {
            this.path = new Stack<>();
            this.indirects = new Stack<>();
            this.baseCmpObject = refKey;
            this.baseOutObject = refKey2;
        }

        private ObjectPath(RefKey refKey, RefKey refKey2, Stack<PathItem> stack) {
            this.path = new Stack<>();
            this.indirects = new Stack<>();
            this.baseCmpObject = refKey;
            this.baseOutObject = refKey2;
            this.path = stack;
        }
    }

    public boolean compareXmls(String str, String str2) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setCoalescing(true);
        documentBuilderFactoryNewInstance.setIgnoringElementContentWhitespace(true);
        documentBuilderFactoryNewInstance.setIgnoringComments(true);
        DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
        Document document = documentBuilderNewDocumentBuilder.parse(new File(str));
        document.normalizeDocument();
        Document document2 = documentBuilderNewDocumentBuilder.parse(new File(str2));
        document2.normalizeDocument();
        return document2.isEqualNode(document);
    }

    public String compareXmp(String str, String str2) {
        return compareXmp(str, str2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public String compareXmp(String str, String str2, boolean z) throws Throwable {
        PdfReader pdfReader;
        Throwable th;
        PdfReader pdfReader2;
        init(str, str2);
        PdfReader pdfReader3 = null;
        try {
            pdfReader2 = new PdfReader(this.cmpPdf);
            try {
                pdfReader = new PdfReader(this.outPdf);
                try {
                    String strCompareXmp = compareXmp(pdfReader2.getMetadata(), pdfReader.getMetadata(), z);
                    pdfReader2.close();
                    pdfReader.close();
                    return strCompareXmp;
                } catch (IOException unused) {
                    pdfReader3 = pdfReader2;
                    if (pdfReader3 != null) {
                        pdfReader3.close();
                    }
                    if (pdfReader != null) {
                        pdfReader.close();
                    }
                    return "XMP parsing failure!";
                } catch (Throwable th2) {
                    th = th2;
                    if (pdfReader2 != null) {
                        pdfReader2.close();
                    }
                    if (pdfReader != null) {
                        pdfReader.close();
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                pdfReader = null;
            } catch (Throwable th3) {
                pdfReader = null;
                th = th3;
            }
        } catch (IOException unused3) {
            pdfReader = null;
        } catch (Throwable th4) {
            pdfReader = null;
            th = th4;
            pdfReader2 = null;
        }
    }

    public String compareByContent(String str, String str2, String str3, String str4, Map<Integer, List<Rectangle>> map) {
        init(str, str2);
        return compareByContent(str3, str4, map);
    }

    public String compareByContent(String str, String str2, String str3, String str4) {
        return compareByContent(str, str2, str3, str4, null);
    }

    public String compare(String str, String str2, String str3, String str4, Map<Integer, List<Rectangle>> map) {
        init(str, str2);
        return compare(str3, str4, map);
    }

    public String compare(String str, String str2, String str3, String str4) {
        return compare(str, str2, str3, str4, null);
    }
}
