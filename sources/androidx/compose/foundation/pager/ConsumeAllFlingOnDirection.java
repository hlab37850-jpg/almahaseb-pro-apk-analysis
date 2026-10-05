package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import defpackage.AbstractC2262gD;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
final class ConsumeAllFlingOnDirection implements NestedScrollConnection {
    private final Orientation orientation;

    public ConsumeAllFlingOnDirection(Orientation orientation) {
        AbstractC4492zt.h(orientation, "orientation");
        this.orientation = orientation;
    }

    /* JADX INFO: renamed from: consumeOnOrientation-8S9VItk, reason: not valid java name */
    public final long m686consumeOnOrientation8S9VItk(long j, Orientation orientation) {
        AbstractC4492zt.h(orientation, "orientation");
        return orientation == Orientation.Vertical ? Offset.m2792copydBAh8RU$default(j, 0.0f, 0.0f, 2, null) : Offset.m2792copydBAh8RU$default(j, 0.0f, 0.0f, 1, null);
    }

    /* JADX INFO: renamed from: consumeOnOrientation-QWom1Mo, reason: not valid java name */
    public final long m687consumeOnOrientationQWom1Mo(long j, Orientation orientation) {
        AbstractC4492zt.h(orientation, "orientation");
        return orientation == Orientation.Vertical ? Velocity.m5381copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null) : Velocity.m5381copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null);
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) {
        return Velocity.m5376boximpl(m687consumeOnOrientationQWom1Mo(j2, this.orientation));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
        return NestedScrollSource.m3958equalsimpl0(i, NestedScrollSource.Companion.m3964getFlingWNlRxjI()) ? m686consumeOnOrientation8S9VItk(j2, this.orientation) : Offset.Companion.m2814getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public /* synthetic */ Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) {
        return AbstractC2262gD.c(this, j, interfaceC0793Of);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public /* synthetic */ long mo343onPreScrollOzD1aCk(long j, int i) {
        return AbstractC2262gD.d(this, j, i);
    }
}
