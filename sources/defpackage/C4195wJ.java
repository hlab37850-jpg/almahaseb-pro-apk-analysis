package defpackage;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* JADX INFO: renamed from: wJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4195wJ extends InputStream {
    public final Reader a;
    public final CharsetEncoder b;
    public final byte[] c;
    public CharBuffer d;
    public ByteBuffer e;
    public boolean f;
    public boolean g;
    public boolean h;

    /* JADX WARN: Illegal instructions before constructor call */
    public C4195wJ(Reader reader, Charset charset, int i) {
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        this(reader, charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction), i);
    }

    public static int c(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    public static CharBuffer g(CharBuffer charBuffer) {
        CharBuffer charBufferWrap = CharBuffer.wrap(Arrays.copyOf(charBuffer.array(), charBuffer.capacity() * 2));
        AbstractC0920St.d(charBufferWrap, charBuffer.position());
        AbstractC0920St.c(charBufferWrap, charBuffer.limit());
        return charBufferWrap;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public final int d(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, this.e.remaining());
        this.e.get(bArr, i, iMin);
        return iMin;
    }

    public final void i() throws IOException {
        if (c(this.d) == 0) {
            if (this.d.position() > 0) {
                AbstractC0920St.b(this.d.compact());
            } else {
                this.d = g(this.d);
            }
        }
        int iLimit = this.d.limit();
        int i = this.a.read(this.d.array(), iLimit, c(this.d));
        if (i == -1) {
            this.f = true;
        } else {
            AbstractC0920St.c(this.d, iLimit + i);
        }
    }

    public final void r(boolean z) {
        AbstractC0920St.b(this.e);
        if (z && this.e.remaining() == 0) {
            this.e = ByteBuffer.allocate(this.e.capacity() * 2);
        } else {
            this.g = true;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.c) == 1) {
            return UnsignedBytes.toInt(this.c[0]);
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        CoderResult coderResultFlush;
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        if (i2 == 0) {
            return 0;
        }
        boolean z = this.f;
        int iD = 0;
        while (true) {
            if (this.g) {
                iD += d(bArr, i + iD, i2 - iD);
                if (iD == i2 || this.h) {
                    break;
                }
                this.g = false;
                AbstractC0920St.a(this.e);
            }
            while (true) {
                if (this.h) {
                    coderResultFlush = CoderResult.UNDERFLOW;
                } else {
                    coderResultFlush = z ? this.b.flush(this.e) : this.b.encode(this.d, this.e, this.f);
                }
                if (coderResultFlush.isOverflow()) {
                    r(true);
                    break;
                }
                if (coderResultFlush.isUnderflow()) {
                    if (z) {
                        this.h = true;
                        r(false);
                        break;
                    }
                    if (this.f) {
                        z = true;
                    } else {
                        i();
                    }
                } else if (coderResultFlush.isError()) {
                    coderResultFlush.throwException();
                    return 0;
                }
            }
        }
        if (iD > 0) {
            return iD;
        }
        return -1;
    }

    public C4195wJ(Reader reader, CharsetEncoder charsetEncoder, int i) {
        this.c = new byte[1];
        this.a = (Reader) Preconditions.checkNotNull(reader);
        this.b = (CharsetEncoder) Preconditions.checkNotNull(charsetEncoder);
        Preconditions.checkArgument(i > 0, "bufferSize must be positive: %s", i);
        charsetEncoder.reset();
        CharBuffer charBufferAllocate = CharBuffer.allocate(i);
        this.d = charBufferAllocate;
        AbstractC0920St.b(charBufferAllocate);
        this.e = ByteBuffer.allocate(i);
    }
}
