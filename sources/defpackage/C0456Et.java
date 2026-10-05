package defpackage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.common.HybridBinarizer;

/* JADX INFO: renamed from: Et, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0456Et extends C4390yi {
    public C0456Et(Reader reader) {
        super(reader);
    }

    @Override // defpackage.C4390yi
    public BinaryBitmap d(LuminanceSource luminanceSource) {
        return new BinaryBitmap(new HybridBinarizer(luminanceSource.invert()));
    }
}
