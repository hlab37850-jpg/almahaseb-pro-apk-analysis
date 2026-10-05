package androidx.compose.ui.node;

import androidx.compose.ui.layout.LayoutCoordinates;

/* JADX INFO: loaded from: classes.dex */
public interface LayoutAwareModifierNode extends DelegatableNode {
    void onPlaced(LayoutCoordinates layoutCoordinates);

    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    void mo222onRemeasuredozmzZPI(long j);
}
