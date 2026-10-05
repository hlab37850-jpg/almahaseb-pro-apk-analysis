package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class ScaleKt {
    @Stable
    public static final Modifier scale(Modifier modifier, float f, float f2) {
        AbstractC4492zt.h(modifier, "<this>");
        return (f == 1.0f && f2 == 1.0f) ? modifier : GraphicsLayerModifierKt.m3188graphicsLayerAp8cVGQ$default(modifier, f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131068, null);
    }

    @Stable
    public static final Modifier scale(Modifier modifier, float f) {
        AbstractC4492zt.h(modifier, "<this>");
        return scale(modifier, f, f);
    }
}
