package com.itextpdf.text.pdf.security;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.XmlSignatureAppearance;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.crypto.dsig.spec.XPathFilter2ParameterSpec;
import javax.xml.crypto.dsig.spec.XPathType;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.jcp.xml.dsig.internal.dom.DOMKeyInfoFactory;
import org.apache.jcp.xml.dsig.internal.dom.DOMReference;
import org.apache.jcp.xml.dsig.internal.dom.DOMSignedInfo;
import org.apache.jcp.xml.dsig.internal.dom.DOMUtils;
import org.apache.jcp.xml.dsig.internal.dom.DOMXMLSignature;
import org.apache.jcp.xml.dsig.internal.dom.XMLDSigRI;
import org.apache.xml.security.utils.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes3.dex */
public class MakeXmlSignature {

    public static class EmptyKey implements Key {
        private static EmptyKey instance = new EmptyKey();

        private EmptyKey() {
        }

        public static EmptyKey getInstance() {
            return instance;
        }

        @Override // java.security.Key
        public String getAlgorithm() {
            return null;
        }

        @Override // java.security.Key
        public byte[] getEncoded() {
            return new byte[0];
        }

        @Override // java.security.Key
        public String getFormat() {
            return null;
        }
    }

    private static XMLSignatureFactory createSignatureFactory() {
        return XMLSignatureFactory.getInstance("DOM", new XMLDSigRI());
    }

    private static Element findElement(NodeList nodeList, String str) {
        for (int length = nodeList.getLength() - 1; length >= 0; length--) {
            Node nodeItem = nodeList.item(length);
            if (nodeItem.getNodeType() == 1 && nodeItem.getLocalName().equals(str)) {
                return (Element) nodeItem;
            }
        }
        return null;
    }

    private static Reference generateContentReference(XMLSignatureFactory xMLSignatureFactory, XmlSignatureAppearance xmlSignatureAppearance, String str) {
        DigestMethod digestMethodNewDigestMethod = xMLSignatureFactory.newDigestMethod(SecurityConstants.SHA1_URI, (DigestMethodParameterSpec) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(xMLSignatureFactory.newTransform("http://www.w3.org/2000/09/xmldsig#enveloped-signature", (TransformParameterSpec) null));
        XpathConstructor xpathConstructor = xmlSignatureAppearance.getXpathConstructor();
        if (xpathConstructor != null && xpathConstructor.getXpathExpression().length() > 0) {
            arrayList.add(xMLSignatureFactory.newTransform("http://www.w3.org/2002/06/xmldsig-filter2", new XPathFilter2ParameterSpec(Collections.singletonList(new XPathType(xpathConstructor.getXpathExpression(), XPathType.Filter.INTERSECT)))));
        }
        return xMLSignatureFactory.newReference("", digestMethodNewDigestMethod, arrayList, (String) null, str);
    }

    private static Reference generateCustomReference(XMLSignatureFactory xMLSignatureFactory, String str, String str2, String str3) {
        return xMLSignatureFactory.newReference(str, xMLSignatureFactory.newDigestMethod(SecurityConstants.SHA1_URI, (DigestMethodParameterSpec) null), (List) null, str2, str3);
    }

    private static KeyInfo generateKeyInfo(Certificate[] certificateArr, XmlSignatureAppearance xmlSignatureAppearance) {
        Certificate certificate = certificateArr[0];
        xmlSignatureAppearance.setCertificate(certificate);
        DOMKeyInfoFactory dOMKeyInfoFactory = new DOMKeyInfoFactory();
        return dOMKeyInfoFactory.newKeyInfo(Collections.singletonList(dOMKeyInfoFactory.newX509Data(Collections.singletonList(certificate))));
    }

    private static XMLObject generateXadesObject(XMLSignatureFactory xMLSignatureFactory, XmlSignatureAppearance xmlSignatureAppearance, String str, String str2, String str3, String[] strArr) throws NoSuchAlgorithmException {
        Node node;
        MessageDigest messageDigest = MessageDigest.getInstance(SecurityConstants.SHA1);
        Certificate certificate = xmlSignatureAppearance.getCertificate();
        Document document = xmlSignatureAppearance.getXmlLocator().getDocument();
        Element elementCreateElementNS = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_QualifyingProperties);
        elementCreateElementNS.setAttribute(SecurityConstants.Target, "#" + str);
        Element elementCreateElementNS2 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_SignedProperties);
        elementCreateElementNS2.setAttribute(SecurityConstants.Id, str3);
        elementCreateElementNS2.setIdAttribute(SecurityConstants.Id, true);
        Element elementCreateElementNS3 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_SignedSignatureProperties);
        Element elementCreateElementNS4 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_SigningTime);
        String str4 = new SimpleDateFormat(SecurityConstants.SigningTimeFormat).format(xmlSignatureAppearance.getSignDate().getTime());
        elementCreateElementNS4.appendChild(document.createTextNode(str4.substring(0, str4.length() - 2).concat(":").concat(str4.substring(str4.length() - 2))));
        elementCreateElementNS3.appendChild(elementCreateElementNS4);
        Element elementCreateElementNS5 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_SigningCertificate);
        Element elementCreateElementNS6 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_Cert);
        Element elementCreateElementNS7 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_CertDigest);
        Element elementCreateElementNS8 = document.createElementNS(SecurityConstants.XMLDSIG_URI, SecurityConstants.DigestMethod);
        elementCreateElementNS8.setAttribute(SecurityConstants.Algorithm, SecurityConstants.SHA1_URI);
        elementCreateElementNS7.appendChild(elementCreateElementNS8);
        Element elementCreateElementNS9 = document.createElementNS(SecurityConstants.XMLDSIG_URI, SecurityConstants.DigestValue);
        elementCreateElementNS9.appendChild(document.createTextNode(Base64.encode(messageDigest.digest(certificate.getEncoded()))));
        elementCreateElementNS7.appendChild(elementCreateElementNS9);
        elementCreateElementNS6.appendChild(elementCreateElementNS7);
        if (certificate instanceof X509Certificate) {
            Element elementCreateElementNS10 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_IssuerSerial);
            Element elementCreateElementNS11 = document.createElementNS(SecurityConstants.XMLDSIG_URI, SecurityConstants.X509IssuerName);
            X509Certificate x509Certificate = (X509Certificate) certificate;
            elementCreateElementNS11.appendChild(document.createTextNode(getX509IssuerName(x509Certificate)));
            elementCreateElementNS10.appendChild(elementCreateElementNS11);
            Element elementCreateElementNS12 = document.createElementNS(SecurityConstants.XMLDSIG_URI, SecurityConstants.X509SerialNumber);
            elementCreateElementNS12.appendChild(document.createTextNode(getX509SerialNumber(x509Certificate)));
            elementCreateElementNS10.appendChild(elementCreateElementNS12);
            elementCreateElementNS6.appendChild(elementCreateElementNS10);
        }
        elementCreateElementNS5.appendChild(elementCreateElementNS6);
        elementCreateElementNS3.appendChild(elementCreateElementNS5);
        if (strArr != null) {
            Element elementCreateElementNS13 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_SignaturePolicyIdentifier);
            Element elementCreateElementNS14 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_SignaturePolicyId);
            Element elementCreateElementNS15 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_SigPolicyId);
            Element elementCreateElementNS16 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_Identifier);
            elementCreateElementNS16.appendChild(document.createTextNode(strArr[0]));
            elementCreateElementNS16.setAttribute(SecurityConstants.Qualifier, SecurityConstants.OIDAsURN);
            elementCreateElementNS15.appendChild(elementCreateElementNS16);
            Element elementCreateElementNS17 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_Description);
            elementCreateElementNS17.appendChild(document.createTextNode(strArr[1]));
            elementCreateElementNS15.appendChild(elementCreateElementNS17);
            elementCreateElementNS14.appendChild(elementCreateElementNS15);
            Element elementCreateElementNS18 = document.createElementNS(SecurityConstants.XADES_132_URI, SecurityConstants.XADES_SigPolicyHash);
            Element elementCreateElementNS19 = document.createElementNS(SecurityConstants.XMLDSIG_URI, SecurityConstants.DigestMethod);
            elementCreateElementNS19.setAttribute(SecurityConstants.Algorithm, SecurityConstants.SHA1_URI);
            elementCreateElementNS18.appendChild(elementCreateElementNS19);
            Element elementCreateElementNS20 = document.createElementNS(SecurityConstants.XMLDSIG_URI, SecurityConstants.DigestValue);
            elementCreateElementNS20.appendChild(document.createTextNode(Base64.encode(messageDigest.digest(getByteArrayOfNode(elementCreateElementNS15)))));
            elementCreateElementNS18.appendChild(elementCreateElementNS20);
            elementCreateElementNS14.appendChild(elementCreateElementNS18);
            elementCreateElementNS13.appendChild(elementCreateElementNS14);
            elementCreateElementNS3.appendChild(elementCreateElementNS13);
            node = elementCreateElementNS2;
        } else {
            node = elementCreateElementNS2;
        }
        node.appendChild(elementCreateElementNS3);
        Element elementCreateElement = document.createElement(SecurityConstants.XADES_SignedDataObjectProperties);
        Element elementCreateElement2 = document.createElement(SecurityConstants.XADES_DataObjectFormat);
        elementCreateElement2.setAttribute(SecurityConstants.ObjectReference, "#" + str2);
        String description = xmlSignatureAppearance.getDescription();
        if (description != null) {
            Element elementCreateElement3 = document.createElement(SecurityConstants.XADES_Description);
            elementCreateElement3.appendChild(document.createTextNode(description));
            elementCreateElement2.appendChild(elementCreateElement3);
        }
        Element elementCreateElement4 = document.createElement(SecurityConstants.XADES_MimeType);
        elementCreateElement4.appendChild(document.createTextNode(xmlSignatureAppearance.getMimeType()));
        elementCreateElement2.appendChild(elementCreateElement4);
        String encoding = xmlSignatureAppearance.getXmlLocator().getEncoding();
        if (encoding != null) {
            Element elementCreateElement5 = document.createElement(SecurityConstants.XADES_Encoding);
            elementCreateElement5.appendChild(document.createTextNode(encoding));
            elementCreateElement2.appendChild(elementCreateElement5);
        }
        elementCreateElement.appendChild(elementCreateElement2);
        node.appendChild(elementCreateElement);
        elementCreateElementNS.appendChild(node);
        return xMLSignatureFactory.newXMLObject(Collections.singletonList(new DOMStructure(elementCreateElementNS)), (String) null, (String) null, (String) null);
    }

    private static byte[] getByteArrayOfNode(Node node) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("omit-xml-declaration", "yes");
            transformerNewTransformer.transform(new DOMSource(node), streamResult);
            return streamResult.getWriter().toString().getBytes();
        } catch (Exception unused) {
            return byteArrayOutputStream.toByteArray();
        }
    }

    private static String getRandomId() {
        return UUID.randomUUID().toString().substring(24);
    }

    private static String getX509IssuerName(X509Certificate x509Certificate) {
        return x509Certificate.getIssuerX500Principal().toString();
    }

    private static String getX509SerialNumber(X509Certificate x509Certificate) {
        return x509Certificate.getSerialNumber().toString();
    }

    private static void sign(XMLSignatureFactory xMLSignatureFactory, ExternalSignature externalSignature, XmlLocator xmlLocator, DOMSignedInfo dOMSignedInfo, XMLObject xMLObject, KeyInfo keyInfo, String str) throws DocumentException {
        Document document = xmlLocator.getDocument();
        DOMSignContext dOMSignContext = new DOMSignContext(EmptyKey.getInstance(), document.getDocumentElement());
        DOMXMLSignature dOMXMLSignatureNewXMLSignature = xMLSignatureFactory.newXMLSignature(dOMSignedInfo, keyInfo, xMLObject != null ? Collections.singletonList(xMLObject) : null, str, (String) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            dOMXMLSignatureNewXMLSignature.marshal(dOMSignContext.getParent(), dOMSignContext.getNextSibling(), DOMUtils.getSignaturePrefix(dOMSignContext), dOMSignContext);
            Element elementFindElement = findElement(document.getDocumentElement().getChildNodes(), SecurityConstants.Signature);
            if (str != null) {
                elementFindElement.setAttributeNS(SecurityConstants.XMLNS_URI, SecurityConstants.XMLNS_XADES, SecurityConstants.XADES_132_URI);
            }
            List references = dOMSignedInfo.getReferences();
            for (int i = 0; i < references.size(); i++) {
                ((DOMReference) references.get(i)).digest(dOMSignContext);
            }
            dOMSignedInfo.canonicalize(dOMSignContext, byteArrayOutputStream);
            findElement(elementFindElement.getChildNodes(), SecurityConstants.SignatureValue).appendChild(document.createTextNode(Base64.encode(externalSignature.sign(byteArrayOutputStream.toByteArray()))));
            xmlLocator.setDocument(document);
        } catch (Exception e) {
            throw new DocumentException(e);
        }
    }

    public static void signXades(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, Certificate[] certificateArr, boolean z) throws DocumentException, NoSuchAlgorithmException {
        String str;
        String[] strArr;
        verifyArguments(xmlSignatureAppearance, externalSignature);
        if (externalSignature.getEncryptionAlgorithm().equals(SecurityConstants.RSA)) {
            str = "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
        } else {
            str = externalSignature.getEncryptionAlgorithm().equals(SecurityConstants.DSA) ? "http://www.w3.org/2000/09/xmldsig#dsa-sha1" : null;
        }
        String str2 = SecurityConstants.Reference_ + getRandomId();
        String str3 = SecurityConstants.SignedProperties_ + getRandomId();
        String str4 = SecurityConstants.Signature_ + getRandomId();
        XMLSignatureFactory xMLSignatureFactoryCreateSignatureFactory = createSignatureFactory();
        KeyInfo keyInfoGenerateKeyInfo = generateKeyInfo(certificateArr, xmlSignatureAppearance);
        if (z) {
            String[] strArr2 = new String[2];
            if (str.equals("http://www.w3.org/2000/09/xmldsig#rsa-sha1")) {
                strArr2[0] = SecurityConstants.OID_RSA_SHA1;
                strArr2[1] = SecurityConstants.OID_RSA_SHA1_DESC;
            } else {
                strArr2[0] = SecurityConstants.OID_DSA_SHA1;
                strArr2[1] = SecurityConstants.OID_DSA_SHA1_DESC;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        sign(xMLSignatureFactoryCreateSignatureFactory, externalSignature, xmlSignatureAppearance.getXmlLocator(), xMLSignatureFactoryCreateSignatureFactory.newSignedInfo(xMLSignatureFactoryCreateSignatureFactory.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (C14NMethodParameterSpec) null), xMLSignatureFactoryCreateSignatureFactory.newSignatureMethod(str, (SignatureMethodParameterSpec) null), Arrays.asList(generateCustomReference(xMLSignatureFactoryCreateSignatureFactory, "#" + str3, SecurityConstants.SignedProperties_Type, null), generateContentReference(xMLSignatureFactoryCreateSignatureFactory, xmlSignatureAppearance, str2)), (String) null), generateXadesObject(xMLSignatureFactoryCreateSignatureFactory, xmlSignatureAppearance, str4, str2, str3, strArr), keyInfoGenerateKeyInfo, str4);
        xmlSignatureAppearance.close();
    }

    public static void signXadesBes(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, Certificate[] certificateArr) throws DocumentException, NoSuchAlgorithmException {
        signXades(xmlSignatureAppearance, externalSignature, certificateArr, false);
    }

    public static void signXadesEpes(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, Certificate[] certificateArr) throws DocumentException, NoSuchAlgorithmException {
        signXades(xmlSignatureAppearance, externalSignature, certificateArr, true);
    }

    public static void signXmlDSig(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, KeyInfo keyInfo) throws DocumentException {
        String str;
        verifyArguments(xmlSignatureAppearance, externalSignature);
        XMLSignatureFactory xMLSignatureFactoryCreateSignatureFactory = createSignatureFactory();
        Reference referenceGenerateContentReference = generateContentReference(xMLSignatureFactoryCreateSignatureFactory, xmlSignatureAppearance, null);
        if (externalSignature.getEncryptionAlgorithm().equals(SecurityConstants.RSA)) {
            str = "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
        } else {
            str = externalSignature.getEncryptionAlgorithm().equals(SecurityConstants.DSA) ? "http://www.w3.org/2000/09/xmldsig#dsa-sha1" : null;
        }
        sign(xMLSignatureFactoryCreateSignatureFactory, externalSignature, xmlSignatureAppearance.getXmlLocator(), xMLSignatureFactoryCreateSignatureFactory.newSignedInfo(xMLSignatureFactoryCreateSignatureFactory.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (C14NMethodParameterSpec) null), xMLSignatureFactoryCreateSignatureFactory.newSignatureMethod(str, (SignatureMethodParameterSpec) null), Collections.singletonList(referenceGenerateContentReference)), null, keyInfo, null);
        xmlSignatureAppearance.close();
    }

    private static void verifyArguments(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature) throws DocumentException {
        if (xmlSignatureAppearance.getXmlLocator() == null) {
            throw new DocumentException(MessageLocalization.getComposedMessage("xmllocator.cannot.be.null", new Object[0]));
        }
        if (!externalSignature.getHashAlgorithm().equals(SecurityConstants.SHA1)) {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("support.only.sha1.hash.algorithm", new Object[0]));
        }
        if (!externalSignature.getEncryptionAlgorithm().equals(SecurityConstants.RSA) && !externalSignature.getEncryptionAlgorithm().equals(SecurityConstants.DSA)) {
            throw new UnsupportedOperationException(MessageLocalization.getComposedMessage("support.only.rsa.and.dsa.algorithms", new Object[0]));
        }
    }

    private static KeyInfo generateKeyInfo(PublicKey publicKey) {
        DOMKeyInfoFactory dOMKeyInfoFactory = new DOMKeyInfoFactory();
        return dOMKeyInfoFactory.newKeyInfo(Collections.singletonList(dOMKeyInfoFactory.newKeyValue(publicKey)));
    }

    public static void signXmlDSig(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, Certificate[] certificateArr) throws DocumentException {
        signXmlDSig(xmlSignatureAppearance, externalSignature, generateKeyInfo(certificateArr, xmlSignatureAppearance));
    }

    public static void signXmlDSig(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, PublicKey publicKey) throws DocumentException {
        signXmlDSig(xmlSignatureAppearance, externalSignature, generateKeyInfo(publicKey));
    }
}
