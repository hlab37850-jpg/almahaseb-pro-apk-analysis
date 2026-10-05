package androidx.compose.material;

import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4162vx;
import defpackage.FW;
import defpackage.InterfaceC3750qp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class DrawerKt$BottomDrawer$2$1$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ AnchoredDraggableState.AnchorChangedCallback<BottomDrawerValue> $anchorChangeCallback;
    final /* synthetic */ BottomDrawerState $drawerState;
    final /* synthetic */ float $fullHeight;
    final /* synthetic */ boolean $isLandscape;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawer$2$1$2(BottomDrawerState bottomDrawerState, AnchoredDraggableState.AnchorChangedCallback<BottomDrawerValue> anchorChangedCallback, float f, boolean z) {
        super(1);
        this.$drawerState = bottomDrawerState;
        this.$anchorChangeCallback = anchorChangedCallback;
        this.$fullHeight = f;
        this.$isLandscape = z;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1100invokeozmzZPI(((IntSize) obj).m5324unboximpl());
        return FW.a;
    }

    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final void m1100invokeozmzZPI(long j) {
        float fM5319getHeightimpl = IntSize.m5319getHeightimpl(j);
        float f = this.$fullHeight;
        boolean z = this.$isLandscape;
        Map mapC = AbstractC4162vx.c();
        mapC.put(BottomDrawerValue.Closed, Float.valueOf(f));
        float f2 = 0.5f * f;
        if (fM5319getHeightimpl > f2 || z) {
            mapC.put(BottomDrawerValue.Open, Float.valueOf(f2));
        }
        if (fM5319getHeightimpl > 0.0f) {
            mapC.put(BottomDrawerValue.Expanded, Float.valueOf(Math.max(0.0f, f - fM5319getHeightimpl)));
        }
        this.$drawerState.getAnchoredDraggableState$material_release().updateAnchors$material_release(AbstractC4162vx.b(mapC), this.$anchorChangeCallback);
    }
}
