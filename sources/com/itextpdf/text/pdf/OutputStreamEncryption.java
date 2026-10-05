package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.crypto.AESCipher;
import com.itextpdf.text.pdf.crypto.ARCFOUREncryption;
import com.itextpdf.text.pdf.crypto.IVGenerator;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class OutputStreamEncryption extends OutputStream {
    private static final int AES_128 = 4;
    private static final int AES_256 = 5;
    private boolean aes;
    protected ARCFOUREncryption arcfour;
    protected AESCipher cipher;
    private boolean finished;
    protected OutputStream out;
    private byte[] sb;

    public OutputStreamEncryption(OutputStream outputStream, byte[] bArr, int i, int i2, int i3) {
        this.sb = new byte[1];
        try {
            this.out = outputStream;
            boolean z = i3 == 4 || i3 == 5;
            this.aes = z;
            if (!z) {
                ARCFOUREncryption aRCFOUREncryption = new ARCFOUREncryption();
                this.arcfour = aRCFOUREncryption;
                aRCFOUREncryption.prepareARCFOURKey(bArr, i, i2);
            } else {
                byte[] iv = IVGenerator.getIV();
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                this.cipher = new AESCipher(true, bArr2, iv);
                write(iv);
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        finish();
        this.out.close();
    }

    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        this.finished = true;
        if (this.aes) {
            try {
                byte[] bArrDoFinal = this.cipher.doFinal();
                this.out.write(bArrDoFinal, 0, bArrDoFinal.length);
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.sb;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.aes) {
            byte[] bArrUpdate = this.cipher.update(bArr, i, i2);
            if (bArrUpdate == null || bArrUpdate.length == 0) {
                return;
            }
            this.out.write(bArrUpdate, 0, bArrUpdate.length);
            return;
        }
        int iMin = Math.min(i2, 4192);
        byte[] bArr2 = new byte[iMin];
        while (i2 > 0) {
            int iMin2 = Math.min(i2, iMin);
            this.arcfour.encryptARCFOUR(bArr, i, iMin2, bArr2, 0);
            this.out.write(bArr2, 0, iMin2);
            i2 -= iMin2;
            i += iMin2;
        }
    }

    public OutputStreamEncryption(OutputStream outputStream, byte[] bArr, int i) {
        this(outputStream, bArr, 0, bArr.length, i);
    }
}
