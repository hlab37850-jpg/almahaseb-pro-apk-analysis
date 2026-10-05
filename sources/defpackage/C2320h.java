package defpackage;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: renamed from: h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2320h extends AbstractC3353m {
    public C2320h(BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() < 48) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        b(sb, 8);
        int iF = getGeneralDecoder().f(48, 2);
        sb.append("(392");
        sb.append(iF);
        sb.append(')');
        sb.append(getGeneralDecoder().c(50, null).b());
        return sb.toString();
    }
}
