package defpackage;

import android.graphics.Bitmap;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes3.dex */
public class OH extends RH {
    public void e(float f, float f2, Bitmap bitmap) {
        try {
            this.a.drawBitmap(bitmap, f, f2, (Paint) null);
            if (this.e < bitmap.getHeight() + f2) {
                this.e = f2 + bitmap.getHeight();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
