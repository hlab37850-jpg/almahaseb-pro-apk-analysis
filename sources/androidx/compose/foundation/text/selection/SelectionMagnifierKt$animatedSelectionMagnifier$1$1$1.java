package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC2233fv;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionMagnifierKt$animatedSelectionMagnifier$1$1$1 extends AbstractC2233fv implements InterfaceC3588op {
    final /* synthetic */ State<Offset> $animatedCenter$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectionMagnifierKt$animatedSelectionMagnifier$1$1$1(State<Offset> state) {
        super(0);
        this.$animatedCenter$delegate = state;
    }

    @Override // defpackage.InterfaceC3588op
    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.m2787boximpl(m905invokeF1C5BW0());
    }

    /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
    public final long m905invokeF1C5BW0() {
        return SelectionMagnifierKt.AnonymousClass1.invoke$lambda$0(this.$animatedCenter$delegate);
    }
}
