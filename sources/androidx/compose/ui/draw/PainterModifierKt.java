package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import defpackage.AbstractC4492zt;
import org.apache.poi.ss.util.CellUtil;

/* JADX INFO: loaded from: classes.dex */
public final class PainterModifierKt {
    public static final Modifier paint(Modifier modifier, Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(painter, "painter");
        AbstractC4492zt.h(alignment, CellUtil.ALIGNMENT);
        AbstractC4492zt.h(contentScale, "contentScale");
        return modifier.then(new PainterElement(painter, z, alignment, contentScale, f, colorFilter));
    }

    public static /* synthetic */ Modifier paint$default(Modifier modifier, Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Object obj) {
        boolean z2 = (i & 2) != 0 ? true : z;
        if ((i & 4) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        Alignment alignment2 = alignment;
        if ((i & 8) != 0) {
            contentScale = ContentScale.Companion.getInside();
        }
        ContentScale contentScale2 = contentScale;
        float f2 = (i & 16) != 0 ? 1.0f : f;
        if ((i & 32) != 0) {
            colorFilter = null;
        }
        return paint(modifier, painter, z2, alignment2, contentScale2, f2, colorFilter);
    }
}
