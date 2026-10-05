package defpackage;

import com.google.zxing.common.BitArray;

/* JADX INFO: renamed from: l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3271l extends AbstractC3353m {
    public C3271l(BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("(01)");
        int length = sb.length();
        sb.append(getGeneralDecoder().f(4, 4));
        c(sb, 8, length);
        return getGeneralDecoder().a(sb, 48);
    }
}
