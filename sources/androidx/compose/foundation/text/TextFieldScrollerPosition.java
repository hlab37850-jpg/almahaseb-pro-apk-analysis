package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC3871sJ;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@Stable
public final class TextFieldScrollerPosition {
    public static final Companion Companion = new Companion(null);
    private static final Saver<TextFieldScrollerPosition, Object> Saver = ListSaverKt.listSaver(TextFieldScrollerPosition$Companion$Saver$1.INSTANCE, TextFieldScrollerPosition$Companion$Saver$2.INSTANCE);
    private final MutableFloatState maximum$delegate;
    private final MutableFloatState offset$delegate;
    private final MutableState orientation$delegate;
    private Rect previousCursorRect;
    private long previousSelection;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC0419Di abstractC0419Di) {
            this();
        }

        public final Saver<TextFieldScrollerPosition, Object> getSaver() {
            return TextFieldScrollerPosition.Saver;
        }

        private Companion() {
        }
    }

    public TextFieldScrollerPosition(Orientation orientation, float f) {
        AbstractC4492zt.h(orientation, "initialOrientation");
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.maximum$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.previousCursorRect = Rect.Companion.getZero();
        this.previousSelection = TextRange.Companion.m4710getZerod9O1mEE();
        this.orientation$delegate = SnapshotStateKt.mutableStateOf(orientation, SnapshotStateKt.structuralEqualityPolicy());
    }

    private final void setMaximum(float f) {
        this.maximum$delegate.setFloatValue(f);
    }

    public final void coerceOffset$foundation_release(float f, float f2, int i) {
        float f3;
        float offset = getOffset();
        float f4 = i;
        float f5 = offset + f4;
        if (f2 <= f5 && (f >= offset || f2 - f <= f4)) {
            f3 = (f >= offset || f2 - f > f4) ? 0.0f : f - offset;
        } else {
            f3 = f2 - f5;
        }
        setOffset(getOffset() + f3);
    }

    public final float getMaximum() {
        return this.maximum$delegate.getFloatValue();
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    /* JADX INFO: renamed from: getOffsetToFollow-5zc-tL8, reason: not valid java name */
    public final int m830getOffsetToFollow5zctL8(long j) {
        if (TextRange.m4705getStartimpl(j) != TextRange.m4705getStartimpl(this.previousSelection)) {
            return TextRange.m4705getStartimpl(j);
        }
        return TextRange.m4700getEndimpl(j) != TextRange.m4700getEndimpl(this.previousSelection) ? TextRange.m4700getEndimpl(j) : TextRange.m4703getMinimpl(j);
    }

    public final Orientation getOrientation() {
        return (Orientation) this.orientation$delegate.getValue();
    }

    /* JADX INFO: renamed from: getPreviousSelection-d9O1mEE, reason: not valid java name */
    public final long m831getPreviousSelectiond9O1mEE() {
        return this.previousSelection;
    }

    public final void setOffset(float f) {
        this.offset$delegate.setFloatValue(f);
    }

    public final void setOrientation(Orientation orientation) {
        AbstractC4492zt.h(orientation, "<set-?>");
        this.orientation$delegate.setValue(orientation);
    }

    /* JADX INFO: renamed from: setPreviousSelection-5zc-tL8, reason: not valid java name */
    public final void m832setPreviousSelection5zctL8(long j) {
        this.previousSelection = j;
    }

    public final void update(Orientation orientation, Rect rect, int i, int i2) {
        AbstractC4492zt.h(orientation, "orientation");
        AbstractC4492zt.h(rect, "cursorRect");
        float f = i2 - i;
        setMaximum(f);
        if (rect.getLeft() != this.previousCursorRect.getLeft() || rect.getTop() != this.previousCursorRect.getTop()) {
            boolean z = orientation == Orientation.Vertical;
            coerceOffset$foundation_release(z ? rect.getTop() : rect.getLeft(), z ? rect.getBottom() : rect.getRight(), i);
            this.previousCursorRect = rect;
        }
        setOffset(AbstractC3871sJ.k(getOffset(), 0.0f, f));
    }

    public /* synthetic */ TextFieldScrollerPosition(Orientation orientation, float f, int i, AbstractC0419Di abstractC0419Di) {
        this(orientation, (i & 2) != 0 ? 0.0f : f);
    }

    public TextFieldScrollerPosition() {
        this(Orientation.Vertical, 0.0f, 2, null);
    }
}
