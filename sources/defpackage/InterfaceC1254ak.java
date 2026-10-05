package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: ak, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC1254ak {

    /* JADX INFO: renamed from: ak$a */
    public static class a {
        public final InputStream a;
        public final Bitmap b;
        public final boolean c;
        public final long d;

        public a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.a = inputStream;
            this.b = null;
            this.c = z;
            this.d = j;
        }

        public Bitmap a() {
            return this.b;
        }

        public long b() {
            return this.d;
        }

        public InputStream c() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: ak$b */
    public static class b extends IOException {
        public final boolean a;
        public final int b;

        public b(String str, int i, int i2) {
            super(str);
            this.a = EnumC3704qD.a(i);
            this.b = i2;
        }
    }

    a a(Uri uri, int i);
}
