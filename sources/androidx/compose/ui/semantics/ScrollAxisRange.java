package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class ScrollAxisRange {
    public static final int $stable = 0;
    private final InterfaceC3588op maxValue;
    private final boolean reverseScrolling;
    private final InterfaceC3588op value;

    public ScrollAxisRange(InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, boolean z) {
        AbstractC4492zt.h(interfaceC3588op, "value");
        AbstractC4492zt.h(interfaceC3588op2, "maxValue");
        this.value = interfaceC3588op;
        this.maxValue = interfaceC3588op2;
        this.reverseScrolling = z;
    }

    public final InterfaceC3588op getMaxValue() {
        return this.maxValue;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final InterfaceC3588op getValue() {
        return this.value;
    }

    public String toString() {
        return "ScrollAxisRange(value=" + ((Number) this.value.invoke()).floatValue() + ", maxValue=" + ((Number) this.maxValue.invoke()).floatValue() + ", reverseScrolling=" + this.reverseScrolling + ')';
    }

    public /* synthetic */ ScrollAxisRange(InterfaceC3588op interfaceC3588op, InterfaceC3588op interfaceC3588op2, boolean z, int i, AbstractC0419Di abstractC0419Di) {
        this(interfaceC3588op, interfaceC3588op2, (i & 4) != 0 ? false : z);
    }
}
