package androidx.compose.material3;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchKt$Switch$valueToOffset$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ float $maxBound;
    final /* synthetic */ float $minBound;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchKt$Switch$valueToOffset$1$1(float f, float f2) {
        super(1);
        this.$maxBound = f;
        this.$minBound = f2;
    }

    public final Float invoke(boolean z) {
        return Float.valueOf(z ? this.$maxBound : this.$minBound);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Boolean) obj).booleanValue());
    }
}
