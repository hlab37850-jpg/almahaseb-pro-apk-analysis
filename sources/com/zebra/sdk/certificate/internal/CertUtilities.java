package com.zebra.sdk.certificate.internal;

import com.itextpdf.text.pdf.security.SecurityConstants;
import com.zebra.sdk.certificate.ZebraCertificateException;
import com.zebra.sdk.util.internal.Base64;
import com.zebra.sdk.util.internal.CertificateInfo;
import com.zebra.sdk.util.internal.StringUtilities;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.apache.commons.io.IOUtils;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cert.jcajce.JcaX509CertificateConverter;
import org.spongycastle.cms.CMSAlgorithm;
import org.spongycastle.crypto.prng.ThreadedSeedGenerator;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.X509CertificateObject;
import org.spongycastle.openssl.PEMEncryptedKeyPair;
import org.spongycastle.openssl.PEMKeyPair;
import org.spongycastle.openssl.PEMParser;
import org.spongycastle.openssl.jcajce.JcaPKCS8Generator;
import org.spongycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder;
import org.spongycastle.openssl.jcajce.JceOpenSSLPKCS8EncryptorBuilder;
import org.spongycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.spongycastle.pkcs.PKCSException;
import org.spongycastle.util.io.pem.PemGenerationException;
import org.spongycastle.util.io.pem.PemWriter;

/* JADX INFO: loaded from: classes3.dex */
public class CertUtilities implements CertUtilitiesI {
    protected static final String PEM_BEGIN_CERTIFICATE = "-----BEGIN CERTIFICATE-----";
    protected static final String PEM_BEGIN_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----";
    protected static final String PEM_END_CERTIFICATE = "-----END CERTIFICATE-----";
    protected static final String PEM_END_PRIVATE_KEY = "-----END PRIVATE KEY-----";
    protected static final String PEM_FOOTER = "-----END ";
    protected static final String PEM_HEADER = "-----BEGIN ";
    protected static final ASN1ObjectIdentifier PRIVATE_KEY_CMS_ALGO = CMSAlgorithm.AES128_CBC;
    protected static final String ZEBRA_PKCS12_KEY_ALIAS = "zebra_linkos";

    private String convertDerToPem(byte[] bArr) throws ZebraCertificateException {
        if (bArr == null || bArr.length == 0) {
            throw new ZebraCertificateException("The DER contents must be provided");
        }
        return Base64.encodeBytes(bArr);
    }

    private PrivateKeyInfo getKeyFile(String str, String str2) {
        PEMKeyPair pEMKeyPairDecryptKeyPair;
        Security.addProvider(new BouncyCastleProvider());
        PrivateKeyInfo privateKeyInfoDecryptPrivateKeyInfo = null;
        try {
            PEMParser pEMParser = new PEMParser(new StringReader(str));
            Object object = pEMParser.readObject();
            if (!(object instanceof PEMKeyPair)) {
                if (object instanceof PrivateKeyInfo) {
                    privateKeyInfoDecryptPrivateKeyInfo = (PrivateKeyInfo) object;
                } else if (object instanceof PEMEncryptedKeyPair) {
                    JcePEMDecryptorProviderBuilder jcePEMDecryptorProviderBuilder = new JcePEMDecryptorProviderBuilder();
                    jcePEMDecryptorProviderBuilder.setProvider("SC");
                    pEMKeyPairDecryptKeyPair = ((PEMEncryptedKeyPair) object).decryptKeyPair(jcePEMDecryptorProviderBuilder.build(str2.toCharArray()));
                    if (pEMKeyPairDecryptKeyPair != null) {
                    }
                } else if (object instanceof PKCS8EncryptedPrivateKeyInfo) {
                    JceOpenSSLPKCS8DecryptorProviderBuilder jceOpenSSLPKCS8DecryptorProviderBuilder = new JceOpenSSLPKCS8DecryptorProviderBuilder();
                    jceOpenSSLPKCS8DecryptorProviderBuilder.setProvider("SC");
                    privateKeyInfoDecryptPrivateKeyInfo = ((PKCS8EncryptedPrivateKeyInfo) object).decryptPrivateKeyInfo(jceOpenSSLPKCS8DecryptorProviderBuilder.build(str2.toCharArray()));
                }
                pEMParser.close();
                return privateKeyInfoDecryptPrivateKeyInfo;
            }
            pEMKeyPairDecryptKeyPair = (PEMKeyPair) pEMParser.readObject();
            privateKeyInfoDecryptPrivateKeyInfo = pEMKeyPairDecryptKeyPair.getPrivateKeyInfo();
            pEMParser.close();
        } catch (IOException | OperatorCreationException | PKCSException unused) {
        }
        return privateKeyInfoDecryptPrivateKeyInfo;
    }

    private PrivateKeyInfo getKeyFileFromStream(InputStream inputStream, String str) {
        try {
            return getKeyFile(IOUtils.toString(inputStream), str);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public String convertDerCertToPemCert(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("-----BEGIN CERTIFICATE-----\r\n");
        stringBuffer.append(convertDerToPem(bArr));
        stringBuffer.append("-----END CERTIFICATE-----\r\n");
        return stringBuffer.toString();
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public String convertDerKeyToPemKey(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("-----BEGIN PRIVATE KEY-----\r\n");
        stringBuffer.append(convertDerToPem(bArr));
        stringBuffer.append("-----END PRIVATE KEY-----\r\n");
        return stringBuffer.toString();
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public Certificate[] createCertChain(String str) {
        Security.addProvider(new BouncyCastleProvider());
        PEMParser pEMParser = new PEMParser(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("certificates/ZebraCAChain.cer")));
        PEMParser pEMParser2 = new PEMParser(new StringReader(str));
        X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) pEMParser2.readObject();
        X509CertificateHolder x509CertificateHolder2 = (X509CertificateHolder) pEMParser.readObject();
        X509CertificateHolder x509CertificateHolder3 = (X509CertificateHolder) pEMParser.readObject();
        pEMParser2.close();
        pEMParser.close();
        JcaX509CertificateConverter provider = new JcaX509CertificateConverter().setProvider("SC");
        return new X509Certificate[]{(X509CertificateObject) provider.getCertificate(x509CertificateHolder), (X509CertificateObject) provider.getCertificate(x509CertificateHolder2), (X509CertificateObject) provider.getCertificate(x509CertificateHolder3)};
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public void createP12File(PrivateKey privateKey, Certificate[] certificateArr, String str, String str2) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, null);
        keyStore.setKeyEntry(ZEBRA_PKCS12_KEY_ALIAS, privateKey, str2.toCharArray(), certificateArr);
        keyStore.store(getOutputStream(str), str2.toCharArray());
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public void getCaFromPkcs12Keystore(String str, OutputStream outputStream, KeyStore keyStore) throws ZebraCertificateException, IOException {
        if (keyStore == null) {
            throw new IllegalArgumentException("A keystore must be supplied");
        }
        Security.addProvider(new BouncyCastleProvider());
        Certificate[] certificateChain = getCertificateChain(str, keyStore);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        for (int i = 1; i < certificateChain.length; i++) {
            try {
                try {
                    outputStreamWriter.write(convertDerCertToPemCert(certificateChain[i].getEncoded()) + StringUtilities.CRLF);
                } catch (CertificateEncodingException e) {
                    throw new ZebraCertificateException("Failed to encode the certificate provided in the p12 file.", e);
                }
            } catch (Throwable th) {
                outputStreamWriter.close();
                throw th;
            }
        }
        outputStreamWriter.close();
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public Certificate getCertificate(String str) {
        Security.addProvider(new BouncyCastleProvider());
        try {
            return CertificateFactory.getInstance("X.509", "SC").generateCertificate(IOUtils.toInputStream(str));
        } catch (NoSuchProviderException | CertificateException unused) {
            return null;
        }
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public Certificate[] getCertificateChain(String str, KeyStore keyStore) throws ZebraCertificateException {
        try {
            Certificate[] certificateChain = keyStore.getCertificateChain(str);
            if (certificateChain == null || certificateChain.length == 0) {
                throw new ZebraCertificateException("Error: Could not locate the certificate within the provided PKCS12 file. Make sure the alias used is valid.");
            }
            return certificateChain;
        } catch (KeyStoreException e) {
            throw new ZebraCertificateException("The p12 file was not valid.", e);
        }
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public void getCertificateFromPkcs12Keystore(String str, OutputStream outputStream, KeyStore keyStore) throws ZebraCertificateException, IOException {
        Security.addProvider(new BouncyCastleProvider());
        Certificate[] certificateChain = getCertificateChain(str, keyStore);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        try {
            try {
                outputStreamWriter.write(convertDerCertToPemCert(certificateChain[0].getEncoded()));
                outputStreamWriter.close();
            } catch (CertificateEncodingException e) {
                throw new ZebraCertificateException("Failed to encode the certificate provided in the p12 file.", e);
            }
        } catch (Throwable th) {
            outputStreamWriter.close();
            throw th;
        }
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public KeyPair getKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException {
        Security.addProvider(new BouncyCastleProvider());
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(SecurityConstants.RSA, "SC");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    public OutputStream getOutputStream(String str) {
        return new FileOutputStream(str);
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public PrivateKey getPrivateKey(String str, String str2, KeyStore keyStore) throws UnrecoverableKeyException {
        Security.addProvider(new BouncyCastleProvider());
        try {
            Key key = keyStore.getKey(str, str2.toCharArray());
            if (key instanceof PrivateKey) {
                return (PrivateKey) key;
            }
            throw new UnrecoverableKeyException("Could not recover the private key from the pkcs12 file. Verify that the provided passkey is correct and any provided aliases are valid.");
        } catch (KeyStoreException unused) {
            throw new UnrecoverableKeyException("Could not recover the private key from the pkcs12 file. Verify that the provided passkey is correct and any provided aliases are valid.");
        } catch (NoSuchAlgorithmException e) {
            throw new UnrecoverableKeyException("Could not recover the private key from the pkcs12 file. The key algorithm may not be supported: " + e.getLocalizedMessage());
        }
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public void getPrivateKeyFromPkcs12Keystore(String str, String str2, String str3, OutputStream outputStream, KeyStore keyStore) {
        if (str3 == null || str3.isEmpty()) {
            throw new IllegalArgumentException("A private key passphrase must be supplied");
        }
        if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("A p12 keystore passphrase must be supplied");
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("An alias must be supplied");
        }
        if (keyStore == null) {
            throw new IllegalArgumentException("A keystore must be supplied");
        }
        Security.addProvider(new BouncyCastleProvider());
        savePrivateKey(getPrivateKey(str, str2, keyStore), new OutputStreamWriter(outputStream), str3);
    }

    public Writer getWriter(String str) {
        return new FileWriter(str);
    }

    @Override // com.zebra.sdk.certificate.internal.CertUtilitiesI
    public void save(CertificateInfo certificateInfo, KeyPair keyPair, String str, String str2, String str3, int i, String str4, String str5, String str6) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        if (certificateInfo == null || keyPair == null || str == null || str.isEmpty() || str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty()) {
            throw new IllegalArgumentException("All parameters must be supplied in order to save the p12 fill successfully");
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        String commonName = certificateInfo.getUserRequestInfo().getCommonName();
        String str7 = str + commonName + ".csr";
        String str8 = str + commonName + ".p12";
        savePrivateKey(keyPair.getPrivate(), getWriter(str + commonName + ".key"), str3);
        Writer writer = getWriter(str + commonName + ".cer");
        writer.write(certificateInfo.getCertificate());
        writer.close();
        Writer writer2 = getWriter(str7);
        writer2.write(certificateInfo.getUserRequestInfo().getCsr());
        writer2.close();
        createP12File(keyPair.getPrivate(), createCertChain(certificateInfo.getCertificate()), str8, str2);
    }

    public void savePrivateKey(PrivateKey privateKey, Writer writer, String str) {
        try {
            PemWriter pemWriter = new PemWriter(writer);
            JceOpenSSLPKCS8EncryptorBuilder jceOpenSSLPKCS8EncryptorBuilder = new JceOpenSSLPKCS8EncryptorBuilder(PRIVATE_KEY_CMS_ALGO);
            jceOpenSSLPKCS8EncryptorBuilder.setProvider("SC");
            jceOpenSSLPKCS8EncryptorBuilder.setRandom(new SecureRandom(new ThreadedSeedGenerator().generateSeed(20, true)));
            jceOpenSSLPKCS8EncryptorBuilder.setPasssword(str.toCharArray());
            pemWriter.writeObject(new JcaPKCS8Generator(privateKey, jceOpenSSLPKCS8EncryptorBuilder.build()).generate());
            pemWriter.close();
        } catch (PemGenerationException | IOException | OperatorCreationException unused) {
        }
    }
}
