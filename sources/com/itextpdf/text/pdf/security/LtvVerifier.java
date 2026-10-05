package com.itextpdf.text.pdf.security;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import java.io.ByteArrayInputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.spongycastle.cert.ocsp.BasicOCSPResp;
import org.spongycastle.cert.ocsp.OCSPException;
import org.spongycastle.cert.ocsp.OCSPResp;

/* JADX INFO: loaded from: classes3.dex */
public class LtvVerifier extends RootStoreVerifier {
    protected static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) LtvVerifier.class);
    protected PdfDictionary dss;
    protected AcroFields fields;
    protected boolean latestRevision;
    protected LtvVerification.CertificateOption option;
    protected PdfPKCS7 pkcs7;
    protected PdfReader reader;
    protected Date signDate;
    protected String signatureName;
    protected boolean verifyRootCertificate;

    public LtvVerifier(PdfReader pdfReader) throws VerificationException {
        super(null);
        this.option = LtvVerification.CertificateOption.SIGNING_CERTIFICATE;
        this.verifyRootCertificate = true;
        this.latestRevision = true;
        this.reader = pdfReader;
        AcroFields acroFields = pdfReader.getAcroFields();
        this.fields = acroFields;
        ArrayList<String> signatureNames = acroFields.getSignatureNames();
        this.signatureName = signatureNames.get(signatureNames.size() - 1);
        this.signDate = new Date();
        PdfPKCS7 pdfPKCS7CoversWholeDocument = coversWholeDocument();
        this.pkcs7 = pdfPKCS7CoversWholeDocument;
        LOGGER.info(String.format("Checking %ssignature %s", pdfPKCS7CoversWholeDocument.isTsp() ? "document-level timestamp " : "", this.signatureName));
    }

    public PdfPKCS7 coversWholeDocument() throws VerificationException {
        PdfPKCS7 pdfPKCS7VerifySignature = this.fields.verifySignature(this.signatureName);
        if (!this.fields.signatureCoversWholeDocument(this.signatureName)) {
            throw new VerificationException(null, "Signature doesn't cover whole document.");
        }
        Logger logger = LOGGER;
        logger.info("The timestamp covers whole document.");
        if (!pdfPKCS7VerifySignature.verify()) {
            throw new VerificationException(null, "The document was altered after the final signature was applied.");
        }
        logger.info("The signed document has not been modified.");
        return pdfPKCS7VerifySignature;
    }

    public List<X509CRL> getCRLsFromDSS() throws CertificateException {
        PdfArray asArray;
        ArrayList arrayList = new ArrayList();
        PdfDictionary pdfDictionary = this.dss;
        if (pdfDictionary == null || (asArray = pdfDictionary.getAsArray(PdfName.CRLS)) == null) {
            return arrayList;
        }
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        for (int i = 0; i < asArray.size(); i++) {
            arrayList.add((X509CRL) certificateFactory.generateCRL(new ByteArrayInputStream(PdfReader.getStreamBytes((PRStream) asArray.getAsStream(i)))));
        }
        return arrayList;
    }

    public List<BasicOCSPResp> getOCSPResponsesFromDSS() throws GeneralSecurityException {
        PdfArray asArray;
        ArrayList arrayList = new ArrayList();
        PdfDictionary pdfDictionary = this.dss;
        if (pdfDictionary == null || (asArray = pdfDictionary.getAsArray(PdfName.OCSPS)) == null) {
            return arrayList;
        }
        for (int i = 0; i < asArray.size(); i++) {
            OCSPResp oCSPResp = new OCSPResp(PdfReader.getStreamBytes((PRStream) asArray.getAsStream(i)));
            if (oCSPResp.getStatus() == 0) {
                try {
                    arrayList.add((BasicOCSPResp) oCSPResp.getResponseObject());
                } catch (OCSPException e) {
                    throw new GeneralSecurityException((Throwable) e);
                }
            }
        }
        return arrayList;
    }

    public void setCertificateOption(LtvVerification.CertificateOption certificateOption) {
        this.option = certificateOption;
    }

    public void setVerifier(CertificateVerifier certificateVerifier) {
        this.verifier = certificateVerifier;
    }

    public void setVerifyRootCertificate(boolean z) {
        this.verifyRootCertificate = z;
    }

    public void switchToPreviousRevision() throws VerificationException {
        Logger logger = LOGGER;
        logger.info("Switching to previous revision.");
        this.latestRevision = false;
        this.dss = this.reader.getCatalog().getAsDict(PdfName.DSS);
        Calendar timeStampDate = this.pkcs7.getTimeStampDate();
        if (timeStampDate == null) {
            timeStampDate = this.pkcs7.getSignDate();
        }
        this.signDate = timeStampDate.getTime();
        ArrayList<String> signatureNames = this.fields.getSignatureNames();
        if (signatureNames.size() <= 1) {
            logger.info("No signatures in revision");
            this.pkcs7 = null;
            return;
        }
        this.signatureName = signatureNames.get(signatureNames.size() - 2);
        PdfReader pdfReader = new PdfReader(this.fields.extractRevision(this.signatureName));
        this.reader = pdfReader;
        AcroFields acroFields = pdfReader.getAcroFields();
        this.fields = acroFields;
        ArrayList<String> signatureNames2 = acroFields.getSignatureNames();
        this.signatureName = signatureNames2.get(signatureNames2.size() - 1);
        PdfPKCS7 pdfPKCS7CoversWholeDocument = coversWholeDocument();
        this.pkcs7 = pdfPKCS7CoversWholeDocument;
        logger.info(String.format("Checking %ssignature %s", pdfPKCS7CoversWholeDocument.isTsp() ? "document-level timestamp " : "", this.signatureName));
    }

    public List<VerificationOK> verify(List<VerificationOK> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        while (this.pkcs7 != null) {
            list.addAll(verifySignature());
        }
        return list;
    }

    public void verifyChain(Certificate[] certificateArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        for (int i = 0; i < certificateArr.length; i++) {
            ((X509Certificate) certificateArr[i]).checkValidity(this.signDate);
            if (i > 0) {
                certificateArr[i - 1].verify(certificateArr[i].getPublicKey());
            }
        }
        LOGGER.info("All certificates are valid on " + this.signDate.toString());
    }

    public List<VerificationOK> verifySignature() throws VerificationException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        LOGGER.info("Verifying signature.");
        ArrayList arrayList = new ArrayList();
        Certificate[] signCertificateChain = this.pkcs7.getSignCertificateChain();
        verifyChain(signCertificateChain);
        int length = LtvVerification.CertificateOption.WHOLE_CHAIN.equals(this.option) ? signCertificateChain.length : 1;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            X509Certificate x509Certificate = (X509Certificate) signCertificateChain[i];
            X509Certificate x509Certificate2 = i2 < signCertificateChain.length ? (X509Certificate) signCertificateChain[i2] : null;
            LOGGER.info(x509Certificate.getSubjectDN().getName());
            List<VerificationOK> listVerify = verify(x509Certificate, x509Certificate2, this.signDate);
            if (listVerify.size() == 0) {
                try {
                    x509Certificate.verify(x509Certificate.getPublicKey());
                    if (this.latestRevision && signCertificateChain.length > 1) {
                        listVerify.add(new VerificationOK(x509Certificate, getClass(), "Root certificate in final revision"));
                    }
                    if (listVerify.size() == 0 && this.verifyRootCertificate) {
                        throw new GeneralSecurityException();
                    }
                    if (signCertificateChain.length > 1) {
                        listVerify.add(new VerificationOK(x509Certificate, getClass(), "Root certificate passed without checking"));
                    }
                } catch (GeneralSecurityException unused) {
                    throw new VerificationException(x509Certificate, "Couldn't verify with CRL or OCSP or trusted anchor");
                }
            }
            arrayList.addAll(listVerify);
            i = i2;
        }
        switchToPreviousRevision();
        return arrayList;
    }

    @Override // com.itextpdf.text.pdf.security.RootStoreVerifier, com.itextpdf.text.pdf.security.CertificateVerifier
    public List<VerificationOK> verify(X509Certificate x509Certificate, X509Certificate x509Certificate2, Date date) {
        RootStoreVerifier rootStoreVerifier = new RootStoreVerifier(this.verifier);
        rootStoreVerifier.setRootStore(this.rootStore);
        CRLVerifier cRLVerifier = new CRLVerifier(rootStoreVerifier, getCRLsFromDSS());
        cRLVerifier.setRootStore(this.rootStore);
        boolean z = true;
        cRLVerifier.setOnlineCheckingAllowed(this.latestRevision || this.onlineCheckingAllowed);
        OCSPVerifier oCSPVerifier = new OCSPVerifier(cRLVerifier, getOCSPResponsesFromDSS());
        oCSPVerifier.setRootStore(this.rootStore);
        if (!this.latestRevision && !this.onlineCheckingAllowed) {
            z = false;
        }
        oCSPVerifier.setOnlineCheckingAllowed(z);
        return oCSPVerifier.verify(x509Certificate, x509Certificate2, date);
    }
}
