package androidx.compose.material.icons;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;

/* JADX INFO: loaded from: classes.dex */
public final class IconsKt {
    public static final float MaterialIconDimension = 24.0f;

    public static /* synthetic */ void getMaterialIconDimension$annotations() {
    }

    public static final ImageVector materialIcon(String str, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        return ((ImageVector.Builder) interfaceC3750qp.invoke(new ImageVector.Builder(str, Dp.m5160constructorimpl(24.0f), Dp.m5160constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 224, null))).build();
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI, reason: not valid java name */
    public static final ImageVector.Builder m1292materialPathYwgOQQI(ImageVector.Builder builder, float f, float f2, int i, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(builder, "$this$materialPath");
        AbstractC4492zt.h(interfaceC3750qp, "pathBuilder");
        SolidColor solidColor = new SolidColor(Color.Companion.m3058getBlack0d7_KjU(), null);
        int iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
        int iM3366getBevelLxFBmk8 = StrokeJoin.Companion.m3366getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        interfaceC3750qp.invoke(pathBuilder);
        return ImageVector.Builder.m3574addPathoIyEayM$default(builder, pathBuilder.getNodes(), i, "", solidColor, f, null, f2, 1.0f, iM3356getButtKaPHkGw, iM3366getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI$default, reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m1293materialPathYwgOQQI$default(ImageVector.Builder builder, float f, float f2, int i, InterfaceC3750qp interfaceC3750qp, int i2, Object obj) {
        float f3 = (i2 & 1) != 0 ? 1.0f : f;
        float f4 = (i2 & 2) != 0 ? 1.0f : f2;
        int defaultFillType = (i2 & 4) != 0 ? VectorKt.getDefaultFillType() : i;
        AbstractC4492zt.h(builder, "$this$materialPath");
        AbstractC4492zt.h(interfaceC3750qp, "pathBuilder");
        SolidColor solidColor = new SolidColor(Color.Companion.m3058getBlack0d7_KjU(), null);
        int iM3356getButtKaPHkGw = StrokeCap.Companion.m3356getButtKaPHkGw();
        int iM3366getBevelLxFBmk8 = StrokeJoin.Companion.m3366getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        interfaceC3750qp.invoke(pathBuilder);
        return ImageVector.Builder.m3574addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, f3, null, f4, 1.0f, iM3356getButtKaPHkGw, iM3366getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }
}
