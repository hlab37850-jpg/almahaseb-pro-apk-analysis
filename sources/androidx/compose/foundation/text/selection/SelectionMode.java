package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public enum SelectionMode {
    Vertical { // from class: androidx.compose.foundation.text.selection.SelectionMode.Vertical
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release */
        public int mo943compare3MmeM6k$foundation_release(long j, Rect rect) {
            AbstractC4492zt.h(rect, "bounds");
            if (rect.m2824containsk4lQ0M(j)) {
                return 0;
            }
            if (Offset.m2799getYimpl(j) < rect.getTop()) {
                return -1;
            }
            return (Offset.m2798getXimpl(j) >= rect.getLeft() || Offset.m2799getYimpl(j) >= rect.getBottom()) ? 1 : -1;
        }
    },
    Horizontal { // from class: androidx.compose.foundation.text.selection.SelectionMode.Horizontal
        @Override // androidx.compose.foundation.text.selection.SelectionMode
        /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release */
        public int mo943compare3MmeM6k$foundation_release(long j, Rect rect) {
            AbstractC4492zt.h(rect, "bounds");
            if (rect.m2824containsk4lQ0M(j)) {
                return 0;
            }
            if (Offset.m2798getXimpl(j) < rect.getLeft()) {
                return -1;
            }
            return (Offset.m2799getYimpl(j) >= rect.getTop() || Offset.m2798getXimpl(j) >= rect.getRight()) ? 1 : -1;
        }
    };

    /* synthetic */ SelectionMode(AbstractC0419Di abstractC0419Di) {
        this();
    }

    /* JADX INFO: renamed from: compare-3MmeM6k$foundation_release, reason: not valid java name */
    public abstract int mo943compare3MmeM6k$foundation_release(long j, Rect rect);

    /* JADX INFO: renamed from: isSelected-2x9bVx0$foundation_release, reason: not valid java name */
    public final boolean m944isSelected2x9bVx0$foundation_release(Rect rect, long j, long j2) {
        AbstractC4492zt.h(rect, "bounds");
        if (rect.m2824containsk4lQ0M(j) || rect.m2824containsk4lQ0M(j2)) {
            return true;
        }
        return (mo943compare3MmeM6k$foundation_release(j, rect) > 0) ^ (mo943compare3MmeM6k$foundation_release(j2, rect) > 0);
    }
}
