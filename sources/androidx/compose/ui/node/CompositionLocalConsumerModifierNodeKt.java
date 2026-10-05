package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocal;
import com.google.android.gms.common.internal.ImagesContract;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class CompositionLocalConsumerModifierNodeKt {
    public static final <T> T currentValueOf(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode, CompositionLocal<T> compositionLocal) {
        AbstractC4492zt.h(compositionLocalConsumerModifierNode, "<this>");
        AbstractC4492zt.h(compositionLocal, ImagesContract.LOCAL);
        if (compositionLocalConsumerModifierNode.getNode().isAttached()) {
            return (T) DelegatableNodeKt.requireLayoutNode(compositionLocalConsumerModifierNode).getCompositionLocalMap().get(compositionLocal);
        }
        throw new IllegalStateException("Cannot read CompositionLocal because the Modifier node is not currently attached.");
    }
}
