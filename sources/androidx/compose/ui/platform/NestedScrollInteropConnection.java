package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0793Of;
import defpackage.Q5;

/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollInteropConnection implements NestedScrollConnection {
    private final int[] consumedScrollCache;
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;

    public NestedScrollInteropConnection(View view) {
        AbstractC4492zt.h(view, "view");
        this.view = view;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(view);
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(view, true);
    }

    private final void interruptOngoingScrolls() {
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(0)) {
            this.nestedScrollChildHelper.stopNestedScroll(0);
        }
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(1)) {
            this.nestedScrollChildHelper.stopNestedScroll(1);
        }
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) {
        if (!this.nestedScrollChildHelper.dispatchNestedFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5385getXimpl(j2)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5386getYimpl(j2)), true)) {
            j2 = Velocity.Companion.m5396getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m5376boximpl(j2);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m4517getScrollAxesk4lQ0M(j2), NestedScrollInteropConnectionKt.m4519toViewTypeGyEprt8(i))) {
            return Offset.Companion.m2814getZeroF1C5BW0();
        }
        Q5.t(this.consumedScrollCache, 0, 0, 0, 6, null);
        this.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2798getXimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2799getYimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2798getXimpl(j2)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2799getYimpl(j2)), null, NestedScrollInteropConnectionKt.m4519toViewTypeGyEprt8(i), this.consumedScrollCache);
        return NestedScrollInteropConnectionKt.m4518toOffsetUv8p0NA(this.consumedScrollCache, j2);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public Object mo342onPreFlingQWom1Mo(long j, InterfaceC0793Of interfaceC0793Of) {
        if (!this.nestedScrollChildHelper.dispatchNestedPreFling(NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5385getXimpl(j)), NestedScrollInteropConnectionKt.toViewVelocity(Velocity.m5386getYimpl(j)))) {
            j = Velocity.Companion.m5396getZero9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.m5376boximpl(j);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo343onPreScrollOzD1aCk(long j, int i) {
        if (!this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.m4517getScrollAxesk4lQ0M(j), NestedScrollInteropConnectionKt.m4519toViewTypeGyEprt8(i))) {
            return Offset.Companion.m2814getZeroF1C5BW0();
        }
        Q5.t(this.consumedScrollCache, 0, 0, 0, 6, null);
        this.nestedScrollChildHelper.dispatchNestedPreScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2798getXimpl(j)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m2799getYimpl(j)), this.consumedScrollCache, null, NestedScrollInteropConnectionKt.m4519toViewTypeGyEprt8(i));
        return NestedScrollInteropConnectionKt.m4518toOffsetUv8p0NA(this.consumedScrollCache, j);
    }
}
