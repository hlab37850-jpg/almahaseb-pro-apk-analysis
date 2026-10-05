package defpackage;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: renamed from: Hs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0581Hs implements InterfaceC3309lR {
    public final L8 a;
    public final Inflater b;
    public int c;
    public boolean d;

    public C0581Hs(L8 l8, Inflater inflater) {
        AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(inflater, "inflater");
        this.a = l8;
        this.b = inflater;
    }

    @Override // defpackage.InterfaceC3309lR
    public JU b() {
        return this.a.b();
    }

    public final long c(H8 h8, long j) throws IOException {
        AbstractC4492zt.h(h8, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        try {
            C3306lO c3306lOU = h8.U(1);
            int iMin = (int) Math.min(j, 8192 - c3306lOU.c);
            d();
            int iInflate = this.b.inflate(c3306lOU.a, c3306lOU.c, iMin);
            g();
            if (iInflate > 0) {
                c3306lOU.c += iInflate;
                long j2 = iInflate;
                h8.Q(h8.R() + j2);
                return j2;
            }
            if (c3306lOU.b == c3306lOU.c) {
                h8.a = c3306lOU.b();
                C3388mO.b(c3306lOU);
            }
            return 0L;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }

    public final boolean d() {
        if (!this.b.needsInput()) {
            return false;
        }
        if (this.a.h()) {
            return true;
        }
        C3306lO c3306lO = this.a.a().a;
        AbstractC4492zt.e(c3306lO);
        int i = c3306lO.c;
        int i2 = c3306lO.b;
        int i3 = i - i2;
        this.c = i3;
        this.b.setInput(c3306lO.a, i2, i3);
        return false;
    }

    public final void g() {
        int i = this.c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.b.getRemaining();
        this.c -= remaining;
        this.a.skip(remaining);
    }

    @Override // defpackage.InterfaceC3309lR
    public long y(H8 h8, long j) throws IOException {
        AbstractC4492zt.h(h8, "sink");
        do {
            long jC = c(h8, j);
            if (jC > 0) {
                return jC;
            }
            if (this.b.finished() || this.b.needsDictionary()) {
                return -1L;
            }
        } while (!this.a.h());
        throw new EOFException("source exhausted prematurely");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0581Hs(InterfaceC3309lR interfaceC3309lR, Inflater inflater) {
        this(AbstractC4443zE.b(interfaceC3309lR), inflater);
        AbstractC4492zt.h(interfaceC3309lR, DublinCoreProperties.SOURCE);
        AbstractC4492zt.h(inflater, "inflater");
    }
}
