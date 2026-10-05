package com.zebra.sdk.certificate;

import com.itextpdf.text.pdf.security.SecurityConstants;
import com.zebra.sdk.certificate.internal.CertUtilitiesFactory;
import com.zebra.sdk.certificate.internal.CertUtilitiesI;
import com.zebra.sdk.util.internal.Base64;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class CertificateParser {
    private static final String CERTIFICATE_PATTERN = "(-----BEGIN CERTIFICATE-----.*?-----END CERTIFICATE-----)";
    private static final String PEM_PATTERN = "(-----BEGIN .*?-----.*?-----END .*?-----)";
    private static final String PRIVATE_KEY_PATTERN = "(-----BEGIN( RSA)? PRIVATE KEY-----.*?-----END( RSA)? PRIVATE KEY-----)";

    private CertificateParser() {
    }

    private static void addCertificate(ZebraCertificateInfo zebraCertificateInfo, CertificateFactory certificateFactory, String str) {
        if (((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(str.getBytes()))).getBasicConstraints() == -1) {
            zebraCertificateInfo.clientCertificate = str;
        } else {
            zebraCertificateInfo.caCertificates.add(str);
        }
    }

    private static Matcher getMatcher(String str, String str2) {
        return Pattern.compile(str, 40).matcher(str2);
    }

    private static String getPrivateKeyFromPem(String str) {
        Matcher matcher = getMatcher(PRIVATE_KEY_PATTERN, str);
        if (matcher.find()) {
            return matcher.group(0).replace(StringUtilities.CRLF, StringUtilities.LF).replace(StringUtilities.LF, StringUtilities.CRLF);
        }
        return null;
    }

    private static boolean parseAsCertificate(byte[] bArr, ZebraCertificateInfo zebraCertificateInfo) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509", CertUtilitiesFactory.getCertificateHelper().getCertificateProvider());
            for (Certificate certificate : certificateFactory.generateCertificates(new ByteArrayInputStream(bArr))) {
                StringWriter stringWriter = new StringWriter();
                CertUtilitiesFactory.getCertificateHelper().pemWriterHelper(certificate, stringWriter);
                addCertificate(zebraCertificateInfo, certificateFactory, stringWriter.toString().replace(StringUtilities.CRLF, StringUtilities.LF).replace(StringUtilities.LF, StringUtilities.CRLF));
            }
            return true;
        } catch (CertificateException unused) {
            return false;
        }
    }

    private static boolean parseAsDerPrivateKey(byte[] bArr, ZebraCertificateInfo zebraCertificateInfo) {
        try {
            PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(SecurityConstants.RSA).generatePrivate(new PKCS8EncodedKeySpec(bArr));
            StringWriter stringWriter = new StringWriter();
            CertUtilitiesFactory.getCertificateHelper().pemWriterHelper(privateKeyGeneratePrivate, stringWriter);
            zebraCertificateInfo.privateKey = stringWriter.toString().replace(StringUtilities.CRLF, StringUtilities.LF).replace(StringUtilities.LF, StringUtilities.CRLF);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void parseAsP12(byte[] bArr, ZebraCertificateInfo zebraCertificateInfo, String str, String str2) throws CertificateEncodingException {
        ZebraP12Info zebraP12Info = new ZebraP12Info(new ByteArrayInputStream(bArr), str2);
        zebraCertificateInfo.clientCertificate = zebraP12Info.getCertificateContent();
        zebraCertificateInfo.privateKey = zebraP12Info.getEncryptedPrivateKeyContent(str2, str2);
        CertUtilitiesI certUtilities = CertUtilitiesFactory.getCertUtilities();
        if (str == null) {
            str = zebraP12Info.getKeyStore().aliases().nextElement();
        }
        Certificate[] certificateChain = certUtilities.getCertificateChain(str, zebraP12Info.getKeyStore());
        for (int i = 1; i < certificateChain.length; i++) {
            zebraCertificateInfo.caCertificates.add(certUtilities.convertDerCertToPemCert(certificateChain[i].getEncoded()));
        }
    }

    private static boolean parseAsPem(ZebraCertificateInfo zebraCertificateInfo, String str) {
        if (!str.contains("-----BEGIN")) {
            return false;
        }
        String strStripExtraInfo = stripExtraInfo(str);
        zebraCertificateInfo.privateKey = getPrivateKeyFromPem(strStripExtraInfo);
        processPemCertificates(zebraCertificateInfo, strStripExtraInfo);
        return true;
    }

    public static ZebraCertificateInfo parseCertificate(InputStream inputStream, String str, String str2) throws CertificateEncodingException {
        byte[] bArr = new byte[inputStream.available()];
        IOUtils.readFully(inputStream, bArr);
        byte[] bArrStripPkcs7OpenSSLHeader = stripPkcs7OpenSSLHeader(bArr);
        String str3 = new String(bArrStripPkcs7OpenSSLHeader);
        ZebraCertificateInfo zebraCertificateInfo = new ZebraCertificateInfo();
        if (!parseAsPem(zebraCertificateInfo, str3) && !parseAsCertificate(bArrStripPkcs7OpenSSLHeader, zebraCertificateInfo) && !parseAsDerPrivateKey(bArrStripPkcs7OpenSSLHeader, zebraCertificateInfo)) {
            parseAsP12(bArrStripPkcs7OpenSSLHeader, zebraCertificateInfo, str, str2);
        }
        return zebraCertificateInfo;
    }

    private static void processPemCertificates(ZebraCertificateInfo zebraCertificateInfo, String str) {
        Matcher matcher = getMatcher(CERTIFICATE_PATTERN, str);
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            while (matcher.find()) {
                addCertificate(zebraCertificateInfo, certificateFactory, matcher.group(0).replace(StringUtilities.CRLF, StringUtilities.LF).replace(StringUtilities.LF, StringUtilities.CRLF));
            }
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }

    private static String stripExtraInfo(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile(PEM_PATTERN, 40).matcher(str);
        while (matcher.find()) {
            stringBuffer.append(matcher.group(0));
            stringBuffer.append(StringUtilities.LF);
        }
        return stringBuffer.toString();
    }

    private static byte[] stripPkcs7OpenSSLHeader(byte[] bArr) {
        String str = new String(bArr);
        return str.contains("-----BEGIN PKCS7-----") ? Base64.decode(str.replaceAll("-----BEGIN PKCS7-----", "").replaceAll("-----END PKCS7-----", "").trim()) : bArr;
    }
}
