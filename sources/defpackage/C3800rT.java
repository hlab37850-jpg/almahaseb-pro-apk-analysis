package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import com.itextpdf.tool.xml.html.HTML;

/* JADX INFO: renamed from: rT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3800rT extends AbstractC1214aF {
    public EV j;
    public float k;

    /* JADX INFO: renamed from: rT$b */
    public class b {
        public Path a;
        public a b;
        public a c;
        public a d;

        public b() {
        }
    }

    public C3800rT(String str, BF bf, C4029uF c4029uF) {
        super(str, bf, c4029uF);
        c4029uF.e();
        BF bfC = c4029uF.c();
        if (bfC == null) {
            this.j = null;
            return;
        }
        EV evK = EV.k(bfC.r());
        this.j = evK;
        this.k = ((C3671pr) evK.h(HTML.Tag.HEAD)).s();
    }

    @Override // defpackage.AbstractC1214aF
    public synchronized Path n(char c, float f) {
        C0902Sb c0902Sb = (C0902Sb) this.j.h("cmap");
        if (c0902Sb == null) {
            return s(c, f);
        }
        for (AbstractC2012d9 abstractC2012d9 : c0902Sb.i()) {
            char cG = abstractC2012d9.g(c);
            if (cG != 0) {
                return s(cG, f);
            }
        }
        return s(0, f);
    }

    @Override // defpackage.AbstractC1214aF
    public synchronized Path o(String str, float f) {
        ZG zg = (ZG) this.j.h("post");
        if (zg != null) {
            short sH = zg.h(str);
            if (sH == 0) {
                return null;
            }
            return s(sH, f);
        }
        Integer numC = C3927t2.c(str);
        if (numC == null) {
            return null;
        }
        return t((char) numC.intValue(), f);
    }

    public final void q(a aVar, b bVar) {
        a aVar2 = bVar.d;
        if (aVar2 != null) {
            r(new a((aVar.a + aVar2.a) / 2, (aVar.b + aVar2.b) / 2, true), bVar);
        } else if (bVar.b == null) {
            bVar.c = aVar;
        }
        bVar.d = aVar;
    }

    public final void r(a aVar, b bVar) {
        if (bVar.b == null) {
            bVar.b = aVar;
            bVar.a.moveTo(aVar.a, aVar.b);
            return;
        }
        a aVar2 = bVar.d;
        if (aVar2 == null) {
            bVar.a.lineTo(aVar.a, aVar.b);
        } else {
            bVar.a.quadTo(aVar2.a, aVar2.b, aVar.a, aVar.b);
            bVar.d = null;
        }
    }

    public synchronized Path s(int i, float f) {
        Path pathU;
        try {
            C3751qq c3751qq = (C3751qq) this.j.h("glyf");
            C3507nq c3507nqG = c3751qq.g(i);
            if (c3507nqG instanceof C3670pq) {
                pathU = v((C3670pq) c3507nqG);
            } else {
                pathU = c3507nqG instanceof C3589oq ? u(c3751qq, (C3589oq) c3507nqG) : new Path();
            }
            float fG = f / (((C4318xr) this.j.h("hmtx")).g(i) / this.k);
            Matrix matrix = new Matrix();
            float f2 = this.k;
            matrix.setScale(1.0f / f2, 1.0f / f2);
            Matrix matrix2 = new Matrix();
            matrix2.setScale(fG, 1.0f);
            matrix.preConcat(matrix2);
            pathU.transform(matrix);
        } catch (Throwable th) {
            throw th;
        }
        return pathU;
    }

    public synchronized Path t(char c, float f) {
        try {
            C0902Sb c0902Sb = (C0902Sb) this.j.h("cmap");
            if (c0902Sb == null) {
                return null;
            }
            AbstractC2012d9 abstractC2012d9H = c0902Sb.h((short) 3, (short) 1);
            if (abstractC2012d9H == null) {
                abstractC2012d9H = c0902Sb.h((short) 1, (short) 0);
            }
            char cG = abstractC2012d9H.g(c);
            if (cG == 0) {
                return null;
            }
            return s(cG, f);
        } catch (Throwable th) {
            throw th;
        }
    }

    public Path u(C3751qq c3751qq, C3589oq c3589oq) {
        Path pathU;
        Path path = new Path();
        for (int i = 0; i < c3589oq.p(); i++) {
            C3507nq c3507nqG = c3751qq.g(c3589oq.o(i));
            if (c3507nqG instanceof C3670pq) {
                pathU = v((C3670pq) c3507nqG);
            } else {
                if (!(c3507nqG instanceof C3589oq)) {
                    throw new RuntimeException("Unsupported glyph type " + c3507nqG.getClass().getCanonicalName());
                }
                pathU = u(c3751qq, (C3589oq) c3507nqG);
            }
            float[] fArrQ = c3589oq.q(i);
            Matrix matrix = new Matrix();
            AbstractC4128vX.d(matrix, fArrQ);
            path.addPath(pathU, matrix);
        }
        return path;
    }

    public Path v(C3670pq c3670pq) {
        b bVar = new b();
        bVar.a = new Path();
        int i = 0;
        for (int i2 = 0; i2 < c3670pq.s(); i2++) {
            a aVar = new a(c3670pq, i2);
            if (aVar.c) {
                r(aVar, bVar);
            } else {
                q(aVar, bVar);
            }
            if (i2 == c3670pq.o(i)) {
                i++;
                a aVar2 = bVar.c;
                if (aVar2 != null) {
                    q(aVar2, bVar);
                }
                a aVar3 = bVar.b;
                if (aVar3 != null) {
                    r(aVar3, bVar);
                }
                bVar.b = null;
                bVar.c = null;
                bVar.d = null;
            }
        }
        return bVar.a;
    }

    /* JADX INFO: renamed from: rT$a */
    public class a {
        public int a;
        public int b;
        public boolean c;

        public a(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }

        public a(C3670pq c3670pq, int i) {
            this.a = c3670pq.t(i);
            this.b = c3670pq.u(i);
            this.c = c3670pq.v(i);
        }
    }
}
