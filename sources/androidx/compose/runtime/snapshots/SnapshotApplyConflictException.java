package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SnapshotApplyConflictException extends Exception {
    public static final int $stable = 8;
    private final Snapshot snapshot;

    public SnapshotApplyConflictException(Snapshot snapshot) {
        AbstractC4492zt.h(snapshot, "snapshot");
        this.snapshot = snapshot;
    }

    public final Snapshot getSnapshot() {
        return this.snapshot;
    }
}
