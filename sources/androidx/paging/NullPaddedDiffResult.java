package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes2.dex */
public final class NullPaddedDiffResult {
    private final DiffUtil.DiffResult diff;
    private final boolean hasOverlap;

    public NullPaddedDiffResult(DiffUtil.DiffResult diffResult, boolean z) {
        AbstractC4492zt.h(diffResult, "diff");
        this.diff = diffResult;
        this.hasOverlap = z;
    }

    public final DiffUtil.DiffResult getDiff() {
        return this.diff;
    }

    public final boolean getHasOverlap() {
        return this.hasOverlap;
    }
}
