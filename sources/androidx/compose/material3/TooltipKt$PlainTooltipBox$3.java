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
public final class TooltipKt$PlainTooltipBox$3 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ InterfaceC0526Fp $tooltip;
    final /* synthetic */ PlainTooltipState $tooltipState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooltipKt$PlainTooltipBox$3(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, PlainTooltipState plainTooltipState, Shape shape, long j, long j2, InterfaceC0552Gp interfaceC0552Gp, int i, int i2) {
        super(2);
        this.$tooltip = interfaceC0526Fp;
        this.$modifier = modifier;
        this.$tooltipState = plainTooltipState;
        this.$shape = shape;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$content = interfaceC0552Gp;
        this.$$changed = i;
        this.$$default = i2;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        TooltipKt.m2045PlainTooltipBoxnBX6wN0(this.$tooltip, this.$modifier, this.$tooltipState, this.$shape, this.$containerColor, this.$contentColor, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
