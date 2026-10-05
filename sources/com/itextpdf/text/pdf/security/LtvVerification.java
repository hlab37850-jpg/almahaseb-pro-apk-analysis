package com.itextpdf.text.pdf.security;

import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfStream;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers;

/* JADX INFO: loaded from: classes3.dex */
public class LtvVerification {
    private AcroFields acroFields;
    private PdfReader reader;
    private PdfStamper stp;
    private PdfWriter writer;
    private Logger LOGGER = LoggerFactory.getLogger((Class<?>) LtvVerification.class);
    private Map<PdfName, ValidationData> validated = new HashMap();
    private boolean used = false;

    public enum CertificateInclusion {
        YES,
        NO
    }

    public enum CertificateOption {
        SIGNING_CERTIFICATE,
        WHOLE_CHAIN
    }

    public enum Level {
        OCSP,
        CRL,
        OCSP_CRL,
        OCSP_OPTIONAL_CRL
    }

    public static class ValidationData {
        public List<byte[]> certs;
        public List<byte[]> crls;
        public List<byte[]> ocsps;

        private ValidationData() {
            this.crls = new ArrayList();
            this.ocsps = new ArrayList();
            this.certs = new ArrayList();
        }
    }

    public LtvVerification(PdfStamper pdfStamper) {
        this.stp = pdfStamper;
        this.writer = pdfStamper.getWriter();
        this.reader = pdfStamper.getReader();
        this.acroFields = pdfStamper.getAcroFields();
    }

    private static byte[] buildOCSPResponse(byte[] bArr) {
        DEROctetString dEROctetString = new DEROctetString(bArr);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(OCSPObjectIdentifiers.id_pkix_ocsp_basic);
        aSN1EncodableVector.add(dEROctetString);
        ASN1Enumerated aSN1Enumerated = new ASN1Enumerated(0);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(aSN1Enumerated);
        aSN1EncodableVector2.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector)));
        return new DERSequence(aSN1EncodableVector2).getEncoded();
    }

    private void createDss() {
        outputDss(new PdfDictionary(), new PdfDictionary(), new PdfArray(), new PdfArray(), new PdfArray());
    }

    private static void deleteOldReferences(PdfArray pdfArray, PdfArray pdfArray2) {
        if (pdfArray == null || pdfArray2 == null) {
            return;
        }
        for (PdfObject pdfObject : pdfArray2) {
            if (pdfObject.isIndirect()) {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                int i = 0;
                while (i < pdfArray.size()) {
                    PdfObject pdfObject2 = pdfArray.getPdfObject(i);
                    if (pdfObject2.isIndirect() && pRIndirectReference.getNumber() == ((PRIndirectReference) pdfObject2).getNumber()) {
                        pdfArray.remove(i);
                        i--;
                    }
                    i++;
                }
            }
        }
    }

    private X509Certificate getParent(X509Certificate x509Certificate, Certificate[] certificateArr) {
        for (Certificate certificate : certificateArr) {
            X509Certificate x509Certificate2 = (X509Certificate) certificate;
            if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return null;
    }

    private PdfName getSignatureHashKey(String str) {
        PdfDictionary signatureDictionary = this.acroFields.getSignatureDictionary(str);
        byte[] originalBytes = signatureDictionary.getAsString(PdfName.CONTENTS).getOriginalBytes();
        if (PdfName.ETSI_RFC3161.equals(PdfReader.getPdfObject(signatureDictionary.get(PdfName.SUBFILTER)))) {
            originalBytes = new ASN1InputStream(new ByteArrayInputStream(originalBytes)).readObject().getEncoded();
        }
        return new PdfName(Utilities.convertToHex(hashBytesSha1(originalBytes)));
    }

    private static byte[] hashBytesSha1(byte[] bArr) {
        return MessageDigest.getInstance(SecurityConstants.SHA1).digest(bArr);
    }

    private void outputDss(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfArray pdfArray, PdfArray pdfArray2, PdfArray pdfArray3) {
        this.writer.addDeveloperExtension(PdfDeveloperExtension.ESIC_1_7_EXTENSIONLEVEL5);
        PdfDictionary catalog = this.reader.getCatalog();
        this.stp.markUsed(catalog);
        Iterator<PdfName> it = this.validated.keySet().iterator();
        while (it.hasNext()) {
            PdfName next = it.next();
            PdfArray pdfArray4 = new PdfArray();
            PdfArray pdfArray5 = new PdfArray();
            PdfArray pdfArray6 = new PdfArray();
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            Iterator<byte[]> it2 = this.validated.get(next).crls.iterator();
            while (it2.hasNext()) {
                PdfStream pdfStream = new PdfStream(it2.next());
                pdfStream.flateCompress();
                Iterator<PdfName> it3 = it;
                PdfIndirectReference indirectReference = this.writer.addToBody((PdfObject) pdfStream, false).getIndirectReference();
                pdfArray5.add(indirectReference);
                pdfArray2.add(indirectReference);
                it = it3;
            }
            Iterator<PdfName> it4 = it;
            Iterator<byte[]> it5 = this.validated.get(next).ocsps.iterator();
            while (it5.hasNext()) {
                PdfStream pdfStream2 = new PdfStream(it5.next());
                pdfStream2.flateCompress();
                PdfIndirectReference indirectReference2 = this.writer.addToBody((PdfObject) pdfStream2, false).getIndirectReference();
                pdfArray4.add(indirectReference2);
                pdfArray.add(indirectReference2);
            }
            Iterator<byte[]> it6 = this.validated.get(next).certs.iterator();
            while (it6.hasNext()) {
                PdfStream pdfStream3 = new PdfStream(it6.next());
                pdfStream3.flateCompress();
                PdfIndirectReference indirectReference3 = this.writer.addToBody((PdfObject) pdfStream3, false).getIndirectReference();
                pdfArray6.add(indirectReference3);
                pdfArray3.add(indirectReference3);
            }
            if (pdfArray4.size() > 0) {
                pdfDictionary3.put(PdfName.OCSP, this.writer.addToBody((PdfObject) pdfArray4, false).getIndirectReference());
            }
            if (pdfArray5.size() > 0) {
                pdfDictionary3.put(PdfName.CRL, this.writer.addToBody((PdfObject) pdfArray5, false).getIndirectReference());
            }
            if (pdfArray6.size() > 0) {
                pdfDictionary3.put(PdfName.CERT, this.writer.addToBody((PdfObject) pdfArray6, false).getIndirectReference());
            }
            pdfDictionary2.put(next, this.writer.addToBody((PdfObject) pdfDictionary3, false).getIndirectReference());
            it = it4;
        }
        pdfDictionary.put(PdfName.VRI, this.writer.addToBody((PdfObject) pdfDictionary2, false).getIndirectReference());
        if (pdfArray.size() > 0) {
            pdfDictionary.put(PdfName.OCSPS, this.writer.addToBody((PdfObject) pdfArray, false).getIndirectReference());
        }
        if (pdfArray2.size() > 0) {
            pdfDictionary.put(PdfName.CRLS, this.writer.addToBody((PdfObject) pdfArray2, false).getIndirectReference());
        }
        if (pdfArray3.size() > 0) {
            pdfDictionary.put(PdfName.CERTS, this.writer.addToBody((PdfObject) pdfArray3, false).getIndirectReference());
        }
        catalog.put(PdfName.DSS, this.writer.addToBody((PdfObject) pdfDictionary, false).getIndirectReference());
    }

    private void updateDss() {
        PdfDictionary asDict;
        PdfDictionary catalog = this.reader.getCatalog();
        this.stp.markUsed(catalog);
        PdfDictionary asDict2 = catalog.getAsDict(PdfName.DSS);
        PdfName pdfName = PdfName.OCSPS;
        PdfArray asArray = asDict2.getAsArray(pdfName);
        PdfName pdfName2 = PdfName.CRLS;
        PdfArray asArray2 = asDict2.getAsArray(pdfName2);
        PdfName pdfName3 = PdfName.CERTS;
        PdfArray asArray3 = asDict2.getAsArray(pdfName3);
        asDict2.remove(pdfName);
        asDict2.remove(pdfName2);
        asDict2.remove(pdfName3);
        PdfDictionary asDict3 = asDict2.getAsDict(PdfName.VRI);
        if (asDict3 != null) {
            for (PdfName pdfName4 : asDict3.getKeys()) {
                if (this.validated.containsKey(pdfName4) && (asDict = asDict3.getAsDict(pdfName4)) != null) {
                    deleteOldReferences(asArray, asDict.getAsArray(PdfName.OCSP));
                    deleteOldReferences(asArray2, asDict.getAsArray(PdfName.CRL));
                    deleteOldReferences(asArray3, asDict.getAsArray(PdfName.CERT));
                }
            }
        }
        if (asArray == null) {
            asArray = new PdfArray();
        }
        outputDss(asDict2, asDict3, asArray, asArray2 == null ? new PdfArray() : asArray2, asArray3 == null ? new PdfArray() : asArray3);
    }

    public boolean addVerification(String str, OcspClient ocspClient, CrlClient crlClient, CertificateOption certificateOption, Level level, CertificateInclusion certificateInclusion) {
        String str2;
        Collection<byte[]> encoded;
        byte[] encoded2;
        if (this.used) {
            throw new IllegalStateException(MessageLocalization.getComposedMessage("verification.already.output", new Object[0]));
        }
        PdfPKCS7 pdfPKCS7VerifySignature = this.acroFields.verifySignature(str);
        this.LOGGER.info("Adding verification for " + str);
        Certificate[] certificates = pdfPKCS7VerifySignature.getCertificates();
        X509Certificate signingCertificate = pdfPKCS7VerifySignature.getSigningCertificate();
        String str3 = null;
        ValidationData validationData = new ValidationData();
        int i = 0;
        while (i < certificates.length) {
            X509Certificate x509Certificate = (X509Certificate) certificates[i];
            this.LOGGER.info("Certificate: " + x509Certificate.getSubjectDN());
            if (certificateOption != CertificateOption.SIGNING_CERTIFICATE || x509Certificate.equals(signingCertificate)) {
                if (ocspClient == null || level == Level.CRL) {
                    str2 = str3;
                } else {
                    encoded2 = ocspClient.getEncoded(x509Certificate, getParent(x509Certificate, certificates), str3);
                    if (encoded2 != null) {
                        str2 = encoded2;
                        validationData.ocsps.add(buildOCSPResponse(encoded2));
                        this.LOGGER.info("OCSP added");
                        str2 = encoded2;
                    }
                }
                if (crlClient != null && ((level == Level.CRL || level == Level.OCSP_CRL || (level == Level.OCSP_OPTIONAL_CRL && str2 == null)) && (encoded = crlClient.getEncoded(x509Certificate, str3)) != null)) {
                    for (byte[] bArr : encoded) {
                        Iterator<byte[]> it = validationData.crls.iterator();
                        do {
                            if (!it.hasNext()) {
                                validationData.crls.add(bArr);
                                this.LOGGER.info("CRL added");
                                break;
                            }
                        } while (!Arrays.equals(it.next(), bArr));
                    }
                }
                if (certificateInclusion == CertificateInclusion.YES) {
                    validationData.certs.add(x509Certificate.getEncoded());
                }
            }
            i++;
            str3 = null;
        }
        if (validationData.crls.isEmpty() && validationData.ocsps.isEmpty()) {
            return false;
        }
        this.validated.put(getSignatureHashKey(str), validationData);
        return true;
    }

    public void merge() {
        if (this.used || this.validated.isEmpty()) {
            return;
        }
        this.used = true;
        if (this.reader.getCatalog().get(PdfName.DSS) == null) {
            createDss();
        } else {
            updateDss();
        }
    }

    public boolean addVerification(String str, Collection<byte[]> collection, Collection<byte[]> collection2, Collection<byte[]> collection3) {
        if (!this.used) {
            ValidationData validationData = new ValidationData();
            if (collection != null) {
                Iterator<byte[]> it = collection.iterator();
                while (it.hasNext()) {
                    validationData.ocsps.add(buildOCSPResponse(it.next()));
                }
            }
            if (collection2 != null) {
                Iterator<byte[]> it2 = collection2.iterator();
                while (it2.hasNext()) {
                    validationData.crls.add(it2.next());
                }
            }
            if (collection3 != null) {
                Iterator<byte[]> it3 = collection3.iterator();
                while (it3.hasNext()) {
                    validationData.certs.add(it3.next());
                }
            }
            this.validated.put(getSignatureHashKey(str), validationData);
            return true;
        }
        throw new IllegalStateException(MessageLocalization.getComposedMessage("verification.already.output", new Object[0]));
    }
}
