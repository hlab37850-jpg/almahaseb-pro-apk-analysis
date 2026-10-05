package com.itextpdf.text.pdf.security;

import com.itextpdf.text.pdf.codec.Base64;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.esf.OtherHashAlgAndValue;
import org.spongycastle.asn1.esf.SigPolicyQualifierInfo;
import org.spongycastle.asn1.esf.SigPolicyQualifiers;
import org.spongycastle.asn1.esf.SignaturePolicyId;
import org.spongycastle.asn1.esf.SignaturePolicyIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes3.dex */
public class SignaturePolicyInfo {
    private String policyDigestAlgorithm;
    private byte[] policyHash;
    private String policyIdentifier;
    private String policyUri;

    public SignaturePolicyInfo(String str, byte[] bArr, String str2, String str3) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Policy identifier cannot be null");
        }
        if (bArr == null) {
            throw new IllegalArgumentException("Policy hash cannot be null");
        }
        if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("Policy digest algorithm cannot be null");
        }
        this.policyIdentifier = str;
        this.policyHash = bArr;
        this.policyDigestAlgorithm = str2;
        this.policyUri = str3;
    }

    public String getPolicyDigestAlgorithm() {
        return this.policyDigestAlgorithm;
    }

    public byte[] getPolicyHash() {
        return this.policyHash;
    }

    public String getPolicyIdentifier() {
        return this.policyIdentifier;
    }

    public String getPolicyUri() {
        return this.policyUri;
    }

    public SignaturePolicyIdentifier toSignaturePolicyIdentifier() {
        String allowedDigests = DigestAlgorithms.getAllowedDigests(this.policyDigestAlgorithm);
        if (allowedDigests == null || allowedDigests.length() == 0) {
            throw new IllegalArgumentException("Invalid policy hash algorithm");
        }
        String str = this.policyUri;
        return new SignaturePolicyIdentifier(new SignaturePolicyId(DERObjectIdentifier.getInstance(new DERObjectIdentifier(this.policyIdentifier.replace("urn:oid:", ""))), new OtherHashAlgAndValue(new AlgorithmIdentifier(allowedDigests), new DEROctetString(this.policyHash)), new SigPolicyQualifiers(new SigPolicyQualifierInfo[]{(str == null || str.length() <= 0) ? null : new SigPolicyQualifierInfo(PKCSObjectIdentifiers.id_spq_ets_uri, new DERIA5String(this.policyUri))})));
    }

    public SignaturePolicyInfo(String str, String str2, String str3, String str4) {
        this(str, str2 != null ? Base64.decode(str2) : null, str3, str4);
    }
}
