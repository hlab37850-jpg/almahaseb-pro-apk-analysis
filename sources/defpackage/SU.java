package defpackage;

import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SU {
    public static final SU b = new C4455zQ(null, 0, 0);
    public final SU a;

    public SU(SU su) {
        this.a = su;
    }

    public final SU a(int i, int i2) {
        return new C4455zQ(this, i, i2);
    }

    public final SU b(int i, int i2) {
        return new Y7(this, i, i2);
    }

    public abstract void c(BitArray bitArray, byte[] bArr);

    public final SU d() {
        return this.a;
    }
}
