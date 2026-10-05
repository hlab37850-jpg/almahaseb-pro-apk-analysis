package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
@Stable
final class UnionInsetsConsumingModifier extends InsetsConsumingModifier {
    private final WindowInsets insets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnionInsetsConsumingModifier(WindowInsets windowInsets, InterfaceC3750qp interfaceC3750qp) {
        super(interfaceC3750qp, null);
        AbstractC4492zt.h(windowInsets, "insets");
        AbstractC4492zt.h(interfaceC3750qp, "inspectorInfo");
        this.insets = windowInsets;
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifier
    public WindowInsets calculateInsets(WindowInsets windowInsets) {
        AbstractC4492zt.h(windowInsets, "modifierLocalInsets");
        return WindowInsetsKt.union(this.insets, windowInsets);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UnionInsetsConsumingModifier) {
            return AbstractC4492zt.d(((UnionInsetsConsumingModifier) obj).insets, this.insets);
        }
        return false;
    }

    public int hashCode() {
        return this.insets.hashCode();
    }
}
