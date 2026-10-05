package defpackage;

import com.google.zxing.common.BitArray;
import org.apache.poi.hpsf.Constants;

/* JADX INFO: renamed from: g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2238g extends AbstractC3189k {
    public C2238g(BitArray bitArray) {
        super(bitArray);
    }

    @Override // defpackage.AbstractC3435n
    public void d(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // defpackage.AbstractC3435n
    public int e(int i) {
        return i < 10000 ? i : i - Constants.CP_MAC_ROMAN;
    }
}
