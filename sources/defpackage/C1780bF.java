package defpackage;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: bF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1780bF implements LQ {
    public final OutputStream a;
    public final JU b;

    public C1780bF(OutputStream outputStream, JU ju) {
        AbstractC4492zt.h(outputStream, "out");
        AbstractC4492zt.h(ju, "timeout");
        this.a = outputStream;
        this.b = ju;
    }

    @Override // defpackage.LQ
    public JU b() {
        return this.b;
    }

    @Override // defpackage.LQ, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // defpackage.LQ, java.io.Flushable
    public void flush() throws IOException {
        this.a.flush();
    }

    @Override // defpackage.LQ
    public void p(H8 h8, long j) throws IOException {
        AbstractC4492zt.h(h8, DublinCoreProperties.SOURCE);
        AbstractC2074e.b(h8.R(), 0L, j);
        while (j > 0) {
            this.b.f();
            C3306lO c3306lO = h8.a;
            AbstractC4492zt.e(c3306lO);
            int iMin = (int) Math.min(j, c3306lO.c - c3306lO.b);
            this.a.write(c3306lO.a, c3306lO.b, iMin);
            c3306lO.b += iMin;
            long j2 = iMin;
            j -= j2;
            h8.Q(h8.R() - j2);
            if (c3306lO.b == c3306lO.c) {
                h8.a = c3306lO.b();
                C3388mO.b(c3306lO);
            }
        }
    }

    public String toString() {
        return "sink(" + this.a + ')';
    }
}
