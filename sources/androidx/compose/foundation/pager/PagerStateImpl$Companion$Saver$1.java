package androidx.compose.foundation.pager;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PagerStateImpl$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final PagerStateImpl$Companion$Saver$1 INSTANCE = new PagerStateImpl$Companion$Saver$1();

    public PagerStateImpl$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final List<Object> mo13invoke(SaverScope saverScope, PagerStateImpl pagerStateImpl) {
        AbstractC4492zt.h(saverScope, "$this$listSaver");
        AbstractC4492zt.h(pagerStateImpl, "it");
        return AbstractC1886cc.p(Integer.valueOf(pagerStateImpl.getCurrentPage()), Float.valueOf(pagerStateImpl.getCurrentPageOffsetFraction()), Integer.valueOf(pagerStateImpl.getPageCount()));
    }
}
