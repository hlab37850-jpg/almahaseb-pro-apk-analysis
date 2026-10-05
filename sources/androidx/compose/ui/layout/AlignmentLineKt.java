package androidx.compose.ui.layout;

import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class AlignmentLineKt {
    private static final HorizontalAlignmentLine FirstBaseline = new HorizontalAlignmentLine(AlignmentLineKt$FirstBaseline$1.INSTANCE);
    private static final HorizontalAlignmentLine LastBaseline = new HorizontalAlignmentLine(AlignmentLineKt$LastBaseline$1.INSTANCE);

    public static final HorizontalAlignmentLine getFirstBaseline() {
        return FirstBaseline;
    }

    public static final HorizontalAlignmentLine getLastBaseline() {
        return LastBaseline;
    }

    public static final int merge(AlignmentLine alignmentLine, int i, int i2) {
        AbstractC4492zt.h(alignmentLine, "<this>");
        return ((Number) alignmentLine.getMerger$ui_release().mo13invoke(Integer.valueOf(i), Integer.valueOf(i2))).intValue();
    }
}
