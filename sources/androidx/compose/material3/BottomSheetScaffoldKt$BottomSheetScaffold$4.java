package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheetScaffold$4 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ long $sheetContainerColor;
    final /* synthetic */ InterfaceC0552Gp $sheetContent;
    final /* synthetic */ long $sheetContentColor;
    final /* synthetic */ InterfaceC0526Fp $sheetDragHandle;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ float $sheetShadowElevation;
    final /* synthetic */ Shape $sheetShape;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ float $sheetTonalElevation;
    final /* synthetic */ InterfaceC0552Gp $snackbarHost;
    final /* synthetic */ InterfaceC0526Fp $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffold$4(InterfaceC0552Gp interfaceC0552Gp, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, float f, Shape shape, long j, long j2, float f2, float f3, InterfaceC0526Fp interfaceC0526Fp, boolean z, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0552Gp interfaceC0552Gp2, long j3, long j4, InterfaceC0552Gp interfaceC0552Gp3, int i, int i2, int i3) {
        super(2);
        this.$sheetContent = interfaceC0552Gp;
        this.$modifier = modifier;
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$sheetPeekHeight = f;
        this.$sheetShape = shape;
        this.$sheetContainerColor = j;
        this.$sheetContentColor = j2;
        this.$sheetTonalElevation = f2;
        this.$sheetShadowElevation = f3;
        this.$sheetDragHandle = interfaceC0526Fp;
        this.$sheetSwipeEnabled = z;
        this.$topBar = interfaceC0526Fp2;
        this.$snackbarHost = interfaceC0552Gp2;
        this.$containerColor = j3;
        this.$contentColor = j4;
        this.$content = interfaceC0552Gp3;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        BottomSheetScaffoldKt.m1349BottomSheetScaffold6cEcpDs(this.$sheetContent, this.$modifier, this.$scaffoldState, this.$sheetPeekHeight, this.$sheetShape, this.$sheetContainerColor, this.$sheetContentColor, this.$sheetTonalElevation, this.$sheetShadowElevation, this.$sheetDragHandle, this.$sheetSwipeEnabled, this.$topBar, this.$snackbarHost, this.$containerColor, this.$contentColor, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
