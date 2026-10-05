package defpackage;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;

/* JADX INFO: loaded from: classes3.dex */
public final class FJ extends FL {
    public final String b;
    public final long c;
    public final L8 d;

    public FJ(String str, long j, L8 l8) {
        AbstractC4492zt.h(l8, DublinCoreProperties.SOURCE);
        this.b = str;
        this.c = j;
        this.d = l8;
    }

    @Override // defpackage.FL
    public long d() {
        return this.c;
    }

    @Override // defpackage.FL
    public IB g() {
        String str = this.b;
        if (str != null) {
            return IB.e.b(str);
        }
        return null;
    }

    @Override // defpackage.FL
    public L8 i() {
        return this.d;
    }
}
