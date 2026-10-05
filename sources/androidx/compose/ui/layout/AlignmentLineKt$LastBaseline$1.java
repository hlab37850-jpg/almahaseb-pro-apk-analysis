package androidx.compose.ui.layout;

import defpackage.C0916Sp;
import defpackage.InterfaceC0526Fp;
import defpackage.YA;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class AlignmentLineKt$LastBaseline$1 extends C0916Sp implements InterfaceC0526Fp {
    public static final AlignmentLineKt$LastBaseline$1 INSTANCE = new AlignmentLineKt$LastBaseline$1();

    public AlignmentLineKt$LastBaseline$1() {
        super(2, YA.class, "max", "max(II)I", 1);
    }

    public final Integer invoke(int i, int i2) {
        return Integer.valueOf(Math.max(i, i2));
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
    }
}
