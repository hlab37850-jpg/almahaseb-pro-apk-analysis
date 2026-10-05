package androidx.compose.ui.graphics;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class CanvasZHelper {
    public static final CanvasZHelper INSTANCE = new CanvasZHelper();

    private CanvasZHelper() {
    }

    @DoNotInline
    public final void enableZ(android.graphics.Canvas canvas, boolean z) {
        AbstractC4492zt.h(canvas, HTML.Tag.CANVAS);
        if (z) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }
}
