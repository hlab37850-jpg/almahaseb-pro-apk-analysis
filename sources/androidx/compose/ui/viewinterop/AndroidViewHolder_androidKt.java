package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import defpackage.AbstractC1210aB;
import defpackage.AbstractC2262gD;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidViewHolder_androidKt {
    private static final AndroidViewHolder_androidKt$NoOpScrollConnection$1 NoOpScrollConnection = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder_androidKt$NoOpScrollConnection$1
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        public /* synthetic */ Object mo340onPostFlingRZ2iAVY(long j, long j2, InterfaceC0793Of interfaceC0793Of) {
            return AbstractC2262gD.a(this, j, j2, interfaceC0793Of);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
        public /* synthetic */ long mo341onPostScrollDzOQY0M(long j, long j2, int i) {
            return AbstractC2262gD.b(this, j, j2, i);
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
    };
    private static final int Unmeasured = Integer.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutAccordingTo(View view, LayoutNode layoutNode) {
        long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(layoutNode.getCoordinates());
        int iC = AbstractC1210aB.c(Offset.m2798getXimpl(jPositionInRoot));
        int iC2 = AbstractC1210aB.c(Offset.m2799getYimpl(jPositionInRoot));
        view.layout(iC, iC2, view.getMeasuredWidth() + iC, view.getMeasuredHeight() + iC2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeOffset(int i) {
        return i * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeVelocity(float f) {
        return f * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toNestedScrollSource(int i) {
        return i == 0 ? NestedScrollSource.Companion.m3963getDragWNlRxjI() : NestedScrollSource.Companion.m3964getFlingWNlRxjI();
    }
}
