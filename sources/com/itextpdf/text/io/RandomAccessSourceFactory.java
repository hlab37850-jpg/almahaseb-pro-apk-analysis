package com.itextpdf.text.io;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public final class RandomAccessSourceFactory {
    private boolean forceRead = false;
    private boolean usePlainRandomAccess = false;
    private boolean exclusivelyLockFile = false;

    private RandomAccessSource createByReadingToMemory(String str) throws IOException {
        InputStream resourceStream = StreamUtil.getResourceStream(str);
        if (resourceStream != null) {
            return createByReadingToMemory(resourceStream);
        }
        throw new IOException(MessageLocalization.getComposedMessage("1.not.found.as.file.or.resource", str));
    }

    public RandomAccessSource createBestSource(String str) throws IOException {
        File file = new File(str);
        if (!file.canRead()) {
            return (str.startsWith("file:/") || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("jar:") || str.startsWith("wsjar:") || str.startsWith("wsjar:") || str.startsWith("vfszip:")) ? createSource(new URL(str)) : createByReadingToMemory(str);
        }
        if (this.forceRead) {
            return createByReadingToMemory(new FileInputStream(str));
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, this.exclusivelyLockFile ? "rw" : "r");
        if (this.exclusivelyLockFile) {
            randomAccessFile.getChannel().lock();
        }
        try {
            return createBestSource(randomAccessFile);
        } catch (IOException e) {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
            throw e;
        } catch (RuntimeException e2) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw e2;
        }
    }

    public RandomAccessSource createRanged(RandomAccessSource randomAccessSource, long[] jArr) {
        RandomAccessSource[] randomAccessSourceArr = new RandomAccessSource[jArr.length / 2];
        for (int i = 0; i < jArr.length; i += 2) {
            randomAccessSourceArr[i / 2] = new WindowRandomAccessSource(randomAccessSource, jArr[i], jArr[i + 1]);
        }
        return new GroupedRandomAccessSource(randomAccessSourceArr);
    }

    public RandomAccessSource createSource(byte[] bArr) {
        return new ArrayRandomAccessSource(bArr);
    }

    public RandomAccessSourceFactory setExclusivelyLockFile(boolean z) {
        this.exclusivelyLockFile = z;
        return this;
    }

    public RandomAccessSourceFactory setForceRead(boolean z) {
        this.forceRead = z;
        return this;
    }

    public RandomAccessSourceFactory setUsePlainRandomAccess(boolean z) {
        this.usePlainRandomAccess = z;
        return this;
    }

    public RandomAccessSource createSource(RandomAccessFile randomAccessFile) {
        return new RAFRandomAccessSource(randomAccessFile);
    }

    public RandomAccessSource createSource(URL url) throws IOException {
        InputStream inputStreamOpenStream = url.openStream();
        try {
            return createSource(inputStreamOpenStream);
        } finally {
            try {
                inputStreamOpenStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private RandomAccessSource createByReadingToMemory(InputStream inputStream) {
        try {
            return new ArrayRandomAccessSource(StreamUtil.inputStreamToArray(inputStream));
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public RandomAccessSource createSource(InputStream inputStream) {
        try {
            return createSource(StreamUtil.inputStreamToArray(inputStream));
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public RandomAccessSource createBestSource(RandomAccessFile randomAccessFile) {
        if (this.usePlainRandomAccess) {
            return new RAFRandomAccessSource(randomAccessFile);
        }
        if (randomAccessFile.length() <= 0) {
            return new RAFRandomAccessSource(randomAccessFile);
        }
        try {
            return createBestSource(randomAccessFile.getChannel());
        } catch (MapFailedException unused) {
            return new RAFRandomAccessSource(randomAccessFile);
        }
    }

    public RandomAccessSource createBestSource(FileChannel fileChannel) {
        if (fileChannel.size() <= 67108864) {
            return new GetBufferedRandomAccessSource(new FileChannelRandomAccessSource(fileChannel));
        }
        return new GetBufferedRandomAccessSource(new PagedChannelRandomAccessSource(fileChannel));
    }
}
