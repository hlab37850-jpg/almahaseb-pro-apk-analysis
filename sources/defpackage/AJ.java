package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class AJ implements L8 {
    public final InterfaceC3309lR a;
    public final H8 b;
    public boolean c;

    public AJ(InterfaceC3309lR interfaceC3309lR) {
        AbstractC4492zt.h(interfaceC3309lR, DublinCoreProperties.SOURCE);
        this.a = interfaceC3309lR;
        this.b = new H8();
    }

    @Override // defpackage.L8
    public int B(XE xe) throws EOFException {
        AbstractC4492zt.h(xe, "options");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iD = AbstractC1754b.d(this.b, xe, true);
            if (iD != -2) {
                if (iD == -1) {
                    break;
                }
                this.b.skip(xe.c()[iD].u());
                return iD;
            }
        } while (this.a.y(this.b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return -1;
    }

    @Override // defpackage.L8
    public void D(long j) throws EOFException {
        if (!r(j)) {
            throw new EOFException();
        }
    }

    @Override // defpackage.L8
    public long E() throws EOFException {
        D(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!r(i2)) {
                break;
            }
            byte bX = this.b.x(i);
            if ((bX < 48 || bX > 57) && ((bX < 97 || bX > 102) && (bX < 65 || bX > 70))) {
                if (i != 0) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(bX, AbstractC3566ob.a(AbstractC3566ob.a(16)));
                AbstractC4492zt.g(string, "toString(this, checkRadix(radix))");
                sb.append(string);
                throw new NumberFormatException(sb.toString());
            }
            i = i2;
        }
        return this.b.E();
    }

    @Override // defpackage.L8
    public H8 a() {
        return this.b;
    }

    @Override // defpackage.InterfaceC3309lR
    public JU b() {
        return this.a.b();
    }

    public long c(byte b) {
        return d(b, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws EOFException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.a.close();
        this.b.d();
    }

    public long d(byte b, long j, long j2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long jZ = this.b.z(b, j, j2);
            if (jZ != -1) {
                return jZ;
            }
            long jR = this.b.R();
            if (jR >= j2 || this.a.y(this.b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            j = Math.max(j, jR);
        }
        return -1L;
    }

    @Override // defpackage.L8
    public W8 e(long j) throws EOFException {
        D(j);
        return this.b.e(j);
    }

    public int g() throws EOFException {
        D(4L);
        return this.b.L();
    }

    @Override // defpackage.L8
    public boolean h() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        return this.b.h() && this.a.y(this.b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    public short i() throws EOFException {
        D(2L);
        return this.b.M();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // defpackage.L8
    public String k(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j + 1;
        long jD = d((byte) 10, 0L, j2);
        if (jD != -1) {
            return AbstractC1754b.c(this.b, jD);
        }
        if (j2 < LocationRequestCompat.PASSIVE_INTERVAL && r(j2) && this.b.x(j2 - 1) == 13 && r(1 + j2) && this.b.x(j2) == 10) {
            return AbstractC1754b.c(this.b, j2);
        }
        H8 h8 = new H8();
        H8 h9 = this.b;
        h9.t(h8, 0L, Math.min(32, h9.R()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.b.R(), j) + " content=" + h8.K().k() + (char) 8230);
    }

    @Override // defpackage.L8
    public void m(H8 h8, long j) throws EOFException {
        AbstractC4492zt.h(h8, "sink");
        try {
            D(j);
            this.b.m(h8, j);
        } catch (EOFException e) {
            h8.Y(this.b);
            throw e;
        }
    }

    @Override // defpackage.L8
    public String o(Charset charset) {
        AbstractC4492zt.h(charset, "charset");
        this.b.Y(this.a);
        return this.b.o(charset);
    }

    public boolean r(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (this.b.R() < j) {
            if (this.a.y(this.b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        AbstractC4492zt.h(byteBuffer, "sink");
        if (this.b.R() == 0 && this.a.y(this.b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.b.read(byteBuffer);
    }

    @Override // defpackage.L8
    public byte readByte() throws EOFException {
        D(1L);
        return this.b.readByte();
    }

    @Override // defpackage.L8
    public void readFully(byte[] bArr) throws EOFException {
        AbstractC4492zt.h(bArr, "sink");
        try {
            D(bArr.length);
            this.b.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.b.R() > 0) {
                H8 h8 = this.b;
                int i2 = h8.read(bArr, i, (int) h8.R());
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
            throw e;
        }
    }

    @Override // defpackage.L8
    public int readInt() throws EOFException {
        D(4L);
        return this.b.readInt();
    }

    @Override // defpackage.L8
    public long readLong() throws EOFException {
        D(8L);
        return this.b.readLong();
    }

    @Override // defpackage.L8
    public short readShort() throws EOFException {
        D(2L);
        return this.b.readShort();
    }

    @Override // defpackage.L8
    public String s() {
        return k(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // defpackage.L8
    public void skip(long j) throws EOFException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.b.R() == 0 && this.a.y(this.b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.b.R());
            this.b.skip(jMin);
            j -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // defpackage.L8
    public byte[] w(long j) throws EOFException {
        D(j);
        return this.b.w(j);
    }

    @Override // defpackage.InterfaceC3309lR
    public long y(H8 h8, long j) {
        AbstractC4492zt.h(h8, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.b.R() == 0 && this.a.y(this.b, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.b.y(h8, Math.min(j, this.b.R()));
    }
}
