package androidx.compose.material;

import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheet$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnchoredDraggableState.AnchorChangedCallback<BottomSheetValue> $anchorChangeCallback;
    final /* synthetic */ InterfaceC3750qp $calculateAnchors;
    final /* synthetic */ BottomSheetState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheet$1(BottomSheetState bottomSheetState, InterfaceC3750qp interfaceC3750qp, AnchoredDraggableState.AnchorChangedCallback<BottomSheetValue> anchorChangedCallback) {
        super(1);
        this.$state = bottomSheetState;
        this.$calculateAnchors = interfaceC3750qp;
        this.$anchorChangeCallback = anchorChangedCallback;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1011invokeozmzZPI(((IntSize) obj).m5324unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final void m1011invokeozmzZPI(long j) {
        this.$state.getAnchoredDraggableState$material_release().updateAnchors$material_release((Map) this.$calculateAnchors.invoke(IntSize.m5312boximpl(j)), this.$anchorChangeCallback);
    }
}
