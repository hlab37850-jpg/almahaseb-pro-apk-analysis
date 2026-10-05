package androidx.compose.foundation.layout;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import defpackage.AbstractC2262gD;
import defpackage.InterfaceC0793Of;

/* JADX INFO: loaded from: classes.dex */
final class DoNothingNestedScrollConnection implements NestedScrollConnection {
    public static final DoNothingNestedScrollConnection INSTANCE = new DoNothingNestedScrollConnection();

    private DoNothingNestedScrollConnection() {
    }

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
}
