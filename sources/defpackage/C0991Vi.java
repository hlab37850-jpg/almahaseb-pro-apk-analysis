package defpackage;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.io.IOException;
import java.util.zip.Deflater;

/* JADX INFO: renamed from: Vi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0991Vi implements LQ {
    public final K8 a;
    public final Deflater b;
    public boolean c;

    public C0991Vi(K8 k8, Deflater deflater) {
        AbstractC4492zt.h(k8, "sink");
        AbstractC4492zt.h(deflater, "deflater");
        this.a = k8;
        this.b = deflater;
    }

    @Override // defpackage.LQ
    public JU b() {
        return this.a.b();
    }

    public final void c(boolean z) throws IOException {
        C3306lO c3306lOU;
        int iDeflate;
        H8 h8A = this.a.a();
        while (true) {
            c3306lOU = h8A.U(1);
            if (z) {
                try {
                    Deflater deflater = this.b;
                    byte[] bArr = c3306lOU.a;
                    int i = c3306lOU.c;
                    iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
                } catch (NullPointerException e) {
                    throw new IOException("Deflater already closed", e);
                }
            } else {
                Deflater deflater2 = this.b;
                byte[] bArr2 = c3306lOU.a;
                int i2 = c3306lOU.c;
                iDeflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                c3306lOU.c += iDeflate;
                h8A.Q(h8A.R() + ((long) iDeflate));
                this.a.j();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (c3306lOU.b == c3306lOU.c) {
            h8A.a = c3306lOU.b();
            C3388mO.b(c3306lOU);
        }
    }

    @Override // defpackage.LQ, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.c) {
            return;
        }
        d();
        th = null;
        try {
            this.b.end();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        try {
            this.a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    public final void d() throws IOException {
        this.b.finish();
        c(false);
    }

    @Override // defpackage.LQ, java.io.Flushable
    public void flush() throws IOException {
        c(true);
        this.a.flush();
    }

    @Override // defpackage.LQ
    public void p(H8 h8, long j) throws IOException {
        AbstractC4492zt.h(h8, DublinCoreProperties.SOURCE);
        AbstractC2074e.b(h8.R(), 0L, j);
        while (j > 0) {
            C3306lO c3306lO = h8.a;
            AbstractC4492zt.e(c3306lO);
            int iMin = (int) Math.min(j, c3306lO.c - c3306lO.b);
            this.b.setInput(c3306lO.a, c3306lO.b, iMin);
            c(false);
            long j2 = iMin;
            h8.Q(h8.R() - j2);
            int i = c3306lO.b + iMin;
            c3306lO.b = i;
            if (i == c3306lO.c) {
                h8.a = c3306lO.b();
                C3388mO.b(c3306lO);
            }
            j -= j2;
        }
    }

    public String toString() {
        return "DeflaterSink(" + this.a + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0991Vi(LQ lq, Deflater deflater) {
        this(AbstractC4443zE.a(lq), deflater);
        AbstractC4492zt.h(lq, "sink");
        AbstractC4492zt.h(deflater, "deflater");
    }
}
