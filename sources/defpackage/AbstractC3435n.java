package defpackage;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.google.zxing.common.BitArray;

/* JADX INFO: renamed from: n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3435n extends AbstractC3353m {
    public AbstractC3435n(BitArray bitArray) {
        super(bitArray);
    }

    public abstract void d(StringBuilder sb, int i);

    public abstract int e(int i);

    public final void f(StringBuilder sb, int i, int i2) {
        int iF = getGeneralDecoder().f(i, i2);
        d(sb, iF);
        int iE = e(iF);
        int i3 = AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
        for (int i4 = 0; i4 < 5; i4++) {
            if (iE / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(iE);
    }
}
