package defpackage;

import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;

/* JADX INFO: renamed from: i4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2411i4 extends AbstractExpandedDecoder {
    public C2411i4(BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() {
        return getGeneralDecoder().a(new StringBuilder(), 5);
    }
}
