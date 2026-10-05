package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ListItemKt$OffsetToBaselineOrCenter$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ InterfaceC0526Fp $content;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $offset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListItemKt$OffsetToBaselineOrCenter$2(float f, Modifier modifier, InterfaceC0526Fp interfaceC0526Fp, int i, int i2) {
        super(2);
        this.$offset = f;
        this.$modifier = modifier;
        this.$content = interfaceC0526Fp;
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
        ListItemKt.m1142OffsetToBaselineOrCenterKz89ssw(this.$offset, this.$modifier, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
