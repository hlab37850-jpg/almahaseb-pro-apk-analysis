package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class LazyGridInterval implements LazyLayoutIntervalContent.Interval {
    private final InterfaceC0578Hp item;
    private final InterfaceC3750qp key;
    private final InterfaceC0526Fp span;
    private final InterfaceC3750qp type;

    public LazyGridInterval(InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, InterfaceC3750qp interfaceC3750qp2, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(interfaceC0526Fp, "span");
        AbstractC4492zt.h(interfaceC3750qp2, "type");
        AbstractC4492zt.h(interfaceC0578Hp, "item");
        this.key = interfaceC3750qp;
        this.span = interfaceC0526Fp;
        this.type = interfaceC3750qp2;
        this.item = interfaceC0578Hp;
    }

    public final InterfaceC0578Hp getItem() {
        return this.item;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public InterfaceC3750qp getKey() {
        return this.key;
    }

    public final InterfaceC0526Fp getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public InterfaceC3750qp getType() {
        return this.type;
    }
}
