package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotContextElementKt {
    @ExperimentalComposeApi
    public static final SnapshotContextElement asContextElement(Snapshot snapshot) {
        AbstractC4492zt.h(snapshot, "<this>");
        return new SnapshotContextElementImpl(snapshot);
    }
}
