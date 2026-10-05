package com.zebra.sdk.certificate.internal;

import org.spongycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes3.dex */
public class CertUtilitiesFactory {
    public static CertUtilitiesI getCertUtilities() {
        try {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = CertUtilities.PRIVATE_KEY_CMS_ALGO;
            return (CertUtilitiesI) CertUtilities.class.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    public static CertificateHelperI getCertificateHelper() {
        try {
            return (CertificateHelperI) CertificateHelper.class.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }
}
