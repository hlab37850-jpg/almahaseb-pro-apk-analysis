package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.youtube.player.YouTubeThumbnailView;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends com.google.android.youtube.player.internal.a {
    private final Handler a;
    private b b;
    private k c;
    private boolean d;
    private boolean e;

    public final class a extends j.a {

        /* JADX INFO: renamed from: com.google.android.youtube.player.internal.p$a$a, reason: collision with other inner class name */
        public class RunnableC0193a implements Runnable {
            public final /* synthetic */ boolean a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ Bitmap c;
            public final /* synthetic */ String d;

            public RunnableC0193a(boolean z, boolean z2, Bitmap bitmap, String str) {
                this.a = z;
                this.b = z2;
                this.c = bitmap;
                this.d = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.d = this.a;
                p.this.e = this.b;
                p.this.a(this.c, this.d);
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ boolean a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ String c;

            public b(boolean z, boolean z2, String str) {
                this.a = z;
                this.b = z2;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p.this.d = this.a;
                p.this.e = this.b;
                p.this.b(this.c);
            }
        }

        public a() {
        }

        @Override // com.google.android.youtube.player.internal.j
        public final void a(Bitmap bitmap, String str, boolean z, boolean z2) {
            p.this.a.post(new RunnableC0193a(z, z2, bitmap, str));
        }

        public /* synthetic */ a(p pVar, byte b2) {
            this();
        }

        @Override // com.google.android.youtube.player.internal.j
        public final void a(String str, boolean z, boolean z2) {
            p.this.a.post(new b(z, z2, str));
        }
    }

    public p(b bVar, YouTubeThumbnailView youTubeThumbnailView) {
        super(youTubeThumbnailView);
        this.b = (b) ab.a(bVar, "connectionClient cannot be null");
        this.c = bVar.a(new a(this, (byte) 0));
        this.a = new Handler(Looper.getMainLooper());
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void c() {
        try {
            this.c.a();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void d() {
        try {
            this.c.b();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void e() {
        try {
            this.c.c();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.youtube.player.internal.a
    public final boolean f() {
        return this.e;
    }

    @Override // com.google.android.youtube.player.internal.a
    public final boolean g() {
        return this.d;
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void h() {
        try {
            this.c.d();
        } catch (RemoteException unused) {
        }
        this.b.d();
        this.c = null;
        this.b = null;
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void a(String str) {
        try {
            this.c.a(str);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.youtube.player.internal.a
    public final void a(String str, int i) {
        try {
            this.c.a(str, i);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.youtube.player.internal.a
    public final boolean a() {
        return super.a() && this.c != null;
    }
}
