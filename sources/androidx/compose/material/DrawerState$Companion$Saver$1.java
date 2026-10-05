package androidx.compose.material;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class DrawerState$Companion$Saver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final DrawerState$Companion$Saver$1 INSTANCE = new DrawerState$Companion$Saver$1();

    public DrawerState$Companion$Saver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final DrawerValue mo13invoke(SaverScope saverScope, DrawerState drawerState) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        AbstractC4492zt.h(drawerState, "it");
        return drawerState.getCurrentValue();
    }
}
