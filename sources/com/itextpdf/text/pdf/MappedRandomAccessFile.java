package com.itextpdf.text.pdf;

import com.google.common.primitives.UnsignedBytes;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.BufferUnderflowException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes3.dex */
public class MappedRandomAccessFile {
    private static final int BUFSIZE = 1073741824;
    private FileChannel channel = null;
    private MappedByteBuffer[] mappedBuffers;
    private long pos;
    private long size;

    public MappedRandomAccessFile(String str, String str2) throws IOException {
        if (str2.equals("rw")) {
            init(new RandomAccessFile(str, str2).getChannel(), FileChannel.MapMode.READ_WRITE);
        } else {
            init(new FileInputStream(str).getChannel(), FileChannel.MapMode.READ_ONLY);
        }
    }

    public static boolean clean(final java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer == null || !byteBuffer.isDirect()) {
            return false;
        }
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: com.itextpdf.text.pdf.MappedRandomAccessFile.1
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

    private void init(FileChannel fileChannel, FileChannel.MapMode mapMode) throws IOException {
        this.channel = fileChannel;
        long size = fileChannel.size();
        this.size = size;
        this.pos = 0L;
        int i = ((int) (size / 1073741824)) + (size % 1073741824 == 0 ? 0 : 1);
        this.mappedBuffers = new MappedByteBuffer[i];
        long j = 0;
        int i2 = 0;
        while (true) {
            try {
                long j2 = this.size;
                if (j >= j2) {
                    break;
                }
                this.mappedBuffers[i2] = fileChannel.map(mapMode, j, Math.min(j2 - j, 1073741824L));
                this.mappedBuffers[i2].load();
                i2++;
                j += 1073741824;
            } catch (IOException e) {
                close();
                throw e;
            } catch (RuntimeException e2) {
                close();
                throw e2;
            }
        }
        if (i2 == i) {
            return;
        }
        throw new Error("Should never happen - " + i2 + " != " + i);
    }

    public void close() throws IOException {
        int i = 0;
        while (true) {
            MappedByteBuffer[] mappedByteBufferArr = this.mappedBuffers;
            if (i >= mappedByteBufferArr.length) {
                break;
            }
            MappedByteBuffer mappedByteBuffer = mappedByteBufferArr[i];
            if (mappedByteBuffer != null) {
                clean(mappedByteBuffer);
                this.mappedBuffers[i] = null;
            }
            i++;
        }
        FileChannel fileChannel = this.channel;
        if (fileChannel != null) {
            fileChannel.close();
        }
        this.channel = null;
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public FileChannel getChannel() {
        return this.channel;
    }

    public long getFilePointer() {
        return this.pos;
    }

    public long length() {
        return this.size;
    }

    public int read() {
        try {
            long j = this.pos;
            int i = (int) (j / 1073741824);
            int i2 = (int) (j % 1073741824);
            MappedByteBuffer[] mappedByteBufferArr = this.mappedBuffers;
            if (i >= mappedByteBufferArr.length || i2 >= mappedByteBufferArr[i].limit()) {
                return -1;
            }
            byte b = this.mappedBuffers[i].get(i2);
            this.pos++;
            return b & UnsignedBytes.MAX_VALUE;
        } catch (BufferUnderflowException unused) {
            return -1;
        }
    }

    public void seek(long j) {
        this.pos = j;
    }

    public int read(byte[] bArr, int i, int i2) {
        long j = this.pos;
        int i3 = (int) (j / 1073741824);
        int i4 = (int) (j % 1073741824);
        int i5 = 0;
        while (i5 < i2) {
            MappedByteBuffer[] mappedByteBufferArr = this.mappedBuffers;
            if (i3 >= mappedByteBufferArr.length) {
                break;
            }
            MappedByteBuffer mappedByteBuffer = mappedByteBufferArr[i3];
            if (i4 > mappedByteBuffer.limit()) {
                break;
            }
            mappedByteBuffer.position(i4);
            int iMin = Math.min(i2 - i5, mappedByteBuffer.remaining());
            mappedByteBuffer.get(bArr, i, iMin);
            i += iMin;
            this.pos += (long) iMin;
            i5 += iMin;
            i3++;
            i4 = 0;
        }
        if (i5 == 0) {
            return -1;
        }
        return i5;
    }
}
