package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.itextpdf.text.pdf.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RH {
    public int d;
    public Canvas a = null;
    public Paint b = null;
    public Bitmap c = null;
    public float e = 0.0f;
    public byte[] f = null;

    public int a() {
        return ((int) this.e) + 20;
    }

    public void b(int i) {
        this.c = Bitmap.createBitmap(i, i * 10, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(this.c);
        this.a = canvas;
        canvas.drawColor(-1);
        this.d = i;
        this.f = new byte[i / 8];
    }

    public void c() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.b.setStyle(Paint.Style.STROKE);
    }

    public byte[] d() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.c, 0, 0, this.d, a());
        byte[] bArr = new byte[((this.d / 8) * a()) + 8];
        bArr[0] = 29;
        bArr[1] = 118;
        bArr[2] = ByteBuffer.ZERO;
        bArr[3] = 0;
        bArr[4] = (byte) (this.d / 8);
        bArr[5] = 0;
        bArr[6] = (byte) (a() % 256);
        int i = 7;
        bArr[7] = (byte) (a() / 256);
        for (int i2 = 0; i2 < a(); i2++) {
            for (int i3 = 0; i3 < this.d / 8; i3++) {
                int i4 = i3 * 8;
                this.f[i3] = (byte) (((bitmapCreateBitmap.getPixel(i4, i2) == -1 ? 0 : 1) * 128) + ((bitmapCreateBitmap.getPixel(i4 + 1, i2) == -1 ? 0 : 1) * 64) + ((bitmapCreateBitmap.getPixel(i4 + 2, i2) == -1 ? 0 : 1) * 32) + ((bitmapCreateBitmap.getPixel(i4 + 3, i2) == -1 ? 0 : 1) * 16) + ((bitmapCreateBitmap.getPixel(i4 + 4, i2) == -1 ? 0 : 1) * 8) + ((bitmapCreateBitmap.getPixel(i4 + 5, i2) == -1 ? 0 : 1) * 4) + ((bitmapCreateBitmap.getPixel(i4 + 6, i2) == -1 ? 0 : 1) * 2) + (bitmapCreateBitmap.getPixel(i4 + 7, i2) == -1 ? 0 : 1));
            }
            for (int i5 = 0; i5 < this.d / 8; i5++) {
                i++;
                bArr[i] = this.f[i5];
            }
        }
        return bArr;
    }
}
