package defpackage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: yi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C4390yi implements ResultPointCallback {
    public Reader a;
    public List b = new ArrayList();

    public C4390yi(Reader reader) {
        this.a = reader;
    }

    public Result a(BinaryBitmap binaryBitmap) {
        this.b.clear();
        try {
            Reader reader = this.a;
            return reader instanceof MultiFormatReader ? ((MultiFormatReader) reader).decodeWithState(binaryBitmap) : reader.decode(binaryBitmap);
        } catch (Exception unused) {
            return null;
        } finally {
            this.a.reset();
        }
    }

    public Result b(LuminanceSource luminanceSource) {
        return a(d(luminanceSource));
    }

    public List c() {
        return new ArrayList(this.b);
    }

    public BinaryBitmap d(LuminanceSource luminanceSource) {
        return new BinaryBitmap(new HybridBinarizer(luminanceSource));
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.b.add(resultPoint);
    }
}
