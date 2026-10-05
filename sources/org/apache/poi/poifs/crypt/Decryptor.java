package org.apache.poi.poifs.crypt;

import com.itextpdf.text.pdf.security.DigestAlgorithms;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes4.dex */
public class Decryptor {
    public static final String DEFAULT_PASSWORD = "VelvetSweatshop";

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private final EncryptionInfo f91info;
    private byte[] passwordHash;

    public Decryptor(EncryptionInfo encryptionInfo) {
        this.f91info = encryptionInfo;
    }

    private byte[] generateKey(int i) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(DigestAlgorithms.SHA1);
        messageDigest.update(this.passwordHash);
        byte[] bArr = new byte[4];
        LittleEndian.putInt(bArr, i);
        byte[] bArrDigest = messageDigest.digest(bArr);
        int keySize = this.f91info.getHeader().getKeySize() / 8;
        byte[] bArr2 = new byte[64];
        Arrays.fill(bArr2, (byte) 54);
        for (int i2 = 0; i2 < bArrDigest.length; i2++) {
            bArr2[i2] = (byte) (bArr2[i2] ^ bArrDigest[i2]);
        }
        messageDigest.reset();
        byte[] bArrDigest2 = messageDigest.digest(bArr2);
        Arrays.fill(bArr2, (byte) 92);
        for (int i3 = 0; i3 < bArrDigest.length; i3++) {
            bArr2[i3] = (byte) (bArr2[i3] ^ bArrDigest[i3]);
        }
        messageDigest.reset();
        byte[] bArrDigest3 = messageDigest.digest(bArr2);
        byte[] bArr3 = new byte[bArrDigest2.length + bArrDigest3.length];
        System.arraycopy(bArrDigest2, 0, bArr3, 0, bArrDigest2.length);
        System.arraycopy(bArrDigest3, 0, bArr3, bArrDigest2.length, bArrDigest3.length);
        return truncateOrPad(bArr3, keySize);
    }

    private void generatePasswordHash(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(DigestAlgorithms.SHA1);
        try {
            byte[] bytes = str.getBytes(XmpWriter.UTF16LE);
            messageDigest.update(this.f91info.getVerifier().getSalt());
            byte[] bArrDigest = messageDigest.digest(bytes);
            byte[] bArr = new byte[4];
            for (int i = 0; i < 50000; i++) {
                messageDigest.reset();
                LittleEndian.putInt(bArr, i);
                messageDigest.update(bArr);
                bArrDigest = messageDigest.digest(bArrDigest);
            }
            this.passwordHash = bArrDigest;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("Your JVM is broken - UTF16 not found!");
        }
    }

    private Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArrGenerateKey = generateKey(0);
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(2, new SecretKeySpec(bArrGenerateKey, "AES"));
        return cipher;
    }

    private byte[] truncateOrPad(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(i, bArr.length));
        if (i > bArr.length) {
            for (int length = bArr.length; length < i; length++) {
                bArr2[length] = 0;
            }
        }
        return bArr2;
    }

    public InputStream getDataStream(POIFSFileSystem pOIFSFileSystem) {
        DocumentInputStream documentInputStreamCreateDocumentInputStream = pOIFSFileSystem.createDocumentInputStream("EncryptedPackage");
        documentInputStreamCreateDocumentInputStream.readLong();
        return new CipherInputStream(documentInputStreamCreateDocumentInputStream, getCipher());
    }

    public boolean verifyPassword(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        generatePasswordHash(str);
        Cipher cipher = getCipher();
        byte[] bArrDigest = MessageDigest.getInstance(DigestAlgorithms.SHA1).digest(cipher.doFinal(this.f91info.getVerifier().getVerifier()));
        return Arrays.equals(bArrDigest, truncateOrPad(cipher.doFinal(this.f91info.getVerifier().getVerifierHash()), bArrDigest.length));
    }
}
