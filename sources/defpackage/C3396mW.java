package defpackage;

import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.UPCEANReader;
import com.google.zxing.oned.a;
import com.google.zxing.oned.b;

/* JADX INFO: renamed from: mW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3396mW {
    public static final int[] c = {1, 1, 2};
    public final a a = new a();
    public final b b = new b();

    public Result a(int i, BitArray bitArray, int i2) {
        int[] iArrFindGuardPattern = UPCEANReader.findGuardPattern(bitArray, i2, false, c);
        try {
            return this.b.b(i, bitArray, iArrFindGuardPattern);
        } catch (ReaderException unused) {
            return this.a.b(i, bitArray, iArrFindGuardPattern);
        }
    }
}
