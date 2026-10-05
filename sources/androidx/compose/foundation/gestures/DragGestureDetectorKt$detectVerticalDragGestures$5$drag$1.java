package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.LJ;

/* JADX INFO: loaded from: classes.dex */
public final class DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ LJ $overSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$detectVerticalDragGestures$5$drag$1(LJ lj) {
        super(2);
        this.$overSlop = lj;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((PointerInputChange) obj, ((Number) obj2).floatValue());
        return FW.a;
    }

    public final void invoke(PointerInputChange pointerInputChange, float f) {
        AbstractC4492zt.h(pointerInputChange, "change");
        pointerInputChange.consume();
        this.$overSlop.a = f;
    }
}
