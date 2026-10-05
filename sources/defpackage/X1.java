package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class X1 {
    public final C4192wG a;
    public final C3792rL b;
    public final WeakReference c;
    public final boolean d;
    public final int e;
    public final int f;
    public final int g;
    public final Drawable h;
    public final String i;
    public final Object j;
    public boolean k;
    public boolean l;

    public static class a extends WeakReference {
        public final X1 a;

        public a(X1 x1, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.a = x1;
        }
    }

    public X1(C4192wG c4192wG, Object obj, C3792rL c3792rL, int i, int i2, int i3, Drawable drawable, String str, Object obj2, boolean z) {
        this.a = c4192wG;
        this.b = c3792rL;
        this.c = obj == null ? null : new a(this, obj, c4192wG.j);
        this.e = i;
        this.f = i2;
        this.d = z;
        this.g = i3;
        this.h = drawable;
        this.i = str;
        this.j = obj2 == null ? this : obj2;
    }

    public void a() {
        this.l = true;
    }

    public abstract void b(Bitmap bitmap, C4192wG.e eVar);

    public abstract void c();

    public String d() {
        return this.i;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public C4192wG g() {
        return this.a;
    }

    public C4192wG.f h() {
        return this.b.r;
    }

    public C3792rL i() {
        return this.b;
    }

    public Object j() {
        return this.j;
    }

    public Object k() {
        WeakReference weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.k;
    }
}
