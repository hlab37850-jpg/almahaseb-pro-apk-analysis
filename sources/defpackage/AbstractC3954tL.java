package defpackage;

import com.itextpdf.text.Annotation;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: tL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3954tL {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: tL$a */
    public static final class a {

        /* JADX INFO: renamed from: tL$a$a, reason: collision with other inner class name */
        public static final class C0330a extends AbstractC3954tL {
            public final /* synthetic */ IB b;
            public final /* synthetic */ int c;
            public final /* synthetic */ byte[] d;
            public final /* synthetic */ int e;

            public C0330a(IB ib, int i, byte[] bArr, int i2) {
                this.b = ib;
                this.c = i;
                this.d = bArr;
                this.e = i2;
            }

            @Override // defpackage.AbstractC3954tL
            public long a() {
                return this.c;
            }

            @Override // defpackage.AbstractC3954tL
            public IB b() {
                return this.b;
            }

            @Override // defpackage.AbstractC3954tL
            public void f(K8 k8) {
                AbstractC4492zt.h(k8, "sink");
                k8.write(this.d, this.e, this.c);
            }
        }

        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ AbstractC3954tL d(a aVar, byte[] bArr, IB ib, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                ib = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return aVar.c(bArr, ib, i, i2);
        }

        public final AbstractC3954tL a(IB ib, String str) {
            AbstractC4492zt.h(str, Annotation.CONTENT);
            return b(str, ib);
        }

        public final AbstractC3954tL b(String str, IB ib) {
            AbstractC4492zt.h(str, "<this>");
            Charset charset = C3809rb.b;
            if (ib != null) {
                Charset charsetD = IB.d(ib, null, 1, null);
                if (charsetD == null) {
                    ib = IB.e.b(ib + "; charset=utf-8");
                } else {
                    charset = charsetD;
                }
            }
            byte[] bytes = str.getBytes(charset);
            AbstractC4492zt.g(bytes, "this as java.lang.String).getBytes(charset)");
            return c(bytes, ib, 0, bytes.length);
        }

        public final AbstractC3954tL c(byte[] bArr, IB ib, int i, int i2) {
            AbstractC4492zt.h(bArr, "<this>");
            AbstractC3724qX.l(bArr.length, i, i2);
            return new C0330a(ib, i2, bArr, i);
        }

        public a() {
        }
    }

    public static final AbstractC3954tL c(IB ib, String str) {
        return a.a(ib, str);
    }

    public abstract long a();

    public abstract IB b();

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public abstract void f(K8 k8);
}
