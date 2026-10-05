package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.xml.XmlDomWriter;
import com.itextpdf.xmp.XMPConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class XmpReader {
    public static final String EXTRASPACE = "                                                                                                   \n";
    public static final String XPACKET_PI_BEGIN = "<?xpacket begin=\"\ufeff\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>\n";
    public static final String XPACKET_PI_END_W = "<?xpacket end=\"w\"?>";
    private Document domDocument;

    public XmpReader(byte[] bArr) {
        try {
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setNamespaceAware(true);
            this.domDocument = documentBuilderFactoryNewInstance.newDocumentBuilder().parse(new ByteArrayInputStream(bArr));
        } catch (ParserConfigurationException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean add(String str, String str2, String str3, String str4) {
        NodeList elementsByTagName = this.domDocument.getElementsByTagName(str);
        if (elementsByTagName.getLength() == 0) {
            return false;
        }
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node nodeItem = elementsByTagName.item(i);
            NamedNodeMap attributes = nodeItem.getAttributes();
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                Node nodeItem2 = attributes.item(i2);
                if (str2.equals(nodeItem2.getNodeValue())) {
                    String localName = nodeItem2.getLocalName();
                    Element elementCreateElementNS = this.domDocument.createElementNS(str2, str3);
                    elementCreateElementNS.setPrefix(localName);
                    elementCreateElementNS.appendChild(this.domDocument.createTextNode(str4));
                    nodeItem.appendChild(elementCreateElementNS);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean replaceDescriptionAttribute(String str, String str2, String str3) {
        NodeList elementsByTagNameNS = this.domDocument.getElementsByTagNameNS(XMPConst.NS_RDF, "Description");
        if (elementsByTagNameNS.getLength() == 0) {
            return false;
        }
        for (int i = 0; i < elementsByTagNameNS.getLength(); i++) {
            Node namedItemNS = elementsByTagNameNS.item(i).getAttributes().getNamedItemNS(str, str2);
            if (namedItemNS != null) {
                namedItemNS.setNodeValue(str3);
                return true;
            }
        }
        return false;
    }

    public boolean replaceNode(String str, String str2, String str3) {
        NodeList elementsByTagNameNS = this.domDocument.getElementsByTagNameNS(str, str2);
        if (elementsByTagNameNS.getLength() == 0) {
            return false;
        }
        for (int i = 0; i < elementsByTagNameNS.getLength(); i++) {
            setNodeText(this.domDocument, elementsByTagNameNS.item(i), str3);
        }
        return true;
    }

    public byte[] serializeDoc() throws IOException {
        XmlDomWriter xmlDomWriter = new XmlDomWriter();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlDomWriter.setOutput(byteArrayOutputStream, null);
        byteArrayOutputStream.write(XPACKET_PI_BEGIN.getBytes(XmpWriter.UTF8));
        byteArrayOutputStream.flush();
        xmlDomWriter.write(this.domDocument.getElementsByTagName("x:xmpmeta").item(0));
        byteArrayOutputStream.flush();
        for (int i = 0; i < 20; i++) {
            byteArrayOutputStream.write(EXTRASPACE.getBytes());
        }
        byteArrayOutputStream.write(XPACKET_PI_END_W.getBytes());
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public boolean setNodeText(Document document, Node node, String str) {
        if (node == null) {
            return false;
        }
        while (true) {
            Node firstChild = node.getFirstChild();
            if (firstChild == null) {
                node.appendChild(document.createTextNode(str));
                return true;
            }
            node.removeChild(firstChild);
        }
    }
}
