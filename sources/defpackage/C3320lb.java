package defpackage;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: lb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3320lb extends Reader {
    public CharSequence a;
    public int b;
    public int c;

    public C3320lb(CharSequence charSequence) {
        this.a = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public final void c() throws IOException {
        if (this.a == null) {
            throw new IOException("reader closed");
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.a = null;
    }

    public final boolean d() {
        return g() > 0;
    }

    public final int g() {
        Objects.requireNonNull(this.a);
        return this.a.length() - this.b;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i) {
        Preconditions.checkArgument(i >= 0, "readAheadLimit (%s) may not be negative", i);
        c();
        this.c = this.b;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) {
        Preconditions.checkNotNull(charBuffer);
        c();
        Objects.requireNonNull(this.a);
        if (!d()) {
            return -1;
        }
        int iMin = Math.min(charBuffer.remaining(), g());
        for (int i = 0; i < iMin; i++) {
            CharSequence charSequence = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            charBuffer.put(charSequence.charAt(i2));
        }
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() {
        c();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() {
        c();
        this.b = this.c;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j) {
        int iMin;
        Preconditions.checkArgument(j >= 0, "n (%s) may not be negative", j);
        c();
        iMin = (int) Math.min(g(), j);
        this.b += iMin;
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized int read() {
        int iCharAt;
        c();
        Objects.requireNonNull(this.a);
        if (d()) {
            CharSequence charSequence = this.a;
            int i = this.b;
            this.b = i + 1;
            iCharAt = charSequence.charAt(i);
        } else {
            iCharAt = -1;
        }
        return iCharAt;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, cArr.length);
        c();
        Objects.requireNonNull(this.a);
        if (!d()) {
            return -1;
        }
        int iMin = Math.min(i2, g());
        for (int i3 = 0; i3 < iMin; i3++) {
            CharSequence charSequence = this.a;
            int i4 = this.b;
            this.b = i4 + 1;
            cArr[i + i3] = charSequence.charAt(i4);
        }
        return iMin;
    }
}
