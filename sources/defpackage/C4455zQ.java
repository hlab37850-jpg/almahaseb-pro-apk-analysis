package defpackage;

import com.google.zxing.common.BitArray;

/* JADX INFO: renamed from: zQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C4455zQ extends SU {
    public final short c;
    public final short d;

    public C4455zQ(SU su, int i, int i2) {
        super(su);
        this.c = (short) i;
        this.d = (short) i2;
    }

    @Override // defpackage.SU
    public void c(BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.c, this.d);
    }

    public String toString() {
        short s = this.c;
        short s2 = this.d;
        return "<" + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.d)).substring(1) + '>';
    }
}
