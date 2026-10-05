package androidx.compose.foundation.relocation;

import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import defpackage.AbstractC4492zt;
import defpackage.FW;
import defpackage.InterfaceC0793Of;
import defpackage.InterfaceC3588op;

/* JADX INFO: loaded from: classes.dex */
public final class BringIntoViewResponder_androidKt {
    public static final BringIntoViewParent defaultBringIntoViewParent(final CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode) {
        AbstractC4492zt.h(compositionLocalConsumerModifierNode, "<this>");
        return new BringIntoViewParent() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponder_androidKt.defaultBringIntoViewParent.1
            @Override // androidx.compose.foundation.relocation.BringIntoViewParent
            public final Object bringChildIntoView(LayoutCoordinates layoutCoordinates, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) {
                View view = (View) CompositionLocalConsumerModifierNodeKt.currentValueOf(compositionLocalConsumerModifierNode, AndroidCompositionLocals_androidKt.getLocalView());
                long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(layoutCoordinates);
                Rect rect = (Rect) interfaceC3588op.invoke();
                Rect rectM2835translatek4lQ0M = rect != null ? rect.m2835translatek4lQ0M(jPositionInRoot) : null;
                if (rectM2835translatek4lQ0M != null) {
                    view.requestRectangleOnScreen(BringIntoViewResponder_androidKt.toRect(rectM2835translatek4lQ0M), false);
                }
                return FW.a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.graphics.Rect toRect(Rect rect) {
        return new android.graphics.Rect((int) rect.getLeft(), (int) rect.getTop(), (int) rect.getRight(), (int) rect.getBottom());
    }
}
