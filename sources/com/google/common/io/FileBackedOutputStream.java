package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class FileBackedOutputStream extends OutputStream {

    @GuardedBy("this")
    private File file;
    private final int fileThreshold;

    @GuardedBy("this")
    private c memory;

    @GuardedBy("this")
    private OutputStream out;
    private final File parentDirectory;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    public class a extends ByteSource {
        public a() {
        }

        public void finalize() {
            try {
                FileBackedOutputStream.this.reset();
            } catch (Throwable th) {
                th.printStackTrace(System.err);
            }
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return FileBackedOutputStream.this.openInputStream();
        }
    }

    public class b extends ByteSource {
        public b() {
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return FileBackedOutputStream.this.openInputStream();
        }
    }

    public static class c extends ByteArrayOutputStream {
        public c() {
        }

        public byte[] c() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public FileBackedOutputStream(int i) {
        this(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized InputStream openInputStream() {
        if (this.file != null) {
            return new FileInputStream(this.file);
        }
        Objects.requireNonNull(this.memory);
        return new ByteArrayInputStream(this.memory.c(), 0, this.memory.getCount());
    }

    @GuardedBy("this")
    private void update(int i) throws IOException {
        c cVar = this.memory;
        if (cVar == null || cVar.getCount() + i <= this.fileThreshold) {
            return;
        }
        File fileCreateTempFile = File.createTempFile("FileBackedOutputStream", null, this.parentDirectory);
        if (this.resetOnFinalize) {
            fileCreateTempFile.deleteOnExit();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(this.memory.c(), 0, this.memory.getCount());
            fileOutputStream.flush();
            this.out = fileOutputStream;
            this.file = fileCreateTempFile;
            this.memory = null;
        } catch (IOException e) {
            fileCreateTempFile.delete();
            throw e;
        }
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        this.out.flush();
    }

    @VisibleForTesting
    public synchronized File getFile() {
        return this.file;
    }

    public synchronized void reset() {
        a aVar = null;
        try {
            try {
                close();
                c cVar = this.memory;
                if (cVar == null) {
                    this.memory = new c(aVar);
                } else {
                    cVar.reset();
                }
                this.out = this.memory;
                File file = this.file;
                if (file != null) {
                    this.file = null;
                    if (!file.delete()) {
                        String strValueOf = String.valueOf(file);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                        sb.append("Could not delete: ");
                        sb.append(strValueOf);
                        throw new IOException(sb.toString());
                    }
                }
            } catch (Throwable th) {
                if (this.memory == null) {
                    this.memory = new c(aVar);
                } else {
                    this.memory.reset();
                }
                this.out = this.memory;
                File file2 = this.file;
                if (file2 != null) {
                    this.file = null;
                    if (!file2.delete()) {
                        String strValueOf2 = String.valueOf(file2);
                        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 18);
                        sb2.append("Could not delete: ");
                        sb2.append(strValueOf2);
                        throw new IOException(sb2.toString());
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        update(1);
        this.out.write(i);
    }

    public FileBackedOutputStream(int i, boolean z) {
        this(i, z, null);
    }

    private FileBackedOutputStream(int i, boolean z, File file) {
        this.fileThreshold = i;
        this.resetOnFinalize = z;
        this.parentDirectory = file;
        c cVar = new c(null);
        this.memory = cVar;
        this.out = cVar;
        if (z) {
            this.source = new a();
        } else {
            this.source = new b();
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        update(i2);
        this.out.write(bArr, i, i2);
    }
}
