package defpackage;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: renamed from: Wq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1025Wq implements InterfaceC3309lR {
    public byte a;
    public final AJ b;
    public final Inflater c;
    public final C0581Hs d;
    public final CRC32 e;

    public C1025Wq(InterfaceC3309lR interfaceC3309lR) {
        AbstractC4492zt.h(interfaceC3309lR, DublinCoreProperties.SOURCE);
        AJ aj = new AJ(interfaceC3309lR);
        this.b = aj;
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        this.d = new C0581Hs((L8) aj, inflater);
        this.e = new CRC32();
    }

    @Override // defpackage.InterfaceC3309lR
    public JU b() {
        return this.b.b();
    }

    public final void c(String str, int i, int i2) throws IOException {
        if (i2 == i) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3));
        AbstractC4492zt.g(str2, "format(this, *args)");
        throw new IOException(str2);
    }

    @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.d.close();
    }

    public final void d() throws IOException {
        this.b.D(10L);
        byte bX = this.b.b.x(3L);
        boolean z = ((bX >> 1) & 1) == 1;
        if (z) {
            i(this.b.b, 0L, 10L);
        }
        c("ID1ID2", 8075, this.b.readShort());
        this.b.skip(8L);
        if (((bX >> 2) & 1) == 1) {
            this.b.D(2L);
            if (z) {
                i(this.b.b, 0L, 2L);
            }
            long jM = this.b.b.M() & 65535;
            this.b.D(jM);
            if (z) {
                i(this.b.b, 0L, jM);
            }
            this.b.skip(jM);
        }
        if (((bX >> 3) & 1) == 1) {
            long jC = this.b.c((byte) 0);
            if (jC == -1) {
                throw new EOFException();
            }
            if (z) {
                i(this.b.b, 0L, jC + 1);
            }
            this.b.skip(jC + 1);
        }
        if (((bX >> 4) & 1) == 1) {
            long jC2 = this.b.c((byte) 0);
            if (jC2 == -1) {
                throw new EOFException();
            }
            if (z) {
                i(this.b.b, 0L, jC2 + 1);
            }
            this.b.skip(jC2 + 1);
        }
        if (z) {
            c("FHCRC", this.b.i(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    public final void g() throws IOException {
        c("CRC", this.b.g(), (int) this.e.getValue());
        c("ISIZE", this.b.g(), (int) this.c.getBytesWritten());
    }

    public final void i(H8 h8, long j, long j2) {
        C3306lO c3306lO = h8.a;
        AbstractC4492zt.e(c3306lO);
        while (true) {
            int i = c3306lO.c;
            int i2 = c3306lO.b;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            c3306lO = c3306lO.f;
            AbstractC4492zt.e(c3306lO);
        }
        while (j2 > 0) {
            int i3 = (int) (((long) c3306lO.b) + j);
            int iMin = (int) Math.min(c3306lO.c - i3, j2);
            this.e.update(c3306lO.a, i3, iMin);
            j2 -= (long) iMin;
            c3306lO = c3306lO.f;
            AbstractC4492zt.e(c3306lO);
            j = 0;
        }
    }

    @Override // defpackage.InterfaceC3309lR
    public long y(H8 h8, long j) throws IOException {
        AbstractC4492zt.h(h8, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (j == 0) {
            return 0L;
        }
        if (this.a == 0) {
            d();
            this.a = (byte) 1;
        }
        if (this.a == 1) {
            long jR = h8.R();
            long jY = this.d.y(h8, j);
            if (jY != -1) {
                i(h8, jR, jY);
                return jY;
            }
            this.a = (byte) 2;
        }
        if (this.a == 2) {
            g();
            this.a = (byte) 3;
            if (!this.b.h()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }
}
