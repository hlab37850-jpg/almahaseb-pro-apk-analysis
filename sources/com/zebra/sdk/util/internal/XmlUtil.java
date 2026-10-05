package com.zebra.sdk.util.internal;

import com.zebra.sdk.device.ZebraIllegalArgumentException;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes3.dex */
public class XmlUtil {
    private static final int DOCUMENT_NODE_TYPE = 9;
    private static final int TEXT_NODE_TYPE = 3;

    public static List<Node> findImmediateChildByName(Node node, String str) {
        ArrayList arrayList = new ArrayList();
        if (node == null || str == null) {
            return null;
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeName().equals(str)) {
                arrayList.add(nodeItem);
            }
        }
        return arrayList;
    }

    public static List<Node> getAllNodesByPath(Document document, String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] strArrSplit = str.split("/");
        NodeList elementsByTagName = document.getElementsByTagName(strArrSplit[strArrSplit.length - 1]);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node nodeItem = elementsByTagName.item(i);
            int length = strArrSplit.length - 1;
            while (length >= 0 && nodeItem.getNodeName().equals(strArrSplit[length])) {
                nodeItem = nodeItem.getParentNode();
                length--;
            }
            if (length == -1) {
                arrayList.add(elementsByTagName.item(i));
            }
        }
        return arrayList;
    }

    public static void getAllSubNodesByName(List<Node> list, Node node, String str) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeName().equals(str)) {
                list.add(nodeItem);
            }
            getAllSubNodesByName(list, nodeItem, str);
        }
    }

    public static Node getDataAtNamedNode(ByteArrayInputStream byteArrayInputStream, String str) {
        return getDataAtNamedNode(byteArrayInputStream, str, null);
    }

    public static Node getFirstNodeByPath(Document document, String str) {
        List<Node> allNodesByPath = getAllNodesByPath(document, str);
        if (allNodesByPath == null || allNodesByPath.size() <= 0) {
            return null;
        }
        return allNodesByPath.get(0);
    }

    public static Node getFirstSubNodeByName(Node node, String str) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeName().equals(str)) {
                return nodeItem;
            }
            Node firstSubNodeByName = getFirstSubNodeByName(nodeItem, str);
            if (firstSubNodeByName != null) {
                return firstSubNodeByName;
            }
        }
        return null;
    }

    public static String getTextContent(Node node, String str) {
        Node firstChild;
        if (node != null && (firstChild = node.getFirstChild()) != null) {
            String nodeValue = firstChild.getNodeValue();
            Node nextSibling = firstChild.getNextSibling();
            if (nextSibling != null) {
                nodeValue = nextSibling.getNodeValue();
            }
            if (nodeValue != null) {
                return nodeValue;
            }
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0053 A[LOOP:0: B:18:0x004d->B:20:0x0053, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:23:0x0067  */
    public static String xmlToString(Node node) {
        String str;
        NodeList childNodes;
        int i;
        String nodeValue;
        StringBuilder sb = new StringBuilder();
        if (node != null) {
            if (node.getNodeType() == 3) {
                nodeValue = node.getNodeValue();
            } else {
                if (node.getNodeType() != 9) {
                    sb.append("<");
                    sb.append(node.getNodeName());
                    sb.append(">");
                    if (!node.hasChildNodes() || node.getFirstChild().getNodeType() == 3) {
                        childNodes = node.getChildNodes();
                        for (i = 0; i < childNodes.getLength(); i++) {
                            sb.append(xmlToString(childNodes.item(i)));
                        }
                        if (node.getNodeType() != 9) {
                            sb.append("</");
                            sb.append(node.getNodeName());
                            nodeValue = ">\r\n";
                        }
                    } else {
                        str = StringUtilities.CRLF;
                    }
                } else {
                    str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n";
                }
                sb.append(str);
                childNodes = node.getChildNodes();
                while (i < childNodes.getLength()) {
                    sb.append(xmlToString(childNodes.item(i)));
                }
                if (node.getNodeType() != 9) {
                    sb.append("</");
                    sb.append(node.getNodeName());
                    nodeValue = ">\r\n";
                }
            }
            sb.append(nodeValue);
        }
        return sb.toString();
    }

    public static Node getDataAtNamedNode(ByteArrayInputStream byteArrayInputStream, String str, String str2) throws ZebraIllegalArgumentException {
        Node firstSubNodeByName = getFirstSubNodeByName(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(byteArrayInputStream).getChildNodes().item(0), str);
        if (firstSubNodeByName != null) {
            return firstSubNodeByName;
        }
        String str3 = "Malformed response from printer";
        if (str2 != null && str2.length() > 0) {
            str3 = "Malformed response from printer for " + str2;
        }
        throw new ZebraIllegalArgumentException(str3 + ".");
    }
}
