package androidx.compose.ui.platform;

import android.view.RenderNode;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
final class RenderNodeVerificationHelper28 {
    public static final RenderNodeVerificationHelper28 INSTANCE = new RenderNodeVerificationHelper28();

    private RenderNodeVerificationHelper28() {
    }

    @DoNotInline
    public final int getAmbientShadowColor(RenderNode renderNode) {
        AbstractC4492zt.h(renderNode, "renderNode");
        return renderNode.getAmbientShadowColor();
    }

    @DoNotInline
    public final int getSpotShadowColor(RenderNode renderNode) {
        AbstractC4492zt.h(renderNode, "renderNode");
        return renderNode.getSpotShadowColor();
    }

    @DoNotInline
    public final void setAmbientShadowColor(RenderNode renderNode, int i) {
        AbstractC4492zt.h(renderNode, "renderNode");
        renderNode.setAmbientShadowColor(i);
    }

    @DoNotInline
    public final void setSpotShadowColor(RenderNode renderNode, int i) {
        AbstractC4492zt.h(renderNode, "renderNode");
        renderNode.setSpotShadowColor(i);
    }
}
