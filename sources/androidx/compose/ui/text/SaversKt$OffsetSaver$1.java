package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC1886cc;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class SaversKt$OffsetSaver$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    public static final SaversKt$OffsetSaver$1 INSTANCE = new SaversKt$OffsetSaver$1();

    public SaversKt$OffsetSaver$1() {
        super(2);
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return m4648invokeUv8p0NA((SaverScope) obj, ((Offset) obj2).m2808unboximpl());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
    public final Object m4648invokeUv8p0NA(SaverScope saverScope, long j) {
        AbstractC4492zt.h(saverScope, "$this$Saver");
        return Offset.m2795equalsimpl0(j, Offset.Companion.m2813getUnspecifiedF1C5BW0()) ? Boolean.FALSE : AbstractC1886cc.g(SaversKt.save(Float.valueOf(Offset.m2798getXimpl(j))), SaversKt.save(Float.valueOf(Offset.m2799getYimpl(j))));
    }
}
