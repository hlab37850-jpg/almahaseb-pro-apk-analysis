package androidx.compose.material;

import androidx.compose.ui.input.pointer.PointerInputChange;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.LJ;

/* JADX INFO: loaded from: classes.dex */
public final class SliderKt$awaitSlop$postPointerSlop$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ LJ $initialDelta;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$awaitSlop$postPointerSlop$1(LJ lj) {
        super(2);
        this.$initialDelta = lj;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((PointerInputChange) obj, ((Number) obj2).floatValue());
        return FW.a;
    }

    public final void invoke(PointerInputChange pointerInputChange, float f) {
        AbstractC4492zt.h(pointerInputChange, "pointerInput");
        pointerInputChange.consume();
        this.$initialDelta.a = f;
    }
}
