package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0578Hp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
final class PagerLayoutIntervalContent extends LazyLayoutIntervalContent<PagerIntervalContent> {
    private final IntervalList<PagerIntervalContent> intervals;
    private final InterfaceC3750qp key;
    private final InterfaceC0578Hp pageContent;
    private final int pageCount;

    public PagerLayoutIntervalContent(InterfaceC0578Hp interfaceC0578Hp, InterfaceC3750qp interfaceC3750qp, int i) {
        AbstractC4492zt.h(interfaceC0578Hp, "pageContent");
        this.pageContent = interfaceC0578Hp;
        this.key = interfaceC3750qp;
        this.pageCount = i;
        MutableIntervalList mutableIntervalList = new MutableIntervalList();
        mutableIntervalList.addInterval(i, new PagerIntervalContent(interfaceC3750qp, interfaceC0578Hp));
        this.intervals = mutableIntervalList;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent
    public IntervalList<PagerIntervalContent> getIntervals() {
        return this.intervals;
    }

    public final InterfaceC3750qp getKey() {
        return this.key;
    }

    public final InterfaceC0578Hp getPageContent() {
        return this.pageContent;
    }

    public final int getPageCount() {
        return this.pageCount;
    }
}
