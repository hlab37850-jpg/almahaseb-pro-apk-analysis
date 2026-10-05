package androidx.compose.ui.platform;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
final class ViewLayerVerificationHelper28 {
    public static final ViewLayerVerificationHelper28 INSTANCE = new ViewLayerVerificationHelper28();

    private ViewLayerVerificationHelper28() {
    }

    @DoNotInline
    public final void setOutlineAmbientShadowColor(View view, int i) {
        AbstractC4492zt.h(view, "view");
        view.setOutlineAmbientShadowColor(i);
    }

    @DoNotInline
    public final void setOutlineSpotShadowColor(View view, int i) {
        AbstractC4492zt.h(view, "view");
        view.setOutlineSpotShadowColor(i);
    }
}
