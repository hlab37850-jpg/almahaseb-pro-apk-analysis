package androidx.compose.ui.text.font;

import androidx.compose.ui.util.MathHelpersKt;
import com.itextpdf.tool.xml.html.HTML;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class FontWeightKt {
    public static final FontWeight lerp(FontWeight fontWeight, FontWeight fontWeight2, float f) {
        AbstractC4492zt.h(fontWeight, HTML.Attribute.START);
        AbstractC4492zt.h(fontWeight2, "stop");
        return new FontWeight(AbstractC3871sJ.l(MathHelpersKt.lerp(fontWeight.getWeight(), fontWeight2.getWeight(), f), 1, 1000));
    }
}
