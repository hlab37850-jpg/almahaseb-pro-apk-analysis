package androidx.window.core;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class Version$bigInteger$2 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ Version this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Version$bigInteger$2(Version version) {
        super(0);
        this.this$0 = version;
    }

    @Override // defpackage.InterfaceC3588op
    public final BigInteger invoke() {
        return BigInteger.valueOf(this.this$0.getMajor()).shiftLeft(32).or(BigInteger.valueOf(this.this$0.getMinor())).shiftLeft(32).or(BigInteger.valueOf(this.this$0.getPatch()));
    }
}
