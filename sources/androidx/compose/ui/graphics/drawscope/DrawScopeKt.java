package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class DrawScopeKt {
    /* JADX INFO: renamed from: clipPath-KD09W0M, reason: not valid java name */
    public static final void m3535clipPathKD09W0M(DrawScope drawScope, Path path, int i, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "$this$clipPath");
        AbstractC4492zt.h(path, "path");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3477clipPathmtrdDE(path, i);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: clipPath-KD09W0M$default, reason: not valid java name */
    public static /* synthetic */ void m3536clipPathKD09W0M$default(DrawScope drawScope, Path path, int i, InterfaceC3750qp interfaceC3750qp, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m3021getIntersectrtfAjoo();
        }
        AbstractC4492zt.h(drawScope, "$this$clipPath");
        AbstractC4492zt.h(path, "path");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3477clipPathmtrdDE(path, i);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: clipRect-rOu3jXo, reason: not valid java name */
    public static final void m3537clipRectrOu3jXo(DrawScope drawScope, float f, float f2, float f3, float f4, int i, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "$this$clipRect");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3478clipRectN_I0leg(f, f2, f3, f4, i);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: clipRect-rOu3jXo$default, reason: not valid java name */
    public static /* synthetic */ void m3538clipRectrOu3jXo$default(DrawScope drawScope, float f, float f2, float f3, float f4, int i, InterfaceC3750qp interfaceC3750qp, int i2, Object obj) {
        float f5 = (i2 & 1) != 0 ? 0.0f : f;
        float f6 = (i2 & 2) != 0 ? 0.0f : f2;
        if ((i2 & 4) != 0) {
            f3 = Size.m2867getWidthimpl(drawScope.mo3469getSizeNHjbRc());
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = Size.m2864getHeightimpl(drawScope.mo3469getSizeNHjbRc());
        }
        float f8 = f4;
        if ((i2 & 16) != 0) {
            i = ClipOp.Companion.m3021getIntersectrtfAjoo();
        }
        AbstractC4492zt.h(drawScope, "$this$clipRect");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3478clipRectN_I0leg(f5, f6, f7, f8, i);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    public static final void drawIntoCanvas(DrawScope drawScope, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        interfaceC3750qp.invoke(drawScope.getDrawContext().getCanvas());
    }

    public static final void inset(DrawScope drawScope, float f, float f2, float f3, float f4, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        drawScope.getDrawContext().getTransform().inset(f, f2, f3, f4);
        interfaceC3750qp.invoke(drawScope);
        drawScope.getDrawContext().getTransform().inset(-f, -f2, -f3, -f4);
    }

    public static /* synthetic */ void inset$default(DrawScope drawScope, float f, float f2, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        AbstractC4492zt.h(drawScope, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        drawScope.getDrawContext().getTransform().inset(f, f2, f, f2);
        interfaceC3750qp.invoke(drawScope);
        float f3 = -f;
        float f4 = -f2;
        drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
    }

    /* JADX INFO: renamed from: rotate-Rg1IO4c, reason: not valid java name */
    public static final void m3539rotateRg1IO4c(DrawScope drawScope, float f, long j, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "$this$rotate");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3481rotateUv8p0NA(f, j);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: rotate-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m3540rotateRg1IO4c$default(DrawScope drawScope, float f, long j, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo3468getCenterF1C5BW0();
        }
        AbstractC4492zt.h(drawScope, "$this$rotate");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3481rotateUv8p0NA(f, j);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: rotateRad-Rg1IO4c, reason: not valid java name */
    public static final void m3541rotateRadRg1IO4c(DrawScope drawScope, float f, long j, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "$this$rotateRad");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3481rotateUv8p0NA(DegreesKt.degrees(f), j);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: rotateRad-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m3542rotateRadRg1IO4c$default(DrawScope drawScope, float f, long j, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo3468getCenterF1C5BW0();
        }
        AbstractC4492zt.h(drawScope, "$this$rotateRad");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3481rotateUv8p0NA(DegreesKt.degrees(f), j);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: scale-Fgt4K4Q, reason: not valid java name */
    public static final void m3543scaleFgt4K4Q(DrawScope drawScope, float f, float f2, long j, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "$this$scale");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3482scale0AR0LA0(f, f2, j);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: scale-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ void m3544scaleFgt4K4Q$default(DrawScope drawScope, float f, float f2, long j, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 4) != 0) {
            j = drawScope.mo3468getCenterF1C5BW0();
        }
        AbstractC4492zt.h(drawScope, "$this$scale");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3482scale0AR0LA0(f, f2, j);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: scale-Rg1IO4c, reason: not valid java name */
    public static final void m3545scaleRg1IO4c(DrawScope drawScope, float f, long j, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "$this$scale");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3482scale0AR0LA0(f, f, j);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    /* JADX INFO: renamed from: scale-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m3546scaleRg1IO4c$default(DrawScope drawScope, float f, long j, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo3468getCenterF1C5BW0();
        }
        AbstractC4492zt.h(drawScope, "$this$scale");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3482scale0AR0LA0(f, f, j);
        interfaceC3750qp.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    public static final void translate(DrawScope drawScope, float f, float f2, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        drawScope.getDrawContext().getTransform().translate(f, f2);
        interfaceC3750qp.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f, -f2);
    }

    public static /* synthetic */ void translate$default(DrawScope drawScope, float f, float f2, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        AbstractC4492zt.h(drawScope, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        drawScope.getDrawContext().getTransform().translate(f, f2);
        interfaceC3750qp.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f, -f2);
    }

    public static final void withTransform(DrawScope drawScope, InterfaceC3750qp interfaceC3750qp, InterfaceC3750qp interfaceC3750qp2) {
        AbstractC4492zt.h(drawScope, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, "transformBlock");
        AbstractC4492zt.h(interfaceC3750qp2, "drawBlock");
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo3475getSizeNHjbRc = drawContext.mo3475getSizeNHjbRc();
        drawContext.getCanvas().save();
        interfaceC3750qp.invoke(drawContext.getTransform());
        interfaceC3750qp2.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo3476setSizeuvyYCjk(jMo3475getSizeNHjbRc);
    }

    public static final void inset(DrawScope drawScope, float f, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        drawScope.getDrawContext().getTransform().inset(f, f, f, f);
        interfaceC3750qp.invoke(drawScope);
        float f2 = -f;
        drawScope.getDrawContext().getTransform().inset(f2, f2, f2, f2);
    }

    public static final void inset(DrawScope drawScope, float f, float f2, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(drawScope, "<this>");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        drawScope.getDrawContext().getTransform().inset(f, f2, f, f2);
        interfaceC3750qp.invoke(drawScope);
        float f3 = -f;
        float f4 = -f2;
        drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
    }
}
