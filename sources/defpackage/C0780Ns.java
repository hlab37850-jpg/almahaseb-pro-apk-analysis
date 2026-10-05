package defpackage;

import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: Ns, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0780Ns implements InterfaceC3309lR {
    public final InputStream a;
    public final JU b;

    public C0780Ns(InputStream inputStream, JU ju) {
        AbstractC4492zt.h(inputStream, HTML.Tag.INPUT);
        AbstractC4492zt.h(ju, "timeout");
        this.a = inputStream;
        this.b = ju;
    }

    @Override // defpackage.InterfaceC3309lR
    public JU b() {
        return this.b;
    }

    @Override // defpackage.InterfaceC3309lR, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        this.a.close();
    }

    public String toString() {
        return "source(" + this.a + ')';
    }

    @Override // defpackage.InterfaceC3309lR
    public long y(H8 h8, long j) throws IOException {
        AbstractC4492zt.h(h8, "sink");
        if (j == 0) {
            return 0L;
        }
        if (j < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        try {
            this.b.f();
            C3306lO c3306lOU = h8.U(1);
            int i = this.a.read(c3306lOU.a, c3306lOU.c, (int) Math.min(j, 8192 - c3306lOU.c));
            if (i != -1) {
                c3306lOU.c += i;
                long j2 = i;
                h8.Q(h8.R() + j2);
                return j2;
            }
            if (c3306lOU.b != c3306lOU.c) {
                return -1L;
            }
            h8.a = c3306lOU.b();
            C3388mO.b(c3306lOU);
            return -1L;
        } catch (AssertionError e) {
            if (AbstractC4443zE.c(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }
}
