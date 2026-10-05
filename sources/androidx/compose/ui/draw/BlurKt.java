package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class BlurKt {
    @Stable
    /* JADX INFO: renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m2686blur1fqSgw(Modifier modifier, float f, float f2, Shape shape) {
        int iM3377getDecal3opZhB0;
        boolean z;
        AbstractC4492zt.h(modifier, "$this$blur");
        if (shape != null) {
            iM3377getDecal3opZhB0 = TileMode.Companion.m3376getClamp3opZhB0();
            z = true;
        } else {
            iM3377getDecal3opZhB0 = TileMode.Companion.m3377getDecal3opZhB0();
            z = false;
        }
        float f3 = 0;
        return ((Dp.m5159compareTo0680j_4(f, Dp.m5160constructorimpl(f3)) <= 0 || Dp.m5159compareTo0680j_4(f2, Dp.m5160constructorimpl(f3)) <= 0) && !z) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new BlurKt$blur$1(f, f2, iM3377getDecal3opZhB0, shape, z));
    }

    /* JADX INFO: renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2687blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2690boximpl(BlurredEdgeTreatment.Companion.m2697getRectangleGoahg());
        }
        return m2686blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m2696unboximpl());
    }

    @Stable
    /* JADX INFO: renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m2688blurF8QBwvs(Modifier modifier, float f, Shape shape) {
        AbstractC4492zt.h(modifier, "$this$blur");
        return m2686blur1fqSgw(modifier, f, f, shape);
    }

    /* JADX INFO: renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2689blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2690boximpl(BlurredEdgeTreatment.Companion.m2697getRectangleGoahg());
        }
        return m2688blurF8QBwvs(modifier, f, blurredEdgeTreatment.m2696unboximpl());
    }
}
