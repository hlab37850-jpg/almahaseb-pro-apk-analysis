package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.Dp;
import defpackage.AD;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class BorderModifierNode$drawWithCacheModifierNode$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ BorderModifierNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BorderModifierNode$drawWithCacheModifierNode$1(BorderModifierNode borderModifierNode) {
        super(1);
        this.this$0 = borderModifierNode;
    }

    @Override // defpackage.InterfaceC3750qp
    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
        AbstractC4492zt.h(cacheDrawScope, "$this$CacheDrawModifierNode");
        if (cacheDrawScope.mo333toPx0680j_4(this.this$0.m185getWidthD9Ej5fM()) < 0.0f || Size.m2866getMinDimensionimpl(cacheDrawScope.m2701getSizeNHjbRc()) <= 0.0f) {
            return BorderKt.drawContentWithoutBorder(cacheDrawScope);
        }
        float f = 2;
        float fMin = Math.min(Dp.m5165equalsimpl0(this.this$0.m185getWidthD9Ej5fM(), Dp.Companion.m5178getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.mo333toPx0680j_4(this.this$0.m185getWidthD9Ej5fM())), (float) Math.ceil(Size.m2866getMinDimensionimpl(cacheDrawScope.m2701getSizeNHjbRc()) / f));
        float f2 = fMin / f;
        long jOffset = OffsetKt.Offset(f2, f2);
        long jSize = SizeKt.Size(Size.m2867getWidthimpl(cacheDrawScope.m2701getSizeNHjbRc()) - fMin, Size.m2864getHeightimpl(cacheDrawScope.m2701getSizeNHjbRc()) - fMin);
        boolean z = f * fMin > Size.m2866getMinDimensionimpl(cacheDrawScope.m2701getSizeNHjbRc());
        Outline outlineMo216createOutlinePq9zytI = this.this$0.getShape().mo216createOutlinePq9zytI(cacheDrawScope.m2701getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        if (outlineMo216createOutlinePq9zytI instanceof Outline.Generic) {
            BorderModifierNode borderModifierNode = this.this$0;
            return borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.getBrush(), (Outline.Generic) outlineMo216createOutlinePq9zytI, z, fMin);
        }
        if (outlineMo216createOutlinePq9zytI instanceof Outline.Rounded) {
            BorderModifierNode borderModifierNode2 = this.this$0;
            return borderModifierNode2.m184drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode2.getBrush(), (Outline.Rounded) outlineMo216createOutlinePq9zytI, jOffset, jSize, z, fMin);
        }
        if (outlineMo216createOutlinePq9zytI instanceof Outline.Rectangle) {
            return BorderKt.m181drawRectBorderNsqcLGU(cacheDrawScope, this.this$0.getBrush(), jOffset, jSize, z, fMin);
        }
        throw new AD();
    }
}
