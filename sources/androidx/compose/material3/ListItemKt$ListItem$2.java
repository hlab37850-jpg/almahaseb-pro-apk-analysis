package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ListItemKt$ListItem$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ ListItemColors $colors;
    final /* synthetic */ InterfaceC0526Fp $headlineContent;
    final /* synthetic */ InterfaceC0526Fp $leadingContent;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ InterfaceC0526Fp $overlineContent;
    final /* synthetic */ float $shadowElevation;
    final /* synthetic */ InterfaceC0526Fp $supportingContent;
    final /* synthetic */ float $tonalElevation;
    final /* synthetic */ InterfaceC0526Fp $trailingContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListItemKt$ListItem$2(InterfaceC0526Fp interfaceC0526Fp, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, InterfaceC0526Fp interfaceC0526Fp4, InterfaceC0526Fp interfaceC0526Fp5, ListItemColors listItemColors, float f, float f2, int i, int i2) {
        super(2);
        this.$headlineContent = interfaceC0526Fp;
        this.$modifier = modifier;
        this.$overlineContent = interfaceC0526Fp2;
        this.$supportingContent = interfaceC0526Fp3;
        this.$leadingContent = interfaceC0526Fp4;
        this.$trailingContent = interfaceC0526Fp5;
        this.$colors = listItemColors;
        this.$tonalElevation = f;
        this.$shadowElevation = f2;
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
        ListItemKt.m1623ListItemHXNGIdc(this.$headlineContent, this.$modifier, this.$overlineContent, this.$supportingContent, this.$leadingContent, this.$trailingContent, this.$colors, this.$tonalElevation, this.$shadowElevation, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
