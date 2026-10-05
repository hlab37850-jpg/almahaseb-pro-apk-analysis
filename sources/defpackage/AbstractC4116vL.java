package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import java.io.InputStream;

/* JADX INFO: renamed from: vL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4116vL {

    /* JADX INFO: renamed from: vL$a */
    public static final class a {
        public final C4192wG.e a;
        public final Bitmap b;
        public final InputStream c;
        public final int d;

        public a(Bitmap bitmap, C4192wG.e eVar) {
            this((Bitmap) AbstractC4047uX.d(bitmap, "bitmap == null"), null, eVar, 0);
        }

        public Bitmap a() {
            return this.b;
        }

        public int b() {
            return this.d;
        }

        public C4192wG.e c() {
            return this.a;
        }

        public InputStream d() {
            return this.c;
        }

        public a(InputStream inputStream, C4192wG.e eVar) {
            this(null, (InputStream) AbstractC4047uX.d(inputStream, "stream == null"), eVar, 0);
        }

        public a(Bitmap bitmap, InputStream inputStream, C4192wG.e eVar, int i) {
            if ((inputStream != null) ^ (bitmap != null)) {
                this.b = bitmap;
                this.c = inputStream;
                this.a = (C4192wG.e) AbstractC4047uX.d(eVar, "loadedFrom == null");
                this.d = i;
                return;
            }
            throw new AssertionError();
        }
    }

    public static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, C3792rL c3792rL) {
        int iMax;
        double dFloor;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                dFloor = Math.floor(i3 / i);
            } else if (i == 0) {
                dFloor = Math.floor(i4 / i2);
            } else {
                int iFloor = (int) Math.floor(i4 / i2);
                int iFloor2 = (int) Math.floor(i3 / i);
                iMax = c3792rL.k ? Math.max(iFloor, iFloor2) : Math.min(iFloor, iFloor2);
            }
            iMax = (int) dFloor;
        } else {
            iMax = 1;
        }
        options.inSampleSize = iMax;
        options.inJustDecodeBounds = false;
    }

    public static void b(int i, int i2, BitmapFactory.Options options, C3792rL c3792rL) {
        a(i, i2, options.outWidth, options.outHeight, options, c3792rL);
    }

    public static BitmapFactory.Options d(C3792rL c3792rL) {
        boolean zC = c3792rL.c();
        boolean z = c3792rL.q != null;
        if (!zC && !z) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = zC;
        if (z) {
            options.inPreferredConfig = c3792rL.q;
        }
        return options;
    }

    public static boolean g(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public abstract boolean c(C3792rL c3792rL);

    public int e() {
        return 0;
    }

    public abstract a f(C3792rL c3792rL, int i);

    public boolean h(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    public boolean i() {
        return false;
    }
}
