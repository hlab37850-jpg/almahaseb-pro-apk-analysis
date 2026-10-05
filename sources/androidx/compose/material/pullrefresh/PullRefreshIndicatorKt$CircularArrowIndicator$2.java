package androidx.compose.material.pullrefresh;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import com.google.android.material.internal.ViewUtils;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3255kk;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class PullRefreshIndicatorKt$CircularArrowIndicator$2 extends AbstractC2233fv implements InterfaceC3750qp {
    final /* synthetic */ State<Float> $alphaState;
    final /* synthetic */ long $color;
    final /* synthetic */ Path $path;
    final /* synthetic */ PullRefreshState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullRefreshIndicatorKt$CircularArrowIndicator$2(PullRefreshState pullRefreshState, State<Float> state, long j, Path path) {
        super(1);
        this.$state = pullRefreshState;
        this.$alphaState = state;
        this.$color = j;
        this.$path = path;
    }

    @Override // defpackage.InterfaceC3750qp
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return FW.a;
    }

    public final void invoke(DrawScope drawScope) {
        AbstractC4492zt.h(drawScope, "$this$Canvas");
        ArrowValues ArrowValues = PullRefreshIndicatorKt.ArrowValues(this.$state.getProgress());
        float fFloatValue = this.$alphaState.getValue().floatValue();
        float rotation = ArrowValues.getRotation();
        long j = this.$color;
        Path path = this.$path;
        long jMo3468getCenterF1C5BW0 = drawScope.mo3468getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3481rotateUv8p0NA(rotation, jMo3468getCenterF1C5BW0);
        float fMo333toPx0680j_4 = drawScope.mo333toPx0680j_4(PullRefreshIndicatorKt.ArcRadius) + (drawScope.mo333toPx0680j_4(PullRefreshIndicatorKt.StrokeWidth) / 2.0f);
        Rect rect = new Rect(Offset.m2798getXimpl(SizeKt.m2877getCenteruvyYCjk(drawScope.mo3469getSizeNHjbRc())) - fMo333toPx0680j_4, Offset.m2799getYimpl(SizeKt.m2877getCenteruvyYCjk(drawScope.mo3469getSizeNHjbRc())) - fMo333toPx0680j_4, Offset.m2798getXimpl(SizeKt.m2877getCenteruvyYCjk(drawScope.mo3469getSizeNHjbRc())) + fMo333toPx0680j_4, Offset.m2799getYimpl(SizeKt.m2877getCenteruvyYCjk(drawScope.mo3469getSizeNHjbRc())) + fMo333toPx0680j_4);
        AbstractC3255kk.v(drawScope, j, ArrowValues.getStartAngle(), ArrowValues.getEndAngle() - ArrowValues.getStartAngle(), false, rect.m2833getTopLeftF1C5BW0(), rect.m2831getSizeNHjbRc(), fFloatValue, new Stroke(drawScope.mo333toPx0680j_4(PullRefreshIndicatorKt.StrokeWidth), 0.0f, StrokeCap.Companion.m3358getSquareKaPHkGw(), 0, null, 26, null), null, 0, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
        PullRefreshIndicatorKt.m1306drawArrowBx497Mc(drawScope, path, rect, j, fFloatValue, ArrowValues);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }
}
