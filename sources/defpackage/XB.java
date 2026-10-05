package defpackage;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.common.HybridBinarizer;

/* JADX INFO: loaded from: classes3.dex */
public class XB extends C4390yi {
    public boolean c;

    public XB(Reader reader) {
        super(reader);
        this.c = true;
    }

    @Override // defpackage.C4390yi
    public BinaryBitmap d(LuminanceSource luminanceSource) {
        if (this.c) {
            this.c = false;
            return new BinaryBitmap(new HybridBinarizer(luminanceSource.invert()));
        }
        this.c = true;
        return new BinaryBitmap(new HybridBinarizer(luminanceSource));
    }
}
