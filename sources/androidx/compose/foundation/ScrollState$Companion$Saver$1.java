package androidx.compose.foundation;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollState$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final ScrollState$Companion$Saver$1 INSTANCE = new ScrollState$Companion$Saver$1();

    public ScrollState$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Integer mo13invoke(SaverScope saverScope, ScrollState scrollState) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(scrollState, "it");
        return Integer.valueOf(scrollState.getValue());
    }
}
