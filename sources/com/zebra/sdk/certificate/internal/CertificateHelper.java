package com.zebra.sdk.certificate.internal;

import java.io.StringWriter;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import org.spongycastle.asn1.x500.style.BCStyle;
import org.spongycastle.asn1.x500.style.IETFUtils;
import org.spongycastle.cert.jcajce.JcaX509CertificateHolder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.openssl.PEMWriter;

/* JADX INFO: loaded from: classes3.dex */
public class CertificateHelper implements CertificateHelperI {
    @Override // com.zebra.sdk.certificate.internal.CertificateHelperI
    public Provider getCertificateProvider() {
        return new BouncyCastleProvider();
    }

    @Override // com.zebra.sdk.certificate.internal.CertificateHelperI
    public String getCommonNameHelper(X509Certificate x509Certificate) {
        return IETFUtils.valueToString(new JcaX509CertificateHolder(x509Certificate).getSubject().getRDNs(BCStyle.CN)[0].getFirst().getValue());
    }

    @Override // com.zebra.sdk.certificate.internal.CertificateHelperI
    public void pemWriterHelper(PrivateKey privateKey, StringWriter stringWriter) {
        PEMWriter pEMWriter = new PEMWriter(stringWriter);
        pEMWriter.writeObject(privateKey);
        pEMWriter.close();
    }

    @Override // com.zebra.sdk.certificate.internal.CertificateHelperI
    public void pemWriterHelper(Certificate certificate, StringWriter stringWriter) {
        PEMWriter pEMWriter = new PEMWriter(stringWriter);
        pEMWriter.writeObject(certificate);
        pEMWriter.close();
    }
}
