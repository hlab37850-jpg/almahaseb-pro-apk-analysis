package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.PopupPositionProvider;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;

/* JADX INFO: loaded from: classes.dex */
public final class TooltipKt$TooltipBox$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ float $elevation;
    final /* synthetic */ float $maxWidth;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ InterfaceC0526Fp $tooltipContent;
    final /* synthetic */ PopupPositionProvider $tooltipPositionProvider;
    final /* synthetic */ TooltipState $tooltipState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooltipKt$TooltipBox$2(InterfaceC0526Fp interfaceC0526Fp, PopupPositionProvider popupPositionProvider, Modifier modifier, Shape shape, TooltipState tooltipState, long j, float f, float f2, InterfaceC0552Gp interfaceC0552Gp, int i) {
        super(2);
        this.$tooltipContent = interfaceC0526Fp;
        this.$tooltipPositionProvider = popupPositionProvider;
        this.$modifier = modifier;
        this.$shape = shape;
        this.$tooltipState = tooltipState;
        this.$containerColor = j;
        this.$elevation = f;
        this.$maxWidth = f2;
        this.$content = interfaceC0552Gp;
        this.$$changed = i;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        TooltipKt.m2047TooltipBoxXDn_Kpo(this.$tooltipContent, this.$tooltipPositionProvider, this.$modifier, this.$shape, this.$tooltipState, this.$containerColor, this.$elevation, this.$maxWidth, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
