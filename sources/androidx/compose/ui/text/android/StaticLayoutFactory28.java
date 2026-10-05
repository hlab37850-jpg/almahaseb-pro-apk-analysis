package androidx.compose.ui.text.android;

import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
final class StaticLayoutFactory28 {
    public static final StaticLayoutFactory28 INSTANCE = new StaticLayoutFactory28();

    private StaticLayoutFactory28() {
    }

    @DoNotInline
    public static final void setUseLineSpacingFromFallbacks(StaticLayout.Builder builder, boolean z) {
        AbstractC4492zt.h(builder, "builder");
        builder.setUseLineSpacingFromFallbacks(z);
    }
}
