package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Rect;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BasicTextKt$BasicText$4$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ MutableState<List<Rect>> $measuredPlaceholderPositions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTextKt$BasicText$4$1(MutableState<List<Rect>> mutableState) {
        super(0);
        this.$measuredPlaceholderPositions = mutableState;
    }

    @Override // defpackage.InterfaceC3588op
    public final List<Rect> invoke() {
        return this.$measuredPlaceholderPositions.getValue();
    }
}
