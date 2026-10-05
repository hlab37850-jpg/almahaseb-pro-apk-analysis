package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: uL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4035uL {
    public static final AtomicInteger m = new AtomicInteger();
    public final C4192wG a;
    public final C3792rL.b b;
    public boolean c;
    public boolean d;
    public boolean e = true;
    public int f;
    public int g;
    public int h;
    public int i;
    public Drawable j;
    public Drawable k;
    public Object l;

    public C4035uL(C4192wG c4192wG, Uri uri, int i) {
        if (c4192wG.n) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.a = c4192wG;
        this.b = new C3792rL.b(uri, i, c4192wG.k);
    }

    public final C3792rL a(long j) {
        int andIncrement = m.getAndIncrement();
        C3792rL c3792rLA = this.b.a();
        c3792rLA.a = andIncrement;
        c3792rLA.b = j;
        boolean z = this.a.m;
        if (z) {
            AbstractC4047uX.v("Main", "created", c3792rLA.g(), c3792rLA.toString());
        }
        C3792rL c3792rLM = this.a.m(c3792rLA);
        if (c3792rLM != c3792rLA) {
            c3792rLM.a = andIncrement;
            c3792rLM.b = j;
            if (z) {
                AbstractC4047uX.v("Main", "changed", c3792rLM.d(), "into " + c3792rLM);
            }
        }
        return c3792rLM;
    }

    public final Drawable b() {
        return this.f != 0 ? this.a.d.getResources().getDrawable(this.f) : this.j;
    }

    public void c(ImageView imageView) {
        d(imageView, null);
    }

    public void d(ImageView imageView, InterfaceC3400ma interfaceC3400ma) {
        Bitmap bitmapJ;
        long jNanoTime = System.nanoTime();
        AbstractC4047uX.c();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (!this.b.b()) {
            this.a.c(imageView);
            if (this.e) {
                C4273xG.d(imageView, b());
                return;
            }
            return;
        }
        if (this.d) {
            if (this.b.c()) {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                if (this.e) {
                    C4273xG.d(imageView, b());
                }
                this.a.e(imageView, new ViewTreeObserverOnPreDrawListenerC0909Si(this, imageView, interfaceC3400ma));
                return;
            }
            this.b.d(width, height);
        }
        C3792rL c3792rLA = a(jNanoTime);
        String strH = AbstractC4047uX.h(c3792rLA);
        if (!KB.a(this.h) || (bitmapJ = this.a.j(strH)) == null) {
            if (this.e) {
                C4273xG.d(imageView, b());
            }
            this.a.g(new C3263ks(this.a, imageView, c3792rLA, this.h, this.i, this.g, this.k, strH, this.l, interfaceC3400ma, this.c));
            return;
        }
        this.a.c(imageView);
        C4192wG c4192wG = this.a;
        Context context = c4192wG.d;
        C4192wG.e eVar = C4192wG.e.MEMORY;
        C4273xG.c(imageView, context, bitmapJ, eVar, this.c, c4192wG.l);
        if (this.a.m) {
            AbstractC4047uX.v("Main", "completed", c3792rLA.g(), "from " + eVar);
        }
        if (interfaceC3400ma != null) {
            interfaceC3400ma.a();
        }
    }

    public C4035uL e(int i, int i2) {
        this.b.d(i, i2);
        return this;
    }

    public C4035uL f() {
        this.d = false;
        return this;
    }
}
