package defpackage;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/* JADX INFO: renamed from: Ai, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0341Ai implements ResultPointCallback {
    public C4390yi a;

    public void a(C4390yi c4390yi) {
        this.a = c4390yi;
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        C4390yi c4390yi = this.a;
        if (c4390yi != null) {
            c4390yi.foundPossibleResultPoint(resultPoint);
        }
    }
}
