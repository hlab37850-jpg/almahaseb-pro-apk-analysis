package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BorderModifierNode$drawRoundRectBorder$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ Brush $brush;
    final /* synthetic */ Path $roundedRectPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderModifierNode$drawRoundRectBorder$2(Path path, Brush brush) {
        super(1);
        this.$roundedRectPath = path;
        this.$brush = brush;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return FW.a;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        AbstractC4492zt.h(contentDrawScope, "$this$onDrawWithContent");
        contentDrawScope.drawContent();
        AbstractC3255kk.F(contentDrawScope, this.$roundedRectPath, this.$brush, 0.0f, null, null, 0, 60, null);
    }
}
