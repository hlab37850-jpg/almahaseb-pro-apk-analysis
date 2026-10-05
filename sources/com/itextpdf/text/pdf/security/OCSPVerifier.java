package com.itextpdf.text.pdf.security;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cert.jcajce.JcaX509CertificateConverter;
import org.spongycastle.cert.ocsp.BasicOCSPResp;
import org.spongycastle.cert.ocsp.CertificateStatus;
import org.spongycastle.cert.ocsp.OCSPException;
import org.spongycastle.cert.ocsp.SingleResp;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.operator.bc.BcDigestCalculatorProvider;
import org.spongycastle.operator.jcajce.JcaContentVerifierProviderBuilder;

/* JADX INFO: loaded from: classes3.dex */
public class OCSPVerifier extends RootStoreVerifier {
    protected static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) OCSPVerifier.class);
    protected static final String id_kp_OCSPSigning = "1.3.6.1.5.5.7.3.9";
    protected List<BasicOCSPResp> ocsps;

    public OCSPVerifier(CertificateVerifier certificateVerifier, List<BasicOCSPResp> list) {
        super(certificateVerifier);
        this.ocsps = list;
    }

    public BasicOCSPResp getOcspResponse(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        BasicOCSPResp basicOCSPResp;
        if ((x509Certificate == null && x509Certificate2 == null) || (basicOCSPResp = new OcspClientBouncyCastle().getBasicOCSPResp(x509Certificate, x509Certificate2, null)) == null) {
            return null;
        }
        for (SingleResp singleResp : basicOCSPResp.getResponses()) {
            if (singleResp.getCertStatus() == CertificateStatus.GOOD) {
                return basicOCSPResp;
            }
        }
        return null;
    }

    public boolean isSignatureValid(BasicOCSPResp basicOCSPResp, Certificate certificate) {
        try {
            return basicOCSPResp.isSignatureValid(new JcaContentVerifierProviderBuilder().setProvider("BC").build(certificate.getPublicKey()));
        } catch (OperatorCreationException | OCSPException unused) {
            return false;
        }
    }

    public void isValidResponse(BasicOCSPResp basicOCSPResp, X509Certificate x509Certificate) throws VerificationException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        CRL crl;
        X509Certificate x509Certificate2 = isSignatureValid(basicOCSPResp, x509Certificate) ? x509Certificate : null;
        if (x509Certificate2 == null) {
            if (basicOCSPResp.getCerts() != null) {
                for (X509CertificateHolder x509CertificateHolder : basicOCSPResp.getCerts()) {
                    try {
                        X509Certificate certificate = new JcaX509CertificateConverter().getCertificate(x509CertificateHolder);
                        List<String> extendedKeyUsage = certificate.getExtendedKeyUsage();
                        if (extendedKeyUsage != null && extendedKeyUsage.contains(id_kp_OCSPSigning) && isSignatureValid(basicOCSPResp, certificate)) {
                            x509Certificate2 = certificate;
                            break;
                        }
                    } catch (CertificateParsingException | Exception unused) {
                    }
                }
                if (x509Certificate2 == null) {
                    throw new VerificationException(x509Certificate, "OCSP response could not be verified");
                }
            } else {
                KeyStore keyStore = this.rootStore;
                if (keyStore != null) {
                    try {
                        Enumeration<String> enumerationAliases = keyStore.aliases();
                        while (enumerationAliases.hasMoreElements()) {
                            String strNextElement = enumerationAliases.nextElement();
                            try {
                                if (this.rootStore.isCertificateEntry(strNextElement)) {
                                    X509Certificate x509Certificate3 = (X509Certificate) this.rootStore.getCertificate(strNextElement);
                                    if (isSignatureValid(basicOCSPResp, x509Certificate3)) {
                                        x509Certificate2 = x509Certificate3;
                                        break;
                                    }
                                }
                            } catch (GeneralSecurityException unused2) {
                            }
                        }
                    } catch (KeyStoreException unused3) {
                        x509Certificate2 = null;
                    }
                }
                if (x509Certificate2 == null) {
                    throw new VerificationException(x509Certificate, "OCSP response could not be verified");
                }
            }
        }
        x509Certificate2.verify(x509Certificate.getPublicKey());
        if (x509Certificate2.getExtensionValue(OCSPObjectIdentifiers.id_pkix_ocsp_nocheck.getId()) == null) {
            try {
                crl = CertificateUtil.getCRL(x509Certificate2);
            } catch (Exception unused4) {
                crl = null;
            }
            if (crl != null && (crl instanceof X509CRL)) {
                CRLVerifier cRLVerifier = new CRLVerifier(null, null);
                cRLVerifier.setRootStore(this.rootStore);
                cRLVerifier.setOnlineCheckingAllowed(this.onlineCheckingAllowed);
                cRLVerifier.verify((X509CRL) crl, x509Certificate2, x509Certificate, new Date());
                return;
            }
        }
        x509Certificate2.checkValidity();
    }

    @Override // com.itextpdf.text.pdf.security.RootStoreVerifier, com.itextpdf.text.pdf.security.CertificateVerifier
    public List<VerificationOK> verify(X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) {
        int i;
        ArrayList arrayList = new ArrayList();
        List<BasicOCSPResp> list = this.ocsps;
        boolean z = false;
        if (list != null) {
            Iterator<BasicOCSPResp> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (verify(it.next(), x509Certificate, x509Certificate2, date)) {
                    i++;
                }
            }
        } else {
            i = 0;
        }
        if (this.onlineCheckingAllowed && i == 0 && verify(getOcspResponse(x509Certificate, x509Certificate2), x509Certificate, x509Certificate2, date)) {
            i++;
            z = true;
        }
        LOGGER.info("Valid OCSPs found: " + i);
        if (i > 0) {
            Class<?> cls = getClass();
            StringBuilder sb = new StringBuilder();
            sb.append("Valid OCSPs Found: ");
            sb.append(i);
            sb.append(z ? " (online)" : "");
            arrayList.add(new VerificationOK(x509Certificate, cls, sb.toString()));
        }
        CertificateVerifier certificateVerifier = this.verifier;
        if (certificateVerifier != null) {
            arrayList.addAll(certificateVerifier.verify(x509Certificate, x509Certificate2, date));
        }
        return arrayList;
    }

    @Deprecated
    public boolean verifyResponse(BasicOCSPResp basicOCSPResp, X509Certificate x509Certificate) {
        try {
            isValidResponse(basicOCSPResp, x509Certificate);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean verify(BasicOCSPResp basicOCSPResp, X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) throws VerificationException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (basicOCSPResp == null) {
            return false;
        }
        SingleResp[] responses = basicOCSPResp.getResponses();
        for (int i = 0; i < responses.length; i++) {
            if (x509Certificate.getSerialNumber().equals(responses[i].getCertID().getSerialNumber())) {
                if (x509Certificate2 == null) {
                    x509Certificate2 = x509Certificate;
                }
                try {
                    if (!responses[i].getCertID().matchesIssuer(new X509CertificateHolder(x509Certificate2.getEncoded()), new BcDigestCalculatorProvider())) {
                        LOGGER.info("OCSP: Issuers doesn't match.");
                    } else {
                        Date nextUpdate = responses[i].getNextUpdate();
                        if (nextUpdate == null) {
                            nextUpdate = new Date(responses[i].getThisUpdate().getTime() + 180000);
                            LOGGER.info(String.format("No 'next update' for OCSP Response; assuming %s", nextUpdate));
                        }
                        if (date.after(nextUpdate)) {
                            LOGGER.info(String.format("OCSP no longer valid: %s after %s", date, nextUpdate));
                        } else if (responses[i].getCertStatus() == CertificateStatus.GOOD) {
                            isValidResponse(basicOCSPResp, x509Certificate2);
                            return true;
                        }
                    }
                } catch (OCSPException unused) {
                    continue;
                }
            }
        }
        return false;
    }
}
