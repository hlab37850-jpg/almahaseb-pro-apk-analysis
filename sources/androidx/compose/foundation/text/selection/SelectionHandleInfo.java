package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import defpackage.AbstractC0419Di;
import defpackage.AbstractC4492zt;

/* JADX INFO: loaded from: classes.dex */
public final class SelectionHandleInfo {
    private final Handle handle;
    private final long position;

    public /* synthetic */ SelectionHandleInfo(Handle handle, long j, AbstractC0419Di abstractC0419Di) {
        this(handle, j);
    }

    /* JADX INFO: renamed from: copy-Uv8p0NA$default, reason: not valid java name */
    public static /* synthetic */ SelectionHandleInfo m898copyUv8p0NA$default(SelectionHandleInfo selectionHandleInfo, Handle handle, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            handle = selectionHandleInfo.handle;
        }
        if ((i & 2) != 0) {
            j = selectionHandleInfo.position;
        }
        return selectionHandleInfo.m900copyUv8p0NA(handle, j);
    }

    public final Handle component1() {
        return this.handle;
    }

    /* JADX INFO: renamed from: component2-F1C5BW0, reason: not valid java name */
    public final long m899component2F1C5BW0() {
        return this.position;
    }

    /* JADX INFO: renamed from: copy-Uv8p0NA, reason: not valid java name */
    public final SelectionHandleInfo m900copyUv8p0NA(Handle handle, long j) {
        AbstractC4492zt.h(handle, "handle");
        return new SelectionHandleInfo(handle, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionHandleInfo)) {
            return false;
        }
        SelectionHandleInfo selectionHandleInfo = (SelectionHandleInfo) obj;
        return this.handle == selectionHandleInfo.handle && Offset.m2795equalsimpl0(this.position, selectionHandleInfo.position);
    }

    public final Handle getHandle() {
        return this.handle;
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m901getPositionF1C5BW0() {
        return this.position;
    }

    public int hashCode() {
        return (this.handle.hashCode() * 31) + Offset.m2800hashCodeimpl(this.position);
    }

    public String toString() {
        return "SelectionHandleInfo(handle=" + this.handle + ", position=" + ((Object) Offset.m2806toStringimpl(this.position)) + ')';
    }

    private SelectionHandleInfo(Handle handle, long j) {
        AbstractC4492zt.h(handle, "handle");
        this.handle = handle;
        this.position = j;
    }
}
