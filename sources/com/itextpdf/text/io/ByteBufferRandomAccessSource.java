package com.itextpdf.text.io;

import com.google.common.primitives.UnsignedBytes;
import java.lang.reflect.Method;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes3.dex */
class ByteBufferRandomAccessSource implements RandomAccessSource {
    private final ByteBuffer byteBuffer;

    public ByteBufferRandomAccessSource(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    private static boolean clean(final ByteBuffer byteBuffer) {
        if (byteBuffer == null || !byteBuffer.isDirect()) {
            return false;
        }
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: com.itextpdf.text.io.ByteBufferRandomAccessSource.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                Boolean bool = Boolean.FALSE;
                try {
                    Method method = byteBuffer.getClass().getMethod("cleaner", null);
                    method.setAccessible(true);
                    Object objInvoke = method.invoke(byteBuffer, null);
                    objInvoke.getClass().getMethod("clean", null).invoke(objInvoke, null);
                    return Boolean.TRUE;
                } catch (Exception unused) {
                    return bool;
                }
            }
        })).booleanValue();
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public void close() {
        clean(this.byteBuffer);
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j) {
        if (j > 2147483647L) {
            throw new IllegalArgumentException("Position must be less than Integer.MAX_VALUE");
        }
        try {
            if (j >= this.byteBuffer.limit()) {
                return -1;
            }
            return this.byteBuffer.get((int) j) & UnsignedBytes.MAX_VALUE;
        } catch (BufferUnderflowException unused) {
            return -1;
        }
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public long length() {
        return this.byteBuffer.limit();
    }

    @Override // com.itextpdf.text.io.RandomAccessSource
    public int get(long j, byte[] bArr, int i, int i2) {
        if (j > 2147483647L) {
            throw new IllegalArgumentException("Position must be less than Integer.MAX_VALUE");
        }
        if (j >= this.byteBuffer.limit()) {
            return -1;
        }
        this.byteBuffer.position((int) j);
        int iMin = Math.min(i2, this.byteBuffer.remaining());
        this.byteBuffer.get(bArr, i, iMin);
        return iMin;
    }
}
