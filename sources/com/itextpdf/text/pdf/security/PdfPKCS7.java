package com.itextpdf.text.pdf.security;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfName;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cms.Attribute;
import org.spongycastle.asn1.cms.AttributeTable;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.esf.SignaturePolicyIdentifier;
import org.spongycastle.asn1.ess.ESSCertIDv2;
import org.spongycastle.asn1.ess.SigningCertificate;
import org.spongycastle.asn1.ess.SigningCertificateV2;
import org.spongycastle.asn1.ocsp.BasicOCSPResponse;
import org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.tsp.MessageImprint;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cert.jcajce.JcaX509CertificateHolder;
import org.spongycastle.cert.ocsp.BasicOCSPResp;
import org.spongycastle.cert.ocsp.CertificateID;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.provider.X509CertParser;
import org.spongycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.spongycastle.tsp.TimeStampToken;
import org.spongycastle.tsp.TimeStampTokenInfo;

/* JADX INFO: loaded from: classes3.dex */
public class PdfPKCS7 {
    private byte[] RSAdata;
    private BasicOCSPResp basicResp;
    private Collection<Certificate> certs;
    private Collection<CRL> crls;
    private byte[] digest;
    private String digestAlgorithmOid;
    private byte[] digestAttr;
    private String digestEncryptionAlgorithmOid;
    private Set<String> digestalgos;
    private MessageDigest encContDigest;
    private byte[] externalDigest;
    private byte[] externalRSAdata;
    private PdfName filterSubtype;
    private ExternalDigest interfaceDigest;
    private boolean isCades;
    private boolean isTsp;
    private String location;
    private MessageDigest messageDigest;
    private String provider;
    private String reason;
    private Signature sig;
    private byte[] sigAttr;
    private byte[] sigAttrDer;
    private X509Certificate signCert;
    private Collection<Certificate> signCerts;
    private Calendar signDate;
    private String signName;
    private SignaturePolicyIdentifier signaturePolicyIdentifier;
    private int signerversion;
    private TimeStampToken timeStampToken;
    private boolean verified;
    private boolean verifyResult;
    private int version;

    public PdfPKCS7(PrivateKey privateKey, Certificate[] certificateArr, String str, String str2, ExternalDigest externalDigest, boolean z) throws NoSuchAlgorithmException {
        this.version = 1;
        this.signerversion = 1;
        this.provider = str2;
        this.interfaceDigest = externalDigest;
        String allowedDigests = DigestAlgorithms.getAllowedDigests(str);
        this.digestAlgorithmOid = allowedDigests;
        if (allowedDigests == null) {
            throw new NoSuchAlgorithmException(MessageLocalization.getComposedMessage("unknown.hash.algorithm.1", str));
        }
        this.signCert = (X509Certificate) certificateArr[0];
        this.certs = new ArrayList();
        for (Certificate certificate : certificateArr) {
            this.certs.add(certificate);
        }
        HashSet hashSet = new HashSet();
        this.digestalgos = hashSet;
        hashSet.add(this.digestAlgorithmOid);
        if (privateKey != null) {
            String algorithm = privateKey.getAlgorithm();
            this.digestEncryptionAlgorithmOid = algorithm;
            if (algorithm.equals(SecurityConstants.RSA)) {
                this.digestEncryptionAlgorithmOid = SecurityIDs.ID_RSA;
            } else {
                if (!this.digestEncryptionAlgorithmOid.equals(SecurityConstants.DSA)) {
                    throw new NoSuchAlgorithmException(MessageLocalization.getComposedMessage("unknown.key.algorithm.1", this.digestEncryptionAlgorithmOid));
                }
                this.digestEncryptionAlgorithmOid = SecurityIDs.ID_DSA;
            }
        }
        if (z) {
            this.RSAdata = new byte[0];
            this.messageDigest = DigestAlgorithms.getMessageDigest(getHashAlgorithm(), str2);
        }
        if (privateKey != null) {
            this.sig = initSignature(privateKey);
        }
    }

    private ASN1EncodableVector buildUnauthenticatedAttributes(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ASN1InputStream aSN1InputStream = new ASN1InputStream(new ByteArrayInputStream(bArr));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.2.14"));
        aSN1EncodableVector2.add(new DERSet(aSN1InputStream.readObject()));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        return aSN1EncodableVector;
    }

    private void findCRL(ASN1Sequence aSN1Sequence) {
        try {
            this.crls = new ArrayList();
            for (int i = 0; i < aSN1Sequence.size(); i++) {
                this.crls.add((X509CRL) CertificateFactory.getInstance("X.509").generateCRL(new ByteArrayInputStream(aSN1Sequence.getObjectAt(i).toASN1Primitive().getEncoded("DER"))));
            }
        } catch (Exception unused) {
        }
    }

    private void findOcsp(ASN1Sequence aSN1Sequence) {
        boolean z;
        this.basicResp = null;
        do {
            z = false;
            if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).getId().equals(OCSPObjectIdentifiers.id_pkix_ocsp_basic.getId())) {
                int i = 0;
                while (true) {
                    if (i >= aSN1Sequence.size()) {
                        z = true;
                        break;
                    }
                    if (aSN1Sequence.getObjectAt(i) instanceof ASN1Sequence) {
                        aSN1Sequence = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
                        break;
                    } else {
                        if (aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject) {
                            ASN1TaggedObject objectAt = aSN1Sequence.getObjectAt(i);
                            if (objectAt.getObject() instanceof ASN1Sequence) {
                                aSN1Sequence = (ASN1Sequence) objectAt.getObject();
                                break;
                            }
                            return;
                        }
                        i++;
                    }
                }
            } else {
                this.basicResp = new BasicOCSPResp(BasicOCSPResponse.getInstance(new ASN1InputStream(aSN1Sequence.getObjectAt(1).getOctets()).readObject()));
                return;
            }
        } while (!z);
    }

    private DERSet getAuthenticatedAttributeSet(byte[] bArr, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        boolean z;
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(new ASN1ObjectIdentifier(SecurityIDs.ID_CONTENT_TYPE));
            aSN1EncodableVector2.add(new DERSet(new ASN1ObjectIdentifier(SecurityIDs.ID_PKCS7_DATA)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(new ASN1ObjectIdentifier(SecurityIDs.ID_MESSAGE_DIGEST));
            aSN1EncodableVector3.add(new DERSet(new DEROctetString(bArr)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
            if (collection == null) {
                z = false;
                break;
            }
            Iterator<byte[]> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (it.next() != null) {
                    z = true;
                    break;
                }
            }
            if (bArr2 != null || z) {
                ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                aSN1EncodableVector4.add(new ASN1ObjectIdentifier(SecurityIDs.ID_ADBE_REVOCATION));
                ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                if (z) {
                    ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
                    for (byte[] bArr3 : collection) {
                        if (bArr3 != null) {
                            aSN1EncodableVector6.add(new ASN1InputStream(new ByteArrayInputStream(bArr3)).readObject());
                        }
                    }
                    aSN1EncodableVector5.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector6)));
                }
                if (bArr2 != null) {
                    DEROctetString dEROctetString = new DEROctetString(bArr2);
                    ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                    aSN1EncodableVector8.add(OCSPObjectIdentifiers.id_pkix_ocsp_basic);
                    aSN1EncodableVector8.add(dEROctetString);
                    ASN1Enumerated aSN1Enumerated = new ASN1Enumerated(0);
                    ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                    aSN1EncodableVector9.add(aSN1Enumerated);
                    aSN1EncodableVector9.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector8)));
                    aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector9));
                    aSN1EncodableVector5.add(new DERTaggedObject(true, 1, new DERSequence(aSN1EncodableVector7)));
                }
                aSN1EncodableVector4.add(new DERSet(new DERSequence(aSN1EncodableVector5)));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
            }
            if (cryptoStandard == MakeSignature.CryptoStandard.CADES) {
                ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                aSN1EncodableVector10.add(new ASN1ObjectIdentifier(SecurityIDs.ID_AA_SIGNING_CERTIFICATE_V2));
                ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                if (!DigestAlgorithms.getAllowedDigests("SHA-256").equals(this.digestAlgorithmOid)) {
                    aSN1EncodableVector11.add(new AlgorithmIdentifier(new ASN1ObjectIdentifier(this.digestAlgorithmOid)));
                }
                aSN1EncodableVector11.add(new DEROctetString(this.interfaceDigest.getMessageDigest(getHashAlgorithm()).digest(this.signCert.getEncoded())));
                aSN1EncodableVector10.add(new DERSet(new DERSequence(new DERSequence(new DERSequence(aSN1EncodableVector11)))));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector10));
            }
            if (this.signaturePolicyIdentifier != null) {
                aSN1EncodableVector.add(new Attribute(PKCSObjectIdentifiers.id_aa_ets_sigPolicyId, new DERSet(this.signaturePolicyIdentifier)));
            }
            return new DERSet(aSN1EncodableVector);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private Signature initSignature(PrivateKey privateKey) throws InvalidKeyException {
        Signature signature = this.provider == null ? Signature.getInstance(getDigestAlgorithm()) : Signature.getInstance(getDigestAlgorithm(), this.provider);
        signature.initSign(privateKey);
        return signature;
    }

    private void signCertificateChain() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.signCert);
        ArrayList arrayList2 = new ArrayList(this.certs);
        int i = 0;
        while (i < arrayList2.size()) {
            if (this.signCert.equals(arrayList2.get(i))) {
                arrayList2.remove(i);
                i--;
            }
            i++;
        }
        while (true) {
            boolean z = true;
            while (true) {
                if (!z) {
                    this.signCerts = arrayList;
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
                int i2 = 0;
                boolean z2 = false;
                while (true) {
                    if (i2 < arrayList2.size()) {
                        X509Certificate x509Certificate2 = (X509Certificate) arrayList2.get(i2);
                        try {
                            if (this.provider == null) {
                                x509Certificate.verify(x509Certificate2.getPublicKey());
                            } else {
                                x509Certificate.verify(x509Certificate2.getPublicKey(), this.provider);
                            }
                            try {
                                arrayList.add(arrayList2.get(i2));
                                arrayList2.remove(i2);
                                break;
                            } catch (Exception unused) {
                                z2 = true;
                                i2++;
                            }
                        } catch (Exception unused2) {
                        }
                    } else {
                        z = z2;
                    }
                    i2++;
                }
            }
        }
    }

    private boolean verifySigAttributes(byte[] bArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        Signature signatureInitSignature = initSignature(this.signCert.getPublicKey());
        signatureInitSignature.update(bArr);
        return signatureInitSignature.verify(this.digest);
    }

    public byte[] getAuthenticatedAttributeBytes(byte[] bArr, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        try {
            return getAuthenticatedAttributeSet(bArr, bArr2, collection, cryptoStandard).getEncoded("DER");
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public Collection<CRL> getCRLs() {
        return this.crls;
    }

    public Certificate[] getCertificates() {
        Collection<Certificate> collection = this.certs;
        return (Certificate[]) collection.toArray(new X509Certificate[collection.size()]);
    }

    public String getDigestAlgorithm() {
        return getHashAlgorithm() + "with" + getEncryptionAlgorithm();
    }

    public String getDigestAlgorithmOid() {
        return this.digestAlgorithmOid;
    }

    public String getDigestEncryptionAlgorithmOid() {
        return this.digestEncryptionAlgorithmOid;
    }

    public byte[] getEncodedPKCS1() {
        try {
            byte[] bArr = this.externalDigest;
            if (bArr != null) {
                this.digest = bArr;
            } else {
                this.digest = this.sig.sign();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(new DEROctetString(this.digest));
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public byte[] getEncodedPKCS7() {
        return getEncodedPKCS7(null, null, null, null, MakeSignature.CryptoStandard.CMS);
    }

    public String getEncryptionAlgorithm() {
        String algorithm = EncryptionAlgorithms.getAlgorithm(this.digestEncryptionAlgorithmOid);
        return algorithm == null ? this.digestEncryptionAlgorithmOid : algorithm;
    }

    public PdfName getFilterSubtype() {
        return this.filterSubtype;
    }

    public String getHashAlgorithm() {
        return DigestAlgorithms.getDigest(this.digestAlgorithmOid);
    }

    public String getLocation() {
        return this.location;
    }

    public BasicOCSPResp getOcsp() {
        return this.basicResp;
    }

    public String getReason() {
        return this.reason;
    }

    public Certificate[] getSignCertificateChain() {
        Collection<Certificate> collection = this.signCerts;
        return (Certificate[]) collection.toArray(new X509Certificate[collection.size()]);
    }

    public Calendar getSignDate() {
        Calendar timeStampDate = getTimeStampDate();
        return timeStampDate == null ? this.signDate : timeStampDate;
    }

    public String getSignName() {
        return this.signName;
    }

    public X509Certificate getSigningCertificate() {
        return this.signCert;
    }

    public int getSigningInfoVersion() {
        return this.signerversion;
    }

    public Calendar getTimeStampDate() {
        if (this.timeStampToken == null) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.timeStampToken.getTimeStampInfo().getGenTime());
        return gregorianCalendar;
    }

    public TimeStampToken getTimeStampToken() {
        return this.timeStampToken;
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isRevocationValid() {
        if (this.basicResp == null || this.signCerts.size() < 2) {
            return false;
        }
        try {
            X509Certificate[] x509CertificateArr = (X509Certificate[]) getSignCertificateChain();
            CertificateID certID = this.basicResp.getResponses()[0].getCertID();
            return new CertificateID(new JcaDigestCalculatorProviderBuilder().build().get(new AlgorithmIdentifier(certID.getHashAlgOID(), DERNull.INSTANCE)), new JcaX509CertificateHolder(x509CertificateArr[1]), getSigningCertificate().getSerialNumber()).equals(certID);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isTsp() {
        return this.isTsp;
    }

    public void setExternalDigest(byte[] bArr, byte[] bArr2, String str) {
        this.externalDigest = bArr;
        this.externalRSAdata = bArr2;
        if (str != null) {
            if (str.equals(SecurityConstants.RSA)) {
                this.digestEncryptionAlgorithmOid = SecurityIDs.ID_RSA;
            } else if (str.equals(SecurityConstants.DSA)) {
                this.digestEncryptionAlgorithmOid = SecurityIDs.ID_DSA;
            } else {
                if (!str.equals("ECDSA")) {
                    throw new ExceptionConverter(new NoSuchAlgorithmException(MessageLocalization.getComposedMessage("unknown.key.algorithm.1", str)));
                }
                this.digestEncryptionAlgorithmOid = SecurityIDs.ID_ECDSA;
            }
        }
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setSignDate(Calendar calendar) {
        this.signDate = calendar;
    }

    public void setSignName(String str) {
        this.signName = str;
    }

    public void setSignaturePolicy(SignaturePolicyInfo signaturePolicyInfo) {
        this.signaturePolicyIdentifier = signaturePolicyInfo.toSignaturePolicyIdentifier();
    }

    public void update(byte[] bArr, int i, int i2) throws SignatureException {
        if (this.RSAdata == null && this.digestAttr == null && !this.isTsp) {
            this.sig.update(bArr, i, i2);
        } else {
            this.messageDigest.update(bArr, i, i2);
        }
    }

    public boolean verify() throws SignatureException {
        boolean zEquals;
        boolean zEquals2;
        if (this.verified) {
            return this.verifyResult;
        }
        if (this.isTsp) {
            this.verifyResult = Arrays.equals(this.messageDigest.digest(), this.timeStampToken.getTimeStampInfo().toASN1Structure().getMessageImprint().getHashedMessage());
        } else if (this.sigAttr == null && this.sigAttrDer == null) {
            if (this.RSAdata != null) {
                this.sig.update(this.messageDigest.digest());
            }
            this.verifyResult = this.sig.verify(this.digest);
        } else {
            byte[] bArrDigest = this.messageDigest.digest();
            byte[] bArr = this.RSAdata;
            boolean z = false;
            if (bArr != null) {
                zEquals = Arrays.equals(bArrDigest, bArr);
                this.encContDigest.update(this.RSAdata);
                zEquals2 = Arrays.equals(this.encContDigest.digest(), this.digestAttr);
            } else {
                zEquals = true;
                zEquals2 = false;
            }
            boolean z2 = Arrays.equals(bArrDigest, this.digestAttr) || zEquals2;
            boolean z3 = verifySigAttributes(this.sigAttr) || verifySigAttributes(this.sigAttrDer);
            if (z2 && z3 && zEquals) {
                z = true;
            }
            this.verifyResult = z;
        }
        this.verified = true;
        return this.verifyResult;
    }

    public boolean verifyTimestampImprint() {
        TimeStampToken timeStampToken = this.timeStampToken;
        if (timeStampToken == null) {
            return false;
        }
        TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
        MessageImprint messageImprint = timeStampInfo.toASN1Structure().getMessageImprint();
        return Arrays.equals(new BouncyCastleDigest().getMessageDigest(DigestAlgorithms.getDigest(timeStampInfo.getMessageImprintAlgOID().getId())).digest(this.digest), messageImprint.getHashedMessage());
    }

    public byte[] getEncodedPKCS7(byte[] bArr) {
        return getEncodedPKCS7(bArr, null, null, null, MakeSignature.CryptoStandard.CMS);
    }

    public void setSignaturePolicy(SignaturePolicyIdentifier signaturePolicyIdentifier) {
        this.signaturePolicyIdentifier = signaturePolicyIdentifier;
    }

    public byte[] getEncodedPKCS7(byte[] bArr, TSAClient tSAClient, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        byte[] timeStampToken;
        ASN1EncodableVector aSN1EncodableVectorBuildUnauthenticatedAttributes;
        try {
            byte[] bArr3 = this.externalDigest;
            if (bArr3 != null) {
                this.digest = bArr3;
                if (this.RSAdata != null) {
                    this.RSAdata = this.externalRSAdata;
                }
            } else {
                byte[] bArr4 = this.externalRSAdata;
                if (bArr4 != null && this.RSAdata != null) {
                    this.RSAdata = bArr4;
                    this.sig.update(bArr4);
                    this.digest = this.sig.sign();
                } else {
                    if (this.RSAdata != null) {
                        byte[] bArrDigest = this.messageDigest.digest();
                        this.RSAdata = bArrDigest;
                        this.sig.update(bArrDigest);
                    }
                    this.digest = this.sig.sign();
                }
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (String str : this.digestalgos) {
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                aSN1EncodableVector2.add(new ASN1ObjectIdentifier(str));
                aSN1EncodableVector2.add(DERNull.INSTANCE);
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            }
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(new ASN1ObjectIdentifier(SecurityIDs.ID_PKCS7_DATA));
            if (this.RSAdata != null) {
                aSN1EncodableVector3.add(new DERTaggedObject(0, new DEROctetString(this.RSAdata)));
            }
            DERSequence dERSequence = new DERSequence(aSN1EncodableVector3);
            ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
            Iterator<Certificate> it = this.certs.iterator();
            while (it.hasNext()) {
                aSN1EncodableVector4.add(new ASN1InputStream(new ByteArrayInputStream(((X509Certificate) it.next()).getEncoded())).readObject());
            }
            DERSet dERSet = new DERSet(aSN1EncodableVector4);
            ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
            aSN1EncodableVector5.add(new ASN1Integer(this.signerversion));
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            aSN1EncodableVector6.add(CertificateInfo.getIssuer(this.signCert.getTBSCertificate()));
            aSN1EncodableVector6.add(new ASN1Integer(this.signCert.getSerialNumber()));
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector6));
            ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
            aSN1EncodableVector7.add(new ASN1ObjectIdentifier(this.digestAlgorithmOid));
            aSN1EncodableVector7.add(new DERNull());
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector7));
            if (bArr != null) {
                aSN1EncodableVector5.add(new DERTaggedObject(false, 0, getAuthenticatedAttributeSet(bArr, bArr2, collection, cryptoStandard)));
            }
            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
            aSN1EncodableVector8.add(new ASN1ObjectIdentifier(this.digestEncryptionAlgorithmOid));
            aSN1EncodableVector8.add(new DERNull());
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector8));
            aSN1EncodableVector5.add(new DEROctetString(this.digest));
            if (tSAClient != null && (timeStampToken = tSAClient.getTimeStampToken(tSAClient.getMessageDigest().digest(this.digest))) != null && (aSN1EncodableVectorBuildUnauthenticatedAttributes = buildUnauthenticatedAttributes(timeStampToken)) != null) {
                aSN1EncodableVector5.add(new DERTaggedObject(false, 1, new DERSet(aSN1EncodableVectorBuildUnauthenticatedAttributes)));
            }
            ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
            aSN1EncodableVector9.add(new ASN1Integer(this.version));
            aSN1EncodableVector9.add(new DERSet(aSN1EncodableVector));
            aSN1EncodableVector9.add(dERSequence);
            aSN1EncodableVector9.add(new DERTaggedObject(false, 0, dERSet));
            aSN1EncodableVector9.add(new DERSet(new DERSequence(aSN1EncodableVector5)));
            ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
            aSN1EncodableVector10.add(new ASN1ObjectIdentifier(SecurityIDs.ID_PKCS7_SIGNED_DATA));
            aSN1EncodableVector10.add(new DERTaggedObject(0, new DERSequence(aSN1EncodableVector9)));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(new DERSequence(aSN1EncodableVector10));
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private Signature initSignature(PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        Signature signature;
        String digestAlgorithm = getDigestAlgorithm();
        if (PdfName.ADBE_X509_RSA_SHA1.equals(getFilterSubtype())) {
            digestAlgorithm = "SHA1withRSA";
        }
        String str = this.provider;
        if (str == null) {
            signature = Signature.getInstance(digestAlgorithm);
        } else {
            signature = Signature.getInstance(digestAlgorithm, str);
        }
        signature.initVerify(publicKey);
        return signature;
    }

    public PdfPKCS7(byte[] bArr, byte[] bArr2, String str) {
        this.version = 1;
        this.signerversion = 1;
        try {
            this.provider = str;
            X509CertParser x509CertParser = new X509CertParser();
            x509CertParser.engineInit(new ByteArrayInputStream(bArr2));
            Collection<Certificate> collectionEngineReadAll = x509CertParser.engineReadAll();
            this.certs = collectionEngineReadAll;
            this.signCerts = collectionEngineReadAll;
            this.signCert = (X509Certificate) collectionEngineReadAll.iterator().next();
            this.crls = new ArrayList();
            this.digest = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject().getOctets();
            if (str == null) {
                this.sig = Signature.getInstance("SHA1withRSA");
            } else {
                this.sig = Signature.getInstance("SHA1withRSA", str);
            }
            this.sig.initVerify(this.signCert.getPublicKey());
            this.digestAlgorithmOid = "1.2.840.10040.4.3";
            this.digestEncryptionAlgorithmOid = "1.3.36.3.3.1.2";
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public PdfPKCS7(byte[] bArr, PdfName pdfName, String str) {
        boolean z;
        Attribute attribute;
        this.version = 1;
        this.signerversion = 1;
        this.filterSubtype = pdfName;
        this.isTsp = PdfName.ETSI_RFC3161.equals(pdfName);
        this.isCades = PdfName.ETSI_CADES_DETACHED.equals(pdfName);
        try {
            this.provider = str;
            try {
                ASN1Sequence object = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject();
                if (object instanceof ASN1Sequence) {
                    ASN1Sequence aSN1Sequence = object;
                    if (aSN1Sequence.getObjectAt(0).getId().equals(SecurityIDs.ID_PKCS7_SIGNED_DATA)) {
                        ASN1Sequence object2 = aSN1Sequence.getObjectAt(1).getObject();
                        this.version = object2.getObjectAt(0).getValue().intValue();
                        this.digestalgos = new HashSet();
                        Enumeration objects = object2.getObjectAt(1).getObjects();
                        while (objects.hasMoreElements()) {
                            this.digestalgos.add(((ASN1Sequence) objects.nextElement()).getObjectAt(0).getId());
                        }
                        ASN1Sequence objectAt = object2.getObjectAt(2);
                        if (objectAt.size() > 1) {
                            this.RSAdata = objectAt.getObjectAt(1).getObject().getOctets();
                        }
                        int i = 3;
                        int i2 = 3;
                        while (object2.getObjectAt(i2) instanceof ASN1TaggedObject) {
                            i2++;
                        }
                        X509CertParser x509CertParser = new X509CertParser();
                        x509CertParser.engineInit(new ByteArrayInputStream(bArr));
                        this.certs = x509CertParser.engineReadAll();
                        ASN1Set objectAt2 = object2.getObjectAt(i2);
                        if (objectAt2.size() == 1) {
                            ASN1Sequence objectAt3 = objectAt2.getObjectAt(0);
                            this.signerversion = objectAt3.getObjectAt(0).getValue().intValue();
                            ASN1Sequence objectAt4 = objectAt3.getObjectAt(1);
                            X509Principal x509Principal = new X509Principal(objectAt4.getObjectAt(0).toASN1Primitive().getEncoded());
                            BigInteger value = objectAt4.getObjectAt(1).getValue();
                            Iterator<Certificate> it = this.certs.iterator();
                            while (it.hasNext()) {
                                X509Certificate x509Certificate = (X509Certificate) it.next();
                                if (x509Certificate.getIssuerDN().equals(x509Principal) && value.equals(x509Certificate.getSerialNumber())) {
                                    this.signCert = x509Certificate;
                                    break;
                                }
                            }
                            if (this.signCert != null) {
                                signCertificateChain();
                                this.digestAlgorithmOid = objectAt3.getObjectAt(2).getObjectAt(0).getId();
                                if (objectAt3.getObjectAt(3) instanceof ASN1TaggedObject) {
                                    ASN1Set aSN1Set = ASN1Set.getInstance(objectAt3.getObjectAt(3), false);
                                    this.sigAttr = aSN1Set.getEncoded();
                                    this.sigAttrDer = aSN1Set.getEncoded("DER");
                                    z = false;
                                    for (int i3 = 0; i3 < aSN1Set.size(); i3++) {
                                        ASN1Sequence objectAt5 = aSN1Set.getObjectAt(i3);
                                        String id = objectAt5.getObjectAt(0).getId();
                                        if (id.equals(SecurityIDs.ID_MESSAGE_DIGEST)) {
                                            this.digestAttr = objectAt5.getObjectAt(1).getObjectAt(0).getOctets();
                                        } else if (id.equals(SecurityIDs.ID_ADBE_REVOCATION)) {
                                            ASN1Sequence objectAt6 = objectAt5.getObjectAt(1).getObjectAt(0);
                                            for (int i4 = 0; i4 < objectAt6.size(); i4++) {
                                                ASN1TaggedObject objectAt7 = objectAt6.getObjectAt(i4);
                                                if (objectAt7.getTagNo() == 0) {
                                                    findCRL((ASN1Sequence) objectAt7.getObject());
                                                }
                                                if (objectAt7.getTagNo() == 1) {
                                                    findOcsp((ASN1Sequence) objectAt7.getObject());
                                                }
                                            }
                                        } else {
                                            if (this.isCades && id.equals(SecurityIDs.ID_AA_SIGNING_CERTIFICATE_V1)) {
                                                if (!Arrays.equals(new BouncyCastleDigest().getMessageDigest(DigestAlgorithms.SHA1).digest(this.signCert.getEncoded()), SigningCertificate.getInstance(objectAt5.getObjectAt(1).getObjectAt(0)).getCerts()[0].getCertHash())) {
                                                    throw new IllegalArgumentException("Signing certificate doesn't match the ESS information.");
                                                }
                                            } else if (this.isCades && id.equals(SecurityIDs.ID_AA_SIGNING_CERTIFICATE_V2)) {
                                                ESSCertIDv2 eSSCertIDv2 = SigningCertificateV2.getInstance(objectAt5.getObjectAt(1).getObjectAt(0)).getCerts()[0];
                                                if (!Arrays.equals(new BouncyCastleDigest().getMessageDigest(DigestAlgorithms.getDigest(eSSCertIDv2.getHashAlgorithm().getAlgorithm().getId())).digest(this.signCert.getEncoded()), eSSCertIDv2.getCertHash())) {
                                                    throw new IllegalArgumentException("Signing certificate doesn't match the ESS information.");
                                                }
                                            }
                                            z = true;
                                        }
                                    }
                                    if (this.digestAttr == null) {
                                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("authenticated.attribute.is.missing.the.digest", new Object[0]));
                                    }
                                    i = 4;
                                } else {
                                    z = false;
                                }
                                if (this.isCades && !z) {
                                    throw new IllegalArgumentException("CAdES ESS information missing.");
                                }
                                int i5 = 1 + i;
                                this.digestEncryptionAlgorithmOid = objectAt3.getObjectAt(i).getObjectAt(0).getId();
                                int i6 = i + 2;
                                this.digest = objectAt3.getObjectAt(i5).getOctets();
                                if (i6 < objectAt3.size() && (objectAt3.getObjectAt(i6) instanceof ASN1TaggedObject) && (attribute = new AttributeTable(ASN1Set.getInstance(objectAt3.getObjectAt(i6), false)).get(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken)) != null && attribute.getAttrValues().size() > 0) {
                                    this.timeStampToken = new TimeStampToken(new ContentInfo(ASN1Sequence.getInstance(attribute.getAttrValues().getObjectAt(0))));
                                }
                                if (this.isTsp) {
                                    TimeStampToken timeStampToken = new TimeStampToken(new ContentInfo(aSN1Sequence));
                                    this.timeStampToken = timeStampToken;
                                    this.messageDigest = DigestAlgorithms.getMessageDigestFromOid(timeStampToken.getTimeStampInfo().getMessageImprintAlgOID().getId(), null);
                                    return;
                                }
                                if (this.RSAdata != null || this.digestAttr != null) {
                                    if (PdfName.ADBE_PKCS7_SHA1.equals(getFilterSubtype())) {
                                        this.messageDigest = DigestAlgorithms.getMessageDigest(SecurityConstants.SHA1, str);
                                    } else {
                                        this.messageDigest = DigestAlgorithms.getMessageDigest(getHashAlgorithm(), str);
                                    }
                                    this.encContDigest = DigestAlgorithms.getMessageDigest(getHashAlgorithm(), str);
                                }
                                this.sig = initSignature(this.signCert.getPublicKey());
                                return;
                            }
                            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("can.t.find.signing.certificate.with.serial.1", x509Principal.getName() + " / " + value.toString(16)));
                        }
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("this.pkcs.7.object.has.multiple.signerinfos.only.one.is.supported.at.this.time", new Object[0]));
                    }
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("not.a.valid.pkcs.7.object.not.signed.data", new Object[0]));
                }
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("not.a.valid.pkcs.7.object.not.a.sequence", new Object[0]));
            } catch (IOException unused) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("can.t.decode.pkcs7signeddata.object", new Object[0]));
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
