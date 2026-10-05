package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.common.net.HttpHeaders;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: yF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4353yF {
    public static boolean j;
    public int b;
    public int c;
    public AbstractC3297lF d;
    public int e;
    public C4353yF g;
    public float[] h;
    public BF i;
    public int[] a = null;
    public boolean f = false;

    public C4353yF(BF bf) {
        this.i = bf;
    }

    public static C4353yF a(BF bf, Map map) throws EF {
        C4353yF c4353yF = new C4353yF(bf);
        BF bfJ = bf.j(HttpHeaders.WIDTH);
        if (bfJ == null) {
            throw new EF("Unable to read image width: " + bf);
        }
        c4353yF.q(bfJ.n());
        BF bfJ2 = bf.j("Height");
        if (bfJ2 == null) {
            throw new EF("Unable to get image height: " + bf);
        }
        c4353yF.n(bfJ2.n());
        BF bfJ3 = bf.j("ImageMask");
        if (bfJ3 != null) {
            c4353yF.o(bfJ3.f());
        }
        if (c4353yF.g()) {
            c4353yF.j(1);
            BF bfJ4 = bf.j("Decode");
            if (bfJ4 != null) {
                bfJ4.d()[0].m();
            }
            c4353yF.l(AbstractC3297lF.a(0));
        } else {
            BF bfJ5 = bf.j("BitsPerComponent");
            if (bfJ5 == null) {
                throw new EF("Unable to get bits per component: " + bf);
            }
            c4353yF.j(bfJ5.n());
            BF bfJ6 = bf.j("ColorSpace");
            if (bfJ6 == null) {
                throw new EF("No ColorSpace for image: " + bf);
            }
            c4353yF.l(AbstractC3297lF.b(bfJ6, map));
        }
        BF bfJ7 = bf.j("Decode");
        if (bfJ7 != null) {
            BF[] bfArrD = bfJ7.d();
            float[] fArr = new float[bfArrD.length];
            for (int i = 0; i < bfArrD.length; i++) {
                fArr[i] = bfArrD[i].m();
            }
            c4353yF.m(fArr);
        }
        if (bfJ3 == null) {
            BF bfJ8 = bf.j("SMask");
            if (bfJ8 == null) {
                bfJ8 = bf.j("Mask");
            }
            if (bfJ8 != null) {
                if (bfJ8.t() == 7) {
                    try {
                        c4353yF.p(a(bfJ8, map));
                    } catch (IOException e) {
                        h("ERROR: there was a problem parsing the mask for this object");
                        b(bf);
                        e.printStackTrace(System.out);
                    }
                } else if (bfJ8.t() == 5) {
                    try {
                        c4353yF.k(bfJ8);
                    } catch (IOException e2) {
                        h("ERROR: there was a problem parsing the color mask for this object");
                        b(bf);
                        e2.printStackTrace(System.out);
                    }
                }
            }
        }
        return c4353yF;
    }

    public static void b(BF bf) {
        h("dumping PDF object: " + bf);
        if (bf == null) {
            return;
        }
        HashMap mapK = bf.k();
        h("   dict = " + mapK);
        for (Object obj : mapK.keySet()) {
            h("key = " + obj + " value = " + mapK.get(obj));
        }
    }

    public static void h(String str) {
        System.out.println(str);
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.c;
    }

    public Bitmap e() {
        try {
            Bitmap bitmap = (Bitmap) this.i.g();
            if (bitmap != null) {
                return bitmap;
            }
            if (!j) {
                throw new UnsupportedOperationException("do not show images");
            }
            Bitmap bitmapI = i(this.i.q());
            this.i.v(bitmapI);
            return bitmapI;
        } catch (IOException e) {
            System.out.println("Error reading image");
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError unused) {
            Log.e("AWTPDF.pdfimage", "image too large (OutOfMemoryError)");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(15, 15, Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.drawColor(SupportMenu.CATEGORY_MASK);
            Paint paint = new Paint();
            paint.setColor(-1);
            float f = 14;
            canvas.drawLine(0.0f, 0.0f, f, f, paint);
            canvas.drawLine(0.0f, f, f, 0.0f, paint);
            float f2 = 6;
            canvas.drawLine(f2, 0.0f, f2, f, paint);
            canvas.drawLine(0.0f, f2, f, f2, paint);
            return bitmapCreateBitmap;
        }
    }

    public int f() {
        return this.b;
    }

    public boolean g() {
        return this.f;
    }

    public final Bitmap i(byte[] bArr) {
        Bitmap bitmapCreateBitmap;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.i("AWTPDF.pdfimage", "Creating Image width=" + f() + ", Height=" + d() + ", bpc=" + c() + ",cs=" + this.d);
        AbstractC3297lF abstractC3297lF = this.d;
        if (abstractC3297lF == null) {
            throw new UnsupportedOperationException("image without colorspace");
        }
        if (abstractC3297lF.g() == 1) {
            int iD = d();
            int iF = f();
            if (bArr.length == iF * 2 * iD) {
                bitmapCreateBitmap = Bitmap.createBitmap(iF, iD, Bitmap.Config.RGB_565);
                bitmapCreateBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr));
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(f(), d(), Bitmap.Config.ARGB_8888);
                int[] iArr = new int[iF];
                int i = 0;
                int i2 = 0;
                while (i2 < iD) {
                    int i3 = i;
                    for (int i4 = 0; i4 < f(); i4++) {
                        iArr[i4] = ((((bArr[i3] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i3 + 1] & UnsignedBytes.MAX_VALUE)) << 8) | (bArr[i3 + 2] & UnsignedBytes.MAX_VALUE) | ViewCompat.MEASURED_STATE_MASK;
                        i3 += 3;
                    }
                    bitmapCreateBitmap2.setPixels(iArr, 0, iF, 0, i2, iF, 1);
                    i2++;
                    i = i3;
                    iArr = iArr;
                    iF = iF;
                }
                bitmapCreateBitmap = bitmapCreateBitmap2;
            }
        } else if (this.d.g() == 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(f(), d(), Bitmap.Config.ARGB_8888);
            int iD2 = d();
            int iF2 = f();
            int[] iArr2 = new int[iF2];
            int i5 = 0;
            int i6 = 0;
            while (i6 < iD2) {
                int i7 = i5;
                for (int i8 = 0; i8 < f(); i8++) {
                    int i9 = bArr[i7] & UnsignedBytes.MAX_VALUE;
                    iArr2[i8] = i9 | (((i9 << 8) | i9) << 8) | ViewCompat.MEASURED_STATE_MASK;
                    i7++;
                }
                int i10 = i6;
                bitmapCreateBitmap.setPixels(iArr2, 0, iF2, 0, i10, iF2, 1);
                i6 = i10 + 1;
                i5 = i7;
                iArr2 = iArr2;
            }
        } else {
            if (this.d.g() != 4) {
                throw new UnsupportedOperationException("image with unsupported colorspace " + this.d);
            }
            bitmapCreateBitmap = Bitmap.createBitmap(f(), d(), Bitmap.Config.ARGB_8888);
            int iD3 = d();
            int iF3 = f();
            int[] iArr3 = new int[iF3];
            int i11 = 0;
            int i12 = 0;
            while (i12 < iD3) {
                int i13 = i11;
                for (int i14 = 0; i14 < f(); i14++) {
                    iArr3[i14] = this.d.i(new int[]{bArr[i13] & 255});
                    i13++;
                }
                bitmapCreateBitmap.setPixels(iArr3, 0, iF3, 0, i12, iF3, 1);
                i12++;
                i11 = i13;
                iArr3 = iArr3;
            }
        }
        Log.i("AWTPDF.pdfimage", "millis for converting image=" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return bitmapCreateBitmap;
    }

    public void j(int i) {
        this.e = i;
    }

    public final void k(BF bf) {
        BF[] bfArrD = bf.d();
        this.a = null;
        int length = bfArrD.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = bfArrD[i].n();
        }
        this.a = iArr;
    }

    public void l(AbstractC3297lF abstractC3297lF) {
        this.d = abstractC3297lF;
    }

    public void m(float[] fArr) {
        this.h = fArr;
    }

    public void n(int i) {
        this.c = i;
    }

    public void o(boolean z) {
        this.f = z;
    }

    public void p(C4353yF c4353yF) {
        this.g = c4353yF;
    }

    public void q(int i) {
        this.b = i;
    }
}
