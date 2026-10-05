package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.google.zxing.PlanarYUVLuminanceSource;
import java.io.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: renamed from: mR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C3391mR {
    public byte[] a;
    public int b;
    public int c;
    public int d;
    public int e;
    public Rect f;

    public C3391mR(byte[] bArr, int i, int i2, int i3, int i4) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = i4;
        this.d = i3;
        if (i * i2 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i + "x" + i2 + " > " + bArr.length);
    }

    public static byte[] e(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i4] = bArr[i5];
            i4--;
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = i2 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i) + i5];
                i4--;
            }
        }
        return bArr2;
    }

    public static byte[] g(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i * i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                bArr2[i3] = bArr[(i5 * i) + i4];
                i3++;
            }
        }
        return bArr2;
    }

    public static byte[] h(int i, byte[] bArr, int i2, int i3) {
        if (i == 90) {
            return g(bArr, i2, i3);
        }
        if (i != 180) {
            return i != 270 ? bArr : f(bArr, i2, i3);
        }
        return e(bArr, i2, i3);
    }

    public PlanarYUVLuminanceSource a() {
        byte[] bArrH = h(this.e, this.a, this.b, this.c);
        if (d()) {
            int i = this.c;
            int i2 = this.b;
            Rect rect = this.f;
            return new PlanarYUVLuminanceSource(bArrH, i, i2, rect.left, rect.top, rect.width(), this.f.height(), false);
        }
        int i3 = this.b;
        int i4 = this.c;
        Rect rect2 = this.f;
        return new PlanarYUVLuminanceSource(bArrH, i3, i4, rect2.left, rect2.top, rect2.width(), this.f.height(), false);
    }

    public Bitmap b(int i) {
        return c(this.f, i);
    }

    public final Bitmap c(Rect rect, int i) {
        if (d()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.a, this.d, this.b, this.c, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.e == 0) {
            return bitmapDecodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.e);
        return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
    }

    public boolean d() {
        return this.e % ShapeTypes.MATH_EQUAL != 0;
    }

    public void i(Rect rect) {
        this.f = rect;
    }
}
