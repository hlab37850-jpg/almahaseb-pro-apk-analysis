package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class ClipKt {
    @Stable
    public static final Modifier clip(Modifier modifier, Shape shape) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(shape, "shape");
        return GraphicsLayerModifierKt.m3188graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, shape, true, null, 0L, 0L, 0, 124927, null);
    }

    @Stable
    public static final Modifier clipToBounds(Modifier modifier) {
        AbstractC4492zt.h(modifier, "<this>");
        return GraphicsLayerModifierKt.m3188graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, true, null, 0L, 0L, 0, 126975, null);
    }
}
