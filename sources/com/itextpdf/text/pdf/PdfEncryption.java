package com.itextpdf.text.pdf;

import com.google.common.primitives.UnsignedBytes;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.pdf.crypto.AESCipherCBCnoPad;
import com.itextpdf.text.pdf.crypto.ARCFOUREncryption;
import com.itextpdf.text.pdf.crypto.IVGenerator;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes3.dex */
public class PdfEncryption {
    public static final int AES_128 = 4;
    public static final int AES_256 = 5;
    private static final int KEY_SALT_OFFSET = 40;
    private static final int OU_LENGHT = 48;
    private static final int SALT_LENGHT = 8;
    public static final int STANDARD_ENCRYPTION_128 = 3;
    public static final int STANDARD_ENCRYPTION_40 = 2;
    private static final int VALIDATION_SALT_OFFSET = 32;
    private ARCFOUREncryption arcfour;
    private int cryptoMode;
    byte[] documentID;
    private boolean embeddedFilesOnly;
    private boolean encryptMetadata;
    byte[] extra;
    byte[] key;
    private int keyLength;
    int keySize;
    MessageDigest md5;
    byte[] mkey;
    byte[] oeKey;
    byte[] ownerKey;
    long permissions;
    byte[] perms;
    protected PdfPublicKeySecurityHandler publicKeyHandler;
    private int revision;
    byte[] ueKey;
    byte[] userKey;
    private static final byte[] pad = {40, -65, 78, 94, 78, 117, -118, 65, 100, 0, 78, 86, -1, -6, 1, 8, 46, 46, 0, -74, -48, 104, DocWriter.GT, UnsignedBytes.MAX_POWER_OF_TWO, DocWriter.FORWARD, 12, -87, -2, 100, 83, 105, 122};
    private static final byte[] salt = {115, 65, 108, 84};
    private static final byte[] metadataPad = {-1, -1, -1, -1};
    static long seq = System.currentTimeMillis();

    public PdfEncryption() {
        this.mkey = new byte[0];
        this.ownerKey = new byte[32];
        this.userKey = new byte[32];
        this.publicKeyHandler = null;
        this.extra = new byte[5];
        this.arcfour = new ARCFOUREncryption();
        try {
            this.md5 = MessageDigest.getInstance("MD5");
            this.publicKeyHandler = new PdfPublicKeySecurityHandler();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private static boolean compareArray(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private byte[] computeOwnerKey(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        byte[] bArrDigest = this.md5.digest(bArr2);
        int i = this.revision;
        if (i == 3 || i == 4) {
            int i2 = this.keyLength / 8;
            byte[] bArr4 = new byte[i2];
            for (int i3 = 0; i3 < 50; i3++) {
                this.md5.update(bArrDigest, 0, i2);
                System.arraycopy(this.md5.digest(), 0, bArrDigest, 0, i2);
            }
            System.arraycopy(bArr, 0, bArr3, 0, 32);
            for (int i4 = 0; i4 < 20; i4++) {
                for (int i5 = 0; i5 < i2; i5++) {
                    bArr4[i5] = (byte) (bArrDigest[i5] ^ i4);
                }
                this.arcfour.prepareARCFOURKey(bArr4);
                this.arcfour.encryptARCFOUR(bArr3);
            }
        } else {
            this.arcfour.prepareARCFOURKey(bArrDigest, 0, 5);
            this.arcfour.encryptARCFOUR(bArr, bArr3);
        }
        return bArr3;
    }

    public static byte[] createDocumentId() {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jFreeMemory = Runtime.getRuntime().freeMemory();
            StringBuilder sb = new StringBuilder();
            sb.append(jCurrentTimeMillis);
            sb.append("+");
            sb.append(jFreeMemory);
            sb.append("+");
            long j = seq;
            seq = 1 + j;
            sb.append(j);
            return messageDigest.digest(sb.toString().getBytes());
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static PdfObject createInfoId(byte[] bArr, boolean z) throws IOException {
        ByteBuffer byteBuffer = new ByteBuffer(90);
        if (bArr.length == 0) {
            bArr = createDocumentId();
        }
        byteBuffer.append('[').append('<');
        for (byte b : bArr) {
            byteBuffer.appendHex(b);
        }
        byteBuffer.append('>').append('<');
        if (z) {
            bArr = createDocumentId();
        }
        for (byte b2 : bArr) {
            byteBuffer.appendHex(b2);
        }
        byteBuffer.append('>').append(']');
        byteBuffer.close();
        return new PdfLiteral(byteBuffer.toByteArray());
    }

    private byte[] padPassword(byte[] bArr) {
        byte[] bArr2 = new byte[32];
        if (bArr == null) {
            System.arraycopy(pad, 0, bArr2, 0, 32);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, 32));
            if (bArr.length < 32) {
                System.arraycopy(pad, 0, bArr2, bArr.length, 32 - bArr.length);
            }
        }
        return bArr2;
    }

    private void setupByOwnerPad(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j) {
        setupGlobalEncryptionKey(bArr, computeOwnerKey(bArr4, bArr2), bArr4, j);
        setupUserKey();
    }

    private void setupByUserPad(byte[] bArr, byte[] bArr2, byte[] bArr3, long j) {
        setupGlobalEncryptionKey(bArr, bArr2, bArr3, j);
        setupUserKey();
    }

    private void setupGlobalEncryptionKey(byte[] bArr, byte[] bArr2, byte[] bArr3, long j) {
        this.documentID = bArr;
        this.ownerKey = bArr3;
        this.permissions = j;
        this.mkey = new byte[this.keyLength / 8];
        this.md5.reset();
        this.md5.update(bArr2);
        this.md5.update(bArr3);
        this.md5.update(new byte[]{(byte) j, (byte) (j >> 8), (byte) (j >> 16), (byte) (j >> 24)}, 0, 4);
        if (bArr != null) {
            this.md5.update(bArr);
        }
        if (!this.encryptMetadata) {
            this.md5.update(metadataPad);
        }
        byte[] bArr4 = new byte[this.mkey.length];
        System.arraycopy(this.md5.digest(), 0, bArr4, 0, this.mkey.length);
        int i = this.revision;
        if (i == 3 || i == 4) {
            for (int i2 = 0; i2 < 50; i2++) {
                System.arraycopy(this.md5.digest(bArr4), 0, bArr4, 0, this.mkey.length);
            }
        }
        byte[] bArr5 = this.mkey;
        System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
    }

    private void setupUserKey() {
        byte[] bArr;
        int i = this.revision;
        if (i != 3 && i != 4) {
            this.arcfour.prepareARCFOURKey(this.mkey);
            this.arcfour.encryptARCFOUR(pad, this.userKey);
            return;
        }
        this.md5.update(pad);
        byte[] bArrDigest = this.md5.digest(this.documentID);
        System.arraycopy(bArrDigest, 0, this.userKey, 0, 16);
        for (int i2 = 16; i2 < 32; i2++) {
            this.userKey[i2] = 0;
        }
        for (int i3 = 0; i3 < 20; i3++) {
            int i4 = 0;
            while (true) {
                bArr = this.mkey;
                if (i4 < bArr.length) {
                    bArrDigest[i4] = (byte) (bArr[i4] ^ i3);
                    i4++;
                }
            }
            this.arcfour.prepareARCFOURKey(bArrDigest, 0, bArr.length);
            this.arcfour.encryptARCFOUR(this.userKey, 0, 16);
        }
    }

    public void addRecipient(Certificate certificate, int i) {
        this.documentID = createDocumentId();
        this.publicKeyHandler.addRecipient(new PdfPublicKeyRecipient(certificate, i));
    }

    public int calculateStreamSize(int i) {
        int i2 = this.revision;
        return (i2 == 4 || i2 == 5) ? (i & 2147483632) + 32 : i;
    }

    public byte[] computeUserPassword(byte[] bArr) {
        int i;
        if (this.publicKeyHandler.getRecipientsSize() != 0 || 2 > (i = this.revision) || i > 4) {
            return null;
        }
        byte[] bArrComputeOwnerKey = computeOwnerKey(this.ownerKey, padPassword(bArr));
        for (int i2 = 0; i2 < bArrComputeOwnerKey.length; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= bArrComputeOwnerKey.length - i2) {
                    byte[] bArr2 = new byte[i2];
                    System.arraycopy(bArrComputeOwnerKey, 0, bArr2, 0, i2);
                    return bArr2;
                }
                if (bArrComputeOwnerKey[i2 + i3] != pad[i3]) {
                    break;
                }
                i3++;
            }
        }
        return bArrComputeOwnerKey;
    }

    public byte[] decryptByteArray(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            StandardDecryption decryptor = getDecryptor();
            byte[] bArrUpdate = decryptor.update(bArr, 0, bArr.length);
            if (bArrUpdate != null) {
                byteArrayOutputStream.write(bArrUpdate);
            }
            byte[] bArrFinish = decryptor.finish();
            if (bArrFinish != null) {
                byteArrayOutputStream.write(bArrFinish);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public byte[] encryptByteArray(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamEncryption encryptionStream = getEncryptionStream(byteArrayOutputStream);
            encryptionStream.write(bArr);
            encryptionStream.finish();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public int getCryptoMode() {
        return this.cryptoMode;
    }

    public StandardDecryption getDecryptor() {
        return new StandardDecryption(this.key, 0, this.keySize, this.revision);
    }

    public PdfDictionary getEncryptionDictionary() {
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (this.publicKeyHandler.getRecipientsSize() > 0) {
            pdfDictionary.put(PdfName.FILTER, PdfName.PUBSEC);
            PdfName pdfName = PdfName.R;
            pdfDictionary.put(pdfName, new PdfNumber(this.revision));
            try {
                PdfArray encodedRecipients = this.publicKeyHandler.getEncodedRecipients();
                int i = this.revision;
                if (i == 2) {
                    pdfDictionary.put(PdfName.V, new PdfNumber(1));
                    pdfDictionary.put(PdfName.SUBFILTER, PdfName.ADBE_PKCS7_S4);
                    pdfDictionary.put(PdfName.RECIPIENTS, encodedRecipients);
                } else if (i == 3 && this.encryptMetadata) {
                    pdfDictionary.put(PdfName.V, new PdfNumber(2));
                    pdfDictionary.put(PdfName.LENGTH, new PdfNumber(128));
                    pdfDictionary.put(PdfName.SUBFILTER, PdfName.ADBE_PKCS7_S4);
                    pdfDictionary.put(PdfName.RECIPIENTS, encodedRecipients);
                } else {
                    if (i == 5) {
                        pdfDictionary.put(pdfName, new PdfNumber(5));
                        pdfDictionary.put(PdfName.V, new PdfNumber(5));
                    } else {
                        pdfDictionary.put(pdfName, new PdfNumber(4));
                        pdfDictionary.put(PdfName.V, new PdfNumber(4));
                    }
                    pdfDictionary.put(PdfName.SUBFILTER, PdfName.ADBE_PKCS7_S5);
                    PdfDictionary pdfDictionary2 = new PdfDictionary();
                    pdfDictionary2.put(PdfName.RECIPIENTS, encodedRecipients);
                    if (!this.encryptMetadata) {
                        pdfDictionary2.put(PdfName.ENCRYPTMETADATA, PdfBoolean.PDFFALSE);
                    }
                    int i2 = this.revision;
                    if (i2 == 4) {
                        pdfDictionary2.put(PdfName.CFM, PdfName.AESV2);
                        pdfDictionary2.put(PdfName.LENGTH, new PdfNumber(128));
                    } else if (i2 == 5) {
                        pdfDictionary2.put(PdfName.CFM, PdfName.AESV3);
                        pdfDictionary2.put(PdfName.LENGTH, new PdfNumber(256));
                    } else {
                        pdfDictionary2.put(PdfName.CFM, PdfName.V2);
                    }
                    PdfDictionary pdfDictionary3 = new PdfDictionary();
                    PdfName pdfName2 = PdfName.DEFAULTCRYPTFILTER;
                    pdfDictionary3.put(pdfName2, pdfDictionary2);
                    pdfDictionary.put(PdfName.CF, pdfDictionary3);
                    if (this.embeddedFilesOnly) {
                        pdfDictionary.put(PdfName.EFF, pdfName2);
                        PdfName pdfName3 = PdfName.STRF;
                        PdfName pdfName4 = PdfName.IDENTITY;
                        pdfDictionary.put(pdfName3, pdfName4);
                        pdfDictionary.put(PdfName.STMF, pdfName4);
                    } else {
                        pdfDictionary.put(PdfName.STRF, pdfName2);
                        pdfDictionary.put(PdfName.STMF, pdfName2);
                    }
                }
                try {
                    MessageDigest messageDigest = this.revision == 5 ? MessageDigest.getInstance("SHA-256") : MessageDigest.getInstance(DigestAlgorithms.SHA1);
                    messageDigest.update(this.publicKeyHandler.getSeed());
                    for (int i3 = 0; i3 < this.publicKeyHandler.getRecipientsSize(); i3++) {
                        messageDigest.update(this.publicKeyHandler.getEncodedRecipient(i3));
                    }
                    if (!this.encryptMetadata) {
                        messageDigest.update(new byte[]{-1, -1, -1, -1});
                    }
                    byte[] bArrDigest = messageDigest.digest();
                    if (this.revision == 5) {
                        this.key = bArrDigest;
                    } else {
                        setupByEncryptionKey(bArrDigest, this.keyLength);
                    }
                } catch (Exception e) {
                    throw new ExceptionConverter(e);
                }
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            pdfDictionary.put(PdfName.FILTER, PdfName.STANDARD);
            pdfDictionary.put(PdfName.O, new PdfLiteral(StringUtils.escapeString(this.ownerKey)));
            pdfDictionary.put(PdfName.U, new PdfLiteral(StringUtils.escapeString(this.userKey)));
            pdfDictionary.put(PdfName.P, new PdfNumber(this.permissions));
            PdfName pdfName5 = PdfName.R;
            pdfDictionary.put(pdfName5, new PdfNumber(this.revision));
            int i4 = this.revision;
            if (i4 == 2) {
                pdfDictionary.put(PdfName.V, new PdfNumber(1));
            } else if (i4 == 3 && this.encryptMetadata) {
                pdfDictionary.put(PdfName.V, new PdfNumber(2));
                pdfDictionary.put(PdfName.LENGTH, new PdfNumber(128));
            } else if (i4 == 5) {
                if (!this.encryptMetadata) {
                    pdfDictionary.put(PdfName.ENCRYPTMETADATA, PdfBoolean.PDFFALSE);
                }
                pdfDictionary.put(PdfName.OE, new PdfLiteral(StringUtils.escapeString(this.oeKey)));
                pdfDictionary.put(PdfName.UE, new PdfLiteral(StringUtils.escapeString(this.ueKey)));
                pdfDictionary.put(PdfName.PERMS, new PdfLiteral(StringUtils.escapeString(this.perms)));
                pdfDictionary.put(PdfName.V, new PdfNumber(this.revision));
                PdfName pdfName6 = PdfName.LENGTH;
                pdfDictionary.put(pdfName6, new PdfNumber(256));
                PdfDictionary pdfDictionary4 = new PdfDictionary();
                pdfDictionary4.put(pdfName6, new PdfNumber(32));
                if (this.embeddedFilesOnly) {
                    pdfDictionary4.put(PdfName.AUTHEVENT, PdfName.EFOPEN);
                    pdfDictionary.put(PdfName.EFF, PdfName.STDCF);
                    PdfName pdfName7 = PdfName.STRF;
                    PdfName pdfName8 = PdfName.IDENTITY;
                    pdfDictionary.put(pdfName7, pdfName8);
                    pdfDictionary.put(PdfName.STMF, pdfName8);
                } else {
                    pdfDictionary4.put(PdfName.AUTHEVENT, PdfName.DOCOPEN);
                    PdfName pdfName9 = PdfName.STRF;
                    PdfName pdfName10 = PdfName.STDCF;
                    pdfDictionary.put(pdfName9, pdfName10);
                    pdfDictionary.put(PdfName.STMF, pdfName10);
                }
                pdfDictionary4.put(PdfName.CFM, PdfName.AESV3);
                PdfDictionary pdfDictionary5 = new PdfDictionary();
                pdfDictionary5.put(PdfName.STDCF, pdfDictionary4);
                pdfDictionary.put(PdfName.CF, pdfDictionary5);
            } else {
                if (!this.encryptMetadata) {
                    pdfDictionary.put(PdfName.ENCRYPTMETADATA, PdfBoolean.PDFFALSE);
                }
                pdfDictionary.put(pdfName5, new PdfNumber(4));
                pdfDictionary.put(PdfName.V, new PdfNumber(4));
                PdfName pdfName11 = PdfName.LENGTH;
                pdfDictionary.put(pdfName11, new PdfNumber(128));
                PdfDictionary pdfDictionary6 = new PdfDictionary();
                pdfDictionary6.put(pdfName11, new PdfNumber(16));
                if (this.embeddedFilesOnly) {
                    pdfDictionary6.put(PdfName.AUTHEVENT, PdfName.EFOPEN);
                    pdfDictionary.put(PdfName.EFF, PdfName.STDCF);
                    PdfName pdfName12 = PdfName.STRF;
                    PdfName pdfName13 = PdfName.IDENTITY;
                    pdfDictionary.put(pdfName12, pdfName13);
                    pdfDictionary.put(PdfName.STMF, pdfName13);
                } else {
                    pdfDictionary6.put(PdfName.AUTHEVENT, PdfName.DOCOPEN);
                    PdfName pdfName14 = PdfName.STRF;
                    PdfName pdfName15 = PdfName.STDCF;
                    pdfDictionary.put(pdfName14, pdfName15);
                    pdfDictionary.put(PdfName.STMF, pdfName15);
                }
                if (this.revision == 4) {
                    pdfDictionary6.put(PdfName.CFM, PdfName.AESV2);
                } else {
                    pdfDictionary6.put(PdfName.CFM, PdfName.V2);
                }
                PdfDictionary pdfDictionary7 = new PdfDictionary();
                pdfDictionary7.put(PdfName.STDCF, pdfDictionary6);
                pdfDictionary.put(PdfName.CF, pdfDictionary7);
            }
        }
        return pdfDictionary;
    }

    public OutputStreamEncryption getEncryptionStream(OutputStream outputStream) {
        return new OutputStreamEncryption(outputStream, this.key, 0, this.keySize, this.revision);
    }

    public PdfObject getFileID(boolean z) {
        return createInfoId(this.documentID, z);
    }

    public long getPermissions() {
        return this.permissions;
    }

    public boolean isEmbeddedFilesOnly() {
        return this.embeddedFilesOnly;
    }

    public boolean isMetadataEncrypted() {
        return this.encryptMetadata;
    }

    public boolean readKey(PdfDictionary pdfDictionary, byte[] bArr) throws BadPasswordException {
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (BadPasswordException e) {
                throw e;
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }
        byte[] iSOBytes = DocWriter.getISOBytes(pdfDictionary.get(PdfName.O).toString());
        byte[] iSOBytes2 = DocWriter.getISOBytes(pdfDictionary.get(PdfName.U).toString());
        byte[] iSOBytes3 = DocWriter.getISOBytes(pdfDictionary.get(PdfName.OE).toString());
        byte[] iSOBytes4 = DocWriter.getISOBytes(pdfDictionary.get(PdfName.UE).toString());
        byte[] iSOBytes5 = DocWriter.getISOBytes(pdfDictionary.get(PdfName.PERMS).toString());
        PdfNumber pdfNumber = (PdfNumber) pdfDictionary.get(PdfName.P);
        this.oeKey = iSOBytes3;
        this.ueKey = iSOBytes4;
        this.perms = iSOBytes5;
        this.ownerKey = iSOBytes;
        this.userKey = iSOBytes2;
        this.permissions = pdfNumber.longValue();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr, 0, Math.min(bArr.length, ShapeTypes.VERTICAL_SCROLL));
        messageDigest.update(iSOBytes, 32, 8);
        messageDigest.update(iSOBytes2, 0, 48);
        boolean zCompareArray = compareArray(messageDigest.digest(), iSOBytes, 32);
        if (zCompareArray) {
            messageDigest.update(bArr, 0, Math.min(bArr.length, ShapeTypes.VERTICAL_SCROLL));
            messageDigest.update(iSOBytes, 40, 8);
            messageDigest.update(iSOBytes2, 0, 48);
            this.key = new AESCipherCBCnoPad(false, messageDigest.digest()).processBlock(iSOBytes3, 0, iSOBytes3.length);
        } else {
            messageDigest.update(bArr, 0, Math.min(bArr.length, ShapeTypes.VERTICAL_SCROLL));
            messageDigest.update(iSOBytes2, 32, 8);
            if (!compareArray(messageDigest.digest(), iSOBytes2, 32)) {
                throw new BadPasswordException(MessageLocalization.getComposedMessage("bad.user.password", new Object[0]));
            }
            messageDigest.update(bArr, 0, Math.min(bArr.length, ShapeTypes.VERTICAL_SCROLL));
            messageDigest.update(iSOBytes2, 40, 8);
            this.key = new AESCipherCBCnoPad(false, messageDigest.digest()).processBlock(iSOBytes4, 0, iSOBytes4.length);
        }
        byte[] bArrProcessBlock = new AESCipherCBCnoPad(false, this.key).processBlock(iSOBytes5, 0, iSOBytes5.length);
        if (bArrProcessBlock[9] != 97 || bArrProcessBlock[10] != 100 || bArrProcessBlock[11] != 98) {
            throw new BadPasswordException(MessageLocalization.getComposedMessage("bad.user.password", new Object[0]));
        }
        int i = (bArrProcessBlock[0] & UnsignedBytes.MAX_VALUE) | ((bArrProcessBlock[1] & UnsignedBytes.MAX_VALUE) << 8);
        byte b = bArrProcessBlock[2];
        this.permissions = i | ((b & UnsignedBytes.MAX_VALUE) << 16) | ((b & UnsignedBytes.MAX_VALUE) << 24);
        this.encryptMetadata = bArrProcessBlock[8] == 84;
        return zCompareArray;
    }

    public void setCryptoMode(int i, int i2) {
        this.cryptoMode = i;
        this.encryptMetadata = (i & 8) != 8;
        this.embeddedFilesOnly = (i & 24) == 24;
        int i3 = i & 7;
        if (i3 == 0) {
            this.encryptMetadata = true;
            this.embeddedFilesOnly = false;
            this.keyLength = 40;
            this.revision = 2;
            return;
        }
        if (i3 == 1) {
            this.embeddedFilesOnly = false;
            if (i2 > 0) {
                this.keyLength = i2;
            } else {
                this.keyLength = 128;
            }
            this.revision = 3;
            return;
        }
        if (i3 == 2) {
            this.keyLength = 128;
            this.revision = 4;
        } else {
            if (i3 != 3) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("no.valid.encryption.mode", new Object[0]));
            }
            this.keyLength = 256;
            this.keySize = 32;
            this.revision = 5;
        }
    }

    public void setHashKey(int i, int i2) {
        if (this.revision == 5) {
            return;
        }
        this.md5.reset();
        byte[] bArr = this.extra;
        bArr[0] = (byte) i;
        bArr[1] = (byte) (i >> 8);
        bArr[2] = (byte) (i >> 16);
        bArr[3] = (byte) i2;
        bArr[4] = (byte) (i2 >> 8);
        this.md5.update(this.mkey);
        this.md5.update(this.extra);
        if (this.revision == 4) {
            this.md5.update(salt);
        }
        this.key = this.md5.digest();
        int length = this.mkey.length + 5;
        this.keySize = length;
        if (length > 16) {
            this.keySize = 16;
        }
    }

    public void setKey(byte[] bArr) {
        this.key = bArr;
    }

    public void setupAllKeys(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3;
        byte[] bArrDigest = bArr2;
        if (bArrDigest == null || bArrDigest.length == 0) {
            bArrDigest = this.md5.digest(createDocumentId());
        }
        int i2 = this.revision;
        int i3 = (i | ((i2 == 3 || i2 == 4 || i2 == 5) ? -3904 : -64)) & (-4);
        long j = i3;
        this.permissions = j;
        if (i2 != 5) {
            byte[] bArrPadPassword = padPassword(bArr);
            this.ownerKey = computeOwnerKey(bArrPadPassword, padPassword(bArrDigest));
            byte[] bArrCreateDocumentId = createDocumentId();
            this.documentID = bArrCreateDocumentId;
            setupByUserPad(bArrCreateDocumentId, bArrPadPassword, this.ownerKey, j);
            return;
        }
        if (bArr == null) {
            try {
                bArr3 = new byte[0];
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            bArr3 = bArr;
        }
        this.documentID = createDocumentId();
        byte[] iv = IVGenerator.getIV(8);
        byte[] iv2 = IVGenerator.getIV(8);
        this.key = IVGenerator.getIV(32);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr3, 0, Math.min(bArr3.length, ShapeTypes.VERTICAL_SCROLL));
        messageDigest.update(iv);
        byte[] bArr4 = new byte[48];
        this.userKey = bArr4;
        messageDigest.digest(bArr4, 0, 32);
        System.arraycopy(iv, 0, this.userKey, 32, 8);
        System.arraycopy(iv2, 0, this.userKey, 40, 8);
        messageDigest.update(bArr3, 0, Math.min(bArr3.length, ShapeTypes.VERTICAL_SCROLL));
        messageDigest.update(iv2);
        AESCipherCBCnoPad aESCipherCBCnoPad = new AESCipherCBCnoPad(true, messageDigest.digest());
        byte[] bArr5 = this.key;
        this.ueKey = aESCipherCBCnoPad.processBlock(bArr5, 0, bArr5.length);
        byte[] iv3 = IVGenerator.getIV(8);
        byte[] iv4 = IVGenerator.getIV(8);
        messageDigest.update(bArrDigest, 0, Math.min(bArrDigest.length, ShapeTypes.VERTICAL_SCROLL));
        messageDigest.update(iv3);
        messageDigest.update(this.userKey);
        byte[] bArr6 = new byte[48];
        this.ownerKey = bArr6;
        messageDigest.digest(bArr6, 0, 32);
        System.arraycopy(iv3, 0, this.ownerKey, 32, 8);
        System.arraycopy(iv4, 0, this.ownerKey, 40, 8);
        messageDigest.update(bArrDigest, 0, Math.min(bArrDigest.length, ShapeTypes.VERTICAL_SCROLL));
        messageDigest.update(iv4);
        messageDigest.update(this.userKey);
        AESCipherCBCnoPad aESCipherCBCnoPad2 = new AESCipherCBCnoPad(true, messageDigest.digest());
        byte[] bArr7 = this.key;
        this.oeKey = aESCipherCBCnoPad2.processBlock(bArr7, 0, bArr7.length);
        byte[] iv5 = IVGenerator.getIV(16);
        iv5[0] = (byte) i3;
        iv5[1] = (byte) (i3 >> 8);
        iv5[2] = (byte) (-1);
        iv5[3] = (byte) (-1);
        iv5[4] = -1;
        iv5[5] = -1;
        iv5[6] = -1;
        iv5[7] = -1;
        iv5[8] = this.encryptMetadata ? (byte) 84 : (byte) 70;
        iv5[9] = 97;
        iv5[10] = 100;
        iv5[11] = 98;
        this.perms = new AESCipherCBCnoPad(true, this.key).processBlock(iv5, 0, iv5.length);
    }

    public void setupByEncryptionKey(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i / 8];
        this.mkey = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
    }

    public void setupByOwnerPassword(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j) {
        setupByOwnerPad(bArr, padPassword(bArr2), bArr3, bArr4, j);
    }

    public void setupByUserPassword(byte[] bArr, byte[] bArr2, byte[] bArr3, long j) {
        setupByUserPad(bArr, padPassword(bArr2), bArr3, j);
    }

    public PdfEncryption(PdfEncryption pdfEncryption) {
        this();
        byte[] bArr = pdfEncryption.key;
        if (bArr != null) {
            this.key = (byte[]) bArr.clone();
        }
        this.keySize = pdfEncryption.keySize;
        this.mkey = (byte[]) pdfEncryption.mkey.clone();
        this.ownerKey = (byte[]) pdfEncryption.ownerKey.clone();
        this.userKey = (byte[]) pdfEncryption.userKey.clone();
        this.permissions = pdfEncryption.permissions;
        byte[] bArr2 = pdfEncryption.documentID;
        if (bArr2 != null) {
            this.documentID = (byte[]) bArr2.clone();
        }
        this.revision = pdfEncryption.revision;
        this.keyLength = pdfEncryption.keyLength;
        this.encryptMetadata = pdfEncryption.encryptMetadata;
        this.embeddedFilesOnly = pdfEncryption.embeddedFilesOnly;
        this.publicKeyHandler = pdfEncryption.publicKeyHandler;
        byte[] bArr3 = pdfEncryption.ueKey;
        if (bArr3 != null) {
            this.ueKey = (byte[]) bArr3.clone();
        }
        byte[] bArr4 = pdfEncryption.oeKey;
        if (bArr4 != null) {
            this.oeKey = (byte[]) bArr4.clone();
        }
        byte[] bArr5 = pdfEncryption.perms;
        if (bArr5 != null) {
            this.perms = (byte[]) bArr5.clone();
        }
    }
}
