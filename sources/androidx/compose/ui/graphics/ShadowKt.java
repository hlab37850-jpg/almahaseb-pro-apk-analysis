package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class ShadowKt {
    @Stable
    public static final Shadow lerp(Shadow shadow, Shadow shadow2, float f) {
        AbstractC4492zt.h(shadow, HTML.Attribute.START);
        AbstractC4492zt.h(shadow2, "stop");
        return new Shadow(ColorKt.m3083lerpjxsXWHM(shadow.m3328getColor0d7_KjU(), shadow2.m3328getColor0d7_KjU(), f), OffsetKt.m2821lerpWko1d7g(shadow.m3329getOffsetF1C5BW0(), shadow2.m3329getOffsetF1C5BW0(), f), MathHelpersKt.lerp(shadow.getBlurRadius(), shadow2.getBlurRadius(), f), null);
    }
}
