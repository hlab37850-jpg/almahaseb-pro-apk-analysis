package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.graphics.Color;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.C3150jW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$ColorSaver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SaversKt$ColorSaver$1 INSTANCE = new SaversKt$ColorSaver$1();

    public SaversKt$ColorSaver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m4646invoke4WTKRHQ((SaverScope) obj, ((Color) obj2).m3042unboximpl());
    }

    /* JADX INFO: renamed from: invoke-4WTKRHQ, reason: not valid java name */
    public final Object m4646invoke4WTKRHQ(SaverScope saverScope, long j) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        return C3150jW.a(j);
    }
}
