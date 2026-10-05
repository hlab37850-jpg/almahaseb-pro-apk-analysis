package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.core.os.BuildCompat;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
final class StaticLayoutFactory23 implements StaticLayoutFactoryImpl {
    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    @DoNotInline
    public StaticLayout create(StaticLayoutParams staticLayoutParams) {
        AbstractC4492zt.h(staticLayoutParams, "params");
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(staticLayoutParams.getText(), staticLayoutParams.getStart(), staticLayoutParams.getEnd(), staticLayoutParams.getPaint(), staticLayoutParams.getWidth());
        builderObtain.setTextDirection(staticLayoutParams.getTextDir());
        builderObtain.setAlignment(staticLayoutParams.getAlignment());
        builderObtain.setMaxLines(staticLayoutParams.getMaxLines());
        builderObtain.setEllipsize(staticLayoutParams.getEllipsize());
        builderObtain.setEllipsizedWidth(staticLayoutParams.getEllipsizedWidth());
        builderObtain.setLineSpacing(staticLayoutParams.getLineSpacingExtra(), staticLayoutParams.getLineSpacingMultiplier());
        builderObtain.setIncludePad(staticLayoutParams.getIncludePadding());
        builderObtain.setBreakStrategy(staticLayoutParams.getBreakStrategy());
        builderObtain.setHyphenationFrequency(staticLayoutParams.getHyphenationFrequency());
        builderObtain.setIndents(staticLayoutParams.getLeftIndents(), staticLayoutParams.getRightIndents());
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            AbstractC4492zt.g(builderObtain, "this");
            StaticLayoutFactory26.setJustificationMode(builderObtain, staticLayoutParams.getJustificationMode());
        }
        if (i >= 28) {
            AbstractC4492zt.g(builderObtain, "this");
            StaticLayoutFactory28.setUseLineSpacingFromFallbacks(builderObtain, staticLayoutParams.getUseFallbackLineSpacing());
        }
        if (i >= 33) {
            AbstractC4492zt.g(builderObtain, "this");
            StaticLayoutFactory33.setLineBreakConfig(builderObtain, staticLayoutParams.getLineBreakStyle(), staticLayoutParams.getLineBreakWordStyle());
        }
        StaticLayout staticLayoutBuild = builderObtain.build();
        AbstractC4492zt.g(staticLayoutBuild, "obtain(params.text, para…  }\n            }.build()");
        return staticLayoutBuild;
    }

    @Override // androidx.compose.ui.text.android.StaticLayoutFactoryImpl
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public boolean isFallbackLineSpacingEnabled(StaticLayout staticLayout, boolean z) {
        AbstractC4492zt.h(staticLayout, "layout");
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            return StaticLayoutFactory33.isFallbackLineSpacingEnabled(staticLayout);
        }
        if (i >= 28) {
            return z;
        }
        return false;
    }
}
