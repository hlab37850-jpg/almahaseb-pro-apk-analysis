package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FL implements Closeable {
    public static final a a = new a(null);

    public static final class a {

        /* JADX INFO: renamed from: FL$a$a, reason: collision with other inner class name */
        public static final class C0005a extends FL {
            public final /* synthetic */ IB b;
            public final /* synthetic */ long c;
            public final /* synthetic */ L8 d;

            public C0005a(IB ib, long j, L8 l8) {
                this.b = ib;
                this.c = j;
                this.d = l8;
            }

            @Override // defpackage.FL
            public long d() {
                return this.c;
            }

            @Override // defpackage.FL
            public IB g() {
                return this.b;
            }

            @Override // defpackage.FL
            public L8 i() {
                return this.d;
            }
        }

        public /* synthetic */ a(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public static /* synthetic */ FL c(a aVar, byte[] bArr, IB ib, int i, Object obj) {
            if ((i & 1) != 0) {
                ib = null;
            }
            return aVar.b(bArr, ib);
        }

        public final FL a(L8 l8, IB ib, long j) {
            AbstractC4492zt.h(l8, "<this>");
            return new C0005a(ib, j, l8);
        }

        public final FL b(byte[] bArr, IB ib) {
            AbstractC4492zt.h(bArr, "<this>");
            return a(new H8().write(bArr), ib, bArr.length);
        }

        public a() {
        }
    }

    public final Charset c() {
        Charset charsetC;
        IB ibG = g();
        return (ibG == null || (charsetC = ibG.c(C3809rb.b)) == null) ? C3809rb.b : charsetC;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractC3724qX.m(i());
    }

    public abstract long d();

    public abstract IB g();

    public abstract L8 i();

    public final String r() throws IllegalAccessException, IOException, InvocationTargetException {
        L8 l8I = i();
        try {
            String strO = l8I.o(AbstractC3724qX.I(l8I, c()));
            AbstractC0712Lb.a(l8I, null);
            return strO;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0712Lb.a(l8I, th);
                throw th2;
            }
        }
    }
}
