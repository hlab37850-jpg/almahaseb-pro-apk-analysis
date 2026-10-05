package org.apache.poi.poifs.crypt;

import org.apache.poi.poifs.filesystem.DocumentInputStream;

/* JADX INFO: loaded from: classes4.dex */
public class EncryptionVerifier {
    private final byte[] salt;
    private final byte[] verifier;
    private final byte[] verifierHash;
    private final int verifierHashSize;

    public EncryptionVerifier(DocumentInputStream documentInputStream, int i) {
        byte[] bArr = new byte[16];
        this.salt = bArr;
        byte[] bArr2 = new byte[16];
        this.verifier = bArr2;
        if (documentInputStream.readInt() != 16) {
            throw new RuntimeException("Salt size != 16 !?");
        }
        documentInputStream.readFully(bArr);
        documentInputStream.readFully(bArr2);
        this.verifierHashSize = documentInputStream.readInt();
        byte[] bArr3 = new byte[i];
        this.verifierHash = bArr3;
        documentInputStream.readFully(bArr3);
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public byte[] getVerifier() {
        return this.verifier;
    }

    public byte[] getVerifierHash() {
        return this.verifierHash;
    }
}
