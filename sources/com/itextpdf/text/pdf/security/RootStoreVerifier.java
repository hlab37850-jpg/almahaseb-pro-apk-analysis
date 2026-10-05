package com.itextpdf.text.pdf.security;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RootStoreVerifier extends CertificateVerifier {
    protected static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) RootStoreVerifier.class);
    protected KeyStore rootStore;

    public RootStoreVerifier(CertificateVerifier certificateVerifier) {
        super(certificateVerifier);
        this.rootStore = null;
    }

    public void setRootStore(KeyStore keyStore) {
        this.rootStore = keyStore;
    }

    @Override // com.itextpdf.text.pdf.security.CertificateVerifier
    public List<VerificationOK> verify(X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) {
        LOGGER.info("Root store verification: " + x509Certificate.getSubjectDN().getName());
        if (this.rootStore == null) {
            return super.verify(x509Certificate, x509Certificate2, date);
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration<String> enumerationAliases = this.rootStore.aliases();
            while (enumerationAliases.hasMoreElements()) {
                String strNextElement = enumerationAliases.nextElement();
                try {
                    if (this.rootStore.isCertificateEntry(strNextElement)) {
                        x509Certificate.verify(((X509Certificate) this.rootStore.getCertificate(strNextElement)).getPublicKey());
                        LOGGER.info("Certificate verified against root store");
                        arrayList.add(new VerificationOK(x509Certificate, getClass(), "Certificate verified against root store."));
                        arrayList.addAll(super.verify(x509Certificate, x509Certificate2, date));
                        return arrayList;
                    }
                } catch (GeneralSecurityException unused) {
                }
            }
            arrayList.addAll(super.verify(x509Certificate, x509Certificate2, date));
            return arrayList;
        } catch (GeneralSecurityException unused2) {
            return super.verify(x509Certificate, x509Certificate2, date);
        }
    }
}
