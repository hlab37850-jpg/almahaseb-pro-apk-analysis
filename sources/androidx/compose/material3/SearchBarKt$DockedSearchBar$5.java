package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC0552Gp;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class SearchBarKt$DockedSearchBar$5 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $active;
    final /* synthetic */ SearchBarColors $colors;
    final /* synthetic */ InterfaceC0552Gp $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ InterfaceC0526Fp $leadingIcon;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ InterfaceC3750qp $onActiveChange;
    final /* synthetic */ InterfaceC3750qp $onQueryChange;
    final /* synthetic */ InterfaceC3750qp $onSearch;
    final /* synthetic */ InterfaceC0526Fp $placeholder;
    final /* synthetic */ String $query;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $tonalElevation;
    final /* synthetic */ InterfaceC0526Fp $trailingIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBarKt$DockedSearchBar$5(String str, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2, boolean z, InterfaceC3750qp interfaceC3750qp3, Modifier modifier, boolean z2, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0526Fp interfaceC0526Fp2, InterfaceC0526Fp interfaceC0526Fp3, Shape shape, SearchBarColors searchBarColors, float f, MutableInteractionSource mutableInteractionSource, InterfaceC0552Gp interfaceC0552Gp, int i, int i2, int i3) {
        super(2);
        this.$query = str;
        this.$onQueryChange = interfaceC3750qp;
        this.$onSearch = interfaceC3750qp2;
        this.$active = z;
        this.$onActiveChange = interfaceC3750qp3;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$placeholder = interfaceC0526Fp;
        this.$leadingIcon = interfaceC0526Fp2;
        this.$trailingIcon = interfaceC0526Fp3;
        this.$shape = shape;
        this.$colors = searchBarColors;
        this.$tonalElevation = f;
        this.$interactionSource = mutableInteractionSource;
        this.$content = interfaceC0552Gp;
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
        SearchBarKt.m1736DockedSearchBarrpjkMjA(this.$query, this.$onQueryChange, this.$onSearch, this.$active, this.$onActiveChange, this.$modifier, this.$enabled, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$shape, this.$colors, this.$tonalElevation, this.$interactionSource, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
