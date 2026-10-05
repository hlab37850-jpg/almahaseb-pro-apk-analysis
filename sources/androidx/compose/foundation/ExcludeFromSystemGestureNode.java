package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import defpackage.AbstractC0986Vd;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC3750qp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class ExcludeFromSystemGestureNode extends Modifier.Node implements GlobalPositionAwareModifierNode, CompositionLocalConsumerModifierNode {
    private InterfaceC3750qp exclusion;
    private Rect rect;

    public ExcludeFromSystemGestureNode(InterfaceC3750qp interfaceC3750qp) {
        this.exclusion = interfaceC3750qp;
    }

    private final Rect calcBounds(LayoutCoordinates layoutCoordinates, androidx.compose.ui.geometry.Rect rect) {
        LayoutCoordinates layoutCoordinatesFindRoot = findRoot(layoutCoordinates);
        long jMo4167localPositionOfR5De75A = layoutCoordinatesFindRoot.mo4167localPositionOfR5De75A(layoutCoordinates, rect.m2833getTopLeftF1C5BW0());
        long jMo4167localPositionOfR5De75A2 = layoutCoordinatesFindRoot.mo4167localPositionOfR5De75A(layoutCoordinates, rect.m2834getTopRightF1C5BW0());
        long jMo4167localPositionOfR5De75A3 = layoutCoordinatesFindRoot.mo4167localPositionOfR5De75A(layoutCoordinates, rect.m2826getBottomLeftF1C5BW0());
        long jMo4167localPositionOfR5De75A4 = layoutCoordinatesFindRoot.mo4167localPositionOfR5De75A(layoutCoordinates, rect.m2827getBottomRightF1C5BW0());
        return new Rect(AbstractC1210aB.c(AbstractC0986Vd.i(Offset.m2798getXimpl(jMo4167localPositionOfR5De75A), Offset.m2798getXimpl(jMo4167localPositionOfR5De75A2), Offset.m2798getXimpl(jMo4167localPositionOfR5De75A3), Offset.m2798getXimpl(jMo4167localPositionOfR5De75A4))), AbstractC1210aB.c(AbstractC0986Vd.i(Offset.m2799getYimpl(jMo4167localPositionOfR5De75A), Offset.m2799getYimpl(jMo4167localPositionOfR5De75A2), Offset.m2799getYimpl(jMo4167localPositionOfR5De75A3), Offset.m2799getYimpl(jMo4167localPositionOfR5De75A4))), AbstractC1210aB.c(AbstractC0986Vd.g(Offset.m2798getXimpl(jMo4167localPositionOfR5De75A), Offset.m2798getXimpl(jMo4167localPositionOfR5De75A2), Offset.m2798getXimpl(jMo4167localPositionOfR5De75A3), Offset.m2798getXimpl(jMo4167localPositionOfR5De75A4))), AbstractC1210aB.c(AbstractC0986Vd.g(Offset.m2799getYimpl(jMo4167localPositionOfR5De75A), Offset.m2799getYimpl(jMo4167localPositionOfR5De75A2), Offset.m2799getYimpl(jMo4167localPositionOfR5De75A3), Offset.m2799getYimpl(jMo4167localPositionOfR5De75A4))));
    }

    private final LayoutCoordinates findRoot(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates2 = parentLayoutCoordinates;
            LayoutCoordinates layoutCoordinates3 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates2;
            if (layoutCoordinates == null) {
                return layoutCoordinates3;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
    }

    private final View getView() {
        return (View) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, AndroidCompositionLocals_androidKt.getLocalView());
    }

    public final InterfaceC3750qp getExclusion() {
        return this.exclusion;
    }

    public final Rect getRect() {
        return this.rect;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        replaceRect(null);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        Rect rectCalcBounds;
        AbstractC4492zt.h(layoutCoordinates, "coordinates");
        InterfaceC3750qp interfaceC3750qp = this.exclusion;
        if (interfaceC3750qp == null) {
            androidx.compose.ui.geometry.Rect rectBoundsInRoot = LayoutCoordinatesKt.boundsInRoot(layoutCoordinates);
            rectCalcBounds = new Rect(AbstractC1210aB.c(rectBoundsInRoot.getLeft()), AbstractC1210aB.c(rectBoundsInRoot.getTop()), AbstractC1210aB.c(rectBoundsInRoot.getRight()), AbstractC1210aB.c(rectBoundsInRoot.getBottom()));
        } else {
            AbstractC4492zt.e(interfaceC3750qp);
            rectCalcBounds = calcBounds(layoutCoordinates, (androidx.compose.ui.geometry.Rect) interfaceC3750qp.invoke(layoutCoordinates));
        }
        replaceRect(rectCalcBounds);
    }

    public final void replaceRect(Rect rect) {
        MutableVector mutableVector = new MutableVector(new Rect[16], 0);
        List systemGestureExclusionRects = getView().getSystemGestureExclusionRects();
        AbstractC4492zt.g(systemGestureExclusionRects, "view.systemGestureExclusionRects");
        mutableVector.addAll(mutableVector.getSize(), systemGestureExclusionRects);
        Rect rect2 = this.rect;
        if (rect2 != null) {
            mutableVector.remove(rect2);
        }
        if (rect != null && !rect.isEmpty()) {
            mutableVector.add(rect);
        }
        getView().setSystemGestureExclusionRects(mutableVector.asMutableList());
        this.rect = rect;
    }

    public final void setExclusion(InterfaceC3750qp interfaceC3750qp) {
        this.exclusion = interfaceC3750qp;
    }

    public final void setRect(Rect rect) {
        this.rect = rect;
    }
}
