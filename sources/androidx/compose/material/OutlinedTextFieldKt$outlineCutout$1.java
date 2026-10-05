package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.unit.LayoutDirection;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class OutlinedTextFieldKt$outlineCutout$1 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ long $labelSize;
    final /* synthetic */ PaddingValues $paddingValues;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldKt$outlineCutout$1(long j, PaddingValues paddingValues) {
        super(1);
        this.$labelSize = j;
        this.$paddingValues = paddingValues;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return FW.a;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        AbstractC4492zt.h(contentDrawScope, "$this$drawWithContent");
        float fM2867getWidthimpl = Size.m2867getWidthimpl(this.$labelSize);
        if (fM2867getWidthimpl <= 0.0f) {
            contentDrawScope.drawContent();
            return;
        }
        float fMo333toPx0680j_4 = contentDrawScope.mo333toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
        float fMo333toPx0680j_5 = contentDrawScope.mo333toPx0680j_4(this.$paddingValues.mo436calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection())) - fMo333toPx0680j_4;
        float f = 2;
        float fM2867getWidthimpl2 = fM2867getWidthimpl + fMo333toPx0680j_5 + (fMo333toPx0680j_4 * f);
        LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        float fM2867getWidthimpl3 = iArr[layoutDirection.ordinal()] == 1 ? Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()) - fM2867getWidthimpl2 : AbstractC3871sJ.c(fMo333toPx0680j_5, 0.0f);
        if (iArr[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
            fM2867getWidthimpl2 = Size.m2867getWidthimpl(contentDrawScope.mo3469getSizeNHjbRc()) - AbstractC3871sJ.c(fMo333toPx0680j_5, 0.0f);
        }
        float f2 = fM2867getWidthimpl2;
        float fM2864getHeightimpl = Size.m2864getHeightimpl(this.$labelSize);
        float f3 = (-fM2864getHeightimpl) / f;
        float f4 = fM2864getHeightimpl / f;
        int iM3020getDifferencertfAjoo = ClipOp.Companion.m3020getDifferencertfAjoo();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3478clipRectN_I0leg(fM2867getWidthimpl3, f3, f2, f4, iM3020getDifferencertfAjoo);
        contentDrawScope.drawContent();
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }
}
