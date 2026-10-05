package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import defpackage.C2020dG;

/* JADX INFO: loaded from: classes.dex */
public interface Selectable {
    Rect getBoundingBox(int i);

    /* JADX INFO: renamed from: getHandlePosition-dBAh8RU */
    long mo884getHandlePositiondBAh8RU(Selection selection, boolean z);

    int getLastVisibleOffset();

    LayoutCoordinates getLayoutCoordinates();

    /* JADX INFO: renamed from: getRangeOfLineContaining--jx7JFs */
    long mo885getRangeOfLineContainingjx7JFs(int i);

    Selection getSelectAllSelection();

    long getSelectableId();

    AnnotatedString getText();

    /* JADX INFO: renamed from: updateSelection-qCDeeow */
    C2020dG mo886updateSelectionqCDeeow(long j, long j2, Offset offset, boolean z, LayoutCoordinates layoutCoordinates, SelectionAdjustment selectionAdjustment, Selection selection);
}
