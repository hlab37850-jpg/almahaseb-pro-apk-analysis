package androidx.compose.material.pullrefresh;

import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class PullRefreshIndicatorTransformKt {
    @ExperimentalMaterialApi
    public static final Modifier pullRefreshIndicatorTransform(Modifier modifier, PullRefreshState pullRefreshState, boolean z) {
        AbstractC4492zt.h(modifier, "<this>");
        AbstractC4492zt.h(pullRefreshState, "state");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$$inlined$debugInspectorInfo$1(pullRefreshState, z) : InspectableValueKt.getNoInspectorInfo(), GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent(Modifier.Companion, PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$1.INSTANCE), new PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$2(pullRefreshState, z)));
    }

    public static /* synthetic */ Modifier pullRefreshIndicatorTransform$default(Modifier modifier, PullRefreshState pullRefreshState, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pullRefreshIndicatorTransform(modifier, pullRefreshState, z);
    }
}
