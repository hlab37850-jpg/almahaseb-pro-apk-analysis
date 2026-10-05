package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.xml.XmlDomWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes3.dex */
public class XfaForm {
    public static final String XFA_DATA_SCHEMA = "http://www.xfa.org/schema/xfa-data/1.0/";
    private AcroFieldsSearch acroFieldsSom;
    private boolean changed;
    private Node datasetsNode;
    private Xml2SomDatasets datasetsSom;
    private Document domDocument;
    private PdfReader reader;
    private Node templateNode;
    private Xml2SomTemplate templateSom;
    private boolean xfaPresent;

    public static class AcroFieldsSearch extends Xml2Som {
        private HashMap<String, String> acroShort2LongName;

        public AcroFieldsSearch(Collection<String> collection) {
            this.inverseSearch = new HashMap<>();
            this.acroShort2LongName = new HashMap<>();
            for (String str : collection) {
                String shortName = Xml2Som.getShortName(str);
                this.acroShort2LongName.put(shortName, str);
                Xml2Som.inverseSearchAdd(this.inverseSearch, Xml2Som.splitParts(shortName), str);
            }
        }

        public HashMap<String, String> getAcroShort2LongName() {
            return this.acroShort2LongName;
        }

        public void setAcroShort2LongName(HashMap<String, String> map) {
            this.acroShort2LongName = map;
        }
    }

    public static class InverseStore {
        protected ArrayList<String> part = new ArrayList<>();
        protected ArrayList<Object> follow = new ArrayList<>();

        public String getDefaultName() {
            InverseStore inverseStore = this;
            while (true) {
                Object obj = inverseStore.follow.get(0);
                if (obj instanceof String) {
                    return (String) obj;
                }
                inverseStore = (InverseStore) obj;
            }
        }

        public boolean isSimilar(String str) {
            String strSubstring = str.substring(0, str.indexOf(91) + 1);
            for (int i = 0; i < this.part.size(); i++) {
                if (this.part.get(i).startsWith(strSubstring)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class Stack2<T> extends ArrayList<T> {
        private static final long serialVersionUID = -7451476576174095212L;

        public boolean empty() {
            return size() == 0;
        }

        public T peek() {
            if (size() != 0) {
                return get(size() - 1);
            }
            throw new EmptyStackException();
        }

        public T pop() {
            if (size() == 0) {
                throw new EmptyStackException();
            }
            T t = get(size() - 1);
            remove(size() - 1);
            return t;
        }

        public T push(T t) {
            add(t);
            return t;
        }
    }

    public static class Xml2Som {
        protected int anform;
        protected HashMap<String, InverseStore> inverseSearch;
        protected HashMap<String, Node> name2Node;
        protected ArrayList<String> order;
        protected Stack2<String> stack;

        public static String escapeSom(String str) {
            if (str == null) {
                return "";
            }
            int iIndexOf = str.indexOf(46);
            if (iIndexOf < 0) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (iIndexOf >= 0) {
                stringBuffer.append(str.substring(i, iIndexOf));
                stringBuffer.append('\\');
                i = iIndexOf;
                iIndexOf = str.indexOf(46, iIndexOf + 1);
            }
            stringBuffer.append(str.substring(i));
            return stringBuffer.toString();
        }

        public static String getShortName(String str) {
            int iIndexOf = str.indexOf(".#subform[");
            if (iIndexOf < 0) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (iIndexOf >= 0) {
                stringBuffer.append(str.substring(i, iIndexOf));
                int iIndexOf2 = str.indexOf("]", iIndexOf + 10);
                if (iIndexOf2 < 0) {
                    return stringBuffer.toString();
                }
                i = iIndexOf2 + 1;
                iIndexOf = str.indexOf(".#subform[", i);
            }
            stringBuffer.append(str.substring(i));
            return stringBuffer.toString();
        }

        public static Stack2<String> splitParts(String str) {
            int iIndexOf;
            while (str.startsWith(".")) {
                str = str.substring(1);
            }
            Stack2<String> stack2 = new Stack2<>();
            int i = 0;
            while (true) {
                int i2 = i;
                while (true) {
                    iIndexOf = str.indexOf(46, i2);
                    if (iIndexOf < 0 || str.charAt(iIndexOf - 1) != '\\') {
                        break;
                    }
                    i2 = iIndexOf + 1;
                }
                if (iIndexOf < 0) {
                    break;
                }
                String strSubstring = str.substring(i, iIndexOf);
                if (!strSubstring.endsWith("]")) {
                    strSubstring = strSubstring + "[0]";
                }
                stack2.add(strSubstring);
                i = iIndexOf + 1;
            }
            String strSubstring2 = str.substring(i);
            if (!strSubstring2.endsWith("]")) {
                strSubstring2 = strSubstring2 + "[0]";
            }
            stack2.add(strSubstring2);
            return stack2;
        }

        public static String unescapeSom(String str) {
            int iIndexOf = str.indexOf(92);
            if (iIndexOf < 0) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (iIndexOf >= 0) {
                stringBuffer.append(str.substring(i, iIndexOf));
                i = iIndexOf + 1;
                iIndexOf = str.indexOf(92, i);
            }
            stringBuffer.append(str.substring(i));
            return stringBuffer.toString();
        }

        public HashMap<String, InverseStore> getInverseSearch() {
            return this.inverseSearch;
        }

        public HashMap<String, Node> getName2Node() {
            return this.name2Node;
        }

        public ArrayList<String> getOrder() {
            return this.order;
        }

        public void inverseSearchAdd(String str) {
            inverseSearchAdd(this.inverseSearch, this.stack, str);
        }

        public String inverseSearchGlobal(ArrayList<String> arrayList) {
            InverseStore inverseStore;
            if (arrayList.isEmpty() || (inverseStore = this.inverseSearch.get(arrayList.get(arrayList.size() - 1))) == null) {
                return null;
            }
            for (int size = arrayList.size() - 2; size >= 0; size--) {
                String str = arrayList.get(size);
                int iIndexOf = inverseStore.part.indexOf(str);
                if (iIndexOf < 0) {
                    if (inverseStore.isSimilar(str)) {
                        return null;
                    }
                    return inverseStore.getDefaultName();
                }
                inverseStore = (InverseStore) inverseStore.follow.get(iIndexOf);
            }
            return inverseStore.getDefaultName();
        }

        public String printStack() {
            if (this.stack.empty()) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.stack.size(); i++) {
                stringBuffer.append('.');
                stringBuffer.append(this.stack.get(i));
            }
            return stringBuffer.substring(1);
        }

        public void setInverseSearch(HashMap<String, InverseStore> map) {
            this.inverseSearch = map;
        }

        public void setName2Node(HashMap<String, Node> map) {
            this.name2Node = map;
        }

        public void setOrder(ArrayList<String> arrayList) {
            this.order = arrayList;
        }

        public static void inverseSearchAdd(HashMap<String, InverseStore> map, Stack2<String> stack2, String str) {
            InverseStore inverseStore;
            String strPeek = stack2.peek();
            InverseStore inverseStore2 = map.get(strPeek);
            if (inverseStore2 == null) {
                inverseStore2 = new InverseStore();
                map.put(strPeek, inverseStore2);
            }
            for (int size = stack2.size() - 2; size >= 0; size--) {
                String str2 = stack2.get(size);
                int iIndexOf = inverseStore2.part.indexOf(str2);
                if (iIndexOf < 0) {
                    inverseStore2.part.add(str2);
                    inverseStore = new InverseStore();
                    inverseStore2.follow.add(inverseStore);
                } else {
                    inverseStore = (InverseStore) inverseStore2.follow.get(iIndexOf);
                }
                inverseStore2 = inverseStore;
            }
            inverseStore2.part.add("");
            inverseStore2.follow.add(str);
        }
    }

    public static class Xml2SomDatasets extends Xml2Som {
        public Xml2SomDatasets(Node node) {
            this.order = new ArrayList<>();
            this.name2Node = new HashMap<>();
            this.stack = new Stack2<>();
            this.anform = 0;
            this.inverseSearch = new HashMap<>();
            processDatasetsInternal(node);
        }

        private static boolean hasChildren(Node node) {
            Node namedItemNS = node.getAttributes().getNamedItemNS(XfaForm.XFA_DATA_SCHEMA, "dataNode");
            if (namedItemNS != null) {
                String nodeValue = namedItemNS.getNodeValue();
                if ("dataGroup".equals(nodeValue)) {
                    return true;
                }
                if ("dataValue".equals(nodeValue)) {
                    return false;
                }
            }
            if (!node.hasChildNodes()) {
                return false;
            }
            for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild.getNodeType() == 1) {
                    return true;
                }
            }
            return false;
        }

        private void processDatasetsInternal(Node node) {
            if (node != null) {
                HashMap map = new HashMap();
                for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                    if (firstChild.getNodeType() == 1) {
                        String strEscapeSom = Xml2Som.escapeSom(firstChild.getLocalName());
                        Integer num = (Integer) map.get(strEscapeSom);
                        Integer numValueOf = num == null ? 0 : Integer.valueOf(num.intValue() + 1);
                        map.put(strEscapeSom, numValueOf);
                        this.stack.push(strEscapeSom + "[" + numValueOf.toString() + "]");
                        if (hasChildren(firstChild)) {
                            processDatasetsInternal(firstChild);
                        }
                        String strPrintStack = printStack();
                        this.order.add(strPrintStack);
                        inverseSearchAdd(strPrintStack);
                        this.name2Node.put(strPrintStack, firstChild);
                        this.stack.pop();
                    }
                }
            }
        }

        public Node insertNode(Node node, String str) {
            Stack2<String> stack2SplitParts = Xml2Som.splitParts(str);
            Document ownerDocument = node.getOwnerDocument();
            Node firstChild = node.getFirstChild();
            while (firstChild.getNodeType() != 1) {
                firstChild = firstChild.getNextSibling();
            }
            Node node2 = null;
            int i = 0;
            while (i < stack2SplitParts.size()) {
                String str2 = stack2SplitParts.get(i);
                int iLastIndexOf = str2.lastIndexOf(91);
                String strSubstring = str2.substring(0, iLastIndexOf);
                int i2 = Integer.parseInt(str2.substring(iLastIndexOf + 1, str2.length() - 1));
                Node firstChild2 = firstChild.getFirstChild();
                int i3 = -1;
                while (firstChild2 != null && (firstChild2.getNodeType() != 1 || !Xml2Som.escapeSom(firstChild2.getLocalName()).equals(strSubstring) || (i3 = i3 + 1) != i2)) {
                    firstChild2 = firstChild2.getNextSibling();
                }
                while (i3 < i2) {
                    firstChild2 = firstChild.appendChild(ownerDocument.createElementNS(null, strSubstring));
                    Attr attrCreateAttributeNS = ownerDocument.createAttributeNS(XfaForm.XFA_DATA_SCHEMA, "dataNode");
                    attrCreateAttributeNS.setNodeValue("dataGroup");
                    firstChild2.getAttributes().setNamedItemNS(attrCreateAttributeNS);
                    i3++;
                }
                i++;
                firstChild = firstChild2;
                node2 = firstChild;
            }
            Xml2Som.inverseSearchAdd(this.inverseSearch, stack2SplitParts, str);
            this.name2Node.put(str, node2);
            this.order.add(str);
            return node2;
        }
    }

    public static class Xml2SomTemplate extends Xml2Som {
        private boolean dynamicForm;
        private int templateLevel;

        public Xml2SomTemplate(Node node) {
            this.order = new ArrayList<>();
            this.name2Node = new HashMap<>();
            this.stack = new Stack2<>();
            this.anform = 0;
            this.templateLevel = 0;
            this.inverseSearch = new HashMap<>();
            processTemplate(node, null);
        }

        private void processTemplate(Node node, HashMap<String, Integer> map) {
            int i;
            int i2;
            int i3;
            String strEscapeSom;
            boolean z;
            Integer numValueOf;
            if (map == null) {
                map = new HashMap<>();
            }
            HashMap map2 = new HashMap();
            for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild.getNodeType() == 1) {
                    String localName = firstChild.getLocalName();
                    if ("subform".equals(localName)) {
                        Node namedItem = firstChild.getAttributes().getNamedItem("name");
                        if (namedItem != null) {
                            strEscapeSom = Xml2Som.escapeSom(namedItem.getNodeValue());
                            z = false;
                        } else {
                            strEscapeSom = "#subform";
                            z = true;
                        }
                        if (z) {
                            numValueOf = Integer.valueOf(this.anform);
                            this.anform++;
                        } else {
                            Integer num = (Integer) map2.get(strEscapeSom);
                            numValueOf = num == null ? 0 : Integer.valueOf(num.intValue() + 1);
                            map2.put(strEscapeSom, numValueOf);
                        }
                        this.stack.push(strEscapeSom + "[" + numValueOf.toString() + "]");
                        this.templateLevel = this.templateLevel + 1;
                        if (z) {
                            processTemplate(firstChild, map);
                        } else {
                            processTemplate(firstChild, null);
                        }
                        this.templateLevel--;
                        this.stack.pop();
                    } else if ("field".equals(localName) || "exclGroup".equals(localName)) {
                        Node namedItem2 = firstChild.getAttributes().getNamedItem("name");
                        if (namedItem2 != null) {
                            String strEscapeSom2 = Xml2Som.escapeSom(namedItem2.getNodeValue());
                            Integer num2 = map.get(strEscapeSom2);
                            Integer numValueOf2 = num2 == null ? 0 : Integer.valueOf(num2.intValue() + 1);
                            map.put(strEscapeSom2, numValueOf2);
                            this.stack.push(strEscapeSom2 + "[" + numValueOf2.toString() + "]");
                            String strPrintStack = printStack();
                            this.order.add(strPrintStack);
                            inverseSearchAdd(strPrintStack);
                            this.name2Node.put(strPrintStack, firstChild);
                            this.stack.pop();
                        }
                    } else if (!this.dynamicForm && this.templateLevel > 0 && "occur".equals(localName)) {
                        Node namedItem3 = firstChild.getAttributes().getNamedItem("initial");
                        if (namedItem3 != null) {
                            try {
                                i = Integer.parseInt(namedItem3.getNodeValue().trim());
                            } catch (Exception unused) {
                                i = 1;
                            }
                        } else {
                            i = 1;
                        }
                        Node namedItem4 = firstChild.getAttributes().getNamedItem("min");
                        if (namedItem4 != null) {
                            try {
                                i2 = Integer.parseInt(namedItem4.getNodeValue().trim());
                            } catch (Exception unused2) {
                                i2 = 1;
                            }
                        } else {
                            i2 = 1;
                        }
                        Node namedItem5 = firstChild.getAttributes().getNamedItem("max");
                        if (namedItem5 != null) {
                            try {
                                i3 = Integer.parseInt(namedItem5.getNodeValue().trim());
                            } catch (Exception unused3) {
                                i3 = 1;
                            }
                        } else {
                            i3 = 1;
                        }
                        if (i != i2 || i2 != i3) {
                            this.dynamicForm = true;
                        }
                    }
                }
            }
        }

        public String getFieldType(String str) {
            Node node = this.name2Node.get(str);
            if (node == null) {
                return null;
            }
            if ("exclGroup".equals(node.getLocalName())) {
                return "exclGroup";
            }
            Node firstChild = node.getFirstChild();
            while (firstChild != null && (firstChild.getNodeType() != 1 || !"ui".equals(firstChild.getLocalName()))) {
                firstChild = firstChild.getNextSibling();
            }
            if (firstChild == null) {
                return null;
            }
            for (Node firstChild2 = firstChild.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
                if (firstChild2.getNodeType() == 1 && (!"extras".equals(firstChild2.getLocalName()) || !"picture".equals(firstChild2.getLocalName()))) {
                    return firstChild2.getLocalName();
                }
            }
            return null;
        }

        public boolean isDynamicForm() {
            return this.dynamicForm;
        }

        public void setDynamicForm(boolean z) {
            this.dynamicForm = z;
        }
    }

    public XfaForm() {
    }

    private void createDatasetsNode(Node node) {
        while (node.getChildNodes().getLength() == 0) {
            node = node.getNextSibling();
        }
        Element elementCreateElement = node.getOwnerDocument().createElement("xfa:datasets");
        elementCreateElement.setAttribute("xmlns:xfa", XFA_DATA_SCHEMA);
        this.datasetsNode = elementCreateElement;
        node.appendChild(elementCreateElement);
    }

    private void extractNodes() {
        Map<String, Node> mapExtractXFANodes = extractXFANodes(this.domDocument);
        if (mapExtractXFANodes.containsKey("template")) {
            Node node = mapExtractXFANodes.get("template");
            this.templateNode = node;
            this.templateSom = new Xml2SomTemplate(node);
        }
        if (mapExtractXFANodes.containsKey("datasets")) {
            Node node2 = mapExtractXFANodes.get("datasets");
            this.datasetsNode = node2;
            Node nodeFindDataNode = findDataNode(node2);
            if (nodeFindDataNode == null) {
                nodeFindDataNode = this.datasetsNode.getFirstChild();
            }
            this.datasetsSom = new Xml2SomDatasets(nodeFindDataNode);
        }
        if (this.datasetsNode == null) {
            createDatasetsNode(this.domDocument.getFirstChild());
        }
    }

    public static Map<String, Node> extractXFANodes(Document document) {
        HashMap map = new HashMap();
        Node firstChild = document.getFirstChild();
        while (firstChild.getChildNodes().getLength() == 0) {
            firstChild = firstChild.getNextSibling();
        }
        for (Node firstChild2 = firstChild.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
            if (firstChild2.getNodeType() == 1) {
                map.put(firstChild2.getLocalName(), firstChild2);
            }
        }
        return map;
    }

    private Node findDataNode(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeName().equals("xfa:data")) {
                return childNodes.item(i);
            }
        }
        return null;
    }

    private Node getFirstElementNode(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == 1) {
                return childNodes.item(i);
            }
        }
        return null;
    }

    public static String getNodeText(Node node) {
        return node == null ? "" : getNodeText(node, "");
    }

    public static PdfObject getXfaObject(PdfReader pdfReader) {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.ACROFORM));
        if (pdfDictionary == null) {
            return null;
        }
        return PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.XFA));
    }

    public static byte[] serializeDoc(Node node) throws IOException {
        XmlDomWriter xmlDomWriter = new XmlDomWriter();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlDomWriter.setOutput(byteArrayOutputStream, null);
        xmlDomWriter.setCanonical(false);
        xmlDomWriter.write(node);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void setXfa(XfaForm xfaForm, PdfReader pdfReader, PdfWriter pdfWriter) {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.ACROFORM));
        if (pdfDictionary == null) {
            return;
        }
        PdfObject xfaObject = getXfaObject(pdfReader);
        if (xfaObject.isArray()) {
            PdfArray pdfArray = (PdfArray) xfaObject;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < pdfArray.size(); i3 += 2) {
                PdfString asString = pdfArray.getAsString(i3);
                if ("template".equals(asString.toString())) {
                    i = i3 + 1;
                }
                if ("datasets".equals(asString.toString())) {
                    i2 = i3 + 1;
                }
            }
            if (i > -1 && i2 > -1) {
                pdfReader.killXref(pdfArray.getAsIndirectObject(i));
                pdfReader.killXref(pdfArray.getAsIndirectObject(i2));
                PdfStream pdfStream = new PdfStream(serializeDoc(xfaForm.templateNode));
                pdfStream.flateCompress(pdfWriter.getCompressionLevel());
                pdfArray.set(i, pdfWriter.addToBody(pdfStream).getIndirectReference());
                PdfStream pdfStream2 = new PdfStream(serializeDoc(xfaForm.datasetsNode));
                pdfStream2.flateCompress(pdfWriter.getCompressionLevel());
                pdfArray.set(i2, pdfWriter.addToBody(pdfStream2).getIndirectReference());
                pdfDictionary.put(PdfName.XFA, new PdfArray(pdfArray));
                return;
            }
        }
        PdfName pdfName = PdfName.XFA;
        pdfReader.killXref(pdfDictionary.get(pdfName));
        PdfStream pdfStream3 = new PdfStream(serializeDoc(xfaForm.domDocument));
        pdfStream3.flateCompress(pdfWriter.getCompressionLevel());
        pdfDictionary.put(pdfName, pdfWriter.addToBody(pdfStream3).getIndirectReference());
    }

    public void fillXfaForm(File file) {
        fillXfaForm(file, false);
    }

    public String findDatasetsName(String str) {
        return this.datasetsSom.getName2Node().containsKey(str) ? str : this.datasetsSom.inverseSearchGlobal(Xml2Som.splitParts(str));
    }

    public Node findDatasetsNode(String str) {
        String strFindDatasetsName;
        if (str == null || (strFindDatasetsName = findDatasetsName(str)) == null) {
            return null;
        }
        return this.datasetsSom.getName2Node().get(strFindDatasetsName);
    }

    public String findFieldName(String str, AcroFields acroFields) {
        Map<String, AcroFields.Item> fields = acroFields.getFields();
        if (fields.containsKey(str)) {
            return str;
        }
        if (this.acroFieldsSom == null) {
            if (fields.isEmpty() && this.xfaPresent) {
                this.acroFieldsSom = new AcroFieldsSearch(this.datasetsSom.getName2Node().keySet());
            } else {
                this.acroFieldsSom = new AcroFieldsSearch(fields.keySet());
            }
        }
        return this.acroFieldsSom.getAcroShort2LongName().containsKey(str) ? this.acroFieldsSom.getAcroShort2LongName().get(str) : this.acroFieldsSom.inverseSearchGlobal(Xml2Som.splitParts(str));
    }

    public AcroFieldsSearch getAcroFieldsSom() {
        return this.acroFieldsSom;
    }

    public Node getDatasetsNode() {
        return this.datasetsNode;
    }

    public Xml2SomDatasets getDatasetsSom() {
        return this.datasetsSom;
    }

    public Document getDomDocument() {
        return this.domDocument;
    }

    public PdfReader getReader() {
        return this.reader;
    }

    public Xml2SomTemplate getTemplateSom() {
        return this.templateSom;
    }

    public boolean isChanged() {
        return this.changed;
    }

    public boolean isXfaPresent() {
        return this.xfaPresent;
    }

    public void setAcroFieldsSom(AcroFieldsSearch acroFieldsSearch) {
        this.acroFieldsSom = acroFieldsSearch;
    }

    public void setChanged(boolean z) {
        this.changed = z;
    }

    public void setDatasetsSom(Xml2SomDatasets xml2SomDatasets) {
        this.datasetsSom = xml2SomDatasets;
    }

    public void setDomDocument(Document document) {
        this.domDocument = document;
        extractNodes();
    }

    public void setNodeText(Node node, String str) {
        if (node == null) {
            return;
        }
        while (true) {
            Node firstChild = node.getFirstChild();
            if (firstChild == null) {
                break;
            } else {
                node.removeChild(firstChild);
            }
        }
        if (node.getAttributes().getNamedItemNS(XFA_DATA_SCHEMA, "dataNode") != null) {
            node.getAttributes().removeNamedItemNS(XFA_DATA_SCHEMA, "dataNode");
        }
        node.appendChild(this.domDocument.createTextNode(str));
        this.changed = true;
    }

    public void setReader(PdfReader pdfReader) {
        this.reader = pdfReader;
    }

    public void setTemplateSom(Xml2SomTemplate xml2SomTemplate) {
        this.templateSom = xml2SomTemplate;
    }

    public void setXfaPresent(boolean z) {
        this.xfaPresent = z;
    }

    public XfaForm(PdfReader pdfReader) throws IOException {
        this.reader = pdfReader;
        PdfObject xfaObject = getXfaObject(pdfReader);
        if (xfaObject == null) {
            this.xfaPresent = false;
            return;
        }
        this.xfaPresent = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (xfaObject.isArray()) {
            PdfArray pdfArray = (PdfArray) xfaObject;
            for (int i = 1; i < pdfArray.size(); i += 2) {
                PdfObject directObject = pdfArray.getDirectObject(i);
                if (directObject instanceof PRStream) {
                    byteArrayOutputStream.write(PdfReader.getStreamBytes((PRStream) directObject));
                }
            }
        } else if (xfaObject instanceof PRStream) {
            byteArrayOutputStream.write(PdfReader.getStreamBytes((PRStream) xfaObject));
        }
        byteArrayOutputStream.close();
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        this.domDocument = documentBuilderFactoryNewInstance.newDocumentBuilder().parse(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        extractNodes();
    }

    public void fillXfaForm(File file, boolean z) {
        fillXfaForm(new FileInputStream(file), z);
    }

    private static String getNodeText(Node node, String str) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 1) {
                str = getNodeText(firstChild, str);
            } else if (firstChild.getNodeType() == 3) {
                str = str + firstChild.getNodeValue();
            }
        }
        return str;
    }

    public void fillXfaForm(InputStream inputStream) {
        fillXfaForm(inputStream, false);
    }

    public void fillXfaForm(InputStream inputStream, boolean z) {
        fillXfaForm(new InputSource(inputStream), z);
    }

    public void fillXfaForm(InputSource inputSource) {
        fillXfaForm(inputSource, false);
    }

    public void fillXfaForm(InputSource inputSource, boolean z) {
        try {
            fillXfaForm(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource).getDocumentElement(), z);
        } catch (ParserConfigurationException e) {
            throw new ExceptionConverter(e);
        } catch (SAXException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void fillXfaForm(Node node) {
        fillXfaForm(node, false);
    }

    public void fillXfaForm(Node node, boolean z) {
        Node nodeCreateElementNS;
        int i = 0;
        if (z) {
            NodeList elementsByTagName = this.domDocument.getElementsByTagName("field");
            for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                ((Element) elementsByTagName.item(i2)).setAttribute("access", "readOnly");
            }
        }
        NodeList childNodes = this.datasetsNode.getChildNodes();
        int length = childNodes.getLength();
        while (true) {
            if (i >= length) {
                nodeCreateElementNS = null;
                break;
            }
            nodeCreateElementNS = childNodes.item(i);
            if (nodeCreateElementNS.getNodeType() == 1 && nodeCreateElementNS.getLocalName().equals("data") && XFA_DATA_SCHEMA.equals(nodeCreateElementNS.getNamespaceURI())) {
                break;
            } else {
                i++;
            }
        }
        if (nodeCreateElementNS == null) {
            nodeCreateElementNS = this.datasetsNode.getOwnerDocument().createElementNS(XFA_DATA_SCHEMA, "xfa:data");
            this.datasetsNode.appendChild(nodeCreateElementNS);
        }
        if (nodeCreateElementNS.getChildNodes().getLength() == 0) {
            nodeCreateElementNS.appendChild(this.domDocument.importNode(node, true));
        } else {
            Node firstElementNode = getFirstElementNode(nodeCreateElementNS);
            if (firstElementNode != null) {
                nodeCreateElementNS.replaceChild(this.domDocument.importNode(node, true), firstElementNode);
            }
        }
        extractNodes();
        setChanged(true);
    }

    public void setXfa(PdfWriter pdfWriter) {
        setXfa(this, this.reader, pdfWriter);
    }
}
