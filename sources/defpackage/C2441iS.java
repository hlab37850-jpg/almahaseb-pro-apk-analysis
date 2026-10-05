package defpackage;

import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: iS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2441iS extends AbstractC3712qL {
    public final DL.b q;

    public C2441iS(int i, String str, DL.b bVar, DL.a aVar) {
        super(i, str, aVar);
        this.q = bVar;
    }

    @Override // defpackage.AbstractC3712qL
    public DL C(C3865sD c3865sD) {
        String str;
        try {
            str = new String(c3865sD.b, AbstractC0606Ir.b(c3865sD.c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(c3865sD.b);
        }
        return DL.c(str, AbstractC0606Ir.a(c3865sD));
    }

    @Override // defpackage.AbstractC3712qL
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void e(String str) {
        this.q.a(str);
    }
}
