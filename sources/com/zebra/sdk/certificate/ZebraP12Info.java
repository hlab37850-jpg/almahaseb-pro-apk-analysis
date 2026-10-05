package com.zebra.sdk.certificate;

import androidx.autofill.HintConstants;
import com.zebra.sdk.certificate.internal.CertUtilitiesFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import javax.crypto.BadPaddingException;

/* JADX INFO: loaded from: classes3.dex */
public class ZebraP12Info {
    private String firstAlias;
    private KeyStore keyStore;

    public ZebraP12Info(InputStream inputStream, String str) throws ZebraCertificateException {
        this.keyStore = null;
        this.firstAlias = "";
        try {
            KeyStore pkcs12KeyStore = getPkcs12KeyStore(inputStream, str);
            this.keyStore = pkcs12KeyStore;
            this.firstAlias = pkcs12KeyStore.aliases().nextElement();
        } catch (IOException e) {
            throw new ZebraCertificateException(e.getLocalizedMessage().toLowerCase(Locale.US).contains(HintConstants.AUTOFILL_HINT_PASSWORD) ? "The provided password was incorrect." : "The provided certificate file was invalid.", e);
        } catch (IllegalArgumentException e2) {
            throw new ZebraCertificateException("The provided password was incorrect.", e2);
        } catch (Exception e3) {
            throw new ZebraCertificateException("The provided stream does not appear to contain valid certificate content or the password is incorrect.", e3);
        }
    }

    private KeyStore getPkcs12KeyStore(InputStream inputStream, String str) throws IOException, KeyStoreException {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        if (str == null) {
            str = "";
        }
        try {
            keyStore.load(inputStream, str.toCharArray());
            return keyStore;
        } catch (Exception e) {
            if (e.getCause() != null && (e.getCause() instanceof BadPaddingException)) {
                throw new IllegalArgumentException("The provided password was incorrect.", e);
            }
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            throw new IllegalArgumentException("Failed to read contents of the certificate file - make sure that the provided password is correct.", e);
        }
    }

    public List<String> getAliases() throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<String> enumerationAliases = this.keyStore.aliases();
            while (enumerationAliases != null && enumerationAliases.hasMoreElements()) {
                arrayList.add(enumerationAliases.nextElement());
            }
            return arrayList;
        } catch (KeyStoreException e) {
            throw new ZebraCertificateException("The certificate file was not valid.", e);
        }
    }

    public String getCaCommonName() {
        return getCaCommonName(this.firstAlias);
    }

    public String getCaContent() {
        return getCaContent(this.firstAlias);
    }

    public Date getCaExpirationDate() {
        return getCertificateExpirationDate(this.firstAlias);
    }

    public String getCertificateCommonName() {
        return getCertificateCommonName(this.firstAlias);
    }

    public String getCertificateContent() {
        return getCertificateContent(this.firstAlias);
    }

    public Date getCertificateExpirationDate() {
        return getCertificateExpirationDate(this.firstAlias);
    }

    public String getCertificateIssuer() {
        return getCertificateIssuer(this.firstAlias);
    }

    public String getEncryptedPrivateKeyContent(String str, String str2) {
        return getEncryptedPrivateKeyContent(this.firstAlias, str, str2);
    }

    public KeyStore getKeyStore() {
        return this.keyStore;
    }

    public String getPrivateKeyAlgorithm(String str) {
        return getPrivateKeyAlgorithm(this.firstAlias, str);
    }

    public String getPrivateKeyFormat(String str) {
        return getPrivateKeyFormat(this.firstAlias, str);
    }

    public String getCaCommonName(String str) throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        if (getAliases().contains(str)) {
            Certificate[] certificateChain = CertUtilitiesFactory.getCertUtilities().getCertificateChain(str, this.keyStore);
            try {
                return CertUtilitiesFactory.getCertificateHelper().getCommonNameHelper((X509Certificate) certificateChain[certificateChain.length - 1]);
            } catch (CertificateEncodingException e) {
                throw new ZebraCertificateException("The certificate could not be parsed for a common name.", e);
            }
        }
        throw new ZebraCertificateException("The provided alias \"" + str + "\" was not found in the provided keystore.");
    }

    public String getCaContent(String str) throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        if (!getAliases().contains(str)) {
            throw new ZebraCertificateException("The provided alias \"" + str + "\" was not found in the provided keystore.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            CertUtilitiesFactory.getCertUtilities().getCaFromPkcs12Keystore(str, byteArrayOutputStream, this.keyStore);
            String str2 = new String(byteArrayOutputStream.toByteArray());
            if (str2.isEmpty()) {
                throw new ZebraCertificateException("The provided certificate file does not contain a ca.");
            }
            return str2;
        } catch (IOException e) {
            throw new ZebraCertificateException("Failed to retrieve the ca contents", e);
        }
    }

    public Date getCaExpirationDate(String str) throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        if (getAliases().contains(str)) {
            Certificate[] certificateChain = CertUtilitiesFactory.getCertUtilities().getCertificateChain(str, this.keyStore);
            return ((X509Certificate) certificateChain[certificateChain.length - 1]).getNotAfter();
        }
        throw new ZebraCertificateException("The provided alias \"" + str + "\" was not found in the provided keystore.");
    }

    public String getCertificateCommonName(String str) throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        if (getAliases().contains(str)) {
            try {
                return CertUtilitiesFactory.getCertificateHelper().getCommonNameHelper((X509Certificate) CertUtilitiesFactory.getCertUtilities().getCertificateChain(str, this.keyStore)[0]);
            } catch (CertificateEncodingException e) {
                throw new ZebraCertificateException("The certificate could not be parsed for a common name.", e);
            }
        }
        throw new ZebraCertificateException("The provided alias \"" + str + "\" was not found in the provided keystore.");
    }

    public String getCertificateContent(String str) throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        if (getAliases().contains(str)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                CertUtilitiesFactory.getCertUtilities().getCertificateFromPkcs12Keystore(str, byteArrayOutputStream, this.keyStore);
                return new String(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                throw new ZebraCertificateException("Failed to retrieve the certificate contents", e);
            }
        }
        throw new ZebraCertificateException("The provided alias \"" + str + "\" was not found in the provided keystore.");
    }

    public Date getCertificateExpirationDate(String str) throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        if (getAliases().contains(str)) {
            return ((X509Certificate) CertUtilitiesFactory.getCertUtilities().getCertificateChain(str, this.keyStore)[0]).getNotAfter();
        }
        throw new ZebraCertificateException("The provided alias \"" + str + "\" was not found in the provided keystore.");
    }

    public String getCertificateIssuer(String str) throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        if (getAliases().contains(str)) {
            return ((X509Certificate) CertUtilitiesFactory.getCertUtilities().getCertificateChain(str, this.keyStore)[0]).getIssuerX500Principal().getName();
        }
        throw new ZebraCertificateException("The provided alias \"" + str + "\" was not found in the provided keystore.");
    }

    public String getEncryptedPrivateKeyContent(String str, String str2, String str3) throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        if (!getAliases().contains(str)) {
            throw new ZebraCertificateException("The provided alias \"" + str + "\" was not found in the provided keystore.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            CertUtilitiesFactory.getCertUtilities().getPrivateKeyFromPkcs12Keystore(str, str3, str2, byteArrayOutputStream, this.keyStore);
            return new String(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new ZebraCertificateException("Failed to retrieve the private key contents", e);
        } catch (UnrecoverableKeyException e2) {
            throw new ZebraCertificateException("Could not recover the key from the provided certificate keystore.", e2);
        }
    }

    public String getPrivateKeyAlgorithm(String str, String str2) throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        if (getAliases().contains(str)) {
            try {
                return CertUtilitiesFactory.getCertUtilities().getPrivateKey(str, str2, this.keyStore).getAlgorithm();
            } catch (UnrecoverableKeyException e) {
                throw new ZebraCertificateException("Could not recover the key from the provided certificate keystore.", e);
            }
        }
        throw new ZebraCertificateException("The provided alias \"" + str + "\" was not found in the provided keystore.");
    }

    public String getPrivateKeyFormat(String str, String str2) throws ZebraCertificateException {
        if (this.keyStore == null) {
            throw new ZebraCertificateException("The certificate file was not valid.");
        }
        if (getAliases().contains(str)) {
            try {
                return CertUtilitiesFactory.getCertUtilities().getPrivateKey(str, str2, this.keyStore).getFormat();
            } catch (UnrecoverableKeyException e) {
                throw new ZebraCertificateException("Could not recover the key from the provided certificate keystore.", e);
            }
        }
        throw new ZebraCertificateException("The provided alias \"" + str + "\" was not found in the provided keystore.");
    }
}
