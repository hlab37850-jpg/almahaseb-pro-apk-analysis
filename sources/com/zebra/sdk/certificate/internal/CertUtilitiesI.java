package com.zebra.sdk.certificate.internal;

import com.zebra.sdk.util.internal.CertificateInfo;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes3.dex */
public interface CertUtilitiesI {
    String convertDerCertToPemCert(byte[] bArr);

    String convertDerKeyToPemKey(byte[] bArr);

    Certificate[] createCertChain(String str);

    void createP12File(PrivateKey privateKey, Certificate[] certificateArr, String str, String str2);

    void getCaFromPkcs12Keystore(String str, OutputStream outputStream, KeyStore keyStore);

    Certificate getCertificate(String str);

    Certificate[] getCertificateChain(String str, KeyStore keyStore);

    void getCertificateFromPkcs12Keystore(String str, OutputStream outputStream, KeyStore keyStore);

    KeyPair getKeyPair();

    PrivateKey getPrivateKey(String str, String str2, KeyStore keyStore);

    void getPrivateKeyFromPkcs12Keystore(String str, String str2, String str3, OutputStream outputStream, KeyStore keyStore);

    void save(CertificateInfo certificateInfo, KeyPair keyPair, String str, String str2, String str3, int i, String str4, String str5, String str6);
}
