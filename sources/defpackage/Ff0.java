package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class Ff0 extends AbstractBinderC3165jf0 {
    public final byte[] b;

    public Ff0(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.b = bArr;
    }

    @Override // defpackage.AbstractBinderC3165jf0
    public final byte[] t() {
        return this.b;
    }
}
