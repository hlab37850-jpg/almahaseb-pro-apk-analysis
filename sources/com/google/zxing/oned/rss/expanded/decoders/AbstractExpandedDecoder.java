package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;
import defpackage.C2064dq;
import defpackage.C2156f;
import defpackage.C2238g;
import defpackage.C2320h;
import defpackage.C2402i;
import defpackage.C2411i4;
import defpackage.C3107j;
import defpackage.C3271l;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractExpandedDecoder {
    private final C2064dq generalDecoder;
    private final BitArray information;

    public AbstractExpandedDecoder(BitArray bitArray) {
        this.information = bitArray;
        this.generalDecoder = new C2064dq(bitArray);
    }

    public static AbstractExpandedDecoder createDecoder(BitArray bitArray) {
        if (bitArray.get(1)) {
            return new C3271l(bitArray);
        }
        if (!bitArray.get(2)) {
            return new C2411i4(bitArray);
        }
        int iG = C2064dq.g(bitArray, 1, 4);
        if (iG == 4) {
            return new C2156f(bitArray);
        }
        if (iG == 5) {
            return new C2238g(bitArray);
        }
        int iG2 = C2064dq.g(bitArray, 1, 5);
        if (iG2 == 12) {
            return new C2320h(bitArray);
        }
        if (iG2 == 13) {
            return new C2402i(bitArray);
        }
        switch (C2064dq.g(bitArray, 1, 7)) {
            case 56:
                return new C3107j(bitArray, "310", "11");
            case 57:
                return new C3107j(bitArray, "320", "11");
            case 58:
                return new C3107j(bitArray, "310", "13");
            case 59:
                return new C3107j(bitArray, "320", "13");
            case 60:
                return new C3107j(bitArray, "310", "15");
            case 61:
                return new C3107j(bitArray, "320", "15");
            case 62:
                return new C3107j(bitArray, "310", "17");
            case 63:
                return new C3107j(bitArray, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(bitArray)));
        }
    }

    public final C2064dq getGeneralDecoder() {
        return this.generalDecoder;
    }

    public final BitArray getInformation() {
        return this.information;
    }

    public abstract String parseInformation();
}
