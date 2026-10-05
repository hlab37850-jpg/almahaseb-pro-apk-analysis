package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ListItemKt$ListItem$decoratedHeadlineContent$1 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ ListItemColors $colors;
    final /* synthetic */ InterfaceC0526Fp $headlineContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListItemKt$ListItem$decoratedHeadlineContent$1(ListItemColors listItemColors, int i, InterfaceC0526Fp interfaceC0526Fp) {
        super(2);
        this.$colors = listItemColors;
        this.$$dirty = i;
        this.$headlineContent = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    @Composable
    public final void invoke(Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-403249643, i, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:84)");
        }
        ListItemKt.m1625ProvideTextStyleFromToken3JVO9M(this.$colors.headlineColor$material3_release(true, composer, ((this.$$dirty >> 15) & 112) | 6).getValue().m3042unboximpl(), ListTokens.INSTANCE.getListItemLabelTextFont(), this.$headlineContent, composer, ((this.$$dirty << 6) & 896) | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
