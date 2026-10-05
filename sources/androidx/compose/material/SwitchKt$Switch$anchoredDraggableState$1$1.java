package androidx.compose.material;

import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchKt$Switch$anchoredDraggableState$1$1 extends AbstractC2233fv implements InterfaceC3750qp {
    public static final SwitchKt$Switch$anchoredDraggableState$1$1 INSTANCE = new SwitchKt$Switch$anchoredDraggableState$1$1();

    public SwitchKt$Switch$anchoredDraggableState$1$1() {
        super(1);
    }

    public final Float invoke(float f) {
        return Float.valueOf(f * 0.7f);
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
