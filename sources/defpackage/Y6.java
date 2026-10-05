package defpackage;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Y6 {
    public Result a;
    public C3391mR b;
    public final int c = 2;

    public Y6(Result result, C3391mR c3391mR) {
        this.a = result;
        this.b = c3391mR;
    }

    public BarcodeFormat a() {
        return this.a.getBarcodeFormat();
    }

    public Bitmap b() {
        return this.b.b(2);
    }

    public byte[] c() {
        return this.a.getRawBytes();
    }

    public Map d() {
        return this.a.getResultMetadata();
    }

    public String toString() {
        return this.a.getText();
    }
}
