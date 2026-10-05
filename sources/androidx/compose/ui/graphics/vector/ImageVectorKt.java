package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import com.itextpdf.tool.xml.css.CSS;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ImageVectorKt {
    public static final ImageVector.Builder group(ImageVector.Builder builder, String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(builder, "<this>");
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(list, "clipPathData");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        builder.addGroup(str, f, f2, f3, f4, f5, f6, f7, list);
        interfaceC3750qp.invoke(builder);
        builder.clearGroup();
        return builder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageVector.Builder group$default(ImageVector.Builder builder, String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, InterfaceC3750qp interfaceC3750qp, int i, Object obj) {
        String str2 = (i & 1) != 0 ? "" : str;
        float f8 = (i & 2) != 0 ? 0.0f : f;
        float f9 = (i & 4) != 0 ? 0.0f : f2;
        float f10 = (i & 8) != 0 ? 0.0f : f3;
        float f11 = (i & 16) != 0 ? 1.0f : f4;
        float f12 = (i & 32) == 0 ? f5 : 1.0f;
        float f13 = (i & 64) != 0 ? 0.0f : f6;
        float f14 = (i & 128) != 0 ? 0.0f : f7;
        List emptyPath = (i & 256) != 0 ? VectorKt.getEmptyPath() : list;
        AbstractC4492zt.h(builder, "<this>");
        AbstractC4492zt.h(str2, "name");
        AbstractC4492zt.h(emptyPath, "clipPathData");
        AbstractC4492zt.h(interfaceC3750qp, CSS.Value.BLOCK);
        builder.addGroup(str2, f8, f9, f10, f11, f12, f13, f14, emptyPath);
        interfaceC3750qp.invoke(builder);
        builder.clearGroup();
        return builder;
    }

    /* JADX INFO: renamed from: path-R_LF-3I, reason: not valid java name */
    public static final ImageVector.Builder m3576pathR_LF3I(ImageVector.Builder builder, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i, int i2, float f4, int i3, InterfaceC3750qp interfaceC3750qp) {
        AbstractC4492zt.h(builder, "$this$path");
        AbstractC4492zt.h(str, "name");
        AbstractC4492zt.h(interfaceC3750qp, "pathBuilder");
        PathBuilder pathBuilder = new PathBuilder();
        interfaceC3750qp.invoke(pathBuilder);
        return ImageVector.Builder.m3574addPathoIyEayM$default(builder, pathBuilder.getNodes(), i3, str, brush, f, brush2, f2, f3, i, i2, f4, 0.0f, 0.0f, 0.0f, 14336, null);
    }

    /* JADX INFO: renamed from: path-R_LF-3I$default, reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m3577pathR_LF3I$default(ImageVector.Builder builder, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i, int i2, float f4, int i3, InterfaceC3750qp interfaceC3750qp, int i4, Object obj) {
        String str2 = (i4 & 1) != 0 ? "" : str;
        Brush brush3 = (i4 & 2) != 0 ? null : brush;
        float f5 = (i4 & 4) != 0 ? 1.0f : f;
        Brush brush4 = (i4 & 8) != 0 ? null : brush2;
        float f6 = (i4 & 16) != 0 ? 1.0f : f2;
        float f7 = (i4 & 32) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i4 & 64) != 0 ? VectorKt.getDefaultStrokeLineCap() : i;
        int defaultStrokeLineJoin = (i4 & 128) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i2;
        float f8 = (i4 & 256) != 0 ? 4.0f : f4;
        int defaultFillType = (i4 & 512) != 0 ? VectorKt.getDefaultFillType() : i3;
        AbstractC4492zt.h(builder, "$this$path");
        AbstractC4492zt.h(str2, "name");
        AbstractC4492zt.h(interfaceC3750qp, "pathBuilder");
        PathBuilder pathBuilder = new PathBuilder();
        interfaceC3750qp.invoke(pathBuilder);
        return ImageVector.Builder.m3574addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, str2, brush3, f5, brush4, f6, f7, defaultStrokeLineCap, defaultStrokeLineJoin, f8, 0.0f, 0.0f, 0.0f, 14336, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T peek(ArrayList<T> arrayList) {
        return arrayList.get(arrayList.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T pop(ArrayList<T> arrayList) {
        return arrayList.remove(arrayList.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean push(ArrayList<T> arrayList, T t) {
        return arrayList.add(t);
    }
}
