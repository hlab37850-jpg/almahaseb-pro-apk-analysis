package androidx.compose.material3;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TopAppBarState$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final TopAppBarState$Companion$Saver$1 INSTANCE = new TopAppBarState$Companion$Saver$1();

    public TopAppBarState$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final List<Float> mo13invoke(SaverScope saverScope, TopAppBarState topAppBarState) {
        AbstractC4492zt.h(saverScope, "$this$listSaver");
        AbstractC4492zt.h(topAppBarState, "it");
        return AbstractC1886cc.p(Float.valueOf(topAppBarState.getHeightOffsetLimit()), Float.valueOf(topAppBarState.getHeightOffset()), Float.valueOf(topAppBarState.getContentOffset()));
    }
}
