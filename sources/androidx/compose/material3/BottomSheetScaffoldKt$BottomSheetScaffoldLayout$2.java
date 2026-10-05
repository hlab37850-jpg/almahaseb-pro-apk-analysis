package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ InterfaceC0552Gp $body;
    final /* synthetic */ InterfaceC0552Gp $bottomSheet;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ InterfaceC3588op $sheetOffset;
    final /* synthetic */ float $sheetPeekHeight;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ InterfaceC0526Fp $snackbarHost;
    final /* synthetic */ InterfaceC0526Fp $topBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2(Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0552Gp interfaceC0552Gp, InterfaceC0552Gp interfaceC0552Gp2, InterfaceC0526Fp interfaceC0526Fp2, float f, InterfaceC3588op interfaceC3588op, SheetState sheetState, long j, long j2, int i) {
        super(2);
        this.$modifier = modifier;
        this.$topBar = interfaceC0526Fp;
        this.$body = interfaceC0552Gp;
        this.$bottomSheet = interfaceC0552Gp2;
        this.$snackbarHost = interfaceC0526Fp2;
        this.$sheetPeekHeight = f;
        this.$sheetOffset = interfaceC3588op;
        this.$sheetState = sheetState;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$$changed = i;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        BottomSheetScaffoldKt.m1350BottomSheetScaffoldLayoutPxNyym8(this.$modifier, this.$topBar, this.$body, this.$bottomSheet, this.$snackbarHost, this.$sheetPeekHeight, this.$sheetOffset, this.$sheetState, this.$containerColor, this.$contentColor, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
