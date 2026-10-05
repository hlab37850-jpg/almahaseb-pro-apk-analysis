package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class SemanticsNodeWithAdjustedBounds {
    private final Rect adjustedBounds;
    private final SemanticsNode semanticsNode;

    public SemanticsNodeWithAdjustedBounds(SemanticsNode semanticsNode, Rect rect) {
        AbstractC4492zt.h(semanticsNode, "semanticsNode");
        AbstractC4492zt.h(rect, "adjustedBounds");
        this.semanticsNode = semanticsNode;
        this.adjustedBounds = rect;
    }

    public final Rect getAdjustedBounds() {
        return this.adjustedBounds;
    }

    public final SemanticsNode getSemanticsNode() {
        return this.semanticsNode;
    }
}
