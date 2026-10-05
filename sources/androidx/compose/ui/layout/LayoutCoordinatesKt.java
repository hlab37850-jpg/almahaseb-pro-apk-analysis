package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC0986Vd;
import defpackage.AbstractC3184jv;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutCoordinatesKt {
    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        Rect rectC;
        AbstractC4492zt.h(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectC = AbstractC3184jv.c(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m5320getWidthimpl(layoutCoordinates.mo4166getSizeYbymL2g()), IntSize.m5319getHeightimpl(layoutCoordinates.mo4166getSizeYbymL2g())) : rectC;
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "<this>");
        return AbstractC3184jv.c(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "<this>");
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = findRootCoordinates(layoutCoordinates);
        Rect rectBoundsInRoot = boundsInRoot(layoutCoordinates);
        float fM5320getWidthimpl = IntSize.m5320getWidthimpl(layoutCoordinatesFindRootCoordinates.mo4166getSizeYbymL2g());
        float fM5319getHeightimpl = IntSize.m5319getHeightimpl(layoutCoordinatesFindRootCoordinates.mo4166getSizeYbymL2g());
        float fK = AbstractC3871sJ.k(rectBoundsInRoot.getLeft(), 0.0f, fM5320getWidthimpl);
        float fK2 = AbstractC3871sJ.k(rectBoundsInRoot.getTop(), 0.0f, fM5319getHeightimpl);
        float fK3 = AbstractC3871sJ.k(rectBoundsInRoot.getRight(), 0.0f, fM5320getWidthimpl);
        float fK4 = AbstractC3871sJ.k(rectBoundsInRoot.getBottom(), 0.0f, fM5319getHeightimpl);
        if (fK == fK3 || fK2 == fK4) {
            return Rect.Companion.getZero();
        }
        long jMo4169localToWindowMKHz9U = layoutCoordinatesFindRootCoordinates.mo4169localToWindowMKHz9U(OffsetKt.Offset(fK, fK2));
        long jMo4169localToWindowMKHz9U2 = layoutCoordinatesFindRootCoordinates.mo4169localToWindowMKHz9U(OffsetKt.Offset(fK3, fK2));
        long jMo4169localToWindowMKHz9U3 = layoutCoordinatesFindRootCoordinates.mo4169localToWindowMKHz9U(OffsetKt.Offset(fK3, fK4));
        long jMo4169localToWindowMKHz9U4 = layoutCoordinatesFindRootCoordinates.mo4169localToWindowMKHz9U(OffsetKt.Offset(fK, fK4));
        return new Rect(AbstractC0986Vd.i(Offset.m2798getXimpl(jMo4169localToWindowMKHz9U), Offset.m2798getXimpl(jMo4169localToWindowMKHz9U2), Offset.m2798getXimpl(jMo4169localToWindowMKHz9U4), Offset.m2798getXimpl(jMo4169localToWindowMKHz9U3)), AbstractC0986Vd.i(Offset.m2799getYimpl(jMo4169localToWindowMKHz9U), Offset.m2799getYimpl(jMo4169localToWindowMKHz9U2), Offset.m2799getYimpl(jMo4169localToWindowMKHz9U4), Offset.m2799getYimpl(jMo4169localToWindowMKHz9U3)), AbstractC0986Vd.g(Offset.m2798getXimpl(jMo4169localToWindowMKHz9U), Offset.m2798getXimpl(jMo4169localToWindowMKHz9U2), Offset.m2798getXimpl(jMo4169localToWindowMKHz9U4), Offset.m2798getXimpl(jMo4169localToWindowMKHz9U3)), AbstractC0986Vd.g(Offset.m2799getYimpl(jMo4169localToWindowMKHz9U), Offset.m2799getYimpl(jMo4169localToWindowMKHz9U2), Offset.m2799getYimpl(jMo4169localToWindowMKHz9U4), Offset.m2799getYimpl(jMo4169localToWindowMKHz9U3)));
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        AbstractC4492zt.h(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy$ui_release;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
        }
    }

    public static final long positionInParent(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo4167localPositionOfR5De75A(layoutCoordinates, Offset.Companion.m2814getZeroF1C5BW0()) : Offset.Companion.m2814getZeroF1C5BW0();
    }

    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "<this>");
        return layoutCoordinates.mo4168localToRootMKHz9U(Offset.Companion.m2814getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "<this>");
        return layoutCoordinates.mo4169localToWindowMKHz9U(Offset.Companion.m2814getZeroF1C5BW0());
    }
}
