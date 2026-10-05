package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$TextUnitSaver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SaversKt$TextUnitSaver$1 INSTANCE = new SaversKt$TextUnitSaver$1();

    public SaversKt$TextUnitSaver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m4652invokempE4wyQ((SaverScope) obj, ((TextUnit) obj2).m5350unboximpl());
    }

    /* JADX INFO: renamed from: invoke-mpE4wyQ, reason: not valid java name */
    public final Object m4652invokempE4wyQ(SaverScope saverScope, long j) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        return AbstractC1886cc.g(SaversKt.save(Float.valueOf(TextUnit.m5341getValueimpl(j))), SaversKt.save(TextUnitType.m5366boximpl(TextUnit.m5340getTypeUIouoOA(j))));
    }
}
