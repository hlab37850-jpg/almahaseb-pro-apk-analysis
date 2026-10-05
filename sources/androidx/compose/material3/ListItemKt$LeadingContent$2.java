package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import defpackage.AbstractC2233fv;
import defpackage.FW;
import defpackage.InterfaceC0526Fp;

/* JADX INFO: loaded from: classes.dex */
public final class ListItemKt$LeadingContent$2 extends AbstractC2233fv implements InterfaceC0526Fp {
    final /* synthetic */ int $$changed;
    final /* synthetic */ InterfaceC0526Fp $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ RowScope $this_LeadingContent;
    final /* synthetic */ boolean $topAlign;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListItemKt$LeadingContent$2(RowScope rowScope, long j, boolean z, InterfaceC0526Fp interfaceC0526Fp, int i) {
        super(2);
        this.$this_LeadingContent = rowScope;
        this.$contentColor = j;
        this.$topAlign = z;
        this.$content = interfaceC0526Fp;
        this.$$changed = i;
    }

    @Override // defpackage.InterfaceC0526Fp
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return FW.a;
    }

    public final void invoke(Composer composer, int i) {
        ListItemKt.m1622LeadingContent3IgeMak(this.$this_LeadingContent, this.$contentColor, this.$topAlign, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
