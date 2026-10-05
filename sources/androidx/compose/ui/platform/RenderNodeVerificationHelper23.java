package androidx.compose.ui.platform;

import android.view.RenderNode;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
final class RenderNodeVerificationHelper23 {
    public static final RenderNodeVerificationHelper23 INSTANCE = new RenderNodeVerificationHelper23();

    private RenderNodeVerificationHelper23() {
    }

    @DoNotInline
    public final void destroyDisplayListData(RenderNode renderNode) {
        AbstractC4492zt.h(renderNode, "renderNode");
        renderNode.destroyDisplayListData();
    }
}
