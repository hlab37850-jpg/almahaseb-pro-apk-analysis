package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Rect;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BasicTextKt$BasicText$3$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ MutableState<List<Rect>> $measuredPlaceholderPositions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTextKt$BasicText$3$1(MutableState<List<Rect>> mutableState) {
        super(1);
        this.$measuredPlaceholderPositions = mutableState;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<Rect>) obj);
        return FW.a;
    }

    public final void invoke(List<Rect> list) {
        AbstractC4492zt.h(list, "it");
        this.$measuredPlaceholderPositions.setValue(list);
    }
}
