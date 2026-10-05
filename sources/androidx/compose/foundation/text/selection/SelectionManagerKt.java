package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import defpackage.AD;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionManagerKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.SelectionStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.Cursor.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m937calculateSelectionMagnifierCenterAndroidO0kMr_c(SelectionManager selectionManager, long j) {
        AbstractC4492zt.h(selectionManager, "manager");
        Selection selection = selectionManager.getSelection();
        if (selection == null) {
            return Offset.Companion.m2813getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = selectionManager.getDraggingHandle();
        int i = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i == -1) {
            return Offset.Companion.m2813getUnspecifiedF1C5BW0();
        }
        if (i == 1) {
            return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(selectionManager, j, selection.getStart(), true);
        }
        if (i == 2) {
            return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(selectionManager, j, selection.getEnd(), false);
        }
        if (i != 3) {
            throw new AD();
        }
        throw new IllegalStateException("SelectionContainer does not support cursor");
    }

    private static final long calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(SelectionManager selectionManager, long j, Selection.AnchorInfo anchorInfo, boolean z) {
        Selectable anchorSelectable$foundation_release = selectionManager.getAnchorSelectable$foundation_release(anchorInfo);
        if (anchorSelectable$foundation_release == null) {
            return Offset.Companion.m2813getUnspecifiedF1C5BW0();
        }
        LayoutCoordinates containerLayoutCoordinates = selectionManager.getContainerLayoutCoordinates();
        if (containerLayoutCoordinates == null) {
            return Offset.Companion.m2813getUnspecifiedF1C5BW0();
        }
        LayoutCoordinates layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return Offset.Companion.m2813getUnspecifiedF1C5BW0();
        }
        int offset = anchorInfo.getOffset();
        if (!z) {
            offset--;
        }
        if (offset > anchorSelectable$foundation_release.getLastVisibleOffset()) {
            return Offset.Companion.m2813getUnspecifiedF1C5BW0();
        }
        Offset offsetM923getCurrentDragPosition_m7T9E = selectionManager.m923getCurrentDragPosition_m7T9E();
        AbstractC4492zt.e(offsetM923getCurrentDragPosition_m7T9E);
        float fM2798getXimpl = Offset.m2798getXimpl(layoutCoordinates.mo4167localPositionOfR5De75A(containerLayoutCoordinates, offsetM923getCurrentDragPosition_m7T9E.m2808unboximpl()));
        long jMo885getRangeOfLineContainingjx7JFs = anchorSelectable$foundation_release.mo885getRangeOfLineContainingjx7JFs(offset);
        Rect boundingBox = anchorSelectable$foundation_release.getBoundingBox(TextRange.m4703getMinimpl(jMo885getRangeOfLineContainingjx7JFs));
        Rect boundingBox2 = anchorSelectable$foundation_release.getBoundingBox(AbstractC3871sJ.d(TextRange.m4702getMaximpl(jMo885getRangeOfLineContainingjx7JFs) - 1, TextRange.m4703getMinimpl(jMo885getRangeOfLineContainingjx7JFs)));
        float fK = AbstractC3871sJ.k(fM2798getXimpl, Math.min(boundingBox.getLeft(), boundingBox2.getLeft()), Math.max(boundingBox.getRight(), boundingBox2.getRight()));
        return Math.abs(fM2798getXimpl - fK) > ((float) (IntSize.m5320getWidthimpl(j) / 2)) ? Offset.Companion.m2813getUnspecifiedF1C5BW0() : containerLayoutCoordinates.mo4167localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(fK, Offset.m2799getYimpl(anchorSelectable$foundation_release.getBoundingBox(offset).m2828getCenterF1C5BW0())));
    }

    /* JADX INFO: renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m938containsInclusiveUv8p0NA(Rect rect, long j) {
        AbstractC4492zt.h(rect, "$this$containsInclusive");
        float left = rect.getLeft();
        float right = rect.getRight();
        float fM2798getXimpl = Offset.m2798getXimpl(j);
        if (left <= fM2798getXimpl && fM2798getXimpl <= right) {
            float top = rect.getTop();
            float bottom = rect.getBottom();
            float fM2799getYimpl = Offset.m2799getYimpl(j);
            if (top <= fM2799getYimpl && fM2799getYimpl <= bottom) {
                return true;
            }
        }
        return false;
    }

    public static final AnnotatedString getCurrentSelectedText(Selectable selectable, Selection selection) {
        AbstractC4492zt.h(selectable, "selectable");
        AbstractC4492zt.h(selection, "selection");
        AnnotatedString text = selectable.getText();
        if (selectable.getSelectableId() != selection.getStart().getSelectableId() && selectable.getSelectableId() != selection.getEnd().getSelectableId()) {
            return text;
        }
        if (selectable.getSelectableId() == selection.getStart().getSelectableId() && selectable.getSelectableId() == selection.getEnd().getSelectableId()) {
            return selection.getHandlesCrossed() ? text.subSequence(selection.getEnd().getOffset(), selection.getStart().getOffset()) : text.subSequence(selection.getStart().getOffset(), selection.getEnd().getOffset());
        }
        if (selectable.getSelectableId() == selection.getStart().getSelectableId()) {
            return selection.getHandlesCrossed() ? text.subSequence(0, selection.getStart().getOffset()) : text.subSequence(selection.getStart().getOffset(), text.length());
        }
        return selection.getHandlesCrossed() ? text.subSequence(selection.getEnd().getOffset(), text.length()) : text.subSequence(0, selection.getEnd().getOffset());
    }

    public static final Selection merge(Selection selection, Selection selection2) {
        Selection selectionMerge;
        return (selection == null || (selectionMerge = selection.merge(selection2)) == null) ? selection2 : selectionMerge;
    }

    public static final Rect visibleBounds(LayoutCoordinates layoutCoordinates) {
        AbstractC4492zt.h(layoutCoordinates, "<this>");
        Rect rectBoundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        return RectKt.m2836Rect0a9Yr6o(layoutCoordinates.mo4171windowToLocalMKHz9U(rectBoundsInWindow.m2833getTopLeftF1C5BW0()), layoutCoordinates.mo4171windowToLocalMKHz9U(rectBoundsInWindow.m2827getBottomRightF1C5BW0()));
    }
}
