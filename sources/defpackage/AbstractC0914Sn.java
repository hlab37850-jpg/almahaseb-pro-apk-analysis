package defpackage;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;

/* JADX INFO: renamed from: Sn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0914Sn implements LQ {
    public final LQ a;

    public AbstractC0914Sn(LQ lq) {
        AbstractC4492zt.h(lq, "delegate");
        this.a = lq;
    }

    @Override // defpackage.LQ
    public JU b() {
        return this.a.b();
    }

    @Override // defpackage.LQ, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // defpackage.LQ, java.io.Flushable
    public void flush() {
        this.a.flush();
    }

    @Override // defpackage.LQ
    public void p(H8 h8, long j) {
        AbstractC4492zt.h(h8, DublinCoreProperties.SOURCE);
        this.a.p(h8, j);
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.a + ')';
    }
}
