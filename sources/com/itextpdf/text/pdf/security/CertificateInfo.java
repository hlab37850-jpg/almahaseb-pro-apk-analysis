package com.itextpdf.text.pdf.security;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;

/* JADX INFO: loaded from: classes3.dex */
public class CertificateInfo {

    public static class X509NameTokenizer {
        private StringBuffer buf = new StringBuffer();
        private int index = -1;
        private String oid;

        public X509NameTokenizer(String str) {
            this.oid = str;
        }

        public boolean hasMoreTokens() {
            return this.index != this.oid.length();
        }

        public String nextToken() {
            if (this.index == this.oid.length()) {
                return null;
            }
            int i = this.index + 1;
            this.buf.setLength(0);
            boolean z = false;
            boolean z2 = false;
            while (i != this.oid.length()) {
                char cCharAt = this.oid.charAt(i);
                if (cCharAt != '\"') {
                    if (z || z2) {
                        this.buf.append(cCharAt);
                    } else if (cCharAt == '\\') {
                        z = true;
                    } else {
                        if (cCharAt == ',') {
                            break;
                        }
                        this.buf.append(cCharAt);
                    }
                    i++;
                } else if (z) {
                    this.buf.append(cCharAt);
                } else {
                    z2 = !z2;
                }
                z = false;
                i++;
            }
            this.index = i;
            return this.buf.toString().trim();
        }
    }

    public static ASN1Primitive getIssuer(byte[] bArr) {
        try {
            ASN1Sequence object = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject();
            return object.getObjectAt(object.getObjectAt(0) instanceof ASN1TaggedObject ? 3 : 2);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static X500Name getIssuerFields(X509Certificate x509Certificate) {
        try {
            return new X500Name(getIssuer(x509Certificate.getTBSCertificate()));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static ASN1Primitive getSubject(byte[] bArr) {
        try {
            ASN1Sequence object = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject();
            return object.getObjectAt(object.getObjectAt(0) instanceof ASN1TaggedObject ? 5 : 4);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static X500Name getSubjectFields(X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            return null;
        }
        try {
            return new X500Name(getSubject(x509Certificate.getTBSCertificate()));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static class X500Name {
        public static final ASN1ObjectIdentifier C;
        public static final ASN1ObjectIdentifier CN;
        public static final ASN1ObjectIdentifier DC;
        public static final Map<ASN1ObjectIdentifier, String> DefaultSymbols;
        public static final ASN1ObjectIdentifier E;
        public static final ASN1ObjectIdentifier EmailAddress;
        public static final ASN1ObjectIdentifier GENERATION;
        public static final ASN1ObjectIdentifier GIVENNAME;
        public static final ASN1ObjectIdentifier INITIALS;
        public static final ASN1ObjectIdentifier L;
        public static final ASN1ObjectIdentifier O;
        public static final ASN1ObjectIdentifier OU;
        public static final ASN1ObjectIdentifier SN;
        public static final ASN1ObjectIdentifier ST;
        public static final ASN1ObjectIdentifier SURNAME;
        public static final ASN1ObjectIdentifier T;
        public static final ASN1ObjectIdentifier UID;
        public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER;
        public Map<String, ArrayList<String>> values = new HashMap();

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.5.4.6");
            C = aSN1ObjectIdentifier;
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.5.4.10");
            O = aSN1ObjectIdentifier2;
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.5.4.11");
            OU = aSN1ObjectIdentifier3;
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("2.5.4.12");
            T = aSN1ObjectIdentifier4;
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("2.5.4.3");
            CN = aSN1ObjectIdentifier5;
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("2.5.4.5");
            SN = aSN1ObjectIdentifier6;
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier("2.5.4.7");
            L = aSN1ObjectIdentifier7;
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("2.5.4.8");
            ST = aSN1ObjectIdentifier8;
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("2.5.4.4");
            SURNAME = aSN1ObjectIdentifier9;
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("2.5.4.42");
            GIVENNAME = aSN1ObjectIdentifier10;
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier("2.5.4.43");
            INITIALS = aSN1ObjectIdentifier11;
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("2.5.4.44");
            GENERATION = aSN1ObjectIdentifier12;
            UNIQUE_IDENTIFIER = new ASN1ObjectIdentifier("2.5.4.45");
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = new ASN1ObjectIdentifier("1.2.840.113549.1.9.1");
            EmailAddress = aSN1ObjectIdentifier13;
            E = aSN1ObjectIdentifier13;
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
            DC = aSN1ObjectIdentifier14;
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
            UID = aSN1ObjectIdentifier15;
            HashMap map = new HashMap();
            DefaultSymbols = map;
            map.put(aSN1ObjectIdentifier, "C");
            map.put(aSN1ObjectIdentifier2, "O");
            map.put(aSN1ObjectIdentifier4, "T");
            map.put(aSN1ObjectIdentifier3, "OU");
            map.put(aSN1ObjectIdentifier5, "CN");
            map.put(aSN1ObjectIdentifier7, "L");
            map.put(aSN1ObjectIdentifier8, "ST");
            map.put(aSN1ObjectIdentifier6, "SN");
            map.put(aSN1ObjectIdentifier13, "E");
            map.put(aSN1ObjectIdentifier14, "DC");
            map.put(aSN1ObjectIdentifier15, "UID");
            map.put(aSN1ObjectIdentifier9, "SURNAME");
            map.put(aSN1ObjectIdentifier10, "GIVENNAME");
            map.put(aSN1ObjectIdentifier11, "INITIALS");
            map.put(aSN1ObjectIdentifier12, "GENERATION");
        }

        public X500Name(ASN1Sequence aSN1Sequence) {
            Enumeration objects = aSN1Sequence.getObjects();
            while (objects.hasMoreElements()) {
                ASN1Set aSN1Set = (ASN1Set) objects.nextElement();
                for (int i = 0; i < aSN1Set.size(); i++) {
                    ASN1Sequence objectAt = aSN1Set.getObjectAt(i);
                    String str = DefaultSymbols.get(objectAt.getObjectAt(0));
                    if (str != null) {
                        ArrayList<String> arrayList = this.values.get(str);
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            this.values.put(str, arrayList);
                        }
                        arrayList.add(objectAt.getObjectAt(1).getString());
                    }
                }
            }
        }

        public String getField(String str) {
            ArrayList<String> arrayList = this.values.get(str);
            if (arrayList == null) {
                return null;
            }
            return arrayList.get(0);
        }

        public List<String> getFieldArray(String str) {
            return this.values.get(str);
        }

        public Map<String, ArrayList<String>> getFields() {
            return this.values;
        }

        public String toString() {
            return this.values.toString();
        }

        public X500Name(String str) {
            X509NameTokenizer x509NameTokenizer = new X509NameTokenizer(str);
            while (x509NameTokenizer.hasMoreTokens()) {
                String strNextToken = x509NameTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(61);
                if (iIndexOf != -1) {
                    String upperCase = strNextToken.substring(0, iIndexOf).toUpperCase();
                    String strSubstring = strNextToken.substring(iIndexOf + 1);
                    ArrayList<String> arrayList = this.values.get(upperCase);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        this.values.put(upperCase, arrayList);
                    }
                    arrayList.add(strSubstring);
                } else {
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("badly.formated.directory.string", new Object[0]));
                }
            }
        }
    }
}
