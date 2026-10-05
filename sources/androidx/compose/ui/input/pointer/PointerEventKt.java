package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class PointerEventKt {
    public static final boolean anyChangeConsumed(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        return pointerInputChange.isConsumed();
    }

    public static final boolean changedToDown(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        return (pointerInputChange.isConsumed() || pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        return !pointerInputChange.getPreviousPressed() && pointerInputChange.getPressed();
    }

    public static final boolean changedToUp(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        return (pointerInputChange.isConsumed() || !pointerInputChange.getPreviousPressed() || pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToUpIgnoreConsumed(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        return pointerInputChange.getPreviousPressed() && !pointerInputChange.getPressed();
    }

    public static final void consumeAllChanges(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        pointerInputChange.consume();
    }

    public static final void consumeDownChange(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        if (pointerInputChange.getPressed() != pointerInputChange.getPreviousPressed()) {
            pointerInputChange.consume();
        }
    }

    public static final void consumePositionChange(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        if (Offset.m2795equalsimpl0(positionChange(pointerInputChange), Offset.Companion.m2814getZeroF1C5BW0())) {
            return;
        }
        pointerInputChange.consume();
    }

    /* JADX INFO: renamed from: isOutOfBounds-O0kMr_c, reason: not valid java name */
    public static final boolean m3998isOutOfBoundsO0kMr_c(PointerInputChange pointerInputChange, long j) {
        AbstractC4492zt.h(pointerInputChange, "$this$isOutOfBounds");
        long jM4054getPositionF1C5BW0 = pointerInputChange.m4054getPositionF1C5BW0();
        float fM2798getXimpl = Offset.m2798getXimpl(jM4054getPositionF1C5BW0);
        float fM2799getYimpl = Offset.m2799getYimpl(jM4054getPositionF1C5BW0);
        return fM2798getXimpl < 0.0f || fM2798getXimpl > ((float) IntSize.m5320getWidthimpl(j)) || fM2799getYimpl < 0.0f || fM2799getYimpl > ((float) IntSize.m5319getHeightimpl(j));
    }

    /* JADX INFO: renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m3999isOutOfBoundsjwHxaWs(PointerInputChange pointerInputChange, long j, long j2) {
        AbstractC4492zt.h(pointerInputChange, "$this$isOutOfBounds");
        if (!PointerType.m4112equalsimpl0(pointerInputChange.m4057getTypeT8wyACA(), PointerType.Companion.m4119getTouchT8wyACA())) {
            return m3998isOutOfBoundsO0kMr_c(pointerInputChange, j);
        }
        long jM4054getPositionF1C5BW0 = pointerInputChange.m4054getPositionF1C5BW0();
        float fM2798getXimpl = Offset.m2798getXimpl(jM4054getPositionF1C5BW0);
        float fM2799getYimpl = Offset.m2799getYimpl(jM4054getPositionF1C5BW0);
        return fM2798getXimpl < (-Size.m2867getWidthimpl(j2)) || fM2798getXimpl > ((float) IntSize.m5320getWidthimpl(j)) + Size.m2867getWidthimpl(j2) || fM2799getYimpl < (-Size.m2864getHeightimpl(j2)) || fM2799getYimpl > ((float) IntSize.m5319getHeightimpl(j)) + Size.m2864getHeightimpl(j2);
    }

    public static final long positionChange(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        return positionChangeInternal(pointerInputChange, false);
    }

    public static final boolean positionChangeConsumed(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        return pointerInputChange.isConsumed();
    }

    public static final long positionChangeIgnoreConsumed(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        return positionChangeInternal(pointerInputChange, true);
    }

    private static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z) {
        long jM2802minusMKHz9U = Offset.m2802minusMKHz9U(pointerInputChange.m4054getPositionF1C5BW0(), pointerInputChange.m4055getPreviousPositionF1C5BW0());
        return (z || !pointerInputChange.isConsumed()) ? jM2802minusMKHz9U : Offset.Companion.m2814getZeroF1C5BW0();
    }

    public static /* synthetic */ long positionChangeInternal$default(PointerInputChange pointerInputChange, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return positionChangeInternal(pointerInputChange, z);
    }

    public static final boolean positionChanged(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        return !Offset.m2795equalsimpl0(positionChangeInternal(pointerInputChange, false), Offset.Companion.m2814getZeroF1C5BW0());
    }

    public static final boolean positionChangedIgnoreConsumed(PointerInputChange pointerInputChange) {
        AbstractC4492zt.h(pointerInputChange, "<this>");
        return !Offset.m2795equalsimpl0(positionChangeInternal(pointerInputChange, true), Offset.Companion.m2814getZeroF1C5BW0());
    }
}
