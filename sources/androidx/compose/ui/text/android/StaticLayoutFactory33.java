package androidx.compose.ui.text.android;

import android.graphics.text.LineBreakConfig;
import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC1793bS;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(33)
final class StaticLayoutFactory33 {
    public static final StaticLayoutFactory33 INSTANCE = new StaticLayoutFactory33();

    private StaticLayoutFactory33() {
    }

    @DoNotInline
    public static final boolean isFallbackLineSpacingEnabled(StaticLayout staticLayout) {
        AbstractC4492zt.h(staticLayout, "layout");
        return staticLayout.isFallbackLineSpacingEnabled();
    }

    @DoNotInline
    public static final void setLineBreakConfig(StaticLayout.Builder builder, int i, int i2) {
        AbstractC4492zt.h(builder, "builder");
        LineBreakConfig lineBreakConfigBuild = AbstractC1793bS.a().setLineBreakStyle(i).setLineBreakWordStyle(i2).build();
        AbstractC4492zt.g(lineBreakConfigBuild, "Builder()\n              …\n                .build()");
        builder.setLineBreakConfig(lineBreakConfigBuild);
    }
}
