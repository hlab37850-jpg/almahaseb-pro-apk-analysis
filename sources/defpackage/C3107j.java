package defpackage;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: renamed from: j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3107j extends AbstractC3435n {
    public final String a;
    public final String b;

    public C3107j(BitArray bitArray, String str, String str2) {
        super(bitArray);
        this.a = str2;
        this.b = str;
    }

    @Override // defpackage.AbstractC3435n
    public void d(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.b);
        sb.append(i / AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength);
        sb.append(')');
    }

    @Override // defpackage.AbstractC3435n
    public int e(int i) {
        return i % AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
    }

    public final void g(StringBuilder sb, int i) {
        int iF = getGeneralDecoder().f(i, 16);
        if (iF == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.a);
        sb.append(')');
        int i2 = iF % 32;
        int i3 = iF / 32;
        int i4 = (i3 % 12) + 1;
        int i5 = i3 / 12;
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i4 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i4);
        if (i2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i2);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        f(sb, 48, 20);
        g(sb, 68);
        return sb.toString();
    }
}
