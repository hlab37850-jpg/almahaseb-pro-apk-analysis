package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PagerIntervalContent implements LazyLayoutIntervalContent.Interval {
    private final InterfaceC0578Hp item;
    private final InterfaceC3750qp key;

    public PagerIntervalContent(InterfaceC3750qp interfaceC3750qp, InterfaceC0578Hp interfaceC0578Hp) {
        AbstractC4492zt.h(interfaceC0578Hp, "item");
        this.key = interfaceC3750qp;
        this.item = interfaceC0578Hp;
    }

    public final InterfaceC0578Hp getItem() {
        return this.item;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public InterfaceC3750qp getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public /* synthetic */ InterfaceC3750qp getType() {
        return LazyLayoutIntervalContent.Interval.CC.b(this);
    }
}
