package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.BaselineShift;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$BaselineShiftSaver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SaversKt$BaselineShiftSaver$1 INSTANCE = new SaversKt$BaselineShiftSaver$1();

    public SaversKt$BaselineShiftSaver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m4644invoke8a2Sb4w((SaverScope) obj, ((BaselineShift) obj2).m4965unboximpl());
    }

    /* JADX INFO: renamed from: invoke-8a2Sb4w, reason: not valid java name */
    public final Object m4644invoke8a2Sb4w(SaverScope saverScope, float f) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        return Float.valueOf(f);
    }
}
