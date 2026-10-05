package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$TextRangeSaver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SaversKt$TextRangeSaver$1 INSTANCE = new SaversKt$TextRangeSaver$1();

    public SaversKt$TextRangeSaver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m4650invokeFDrldGo((SaverScope) obj, ((TextRange) obj2).m4709unboximpl());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke-FDrldGo, reason: not valid java name */
    public final Object m4650invokeFDrldGo(SaverScope saverScope, long j) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        return AbstractC1886cc.g(SaversKt.save(Integer.valueOf(TextRange.m4705getStartimpl(j))), SaversKt.save(Integer.valueOf(TextRange.m4700getEndimpl(j))));
    }
}
