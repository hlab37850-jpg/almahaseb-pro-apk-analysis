package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes3.dex */
public final class QB implements Closeable {
    public final boolean a;
    public final H8 b;
    public final Deflater c;
    public final C0991Vi d;

    public QB(boolean z) {
        this.a = z;
        H8 h8 = new H8();
        this.b = h8;
        Deflater deflater = new Deflater(-1, true);
        this.c = deflater;
        this.d = new C0991Vi((LQ) h8, deflater);
    }

    public final void c(H8 h8) throws IllegalAccessException, IOException, InvocationTargetException {
        AbstractC4492zt.h(h8, "buffer");
        if (this.b.R() != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.a) {
            this.c.reset();
        }
        this.d.p(h8, h8.R());
        this.d.flush();
        if (d(this.b, RB.a)) {
            long jR = this.b.R() - ((long) 4);
            H8.a aVarI = H8.I(this.b, null, 1, null);
            try {
                aVarI.g(jR);
                AbstractC0712Lb.a(aVarI, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AbstractC0712Lb.a(aVarI, th);
                    throw th2;
                }
            }
        } else {
            this.b.writeByte(0);
        }
        H8 h9 = this.b;
        h8.p(h9, h9.R());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.d.close();
    }

    public final boolean d(H8 h8, W8 w8) {
        return h8.F(h8.R() - ((long) w8.u()), w8);
    }
}
