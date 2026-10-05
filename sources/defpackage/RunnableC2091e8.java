package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: e8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC2091e8 implements Runnable {
    public final int a = z.incrementAndGet();
    public final C4192wG b;
    public final C4482zj c;
    public final InterfaceC2421i9 d;
    public final C1874cS e;
    public final String f;
    public final C3792rL g;
    public final int h;
    public int i;
    public final AbstractC4116vL j;
    public X1 k;
    public List l;
    public Bitmap n;
    public Future p;
    public C4192wG.e q;
    public Exception t;
    public int u;
    public int v;
    public C4192wG.f w;
    public static final Object x = new Object();
    public static final ThreadLocal y = new a();
    public static final AtomicInteger z = new AtomicInteger();
    public static final AbstractC4116vL A = new b();

    /* JADX INFO: renamed from: e8$a */
    public static class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    /* JADX INFO: renamed from: e8$b */
    public static class b extends AbstractC4116vL {
        @Override // defpackage.AbstractC4116vL
        public boolean c(C3792rL c3792rL) {
            return true;
        }

        @Override // defpackage.AbstractC4116vL
        public AbstractC4116vL.a f(C3792rL c3792rL, int i) {
            throw new IllegalStateException("Unrecognized type of request: " + c3792rL);
        }
    }

    /* JADX INFO: renamed from: e8$c */
    public static class c implements Runnable {
        public final /* synthetic */ RuntimeException a;

        public c(InterfaceC2280gV interfaceC2280gV, RuntimeException runtimeException) {
            this.a = runtimeException;
        }

        @Override // java.lang.Runnable
        public void run() {
            new StringBuilder().append("Transformation ");
            throw null;
        }
    }

    public RunnableC2091e8(C4192wG c4192wG, C4482zj c4482zj, InterfaceC2421i9 interfaceC2421i9, C1874cS c1874cS, X1 x1, AbstractC4116vL abstractC4116vL) {
        this.b = c4192wG;
        this.c = c4482zj;
        this.d = interfaceC2421i9;
        this.e = c1874cS;
        this.k = x1;
        this.f = x1.d();
        this.g = x1.i();
        this.w = x1.h();
        this.h = x1.e();
        this.i = x1.f();
        this.j = abstractC4116vL;
        this.v = abstractC4116vL.e();
    }

    public static Bitmap a(List list, Bitmap bitmap) {
        if (list.size() <= 0) {
            return bitmap;
        }
        AbstractC3574of.a(list.get(0));
        try {
            throw null;
        } catch (RuntimeException e) {
            C4192wG.o.post(new c(null, e));
            return null;
        }
    }

    public static Bitmap e(InputStream inputStream, C3792rL c3792rL) throws IOException {
        C4324xx c4324xx = new C4324xx(inputStream);
        long jD = c4324xx.d(65536);
        BitmapFactory.Options optionsD = AbstractC4116vL.d(c3792rL);
        boolean zG = AbstractC4116vL.g(optionsD);
        boolean zT = AbstractC4047uX.t(c4324xx);
        c4324xx.c(jD);
        if (zT) {
            byte[] bArrX = AbstractC4047uX.x(c4324xx);
            if (zG) {
                BitmapFactory.decodeByteArray(bArrX, 0, bArrX.length, optionsD);
                AbstractC4116vL.b(c3792rL.h, c3792rL.i, optionsD, c3792rL);
            }
            return BitmapFactory.decodeByteArray(bArrX, 0, bArrX.length, optionsD);
        }
        if (zG) {
            BitmapFactory.decodeStream(c4324xx, null, optionsD);
            AbstractC4116vL.b(c3792rL.h, c3792rL.i, optionsD, c3792rL);
            c4324xx.c(jD);
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(c4324xx, null, optionsD);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public static RunnableC2091e8 g(C4192wG c4192wG, C4482zj c4482zj, InterfaceC2421i9 interfaceC2421i9, C1874cS c1874cS, X1 x1) {
        C3792rL c3792rLI = x1.i();
        List listH = c4192wG.h();
        int size = listH.size();
        for (int i = 0; i < size; i++) {
            AbstractC4116vL abstractC4116vL = (AbstractC4116vL) listH.get(i);
            if (abstractC4116vL.c(c3792rLI)) {
                return new RunnableC2091e8(c4192wG, c4482zj, interfaceC2421i9, c1874cS, x1, abstractC4116vL);
            }
        }
        return new RunnableC2091e8(c4192wG, c4482zj, interfaceC2421i9, c1874cS, x1, A);
    }

    public static boolean t(boolean z2, int i, int i2, int i3, int i4) {
        return !z2 || i > i3 || i2 > i4;
    }

    public static Bitmap w(C3792rL c3792rL, Bitmap bitmap, int i) {
        int i2;
        int i3;
        int i4;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int iCeil;
        int i5;
        int i6;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z2 = c3792rL.l;
        Matrix matrix = new Matrix();
        int i7 = 0;
        if (c3792rL.e()) {
            int i8 = c3792rL.h;
            int i9 = c3792rL.i;
            float f6 = c3792rL.m;
            if (f6 != 0.0f) {
                if (c3792rL.p) {
                    matrix.setRotate(f6, c3792rL.n, c3792rL.o);
                } else {
                    matrix.setRotate(f6);
                }
            }
            if (c3792rL.j) {
                float f7 = i8;
                float f8 = width;
                float f9 = f7 / f8;
                float f10 = i9;
                float f11 = height;
                float f12 = f10 / f11;
                if (f9 > f12) {
                    iCeil = (int) Math.ceil(f11 * (f12 / f9));
                    i6 = (height - iCeil) / 2;
                    f12 = f10 / iCeil;
                    f5 = f9;
                    i5 = width;
                } else {
                    int iCeil2 = (int) Math.ceil(f8 * (f9 / f12));
                    f5 = f7 / iCeil2;
                    iCeil = height;
                    i7 = (width - iCeil2) / 2;
                    i5 = iCeil2;
                    i6 = 0;
                }
                if (t(z2, width, height, i8, i9)) {
                    matrix.preScale(f5, f12);
                }
                i4 = i6;
                i2 = i5;
                i3 = iCeil;
            } else {
                if (c3792rL.k) {
                    float f13 = i8 / width;
                    float f14 = i9 / height;
                    if (f13 >= f14) {
                        f13 = f14;
                    }
                    if (t(z2, width, height, i8, i9)) {
                        matrix.preScale(f13, f13);
                    }
                } else if ((i8 != 0 || i9 != 0) && (i8 != width || i9 != height)) {
                    if (i8 != 0) {
                        f = i8;
                        f2 = width;
                    } else {
                        f = i9;
                        f2 = height;
                    }
                    float f15 = f / f2;
                    if (i9 != 0) {
                        f3 = i9;
                        f4 = height;
                    } else {
                        f3 = i8;
                        f4 = width;
                    }
                    float f16 = f3 / f4;
                    if (t(z2, width, height, i8, i9)) {
                        matrix.preScale(f15, f16);
                    }
                }
                i2 = width;
                i3 = height;
                i4 = 0;
            }
        } else {
            i2 = width;
            i3 = height;
            i4 = 0;
        }
        if (i != 0) {
            matrix.preRotate(i);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i7, i4, i2, i3, matrix, true);
        if (bitmapCreateBitmap == bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return bitmapCreateBitmap;
    }

    public static void x(C3792rL c3792rL) {
        String strA = c3792rL.a();
        StringBuilder sb = (StringBuilder) y.get();
        sb.ensureCapacity(strA.length() + 8);
        sb.replace(8, sb.length(), strA);
        Thread.currentThread().setName(sb.toString());
    }

    public void b(X1 x1) {
        boolean z2 = this.b.m;
        C3792rL c3792rL = x1.b;
        if (this.k == null) {
            this.k = x1;
            if (z2) {
                List list = this.l;
                if (list == null || list.isEmpty()) {
                    AbstractC4047uX.v("Hunter", "joined", c3792rL.d(), "to empty hunter");
                    return;
                } else {
                    AbstractC4047uX.v("Hunter", "joined", c3792rL.d(), AbstractC4047uX.m(this, "to "));
                    return;
                }
            }
            return;
        }
        if (this.l == null) {
            this.l = new ArrayList(3);
        }
        this.l.add(x1);
        if (z2) {
            AbstractC4047uX.v("Hunter", "joined", c3792rL.d(), AbstractC4047uX.m(this, "to "));
        }
        C4192wG.f fVarH = x1.h();
        if (fVarH.ordinal() > this.w.ordinal()) {
            this.w = fVarH;
        }
    }

    public boolean c() {
        Future future;
        if (this.k != null) {
            return false;
        }
        List list = this.l;
        return (list == null || list.isEmpty()) && (future = this.p) != null && future.cancel(false);
    }

    public final C4192wG.f d() {
        C4192wG.f fVarH = C4192wG.f.LOW;
        List list = this.l;
        boolean z2 = (list == null || list.isEmpty()) ? false : true;
        X1 x1 = this.k;
        if (x1 == null && !z2) {
            return fVarH;
        }
        if (x1 != null) {
            fVarH = x1.h();
        }
        if (z2) {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                C4192wG.f fVarH2 = ((X1) this.l.get(i)).h();
                if (fVarH2.ordinal() > fVarH.ordinal()) {
                    fVarH = fVarH2;
                }
            }
        }
        return fVarH;
    }

    public void f(X1 x1) {
        boolean zRemove;
        if (this.k == x1) {
            this.k = null;
            zRemove = true;
        } else {
            List list = this.l;
            zRemove = list != null ? list.remove(x1) : false;
        }
        if (zRemove && x1.h() == this.w) {
            this.w = d();
        }
        if (this.b.m) {
            AbstractC4047uX.v("Hunter", "removed", x1.b.d(), AbstractC4047uX.m(this, "from "));
        }
    }

    public X1 h() {
        return this.k;
    }

    public List i() {
        return this.l;
    }

    public C3792rL j() {
        return this.g;
    }

    public Exception k() {
        return this.t;
    }

    public String l() {
        return this.f;
    }

    public C4192wG.e m() {
        return this.q;
    }

    public int n() {
        return this.h;
    }

    public C4192wG o() {
        return this.b;
    }

    public C4192wG.f p() {
        return this.w;
    }

    public Bitmap q() {
        return this.n;
    }

    public Bitmap r() {
        Bitmap bitmapW;
        if (KB.a(this.h)) {
            bitmapW = this.d.get(this.f);
            if (bitmapW != null) {
                this.e.d();
                this.q = C4192wG.e.MEMORY;
                if (this.b.m) {
                    AbstractC4047uX.v("Hunter", "decoded", this.g.d(), "from cache");
                }
                return bitmapW;
            }
        } else {
            bitmapW = null;
        }
        C3792rL c3792rL = this.g;
        c3792rL.c = this.v == 0 ? EnumC3704qD.OFFLINE.a : this.i;
        AbstractC4116vL.a aVarF = this.j.f(c3792rL, this.i);
        if (aVarF != null) {
            this.q = aVarF.c();
            this.u = aVarF.b();
            bitmapW = aVarF.a();
            if (bitmapW == null) {
                InputStream inputStreamD = aVarF.d();
                try {
                    Bitmap bitmapE = e(inputStreamD, this.g);
                    AbstractC4047uX.e(inputStreamD);
                    bitmapW = bitmapE;
                } catch (Throwable th) {
                    AbstractC4047uX.e(inputStreamD);
                    throw th;
                }
            }
        }
        if (bitmapW != null) {
            if (this.b.m) {
                AbstractC4047uX.u("Hunter", "decoded", this.g.d());
            }
            this.e.b(bitmapW);
            if (this.g.f() || this.u != 0) {
                synchronized (x) {
                    try {
                        if (this.g.e() || this.u != 0) {
                            bitmapW = w(this.g, bitmapW, this.u);
                            if (this.b.m) {
                                AbstractC4047uX.u("Hunter", "transformed", this.g.d());
                            }
                        }
                        if (this.g.b()) {
                            bitmapW = a(this.g.g, bitmapW);
                            if (this.b.m) {
                                AbstractC4047uX.v("Hunter", "transformed", this.g.d(), "from custom transformations");
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (bitmapW != null) {
                    this.e.c(bitmapW);
                }
            }
        }
        return bitmapW;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    try {
                        x(this.g);
                        if (this.b.m) {
                            AbstractC4047uX.u("Hunter", "executing", AbstractC4047uX.l(this));
                        }
                        Bitmap bitmapR = r();
                        this.n = bitmapR;
                        if (bitmapR == null) {
                            this.c.e(this);
                        } else {
                            this.c.d(this);
                        }
                    } catch (IOException e) {
                        this.t = e;
                        this.c.g(this);
                    }
                } catch (C3784rD.a e2) {
                    this.t = e2;
                    this.c.g(this);
                } catch (Exception e3) {
                    this.t = e3;
                    this.c.e(this);
                }
            } catch (InterfaceC1254ak.b e4) {
                if (!e4.a || e4.b != 504) {
                    this.t = e4;
                }
                this.c.e(this);
            } catch (OutOfMemoryError e5) {
                StringWriter stringWriter = new StringWriter();
                this.e.a().a(new PrintWriter(stringWriter));
                this.t = new RuntimeException(stringWriter.toString(), e5);
                this.c.e(this);
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    public boolean s() {
        Future future = this.p;
        return future != null && future.isCancelled();
    }

    public boolean u(boolean z2, NetworkInfo networkInfo) {
        int i = this.v;
        if (i <= 0) {
            return false;
        }
        this.v = i - 1;
        return this.j.h(z2, networkInfo);
    }

    public boolean v() {
        return this.j.i();
    }
}
