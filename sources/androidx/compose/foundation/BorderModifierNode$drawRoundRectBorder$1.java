package androidx.compose.foundation;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.Stroke;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BorderModifierNode$drawRoundRectBorder$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ long $borderSize;
    final /* synthetic */ Stroke $borderStroke;
    final /* synthetic */ Brush $brush;
    final /* synthetic */ long $cornerRadius;
    final /* synthetic */ boolean $fillArea;
    final /* synthetic */ float $halfStroke;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ long $topLeft;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderModifierNode$drawRoundRectBorder$1(boolean z, Brush brush, long j, float f, float f2, long j2, long j3, Stroke stroke) {
        super(1);
        this.$fillArea = z;
        this.$brush = brush;
        this.$cornerRadius = j;
        this.$halfStroke = f;
        this.$strokeWidth = f2;
        this.$topLeft = j2;
        this.$borderSize = j3;
        this.$borderStroke = stroke;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return FW.a;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        AbstractC4492zt.h(contentDrawScope, "$this$onDrawWithContent");
        contentDrawScope.drawContent();
        if (this.$fillArea) {
            AbstractC3255kk.L(contentDrawScope, this.$brush, 0L, 0L, this.$cornerRadius, 0.0f, null, null, 0, 246, null);
            return;
        }
        float fM2773getXimpl = CornerRadius.m2773getXimpl(this.$cornerRadius);
        float f = this.$halfStroke;
        if (fM2773getXimpl >= f) {
            AbstractC3255kk.L(contentDrawScope, this.$brush, this.$topLeft, this.$borderSize, BorderKt.m182shrinkKibmq7A(this.$cornerRadius, f), 0.0f, this.$borderStroke, null, 0, 208, null);
            return;
        }
        float f2 = this.$strokeWidth;
        float fM2867getWidthimpl = Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()) - this.$strokeWidth;
        float fM2864getHeightimpl = Size.m2864getHeightimpl(contentDrawScope.mo3469getSizeNHjbRc()) - this.$strokeWidth;
        int iM3020getDifferencertfAjoo = ClipOp.Companion.m3020getDifferencertfAjoo();
        Brush brush = this.$brush;
        long j = this.$cornerRadius;
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3478clipRectN_I0leg(f2, f2, fM2867getWidthimpl, fM2864getHeightimpl, iM3020getDifferencertfAjoo);
        AbstractC3255kk.L(contentDrawScope, brush, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }
}
