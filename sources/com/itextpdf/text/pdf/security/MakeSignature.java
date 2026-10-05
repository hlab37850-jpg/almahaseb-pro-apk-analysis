package com.itextpdf.text.pdf.security;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.io.RASInputStream;
import com.itextpdf.text.io.RandomAccessSource;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignature;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfString;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.spongycastle.asn1.esf.SignaturePolicyIdentifier;

/* JADX INFO: loaded from: classes3.dex */
public class MakeSignature {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) MakeSignature.class);

    public enum CryptoStandard {
        CMS,
        CADES
    }

    public static Collection<byte[]> processCrl(Certificate certificate, Collection<CrlClient> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CrlClient crlClient : collection) {
            if (crlClient != null) {
                LOGGER.info("Processing " + crlClient.getClass().getName());
                Collection<byte[]> encoded = crlClient.getEncoded((X509Certificate) certificate, null);
                if (encoded != null) {
                    arrayList.addAll(encoded);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static void signDeferred(PdfReader pdfReader, String str, OutputStream outputStream, ExternalSignatureContainer externalSignatureContainer) throws DocumentException, IOException {
        AcroFields acroFields = pdfReader.getAcroFields();
        PdfDictionary signatureDictionary = acroFields.getSignatureDictionary(str);
        if (signatureDictionary == null) {
            throw new DocumentException("No field");
        }
        if (!acroFields.signatureCoversWholeDocument(str)) {
            throw new DocumentException("Not the last signature");
        }
        PdfArray asArray = signatureDictionary.getAsArray(PdfName.BYTERANGE);
        long[] jArrAsLongArray = asArray.asLongArray();
        if (asArray.size() == 4) {
            if (jArrAsLongArray[0] == 0) {
                RandomAccessSource randomAccessSourceCreateSourceView = pdfReader.getSafeFile().createSourceView();
                byte[] bArrSign = externalSignatureContainer.sign(new RASInputStream(new RandomAccessSourceFactory().createRanged(randomAccessSourceCreateSourceView, jArrAsLongArray)));
                long j = jArrAsLongArray[2];
                long j2 = jArrAsLongArray[1];
                int i = ((int) (j - j2)) - 2;
                if ((i & 1) != 0) {
                    throw new DocumentException("Gap is not a multiple of 2");
                }
                int i2 = i / 2;
                if (i2 < bArrSign.length) {
                    throw new DocumentException("Not enough space");
                }
                StreamUtil.CopyBytes(randomAccessSourceCreateSourceView, 0L, j2 + 1, outputStream);
                ByteBuffer byteBuffer = new ByteBuffer(i2 * 2);
                for (byte b : bArrSign) {
                    byteBuffer.appendHex(b);
                }
                int length = (i2 - bArrSign.length) * 2;
                for (int i3 = 0; i3 < length; i3++) {
                    byteBuffer.append(ByteBuffer.ZERO);
                }
                byteBuffer.writeTo(outputStream);
                StreamUtil.CopyBytes(randomAccessSourceCreateSourceView, jArrAsLongArray[2] - 1, jArrAsLongArray[3] + 1, outputStream);
                return;
            }
        }
        throw new DocumentException("Single exclusion space supported");
    }

    public static void signDetached(PdfSignatureAppearance pdfSignatureAppearance, ExternalDigest externalDigest, ExternalSignature externalSignature, Certificate[] certificateArr, Collection<CrlClient> collection, OcspClient ocspClient, TSAClient tSAClient, int i, CryptoStandard cryptoStandard) throws DocumentException, IOException {
        signDetached(pdfSignatureAppearance, externalDigest, externalSignature, certificateArr, collection, ocspClient, tSAClient, i, cryptoStandard, (SignaturePolicyIdentifier) null);
    }

    public static void signExternalContainer(PdfSignatureAppearance pdfSignatureAppearance, ExternalSignatureContainer externalSignatureContainer, int i) throws DocumentException, IOException {
        PdfSignature pdfSignature = new PdfSignature(null, null);
        pdfSignature.setReason(pdfSignatureAppearance.getReason());
        pdfSignature.setLocation(pdfSignatureAppearance.getLocation());
        pdfSignature.setSignatureCreator(pdfSignatureAppearance.getSignatureCreator());
        pdfSignature.setContact(pdfSignatureAppearance.getContact());
        pdfSignature.setDate(new PdfDate(pdfSignatureAppearance.getSignDate()));
        externalSignatureContainer.modifySigningDictionary(pdfSignature);
        pdfSignatureAppearance.setCryptoDictionary(pdfSignature);
        HashMap<PdfName, Integer> map = new HashMap<>();
        PdfName pdfName = PdfName.CONTENTS;
        map.put(pdfName, new Integer((i * 2) + 2));
        pdfSignatureAppearance.preClose(map);
        byte[] bArrSign = externalSignatureContainer.sign(pdfSignatureAppearance.getRangeStream());
        if (i < bArrSign.length) {
            throw new IOException("Not enough space");
        }
        byte[] bArr = new byte[i];
        System.arraycopy(bArrSign, 0, bArr, 0, bArrSign.length);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(pdfName, new PdfString(bArr).setHexWriting(true));
        pdfSignatureAppearance.close(pdfDictionary);
    }

    public static void signDetached(PdfSignatureAppearance pdfSignatureAppearance, ExternalDigest externalDigest, ExternalSignature externalSignature, Certificate[] certificateArr, Collection<CrlClient> collection, OcspClient ocspClient, TSAClient tSAClient, int i, CryptoStandard cryptoStandard, SignaturePolicyInfo signaturePolicyInfo) throws DocumentException, IOException {
        signDetached(pdfSignatureAppearance, externalDigest, externalSignature, certificateArr, collection, ocspClient, tSAClient, i, cryptoStandard, signaturePolicyInfo.toSignaturePolicyIdentifier());
    }

    public static void signDetached(PdfSignatureAppearance pdfSignatureAppearance, ExternalDigest externalDigest, ExternalSignature externalSignature, Certificate[] certificateArr, Collection<CrlClient> collection, OcspClient ocspClient, TSAClient tSAClient, int i, CryptoStandard cryptoStandard, SignaturePolicyIdentifier signaturePolicyIdentifier) throws DocumentException, IOException {
        int i2;
        byte[] bArr;
        byte[] encoded;
        Collection<byte[]> collectionProcessCrl = null;
        for (int i3 = 0; collectionProcessCrl == null && i3 < certificateArr.length; i3++) {
            collectionProcessCrl = processCrl(certificateArr[i3], collection);
        }
        if (i == 0) {
            int length = 8192;
            if (collectionProcessCrl != null) {
                Iterator<byte[]> it = collectionProcessCrl.iterator();
                while (it.hasNext()) {
                    length += it.next().length + 10;
                }
            }
            if (ocspClient != null) {
                length += 4192;
            }
            if (tSAClient != null) {
                length += 4192;
            }
            i2 = length;
        } else {
            i2 = i;
        }
        pdfSignatureAppearance.setCertificate(certificateArr[0]);
        CryptoStandard cryptoStandard2 = CryptoStandard.CADES;
        if (cryptoStandard == cryptoStandard2) {
            pdfSignatureAppearance.addDeveloperExtension(PdfDeveloperExtension.ESIC_1_7_EXTENSIONLEVEL2);
        }
        PdfSignature pdfSignature = new PdfSignature(PdfName.ADOBE_PPKLITE, cryptoStandard == cryptoStandard2 ? PdfName.ETSI_CADES_DETACHED : PdfName.ADBE_PKCS7_DETACHED);
        pdfSignature.setReason(pdfSignatureAppearance.getReason());
        pdfSignature.setLocation(pdfSignatureAppearance.getLocation());
        pdfSignature.setSignatureCreator(pdfSignatureAppearance.getSignatureCreator());
        pdfSignature.setContact(pdfSignatureAppearance.getContact());
        pdfSignature.setDate(new PdfDate(pdfSignatureAppearance.getSignDate()));
        pdfSignatureAppearance.setCryptoDictionary(pdfSignature);
        HashMap<PdfName, Integer> map = new HashMap<>();
        PdfName pdfName = PdfName.CONTENTS;
        map.put(pdfName, new Integer((i2 * 2) + 2));
        pdfSignatureAppearance.preClose(map);
        String hashAlgorithm = externalSignature.getHashAlgorithm();
        PdfPKCS7 pdfPKCS7 = new PdfPKCS7(null, certificateArr, hashAlgorithm, null, externalDigest, false);
        if (signaturePolicyIdentifier != null) {
            pdfPKCS7.setSignaturePolicy(signaturePolicyIdentifier);
        }
        byte[] bArrDigest = DigestAlgorithms.digest(pdfSignatureAppearance.getRangeStream(), externalDigest.getMessageDigest(hashAlgorithm));
        if (certificateArr.length < 2 || ocspClient == null) {
            bArr = null;
            encoded = null;
        } else {
            bArr = null;
            encoded = ocspClient.getEncoded((X509Certificate) certificateArr[0], (X509Certificate) certificateArr[1], null);
        }
        pdfPKCS7.setExternalDigest(externalSignature.sign(pdfPKCS7.getAuthenticatedAttributeBytes(bArrDigest, encoded, collectionProcessCrl, cryptoStandard)), bArr, externalSignature.getEncryptionAlgorithm());
        byte[] encodedPKCS7 = pdfPKCS7.getEncodedPKCS7(bArrDigest, tSAClient, encoded, collectionProcessCrl, cryptoStandard);
        if (i2 >= encodedPKCS7.length) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(encodedPKCS7, 0, bArr2, 0, encodedPKCS7.length);
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(pdfName, new PdfString(bArr2).setHexWriting(true));
            pdfSignatureAppearance.close(pdfDictionary);
            return;
        }
        throw new IOException("Not enough space");
    }
}
